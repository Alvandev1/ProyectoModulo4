import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuPrincipal extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lblTitulo;
    private JButton btnBus;
    private JButton btnTren;
    private JButton btnSalir;

    public MenuPrincipal() {
        // 🧱 Inicializar componentes
        panelPrincipal = new JPanel();
        lblTitulo = new JLabel("🚉 Recarga de Abonos de Transporte", SwingConstants.CENTER);
        btnBus = new JButton("🚌 Recargar Abono Bus");
        btnTren = new JButton("🚆 Recargar Abono Tren");
        btnSalir = new JButton("❌ Salir");

        // 🎨 Estilos visuales
        panelPrincipal.setBackground(new Color(230, 240, 255)); // fondo azul claro
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(0, 51, 102));

        configurarBoton(btnBus, new Color(255, 204, 0), new Color(51, 51, 51));     // amarillo bus
        configurarBoton(btnTren, new Color(0, 102, 204), Color.WHITE);              // azul tren
        configurarBoton(btnSalir, new Color(220, 53, 69), Color.WHITE);             // rojo salida

        // 🧭 Layout principal
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelPrincipal.add(lblTitulo, gbc);
        gbc.gridy++;
        panelPrincipal.add(btnBus, gbc);
        gbc.gridy++;
        panelPrincipal.add(btnTren, gbc);
        gbc.gridy++;
        panelPrincipal.add(btnSalir, gbc);

        // 🖱️ Acciones de los botones
        btnBus.addActionListener(this::abrirBus);
        btnTren.addActionListener(this::abrirTren);
        btnSalir.addActionListener(e -> cerrarAplicacion());

        // 🪟 Configuración de la ventana
        setTitle("Menú Principal - Recarga de Abonos");
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        // 🔒 Confirmación al cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }
        });

        // 🧩 Icono del programa
        ImageIcon iconoApp = new ImageIcon("src/resources/train_icon.png");
        setIconImage(iconoApp.getImage());

        setVisible(true);
    }

    // 🎨 Método auxiliar para dar estilo a los botones
    private void configurarBoton(JButton boton, Color fondo, Color texto) {
        boton.setBackground(fondo);
        boton.setForeground(texto);
        boton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    // 🚌 Abrir ventana Bus
    private void abrirBus(ActionEvent e) {
        new Bus();
        dispose(); // cierra el menú principal
    }

    // 🚆 Abrir ventana Tren
    private void abrirTren(ActionEvent e) {
        new RecargaTren();
        dispose();
    }

    // 🔒 Confirmación de salida
    private void cerrarAplicacion() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Desea salir de la aplicación?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    // 🚀 Método main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuPrincipal::new);
    }
}
