package com.ucab.juego;

public class Carta {
	private int numero;
	private String icono;
	
	// Constructor de una carta: Da un numero y su icono
	public Carta(int numero){
		this.numero=numero;
		setIcono();
	}
		
	// Da la direccion del icono del numero
	public void setIcono(){
		switch(this.numero){
		case 1 : this.icono = ("src/Imagenes/2.png"); break;
		case 2 : this.icono = ("src/Imagenes/4.png"); break;
		case 3 : this.icono = ("src/Imagenes/8.png"); break;
		case 4 : this.icono = ("src/Imagenes/16.png"); break;
		case 5 : this.icono = ("src/Imagenes/32.png"); break;
		case 6 : this.icono = ("src/Imagenes/64.png"); break;
		case 7 : this.icono = ("src/Imagenes/128.png"); break;
		case 8 : this.icono = ("src/Imagenes/256.png"); break;
		case 9 : this.icono = ("src/Imagenes/512.png"); break;
		case 10: this.icono = ("src/Imagenes/1024.png"); break;
		}
	}
	
	// Incrementa la carta a su siguiente y actualiza el color
	public void incrementar() {
		this.numero++;
		setIcono();
	}
	
	// Calcula el valor de la carta en base a su exponente 
	public int valor() {
		int resultado=1,exponente=1;
		while(exponente<=this.numero) {
			resultado*=2;
			exponente++;
		}
		return resultado;
	}

	public String getIcono(){
	return this.icono;
	}
	
	public int getNumero(){
		return this.numero;
	}

}