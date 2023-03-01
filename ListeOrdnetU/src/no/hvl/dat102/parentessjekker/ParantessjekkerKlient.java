package no.hvl.dat102.parentessjekker;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.tabell.TabellOrdnetListe;

public class ParantessjekkerKlient implements Parentessjekker {

	private char[] venstreParanteser = { '(', '[', '{' };
	private char[] hoeyreParanteser = { ')', ']', '}' };
	
	public static void main(String[] args) {
		ParantessjekkerKlient ps = new ParantessjekkerKlient();
		String[] tester = {
				"()",   //Gyldig
				")",	//Ugyldig
				"[]{([])}",	//Gyldig
				"[][][]{[}]()",	//Ugyldig
				"Helllo(){};",	//Gyldig
				"TestTest()Test[{()[]}]"};	//Gyldig
		for(String test : tester) {
			String resultat = ps.verifiserString(test) ? "Gyldige paranteser!" : "Ugyldige paranteser!";
			System.out.println(resultat);
		}
	}

	public boolean verifiserString(String s) {
		OrdnetListeADT<Character> ordnetListe = new TabellOrdnetListe<Character>();

		if (!erBalansert(s)) {
			return false;
		}
		for (char c : s.toCharArray()) {
			if (erVenstreparentes(c)) {
				ordnetListe.leggTil(c);
			} else if (erHogreparentes(c)) {
				if (!ordnetListe.erTom() && erPar(ordnetListe.siste(), c)) {
					ordnetListe.fjernSiste();
				} else {
					ordnetListe.leggTil(c);
				}
			}
		}
		if (ordnetListe.erTom()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean erVenstreparentes(char p) {
		return inneholder(venstreParanteser, p);
	}

	@Override
	public boolean erHogreparentes(char p) {
		return inneholder(hoeyreParanteser, p);
	}

	@Override
	public boolean erParentes(char p) {
		return erHogreparentes(p) || erVenstreparentes(p);
	}

	@Override
	public boolean erPar(char venstre, char hogre) {
		if (erVenstreparentes(venstre) && erHogreparentes(hogre)) {
			int i = indeks(venstreParanteser, venstre);
			int j = indeks(hoeyreParanteser, hogre);
			return i == j && i != -1 && j != -1;
		}
		return false;
	}

	@Override
	public boolean erBalansert(String s) {
		int balanse = 0;
		for (char c : s.toCharArray()) {
			if (erHogreparentes(c)) {
				balanse++;
			} else if (erVenstreparentes(c)) {
				balanse--;
			}
		}
		return balanse == 0;
	}

	private boolean inneholder(char[] array, char elem) {
		for (char c : array) {
			if (c == elem) {
				return true;
			}
		}
		return false;
	}

	private int indeks(char[] array, char elem) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == elem) {
				return i;
			}
		}
		return -1;
	}

}
