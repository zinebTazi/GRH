package Header_footer;



import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Hf_Avancement extends PdfPageEventHelper {

    /**
     * The header text.
     */
    String header;
    /**
     * The template with the total number of pages.
     */
    PdfTemplate total;

    /**
     * Fills out the total number of pages before the document is closed.
     *
     * @see
     * com.itextpdf.text.pdf.PdfPageEventHelper#onCloseDocument(com.itextpdf.text.pdf.PdfWriter,
     * com.itextpdf.text.Document)
     */
    public void onCloseDocument(PdfWriter writer, Document document) {
        total.reset();
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                new Phrase(String.valueOf(writer.getPageNumber() - 1)),
                2, 2, 0);

    }

    public void onStartPage(PdfWriter writer, Document document) {
        try {
            // <editor-fold defaultstate="collapsed" desc="Compiled Code">
            /* 0: return
             *  */
            // </editor-fold>

            Font f = new Font(Font.FontFamily.TIMES_ROMAN, 8.50f);
            Font f1 = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, Font.BOLD);

            Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, Font.BOLD | Font.UNDERLINE);

            BaseFont bf = BaseFont.createFont("Ressource/arial.ttf", BaseFont.IDENTITY_H, true);
            Font fontArab = new Font(bf, 10);
            Font fontArabe = new Font(bf, 8);

            PdfPTable table1 = new PdfPTable(3);
            // table1.getDefaultCell().setBorder(0);
            table1.setWidths(new int[]{40, 8, 40});
            table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table1.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            table1.setTotalWidth(document.getPageSize().getWidth()
                    - document.leftMargin() - document.rightMargin());
            table1.setLockedWidth(true);
            table1.setWidthPercentage(100);

            PdfPCell cell = new PdfPCell();

            cell = new PdfPCell(new Paragraph("Royaume du Maroc\n\n"
                    + "Ministère de l'Enseignement Supèrieure,de la Recherche\n"
                    + "Scientifique et de la Formation des Cadres ‫\n"
                    + "Université Mohammed 1er ‫\n"
                    + "Faculté des Sciences\n"
                    + "Oujda", f));
            cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);

            cell.setBorder(Rectangle.NO_BORDER);
            table1.addCell(cell);
            Chunk CONNECT = new Chunk(
                    new LineSeparator(1f, 4000, BaseColor.BLACK, Element.ALIGN_MIDDLE, 15f));
            Phrase chunk = new Phrase(CONNECT);
            Image image1 = Image.getInstance("Ressource/logoFso.jpg");
            cell = new PdfPCell(image1, true);
            image1.setAlignment(PdfPCell.ALIGN_CENTER);
            cell.setBorder(Rectangle.NO_BORDER);
            table1.addCell(cell);

            cell = new PdfPCell(new Paragraph("المملكة   المغربية\n\n"
                    + "وزارة التعليم العالي و البحث العلمي  و تكوين الاطر\n"
                    + "جامعة  محمد  الاول\n"
                    + "كلية   العلوم\n"
                    + "وجدة ", fontArab));

            Paragraph a = new Paragraph();
            a.add(CONNECT);
            cell.setBorder(Rectangle.NO_BORDER);
            cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            table1.addCell(cell);
            document.add(new Phrase("\n\n\n\n\n\n"));
            cell = new PdfPCell(new Paragraph(a));
            cell.setColspan(3);
            cell.setBorder(Rectangle.NO_BORDER);
            table1.addCell(cell);
         

            table1.writeSelectedRows(0, -1, document.leftMargin(),
                    document.top(), writer.getDirectContent());
        } catch (DocumentException ex) {
            Logger.getLogger(Hf_Ordre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hf_Ordre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds a header to every page
     *
     * @see
     * com.itextpdf.text.pdf.PdfPageEventHelper#onEndPage(com.itextpdf.text.pdf.PdfWriter,
     * com.itextpdf.text.Document)
     */
    public void onEndPage(PdfWriter writer, Document document) {

        try {
            PdfPTable table = new PdfPTable(1);
            Font f = new Font(Font.FontFamily.TIMES_ROMAN, 14.50f);
            Font f2 = new Font(Font.FontFamily.TIMES_ROMAN, 12.0f, Font.BOLD | Font.UNDERLINE);
            Font f1 = new Font(Font.FontFamily.TIMES_ROMAN, 8.0f, Font.BOLD);
            BaseFont bf = BaseFont.createFont("Ressource/arial.ttf", BaseFont.IDENTITY_H, true);
            Font boldText = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLD);
            Font bold = new Font(Font.getFamily("TIMES_ROMAN"), 18, Font.BOLD | Font.UNDERLINE);
            Font fontArab = new Font(bf, 10);
            Font fontArabe = new Font(bf, 12);
            table.setWidths(new int[]{100});
            table.setTotalWidth(document.getPageSize().getWidth()
                    - document.leftMargin() - document.rightMargin());
            table.setLockedWidth(true);
            table.setWidthPercentage(100);
            //table.getDefaultCell().setFixedHeight(20);
            table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
            
            //*******************************************
          PdfPTable table3 = new PdfPTable(4);
        table3.setWidths( new int[]{40, 47, 45, 40});
        boldText.setColor(BaseColor.GRAY);
        table3.setWidthPercentage( 100); 
        table3.setHorizontalAlignment(Element.ALIGN_LEFT); 
        table3.setTotalWidth(document.getPageSize().getWidth()
                    - document.leftMargin() - document.rightMargin());
         Font boldTextUn = new Font(Font.getFamily("TIMES_ROMAN"), 12, Font.BOLDITALIC | Font.UNDERLINE);
        table3.setLockedWidth(true);
        PdfPCell cell = new PdfPCell(new Paragraph("L'avis de la Commission", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      //  cell.setVerticalAlignment(Element.ALIGN_CENTER);
         cell.setPadding(5);
        table3.addCell(cell);
        cell = new PdfPCell(new Paragraph("Représentants de l'Administration", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
       cell.setPadding(5);
        table3.addCell(cell);
        cell = new PdfPCell(new Paragraph("Représentants des Enseignants", boldText));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setPadding(5);
        //cell.setVerticalAlignment(Element.ALIGN_CENTER);
        table3.addCell(cell); 
        cell = new PdfPCell(new Paragraph("Signature du Doyen", boldTextUn));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        cell.setBorder(Rectangle.NO_BORDER); 
        table3.addCell(cell); 
        cell = new PdfPCell(new Paragraph("L'Approbation", boldText)); 
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
        cell.setPadding( 15);
        table3.addCell(cell); 
        cell = new PdfPCell(new Paragraph("")); 
        cell.setRowspan( 2);
        table3.addCell(cell); 
        cell = new PdfPCell(new Paragraph("")); 
        cell.setRowspan( 2);
        table3.addCell(cell); 
        cell = new PdfPCell(new Paragraph(""));
        cell.setBorder(Rectangle.NO_BORDER); 
        cell.setRowspan( 2);
        table3.addCell(cell);
        cell = new PdfPCell(new Paragraph("La désapprobation", boldText)); 
        cell.setPadding( 15);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); 
        table3.addCell(cell); 
        
        table3.writeSelectedRows(0, -1, document.leftMargin(),
                    document.bottom() +120, writer.getDirectContent());
        
            Chunk CONNECT = new Chunk(
                    new LineSeparator(1f, 5000, BaseColor.BLACK, Element.ALIGN_CENTER, 15f));
            Phrase chunk = new Phrase(CONNECT);
            cell = new PdfPCell();
            cell.setBorder(Rectangle.NO_BORDER);

            table.addCell(cell);
             Paragraph a = new Paragraph();
             a.add(CONNECT);
           
             a.add(new Paragraph("شارع  محمد  السادس  صندوق  البريد  717 وجدة  60500 المغرب    الهاتف : (212)536500601/02 الفاكس : (212)536500603  البريد الإلكتروني : ", fontArabe));
             a.add(new Phrase("  fsocomm@ump.ma ", f2));

             a.setAlignment(Element.ALIGN_CENTER);

             cell = new PdfPCell(new Paragraph(a));
             cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
             cell.setBorder(Rectangle.NO_BORDER);

             table.addCell(cell);
             table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
                     
                
            table.setExtendLastRow(true);
            //table.addCell(header);
            table.writeSelectedRows(0, -1, document.leftMargin(),
                    document.bottom(), writer.getDirectContent());

        } catch (DocumentException ex) {
            Logger.getLogger(Hf_Ordre.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hf_Ordre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates the PdfTemplate that will hold the total number of pages.
     *
     * @see
     * com.itextpdf.text.pdf.PdfPageEventHelper#onOpenDocument(com.itextpdf.text.pdf.PdfWriter,
     * com.itextpdf.text.Document)
     */
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(15, 14);
        //total.setBoundingBox(new Rectangle(-1, 6, 20, 20));
        
    }

    /**
     * Allows us to change the content of the header.
     *
     * @param header The new header String
     */
    public void setHeader(String header) {
        this.header = header;
    }
}

   