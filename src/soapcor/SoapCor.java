/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soapcor;

import java.util.List;
import org.tempuri.CResultado;
import org.tempuri.CServico;

/**
 *
 * @author Gustavo
 */
public class SoapCor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CResultado res = calcPrazo("04014", "13604228", "68906848");
        
        List <CServico> lista=res.getServicos().getCServico();
        
        for(CServico cs:lista){
            if(cs.getErro().equals(""))
                System.out.println("Prazo de entrega é: "+cs.getPrazoEntrega());
            else
                System.out.println(cs.getErro());
        }
    }

    private static CResultado calcPrazo(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino) {
        org.tempuri.CalcPrecoPrazoWS service = new org.tempuri.CalcPrecoPrazoWS();
        org.tempuri.CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap();
        return port.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
    }
    
}
