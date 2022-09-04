package claudioESandrade.EnvioMsgTelegram.Service;

import claudioESandrade.EnvioMsgTelegram.Model.Usuario;
import claudioESandrade.EnvioMsgTelegram.Model.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Iterable<Usuario > buscarTodos() {
        // Buscar todos os Usuarios.
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        // Buscar Usuarios por ID.
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(Usuario usuario) {
        salvarUsuario(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        // Buscar Usuario  por ID, caso exista:
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()) {
            salvarUsuario(usuario);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Usuario por ID.
        usuarioRepository.deleteById(id);
    }

    private void salvarUsuario (Usuario usuario) {
        // Salvar Usuario
        usuarioRepository.save(usuario);
    }




}
