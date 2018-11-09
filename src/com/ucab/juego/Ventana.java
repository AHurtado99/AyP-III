package com.ucab.juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Ventana {

	private JFrame frame;
	private Juego partidaAnterior;
	private Juego partida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
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
		frame.setBounds(500, 100, 525, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		partida = new Juego();/*
		partida.AgregarCarta(1, 10);
		partida.AgregarCarta(2, 10);
		partida.AgregarCarta(3, 10);
		partida.AgregarCarta(4, 10);*/
		partidaAnterior = partida;
		Imprimir();
	}

	/**
	 * Initialize the contents of the frame.**/
	private void Imprimir() {
		
		
		JLabel NuevoMultiplicador = new JLabel();
		NuevoMultiplicador.setFont(new Font("URW Chancery L", Font.ITALIC, 33));
		NuevoMultiplicador.setBounds(0, 0, 525, 650);
		NuevoMultiplicador.setHorizontalAlignment(SwingConstants.CENTER);
		NuevoMultiplicador.setVerticalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(NuevoMultiplicador);
		
		JButton[] Mazo = new JButton[2];
		
		Mazo[0] = new JButton(" "+partida.newcartas[0].valor()+" ");
		Mazo[0].setHorizontalAlignment(SwingConstants.LEFT);
		Mazo[0].setVerticalAlignment(SwingConstants.TOP);
		Mazo[0].setRolloverEnabled(false);
		Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
		Mazo[0].setForeground(Color.BLACK);
		Mazo[0].setBounds(243, 450, 100, 150);
		frame.getContentPane().add(Mazo[0]);
		
		Mazo[1]= new JButton(""+partida.newcartas[1].valor()+"");
		Mazo[1].setHorizontalAlignment(SwingConstants.LEFT);
		Mazo[1].setVerticalAlignment(SwingConstants.TOP);
		Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
		Mazo[1].setForeground(Color.BLACK);
		Mazo[1].setRolloverEnabled(false);
		Mazo[1].setBounds(183, 450, 60, 150);
		frame.getContentPane().add(Mazo[1]);
		
		JTextPane Header = new JTextPane();
		Header.setEditable(false);
		Header.setForeground(Color.BLACK);
		Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
		Header.setBounds(25, 25, 450, 25);
		frame.getContentPane().add(Header);
		
		JButton Comodin1 = new JButton();
		Comodin1.setText("Botar carta");
		Comodin1.setBackground(Color.BLUE);
		Comodin1.setForeground(Color.WHITE);
		Comodin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partidaAnterior = partida;
				partida.AumentarComodines();
				partida.comodines[1]=0;
				partida.newcartas[0]=partida.newcartas[1];
				partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
				Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
				Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
				Comodin1.setText(""+(int)(40-partida.comodines[1]));
				Comodin1.setEnabled(false);
				Comodin1.setBackground(Color.RED);
				frame.repaint();
			}
		});
		Comodin1.setBounds(400, 475, 100, 50);
		frame.getContentPane().add(Comodin1);
		
		JButton Comodin2 = new JButton();
		Comodin2.setText("Botar carta");
		Comodin2.setBackground(Color.BLUE);
		Comodin2.setForeground(Color.WHITE);
		Comodin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partidaAnterior = partida;
				partida.AumentarComodines();
				partida.comodines[2]=0;
				partida.newcartas[0]=partida.newcartas[1];
				partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
				Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
				Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
				Comodin2.setText(""+(int)(40-partida.comodines[2]));
				Comodin2.setEnabled(false);
				Comodin2.setBackground(Color.RED);
				frame.repaint();
			}
		});
		Comodin2.setBounds(400, 525, 100, 50);
		frame.getContentPane().add(Comodin2);

		JButton BackBtn = new JButton("Volver");
		BackBtn.setBounds(25, 500, 100, 50);
		frame.getContentPane().add(BackBtn);
		
		int  y=75;
		JButton[] Carta1 = new JButton[8];
		JButton[] Carta2 = new JButton[8];
		JButton[] Carta3 = new JButton[8];
		JButton[] Carta4 = new JButton[8];

		JButton Vacio1 = new JButton(" Vacio ");
		JButton Vacio2 = new JButton(" Vacio ");
		JButton Vacio3 = new JButton(" Vacio ");
		JButton Vacio4 = new JButton(" Vacio ");
		
		int b=0;
		while(b<8) {
			Carta1[b] = new JButton();
			Carta2[b] = new JButton();
			Carta3[b] = new JButton();
			Carta4[b] = new JButton();
			b++;
		}
		if(partida.Columnas[1].cantidad>0) {
			int i=0;
			while(partida.Columnas[1].cartas[i]!=null) {
				if(partida.Columnas[1].cantidad>i+1) {
					Carta1[i].setText(" "+partida.Columnas[1].cartas[i].valor());
					Carta1[i].setRolloverEnabled(false);
					Carta1[i].setBackground(Color.decode(partida.Columnas[1].cartas[i].getColor()));
					Carta1[i].setForeground(Color.BLACK);
					Carta1[i].setHorizontalAlignment(SwingConstants.LEFT);
					Carta1[i].setVerticalAlignment(SwingConstants.TOP);
					Carta1[i].setBounds(25, y, 100, 25);
					frame.getContentPane().add(Carta1[i]);
				}if(partida.Columnas[1].cantidad==i+1)  {
					frame.remove(Carta1[i]);
					Vacio1.setText(" "+partida.Columnas[1].cartas[i].valor()+" ");
					Vacio1.setBackground(Color.decode(partida.Columnas[1].cartas[i].getColor()));
					Vacio1.setHorizontalAlignment(SwingConstants.LEFT);
					Vacio1.setVerticalAlignment(SwingConstants.TOP);
					Vacio1.setForeground(Color.BLACK);
					Vacio1.setBounds(25, y, 100, 150);
				}
				i++;
				y+=25;
			}
		}else {
			Vacio1.setHorizontalAlignment(SwingConstants.CENTER);
			Vacio1.setVerticalAlignment(SwingConstants.CENTER);
			Vacio1.setBackground(Color.BLACK);
			Vacio1.setForeground(Color.WHITE);
			Vacio1.setBounds(25, y, 100, 150);
		}
		y=75;
		if(partida.Columnas[2].cantidad>0) {
			int i=0;
			while(partida.Columnas[2].cartas[i]!=null) {
				if(partida.Columnas[2].cantidad>i+1) {
					Carta2[i].setText(" "+partida.Columnas[2].cartas[i].valor());
					Carta2[i].setRolloverEnabled(false);
					Carta2[i].setBackground(Color.decode(partida.Columnas[2].cartas[i].getColor()));
					Carta2[i].setForeground(Color.BLACK);
					Carta2[i].setHorizontalAlignment(SwingConstants.LEFT);
					Carta2[i].setVerticalAlignment(SwingConstants.TOP);
					Carta2[i].setBounds(150, y, 100, 25);
					frame.getContentPane().add(Carta1[i]);
				}if(partida.Columnas[2].cantidad==i+1)  {
					frame.remove(Carta2[i]);
					Vacio2.setText(" "+partida.Columnas[2].cartas[i].valor()+" ");
					Vacio2.setBackground(Color.decode(partida.Columnas[2].cartas[i].getColor()));
					Vacio2.setHorizontalAlignment(SwingConstants.LEFT);
					Vacio2.setVerticalAlignment(SwingConstants.TOP);
					Vacio2.setForeground(Color.BLACK);
					Vacio2.setBounds(150, y, 100, 150);
				}
				i++;
				y+=25;
			}
		}else {
			Vacio2.setBackground(Color.BLACK);
			Vacio2.setForeground(Color.WHITE);
			Vacio2.setHorizontalAlignment(SwingConstants.CENTER);
			Vacio2.setVerticalAlignment(SwingConstants.CENTER);
			Vacio2.setBounds(150, y, 100, 150);
		}
		y=75;
		if(partida.Columnas[3].cantidad>0) {
			int i=0;
			while(partida.Columnas[3].cartas[i]!=null) {
				if(partida.Columnas[3].cantidad>i+1) {
					Carta3[i].setText(" "+partida.Columnas[3].cartas[i].valor());
					Carta3[i].setRolloverEnabled(false);
					Carta3[i].setBackground(Color.decode(partida.Columnas[3].cartas[i].getColor()));
					Carta3[i].setForeground(Color.BLACK);
					Carta3[i].setHorizontalAlignment(SwingConstants.LEFT);
					Carta3[i].setVerticalAlignment(SwingConstants.TOP);
					Carta3[i].setBounds(275, y, 100, 25);
					frame.getContentPane().add(Carta3[i]);
				}if(partida.Columnas[3].cantidad==i+1)  {
					frame.remove(Carta3[i]);
					Vacio3.setText(" "+partida.Columnas[3].cartas[i].valor()+" ");
					Vacio3.setBackground(Color.decode(partida.Columnas[3].cartas[i].getColor()));
					Vacio3.setHorizontalAlignment(SwingConstants.LEFT);
					Vacio3.setVerticalAlignment(SwingConstants.TOP);
					Vacio3.setForeground(Color.BLACK);
					Vacio3.setBounds(275, y, 100, 150);
				}
				i++;
				y+=25;
			}
		}else {
			Vacio3.setBackground(Color.BLACK);
			Vacio3.setForeground(Color.WHITE);
			Vacio3.setHorizontalAlignment(SwingConstants.CENTER);
			Vacio3.setVerticalAlignment(SwingConstants.CENTER);
			Vacio3.setBounds(275, y, 100, 150);
		}
		y=75;
		if(partida.Columnas[4].cantidad>0){
			int i=0;
			while(partida.Columnas[4].cartas[i]!=null) {
				if(partida.Columnas[4].cantidad>i+1) {
					Carta4[i].setText(" "+partida.Columnas[4].cartas[i].valor());
					Carta4[i].setRolloverEnabled(false);
					Carta4[i].setBackground(Color.decode(partida.Columnas[4].cartas[i].getColor()));
					Carta4[i].setForeground(Color.BLACK);
					Carta4[i].setHorizontalAlignment(SwingConstants.LEFT);
					Carta4[i].setVerticalAlignment(SwingConstants.TOP);
					Carta4[i].setBounds(400, y, 100, 25);
					frame.getContentPane().add(Carta4[i]);
				}if(partida.Columnas[4].cantidad==i+1)  {
					frame.remove(Carta4[i]);
					Vacio4.setText(" "+partida.Columnas[4].cartas[i].valor()+" ");
					Vacio4.setBackground(Color.decode(partida.Columnas[4].cartas[i].getColor()));
					Vacio4.setHorizontalAlignment(SwingConstants.LEFT);
					Vacio4.setVerticalAlignment(SwingConstants.TOP);
					Vacio4.setForeground(Color.BLACK);
					Vacio4.setBounds(400, y, 100, 150);
				}
				i++;
				y+=25;
			}
		}else{
			Vacio4.setBackground(Color.BLACK);
			Vacio4.setForeground(Color.WHITE);
			Vacio4.setHorizontalAlignment(SwingConstants.CENTER);
			Vacio4.setVerticalAlignment(SwingConstants.CENTER);
			Vacio4.setBounds(400, y, 100, 150);
		}
		Vacio1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partidaAnterior = partida;
				if(partida.Columnas[1].cantidad<8 || partida.Columnas[1].ultima==partida.newcartas[0].getNumero()) {
					partida.AgregarCarta(1, partida.newcartas[0].getNumero());
					partida.newcartas[0]=partida.newcartas[1];
					partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
					if(partida.comodines[1]>39) {
						Comodin1.setText("Botar carta");
						Comodin1.setEnabled(true);
						Comodin1.setBackground(Color.BLUE);
					}else {
						Comodin1.setText(""+(int)(40-partida.comodines[1]));
					}
					if(partida.comodines[2]>39) {
						Comodin2.setText("Botar carta");
						Comodin2.setEnabled(true);
						Comodin2.setBackground(Color.BLUE);
					}else {
						Comodin2.setText(""+(int)(40-partida.comodines[2]));
					}
					Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
					Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
					Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
					Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
					Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
					int i=0, y=75;
					while(i<8) {
						if(partida.Columnas[1].cantidad>i+1) {
							Carta1[i].setText(" "+partida.Columnas[1].cartas[i].valor());
							Carta1[i].setRolloverEnabled(false);
							Carta1[i].setBackground(Color.decode(partida.Columnas[1].cartas[i].getColor()));
							Carta1[i].setForeground(Color.BLACK);
							Carta1[i].setHorizontalAlignment(SwingConstants.LEFT);
							Carta1[i].setVerticalAlignment(SwingConstants.TOP);
							Carta1[i].setBounds(25, y, 100, 25);
							frame.getContentPane().add(Carta1[i]);
						}if(partida.Columnas[1].cantidad==i+1)  {
							frame.remove(Carta1[i]);
							Vacio1.setText(" "+partida.Columnas[1].cartas[i].valor()+" ");
							Vacio1.setBackground(Color.decode(partida.Columnas[1].cartas[i].getColor()));
							Vacio1.setHorizontalAlignment(SwingConstants.LEFT);
							Vacio1.setVerticalAlignment(SwingConstants.TOP);
							Vacio1.setForeground(Color.BLACK);
							Vacio1.setBounds(25, y, 100, 150);
							frame.getContentPane().add(Vacio1);
						}if(partida.Columnas[1].cantidad<i+1)   {
							if(i==0) {
								Vacio1.setText(" Vacio ");
								Vacio1.setBackground(Color.BLACK);
								Vacio1.setForeground(Color.WHITE);
								Vacio1.setHorizontalAlignment(SwingConstants.CENTER);
								Vacio1.setVerticalAlignment(SwingConstants.CENTER);
								Vacio1.setBounds(25, y, 100, 150);
								frame.getContentPane().add(Vacio1);
							}
							frame.remove(Carta1[i]);	
						}
						y+=25;
						i++;
					}
					frame.repaint();
				}else {frame.addNotify();
				}
			}
		});
		frame.getContentPane().add(Vacio1);
		Vacio2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			partidaAnterior = partida;
			if(partida.Columnas[2].cantidad<8 || partida.Columnas[2].ultima==partida.newcartas[0].getNumero()) {
				partida.AgregarCarta(2, partida.newcartas[0].getNumero());
				partida.newcartas[0]=partida.newcartas[1];
				partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
				if(partida.comodines[1]>39) {
					Comodin1.setText("Botar carta");
					Comodin1.setEnabled(true);
					Comodin1.setBackground(Color.BLUE);
				}else {
					Comodin1.setText(""+(int)(40-partida.comodines[1]));
				}
				if(partida.comodines[2]>39) {
					Comodin2.setText("Botar carta");
					Comodin2.setEnabled(true);
					Comodin2.setBackground(Color.BLUE);
				}else {
					Comodin2.setText(""+(int)(40-partida.comodines[2]));
				}
				Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
				Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
				Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
				int i=0, y=75;
				while(i<8) {
					if(partida.Columnas[2].cantidad>i+1) {
						Carta2[i].setText(" "+partida.Columnas[2].cartas[i].valor());
						Carta2[i].setRolloverEnabled(false);
						Carta2[i].setBackground(Color.decode(partida.Columnas[2].cartas[i].getColor()));
						Carta2[i].setForeground(Color.BLACK);
						Carta2[i].setVerticalAlignment(SwingConstants.TOP);
						Carta2[i].setHorizontalAlignment(SwingConstants.LEFT);
						Carta2[i].setBounds(150, y, 100, 25);
						frame.getContentPane().add(Carta2[i]);
					}if(partida.Columnas[2].cantidad==i+1)  {
						frame.remove(Carta2[i]);
						Vacio2.setText(" "+partida.Columnas[2].cartas[i].valor()+" ");
						Vacio2.setBackground(Color.decode(partida.Columnas[2].cartas[i].getColor()));
						Vacio2.setHorizontalAlignment(SwingConstants.LEFT);
						Vacio2.setVerticalAlignment(SwingConstants.TOP);
						Vacio2.setForeground(Color.BLACK);
						Vacio2.setBounds(150, y, 100, 150);
						frame.getContentPane().add(Vacio2);
					}if(partida.Columnas[2].cantidad<i+1)   {
						if(i==0){
							Vacio2.setText(" Vacio ");
							Vacio2.setBackground(Color.BLACK);
							Vacio2.setForeground(Color.WHITE);
							Vacio2.setHorizontalAlignment(SwingConstants.CENTER);
							Vacio2.setVerticalAlignment(SwingConstants.CENTER);
							Vacio2.setBounds(150, y, 100, 150);
							frame.getContentPane().add(Vacio2);
						}
						frame.remove(Carta2[i]);
					}
					y+=25;
					i++;
				}
				frame.repaint();
			}else frame.addNotify();
		}
	});
		frame.getContentPane().add(Vacio2);
		Vacio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partidaAnterior = partida;
				if(partida.Columnas[3].cantidad<8 || partida.Columnas[3].ultima==partida.newcartas[0].getNumero()) {
					partida.AgregarCarta(3, partida.newcartas[0].getNumero());
					partida.newcartas[0]=partida.newcartas[1];
					partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
					if(partida.comodines[1]>39) {
						Comodin1.setText("Botar carta");
						Comodin1.setEnabled(true);
						Comodin1.setBackground(Color.BLUE);
					}else {
						Comodin1.setText(""+(int)(40-partida.comodines[1]));
					}
					if(partida.comodines[2]>39) {
						Comodin2.setText("Botar carta");
						Comodin2.setEnabled(true);
						Comodin2.setBackground(Color.BLUE);
					}else {
						Comodin2.setText(""+(int)(40-partida.comodines[2]));
					}
					Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
					Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
					Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
					Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
					Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
					int i=0, y=75;
					while(i<8) {
						if(partida.Columnas[3].cantidad>i+1) {
							Carta3[i].setText(" "+partida.Columnas[3].cartas[i].valor());
							Carta3[i].setRolloverEnabled(false);
							Carta3[i].setBackground(Color.decode(partida.Columnas[3].cartas[i].getColor()));
							Carta3[i].setForeground(Color.BLACK);
							Carta3[i].setVerticalAlignment(SwingConstants.TOP);
							Carta3[i].setBounds(275, y, 100, 25);
							Carta3[i].setHorizontalAlignment(SwingConstants.LEFT);
							frame.getContentPane().add(Carta3[i]);
						}if(partida.Columnas[3].cantidad==i+1)  {
							frame.remove(Carta3[i]);
							Vacio3.setText(" "+partida.Columnas[3].cartas[i].valor()+" ");
							Vacio3.setBackground(Color.decode(partida.Columnas[3].cartas[i].getColor()));
							Vacio3.setForeground(Color.BLACK);
							Vacio3.setHorizontalAlignment(SwingConstants.LEFT);
							Vacio3.setVerticalAlignment(SwingConstants.TOP);
							Vacio3.setBounds(275, y, 100, 150);
							frame.getContentPane().add(Vacio3);
						}if(partida.Columnas[3].cantidad<i+1)   {
							if(i==0) {
								Vacio3.setText(" Vacio ");
								Vacio3.setBackground(Color.BLACK);
								Vacio3.setForeground(Color.WHITE);
								Vacio3.setHorizontalAlignment(SwingConstants.CENTER);
								Vacio3.setVerticalAlignment(SwingConstants.CENTER);
								Vacio3.setBounds(275, y, 100, 150);
								frame.getContentPane().add(Vacio3);
							}
							frame.remove(Carta3[i]);	
						}
						y+=25;
						i++;
					}
					frame.repaint();
				}else frame.addNotify();
			}
		});
		frame.getContentPane().add(Vacio3);
		Vacio4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				partidaAnterior = partida;
				if(partida.Columnas[4].cantidad<8 || partida.Columnas[4].ultima==partida.newcartas[0].getNumero()) {
				partida.AgregarCarta(4, partida.newcartas[0].getNumero());
				partida.newcartas[0]=partida.newcartas[1];
				partida.newcartas[1]=new carta((int) (Math.random()*6)+1);
				if(partida.comodines[1]>39) {
					Comodin1.setText("Botar carta");
					Comodin1.setEnabled(true);
					Comodin1.setBackground(Color.BLUE);
				}else {
					Comodin1.setText(""+(int)(40-partida.comodines[1]));
				}
				if(partida.comodines[2]>39) {
					Comodin2.setText("Botar carta");
					Comodin2.setEnabled(true);
					Comodin2.setBackground(Color.BLUE);
				}else {
					Comodin2.setText(""+(int)(40-partida.comodines[2]));
				}
				Mazo[0].setText(" "+partida.newcartas[0].valor()+" ");
				Mazo[0].setBackground(Color.decode(partida.newcartas[0].getColor()));
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
				Header.setText("Record:"+partida.record+"	Score:"+partida.score+"	X"+partida.multiplicador);
				int i=0, y=75;
				while(i<8) {
					if(partida.Columnas[4].cantidad>i+1) {
						Carta4[i].setText(" "+partida.Columnas[4].cartas[i].valor());
						Carta4[i].setRolloverEnabled(false);
						Carta4[i].setBackground(Color.decode(partida.Columnas[4].cartas[i].getColor()));
						Carta4[i].setForeground(Color.BLACK);
						Carta4[i].setVerticalAlignment(SwingConstants.TOP);
						Carta4[i].setHorizontalAlignment(SwingConstants.LEFT);
						Carta4[i].setBounds(400, y, 100, 25);
						frame.getContentPane().add(Carta4[i]);
					}if(partida.Columnas[4].cantidad==i+1)  {
						frame.remove(Carta4[i]);
						Vacio4.setText(" "+partida.Columnas[4].cartas[i].valor()+" ");
						Vacio4.setBackground(Color.decode(partida.Columnas[4].cartas[i].getColor()));
						Vacio4.setForeground(Color.BLACK);
						Vacio4.setHorizontalAlignment(SwingConstants.LEFT);
						Vacio4.setVerticalAlignment(SwingConstants.TOP);
						Vacio4.setBounds(400, y, 100, 150);
						frame.getContentPane().add(Vacio4);
					}if(partida.Columnas[4].cantidad<i+1)   {
						if(i==0) {
							Vacio4.setText(" Vacio ");
							Vacio4.setBackground(Color.BLACK);
							Vacio4.setForeground(Color.WHITE);
							Vacio4.setHorizontalAlignment(SwingConstants.CENTER);
							Vacio4.setVerticalAlignment(SwingConstants.CENTER);
							Vacio4.setBounds(400, y, 100, 150);
							frame.getContentPane().add(Vacio4);
						}
						frame.remove(Carta4[i]);
					}
					y+=25;
					i++;
				}
				frame.repaint();
				}else frame.addNotify();	
			}
		});
		frame.getContentPane().add(Vacio4);
	}
}
