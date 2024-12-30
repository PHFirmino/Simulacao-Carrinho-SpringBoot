package com.firstproject.repository;

import com.firstproject.models.Produto;
import com.firstproject.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public List<Usuario> findByNomeLike(String nome);
}
