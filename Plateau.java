import MG2D.*;
import MG2D.geometrie.*;


public class Plateau{

    private Pion[][] intersections;

    public Plateau(){
        intersections = new Pion[20][20];
    }

    public Fenetre afficherPlateau(Fenetre f,int largeur, int hauteur){
        int tailleX = largeur/21;
        int tailleY = hauteur/21;
        f.ajouter(new Texture("img/plateau.png",new Point(tailleX,tailleY),largeur-2*tailleX,hauteur-2*tailleY));
        return f;
    }

    public Pion[][] getIntersections(){
        return this.intersections;
    }

    public boolean ajoutPion(Pion pion){
        if (intersections[pion.getX()][pion.getY()] == null){
            intersections[pion.getX()][pion.getY()] = pion;
            checkVoisins(pion);
            return true;
        }
        return false;
    }

    public void checkVoisins(Pion pion){
        int posX = pion.getX();
        int posY = pion.getY();
        int[][] relatifs = {{-1,1},{0,1},{1,1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1}};
        for(int[] relatif:relatifs){
            if((posX+relatif[0] < 20 && posY+relatif[1] < 20) && (posX+relatif[0] > 0 && posY+relatif[1] > 0))
            if(intersections[posX+relatif[0]][posY+relatif[1]] != null){
                if(intersections[posX+relatif[0]][posY+relatif[1]].getJoueur().getNumero() != pion.getJoueur().getNumero()){
                    //System.out.println("Voisin différent");
                }
                else if(intersections[posX+relatif[0]][posY+relatif[1]].getJoueur().getNumero() == pion.getJoueur().getNumero()) {
                    checkCoupGagnant(pion,relatif);
                };
            }
        }
    }

    public void checkCoupGagnant(Pion pion, int[] relatif){
        int num = pion.getJoueur().getNumero();
        int posX = pion.getX();
        int posY = pion.getY();
        int relX = relatif[0];
        int relY = relatif[1];
        int numPion = 2;
        boolean fini = false;
        int i = 2;
        while(!fini){
            if((posX+relX*i < 20 && posY+relY*i < 20) && (posX+relX*i > 0 && posY+relY*i > 0)){
                if(intersections[posX+relX*i][posY+relY*i] != null){
                    if(intersections[posX+relX*i][posY+relY*i].getJoueur().getNumero() == num){
                        numPion += 1;
                        i+=1;
                    }
                    else{
                        fini = true;
                    }
                }
                else{
                    fini = true;
                }
            }
            else{
                fini = true;
            }
        }
        System.out.println(numPion);
    }

    public Fenetre afficherPion(Fenetre f,int largeur, int hauteur, Pion pion){
        int tailleX = largeur/21;
        int tailleY = hauteur/21;
        int taillePionX = (int)Math.round(tailleX*0.7);
        int taillePionY = (int)Math.round(tailleY*0.7);
        if (pion.getJoueur().getNumero() == 1){
            f.ajouter(new Texture("img/pion_blanc.png",new Point(tailleX*(pion.getX()+1)-taillePionX/2,tailleY*(pion.getY()+1)-taillePionY/2),taillePionX,taillePionY));
        }
        else{
            f.ajouter(new Texture("img/pion_noir.png",new Point(tailleX*(pion.getX()+1)-taillePionX/2,tailleY*(pion.getY()+1)-taillePionY/2),taillePionX,taillePionY));
        }
        return f;
    }

    public void supprimerPion(Pion pion){
        intersections[pion.getX()][pion.getY()] = null;
    }
}