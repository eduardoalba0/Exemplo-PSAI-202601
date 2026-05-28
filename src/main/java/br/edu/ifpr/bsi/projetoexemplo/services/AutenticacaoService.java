package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.adapters.UserAdapter;
import br.edu.ifpr.bsi.projetoexemplo.mappers.UsuarioMapper;
import br.edu.ifpr.bsi.projetoexemplo.model.usuario.*;
import br.edu.ifpr.bsi.projetoexemplo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsername(username);
        if (usuario == null) throw new UsernameNotFoundException("Usuário não encontrado");
        return new UserAdapter(usuario);
    }

    public LoginResponseDTO login(UsuarioLoginDTO request) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        Authentication auth = authenticationManager.authenticate(authToken);

        UserAdapter adapter = (UserAdapter) auth.getPrincipal();
        String token = tokenService.gerarToken(adapter);

        UsuarioDetailDTO usuario = usuarioMapper.entityToDetailDTO(adapter.getUsuario());

        return new LoginResponseDTO(usuario,token);
    }
}
