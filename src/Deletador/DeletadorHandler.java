package Deletador;

import com.amazonaws.services.lambda.runtime.RequestHandler;


import com.amazonaws.services.lambda.runtime.Context;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DeletadorHandler implements RequestHandler<Request, Response> {

	@Override
	public Response handleRequest(Request request, Context context) {

		try {
			
			int id = request.getId_produto();
			
			URL url = new URL("https://dry-escarpment-83331.herokuapp.com/produto/" + id);
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("DELETE");
			httpConnection.setRequestProperty(
				    "Content-Type", "application/x-www-form-urlencoded" );
			httpConnection.connect();

			
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
//			JSONObject answer = new JSONObject(content);
//			String a = answer.getString("response");
			System.out.println(content);
			if (flag) {
				return new Response("Exclusao realizado com sucesso", "aprovado");
			}
			return new Response("Exclusao nao sucedido", "reprovado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Response("Exclusao nao sucedido", "reprovado");
	}

}
