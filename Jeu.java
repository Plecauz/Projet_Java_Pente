import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;


public class Jeu {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        Joueur j1 = new Joueur("Plop",1);
        Joueur j2 = new Joueur("Joueur",2);
        int hauteurf = 900;
        int largeurf = 1300;
        int hauteur = 800;
        int largeur = 800;
        Fenetre f = new Fenetre("plateau",largeurf,hauteurf);
        Souris souris = f.getSouris();
        int tailleX = hauteur/21;
        int tailleY = hauteur/21;

        // Création des boutons de navigation
        Couleur coltexte = new Couleur(153,38,0);
        Couleur fond = new Couleur(175,222,228);
        Font Calibri = new Font("Calibri", Font.TYPE1_FONT, 25);
        // Bouton Menu
        Point menubg = new Point(tailleX,hauteurf-80);
        Point menuhd = new Point(tailleX+200,hauteurf-20);
        Point textecoor = new Point(tailleX+100,hauteurf-50);
        boolean menu = false;
        /*f.ajouter(new Rectangle(fond,menubg,menuhd,true));
        f.ajouter(new Texte(coltexte, "Menu Principal", Calibri, textecoor));*/

        // Affichage des infos
        f.ajouter(new Texte(coltexte, j2.getNom(), Calibri, new Point(largeurf-100, hauteurf-50)));

        p.afficherPlateau(f, largeur, hauteur);
        f.rafraichir();
        while ( true ) { 
            // Vérification des clics
            /*while (menu == false) {
                f.ajouter(new Rectangle(fond,menubg,menuhd,true));
                f.ajouter(new Texte(coltexte, "Menu Principal", Calibri, textecoor));
                if (souris.getClicGauche() == true) {
                    System.out.println("Le clic a bien été pris en compte");
                    Point collectclic = souris.getPosition();
                    System.out.println("Coordonnées de la souris : "+collectclic);
                    System.out.println("Coordonnées du bouton : "+menubg+" "+ menuhd);
                    if ( collectclic.getX() > menubg.getX() &&  collectclic.getY() > menuhd.getY()) {
                        f.fermer();
                        menu = true;
                    }
                }
                f.rafraichir();
            }*/
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
                Pion pion = new Pion(5,4,j1);
                //Permet de rester dans les limites du plateau
                if(posX <= 19 && posY <= 19 && posX >= 0 && posY >= 0){
                    if (j1.getTour()){
                        pion = new Pion(posX,posY,j1);
                        p.afficherPion(f,largeur,hauteur,pion);
                        j1.setTour(false);
                        j2.setTour(true);
                    }
                    else{
                        pion = new Pion(posX,posY,j2);
                        p.afficherPion(f,largeur,hauteur,pion);
                        j2.setTour(false);
                        j1.setTour(true);
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
}