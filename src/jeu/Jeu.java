package jeu;
import joueur.Joueur;

/**
 * Interface d'ingine des jeux"
 *
 */
public interface Jeu {
	public Joueur p1 = null; //initialistion
	public Joueur p2 = null ;
	
	/**
	 * Lancer le jeu
	 */
	public void commencerJeu() ;
	
	/**
	 * Terminer le jeu
	 */
	public void finirJeu();
	
	/**
	 * Annocer le gagnant
	 */
	public void revelerGagnant() ;

}
