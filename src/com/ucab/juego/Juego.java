package com.ucab.juego;

import com.ucab.juego.Columna;

public class Juego {
	
	Columna[] Columnas= new Columna[5];
	private long record;
	int multiplicador;
	private long score;
	int[] comodines = new int[3];
	Carta[] newcartas= new Carta[2];
	Columna[] aColumnas= new Columna[5];
	long arecord;
	int amultiplicador;
	long ascore;
	int[] acomodines = new int[3];
	Carta[] anewcartas= new Carta[2];
	 
	//constructor
	public Juego() {
		this.record =1/*cargar record del json */;
		this.multiplicador = 10/*cargar multiplicador del json */ ;
		/*if(false /*validar si ya existe una partida jugada){
			//carga de partida anterior, necesita json
		}else {*/
		this.Columnas[1] = new Columna();
		this.Columnas[2] = new Columna();
		this.Columnas[3] = new Columna();
		this.Columnas[4] = new Columna();
		this.aColumnas[1] = new Columna();
		this.aColumnas[2] = new Columna();
		this.aColumnas[3] = new Columna();
		this.aColumnas[4] = new Columna();
		this.score=0;
		this.comodines[0]=40;
		this.comodines[1]=40;
		this.comodines[2]=40;
		this.newcartas[0]= new Carta((int) (Math.random()*6)+1);
		this.newcartas[1]= new Carta((int) (Math.random()*6)+1);
		//}
	}
	
	public void Cargar() {
		this.score = this.ascore;
		this.record = this.arecord;
		int j=1;
		while(j<5) {
			this.Columnas[j].cantidad=this.aColumnas[j].cantidad;
			this.Columnas[j].ultima=this.aColumnas[j].ultima;
			int i=0;
			while(i<9) {
				this.Columnas[j].cartas[i]=this.aColumnas[j].cartas[i];
				i++;
			}
			j++;
		}
		this.comodines[0] = this.acomodines[0];
		this.comodines[1] = this.acomodines[1];
		this.comodines[2] = this.acomodines[2];
		this.newcartas[0] = this.anewcartas[0];
		this.newcartas[1] = this.anewcartas[1];
		this.multiplicador = this.amultiplicador;
	}
	
	public void Guardar() {
		this.ascore = this.score;
		this.arecord = this.record;
		int j=1;
		while(j<5) {
			this.aColumnas[j].cantidad=this.Columnas[j].cantidad;
			this.aColumnas[j].ultima=this.Columnas[j].ultima;
			int i=0;
			while(i<9) {
				this.aColumnas[j].cartas[i]=this.Columnas[j].cartas[i];
				i++;
			}
			j++;
		}
		this.acomodines[0] = this.comodines[0];
		this.acomodines[1] = this.comodines[1];
		this.acomodines[2] = this.comodines[2];
		this.anewcartas[0] = this.newcartas[0];
		this.anewcartas[1] = this.newcartas[1];
		this.amultiplicador = this.multiplicador;
	}
	
	// Agrega cartas en una determinada columna y de un deerminado indice de carta
	public void AgregarCarta(int Columna) {
		boolean a =this.Columnas[Columna].agregarCarta(this.newcartas[0].getNumero(), this.multiplicador);
		this.score+=this.Columnas[Columna].getUltimoscore();
		this.newcartas[0]=this.newcartas[1];
		this.newcartas[1]=new Carta((int) (Math.random()*6)+1);
		if(a) {
			this.multiplicador++;
			this.comodines[0]=40;
			this.comodines[1]=40;
			this.comodines[2]=40;
			this.Columnas[Columna] = new Columna();
		}
		if(this.score>this.record) {
			this.record=this.score;
		}
		this.AumentarComodines();
	}
	
	public String getRecord() {
		String tex=""+record;
		if(record>999) {
			long x=record/1000;
			long y=(record%1000)/10;
			tex=""+x+","+y+"K";
		}
		if(record>999999) {
			long x=record/1000000;
			long y=(record%1000000)/10000;
			tex=""+x+","+y+"M";
		}
		return tex;
	}

	public String getScore() {
		String tex=""+score;
		if(score>999) {
			long x=score/1000;
			long y=(score%1000)/10;
			tex=""+x+","+y+"K";
		}
		if(score>999999) {
			long x=score/1000000;
			long y=(score%1000000)/10000;
			tex=""+x+","+y+"M";
		}
		return tex;
	}

	//aumenta los comodines por cada jugada 
	public void AumentarComodines() {
		this.comodines[0]++;
		this.comodines[1]++;
		this.comodines[2]++;
	}
	//Retorna si es posible hacer una jugada
	public boolean Posiblejugada() {
		int x=this.newcartas[0].getNumero();
		if(this.Columnas[1].cantidad==8 && this.Columnas[2].cantidad==8 && this.Columnas[3].cantidad==8 && this.Columnas[4].cantidad==8) {
			if(this.Columnas[1].ultima!=x && this.Columnas[2].ultima!=x && this.Columnas[3].ultima!=x && this.Columnas[4].ultima!=x)
				if(this.comodines[0]<40 && this.comodines[1]<40 && this.comodines[2]<40) {
					return false;
			}
		}
		return true;
	}
}
