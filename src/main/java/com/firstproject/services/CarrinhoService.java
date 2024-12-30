package com.firstproject.services;

import com.firstproject.CarrinhoException;
import com.firstproject.DtoEntradaCarrinho;
import com.firstproject.models.Carrinho;
import com.firstproject.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {
    @Autowired
    public CarrinhoRepository carrinhoRepository;

    @Autowired
    public UsuarioService usuarioService;

    @Autowired
    public ProdutoService produtoService;

    public List<Carrinho> ListarCarrinhos(){

        var carrinhos = carrinhoRepository.findAll();

        return carrinhos;
    }

    public List<Carrinho> ListarPorIdUsuario(Long id){

        var usuario = usuarioService.ListarPorIdUsuario(id);

        var carrinho = carrinhoRepository.findByUsuario(usuario);

        return carrinho;
    }

    public Carrinho AdicionarCarrinho(DtoEntradaCarrinho carrinho){

        var verificaSePossuiProdutoNoCarrinho = carrinhoRepository.findByUsuarioAndProduto(
                usuarioService.ListarPorIdUsuario(carrinho.usuario()),
                produtoService.ListarPorIdProduto(carrinho.produto())
        );

        if(verificaSePossuiProdutoNoCarrinho != null){
            verificaSePossuiProdutoNoCarrinho.setQuantidade(
                    verificaSePossuiProdutoNoCarrinho.getQuantidade() + carrinho.quantidade()
            );

            carrinhoRepository.save(verificaSePossuiProdutoNoCarrinho);

            return  verificaSePossuiProdutoNoCarrinho;
        }

        var carrinhoAdicionar = new Carrinho();
        carrinhoAdicionar.setUsuario(
                usuarioService.ListarPorIdUsuario(carrinho.usuario())
        );
        carrinhoAdicionar.setProduto(
                produtoService.ListarPorIdProduto(carrinho.produto())
        );
        carrinhoAdicionar.setQuantidade(carrinho.quantidade());

        carrinhoRepository.save(carrinhoAdicionar);

        return carrinhoAdicionar;
    }

    public Carrinho EditarCarrinho(DtoEntradaCarrinho carrinho){

        var verificaSePossuiProdutoNoCarrinho = carrinhoRepository.findByUsuarioAndProduto(
                usuarioService.ListarPorIdUsuario(carrinho.usuario()),
                produtoService.ListarPorIdProduto(carrinho.produto())
        );

        if(verificaSePossuiProdutoNoCarrinho != null){
            verificaSePossuiProdutoNoCarrinho.setQuantidade(
                    verificaSePossuiProdutoNoCarrinho.getQuantidade() - carrinho.quantidade()
            );

            if(verificaSePossuiProdutoNoCarrinho.getQuantidade() <= 0){
                ExcluirCarrinho(verificaSePossuiProdutoNoCarrinho.getId());

                throw new CarrinhoException("Item excluído do carrinho");
            }
        }

        carrinhoRepository.save(verificaSePossuiProdutoNoCarrinho);

        return verificaSePossuiProdutoNoCarrinho;
    }

    public Carrinho ExcluirCarrinho(Long id){

        var carrinhoExcluir = carrinhoRepository.findById(id).get();

        carrinhoRepository.delete(carrinhoExcluir);

        return carrinhoExcluir;
    }
}
