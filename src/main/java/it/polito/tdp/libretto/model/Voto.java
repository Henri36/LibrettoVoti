package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto  implements Comparable <Voto>{
	
	private String corso; // Tecniche di programmazione
	private int voto; // 28
	private LocalDate data; // 24/06/2020
	
	/**
	 * costruttore di Voto 
	 * @param corso nome del corso 
	 * @param voto valutazione ottenuta
	 * @param data data di superamento dell'esame
	 */
	public Voto(String corso, int voto, LocalDate data) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}
	
	/**
	 * COPY CONSTRUCTOR di {@link Voto} : crea un nuovo {@link Voto} copiando il contenuto del parametro {@code v}
	 * @param v voto da copiare
	 */
	public Voto(Voto v) {
		this.corso= v.corso; //v.getCorso()
		this.voto= v.voto;
		this.data=v.data;
	}
	
	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	/**
	 * metodo per la descrizione e quindi la stampa nel formato indicato di un voto
	 */
	public String toString() {
		return corso + ": " + voto + ", " + data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
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
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}
	
	public boolean isCorretto() {
		if(this.getVoto()<=0 || this.getVoto()>30 || this.getData().equals(null) || this.getCorso().equals(null)) {
			return false;
		} 
		else
			return true;
	}
	
	/**
	 * Copia (clona) un oggetto di tipo {@link Voto}
	 */
	public Voto clone() {
		Voto nuovo = new Voto(this.corso, this.voto, this.data);
		return nuovo;
	}

	@Override
	public int compareTo(Voto other) {
		/*
		 * <0 se this < other
		 * =0 se this == other 
		 * >0 se this > other
		 */
		return this.corso.compareTo(other.corso);
	}
	
	
	
	
	
	

}
