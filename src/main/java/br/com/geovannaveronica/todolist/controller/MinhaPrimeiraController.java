package br.com.geovannaveronica.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



// http://localhost:8080/
@RestController
@RequestMapping("/primeiraRota")
public class MinhaPrimeiraController {

    /**
     * Métodos de acesso de uma requisição do HTTP
     * GET - Buscar uma informação
     * POST - Adicionar um dado/informação
     * PUT - Alterar um dado/info
     * DELETE - Remover um dado
     * PATCH - Alterar somente uma parte da info/dado
     */

     // Método (Funcionalidade) de uma classe
     @GetMapping("/")
    public String primeiraMensagem() {
        return "Funcionou";
    }
    
}
