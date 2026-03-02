public class Livro {
    private final int id;
    private final String titulo;
    private final String autor;
    private final int ano;
    private boolean emprestado;

    public int getId() {
        return id;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public Livro(int id, String titulo, String autor, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.emprestado = false;
    }

    public void emprestar(){
        if (emprestado){
            throw new IllegalArgumentException("O livro já foi emprestado!");
        }
        this.emprestado = true;
    }

    public void devolver(){
        if (!emprestado){
            throw new IllegalArgumentException("O livro já foi devolvido!");
        }
        this.emprestado = false;
    }

    @Override
    public String toString() {
        return "Livro: { ID: " + id + ", Titulo: "  + titulo + ", Autor: " + autor + ", Ano:" + ano + ", Situação: " + emprestado + " }";
    }
}
