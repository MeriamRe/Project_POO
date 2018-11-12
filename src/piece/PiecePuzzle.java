package piece;
import java.util.Random;

/**
 * On dispose d'une image dont les caract�ristiques sont d�finis dans la classe piece.ImagePuzzle
 * On d�coupe ensuite cette image en un nombre Npuzzle de pi�ce
 * 
 * Il y trois types de pi�ce: coins, c�t�s et interieurs
 * Coins: deux c�t�s droits
 * C�t�s: un c�t� droit
 * Int�rieur: pas de c�t� droit
 * 
 * Pour un jeu de puzzle, on d�finit d'abord les pi�ces des coins, puis des c�t�s, puis des int�rieurs
 * 
 * @author"Jiayin"
 *
 */
public class PiecePuzzle extends Piece {
	
	private final boolean[] config = new boolean[4];//true si un excroissance et false si un creux
	private final Orientation[] ort = {Orientation.NORD, Orientation.SUD, Orientation.EST, Orientation.OUEST};
	
	public PiecePuzzle(double posX, double posY) {
		
		super(posX,posY);
		int k = 4;
		if (this instanceof PiecePuzzleCoins) k = 2;
		if (this instanceof PiecePuzzleCotes) k = 3;
		
		for(int i = 0; i< k; i++) {
			Random r = new Random();
			int temp = r.nextInt(1);
			if (temp == 1) {
				this.config[i] = true;
			} else {
				this.config[i] = false;
			}
		}
		
	}

	public boolean[] getConfig() {
		boolean[] tab = new boolean[4];
		for (int i = 0; i< 4; i++) {
			tab[i] = this.config[i];
		}
		return tab;
	}

	@Override
	public boolean estConnectable(Piece p) {
		boolean res = false;
		for(int i = 0; i< 4; i++) {
			if(this.estConnecte[i] == false) {
				res = (((PiecePuzzle)p).getConfig()[3-i] != this.getConfig()[i]);
				p.setEstConnecte(3-i, res);
			}
			if (res == true) return res;
		}
		return res;
	}
	

}
