import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.*;


public class Generation
{
    public Generation(ArrayList<Etudiant> listEtud, int nbrEtudiantGp, ArrayList<Salle> listSalle, ArrayList<Jury> listJuries, ArrayList<String> listeCategorie)
    {
        try
        {
            genererListeEtudiant(listEtud);
            genererListeEquipe(listEtud, nbrEtudiantGp, listSalle, listeCategorie);
            //genererListeHorraires(repertoire, listJuries);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void genererListeEtudiant(ArrayList<Etudiant> listEtud) throws IOException
    {
        File file = new File("ListeEtudiant.html");
        if(!file.exists())
            file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsolutePath());
        BufferedWriter bw = new BufferedWriter(fw);
        
        //HTML
        bw.write("<!DOCTYPE html> \n" + 
                       "<html lang=\"fr\">\n"  );

        //head
        bw.write("\t<head> \n" + 
                       "\t\t<meta charset=\"UTF-8\">\n");
        bw.write ( "\t\t<link rel=\"stylesheet\" href=\"style/Style_ListEtudiant.css\" />\n" );
        bw.write ("\t\t<title> Liste Etudiant </title>\n" +
                        "\t</head>\n"                              );

        //body
        bw.write ( "\t<body>\n" );

        //titre
        bw.write ( "\t\t<header> Liste des Etudiants </header>\n" );

        bw.write("\t\t<table>\n" +
                    "\t\t\t<thead>\n\n" +
                    "\t\t\t\t<tr>\n"    +
                    "\t\t\t\t\t<th>Nom</th>\n" +
                    "\t\t\t\t\t<th>Prénom</th\n>" +
                    "\t\t\t\t\t<th>Groupe</th>\n" +
                    "\t\t\t\t\t<th>N° d'équipe</th>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t</thead>\n\n" +
                    "\t\t\t<tbody>\n");

        for(int i = 1; i < listEtud.size(); i++)
        {
            bw.write("\t\t\t\t<tr>\n" +
                       "\t\t\t\t\t<td>" + String.format("%13s",listEtud.get(i).getNom()) + "</td>\n" +
                       "\t\t\t\t\t<td>" + String.format("%9s", listEtud.get(i).getPrenom()) + "</td>\n" +
                       "\t\t\t\t\t<td>" + listEtud.get(i).getGroupe() + "</td>\n" +
                       "\t\t\t\t\t<td>" + listEtud.get(i).getEquipe() + "</td>\n");
        }

        bw.write("\t\t\t</tbody>\n");

        //espacement avec le pied de page
        bw.write ( "\t\t<br style = \"line-height:100px;\">\n" );


        bw.write ( "\t\t<footer>\n" );
        bw.write ( "\t\t</footer>\n" );

		bw.write ( "\t</body>\n" );

		bw.write ( "</html>\n" );

        bw.close();
        
        //On essaye d'ouvrir le fichier dans le navigateur
        try
        {
            file = new File("ListeEtudiant.html").getAbsoluteFile();
            Desktop.getDesktop().open(file);
        }
        catch(Exception e)
        {
            //Ignore
        }
    }


    public static void genererListeEquipe(ArrayList<Etudiant> listeEtudiant, int nbrEtudiantGp, ArrayList<Salle> listSalle, ArrayList<String> listCategorie) throws IOException
    {
        File file = new File("ListeEquipe.html");
        if(!file.exists())
            file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsolutePath());
        BufferedWriter bw = new BufferedWriter(fw);

        //HTML
        bw.write("<!DOCTYPE html> \n" + 
                       "<html lang=\"fr\">\n"  );

        //head
        bw.write("\t<head> \n" + 
                    "\t\t<meta charset=\"UTF-8\">\n");
        bw.write( "\t\t<link rel=\"stylesheet\" href=\"style/Style_ListEquipe.css\" />\n" );
        bw.write("\t\t<title> Liste Etudiant </title>\n" +
                    "\t</head>\n"                              );

        //body
        bw.write( "\t<body>\n" );

        //titre
        bw.write( "\t\t<header> Liste des équipes </header>\n" );

        bw.write("\t\t<table>\n" +
                    "\t\t\t<tr>\n"   );
        
        int numEquipe = 1;
        //Boucle nombre de groupe
        for(int i = 0; i < listeEtudiant.size()/nbrEtudiantGp; i++)
        {
            bw.write("<td style=\"border-right:none;\">" + numEquipe + "</td>");
            //Boucle étudiant par groupe
            for(int j = 0; j < nbrEtudiantGp; j++)
            {
                //Boucle parcourir étudiant
                for(int k = 0; k < listeEtudiant.size(); k++)
                {
                    //boucle catégorie
                    for(int l = 0; l < listCategorie.size(); l++)
                    {
                        if(listeEtudiant.get(i).getCategorie().equals(listCategorie.get(l)))
                        {
                            bw.write("<td>" + listeEtudiant.get(i).getNom() + " " + listeEtudiant.get(i).getPrenom() + "</td>");
                        }
                    }
                }
            }
        }

        /*<td style="border-right:none;>  numéro groupe </td>
        <td> équipe </td>
        <td class="tab_joneq" style="border-left:none;"> la salle </td>*/

        bw.write("</tr>\n" +
                   "</table>\n");

		bw.write( "\t</body>\n" +
                     "</html>\n"      );

		bw.close();
    }
}