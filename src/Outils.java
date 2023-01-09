public class Outils {
    public String[] decomposeur(String chaine, int ascii, String regex)
    {
        int[] tab = new int[chaine.length()];
        String st = "";

        for(int i = 0; i < chaine.length(); i++)
        {
            if((int)((char)chaine.charAt(i)) != ascii)
                tab[i] = (int)((char)chaine.charAt(i));
            else
                tab[i] = (int)regex.charAt(0);
        }

        for(int i = 0; i < tab.length; i++)
        {
            st = st + (char)tab[i];
        }
        String[] stTab = st.split(regex);

        return stTab;
    }
}
