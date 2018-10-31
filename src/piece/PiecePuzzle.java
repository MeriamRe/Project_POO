package piece;

import piece.ImagePuzzle;

public class PiecePuzzle extends Piece {
	
	private final int nbExcroissance ;
	private final int nbCreux ; 
	
	public PiecePuzzle(double posX, double posY, int nbExcroissance, int nbCreux) {
		
		super(posX,posY);
		this.nbCreux=nbCreux ; 
		this.nbExcroissance = nbExcroissance ;
		
	}
	

}
