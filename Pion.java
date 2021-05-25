public class Pion {
    private int x;
    private int y;
    public Pion(){
        this.x = 0;
        this.y = 0;
    }

    public Pion(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
