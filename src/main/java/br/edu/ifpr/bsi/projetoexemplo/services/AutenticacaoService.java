package br.edu.ifpr.bsi.projetoexemplo.services;

import br.edu.ifpr.bsi.projetoexemplo.adapters.UserAdapter;
import br.edu.ifpr.bsi.projetoexemplo.model.Usuario;
import br.edu.ifpr.bsi.projetoexemplo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repository.findByUsername(username);
        if (usuario == null) throw new UsernameNotFoundException("Usuário não encontrado");
        return new UserAdapter(usuario);
    }

    public HashMap<String, Object> login(Usuario usuario) {
        HashMap<String, Object> resposta = new HashMap<>();
        Authentication authToken = new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getSenhaLocal());
        Authentication auth = authenticationManager.authenticate(authToken);

        UserAdapter adapter = (UserAdapter) auth.getPrincipal();
        String token = tokenService.gerarToken(adapter);

        resposta.put("token", token);
        resposta.put("usuario", adapter.getUsuario());

        return resposta;
    }
}
