public class Outils {
    public String[] decomposeur(String chaine, int ascii)
    {
        String[] stTab;
        if(chaine != null)
            stTab= chaine.split(String.valueOf((char)ascii));
        else
            stTab = new String[2];
        return stTab;
    }
}