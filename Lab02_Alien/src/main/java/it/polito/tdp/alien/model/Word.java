package it.polito.tdp.alien.model;

import javax.print.attribute.standard.MediaSize.Other;

public class Word {
	private String alienWord;
	private String translation;
	
	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = translation;
	}

	public String getAlienWord() {
		return alienWord;
	}

	public String getTranslation() {
		return translation;
	}
	

	@Override
	public boolean equals(Object obj) {
		String word =((Word) obj).getAlienWord().toLowerCase();
		String tempAlienWord = alienWord.toLowerCase();
		
		if (tempAlienWord.contains("?"))
			tempAlienWord = tempAlienWord.replace('?', '.');
		
		return word.matches(tempAlienWord);
	}

	public void setTranslation(String translation2) {
		this.translation = translation2;
	}

	@Override
	public String toString() {
		return 	this.alienWord + ": " + translation;
	}
	
	

	
}
