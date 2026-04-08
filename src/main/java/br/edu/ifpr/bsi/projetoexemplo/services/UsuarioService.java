package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.mappers.UsuarioMapper;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.Usuario;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioDetailDTO;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.UsuarioRequestDTO;
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
    private UsuarioMapper usuarioMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioDetailDTO salvar(UsuarioRequestDTO request) {
        if (this.usuarioRepository.findByUsername(request.username()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!");
        }
        Usuario usuario = this.usuarioMapper.requestDTOToEntity(request);
        usuario.setPassword(this.passwordEncoder.encode(request.password()));
        return this.usuarioMapper.entityToDetailDTO(this.usuarioRepository.save(usuario));
    }

    @Transactional
    public UsuarioDetailDTO atualizar(Long codigo, UsuarioRequestDTO request) {
        Usuario existente = this.usuarioRepository.findById(codigo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Usuario usuario = this.usuarioMapper.requestDTOToEntity(request);

        if (usuario.getPassword() != null) {
            existente.setPassword(this.passwordEncoder.encode(request.password()));
        }
        existente.setUsername(usuario.getUsername());
        return this.usuarioMapper.entityToDetailDTO(this.usuarioRepository.save(usuario));
    }
}