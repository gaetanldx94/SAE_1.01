import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    static int nbEtudiantGroupe;
    static int numEquipe = 1;
    static GenerationPagesListEtud gen;
    public static void main(String[] args) throws IOException
    {

        Scanner sc;
        Etudiant tmp = null;
        ArrayList<Etudiant> listEtud = new ArrayList<Etudiant>();
        ArrayList<Salle> listSalle = new ArrayList<Salle>();
        int cptCategorie;
        String repDest = "provisoire";

        sc = new Scanner(new FileInputStream("lib/promotion.data"));
        while(sc.hasNextLine())
            listEtud.add(new Etudiant(sc.nextLine()));

        sc = new Scanner(new FileInputStream("lib/ressources.data"));
        nbEtudiantGroupe = sc.nextInt();
        sc.nextLine();

        while(sc.hasNextLine())
            listSalle.add(new Salle(sc.nextLine()));

        for(int i = 0; i < listEtud.size(); i++)
            for(int j = 0; j < listEtud.size()-1; j++)
                if(listEtud.get(j).getCategorie().compareTo(listEtud.get(j).getCategorie()) > 0)
                {
                    tmp = listEtud.get(j);
                    listEtud.set(j, listEtud.get(j+1));
                    listEtud.set(j+1, tmp);
                }
            

        System.out.println(toString(triNom(catego('A', listEtud))));
    }

    public static ArrayList<Etudiant> catego(char categorie, ArrayList<Etudiant> listEtud) 
    {
        ArrayList<Etudiant> listCatego = new ArrayList<Etudiant>();
        for(int i = 0; i < listEtud.size(); i++)
            if(listEtud.get(i).getCategorie().equals(Character.toString(categorie)))
                listCatego.add(listEtud.get(i));
        return listCatego;
    }

    public static ArrayList<Etudiant> triNom(ArrayList<Etudiant> listEtud)
    {
        Object tmp;
        for(int i = 0; i < listEtud.size(); i++)
            for(int j = 0; j < listEtud.size()-1; j++)
                if(listEtud.get(j).getNom().compareTo(listEtud.get(j).getNom()) > 0)
                {
                    tmp = listEtud.get(j);
                    listEtud.set(j, listEtud.get(j+1));
                    listEtud.set(j+1, (Etudiant)tmp);
                }
        return listEtud;
    }

    public static int cptCatego(ArrayList<Etudiant> listEtud)
    {
        int indice = 0;
        ArrayList<String> categoCpt = new ArrayList<String>();
        categoCpt.add(listEtud.get(1).getCategorie());

        for(int i = 1; i < listEtud.size(); i++)
        {
            for(int j = 0; j < categoCpt.size(); j++)
            {
                if(categoCpt.get(j).compareTo(listEtud.get(i).getCategorie()) == 0)
                    indice = 1;
            }
            if(indice == 0)
                categoCpt.add(listEtud.get(i).getCategorie());
            indice = 0;
        }

        return categoCpt.size();
    }

    public static String toString(ArrayList<Etudiant> listEtud)
    {
        String str = "";
        
        str += "Equipe " + numEquipe + "\n";
        for(int i = 0; i < listEtud.size(); i++) 
        {
            str += String.format("%-13s", listEtud.get(i).getNom())  + " " + String.format("%-9s", listEtud.get(i).getPrenom()) + " " + listEtud.get(i).getGroupe() + "\n";
            if((i+1)%nbEtudiantGroupe == 0)
            {
                numEquipe++;
                str += "\n";
                str += "Equipe " + numEquipe + "\n";
            }
        }
        return str;
    }
}