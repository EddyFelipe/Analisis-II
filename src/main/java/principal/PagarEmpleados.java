/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.Empleados;
import entidades.BonosDescuentos;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import recursoshumanos.Bonos_Descuentos;
import singleton.singleton;

/**
 *
 * @author User
 */
public class PagarEmpleados extends javax.swing.JPanel {
    Empleados empleado;
    Bonos_Descuentos datos = new Bonos_Descuentos();
    DefaultListModel modeloagregar = new DefaultListModel();
    DefaultListModel modeloagregados = new DefaultListModel();
    DefaultListModel modelocantidades = new DefaultListModel();
    DefaultTableModel modelotabla = new DefaultTableModel();
    Date date = new Date();
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    boolean interruptor = true;
    int seleccionadoAgregar = 0;
    int seleccionadoRemover = 0;
    int seleccionadoCantidades = 0;
    
    public PagarEmpleados(Empleados empleado) {
        initComponents();
        this.empleado = empleado;
        lblEmpleado.setText("Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
        btnAgregar.setEnabled(false);
        btnRemover.setEnabled(false);
        btnConfirmar.setEnabled(false);
        btnPagar.setEnabled(false);
        rbConSalario.setSelected(true);
        rbSinSalario.setSelected(false);
        tfCantidad.setEnabled(false);
        tPagos.setModel(modelotabla);
        modelotabla.addColumn("Cantidad");
        modelotabla.addColumn("Fecha y hora");
        modelotabla.addColumn("Motivo");
        modelotabla.addColumn("Monto");
        inicializarDatosAgregar();
    }
    
    private void inicializarDatosAgregar()
    {
        List<BonosDescuentos> lista = datos.buscarObjects("", singleton.getConnection());
        for (int i = 0; i < lista.size(); i++)
        {
            if (lista.get(i).getDescontinuado() == 0)
            {
                if (lista.get(i).getEsBono() == 1)
                    modeloagregar.addElement(lista.get(i).getDescripción());
                else
                    modeloagregar.addElement(lista.get(i).getDescripción());
            }
            
        }
        listDisponibles.setModel(modeloagregar);
        listAgregados.setModel(modeloagregados);
        listCantidades.setModel(modelocantidades);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDisponibles = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listAgregados = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listCantidades = new javax.swing.JList<>();
        tfCantidad = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        jScrollPabe1 = new javax.swing.JScrollPane();
        tPagos = new javax.swing.JTable();
        btnPagar = new javax.swing.JButton();
        lblEmpleado = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        lblColorRojo = new javax.swing.JLabel();
        lblColorVerde = new javax.swing.JLabel();
        rbConSalario = new javax.swing.JRadioButton();
        rbSinSalario = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(36, 41, 46));

        listDisponibles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listDisponibles.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                listDisponiblesMouseDragged(evt);
            }
        });
        listDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listDisponiblesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listDisponiblesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listDisponiblesMouseReleased(evt);
            }
        });
        listDisponibles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listDisponiblesKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listDisponiblesKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                listDisponiblesKeyTyped(evt);
            }
        });
        listDisponibles.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDisponiblesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listDisponibles);

        btnAgregar.setBackground(new java.awt.Color(0, 136, 204));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar >>>");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnRemover.setBackground(new java.awt.Color(0, 136, 204));
        btnRemover.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(255, 255, 255));
        btnRemover.setText("Remover <<<");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        listAgregados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listAgregados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                listAgregadosMouseDragged(evt);
            }
        });
        listAgregados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listAgregadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listAgregadosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listAgregadosMouseReleased(evt);
            }
        });
        listAgregados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listAgregadosKeyPressed(evt);
            }
        });
        listAgregados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listAgregadosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listAgregados);

        listCantidades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listCantidades.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                listCantidadesMouseDragged(evt);
            }
        });
        listCantidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listCantidadesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listCantidadesMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listCantidadesMouseReleased(evt);
            }
        });
        listCantidades.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listCantidadesKeyPressed(evt);
            }
        });
        listCantidades.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCantidadesValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listCantidades);

        tfCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCantidadKeyTyped(evt);
            }
        });

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad:");

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
        jScrollPabe1.setViewportView(tPagos);

        btnPagar.setBackground(new java.awt.Color(0, 136, 204));
        btnPagar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");

        lblEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpleado.setText("Empleado: ");

        btnConfirmar.setBackground(new java.awt.Color(0, 136, 204));
        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblColorRojo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorRojo.setForeground(new java.awt.Color(255, 255, 255));
        lblColorRojo.setText("Naranja: Descuentos");

        lblColorVerde.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde.setText("Verde: Bonos");

        rbConSalario.setBackground(new java.awt.Color(36, 41, 46));
        rbConSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbConSalario.setForeground(new java.awt.Color(255, 255, 255));
        rbConSalario.setText("Con salario");
        rbConSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbConSalarioActionPerformed(evt);
            }
        });

        rbSinSalario.setBackground(new java.awt.Color(36, 41, 46));
        rbSinSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbSinSalario.setForeground(new java.awt.Color(255, 255, 255));
        rbSinSalario.setText("Sin salario");
        rbSinSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSinSalarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColorVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbSinSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbConSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPabe1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(34, 34, 34)
                        .addComponent(btnRemover)
                        .addGap(44, 44, 44))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbConSalario))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbSinSalario)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblColorVerde, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblColorRojo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPabe1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnConfirmar)
                        .addGap(18, 18, 18)
                        .addComponent(btnPagar)))
                .addGap(78, 78, 78))
        );

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

    private void tfCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCantidadKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER && !tfCantidad.getText().equals(""))
        {
            modelocantidades.setElementAt(tfCantidad.getText(), seleccionadoCantidades);
            tfCantidad.setText("");
        }
            
    }//GEN-LAST:event_tfCantidadKeyPressed

    private void tfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCantidadKeyTyped
        char c = evt.getKeyChar();
        if (c < '1' || c > '9')
            evt.consume();
        if (tfCantidad.getText().length() > 6) evt.consume();
    }//GEN-LAST:event_tfCantidadKeyTyped

    private void tPagosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPagosMouseReleased

    }//GEN-LAST:event_tPagosMouseReleased

    private void listDisponiblesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseReleased
        if (evt.getButton() == 1)
            seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMouseReleased

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        btnConfirmar.setEnabled(true);
        modeloagregados.addElement(listDisponibles.getSelectedValue());
        int auxiliar;
        if (listDisponibles.getModel().getSize()-1 > seleccionadoAgregar)
        {
            auxiliar = seleccionadoAgregar;
            modeloagregar.remove(listDisponibles.getSelectedIndex());
            listDisponibles.setSelectedIndex(auxiliar);
            if (datos.buscarBono_Descuento(singleton.getConnection(), listDisponibles.getSelectedValue()).getEsBono() == 1)
                listDisponibles.setSelectionBackground(Color.green);
            else
                listDisponibles.setSelectionBackground(Color.orange);
            
        }
        else
        {
            seleccionadoAgregar -= 1;
            auxiliar = seleccionadoAgregar;
            modeloagregar.remove(listDisponibles.getSelectedIndex());
            listDisponibles.setSelectedIndex(auxiliar);
            if (seleccionadoAgregar != -1)
            {
                if (datos.buscarBono_Descuento(singleton.getConnection(), listDisponibles.getSelectedValue()).getEsBono() == 1)
                    listDisponibles.setSelectionBackground(Color.green);
                else
                    listDisponibles.setSelectionBackground(Color.orange);                
            }
        }
        modelocantidades.addElement("1");
        if (seleccionadoAgregar == -1)
            btnAgregar.setEnabled(false);
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        modeloagregar.addElement(listAgregados.getSelectedValue());
        int auxiliar;
        if (listAgregados.getModel().getSize()-1 > seleccionadoRemover)
        {
            auxiliar = seleccionadoRemover;
            btnConfirmar.setEnabled(true);
            modeloagregados.remove(listAgregados.getSelectedIndex());
            modelocantidades.remove(listCantidades.getSelectedIndex());
            listAgregados.setSelectedIndex(auxiliar);
            listCantidades.setSelectedIndex(auxiliar);
            if (datos.buscarBono_Descuento(singleton.getConnection(), listAgregados.getSelectedValue()).getEsBono() == 1)
            {
                listAgregados.setSelectionBackground(Color.green);
                listCantidades.setSelectionBackground(Color.green);
            }
            else
            {
                listAgregados.setSelectionBackground(Color.orange);
                listCantidades.setSelectionBackground(Color.orange);
            }   
        }
        else
        {
            seleccionadoRemover = seleccionadoCantidades -= 1;
            auxiliar = seleccionadoRemover;
            modeloagregados.remove(listAgregados.getSelectedIndex());
            modelocantidades.remove(listCantidades.getSelectedIndex());
            listAgregados.setSelectedIndex(auxiliar);
            listCantidades.setSelectedIndex(auxiliar);
            if (seleccionadoRemover != -1)
            {
                if (datos.buscarBono_Descuento(singleton.getConnection(), listAgregados.getSelectedValue()).getEsBono() == 1)
                {
                    listAgregados.setSelectionBackground(Color.green);
                    listCantidades.setSelectionBackground(Color.green);
                }
                else
                {
                    listAgregados.setSelectionBackground(Color.orange);
                    listCantidades.setSelectionBackground(Color.orange);
                }
            }
        }
        if (seleccionadoRemover == -1)
        {
            btnConfirmar.setEnabled(false);
            btnRemover.setEnabled(false);
            tfCantidad.setEnabled(false);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed
    
    private void listCantidadesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMouseReleased
        if (evt.getButton() == 1)
            seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMouseReleased

    private void listAgregadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMouseReleased
        if (evt.getButton() == 1)
            seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMouseReleased

    private void listDisponiblesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMousePressed
        if (evt.getButton() == 1)
            seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMousePressed

    private void listDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseClicked
        if (evt.getButton() == 1)
            seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMouseClicked

    private void listDisponiblesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseDragged
        seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMouseDragged

    private void listAgregadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMouseClicked
        if (evt.getButton() == 1)
            seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMouseClicked

    private void listAgregadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMousePressed
        if (evt.getButton() == 1)
            seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMousePressed

    private void listCantidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMouseClicked
        if (evt.getButton() == 1)
            seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMouseClicked

    private void listCantidadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMousePressed
        if (evt.getButton() == 1)
            seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMousePressed

    private void listCantidadesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMouseDragged
        seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMouseDragged

    private void listAgregadosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMouseDragged
        seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMouseDragged

    private void rbConSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConSalarioActionPerformed
        if (rbConSalario.isSelected() && interruptor == false)
        {
            interruptor = true;
            rbSinSalario.setSelected(false);
        }
        if (!rbConSalario.isSelected())
            rbConSalario.setSelected(true);
    }//GEN-LAST:event_rbConSalarioActionPerformed

    private void rbSinSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSinSalarioActionPerformed
        if (rbSinSalario.isSelected() && interruptor == true)
        {
            interruptor = false;
            rbConSalario.setSelected(false);
        }
        if (!rbSinSalario.isSelected())
            rbSinSalario.setSelected(true);
    }//GEN-LAST:event_rbSinSalarioActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        generarDetallesPagos();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void listDisponiblesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponiblesKeyPressed
     
    }//GEN-LAST:event_listDisponiblesKeyPressed

    private void listCantidadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listCantidadesKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_DOWN)
            seleccionarEnListCantidades();
        else if (evt.getKeyCode() == KeyEvent.VK_UP)
            seleccionarEnListCantidades();*/
    }//GEN-LAST:event_listCantidadesKeyPressed

    private void listAgregadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listAgregadosKeyPressed
        /*if (evt.getKeyCode() == KeyEvent.VK_DOWN)
            seleccionarEnListAgregados();
        else if (evt.getKeyCode() == KeyEvent.VK_UP)
            seleccionarEnListAgregados();*/
    }//GEN-LAST:event_listAgregadosKeyPressed

    private void listDisponiblesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponiblesKeyTyped
                 
    }//GEN-LAST:event_listDisponiblesKeyTyped

    private void listDisponiblesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponiblesKeyReleased
        /*if (evt.getKeyCode() == KeyEvent.VK_DOWN)
            seleccionarEnListDisponibles();
        else if (evt.getKeyCode() == KeyEvent.VK_UP)
            seleccionarEnListDisponibles();  */
    }//GEN-LAST:event_listDisponiblesKeyReleased

    private void listDisponiblesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDisponiblesValueChanged
        seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesValueChanged

    private void listCantidadesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCantidadesValueChanged
        seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesValueChanged

    private void listAgregadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listAgregadosValueChanged
        seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosValueChanged

    private void generarDetallesPagos()
    {
        Object O[] = null;
        float total = 0;
        int iterador = 0;
        int k = 0;
        int condicion = modeloagregados.size();
        while (modelotabla.getRowCount() > 0)
            modelotabla.removeRow(0);
        if (rbConSalario.isSelected())
        {
            iterador ++;
            condicion ++;
            modelotabla.addRow(O);
            modelotabla.setValueAt("1", 0, 0);
            modelotabla.setValueAt(dateFormat.format(date) + " , " + hourFormat.format(date), 
                    0, 1);
            modelotabla.setValueAt("Salario ", 0, 2);
            modelotabla.setValueAt(empleado.getSalario(), 0, 3);
            total += Float.parseFloat(String.valueOf(modelotabla.getValueAt(0, 3)));
        }
        for(int i = iterador; i < condicion; i++)
        {
            modelotabla.addRow(O);
            modelotabla.setValueAt(modelocantidades.getElementAt(k), i, 0);
            modelotabla.setValueAt(dateFormat.format(date) + " , " + hourFormat.format(date), i, 1);
            modelotabla.setValueAt("Pago " + modeloagregados.getElementAt(k), i, 2);
            BonosDescuentos monto = datos.buscarBono_Descuento(singleton.getConnection(), 
                    String.valueOf(modeloagregados.elementAt(k)));
            if (monto.getEsPorcentaje() == 0)
            {
                float valorPago = monto.getMonto() * Integer.parseInt(String.valueOf(modelocantidades.getElementAt(k)));
                if (monto.getEsBono() == 1)
                    modelotabla.setValueAt(valorPago, i, 3);
                else
                    modelotabla.setValueAt("-" + valorPago, i, 3);
            }
            else
            {
                float valorPago = ((monto.getMonto()/100)*empleado.getSalario())*
                        Integer.parseInt(String.valueOf(modelocantidades.getElementAt(k)));
                if (monto.getEsBono() == 1)
                    modelotabla.setValueAt(valorPago, i, 3);
                else
                    modelotabla.setValueAt("-" + valorPago, i, 3);
            }
            total += Float.parseFloat(String.valueOf(modelotabla.getValueAt(i, 3)));
            k++;
        }
        modelotabla.addRow(O);
        modelotabla.setValueAt("1", condicion, 0);
        modelotabla.setValueAt(dateFormat.format(date) + " , " + hourFormat.format(date), 
                 condicion, 1);
        modelotabla.setValueAt("Total ", condicion, 2);
        modelotabla.setValueAt(total, condicion, 3);
        
        
    }
    
    private void seleccionarEnListDisponibles()
    {
        seleccionadoAgregar = listDisponibles.getSelectedIndex();
        if (seleccionadoAgregar >= 0)
        {
            btnAgregar.setEnabled(true);
            if (datos.buscarBono_Descuento(singleton.getConnection(), listDisponibles.getSelectedValue()).getEsBono() == 1)
                listDisponibles.setSelectionBackground(Color.green);
            else
                listDisponibles.setSelectionBackground(Color.orange);    
        }        
    }
    
    private void seleccionarEnListAgregados()
    {
        seleccionadoCantidades = seleccionadoRemover = listAgregados.getSelectedIndex();
        if (seleccionadoRemover >= 0)
        {
            listCantidades.setSelectedIndex(listAgregados.getSelectedIndex());
            btnRemover.setEnabled(true);
            tfCantidad.setEnabled(true);
            if (datos.buscarBono_Descuento(singleton.getConnection(), listAgregados.getSelectedValue()).getEsBono() == 1)
            {
                listAgregados.setSelectionBackground(Color.green);
                listCantidades.setSelectionBackground(Color.green);
            }

            else
            {
                listAgregados.setSelectionBackground(Color.orange);    
                listCantidades.setSelectionBackground(Color.orange);
            }
        }
    }
    
    private void seleccionarEnListCantidades()
    {
        seleccionadoRemover = seleccionadoCantidades = listCantidades.getSelectedIndex();
        if (seleccionadoCantidades >= 0)
        {
            listAgregados.setSelectedIndex(listCantidades.getSelectedIndex());
            btnRemover.setEnabled(true);
            tfCantidad.setEnabled(true);
            if (datos.buscarBono_Descuento(singleton.getConnection(), listAgregados.getSelectedValue()).getEsBono() == 1)
            {
                listCantidades.setSelectionBackground(Color.green);
                listAgregados.setSelectionBackground(Color.green);
            }

            else
            {
                listCantidades.setSelectionBackground(Color.orange);
                listAgregados.setSelectionBackground(Color.orange);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPabe1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblColorRojo;
    private javax.swing.JLabel lblColorVerde;
    private javax.swing.JLabel lblEmpleado;
    private javax.swing.JList<String> listAgregados;
    private javax.swing.JList<String> listCantidades;
    private javax.swing.JList<String> listDisponibles;
    private javax.swing.JRadioButton rbConSalario;
    private javax.swing.JRadioButton rbSinSalario;
    private javax.swing.JTable tPagos;
    private javax.swing.JTextField tfCantidad;
    // End of variables declaration//GEN-END:variables
}
