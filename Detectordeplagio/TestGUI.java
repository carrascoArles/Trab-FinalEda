package Detectordeplagio;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class TestGUI extends JFrame {

	private JTabbedPane contentPane;

	public static void main(String[] args) {
		
		try {
			TestGUI frame = new TestGUI();
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

	public TestGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JTabbedPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel_resultados = new JPanel();
		panel_resultados.setLayout(null);

        JLabel label_resultados_1 = new JLabel("Resultados");
		label_resultados_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_resultados_1.setBounds(320, 11, 120, 20);
		
		JLabel label_resultados_2 = new JLabel("Aqui se mostraran los resultados");
		label_resultados_2.setBounds(10, 50, 749, 462);
		label_resultados_2.setHorizontalAlignment(SwingConstants.CENTER);

        // añadiendo elementos al panel de resultados
		panel_resultados.add(label_resultados_1);
		panel_resultados.add(label_resultados_2);

        JPanel panel_textos = new JPanel();
		panel_textos.setLayout(null);	

        JPanel panel_comparar = new JPanel();
		panel_comparar.setLayout(null);
		
		contentPane.addTab("Textos", null, panel_textos, null);
		contentPane.addTab("Comparar", null, panel_comparar, null);
		contentPane.addTab("Resultados", null, panel_resultados, null);
		
	}
}
