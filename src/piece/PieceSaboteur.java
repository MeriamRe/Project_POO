package piece;

import joueur.Joueur;

public class PieceSaboteur extends Piece {


	private final SabType type ; 
	//Changement par rapport au diagramme de classe
	//il n'y a plus d'attribut estAction


	public PieceSaboteur  (int posX, int posY, SabType type) {

		super(posX,posY);
		this.type = type ;
	}

	public SabType getType() {
		return this.type ;
	}

	public boolean estAction() {
		if(this.getType().equals(SabType.ACTION1)&&(this.getType().equals(SabType.ACTION1))) {
			return true ;
		}
		return false ;

	}

	//cette fonction est appelée si le joueur choisit 
	// de réaliser une action sur un autre joueur

	public void Action(Joueur p, SabType type) {

		// A définir les actions à faire
		// Cela va dépendre de quelle action on chosit soit l'action Action1 ou Action2.


		if(type.equals(SabType.ACTION1)) {
			//Traitement1 
		}	

		if(type.equals(SabType.ACTION2)) {
			//Traitement2
		}	

	}

	@Override
	public boolean estConnectable(Piece p) {
		// TODO Auto-generated method stub
		return false;
	}



}