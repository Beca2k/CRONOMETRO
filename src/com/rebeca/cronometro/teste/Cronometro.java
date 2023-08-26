package com.rebeca.cronometro.teste;
import java.awt.EventQueue;
import com.rebeca.cronometro.ui.UiPrincipal;

public class Cronometro {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				UiPrincipal principal = new UiPrincipal();
				principal.mostrar();
			}
		});
	}
}
