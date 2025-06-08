package com.pessoa.pessoa_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


    @Entity //ELE FAZ COM OQUE A CLASSE SEJA ULTILIZADA PARA CRIAR A TABELA NO BANCO DE DADOS
    public class Usuario {

     //#region
    @Id //VAI TRANSFORMAR O ID EM PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.AUTO) //serve para dizer que o id sera auto_increment
    private Integer id;
    private String nome;
    private String email;
    private String password;
    //#endregion

    // server para cadastar
    public Usuario(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    // serve para editar
    public Usuario(Integer id, String nome, String email, String password) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    // serve para adicionar 
    public Usuario() {}


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
}
