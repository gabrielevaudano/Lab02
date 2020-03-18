package it.polito.tdp.alien.model;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model model = new Model();
		
		System.out.println(model.addWord("Ciao", "Hello"));
		System.out.println(model.addWord("Ciao", "Hello"));

		System.out.println(model.translateWord("Ciao"));
	}

}
