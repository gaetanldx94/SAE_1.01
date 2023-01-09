import java.io.PrintWriter;
import java.io.File;

import java.util.ArrayList;

public class Generation
{
    public static void generer(String repertoire, ArrayList<Etudiant> listEtud)
    {
        PrintWriter pw = null;

        try{pw = new PrintWriter(new File("../" + repertoire + "/listeEtudiant.html"), "utf-8"); }
        catch (Exception e){e.printStackTrace();}

        //HTML
        pw.println("<!DOCTYPE html> \n" + 
                       "<html lang=\"fr\">"  );

        //head
        pw.println("\t<head> \n" + 
                       "\t\t<meta charset=\"UTF-8\">");
        pw.println ( "\t\t<link rel=\"stylesheet\" href=\"../style/Style.css\" />" );
        pw.println ("\t\t<title> Liste Etudiant </title>\n" +
                        "\t</head>"                              );

        //body
        pw.println ( "\t<body>" );

        //titre
        pw.println ( "\t\t<h1> Liste des Etudiants </h1>" );

        pw.println("\t\t<table>\n" +
                    "\t\t\t<thead>\n\n" +
                    "\t\t\t\t<tr>\n"    +
                    "\t\t\t\t\t<th>Nom</th>\n" +
                    "\t\t\t\t\t<th>Prénom</th\n>" +
                    "\t\t\t\t\t<th>Groupe</th>\n" +
                    "\t\t\t\t\t<th>N° d'équipe</th>\n" +
                    "\t\t\t\t</tr>\n" +
                    "\t\t\t</thead>\n\n" +
                    "\t\t\t<tbody>\n");

        for(int i = 0; i < listEtud.size(); i++)
        {
            pw.println("\t\t\t\t<tr>\n" +
                       "\t\t\t\t\t<t>" + String.format("%13s",listEtud.get(i).getNom()) + "</tr>\n" +
                       "\t\t\t\t\t<t>" + String.format("%9s", listEtud.get(i).getPrenom()) + "</tr>\n" +
                       "\t\t\t\t\t<t>" + listEtud.get(i).getGroupe() + "</tr>\n" +
                       "\t\t\t\t\t<t>" + listEtud.get(i).getEquipe());
        }

        //espacement avec le pied de page
        pw.println ( "\t\t<br style = \"line-height:100px;\">" );


        pw.println ( "\t\t<footer>" );
        pw.println ( "\t\t</footer>" );

		pw.println ( "\t</body>" );

		pw.println ( "</html>" );

		pw.close();
    }
}