package br.edu.ifpr.bsi.projetoexemplo.controllers;

import br.edu.ifpr.bsi.projetoexemplo.model.usuario.LoginRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.LoginResponseDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioRequestDTO;
import br.edu.ifpr.bsi.projetoexemplo.services.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    // Rota de Login (Usa o serviço de Autenticação)
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(autenticacaoService.login(request));
    }
}