import Editor.Editor;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Editor editor = new Editor();
        Scanner s = new Scanner(System.in);
        Integer opcao;

        System.out.println("1 - Criar um Arquivo");
        System.out.println("2 - Consultar no Arquivo");
        System.out.println("3 - Alterar o Arquivo");
        System.out.println("4 - Remover do Arquivo");
        System.out.println("5 - Sair");
        System.out.println("Digite sua escolha: ");
        opcao = s.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("\n Criando um Arquivo");
                editor.CriarArquivo();
                break;

            case 2:
                System.out.println("\n Consultando no Arquivo");
                editor.ConsultarArquivo();
                break;

            case 3:
                System.out.println("\n Alterando o Arquivo");
                editor.AlterarArquivo();
                break;

            case 4:
                System.out.println("\n Removendo do Arquivo");
                editor.RemoverArquivo();
                break;

            case 5:
                System.out.println("\n Programa Encerrado!");
                break;

            default:
                System.out.println("\n Opção Inválida");
                break;
        }
    }
    
}
