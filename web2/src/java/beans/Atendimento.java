/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Ana Nicole
 */
public class Atendimento implements Serializable{
    private int id;
    private String descricao, solucao, cliente;
    private Date abertura, fim;
    private boolean situacao;
    private Produto produto = new Produto();
    private Categoria categoria = new Categoria();
    private Tipo tipo = new Tipo();
    
    public Atendimento() {
    }

    public Atendimento(int id, Tipo tipo, String descricao, String solucao, String cliente, Date abertura, Date fim, boolean situacao, Produto produto, Categoria categoria) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.solucao = solucao;
        this.cliente = cliente;
        this.abertura = abertura;
        this.fim = fim;
        this.situacao = situacao;
        this.produto = produto;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoId() {
        return tipo.getId();
    }
    
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = new Tipo(tipo);
    }
    
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getAbertura() {
        return abertura;
    }

    public void setAbertura(Date abertura) {
        this.abertura = abertura;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public int getProdutoId() {
        return produto.getId();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public void setProduto(int produto) {
        this.produto = new Produto(produto);
    }

    public int getCategoriaId() {
        return categoria.getId();
    }
    
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void setCategoria(int categoria) {
        this.categoria = new Categoria(categoria);
    }

   
}
