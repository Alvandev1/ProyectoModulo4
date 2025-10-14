package Interfaz;
import com.toedter.calendar.JMonthChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TrenForm extends JFrame {
    private JPanel mainPanel;
    private JLabel label;
    private JMonthChooser monthChooser;
    private JButton botonRecargar;

    public TrenForm() {
        setTitle("Recarga Tren 🚆");
        setContentPane(mainPanel);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);

        // Tooltip (extra)
        botonRecargar.setToolTipText("Haz clic para recargar tu abono mensual de tren");

        // Icono (extra)
        setIconImage(new ImageIcon(getClass().getResource("/icons/train.png")).getImage());

        // Confirmación al cerrar ventana (extra)
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        RecargaTrenForm.this,
                        "¿Seguro que desea salir?",
                        "Confirmar salida",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // Acción del botón
        botonRecargar.addActionListener(e -> {
            int mesIndex = monthChooser.getMonth();
            String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
            String mesSeleccionado = meses[mesIndex];

            if (mesSeleccionado.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione un mes antes de recargar.", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Su abono de transporte ha sido recargado para el mes de: " + mesSeleccionado,
                        "Recarga completada",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RecargaTrenForm().setVisible(true));
    }
}
