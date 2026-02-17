import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    //Metodos para manipular a lista de usuarios

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public Usuario buscarPorEmail(String email) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }
        return null;
    
    }

    public boolean removerPorEmail(String email) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(email)) {
                usuarios.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean atualizarUsuario(String emailAntigo, String novoNome, int novaIdade, String novoEmail) {
        Usuario usuario = buscarPorEmail(emailAntigo);

        if (usuario != null) {
            usuario.setNome(novoNome);
            usuario.setIdade(novaIdade);
            usuario.setEmail(novoEmail);
            return true;
        }

        return false;
    }
}


