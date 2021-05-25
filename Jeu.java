import MG2D.*;
import MG2D.geometrie.*;

public class Jeu {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Souris souris = f.getSouris();
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
                pion = new Pion(posX,posY);
                if(posX < 19 && posY < 19 && posX >= 0 && posY >= 0){
                    p.afficherPion(f,largeur,hauteur,pion);
                    f.rafraichir();
                }
            }
    }
}