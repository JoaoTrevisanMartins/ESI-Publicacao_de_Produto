package Alterador;

public class Request {
    String nome,marca,tamanho,descricao,categoria,frete,condicao;
	double preco,desconto;
    int id_comprador, id_produto, id_vendedor, qtde_curtidas;
    boolean a_venda;
    String [] foto, tags; 
    
    public Request(String nome, String marca, String tamanho, String descricao, String categoria, String frete,
			String condicao, double preco, double desconto, int id_comprador, int id_produto, int id_vendedor,
			int qtde_curtidas, boolean a_venda, String[] foto, String[] tags) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.tamanho = tamanho;
		this.descricao = descricao;
		this.categoria = categoria;
		this.frete = frete;
		this.condicao = condicao;
		this.preco = preco;
		this.desconto = desconto;
		this.id_comprador = id_comprador;
		this.id_produto = id_produto;
		this.id_vendedor = id_vendedor;
		this.qtde_curtidas = qtde_curtidas;
		this.a_venda = a_venda;
		this.foto = foto;
		this.tags = tags;
	}
    
	public String getNome() {
    	return nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public String getMarca() {
    	return marca;
    }
    public void setMarca(String marca) {
    	this.marca = marca;
    }
    public String getTamanho() {
    	return tamanho;
    }
    public void setTamanho(String tamanho) {
    	this.tamanho = tamanho;
    }
    public String getDescricao() {
    	return descricao;
    }
    public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }
    public String getCategoria() {
    	return categoria;
    }
    public void setCategoria(String categoria) {
    	this.categoria = categoria;
    }
    public String getFrete() {
    	return frete;
    }
    public void setFrete(String frete) {
    	this.frete = frete;
    }
    public String getCondicao() {
    	return condicao;
    }
    public void setCondicao(String condicao) {
    	this.condicao = condicao;
    }
    public double getPreco() {
    	return preco;
    }
    public void setPreco(double preco) {
    	this.preco = preco;
    }
    public double getDesconto() {
    	return desconto;
    }
    public void setDesconto(double desconto) {
    	this.desconto = desconto;
    }
    public int getId_comprador() {
    	return id_comprador;
    }
    public void setId_comprador(int id_comprador) {
    	this.id_comprador = id_comprador;
    }
    public int getId_produto() {
    	return id_produto;
    }
    public void setId_produto(int id_produto) {
    	this.id_produto = id_produto;
    }
    public int getId_vendedor() {
    	return id_vendedor;
    }
    public void setId_vendedor(int id_vendedor) {
    	this.id_vendedor = id_vendedor;
    }
    public int getQtde_curtidas() {
    	return qtde_curtidas;
    }
    public void setQtde_curtidas(int qtde_curtidas) {
    	this.qtde_curtidas = qtde_curtidas;
    }
    public boolean isA_venda() {
    	return a_venda;
    }
    public void setA_venda(boolean a_venda) {
    	this.a_venda = a_venda;
    }
    public String[] getFoto() {
    	return foto;
    }
    public void setFoto(String[] foto) {
    	this.foto = foto;
    }
    public String[] getTags() {
    	return tags;
    }
    public void setTags(String[] tags) {
    	this.tags = tags;
    }

}