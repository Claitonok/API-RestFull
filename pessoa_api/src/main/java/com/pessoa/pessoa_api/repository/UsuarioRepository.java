package com.pessoa.pessoa_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pessoa.pessoa_api.model.Usuario;


// É obrigario esse classe ser uma INTERFACE
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
