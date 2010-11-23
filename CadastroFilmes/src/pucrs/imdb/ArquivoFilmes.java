/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pucrs.imdb;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe que realiza a carga dos dados do arquivo de filmes, e inicializa
 * a lista de filmes 
 * @author flash
 */
public class ArquivoFilmes {

    private ListaFilmes listaFilmes;

    public ArquivoFilmes() {
        listaFilmes = new ListaFilmes();
    }

    public ListaFilmes getListaFilmes() {
        return listaFilmes;
    }

    public boolean preencherPorArquivo(String nomeDoArquivo) {
        try {
            Scanner scanner = new Scanner(new File(nomeDoArquivo), "UTF-8");
            // Informa o caractere de fim de linha (just in case)
            scanner.useDelimiter("\n");
            // Processa cada linha do arquivo
            while (scanner.hasNext()) {
                processaLinha(scanner.next());
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo " + nomeDoArquivo + " nao encontrado!");
            System.exit(1);
        }
        return false;
    }

    // Processa uma linha do arquivo de dados
    private void processaLinha(String line) {
        //System.out.println(">>> "+line);
        Scanner lineScanner = new Scanner(line);
        // O delimitador abaixo evita a necessidade de usarmos trim() em
        // cada string: ele define que o final de cada string é dado por
        // um ; seguido de uma quantidade arbitrária de espaços em branco
        lineScanner.useDelimiter("; *");

        // Le o titulo, e separa em titulo e ano da producao
        String tituloAno = lineScanner.next();
        String titulo = tituloAno.substring(0, tituloAno.lastIndexOf('(') - 1);
        String ano = tituloAno.substring(tituloAno.lastIndexOf('(') + 1, tituloAno.lastIndexOf('(') + 5);

        // Le URL e diretor
        String url = lineScanner.next();
        String diretor = lineScanner.next();

        // Converte os dados numericos
        int anoI = Integer.parseInt(ano);

        // Cria um novo filme e adiciona à lista
        Filme f = new Filme(anoI, titulo, diretor, url, 0, 0);
        listaFilmes.addFilme(f);
        //System.out.printf("<%s>\n", f);
    }
}
