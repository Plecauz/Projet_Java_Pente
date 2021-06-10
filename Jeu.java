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
        Point histobg = new Point(tailleX+250, hauteurf-80);
        Point histohd = new Point(tailleX+450, hauteurf-80);
        Point textecoor = new Point(tailleX+100,hauteurf-50);
        String pionsj1 = String.valueOf(j1.getNbPions());
        String pionsj2 = String.valueOf(j2.getNbPions());
        boolean menu = false;
        boolean arreter = false;

        // Affichage des infos;
        f.ajouter(new Texte(coltexte, j1.getNom(), Calibri, new Point(largeurf-150, hauteurf-200)));
        f.ajouter(new Texte(coltexte, pionsj1, Calibri, new Point(largeurf-150, hauteurf-250)));
        f.ajouter(new Texte(coltexte, j2.getNom(), Calibri, new Point(largeurf-150, hauteurf-500)));
        f.ajouter(new Texte(coltexte, pionsj2, Calibri, new Point(largeurf-150, hauteurf-550)));
        
        f.ajouter(new Rectangle(fond,histobg,histohd,true));
        f.ajouter(new Texte(coltexte, "Historique des coups", Calibri, textecoor));
                if (souris.getClicGauche() == true) {
                    Point collectclic = souris.getPosition();
                    if (collectclic.getX() > menubg.getX() &&  collectclic.getY() < menuhd.getY()) {
                        System.out.println("Historique à afficher");
                    }
                }
        p.afficherPlateau(f, largeur, hauteur);
        f.rafraichir();
        while (arreter == false ) { 
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
                    // Mise à jour du compteur
                    pionsj1 = String.valueOf(j1.getNbPions());
                    pionsj2 = String.valueOf(j2.getNbPions());
                    f.ajouter(new Texte(coltexte, j1.getNom(), Calibri, new Point(largeurf-150, hauteurf-200)));
                    f.ajouter(new Texte(coltexte, pionsj1, Calibri, new Point(largeurf-150, hauteurf-250)));
                    f.ajouter(new Texte(coltexte, j2.getNom(), Calibri, new Point(largeurf-150, hauteurf-500)));
                    f.ajouter(new Texte(coltexte, pionsj2, Calibri, new Point(largeurf-150, hauteurf-550)));
                    
                    

                    f.rafraichir();

            // Création des boutons et création des clics
            while (menu == false) {
                f.ajouter(new Rectangle(fond,menubg,menuhd,true));
                f.ajouter(new Texte(coltexte, "Menu Principal", Calibri, textecoor));
                if (souris.getClicGauche() == true) {
                    Point collectclic = souris.getPosition();
                    if (collectclic.getX() > menubg.getX() &&  collectclic.getY() < menuhd.getY()) {
                        f.fermer();
                        menu = true;
                        arreter = true;
                    }
                }
                f.rafraichir();
            }

                    
                }
            }
        }
    }
}