package Joueur;

import Piece.Piece;

public  abstract class joueurSaboteur extends Joueur {

	public joueurSaboteur(int id, String pseudo, int nbPiece) {
		super(id, pseudo, nbPiece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Piocher() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Poser() {
		// TODO Auto-generated method stub
		
	}

	//cette classe je vais la mettre à abstract vu que je n'ai pas enocre
	//les méthodes appliquer et Jeter
	public  abstract void Jeter(Piece p) ;
	public  void Appliquer(Piece p, Joueur j)
	{
		
		//if p.estAction on appel la methode action
	}
	
}
