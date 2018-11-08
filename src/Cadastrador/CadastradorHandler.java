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
	
	public static void main(String []args) throws Exception {
		String descricao = "asdsdf@usp.br";
		boolean aprovado = limpa_campos(descricao);
		if(aprovado) {
			System.out.println("Aprovado");
		}
		else {
			System.out.println("Nooooob");
		}
	}
	
    @Override
    public Response handleRequest(Request request, Context context) {
    	boolean aprovado = false;
    	try {
			aprovado = limpa_campos(request.nome + " " + request.descricao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(aprovado) {
    		JSONObject data = new JSONObject();
            try {
            	data.put("a_venda", request.a_venda);
				data.put("nome", request.nome);
				data.put("foto", request.foto);
				data.put("marca", request.marca);
				data.put("tamanho", request.tamanho);
				data.put("descricao", request.descricao);
				data.put("categoria", request.categoria);
				data.put("frete", request.frete);
				data.put("condicao", request.condicao);
				data.put("preco", request.preco);
				data.put("desconto", request.desconto);
				data.put("id_comprador", request.id_comprador);
				data.put("id_produto", request.id_produto);
				data.put("id_vendedor", request.id_vendedor);
				data.put("qtde_curtidas", request.qtde_curtidas);
				data.put("tags", request.tags);
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
	            String a = answer.getString("response");
	            if(a == "ok") {
	            	return new Response("Cadastro realizado com sucesso", "aprovado");
	            }
	            
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
    	}

        return new Response("Cadastro nao sucedido", "reprovado");
    }

    static public boolean limpa_campos(String s) throws Exception{
        JSONObject data = new JSONObject();
        data.put("description", s);
        
        URL url = new URL("https://3pf8dr4ds6.execute-api.us-east-1.amazonaws.com/ChecaEmail");
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
        if(a.equals("se fudeu arrombado")){
        	return false;
        }
        return true;
    }
    
    


}
