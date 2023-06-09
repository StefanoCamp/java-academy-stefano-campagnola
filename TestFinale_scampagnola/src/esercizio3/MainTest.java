package esercizio3;

import esercizio3.implementazione.*;

public class MainTest {

	public static void main(String[] args) {
		
		Calciatore calciatore = new Calciatore("Stefano", "Campagnola", "1995", "Cerignola",
				"Juventus", "Centrocampista", 500.00,30.000,5);
		calciatore.stampaDati();
		System.out.println("Lo stipendio mensile del calciatore è : " + calciatore.calcolaStipendioMensile() + " euro al mese");

	}

}
