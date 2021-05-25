import MG2D.*;
import MG2D.geometrie.*;


public class Plateau{

    private int[][] intersections;

    public Plateau(){
        intersections = new int[18][18];
    }

    public Fenetre afficherPlateau(Fenetre f,int largeur, int hauteur){
        boolean pair = true;
        int tailleX = largeur/21;
        int tailleY = hauteur/21;
        for(int y = 0;y<19;y++){
            for(int x=0;x<19;x++){
                if(pair){
                    f.ajouter (new Rectangle(Couleur.GRIS_FONCE, new Point(tailleX+x*tailleX,tailleY+y*tailleY), new Point(2*tailleX+x*tailleX, 2*tailleY+y*tailleY), true));
                    pair = false;
                }
                else{
                    f.ajouter (new Rectangle(Couleur.GRIS_CLAIR, new Point(tailleX+x*tailleX,tailleY+y*tailleY), new Point(2*tailleX+x*tailleX, 2*tailleY+y*tailleY), true));
                    pair = true;
                }
            }
        }
        return f;
    }

    public Fenetre afficherPion(Fenetre f,int largeur, int hauteur, Pion pion){
        int tailleX = largeur/21;
        int tailleY = hauteur/21;
        f.ajouter(new Cercle(Couleur.NOIR, new Point(tailleX*(pion.getX()+1),tailleY*(pion.getY()+1)), 12,true));
        return f;
    }
}