package Cadastrador;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class CadastradorHandler  implements RequestHandler<Request, Response>{
    @Override
    public Response handleRequest(Request request, Context context) {



        return null;
    }

    static public boolean limpa_campos(String s) throws Exception{
        JSONObject data = new JSONObject();
        data.put("description", s);
        
        URL url = new URL("https://dnetix.co/ping");
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod("POST");
        httpConnection.setRequestProperty("Content-Type", "application/json");
        httpConnection.setRequestProperty("Accept", "application/json");
        
        DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
        wr.write(data.toString().getBytes());
        Integer responseCode = httpConnection.getResponseCode();
        
        
        BufferedReader bufferedReader;
        // Creates a reader buffer
        if (responseCode > 199 && responseCode < 300) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        } else {
           return false;
        }

        // To receive the response
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();
        
        JSONObject answer = new JSONObject(line);
        String a = answer.getString("response");
        if(a.equals("se fudeu arrombado")){
        	
        }
        return true;
    }


}
