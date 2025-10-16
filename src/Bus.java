import com.toedter.calendar.JMonthChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bus extends JFrame {

    private JMonthChooser monthChooser;
    private JButton btnRecargar;
    private JLabel lblInstruccion;

    public Bus() {

        // --- Configuración de la ventana ---
        setTitle("Recarga de Abono - BUS");
        setSize(400, 220);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // --- Layout principal ---
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBackground(new Color(40, 40, 40)); // gris oscuro
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Etiqueta ---
        lblInstruccion = new JLabel("Seleccione el mes para recargar su abono BUS:");
        lblInstruccion.setForeground(Color.ORANGE);
        lblInstruccion.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(lblInstruccion);

        // --- Selector de mes ---
        monthChooser = new JMonthChooser();
        monthChooser.setBackground(Color.DARK_GRAY);
        monthChooser.setForeground(Color.WHITE);
        panel.add(monthChooser);

        // --- Botón ---
        btnRecargar = new JButton("🚌 Recargar Abono");
        btnRecargar.setToolTipText("Pulsa para recargar tu abono mensual de bus");
        btnRecargar.setBackground(new Color(255, 102, 0)); // naranja intenso
        btnRecargar.setForeground(Color.WHITE);
        btnRecargar.setFont(new Font("Arial", Font.BOLD, 13));
        btnRecargar.setFocusPainted(false);
        btnRecargar.addActionListener(e -> recargarAbono());
        panel.add(btnRecargar);

        // --- Listener de cierre con confirmación ---
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opcion = JOptionPane.showConfirmDialog(
                        Bus.this,
                        "¿Seguro que quieres salir de la recarga de BUS?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (opcion == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // --- Icono de la ventana ---
        ImageIcon iconoBus = new ImageIcon("src/resources/bus_icon.png");
        setIconImage(iconoBus.getImage());

        // --- Añadir panel y mostrar ventana ---
        add(panel);
        setVisible(true); // 🔹 Importante: muestra la ventana al instanciarla
    }

    private void recargarAbono() {
        int mes = monthChooser.getMonth();
        String[] meses = {
                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        // Validación
        if (mes < 0 || mes > 11) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un mes válido antes de recargar.",
                    "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String mensaje = "🚌 Su abono de transporte BUS ha sido recargado para el mes de: " + meses[mes];
        JOptionPane.showMessageDialog(this, mensaje,
                "Recarga confirmada", JOptionPane.INFORMATION_MESSAGE);
    }

    // ✅ main opcional (para probar de forma independiente)
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bus::new);
    }
}
