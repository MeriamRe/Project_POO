package piece;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import jeu.JeuPuzzle;

/**
 * On dispose d'une image carrée
 * On découpe ensuite cette image en 9 pièce
 * Il s'agit d'un puzzle par glissement
 * 
 * @author"Jiayin"
 *
 */
public class PiecePuzzle extends Piece {
	
	//pour associer les pièces au jeu
	private JeuPuzzle leJeu;
	
	//un côte de pièce puzzle défini par la taille de l'image carrée
	private final int cote;
	
	//pour attribuer un id à chaque pièce 
	private final int id;
	
	//pour enlever une pièce
	private boolean estVide = false;
	
	/**
	 * Constructeur qui prend la position de la pièce, le jeu auquel le pièce s'attache
	 * et la longueur de la côté
	 * @param posX
	 * @param posY
	 * @param leJeu
	 * @param cote
	 */
	public PiecePuzzle(int posX, int posY, JeuPuzzle leJeu, int cote, int id) {
		
		super(posX,posY);
		this.leJeu = leJeu;
		this.id = id;
		this.cote = cote;
		
	}
	
	//Si on n'utilise pas d'interface graphique
	public PiecePuzzle(int x, int y, int id) {
		super(x,y);
		this.id = id;
		this.cote = 10;
	}

	//------Getters & setters------
	public int getId() {
		return id;
	}
	public boolean estVide() {
		return this.estVide;
	}
	public void setEstVide(boolean b) {
		this.estVide = b;
	}
	
	/**
	 * Vérifier si dans cette zone correspondante de la pièce puzzle il a un clique
	 * Autrement dit si la pièce a été cliquée
	 * @param posX
	 * @param posY
	 * @return	true si c'est cliquée et false sinon
	 */
	public boolean estClique(int x, int y) {
		return new Rectangle(this.getPosX()*(30+cote), this.getPosY()*(30+cote),cote+30,cote+30).contains(x, y);
	}
	
	/**
	 * Pour Puzzle glisser, étant donné que les pièces sont déjà côte à côte,
	 * cette méthode sert à vérifier si le jeu est fini
	 */
	@Override
	public boolean estConnectable(Piece p) {
		boolean res = false;
		if(this.getPosX() == p.getPosX() && this.getPosY() == (p.getPosY()-1))res = true;	
		if(this.getPosX() == p.getPosX() && this.getPosY() == (p.getPosY()+1))res = true;
		if(this.getPosY() == p.getPosY() && this.getPosX() == (p.getPosX()-1))res = true;
		if(this.getPosY() == p.getPosY() && this.getPosX() == (p.getPosX()+1))res = true;
		return res;
	}
	
	/**
	 * Une pièce est glissable si elle est connectée à p
	 * et que p soit vide (non occupé)
	 * Si tel cas on déplace la pièce en main
	 * @param p une pièce voisine a priori
	 * @return true si glissable false sinon
	 */
	public boolean glisser(Piece p){
		boolean res = false;
		if ((((PiecePuzzle)p).estVide()==true) && (this.estConnectable(p)==true)) {
			res = true;
			int x = this.getPosX();
			int y = this.getPosY();
			this.setPosX(p.getPosX());
			this.setPosY(p.getPosY());
			p.setPosX(x);
			p.setPosY(y);
		}
		return res;
	}
	
	/**
	 * Pour dessiner chaque pièce
	 * @param g
	 */
	public void paint(Graphics g) {
		if(this.estVide() == false) {
			int x = id/3;
			int y = id%3;
			
			
			g.drawImage(leJeu.getImg(), this.getPosX()*cote, this.getPosY()*cote,
										(this.getPosX()+1)*cote, (this.getPosY()+1)*cote,
										x*cote, y*cote,
										(x+1)*cote, (y+1)*cote,
										leJeu);
			g.setColor(Color.WHITE);
			
			g.drawLine(this.getPosX()*cote+(cote-1), this.getPosY()*cote, 
						this.getPosX()*cote+(cote-1), (this.getPosY()+1)*cote);
			
			g.drawLine(this.getPosX()*cote, this.getPosY()*cote+(cote -1), 
						(this.getPosX()+1)*cote, this.getPosY()*cote+(cote-1));
			g.setColor(Color.BLACK);
			g.drawLine(this.getPosX()*cote, this.getPosY()*cote, this.getPosX()*cote, (this.getPosY()+1)*cote);
			g.drawLine(this.getPosX()*cote, this.getPosY()*cote, (this.getPosX()+1)*cote, this.getPosY()*cote);
		}
	}

	/**
	 * Méthode toString
	 */
	@Override
	public String toString() {
		return "\nPiecePuzzle \n"
				+ "[ cote=" + cote + 
				", id=" + id + 
				", estVide=" + estVide + 
				",\tposX=" + this.getPosX() +
				",\tposY=" + this.getPosY() + " ]\n";
	}
}
