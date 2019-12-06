/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.Empleados;
import entidades.BonosDescuentos;
import entidades.Detallepagos;
import entidades.Pagos;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import recursoshumanos.Bonos_Descuentos;
import recursoshumanos.DetallePagosEmpleados;
import recursoshumanos.PagosEmpleados;
import singleton.singleton;

/**
 *
 * @author User
 */
public class HistorialPagos extends javax.swing.JPanel {
    Empleados empleado;
    public HistorialPagos(Empleados empleado) {
        initComponents();
        DefaultTableModel modelotabla = new DefaultTableModel();
        DefaultTableModel modelodetalle = new DefaultTableModel();
        this.empleado = empleado;
        modelotabla.addColumn("Código pago");
        modelotabla.addColumn("Fecha y hora");
        modelotabla.addColumn("Total");
        tPagos.setModel(modelotabla);
        modelodetalle.addColumn("Código detalle");
        modelodetalle.addColumn("Cantidad");
        modelodetalle.addColumn("Descripción");
        modelodetalle.addColumn("Sub-total");
        lblPago.setText("Pago a: " + empleado.getNombre() + " " + empleado.getApellido());
        tDetalles.setModel(modelodetalle);
        definirAno();
        inicializarListener();
    }
    
    public void inicializarListener() {
        tPagos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    PagosEmpleados pagos = new PagosEmpleados();
                    Pagos pago = pagos.obtenerPago(Integer.parseInt(String.valueOf(tPagos.getValueAt(tPagos.getSelectedRow(),
                            0))), singleton.getConnection());
                    DetallePagosEmpleados detalles = new DetallePagosEmpleados();
                    detalles.listarDetalles((DefaultTableModel) tDetalles.getModel(), pago, singleton.getConnection());
                }
            }
        });
    }
    
    public void definirAno()
    {
        int ano = 2019;
        Calendar cal= Calendar.getInstance();
        int anoactual= cal.get(Calendar.YEAR);
        while (ano <= anoactual)
        {
            cbAnoInicio.addItem(String.valueOf(ano));
            cbAnoFinal.addItem(String.valueOf(ano));
            ano ++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        btnBuscar = new javax.swing.JButton();
        jScrollPabe3 = new javax.swing.JScrollPane();
        tDetalles = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblColorVerde2 = new javax.swing.JLabel();
        lblColorVerde1 = new javax.swing.JLabel();
        lblColorVerde = new javax.swing.JLabel();
        cbMesInicio = new javax.swing.JComboBox<>();
        cbAnoInicio = new javax.swing.JComboBox<>();
        lblColorVerde4 = new javax.swing.JLabel();
        lblColorVerde3 = new javax.swing.JLabel();
        lblColorVerde5 = new javax.swing.JLabel();
        cbMesFinal = new javax.swing.JComboBox<>();
        cbAnoFinal = new javax.swing.JComboBox<>();
        btnRegresar = new javax.swing.JButton();
        jScrollPabe2 = new javax.swing.JScrollPane();
        tPagos = new javax.swing.JTable();
        btnEliminarPago = new javax.swing.JButton();
        btnEliminarDetalle = new javax.swing.JButton();
        lblPago = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(36, 41, 46));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 1010, -1));

        btnBuscar.setBackground(new java.awt.Color(0, 136, 204));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 109, -1));

        tDetalles = new javax.swing.JTable(){ public boolean isCellEditable(int rowIndex, int colIndex){     return false;     } };
        tDetalles.setModel(new javax.swing.table.DefaultTableModel(
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
        tDetalles.setFocusable(false);
        tDetalles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tDetallesMouseReleased(evt);
            }
        });
        jScrollPabe3.setViewportView(tDetalles);

        jPanel1.add(jScrollPabe3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 649, 170));

        jPanel2.setBackground(new java.awt.Color(36, 41, 46));

        lblColorVerde2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde2.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde2.setText("Mes:");

        lblColorVerde1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde1.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde1.setText("Rango inicio:");

        lblColorVerde.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde.setText("Año:");

        cbMesInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbMesInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cbAnoInicio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbAnoInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));

        lblColorVerde4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde4.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde4.setText("Mes:");

        lblColorVerde3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde3.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde3.setText("Rango final:");

        lblColorVerde5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde5.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde5.setText("Año:");

        cbMesFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbMesFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        cbAnoFinal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbAnoFinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar..." }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColorVerde2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(lblColorVerde1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(lblColorVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(lblColorVerde5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblColorVerde4, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(lblColorVerde3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(cbAnoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(cbMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(cbAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblColorVerde1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblColorVerde3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblColorVerde2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColorVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColorVerde5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColorVerde4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMesInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnoInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMesFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAnoFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 670, 110));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Back.png"))); // NOI18N
        btnRegresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Back2.png"))); // NOI18N
        btnRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Back1.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        tPagos = new javax.swing.JTable(){ public boolean isCellEditable(int rowIndex, int colIndex){     return false;     } };
        tPagos.setModel(new javax.swing.table.DefaultTableModel(
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
        tPagos.setFocusable(false);
        tPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tPagosMouseReleased(evt);
            }
        });
        jScrollPabe2.setViewportView(tPagos);

        jPanel1.add(jScrollPabe2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 649, 110));

        btnEliminarPago.setBackground(new java.awt.Color(0, 136, 204));
        btnEliminarPago.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarPago.setText("X");
        btnEliminarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPagoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 240, 50, -1));

        btnEliminarDetalle.setBackground(new java.awt.Color(0, 136, 204));
        btnEliminarDetalle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnEliminarDetalle.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarDetalle.setText("X");
        btnEliminarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDetalleActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminarDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 50, -1));

        lblPago.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPago.setForeground(new java.awt.Color(255, 255, 255));
        lblPago.setText("Pago a:");
        jPanel1.add(lblPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 650, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tPagosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPagosMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tPagosMouseReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (cbAnoInicio.getSelectedIndex() > 0 && cbMesInicio.getSelectedIndex() > 0 && cbAnoFinal.getSelectedIndex() > 0 && cbMesFinal.getSelectedIndex() > 0)
        {
            PagosEmpleados pagos = new PagosEmpleados();
            String fechainicio = String.valueOf(cbAnoInicio.getSelectedItem()) + "-" + cbMesInicio.getSelectedIndex() + "-" + "1";
            String fechafinal = String.valueOf(cbAnoFinal.getSelectedItem()) + "-" + cbMesFinal.getSelectedIndex() + "-" + elegirDiaFinal();
            if ((cbAnoInicio.getSelectedIndex() <= cbAnoFinal.getSelectedIndex()) && 
                    (cbMesFinal.getSelectedIndex() >= cbMesInicio.getSelectedIndex()))
                pagos.filtrado((DefaultTableModel) tPagos.getModel(),
                        fechainicio, fechafinal, empleado, singleton.getConnection());
            else
                JOptionPane.showMessageDialog(null, "La fecha final es menor a la de inicio, por favor verifique los rangos especificados.");
            DefaultTableModel modeloDetalles = (DefaultTableModel)tDetalles.getModel();
            while (modeloDetalles.getRowCount() > 0)
                modeloDetalles.removeRow(0);
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor seleccione mes y año en los rangos de inicio y final");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tDetallesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDetallesMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tDetallesMouseReleased

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        PagarEmpleados empleados = new PagarEmpleados(empleado);
        empleados.setSize(1010,600);
        empleados.setLocation(0, 0);
        this.removeAll();
        this.add(empleados,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEliminarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPagoActionPerformed
        DefaultTableModel modeloPagos = (DefaultTableModel) tPagos.getModel();
        if (tPagos.getSelectedRow() > -1)
        {
            DefaultTableModel modeloDetalles = (DefaultTableModel) tDetalles.getModel();
            PagosEmpleados pagos = new PagosEmpleados();
            DetallePagosEmpleados detalles = new DetallePagosEmpleados();
            int pago = Integer.parseInt(String.valueOf(tPagos.getValueAt(tPagos.getSelectedRow(), 0)));
            Pagos objetoCompra = pagos.obtenerPago(pago, singleton.getConnection());
            for (int i = 0; i < objetoCompra.getDetallepagosList().size(); i++)
                detalles.eliminarDetalle(objetoCompra.getDetallepagosList().get(i).getId(), singleton.getConnection());
            pagos.eliminarPago(pago, singleton.getConnection());
            modeloPagos.removeRow(tPagos.getSelectedRow());
            while (modeloDetalles.getRowCount() > 0)
                modeloDetalles.removeRow(0);
        }
    }//GEN-LAST:event_btnEliminarPagoActionPerformed

    private void btnEliminarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDetalleActionPerformed
        DefaultTableModel modeloDetalles = (DefaultTableModel) tDetalles.getModel();
        if (tDetalles.getSelectedRow() > -1) {
            int cantidad = Integer.parseInt(String.valueOf(tDetalles.getValueAt(tDetalles.getSelectedRow(), 1)));
            float subtotal = cantidad * Float.parseFloat(String.valueOf(tDetalles.getValueAt(tDetalles.getSelectedRow(), 3)));
            PagosEmpleados pagos = new PagosEmpleados();
            Pagos objetoPago = pagos.obtenerPago(Integer.parseInt(String.valueOf(tPagos.getValueAt(tPagos.getSelectedRow(), 0))), singleton.getConnection());
            DetallePagosEmpleados detalles = new DetallePagosEmpleados();
            detalles.eliminarDetalle(Integer.parseInt(String.valueOf(tDetalles.getValueAt(tDetalles.getSelectedRow(), 0))), singleton.getConnection());
            detalles.listarDetalles((DefaultTableModel) tDetalles.getModel(), objetoPago, singleton.getConnection());
            float total = 0;
            for (int i = 0; i < tDetalles.getRowCount(); i++) {
                total += Float.parseFloat(String.valueOf(tDetalles.getValueAt(i, 3)));
            }
            objetoPago = pagos.obtenerPago(Integer.parseInt(String.valueOf(tPagos.getValueAt(tPagos.getSelectedRow(), 0))), singleton.getConnection());
            objetoPago.setMonto(total);
            pagos.editarPago(objetoPago, singleton.getConnection());
            if (objetoPago.getDetallepagosList().size() == 0)
            {
                DefaultTableModel modeloPagos = (DefaultTableModel)tPagos.getModel();
                pagos.eliminarPago(objetoPago.getId(), singleton.getConnection());
                modeloPagos.removeRow(tPagos.getSelectedRow());
            }
            else
            {
                DefaultTableModel modeloCompra = (DefaultTableModel) tPagos.getModel();
                modeloCompra.setValueAt(total, tPagos.getSelectedRow(), 2);
            }
        }
    }//GEN-LAST:event_btnEliminarDetalleActionPerformed
    
    private String elegirDiaFinal()
    {
        String dia = "";
        if (cbMesInicio.getSelectedIndex() == 1)
            dia = "31";
        else if (cbMesInicio.getSelectedIndex() == 2)
            dia = anoFinalBisiesto();
        else if (cbMesInicio.getSelectedIndex() == 3)
            dia = "31";
        else if (cbMesInicio.getSelectedIndex() == 4)
            dia = "30";
        else if (cbMesInicio.getSelectedIndex() == 5)
            dia = "31";
        else if (cbMesInicio.getSelectedIndex() == 6)
            dia = "30";
        else if (cbMesInicio.getSelectedIndex() == 7)
            dia = "31";
        else if (cbMesInicio.getSelectedIndex() == 8)
            dia = "31";
        else if (cbMesInicio.getSelectedIndex() == 9)
            dia = "30";
        else if (cbMesInicio.getSelectedIndex() == 10)
            dia = "31";
        else if (cbMesInicio.getSelectedIndex() == 11)
            dia = "30";
        else if (cbMesInicio.getSelectedIndex() == 12)
            dia = "31";
        return dia;
    }

    private String anoFinalBisiesto()
    {
        int anoescogido = Integer.parseInt(String.valueOf(cbAnoInicio.getSelectedItem()));
        if (anoescogido % 4 == 0)
        {
            if (anoescogido % 100 == 0 && anoescogido % 400 != 0)
                return "28";
            else if (anoescogido % 100 != 0 && anoescogido % 400 != 0)
                return "29";
            else if (anoescogido % 100 == 0 && anoescogido % 400 == 0)
                return "29";
            else
                return "28";
        }
        else
            return "28";
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminarDetalle;
    private javax.swing.JButton btnEliminarPago;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbAnoFinal;
    private javax.swing.JComboBox<String> cbAnoInicio;
    private javax.swing.JComboBox<String> cbMesFinal;
    private javax.swing.JComboBox<String> cbMesInicio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPabe2;
    private javax.swing.JScrollPane jScrollPabe3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblColorVerde;
    private javax.swing.JLabel lblColorVerde1;
    private javax.swing.JLabel lblColorVerde2;
    private javax.swing.JLabel lblColorVerde3;
    private javax.swing.JLabel lblColorVerde4;
    private javax.swing.JLabel lblColorVerde5;
    private javax.swing.JLabel lblPago;
    private javax.swing.JTable tDetalles;
    private javax.swing.JTable tPagos;
    // End of variables declaration//GEN-END:variables
}
