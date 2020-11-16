/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Control.AccesoAleatorio;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/**
 *
 * @author usurio
 */

public class LimitarCaracter extends PlainDocument{
    private JTextField Editor;
    private int num;
    static int N;

    public LimitarCaracter(JTextField Editor, int num) {
        this.Editor = Editor;
        this.num = num;
    }
    
    public void insertString(int arg0,String arg1,AttributeSet arg2) throws BadLocationException
    {
        if((Editor.getText().length()+arg1.length())>this.num)
        {
            return;
        }
        super.insertString(arg0, arg1, arg2);
    }
    
    
    
     







    





















































    




















































    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
public  static String  Parametros(String [] H)
    {
        int valor=H.length-1;
        StringBuilder S = new StringBuilder();
        try {
            AccesoAleatorio.crearFileLibro(new File("ArchivosCreados\\Libro.dat"));
            
            
            
            //String[] H=new String[NroRegistros-1];
            for(int j = 1;j < H.length; j++)//agregar libros a memoria intermedia
                 {
                     Libro A=AccesoAleatorio.getLibro(j);
                     H[j-1]=A.Atributos();
                     
                 }
            
            AccesoAleatorio.cerrar();
            //JOptionPane.showMessageDialog(this, "El registro se realizó correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(this, "Error en la escritura de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for(int i = 0; i < valor - 1; i++)
        {
            for(int j = 0; j < valor -1; j++)
            {
                
                int Valor=H[j].substring(5,55).compareTo(H[j + 1].substring(5,55));
                if (Valor>=0)//arreglo[j] > arreglo[j + 1]
                {
                    String tmp = H[j+1];
                    H[j+1] = H[j];
                    H[j] = tmp;
                    
                }
                
            }
        }
        try {
            
            
            
            
            //String[] H=new String[NroRegistros-1];
            for(int j = 0;j < H.length; j++)//agregar libros a memoria intermedia
                 {
                     AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\SMT_Final.dat") );//creacion de archivo.dat
                    for(int k = 0;k < valor; k++)
                    {
                        String CodLibro=H[k].substring(0,5);//cortamos cada atributo del registro
                        String Titulo=H[k].substring(5,55);
                        String Autor=H[k].substring(55,85);
                        int Año=Integer.parseInt(H[k].substring(85,89));//conversion a int del año
                        int Estado=Integer.parseInt(H[k].substring(89,90));
                        AccesoAleatorio.añadirLibro(new Libro(CodLibro,Titulo,Autor,Año,Estado));
                    }
                    AccesoAleatorio.cerrar();
                     
                 }
            
            
            //JOptionPane.showMessageDialog(this, "El registro se realizó correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(this, "Error en la escritura de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for(int k = 0;k < valor; k++)
        {
           S.append(H[k]+"\n");
        }  
        
    return S.toString();
    }
    public  static String  Parametro(String [] H)
    {
        int valor=H.length-1;
        StringBuilder S = new StringBuilder();
        try {
            AccesoAleatorio.crearFileLibro(new File("ArchivosCreados\\Libro.dat"));
            
            
            
            //String[] H=new String[NroRegistros-1];
            for(int j = 1;j < H.length; j++)//agregar libros a memoria intermedia
                 {
                     Libro A=AccesoAleatorio.getLibro(j);
                     H[j-1]=A.Atributos();
                     
                 }
            
            AccesoAleatorio.cerrar();
            //JOptionPane.showMessageDialog(this, "El registro se realizó correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(this, "Error en la escritura de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for(int i = 0; i < valor - 1; i++)
        {
            for(int j = 0; j < valor -1; j++)
            {
                
                int Valor=H[j].compareTo(H[j + 1]);
                if (Valor>=0)//arreglo[j] > arreglo[j + 1]
                {
                    String tmp = H[j+1];
                    H[j+1] = H[j];
                    H[j] = tmp;
                    
                }
                
            }
        }
        try {
            
            
            
            
            //String[] H=new String[NroRegistros-1];
            for(int j = 0;j < H.length; j++)//agregar libros a memoria intermedia
                 {
                     AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\SMC_Final.dat") );//creacion de archivo.dat
                    for(int k = 0;k < valor; k++)
                    {
                        String CodLibro=H[k].substring(0,5);//cortamos cada atributo del registro
                        String Titulo=H[k].substring(5,55);
                        String Autor=H[k].substring(55,85);
                        int Año=Integer.parseInt(H[k].substring(85,89));//conversion a int del año
                        int Estado=Integer.parseInt(H[k].substring(89,90));
                        AccesoAleatorio.añadirLibro(new Libro(CodLibro,Titulo,Autor,Año,Estado));
                    }
                    AccesoAleatorio.cerrar();
                     
                 }
            
            
            //JOptionPane.showMessageDialog(this, "El registro se realizó correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            //JOptionPane.showMessageDialog(this, "Error en la escritura de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        for(int k = 0;k < valor; k++)
        {
           S.append(H[k]+"\n");
        }  
        
    return S.toString();
    }    
    
}