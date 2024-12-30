package com.firstproject.controllers;

import com.firstproject.models.Produto;
import com.firstproject.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutosController {
    @Autowired
    public ProdutoService produtoService;

    @GetMapping("/listar-produtos")
    public ResponseEntity<List<Produto>> ListarProdutos(){
        var listarProdutos = produtoService.ListarProdutos();

        return ResponseEntity.ok(listarProdutos);
    }

    @GetMapping("/listar-por-id-produto/{id}")
    public ResponseEntity<Produto> ListarPorIdProduto(@PathVariable Long id){
        var listarPorIdProduto = produtoService.ListarPorIdProduto(id);

        return ResponseEntity.ok(listarPorIdProduto);
    }

    @GetMapping("/listar-por-nome-produtos")
    public ResponseEntity<List<Produto>> ListarPorNomeProduto(@RequestParam String nome){
        var listarPorNomeProduto = produtoService.ListarPorNomeProduto(nome);

        return ResponseEntity.ok(listarPorNomeProduto);
    }

    @PostMapping("/adicionar-produto")
    public ResponseEntity<Produto> AdicionarProduto(@RequestBody Produto produto){
        var produtoAdicionado = produtoService.AdicionarProduto(produto);

        return ResponseEntity.ok(produtoAdicionado);
    }

    @PutMapping("/editar-produto/{id}")
    public ResponseEntity<Produto> EditarProduto(@PathVariable Long id, @RequestBody Produto produto){
        var produtoEditado = produtoService.EditarProduto(id, produto);

        return ResponseEntity.ok(produtoEditado);
    }

    @DeleteMapping("/excluir-produto/{id}")
    public ResponseEntity<Produto> ExcluirProduto(@PathVariable Long id){
        var produtoExcluido = produtoService.ExcluirProduto(id);

        return ResponseEntity.ok(produtoExcluido);
    }
}
