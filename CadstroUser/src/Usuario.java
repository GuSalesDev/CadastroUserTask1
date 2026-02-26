public class Usuario {
    
    // Atributos da classe Usuario

    private String nome;
    private int idade;
    private String email;
    private StatusUsuario status;

    //Contrutor da classe Usuario

    public Usuario(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.status = StatusUsuario.ATIVO;
    }

    //Getters e Setters para os atributos da classe Usuario

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StatusUsuario getStatus() {
        return status;
    }

    public void setStatus(StatusUsuario status) {
        this.status = status;
    }

    // Metodo tostring sobrescrito para exibir as informações do usuario de forma legivel

    @Override
public String toString() {
    return "Usuario:\n" +
           "Nome: " + nome + "\n" +
           "Idade: " + idade + "\n" +
           "Email: " + email + "\n";
    }

}
