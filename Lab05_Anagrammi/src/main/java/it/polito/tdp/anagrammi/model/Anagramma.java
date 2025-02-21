package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {
	private String parola;
	private List<String> risultato;
	
	
	public Anagramma(String parola) {
		this.parola = parola;
		this.risultato = anagrammi();
	}

	private List<String>  anagrammi() {
		
		risultato = new ArrayList<>() ;
			permuta("", parola, 0, risultato) ; 
			return risultato;
		}

	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {
		if( lettere.length()==0 ) { 
			risultato.add(parziale) ;
		} else {
			
			for(int pos=0; pos<lettere.length(); pos++) {
				
				char tentativo = lettere.charAt(pos) ; 
				
				String nuovaParziale = parziale + tentativo ;
				String nuovaLettere = lettere.substring(0, pos)+lettere.substring(pos+1) ;
					
				permuta(nuovaParziale, nuovaLettere, livello+1, risultato) ;

				
			}
		}
	}

	public String getParola() {
		return parola;
	}

	public List<String> getRisultato() {
		return risultato;
	}

}
