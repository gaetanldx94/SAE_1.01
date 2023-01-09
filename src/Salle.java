public class Salle {
    private String numero;
    private String nbEquipe;

    public Salle(String salle)
    {
        populateSalle(salle);
    }

    public void populateSalle(String salle)
    {
        String[] stTab = new Outils().decomposeur(salle, 9, ":");

        this.numero = stTab[0];
        this.nbEquipe = stTab[1];
    }

    public String getNumero() 
    {
        return numero;
    }
    
    public String getNbEquipe() 
    {
        return nbEquipe;
    }
}