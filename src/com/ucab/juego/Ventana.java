	package com.ucab.juego;
	
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	import javax.swing.ImageIcon;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.SwingConstants;
	
	public class Ventana {

	private JFrame frame;
	private Juego partida;
	
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
	
		public Ventana() {
			frame = new JFrame();
			frame.setBounds(500, 100, 525, 720);
			frame.setUndecorated(true);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setIconImage(new ImageIcon("src/Imagenes/Logo.jpg").getImage());
			frame.getContentPane().setBackground(Color.WHITE);
			frame.getContentPane().setLayout(null);
			
			partida = new Juego();
	
			partida.Columnas[1].agregarCarta(1, 1);
			partida.Columnas[2].agregarCarta(1, 1);
			partida.Columnas[3].agregarCarta(1, 1);
			partida.Columnas[4].agregarCarta(1, 1);
			partida.Columnas[1].agregarCarta(10, 1);
			partida.Columnas[2].agregarCarta(10, 1);
			partida.Columnas[3].agregarCarta(10, 1);
			partida.Columnas[4].agregarCarta(10, 1);
			
			Imprimir();
		}
	
		private void Imprimir() {
			
			JLabel lblRecord= new JLabel();
			JButton btnCorona = new JButton("");
			JButton btnMenu = new JButton("");
			JLabel lblScore= new JLabel();
			JLabel lblMultiplicador=new JLabel();
			JButton[][] Carta = new JButton[5][8];
			JButton[] Vacio = new JButton[5];
			JButton btnLinea = new JButton();
			JButton BackBtn = new JButton();
			JButton[] Mazo = new JButton[2];
			JButton Comodin1 = new JButton();
			JButton Comodin2 = new JButton();
			
			Mazo[0] = new JButton();
			Mazo[0].setBorderPainted(false);
			Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
			Mazo[0].setRolloverEnabled(false);
			Mazo[0].setBounds(243, 520, 100, 150);
			frame.getContentPane().add(Mazo[0]);
			
			Mazo[1]= new JButton();
			Mazo[1].setBorderPainted(false);
			Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
			Mazo[1].setRolloverEnabled(false);
			Mazo[1].setBackground(Color.WHITE);
			Mazo[1].setHorizontalAlignment(SwingConstants.LEFT);
			Mazo[1].setBounds(163, 520, 80, 150);
			frame.getContentPane().add(Mazo[1]);
			
			btnMenu.setBounds(475, 9, 35, 33);
			btnMenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			btnMenu.setIcon(new ImageIcon("src/Imagenes/Configuracion.png"));
			btnMenu.setBackground(Color.WHITE);
			frame.getContentPane().add(btnMenu);
			
			lblMultiplicador.setText("X"+partida.multiplicador);
			lblMultiplicador.setForeground(Color.BLACK);
			lblMultiplicador.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblMultiplicador.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMultiplicador.setVerticalAlignment(SwingConstants.CENTER);
			lblMultiplicador.setBounds(25, 10, 425, 33);
			frame.getContentPane().add(lblMultiplicador);
			
			lblScore.setText(""+partida.getScore());
			lblScore.setFont(new Font("Tahoma", Font.PLAIN, 35));
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setVerticalAlignment(SwingConstants.CENTER);
			lblScore.setBounds(25, 10, 425, 47);
			frame.getContentPane().add(lblScore);
	
			btnCorona.setBounds(15, 9, 35, 33);
			btnCorona.setIcon(new ImageIcon("src/Imagenes/CoronaNegra.png"));
			btnCorona.setBackground(Color.WHITE);
			btnCorona.setBorderPainted(false);
			frame.getContentPane().add(btnCorona);
			
			lblRecord.setFont(new Font("Tahoma", Font.PLAIN, 23));
			lblRecord.setHorizontalAlignment(SwingConstants.LEFT);
			lblRecord.setText(""+partida.getRecord());
			lblRecord.setBounds(55, 12, 100, 27);
			frame.getContentPane().add(lblRecord);
	
			btnLinea.setBounds(0, 501, 535, 18);
			btnLinea.setIcon(new ImageIcon("src/Imagenes/linea.png"));
			btnLinea.setBorderPainted(false);
			frame.getContentPane().add(btnLinea);
			
			int b,c=1;
			while(c<5){
				b=0;
				while(b<8) {
					Carta[c][b] = new JButton();
					Carta[c][b].setVerticalAlignment(SwingConstants.TOP);
					Carta[c][b].setBackground(Color.white);
					Carta[c][b].setRolloverEnabled(false);
					Carta[c][b].setBorderPainted(false);
					b++;
				}
				Vacio[c] = new JButton();
				Vacio[c].setVerticalAlignment(SwingConstants.TOP);
				Vacio[c].setBackground(Color.white);
				Vacio[c].setBorderPainted(false);
			c++;
			}
			
			Comodin1.setIcon(new ImageIcon("src/Imagenes/Comodin.1.2.png"));
			Comodin1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					partida.Guardar();
					partida.AumentarComodines();
					partida.comodines[1]=0;
					partida.newcartas[0]=partida.newcartas[1];
					partida.newcartas[1]=new Carta((int) (Math.random()*6)+1);
					if(partida.comodines[0]>39) {
						BackBtn.setEnabled(true);
					}
					if(partida.comodines[2]>39) {
						Comodin2.setEnabled(true);
					}
					Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
					Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
					Comodin1.setIcon(new ImageIcon("src/Imagenes/Comodin.1.2.png"));
					Comodin1.setEnabled(false);
					frame.repaint();
				}
			});
			Comodin1.setBounds(400, 520, 100, 70);
			Comodin1.setBorderPainted(false);
			frame.getContentPane().add(Comodin1);
			
	
			Comodin2.setIcon(new ImageIcon("src/Imagenes/Comodin.2.2.png"));
			Comodin2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					partida.Guardar();
					partida.AumentarComodines();
					partida.comodines[2]=0;
					partida.newcartas[0]=partida.newcartas[1];
					partida.newcartas[1]=new Carta((int) (Math.random()*6)+1);
					if(partida.comodines[0]>39) {
						BackBtn.setEnabled(true);
					}
					if(partida.comodines[1]>39) {
						Comodin1.setEnabled(true);
					}
					Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
					Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
					Comodin2.setIcon(new ImageIcon("src/Imagenes/Comodin.2.2.png"));
					Comodin2.setEnabled(false);
					frame.repaint();
				}
			});
			Comodin2.setBounds(400, 590, 100, 70);
			Comodin2.setBorderPainted(false);
			frame.getContentPane().add(Comodin2);
	
			BackBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					partida.Cargar();
					partida.comodines[0]=0;
					Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
					Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
					lblMultiplicador.setText("X"+partida.multiplicador);
					lblScore.setText(""+partida.getScore());
					lblRecord.setText(""+partida.getRecord());
					if(partida.comodines[1]>39) {
						Comodin1.setEnabled(true);
					}else {
						Comodin1.setEnabled(false);
					}
					if(partida.comodines[2]>39) {
						Comodin2.setEnabled(true);
					}else {
						Comodin2.setEnabled(false);
					}
					BackBtn.setEnabled(false);
	
					int i=1;
					while(i<5) {	
						crearColumna(25+(125*(i-1)),i,Carta[i],Vacio[i]);
						i++;
					}
					
					frame.repaint();
				}
			});
			BackBtn.setBounds(15, 606, 110, 50);
			BackBtn.setBorderPainted(false);
			BackBtn.setBackground(Color.WHITE);
			BackBtn.setEnabled(false);
			BackBtn.setIcon(new ImageIcon("src/Imagenes/Volver.png"));
			frame.getContentPane().add(BackBtn);
			
			int i=1;
			while(i<5) {	
				crearColumna(25+(125*(i-1)),i,Carta[i],Vacio[i]);
				i++;
			}
			
			Vacio[1].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(partida.Columnas[1].cantidad<8 || partida.Columnas[1].ultima==partida.newcartas[0].getNumero()) {
						partida.Guardar();
						partida.AgregarCarta(1);
						if(partida.comodines[0]>39) {
							BackBtn.setEnabled(true);
						}
						if(partida.comodines[1]>39) {
							Comodin1.setEnabled(true);
						}
						if(partida.comodines[2]>39) {
							Comodin2.setEnabled(true);
						}
						Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
						Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
						lblMultiplicador.setText("X"+partida.multiplicador);
						lblScore.setText(""+partida.getScore());
						lblRecord.setText(""+partida.getRecord());
						int i=0, y=75;
						while(i<8) {
							if(partida.Columnas[1].cantidad>i+1) {
								Carta[1][i].setIcon(new ImageIcon(partida.Columnas[1].cartas[i].getIcono()));
								Carta[1][i].setBounds(25, y, 100, 40);
								frame.getContentPane().add(Carta[1][i]);
							}if(partida.Columnas[1].cantidad==i+1)  {
								frame.remove(Carta[1][i]);
								Vacio[1].setIcon(new ImageIcon(partida.Columnas[1].cartas[i].getIcono()));
								Vacio[1].setBounds(25, y, 100, 150);
								frame.getContentPane().add(Vacio[1]);
							}if(partida.Columnas[1].cantidad<i+1)   {
								if(i==0) {
									Vacio[1].setIcon(new ImageIcon("src/Imagenes/tapa.png"));
									Vacio[1].setBounds(25, y, 100, 150);
									frame.getContentPane().add(Vacio[1]);
								}
								frame.remove(Carta[1][i]);	
							}
							y+=40;
							i++;
						}
						frame.repaint();
					}else {frame.addNotify();
					}
				}
			});
			frame.getContentPane().add(Vacio[1]);
			
			Vacio[2].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(partida.Columnas[2].cantidad<8 || partida.Columnas[2].ultima==partida.newcartas[0].getNumero()) {
						partida.Guardar();
						partida.AgregarCarta(2);
						if(partida.comodines[0]>39) {
							BackBtn.setEnabled(true);
						}
						if(partida.comodines[1]>39) {
							Comodin1.setEnabled(true);
						}
						if(partida.comodines[2]>39) {
							Comodin2.setEnabled(true);
						}
						Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
						Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
						lblMultiplicador.setText("X"+partida.multiplicador);
						lblScore.setText(""+partida.getScore());
						lblRecord.setText(""+partida.getRecord());
						int i=0, y=75;
						while(i<8) {
							if(partida.Columnas[2].cantidad>i+1) {
								Carta[2][i].setIcon(new ImageIcon(partida.Columnas[2].cartas[i].getIcono()));
								Carta[2][i].setBounds(150, y, 100, 40);
								frame.getContentPane().add(Carta[2][i]);
							}if(partida.Columnas[2].cantidad==i+1)  {
								frame.remove(Carta[2][i]);
								Vacio[2].setIcon(new ImageIcon(partida.Columnas[2].cartas[i].getIcono()));
								Vacio[2].setBounds(150, y, 100, 150);
								frame.getContentPane().add(Vacio[2]);
							}if(partida.Columnas[2].cantidad<i+1)   {
								if(i==0) {
									Vacio[2].setIcon(new ImageIcon("src/Imagenes/tapa.png"));
									Vacio[2].setBounds(150, y, 100, 150);
									frame.getContentPane().add(Vacio[2]);
								}
								frame.remove(Carta[2][i]);	
							}
							y+=40;
							i++;
						}
						frame.repaint();
					}else {frame.addNotify();
					}
				}
			});
			frame.getContentPane().add(Vacio[2]);
	
			Vacio[3].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(partida.Columnas[3].cantidad<8 || partida.Columnas[3].ultima==partida.newcartas[0].getNumero()) {
						partida.Guardar();
						partida.AgregarCarta(3);
						if(partida.comodines[0]>39) {
							BackBtn.setEnabled(true);
						}
						if(partida.comodines[1]>39) {
							Comodin1.setEnabled(true);
						}
						if(partida.comodines[2]>39) {
							Comodin2.setEnabled(true);
						}
						Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
						Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
						lblMultiplicador.setText("X"+partida.multiplicador);
						lblScore.setText(""+partida.getScore());
						lblRecord.setText(""+partida.getRecord());
						int i=0, y=75;
						while(i<8) {
							if(partida.Columnas[3].cantidad>i+1) {
								Carta[3][i].setIcon(new ImageIcon(partida.Columnas[3].cartas[i].getIcono()));
								Carta[3][i].setBounds(275, y, 100, 40);
								frame.getContentPane().add(Carta[3][i]);
							}if(partida.Columnas[3].cantidad==i+1)  {
								frame.remove(Carta[3][i]);
								Vacio[3].setIcon(new ImageIcon(partida.Columnas[3].cartas[i].getIcono()));
								Vacio[3].setBounds(275, y, 100, 150);
								frame.getContentPane().add(Vacio[3]);
							}if(partida.Columnas[3].cantidad<i+1)   {
								if(i==0) {
									Vacio[3].setIcon(new ImageIcon("src/Imagenes/tapa.png"));
									Vacio[3].setBounds(275, y, 100, 150);
									frame.getContentPane().add(Vacio[3]);
								}
								frame.remove(Carta[3][i]);	
							}
							y+=40;
							i++;
						}
						frame.repaint();
					}else {frame.addNotify();
					}
				}
			});
			frame.getContentPane().add(Vacio[3]);
			
			Vacio[4].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(partida.Columnas[4].cantidad<8 || partida.Columnas[4].ultima==partida.newcartas[0].getNumero()) {
						partida.Guardar();
						partida.AgregarCarta(4);
						if(partida.comodines[0]>39) {
							BackBtn.setEnabled(true);
						}
						if(partida.comodines[1]>39) {
							Comodin1.setEnabled(true);
						}
						if(partida.comodines[2]>39) {
							Comodin2.setEnabled(true);
						}
						Mazo[0].setIcon(new ImageIcon(partida.newcartas[0].getIcono()));
						Mazo[1].setIcon(new ImageIcon(partida.newcartas[1].getIcono()));
						lblMultiplicador.setText("X"+partida.multiplicador);
						lblScore.setText(""+partida.getScore());
						lblRecord.setText(""+partida.getRecord());
						int i=0, y=75;
						while(i<8) {
							if(partida.Columnas[4].cantidad>i+1) {
								Carta[4][i].setIcon(new ImageIcon(partida.Columnas[4].cartas[i].getIcono()));
								Carta[4][i].setBounds(400, y, 100, 40);
								frame.getContentPane().add(Carta[4][i]);
							}if(partida.Columnas[4].cantidad==i+1)  {
								frame.remove(Carta[4][i]);
								Vacio[4].setIcon(new ImageIcon(partida.Columnas[4].cartas[i].getIcono()));
								Vacio[4].setBounds(400, y, 100, 150);
								frame.getContentPane().add(Vacio[4]);
							}if(partida.Columnas[4].cantidad<i+1)   {
								if(i==0) {
									Vacio[4].setIcon(new ImageIcon("src/Imagenes/tapa.png"));
									Vacio[4].setBounds(400, y, 100, 150);
									frame.getContentPane().add(Vacio[4]);
								}
								frame.remove(Carta[4][i]);	
							}
							y+=40;
							i++;
						}
						frame.repaint();
					}else {
						frame.addNotify();
					}
				}
			});
			frame.getContentPane().add(Vacio[4]);	
		}
		
		public void crearColumna(int x,int j,JButton[] Carta,JButton Vacio ){
			int y=75;
			if(partida.Columnas[j].cantidad>0) {
				int i=0;
				while(partida.Columnas[j].cartas[i]!=null) {
					if(partida.Columnas[j].cantidad>i+1) {
						Carta[i].setIcon(new ImageIcon(partida.Columnas[j].cartas[i].getIcono()));
						Carta[i].setBounds(x, y, 100, 40);
						frame.getContentPane().add(Carta[i]);
					}if(partida.Columnas[j].cantidad==i+1)  {
						Vacio.setIcon(new ImageIcon(partida.Columnas[j].cartas[i].getIcono()));
						Vacio.setBounds(x, y, 100, 150);
					}
					i++;
					y+=40;
				}
			}else {
				Vacio.setIcon(new ImageIcon("src/Imagenes/tapa.png"));
				Vacio.setBounds(x, y, 100, 150);
			}
		}
	}
