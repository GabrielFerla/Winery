package br.com.fiap.winery;

import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName; // Corrected: JAX-WS often expects this for QName
import jakarta.xml.ws.Service;

// Import the generated JAX-WS classes
import br.com.fiap.winery.generated.WineStockService; // This is the SEI (Service Endpoint Interface)
// import br.com.fiap.winery.generated.WineStockServiceImplementationService; // This is the generated Service class, not strictly needed if using Service.create

public class ApplicationClient1 {
    public static void main(String[] args) throws Exception {
        // Script Step 27: Cria uma URL para o arquivo WSDL
        URL url = URI.create("http://localhost:8085/WineStockService?wsdl").toURL();
        
        // Script Step 28: Cria um QName com o namespace e nome do serviço
        QName serviceQName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
        
        // Script Step 29: Instancie um objeto "Service", denominado "service", com o método "create" da classe "Service"
        Service service = Service.create(url, serviceQName);
        
        // Script Step 30: Instancie um objeto "WineStockService", denominado "wineStockService", com o método "getPort"
        WineStockService wineStockServicePort = service.getPort(WineStockService.class);

        // Script Step 31: Chama o método getMenu e armazena o resultado
        String menu = wineStockServicePort.getMenu();
        
        // Imprime o menu
        System.out.println("Menu from WineStockService (ApplicationClient1):");
        System.out.println(menu);
    }
}
