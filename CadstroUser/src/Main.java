import java.util.Scanner;

public class Main {

     static Scanner scanner = new Scanner(System.in);
     static UsuarioService service = new UsuarioService();

        public static void main(String[] args) {
            int opcao;

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
                        System.out.println("Digite o nome do usuario:");
                        String nome = scanner.nextLine();

                        System.out.println("Digite a idade do usuario:");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Digite o email do usuario:");
                        String email = scanner.nextLine();

                        Usuario usuario = new Usuario(nome, idade, email);
                        service.cadastrarUsuario(usuario);

                        System.out.println("Usuario cadastrado com sucesso!");
                        break;
                    
                    case 2:
                        if (service.listarUsuarios().isEmpty()) {
                            System.out.println("Nenhum usuario cadastrado!");
                        } else {
                            for (Usuario u : service.listarUsuarios()) {
                                    System.out.println(u);
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Digite o email do usuario que deseja buscar:");
                        String emailBusca = scanner.nextLine();

                        Usuario encontrado = service.buscarPorEmail(emailBusca);
                        if (encontrado != null) {
                            System.out.println("Usuario encontrado: " + encontrado);
                        } else {
                            System.out.println("Usuario nao encontrado!");
                        }
                        break;

                    case 4:
                        System.out.println("Digite o email do usuario que deseja remover:");
                        String emailRemover = scanner.nextLine();

                        if (service.removerPorEmail(emailRemover)) {
                            System.out.println("Usuario removido com sucesso!");
                        } else {
                            System.out.println("Usuario nao encontrado!");
                        }
                        break;

                    case 5:
                        System.out.println("Digite o email do usuario que deseja atualizar:");
                        String emailAtualizar = scanner.nextLine();

                        System.out.println("Novo nome:");
                        String novoNome = scanner.nextLine();

                        System.out.println("Nova idade:");
                        int novaIdade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Novo email:");
                        String novoEmail = scanner.nextLine();

                        if (service.atualizarUsuario(emailAtualizar, novoNome, novaIdade, novoEmail)) {
                            System.out.println("Usuario atualizado com sucesso!");
                        } else {
                            System.out.println("Usuario nao encontrado.");
                        }
                    break;

                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                }
            } while (opcao != 6);

            scanner.close();

        }

}
