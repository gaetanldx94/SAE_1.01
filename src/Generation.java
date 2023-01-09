import java.io.PrintWriter;
import java.io.File;

import java.util.ArrayList;

public class Generation
{
    public Generation(String repertoire, ArrayList<Etudiant> listEtud, String[][] equipeEtudiant, int nbrEtudiantGp, ArrayList<Salle> listSalle, ArrayList<Jury> listJuries)
    {
        genererListeEtudiant(repertoire, listEtud);
        genererListeEquipe(repertoire, equipeEtudiant, nbrEtudiantGp, listSalle);
        genererListeHorraires(repertoire, listJuries);
    }

    public static void genererListeEtudiant(String repertoire, ArrayList<Etudiant> listEtud)
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
        pw.println ( "\t\t<link rel=\"stylesheet\" href=\"styles/Style.css\" />" );
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


    public static void genererListeEquipe(String repertoire, String[][] equipeEtudiant, int nbrEtudiantGp, ArrayList<Salle> listSalle)
    {
        PrintWriter pw = null;
        try{pw = new PrintWriter(new File("../" + repertoire + "/listeEquipe.html"), "utf-8"); }
        catch (Exception e){e.printStackTrace();}

        //HTML
        pw.println("<!DOCTYPE html> \n" + 
                       "<html lang=\"fr\">"  );

        //head
        pw.println("\t<head> \n" + 
                    "\t\t<meta charset=\"UTF-8\">");
        pw.println ( "\t\t<link rel=\"stylesheet\" href=\"styles/listeEtudiant.css\" />" );
        pw.println ("\t\t<title> Liste Etudiant </title>\n" +
                    "\t</head>"                              );

        //body
        pw.println ( "\t<body>" );

        //titre
        pw.println ( "\t\t<header> Liste des équipes </header>" );

        pw.println ("\t\t<table>" +
                    "\t\t\t<tr>"   );

        for(int i = 0; i < equipeEtudiant.length; i++)
        {
            int nbEquipe;

            pw.println("<td class= \"tab_jaune\" style=\"border-right:none;\">" + i +"</td>");
            pw.println("<td>"); 

            for(int j = 0; j<nbrEtudiantGp+1; j++)
            {
                if(equipeEtudiant[i][nbrEtudiantGp+1] != null)
                    pw.println(equipeEtudiant[i][j]);
            }

            pw.println("</td>");

            for (int j = 0; j < listSalle.size(); j++)
            {
                nbEquipe = 0;
                while(nbEquipe < Integer.parseInt(listSalle.get(j).getNbEquipe()))
                    pw.println("<td class=\"tab_joneq\" style=\"border-left:none;\">" + listSalle.get(j).getNumero() + "</td>");
            }

            pw.println("<td class=\"null\"></td>");
        }

        pw.println("/tr\n" +
                   "/table");

        //espacement avec le pied de page
        pw.println ( "\t\t<br style = \"line-height:100px;\">" );


        pw.println ( "\t\t<footer>" );
        pw.println ( "\t\t</footer>" );

		pw.println ( "\t</body>\n" +
                     "</html>"      );

		pw.close();
    }

    public static void genererListeHorraires(String repertoire, ArrayList<Jury> listjJuries)
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
        pw.println ( "\t\t<link rel=\"stylesheet\" href=\"styles/listeEquipe.css\" />" );
        pw.println ("\t\t<title> Liste Etudiant </title>\n" +
                    "\t</head>"                              );

        //body
        pw.println ( "\t<body>" );

        //titre
        pw.println ( "\t\t<header> Liste des équipes </header>" );

        //espacement avec le pied de page
        pw.println ( "\t\t<br style = \"line-height:100px;\">" );


        pw.println ( "\t\t<footer>" );
        pw.println ( "\t\t</footer>" );

		pw.println ( "\t</body>\n" +
                     "</html>"      );

		pw.close();
    }
}