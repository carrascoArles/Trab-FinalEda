package Detectordeplagio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class TestGUI extends JFrame {

	private JTabbedPane contentPane;

	// variables para ejecucion
	List<File> BD = new ArrayList<File>();
	List<String> textosBD = new ArrayList<>();
	Detector detector = new Detector();
	String textoAComparar;
	JTextArea textArea_comparar_1;
	JTextArea textArea_textos_2;

	public static void main(String[] args) {

		try {
			TestGUI frame = new TestGUI();
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			frame.setVisible(true);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public TestGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JTabbedPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		// panel resultados, aca se mostrara los resultados de la verificacion de plagio
		// de nuestro texto con cada texto de la base de datos
		JPanel panel_resultados = new JPanel();
		panel_resultados.setLayout(null);

		// creando elementos para el panel de resultados
		JLabel label_resultados_1 = new JLabel("Resultados");
		label_resultados_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_resultados_1.setBounds(320, 11, 120, 20);

		JPanel panel_aux = new JPanel();

		JScrollPane scrollPane_textos_3 = new JScrollPane(panel_aux); // Creando un scrollPane para nuestro
																				// textArea (textos grandes)
		scrollPane_textos_3.setBounds(10, 50, 749, 462);
		
		JLabel label_resultados_2 = new JLabel("Aqui se mostraran los resultados");
		label_resultados_2.setFont(new Font("Arial", Font.BOLD, 16));
		label_resultados_2.setBounds(10, 50, 749, 462);
		label_resultados_2.setHorizontalAlignment(SwingConstants.CENTER);

		// añadiendo elementos al panel de resultados
		panel_resultados.add(label_resultados_1);
		panel_resultados.add(scrollPane_textos_3);
		panel_aux.add(label_resultados_2);
		// panel_resultados.add(label_resultados_2);

		// panel de textos, aca se introducira los diversos textos que seran comparados
		// con el texto a introducir en panel_comparar
		JPanel panel_textos = new JPanel();
		panel_textos.setLayout(null);

		// creando elementos para el panel de textos
		// JLabel label_textos_1 = new JLabel("Añadir textos");
		// label_textos_1.setHorizontalAlignment(SwingConstants.CENTER);
		// label_textos_1.setBounds(320, 11, 120, 20);

		// JTextArea textArea_textos_1 = new JTextArea();
		// textArea_textos_1.setLineWrap(true);
		// textArea_textos_1.setWrapStyleWord(true);
		// JScrollPane scrollPane_textos_1 = new JScrollPane(textArea_textos_1); // Creando un scrollPane para nuestro
		// 																		// textArea (textos grandes)
		// scrollPane_textos_1.setBounds(10, 40, 749, 312);

		// JButton boton_textos_1 = new JButton("Agregar texto");
		// boton_textos_1.setBounds(10, 363, 749, 30);
		// boton_textos_1.addActionListener(new ActionListener() {
		// 	public void actionPerformed(ActionEvent e) {
		// 		textosBD.add(textArea_textos_1.getText()); // añadimos un texto a nuestro arraylist
		// 		System.out.println(textosBD);
		// 		textArea_textos_1.setText(""); // vaciamos nuestro textArea
		// 	}
		// });

		JLabel label_textos_2 = new JLabel("¿Posee archivos de texto?");
		label_textos_2.setBounds(100, 25, 170, 30);

		JButton boton_textos_2 = new JButton("Agregar archivos");
		boton_textos_2.setBounds(390, 25, 369, 30);
		boton_textos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFilesBD();
				System.out.println(textosBD);
			}
		});

		textArea_textos_2 = new JTextArea("Aqui se mostraran los archivos subidos");
		textArea_textos_2.setEditable(false);
		textArea_textos_2.setLineWrap(true);
		textArea_textos_2.setWrapStyleWord(true);
		textArea_textos_2.setFont(new Font("Arial", Font.PLAIN, 16));
		JScrollPane scrollPane_textos_2 = new JScrollPane(textArea_textos_2); // Creando un scrollPane para nuestro
																				// textArea (textos grandes)
		scrollPane_textos_2.setBounds(10, 80, 749, 420);

		// añadiendo elementos al panel de textos
		//panel_textos.add(label_textos_1);
		// panel_textos.add(scrollPane_textos_1);
		// panel_textos.add(boton_textos_1);
		panel_textos.add(label_textos_2);
		panel_textos.add(boton_textos_2);
		panel_textos.add(scrollPane_textos_2);

		// panel comparar, aca se introducira el texto el cual se comparara con los
		// textos o archivos ingresados en el panel de textos
		JPanel panel_comparar = new JPanel();
		panel_comparar.setLayout(null);

		// creando elementos para el panel de comparar
		JLabel label_comparar_1 = new JLabel("Texto a comparar");
		label_comparar_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_comparar_1.setBounds(320, 11, 120, 20);

		textArea_comparar_1 = new JTextArea();
		textArea_comparar_1.setFont(new Font("Arial", Font.PLAIN, 16));
		textArea_comparar_1.setLineWrap(true);
		textArea_comparar_1.setWrapStyleWord(true);
		JScrollPane scrollPane_comparar_1 = new JScrollPane(textArea_comparar_1); // Creando un scrollPane para nuestro
																					// textArea (textos grandes)
		scrollPane_comparar_1.setBounds(10, 40, 749, 312);

		JButton boton_comparar_1 = new JButton("Insertar texto a comparar");
		boton_comparar_1.setBounds(10, 363, 749, 30);
		boton_comparar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textoAComparar = textArea_comparar_1.getText(); // actualizamos el texto a comparar
				// textArea_comparar_1.setText(""); // vaciamos el textArea
				System.out.println("Texto actual a comparar: " + textoAComparar);
			}
		});

		JLabel label_comparar_2 = new JLabel("¿Posee un archivo de texto?");
		label_comparar_2.setBounds(210, 404, 170, 30);

		JButton boton_comparar_2 = new JButton("Agregar archivo");
		boton_comparar_2.setBounds(390, 404, 369, 30);
		boton_comparar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFileToCompare();
			}
		});

		JButton boton_comparar_3 = new JButton("Comparar plagio");
		boton_comparar_3.setBounds(10, 445, 749, 60);
		boton_comparar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				detector.loadFiles(textosBD);
				ResultArchivo resultado = detector.verifyPlagiarism(textoAComparar, BD);

				boolean[] plagiarismResults = resultado.getResult();
				String[] fileNames = resultado.getFileNames();
				String[] plagiarismInfo = resultado.getPlagiarismInfo();
				String resAux = "";

				for (int i = 0; i < plagiarismResults.length; i++) {
					String colorHex = plagiarismResults[i] ? "#FF0000" : "#008000"; // Cambia el color segun si es
																					// plagio o no

					// Utilizando etiquetas html para asignar color
					String textoAColor = "<FONT COLOR='" + colorHex + "'>" + plagiarismInfo[i] + "</font><br>";

					resAux += fileNames[i] + " Estado: " + textoAColor;
				}

				label_resultados_2.setText("<html>" + resAux + "</html>");
				contentPane.setSelectedComponent(panel_resultados);

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
		contentPane.addTab("Textos BD", null, panel_textos, null);
		contentPane.addTab("Comparar Texto", null, panel_comparar, null);
		contentPane.addTab("Resultados", null, panel_resultados, null);

	}

	private void loadFileToCompare() {
		JFileChooser fileChooser = new JFileChooser();

		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Archivo seleccionado: " + selectedFile.getAbsolutePath());
			textoAComparar = fileToString(selectedFile);
			textArea_comparar_1.setText(textoAComparar);
		}
	}

	private void loadFilesBD() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setMultiSelectionEnabled(true);
		BD.clear();

		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File[] selectedFiles = fileChooser.getSelectedFiles();
			int numArchivosSubidos = 0;
			String nombreArchivosSubidos = "";
			for (File file : selectedFiles) {
				System.out.println("Archivo seleccionado: " + file.getAbsolutePath());
				textosBD.add(fileToString(file));
				BD.add(file);
				numArchivosSubidos++;
				nombreArchivosSubidos += "Archivo " + numArchivosSubidos + " => " + file.getName() + "\n";
			}

			textArea_textos_2.setText("Archivos subidos:\n" + nombreArchivosSubidos);

			String mensaje = "Se subieron correctamente " + numArchivosSubidos + ":\n" + nombreArchivosSubidos;
			JOptionPane.showMessageDialog(null, mensaje);
		}
	}

	private String fileToString(File file) {
		String texto = "";
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				texto += linea;
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return texto;
	}
}
