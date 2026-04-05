package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.model.Usuario;
import br.edu.ifpr.bsi.projetoexemplo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.findByUsername(usuario.getUsername()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getSenhaLocal()));
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario atualizar(Long codigo, Usuario usuario) {
        Usuario existente = usuarioRepository.findById(codigo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (usuario.getSenhaLocal() != null) {
            existente.setPassword(passwordEncoder.encode(usuario.getSenhaLocal()));
        }
        existente.setUsername(usuario.getUsername());
        return usuarioRepository.save(existente);
    }
}