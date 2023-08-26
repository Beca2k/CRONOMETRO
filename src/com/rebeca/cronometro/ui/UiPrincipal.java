package com.rebeca.cronometro.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class UiPrincipal {
	private JFrame frmCronometro;
	private JTextField textContagem;
	private Timer timer;
	int s = 0;
	int m = 0;
	int h = 0;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public UiPrincipal() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmCronometro = new JFrame();
		frmCronometro.setBackground(new Color(240, 240, 240));
		frmCronometro
				.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\dev\\Pictures\\IconeCronometro.jpg"));
		frmCronometro.setTitle("Cronometro");
		frmCronometro.getContentPane().setBackground(new Color(20, 214, 155));
		frmCronometro.getContentPane().setLayout(null);

		textContagem = new JTextField();
		textContagem.setEditable(false);
		textContagem.setBackground(new Color(243, 216, 150));
		textContagem.setForeground(new Color(0, 0, 0));
		textContagem.setFont(new Font("Tahoma", Font.PLAIN, 41));
		textContagem.setHorizontalAlignment(SwingConstants.CENTER);
		textContagem.setText("00:00:00");
		textContagem.setBounds(50, 50, 326, 59);
		frmCronometro.getContentPane().add(textContagem);
		textContagem.setColumns(10);

		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
				s++;
			}
		});
		btnIniciar.setBackground(new Color(241, 182, 41));
		btnIniciar.setBounds(50, 173, 89, 31);
		frmCronometro.getContentPane().add(btnIniciar);

		JButton btnResetar = new JButton("RESETAR");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				h = 0;
				s = 0;
				m = 0;
				textContagem.setText("00:00:00");
			}
		});
		btnResetar.setBackground(new Color(241, 182, 41));
		btnResetar.setBounds(287, 173, 89, 31);
		frmCronometro.getContentPane().add(btnResetar);

		JButton btnPausar = new JButton("PAUSAR");
		btnPausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
			}
		});
		
		timer = new Timer(800, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String segundos = String.valueOf(s).length() < 2 ? "0" + String.valueOf(s) : String.valueOf(s);
				String minutos = String.valueOf(m).length() < 2 ? "0" + String.valueOf(m) : String.valueOf(m);
				String hora = String.valueOf(h).length() < 2 ? "0" + String.valueOf(h) : String.valueOf(h);

				textContagem.setText(hora + ":" + minutos + ":" + segundos);
				s++;
				if (s == 60) {
					s = 0;
					m++;
					textContagem.setText(hora + ":" + minutos + ":" + segundos);
				}
				if (m == 60) {
					h++;
					m = 0;
					textContagem.setText(hora + ":" + minutos + ":" + segundos);
				}
			}
		});
		btnPausar.setBackground(new Color(241, 182, 41));
		btnPausar.setBounds(169, 173, 89, 31);
		frmCronometro.getContentPane().add(btnPausar);
		frmCronometro.setBounds(100, 100, 450, 300);
		frmCronometro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void mostrar() {
		frmCronometro.setVisible(true);
	}
}