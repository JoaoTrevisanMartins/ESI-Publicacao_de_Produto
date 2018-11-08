package Deletador;

import com.amazonaws.services.lambda.runtime.RequestHandler;

import Cadastrador.Request;

import com.amazonaws.services.lambda.runtime.Context;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class DeletadorHandler implements RequestHandler<Request, Response> {

	@Override
	public Response handleRequest(Request request, Context context) {

		JSONObject data = new JSONObject();
		try {
			
			data.put("id_produto", request.getId_produto());
			
			URL url = new URL("https://dnetix.co/ping");
			HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("DELETE");
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
			if (a == "ok") {
				return new Response("Exclusao realizado com sucesso", "aprovado");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Response("Exclusao nao sucedido", "reprovado");
	}

}
