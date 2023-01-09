public class Salle {
    private String numero;
    private String nbEquipe;

    public Salle(String salle)
    {
        populateSalle(salle);
    }

    public void populateSalle(String salle)
    {
        int[] tab = new int[salle.length()];
        String st = "";

        for(int i = 0; i < salle.length(); i++)
        {
            if((int)((char)salle.charAt(i)) != 9)
                tab[i] = (int)((char)salle.charAt(i));
            else
                tab[i] = (int)':';
        }

        for(int i = 0; i < tab.length; i++)
        {
            st = st + (char)tab[i];
        }
        String[] stTab = st.split(":");

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