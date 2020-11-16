/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Control.AccesoAleatorio;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Modelo.Libro;
import Modelo.LimitarCaracter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author usurio
 */

public class Interface extends javax.swing.JFrame {
    DefaultTableModel dtm=new DefaultTableModel();
    
    /**
     * Creates new form Interface
     */
    /*private void Cerrar()//cierra la ventana y elimina el archivo.dat
    {
        
        
        System.exit(0);
        
    }*/
    public static void borrarDirectorio(File directorio)
    {
        File[] ficheros = directorio.listFiles();

        for(int k = 0;k < ficheros.length; k++)
            {
                if (ficheros[k].isDirectory())
                {
                borrarDirectorio(ficheros[k]);
                }
                ficheros[k].delete();
            }
        
    }
    public Interface() {
        initComponents();
        //setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        File f = new File("ArchivosCreados");
        borrarDirectorio(f);
        Limitar();
        
        
        String[] titulos=new String[]{"Ind","CodLibro","Titulo","Autor","Año","Estado"};
        dtm.setColumnIdentifiers(titulos);
        
        TablaSalida.setModel(dtm);
        
        
        
        
        
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            AccesoAleatorio.añadirLibro(new Libro("","","",0,-1));
            AccesoAleatorio.cerrar();
            //JOptionPane.showMessageDialog(this, "El registro se realizó correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error en la escritura de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        String[] DatosIniciales=new String[100];
        
        DatosIniciales[0]="98342Croata                                            Jorge Garcia                  20200";
        DatosIniciales[1]="87546Asi empezo todo                                   Javier Navarro                19980";
        DatosIniciales[2]="21589El libro de azafran                               Jesus Avila                   19920";
        DatosIniciales[3]="12345El legado de los malditos                         Vanesa Redondo                20140";
        DatosIniciales[4]="35896El silencio de la lengua                          Luis Melero                   20110";
        DatosIniciales[5]="69852Era de la globalizacion                           Gustavo Hernandez             20120";
        DatosIniciales[6]="48796Te espero                                         Fernando Pardo                20150";
        DatosIniciales[7]="57896La mujer de otro                                  Jose Navarro                  20190";
        DatosIniciales[8]="78231Lo inefable del amor                              Sara Carballal                20190";
        DatosIniciales[9]="13258Conatus                                           Belen Blesa                   20160";
        DatosIniciales[10]="93889El exilio del alma                                Jose ignacio                  19990";
        DatosIniciales[11]="58796Las voces amarillas                               Luis Verez                    19980";
        DatosIniciales[12]="25178Sub sua                                           Carla Kohlberg                19780";
        DatosIniciales[13]="68978Una historia de la habana                         Carlos Soriano                20180";
        DatosIniciales[14]="72885Los que miran las estrellas                       Alba Oliva                    19950";
        DatosIniciales[15]="38541America fotografiada                              David Flecha                  19980";
        DatosIniciales[16]="85712Diario de a bordo                                 Pilar Lopez                   19960";
        DatosIniciales[17]="47856Una mirada perdida                                Salva Aleman                  19960";
        DatosIniciales[18]="14578La vida prometida                                 Jose Gallardo                 20200";
        DatosIniciales[19]="91258Nacionalismo Catalan                              Jesus Rul                     20120";
        DatosIniciales[20]="53492La confesion de libio                             Carlos de Tomas               20180";
        DatosIniciales[21]="29173Cinco dias para matar al papa                     Ivan Robledo                  20150";
        DatosIniciales[22]="74156Versos desvelados                                 Laura Martinez                20160";
        DatosIniciales[23]="39274El espia cordial                                  Miguel Catalan                20190";
        DatosIniciales[24]="46579Hijos del fuego                                   Joaquin castillo              20190";
        DatosIniciales[25]="61972Llumantla iliquida                                Monica Velasco                19930";
        DatosIniciales[26]="83289Mujeres en el agua                                Patricia Torres               19990";
        DatosIniciales[27]="15478Tokio diario urbano                               Ignacio de Tomas              19960";
        DatosIniciales[28]="92145Blanco                                            Carlota Berat                 19960";
        DatosIniciales[29]="54345La mente dibujada                                 Grace Klimt                   20140";
        DatosIniciales[30]="69148Burla burlando                                    Alberto del Campo             20160";
        DatosIniciales[31]="21945Cuando el oro aprieta                             Bjon Blanca                   20180";
        DatosIniciales[32]="32956Animales heridos                                  Luis Aleman                   20170";
        DatosIniciales[33]="45698Al tantear la costa                               Juan Fernandez                20190";
        DatosIniciales[34]="71465Vuelos rasantes                                   Luis Amezaga                  20190";
        DatosIniciales[35]="82354Manual practico de IVA                            Carlos Cabrerizo              20200";
        DatosIniciales[36]="16745El reino de la araña                              Mario Delbal                  19950";
        DatosIniciales[37]="29631Manual de derecho tributario                      Carlos Benz                   20160";
        DatosIniciales[38]="39356Leyes de la corrupcion                            Jose Ajenjo                   20140";
        DatosIniciales[39]="46723Memorias de un homicida                           Maria Soto                    20140";
        DatosIniciales[40]="53545Bajo la ultima luz                                Vicente Rodriguez             20150";
        DatosIniciales[41]="68245Shaman urbano                                     Manuel Lara                   20170";
        DatosIniciales[42]="74289Realidades ocultas                                Adrian Inch                   20180";
        DatosIniciales[43]="83456Las zonas frias del sol                           Eugenio Asensio               20180";
        DatosIniciales[44]="91325El color del Ritmo                                Alba Oliva                    20200";
        DatosIniciales[45]="17645El derecho de la nutricion                        Jose Gomez                    19950";
        DatosIniciales[46]="93145Las cronicas de otro mundo II                     Adrian Belmonte               19940";
        DatosIniciales[47]="53568Las cenizas del Manhattan                         Pedro Lopez                   19990";
        DatosIniciales[48]="68274La llave de dios                                  Elena Fernadez                20200";
        DatosIniciales[49]="46798Los filosofos y la libertad                       Fernando Llorca               20200";
        DatosIniciales[50]="47698Palabras que me lleven                            Francisco Rosa                20140";
        DatosIniciales[51]="26985Sabado ingles                                     Jorge Penabade                20170";
        DatosIniciales[52]="33978De cenizas e incendios                            Sara Carballal                20140";
        DatosIniciales[53]="72431Versos y Coplas                                   Jose Navarro                  20130";
        DatosIniciales[54]="84345La madriguera                                     German Ruiz                   20130";
        DatosIniciales[55]="11457Darwinismo y psicianalisis                        Enrique Miura                 20190";
        DatosIniciales[56]="91478Barro                                             Beatriz de silva              20190";
        DatosIniciales[57]="29236El viaje de Irina                                 Fernando domiguez             20190";
        DatosIniciales[58]="83549Los mares Olvidados                               Pablo casanova                20180";
        DatosIniciales[59]="39458Ojos verdes                                       David Vizcaino                20160";
        DatosIniciales[60]="74652Banderas dobladas                                 Ignacio Perandones            20140";
        DatosIniciales[61]="58341Telaraña de odio                                  David Brihuega                20190";
        DatosIniciales[62]="68347La corte de los escandalos                        Julio Carrisho                20190";
        DatosIniciales[63]="53656Zapatos de la estrada                             Carlos Galoz                  20200";
        DatosIniciales[64]="46821Alacran                                           Salva Almendi                 20200";
        DatosIniciales[65]="14152Sara Mattson                                      Ivan Reboredo                 20160";
        DatosIniciales[66]="94132Serena quietud                                    Javier Jotamar                20130";
        DatosIniciales[67]="22946Un canto de libertad                              German Diez                   20130";
        DatosIniciales[68]="85317El enclave                                        Jose Manuel Cruz              19950";
        DatosIniciales[69]="34953Retazos de ayer                                   Luis belaunde                 19950";
        DatosIniciales[70]="76422La peor lluvia                                    Milagros Artieda              19990";
        DatosIniciales[71]="48633Kartapolis                                        Jose Siless                   19990";
        DatosIniciales[72]="63874La palabra perfecta                               Antonio Muñoz                 19970";
        DatosIniciales[73]="56322Ciclo de vuelos bajos                             Jose Sernan                   19970";
        DatosIniciales[74]="11523Niñas y maestras                                  Rosa Elena Sanches            19540";
        DatosIniciales[75]="29356Campo de amapolas                                 Tereza Oliaz                  19950";
        DatosIniciales[76]="91555Que bello es morir                                Antoniano Salinero            19950";
        DatosIniciales[77]="83625Despues del nuevo amanecer                        Erasmo Cachay                 19960";
        DatosIniciales[78]="53714El tren de la esperanza                           Isaber RigB                   19960";
        DatosIniciales[79]="39555Amar una terrorista                               Julio Bernar                  20200";
        DatosIniciales[80]="68457Miedos del Hoy                                    Luis Vianc                    20200";
        DatosIniciales[81]="74755Canciones del amor mentido                        Esther Aparicio               20200";
        DatosIniciales[82]="46999El opio afgano                                    Dany Aros                     19780";
        DatosIniciales[83]="15132G3                                                Javier Francisco Torres       20150";
        DatosIniciales[84]="95123La señorita arcade                                Ivan Robleza                  20150";
        DatosIniciales[85]="57369Ana somos todos                                   Javier Latorre                20180";
        DatosIniciales[86]="64852Entre moros y cristianos                          Fran Amogara                  20180";
        DatosIniciales[87]="23962El inquilino                                      Sofia Meler                   20160";
        DatosIniciales[88]="77421La economia estresada                             Jos Cruz                      20160";
        DatosIniciales[89]="49637De la nada a tu carne                             Pepe Cruz                     20110";
        DatosIniciales[90]="35963Los pintores de estrellas                         Pedro Eguinta                 20110";
        DatosIniciales[91]="86322Las damas justas                                  Rosana Fonceca                20110";
        DatosIniciales[92]="48632Un dios de soles                                  Vicent Machado                20130";
        DatosIniciales[93]="92965Operacion Ulises                                  David Aramburo                20130";
        DatosIniciales[94]="16543Compromiso adquirido                              Jeus Losana                   20120";
        DatosIniciales[95]="53248Cuentos de luna                                   Jose de la Mar                20120";
        DatosIniciales[96]="56874El bajo destello                                  Enrique Pinar Rodriguez       20170";
        DatosIniciales[97]="69831Dos gotass                                        Ana Frances                   20170";
        DatosIniciales[98]="78566Cruze de caminos                                  Carlos Carrion                20160";
        DatosIniciales[99]="32459El hijo del aparcero                              Jose Abelardo Valles          20160";
        
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            for(int k = 0;k < DatosIniciales.length; k++)
            {
                String CodLibro=DatosIniciales[k].substring(0,5);//cortamos cada atributo del registro
                String Titulo=DatosIniciales[k].substring(5,55);
                String Autor=DatosIniciales[k].substring(55,85);
                int Año=Integer.parseInt(DatosIniciales[k].substring(85,89));//conversion a int del año
                int Estado=Integer.parseInt(DatosIniciales[k].substring(89,90));
                AccesoAleatorio.añadirLibro(new Libro(CodLibro,Titulo,Autor,Año,Estado));
            }
            
            
            
            AccesoAleatorio.cerrar();
            //JOptionPane.showMessageDialog(this, "El registro se realizó correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error en la escritura de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaSalida = new javax.swing.JTable();
        btListar = new javax.swing.JButton();
        btListarEliminados = new javax.swing.JButton();
        btListarTodos = new javax.swing.JButton();
        btnIndexar = new javax.swing.JButton();
        btnOrdenacion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbCodLibro = new javax.swing.JTextField();
        tbTitulo = new javax.swing.JTextField();
        tbAutor = new javax.swing.JTextField();
        tbAño = new javax.swing.JTextField();
        btAgregarLibro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tbLibroAEliminar = new javax.swing.JTextField();
        btEliminarLibro = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tbBuscarLibro = new javax.swing.JTextField();
        btBuscarLibro = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btEditarLibro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manejo de Archivos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TablaSalida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(TablaSalida);

        btListar.setText("Listar");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        btListarEliminados.setText("Listar Eliminados");
        btListarEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarEliminadosActionPerformed(evt);
            }
        });

        btListarTodos.setText("Listar Todos");
        btListarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarTodosActionPerformed(evt);
            }
        });

        btnIndexar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnIndexar.setText("Indexar Datos del Libro");
        btnIndexar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndexarActionPerformed(evt);
            }
        });

        btnOrdenacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnOrdenacion.setText("Ordenacion por Mezcla Externa");
        btnOrdenacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btListarEliminados, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btListarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 664, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btnIndexar, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnOrdenacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btListar)
                    .addComponent(btListarEliminados)
                    .addComponent(btListarTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOrdenacion)
                    .addComponent(btnIndexar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar Libro"));

        jLabel1.setText("Cod Libro:");

        jLabel2.setText("Titulo:");

        jLabel3.setText("Autor:");

        jLabel4.setText("Año:");
        jLabel4.setToolTipText("");

        tbCodLibro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbCodLibroFocusGained(evt);
            }
        });

        tbTitulo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbTituloFocusGained(evt);
            }
        });

        tbAutor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbAutorFocusGained(evt);
            }
        });

        tbAño.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbAñoFocusGained(evt);
            }
        });

        btAgregarLibro.setText("Agregar Libro");
        btAgregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbCodLibro)
                    .addComponent(tbTitulo)
                    .addComponent(tbAutor)
                    .addComponent(tbAño))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(btAgregarLibro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbCodLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btAgregarLibro)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar Libro"));

        jLabel5.setText("Cod Libro:");

        tbLibroAEliminar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbLibroAEliminarFocusGained(evt);
            }
        });

        btEliminarLibro.setText("Eliminar Libro");
        btEliminarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tbLibroAEliminar)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btEliminarLibro)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tbLibroAEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btEliminarLibro))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Libro por Codigo"));

        jLabel6.setText("Cod Libro:");

        tbBuscarLibro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbBuscarLibroFocusGained(evt);
            }
        });

        btBuscarLibro.setText("Buscar Libro");
        btBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBuscarLibro)
                    .addComponent(tbBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tbBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btBuscarLibro))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Libro "));

        btEditarLibro.setText("Editar Libro");
        btEditarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(btEditarLibro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btEditarLibro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btAgregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarLibroActionPerformed
        // arega un libro el la ultima posicion
        String CodLibro = tbCodLibro.getText().trim();//asigacion del txt
        if(CodLibro.isEmpty()) {//verificacion si esta vacio
            JOptionPane.showMessageDialog(this, "¡No se ingreso el Codigo del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        if(CodLibro.length()<5)
        {
            CodLibro=String.format("%-5s", CodLibro);
        }
        
        String Titulo = tbTitulo.getText().trim();
        if(Titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso Titulo del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(Titulo.length()<50)
        {
            Titulo=String.format("%-50s", Titulo);
        }
          
        String Autor = tbAutor.getText().trim();
        if(Autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso Autor del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if(Autor.length()<30)
        {
            Autor=String.format("%-30s", Autor);//*********
        }
        
        String _Año = tbAño.getText().trim();
        if(_Año.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso Año del libro", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int Año;
        int Estado=0;
        try{
            Año=Integer.parseInt(_Año);//conversion a int del año
        }catch(NumberFormatException nfe)
        {
             JOptionPane.showMessageDialog(this, "Debe ser ingresar un numero entero para el año.", "Advertencia", JOptionPane.WARNING_MESSAGE);             
             return;
        }
  
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            //parte que valida si el codigo esta duplicandose (borrar si modifica algo)
            for(int i=0; i<AccesoAleatorio.getNumeroRegistros();i++){//recorrido pero solo en registro donde su estado sea 0
                Libro A=AccesoAleatorio.getLibro(i);//Encontrar libro a eliminar, i su posicion
                if((A.getCodLibro().equals(CodLibro))&&(A.getEstado()==0))
                {
                    JOptionPane.showMessageDialog(this, "El codido ingresado ya existe", "Notificación", JOptionPane.WARNING_MESSAGE);
                    AccesoAleatorio.cerrar();//se muestra el libro y se cierra
                    return;
                }
              
            } 
            //parte que valida si el codigo esta duplicandose (borrar si modifica algo)
            AccesoAleatorio.añadirLibro(new Libro(CodLibro,Titulo,Autor,Año,Estado));//agregar el libro en la ulrima poscion
            AccesoAleatorio.cerrar();
            JOptionPane.showMessageDialog(this, "El registro se realizó correctamente.", "Notificación", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error en la escritura de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //para actualizar el grid
        LimpiarTabla();
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            for(int i=0; i<AccesoAleatorio.getNumeroRegistros();i++){//recorrido pero solo en registro donde su estado sea 0
                Libro A=AccesoAleatorio.getLibro(i);//Encontrar libro a eliminar, i su posicion
                if(A.getEstado()==0)
                {
                     dtm.addRow(new Object[]{i,A.getCodLibro(),A.getTitulo(),A.getAutor(),A.getAño(),A.getEstado()});
                }
              
            } 
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btAgregarLibroActionPerformed

    private void btBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarLibroActionPerformed
        // Devuelve un libro si no se encuentra marcado como eliminado
        String libro = tbBuscarLibro.getText().trim();
        if(libro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el nombre del libro!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            int i = AccesoAleatorio.buscarRegistro( libro );//recupera la poscion del libro
            if(i==-1) {//no se encontro la posicion del libro
                JOptionPane.showMessageDialog(this, "Ningún registro coincide con el libro que se búsca.", "Advertencia", JOptionPane.WARNING_MESSAGE);             
                return;
            }
            Libro A=AccesoAleatorio.getLibro(i);//recupera los datos del libro y lo almacena en A
            if(A.getEstado()==0){//si es igual a cero esta el libro esta activo
                JOptionPane.showMessageDialog(this, "Libro encontrado: "+AccesoAleatorio.getLibro(i), "Notificación", JOptionPane.INFORMATION_MESSAGE);
                AccesoAleatorio.cerrar();//se muestra el libro y se cierra
            }else
            {
                JOptionPane.showMessageDialog(this, "No existe Libro ", "Notificación", JOptionPane.INFORMATION_MESSAGE);
                AccesoAleatorio.cerrar();//no hay libro y se cierra
            }
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //LimpiarTabla();
    }//GEN-LAST:event_btBuscarLibroActionPerformed

    private void btEliminarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarLibroActionPerformed
        // TODO add your handling code here:
        String libro = tbLibroAEliminar.getText().trim();
        if(libro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el nombre del libro!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } 
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            
            int i = AccesoAleatorio.buscarRegistro( libro );//ubicamos la posicion de libro buscado
            if(i==-1) {//no hay libro
                JOptionPane.showMessageDialog(this, "Ningún registro coincide con el libro que se búsca.", "Advertencia", JOptionPane.WARNING_MESSAGE);             
                return;
            }
            
            Libro A=AccesoAleatorio.getLibro(i);//Encontrar libro a eliminar, i su posicion
            if(A.getEstado()==0){//se puede eliminar el libro ya que no esta eliminado
            JOptionPane.showMessageDialog(this, "Libro encontrado en la posicion: "+i+" Eliminado", "Notificación", JOptionPane.INFORMATION_MESSAGE);
            int j= AccesoAleatorio.buscarRegistroMenos1(-1);//buscamos el registro que posea un estado -1
            if(j==-2) {//si no encontramos un registro con estado -1
                JOptionPane.showMessageDialog(this, "Ningún registro coincide con el libro que se búsca.", "Advertencia", JOptionPane.WARNING_MESSAGE);             
                return;
            }
            Libro B=AccesoAleatorio.getLibro(j);//registro con -1 para cambiar su atributo 
            B.setEstado(i);//cambiar el estado por la posicion a eliminar
            A.setEstado(-1);//cambiar el estado de la poscion a -1
            AccesoAleatorio.setLibro(j,B);//reescritura del registro
            AccesoAleatorio.setLibro(i,A);//reescritura del registro
            AccesoAleatorio.cerrar();
            }
            else
            {//el libro ya esta eliminado
                JOptionPane.showMessageDialog(this, "El libro ya se encuentra marcado como eliminado ", "Notificación", JOptionPane.INFORMATION_MESSAGE);
                AccesoAleatorio.cerrar();
            }
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        LimpiarTabla();
        
        //xd
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            Libro A=AccesoAleatorio.getLibro(0);//comienzo en el puntero del byte o
           
            int comparador=A.getEstado();//asigno el estado a mi comparador
            while((comparador!=-1))
            {
                Libro B=AccesoAleatorio.getLibro(comparador);//recupero el indice del eliminado
                dtm.addRow(new Object[]{comparador,B.getCodLibro(),B.getTitulo(),B.getAutor(),B.getAño(),B.getEstado()});//agrego al datatable
                
                comparador=B.getEstado();//actualizo valor del comparador
            }
            
            
            
            
              
            
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        //xd
    }//GEN-LAST:event_btEliminarLibroActionPerformed

    private void btListarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarTodosActionPerformed
        // TODO add your handling code here:
         LimpiarTabla();
         try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            for(int i=0; i<AccesoAleatorio.getNumeroRegistros();i++){//recorrido recuperndo los libros en cada posicion
                Libro A=AccesoAleatorio.getLibro(i);//Encontrar libro a eliminar, i su posicion
                dtm.addRow(new Object[]{i,A.getCodLibro(),A.getTitulo(),A.getAutor(),A.getAño(),A.getEstado()});
            } 
           dtm.setValueAt("", 0, 4);
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btListarTodosActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        // TODO add your handling code here:
        LimpiarTabla();
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            for(int i=0; i<AccesoAleatorio.getNumeroRegistros();i++){//recorrido pero solo en registro donde su estado sea 0
                Libro A=AccesoAleatorio.getLibro(i);//Encontrar libro a eliminar, i su posicion
                if(A.getEstado()==0)
                {
                     dtm.addRow(new Object[]{i,A.getCodLibro(),A.getTitulo(),A.getAutor(),A.getAño(),A.getEstado()});
                }
              
            } 
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btListarActionPerformed

    private void btListarEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarEliminadosActionPerformed
        // TODO add your handling code here:
           LimpiarTabla();
           
        try {
            AccesoAleatorio.crearFileLibro( new File("ArchivosCreados\\Libro.dat") );
            Libro A=AccesoAleatorio.getLibro(0);//comienzo en el puntero del byte o
           
            int comparador=A.getEstado();//asigno el estado a mi comparador
            while((comparador!=-1))
            {
                Libro B=AccesoAleatorio.getLibro(comparador);//recupero el indice del eliminado
                dtm.addRow(new Object[]{comparador,B.getCodLibro(),B.getTitulo(),B.getAutor(),B.getAño(),B.getEstado()});//agrego al datatable
                
                comparador=B.getEstado();//actualizo valor del comparador
            }
            
            
            
            
              
            
            
        } catch(IOException e) {
            JOptionPane.showMessageDialog(this, "Error en la búsqueda de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btListarEliminadosActionPerformed

    private void tbCodLibroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbCodLibroFocusGained
        // TODO add your handling code here:
        tbCodLibro.selectAll();
    }//GEN-LAST:event_tbCodLibroFocusGained

    private void tbTituloFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbTituloFocusGained
        // TODO add your handling code here:
        tbTitulo.selectAll();
    }//GEN-LAST:event_tbTituloFocusGained

    private void tbAutorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbAutorFocusGained
        // TODO add your handling code here:
        tbAutor.selectAll();
    }//GEN-LAST:event_tbAutorFocusGained

    private void tbAñoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbAñoFocusGained
        // TODO add your handling code here:
        tbAño.selectAll();
    }//GEN-LAST:event_tbAñoFocusGained

    private void tbLibroAEliminarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbLibroAEliminarFocusGained
        // TODO add your handling code here:
        tbLibroAEliminar.selectAll();
    }//GEN-LAST:event_tbLibroAEliminarFocusGained

    private void tbBuscarLibroFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbBuscarLibroFocusGained
        // TODO add your handling code here:
        tbBuscarLibro.selectAll();
    }//GEN-LAST:event_tbBuscarLibroFocusGained

    private void btEditarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarLibroActionPerformed
        // TODO add your handling code here:
        Modificar Ma= new Modificar();
        Ma.setVisible(true);
    }//GEN-LAST:event_btEditarLibroActionPerformed

    private void btnIndexarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndexarActionPerformed
        // TODO add your handling code here:
        Arboles Ar= new Arboles();
        Ar.setVisible(true);
    }//GEN-LAST:event_btnIndexarActionPerformed

    private void btnOrdenacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenacionActionPerformed
        // TODO add your handling code here:
        OrdenacionMezcla Or= new OrdenacionMezcla();
        Or.setVisible(true);
    }//GEN-LAST:event_btnOrdenacionActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //evento para ceera ventana
        //Cerrar();
    }//GEN-LAST:event_formWindowClosing
    void LimpiarTabla()
    {
        int filas=TablaSalida.getRowCount();
        for(int i=0; i<filas;i++){
            dtm.removeRow(0);
        }
    }
    public void Limitar()
    {
        tbCodLibro.setDocument(new LimitarCaracter(tbCodLibro,5));
        tbTitulo.setDocument(new LimitarCaracter(tbTitulo,50));
        tbAutor.setDocument(new LimitarCaracter(tbAutor,30));
        tbAño.setDocument(new LimitarCaracter(tbAño,4));
        tbAño.setDocument(new LimitarCaracter(tbAño,4));
        tbLibroAEliminar.setDocument(new LimitarCaracter(tbLibroAEliminar,5));
        tbBuscarLibro.setDocument(new LimitarCaracter(tbBuscarLibro,5));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaSalida;
    private javax.swing.JButton btAgregarLibro;
    private javax.swing.JButton btBuscarLibro;
    private javax.swing.JButton btEditarLibro;
    private javax.swing.JButton btEliminarLibro;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btListarEliminados;
    private javax.swing.JButton btListarTodos;
    private javax.swing.JButton btnIndexar;
    private javax.swing.JButton btnOrdenacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tbAutor;
    private javax.swing.JTextField tbAño;
    private javax.swing.JTextField tbBuscarLibro;
    private javax.swing.JTextField tbCodLibro;
    private javax.swing.JTextField tbLibroAEliminar;
    private javax.swing.JTextField tbTitulo;
    // End of variables declaration//GEN-END:variables
}
