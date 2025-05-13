package br.com.fiap.winery;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

@WebService(endpointInterface = "br.com.fiap.winery.WineStockService")
public class WineStockServiceImplementation implements WineStockService {
    @Override
    @WebMethod
    public String getMenu() {
        return "Menu: Cabernet Sauvignon, Merlot, Syrah, Chardonnay, Pinot Noir";
    }

    @Override
    @WebMethod
    public String placeOrder(String name, int quantity) {
        return "Pedido confirmado!";
    }
}
