package it.polito.tdp.alien.model;

import java.security.InvalidParameterException;
import java.util.*;

public class Model {
	private List<WordEnhaced> alienDictionary;
	
	public Model() {
		super();
		this.alienDictionary = new LinkedList<WordEnhaced>();
	}

	public String addWord(String alienWord, String translation) {
		
		if (!alienWord.matches("^[a-zA-Z]+$") || !translation.matches("^[a-zA-Z]+$"))
				throw new InvalidParameterException("Possono essere inseriti solo caratteri");
		
		WordEnhaced temp = new WordEnhaced(alienWord, translation);

		if (alienDictionary.contains(temp)) {
			alienDictionary.get(alienDictionary.indexOf(temp)).setTranslation(translation);
			return "La parola " + alienWord + " è stata modificata con successo";
		}
		else {
			alienDictionary.add(temp);
			return "La parola " + alienWord + " è stata aggiunta con successo";
		}
	}
	
	public String translateWord(String alienWord) {
		WordEnhaced temp = new WordEnhaced(alienWord, null);
		String result = new String();
		if (alienDictionary.contains(temp)) 
			return alienDictionary.get(alienDictionary.indexOf(temp)).toString();
		return null;
	}

	public String throwMoreThanOneException() {
		throw new IllegalStateException("Ci sono stati problemi nell'elaborazione della richiesta perchè sono stati inseriti più di due campi, il sistema inserisce al più un campo di traduzione per ogni parola. Se si vogliono inserire più traduzioni per una singola parola, ripetere pià volte la procedura.");
	}
	
	public void clear() {
		this.alienDictionary.clear();
	}
}
