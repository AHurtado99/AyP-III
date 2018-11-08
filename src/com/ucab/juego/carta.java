package com.ucab.juego;


public class carta {
	
	private String color;
	private int numero;
	
	//define el color de la carta en base de su numero 
	public void setColor() {
		switch(this.numero) {
			case 1 : this.color = "#F7FE2E"; break;
			case 2 : this.color = "#FFBF00"; break;
			case 3 : this.color = "#FF8000"; break;
			case 4 : this.color = "#FF0000"; break;
			case 5 : this.color = "#00FF00"; break;
			case 6 : this.color = "#FF00FF"; break;
			case 7 : this.color = "#FF0080"; break;
			case 8 : this.color = "#0B610B"; break;
			case 9 : this.color = "#6A0888"; break;
			case 10: this.color = "#2EFEF7"; break;
			case 11: this.color = "#848484"; break;
		}
	}
	
	// crea una carta con el indice x y le da un color 
	public carta(int x) {
		this.numero = x;
		setColor();
	}
	
	//incrementa la carta a su siguiente y actualiza el color
	public void incrementar() {
		this.numero++;
		setColor();
	}
	
	//calcula el valor de la carta en base a su exponente 
	public int valor() {
		int i,z;
		i=1;z=0;
		while(z<this.numero) {
			i*=2;
			z++;
		}
		return i;
	}

	public String getColor() {
		return color;
	}

	public int getNumero() {
		return numero;
	}

}
