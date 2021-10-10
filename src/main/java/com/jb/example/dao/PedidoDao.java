package com.jb.example.dao;


import com.jb.example.vo.RelatorioVendasVO;
import com.jb.example.model.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Pedido pedido) {
        this.em.persist(pedido);
    }

    public Pedido buscarPorId(Long id) {
        return this.em.find(Pedido.class, id);
    }

    public List<Pedido> buscarTodos() {
        String jpql = "select p from Pedido p";
        TypedQuery<Pedido> query = this.em.createQuery(jpql, Pedido.class);
        return query.getResultList();
    }

    public BigDecimal valorTotalVendido(){
        String jpql = "select sum(p.valorTotal) from Pedido p";
        return this.em
                .createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<RelatorioVendasVO> relatorioDeVendas(){
        String jpql = "select new com.jb.example.vo.RelatorioVendasVO(" +
                "produto.nome," +
                "sum(item.quantidade) as qtd," +
                "MAX(pedido.data) ) " +
                "from Pedido pedido " +
                "join pedido.itens item " +
                "join item.produto produto " +
                "group by produto.nome " +
                "order by qtd";
        return this.em
                .createQuery(jpql, RelatorioVendasVO.class)
                .getResultList();
    }

}
