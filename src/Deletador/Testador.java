package Deletador;

public class Testador {
	public static void main(String[] args) {
		int id = 6;
		Request request = new Request(id);
		DeletadorHandler deletador = new DeletadorHandler();
		Response response = deletador.handleRequest(request, null);
		System.out.println(response.message + " " + response.status);
	}
}
