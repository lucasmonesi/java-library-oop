package service;

import model.Livro;

import java.util.HashMap;
import java.util.Map;

public class Biblioteca {
    private final Map<Integer, Livro> livros = new HashMap<>();

    public void adicionarLivro(Livro livro){
        if (livros.containsKey(livro.getId())){
            throw new IllegalArgumentException("O ID já está registrado!");
        }
        livros.put(livro.getId(), livro);
    }

    public Livro buscarPorID(int id){
        Livro livro = livros.get(id);
        if (livro == null){
            throw new IllegalArgumentException("model.Livro não encontrado para o ID: " + id);
        }
        return livro;
    }

    public void listarDisponiveis(){
        boolean encontrou = false;
        for (Livro livro : livros.values()){
            if (!livro.isEmprestado()){
                System.out.println(livro);
                encontrou = true;
            }
        }

        if (!encontrou){
            System.out.println("Nenhum livro disponível no momento.");
        }
    }

    public void emprestarLivro(int id){
        Livro livro = buscarPorID(id);
        livro.emprestar();
    }

    public void devolverLivro(int id){
        Livro livro = buscarPorID(id);
        livro.devolver();
    }

    public void deletar(int id){
        Livro livro = buscarPorID(id);
        if (livro.isEmprestado()){
            throw new IllegalArgumentException("Você não pode deletar um livro que está sendo emprestado!");
        }
        livros.remove(id);
    }
}
