package br.com.fiap.winery;

import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class ApplicationClient1 {
    public static void main(String[] args) throws Exception {
        URL url = URI.create("http://localhost:8085/WineStockService?wsdl").toURL();
        
        QName serviceQName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
        
        Service service = Service.create(url, serviceQName);
        
        WineStockService wineStockServicePort = service.getPort(WineStockService.class);

        String menu = wineStockServicePort.getMenu();
    
        System.out.println(menu);
    }
}
