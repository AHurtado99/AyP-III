package com.ucab.juego;

import com.ucab.juego.Columna;

public class Juego {

	Columna[] Columnas;
	int record;
	int multiplicador;
	int score;
	int[] comodines;
	
	public Juego() {
		if(false /*validar si ya existe una partida jugada*/){
			//carga de partida anterior, necesita json
		}else {
		this.Columnas[1] = new Columna();
		this.Columnas[2] = new Columna();
		this.Columnas[3] = new Columna();
		this.Columnas[4] = new Columna();
		this.score=0;
		}
		this.record =1/*cargar record del json */;
		this.multiplicador = 1 /*cargar multiplicador del json */ ;
	}
	
	public void AgregarCarta(int Columna,int Carta) {
		boolean a =this.Columnas[Columna].agregarCarta(Carta, this.multiplicador);
		this.score+=this.Columnas[Columna].getUltimoscore();
		if(a) {
			this.multiplicador++;
			this.Columnas[Columna] = new Columna();
		}
		if(this.score>this.record) {
			this.record=this.score;
		}
	}
	
	public static void main(String[] args) {
		

	}

}
