/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qaant.rofexREST;

/**
 *
 * @author pjseoane@qaantcap.com
 */
public class RofexJava {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    
    
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
             
            loginREST usr = new loginREST();
            System.out.println("\nTOKEN->>>>>>>>>>:"+usr.getToken());
            
            String instruments =usr.getInstruments();
            System.out.println("Elements "+instruments);
            
            String instDetails =usr.getInstrumentDetail("DOJun19");
            System.out.println("Detail "+instDetails);
        
    }
    
}
