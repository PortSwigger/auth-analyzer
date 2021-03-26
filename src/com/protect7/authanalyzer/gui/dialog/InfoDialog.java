package com.protect7.authanalyzer.gui.dialog;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import com.protect7.authanalyzer.util.Globals;

public class InfoDialog extends JDialog {
	
	private static final long serialVersionUID = -5052136850829972442L;

	public InfoDialog(Component parent) {
		setTitle(Globals.EXTENSION_NAME + " - About");
		JPanel dialogPanel = (JPanel) getContentPane();
		dialogPanel.setBorder(new EmptyBorder(10, 50, 10, 50));
		dialogPanel.setLayout(new GridLayout(0, 1, 10, 10));
		
		add(new JLabel("<html><strong>Auth Analyzer</strong></html>"));
		add(new JLabel("Version: " + Globals.VERSION));
		add(new JLabel("Developed by: Simon Reinhart"));
		add(new JLabel("Company: Protect7"));

		ImageIcon p7logo = new ImageIcon(this.getClass().getClassLoader().getResource("p7_logo.png"));
		add(new JLabel(p7logo));
		
		JButton helpButton = new JButton("Help");
		helpButton.addActionListener(e -> openWebsite(Globals.URL_GITHUB_README));
		add(helpButton);
		
		JButton issueButton = new JButton("Report an Issue");
		issueButton.addActionListener(e -> openWebsite(Globals.URL_GITHUB_ISSUE));
		add(issueButton);
		
		JButton closeButton = new JButton("OK");
		closeButton.addActionListener(e -> dispose());
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(closeButton);
		add(buttonPanel);
		
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);	
		setVisible(true);
		pack();
		setLocationRelativeTo(parent);
	}
	
	private void openWebsite(String url) {
		try {
			Desktop.getDesktop().browse(new URI(url));
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Browser can not be opened.", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}