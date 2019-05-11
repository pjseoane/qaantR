/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qaant.rofexlogin;

/**
 *
 * @author pauli ver 4.0
 */
public class rLogin {
	public static void main(String[] args) throws Exception {

                String endpoint=  "http://pbcp-remarket.cloud.primary.com.ar/";
                String usr1 = "pjseoane232";
                String pswd1= "AiZkiC5#";
                
                System.out.println("Sending POST request to: "+endpoint);
                rofexLogin usr = new rofexLogin(endpoint,usr1,pswd1);
                System.out.println("\nTOKEN->>>>>>>>>>:"+usr.getToken());
	          
    
}
        
}
