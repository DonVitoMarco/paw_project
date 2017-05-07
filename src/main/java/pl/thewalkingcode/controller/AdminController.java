package pl.thewalkingcode.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.pdf.PdfBuilder;
import pl.thewalkingcode.service.api.EventAccountService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping(value = "/profile")
public class AdminController {

    @Autowired
    @Qualifier("eventAccountService")
    private EventAccountService eventAccountService;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public void getPdfReport(HttpServletResponse response) {
        response.setContentType("application/pdf");
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("Hello World"));
            document.add(new Paragraph(new Date().toString()));
            document.add(PdfBuilder.createTable());
            document.close();
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
