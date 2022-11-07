package Package;

public class Func {
    
    // attributes (instances)
    private int codigo;
    private String nome;
    private String cargo;
    private String end;

    // constructor (initialization)
    public Func(int codigo, String nome, String cargo, String end) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.end = end;
    }

    // get/set
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Func [codigo=" + codigo + ", nome=" + nome + ", cargo=" + cargo + ", end=" + end + "]";
    }
    
    
}
