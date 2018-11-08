package Cadastrador;

public class Testador {
	public static void main(String []args) throws Exception {
		/*String descricao = "asdsdf@usp.br";
		boolean aprovado = limpa_campos(descricao);
		if(aprovado) {
			System.out.println("Aprovado");
		}
		else {
			System.out.println("Nooooob");
		}
		*/
		String [] fotos = {"lskdjflksjdf", "asdfdfg"};
		String [] tags = {"retro"};
		Request request = new Request("camiseta confortavel", "MC Igu", "grande", "camiseta bem confortavel", "camiseta", "sem frete", "bom estado", 50, 20, 42, 2, 3, 0, true, fotos, tags);
		CadastradorHandler cadastrador = new CadastradorHandler();
		Response response = cadastrador.handleRequest(request, null);
		System.out.println(response.message + " " + response.status);
	}
}
