package Piece;

public class piecePuzzle extends Piece {
	
	private double posX ;
	private double posY ;
	private int nbExcroissance ;
	private int nbCreux ; 
	
	public piecePuzzle(double posX, double posY, int nbExcroissance, int nbCreux)
	{
		super(posX,posY);
		this.nbCreux=nbCreux ; 
		this.nbExcroissance = nbExcroissance ;
		
	}
	
	//pour les estBord() estCoin() j'ai pas trop compris le concept
	

}
