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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
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
public class PagarEmpleados extends javax.swing.JPanel {
    Empleados empleado;//Variable que retiene los datos traspasados del empleado desde el form de empleados
    Bonos_Descuentos datos = new Bonos_Descuentos();//Variable que permite la búsqueda de bonos y descuentos
    DefaultListModel modeloagregar = new DefaultListModel();//Modelo para agregar bonos/descuentos
    DefaultListModel modeloagregados = new DefaultListModel();//Modelo para retener los bonos/descuentos agregados
    DefaultListModel modelocantidades = new DefaultListModel();//Modelo para retener la cantidad de bonos/descuentos agregados
    DefaultTableModel modelotabla = new DefaultTableModel();//Modelo final para generar los detalles del pago a realizar
    boolean interruptor = true;//Booleano para saber si un radiobutton u otro está activado
    int seleccionadoAgregar = 0;//Entero para controlar la fila seleccionada de la lista de bonos/descuentos por agregar
    int seleccionadoRemover = 0;//Entero para controlar la fila seleccionada de la lista de bonos/descuentos agregados
    int seleccionadoCantidades = 0;//Entero para controlar la fila seleccionada de la lista de bonos/descuentos agregados (pero sus cantidades)
    //Retención de los datos del empleado seleccionado en el form de empleados, y control de comportamiento de los componentes al ingresar al panel,
    //así como el cargado de datos
    public PagarEmpleados(Empleados empleado) {
        initComponents();
        this.empleado = empleado;
        lblEmpleado.setText("Empleado: " + empleado.getNombre() + " " + empleado.getApellido());
        btnAgregar.setEnabled(false);
        btnRemover.setEnabled(false);
        btnConfirmar.setEnabled(true);
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
    //Cargar datos al principio, para agregar bonos/descuentos
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
        btnHistorial = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(36, 41, 46));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 91, 299, 192));

        btnAgregar.setBackground(new java.awt.Color(0, 136, 204));
        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar >>>");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 143, 147, -1));

        btnRemover.setBackground(new java.awt.Color(0, 136, 204));
        btnRemover.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRemover.setForeground(new java.awt.Color(255, 255, 255));
        btnRemover.setText("Remover <<<");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(btnRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(409, 208, -1, -1));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 91, 299, 192));

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

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 91, 52, 192));

        tfCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCantidadKeyTyped(evt);
            }
        });
        jPanel1.add(tfCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 347, 120, -1));

        lblCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setText("Cantidad:");
        jPanel1.add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(601, 310, 112, -1));

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

        jPanel1.add(jScrollPabe1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 413, 649, 109));

        btnPagar.setBackground(new java.awt.Color(0, 136, 204));
        btnPagar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setText("Pagar");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        jPanel1.add(btnPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 470, 109, -1));

        lblEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblEmpleado.setText("Empleado: ");
        jPanel1.add(lblEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 600, -1));

        btnConfirmar.setBackground(new java.awt.Color(0, 136, 204));
        btnConfirmar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, -1, -1));

        lblColorRojo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorRojo.setForeground(new java.awt.Color(255, 255, 255));
        lblColorRojo.setText("Naranja: Descuentos");
        jPanel1.add(lblColorRojo, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 338, 239, 31));

        lblColorVerde.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblColorVerde.setForeground(new java.awt.Color(255, 255, 255));
        lblColorVerde.setText("Verde: Bonos");
        jPanel1.add(lblColorVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 301, 239, 31));

        rbConSalario.setBackground(new java.awt.Color(36, 41, 46));
        rbConSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbConSalario.setForeground(new java.awt.Color(255, 255, 255));
        rbConSalario.setText("Con salario");
        rbConSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbConSalarioActionPerformed(evt);
            }
        });
        jPanel1.add(rbConSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 306, 130, -1));

        rbSinSalario.setBackground(new java.awt.Color(36, 41, 46));
        rbSinSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbSinSalario.setForeground(new java.awt.Color(255, 255, 255));
        rbSinSalario.setText("Sin salario");
        rbSinSalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSinSalarioActionPerformed(evt);
            }
        });
        jPanel1.add(rbSinSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(745, 346, 130, -1));

        btnHistorial.setBackground(new java.awt.Color(0, 136, 204));
        btnHistorial.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("Mostrar historial de empleado");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Back.png"))); // NOI18N
        btnRegresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Back2.png"))); // NOI18N
        btnRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Back1.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

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
    //Validar ingreso de cantidades a un bono/descuento al ser seleccionado, y modificar la cantidad al hacer enter
    private void tfCantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCantidadKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER && !tfCantidad.getText().equals(""))
        {
            modelocantidades.setElementAt(tfCantidad.getText(), seleccionadoCantidades);
            tfCantidad.setText("");
        }
            
    }//GEN-LAST:event_tfCantidadKeyPressed
    //Validación de un máximo de 6 caracteres para el ingreso de cantidad de un bono/descuento, con los dígitos validados
    private void tfCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCantidadKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();
        if (tfCantidad.getText().length() == 0 && c == '0')
            evt.consume();
        if (tfCantidad.getText().length() > 6) evt.consume();
    }//GEN-LAST:event_tfCantidadKeyTyped

    private void tPagosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPagosMouseReleased

    }//GEN-LAST:event_tPagosMouseReleased
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listDisponiblesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseReleased
        if (evt.getButton() == 1)
            seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMouseReleased
    //Agregar un bono/descuento para ser tomado en cuenta en los detalles del pago
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        limpiarTabla();
        btnConfirmar.setEnabled(true);
        btnPagar.setEnabled(false);
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
    //Quitar un bono/descuento a tomar en cuenta en los detalles de pago
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        limpiarTabla();
        btnPagar.setEnabled(false);
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
            if (!rbConSalario.isSelected())
                btnConfirmar.setEnabled(false);
            btnRemover.setEnabled(false);
            tfCantidad.setEnabled(false);
        }
    }//GEN-LAST:event_btnRemoverActionPerformed
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listCantidadesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMouseReleased
        if (evt.getButton() == 1)
            seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMouseReleased
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listAgregadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMouseReleased
        if (evt.getButton() == 1)
            seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMouseReleased
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listDisponiblesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMousePressed
        if (evt.getButton() == 1)
            seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMousePressed
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseClicked
        if (evt.getButton() == 1)
            seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMouseClicked
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listDisponiblesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listDisponiblesMouseDragged
        seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesMouseDragged
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listAgregadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMouseClicked
        if (evt.getButton() == 1)
            seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMouseClicked
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listAgregadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMousePressed
        if (evt.getButton() == 1)
            seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMousePressed
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listCantidadesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMouseClicked
        if (evt.getButton() == 1)
            seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMouseClicked
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listCantidadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMousePressed
        if (evt.getButton() == 1)
            seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMousePressed
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listCantidadesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listCantidadesMouseDragged
        seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesMouseDragged
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listAgregadosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listAgregadosMouseDragged
        seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosMouseDragged
    //Validar que se accione sólo el radiobutton de pago con salario
    private void rbConSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbConSalarioActionPerformed
        if (rbConSalario.isSelected() && interruptor == false)
        {
            interruptor = true;
            rbSinSalario.setSelected(false);
            btnConfirmar.setEnabled(true);
            btnPagar.setEnabled(false);
            limpiarTabla();
        }
        if (!rbConSalario.isSelected())
            rbConSalario.setSelected(true);
    }//GEN-LAST:event_rbConSalarioActionPerformed
    //Validar que se accione sólo el radiobutton de pago sin salario
    private void rbSinSalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSinSalarioActionPerformed
        if (rbSinSalario.isSelected() && interruptor == true)
        {
            interruptor = false;
            rbConSalario.setSelected(false);
            btnPagar.setEnabled(false);
            if (modeloagregados.isEmpty())
                btnConfirmar.setEnabled(false);
            limpiarTabla();
        }
        if (!rbSinSalario.isSelected())
            rbSinSalario.setSelected(true);
    }//GEN-LAST:event_rbSinSalarioActionPerformed
    //Botón para confirmar por primera vez el pago a realizar
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        generarDetallesPagos();
        btnPagar.setEnabled(true);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void listDisponiblesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponiblesKeyPressed
     
    }//GEN-LAST:event_listDisponiblesKeyPressed
    //Limpiar la tabla de detalles de pago
    private void limpiarTabla()
    {
        while (modelotabla.getRowCount() > 0)
            modelotabla.removeRow(0);
    }
    private void listCantidadesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listCantidadesKeyPressed

    }//GEN-LAST:event_listCantidadesKeyPressed

    private void listAgregadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listAgregadosKeyPressed

    }//GEN-LAST:event_listAgregadosKeyPressed

    private void listDisponiblesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponiblesKeyTyped
                 
    }//GEN-LAST:event_listDisponiblesKeyTyped

    private void listDisponiblesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponiblesKeyReleased

    }//GEN-LAST:event_listDisponiblesKeyReleased
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listDisponiblesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDisponiblesValueChanged
        seleccionarEnListDisponibles();
    }//GEN-LAST:event_listDisponiblesValueChanged
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listCantidadesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCantidadesValueChanged
        seleccionarEnListCantidades();
    }//GEN-LAST:event_listCantidadesValueChanged
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
    private void listAgregadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listAgregadosValueChanged
        seleccionarEnListAgregados();
    }//GEN-LAST:event_listAgregadosValueChanged
    //Confirmar por segunda vez y de forma definitiva el pago al empleado
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Efectuar pago?", "Aviso",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            PagosEmpleados generarpago = new PagosEmpleados();
            DetallePagosEmpleados generardetalles = new DetallePagosEmpleados();
            Bonos_Descuentos bd = new Bonos_Descuentos();
            LocalDateTime horayfechaActual = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            Pagos pago;
            pago = new Pagos();
            pago.setFechaHora(Date.from(horayfechaActual.atZone(ZoneId.systemDefault()).toInstant()));
            pago.setEmpleadosId(empleado);
            pago.setMonto(Float.parseFloat(String.valueOf(tPagos.getValueAt(modelotabla.getRowCount()-1, 3))));
            generarpago.registrarObject(pago, singleton.getConnection());
            for (int i = 0; i < modelotabla.getRowCount()-1; i++)
            {
                Detallepagos detalle = new Detallepagos();
                detalle.setCantidad(Integer.parseInt(String.valueOf(tPagos.getValueAt(i, 0))));
                BonosDescuentos bonodescuento = bd.buscarBono_Descuento(singleton.getConnection(), String.valueOf(tPagos.getValueAt(i, 2)).substring(5));
                detalle.setBonosDescuentosId(bonodescuento);
                detalle.setMonto(Float.parseFloat(String.valueOf(tPagos.getValueAt(i, 3))));
                detalle.setPagosId(pago);
                detalle.setDescripcion(String.valueOf(tPagos.getValueAt(i, 2)));
                generardetalles.registrarObject(detalle, singleton.getConnection());
            }
            JOptionPane.showMessageDialog(null, "Pago efectuado de manera exitosa");
            limpiarTabla();
            seleccionadoAgregar = seleccionadoRemover = seleccionadoCantidades = -1;
            btnPagar.setEnabled(false);
            if (!rbConSalario.isSelected()) {
                btnConfirmar.setEnabled(false);
            }
            while (modeloagregados.size() > 0) {
                modeloagregados.remove(0);
                modelocantidades.remove(0);
            }
            while (modeloagregar.size() > 0) {
                modeloagregar.remove(0);
            }
            inicializarDatosAgregar();
            btnAgregar.setEnabled(false);
            btnRemover.setEnabled(false);
        }
    }//GEN-LAST:event_btnPagarActionPerformed
    //Ingresar al historial de pagos del empleado
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        HistorialPagos agregar  = new HistorialPagos(empleado);
        agregar.setSize(1010,600);
        agregar.setLocation(0, 0);
        this.removeAll();
        this.add(agregar,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();        
    }//GEN-LAST:event_btnHistorialActionPerformed
    //Regresar al form de empleados
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FormEmpleados empleados = new FormEmpleados();
        empleados.setSize(1010,600);
        empleados.setLocation(0, 0);
        this.removeAll();
        this.add(empleados,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed
    //Generar los detalles de pagos del empleado
    private void generarDetallesPagos()
    {
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
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
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
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
    //Validación para identificar si el bono/descuento seleccionado es bono o es descuento
    //Verde = bono
    //Anaranjado = descuento
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
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnRegresar;
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
