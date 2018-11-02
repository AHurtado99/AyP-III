package com.ucab.juego;

import com.ucab.juego.carta;

public class Columna {

	carta[] cartas ;
	int cantidad, ultima;
	private int ultimoscore;

		// crea una nueva columna de cartas con 0 cartas 
 	public Columna() {
 		this.cantidad=0;
		this.cartas[0]= new carta(1);// este codigo es de prueba agrega una carta nueva en la columna 
		}

	// calcula la ultima posicion disponible en la columna 
	private int ultimo() {
		int x=0;
		boolean b = true;
		while(b){
			if(this.cartas[x] != null) {
				x++;
			}else {
				b= false;
			} 
		}
		return x;
	}

		//agrega carta y edita el score de la columna ppar ser leido desde el main
		// siempre se debe inizializar las 4 columans desde el main con el metodo setUltimoscore
 	public void agregarCarta(int x,int multiplicador) {
 		this.cartas[this.cantidad]= new carta(x);
 		setUltimoscore();// esta aqui repetido porque no he creado el main completo 
 		organizar(this.cantidad-1,1,multiplicador);
 		this.cantidad=ultimo();
 		this.ultima=this.cartas[this.cantidad-1].getNumero();
 	}
 
 	// organiza repeticiones de las cartas y calcula el scor resultante de la suma y lo guarde en la propiedad ultimoscore 
	private void organizar(int u,int v,int m) {
		if(u!=0) {
			if(this.cartas[u].getNumero()==this.cartas[u-1].getNumero()) {
				this.cartas[u]=null;
				this.cartas[u-1].incrementar();
				this.ultimoscore+=v*(this.cartas[u-1].valor())*m;
				organizar(u-1,v++,m);
			}
		}
	}

	public int getUltimoscore() {
		return ultimoscore;
	}

	public void setUltimoscore() {
		this.ultimoscore = 0;
	}


}
