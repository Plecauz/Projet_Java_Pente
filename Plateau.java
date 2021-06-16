import MG2D.*;
import MG2D.geometrie.*;


public class Plateau{

    private Pion[][] intersections;

    //Constructeur par défaut
    public Plateau(){
        intersections = new Pion[20][20];
    }

    //Cette méthode affiche le plateau tout en s'adaptant à la fênetre
    public Fenetre afficherPlateau(Fenetre f,int largeur, int hauteur){
        int tailleX = largeur/21;
        int tailleY = hauteur/21;
        f.ajouter(new Texture("img/plateau.png",new Point(tailleX,tailleY),largeur-2*tailleX,hauteur-2*tailleY));
        return f;
    }

    //Getter
    public Pion[][] getIntersections(){
        return this.intersections;
    }

    /*Cette méthode ajoute un pion si il n'est pas déjà présent dans le tableau d'intersections puis regarde ses voisins*/
    public boolean ajoutPion(Pion pion){
        if (intersections[pion.getX()][pion.getY()] == null){
            intersections[pion.getX()][pion.getY()] = pion;
            checkVoisins(pion);
            return true;
        }
        return false;
    }

    /*Cette fonction regarde les voisins de chaque pion posé en utilisant les coordonées relatives, si il rencontre un pion
    de la même couleur que lui in déclenche la méthode checkCoupGagnant et si il est de couleur différente alors il déclenche la méthode Capture*/
    public void checkVoisins(Pion pion){ 
        int posX = pion.getX();
        int posY = pion.getY();
        int[][] relatifs = {{-1,1},{0,1},{1,1},{-1,0},{1,0},{-1,-1},{0,-1},{1,-1}};
        for(int[] relatif:relatifs){
            if((posX+relatif[0] < 20 && posY+relatif[1] < 20) && (posX+relatif[0] > 0 && posY+relatif[1] > 0))
            if(intersections[posX+relatif[0]][posY+relatif[1]] != null){
                if(intersections[posX+relatif[0]][posY+relatif[1]].getJoueur().getNumero() != pion.getJoueur().getNumero()){
                    Capture(pion, relatif);
                }
                else if(intersections[posX+relatif[0]][posY+relatif[1]].getJoueur().getNumero() == pion.getJoueur().getNumero()) {
                    checkCoupGagnant(pion,relatif);
                };
            }
        }
    }

    /*Cette fonction se déclenche si un pion a détecter un voisin de la même couleur que lui, on récupère le pion qui a fait l'appel ainsi
    que la coordonnée relative de son voisin, il suffira de multiplier cette coordonée pour regarder les pions au dela ( sans oublier le sens inverse)
    afin de comptabiliserle nombre de pions de même couleur allignées, une fois que le compteur atteint 5 on enclenche la victoire*/
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
        fini = false;
        i = 1;
        while(!fini){
            if((posX+(-relX*i) < 20 && posY+(-relY*i) <20) && (posX+relX*i > 0 && posY+relY*i > 0)){
                if(intersections[posX+(-relX*i)][posY+(-relY*i)] != null){
                    if(intersections[posX+(-relX*i)][posY+(-relY*i)].getJoueur().getNumero() == num){
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
        if(numPion == 5){
            Victoire.main(num);
        }
    }

    public boolean Capture(Pion pion,int[] relatif ){
        boolean capture = false ;
        int num = pion.getJoueur().getNumero();
        int posX = pion.getX();
        int posY = pion.getY();
        int relX = relatif[0];
        int relY = relatif[1];
            if ((posX+relX*2 < 20 && posY+relY*2 < 20)&& (posX+relX*2 >0 && posY+relY*2 > 0)) {
                if(intersections[posX+relX*2][posY+relY*2] != null){
                    if(intersections[posX+relX*2][posY+relY*2].getJoueur().getNumero() != num){
                       
                       
                        if(intersections[posX+relX*3][posY+relY*3] != null){
                            if(intersections[posX+relX*3][posY+relY*3].getJoueur().getNumero() == num){
                                
                                
                                capture = true ; 
                            }
                        
                        }  
                    } 
                }
            
            }
        if (capture == true) {
            supprimerPion(intersections[posX+relX*2][posY+relY*2]);
            supprimerPion(intersections[posX+relatif[0]][posY+relatif[1]]);
        }    
        System.out.println(capture);
        return  capture ;   
    }
    /*Cette méthode reçoit un pion ainsi que la fenêtre du jeu, on adapte la taille du pion à la taille de la fenêtre et on affiche
    une image de pion blanc ou de pion noir en fonction du joueur*/
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

    /*Cette méthode supprime un pion donné du tableau d'intersections*/
    public void supprimerPion(Pion pion){
        intersections[pion.getX()][pion.getY()] = null;
    }
}