package pl.thewalkingcode.pdf;

import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import pl.thewalkingcode.model.EventAccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PdfBuilder {

    public static PdfPTable createTable(List<EventAccount> eventAccountList) {
        PdfPTable table = new PdfPTable(8);

        PdfPCell cellTitle = new PdfPCell(new Phrase("Exchange Report"));
        cellTitle.setColspan(8);
        table.addCell(cellTitle);

        PdfPCell cellDate = new PdfPCell(new Phrase("Date: "));
        cellDate.setColspan(3);
        table.addCell(cellDate);

        PdfPCell cellCreateDate = new PdfPCell(new Phrase(new Date().toString()));
        cellCreateDate.setColspan(5);
        table.addCell(cellCreateDate);

        table.addCell(new Phrase("Date"));
        table.addCell(new Phrase("User"));
        table.addCell(new Phrase("Action"));
        table.addCell(new Phrase("Company"));
        table.addCell(new Phrase("Unit"));
        table.addCell(new Phrase("Price"));
        table.addCell(new Phrase("Amount"));
        table.addCell(new Phrase("Wallet"));

        for(EventAccount ea : eventAccountList) {
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String parseDate = dt.format(ea.getDate());
            table.addCell(parseDate);

            table.addCell(ea.getUsername());
            table.addCell(ea.getAction());
            table.addCell(ea.getCompany());
            table.addCell(ea.getUnit().toString());;
            table.addCell(ea.getPrice().toString());
            table.addCell(ea.getAmount().toString());
            table.addCell(ea.getWallet().toString());
        }

        return table;
    }

}
