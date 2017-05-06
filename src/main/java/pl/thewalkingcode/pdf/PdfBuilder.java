package pl.thewalkingcode.pdf;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class PdfBuilder {

    public static PdfPTable createTable() {
        PdfPTable table = new PdfPTable(3);

        PdfPCell cellTitle = new PdfPCell(new Phrase("Title"));
        cellTitle.setColspan(3);
        table.addCell(cellTitle);

        table.addCell(new Phrase("-1-"));
        table.addCell(new Phrase("-2-"));
        table.addCell(new Phrase("-3-"));

        return table;
    }

}
