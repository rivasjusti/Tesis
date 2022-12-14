/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frminicio;


import flogica.conexion;
import flogica.f_accesorios;
import flogica.f_codigocliente;
import flogica.f_llegada;
import flogica.f_mecanico;
import flogica.f_reparacion;
import flogica.f_modelo;
import flogica.f_reclamos;
import flogica.f_tipofactura;
import static frminicio.frmpago.txtclientes;
import static frminicio.frmpago.txtidaccesorios;
import static frminicio.frmpago.txtidcliente;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vdatos.vllegada;
import vdatos.vreclamos;
import vdatos.vreparacion;

//import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

/**
 *
 * @author justi
 */
public class frmreclamos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmhabitacion
     */
    public frmreclamos() {
        initComponents();
        mostrar("");
        inhabilitar();
    }

    private String accion = "guardar";

    void ocultar_columnas() {
        jTListado.getColumnModel().getColumn(0).setMaxWidth(0);
        jTListado.getColumnModel().getColumn(0).setMinWidth(0);
        jTListado.getColumnModel().getColumn(0).setPreferredWidth(0);
        
//        jTListado.getColumnModel().getColumn(1).setMaxWidth(0);
//        jTListado.getColumnModel().getColumn(1).setMinWidth(0);
//        jTListado.getColumnModel().getColumn(1).setPreferredWidth(0);
//        
//        jTListado.getColumnModel().getColumn(2).setMaxWidth(0);
//        jTListado.getColumnModel().getColumn(2).setMinWidth(0);
//        jTListado.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void inhabilitar() {
        jTFidhabitacion.setVisible(false);

       
        jCBMODELO.setEnabled(false);
      
        txtdescripcion.setEnabled(false);
        txtidcliente.setEnabled(false);
         txtdescripcion.setEnabled(false);
        jDcalentar.setEnabled(false);
        txtdescripcion.setEnabled(false);
        jBGuardar.setEnabled(false);
        jBCancelar.setEnabled(false);
        jBEliminar.setEnabled(false);
        //jbreporte.setEnabled(false);
        
        jTFidhabitacion.setText("");
        jCBMODELO.setSelectedIndex(-1);
      
       
    }

    void habilitar() {
        jTFidhabitacion.setVisible(false);
        txtdescripcion.setEnabled(true);
       
       jCBMODELO.setEnabled(true);
        
        txtclientes.setEnabled(true);
        txtidcliente.setEnabled(true);
//        txtidmecanico.setEnabled(false);
//        txtmecanico.setEnabled(true);
        jDcalentar.setEnabled(true);
        txtdescripcion.setEnabled(true);
        jBGuardar.setEnabled(true);
        jBCancelar.setEnabled(true);
        jBEliminar.setEnabled(true);
       // jbreporte.setEnabled(true);
       
        jTFidhabitacion.setText("");
       
      
        jCBMODELO.setSelectedIndex(-1);
      
      
    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            f_reclamos func = new f_reclamos();
            
            f_modelo fp = new f_modelo();
            //f_mecanico fm = new f_mecanico();
           // f_codigocliente fc = new f_codigocliente();
           // f_mecanico fm =new f_mecanico();
          
            modelo = func.mostrar(buscar);
            

            jTListado.setModel(modelo);
            ocultar_columnas();
            jLRegistros.setText("Total Registros " + Integer.toString(func.totalregistros));
           // jTFmanodeobra.setText("Total Registros " + Integer.toString(func.jTFtotalpagar1));
         
           
//            fe.cargarComboEstados(jCBEstado);
           fp.cargarComboModelo(jCBMODELO);
           //fc.cargarComboCliente(jCBMODELO);
                   

           
          

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTFidhabitacion = new javax.swing.JTextField();
        jLNumero = new javax.swing.JLabel();
        jLPiso = new javax.swing.JLabel();
        jBNuevo = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jCBMODELO = new javax.swing.JComboBox<>();
        jLPiso1 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        btnbuscarclientes = new javax.swing.JToggleButton();
        txtidcliente = new javax.swing.JTextField();
        jDcalentar = new com.toedter.calendar.JDateChooser();
        txtclientes = new javax.swing.JTextField();
        jLPiso2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTListado = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTFBuscar = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jLRegistros = new javax.swing.JLabel();
        jbreporte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrar Reclamos");

        jPanel1.setBackground(new java.awt.Color(51, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Reclamos "));

        jTFidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFidhabitacionActionPerformed(evt);
            }
        });

        jLNumero.setText("Fecha entrada");

        jLPiso.setText("Modelo");

        jBNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/escribir.png"))); // NOI18N
        jBNuevo.setText("Nuevo");
        jBNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevoActionPerformed(evt);
            }
        });

        jBGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guarde.png"))); // NOI18N
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/cancelar-icono-9428-32.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jCBMODELO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBMODELOActionPerformed(evt);
            }
        });

        jLPiso1.setText("Descripcion");

        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });

        btnbuscarclientes.setText("...");
        btnbuscarclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarclientesActionPerformed(evt);
            }
        });

        txtclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclientesActionPerformed(evt);
            }
        });

        jLPiso2.setText("Clientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCBMODELO, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDcalentar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
                .addComponent(btnbuscarclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jBGuardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLPiso1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(jBCancelar)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLPiso2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(356, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jTFidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLPiso1)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnbuscarclientes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtclientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDcalentar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBMODELO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBNuevo)
                    .addComponent(jBGuardar)
                    .addComponent(jBCancelar))
                .addGap(75, 75, 75))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(101, 101, 101)
                    .addComponent(jLPiso2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(348, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jTListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTListadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTListadoMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTListado);

        jLabel2.setText("Buscar:");

        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jLRegistros.setText("Total de Registro");

        jbreporte.setText("Reportes");
        jbreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbreporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157)
                .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbreporte, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addComponent(jScrollPane3)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBBuscar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBSalir)
                        .addComponent(jBEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addComponent(jbreporte, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        if (!jTFidhabitacion.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar el Reclamos?", "Confirmar", 2);

            if (confirmacion == 0) {
                f_reclamos func = new f_reclamos();
                vreclamos dts = new vreclamos();

                dts.setIdreclamos(Integer.parseInt(jTFidhabitacion.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        // TODO add your handling code here:
        mostrar(jTFBuscar.getText());
    }//GEN-LAST:event_jBBuscarActionPerformed

    private void jTListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListadoMouseClicked
        // TODO add your handling code here:
        jBGuardar.setText("Editar");
        habilitar();
        jBEliminar.setEnabled(true);
        accion = "editar";

        int fila = jTListado.rowAtPoint(evt.getPoint());

        jTFidhabitacion.setText(jTListado.getValueAt(fila, 0).toString());
        txtdescripcion.setText(jTListado.getValueAt(fila, 1).toString());
        txtclientes.setText(jTListado.getValueAt(fila, 2).toString());
        
        jCBMODELO.setSelectedItem(jTListado.getValueAt(fila, 3).toString());
     
    }//GEN-LAST:event_jTListadoMouseClicked

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_jBSalirActionPerformed
    private Connection connection=new conexion().conectar();
    
    private void jbreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbreporteActionPerformed
        // TODO add your handling code here:
           Map p =new HashMap();
           JasperReport  report;
           JasperPrint print;
           
           try {
            report=JasperCompileManager.compileReport(new File("").getAbsolutePath()+
                    "/src/Reportes/rptllegada.jrxml");  
            print=JasperFillManager.fillReport(report, p,connection);
               JasperViewer view=new JasperViewer(print,false);
               view.setTitle("Reporte de Llegada");
               view.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }//GEN-LAST:event_jbreporteActionPerformed

    private void jCBMODELOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBMODELOActionPerformed
        // TODO add your handling code here:
         jCBMODELO.transferFocus();
    }//GEN-LAST:event_jCBMODELOActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        // TODO add your handling code here:
        mostrar("");
        inhabilitar();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        if (txtidcliente.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar al cliente si..");
            txtidcliente.requestFocus();
            return;
        }
        if (txtdescripcion.getText().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debes ingresar la descripcion si..");
            txtdescripcion.requestFocus();
            return;
        }
        
        
        
       
       
        

        vreclamos dts = new vreclamos();
        f_reclamos func = new f_reclamos();

       
        f_modelo fp = new f_modelo();
       // f_mecanico fm = new f_mecanico();
        //f_codigocliente fc=new f_codigocliente();
         Calendar cal;
        int d,m,a;
        
        cal = jDcalentar.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1900;
        
        dts.setFecharecla(new Date(a,m,d));
       
       


       
       dts.setDescripcion(txtdescripcion.getText());
       
     dts.setIdClientes(Integer.parseInt(txtidcliente.getText()));
       
       
        
       
         int seleccionado = jCBMODELO.getSelectedIndex();
         dts.setIdModelo(fp.obtenerIdModelo(jCBMODELO));
        

       
       
        //dts.setIdAccesorios(fm.obtenerIdAccesorios(jCBacc ));
        //////////////////////////////////////////
        

         

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "EL Reclamo fue registrada satisfactoriamente!");
                mostrar("");
                inhabilitar();
            }
        } else if (accion.equals("editar")) {
            dts.setIdreclamos(Integer.parseInt(jTFidhabitacion.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "Reclamos fue editada satisfactoriamente!");
                mostrar("");
                inhabilitar();
            }
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        jBGuardar.setText("Guardar");
        accion = "guardar";
    }//GEN-LAST:event_jBNuevoActionPerformed

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
           txtdescripcion.transferFocus();
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void btnbuscarclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarclientesActionPerformed
        // TODO add your handling code here:
        frmvistareclamo form = new frmvistareclamo();
        form.toFront();
        form.setVisible(true);
    }//GEN-LAST:event_btnbuscarclientesActionPerformed

    private void jTListadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTListadoMousePressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTListadoMousePressed

    private void txtclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclientesActionPerformed

    private void jTFidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFidhabitacionActionPerformed

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
            java.util.logging.Logger.getLogger(frmreclamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmreclamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmreclamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmreclamos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmreclamos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnbuscarclientes;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevo;
    private javax.swing.JButton jBSalir;
    private javax.swing.JComboBox<String> jCBMODELO;
    private com.toedter.calendar.JDateChooser jDcalentar;
    private javax.swing.JLabel jLNumero;
    private javax.swing.JLabel jLPiso;
    private javax.swing.JLabel jLPiso1;
    private javax.swing.JLabel jLPiso2;
    private javax.swing.JLabel jLRegistros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTFBuscar;
    private javax.swing.JTextField jTFidhabitacion;
    private javax.swing.JTable jTListado;
    private javax.swing.JButton jbreporte;
    public static javax.swing.JTextField txtclientes;
    public static javax.swing.JTextField txtdescripcion;
    public static javax.swing.JTextField txtidcliente;
    // End of variables declaration//GEN-END:variables
}
