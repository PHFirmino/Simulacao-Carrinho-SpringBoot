package com.firstproject.services;

import com.firstproject.models.Produto;
import com.firstproject.models.Usuario;
import com.firstproject.repository.ProdutoRepository;
import com.firstproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    public UsuarioRepository usuarioRepository;

    public List<Usuario> ListarUsuarios(){

        var usuarios = usuarioRepository.findAll();

        return usuarios;
    }

    public Usuario ListarPorIdUsuario(Long id){

        var usuario = usuarioRepository.findById(id).get();

        return usuario;
    }

    public List<Usuario> ListarPorNomeUsuarios(String nome){

        var usuarios = usuarioRepository.findByNomeLike("%"+nome+"%");

        return usuarios;
    }

    public Usuario AdicionarUsuario(Usuario usuario){

        var usuarioAdicionar = new Usuario();
        usuarioAdicionar.setNome(usuario.getNome());

        usuarioRepository.save(usuarioAdicionar);

        return usuarioAdicionar;
    }

    public Usuario EditarUsuario(Long id, Usuario usuario){
        var usuarioEditar = usuarioRepository.findById(id).get();

        usuarioEditar.setNome(usuario.getNome());

        usuarioRepository.save(usuarioEditar);

        return  usuarioEditar;
    }

    public Usuario ExcluirUsuario(Long id){
        var usuarioExcluir = usuarioRepository.findById(id).get();

        usuarioRepository.delete(usuarioExcluir);

        return usuarioExcluir;
    }
}
