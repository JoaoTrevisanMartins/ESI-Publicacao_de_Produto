import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context; 


public class LimpadorHandler implements RequestHandler<Request, Response> {

	@Override
	public Response handleRequest(Request request, Context context) {
		if(Limpador.match_description(request.description)){
			return new Response("boa arrombado");
		}
		return new Response("se fudeu arrombado");
	}

}
