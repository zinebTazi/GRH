package Avancement;

import Gestion.*;
import Header_footer.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.BorderFactory;

public class Prop_GradePdf {

    BD db;
    ResultSet Res, Res1;

    String format = "yyyy";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);

    public Prop_GradePdf(String type, String cadre, String grade, Date dateAvanc) throws DocumentException, FileNotFoundException, IOException, SQLException {
         db = new BD(Parametre.Host,Parametre.username,Parametre.password,Parametre.IPHOST,Parametre.Port);

        Document document = new Document();
        document.setPageSize(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("PropGrade " + type + ".pdf"));
        Hf_Avancement event = new Hf_Avancement();
        writer.setPageEvent(event);
        document.open();

        Font boldText = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLDITALIC);

        Paragraph nn = new Paragraph("\n\n");
        Paragraph an = new Paragraph("\n");

        document.add(an);

        Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 14, Font.BOLD);
        String title = "PROPOSITION DE PROMOTION DANS LE GRADE DE L'ANNEE " + formater.format(dateAvanc) + "\n EN FONCTION DES NOUVEAUX AVANCEMENT \n\n L'AVANCEMENT " + upper(type);
        Paragraph a = new Paragraph(title, bold);
        a.setAlignment(Element.ALIGN_CENTER);

        document.add(a);

        document.add(nn);

        Paragraph p = new Paragraph("CADRE: ");
        p.add(new Phrase(cadre, boldText));
        p.add(new Phrase("                                   GRADE: "));
        p.add(new Phrase(grade, boldText));
        document.add(p);

        document.add(an);

        PdfPTable table2 = new PdfPTable(8);
        table2.setWidths(new int[]{22, 25, 20, 20, 20, 20, 20, 20});
        table2.setWidthPercentage(100);

        table2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        boldText.setColor(BaseColor.GRAY);

        PdfPCell cell = new PdfPCell(new Paragraph("N° de Some", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);

        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Nom et Prenom", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setRowspan(2);

        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Situation Actuelle", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

        cell.setColspan(3);
        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Situation Proposé", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(3);
        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Grade", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);
        cell = new PdfPCell(new Paragraph("Echelon", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);
        cell = new PdfPCell(new Paragraph("Ancienneté", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Grade", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);
        cell = new PdfPCell(new Paragraph("Echelon", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);
        cell = new PdfPCell(new Paragraph("Date", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);

        if (type.equalsIgnoreCase("normal")) {

            Res = db.querySelectAll("Enseignant");

            String Numero_S;

            while (Res.next()) {
                Numero_S = Res.getString("N_somme");

                format = "yyyy/MM/dd";
                formater = new java.text.SimpleDateFormat(format);

                Res1 = db.executionQuery("select *,DATE_ADD(anciennete_E, INTERVAL 2 YEAR) from Enseignant , avoir , situation_administrative,cadre "
                        + "where Enseignant.N_somme=avoir.N_somme "
                        + "and avoir.id_sa=situation_administrative.id_sa "
                        + "and situation_administrative.id_cadre=cadre.id_cadre "
                        + "and situation_administrative.echelon='4' "
                        + "and Enseignant.N_somme='" + Numero_S + "' "
                        + "and cadre.type='" + cadre + "' "
                        + "and situation_administrative.echelle= '" + grade + "' "
                        + " and DATE_ADD(anciennete_E, INTERVAL 2 YEAR) <= '" + formater.format(dateAvanc) + "'");
                while (Res1.next()) {
                    if (Res1.last()) {

                        format = "dd/MM/yyyy";
                        formater = new java.text.SimpleDateFormat(format);

                        String s = "" + Res1.getString("N_somme").substring(0, 3) + "." + (Res1.getString("N_somme")).substring(3);
                        cell = new PdfPCell(new Paragraph(s));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);
                        cell = new PdfPCell(new Paragraph(upper(Res1.getString("nom")) + " " + upperFirst(Res.getString("prenom"))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);

                        cell = new PdfPCell(new Paragraph(Res1.getString("echelle")));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);

                        cell = new PdfPCell(new Paragraph(Res1.getString("echelon")));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);

                        cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("anciennete_E"))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);

                        int asci = (int) Res1.getString("echelle").charAt(0);
                        cell = new PdfPCell(new Paragraph("" + String.valueOf(Character.toChars(asci + 1))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);

                        cell = new PdfPCell(new Paragraph("1"));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);

                        cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"))));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table2.addCell(cell);
                    }
                }
            }
        }

        if (type.equalsIgnoreCase("rapide")) {

            Res = db.querySelectAll("Enseignant");

            String Numero_S;

            while (Res.next()) {
                Numero_S = Res.getString("N_somme");

                format = "yyyy/MM/dd";
                formater = new java.text.SimpleDateFormat(format);
                Res1 = db.executionQuery("select *,DATE_ADD(anciennete_E, INTERVAL 1 YEAR),DATE_ADD(anciennete_E, INTERVAL 2 YEAR) , DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 1 YEAR))/365,DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 2 YEAR))/365 from Enseignant , avoir , situation_administrative,cadre "
                        + "where Enseignant.N_somme=avoir.N_somme "
                        + "and avoir.id_sa=situation_administrative.id_sa "
                        + "and situation_administrative.id_cadre=cadre.id_cadre "
                        + "and cadre.type='" + cadre + "' "
                        + "and Enseignant.N_somme='" + Numero_S + "' "
                        + "and echelon='4' "
                        + "and situation_administrative.echelle= '" + grade + "' ");
                while (Res1.next()) {
                    if (Res1.last()) {
                        Double difference = Double.parseDouble(Res1.getString("DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 1 YEAR))/365"));

                        if (0 <= difference && difference < 1) {

                            format = "dd/MM/yyyy";
                            formater = new java.text.SimpleDateFormat(format);
                            String s = "" + Res1.getString("N_somme").substring(0, 3) + "." + (Res1.getString("N_somme")).substring(3);
                            cell = new PdfPCell(new Paragraph(s));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                            cell = new PdfPCell(new Paragraph(upper(Res1.getString("nom")) + " " + upperFirst(Res.getString("prenom"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(Res1.getString("echelle")));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(Res1.getString("echelon")));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("anciennete_E"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            int asci = (int) Res1.getString("echelle").charAt(0);
                            cell = new PdfPCell(new Paragraph("" + String.valueOf(Character.toChars(asci + 1))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph("1"));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 1 YEAR)"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                        }
                        format = "yyyy/MM/dd";
                        formater = new java.text.SimpleDateFormat(format);
                        Double difference1 = Double.parseDouble(Res1.getString("DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 2 YEAR))/365"));

                        if (0 <= difference1 && difference1 < 1) {

                            format = "dd/MM/yyyy";
                            formater = new java.text.SimpleDateFormat(format);
                            String s = "" + Res1.getString("N_somme").substring(0, 3) + "." + (Res1.getString("N_somme")).substring(3);
                            cell = new PdfPCell(new Paragraph(s));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                            cell = new PdfPCell(new Paragraph(upper(Res1.getString("nom")) + " " + upperFirst(Res.getString("prenom"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(Res1.getString("echelle")));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(Res1.getString("echelon")));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("anciennete_E"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            int asci = (int) Res1.getString("echelle").charAt(0);
                            cell = new PdfPCell(new Paragraph("" + String.valueOf(Character.toChars(asci + 1))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph("1"));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                        }
                    }
                }

            }
        }

        if (type.equalsIgnoreCase("exceptionnel")) {
            Res = db.querySelectAll("Enseignant");

            String Numero_S;

            while (Res.next()) {
                Numero_S = Res.getString("N_somme");

                format = "yyyy/MM/dd";
                formater = new java.text.SimpleDateFormat(format);
                Res1 = db.executionQuery("select *,DATE_ADD(anciennete_E,INTERVAL 1 YEAR),DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 1 YEAR))/365 from Enseignant , avoir , situation_administrative,cadre "
                        + "where Enseignant.N_somme=avoir.N_somme "
                        + "and avoir.id_sa=situation_administrative.id_sa "
                        + "and situation_administrative.id_cadre=cadre.id_cadre "
                        + "and cadre.type='" + cadre + "' "
                        + "and Enseignant.N_somme='" + Numero_S + "' "
                        + "and echelon='4' "
                        + "and situation_administrative.echelle= '" + grade + "' ");
                while (Res1.next()) {
                    if (Res1.last()) {
                        Double difference = Double.parseDouble(Res1.getString("DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 1 YEAR))/365"));
                        
                        if (0 <= difference && difference < 1) {

                            format = "dd/MM/yyyy";
                            formater = new java.text.SimpleDateFormat(format);
                            String s = "" + Res1.getString("N_somme").substring(0, 3) + "." + (Res1.getString("N_somme")).substring(3);
                            cell = new PdfPCell(new Paragraph(s));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                            cell = new PdfPCell(new Paragraph(upper(Res1.getString("nom")) + " " + upperFirst(Res.getString("prenom"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(Res1.getString("echelle")));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(Res1.getString("echelon")));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("anciennete_E"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            int asci = (int) Res1.getString("echelle").charAt(0);
                            cell = new PdfPCell(new Paragraph("" + String.valueOf(Character.toChars(asci + 1))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph("1"));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("DATE_ADD(anciennete_E,INTERVAL 1 YEAR)"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                        }
                    }
                }

                format = "yyyy/MM/dd";
                formater = new java.text.SimpleDateFormat(format);

                Res1 = db.executionQuery("select *,DATE_ADD(anciennete_E,INTERVAL 2 YEAR),DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 2 YEAR))/365 from Enseignant , avoir , situation_administrative,cadre "
                        + "where Enseignant.N_somme=avoir.N_somme "
                        + "and avoir.id_sa=situation_administrative.id_sa "
                        + "and situation_administrative.id_cadre=cadre.id_cadre "
                        + "and cadre.type='" + cadre + "' "
                        + "and Enseignant.N_somme='" + Numero_S + "' "
                        + "and echelon='3' "
                        + "and situation_administrative.echelle= '" + grade + "' ");

                while (Res1.next()) {
                    if (Res1.last()) {
                        Double difference = Double.parseDouble(Res1.getString("DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(anciennete_E,INTERVAL 2 YEAR))/365"));
                        
                        if (0 <= difference && difference < 1) {

                            format = "dd/MM/yyyy";
                            formater = new java.text.SimpleDateFormat(format);
                            String s = "" + Res1.getString("N_somme").substring(0, 3) + "." + (Res1.getString("N_somme")).substring(3);
                            cell = new PdfPCell(new Paragraph(s));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                            cell = new PdfPCell(new Paragraph(upper(Res1.getString("nom")) + " " + upperFirst(Res.getString("prenom"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(Res1.getString("echelle")));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph("" + (Integer.parseInt(Res1.getString("echelon")) + 1)));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("DATE_ADD(anciennete_E,INTERVAL 2 YEAR)"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            int asci = (int) Res1.getString("echelle").charAt(0);
                            cell = new PdfPCell(new Paragraph("" + String.valueOf(Character.toChars(asci + 1))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph("1"));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);

                            cell = new PdfPCell(new Paragraph(formater.format(Res1.getDate("DATE_ADD(anciennete_E,INTERVAL 2 YEAR)"))));
                            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table2.addCell(cell);
                        }
                    }
                }
            }

        }

        document.add(table2);

        document.close();

        Desktop d = java.awt.Desktop.getDesktop();

        d.open(
                new java.io.File("PropGrade " + type + ".pdf"));
    }

    String upper(String x) {
        return x.toUpperCase();
    }

    String upperFirst(String x) {
        return x.substring(0, 1).toUpperCase() + x.substring(1);
    }

}

/*
 int asci=(int)Res.getString("echelle").charAt(0);
 System.out.println(""+String.valueOf(Character.toChars(asci+1)));
 select *,DATE_ADD(anciennete, INTERVAL 2 YEAR) from Enseignant , avoir , situation_administrative,cadre where Enseignant.N_somme=avoir.N_somme and avoir.id_sa=situation_administrative.id_sa and situation_administrative.id_cadre=cadre.id_cadre and situation_administrative.echelon='4' and Enseignant.N_somme='331644' and cadre.type='Professeur d Enseignement Supérieur' and situation_administrative.echelle= 'B'  and DATE_ADD(anciennete, INTERVAL 2 YEAR) <= '23/05/2015'
 */
