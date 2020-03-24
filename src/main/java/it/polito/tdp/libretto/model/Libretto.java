/**
 * 
 */
package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Henri
 * Classe che rappresenta un libretto universitario di oggetti di tipo Voto
 * (indicati con: nome corse, votazione e data di superamento dell'esame)
 * questa classe è quindi un contenitore di voti --> una lista di oggetti di tipo Voto
 */
public class Libretto {
	
	List<Voto> voti = new ArrayList<>();
	
	/**
	 * metodo per aggiungere un nuovo voto al libretto
	 * @param v voto da aggiungere
	 */
	public void add(Voto v) {
		this.voti.add(v);
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
	
	

}
