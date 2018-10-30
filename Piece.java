package Piece;
//Changement par rapport au diagramme de diagramme de classe précedemment fourni
//Piece n'est plus une interface
//Piece est une classe normal

public class Piece {

	public double  posX ; 
	public double posY ; 


	public Piece(double posX, double posY)
	{

		this.posX = posX ;
		this.posY  = posY ;
	}


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


	public static void main( String[] args)
	{
		
		Couleur c = Couleur.BLEUE ;
		System.out.println(c.toString());
		
		
	}


}
