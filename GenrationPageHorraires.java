public class GenrationPageHorraires 
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
        pw.println ( "\t\t<link rel=\"stylesheet\" href=\"styles/listeEquipe.css\" />" );
        pw.println ("\t\t<title> Liste Etudiant </title>\n" +
                    "\t</head>"                              );

        //body
        pw.println ( "\t<body>" );

        //titre
        pw.println ( "\t\t<header> Liste des équipes </header>" );

        pw.println ("\t\t<table>" +
                    "\t\t\t<tr>"   );

        for(int i = 0; i < Main.equipeEtudiant.length; i++)
        {
            int nbEquipe;

            pw.println("<td class= \"tab_jaune\" style=\"border-right:none;\">" + i +"</td>");
            pw.println("<td>"); 

            for(int j = 0; j<Main.nbrEtudiantGp+1; j++)
            {
                if(Main.equipeEtudiant[i][Main.nbrEtudiantGp+1] != null)
                    pw.println(Main.equipeEtudiant[i][j]);
            }

            pw.println("</td>");

            for (int j = 0; j < Main.listSalle.size(); j++)
            {
                nbEquipe = 0;
                while(nbEquipe < Integer.parseInt(Main.listSalle.get(j).getNbEquipe()))
                    pw.println("<td class=\"tab_joneq\" style=\"border-left:none;\">" + Main.listSalle.get(j).getNumero() + "</td>");
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
