package br.com.fiap.winery;

import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName; // Ensure this is the correct QName import
import jakarta.xml.ws.Service;

// Import the generated JAX-WS classes from the new package
import br.com.fiap.winery.generated.orderclient.WineStockService;
import br.com.fiap.winery.generated.orderclient.WineWarningService;
// If you were to use the generated service implementation classes directly (e.g. new WineStockServiceImplementationService(...))
// you would import them as well, like:
// import br.com.fiap.winery.generated.orderclient.WineStockServiceImplementationService;
// import br.com.fiap.winery.generated.orderclient.WineWarningServiceImplementationService;


public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {
        // Steps 37-40: Setup for WineStockService
        URL urlStock = URI.create("http://localhost:8085/WineStockService?wsdl").toURL();
        QName qNameStock = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
        Service serviceStock = Service.create(urlStock, qNameStock);
        WineStockService wineStockServicePort = serviceStock.getPort(WineStockService.class);

        // Step 41: Call placeOrder
        String order = wineStockServicePort.placeOrder("Cabernet Sauvignon", 2);
        System.out.println("Order Response (ApplicationClient2):");
        System.out.println(order);
        
        // Steps 58-61: Setup for WineWarningService
        URL urlWarn = URI.create("http://localhost:8086/WineWarningService?wsdl").toURL();
        QName qNameWarn = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");
        Service serviceWarn = Service.create(urlWarn, qNameWarn);
        WineWarningService wineWarningServicePort = serviceWarn.getPort(WineWarningService.class);

        // Step 62: Call sendWarn
        String warn = wineWarningServicePort.sendWarn();
        System.out.println("Warning Response (ApplicationClient2):");
        System.out.println(warn);
    }
}
