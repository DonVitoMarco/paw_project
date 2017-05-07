package pl.thewalkingcode.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.thewalkingcode.model.EventAccount;
import pl.thewalkingcode.pdf.PdfBuilder;
import pl.thewalkingcode.service.api.EventAccountService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/report")
public class AdminController {

    @Autowired
    @Qualifier("eventAccountService")
    private EventAccountService eventAccountService;

    @RequestMapping(method = RequestMethod.GET)
    public void getPdfReport(HttpServletResponse response) {
        response.setContentType("application/pdf");
        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, response.getOutputStream());
            document.open();
            document.add(PdfBuilder.createTable(eventAccountService.getAllEvents()));
            document.close();
        } catch (DocumentException de) {
            de.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
