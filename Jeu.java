import MG2D.*;
import MG2D.geometrie.*;

public class Jeu {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        Joueur j1 = new Joueur("Plop",1);
        Joueur j2 = new Joueur("Joueur",2);
        int hauteur = 800;
        int largeur = 800;
        Fenetre f = new Fenetre("plateau",largeur,hauteur);
        Souris souris = f.getSouris();
        int tailleX = hauteur/21;
        int tailleY = hauteur/21;
        p.afficherPlateau(f, largeur, hauteur);
        f.rafraichir();
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
                //Permet de rester dans les limites du plateau
                if(posX <= 19 && posY <= 19 && posX >= 0 && posY >= 0){
                    if (j1.getTour()){
                        Pion pion = new Pion(posX,posY,j1);
                        if(p.ajoutPion(pion)){
                            j1.setTour(false);
                            j2.setTour(true);
                        }
                    }
                    else{
                      Pion pion = new Pion(posX,posY,j2);
                        if(p.ajoutPion(pion)){
                            j2.setTour(false);
                            j1.setTour(true);
                        }
                    }
                    f.effacer();
                    p.afficherPlateau(f, largeur, hauteur);
                    for(Pion[] ligne: p.getIntersections()){
                        for(Pion element: ligne){
                            if(element != null){
                                p.afficherPion(f,largeur,hauteur,element);
                            }
                        }
                    }
                    f.rafraichir();
                }
            }
        }
    }

        public void victoire(int numJoueur) {
    
            String joueur = String.valueOf(numJoueur);
            int largeur = 1080;
            int hauteur = 720;
            Font Calibri = new Font("Calibri", Font.TYPE1_FONT, 40);
            Couleur texte = new Couleur(153,38,0);
            Couleur cadre = new Couleur(166,166,166);
            Fenetre f = new Fenetre("Jeu de Pente", largeur, hauteur);
    
            f.ajouter(new Rectangle(cadre, new Point(300,500), new Point(780,600), true));
            f.ajouter(new Texte(texte, "Felicitations Joueur " + joueur + " !", Calibri, new Point ((980/2)+50,500+50)));
    
            f.ajouter(new Rectangle(cadre, new Point(300,425), new Point(780,500), true));
            f.ajouter(new Texte(texte, "Vous avez gagne !!!", Calibri, new Point ((980/2)+50,500)));
    
            f.rafraichir();
        }
    }
}