package br.com.fiap.winery;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;

@WebService(endpointInterface = "br.com.fiap.winery.WineWarningService")
public class WineWarningServiceImplementation implements WineWarningService {
    @Override
    @WebMethod
    public String sendWarn() {
        return "Estoque insuficiente!";
    }
}
