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
		
		Voto v1 = new Voto("Tecniche di programmazione", 29, LocalDate.of(2020, 06, 14));
		Voto v2 = new Voto("Diritto", 27, LocalDate.of(2020, 01, 30));
		Voto v3 = new Voto("Analisi II", 18, LocalDate.of(2020, 02, 18));
		Voto v4 = new Voto("Programmazione a oggetti", 25, LocalDate.of(2020, 06, 20));
		
		this.lib.add(v1);
		this.lib.add(v2);
		this.lib.add(v3);
		this.lib.add(v4);
		this.lib.add(new Voto("Economia", 25, LocalDate.of(2019, 07, 13)));
		this.lib.add(new Voto("Sistemi elettrici", 20, LocalDate.of(2020, 06, 10)));
		this.lib.add(new Voto("Fisica I", 18, LocalDate.now()));
		this.lib.add(new Voto("Analisi I", 18, LocalDate.now()));
		
		// 1. stampare tutti i voti del libretto
		System.out.println("--- 1. Stampare tutti i voti del libretto");
		System.out.println(lib);
		
		// 2. Stampare tutti i voti pari a 25
		System.out.println("--- 2. Stampare tutti i voti pari a 18 ---");
		//lib.stampaVotiUgualiAParametro(27);
		System.out.println(lib.stampaVotiUgualiAParametro(18));
		
		// 3. Ricercare nel libretto il voto di un esame dato il nome di un corso
		System.out.println("--- 3. Ricercare nel libretto il voto di un esame dato il nome di un corso ---");
		String nomeCorsoCercato = "Diritto"; // se scrivessi diritto in piccolo non trova nulla!
		//System.out.println(lib.cercaDatoCorso(nomeCorsoCercato)); 
		//System.out.println("Il voto del corso di " + nomeCorsoCercato + " e': " + lib.cercaDatoCorso(nomeCorsoCercato).getVoto());
		System.out.println("Il voto del corso di " + nomeCorsoCercato + " e': " + lib.cercaNomeCorso(nomeCorsoCercato).getVoto());
		
		// 4. 5. Verifica se voti duplicati o in conflitto
		System.out.println("\n--- 4. 5. Verifica se voti duplicati o in conflitto ---");
		Voto Economia2= new Voto("Economia", 25, LocalDate.now());
		Voto Economia3 = new Voto("Economia",19,LocalDate.now());
		System.out.println("Economia con 25 è duplicato: " + lib.isDuplicato(Economia2) + " / conflitto:" + lib.isConflitto(Economia2));
		System.out.println("Economia con 19 è duplicato: " + lib.isDuplicato(Economia3) + " / conflitto:" + lib.isConflitto(Economia3));
		
		// 6. 6.modificare il metodo Libretto.add() in modo da evitare di inserire valutazioni duplicate (stesso esame con stesso voto) o in conflitto
		// done
		
		// 7. Creare un libretto "migliorato" in cui ciascun voto maggiore o uguale di 18 viene incrementato di 1 punto,
		// ciascun voto maggiore o ugale di 24 viene incrementato di 2 punti (senza superare il 30).
		//Tenere separati due libretti, e stamparli entrambi
		System.out.println("--- 7. Creo un libretto migliorato che ggiunge un punto ai voti fino a 23, +2 se il voto di partenza è >=24 ---");
		System.out.println("Libretto di partenza:");
		System.out.println(lib);
		System.out.println("Ora stampo il libretto migliorato:");
		Libretto migliore = lib.miglioraLibretto();
		System.out.println(migliore);
		System.out.println("Di nuovo quello di partenza per sfizio:");
		System.out.println(lib);
		
		System.out.println("--- 8. Stampare il libretto in ordine alfabetico di esame, ed in ordine numerico decrescente di voto ---");
		
		System.out.println("Stampo il libretto in ordine alfabetico:");
		Libretto alfabetico = new Libretto(lib);
		alfabetico.ordinaPerCorso();
		System.out.println(alfabetico);
		
		System.out.println("Stampo il libretto in ordine decrescente di voto");
		Libretto votiDecrescenti = new Libretto(lib);
		votiDecrescenti.ordinaPerVoto();
		System.out.println(votiDecrescenti);
		
		System.out.println("Stampo il libretto in ordine crescente di voto");
		Libretto votiCrescenti = new Libretto(lib);
		votiCrescenti.ordinaPerVotoCrescente();
		System.out.println(votiCrescenti);
		
		System.out.println("Ora stampo il libretto in ordine cronologico di data:");
		Libretto perData = new Libretto(lib);
		perData.ordinaPerData();
		System.out.println(perData);
		
		// 9.cancellare dal libretto tutti i voti inferiori a 20
		System.out.println("--- 9. Rimuovo dal libretto tutti i voti inferiori a 20 ---");
		Libretto senzaVotiScarsi = new Libretto(lib);
		senzaVotiScarsi.eliminaVotiScarsi();
		System.out.println(senzaVotiScarsi);
	}


	public static void main(String[] args) {
		TestLibretto test = new TestLibretto();
		test.run();

	}

}
