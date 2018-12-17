package piece;
//Changement par rapport au diagrammede classe pr�cedemment fourni
//Piece n'est plus une interface
//Piece est une classe normal

//J'ai rajout� un champ Orientation pour fixer les orientations et les charact�ristiques des
//pi�ces, puis j'ai rajout� un champ estConnect�[] et une m�thode abstraite estConnectable()

public abstract class Piece {

	protected int posX ; 
	protected int posY ;
	protected Orientation[] ort = {Orientation.EST, Orientation.OUEST};
	protected boolean[] estConnecte = new boolean[4];//true si un c�t� correspond de la pi�ce est d�j� connect� 


	public Piece(int posX, int posY) {
		this.posX = posX ;
		this.posY = posY ;
	}

	//------Getters & setters------
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
	public boolean[] getEstConnecte() {
		return estConnecte;
	}
	
	public void setEstConnecte(int i, boolean b) {
		this.getEstConnecte()[i] = b;
	}
	
	/**
	 * Si la pi�ce en main est connectable avec la pi�ce pos�e
	 * @return true si oui et false sinon
	 */
	public abstract boolean estConnectable(Piece p);


}
