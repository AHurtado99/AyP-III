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
	
	public void Mazo(JButton[] boton,JButton[] Mazo,JTextPane Header,JButton Comodin1,JButton Comodin2,Juego partida,int j,int x) {
		int i=0, y=75;
		while(i<8) {
			if(partida.Columnas[j].cantidad>i+1) {
				boton[i].removeAll();
				boton[i].setText(" "+partida.Columnas[j].cartas[i].valor());
				boton[i].setEnabled(false);
				boton[i].setBackground(Color.decode(partida.Columnas[1].cartas[i].getColor()));
				boton[i].setVerticalAlignment(SwingConstants.TOP);
				boton[i].setBounds(x, y, 100, 25);
				frame.getContentPane().add(boton[i]);
			}if(partida.Columnas[j].cantidad==i+1)  {
				boton[i].setText(" "+partida.Columnas[j].cartas[i].valor()+" ");
				boton[i].setBackground(Color.decode(partida.Columnas[j].cartas[i].getColor()));
				boton[i].setBounds(x, y, 100, 75);
				boton[i].setEnabled(true);
				boton[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						partida.AgregarCarta(j, partida.newcartas[0].getNumero());
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
						Mazo(boton,Mazo,Header,Comodin1,Comodin2,partida,j,x);
						frame.repaint();
						
					}
				});
				frame.getContentPane().add(boton[i]);
			}if(partida.Columnas[j].cantidad<i+1)   {
				if(i!=0) {
				frame.remove(boton[i]);	
				}else {
					JButton Vacio1 = new JButton(" Vacio ");
					Vacio1.setBackground(Color.BLACK);
					Vacio1.setForeground(Color.WHITE);
					Vacio1.setBounds(x, y, 100, 75);
					Vacio1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							partida.AgregarCarta(j, partida.newcartas[0].getNumero());
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
							
							frame.getContentPane().remove(Vacio1);

							Mazo(boton,Mazo,Header,Comodin1,Comodin2,partida,j,25);
							
							frame.repaint();
							
						}
					});
					frame.getContentPane().add(Vacio1);
				}
			}
			y+=25;
			i++;
		}
		frame.repaint();
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
				
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				
				Comodin1.setText(""+(int)(40-partida.comodines[1]));
				Comodin1.setEnabled(false);
				Comodin1.setBackground(Color.RED);
				
				frame.repaint();
				
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
				
				Mazo[1].setText(" "+partida.newcartas[1].valor()+" ");
				Mazo[1].setBackground(Color.decode(partida.newcartas[1].getColor()));
				
				Comodin2.setText(""+(int)(40-partida.comodines[2]));
				Comodin2.setEnabled(false);
				Comodin2.setBackground(Color.RED);

				frame.repaint();
			}
		});
		Comodin2.setBounds(375, 350, 125, 25);
		frame.getContentPane().add(Comodin2);

		JButton BackBtn = new JButton("Volver");
		BackBtn.setBounds(25, 375, 125, 25);
		frame.getContentPane().add(BackBtn);
		
		
		int  y=75;
		JButton[] Carta = new JButton[8];
		int b=0;
		while(b<8) {
			Carta[b] = new JButton();
			b++;
		}
		if(partida.Columnas[1].cantidad>0) {
			int i=0;
			while(partida.Columnas[1].cantidad!=1) {
				if(i+1!=partida.Columnas[1].cantidad) {
					Carta[i].setText(" "+partida.Columnas[1].cartas[i].valor());
					Carta[i].setEnabled(false);
					Carta[i].setBackground(Color.decode(partida.Columnas[1].cartas[i].getColor()));
					Carta[i].setVerticalAlignment(SwingConstants.TOP);
					Carta[i].setBounds(25, y, 100, 25);
					frame.getContentPane().add(Carta[i]);
				}
				else {
					Carta[i].setText(" "+partida.Columnas[1].cartas[i].valor()+" ");
					Carta[i].setBackground(Color.decode(partida.Columnas[1].cartas[i].getColor()));
					Carta[i].setBounds(25, y, 100, 75);
					Carta[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
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
							Mazo(Carta,Mazo,Header,Comodin1,Comodin2,partida,1,25);
							frame.repaint();
							
						}
					});
					frame.getContentPane().add(Carta[i]);
				}
				i++;
				y+=25;
			}
		}else {
			JButton Vacio1 = new JButton(" Vacio ");
			Vacio1.setBackground(Color.BLACK);
			Vacio1.setForeground(Color.WHITE);
			Vacio1.setBounds(25, y, 50, 75);
			Vacio1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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
					
					frame.getContentPane().remove(Vacio1);

					Mazo(Carta,Mazo,Header,Comodin1,Comodin2,partida,1,25);
					
					frame.repaint();
					
				}
			});
			frame.getContentPane().add(Vacio1);
		}
		y=75;
		JButton[] Carta2 = new JButton[8];
		b=0;
		while(b<8) {
			Carta2[b] = new JButton();
			b++;
		}
		if(partida.Columnas[2].cantidad>0) {
			int i=0;
			while(partida.Columnas[2].cantidad!=1) {
				if(i+1!=partida.Columnas[2].cantidad) {
					Carta2[i].setText(" "+partida.Columnas[2].cartas[i].valor());
					Carta2[i].setEnabled(false);
					Carta2[i].setBackground(Color.decode(partida.Columnas[2].cartas[i].getColor()));
					Carta2[i].setVerticalAlignment(SwingConstants.TOP);
					Carta2[i].setBounds(150, y, 100, 25);
					frame.getContentPane().add(Carta2[i]);
				}
				else {
					Carta2[i].setText(" "+partida.Columnas[2].cartas[i].valor()+" ");
					Carta2[i].setBackground(Color.decode(partida.Columnas[2].cartas[i].getColor()));
					Carta2[i].setBounds(150, y, 100, 75);
					Carta2[i].addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
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
							Mazo(Carta2,Mazo,Header,Comodin1,Comodin2,partida,2,150);
							frame.repaint();
							
						}
					});
					frame.getContentPane().add(Carta2[i]);
				}
				i++;
				y+=25;
			}
		}else {
			JButton Vacio2 = new JButton(" Vacio ");
			Vacio2.setBackground(Color.BLACK);
			Vacio2.setForeground(Color.WHITE);
			Vacio2.setBounds(150, y, 50, 75);
			Vacio2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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
					
					frame.getContentPane().remove(Vacio2);

					Mazo(Carta2,Mazo,Header,Comodin1,Comodin2,partida,2,150);
					
					frame.repaint();
					
				}
			});
			frame.getContentPane().add(Vacio2);
		}
	}
}
