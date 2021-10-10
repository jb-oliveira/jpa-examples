package com.jb.example.dao;

import com.jb.example.vo.ProdutoVO;
import com.jb.example.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Produto produto) {
        this.em.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return this.em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "select p from Produto p";
        TypedQuery<Produto> query = this.em.createQuery(jpql, Produto.class);
        return query.getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nome) {
        return em.createNamedQuery( "Produto.produtosPorCategoria" , Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public ProdutoVO buscarVoPorNome(String nome) {
        String jpql = "SELECT new com.jb.example.vo.ProdutoVO(p.nome,p.preco) " +
                " FROM Produto p " +
                " WHERE p.nome = :nome";
        return em.createQuery(jpql, ProdutoVO.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public List<Produto> buscaDinamica(String nome) {
        return null;
    }
}
