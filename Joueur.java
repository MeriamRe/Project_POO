package Joueur;

import java.util.LinkedList;

import Piece.Piece;

//Joueur est une classe abstraite
public abstract class Joueur {

	private  final int  id; 
	private final String pseudo ;
	private int nbPiece ;
	private int score ;
	LinkedList<Piece> Main ;
	// Difference par rapport au diagramme de classe
	//ajouter d'une linkedList de carte
	// A revoir concernant le type de liste approprié à utiliser(map,linkedlist...)


	public Joueur(int id, String pseudo, int nbPiece)
	{
		this.id = id ; 
		this.pseudo = pseudo ;
		this.nbPiece = nbPiece ;
		score =0 ;
		Main = new LinkedList<Piece>();
	}


	public abstract void Piocher() ; //choisir une carte au hasart
	public void remplirCarte(){}; //A ajouter dans le diagramme de classe
	public abstract void Poser() ;
	public int getScore()
	{
		return this.score;

	}

	public int getId()
	{

		return this.id;
	}

	public String getPseudo()

	{
    return this.pseudo ;
	}
	
	public void setScore(int a)
	{
		this.score+=a ;
		
		
	}
	
	

}
