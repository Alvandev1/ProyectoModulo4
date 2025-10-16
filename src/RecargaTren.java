import javax.swing.*;
import com.toedter.calendar.JMonthChooser;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RecargaTren extends JFrame {
    private JPanel panelPrincipal;
    private JLabel lblInstruccion;
    private JMonthChooser selectorMes;
    private JButton btnRecargar;

    public RecargaTren() {
        // 🔧 Inicialización de componentes
        panelPrincipal = new JPanel();
        lblInstruccion = new JLabel("Seleccione el mes para recargar su abono de TREN:");
        selectorMes = new JMonthChooser();
        btnRecargar = new JButton("Recargar Abono");

        // 🎨 Estilos visuales (color y fuente)
        panelPrincipal.setBackground(new Color(210, 225, 255)); // azul suave
        lblInstruccion.setForeground(new Color(0, 51, 102)); // texto azul oscuro
        lblInstruccion.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRecargar.setBackground(new Color(0, 102, 204)); // botón azul
        btnRecargar.setForeground(Color.WHITE);
        btnRecargar.setFocusPainted(false);
        btnRecargar.setFont(new Font("Segoe UI", Font.BOLD, 13));

        // 🧭 Layout limpio y centrado
        panelPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Añadir componentes con posiciones
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelPrincipal.add(lblInstruccion, gbc);

        gbc.gridy = 1;
        panelPrincipal.add(selectorMes, gbc);

        gbc.gridy = 2;
        panelPrincipal.add(btnRecargar, gbc);

        // 🛈 Tooltip
        btnRecargar.setToolTipText("Pulsa para confirmar la recarga de tu abono de tren");

        // 🎯 Acción del botón
        btnRecargar.addActionListener(e -> {
            String[] meses = {
                    "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
            };
            int mes = selectorMes.getMonth();
            String mesNombre = meses[mes];

            JOptionPane.showMessageDialog(
                    this,
                    "🚆 Su abono de TREN ha sido recargado para el mes de: " + mesNombre,
                    "Recarga Exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });

        // 🔒 Confirmación al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        RecargaTren.this,
                        "¿Desea cerrar la aplicación?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // 🚆 Icono de la ventana
        ImageIcon iconoTren = new ImageIcon("src/resources/train_icon.png");
        setIconImage(iconoTren.getImage());

        // 🪟 Configuración de la ventana
        setTitle("Recarga Abono Tren 🚆");
        setContentPane(panelPrincipal);
        setSize(400, 220);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setVisible(true); // 🔹 Ahora se muestra automáticamente
    }

    // ✅ main opcional (para pruebas individuales)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(RecargaTren::new);
    }
}
