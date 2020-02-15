package com.ucab.juego;

import com.ucab.juego.Columna;

public class Main {

	Columna[] Columnas;
	int record;
	int multiplicador;
	int score;
	
	public Main() {
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

	public static void main(String[] args) {
		

	}

}
