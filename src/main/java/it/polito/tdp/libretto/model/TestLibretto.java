/**
 * 
 */
package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * @author Henri
 * questa è la classe che testa/prova i punti
 */
public class TestLibretto {
	
	Libretto lib;
	
	public void run() {
		
		this.lib = new Libretto();
		
		Voto v1 = new Voto("Tecniche di programmazione", 28, LocalDate.of(2020, 06, 14));
		Voto v2 = new Voto("Diritto", 27, LocalDate.of(2020, 01, 30));
		Voto v3 = new Voto("Analisi II", 18, LocalDate.of(2020, 02, 18));
		Voto v4 = new Voto("Programmazione a oggetti", 25, LocalDate.of(2020, 06, 20));
		
		this.
	}


	public static void main(String[] args) {
		TestLibretto test = new TestLibretto();
		test.run();

	}

}
