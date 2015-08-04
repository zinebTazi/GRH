package Info_perso;

import Gestion.*;
import Header_footer.*;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author guemmi
 */
public class EnseignantPdf {

    BD db;
    ResultSet Res;

    public EnseignantPdf(String n) throws DocumentException, FileNotFoundException, IOException, SQLException {
        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);
        Res = db.executionQuery("select *  from Enseignant ,situation_administrative,cadre,avoir ,Diplomes, obtient"
                + " where Enseignant.N_somme=obtient.N_somme "
                + " and obtient.id_diplomes=Diplomes.id_diplomes "
                + " and Enseignant.N_somme='" + n + "'"
                + " and  Enseignant.N_somme=avoir.N_somme "
                + " and avoir.id_sa=situation_administrative.id_sa "
                + " and situation_administrative.id_cadre=cadre.id_cadre ");

        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("Enseignant.pdf"));
        Hf_fiche event = new Hf_fiche();
        writer.setPageEvent(event);
        document.open();

        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8.50f);
        Font boldText = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLDITALIC);
        Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 18, Font.BOLD | Font.UNDERLINE);
        Font x = new Font(Font.getFamily("TIMES_ROMAN"), 11, Font.ITALIC);

        PdfPTable table1 = new PdfPTable(3);
        table1.setWidths(new int[]{40, 15, 50});

        table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

        table1.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell();

        cell = new PdfPCell(new Paragraph("\nUniversité Mohammed 1er\n ‫\n"
                + "     Faculté des Sciences\n\n"
                + "               Oujda", x));

        cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);

        cell.setBorder(Rectangle.NO_BORDER);
        cell.setPaddingLeft(10);

        table1.addCell(cell);
        while (Res.next()) {

            Blob blob = Res.getBlob("image");
            if (blob != null) {

                byte barr[] = blob.getBytes(1, (int) blob.length());
                FileOutputStream fout = new FileOutputStream("tes.jpg");
                fout.write(barr);
                com.itextpdf.text.Image image1 = com.itextpdf.text.Image.getInstance("tes.jpg");
                image1.scaleToFit(112, 118);

                cell = new PdfPCell(image1, true);
                cell.setBorder(Rectangle.NO_BORDER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);

                table1.addCell(cell);
            } else {
                table1.addCell("photo");
            }

            String s = "" + Res.getString("N_somme").substring(0, 3) + "." + (Res.getString("N_somme")).substring(3);
            cell = new PdfPCell(new Paragraph("\nN° de some:      " + s
                    + "\n\nC.I.N:        " + (Res.getString("CIN")), x));

            cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);

            cell.setBorder(Rectangle.NO_BORDER);
            cell.setPaddingLeft(100);

            table1.addCell(cell);

            document.add(table1);

            Paragraph a = new Paragraph("\nFiche d'informations personnelles", bold);
            a.setAlignment(Element.ALIGN_CENTER);
            document.add(a);
            if (Res.last()) {

                a = new Paragraph("\n\n\nNom:                             ");
                a.add(new Phrase(upper(Res.getString("nom")), boldText));
                a.add(new Phrase(" \n\nPrénom :                               "));
                a.add(new Phrase(upper(Res.getString("prenom")), boldText));
                a.add(new Phrase("\n\nDate et lieu de naissance :                       "));
                a.add(new Phrase(Res.getString("Date_naissance"), boldText));
                a.add(new Phrase("       à          "));
                a.add(new Phrase(upper(Res.getString("Lieu_Naissance")), boldText));
                a.add(new Phrase("\n\nSituation familiale:                              "));
                a.add(new Phrase(Res.getString("situation_familiale"), boldText));
                a.add(new Phrase("\n\nNombre d'enfants :                           "));
                a.add(new Phrase(upper(Res.getString("nb_enfants")), boldText));

                a.add(new Phrase("\n\nCadre:                        "));
                a.add(new Phrase(Res.getString("type"), boldText));
                a.add(new Phrase("\n\nFonction :                      "));
                a.add(new Phrase(upper(Res.getString("fonction")), boldText));
                a.add(new Phrase("\n\nSpecialité:                        "));
                a.add(new Phrase(Res.getString("departement"), boldText));

                a.add(new Phrase("\n\nDate d'entrée:                        "));
                a.add(new Phrase(Res.getString("date_d_entree"), boldText));

                a.add(new Phrase("\n\nDate de recrutement:                     "));
                a.add(new Phrase(Res.getString("date_recrutement"), boldText));
                a.add(new Phrase("\n\nAdresse:                       "));
                a.add(new Phrase(Res.getString("adresse"), boldText));;
                a.add(new Phrase("\n\nNumero de téléphone:                        "));
                a.add(new Phrase(Res.getString("N_telephone"), boldText));
                a.add(new Phrase("\n\nDiplômes obtenus:                  "));
                a.add(new Phrase(Res.getString("Diplomes.nom"), boldText));
                a.add(new Phrase("\n\n\n\nE-mail:                           "));
                a.add(new Phrase(Res.getString("ad_electronique"), boldText));

            }
            a.setIndentationLeft(67);
            a.setIndentationRight(50);

            document.add(a);

            document.newPage();
            Paragraph nn = new Paragraph("\n\n");

            Paragraph b = new Paragraph("\nSituation administrative", bold);
            b.setAlignment(Element.ALIGN_CENTER);
            document.add(b);
            document.add(nn);
            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[]{50, 20, 20, 20});

            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.setWidthPercentage(100);

            PdfPCell cell1 = new PdfPCell();

            cell1 = new PdfPCell(new Paragraph("Cadre ", boldText));

            cell1.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setFixedHeight(30);
            cell1.setBorderWidth(2);
            table.addCell(cell1);
            cell1 = new PdfPCell(new Paragraph("Grade", boldText));

            cell1.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell1.setFixedHeight(30);
            cell1.setBorderWidth(2);
            table.addCell(cell1);

            cell1 = new PdfPCell(new Paragraph("Echelon", boldText));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);

            cell1.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
            cell1.setFixedHeight(30);

            cell1.setBorderWidth(2);
            table.addCell(cell1);

            cell1 = new PdfPCell(new Paragraph("Ancienneté", boldText));
            cell1.setHorizontalAlignment(Element.ALIGN_CENTER);

            cell1.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
            cell1.setFixedHeight(30);
            cell1.setBorderWidth(2);

            table.addCell(cell1);
            Res = db.executionQuery("select *  from Enseignant ,situation_administrative,cadre,avoir ,Diplomes, obtient"
                    + " where Enseignant.N_somme=obtient.N_somme "
                    + " and obtient.id_diplomes=Diplomes.id_diplomes "
                    + " and Enseignant.N_somme='" + n + "'"
                    + " and  Enseignant.N_somme=avoir.N_somme "
                    + " and avoir.id_sa=situation_administrative.id_sa "
                    + " and situation_administrative.id_cadre=cadre.id_cadre "
                    + " order by anciennete_E asc");
            while (Res.next()) {
                cell = new PdfPCell(new Paragraph(Res.getString("type")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(1);
                table.addCell(cell);
                cell = new PdfPCell(new Paragraph(upper(Res.getString("echelle"))));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(1);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(Res.getString("echelon")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(1);
                table.addCell(cell);

                cell = new PdfPCell(new Paragraph(Res.getString("anciennete_E")));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBorderWidth(1);
                table.addCell(cell);

            }
            document.add(table);

        }
        document.close();

        Desktop d = java.awt.Desktop.getDesktop();
        d.open(new java.io.File("Enseignant.pdf"));

    }

    String upper(String x) {
        return x.toUpperCase();
    }

    String upperFirst(String x) {
        return x.substring(0, 1).toUpperCase() + x.substring(1);
    }

    Paragraph boldunder(String x) {

        Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 10, Font.BOLDITALIC | Font.UNDERLINE);
        Paragraph p = new Paragraph(x, bold);
        return p;
    }

}


/*select echelle,echelon  from Enseignant ,situation_administrative,cadre,avoir ,Diplomes, obtient where Enseignant.N_somme=obtient.N_somme  and obtient.id_diplomes=Diplomes.id_diplomes  and Enseignant.N_somme='452145' and  Enseignant.N_somme=avoir.N_somme  and avoir.id_sa=situation_administrative.id_sa  and situation_administrative.id_cadre=cadre.id_cadre  
 order by echelle asc*/
