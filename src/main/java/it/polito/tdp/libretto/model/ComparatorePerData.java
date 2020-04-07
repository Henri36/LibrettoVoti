package it.polito.tdp.libretto.model;

import java.util.Comparator;

class ComparatorePerData implements Comparator<Voto> {

	@Override
	public int compare(Voto o1, Voto o2) {
		return o1.getData().compareTo(o2.getData());
	}

}
