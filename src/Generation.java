import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Generation
{
    public Generation(String repertoire, ArrayList<Etudiant> listEtud, String[][] equipeEtudiant, int nbrEtudiantGp, ArrayList<Salle> listSalle, ArrayList<Jury> listJuries)
    {
        try
        {
            genererListeEtudiant(repertoire, listEtud);
            //genererListeEquipe(repertoire, equipeEtudiant, nbrEtudiantGp, listSalle);
            //genererListeHorraires(repertoire, listJuries);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void genererListeEtudiant(String repertoire, ArrayList<Etudiant> listEtud) throws IOException
    {
        File file = new File("../src/" + repertoire + "listeEtudiant.html");
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
                        "\t</head>"                              );

        //body
        bw.write ( "\t<body>" );

        //titre
        bw.write ( "\t\t<h1> Liste des Etudiants </h1>\n" );

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
        pw.println ( "\t\t<link rel=\"stylesheet\" href=\"styles/Style_ListHoraires.css\" />" );
        pw.println ("\t\t<title> Jeudi 19 Janvier 2023 </title>\n" +
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