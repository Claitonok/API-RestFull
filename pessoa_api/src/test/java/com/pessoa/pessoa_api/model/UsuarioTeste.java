package com.pessoa.pessoa_api.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class UsuarioTeste {


    @TestConfiguration
    static class test_Usuario{

        @Bean
        public Usuario usuario(){
            return new Usuario(null, null, null);
        }
    }

    /**
     * Tag que carrega a minha class para conseguir instanciar em outro lugares
     * @Autowired
    */
    @Autowired
    Usuario usuario;

// ------------------------------------------------------------

    /**
     * Tag para efetuar um teste do metodo!!
     *  @Test
     */
    @Test
    public void test(){
        Usuario usuario = new Usuario(null, null, null);
        /**
         * Teste pelo spring boot para testar metodos dessa forma!
        */ 
        //Primeiro parametro e oque e esperado | O segundo parametro e oque eu coloco!!
        Assertions.assertEquals(usuario, usuario);
    }


}
