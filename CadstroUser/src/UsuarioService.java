import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    //Metodos para manipular a lista de usuarios

    public boolean cadastrarUsuario(Usuario usuario) {

        if (usuario == null) {
            return false;
        }

        if (usuario.getIdade() <18 || usuario.getIdade() > 120) {
            return false;
        }

        if (usuario.getEmail() == null || !usuario.getEmail().contains("@")) {
            return false;
        }

        if (buscarPorEmail(usuario.getEmail())!= null){
            return false;
        }

        usuarios.add(usuario);
        return true;
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuariosAtivos = new ArrayList<>();

        for (Usuario usuario : usuarios) {
            if (usuario.getStatus() == StatusUsuario.ATIVO || usuario.getStatus() == StatusUsuario.BLOQUEADO) {
                usuariosAtivos.add(usuario);
            }
        }

        return usuariosAtivos;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
           if (email != null && email.equals(usuario.getEmail())) {
                return usuario;
            }
        }
        return null;
    
    }

    public boolean removerPorEmail(String email) {
    Usuario usuario = buscarPorEmail(email);

        if (usuario == null) {
            return false;
        }
        
        if (usuario.getStatus() == StatusUsuario.INATIVO) {
            return false;
        }

        usuario.setStatus(StatusUsuario.INATIVO);
        return true;
    }

    public boolean bloquearUsuario(String email) {
        Usuario usuario = buscarPorEmail(email);

        if (usuario == null) {
            return false;
        }

        if (usuario.getStatus() == StatusUsuario.INATIVO) {
            return false;
        }

        if (!usuario.getStatus().podeAtualizar()) {
            return false;
        }

        usuario.setStatus(StatusUsuario.BLOQUEADO);
        return true;
    }

    public boolean desbloquearUsuario(String email) {
    Usuario usuario = buscarPorEmail(email);

    if (usuario == null) {
        return false;
    }

    if (!usuario.getStatus().podeSerDesbloqueado()) {
        return false;
    }

    usuario.setStatus(usuario.getStatus().desbloquear());
    return true;
}

    public boolean atualizarUsuario(String emailAntigo, String novoNome, int novaIdade, String novoEmail) {
        Usuario usuario = buscarPorEmail(emailAntigo);

        if (usuario == null) {
            return false;
        }

        if (novaIdade < 18 || novaIdade > 120) {
            return false;
        }

        if (novoEmail == null || !novoEmail.contains("@")) {
            return false;
        }

        if (!emailAntigo.equals(novoEmail) && buscarPorEmail(novoEmail) != null) {
            return false;
        }

        usuario.setNome(novoNome);
        usuario.setIdade(novaIdade);
        usuario.setEmail(novoEmail);

        return true;
    }
}


