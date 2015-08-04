package Ordre_de_mission;

import Gestion.*;
import Header_footer.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ordre_de_MissionPdf {

    BD db;
    ResultSet Res;

    String format = "dd/MM/yyyy";

    java.util.Date date = new java.util.Date();

    public Ordre_de_MissionPdf(String num, int ordre) throws DocumentException, SQLException, FileNotFoundException, IOException, Exception {
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
         db = new BD(Parametre.Host,Parametre.username,Parametre.password,Parametre.IPHOST,Parametre.Port);
        Res = db.executionQuery("select *,Ordre_de_mission.id_odm  from Enseignant , Ordre_de_mission,effectuer,Date,situation_administrative,cadre,avoir  "
                + "where Enseignant.N_somme=effectuer.N_somme "
                + " and Ordre_de_mission.id_odm=effectuer.id_odm "
                + "and effectuer.id_date=Date.id_date"
                + " and Enseignant.N_somme='" + num + "'"
                + "and Ordre_de_mission.id_odm='" + ordre + "'"
                + "and  Enseignant.N_somme=avoir.N_somme "
                + "and avoir.id_sa=situation_administrative.id_sa "
                + "and situation_administrative.id_cadre=cadre.id_cadre ");
               
                

        Font boldText = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLDITALIC);
        Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 18, Font.BOLD | Font.UNDERLINE);
        Font x = new Font(Font.getFamily("TIMES_ROMAN"), 9, Font.ITALIC);

        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8.50f);
        Font f1 = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, Font.BOLD);

        Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, Font.BOLD | Font.UNDERLINE);
        Font f3 = new Font(Font.FontFamily.TIMES_ROMAN, 10.0f, Font.BOLD | Font.UNDERLINE);

        BaseFont bf = BaseFont.createFont("Ressource/arial.ttf", BaseFont.IDENTITY_H, true);
        Font fontArab = new Font(bf, 10);
        Font fontArabe = new Font(bf, 8);

        Document document = new Document();

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("OrdreDeMission.pdf"));

        Hf_Attes event = new Hf_Attes();
        writer.setPageEvent(event);
        document.open();

        Paragraph nn = new Paragraph("\n\n");
        Paragraph an = new Paragraph("\n");

        document.add(nn);

        Paragraph a = new Paragraph("ORDRE DE MISSION", bold);
        a.setAlignment(Element.ALIGN_CENTER);
        document.add(a);

        while (Res.next()) {
            if (Res.last()) {
                
                String s = "" + upperFirst(Res.getString("prenom")) + " " + upper(Res.getString("nom"));
                a = new Paragraph("\n\n\n\nLe Doyen de la faculté des sciences d'Oujda autorise :"
                        + "\n\n         Mr: ");
                a.add(new Phrase(s, boldText));
                document.add(a);
                a = new Paragraph("\n Cadre: ");
                a.add(new Phrase(Res.getString("type"), boldText));
                a.add(new Phrase(" , Grade : <<"));
                a.add(new Phrase(upper(Res.getString("echelle")), boldText));
                a.add(new Phrase(">> S.O.M: "));

                s = "" + Res.getString("N_somme").substring(0, 3) + "." + (Res.getString("N_somme")).substring(3);
                a.add(new Phrase(s, boldText));
                document.add(a);
                a = new Paragraph("\n         Département de : ");
                a.add(new Phrase(upperFirst(Res.getString("departement")), boldText));
                document.add(a);
                a = new Paragraph("\n A se rendre à : ");
                a.add(new Phrase(upperFirst(Res.getString("destination")), boldText));
                document.add(a);

                a = new Paragraph("\nDu :  ");
                a.add(new Phrase(formater.format(Res.getDate("date_depart")), boldText));
                a.add(new Phrase(" au "));
                a.add(new Phrase(formater.format(Res.getDate("date_retour")), boldText));
                a.setAlignment(Element.ALIGN_CENTER);
                document.add(a);
                a = new Paragraph("\nMotifs: ");
                a.add(new Phrase(Res.getString("motifs"), boldText));
                document.add(a);

                a = new Paragraph("\n\n\nOujda,le:........................");
                a.setAlignment(Element.ALIGN_CENTER);
                document.add(a);
                a = new Paragraph("\n\n\n\nLE DOYEN:", f3);
                a.setAlignment(Element.ALIGN_CENTER);
                document.add(a);
                a = new Paragraph("NB: Les charges de déplacement sont à la charge de l'interessé.", x);
            }
        }

        document.close();

        Desktop d = java.awt.Desktop.getDesktop();
        d.open(new java.io.File("OrdreDeMission.pdf"));

    }

    String upper(String x) {
        return x.toUpperCase();
    }

    String upperFirst(String x) {
        return x.substring(0, 1).toUpperCase() + x.substring(1);
    }

}
//select id_sa  from Enseignant , Ordre_de_mission , effectuer,Date,avoir where Enseignant.N_somme=effectuer.N_somme  and Ordre_de_mission.id_odm=effectuer.id_odm and effectuer.id_date=Date.id_date and Enseignant.N_somme='452145' and Ordre_de_mission.id_odm='1' and Enseignant.N_somme=avoir.N_somme;