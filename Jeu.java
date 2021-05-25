<<<<<<< HEAD
import MG2D.*;
import MG2D.geometrie.*;

public class Jeu {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        int hauteur = 800;
        int largeur = 800;
        Fenetre f = new Fenetre("plateau",largeur,hauteur);
        Souris souris = f.getSouris();
        int tailleX = hauteur/21;
        int tailleY = hauteur/21;
        p.afficherPlateau(f, largeur, hauteur);
        while ( true ) { 
            try {
                Thread.sleep (20);
                }		
                catch ( Exception e ) {		
                System.out.println ( e );
                }
            //Ajout d'un pion si on fait un clic gauche
            if(souris.getClicGauche() == true){
                Point point = souris.getPosition();
                int posX = ((int)Math.round((double)point.getX()/tailleX ))-1;
                int posY = ((int)Math.round((double)point.getY()/tailleY ))-1;
                Pion pion = new Pion(posX,posY);
                //Permet de rester dans les limites du plateau
                if(posX <= 19 && posY <= 19 && posX >= 0 && posY >= 0){
                    p.afficherPion(f,largeur,hauteur,pion);
                    f.rafraichir();
                }
            }
        }
    }
=======
import MG2D.*;
import MG2D.geometrie.*;

public class Jeu {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        int hauteur = 800;
        int largeur = 800;
        Fenetre f = new Fenetre("plateau",largeur,hauteur);
        Souris souris = f.getSouris();
        int tailleX = hauteur/21;
        int tailleY = hauteur/21;
        p.afficherPlateau(f, largeur, hauteur);
        while ( true ) { 
            try {
                Thread.sleep (20);
                }		
                catch ( Exception e ) {		
                System.out.println ( e );
                }
            //Ajout d'un pion si on fait un clic gauche
            if(souris.getClicGauche() == true){
                Point point = souris.getPosition();
                int posX = ((int)Math.round((double)point.getX()/tailleX ))-1;
                int posY = ((int)Math.round((double)point.getY()/tailleY ))-1;
                Pion pion = new Pion(posX,posY);
                //Permet de rester dans les limites du plateau
                if(posX < 19 && posY < 19 && posX >= 0 && posY >= 0){
                    p.afficherPion(f,largeur,hauteur,pion);
                    f.rafraichir();
                }
            }
        }
    }
>>>>>>> d5fd5fb661bb8d8c13b5aeba857f311f3d663076
}