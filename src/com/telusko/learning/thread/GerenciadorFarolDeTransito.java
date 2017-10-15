package com.telusko.learning.thread;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GerenciadorFarolDeTransito extends JFrame implements Runnable {
	private static final long serialVersionUID = 2753677221307896847L;

	private JButton btnVermelho, btnAmarelo, btnVerde;
	
	public GerenciadorFarolDeTransito() {
		this.setTitle("Farol de transito com threads");
		this.setLayout(new GridLayout(3, 1));
		this.setSize(500, 400);
		this.setLocation(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.btnVermelho = new JButton();
		this.btnAmarelo = new JButton();
		this.btnVerde = new JButton();
		this.add(btnVermelho);
		this.add(btnAmarelo);
		this.add(btnVerde);
		Thread mainThread = new Thread(this);
		mainThread.start();
	}
	
	@Override
	public void run() {
		while (true) {
			Thread farolVermelho = new Thread(new FarolDeTransitoVermelho(btnVermelho, btnAmarelo, btnVerde));
			farolVermelho.start();
			synchronized (farolVermelho) {
				try {
					farolVermelho.wait();
				} catch (InterruptedException e) {
				}
			}
			
			Thread farolVerde = new Thread(new FarolDeTransitoVerde(btnVermelho, btnAmarelo, btnVerde));
			farolVerde.start();
			synchronized (farolVerde) {
				try {
					farolVerde.wait();
				} catch (InterruptedException e) {
				}
			}
			
			Thread farolAmarelo = new Thread(new FarolDeTransitoAmarelo(btnVermelho, btnAmarelo, btnVerde));
			farolAmarelo.start();
			synchronized (farolAmarelo) {
				try {
					farolAmarelo.wait();
				} catch (InterruptedException e) {
				}
			}
		}
	}
}