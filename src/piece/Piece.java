package piece;
//Changement par rapport au diagrammede classe précedemment fourni
//Piece n'est plus une interface
//Piece est une classe normal

//J'ai rajouté un champ Orientation pour fixer les orientations et les charactéristiques des
//pièces, puis j'ai rajouté un champ estConnecté[] et une méthode abstraite estConnectable()

public abstract class Piece {

	protected double posX ; 
	protected double posY ;
	protected Orientation[] ort = {Orientation.EST, Orientation.OUEST};
	protected boolean[] estConnecte = new boolean[4];//true si un côté correspond de la pièce est déjà connecté 


	public Piece(double posX, double posY) {
		this.posX = posX ;
		this.posY = posY ;
	}

	//------Getters & setters------
	public double getPosX() {
		return posX;
	}


	public void setPosX(double posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	
	public boolean[] getEstConnecte() {
		return estConnecte;
	}
	
	public void setEstConnecte(int i, boolean b) {
		this.getEstConnecte()[i] = b;
	}
	
	/**
	 * Si la pièce en main est connectable avec la pièce posée
	 * @return true si oui et false sinon
	 */
	public abstract boolean estConnectable(Piece p);


}
