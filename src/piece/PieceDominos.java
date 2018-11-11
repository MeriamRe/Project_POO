package piece;

public class PieceDominos extends Piece {

	private final int[] num = new int[2];


	public PieceDominos(double posX, double posY, int num1, int num2) {

		super(posX,posY);
		this.num[0] = num1;
		this.num[1] = num2;

	}

	//------Getters------
	public int[] getNum() {
		 int[] tab = new int[2];
		 tab[0] = this.num[0];
		 tab[1] = this.num[1];
		 return tab;
	}
	
	//Bon je me suis rendue compte que c'est toi qui s'occupes de Dominos après avoir terminer 
	//cette méthode... bon dis moi ce que tu en penses et je toucherais pas dom gommette, 
	//j'attaque le puzzle
	
	
	/**
	 * Si un côté de la pièce posée n'est pas connecté encore, on essaie 
	 * les deux chiffres de la pièce en main et voir si on peux les connecter
	 * @param dom pièce domino en main
	 * @return true si oui et false sinon
	 */
	public boolean estConnectable(Piece dom) {
		boolean res = false;
		if(this.getEstConnecte()[0] == false) {
			res = (((PieceDominos)dom).getNum()[0] == this.getNum()[0] || ((PieceDominos)dom).getNum()[1] == this.getNum()[0]);
			this.setEstConnecte(0, res);
			if(((PieceDominos)dom).getNum()[0] == this.getNum()[0]) {
				dom.setEstConnecte(0, res);
			} else if(((PieceDominos)dom).getNum()[1] == this.getNum()[0]) {
				dom.setEstConnecte(1, res);
			}
		}
		if(this.getEstConnecte()[1] == false){
			res = (((PieceDominos)dom).getNum()[0] == this.getNum()[1] || ((PieceDominos)dom).getNum()[1] == this.getNum()[1]);
			this.setEstConnecte(1, res);
			if(((PieceDominos)dom).getNum()[0] == this.getNum()[1]) {
				dom.setEstConnecte(0, res);
			} else if(((PieceDominos)dom).getNum()[1] == this.getNum()[1]) {
				dom.setEstConnecte(1, res);
			}
		}
		return res;
	}

}
