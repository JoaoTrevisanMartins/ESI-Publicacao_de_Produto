package Alterador;

import com.amazonaws.services.lambda.runtime.RequestHandler;


import com.amazonaws.services.lambda.runtime.Context;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class AlteradorHandler implements RequestHandler<Request, Response> {
	
	@Override
	public Response handleRequest(Request request, Context context) {
    	boolean aprovado = false;
    	try {
			aprovado = limpa_campos(request.getCategoria() + " " + request.getCondicao() + " " + request.getDescricao() + " " + request.getFrete() + " " + request.getMarca() + " " + request.getNome() + " " + request.getTamanho());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	aprovado = true;
    	if(aprovado) {
    		JSONObject data = new JSONObject();
            try {
            	data.put("a_venda", request.isA_venda());
				data.put("nome", request.getNome());
				data.put("foto", request.getFoto());
				data.put("marca", request.getMarca());
				data.put("tamanho", request.getTamanho());
				data.put("descricao", request.getDescricao());
				data.put("categoria", request.getCategoria());
				data.put("frete", request.getFrete());
				data.put("condicao", request.getCondicao());
				data.put("preco", request.getPreco());
				data.put("desconto", request.getDesconto());
				data.put("id_comprador", request.getId_comprador());
				data.put("id_produto", request.getId_produto());
				data.put("id_vendedor", request.getId_vendedor());
				data.put("qtde_curtidas", request.getQtde_curtidas());
				data.put("tags", request.getTags());
				URL url = new URL("https://dry-escarpment-83331.herokuapp.com/produto");
	            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
	            httpConnection.setDoOutput(true);
	            httpConnection.setRequestMethod("PUT");
	            httpConnection.setRequestProperty("Content-Type", "application/json");
	            httpConnection.setRequestProperty("Accept", "application/json");
	            
	            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
	            wr.write(data.toString().getBytes());
	            Integer responseCode = httpConnection.getResponseCode();
	            
	            
	            BufferedReader bufferedReader;
	            // Creates a reader buffer
	            boolean flag = false;
	            if (responseCode > 199 && responseCode < 300) {
	            	flag = true;
	                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
	            } else {
	            	bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
	            }

	            // To receive the response
	            StringBuilder content = new StringBuilder();
	            String line;
	            while ((line = bufferedReader.readLine()) != null) {
	                content.append(line).append("\n");
	            }
	            bufferedReader.close();
	            /*String a = answer.getString("response");
	            if(a == "ok") {
	            	return new Response("Cadastro realizado com sucesso", "aprovado");
	            }
	            */
	            System.out.println(content);
	            if(flag) {
	            	return new Response("Alteracao realizado com sucesso", "aprovado");
	            }
	            return new Response("Alteracao nao sucedido", "reprovado");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    	}

        return new Response("Alteracao nao sucedido", "reprovado");
    }

    static public boolean limpa_campos(String s) throws Exception{
        JSONObject data = new JSONObject();
        data.put("description", s);
        
        URL url = new URL("https://rngh8l6wcd.execute-api.sa-east-1.amazonaws.com/Limpador");
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
        System.out.println(content.toString());
        
        JSONObject answer = new JSONObject(content.toString());
        String a = answer.getString("response");
        if(a.equals("Campo com problemas")){
        	return false;
        }
        return true;
    }
}
