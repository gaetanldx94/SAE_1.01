import java.util.*;
import java.io.*;

public class Main
{
    // Variable
    static Scanner              sc;
    static int                  nbrEtudiantGp;

    static ArrayList<Etudiant>  listEtudiant;
    static ArrayList<Etudiant>  listFinale;
    static ArrayList<Salle>     listSalle;

    static String[][] equipeEtudiant;

    public static void main(String[] args) throws IOException
    {
        //Inistialisation
        listEtudiant = new ArrayList<Etudiant>();
        listSalle = new ArrayList<Salle>();
        listFinale = new ArrayList<Etudiant>();

        //Lecture du fichier ressources.data
        sc = new Scanner(new FileInputStream("../lib/ressources.data"));
        nbrEtudiantGp = sc.nextInt();
        sc.nextLine();

        while(sc.hasNextLine())
            listSalle.add(new Salle(sc.nextLine()));

        //Lecture du fichier promotion.data
        sc = new Scanner(new FileInputStream("../lib/promotion.data"));
        while(sc.hasNextLine())
            listEtudiant.add(new Etudiant(sc.nextLine()));
        
        //Affectation
        int numEquipe = 0;
        for(int i = 0; i < nbCategorie(listEtudiant).size(); i++)
        {
            ArrayList<Etudiant> categoriTrier = triAlphabetique(isolerCategorie(nbCategorie(listEtudiant).get(i), listEtudiant));
            equipeEtudiant = creerEquipe(nbrEtudiantGp, categoriTrier);

            //Affichage
            for(int k = 0; k < equipeEtudiant.length; k++)
            {
                numEquipe++;
                System.out.println();
                System.out.println("Equipe " + numEquipe);
                for(int j = 0; j < nbrEtudiantGp+1; j++)
                {
                    if(equipeEtudiant[k][j] != null)
                        System.out.print(equipeEtudiant[k][j]);
                }
            }
        }
    }

    //Récupération de l'ensemble des catégories utiliser
    public static ArrayList<String> nbCategorie(ArrayList<Etudiant> listEtudiant)
    {
        boolean categorieTrouver = false;
        ArrayList<String> listCategorie = new ArrayList<String>();
        
        listCategorie.add(listEtudiant.get(1).getCategorie());

        for(int i = 2; i < listEtudiant.size(); i++)
        {
            for(int j = 0; j < listCategorie.size(); j++)
                if(listCategorie.get(j).compareTo(Main.listEtudiant.get(i).getCategorie()) == 0)
                    categorieTrouver = true;
            if(!categorieTrouver)
                listCategorie.add(listEtudiant.get(i).getCategorie());
            categorieTrouver = false;
        }
        Collections.sort(listCategorie);
        return listCategorie;
    }

    //Isolation d'une des catégories existante
    public static ArrayList<Etudiant> isolerCategorie(String categorie, ArrayList<Etudiant> listEtudiant)
    {
        ArrayList<Etudiant> listIsolerEtudiant = new ArrayList<Etudiant>();
        for(int i = 0; i < listEtudiant.size(); i++)
            if(listEtudiant.get(i).getCategorie().equals(categorie))
                listIsolerEtudiant.add(listEtudiant.get(i));
        return listIsolerEtudiant;
    }

    //triage alphabétique de la liste grâce aux noms des étudiants
    public static ArrayList<Etudiant> triAlphabetique(ArrayList<Etudiant> listEtudiant)
    {
        Etudiant tmp;
        for(int i = 0; i < listEtudiant.size(); i++)
            for(int j = 0; j < listEtudiant.size()-1; j++)
                if(listEtudiant.get(j).getNom().compareTo(listEtudiant.get(j).getNom()) > 0)
                {
                    tmp = listEtudiant.get(j);
                    listEtudiant.set(j, listEtudiant.get(j+1));
                    listEtudiant.set(j+1, tmp);
                }
        return listEtudiant;
    }

    //on créer les équipes d'étudiants
    public static String[][] creerEquipe(int nbrEtudiantGp, ArrayList<Etudiant> listEtudiant)
    {
        int cptEtudiant = 0;
        int cptEquipe = 0;
        String[][] equipeEtud = new String[listEtudiant.size()/nbrEtudiantGp][nbrEtudiantGp+1];

        for(int i = 0; i < listEtudiant.size()/nbrEtudiantGp; i++)
        {
            for(int j = 0; j < nbrEtudiantGp; j++)
            {
                equipeEtud[i][j] =  String.format("%-13s", listEtudiant.get(cptEtudiant).getNom())  + " " + 
                                    String.format("%-9s", listEtudiant.get(cptEtudiant).getPrenom()) + " " + 
                                    listEtudiant.get(cptEtudiant).getGroupe() + "\n";
                cptEtudiant++;
            }
            cptEquipe++;
        }

        if(cptEtudiant < listEtudiant.size())
            for(int i = listEtudiant.size()-1; i >= cptEtudiant; i--)
            {
                equipeEtud[cptEquipe-1][nbrEtudiantGp] =  String.format("%-13s",    listEtudiant.get(i).getNom())  + " " + 
                                                                                    String.format("%-9s", listEtudiant.get(i).getPrenom()) + " " + 
                                                                                    listEtudiant.get(i).getGroupe() + "\n";
                cptEquipe--;
            }
        return equipeEtud;
    }
}