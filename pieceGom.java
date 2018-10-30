package Piece;
public class pieceGom extends Piece {




	private Forme forme1 ; 
	public Forme getForme1() {
		return forme1;
	}
	public void setForme1(Forme forme1) {
		this.forme1 = forme1;
	}
	public Forme getForme2() {
		return forme2;
	}
	public void setForme2(Forme forme2) {
		this.forme2 = forme2;
	}
	public Couleur getClr1() {
		return clr1;
	}
	public void setClr1(Couleur clr1) {
		this.clr1 = clr1;
	}
	public Couleur getClr2() {
		return clr2;
	}
	public void setClr2(Couleur clr2) {
		this.clr2 = clr2;
	}
	private Forme forme2 ;
	private Couleur clr1 ;
	private Couleur clr2 ;

	public pieceGom(double posX, double posY, Forme f1, Forme f2, Couleur clr1, Couleur clr2)
	{
    super(posX, posY) ;
    this.forme1 = f1 ;
    this.forme2 = f2 ;
    this.clr1 = clr1 ;
    this.clr2 = clr2 ;
    

	}





}
