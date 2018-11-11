package jeu;
import joueur.Joueur;

/**
 * Interface d'ingine des jeux"
 *
 */
public abstract class Jeu { // classe abstraite ??
	public Joueur p1 = null ; //initialistion
	public Joueur p2 = null ;
	// stocker les pieces de depart
	/**
	 * Lancer le jeu
	 */
	public abstract void commencerJeu() ;
	
	/**
	 * Terminer le jeu
	 */
	public abstract void finirJeu();
	
	/**
	 * Annocer le gagnant
	 */
	public abstract void revelerGagnant() ;

}
