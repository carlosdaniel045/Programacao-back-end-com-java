package model;
import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {

    private ArrayList<PessoaFisica> pessoas = new ArrayList<>();

    public void inserir(PessoaFisica pf) {
        pessoas.add(pf);
    }

    public void alterar(PessoaFisica pf) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == pf.getId()) {
                pessoas.set(i, pf);
                break;
            }
        }
    }

    public void excluir(int id) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getId() == id) {
                pessoas.remove(i);
                break;
            }
        }
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pf : pessoas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoas;
    }
public void persistir(String nomeArquivo) throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(
            new FileOutputStream(nomeArquivo));

    out.writeObject(pessoas);
    out.close();
}

@SuppressWarnings("unchecked")
public void recuperar(String nomeArquivo) throws Exception {
    ObjectInputStream in = new ObjectInputStream(
            new FileInputStream(nomeArquivo));

    pessoas = (ArrayList<PessoaFisica>) in.readObject();
    in.close();
}
}