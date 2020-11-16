/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 *
 * @author usurio
 */
public class ArbolBMas<K extends Comparable<? super K>, V> {
    
    public static enum NormaRango {//determina si se quiere incluir los valores de inicio y fin para un rango de valores a mostrar
		EXCLUSIVO, INCLUSIVO//EX no los incluye e In los incluye
	}

	private static final int CAPACIDAD_NODO = 128;//tamaño maximo del nodo
        
	private int Capacidad;

	private Node raiz;

	public ArbolBMas() {
		this(CAPACIDAD_NODO);
	}

	public ArbolBMas(int Capacidad) {//asigancion de un tamaño diferente para el nodo
		if (Capacidad <= 2)
			throw new IllegalArgumentException("VALOR NO ACEPTADO: "
					+ Capacidad);
		this.Capacidad = Capacidad;
		raiz = new NodoHoja();
	}

	public V Buscar(K key) {//Devuelve el valor al que está asociada la clave especificada
		return raiz.getValor(key);
	}

	/**Buscar Rango
	 * Devuelve los valores asociados con las claves especificadas por el rango
	 * 
	 * 
	 * @param key1 clave incial
            *           
	 * @param p1 norma de exclusion o inclusion
	 *            
	 * @param key2 clave final
	 *            
	 * @param p2 norma de exclusion o inclusion
	 *            
	 */
	public List<V> buscarRango(K key1, NormaRango p1, K key2,
			NormaRango p2) {
		return raiz.getRango(key1, p1, key2, p2);
	}

	
	public void insertar(K key, V valor) {//Asocia el valor especificado con la clave especificada en este árbol, si la clave ya existe la reeemplaza por la nueva
		raiz.InsertarValor(key, valor);//key es la clave y valor es el onjeto a asociar
	}

	public void Eliminar(K key) {//Elimina la asociación para la clave especificada de este árbol si está presente.
		raiz.EliminarValor(key);
	}

	public String toString() {//muestra por niveles el arbol requerido
		Queue<List<Node>> queue = new LinkedList<List<Node>>();
		queue.add(Arrays.asList(raiz));
		StringBuilder sb = new StringBuilder();//contenedor del arbol
		while (!queue.isEmpty()) {
			Queue<List<Node>> nextQueue = new LinkedList<List<Node>>();
			while (!queue.isEmpty()) {
				List<Node> nodes = queue.remove();
				sb.append('{');
				Iterator<Node> it = nodes.iterator();
				while (it.hasNext()) {
					Node node = it.next();
					sb.append(node.toString());
					if (it.hasNext())
						sb.append(", ");
					if (node instanceof ArbolBMas.NodoInterno)
						nextQueue.add(((NodoInterno) node).Hijos);
				}
				sb.append('}');
				if (!queue.isEmpty())
					sb.append(", ");
				else
					sb.append('\n');
			}
			queue = nextQueue;
		}

		return sb.toString();
	}

	private abstract class Node {//clase nodo del arbol
		List<K> keys;   

		int NumClave() {
			return keys.size();
		}

		abstract V getValor(K key);

		abstract void EliminarValor(K key);

		abstract void InsertarValor(K key, V value);

		abstract K getPrimeraClaveHoja();//obtener clave de la hoja

		abstract List<V> getRango(K key1, NormaRango p1, K key2,
				NormaRango p2);

		abstract void Combinar(Node Hermano);//unir dos nodos

		abstract Node Partir();//Dividir un nodo

		abstract boolean isOverflow();

		abstract boolean isUnderflow();

		public String toString() {
			return keys.toString();
		}
	}

	private class NodoInterno extends Node {//clase nodo interno del arbol
		List<Node> Hijos;

		NodoInterno() {
			this.keys = new ArrayList<K>();
			this.Hijos = new ArrayList<Node>();
		}

		@Override
		V getValor(K key) {
			return getHijos(key).getValor(key);
		}

		@Override
		void EliminarValor(K key) {
			Node Hijo = getHijos(key);
			Hijo.EliminarValor(key); 
			if (Hijo.isUnderflow()) {
				Node HermanoIzquierdo = getHermanoIzquierdo(key);
				Node HermanoDerecho = getHermanoDerecho(key);
				Node Izquierdo = HermanoIzquierdo != null ? HermanoIzquierdo : Hijo;
				Node Derecho = HermanoIzquierdo != null ? Hijo
						: HermanoDerecho;
				Izquierdo.Combinar(Derecho);
				EliminarHijos(Derecho.getPrimeraClaveHoja());
				if (Izquierdo.isOverflow()) {
					Node sibling = Izquierdo.Partir();
					InsertarHijos(sibling.getPrimeraClaveHoja(), sibling);
				}
				if (raiz.NumClave() == 0)
					raiz = Izquierdo;
			}
		}

		@Override
		void InsertarValor(K key, V valor) {
			Node Hijo = getHijos(key);
			Hijo.InsertarValor(key, valor);
			if (Hijo.isOverflow()) {
				Node Hermano = Hijo.Partir();
				InsertarHijos(Hermano.getPrimeraClaveHoja(), Hermano);
			}
			if (raiz.isOverflow()) {
				Node sibling = Partir();
				NodoInterno newRaiz = new NodoInterno();
				newRaiz.keys.add(sibling.getPrimeraClaveHoja());
				newRaiz.Hijos.add(this);
				newRaiz.Hijos.add(sibling);
				raiz = newRaiz;
			}
		}

		@Override
		K getPrimeraClaveHoja() {
			return Hijos.get(0).getPrimeraClaveHoja();
		}

		@Override
		List<V> getRango(K key1, NormaRango p1, K key2,
				NormaRango p2) {
			return getHijos(key1).getRango(key1, p1, key2, p2);
		}

		@Override
		void Combinar(Node Hermano) {
			@SuppressWarnings("unchecked")
			NodoInterno node = (NodoInterno) Hermano;
			keys.add(node.getPrimeraClaveHoja());
			keys.addAll(node.keys);
			Hijos.addAll(node.Hijos);

		}

		@Override
		Node Partir() {
			int from = NumClave() / 2 + 1, to = NumClave();
			NodoInterno Hermano = new NodoInterno();
			Hermano.keys.addAll(keys.subList(from, to));
			Hermano.Hijos.addAll(Hijos.subList(from, to + 1));

			keys.subList(from - 1, to).clear();
			Hijos.subList(from, to + 1).clear();

			return Hermano;
		}

		@Override
		boolean isOverflow() {
			return Hijos.size() > Capacidad;
		}

		@Override
		boolean isUnderflow() {
			return Hijos.size() < (Capacidad + 1) / 2;
		}

		Node getHijos(K key) {
			int loc = Collections.binarySearch(keys, key);
			int childIndex = loc >= 0 ? loc + 1 : -loc - 1;
			return Hijos.get(childIndex);
		}

		void EliminarHijos(K key) {
			int loc = Collections.binarySearch(keys, key);
			if (loc >= 0) {
				keys.remove(loc);
				Hijos.remove(loc + 1);
			}
		}

		void InsertarHijos(K key, Node child) {
			int loc = Collections.binarySearch(keys, key);
			int HijoIndex = loc >= 0 ? loc + 1 : -loc - 1;
			if (loc >= 0) {
				Hijos.set(HijoIndex, child);
			} else {
				keys.add(HijoIndex, key);
				Hijos.add(HijoIndex + 1, child);
			}
		}

		Node getHermanoIzquierdo(K key) {
			int loc = Collections.binarySearch(keys, key);
			int HijoIndex = loc >= 0 ? loc + 1 : -loc - 1;
			if (HijoIndex > 0)
				return Hijos.get(HijoIndex - 1);

			return null;
		}

		Node getHermanoDerecho(K key) {
			int loc = Collections.binarySearch(keys, key);
			int HijoIndex = loc >= 0 ? loc + 1 : -loc - 1;
			if (HijoIndex < NumClave())
				return Hijos.get(HijoIndex + 1);

			return null;
		}
	}

	private class NodoHoja extends Node {//clase nodo Hoja
		List<V> values;
		NodoHoja next;

		NodoHoja() {
			keys = new ArrayList<K>();
			values = new ArrayList<V>();
		}

		@Override
		V getValor(K key) {
			int loc = Collections.binarySearch(keys, key);
			return loc >= 0 ? values.get(loc) : null;
		}

		@Override
		void EliminarValor(K key) {
			int loc = Collections.binarySearch(keys, key);
			if (loc >= 0) {
				keys.remove(loc);
				values.remove(loc);
			}
		}

		@Override
		void InsertarValor(K key, V value) {
			int loc = Collections.binarySearch(keys, key);
			int valueIndex = loc >= 0 ? loc : -loc - 1;
			if (loc >= 0) {
				values.set(valueIndex, value);
			} else {
				keys.add(valueIndex, key);
				values.add(valueIndex, value);
			}
			if (raiz.isOverflow()) {
				Node Hermano = Partir();
				NodoInterno newRaiz = new NodoInterno();
				newRaiz.keys.add(Hermano.getPrimeraClaveHoja());
				newRaiz.Hijos.add(this);
				newRaiz.Hijos.add(Hermano);
				raiz = newRaiz;
			}
		}

		@Override
		K getPrimeraClaveHoja() {
			return keys.get(0);
		}

		@Override
		List<V> getRango(K key1, NormaRango p1, K key2,
				NormaRango p2) {
			List<V> result = new LinkedList<V>();
			NodoHoja node = this;
			while (node != null) {
				Iterator<K> kIt = node.keys.iterator();
				Iterator<V> vIt = node.values.iterator();
				while (kIt.hasNext()) {
					K key = kIt.next();
					V value = vIt.next();
					int cmp1 = key.compareTo(key1);
					int cmp2 = key.compareTo(key2);
					if (((p1 == NormaRango.EXCLUSIVO && cmp1 > 0) || (p1 == NormaRango.INCLUSIVO && cmp1 >= 0))
							&& ((p2 == NormaRango.EXCLUSIVO && cmp2 < 0) || (p2 == NormaRango.INCLUSIVO && cmp2 <= 0)))
						result.add(value);
					else if ((p2 == NormaRango.EXCLUSIVO && cmp2 >= 0)
							|| (p2 == NormaRango.INCLUSIVO && cmp2 > 0))
						return result;
				}
				node = node.next;
			}
			return result;
		}

		@Override
		void Combinar(Node Hermano) {
			@SuppressWarnings("unchecked")
			NodoHoja node = (NodoHoja) Hermano;
			keys.addAll(node.keys);
			values.addAll(node.values);
			next = node.next;
		}

		@Override
		Node Partir() {
			NodoHoja Hermano = new NodoHoja();
			int from = (NumClave() + 1) / 2, to = NumClave();
			Hermano.keys.addAll(keys.subList(from, to));
			Hermano.values.addAll(values.subList(from, to));

			keys.subList(from, to).clear();
			values.subList(from, to).clear();

			Hermano.next = next;
			next = Hermano;
			return Hermano;
		}

		@Override
		boolean isOverflow() {
			return values.size() > Capacidad - 1;
		}

		@Override
		boolean isUnderflow() {
			return values.size() < Capacidad / 2;
		}
	}
   
}
