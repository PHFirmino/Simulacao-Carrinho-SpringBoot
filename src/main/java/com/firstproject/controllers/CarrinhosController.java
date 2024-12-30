package com.firstproject.controllers;

import com.firstproject.CarrinhoException;
import com.firstproject.DtoEntradaCarrinho;
import com.firstproject.models.Carrinho;
import com.firstproject.models.Produto;
import com.firstproject.services.CarrinhoService;
import com.firstproject.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CarrinhosController {

    @Autowired
    public CarrinhoService carrinhoService;

    @GetMapping("/listar-carrinhos")
    public ResponseEntity<List<Carrinho>> ListarCarrinhos(){
        var listarCarrinhos = carrinhoService.ListarCarrinhos();

        return ResponseEntity.ok(listarCarrinhos);
    }

    @GetMapping("/listar-por-id-usuario/{id}")
    public ResponseEntity<List<Carrinho>> ListarPorIdUsuarioCarrinho(@PathVariable Long id){
        var listarPorIdUsuarioCarrinho = carrinhoService.ListarPorIdUsuario(id);

        return ResponseEntity.ok(listarPorIdUsuarioCarrinho);
    }

    @PostMapping("/adicionar-ao-carrinho")
    public ResponseEntity<Carrinho> AdicionarCarrinho(@RequestBody DtoEntradaCarrinho carrinho){
        var carrinhoAdicionado = carrinhoService.AdicionarCarrinho(carrinho);

        return ResponseEntity.ok(carrinhoAdicionado);
    }

    @PostMapping("/remover-do-carrinho")
    public ResponseEntity EditarCarrinho(@RequestBody DtoEntradaCarrinho carrinho){

        try{
            var carrinhoEditado = carrinhoService.EditarCarrinho(carrinho);
            return ResponseEntity.ok(carrinhoEditado);
        }
        catch (CarrinhoException e){
            return ResponseEntity.ok(e.getMessage());
        }

    }
}
