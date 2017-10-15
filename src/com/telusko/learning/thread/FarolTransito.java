package com.telusko.learning.thread;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FarolTransito extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JButton vermelho, amarelo, verde;

	public FarolTransito() {
		this.setTitle("Farol de transito");
		this.setSize(300, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500, 200);
		this.setLayout(new GridLayout(3, 1));
		this.vermelho = new JButton();
		this.amarelo = new JButton();
		this.verde = new JButton();
		this.add(vermelho);
		this.add(amarelo);
		this.add(verde);
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			Thread farolVermelho = new Thread(new FarolVermelho());
			farolVermelho.start();
			synchronized (farolVermelho) {
				try {
					farolVermelho.wait();
				} catch (InterruptedException e) {
				}
			}
			
			Thread farolVerde = new Thread(new FarolVerde());
			farolVerde.start();
			synchronized (farolVerde) {
				try {
					farolVerde.wait();
				} catch (InterruptedException e) {
				}
			}
			
			Thread farolAmarelo = new Thread(new FarolAmarelo());
			farolAmarelo.start();
			synchronized (farolAmarelo) {
				try {
					farolAmarelo.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new FarolTransito().setVisible(true);
	}
	
	class FarolVermelho implements Runnable {
		
		@Override
		public void run() {
			synchronized (this) {
				vermelho.setBackground(Color.RED);
				amarelo.setBackground(Color.WHITE);
				verde.setBackground(Color.WHITE);
				try {
					Thread.sleep(FarolTempoEnum.VERMELHO.getTempo());
				} catch (InterruptedException e) {
				}
				notify();
			}
		}
	}
	
	class FarolAmarelo implements Runnable {
		
		@Override
		public void run() {
			synchronized (this) {
				amarelo.setBackground(Color.YELLOW);
				vermelho.setBackground(Color.WHITE);
				verde.setBackground(Color.WHITE);
				try {
					Thread.sleep(FarolTempoEnum.AMARELO.getTempo());
				} catch (InterruptedException e) {
				}
				notify();
			}
		}
	}
	
	class FarolVerde implements Runnable {
		
		@Override
		public void run() {
			synchronized (this) {
				verde.setBackground(Color.GREEN);
				vermelho.setBackground(Color.WHITE);
				amarelo.setBackground(Color.WHITE);
				try {
					Thread.sleep(FarolTempoEnum.VERDE.getTempo());
				} catch (InterruptedException e) {
				}
				notify();
			}
		}
	}
	
	enum FarolTempoEnum {
		VERMELHO(5000L),
		AMARELO(2000L),
		VERDE(3000L);
		
		private Long tempo;
		
		private FarolTempoEnum(Long tempo) {
			this.tempo = tempo;
		}
		public Long getTempo() {
			return this.tempo;
		}
	}
}