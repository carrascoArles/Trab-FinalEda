package Detectordeplagio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;

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
		
        // panel resultados, aca se mostrara los resultados de la verificacion de plagio para cada texto ingresado
		JPanel panel_resultados = new JPanel();
		panel_resultados.setLayout(null);

        // creando elementos para el panel de resultados
        JLabel label_resultados_1 = new JLabel("Resultados");
		label_resultados_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_resultados_1.setBounds(320, 11, 120, 20);
		
		JLabel label_resultados_2 = new JLabel("Aqui se mostraran los resultados");
		label_resultados_2.setBounds(10, 50, 749, 462);
		label_resultados_2.setHorizontalAlignment(SwingConstants.CENTER);

        // añadiendo elementos al panel de resultados
		panel_resultados.add(label_resultados_1);
		panel_resultados.add(label_resultados_2);

        
        // panel de textos, aca se introducira los diversos textos que seran evaluados por plagio
        JPanel panel_textos = new JPanel();
		panel_textos.setLayout(null);

        // creando elementos para el panel de textos
        JLabel label_textos_1 = new JLabel("Añadir textos");
		label_textos_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_textos_1.setBounds(320, 11, 120, 20);
		
		JTextArea textArea_textos_1 = new JTextArea();
		JScrollPane scrollPane_textos_1 = new JScrollPane(textArea_textos_1); // Creando un scrollPane para nuestro textArea (textos grandes)
		scrollPane_textos_1.setBounds(10, 40, 749, 312);

        JButton boton_textos_1 = new JButton("Agregar texto");
		boton_textos_1.setBounds(10, 363, 749, 30);
		boton_textos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// agrega el texto seleccionado y vacia el textArea
			}
		});
		
		JLabel label_textos_2 = new JLabel("¿Posee archivos de texto?");
		label_textos_2.setBounds(210, 404, 170, 30);
		
		JButton boton_textos_2 = new JButton("Agregar archivos");
		boton_textos_2.setBounds(390, 404, 369, 30);
		boton_textos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Agrega Varios archivos
			}
		});
		
		JButton boton_textos_3 = new JButton("Comparar plagio");
		boton_textos_3.setBounds(10, 445, 749, 60);
		boton_textos_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// realizar comparacion y redireccion a pestaña de resultados		
			}
		});
        
        // añadiendo elementos al panel de textos
		panel_textos.add(label_textos_1);
		panel_textos.add(scrollPane_textos_1);
        panel_textos.add(boton_textos_1);
		panel_textos.add(label_textos_2);
		panel_textos.add(boton_textos_2);
		panel_textos.add(boton_textos_3);

        // panel comparar, aca se introducira el texto original con el cual se comparara los textos ingresados en el panel de textos
        JPanel panel_comparar = new JPanel();
		panel_comparar.setLayout(null);

        // creando elementos para el panel de comparar
		JLabel label_comparar_1 = new JLabel("Texto a comparar");
		label_comparar_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_comparar_1.setBounds(320, 11, 120, 20);
		
		JTextArea textArea_comparar_1 = new JTextArea();
		JScrollPane scrollPane_comparar_1 = new JScrollPane(textArea_comparar_1); // Creando un scrollPane para nuestro textArea (textos grandes)
		scrollPane_comparar_1.setBounds(10, 40, 749, 312);
        

		JButton boton_comparar_1 = new JButton("Agregar texto a comparar");
		boton_comparar_1.setBounds(10, 363, 749, 30);
		boton_comparar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// actualiza variable string que sera usada para comparar. y vacia el textArea
			}
		});
		
		JLabel label_comparar_2 = new JLabel("¿Posee un archivo de texto?");
		label_comparar_2.setBounds(210, 404, 170, 30);
		
		JButton boton_comparar_2 = new JButton("Agregar archivo");
		boton_comparar_2.setBounds(390, 404, 369, 30);
		boton_comparar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// seleccionar un archivo, actualiza variable string que sera usada para comparar.
			}
		});
		
		JButton boton_comparar_3 = new JButton("Comparar plagio");
		boton_comparar_3.setBounds(10, 445, 749, 60);
		boton_comparar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// realizar comparacion y redireccion a pestaña de resultados

			}
		});
		
		// añadiendo elementos al panel de comprar
		panel_comparar.add(label_comparar_1);
		panel_comparar.add(scrollPane_comparar_1);
		panel_comparar.add(boton_comparar_1);
		panel_comparar.add(label_comparar_2);
		panel_comparar.add(boton_comparar_2);
		panel_comparar.add(boton_comparar_3);

		
        // añadiendo paneles a nuestro TabbedPane (contentPane)
		contentPane.addTab("Textos", null, panel_textos, null);
		contentPane.addTab("Comparar", null, panel_comparar, null);
		contentPane.addTab("Resultados", null, panel_resultados, null);
		
	}
}
