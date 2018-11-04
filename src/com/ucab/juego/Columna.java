package com.ucab.juego;

import com.ucab.juego.carta;

public class Columna {

	carta[] cartas =new carta[10];
	int cantidad, ultima;
	private int ultimoscore;

		// crea una nueva columna de cartas con 0 cartas 
 	public Columna() {
 		this.cantidad=0;
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
 	public boolean agregarCarta(int x,int multiplicador) {
 		this.cartas[this.cantidad]= new carta(x);
 		this.setUltimoscore();
 		boolean a = organizar(this.cantidad,1,multiplicador);
 		this.cantidad=ultimo();
 		this.ultima=this.cartas[this.cantidad-1].getNumero();
 		return a;
 	}
 
 	// organiza repeticiones de las cartas y calcula el scor resultante de la suma y lo guarde en la propiedad ultimoscore 
	private boolean organizar(int u,int v,int m) {
		if(u>0) {
			if(this.cartas[u].getNumero()==this.cartas[u-1].getNumero()) {
				this.cartas[u]=null;
				this.cartas[u-1].incrementar();
				System.out.print("'Primera suma'");
				this.ultimoscore+=v*(this.cartas[u-1].valor())*m;
				if (this.cartas[u-1].getNumero()==11)
					return true;
				return organizar(u-1,v++,m);
			}
		}
	return false;
	}

	public int getUltimoscore() {
		return ultimoscore;
	}

	public void setUltimoscore() {
		this.ultimoscore = 0;
	}


}
