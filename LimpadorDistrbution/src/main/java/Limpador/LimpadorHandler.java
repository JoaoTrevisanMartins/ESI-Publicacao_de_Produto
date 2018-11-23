package Limpador;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context; 


public class LimpadorHandler implements RequestHandler<Request, Response> {

	@Override
	public Response handleRequest(Request request, Context context) {
		if(Limpador.match_email(request.description)){
			return new Response("Campo com problemas. Tem um email no campo");
		} else if(Limpador.match_celphone(request.description)){
			return new Response("Campo com problemas. Tem um numero de celular no campo");
		} else if(Limpador.match_address(request.description)){
			return new Response("Campo com problemas. Tem um endereco no campo");
		} else {
			return new Response("Campo limpo");
		}
	}
}
