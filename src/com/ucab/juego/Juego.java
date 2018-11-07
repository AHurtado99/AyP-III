package com.ucab.juego;

import com.ucab.juego.Columna;
import java.util.Scanner;

public class Juego {
	
	Columna[] Columnas= new Columna[5];
	int record;
	int multiplicador;
	int score;
	int[] comodines = new int[3];
	carta[] newcartas= new carta[2];
	 
	//constructor
	public Juego() {
		this.record =1/*cargar record del json */;
		this.multiplicador = 1 /*cargar multiplicador del json */ ;
		/*if(false /*validar si ya existe una partida jugada){
			//carga de partida anterior, necesita json
		}else {*/
		this.Columnas[1] = new Columna();
		this.Columnas[2] = new Columna();
		this.Columnas[3] = new Columna();
		this.Columnas[4] = new Columna();
		this.score=0;
		this.comodines[0]=40;
		this.comodines[1]=40;
		this.comodines[2]=40;
		this.newcartas[0]= new carta((int) (Math.random()*6)+1);
		this.newcartas[1]= new carta((int) (Math.random()*6)+1);
		//}
	}
	
	// Agrega cartas en una determinada columna y de un deerminado indice de carta
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
		this.AumentarComodines();
	}
	
	//aumenta los comodines por cada jugada 
	public void AumentarComodines() {
		this.comodines[0]++;
		this.comodines[1]++;
		this.comodines[2]++;
	}
	
	public boolean Posiblejugada(int x) {
		if(this.Columnas[1].cantidad==8 && this.Columnas[2].cantidad==8 && this.Columnas[3].cantidad==8 && this.Columnas[4].cantidad==8) {
			if(this.Columnas[1].ultima!=x && this.Columnas[2].ultima!=x && this.Columnas[3].ultima!=x && this.Columnas[4].ultima!=x)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Juego partida =new Juego();
		Scanner sc=new Scanner(System.in);
		int x=1;
		int[] y= new int[2];
		y[1]= (int) (Math.random()*6)+1;
		y[0]= (int) (Math.random()*6)+1;
		while(x!=0 && partida.Posiblejugada(y[0])){
			int j=1;System.out.println("		Record:"+partida.record+"	Score:"+partida.score+"		X"+partida.multiplicador);
			while(j<5) {
				int i=0;
				System.out.println("Columna "+j);
				System.out.print(partida.Columnas[j].cantidad+"  -> ");
				while(partida.Columnas[j].cartas[i]!=null){
					System.out.print(partida.Columnas[j].cartas[i].valor()+"/");
					i++;
				}
				System.out.println("		");
				j++;
			}
			System.out.println("		Cartas: "+(int) (Math.pow(2,y[1]))+" '"+(int) (Math.pow(2,y[0]))+"'");
			if(partida.comodines[1]>39)
				System.out.println("		5. Botar la carta ->Activo");
			else
				System.out.println("		5. Botar la carta ->Inactivo Faltan "+(int)(40-partida.comodines[1])+" Jugadas");
			if(partida.comodines[2]>39)
				System.out.println("		6. Botar la carta ->Activo");
			else
				System.out.println("		6. Botar la carta ->Inactivo Faltan "+(int)(40-partida.comodines[2])+" Jugadas");
			x= sc.nextInt();
			if(x>0 && x<5) {
				if(partida.Columnas[x].cantidad<8 || partida.Columnas[x].ultima==y[0]) {
					partida.AgregarCarta(x, y[0]);
					y[0]=y[1];
					y[1]= (int) (Math.random()*6)+4;
				}else System.out.println("Liena llena");
			}
			if(x==5) {
				partida.AumentarComodines();
				partida.comodines[1]=0;
				y[0]=y[1];
				y[1]= (int) (Math.random()*6)+1;
			}
			if(x==6) {
				partida.AumentarComodines();
				partida.comodines[2]=0;
				y[0]=y[1];
				y[1]= (int) (Math.random()*6)+1;
			}
		}
		System.out.println("Bye...");
		sc.next();
		sc.close();
	}

}
