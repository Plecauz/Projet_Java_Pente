public class Pion {
    private int x;
    private int y;

    //Constructeur par défaut
    public Pion(){
        this.x = 0;
        this.y = 0;
    }

    //Constructeur par paramètres
    public Pion(int x,int y){
        this.x = x;
        this.y = y;
    }

    //Modifie la position
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
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
