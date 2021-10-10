package com.jb.example.dao;

import com.jb.example.model.Categoria;
import com.jb.example.model.Cliente;

import javax.persistence.EntityManager;

public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public void atualizar(Cliente cliente) {
        this.em.merge(cliente);
    }

    public void remover(Cliente cliente) {
        Cliente merge = em.merge(cliente);
        this.em.remove(merge);
    }

    public Cliente buscarPorId(Long id){
        return em.find(Cliente.class, id);
    }
}
