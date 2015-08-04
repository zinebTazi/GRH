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

public class Hf_fiche extends PdfPageEventHelper {

    /**
     * The header text.
     */
    String header;
    /**
     * The template with the total number of pages.
     */
    PdfTemplate total;

    public void onCloseDocument(PdfWriter writer, Document document) {
        total.reset();
        ColumnText.showTextAligned(total, Element.ALIGN_LEFT,
                new Phrase(String.valueOf(writer.getPageNumber() - 1)),
                2, 2, 0);

    }

    public void onStartPage(PdfWriter writer, Document document) {

    }

    public void onEndPage(PdfWriter writer, Document document) {
        if (writer.getPageNumber() > 1) {
            try {
                PdfPTable table = new PdfPTable(1);
                Font f = new Font(Font.FontFamily.TIMES_ROMAN, 14.50f);

                table.setWidths(new int[]{100});
                table.setTotalWidth(document.getPageSize().getWidth()
                        - document.leftMargin() - document.rightMargin());
                table.setLockedWidth(true);
                table.setWidthPercentage(100);

                table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
                Chunk CONNECT = new Chunk(
                        new LineSeparator(1f, 4000, BaseColor.BLACK, Element.ALIGN_CENTER, 15f));
                Phrase chunk = new Phrase(CONNECT);
                PdfPCell cell = new PdfPCell();
                cell.setBorder(Rectangle.NO_BORDER);

                table.addCell(cell);

                DottedLineSeparator dottedline = new DottedLineSeparator();
                Chunk linebreak = new Chunk(dottedline);
                dottedline.setOffset(-30);
                dottedline.setGap(5f);
                dottedline.setPercentage(595000f / -80f);
                dottedline.setAlignment(Element.ALIGN_CENTER);
                PdfPTable table1 = new PdfPTable(1);
                table1.setTotalWidth(document.getPageSize().getWidth()
                        - document.leftMargin() - document.rightMargin());
                table1.setLockedWidth(true);
                table1.setWidthPercentage(100);
                Phrase b = new Phrase("Remarque :", f);
                Paragraph c = new Paragraph("\n");
                b.add(linebreak);
                c.add(linebreak);
                c.add(linebreak);
                cell = new PdfPCell(new Phrase(b));
                cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                cell.setBorder(Rectangle.NO_BORDER);
                table1.addCell(cell);

                cell = new PdfPCell(new Paragraph(c));
                cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                cell.setBorder(Rectangle.NO_BORDER);
                table1.addCell(cell);

                cell = new PdfPCell(new Paragraph(c));
                cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                cell.setBorder(Rectangle.NO_BORDER);
                table1.addCell(cell);

                cell = new PdfPCell(new Paragraph(c));
                cell.setRunDirection(PdfWriter.RUN_DIRECTION_LTR);
                cell.setBorder(Rectangle.NO_BORDER);
                table1.addCell(cell);
                table1.writeSelectedRows(0, -1, document.leftMargin(),
                        document.bottom() + 150, writer.getDirectContent());

            } catch (DocumentException ex) {
                Logger.getLogger(Hf_Ordre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(15, 14);

    }

    public void setHeader(String header) {
        this.header = header;
    }
}
