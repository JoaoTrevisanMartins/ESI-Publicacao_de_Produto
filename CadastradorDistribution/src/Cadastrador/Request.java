package Cadastrador;

public class Request {
    String nome,foto,marca,tamanho,cor,departamento,descricao,categoria,tendencias,frete,condicao   ;
    double preco,desconto;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getNome() {
        return nome;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTendencias() {
        return tendencias;
    }

    public void setTendencias(String tendencias) {
        this.tendencias = tendencias;
    }

    public String getFrete() {
        return frete;
    }

    public void setFrete(String frete) {
        this.frete = frete;
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


    public Request(String nome, String foto, String marca, String tamanho, String cor, String departamento, String descricao, String categoria, String tendencias, String frete, String condicao, double preco, double desconto) {
        this.nome = nome;
        this.foto = foto;
        this.marca = marca;
        this.tamanho = tamanho;
        this.cor = cor;
        this.departamento = departamento;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tendencias = tendencias;
        this.frete = frete;
        this.condicao = condicao;
        this.preco = preco;
        this.desconto = desconto;
    }

    public Request() {
    }
}
