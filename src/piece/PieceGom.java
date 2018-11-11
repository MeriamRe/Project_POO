package piece;

public class PieceGom extends Piece {

	private final Forme forme1 ; 
	private final Forme forme2 ;
	private final Couleur clr1 ;
	private final Couleur clr2 ;


	public PieceGom(double posX, double posY, Forme f1, Forme f2, Couleur clr1, Couleur clr2) {
		super(posX, posY) ;
		this.forme1 = f1 ;
		this.forme2 = f2 ;
		this.clr1 = clr1 ;
		this.clr2 = clr2 ;

	}

	//------Getters------
	public Forme getForme1() {
		return forme1;
	}

	public Forme getForme2() {
		return forme2;
	}

	public Couleur getClr1() {
		return clr1;
	}

	public Couleur getClr2() {
		return clr2;
	}

	@Override
	public boolean estConnectable(Piece p) {
		// TODO Auto-generated method stub
		return false;
	}


}
