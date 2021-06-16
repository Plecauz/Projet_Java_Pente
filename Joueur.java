public class Joueur {
    //ATTRIBUTS
    private Pion[] listeDePions ;
    private String nom = new String();
    private int numero;
    private boolean tourdejouer;
    private int nbCapture;
    
    //METHODES

    //Constructeur par défaut
    public Joueur(){
        this.nom = "nom inconnu";
        this.numero = 0;
        this.tourdejouer = false;
        this.nbCapture = 0;
        this.listeDePions= new Pion[35] ;
        
    }
    //Constructeur par paramètre
    public Joueur(String nom, int numero){
        this.nom = nom;
        this.numero = numero;
        this.listeDePions= new Pion[35] ;
        this.tourdejouer = false;
        this.nbCapture = 0;
    }
    //Methode qui determine le joueur qui joue en premier
    public static int JoueurStart(){
        double rand = Math.random();
        int num = 0;
        if(rand >= 0.5){
            num = 2;
        }
        else{
            num = 1;
        }
        return num;
    }
    
    //Methode qui initialise la liste de pions avec leur constructeur par défaut
    public void listedePions(){
        for (int i = 0 ; i<listeDePions.length-1; i++){
            this.listeDePions[i]= new Pion();
        }
    }

    // Méthode qui retourne le numéro du joueur
    public int getNumero(){
        return this.numero;
    }

    public int getCapture(){
        return this.nbCapture;
    }

    public void setCapture(int nb){
        this.nbCapture = nb;
    }

    // Méthode qui retourne le nom du joueur
    public String getNom() {
        return nom;
    }

    // Méthode qui retourne le nombre de pions du joueur
    public int getNbPions() {
        return listeDePions.length;
    }

    // Méthode qui retourne si le joueur joue à ce tour ou au prochain
    public boolean getTour(){
        return this.tourdejouer;
    }

    // Méthode qui applique la valeur du paramètre au booléen
    public void setTour(boolean tour){
        this.tourdejouer = tour;
    }

    //Méthode qui retourne le nom du joueur, son numero de joueur, son nombre de pions et si c'est à lui de jouer
    public String toString(){
        return (this.nom+"est le joueur numero "+ this.numero+" et possede "+ this.listeDePions.length + " " + "pions" + "et son tour de jouer est sur " +this.tourdejouer);
        
    }


}