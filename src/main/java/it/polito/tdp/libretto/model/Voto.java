package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {
	
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
		return corso + ", " + voto + ", " + data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + voto;
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
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (voto != other.voto)
			return false;
		return true;
	}
	
	
	
	
	
	

}
