package com.jb.example;

import com.jb.example.dao.CategoriaDao;
import com.jb.example.dao.ClienteDao;
import com.jb.example.dao.PedidoDao;
import com.jb.example.dao.ProdutoDao;
import com.jb.example.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class ProdutoTest {

    @BeforeAll
    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");

        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);
        Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("8000"), videogames);
        Produto macbook = new Produto("Macbook", "Macboo pro retina", new BigDecimal("14000"), informatica);

        Cliente cliente = new Cliente("Joao", "123456");

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, celular));
        pedido.adicionarItem(new ItemPedido(40, pedido, videogame));

        Pedido pedido2 = new Pedido(cliente);
        pedido2.adicionarItem(new ItemPedido(2, pedido, macbook));

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);

        em.getTransaction().begin();

        categoriaDao.salvar(celulares);
        categoriaDao.salvar(videogames);
        categoriaDao.salvar(informatica);

        produtoDao.salvar(celular);
        produtoDao.salvar(videogame);
        produtoDao.salvar(macbook);

        clienteDao.salvar(cliente);

        pedidoDao.salvar(pedido);
        pedidoDao.salvar(pedido2);

        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testBuscaDinamica() {
        EntityManager entityManager = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        List<Produto> produtos = produtoDao.buscaDinamica("Xiaomi Redmi", null, null);
        Assertions.assertEquals(1, produtos.size());
        Assertions.assertEquals("Xiaomi Redmi", produtos.get(0).getNome());
        produtos = produtoDao.buscaDinamica(null, new BigDecimal("8000"), null);
        Assertions.assertEquals(1, produtos.size());
        Assertions.assertEquals("PS5", produtos.get(0).getNome());
        produtos = produtoDao.buscaDinamica(null, null, LocalDate.now());
        Assertions.assertEquals(3, produtos.size());
    }
}
