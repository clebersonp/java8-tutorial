package com.telusko.learning.thread;

import java.awt.Color;

import javax.swing.JButton;

public class FarolDeTransitoAmarelo extends FarolDeTransito implements Runnable {

	public FarolDeTransitoAmarelo(JButton btnVermelho, JButton btnAmarelo, JButton btnVerde) {
		this.setColor(Color.YELLOW);
		this.setTempo(800L);
		this.setBtnVermelho(btnVermelho);
		this.setBtnAmarelo(btnAmarelo);
		this.setBtnVerde(btnVerde);
	}
	
	@Override
	public void run() {
		synchronized (this) {
			int i = 0;
			while (i < 5) {
				this.getBtnAmarelo().setBackground(this.getColor());
				this.getBtnVermelho().setBackground(this.getWhiteColor());
				this.getBtnVerde().setBackground(this.getWhiteColor());
				try {
					Thread.sleep(this.getTempo());
					this.getBtnAmarelo().setBackground(this.getWhiteColor());
					Thread.sleep(500L);
				} catch (InterruptedException e) {
				}
				i++;
			}
			notifyAll();
		}
	}
}
