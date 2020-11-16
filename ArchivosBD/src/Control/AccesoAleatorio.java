/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.io.*;
import Modelo.*;
/**
 *
 * @author usurio
 */
public class AccesoAleatorio {
    
    private static RandomAccessFile flujo;//referencia a la clase que nos permite el acceso a archivo saltado a la posicion de un byte determinad
    private static int numeroRegistros;//cantidad de registros
    private static int tamañoRegistro = 184;//178+2+2+2 por tratamiento, recorrido para pasar a un siguiente registro

    public static void crearFileLibro(File archivo) throws IOException {//creacion de archivo con el que se trabaja poniendo la ruta hacia un archivo
        if (archivo.exists() && !archivo.isFile()) {//verificacion de la existencia del archivo
            throw new IOException(archivo.getName() + " no es un archivo");
        }
        flujo = new RandomAccessFile(archivo, "rw");//creacion  de archivo instacioando a la variable flujo que pide una ruta y el modo de uso q es de lectura y escritura
        numeroRegistros = (int) Math.ceil(//aroximacion al entero superior
                (double) flujo.length() / (double) tamañoRegistro);//division estre la longitud del archivo entre el tamaño del registro= cantidad de registros
    }

    public static void cerrar() throws IOException {
        flujo.close();//cerrar el flufjo 
    }

    public static boolean setLibro(int i, Libro libro) throws IOException {//recibe la posicion i donde se quiere agregar el libro
        if(i >= 0 && i <= getNumeroRegistros()) {//asegura que la posicion de entra este en el rango de los registro
            if(libro.getTamaño() > tamañoRegistro) {//esta fuera de los limites de un registro
                System.out.println("\nTamaño de registro superado.");
            } else {
                flujo.seek(i*tamañoRegistro);//situar el puntero sobre el byte de donde queremos empezar a escribir la pos i*tamaño
                flujo.writeUTF(libro.getCodLibro());//solo se permite escribir datos y no on¿bjeto por eso no se puede agregar el libro si no los datos que posee
                flujo.writeUTF(libro.getTitulo());
                flujo.writeUTF(libro.getAutor());//writeUTF
                flujo.writeInt(libro.getAño());
                flujo.writeInt(libro.getEstado());
                
                return true;
            }
        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
        }
        return false;
    }
    public static void añadirLibro(Libro Libro) throws IOException {
        
        if(setLibro(numeroRegistros,Libro))//añade un libro en la ultima posicion del archivo que comenzara siempre 
            numeroRegistros++;             //en el numero de registros
    }  

    public static int getNumeroRegistros() {
        return numeroRegistros;
    }

    public static Libro getLibro(int i) throws IOException {//obtener el libro a partir de una posicion y la muestra
        if(i >= 0 && i <= getNumeroRegistros()) {//asegurarnos k la poscion ingresada este en el rango
            flujo.seek(i * tamañoRegistro);//ubicar el puntero el la posicion q le corresponde 
            return new Libro(flujo.readUTF() ,flujo.readUTF(),flujo.readUTF(), flujo.readInt(), flujo.readInt());//obtencion de datos
        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
            return null;
        }
    }
    
    public static Libro PosicionLibro(int i) throws IOException {//obtener un libro en la posicion i y la muestra
        if(i >= 0 && i <= getNumeroRegistros()) {
            flujo.seek(i * tamañoRegistro);//posicionarnos en un byte
            return new Libro(flujo.readUTF(),flujo.readUTF(),flujo.readUTF(), flujo.readInt(), flujo.readInt());//obtencion de datos
        } else {
            System.out.println("\nNúmero de registro fuera de límites.");
            return null;
        }
    }

    public static int buscarRegistro(String buscado) throws IOException {//devuelve la ubicacion de libro en el archivo
        
        if(buscado.length()<5)
        {
            buscado=String.format("%-5s", buscado);
        }
        Libro p;
        
        if (buscado == null) {//si no es valido
            return -1;
        }
        for(int i=0; i<getNumeroRegistros(); i++) {//recorre el archivo
            flujo.seek(i * tamañoRegistro);
            p = getLibro(i);//recupera cada libro del archivo en secuencia
            if(p.getCodLibro().equals(buscado)) {//si es igual al parametro buscasdo retorna la posicion en este caso la posicion
                return i;
            }
        }
        return -1;//si no encuentra coincidencias 
    }
    public static int buscarRegistroMenos1(int buscado) throws IOException {
        Libro p;
        
        for(int i=0; i<getNumeroRegistros(); i++) {
            flujo.seek(i * tamañoRegistro);
            p = getLibro(i);//si es igual al parametro buscasdo retorna la posicion en este caso la posicion en este caso el estado
            if(p.getEstado()==buscado) {
                return i;
            }
        }
        return -2;
    }
    
    public static int getTamañoRegistros() {
        return tamañoRegistro;
    }
    
    public static int getTamañoflujo() {
        return tamañoRegistro*numeroRegistros;
    }
    
    
}
