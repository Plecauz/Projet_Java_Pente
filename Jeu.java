import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;


public class Jeu {
    public static void main(String[] args) {
        Plateau p = new Plateau();
        Joueur j1 = new Joueur("Plop",1);
        Joueur j2 = new Joueur("Joueur",2);
        int hauteurf = 800;
        int largeurf = 1300;
        int hauteur = 800;
        int largeur = 800;
        Fenetre f = new Fenetre("plateau",largeurf,hauteurf);
        Souris souris = f.getSouris();
        int tailleX = hauteur/21;
        int tailleY = hauteur/21;

        // Création des boutons de navigation
        Couleur coltexte = new Couleur(153,38,0);
        Font Calibri = new Font("Calibri", Font.TYPE1_FONT, 25);
        String pionsj1 = String.valueOf(j1.getNbPions());
        String pionsj2 = String.valueOf(j2.getNbPions());
        boolean arreter = false;

        // Affichage des infos;
        f.ajouter(new Texte(coltexte, j1.getNom(), Calibri, new Point(largeurf-150, hauteurf-200)));
        f.ajouter(new Texte(coltexte, pionsj1, Calibri, new Point(largeurf-150, hauteurf-250)));
        f.ajouter(new Texte(coltexte, j2.getNom(), Calibri, new Point(largeurf-150, hauteurf-500)));
        f.ajouter(new Texte(coltexte, pionsj2, Calibri, new Point(largeurf-150, hauteurf-550)));
        
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
                    // Mise à jour du compteur
                    pionsj1 = String.valueOf(j1.getNbPions());
                    pionsj2 = String.valueOf(j2.getNbPions());
                    f.ajouter(new Texte(coltexte, j1.getNom(), Calibri, new Point(largeurf-150, hauteurf-200)));
                    f.ajouter(new Texte(coltexte, pionsj1, Calibri, new Point(largeurf-150, hauteurf-250)));
                    f.ajouter(new Texte(coltexte, j2.getNom(), Calibri, new Point(largeurf-150, hauteurf-500)));
                    f.ajouter(new Texte(coltexte, pionsj2, Calibri, new Point(largeurf-150, hauteurf-550)));
                    f.rafraichir();   
                }
            }
        }
    }
}