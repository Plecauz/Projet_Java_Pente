import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;

public class Victoire {
    public static void main(int num) {

        int largeur = 1080;
        int hauteur = 720;
        Font Calibri = new Font("Calibri", Font.TYPE1_FONT, 40);
        Couleur texte = new Couleur(153,38,0);
        Couleur cadre = new Couleur(166,166,166);
        Fenetre f = new Fenetre("Jeu de Pente", largeur, hauteur);

        f.ajouter(new Rectangle(cadre, new Point(300,500), new Point(780,600), true));
        f.ajouter(new Texte(texte, "Felicitations Joueur " + num + " !", Calibri, new Point ((980/2)+50,500+50)));

        f.ajouter(new Rectangle(cadre, new Point(300,425), new Point(780,500), true));
        f.ajouter(new Texte(texte, "Vous avez gagne !!!", Calibri, new Point ((980/2)+50,500)));

        f.rafraichir();
    }
}