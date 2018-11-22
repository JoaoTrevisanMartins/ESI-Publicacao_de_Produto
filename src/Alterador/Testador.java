package Alterador;



public class Testador {
	public static void main(String[] args) {
		String [] fotos = {"lskdjflksjdf", "asdfdfg"};
		String [] tags = {"retro"};
		Request request = new Request("camiseta confortavel 2", "MC Igu", "medio", "camiseta bem confortavel", "camiseta", "sem frete", "bom estado", 60, 20, 42, 8, 3, 0, true, fotos, tags);
		AlteradorHandler cadastrador = new AlteradorHandler();
		Response response = cadastrador.handleRequest(request, null);
		System.out.println(response.message + " " + response.status);
	}
	
}
