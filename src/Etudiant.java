public class Etudiant {

    private String nom;
    private String prenom;
    private String groupe;
    private String categorie;

    public Etudiant(String etd)
    {
        populateEtudiant(etd);
    }

    public void populateEtudiant(String etd)
    {
        int[] tab = new int[etd.length()];
        String st = "";

        for(int i = 0; i < etd.length(); i++)
        {
            if((int)((char)etd.charAt(i)) != 9)
                tab[i] = (int)((char)etd.charAt(i));
            else
                tab[i] = (int)':';
        }

        for(int i = 0; i < tab.length; i++)
        {
            st = st + (char)tab[i];
        }
        String[] stTab = st.split(":");

        this.nom = stTab[0];
        this.prenom = stTab[1];
        this.groupe = stTab[2];
        this.categorie = stTab[3];
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getCategorie() {
        return categorie;
    }
}