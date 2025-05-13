package br.com.fiap.winery;

import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class ApplicationClient2 {
    public static void main(String[] args) throws Exception {
        // Cria uma URL para o arquivo WSDL do serviço de pedido
        URL url = URI.create("http://localhost:8085/WineStockService?wsdl").toURL();
        // Cria um QName com o namespace e nome do serviço
        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
        // Cria o serviço usando a URL e o QName
        Service service = Service.create(url, qName);
        // Obtém uma porta/interface para o serviço
        WineStockService wineStockService = service.getPort(WineStockService.class);
        // Chama o método placeOrder e armazena o resultado
        String order = wineStockService.placeOrder("Cabernet Sauvignon", 2);
        // Imprime o pedido
        System.out.println(order);
        
        // Cria uma URL para o arquivo WSDL do serviço de aviso
        URL url2 = URI.create("http://localhost:8086/WineWarningService?wsdl").toURL();
        // Cria um QName com o namespace e nome do serviço
        QName qName2 = new QName("http://winery.fiap.com.br/", "WineWarningServiceImplementationService");
        // Cria o serviço usando a URL e o QName
        Service service2 = Service.create(url2, qName2);
        // Obtém uma porta/interface para o serviço
        WineWarningService wineWarningService = service2.getPort(WineWarningService.class);
        // Chama o método sendWarn e armazena o resultado
        String warn = wineWarningService.sendWarn();
        // Imprime o aviso
        System.out.println(warn);
    }
}
