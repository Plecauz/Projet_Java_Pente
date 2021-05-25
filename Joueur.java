import MG2D.* ;
import MG2D.geometrie.*;

public class Joueur {
    //ATTRIBUTS
    private Pion[] listeDePions ;
    String nom = new String();
    int numero;
    boolean tourdejouer;
    
    
    public Joueur(){
        this.nom = nom;
        this.numero = numero;
        this.tourdejouer = false;
        
        this.listeDePions= new Pion[35] ;
        
    }

    
  
    public void listedePions(){
        for (int i = 0 ; i<listeDePions.length-1; i++){
            this.listeDePions[i]= new Pion();
        }
    }

  
    /*
    public void placerPion(int index,Pion pion){
        this.listeDePions[index] = pion;
        
    }
    */

    public String toString(){
        return (this.nom+"est le joueur numero "+ this.numero+" et possede "+ this.listeDePions.length + " " + "pions" "et son tour de jouer est sur " +this.tourdejouer);
        
    }


}
        


        
        

    

