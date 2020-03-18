package it.polito.tdp.alien.model;

import java.util.*;

public class WordEnhaced {
		private String alienWord;
		private List<String> translation;
		
		public WordEnhaced(String alienWord, String translation) {
			super();
			this.alienWord = alienWord;
			this.translation = new LinkedList<String>();
			this.setTranslation(translation);
		}

		public String getAlienWord() {
			return alienWord;
		}

		public List<String> getTranslation() {
			return translation;
		}
		

		@Override
		public boolean equals(Object obj) {
			String word =((WordEnhaced) obj).getAlienWord().toLowerCase();
			String tempAlienWord = alienWord.toLowerCase();
			
			if (tempAlienWord.contains("?"))
				tempAlienWord = tempAlienWord.replace('?', '.');
			
			return word.matches(tempAlienWord);
		}

		public void setTranslation(String translation) {
			this.translation.add(translation);
		}

		@Override
		public String toString() {
			String temp = this.alienWord + ": ";
			for (String w: translation)
				temp += w + ", ";
			
			return temp.substring(0, temp.lastIndexOf(",")) + "\n";
				
		}
	}
