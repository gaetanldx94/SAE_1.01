public class Outils {
    public String[] decomposeur(String chaine, int ascii)
    {
        String[] stTab = chaine.split(String.valueOf((char)ascii));
        return stTab;
    }
}