import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;

public class Demarrage{
    public static void main(String[] args) {

        int x1 = 100;
        int x2 = 980;
        int y1 = 500;
        int y2 = 600;
        //Largeur et Hauteur de la fenêtre
        int largeur = 1080;
        int hauteur = 720;
        Fenetre f = new Fenetre("Jeu de Pente", largeur, hauteur);
        Souris souris = f.getSouris();
        //public Démarrage(java.util.ArrayList<Dessin> Carre);
        Couleur texte = new Couleur(153,38,0);
        Couleur cadre = new Couleur(166,166,166);

        Font Calibri = new Font("Calibri", Font.TYPE1_FONT, 40);


        // Créer un rectangle pour afficher le nom du jeu
        f.ajouter(new Rectangle(cadre, new Point(x1,y1), new Point(x2,y2), true));
        f.ajouter(new Texte(texte, "Jeu de pente", Calibri, new Point ((x2/2)+50,y1+50)));
        
        // Créer un rectangle pour lancer la partie
        f.ajouter(new Rectangle(cadre, new Point((x1/2)+50,(y1/2)+100), new Point(x2/2,(y2/2)+100), true));
        f.ajouter(new Texte(texte, "Jouer",Calibri , new Point ((x2/4)+50,(y1/2)+125)));

        // Créer un rectangle pour lire les règles
        f.ajouter(new Rectangle(cadre, new Point((x1/2)+(largeur/2),(y1/2)+100), new Point((x2/2)+(largeur/2)-50,(y2/2)+100), true));
        f.ajouter(new Texte(texte, "Les regles", Calibri, new Point ((x2/4)+(largeur/2),(y1/2)+125)));

        // Créer un rectangle pour lancer la partie
        f.ajouter(new Rectangle(cadre, new Point((largeur/2)-100, 50), new Point((largeur/2)+100,100), true));
        f.ajouter(new Texte(texte,"Quitter",Calibri, new Point (largeur/2,75) ));
        f.rafraichir();

        //Détection des clics sur les boutons

        boolean play = true;
        while ( play) {
            if (souris.getClicGauche() == true) {
                Point xclic = souris.getPosition();
                Point yclic = souris.getPosition();
                // Si le clic est effectué dans la zone du rectangle "Jouer", lance le jeu
                if (xclic.getX() > (x1/2)+50 && yclic.getY() > (y1/2)+100) {
                    if (xclic.getX() < x2/2 && yclic.getY() < (y2/2)+100 ) {
                        Jeu.main(args);
                    }       
                }
                // Si le clic est effectué dans la zone du rectangle "Quitter", ferme la fenêtre du menu
                if (xclic.getX() > (largeur/2)-100 && yclic.getY() > 50) {
                    if (xclic.getX() < (largeur/2)+100 && yclic.getY() < 100) {
                        f.fermer();
                        play = false;
                    }
                }
                
            }
            f.rafraichir();
        }
        

    }

}