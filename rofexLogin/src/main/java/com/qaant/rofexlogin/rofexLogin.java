/*
 
 */
package com.qaant.rofexlogin;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 *
 * @author pauli ver 3.0
 */
public class rofexLogin {
    String url, usr, pswd;
    
    rofexLogin(String url, String usr, String pswd){
    this.url    =url;
    this.usr    =usr;
    this.pswd   =pswd;
    }        

    public String getToken()throws Exception{   
        url=    url+ "auth/getToken";
        
        URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        String userCredentials = usr+":"+pswd;
        String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userCredentials.getBytes()));
        
        con.setRequestMethod("POST");
        //header
        con.setRequestProperty("Authorization", basicAuth);
        // Send post request
	con.setDoOutput(true);
        
        return con.getHeaderField("X-Auth-Token");
    }
   
}

