package fr.eni.calculatrice;

/**
 * Classe utilitaire qui contient les méthodes de calcul qui peuvent générer des
 * dépassements de capacité de la calculatrice (addition, soustraction et
 * multiplication)
 * 
 * @author benocode
 * @date 22/12/2022
 * @version Caltoch - v1.0
 */
public final class Operation {

	/**
	 * Constructeur privé qui ne peut donc pas être instancié
	 */
	private Operation() {
	}

	/**
	 * Méthode utilitaire qui effectue une addition de 2 entiers
	 * 
	 * @param un entier a
	 * @param un entier b
	 * @return le résultat de l'addition des 2 entiers
	 * @throws DepassementCapaciteException
	 */
	public static int ajouter(int a, int b) throws DepassementCapaciteException {
		long resultLong = (long) a + b;
		int resultInt = a + b;
		if (resultLong != resultInt)
			throw new DepassementCapaciteException();
		return resultInt;
	}

	/**
	 * Méthode utilitaire qui effectue une soustraction de 2 entiers
	 * 
	 * @param un entier a
	 * @param un entier b
	 * @return le résultat de la soustraction des 2 entiers
	 * @throws DepassementCapaciteException
	 */
	public static int soustraire(int a, int b) throws DepassementCapaciteException {
		long resultLong = (long) a - b;
		int resultInt = a - b;
		if (resultLong != resultInt)
			throw new DepassementCapaciteException();
		return resultInt;
	}

	/**
	 * Méthode utilitaire qui effectue une multiplication de 2 entiers
	 * 
	 * @param un entier a
	 * @param un entier b
	 * @return le résultat de la multiplication des 2 entiers
	 * @throws DepassementCapaciteException
	 */
	public static int multiplier(int a, int b) throws DepassementCapaciteException {
		long resultLong = (long) a * b;
		int resultInt = a * b;
		if (resultLong != resultInt)
			throw new DepassementCapaciteException();
		return resultInt;
	}

}
