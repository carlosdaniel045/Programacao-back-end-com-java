package model;
import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {

    private ArrayList<PessoaJuridica> pessoas = new ArrayList<>();

    public void inserir(PessoaJuridica pf) {
        pessoas.add(pf);
    }

    public void alterar(PessoaJuridica pf) {
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

    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pf : pessoas) {
            if (pf.getId() == id) {
                return pf;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
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

    pessoas = (ArrayList<PessoaJuridica>) in.readObject();
    in.close();
}
}