package Jeu;
import Joueur.Joueur ;



public interface Jeu {
	public Joueur p1 =null; //initialistion
	public Joueur p2  = null ;
	public void commencerJeu() ;
	public void finirJeu();
	public void revelerGagnant() ;

}
