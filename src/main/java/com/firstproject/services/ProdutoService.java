package com.firstproject.services;

import com.firstproject.models.Produto;
import com.firstproject.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    public ProdutoRepository produtoRepository;

    public List<Produto> ListarProdutos(){

        var produtos = produtoRepository.findAll();

        return produtos;
    }

    public Produto ListarPorIdProduto(Long id){

        var produto = produtoRepository.findById(id).get();

        return produto;
    }

    public List<Produto> ListarPorNomeProduto(String nome){

        var produtos = produtoRepository.findByNomeLike("%"+nome+"%");

        return produtos;
    }

    public Produto AdicionarProduto(Produto produto){

        var produtoAdicionar = new Produto();
        produtoAdicionar.setNome(produto.getNome());
        produtoAdicionar.setDescricao(produto.getDescricao());

        produtoRepository.save(produtoAdicionar);

        return produtoAdicionar;
    }

    public Produto EditarProduto(Long id, Produto produto){
        var produtoEditar = produtoRepository.findById(id).get();

        produtoEditar.setNome(produto.getNome());
        produtoEditar.setDescricao(produto.getDescricao());

        produtoRepository.save(produtoEditar);

        return  produto;
    }

    public Produto ExcluirProduto(Long id){
        var produtoExcluir = produtoRepository.findById(id).get();

        produtoRepository.delete(produtoExcluir);

        return produtoExcluir;
    }
}
