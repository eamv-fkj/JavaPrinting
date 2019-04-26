import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import javax.print.PrintService;

public class Main {

  public static void main(String[] args) {
    try {
      PrintService[] services = PrinterJob.lookupPrintServices();
      
      for (PrintService service : services)
        System.out.println(service);

      PrintService service = services[4];
      
      // if there is print services available, choose the first one
      if (service != null) {
        System.out.println("selected printer: " + service);
        
        PrinterJob pjob = PrinterJob.getPrinterJob();
        pjob.setPrintService(service);
        pjob.setPrintable(new Document(), new PageFormat());
        pjob.print();
      }
    }
    catch (Throwable t) {
      t.printStackTrace();
    }
  }
}
