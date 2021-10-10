package com.jb.example;

import com.jb.example.dao.ClienteDao;
import com.jb.example.dao.PedidoDao;
import com.jb.example.vo.RelatorioVendasVO;
import com.jb.example.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class AppPedido {
    public static void main(String[] args) {
        // AppProduto.cadastrarProduto();
        // cadatrarCliente();

        EntityManager em = JpaUtil.getEntityManager();

        PedidoDao pedidoDao = new PedidoDao(em);
//        ClienteDao clienteDao = new ClienteDao(em);
//
//        Produto produto = new ProdutoDao(em).buscarPorId(1l);
//
//
//        Cliente cliente = clienteDao.buscarPorId(1l);
//
//        EntityTransaction transaction = em.getTransaction();
//        transaction.begin();
//        Pedido pedido = new Pedido(cliente);
//
//
//        pedido.adicionarItem(new ItemPedido(10,pedido,produto));
//
//        clienteDao.salvar(cliente);
//        pedidoDao.salvar(pedido);
//
//        transaction.commit();
//
//        BigDecimal valor = pedidoDao.valorTotalVendido();
//        System.out.println("Valor total: " + valor);

        List<RelatorioVendasVO> relatorioVendasVOS = pedidoDao.relatorioDeVendas();
        relatorioVendasVOS.forEach(System.out::println);
    }

    private static void cadatrarCliente() {
        EntityManager em = JpaUtil.getEntityManager();
        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = new Cliente("customer", "11111111111");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        clienteDao.salvar(cliente);
        transaction.commit();
    }
}
