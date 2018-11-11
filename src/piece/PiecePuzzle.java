package piece;

import piece.ImagePuzzle;

public class PiecePuzzle extends Piece {
	
//	private final int nbExcroissance ;
//	private final int nbCreux ; 
	public final Orientation[] ort = {Orientation.NORD, Orientation.SUD, Orientation.EST, Orientation.OUEST};
	public PiecePuzzle(double posX, double posY, int nbExcroissance, int nbCreux) {
		
		super(posX,posY);
//		this.nbCreux=nbCreux ; 
//		this.nbExcroissance = nbExcroissance ;
		
	}

	@Override
	public boolean estConnectable(Piece p) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
