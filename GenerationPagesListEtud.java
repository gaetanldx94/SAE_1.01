import java.io.PrintWriter;
import java.io.File;

import java.util.ArrayList;

public class GenerationPagesListEtud
{
    public static void generer(String repertoire, ArrayList<Etudiant> listEtud)
    {
        PrintWriter pw = null;

        for(int i=0; i<listEtud.size(); i++)
        {
            try{pw = new PrintWriter(new File("../" + repertoire + "/listeEtudiant.html"), "utf-8"); }
            catch (Exception e){e.printStackTrace();}

            //HTML
            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"fr\">");

            //head
            pw.println("\t<head>");
            pw.println("\t\t<meta charset=\"UTF-8\">");
            //pw.println ( "\t\t<link rel=\"stylesheet\" href=\"styles/Style.css\" />" );
            pw.println ( "\t\t<title> Liste Etudiant </title>" );
            pw.println ( "\t</head>" );

            //body
            pw.println ( "\t<body>" );

            //titre
            pw.println ( "\t\t<h1> Liste des Etudiants </h1>" );

            for(int j=0; j<listEtud.size(); j++)
                pw.println (listEtud.get(j).getNom() + "  " + listEtud.get(i).getPrenom() + "   " + listEtud.get(i).getGroupe());

            //espacement avec le pied de page
            pw.println ( "\t\t<br style = \"line-height:100px;\">" );


            pw.println ( "\t\t<footer>" );
            pw.println ( "<h2> :) </h2>" );
            pw.println ( "\t\t</footer>" );

			pw.println ( "\t</body>" );

			pw.println ( "</html>" );

			pw.close();
        }
    }
}