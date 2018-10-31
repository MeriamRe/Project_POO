package joueur;

import piece.Piece;

public abstract class JoueurSaboteur extends Joueur {

	public JoueurSaboteur(int id, String pseudo, int nbPiece) {
		super(id, pseudo, nbPiece);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void piocher() {
		// TODO Auto-generated method stub

	}

	@Override
	public void poser() {
		// TODO Auto-generated method stub

	}

	//cette classe je vais la mettre à abstract vu que je n'ai pas enocre
	//les méthodes Appliquer et Jeter
	public abstract void Jeter(Piece p) ;
	public void Appliquer(Piece p, Joueur j)
	{

		//if p.estAction on appelle la methode action
	}

}
