package fr.eni.calculatrice;

/**
 * Classe qui modélise une exception contrôlée lorsque le résultat dépasse la
 * capacité de la calculatrice
 * 
 * @author benocode
 * @date 22/12/2022
 * @version Caltoch - v1.0
 */
public class DepassementCapaciteException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * 
	 * @param message de l'erreur
	 */
	public DepassementCapaciteException() {
		super("Le résultat dépasse la capacité de la calculatrice.");
	}
}
