package Formularios;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class PanelUsuarios extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelUsuarios() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(113, 37, 89, 23);
		add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(15, 38, 96, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblJavaHijoDe = new JLabel("JAVA HIJO DE MIL PUTAAAAAAAAAAAAAA");
		lblJavaHijoDe.setBounds(82, 121, 323, 14);
		add(lblJavaHijoDe);

	}
}
