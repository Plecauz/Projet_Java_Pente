public class Pion {
    private int x;
    private int y;
    private Joueur joueur;

    //Constructeur par défaut
    public Pion(){
        this.x = 0;
        this.y = 0;
        this.joueur = new Joueur();
    }

    //Constructeur par paramètres
    public Pion(int x,int y, Joueur joueur){
        this.x = x;
        this.y = y;
        this.joueur = joueur;
    }

    //Modifie la position
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Joueur getJoueur(){
        return this.joueur;
    }

    //Retourne la position x
    public int getX(){
        return this.x;
    }

    //Retourne la position y
    public int getY(){
        return this.y;
    }
}
