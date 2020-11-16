/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
/**
 *
 * @author usurio
 */
public class Libro implements Serializable {
    private String CodLibro;
    private String Titulo;
    private String Autor;
    private int Año;
    private int Estado;
    
    public Libro(){
        CodLibro="";
        Titulo="";
        Autor="";
        Año=1900;
        Estado=0;
    }
    public Libro(String CodLibro,String Titulo,String Autor,int Año,int Estado){
        this.CodLibro=CodLibro;
        this.Titulo=Titulo;
        this.Autor=Autor;
        this.Año=Año;
        this.Estado=Estado;
    }
    
    public void setCodLibro(String CodLibro) {
        this.CodLibro = CodLibro;
    }
    
    public String getCodLibro() {
        return CodLibro;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getTitulo() {
        return Titulo;
    }
    
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }

    public int getAño() {
        return Año;
    }
    
     public void setEstado(int Estado) {
        this.Estado = Estado;
    }
  
    public int getEstado() {
        return Estado;
    }

   
    @Override
    public String toString(){
        return "\nCodLibro: "+CodLibro+
                "\nTitulo: "+Titulo+
                "\nAutor: "+Autor+
                "\nAño: "+Año+
                "\nEstado: "+Estado;
    }
    public int getTamaño() {
        return getCodLibro().length()*2 + 2 + getTitulo().length()*2 + 2 + getAutor().length()*2 + 2 + 4 + 4;//+4 por cada int 
    }
    public String Atributos()//muestra los atributos del libro tal como el registro
    {
        return CodLibro+Titulo+Autor+Año+Estado;
    }
    
    
}
