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
    	String status = "";
    	try {
			status = limpa_campos(request.getCategoria() + " " + request.getCondicao() + " " + request.getDescricao() + " " + request.getFrete() + " " + request.getMarca() + " " + request.getNome() + " " + request.getTamanho());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(status.equals("Campo limpo")) {
    		JSONObject data = new JSONObject();
            try {
            	data.put("a_venda", request.a_venda);
            	data.put("categoria", request.categoria);
            	data.put("condicao", request.condicao);
            	data.put("desconto", request.desconto);
            	data.put("descricao", request.descricao);
            	data.put("foto", request.foto);
            	data.put("frete", request.frete);
            	data.put("id_comprador", request.id_comprador);
//            	data.put("id_produto", request.id_produto);
            	data.put("id_vendedor", request.id_vendedor);
            	data.put("marca", request.marca);
				data.put("nome", request.nome);
				data.put("preco", request.preco);
				data.put("qtde_curtidas", request.qtde_curtidas);
				data.put("tags", request.tags);
				data.put("tamanho", request.tamanho);
				URL url = new URL("https://dry-escarpment-83331.herokuapp.com/produto");
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
	            boolean flag = false;
	            if (responseCode > 199 && responseCode < 300) {
	                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
	                flag = true;
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
	            JSONObject answer = new JSONObject(content);
	            /*String a = answer.getString("response");
	            if(a == "ok") {
	            	return new Response("Cadastro realizado com sucesso", "aprovado");
	            }
	            */
	            System.out.println(content);
	            if(flag)
	            	return new Response("Cadastro realizado com sucesso", "Aprovado");
            	return new Response("Cadastro nao sucedido", "Erro durante cadastro");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    	}

        return new Response("Cadastro nao sucedido", status);
    }

    static public String limpa_campos(String s) throws Exception{
        JSONObject data = new JSONObject();
        data.put("description", s);
        
        URL url = new URL("https://9nxjgv0mld.execute-api.sa-east-1.amazonaws.com/Limpador");
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
           return "Erro ao checar campos";
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
        return a;
    }
    
    


}
