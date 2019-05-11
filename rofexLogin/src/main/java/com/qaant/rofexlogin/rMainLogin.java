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
public class rMainLogin {
	public static void main(String[] args) throws Exception {

            String endpoint=  "http://pbcp-remarket.cloud.primary.com.ar/";
            String usr1 = "pjseoane232";
            String pswd1= "AiZkiC5#";
            String token=null;
                
            System.out.println("\nqaant Labs Developments - pjseoane@qaantcap.com");
            System.out.println("\nSending POST request to: "+endpoint);
            
            rLogin usr = new rLogin(endpoint,usr1,pswd1);
            token=usr.getToken();
            
            System.out.println("\nTOKEN->>>>>>>>>>:"+token);
            
           
            
            
	}
        
}
