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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prop_EchelonPdf {

    BD db;
    ResultSet Res1, Res2, Res3, Res4;
    int b = 1;

    String echelon;

    String format = "yyyy";
    java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat(format);
    String Numero_S;
    String cadr;
    private String grad;

    public Prop_EchelonPdf(String cadre, String grade, Date dateAvanc) throws SQLException, DocumentException, FileNotFoundException, IOException {

        db = new BD(Parametre.Host, Parametre.username, Parametre.password, Parametre.IPHOST, Parametre.Port);

        Document document = new Document();
        document.setPageSize(PageSize.A4.rotate());

        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("PropEchelon.pdf"));

        Hf_Avancement event = new Hf_Avancement();
        writer.setPageEvent(event);
        document.open();

        Font boldText = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLDITALIC);

        Paragraph nn = new Paragraph("\n\n");
        Paragraph an = new Paragraph("\n");

        Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLD | Font.UNDERLINE);

        Paragraph a = new Paragraph("PROPOSITION D'AVANCEMENT PAR ECHELON DE L'ANNEE " + formater.format(dateAvanc), bold);
        a.setAlignment(Element.ALIGN_CENTER);

        document.add(nn);
        document.add(a);

        document.add(nn);

        Paragraph p = new Paragraph("CADRE: ");
        p.add(new Phrase(cadre, boldText));
        p.add(new Phrase("                                            GRADE: "));
        p.add(new Phrase(grade, boldText));
        document.add(p);

        document.add(an);
        PdfPTable table2 = new PdfPTable(6);
        table2.setWidths(new int[]{22, 45, 20, 20, 20, 20});
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

        cell.setColspan(2);
        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Situation Proposé", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(2);
        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Echelon", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);
        cell = new PdfPCell(new Paragraph("Ancienneté", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);

        cell = new PdfPCell(new Paragraph("Echelon", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);
        cell = new PdfPCell(new Paragraph("Date", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table2.addCell(cell);

        Res1 = db.querySelectAll("Enseignant");

        try {
            while (Res1.next()) {
                Numero_S = Res1.getString("N_somme");

                Res2 = db.executionQuery("select echelon,type,echelle from situation_administrative,avoir,cadre where situation_administrative.id_sa=avoir.id_sa and avoir.N_somme='" + Numero_S + "' and situation_administrative.id_cadre=cadre.id_cadre");
                while (Res2.next()) {

                    if (Res2.last()) {

                        echelon = Res2.getString("echelon");
                        cadr = Res2.getString("type");
                        grad = Res2.getString("echelle");

                        format = "yyyy/MM/dd";
                        formater = new java.text.SimpleDateFormat(format);

                        if (cadr.equalsIgnoreCase(cadre) && grad.equalsIgnoreCase(grade)) {
                            Res3 = db.executionQuery("select *,DATE_ADD(anciennete_E, INTERVAL 2 YEAR) from Enseignant , avoir , situation_administrative,cadre "
                                    + "where Enseignant.N_somme=avoir.N_somme "
                                    + "and avoir.id_sa=situation_administrative.id_sa "
                                    + "and situation_administrative.id_cadre=cadre.id_cadre "
                                    + "and cadre.type='" + cadre + "' "
                                    + "and Enseignant.N_somme='" + Numero_S + "' "
                                    + "and situation_administrative.echelle= '" + grade + "' "
                                    + " and situation_administrative.echelon='" + echelon + "' "
                                    + " and DATE_ADD(anciennete_E, INTERVAL 2 YEAR) <= '" + formater.format(dateAvanc) + "'");

                            while (Res3.next()) {

                                if (Integer.parseInt(Res3.getString("echelon")) < 4) {

                                    format = "dd/MM/yyyy";
                                    formater = new java.text.SimpleDateFormat(format);
                                    String s = "" + Res3.getString("N_somme").substring(0, 3) + "." + (Res3.getString("N_somme")).substring(3);

                                    cell = new PdfPCell(new Paragraph(s));
                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    table2.addCell(cell);
                                    cell = new PdfPCell(new Paragraph(upper(Res3.getString("nom")) + " " + upperFirst(Res3.getString("prenom"))));
                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    table2.addCell(cell);

                                    cell = new PdfPCell(new Paragraph(Res3.getString("echelon")));
                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    table2.addCell(cell);

                                    cell = new PdfPCell(new Paragraph(formater.format(Res3.getDate("anciennete_E"))));
                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    table2.addCell(cell);

                                    cell = new PdfPCell(new Paragraph("" + (Integer.parseInt(Res3.getString("echelon")) + 1)));
                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    table2.addCell(cell);

                                    cell = new PdfPCell(new Paragraph(formater.format(Res3.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"))));
                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                    table2.addCell(cell);

                                    int cmpt = 2;
                                    b = 1;
                                    int i = 1;

                                    while (b == 1) {
                                        format = "yyyy/MM/dd";
                                        formater = new java.text.SimpleDateFormat(format);
                                        Res4 = db.executionQuery("select *,DATE_ADD(DATE_ADD(anciennete_E,INTERVAL " + cmpt + " YEAR),INTERVAL 2 YEAR),DATE_ADD(anciennete_E, INTERVAL " + cmpt + " YEAR) , DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(DATE_ADD(anciennete_E,INTERVAL " + cmpt + " YEAR), INTERVAL 2 YEAR))/365 from Enseignant , avoir , situation_administrative,cadre "
                                                + "where Enseignant.N_somme=avoir.N_somme "
                                                + "and avoir.id_sa=situation_administrative.id_sa "
                                                + "and situation_administrative.id_cadre=cadre.id_cadre "
                                                + "and cadre.type='" + cadre + "' "
                                                + "and Enseignant.N_somme='" + Numero_S + "' "
                                                + " and echelon='" + echelon + "' "
                                                + "and situation_administrative.echelle= '" + grade + "' ");

                                        while (Res4.next()) {
                                            if (Res4.last()) {

                                                if (Double.parseDouble(Res4.getString("DATEDIFF('" + formater.format(dateAvanc) + "',DATE_ADD(DATE_ADD(anciennete_E,INTERVAL " + cmpt + " YEAR), INTERVAL 2 YEAR))/365")) >= 0 && (Integer.parseInt(Res3.getString("echelon")) + i < 4)) {

                                                    format = "dd/MM/yyyy";
                                                    formater = new java.text.SimpleDateFormat(format);
                                                    s = "" + Res3.getString("N_somme").substring(0, 3) + "." + (Res3.getString("N_somme")).substring(3);

                                                    cell = new PdfPCell(new Paragraph(s));
                                                    
                                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                    table2.addCell(cell);
                                                    cell = new PdfPCell(new Paragraph(upper(Res4.getString("nom")) + " " + upperFirst(Res3.getString("prenom"))));
                                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                    table2.addCell(cell);

                                                    cell = new PdfPCell(new Paragraph("" + (Integer.parseInt(Res3.getString("echelon")) + i)));
                                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                    table2.addCell(cell);

                                                    cell = new PdfPCell(new Paragraph(formater.format(Res4.getDate("DATE_ADD(anciennete_E, INTERVAL " + cmpt + " YEAR)"))));
                                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                    table2.addCell(cell);

                                                    cell = new PdfPCell(new Paragraph("" + (Integer.parseInt(Res3.getString("echelon")) + (i + 1))));
                                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                    table2.addCell(cell);

                                                    cell = new PdfPCell(new Paragraph(formater.format(Res4.getDate("DATE_ADD(DATE_ADD(anciennete_E,INTERVAL " + cmpt + " YEAR),INTERVAL 2 YEAR)"))));
                                                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                                    table2.addCell(cell);

                                                    i++;

                                                } else {
                                                    this.b = b + 1;

                                                }

                                            }

                                        }
                                        cmpt = cmpt + 2;

                                    }
                                } else {

                                    if (cadre.equals("Professeur d Enseignement Supérieur") && grade.equals("C")) {
                                        format = "dd/MM/yyyy";
                                        formater = new java.text.SimpleDateFormat(format);
                                        String s = "" + Res3.getString("N_somme").substring(0, 3) + "." + (Res3.getString("N_somme")).substring(3);
                                        System.out.println(s);
                                        cell = new PdfPCell(new Paragraph(s));
                                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        table2.addCell(cell);
                                        cell = new PdfPCell(new Paragraph(upper(Res3.getString("nom")) + " " + upperFirst(Res3.getString("prenom"))));
                                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        table2.addCell(cell);

                                        cell = new PdfPCell(new Paragraph(Res3.getString("echelon")));
                                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        table2.addCell(cell);

                                        cell = new PdfPCell(new Paragraph(formater.format(Res3.getDate("anciennete_E"))));
                                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        table2.addCell(cell);

                                        cell = new PdfPCell(new Paragraph("5"));
                                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        table2.addCell(cell);

                                        cell = new PdfPCell(new Paragraph(formater.format(Res3.getDate("DATE_ADD(anciennete_E, INTERVAL 2 YEAR)"))));
                                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                                        table2.addCell(cell);
                                    }
                                }

                            }
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Prop_EchelonPdf.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.add(table2);

        document.close();

        Desktop d = java.awt.Desktop.getDesktop();
        d.open(new java.io.File("PropEchelon.pdf"));

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
