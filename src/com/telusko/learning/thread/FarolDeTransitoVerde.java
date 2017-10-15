package com.telusko.learning.thread;

import java.awt.Color;

import javax.swing.JButton;

public class FarolDeTransitoVerde extends FarolDeTransito implements Runnable {

	public FarolDeTransitoVerde(JButton btnVermelho, JButton btnAmarelo, JButton btnVerde) {
		this.setColor(Color.GREEN);
		this.setTempo(3000L);
		this.setBtnVermelho(btnVermelho);
		this.setBtnAmarelo(btnAmarelo);
		this.setBtnVerde(btnVerde);
	}
	
	@Override
	public void run() {
		synchronized (this) {
			this.getBtnVerde().setBackground(this.getColor());
			this.getBtnAmarelo().setBackground(this.getWhiteColor());
			this.getBtnVermelho().setBackground(this.getWhiteColor());
			try {
				Thread.sleep(this.getTempo());
			} catch (InterruptedException e) {
			}
			notifyAll();
		}
	}
}
