/**
 * 
 */
package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Henri
 * Classe che rappresenta un libretto universitario di oggetti di tipo Voto
 * (indicati con: nome corse, votazione e data di superamento dell'esame)
 * questa classe è quindi un contenitore di voti --> una lista di oggetti di tipo Voto
 */
public class Libretto extends Exception {
	
	List<Voto> voti = new ArrayList<>();
	
	/**
	 * crea un libretto nuovo (e vuoto)
	 */
	public Libretto() {
		super();
	}
	
	/**
	 * COPY COSTRUCTOR 
	 * SHALLOW (copia superficiale)
	 * @param lib libretto da copiare
	 */
	public Libretto(Libretto lib) {
		super();
		this.voti.addAll(lib.voti);
	}
	
	//devo aggiungere intelligenza al metodo, lo posso fare inserendo controlli, --> inserisco nel libretto solo voti validi
	/**
	 * metodo per aggiungere un nuovo voto al libretto
	 * @param v voto da aggiungere
	 * @return {@code true} se il voto che voglio inserire è corretto. {@code false} se il voto è in conflitto o duplicato
	 */
	public boolean add(Voto v) {
		if(this.isConflitto(v) || this.isDuplicato(v)) {
			//Non lo inserisco
			return false;
		}
		else
			if(v.isCorretto() == true) {
				this.voti.add(v);
				return true;
			}
			else 
				return false;
		}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((voti == null) ? 0 : voti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libretto other = (Libretto) obj;
		if (voti == null) {
			if (other.voti != null)
				return false;
		} else if (!voti.equals(other.voti))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String s= "";
		for(Voto v : voti) {
			s+= v.toString() + "\n" ;
		}
		return s;
	}
	
	/**
	 * inserendo come parametro un voto (es 25), restituisce tutti i corsi con valutazione uguale 
	 * @param val valutazione numerica del voto che fa da filtro
	 * @return un nuovo libretto con tutti i voti pari al parametro
	 */
	public Libretto stampaVotiUgualiAParametro(int val) {
		Libretto nuovo = new Libretto() ;
		for(Voto v : voti) {
			if(v.getVoto()==val) {
				nuovo.add(v);
			}
		}
		return nuovo;
	}
	
	/**
	 * metodo che dato il nome di un corso mi cerca il voto inteso come oggetto
	 * @param c nome del corso che sto cercando (es. Analisi II)
	 * @return un oggetto {@link Voto} restituisce {@code null} se l'esame non è stato trovato
	 */
	/* public Voto cercaDatoCorso(String c) {
		Voto vTemp = new Voto(null, 0, null);
		for(Voto v : voti) {
			if (v.getCorso().compareToIgnoreCase(c)==0)
				vTemp= v;
		}
		return vTemp;
	} */
	
	/** 
	 * Dato il nome di un corso, ricerca se quell'esame esiste nel libretto, ed in caso affermativo restituisce l'oggetto
	 * {@link Voto} corrispondente. se l'esame non esiste restituisce 0 o {@code null}
	 * @param nomeCorso nome del corso da cercare
	 * @return {@link Voto} corrispondente oppure {@code null} se l'esame non esiste
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
		int pos = this.voti.indexOf(new Voto(nomeCorso,0,null));
		if(pos != -1) {
			return voti.get(pos);
		}
		else
			//System.out.println("Corso non trovato!");
			return new Voto("", 0, null);				
		}
	
	/**
	 * Ritorna {@code true} se il corso specificato da {@code v} esiste nel libretto, con la stessa valutazione.
	 * Se non esiste, o la valutazione è diversa, restituisce {@code false}
	 * @param v è il {@link Voto} da ricercare
	 * @return l'esistenza di un duplicato
	 */
	public boolean isDuplicato(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if(esiste== null)
			return false;
		else 
			return (esiste.getVoto()== v.getVoto());
	}
	
	/**
	 * determina se esiste un voto con lo stesso nome corso ma valutazione diversa
	 * @param v
	 */
	public boolean isConflitto(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		if(esiste == null)
			return false;
		else
			return (v.getCorso().equals(esiste.getCorso()) && v.getVoto()==esiste.getVoto());			
	}
	
	public Libretto miglioraLibretto() {
		Libretto migliorato = new Libretto();

		for(Voto v : voti){
			//Voto v2 = new Voto(v);
			Voto v2 = v.clone();
			if(v.getVoto()>= 24) {
				v2.setVoto(v.getVoto()+2);
				if(v2.getVoto()>30)
					v2.setVoto(30);
			}
			else if(v.getVoto()>=18) {
				v2.setVoto(v.getVoto()+1);
			}
			migliorato.add(v2);
		}
		return migliorato;
	}
	
	public void ordinaPerCorso() {
		Collections.sort(this.voti);
	}
	
	public void ordinaPerVoto() {
		Collections.sort(this.voti, new ComparatorePerVotiDecrescenti());
	}
	
	public void ordinaPerVotoCrescente() {
		Collections.sort(this.voti, new ComparatorePerVotiCrescenti());
	}
	
	public void ordinaPerData() {
		Collections.sort(this.voti, new ComparatorePerData());
	}
	
	public void eliminaVotiScarsi() {
		List <Voto>daRimuovere = new ArrayList<>();
		for(Voto v : voti) {
			if(v.getVoto()<20)
				daRimuovere.add(v);
		}
		this.voti.removeAll(daRimuovere);
	}

}
