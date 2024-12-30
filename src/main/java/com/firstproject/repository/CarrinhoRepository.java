package com.firstproject.repository;

import com.firstproject.models.Carrinho;
import com.firstproject.models.Produto;
import com.firstproject.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    public List<Carrinho> findByUsuario(Usuario usuario);
    public Carrinho findByUsuarioAndProduto(Usuario usuario, Produto produto);
}
