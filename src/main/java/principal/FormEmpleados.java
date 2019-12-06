/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import controladores.EmpleadosJpaController;
import controladores.TelefonosJpaController;
import recursoshumanos.ClaseEmpleados;
import entidades.Empleados;
import entidades.Telefonos;
import java.awt.BorderLayout;
import java.awt.Image;
import singleton.singleton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;
import recursoshumanos.ClaseTelefonos;

/**
 *
 * @author igeni
 */
public class FormEmpleados extends javax.swing.JPanel {
    ClaseEmpleados clasEmpleados = new ClaseEmpleados();//Variable para controlar el ingreso, modificación, deshabilitación/habilitación o búsqueda de empleados
    DefaultTableModel empleados = new DefaultTableModel();//Modelo para la tabla de empleados
    DefaultTableModel clientes = new DefaultTableModel();//Modelo para la tabla de teléfonos
    ClaseTelefonos clasTelefonos = new ClaseTelefonos();//Variable para controlar el ingreso, modificación, eliminación o búsqueda de teléfonos
    int seleccionado = -1;//Variable para controlar cuando se seleccione una fila de la tabla de empleados
    int seltel = -1;//Variable para controlar cuando se seleccione una fila de la tabla de teléfonos
    int idseleccionado = -1;//Variable para controlar cuando se seleccione una fila de la tabla de empleados
    int conttel = -1;
    int contemp = -1;
    int clickemp = 0;
    int clicktel = 0;
    Empleados empleado;
    boolean mostrartodosEmp = false;//Variable para mostrar a todos los empleados
    DecimalFormat num = new DecimalFormat("#,###.00");//Variable para asignar un formato de cómo mostrar el salario del empleado
    //Inicializar las columnas de los modelos de cada tabla, cargar información de los empleados habilitados y controlar
    //comportamiento de todos los componentes, así como inicializar los listeners de cada tabla
    public FormEmpleados() {
        initComponents();
        btnEliEmpleado.setEnabled(false);        
        limpiarTodo();
        rbActividad.setSelected(true);
        rbTodos.setSelected(false);
        empleados.addColumn("Código");
        empleados.addColumn("Nombres");
        empleados.addColumn("Apellidos");
        empleados.addColumn("Dirección");
        empleados.addColumn("Estado");
        empleados.addColumn("Rol");
        empleados.addColumn("Salario");
        clientes.addColumn("Teléfono");
        tEmpleados.setModel(empleados);
        tTelefonos.setModel(clientes);
        cargarInformacion("");
        inicializarListenerEmpleados();
        inicializarListenerTelefonos();
    }
    //Mostrar datos de un empleado al hacer doble click a una fila de esta tabla
    public void inicializarListenerEmpleados() {
        tEmpleados.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    seleccionarEmpleado();
                }
            }
        });
    }
    //Mostrar datos de un teléfono al hacer doble click a una fila de esta tabla
    public void inicializarListenerTelefonos() {
        tTelefonos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    seleccionarTelefono();
                }
            }
        });
    }
    //Controlar comportamiento de los componentes al iniciar el uso de este panel
    private void limpiarTodo()
    {
        lblBusqTel.setText("Buscar teléfono de:");
        lblMTelefono.setText("Teléfono/Celular de:");
        lblAgregarTelefono.setText("Agregar teléfono a:");
        tfMNombre.setEnabled(false);
        tfMApellidos.setEnabled(false);
        tfMDireccion.setEnabled(false);
        tfMSalario.setEnabled(false);
        tfMTelefono.setEnabled(false);
        tfTelefono.setEnabled(false);
        tfFiltroTelefonos.setEnabled(false);
        btnPago.setEnabled(false);
        btnPago.setVisible(false);
        tfMNombre.setText("");
        tfMApellidos.setText("");
        tfMDireccion.setText("");
        tfMSalario.setText("");
        tfMTelefono.setText("");
        tfTelefono.setText("");
        tfFiltroTelefonos.setText("");
        btnModEmpleado.setEnabled(false);
        btnEliEmpleado.setEnabled(false);
        btnEliTel.setEnabled(false);
        btnModCel.setEnabled(false);
        btnTelefono.setEnabled(false);
        rbMRol.setEnabled(false);
        rbMRol.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        PEmpleados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tEmpleados = new javax.swing.JTable();
        lblBusqEmpleado = new javax.swing.JLabel();
        tfFiltroEmpleados = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblMNombre = new javax.swing.JLabel();
        tfMNombre = new javax.swing.JTextField();
        lblMApellidos = new javax.swing.JLabel();
        tfMApellidos = new javax.swing.JTextField();
        lblMSalario = new javax.swing.JLabel();
        tfMSalario = new javax.swing.JTextField();
        lblMDireccion = new javax.swing.JLabel();
        tfMDireccion = new javax.swing.JTextField();
        btnModEmpleado = new javax.swing.JButton();
        PTelefono1 = new javax.swing.JPanel();
        btnEliTel = new javax.swing.JButton();
        PIngresoTelefono1 = new javax.swing.JPanel();
        lblAgregarTelefono = new javax.swing.JLabel();
        btnTelefono = new javax.swing.JButton();
        tfTelefono = new javax.swing.JTextField();
        btnModCel = new javax.swing.JButton();
        tfMTelefono = new javax.swing.JTextField();
        lblMTelefono = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tTelefonos = new javax.swing.JTable();
        tfFiltroTelefonos = new javax.swing.JTextField();
        lblBusqTel = new javax.swing.JLabel();
        btnPago = new javax.swing.JButton();
        btnEliEmpleado = new javax.swing.JButton();
        rbMRol = new javax.swing.JRadioButton();
        btnAgregarEmpleado = new javax.swing.JButton();
        rbActividad = new javax.swing.JRadioButton();
        rbTodos = new javax.swing.JRadioButton();
        lblBusqLista = new javax.swing.JLabel();
        btnBonosDescuentos = new javax.swing.JButton();

        panel1.setBackground(new java.awt.Color(36, 41, 46));
        panel1.setPreferredSize(new java.awt.Dimension(1010, 600));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PEmpleados.setBackground(new java.awt.Color(36, 41, 46));
        PEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tEmpleados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Dirección", "Usuario"
            }
        ));
        tEmpleados.setFocusable(false);
        tEmpleados.getTableHeader().setReorderingAllowed(false);
        tEmpleados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tEmpleadosMouseDragged(evt);
            }
        });
        tEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tEmpleadosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tEmpleadosMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tEmpleadosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tEmpleados);

        PEmpleados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 826, 100));

        lblBusqEmpleado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBusqEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        lblBusqEmpleado.setText("Buscar por nombre:");
        PEmpleados.add(lblBusqEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 201, -1));

        tfFiltroEmpleados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfFiltroEmpleados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFiltroEmpleadosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroEmpleadosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFiltroEmpleadosKeyTyped(evt);
            }
        });
        PEmpleados.add(tfFiltroEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 260, -1));

        jPanel1.setBackground(new java.awt.Color(36, 41, 46));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblMNombre.setText("Nombres:");
        jPanel1.add(lblMNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 111, -1));

        tfMNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMNombreActionPerformed(evt);
            }
        });
        tfMNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMNombreKeyTyped(evt);
            }
        });
        jPanel1.add(tfMNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 120, -1));

        lblMApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMApellidos.setForeground(new java.awt.Color(255, 255, 255));
        lblMApellidos.setText("Apellidos:");
        jPanel1.add(lblMApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 11, 109, -1));

        tfMApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMApellidosKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMApellidosKeyTyped(evt);
            }
        });
        jPanel1.add(tfMApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 39, 120, -1));

        lblMSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMSalario.setForeground(new java.awt.Color(255, 255, 255));
        lblMSalario.setText("Salario (Q.):");
        jPanel1.add(lblMSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 11, 112, -1));

        tfMSalario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMSalario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMSalarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMSalarioKeyTyped(evt);
            }
        });
        jPanel1.add(tfMSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 39, 120, -1));

        lblMDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMDireccion.setForeground(new java.awt.Color(255, 255, 255));
        lblMDireccion.setText("Dirección:");
        jPanel1.add(lblMDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 11, -1, -1));

        tfMDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMDireccionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMDireccionKeyTyped(evt);
            }
        });
        jPanel1.add(tfMDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 39, 119, -1));

        btnModEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificarp.png"))); // NOI18N
        btnModEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnModEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(701, 0, 95, 101));

        PTelefono1.setBackground(new java.awt.Color(36, 41, 46));
        PTelefono1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliTel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminarp.png"))); // NOI18N
        btnEliTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliTelActionPerformed(evt);
            }
        });
        PTelefono1.add(btnEliTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 70, 101, 101));

        PIngresoTelefono1.setBackground(new java.awt.Color(36, 41, 46));
        PIngresoTelefono1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAgregarTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAgregarTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblAgregarTelefono.setText("Teléfono/Celular del empleado:");
        PIngresoTelefono1.add(lblAgregarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 420, -1));

        btnTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agregar_telefono.png"))); // NOI18N
        btnTelefono.setBorder(null);
        btnTelefono.setBorderPainted(false);
        btnTelefono.setContentAreaFilled(false);
        btnTelefono.setFocusPainted(false);
        btnTelefono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefonoActionPerformed(evt);
            }
        });
        PIngresoTelefono1.add(btnTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 100, 101));

        tfTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyTyped(evt);
            }
        });
        PIngresoTelefono1.add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 190, -1));

        PTelefono1.add(PIngresoTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 11, 430, -1));

        btnModCel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Modificarp.png"))); // NOI18N
        btnModCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModCelActionPerformed(evt);
            }
        });
        PTelefono1.add(btnModCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 70, 101, 101));

        tfMTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfMTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfMTelefonoActionPerformed(evt);
            }
        });
        tfMTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfMTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfMTelefonoKeyTyped(evt);
            }
        });
        PTelefono1.add(tfMTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, 186, -1));

        lblMTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblMTelefono.setText("Teléfono/Celular del empleado:");
        PTelefono1.add(lblMTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 177, 352, -1));

        tTelefonos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Teléfono"
            }
        ));
        tTelefonos.setFocusable(false);
        tTelefonos.getTableHeader().setReorderingAllowed(false);
        tTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTelefonosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tTelefonosMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tTelefonos);

        PTelefono1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 76, 224, 95));

        tfFiltroTelefonos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfFiltroTelefonos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFiltroTelefonosActionPerformed(evt);
            }
        });
        tfFiltroTelefonos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFiltroTelefonosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfFiltroTelefonosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFiltroTelefonosKeyTyped(evt);
            }
        });
        PTelefono1.add(tfFiltroTelefonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 190, -1));

        lblBusqTel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBusqTel.setForeground(new java.awt.Color(255, 255, 255));
        lblBusqTel.setText("Buscar teléfono de:");
        PTelefono1.add(lblBusqTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 3, 460, -1));

        btnPago.setBackground(new java.awt.Color(0, 136, 204));
        btnPago.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPago.setForeground(new java.awt.Color(255, 255, 255));
        btnPago.setText("Otorgar pago a este empleado");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });
        PTelefono1.add(btnPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 290, -1));

        jPanel1.add(PTelefono1, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 112, -1, -1));

        btnEliEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminarp.png"))); // NOI18N
        btnEliEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(806, 1, 95, 100));

        rbMRol.setBackground(new java.awt.Color(36, 41, 46));
        rbMRol.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMRol.setForeground(new java.awt.Color(255, 255, 255));
        rbMRol.setText("Rol");
        rbMRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMRolActionPerformed(evt);
            }
        });
        jPanel1.add(rbMRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 30, 120, -1));

        PEmpleados.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 990, 360));

        btnAgregarEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Agrega_empleado.png"))); // NOI18N
        btnAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarEmpleadoActionPerformed(evt);
            }
        });
        PEmpleados.add(btnAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 110, 102, 100));

        rbActividad.setBackground(new java.awt.Color(36, 41, 46));
        rbActividad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbActividad.setForeground(new java.awt.Color(255, 255, 255));
        rbActividad.setText("En actividad");
        rbActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActividadActionPerformed(evt);
            }
        });
        PEmpleados.add(rbActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, -1, -1));

        rbTodos.setBackground(new java.awt.Color(36, 41, 46));
        rbTodos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbTodos.setForeground(new java.awt.Color(255, 255, 255));
        rbTodos.setText("En actividad y despedidos");
        rbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTodosActionPerformed(evt);
            }
        });
        PEmpleados.add(rbTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        lblBusqLista.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBusqLista.setForeground(new java.awt.Color(255, 255, 255));
        lblBusqLista.setText("Buscar empleados:");
        PEmpleados.add(lblBusqLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 164, -1));

        btnBonosDescuentos.setBackground(new java.awt.Color(0, 136, 204));
        btnBonosDescuentos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBonosDescuentos.setForeground(new java.awt.Color(255, 255, 255));
        btnBonosDescuentos.setText("Agregar bono o descuento...");
        btnBonosDescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBonosDescuentosActionPerformed(evt);
            }
        });
        PEmpleados.add(btnBonosDescuentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 300, -1));

        panel1.add(PEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 3, -1, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    //Cargar información de empleados con el filtro (dependiendo de si están activos o no)
    private void cargarInformacion(String contenido)
    {
        if (rbActividad.isSelected())
            cargarActivos(contenido);
        else
            cargarTodos(contenido);
    }
    //Cargar empleados activos
    private void cargarActivos(String contenido)
    {
        int fila = 0;
        try{
            Object O[] = null;
            List<entidades.Empleados> lista = clasEmpleados.buscarObjects(contenido, singleton.getConnection());
            for(int i = 0; i < lista.size(); i++)
            {
                if(!lista.get(i).getEstado().equals("Inactivo"))
                {
                    empleados.addRow(O);
                    empleados.setValueAt(lista.get(i).getId(), fila, 0);
                    empleados.setValueAt(lista.get(i).getNombre(), fila, 1);
                    empleados.setValueAt(lista.get(i).getApellido(), fila, 2);
                    empleados.setValueAt(lista.get(i).getDireccion(), fila, 3);
                    empleados.setValueAt(lista.get(i).getEstado(), fila, 4);
                    if (lista.get(i).getAdministrador() == 0)
                        empleados.setValueAt("Usuario", fila, 5);
                    else
                        empleados.setValueAt("Administrador", fila, 5);
                    empleados.setValueAt("Q. " + num.format(lista.get(i).getSalario()), fila, 6);
                    fila ++;
                }
            }
            tEmpleados.setModel(empleados);
            tfFiltroTelefonos.setEnabled(false);
            tfFiltroTelefonos.setText("");
            tfMTelefono.setEnabled(false);
            tfMTelefono.setText("");
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //Cargar a todos los empleados
    private void cargarTodos(String contenido)
    {
        try{
            Object O[] = null;
            List<entidades.Empleados> lista = clasEmpleados.buscarObjects(contenido, singleton.getConnection());
            for(int i = 0; i < lista.size(); i++)
            {
                empleados.addRow(O);
                empleados.setValueAt(lista.get(i).getId(), i, 0);
                empleados.setValueAt(lista.get(i).getNombre(), i, 1);
                empleados.setValueAt(lista.get(i).getApellido(), i, 2);
                empleados.setValueAt(lista.get(i).getDireccion(), i, 3);
                empleados.setValueAt(lista.get(i).getEstado(), i, 4);
                if (lista.get(i).getAdministrador() == 0)
                    empleados.setValueAt("Usuario", i , 5);
                else
                    empleados.setValueAt("Administrador", i , 5);
                empleados.setValueAt("Q. " + num.format(lista.get(i).getSalario()), i , 6);
            }
            tEmpleados.setModel(empleados);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //Cargar teléfonos del empleado seleccionado con el filtro
    private void cargarTelefonos(String telefono)
    {
        try{
            Object O[] = null;
            List<entidades.Telefonos> lista = clasTelefonos.buscarObjects(clasEmpleados.obtenerEmpleado(singleton.getConnection(), idseleccionado), singleton.getConnection(), telefono);
            for(int i = 0; i < lista.size(); i++)
            {
                clientes.addRow(O);
                clientes.setValueAt(lista.get(i).getNumero(), i, 0);
            }
            tTelefonos.setModel(clientes);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    //Habilitar o deshabilitar a un empleado
    private void btnEliEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliEmpleadoActionPerformed
        if (empleado.getEstado().equals("Activo"))
            eliminarEmpleado();
        else
            recontratarEmpleado();
    }//GEN-LAST:event_btnEliEmpleadoActionPerformed
    //Insertar ícono de habilitación o deshabilitación de un empleado
    private void insertarIcono(String ruta)
    {
        ImageIcon imagen = new ImageIcon(ruta);
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(btnEliEmpleado.getWidth(), btnEliEmpleado.getHeight(), Image.SCALE_DEFAULT));
        btnEliEmpleado.setIcon(icono);
    }
    //Despedir a un empleado
    private void eliminarEmpleado()
    {
        if (idseleccionado != -1)
        {
            if (empleado.getId() != 1)
            {
                if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer despedir este empleado?", "Aviso", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    limpiarTablas();
                    empleado.setEstado("Inactivo");
                    empleado.setUsuario(null);
                    empleado.setContrasena(null);
                    clasEmpleados.editarObject(empleado, singleton.getConnection(), idseleccionado);
                    limpiarDespedir_Recontratar_yModificar();
                    cargarInformacion("");
                    JOptionPane.showMessageDialog(null, "Empleado despedido con éxito");
                }
            }
            else
                JOptionPane.showMessageDialog(null, "No se puede despedir al súper administrador");
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor seleccione un empleado");
    }
    //Limpiar tabla de empleados
    private void limpiarTEmpleados()
    {
        while(empleados.getRowCount()>0)
            empleados.removeRow(0);
    }
    //Limpiar tabla de clientes
    private void limpiarTClientes()
    {
        while(clientes.getRowCount()>0)
            clientes.removeRow(0);
    }
    //Limpiar todas las tablas
    private void limpiarTablas()
    {
        while(empleados.getRowCount()>0)
            empleados.removeRow(0);
        while(clientes.getRowCount()>0)
            clientes.removeRow(0);
    }
    //Recontratar a un empleado
    private void recontratarEmpleado()
    {
        if (idseleccionado != -1)
        {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer recontratar este empleado?", "Aviso", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                limpiarTablas();
                empleado.setEstado("Activo");
                clasEmpleados.editarObject(empleado, singleton.getConnection(), idseleccionado);
                limpiarDespedir_Recontratar_yModificar();
                cargarInformacion("");
                JOptionPane.showMessageDialog(null, "Empleado recontratado con éxito");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor seleccione un empleado");
    }
    //Controlar comportamiento de componentes al despedir, recontratar o modificar a un empleado
    private void limpiarDespedir_Recontratar_yModificar()
    {
        tfMNombre.setText("");
        tfMApellidos.setText("");
        tfMDireccion.setText("");
        tfMSalario.setText("");
        tfFiltroEmpleados.setText("");
        tfFiltroTelefonos.setText("");
        tfFiltroTelefonos.setEnabled(false);
        tfMTelefono.setText("");
        tfTelefono.setText("");
        tfTelefono.setEnabled(false);
        tfMTelefono.setEnabled(false);
        btnEliEmpleado.setEnabled(false);
        btnModEmpleado.setEnabled(false);
        btnTelefono.setEnabled(false);
        btnEliTel.setEnabled(false);
        btnModCel.setEnabled(false);
        tfMNombre.setEnabled(false);
        tfMApellidos.setEnabled(false);
        tfMDireccion.setEnabled(false);
        tfMSalario.setEnabled(false);
        rbMRol.setEnabled(false);
        rbMRol.setSelected(false);
        btnPago.setEnabled(false);
        btnPago.setVisible(false);
        lblBusqTel.setText("Buscar teléfono de:");
        lblMTelefono.setText("Teléfono/Celular de:");
        lblAgregarTelefono.setText("Agregar teléfono a:");
        seleccionado = -1;
        idseleccionado = -1;
    }
    
    private void tEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEmpleadosMouseClicked

    }//GEN-LAST:event_tEmpleadosMouseClicked

    //Modificar los datos de un empleado
    private void btnModEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModEmpleadoActionPerformed
        modificarEmpleado();
    }//GEN-LAST:event_btnModEmpleadoActionPerformed
    //Modificar los datos de un empleado
    private void modificarEmpleado()
    {
        if (!tfMNombre.getText().equals("") && !tfMApellidos.getText().equals("") && !tfMDireccion.getText().equals("")
        && !tfMSalario.getText().equals(""))
        {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer modificar los datos de este empleado?", "Aviso", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                if (empleado.getId() == 1 && rbMRol.isSelected())
                    JOptionPane.showMessageDialog(null, "No se puede degradar al súper administrador");
                else
                {
                    empleado = clasEmpleados.obtenerEmpleado(singleton.getConnection(), idseleccionado);
                    limpiarTablas();
                    empleado.setId(idseleccionado);
                    empleado.setNombre(tfMNombre.getText());
                    empleado.setApellido(tfMApellidos.getText());
                    empleado.setDireccion(tfMDireccion.getText());
                    empleado.setSalario(Float.valueOf(tfMSalario.getText()));
                    if (rbMRol.isSelected())
                    {
                        if (empleado.getAdministrador() == 0)
                            empleado.setAdministrador((short)1);
                        else
                            empleado.setAdministrador((short)0);
                    }
                    clasEmpleados.editarObject(empleado, singleton.getConnection(), idseleccionado);
                    limpiarDespedir_Recontratar_yModificar();
                    JOptionPane.showMessageDialog(null, "Modificación exitosa");
                    cargarInformacion("");
                }
            }    
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos de modificación de un empleado.");
    }
    //Validar un máximo de 30 caracteres en el filtro de empleados
    private void tfFiltroEmpleadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroEmpleadosKeyTyped
        if (tfFiltroEmpleados.getText().length() > 30) evt.consume();
        
    }//GEN-LAST:event_tfFiltroEmpleadosKeyTyped
    //Validación de ingreso de nombres sólo con letras del abecedario y letras tildadas, con un máximo de 30 caracteres
    private void tfMNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMNombreKeyTyped
        char c = evt.getKeyChar();
        
        if ((c<'a' || c>'z') && (c<'A')|c>'Z')
        {
            if ((c != ' ') && (c != 'á') && (c != 'é') && (c != 'í') && (c != 'ó') && (c != 'ú'))
                evt.consume();
        }
        if (tfMNombre.getText().length() > 30) evt.consume();
    }//GEN-LAST:event_tfMNombreKeyTyped
    //Validación de ingreso de apellidos sólo con letras del abecedario y letras tildadas, con un máximo de 30 caracteres
    private void tfMApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMApellidosKeyTyped
        char c = evt.getKeyChar();
        
        if ((c<'a' || c>'z') && (c<'A')|c>'Z')
        {
            if ((c != ' ') && (c != 'á') && (c != 'é') && (c != 'í') && (c != 'ó') && (c != 'ú'))
                evt.consume();
        }
        if (tfMApellidos.getText().length() > 30) evt.consume();
    }//GEN-LAST:event_tfMApellidosKeyTyped
    //Validación de un máximo de 45 caracteres para la dirección del empleado
    private void tfMDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMDireccionKeyTyped
        if (tfMDireccion.getText().length() > 45) evt.consume();
    }//GEN-LAST:event_tfMDireccionKeyTyped

    private void tfFiltroEmpleadosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroEmpleadosKeyPressed
        
    }//GEN-LAST:event_tfFiltroEmpleadosKeyPressed
    //Controlar comportamiento de componentes al usar el filtro de empleados, y cargado de información con el mismo
    private void tfFiltroEmpleadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroEmpleadosKeyReleased
        limpiarTablas();
        limpiarTodo();
        cargarInformacion(tfFiltroEmpleados.getText());
    }//GEN-LAST:event_tfFiltroEmpleadosKeyReleased
    //Movimiento entre cajas de texto
    private void tfMNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMNombreKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) tfMApellidos.requestFocus();
    }//GEN-LAST:event_tfMNombreKeyPressed
    //Movimiento entre cajas de texto
    private void tfMApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMApellidosKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) tfMSalario.requestFocus();
        else if (evt.getKeyCode() == KeyEvent.VK_UP) tfMNombre.requestFocus();
    }//GEN-LAST:event_tfMApellidosKeyPressed

    private void tfMDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMDireccionKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) modificarEmpleado();
        else if (evt.getKeyCode() == KeyEvent.VK_UP) tfMSalario.requestFocus();
    }//GEN-LAST:event_tfMDireccionKeyPressed

    private void tEmpleadosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEmpleadosMouseReleased
        
    }//GEN-LAST:event_tEmpleadosMouseReleased
    //Obtener datos del empleado al seleccionarlo
    private void seleccionarEmpleado()
    {
        limpiarTClientes();
        int indice = tEmpleados.getSelectedRow() + 1;
        seleccionado = indice;
        idseleccionado = Integer.parseInt(String.valueOf(tEmpleados.getValueAt(tEmpleados.getSelectedRow(), 0)));
        TableModel modelo = tEmpleados.getModel();
        if (indice > 0)
        {
            empleado = clasEmpleados.obtenerEmpleado(singleton.getConnection(), idseleccionado);
            btnEliEmpleado.setEnabled(true);
            btnModEmpleado.setEnabled(true);
            btnTelefono.setEnabled(true);
            btnEliTel.setEnabled(false);
            btnModCel.setEnabled(false);
            tfMNombre.setEnabled(true);
            tfMApellidos.setEnabled(true);
            tfMDireccion.setEnabled(true);
            tfMSalario.setEnabled(true);
            tfFiltroTelefonos.setEnabled(true);
            rbMRol.setEnabled(true);
            if (empleado.getEstado().equals("Activo"))
            {
                btnPago.setEnabled(true);
                btnPago.setVisible(true);
            }
            else
            {
                btnPago.setEnabled(false);
                btnPago.setVisible(false);
            }
            tfFiltroTelefonos.setText("");
            tfMTelefono.setEnabled(false);
            tfMTelefono.setText("");
            tfMNombre.setText(empleado.getNombre());
            tfMApellidos.setText(empleado.getApellido());
            tfMSalario.setText(BigDecimal.valueOf(empleado.getSalario()).toString());
            tfMDireccion.setText(empleado.getDireccion());
            lblBusqTel.setText("Buscar teléfono de " + empleado.getNombre() + ":");
            lblMTelefono.setText("Teléfono/Celular de " + empleado.getNombre() + ":");
            lblAgregarTelefono.setText("Agregar teléfono a " + empleado.getNombre() + ":");
            tfTelefono.setEnabled(true);
            tfMNombre.requestFocus();
            decidirImagen();
            obtenerRol();
            cargarTelefonos("");
        }
    }
    //Controlar comportamiento del label de rol de empleado
    private void obtenerRol()
    {
        if (empleado.getAdministrador() == 0)
            rbMRol.setText("Ascender");
        else
            rbMRol.setText("Degradar");
    }
    //Decidir la imagen del botón de habilitar/deshabilitar, dependiendo del estado del empleado
    private void decidirImagen()
    {
        if (empleado.getEstado().equals("Activo"))
            insertarIcono("src/main/resources/imagenes/Eliminarp.png");
        else
            insertarIcono("src/main/resources/imagenes/Agregarp.png");
    }
    
    private void tfMSalarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMSalarioKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER || evt.getKeyCode() == KeyEvent.VK_DOWN) tfMDireccion.requestFocus();
        else if (evt.getKeyCode() == KeyEvent.VK_UP) tfMApellidos.requestFocus();
    }//GEN-LAST:event_tfMSalarioKeyPressed
    //Validar un máximo de 6 caracteres (con dígitos validados) para el salario del empleado
    private void tfMSalarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMSalarioKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
        {
            if (c != '.')
                evt.consume();
        }
        if (tfMSalario.getText().length() > 6) evt.consume();
    }//GEN-LAST:event_tfMSalarioKeyTyped
    //Eliminar un teléfono del empleado seleccionado
    private void btnEliTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliTelActionPerformed
        eliminarTelefono();
    }//GEN-LAST:event_btnEliTelActionPerformed
    
    private void tTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTelefonosMouseClicked

    }//GEN-LAST:event_tTelefonosMouseClicked

    private void tTelefonosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTelefonosMouseReleased

    }//GEN-LAST:event_tTelefonosMouseReleased
    //Obtener datos de un teléfono seleccionado
    private void seleccionarTelefono()
    {
        int indice = tTelefonos.getSelectedRow();
        seltel = indice;
        Telefonos telefono = clasTelefonos.obtenerTelefono(String.valueOf(tTelefonos.getValueAt(seltel, 0)), singleton.getConnection());
        tfMTelefono.setEnabled(true);
        tfMTelefono.setText(telefono.getNumero());
        TableModel modelo = tTelefonos.getModel();
        tfTelefono.setEnabled(true);
        if (indice > -1)
        {
            lblMTelefono.setEnabled(true);
            tfTelefono.setEnabled(true);
            btnModCel.setEnabled(true);
            btnEliTel.setEnabled(true);
            tfMTelefono.requestFocus();
        }
    }
    //Eliminar un teléfono
    private void eliminarTelefono()
    {
        if (seltel > -1)
        {
            if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer eliminar el teléfono seleccionado de este empleado?", "Aviso", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                Telefonos telefonos = clasTelefonos.obtenerTelefono(String.valueOf(tTelefonos.getValueAt(seltel, 0)), singleton.getConnection());
                clasTelefonos.eliminarTelefono(telefonos, singleton.getConnection());
                limpiarAlModificar_o_eliminarTel();
                JOptionPane.showMessageDialog(null, "Eliminación de celular exitosa");
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor seleccione un número de teléfono");
    }
    //Controlar el comportamiento al modificar o eliminar un teléfono
    private void limpiarAlModificar_o_eliminarTel()
    {
        limpiarTClientes();
        cargarTelefonos("");
        tfMTelefono.setText("");
        tfMTelefono.setEnabled(false);
        tfFiltroTelefonos.setText("");
        btnModCel.setEnabled(false);
        btnEliTel.setEnabled(false);
        seltel = -1;
    }
    //Modificar un teléfono
    private void modificarTelefono()
    {
        if (!tfMTelefono.getText().equals(""))
        {
            if (tTelefonos.getSelectedRow() != -1)
            {
                List<entidades.Telefonos> resultado = clasTelefonos.existeTelefono(tfMTelefono.getText(), singleton.getConnection());
                if (resultado.isEmpty())
                {
                    if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer modificar el teléfono seleccionado de este empleado?", "Aviso", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        Telefonos telefono = clasTelefonos.obtenerTelefono(String.valueOf(tTelefonos.getValueAt(seltel, 0)), singleton.getConnection());
                        telefono.setNumero(tfMTelefono.getText());
                        clasTelefonos.editarTelefono(telefono, singleton.getConnection());
                        limpiarAlModificar_o_eliminarTel();
                        JOptionPane.showMessageDialog(null, "Modificación de celular exitosa");
                    }
                }
                else
                {
                    if (resultado.get(0).getEmpleadosId() == null) {
                        JOptionPane.showMessageDialog(null, "El teléfono especificado para modificar ya existe\n"
                                + "en la empresa con código: " + resultado.get(0).getComprasIdcompras().getIdcompras());
                    } else {
                        JOptionPane.showMessageDialog(null, "El teléfono especificado para modificar ya existe\n"
                                + "en el empleado con código: " + resultado.get(0).getEmpleadosId().getId());
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Por favor seleccione un número de teléfono");
        }
        else
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo de teléfono celular");
    }
    //Modificar un teléfono
    private void btnModCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModCelActionPerformed
        modificarTelefono();
    }//GEN-LAST:event_btnModCelActionPerformed
    //Agregar un teléfono
    private void btnTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelefonoActionPerformed
        agregarTelefono();
    }//GEN-LAST:event_btnTelefonoActionPerformed
    //Agregar un teléfono
    private void agregarTelefono()
    {
        if (tfTelefono.getText().length() > 0)
        {
            if (tEmpleados.getSelectedRow() != -1)
            {
                List<entidades.Telefonos> resultado = clasTelefonos.existeTelefono(tfTelefono.getText(), singleton.getConnection());
                if (resultado.isEmpty())
                {
                    if (JOptionPane.showConfirmDialog(null, "¿Está seguro de querer agregarle un teléfono a este empleado?", "Aviso", 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                    {
                        Telefonos telefono = new Telefonos();
                        limpiarTClientes();
                        telefono.setNumero(tfTelefono.getText());
                        telefono.setEmpleadosId(clasEmpleados.obtenerEmpleado(singleton.getConnection(), idseleccionado));
                        clasTelefonos.registrarObject(telefono, singleton.getConnection());
                        tfTelefono.setText("");
                        tfMTelefono.setText("");
                        tfFiltroTelefonos.setText("");  
                        btnEliTel.setEnabled(false);
                        btnModCel.setEnabled(false);
                        cargarTelefonos("");
                    }
                }
                else
                {
                    if (resultado.get(0).getEmpleadosId() == null)
                    {
                        JOptionPane.showMessageDialog(null, "El teléfono especificado para modificar ya existe\n"
                         + "en la empresa con código: " + resultado.get(0).getComprasIdcompras().getIdcompras());
                    }
                    else
                        JOptionPane.showMessageDialog(null, "El teléfono especificado para modificar ya existe\n"
                         + "en el empleado con código: " + resultado.get(0).getEmpleadosId().getId());
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Por favor seleccione un empleado");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Por favor rellene el campo que le solicita ingresar un telefono");
        }   
    }
    
    private void tfTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) agregarTelefono();
    }//GEN-LAST:event_tfTelefonoKeyPressed
    //Validar el ingreso de un máximo de 20 caracteres al filtro del teléfono
    private void tfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != '+') && (c != ' ')) evt.consume();
        if (tfTelefono.getText().length() > 20) evt.consume();
    }//GEN-LAST:event_tfTelefonoKeyTyped

    private void tfFiltroTelefonosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroTelefonosKeyPressed

    }//GEN-LAST:event_tfFiltroTelefonosKeyPressed
    //Controlar comportamiento de componentes al usar el filtro del teléfono, y obtener información referente al uso de este
    private void tfFiltroTelefonosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroTelefonosKeyReleased
        limpiarTClientes();
        if (tfFiltroTelefonos.getText().equals(""))
        {
            cargarTelefonos("");
            btnModCel.setEnabled(false);
            btnEliTel.setEnabled(false);
            tfMTelefono.setText("");
            tfMTelefono.setEnabled(false);
        }
        else
        {
            cargarTelefonos(tfFiltroTelefonos.getText());
            btnModCel.setEnabled(false);
            btnEliTel.setEnabled(false);
            tfMTelefono.setText("");
            tfMTelefono.setEnabled(false);
        }
            
    }//GEN-LAST:event_tfFiltroTelefonosKeyReleased
    //Validar un máximo de 20 caracteres al usar el filtro de teléfonos (con el código internacional validado)
    private void tfFiltroTelefonosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFiltroTelefonosKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != '+') && (c != ' ')) evt.consume();
        if (tfFiltroEmpleados.getText().length() > 20) evt.consume();
    }//GEN-LAST:event_tfFiltroTelefonosKeyTyped

    private void tfMTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMTelefonoKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) modificarTelefono();
    }//GEN-LAST:event_tfMTelefonoKeyPressed
    //Validar un máximo de 20 caracteres para el uso del filtro de teléfonos
    private void tfMTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMTelefonoKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && (c != '+') && (c != ' ')) evt.consume();
        if (tfMTelefono.getText().length() > 20) evt.consume();
    }//GEN-LAST:event_tfMTelefonoKeyTyped
    //Regresar al form de empleados
    private void btnAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarEmpleadoActionPerformed
        FormAgregarEmpleado agregar  = new FormAgregarEmpleado();
        agregar.setSize(1010,600);
        agregar.setLocation(0, 0);
        this.removeAll();
        this.add(agregar,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_btnAgregarEmpleadoActionPerformed
    //Validar el accionamiento del radiobutton de actividad, y mostrar todos los empleados activos
    private void rbActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActividadActionPerformed
        if (rbActividad.isSelected() && mostrartodosEmp == true)
        {
            rbTodos.setSelected(false);
            limpiarAlMostraryCargarInfo();
            mostrartodosEmp = false;
        }
        if (!rbActividad.isSelected())
            rbActividad.setSelected(true);
        
    }//GEN-LAST:event_rbActividadActionPerformed
    //Mostrar información al iniciar el panel o cargar con el filtro de empleados
    private void limpiarAlMostraryCargarInfo()
    {
        seleccionado = 0;
        idseleccionado = 0;
        seltel = 0;
        limpiarTodo();
        tfFiltroEmpleados.setText("");
        limpiarTablas();
        cargarInformacion("");
    }
    //Validar accionamiento del radiobutton de todos, y mostrar todos los empleados
    private void rbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTodosActionPerformed
        if (rbTodos.isSelected() && mostrartodosEmp == false)
        {
            rbActividad.setSelected(false);
            limpiarAlMostraryCargarInfo();
            mostrartodosEmp = true;
        }
        if (!rbTodos.isSelected())
            rbTodos.setSelected(true);
    }//GEN-LAST:event_rbTodosActionPerformed

    private void rbMRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMRolActionPerformed

    private void tfMTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMTelefonoActionPerformed

    private void tfFiltroTelefonosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFiltroTelefonosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFiltroTelefonosActionPerformed

    private void tfMNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfMNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMNombreActionPerformed

    private void tEmpleadosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEmpleadosMouseDragged
        
    }//GEN-LAST:event_tEmpleadosMouseDragged

    private void tEmpleadosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tEmpleadosMousePressed

    }//GEN-LAST:event_tEmpleadosMousePressed

    private void btnBonosDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBonosDescuentosActionPerformed
        Bonos_YDescuentos agregar  = new Bonos_YDescuentos();
        agregar.setSize(1010,600);
        agregar.setLocation(0, 0);
        this.removeAll();
        this.add(agregar,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_btnBonosDescuentosActionPerformed

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        PagarEmpleados pagar = new PagarEmpleados(empleado);
        pagar.setSize(1010,600);
        pagar.setLocation(0, 0);
        this.removeAll();
        this.add(pagar,BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_btnPagoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PEmpleados;
    private javax.swing.JPanel PIngresoTelefono1;
    private javax.swing.JPanel PTelefono1;
    private javax.swing.JButton btnAgregarEmpleado;
    private javax.swing.JButton btnBonosDescuentos;
    private javax.swing.JButton btnEliEmpleado;
    private javax.swing.JButton btnEliTel;
    private javax.swing.JButton btnModCel;
    private javax.swing.JButton btnModEmpleado;
    private javax.swing.JButton btnPago;
    private javax.swing.JButton btnTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAgregarTelefono;
    private javax.swing.JLabel lblBusqEmpleado;
    private javax.swing.JLabel lblBusqLista;
    private javax.swing.JLabel lblBusqTel;
    private javax.swing.JLabel lblMApellidos;
    private javax.swing.JLabel lblMDireccion;
    private javax.swing.JLabel lblMNombre;
    private javax.swing.JLabel lblMSalario;
    private javax.swing.JLabel lblMTelefono;
    private java.awt.Panel panel1;
    private javax.swing.JRadioButton rbActividad;
    private javax.swing.JRadioButton rbMRol;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tEmpleados;
    private javax.swing.JTable tTelefonos;
    private javax.swing.JTextField tfFiltroEmpleados;
    private javax.swing.JTextField tfFiltroTelefonos;
    private javax.swing.JTextField tfMApellidos;
    private javax.swing.JTextField tfMDireccion;
    private javax.swing.JTextField tfMNombre;
    private javax.swing.JTextField tfMSalario;
    private javax.swing.JTextField tfMTelefono;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables
}
