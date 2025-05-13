package br.com.fiap.winery;

import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

import br.com.fiap.winery.generated.orderclient.WineStockService;
import br.com.fiap.winery.generated.orderclient.WineWarningService;


public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {
        URL urlStock = URI.create("http://localhost:8085/WineStockService?wsdl").toURL();
        QName qNameStock = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
        Service serviceStock = Service.create(urlStock, qNameStock);
        WineStockService wineStockServicePort = serviceStock.getPort(WineStockService.class);
        String order = wineStockServicePort.placeOrder("Cabernet Sauvignon", 2);
        System.out.println(order);
        
        URL urlWarn = URI.create("http://localhost:8086/WineWarningService?wsdl").toURL();
        QName qNameWarn = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");
        Service serviceWarn = Service.create(urlWarn, qNameWarn);
        WineWarningService wineWarningServicePort = serviceWarn.getPort(WineWarningService.class);
        String warn = wineWarningServicePort.sendWarn();
        System.out.println(warn);
    }
}
