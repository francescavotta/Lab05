package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
private Anagramma a;
private AnagrammaDAO aDao;
private Set<String> e;
private Set<String> c;

public Model() {
	this.a = new Anagramma();
	aDao = new AnagrammaDAO();
}

public void controlla(String parola){
	c = new HashSet<String>();
	e = new HashSet<String>();
	for(String s: a.anagrammi(parola)) {
		if(aDao.isCorrect(s))
			c.add(s);
		else
			e.add(s);
	}
}

public Set<String> getE() {
	return e;
}


public Set<String> getC() {
	return c;
}

public String stampaCorretto(Set<String> set) {
	String stampa="";
	for(String s: set)
		stampa += s + "\n";
	return stampa;
}
}
