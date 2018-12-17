package jeu;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import joueur.Joueur;
import joueur.JoueurPuzzle;
import piece.PiecePuzzle;
import plateau.Plateau;

/**
 * Engine du jeu Puzzle
 */
@SuppressWarnings("serial")
public class JeuPuzzle extends Jeu {


	//-----------------------------------------------------------------
	//-------------------------LES ATTRIBUTS---------------------------
	//-----------------------------------------------------------------

	//les pieces qu'un jeu possede
	private PiecePuzzle[] lesPieces;
	private final PiecePuzzle[] puzzleReini;

	//un plateau pour placer les pieces
	private Plateau plateau; 
	private final Plateau plateauReini;
	//image importee dans le jeu, il y aura 4 choix
	private Image img;

	//Si on a melange
	private boolean melange = false;

	//Si le jeu est fini
	private boolean fini = false;

	//id de la piece retiree
	private int idVide;
	private int idVideBis;

	//pour les joueurs
	private String nom1, nom2;
	private JoueurPuzzle joueurCourant = new JoueurPuzzle(0, "anonyme");

	//Scanner pour la representation textuelle
	private Scanner scan;

	//-----------------------------------------------------------------
	//-------------------------LES CONSTRUCTEURS-----------------------
	//-----------------------------------------------------------------

	public JeuPuzzle(JoueurPuzzle p1, JoueurPuzzle p2, Image img) {
		super(p1, p2);
		this.img = img;

		int cote = (int) Math.ceil(this.img.getWidth(this) / 3.0);

		this.lesPieces = new PiecePuzzle[9];
		this.puzzleReini = new PiecePuzzle[9];

		for (int i = 0; i < 9; i++) {
			this.lesPieces[i] = new PiecePuzzle(i / 3, i % 3, this, cote, i);
			this.puzzleReini[i] = new PiecePuzzle(i / 3, i % 3, this, cote, i);
		}
		this.plateau = new Plateau(this,3,3);
		this.plateauReini = new Plateau(this,3,3);
	}

	/**
	 * Constructeur pour la représenation textuelle
	 * @param p1
	 * @param p2
	 */
	public JeuPuzzle(JoueurPuzzle p1, JoueurPuzzle p2) {
		super(p1,p2);
		this.scan = new Scanner(System.in);

		int cote = 10;

		this.lesPieces = new PiecePuzzle[9];
		this.puzzleReini = new PiecePuzzle[9];

		for (int i = 0; i < 9; i++) {
			this.lesPieces[i] = new PiecePuzzle(i / 3, i % 3, this, cote, i);
			this.puzzleReini[i] = new PiecePuzzle(i / 3, i % 3, this, cote, i);
		}
		this.plateau = new Plateau(this,3,3);
		this.plateauReini = new Plateau(this,3,3);
	}

	//-----------------------------------------------------------------
	//-------------------------LES GETTERS & SETTERS-------------------
	//-----------------------------------------------------------------

	public PiecePuzzle[] getLesPieces() {
		return lesPieces;
	}

	public void setLesPieces(PiecePuzzle[] lesPieces) {
		this.lesPieces = lesPieces;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean isFini() {
		int k = 0;
		for(int i = 0; i<9; i++) {
			if (lesPieces[i].getPosX() == i/3
					&& lesPieces[i].getPosY() == i%3) {
				k ++;
			} 
		}
		if(k == 9) this.setFini(true);
		return this.fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}

	public JoueurPuzzle getJoueurCourant() {
		return this.joueurCourant;
	}

	public void setJoueurCourant(JoueurPuzzle jp) {
		this.joueurCourant = jp;
	}

	public boolean isMelange() {
		return melange;
	}

	public void setMelange(boolean melange) {
		this.melange = melange;
	}

	public Joueur getP1() {
		return super.p1;
	}

	public Joueur getP2() {
		return super.p2;
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}


	public PiecePuzzle[] getPuzzleReini() {
		return puzzleReini;
	}


	//-----------------------------------------------------------------
	//-------------------------LES THREADS---------------------------
	//-----------------------------------------------------------------

	/**
	 * Melanger les pieces qui se trouvent dans lesPieces
	 * Interchangeant un voisin de la pièce vide avec elle-même
	 */
	Runnable runMelanger = new Runnable(){
		public void run() {
			melange = true;

			while (isMelange() == true) {
				System.out.println("<Mélange en cours>");
				ArrayList<Integer> deplacement = new ArrayList<Integer>();
				for (PiecePuzzle pp : lesPieces) {
					if (pp.estConnectable(lesPieces[idVide])) {
						deplacement.add(pp.getId());
					}
				}

				int ind = (int) ((Math.random()*deplacement.size()));

				try {
					int tmpX = lesPieces[deplacement.get(ind)].getPosX();
					int tmpY = lesPieces[deplacement.get(ind)].getPosY();
					int tmpXr = puzzleReini[deplacement.get(ind)].getPosX();
					int tmpYr = puzzleReini[deplacement.get(ind)].getPosY();

					lesPieces[deplacement.get(ind)].setPosX(lesPieces[idVide].getPosX());
					lesPieces[deplacement.get(ind)].setPosY(lesPieces[idVide].getPosY());
					puzzleReini[deplacement.get(ind)].setPosX(puzzleReini[idVide].getPosX());
					puzzleReini[deplacement.get(ind)].setPosY(puzzleReini[idVide].getPosY());
					plateau.getLesCases()[lesPieces[idVide].getPosX()][lesPieces[idVide].getPosY()].setP(lesPieces[deplacement.get(ind)]);
					plateauReini.getLesCases()[puzzleReini[idVide].getPosX()][puzzleReini[idVide].getPosY()].setP(puzzleReini[deplacement.get(ind)]);

					lesPieces[idVide].setPosX(tmpX);
					lesPieces[idVide].setPosY(tmpY);
					puzzleReini[idVide].setPosX(tmpXr);
					puzzleReini[idVide].setPosY(tmpYr);
					plateau.getLesCases()[tmpX][tmpY].setP(lesPieces[idVide]);
					plateauReini.getLesCases()[tmpX][tmpY].setP(puzzleReini[idVide]);

				} catch (Exception e) {
					System.out.println("Erreur");
				}
				repaint();
				try {
					Thread.sleep(600);
				} catch (InterruptedException e) {
					System.out.println("Erreur, interruption");
				}
			}
		}
	};

	Thread melanger = new Thread(runMelanger);

	/**
	 * Gestionnaire des joueurs
	 */
	Runnable runGestionJoueur = new Runnable() {
		public void run() {
			if(JeuPuzzle.this.isMelange() == true)	JeuPuzzle.this.setMelange(false);
			repaint();
		}
	};

	public void gestionJoueur() {
		Thread gj = new Thread(runGestionJoueur);
		gj.start();
		melanger.interrupt();
	}

	/**
	 * Choisir le joueur courant
	 * @param jp
	 */
	public void ChoisirJoueurCourant(JoueurPuzzle jp) {
		this.joueurCourant = jp;
	}


	//-----------------------------------------------------------------
	//-------------------------PARTIE GRAPHIQUE------------------------
	//-----------------------------------------------------------------

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 9; i++) {
			this.getLesPieces()[i].paint(g);
		}
	}

	/**
	 * Ce qui serait passer si on clique sur une pièce: si tout se passe bien 
	 * @param e
	 */
	public void Cliquer(MouseEvent e) {
		for (PiecePuzzle pp : this.getLesPieces()) {
			if (pp.estClique(e.getX(), e.getY())) {
				if (pp.glisser(this.lesPieces[idVide]) == true) {
					this.getJoueurCourant().piocher(pp);
				}
			}
		}
		repaint();

		this.isFini();

		System.out.println("Le jeu est-il fini? " + this.isFini());
	}

	/**
	 * Version textuelle de Cliquer(MouseEvent e)
	 */
	public void deplacer(int idP) {
		if (this.getLesPieces()[idP].glisser(this.lesPieces[idVide]) == true) {
			this.getJoueurCourant().piocher(this.getLesPieces()[idP]);
			int x = this.getLesPieces()[idP].getPosX();
			int y = this.getLesPieces()[idP].getPosY();
			this.plateau.getLesCases()[x][y].setP(this.getLesPieces()[idP]);
			this.plateau.getLesCases()[this.getLesPieces()[idVide].getPosX()][this.getLesPieces()[idVide].getPosY()].setP(this.getLesPieces()[idVide]);
		} else {
			System.out.println("<NON: Vous ne pouvez pas bouger cette pièce\n>");
		}
		this.isFini();			
	}

	//-----------------------------------------------------------------
	//-------------------------ENGINE JEU------------------------
	//-----------------------------------------------------------------

	@Override
	/**
	 * Commencer le jeu de puzzle, proposer une configuration de l'image choisie
	 */
	public void commencerJeu() {

		if(this.getImg() == null) {
			System.out.println("<Dans ce jeu, il y a deux joueurs en concurrence.\nC'est un jeu de puzzle glissant de 9 pièces"
					+ " dont une a été retirée au hasard.\nVous allez faire vous mieux de les reconstituer.>\n");
			System.out.println("<Saisir informations joueur>");
			System.out.println("Le joueur 1 entre son pseudo: ");
			nom1 = scan.nextLine();
			System.out.println("Le joueur 2 entre son pseudo: ");
			nom2 = scan.nextLine();
			p1.setPseudo(nom1);
			p2.setPseudo(nom2);

			System.out.println("<Choisir le joueur courant>");
			System.out.println("<Entrer [1] pour choisir le joueur "+ this.getP1().getPseudo() +">");
			System.out.println("<Entrer [2] pour choisir le joueur "+ this.getP2().getPseudo() +">");
			System.out.println("[1]/[2]? :");int num = scan.nextInt();
			if(num == 1) {
				this.setJoueurCourant((JoueurPuzzle)p1);
			} else if(num == 1){
				this.setJoueurCourant((JoueurPuzzle)p2);
			}
			System.out.println("<Le joueur courant est " + this.getJoueurCourant().getPseudo() + ">");
		}

		System.out.println("\n<Le jeu a commencé>");

		//On retire aelatoiremant une piece
		Random r = new Random();
		idVide = r.nextInt(9);
		idVideBis = idVide;
		this.lesPieces[idVide].setEstVide(true);
		this.puzzleReini[idVide].setEstVide(true);

		melanger.start();

		if(this.getImg() == null) {
			System.out.println("<Appuyer sur le touche [s] pour attêter le mélange>");
			String next = scan.next();
			if( next.equals("s")) {
				this.setMelange(false);
				System.out.println("<Le mélange s'arrête " + this.isMelange() +">");
			}
		}
	}

	/**
	 * Copier la configuration initiale
	 */

	/**
	 * Joueur le jeu avec le clavier
	 */
	public void jouerClavier() {
		this.plateau.afficher();
		System.out.println("<Voulez-vous déplacer quelle pièce?>");
		int idP = scan.nextInt();
		this.deplacer(idP);
	}
	/*
	 * (non-Javadoc)
	 * @see jeu.Jeu#finirJeu()
	 */
	@Override
	public void finirJeu() throws InterruptedException {
		if (this.fini == true) {
			this.lesPieces[idVide].setEstVide(false);
			System.out.println("<Le jeu est terminé.>");
			System.out.println("Le joueur " + this.joueurCourant.getPseudo()
			+ " a fait " + this.joueurCourant.getMain().size()
			+ " déplacements de pièce.");
			this.plateau.afficher();
			melanger.interrupt();
		}
		this.repaint();
		if(this.p1.getMain().size()!=0 && this.p2.getMain().size()!=0) {
			this.revelerGagnant();
		}
	}

	@Override
	/**
	 * On compare le nombre de pas que chaque joueur a utilis, le plus petit gagne.
	 */
	public void revelerGagnant() {
		String g = "";
		g = ((JoueurPuzzle) getP1()).getMain().size() < ((JoueurPuzzle) getP2()).getMain().size()?
				((JoueurPuzzle) getP1()).getPseudo() : ((JoueurPuzzle) getP2()).getPseudo();
				System.out.println("Le gagnant est " + g);
	}

	/**
	 * Reinitialisation
	 */
	public void reinitialiser() {
		idVideBis = idVide;
		this.lesPieces[idVideBis].setEstVide(true);	
		for(int i = 0; i < 9; i++) {
			lesPieces[i] = puzzleReini[i];
			plateau = plateauReini;
		}
		this.setFini(false);
		this.repaint();
		this.ChoisirJoueurCourant(p1.getMain().size()==0?(JoueurPuzzle) p1:(JoueurPuzzle) p2);
	}

}
