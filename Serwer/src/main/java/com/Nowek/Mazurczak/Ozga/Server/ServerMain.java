package com.Nowek.Mazurczak.Ozga.Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.Nowek.Mazurczak.Ozga.Klient.Okno;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import org.apache.log4j.Logger;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class ServerMain {
	
	private JFrame frame;
	private static final Logger logger=Logger.getLogger(ServerMain.class);
	/**
	 * uruchamia aplikacje.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerMain window = new ServerMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		});
	}
	
	/**
	 * Tworzy okno .
	 */
	public ServerMain() {
		initialize();
	}

	/**
	 * Inicjalizuje okno aplikacji i uruchamia serwer.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_1 = new JLabel("Serwer Uruchomiony");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 44));
		frame.getContentPane().add(lblNewLabel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Serwer uruchomiony");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		
		
		
		
		
		System.out.println("Serwer uruchomiony!");
		try {
		
				Server.initialize();
				Server.activeWaiting();
			} catch (IOException ee) {
				// TODO Auto-generated catch block
				logger.error(ee);
			}
		
			

	}
}
