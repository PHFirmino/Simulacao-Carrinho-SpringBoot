package com.firstproject.controllers;

import com.firstproject.models.Produto;
import com.firstproject.models.Usuario;
import com.firstproject.services.ProdutoService;
import com.firstproject.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {
    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/listar-usuarios")
    public ResponseEntity<List<Usuario>> ListarUsuarios(){
        var listarUsuarios = usuarioService.ListarUsuarios();

        return ResponseEntity.ok(listarUsuarios);
    }

    @GetMapping("/listar-por-id-usuario/{id}")
    public ResponseEntity<Usuario> ListarPorIdUsuario(@PathVariable Long id){
        var listarPorIdUsuario = usuarioService.ListarPorIdUsuario(id);

        return ResponseEntity.ok(listarPorIdUsuario);
    }

    @GetMapping("/listar-por-nome-usuarios")
    public ResponseEntity<List<Usuario>> ListarPorNomeUsuarios(@RequestParam String nome){
        var listarPorNomeUsuarios = usuarioService.ListarPorNomeUsuarios(nome);

        return ResponseEntity.ok(listarPorNomeUsuarios);
    }

    @PostMapping("/adicionar-usuario")
    public ResponseEntity<Usuario> AdicionarUsuario(@RequestBody Usuario usuario){
        var usuarioAdicionado = usuarioService.AdicionarUsuario(usuario);

        return ResponseEntity.ok(usuarioAdicionado);
    }

    @PutMapping("/editar-usuario/{id}")
    public ResponseEntity<Usuario> EditarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        var usuarioEditado = usuarioService.EditarUsuario(id, usuario);

        return ResponseEntity.ok(usuarioEditado);
    }

    @DeleteMapping("/excluir-usuario/{id}")
    public ResponseEntity<Usuario> ExcluirUsuario(@PathVariable Long id){
        var usuarioExcluido = usuarioService.ExcluirUsuario(id);

        return ResponseEntity.ok(usuarioExcluido);
    }
}
