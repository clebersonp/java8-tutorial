package com.telusko.learning.thread;

import java.awt.Color;

import javax.swing.JButton;

public abstract class FarolDeTransito {

	private Color color;
	private Long tempo;
	private JButton btnVermelho;
	private JButton btnAmarelo;
	private JButton btnVerde;
	private Color whiteColor = Color.WHITE;
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Long getTempo() {
		return tempo;
	}
	public void setTempo(Long tempo) {
		this.tempo = tempo;
	}
	
	public JButton getBtnVermelho() {
		return btnVermelho;
	}
	public void setBtnVermelho(JButton btnVermelho) {
		this.btnVermelho = btnVermelho;
	}
	
	public JButton getBtnAmarelo() {
		return btnAmarelo;
	}
	public void setBtnAmarelo(JButton btnAmarelo) {
		this.btnAmarelo = btnAmarelo;
	}
	
	public JButton getBtnVerde() {
		return btnVerde;
	}
	public void setBtnVerde(JButton BtnVerde) {
		this.btnVerde = BtnVerde;
	}

	public Color getWhiteColor() {
		return whiteColor;
	}
}