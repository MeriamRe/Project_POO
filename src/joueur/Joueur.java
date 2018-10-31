package joueur;

import java.util.LinkedList;

import piece.Piece;

//Joueur est une classe abstraite
public abstract class Joueur {

	private final int id;// id joueur 
	private final String pseudo ;
	private int nbPiece ;
	private int score ;
	LinkedList<Piece> Main ; // la main de joueur
	// Difference par rapport au diagramme de classe
	// ajouter d'une linkedList de carte
	// A revoir concernant le type de liste approprié à utiliser(map,linkedlist...)

	public Joueur(int id, String pseudo, int nbPiece) {
		this.id = id ; 
		this.pseudo = pseudo ;
		this.nbPiece = nbPiece ;
		this.score = 0 ;
		this.Main = new LinkedList<Piece>();
	}

	/**
	 * Choisir une carte au hasard
	 */
	public abstract void piocher() ;
	
	public void remplirCarte(){}; //A ajouter dans le diagramme de classe
	
	/**
	 * Poser une carte
	 */
	public abstract void poser() ;
	
	
	//------GETTER------	
	public int getScore() {
		return this.score;

	}

	public int getId() {

		return this.id;
	}

	public String getPseudo() {
		return this.pseudo ;
	}

	//------SETTER------	
	public void setScore(int a) {
		this.score+=a ;

	}



}
