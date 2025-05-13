package br.com.fiap.winery;

import java.net.URI;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

public class ApplicationClient1 {
    public static void main(String[] args) throws Exception {
        // Cria uma URL para o arquivo WSDL
        URL url = URI.create("http://localhost:8085/WineStockService?wsdl").toURL();
        // Cria um QName com o namespace e nome do serviço
        QName qName = new QName("http://winery.fiap.com.br/", "WineStockServiceImplementationService");
        // Cria o serviço usando a URL e o QName
        Service service = Service.create(url, qName);
        // Obtém uma porta/interface para o serviço
        WineStockService wineStockService = service.getPort(WineStockService.class);
        // Chama o método getMenu e armazena o resultado
        String menu = wineStockService.getMenu();
        // Imprime o menu
        System.out.println(menu);
    }
}
