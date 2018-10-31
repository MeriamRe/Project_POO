package piece;

public class PieceDominos extends Piece {

	private final int num1 ;
	private final int num2 ;


	public PieceDominos(double posX, double posY, int num1, int num2) {

		super(posX,posY);
		this.num1 = num1 ;
		this.num2 = num2 ;

	}

	//------Getters------
	public int getNum1() {
		return( this.num1);
	}

	public int getNum2() {
		return (this.num2);

	}

}
