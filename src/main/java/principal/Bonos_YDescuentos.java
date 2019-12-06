/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import entidades.BonosDescuentos;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import recursoshumanos.Bonos_Descuentos;
import singleton.singleton;

/**
 *
 * @author User
 */
public class Bonos_YDescuentos extends javax.swing.JPanel {
    DefaultTableModel bonos_ydescuentos = new DefaultTableModel();//Modelo para la tabla de bonos/descuentos
    Bonos_Descuentos bonosdescuentos = new Bonos_Descuentos();//Variable para efectuar operaciones de ingreso, modificación, descontinuación/continuación y búsqueda
    int descontinuado = 0; // Variable para indicar si un bono está descontinuado o no
    BonosDescuentos dato; // Variable de tipo BonoDescuento para obtener sus datos al ser seleccionado en la tabla
    boolean continuado = true; // Booleano para indicar si un bono/descuento está en uso todavía o ya no
    public Bonos_YDescuentos() {
        //Asignar columnas a la tabla de bonos/descuentos, y cargar sus datos en esta misma
        initComponents();
        bonos_ydescuentos.addColumn("Descripción");
        bonos_ydescuentos.addColumn("Monto/Porcentaje");
        bonos_ydescuentos.addColumn("Bono/Descuento");
        bonos_ydescuentos.addColumn("Tipo de dato");
        tBonos_Descuentos.setModel(bonos_ydescuentos);
        rbContinuados.setSelected(true);
        limpiarComponentes();
        cargarBonos_Descuentos(descontinuado, "");
        inicializarListenerBonosDescuentos();
    }
    
    public void inicializarListenerBonosDescuentos() {
        tBonos_Descuentos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    dato = bonosdescuentos.buscarBono_Descuento(singleton.getConnection(),
                            String.valueOf(tBonos_Descuentos.getValueAt(tBonos_Descuentos.getSelectedRow(), 0)));
                    tfMBono_Descuento.setEnabled(true);
                    tfMMonto_Porcentaje.setEnabled(true);
                    rbMBono.setEnabled(true);
                    rbMDescuento.setEnabled(true);
                    rbMMonto.setEnabled(true);
                    rbMPorcentaje.setEnabled(true);
                    rbMContinuar.setEnabled(true);
                    btnModBono_Descuento.setEnabled(true);
                    tfMBono_Descuento.setText(dato.getDescripción());
                    tfMMonto_Porcentaje.setText(dato.getMonto().toString());
                    if (dato.getEsBono() == 0) {
                        rbMDescuento.setSelected(true);
                        rbMBono.setSelected(false);
                    } else {
                        rbMDescuento.setSelected(false);
                        rbMBono.setSelected(true);
                    }
                    if (dato.getEsPorcentaje() == 0) {
                        rbMMonto.setSelected(true);
                        rbMPorcentaje.setSelected(false);
                    } else {
                        rbMMonto.setSelected(false);
                        rbMPorcentaje.setSelected(true);
                    }
                    if (dato.getDescontinuado() == 0) {
                        rbMContinuar.setText("Descontinuar");
                    } else {
                        rbMContinuar.setText("Continuar");
                    }
                    tfMBono_Descuento.requestFocus();
                }
            }
        });
    }
    
    
    
    //Cargar bonos/descuentos en la tabla de bonos/descuentos, ya sea con el filtro o sin este
    private void cargarBonos_Descuentos(int descontinuado, String contenido)
    {
        int fila = 0;
        try{
            Object O[] = null;
            List<entidades.BonosDescuentos> lista = bonosdescuentos.buscarObjects(contenido, singleton.getConnection());
            for(int i = 0; i < lista.size(); i++)
            {
                if(lista.get(i).getDescontinuado() == descontinuado)
                {
                    bonos_ydescuentos.addRow(O);
                    bonos_ydescuentos.setValueAt(lista.get(i).getDescripción(), fila, 0);
                    bonos_ydescuentos.setValueAt(lista.get(i).getMonto(), fila, 1);
                    if (lista.get(i).getEsBono() == 0)
                        bonos_ydescuentos.setValueAt("Descuento", fila, 2);
                    else
                        bonos_ydescuentos.setValueAt("Bono", fila, 2);
                    
                    if (lista.get(i).getEsPorcentaje() == 0)
                        bonos_ydescuentos.setValueAt("Monto", fila, 3);
                    else
                        bonos_ydescuentos.setValueAt("Porcentaje", fila, 3);
                    fila ++;
                }
            }
            tBonos_Descuentos.setModel(bonos_ydescuentos);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //Limpiar tabla de bonos/descuentos
    private void limpiarTabla()
    {
        while (bonos_ydescuentos.getRowCount() > 0)
            bonos_ydescuentos.removeRow(0);
    }
    //Validaciones para evitar que botones sigan activos cuando añadió, modificó, descontinuó, buscó, o continuó un bono/descuento, al igual
    //que validaciones de las cajas de texto
    private void limpiarComponentes()
    {
        limpiarTabla();
        tfMBono_Descuento.setEnabled(false);
        tfMMonto_Porcentaje.setEnabled(false);
        rbMBono.setEnabled(false);
        rbMPorcentaje.setEnabled(false);
        rbMMonto.setEnabled(false);
        rbMDescuento.setEnabled(false);
        rbMContinuar.setEnabled(false);
        tfMBono_Descuento.setText("");
        tfMMonto_Porcentaje.setText("");
        rbMBono.setSelected(false);
        rbMPorcentaje.setSelected(false);
        rbMMonto.setSelected(false);
        rbMDescuento.setSelected(false);
        rbMContinuar.setSelected(false);
        btnModBono_Descuento.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblBusqBono_Descuento = new javax.swing.JLabel();
        jScrollPabe1 = new javax.swing.JScrollPane();
        tBonos_Descuentos = new javax.swing.JTable();
        tfFiltro = new javax.swing.JTextField();
        btnModBono_Descuento = new javax.swing.JButton();
        lblMBono_Descuento = new javax.swing.JLabel();
        tfMBono_Descuento = new javax.swing.JTextField();
        lblMMonto_Porcentaje = new javax.swing.JLabel();
        tfMMonto_Porcentaje = new javax.swing.JTextField();
        rbMBono = new javax.swing.JRadioButton();
        rbContinuados = new javax.swing.JRadioButton();
        rbMDescuento = new javax.swing.JRadioButton();
        rbDescontinuados = new javax.swing.JRadioButton();
        rbMMonto = new javax.swing.JRadioButton();
        rbMPorcentaje = new javax.swing.JRadioButton();
        rbMContinuar = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        btnAgregarBono_Descuento = new javax.swing.JButton();
        lblAgregarBono_Descuento = new javax.swing.JLabel();
        lblNombreBono_Descuento = new javax.swing.JLabel();
        tfNombreBono_Descuento = new javax.swing.JTextField();
        tfMonto_Porcentaje = new javax.swing.JTextField();
        lblMonto_Porcentaje = new javax.swing.JLabel();
        rbBono = new javax.swing.JRadioButton();
        rbDescuento = new javax.swing.JRadioButton();
        rbMonto = new javax.swing.JRadioButton();
        rbPorcentaje = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(36, 41, 46));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(36, 41, 46));

        lblBusqBono_Descuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBusqBono_Descuento.setForeground(new java.awt.Color(255, 255, 255));
        lblBusqBono_Descuento.setText("Bonos:");

        tBonos_Descuentos = new javax.swing.JTable(){ public boolean isCellEditable(int rowIndex, int colIndex){     return false;     } };
        tBonos_Descuentos.setModel(new javax.swing.table.DefaultTableModel(
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
        tBonos_Descuentos.setFocusable(false);
        tBonos_Descuentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tBonos_DescuentosMouseReleased(evt);
            }
        });
        jScrollPabe1.setViewportView(tBonos_Descuentos);

        tfFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFiltroKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFiltroKeyTyped(evt);
            }
        });

        btnModBono_Descuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificarp.png"))); // NOI18N
        btnModBono_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModBono_DescuentoActionPerformed(evt);
            }
        });

        lblMBono_Descuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMBono_Descuento.setForeground(new java.awt.Color(255, 255, 255));
        lblMBono_Descuento.setText("Nombre del bono/descuento:");

        tfMBono_Descuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMBono_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMBono_DescuentoActionPerformed(evt);
            }
        });
        tfMBono_Descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMBono_DescuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMBono_DescuentoKeyTyped(evt);
            }
        });

        lblMMonto_Porcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMMonto_Porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMMonto_Porcentaje.setText("Monto/Porcentaje:");

        tfMMonto_Porcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMMonto_Porcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMMonto_PorcentajeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMMonto_PorcentajeKeyTyped(evt);
            }
        });

        rbMBono.setBackground(new java.awt.Color(36, 41, 46));
        rbMBono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMBono.setForeground(new java.awt.Color(255, 255, 255));
        rbMBono.setText("Bono");
        rbMBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMBonoActionPerformed(evt);
            }
        });

        rbContinuados.setBackground(new java.awt.Color(36, 41, 46));
        rbContinuados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbContinuados.setForeground(new java.awt.Color(255, 255, 255));
        rbContinuados.setText("Continuados");
        rbContinuados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbContinuadosActionPerformed(evt);
            }
        });

        rbMDescuento.setBackground(new java.awt.Color(36, 41, 46));
        rbMDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMDescuento.setForeground(new java.awt.Color(255, 255, 255));
        rbMDescuento.setText("Descuento");
        rbMDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMDescuentoActionPerformed(evt);
            }
        });

        rbDescontinuados.setBackground(new java.awt.Color(36, 41, 46));
        rbDescontinuados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbDescontinuados.setForeground(new java.awt.Color(255, 255, 255));
        rbDescontinuados.setText("Descontinuados");
        rbDescontinuados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDescontinuadosActionPerformed(evt);
            }
        });

        rbMMonto.setBackground(new java.awt.Color(36, 41, 46));
        rbMMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMMonto.setForeground(new java.awt.Color(255, 255, 255));
        rbMMonto.setText("Monto");
        rbMMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMMontoActionPerformed(evt);
            }
        });

        rbMPorcentaje.setBackground(new java.awt.Color(36, 41, 46));
        rbMPorcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMPorcentaje.setForeground(new java.awt.Color(255, 255, 255));
        rbMPorcentaje.setText("Porcentaje");
        rbMPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMPorcentajeActionPerformed(evt);
            }
        });

        rbMContinuar.setBackground(new java.awt.Color(36, 41, 46));
        rbMContinuar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMContinuar.setForeground(new java.awt.Color(255, 255, 255));
        rbMContinuar.setText("Continuar");
        rbMContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBusqBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(rbContinuados, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbDescontinuados))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPabe1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMBono_Descuento)
                                    .addComponent(tfMBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblMMonto_Porcentaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfMMonto_Porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbMBono, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbMDescuento))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbMMonto)
                                    .addComponent(rbMPorcentaje))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbMContinuar)
                            .addComponent(btnModBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblBusqBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbContinuados)
                    .addComponent(rbDescontinuados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnModBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbMContinuar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPabe1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMMonto_Porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfMBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfMMonto_Porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbMBono)
                                    .addComponent(rbMMonto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbMPorcentaje)
                                    .addComponent(rbMDescuento))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 56, -1, 250));

        jPanel3.setBackground(new java.awt.Color(36, 41, 46));

        btnAgregarBono_Descuento.setForeground(new java.awt.Color(240, 240, 240));
        btnAgregarBono_Descuento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregarp.png"))); // NOI18N
        btnAgregarBono_Descuento.setBorder(null);
        btnAgregarBono_Descuento.setBorderPainted(false);
        btnAgregarBono_Descuento.setContentAreaFilled(false);
        btnAgregarBono_Descuento.setFocusPainted(false);
        btnAgregarBono_Descuento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarBono_Descuento.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregarBono_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarBono_DescuentoActionPerformed(evt);
            }
        });

        lblAgregarBono_Descuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAgregarBono_Descuento.setForeground(new java.awt.Color(255, 255, 255));
        lblAgregarBono_Descuento.setText("Agregar bono/descuento:");

        lblNombreBono_Descuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreBono_Descuento.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreBono_Descuento.setText("Nombre del bono/descuento:");

        tfNombreBono_Descuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNombreBono_Descuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreBono_DescuentoActionPerformed(evt);
            }
        });
        tfNombreBono_Descuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNombreBono_DescuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreBono_DescuentoKeyTyped(evt);
            }
        });

        tfMonto_Porcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMonto_Porcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMonto_PorcentajeActionPerformed(evt);
            }
        });
        tfMonto_Porcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMonto_PorcentajeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMonto_PorcentajeKeyTyped(evt);
            }
        });

        lblMonto_Porcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMonto_Porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        lblMonto_Porcentaje.setText("Monto/Porcentaje:");

        rbBono.setBackground(new java.awt.Color(36, 41, 46));
        rbBono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbBono.setForeground(new java.awt.Color(255, 255, 255));
        rbBono.setText("Bono");
        rbBono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbBonoActionPerformed(evt);
            }
        });

        rbDescuento.setBackground(new java.awt.Color(36, 41, 46));
        rbDescuento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbDescuento.setForeground(new java.awt.Color(255, 255, 255));
        rbDescuento.setText("Descuento");
        rbDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbDescuentoActionPerformed(evt);
            }
        });

        rbMonto.setBackground(new java.awt.Color(36, 41, 46));
        rbMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMonto.setForeground(new java.awt.Color(255, 255, 255));
        rbMonto.setText("Monto");
        rbMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMontoActionPerformed(evt);
            }
        });

        rbPorcentaje.setBackground(new java.awt.Color(36, 41, 46));
        rbPorcentaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbPorcentaje.setForeground(new java.awt.Color(255, 255, 255));
        rbPorcentaje.setText("Porcentaje");
        rbPorcentaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPorcentajeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNombreBono_Descuento)
                    .addComponent(tfNombreBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMonto_Porcentaje)
                    .addComponent(tfMonto_Porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAgregarBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbDescuento)
                            .addComponent(rbMonto)
                            .addComponent(rbPorcentaje))
                        .addGap(58, 58, 58)
                        .addComponent(btnAgregarBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rbBono, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAgregarBono_Descuento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblAgregarBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNombreBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfNombreBono_Descuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblMonto_Porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbMonto)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(rbBono)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbDescuento)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMonto_Porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbPorcentaje)))))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 335, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 312, 894, 10));

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
    //Obtener datos de un bono/descuento seleccionado
    private void tBonos_DescuentosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tBonos_DescuentosMouseReleased
        
        
    }//GEN-LAST:event_tBonos_DescuentosMouseReleased

    private void tfFiltroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroKeyPressed

    }//GEN-LAST:event_tfFiltroKeyPressed
    //Filtro de bonos/descuentos accionado
    private void tfFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroKeyReleased
        limpiarComponentes();
        cargarBonos_Descuentos(descontinuado, tfFiltro.getText());
    }//GEN-LAST:event_tfFiltroKeyReleased
    //Validación de un máximo de 30 caracteres en el filtro de bonos/descuentos
    private void tfFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroKeyTyped
        if (tfFiltro.getText().length() > 30) evt.consume();
    }//GEN-LAST:event_tfFiltroKeyTyped
    //Modificación de un bono/descuento
    private void btnModBono_DescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModBono_DescuentoActionPerformed
        modificarBonoDescuento();
    }//GEN-LAST:event_btnModBono_DescuentoActionPerformed

    private void modificarBonoDescuento()
    {
        if (!tfMBono_Descuento.getText().equals("") && !tfMMonto_Porcentaje.getText().equals("") &&
            (rbMMonto.isSelected() || rbMPorcentaje.isSelected()) && (rbMBono.isSelected() || rbMDescuento.isSelected()))
        {
            tfFiltro.setText("");
            dato.setDescripción(tfMBono_Descuento.getText());
            dato.setMonto(Float.valueOf(tfMMonto_Porcentaje.getText()));
            if (rbMMonto.isSelected())
                dato.setEsPorcentaje((short)0);
            else
                dato.setEsPorcentaje((short)1);
            if (rbMBono.isSelected())
                dato.setEsBono((short)1);
            else
                dato.setEsBono((short)0);
            if (rbMContinuar.isSelected())
            {
                if (dato.getDescontinuado() == 0)
                    dato.setDescontinuado((short)1);
                else
                    dato.setDescontinuado((short)0);
            }
            bonosdescuentos.editarObject(dato, singleton.getConnection());
            limpiarComponentes();
            JOptionPane.showMessageDialog(null, "Datos modificados con éxito");
            cargarBonos_Descuentos(descontinuado, "");
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos solicitados de modificación");
    }
    
    private void tfMBono_DescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMBono_DescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMBono_DescuentoActionPerformed

    private void tfMBono_DescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMBono_DescuentoKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode()==KeyEvent.VK_DOWN) tfMMonto_Porcentaje.requestFocus();
    }//GEN-LAST:event_tfMBono_DescuentoKeyPressed
    //Validación de un máximo de caracteres de 50 para modificar un bono/descuento
    private void tfMBono_DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMBono_DescuentoKeyTyped
        if (tfMBono_Descuento.getText().length() > 50) evt.consume();
    }//GEN-LAST:event_tfMBono_DescuentoKeyTyped

    private void tfMMonto_PorcentajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMMonto_PorcentajeKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) modificarBonoDescuento();
    }//GEN-LAST:event_tfMMonto_PorcentajeKeyPressed
    //Validación de un máximo de 6 dígitos (también validados) al ingresar un monto o porcentaje
    private void tfMMonto_PorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMMonto_PorcentajeKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
        {
            if (c != '.')
                evt.consume();
        }
        if (tfMMonto_Porcentaje.getText().length() > 6) evt.consume();
    }//GEN-LAST:event_tfMMonto_PorcentajeKeyTyped
    //Validar que se accione sólo el radiobutton de bono (modificación)
    private void rbMBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMBonoActionPerformed
        if (rbMBono.isSelected())
            rbMDescuento.setSelected(false);
        if (!rbMBono.isSelected())
            rbMBono.setSelected(true);
    }//GEN-LAST:event_rbMBonoActionPerformed
    //Validar que se accione sólo el radiobutton de continuados (al añadir)
    private void rbContinuadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbContinuadosActionPerformed
        if (rbContinuados.isSelected() && continuado == false)
        {
            limpiarComponentes();
            rbDescontinuados.setSelected(false);
            continuado = true;
            descontinuado = 0;
            tfFiltro.setText("");
            cargarBonos_Descuentos(descontinuado, "");
        }
        if (!rbContinuados.isSelected())
            rbContinuados.setSelected(true);
    }//GEN-LAST:event_rbContinuadosActionPerformed
    //Validar que se accione sólo el radiobutton de descuentos (modificación)
    private void rbMDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMDescuentoActionPerformed
        if (rbMDescuento.isSelected())
            rbMBono.setSelected(false);
        if (!rbMDescuento.isSelected())
            rbMDescuento.setSelected(true);
    }//GEN-LAST:event_rbMDescuentoActionPerformed
    //Validar que se accione sólo el radiobutton de descontinuados (al añadir)
    private void rbDescontinuadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDescontinuadosActionPerformed
        if (rbDescontinuados.isSelected() && continuado == true)
        {
            limpiarComponentes();
            rbContinuados.setSelected(false);
            continuado = false;
            descontinuado = 1;
            tfFiltro.setText("");
            cargarBonos_Descuentos(descontinuado, "");
        }
        if (!rbDescontinuados.isSelected())
            rbDescontinuados.setSelected(true);
    }//GEN-LAST:event_rbDescontinuadosActionPerformed
    //Validar que se accione sólo el radiobutton de monto (modificación)
    private void rbMMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMMontoActionPerformed
        if (rbMMonto.isSelected())
            rbMPorcentaje.setSelected(false);
        if (!rbMMonto.isSelected())
            rbMMonto.setSelected(true);
    }//GEN-LAST:event_rbMMontoActionPerformed
    //Validar que se accione sólo el radiobutton de porcentaje (modificación)
    private void rbMPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMPorcentajeActionPerformed
        if (rbMPorcentaje.isSelected())
            rbMMonto.setSelected(false);
        if (!rbMPorcentaje.isSelected())
            rbMPorcentaje.setSelected(true);
    }//GEN-LAST:event_rbMPorcentajeActionPerformed
    //Validar que se accione sólo el radiobutton de continuados (modificación)
    private void rbMContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMContinuarActionPerformed
        
    }//GEN-LAST:event_rbMContinuarActionPerformed
    //Añadir un bono/descuento
    private void btnAgregarBono_DescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarBono_DescuentoActionPerformed
        if (!tfNombreBono_Descuento.getText().equals("") && !tfMonto_Porcentaje.getText().equals("") &&
            (rbMonto.isSelected() || rbPorcentaje.isSelected()) && (rbBono.isSelected() || rbDescuento.isSelected()))
        {
            if (bonosdescuentos.buscarBono_Descuento(singleton.getConnection(), tfNombreBono_Descuento.getText()) == null)
            {
                BonosDescuentos dato = new BonosDescuentos();
                dato.setDescripción(tfNombreBono_Descuento.getText());
                dato.setMonto(Float.valueOf(tfMonto_Porcentaje.getText()));
                dato.setDescontinuado((short)0);
                if (rbMonto.isSelected())
                    dato.setEsPorcentaje((short)0);
                else
                    dato.setEsPorcentaje((short)1);
                if (rbBono.isSelected())
                    dato.setEsBono((short)1);
                else
                    dato.setEsBono((short)0);
                bonosdescuentos.registrarObject(dato, singleton.getConnection());
                limpiarComponentes();
                tfFiltro.setText("");
                JOptionPane.showMessageDialog(null, "Datos agregados con éxito");
                tfNombreBono_Descuento.setText("");
                tfMonto_Porcentaje.setText("");
                rbMonto.setSelected(false);
                rbPorcentaje.setSelected(false);
                rbBono.setSelected(false);
                rbDescuento.setSelected(false);
                cargarBonos_Descuentos(descontinuado, "");
            }
            else
                JOptionPane.showMessageDialog(null, "El nombre del bono/descuento ingresado ya existe");
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos solicitados");
    }//GEN-LAST:event_btnAgregarBono_DescuentoActionPerformed

    private void tfNombreBono_DescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreBono_DescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreBono_DescuentoActionPerformed

    private void tfNombreBono_DescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreBono_DescuentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreBono_DescuentoKeyPressed
    //Validación de escritura de bono/descuento a un máximo de 50 caracteres (al añadir)
    private void tfNombreBono_DescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreBono_DescuentoKeyTyped
        if (tfNombreBono_Descuento.getText().length() > 50) evt.consume();
    }//GEN-LAST:event_tfNombreBono_DescuentoKeyTyped

    private void tfMonto_PorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMonto_PorcentajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMonto_PorcentajeActionPerformed

    private void tfMonto_PorcentajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMonto_PorcentajeKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMonto_PorcentajeKeyPressed
    //Validación de escritura de dígitos (también validados) de un monto o porcentaje
    private void tfMonto_PorcentajeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMonto_PorcentajeKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
        {
            if (c != '.')
                evt.consume();
        }
        if (tfMonto_Porcentaje.getText().length() > 6) evt.consume();
    }//GEN-LAST:event_tfMonto_PorcentajeKeyTyped
    //Validar que se accione sólo el radiobutton de bono (al añadir)
    private void rbBonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbBonoActionPerformed
        if (rbBono.isSelected())
        rbDescuento.setSelected(false);
        if (!rbBono.isSelected())
        rbBono.setSelected(true);
    }//GEN-LAST:event_rbBonoActionPerformed
    //Validar que se accione sólo el radiobutton de descuento (al añadir)
    private void rbDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbDescuentoActionPerformed
        if (rbDescuento.isSelected())
        rbBono.setSelected(false);
        if (!rbDescuento.isSelected())
        rbDescuento.setSelected(true);
    }//GEN-LAST:event_rbDescuentoActionPerformed
    //Validar que se acciones sólo el radiobutton de monto (al añadir)
    private void rbMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMontoActionPerformed
        if (rbMonto.isSelected())
        rbPorcentaje.setSelected(false);
        if (!rbMonto.isSelected())
        rbMonto.setSelected(true);
    }//GEN-LAST:event_rbMontoActionPerformed
    //Validar que se accione sólo el radiobutton de porcentaje (al añadir)
    private void rbPorcentajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPorcentajeActionPerformed
        if (rbPorcentaje.isSelected())
        rbMonto.setSelected(false);
        if (!rbPorcentaje.isSelected())
        rbPorcentaje.setSelected(true);
    }//GEN-LAST:event_rbPorcentajeActionPerformed
    //Regresar al pánel de empleados
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        FormEmpleados empleados = new FormEmpleados();
        empleados.setSize(1010,600);
        empleados.setLocation(0, 0);
        this.removeAll();
        this.add(empleados,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_btnRegresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarBono_Descuento;
    private javax.swing.JButton btnModBono_Descuento;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPabe1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAgregarBono_Descuento;
    private javax.swing.JLabel lblBusqBono_Descuento;
    private javax.swing.JLabel lblMBono_Descuento;
    private javax.swing.JLabel lblMMonto_Porcentaje;
    private javax.swing.JLabel lblMonto_Porcentaje;
    private javax.swing.JLabel lblNombreBono_Descuento;
    private javax.swing.JRadioButton rbBono;
    private javax.swing.JRadioButton rbContinuados;
    private javax.swing.JRadioButton rbDescontinuados;
    private javax.swing.JRadioButton rbDescuento;
    private javax.swing.JRadioButton rbMBono;
    private javax.swing.JRadioButton rbMContinuar;
    private javax.swing.JRadioButton rbMDescuento;
    private javax.swing.JRadioButton rbMMonto;
    private javax.swing.JRadioButton rbMPorcentaje;
    private javax.swing.JRadioButton rbMonto;
    private javax.swing.JRadioButton rbPorcentaje;
    private javax.swing.JTable tBonos_Descuentos;
    private javax.swing.JTextField tfFiltro;
    private javax.swing.JTextField tfMBono_Descuento;
    private javax.swing.JTextField tfMMonto_Porcentaje;
    private javax.swing.JTextField tfMonto_Porcentaje;
    private javax.swing.JTextField tfNombreBono_Descuento;
    // End of variables declaration//GEN-END:variables
}
