package Editor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Editor {
    private String nomeBuscado;
    private String linha;

    ArrayList<String> listaNome = new ArrayList<>();
    Scanner leitura = new Scanner(System.in);

    public void CriarArquivo() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome " + (i + 1) + ": ");
            listaNome.add(leitura.nextLine());
        }

        File pasta = new File("arquivo");
        if (!pasta.exists()) {
            pasta.mkdir();
            System.out.println("Pasta Criada com Sucesso!");
        }

        try {
            FileWriter arquivoTexto = new FileWriter("arquivo/meus_nomes.txt");
            PrintWriter gravador = new PrintWriter(arquivoTexto);

            for (String nome : listaNome) {
                gravador.println(nome);
            }
            gravador.close();
            System.out.println("Os nomes foram salvos com sucesso");

        } catch (IOException e) {
            System.out.println("Algo deu errado");
            e.printStackTrace();
        }
    }



    public void ConsultarArquivo() {
        System.out.println("Digite o nome que você deseja consultar: ");
        nomeBuscado = leitura.nextLine();

        try {
            File arquivo = new File("arquivo/meus_nomes.txt");
            Scanner consultar = new Scanner(arquivo);
            boolean encontrado = false;

            while (consultar.hasNextLine()) {
                linha = consultar.nextLine();

                if (linha.contains(nomeBuscado)) {
                    encontrado = true;
                }
            }

            if (encontrado) {
                System.out.println("O nome digitado está na lista");
            } else {
                System.out.println("O nome digitado não foi encontrado na lista");
            }
            consultar.close();

        } catch (IOException e) {
            System.out.println("Algo deu errado );");
            e.printStackTrace();
        }
    }



    public void ListarArquivo() {
        int contador = 1;

        try {
            File arquivo = new File("arquivo/meus_nomes.txt");
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                /* listaNome.add(leitor.nextLine()); */
                linha = leitor.nextLine();
                System.out.println(contador + "º " + linha);
                contador++;
            }

            leitor.close();

        } catch (IOException e) {
            System.out.println("Algo deu errado. );");
            e.printStackTrace();
        }
    }



    public void AlterarArquivo() {
        try {
            File arquivo = new File("arquivo/meus_nomes.txt");
            Scanner consultar = new Scanner(arquivo);
            System.out.println("");

            while (consultar.hasNextLine()) {
                listaNome.add(consultar.nextLine());
            }
            consultar.close();

        } catch (IOException e) {
            System.out.println("Algo deu errado );");
            e.printStackTrace();
        }

        ListarArquivo();

        System.out.println("Digite o nome que você deseja alterar: ");
        nomeBuscado = leitura.nextLine();

        int indice = listaNome.indexOf(nomeBuscado);

        if (indice != -1) {
            System.out.println("Digite o novo nome: ");
            String novoNome = leitura.nextLine();

            listaNome.set(indice, novoNome);

            try {
                PrintWriter gravador = new PrintWriter("arquivo/meus_nomes.txt");

                for (String nome : listaNome) {
                    gravador.println(nome);

                }
                gravador.close();

            } catch (Exception e) {
                System.out.println("Poxa, erro ao salvar o arquivo );");
            }
            System.out.println("Nome alterado com sucesso!");

        } else {
            System.out.println("Nome não encontrado");
        }
    }



    public void RemoverArquivo() {
        /*
         * listaNome.remove("NomeParaDeletar"): Remove o nome diretamente pelo texto.
         * listaNome.remove(indice): Remove o item que estiver naquela posição
         * específica.
         */
        try {
            File arquivo = new File("arquivo/meus_nomes.txt");
            Scanner consultar = new Scanner(arquivo);
            System.out.println("");

            while (consultar.hasNextLine()) {
                listaNome.add(consultar.nextLine());
            }
            consultar.close();

        } catch (IOException e) {
            System.out.println("Algo deu errado );");
            e.printStackTrace();
        }

        ListarArquivo();

        System.out.println("Digite o nome que deseja remover: ");
        nomeBuscado = leitura.nextLine();

        int indice = listaNome.indexOf(nomeBuscado);

        if (indice != -1) {
            listaNome.remove(indice);

            try {
                PrintWriter gravador = new PrintWriter("arquivo/meus_nomes.txt");

                for (String nome : listaNome) {
                    gravador.println(nome);

                }
                gravador.close();

            } catch (Exception e) {
                System.out.println("Poxa, erro ao salvar o arquivo );");
            }
            System.out.println("Nome removido com sucesso!");

        } else {
            System.out.println("Nome não encontrado!");
        }
    }
}