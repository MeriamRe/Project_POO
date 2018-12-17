package joueur;

import piece.PiecePuzzle;

public class JoueurPuzzle extends Joueur {

	/**
	 * Pour un joueur de Puzzle, on note les pièces qu'il a 
	 * déplacées pandent le jeu dans le LinkedList Main
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
	 * les pièces déplacées par chaque joueur
	 * @param pp PiècePuzzle
	 */
	public void piocher(PiecePuzzle pp) {
		this.getMain().add(pp);
	}

	@Override
	public void poser() {
		// TODO Auto-generated method stub
	} 


}
