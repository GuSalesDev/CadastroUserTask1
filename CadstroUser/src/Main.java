import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     
    static ArrayList<Usuario> usuarios = new ArrayList<>(); 
     static Scanner scanner = new Scanner(System.in); 

        public static void main(String[] args) {
            int opcao = 0;
            do {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Cadastrar Usuario");
                System.out.println("2 - Listar Usuarios");
                System.out.println("3 - Buscar Usuario");
                System.out.println("4 - Remover Usuario");
                System.out.println("5 - Atualizar Usuario");
                System.out.println("6 - Sair");
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
                        buscarUsuario();
                        break;
                    case 4:
                        removerUsuario();
                        break;
                    case 5:
                        atualizarUsuario();
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                }
            } while (opcao != 6);

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

        public static void buscarUsuario() {
            System.out.println("Digite o email:");
            String email = scanner.nextLine();
            Usuario usuario = buscarPorEmail(email);
                if (usuario != null) {
                    System.out.println(usuario);
             } else {
                System.out.println("Usuario nao encontrado.");
            }
        }

        public static Usuario buscarPorEmail(String email) {
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equalsIgnoreCase(email)) {
                    return usuario;
                }
        }
        return null;
        }

        public static void removerUsuario() {
            System.out.println("Digite o email:");
            String email = scanner.nextLine();
            if (removerPorEmail(email)) {
                System.out.println("Usuario removido com sucesso!");
            } else {
                System.out.println("Usuario nao encontrado.");
            }
        }       

        public static boolean removerPorEmail(String email) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getEmail().equalsIgnoreCase(email)) {
                    usuarios.remove(i);
                    return true;
                }
            }
            return false;
        }

        public static void atualizarUsuario() {
            System.out.println("Digite o email:");
            String email = scanner.nextLine();
            Usuario usuario = buscarPorEmail(email);
            if (usuario != null) {
                System.out.println("Digite o novo nome do usuario:");
                String nomeNovo = scanner.nextLine();
                System.out.println("Digite a nova idade do usuario:");
                int idadeNova = scanner.nextInt();
                System.out.println("Digite o novo email do usuario:");
                String emailNovo = scanner.nextLine();
                scanner.nextLine(); 
                usuario.setNome(nomeNovo);
                usuario.setIdade(idadeNova);
                usuario.setEmail(emailNovo);
                System.out.println("Usuario atualizado com sucesso!");
            } else {
                System.out.println("Usuario nao encontrado.");
            }
        }

}
