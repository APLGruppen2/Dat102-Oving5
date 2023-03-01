package no.hvl.dat102.listeklient;

import java.util.Scanner;

import org.junit.platform.commons.util.StringUtils;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.kjedet.KjedetOrdnetListe;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class KlientPerson {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		Person anne = new Person("Anne", "Iversen", 1996);
		Person ole = new Person("Ole", "Vik", 1995);
		Person bendik = new Person("Bendik", "Ness", 1997);
		
		
		OrdnetListeADT<Person> liste = new TabellOrdnetListe<Person>();
		OrdnetListeADT<Person> liste2 = new KjedetOrdnetListe<Person>();
		/*
		for(int i = 0; i < 3; i++) {
			liste.leggTil(leggTilPerson(input));
		}
		*/
		input.close();

		liste.leggTil(anne);
		liste.leggTil(ole);
		liste.leggTil(bendik);
		
		Person person = null;
		
		while(!liste.erTom()) {
			person = liste.fjernFoerste();
			System.out.println(person);
		}
		
		

	}
	
	public static Person leggTilPerson(Scanner input) {
		System.out.println("Skriv inn Fornavn: ");
		String fornavn = input.nextLine();
		System.out.println("Skriv inn Etternavn: ");
		String etternavn = input.nextLine();
		System.out.println("Skriv inn Fødselsår: ");
		String foedselsaar = input.nextLine();
		// (stringUtils.isNumeric(foedselsaar))
		
		Person person = new Person(fornavn, etternavn, Integer.valueOf(foedselsaar));
		return person;
	}
	

}
