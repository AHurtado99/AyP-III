package com.ucab.juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Juego partida =new Juego();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				Ventana window = new Ventana();
				try {
					window.Imprimir(partida);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		frame = new JFrame();
	}
	
	public void Mazo(Juego partida) {
		
	}
	/**
	 * Initialize the contents of the frame.**/
	private void Imprimir(Juego partida) {
		
		frame.setBounds(100, 100, 525, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton[] Mazo = new JButton[2];
		
		Mazo[0] = new JButton(" "+partida.newcartas[0].valor()+" ");
		Mazo[0].setEnabled(false);
		Mazo[0].grabFocus();
		Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
		Mazo[0].setBounds(243, 350, 100, 75);
		frame.getContentPane().add(Mazo[0]);
		
		Mazo[1]= new JButton(""+partida.newcartas[1].valor()+"");
		Mazo[1].setHorizontalAlignment(SwingConstants.LEFT);
		Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
		Mazo[1].setEnabled(false);
		Mazo[1].setBounds(180, 350, 63, 75);
		frame.getContentPane().add(Mazo[1]);
		
		JTextPane Header = new JTextPane();
		Header.setEditable(false);
		Header.setForeground(Color.BLACK);
		Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
		Header.setBounds(25, 25, 475, 25);
		frame.getContentPane().add(Header);
		
		JButton Comodin1 = new JButton();
		Comodin1.setText("Botar carta");
		Comodin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partida.AumentarComodines();
				partida.comodines[1]=0;
				partida.newcartas[0]=partida.newcartas[1];
				partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
				Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
				frame.getContentPane().add(Mazo[0]);
				
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				frame.getContentPane().add(Mazo[1]);
				
				Comodin1.setText(""+(int)(40-partida.comodines[1]));
				Comodin1.setEnabled(false);
				Comodin1.setBackground(Color.RED);
				frame.getContentPane().add(Comodin1);
				
			}
		});
		Comodin1.setBounds(375, 400, 125, 25);
		frame.getContentPane().add(Comodin1);
		
		JButton Comodin2 = new JButton();
		Comodin2.setText("Botar carta");
		Comodin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partida.AumentarComodines();
				partida.comodines[2]=0;
				partida.newcartas[0]=partida.newcartas[1];
				partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
				Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
				Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
				frame.getContentPane().add(Mazo[0]);
				
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
				frame.getContentPane().add(Mazo[1]);
				
				Comodin2.setText(""+(int)(40-partida.comodines[2]));
				Comodin2.setEnabled(false);
				Comodin2.setBackground(Color.RED);
				frame.getContentPane().add(Comodin2);
			}
		});
		Comodin2.setBounds(375, 350, 125, 25);
		frame.getContentPane().add(Comodin2);

		JButton BackBtn = new JButton("Volver");
		BackBtn.setBounds(25, 375, 125, 25);
		frame.getContentPane().add(BackBtn);
		
		
		int j =1,x=25;
		while (j<5) {
			int y=75;
			if(partida.Columnas[j].cantidad>0) {
				int i=0;
				while(partida.Columnas[j].cartas[i]!=null) {
					if(i+1!=partida.Columnas[j].cantidad) {
						JButton Carta = new JButton();
						Carta.setText(" "+partida.Columnas[j].cartas[i].valor());
						Carta.setEnabled(false);
						Carta.setBackground(Color.decode(partida.Columnas[j].cartas[i].getColor()));
						Carta.setVerticalAlignment(SwingConstants.TOP);
						Carta.setBounds(x+(150*(j-1)), y, 100, 25);
						frame.getContentPane().add(Carta);
					}
					else {
						JButton Carta = new JButton();
						Carta.setText(" "+partida.Columnas[j].cartas[i].valor()+" ");
						Carta.setBackground(Color.decode(partida.Columnas[j].cartas[i].getColor()));
						Carta.setBounds(x+(150*(j-1)), y, 100, 75);
						Carta.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								partida.AumentarComodines();
								partida.AgregarCarta(1, partida.newcartas[0].getNumero());
								partida.newcartas[0]=partida.newcartas[1];
								partida.newcartas[1]=new carta(/*(int) (Math.random()*6)+1*/ 9);
								
								Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
								frame.getContentPane().add(Mazo[0]);
								
								Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
								frame.getContentPane().add(Mazo[1]);
								
								Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
								frame.getContentPane().add(Header);
							}
						});
						frame.getContentPane().add(Carta);
					}
					i++;
					y+=25;
				}
			}else {
				JButton Vacio = new JButton(" Vacio ");
				Vacio.setBackground(Color.BLACK);
				Vacio.setForeground(Color.WHITE);
				Vacio.setBounds(x, y, 50, 75);
				Vacio.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						partida.AgregarCarta(1, partida.newcartas[0].getNumero());
						partida.newcartas[0]=partida.newcartas[1];
						partida.newcartas[1]=new carta(/*(int) (Math.random()*6)+1*/ 9);
						if(partida.comodines[1]>39) {
							Comodin1.setText("Botar carta");
							Comodin1.setEnabled(true);
							Comodin1.setBackground(Color.BLUE);
							frame.getContentPane().add(Comodin1);
						}else {
							Comodin1.setText(""+(int)(40-partida.comodines[1]));
							frame.getContentPane().add(Comodin1);
						}
						if(partida.comodines[2]>39) {
							Comodin2.setText("Botar carta");
							Comodin2.setEnabled(true);
							Comodin2.setBackground(Color.BLUE);
							frame.getContentPane().add(Comodin2);
						}else {
							Comodin2.setText(""+(int)(40-partida.comodines[2]));
							frame.getContentPane().add(Comodin2);
						}
						
						Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
						frame.getContentPane().add(Mazo[0]);
						
						Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
						frame.getContentPane().add(Mazo[1]);
						
						Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
						frame.getContentPane().add(Header);
					}
				});
				frame.getContentPane().add(Vacio);
			}
			j++;x+=150;
		}
	}
}
