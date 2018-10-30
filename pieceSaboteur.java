package Piece;

import Joueur.Joueur;

public class pieceSaboteur extends Piece {


	private sabType type ; 
	//Changement par rapport au diagramme de classe
	//il y a plus d'attribut estActin


	public pieceSaboteur  ( double posX, double posY, sabType type)
	{

		super(posX,posY);
		this.type = type ;
	}

	public sabType getType()
	{
		return this.type ;

	}

	public boolean estAction()
	{
		if(this.getType().equals(sabType.ACTION1)&&(this.getType().equals(sabType.ACTION1)))
		{
			return true ;
		}

		else 
			return false ;

	}

	//cette fonction est appeleé si le joueur choisit 
	// de realiser une action  sur un autre joueur

	public void Action(Joueur p, sabType type)
	{

		// A définir les actions à faire
		// Cela va dépendre de quelle action on chosit soit l'action Action1 ou Action2.


		if(type.equals(sabType.ACTION1))
		{
			//Traitement1 
		}	

		if(type.equals(sabType.ACTION2))
		{
			//Traitement2
		}	

	}



}