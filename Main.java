import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        int escolha = -1;
        while (escolha != 0){

            menu();
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha){
                case 1: {
                    System.out.print("Insira o ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Insira o titulo: ");
                    String titulo = sc.nextLine();

                    System.out.print("Insira o autor: ");
                    String autor = sc.nextLine();

                    System.out.print("Insira o ano: ");
                    int ano = sc.nextInt();

                    Livro livro = new Livro(id, titulo, autor, ano);
                    biblioteca.adicionarLivro(livro);
                    System.out.println("Cadastrado com sucesso!");
                    break;
                }
                case 2: {
                    System.out.print("Insira o ID: ");
                    int id = sc.nextInt();
                    Livro encontrou = biblioteca.buscarPorID(id);
                    System.out.print(encontrou.toString());
                    break;
                }
                case 3: {
                    biblioteca.listarDisponiveis();
                    break;
                }
                case 4: {
                    System.out.print("Insira o ID: ");
                    int id = sc.nextInt();
                    biblioteca.emprestarLivro(id);
                    System.out.println("Livro emprestado com sucesso!");
                    break;
                }
                case 5: {
                    System.out.print("Insira o ID: ");
                    int id = sc.nextInt();
                    biblioteca.devolverLivro(id);
                    System.out.println("Livro devolvido com sucesso!");
                    break;
                }
                case 6: {
                    System.out.print("Insira o ID: ");
                    int id = sc.nextInt();
                    biblioteca.deletar(id);
                    System.out.println("Livro deletado com sucesso!");
                    break;
                }
            }
        }
    }

    public static void menu(){
        System.out.println("----------------------------------");
        System.out.println("Bem-vindo ao sistema da biblioteca");
        System.out.println("----------------------------------");
        System.out.println("Adicionar livro: 1");
        System.out.println("Buscar livro por ID: 2");
        System.out.println("Listar livros disponiveis: 3");
        System.out.println("Emprestar livro: 4");
        System.out.println("Devolver livro: 5");
        System.out.println("Deletar livro: 6");
        System.out.println("Sair: 0");
        System.out.println("----------------------------------");
        System.out.print("Escolha uma opção: ");
    }
}