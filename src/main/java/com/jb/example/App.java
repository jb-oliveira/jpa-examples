package com.jb.example;

import com.jb.example.dao.CategoriaDao;
import com.jb.example.dao.ProdutoDao;
import com.jb.example.dto.ProdutoDTO;
import com.jb.example.model.Categoria;
import com.jb.example.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        // cadastrarProduto();
        ProdutoDao produtoDao = new ProdutoDao(JpaUtil.getEntityManager());

        List<Produto> produtos = produtoDao.buscarTodos();
        produtos.forEach(p -> System.out.println(p.getNome()));

        BigDecimal preco = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi Redmi");
        System.out.println("Preço : " + preco);

        ProdutoDTO xiaomi_redmi = produtoDao.buscarDtoPorNome("Xiaomi Redmi");
        System.out.println(xiaomi_redmi);
    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares);


        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        categoriaDao.salvar(celulares);
        produtoDao.salvar(celular);
        transaction.commit();
        em.close();
    }

}
