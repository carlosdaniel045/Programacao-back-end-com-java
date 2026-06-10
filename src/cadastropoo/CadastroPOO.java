package cadastropoo;

import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
    PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

    int opcao;

    try {

        do {

            System.out.println("\n=== CADASTRO POO ===");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir por ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Salvar");
            System.out.println("7 - Recuperar");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");

            opcao = sc.nextInt();

if (opcao == 1) {
                

    System.out.println("F - Pessoa Fisica");
    System.out.println("J - Pessoa Juridica");
    System.out.print("Tipo: ");

    String tipo = sc.next();

    if (tipo.equalsIgnoreCase("F")) {

        System.out.print("Id: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Idade: ");
        int idade = sc.nextInt();

        repoPF.inserir(new PessoaFisica(id, nome, cpf, idade));

        System.out.println("Pessoa fisica cadastrada!");

    } else if (tipo.equalsIgnoreCase("J")) {

        System.out.print("Id: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CNPJ: ");
        String cnpj = sc.nextLine();

        repoPJ.inserir(new PessoaJuridica(id, nome, cnpj));

        System.out.println("Pessoa juridica cadastrada!");
    }
}

if (opcao == 2) {

    System.out.println("F - Pessoa Fisica");
    System.out.println("J - Pessoa Juridica");
    System.out.print("Tipo: ");

    String tipo = sc.next();

    System.out.print("Id: ");
    int id = sc.nextInt();

    sc.nextLine();

    if (tipo.equalsIgnoreCase("F")) {

        PessoaFisica pf = repoPF.obter(id);

        if (pf != null) {

            System.out.println("Dados atuais:");
            pf.exibir();

            System.out.print("Novo nome: ");
            String nome = sc.nextLine();

            System.out.print("Novo CPF: ");
            String cpf = sc.nextLine();

            System.out.print("Nova idade: ");
            int idade = sc.nextInt();

            repoPF.alterar(new PessoaFisica(id, nome, cpf, idade));

            System.out.println("Pessoa fisica alterada!");

        } else {
            System.out.println("Pessoa fisica nao encontrada!");
        }

    } else if (tipo.equalsIgnoreCase("J")) {

        PessoaJuridica pj = repoPJ.obter(id);

        if (pj != null) {

            System.out.println("Dados atuais:");
            pj.exibir();

            System.out.print("Novo nome: ");
            String nome = sc.nextLine();

            System.out.print("Novo CNPJ: ");
            String cnpj = sc.nextLine();

            repoPJ.alterar(new PessoaJuridica(id, nome, cnpj));

            System.out.println("Pessoa juridica alterada!");

        } else {
            System.out.println("Pessoa juridica nao encontrada!");
        }
    }
}

if (opcao == 3) {

    System.out.println("F - Pessoa Fisica");
    System.out.println("J - Pessoa Juridica");
    System.out.print("Tipo: ");

    String tipo = sc.next();

    System.out.print("Id: ");
    int id = sc.nextInt();

    if (tipo.equalsIgnoreCase("F")) {

        repoPF.excluir(id);
        System.out.println("Pessoa fisica excluida!");

    } else if (tipo.equalsIgnoreCase("J")) {

        repoPJ.excluir(id);
        System.out.println("Pessoa juridica excluida!");
    }
}

if (opcao == 4) {

    System.out.println("F - Pessoa Fisica");
    System.out.println("J - Pessoa Juridica");
    System.out.print("Tipo: ");

    String tipo = sc.next();

    System.out.print("Id: ");
    int id = sc.nextInt();

    if (tipo.equalsIgnoreCase("F")) {

        PessoaFisica pf = repoPF.obter(id);

        if (pf != null) {
            pf.exibir();
        } else {
            System.out.println("Pessoa fisica nao encontrada!");
        }

    } else if (tipo.equalsIgnoreCase("J")) {

        PessoaJuridica pj = repoPJ.obter(id);

        if (pj != null) {
            pj.exibir();
        } else {
            System.out.println("Pessoa juridica nao encontrada!");
        }
    }
}

if (opcao == 5) {

    System.out.println("F - Pessoa Fisica");
    System.out.println("J - Pessoa Juridica");
    System.out.print("Tipo: ");

    String tipo = sc.next();

    if (tipo.equalsIgnoreCase("F")) {

        for (PessoaFisica pf : repoPF.obterTodos()) {
            pf.exibir();
            System.out.println();
        }

    } else if (tipo.equalsIgnoreCase("J")) {

        for (PessoaJuridica pj : repoPJ.obterTodos()) {
            pj.exibir();
            System.out.println();
        }
    }
}   

if (opcao == 6) {

    System.out.print("Prefixo dos arquivos: ");
    String prefixo = sc.next();

    try {

        repoPF.persistir(prefixo + ".fisica.bin");
        repoPJ.persistir(prefixo + ".juridica.bin");

        System.out.println("Dados salvos com sucesso!");

    } catch (Exception e) {

        System.out.println("Erro ao salvar: " + e.getMessage());

    }
}

if (opcao == 7) {

    System.out.print("Prefixo dos arquivos: ");
    String prefixo = sc.next();

    try {

        repoPF.recuperar(prefixo + ".fisica.bin");
        repoPJ.recuperar(prefixo + ".juridica.bin");

        System.out.println("Dados recuperados com sucesso!");

    } catch (Exception e) {

        System.out.println("Erro ao recuperar: " + e.getMessage());

    }
}
        } while (opcao != 0);

    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }

    sc.close();
}
} 