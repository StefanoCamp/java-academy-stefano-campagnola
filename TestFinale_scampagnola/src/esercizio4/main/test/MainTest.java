package esercizio4.main.test;

import esercizio4.fumetteria.*;

public class MainTest {

	public static void main(String[] args) {
		
		Fumetto f1 = new Fumetto("Spider-Man", "Stan lee", "1980", "Marvel",20,
				"The amazing spider-man","Stefano Campagnola");
		Fumetto f2 = new Fumetto("Bat-man", "Mario Rossi", "1970", "DC",15,
				"Bat-man, le origini","Stefano Bianchi");
		Fumetto f3 = new Fumetto("Super-man", "Stefano Bianchi", "1978", "DC",20,
				"L'uomo d'acciaio","Stefano Rossi");
		Fumetto f4 = new Fumetto("Thor", "Stan lee", "1990", "Marvel",14,
				"Thor: Love and Thunder","Stefano Campagnola");
		Fumetto f5 = new Fumetto("Captain America", "Stan lee", "1990", "Marvel",20,
				"Il primo vendicatore","Stan lee");
		Fumetto[] fumetti = {f1,f2,f3,f4,f5};
		
		Fumetteria fumetteria = new Fumetteria("Neverland", "Via Bari 18", "Mario Bianchi", fumetti.length,fumetti);
		fumetteria.stampaDati();

	}

}
