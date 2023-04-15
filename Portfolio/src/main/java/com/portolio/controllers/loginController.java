package com.portolio.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.portolio.entities.Usuario;
import com.portolio.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuarios")
public class loginController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping(value = "/registrarUsuario")
    public ResponseEntity<Usuario> registrarNovoUsuario(@RequestParam String email, @RequestParam String nome,
                                       @RequestParam String senha, @RequestParam String bio,
                                       @RequestParam String tipo,  @RequestParam String estado, UriComponentsBuilder uriComponentsBuilder) {

        Usuario usuario = new Usuario(email,nome,senha,bio,tipo,estado);

        usuario = usuarioRepository.saveAndFlush(usuario);

        URI uri = uriComponentsBuilder.path("/usuarios/{id}").build(usuario.getAutoId());


        return uri;



   }



}
