package fr.eni.calculatrice;

import java.math.BigInteger;
import java.util.Scanner;

public class Calculatrice {

	private static Scanner s = new Scanner(System.in);
	private static final String OPERATEURS = "+-*/q";

	public static void main(String[] args) throws DepassementCapaciteException {
	
		char operateur;
		int valeur1;
		int valeur2;
		int resultat = 0;
		int modulo = 0;

		valeur1 = saisirEntier();

		do {
			operateur = saisirOperateur();
			if (operateur != 'q') {
				valeur2 = saisirEntier();
				try {
					switch (operateur) {
					case '+':
						resultat = Operation.ajouter(valeur1, valeur2);
						break;
					case '-':
						resultat = Operation.soustraire(valeur1, valeur2);
						break;
					case '*':
						resultat = Operation.multiplier(valeur1, valeur2);
						break;
					case '/':
						resultat = valeur1 / valeur2;
						modulo = valeur1 % valeur2;
						break;
					}
					System.out.printf("%d %s %d = %d%s%n", valeur1, operateur, valeur2, resultat,
							operateur == '/' ? " reste " + modulo : "");
					System.out.printf("%nQuel traitement sur le résultat : %d%n", resultat);
					valeur1 = resultat;

				} catch (DepassementCapaciteException e) {
					System.err.println(e.getMessage());
				} catch (ArithmeticException e) {
					System.err.println("La division par zéro n'est pas définie !");
				}
			}

		} while (operateur != 'q');
		System.out.println("Merci et à bientôt !");
		
		s.close();
	}

	private static int saisirEntier() {
		System.out.println("Saisir un nombre entier :");
		String saisie = s.nextLine();
		int entier = 0;
		boolean saisieOK = false;
		do {
			try {
				entier = Integer.parseInt(saisie);
				saisieOK = true;
			} catch (NumberFormatException e) {
				try {
					new BigInteger(saisie); // vérification si dépassement de capacité de l'integer
					System.err.println("La valeur saisie dépasse les capacités de cette calculatrice. Réessayer...");
				} catch (NumberFormatException f) {
					System.err.println("Saisie incorrecte. Réessayer...");
				}
				saisie = s.nextLine();
			}
		} while (!saisieOK);
		return entier;
	}

	private static char saisirOperateur() {
		boolean saisieOK = true;
		String operateur;
		do {
			System.out.println("opérateur ? (+ - * / ou q pour quitter)");
			operateur = s.nextLine();
			saisieOK = operateur.length() == 1 && OPERATEURS.indexOf(operateur) != -1;
			if (!saisieOK)
				System.err.println("L'opérateur choisit n'est pas valide");
		} while (!saisieOK);
		return operateur.charAt(0);
	}
}
