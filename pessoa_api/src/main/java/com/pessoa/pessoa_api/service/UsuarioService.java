package com.pessoa.pessoa_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.pessoa_api.model.Usuario;
import com.pessoa.pessoa_api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Metodo obterTodos
     * @return retorna todos os Usuarios
     */
    public List<Usuario> ObterTodos(){
        List<Usuario> usuario = usuarioRepository.findAll();
        return usuario;
    }

    /**
     * Metodo que pega por ID
     * @param id Esse metodo pede que seja passado um id
     * @return retorna uma dados por id
     */
    public Optional<Usuario> ObterPorId(Integer id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            System.err.println("Não foi passado o id: " + id + "do usuario");
        }
        return usuario;
    }

    /**
     * Metodo que ADICIONAR UM USUARIO
     * @param usuario
     * @return retorna o usuario cadastrado
     */
    public Usuario Adicionar(Usuario usuario){

        Usuario usuario2 = new Usuario();
        usuario2 = usuarioRepository.save(usuario);

        return usuario2;
    }

    /** Metodo que deletar o usuario
     * @param id 
     */
    public void deletar(Integer id){

        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            System.err.println("O id do usuario precisa ser passado: " + id + "Ou não encontramos seu id");
        }

        usuarioRepository.deleteById(id);
    }

    
     /**
     * Metodo para atualizar o Produto.
     * @param produto que será para atualizar.
     *  @param id do Produto para atualizar o sistema.
     * @return Retorna um valor atualizado.
     */
    public Usuario atualizaUsuario(Integer id, Usuario usuario){

        usuario.setId(id);
        Usuario resposta = new Usuario();
        resposta = usuarioRepository.save(usuario);

        return resposta;
    }

}
