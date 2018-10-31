package piece;
//Changement par rapport au diagrammede classe précedemment fourni
//Piece n'est plus une interface
//Piece est une classe normal

public class Piece {

	public double posX ; 
	public double posY ; 


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

}
