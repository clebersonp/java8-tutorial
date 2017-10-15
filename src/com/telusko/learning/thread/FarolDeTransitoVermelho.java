package com.telusko.learning.thread;

import java.awt.Color;

import javax.swing.JButton;

public class FarolDeTransitoVermelho extends FarolDeTransito implements Runnable {

	public FarolDeTransitoVermelho(JButton btnVermelho, JButton btnAmarelo, JButton btnVerde) {
		this.setColor(Color.RED);
		this.setTempo(5000L);
		this.setBtnVermelho(btnVermelho);
		this.setBtnAmarelo(btnAmarelo);
		this.setBtnVerde(btnVerde);
	}
	
	@Override
	public void run() {
		synchronized (this) {
			this.getBtnVermelho().setBackground(this.getColor());
			this.getBtnAmarelo().setBackground(this.getWhiteColor());
			this.getBtnVerde().setBackground(this.getWhiteColor());
			try {
				Thread.sleep(this.getTempo());
			} catch (InterruptedException e) {
			}
			notifyAll();
		}
	}
}
