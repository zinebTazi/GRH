package Attestation;


import Gestion.*;
import Header_footer.*;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.BorderLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPage;
import com.itextpdf.text.pdf.PdfPageEventHelper;

import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AttestationPdf {

    static int i = 1;

    BD db;
    ResultSet Res, Res1;

    String format = "yy";

    java.util.Date date = new java.util.Date();
    String id_cadre;
    private String id_grade;

    public AttestationPdf(String numero) throws DocumentException, FileNotFoundException, IOException, SQLException {
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);

        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        Res = db.executionQuery("select * from Enseignant , avoir , situation_administrative,cadre "
                + "where Enseignant.N_somme=avoir.N_somme "
                + "and avoir.id_sa=situation_administrative.id_sa "
                + "and Enseignant.N_somme='" + numero + "' "
                + "and situation_administrative.id_cadre=cadre.id_cadre");

        Font boldText = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLDITALIC);
        Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 18, Font.BOLD | Font.UNDERLINE);
        Font italic = new Font(Font.getFamily("TIMES_ROMAN"), 9, Font.ITALIC);

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Attestation.pdf"));

        Hf_Attes event = new Hf_Attes();
        writer.setPageEvent(event);
        document.open();

        Paragraph nn = new Paragraph("\n\n");
        Paragraph an = new Paragraph("\n");

        document.add(nn);

        Paragraph par = new Paragraph("ATTESTATION DE TRAVAIL", bold);
        par.setAlignment(Element.ALIGN_CENTER);
        document.add(par);

        while (Res.next()) {

            if (Res.last()) {
                id_cadre = Res.getString("id_cadre");
                id_grade = Res.getString("echelle");
                Res1 = db.executionQuery("select * from Enseignant , avoir , situation_administrative,cadre "
                        + " where Enseignant.N_somme=avoir.N_somme "
                        + "and avoir.id_sa=situation_administrative.id_sa "
                        + "and Enseignant.N_somme='" + numero + "' "
                        + "and situation_administrative.id_cadre=cadre.id_cadre "
                        + "and cadre.id_cadre='" + id_cadre + "' "
                        + " and echelle='" + id_grade + "' ");

                while (Res1.next()) {
                    if (Res1.last()) {
                        String nomP = "" + upperFirst(Res1.getString("prenom")) + " " + upper(Res1.getString("nom"));

                        par = new Paragraph("\n\n\n "
                                + " \n\n\n\nLe Doyen de la Faculté des Sciences d'Oujda\n   "
                                + "        Atteste que: \n  ");
                        document.add(par);
                        par = new Paragraph("              Mr: ");

                        format = "dd/MM/yyyy";
                        java.text.SimpleDateFormat formater1 = new java.text.SimpleDateFormat(format);

                        par.add(new Phrase(nomP, boldText));
                        par.add(new Phrase("                                                   DOTI: "));

                        par.add(new Phrase(Res1.getString("N_somme").substring(0, 3) + "." + Res1.getString("N_somme").substring(3) + "\n\n", boldText));

                        document.add(par);

                        par = new Paragraph("Fait partie du personnel de cet établissement, en qualité de:\n\n");

                        par.add(new Phrase("           " + Res1.getString("type"), boldText));
                        par.add(new Phrase(", Grade << " + upper(Res1.getString("echelle")) + ">> depuis le: "));
                        par.add(new Phrase(formater1.format(Res1.getDate("ancienete_G")), boldText));

                        document.add(par);
                        par = new Paragraph("\nEt que sa date de recrutement dans les administrations publiques est le: ");
                        par.add(new Phrase(formater1.format(Res1.getDate("date_recrutement")), boldText));
                        document.add(par);

                        par = Bold("Il assure la fonction d': " + upper(Res1.getString("fonction")));
                        document.add(par);

                        par = new Paragraph("\nLa présente attestation lui a été délivrée sur sa demande pour servir et valoir "
                                + "\nce que de droit .");
                        document.add(par);
                        par = new Paragraph("\n\nOUJDA,le: ..........................................................");
                        par.setAlignment(Element.ALIGN_CENTER);

                        document.add(par);

                        par = boldunder("\n\n\nLe DOYEN :");

                        par.setAlignment(Element.ALIGN_CENTER);

                        document.add(par);

                    }
                }

            }
        }

        document.close();

        Desktop d = java.awt.Desktop.getDesktop();
        d.open(new java.io.File("Attestation.pdf"));

    }

    String upper(String x) {
        return x.toUpperCase();
    }

    String upperFirst(String x) {
        return x.substring(0, 1).toUpperCase() + x.substring(1);
    }

    Paragraph Bold(String x) {
        Font boldText = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLD);
        Paragraph p = new Paragraph(x, boldText);
        return p;
    }

    Paragraph boldunder(String x) {

        Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 10, Font.BOLDITALIC | Font.UNDERLINE);
        Paragraph p = new Paragraph(x, bold);
        return p;
    }

}
/*


 select last(situation_administrative.id_sa),nom,prenom,type from Enseignant , avoir , situation_administrative,cadre 
 where Enseignant.N_somme=avoir.N_somme 
 and avoir.id_sa=situation_administrative.id_sa
 and Enseignant.N_somme='768.693'
 and situation_administrative.id_cadre=cadre.id_cadre

 */
