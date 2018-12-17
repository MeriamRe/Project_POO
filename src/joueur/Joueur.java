package joueur;

import java.util.LinkedList;

import piece.Piece;

//Joueur est une classe abstraite
public abstract class Joueur {

	private final int id;// id joueur 
	private String pseudo ;
	private int score ;
	LinkedList<Piece> Main ; // la main de joueur
	// Difference par rapport au diagramme de classe
	// ajouter une linkedList de piece
	// A revoir concernant le type de liste approprié à utiliser(map,linkedlist...)

	public Joueur(int id, String pseudo) {
		this.id = id ; 
		this.pseudo = pseudo ;
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

	public LinkedList<Piece> getMain(){
		return this.Main;
	}
	
	//------SETTER------	
	public void setScore(int a) {
		this.score+=a ;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	


}
