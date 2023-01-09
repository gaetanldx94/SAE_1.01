import java.util.ArrayList;

public class Jury 
{
    private String juryId;
    private String salle;
    private String date;
    private ArrayList<String> horaires;
    private ArrayList<String> prof;

    public Jury(String jury)
    {
        populateJury(jury);
    }

    public void populateJury(String jury)
    {
        //Décomposeur optimiser
        int[] tab = new int[jury.length()];
        String st = "";

        for(int i = 0; i < jury.length(); i++)
        {
            if((int)((char)jury.charAt(i)) != 9)
                tab[i] = (int)((char)jury.charAt(i));
            else
                tab[i] = (int)',';
        }

        for(int i = 0; i < tab.length; i++)
        {
            st = st + (char)tab[i];
        }
        String[] stTab = st.split(",");

        //Affectation
        this.horaires = new ArrayList<String>();
        this.prof = new ArrayList<String>();

        this.juryId = stTab[0];
        this.salle  = stTab[1];
        this.date   = stTab[2];
        this.horaires.add(stTab[3]);
        this.horaires.add(stTab[4]);

        for(int i = 5; i < stTab.length; i++)
        {
            this.prof.add(stTab[i]);
        }
    }

    public String getJuryId() 
    {
        return juryId;
    }

    public String getSalle() 
    {
        return salle;
    }

    public String getDate() 
    {
        return date;
    }

    public ArrayList<String> getHoraires() 
    {
        return horaires;
    }
    
    public ArrayList<String> getProf() 
    {
        return prof;
    } 
}
