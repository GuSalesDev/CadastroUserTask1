import java.util.ArrayList;
import java.util.Scanner;

public class App {
     
    static ArrayList<Usuario> usuarios = new ArrayList<>(); 
     static Scanner scanner = new Scanner(System.in); 

        public static void main(String[] args) {
            int opcao = 0;
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Cadastrar Usuario");
                System.out.println("2 - Listar Usuarios");
                System.out.println("3 - Sair");
                opcao = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcao) {
                    case 1:
                        cadastrarUsuario();
                        break;
                    case 2:
                        listarUsuarios();
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                }
            } while (opcao != 3);

        }

        public static void cadastrarUsuario() {
            System.out.println("Digite o nome do usuario:");
            String nome = scanner.nextLine();
            System.out.println("Digite a idade do usuario:");
            int idade = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("Digite o email do usuario:");
            String email = scanner.nextLine();
            Usuario usuario = new Usuario(nome, idade, email);
            usuarios.add(usuario);
            System.out.println("Usuario cadastrado com sucesso!");


        }

        public static void listarUsuarios() {
    if (usuarios.isEmpty()) {
        System.out.println("Nenhum usuario cadastrado.");
    } else {
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }
}


}
