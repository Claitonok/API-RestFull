package com.pessoa.pessoa_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoa.pessoa_api.model.Usuario;
import com.pessoa.pessoa_api.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * 
     * @return RETORNA TODOS OS DADOS DO BANCO DE DADOS
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> obetrUsuarios(){
        return new ResponseEntity<>(usuarioService.ObterTodos(), HttpStatus.OK);
    }


    /**
     * ESSE METODO ESPERA PASSAR O {id}:
     * @param id 
     * @return RETORNA OS DADOS DO BANCO DE DADOS PELO {id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> obterPorId(@PathVariable Integer id){
        return new ResponseEntity<>(usuarioService.ObterPorId(id), HttpStatus.OK);
    }


    /**
     * ESSE METODO SERVE PARA CADASTRAR POR ISSO DO @PostMapping
     * LEMBRAR DE PASSAR POR PARAMETRO NO METODO O @RequestBody NOME_DA_CLASSE | APELIDO DA CLASSE!!
     * @param usuario
     * @return
     */
    @PostMapping
    public ResponseEntity<Usuario> adicionar(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(usuarioService.Adicionar(usuario), HttpStatus.CREATED);
    }   

    /**
     * ESSE METODO ELE SERVE PARA EXCLUIR DO BANCO DE DADOS PELO id
     * @param id ESPERA PASSAR O {id} PELA URI
     * @return RETORNA O STATUS DE EXCLUSÃO
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deletar(@PathVariable Integer id){
        usuarioService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    

    /**
     * ESSE METOOO ELE ATUALIZA PELO {id} PASSADO PELA URI
     * @param usuario
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario, @PathVariable Integer id){

        try {
            return new ResponseEntity<>(usuarioService.atualizaUsuario(id, usuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
