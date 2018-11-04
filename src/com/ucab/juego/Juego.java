package com.ucab.juego;

import com.ucab.juego.Columna;
import java.util.Scanner;

public class Juego {
	
	Columna[] Columnas= new Columna[5];
	int record;
	int multiplicador;
	int score;
	int[] comodines = new int[3];
	
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
		comodines[0]=40;
		comodines[1]=40;
		comodines[2]=40;
		//}
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
		this.AumentarComodines();
	}
	
	public void AumentarComodines() {
		comodines[0]++;
		comodines[1]++;
		comodines[2]++;
	}
	
	public static void main(String[] args) {
		Juego partida =new Juego();
		Scanner sc=new Scanner(System.in);
		int x=1,y=0;
		while(x!=0) {
			int j=1;System.out.print(" "+partida.record+"  "+partida.score+"  "+partida.multiplicador);
			while(j<5) {
				int i=0;
				System.out.println("	");
				System.out.print(partida.Columnas[j].cantidad+"		");
				while(partida.Columnas[j].cartas[i]!=null){
					System.out.print(partida.Columnas[j].cartas[i].getNumero()+"/");
					i++;
				}
				j++;
			}
			x= sc.nextInt();
			y= sc.nextInt();
			partida.AgregarCarta(x, y);
		}
		System.out.println("Bye...");
		sc.next();
		sc.close();
	}

}
