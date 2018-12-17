package joueur;

import piece.PiecePuzzle;

public class JoueurPuzzle extends Joueur {

	/**
	 * Pour un joueur de Puzzle, on note les pi�ces qu'il a 
	 * d�plac�es pandent le jeu dans le LinkedList Main
	 * @param id
	 * @param pseudo
	 * @param age
	 */
	public JoueurPuzzle(int id, String pseudo) {
		super(id, pseudo);
	}

	@Override
	public void piocher() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Surcharge de piocher pour le cas de Puzzle
	 * Car on veut enregistrer dans un tableau 
	 * les pi�ces d�plac�es par chaque joueur
	 * @param pp Pi�cePuzzle
	 */
	public void piocher(PiecePuzzle pp) {
		this.getMain().add(pp);
	}

	@Override
	public void poser() {
		// TODO Auto-generated method stub
	} 


}
