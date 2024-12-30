package com.firstproject.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "produtoId", referencedColumnName = "id")
    public Produto produto;

    @ManyToOne
    @JoinColumn(name = "usuarioId", referencedColumnName = "id")
    public Usuario usuario;

}
