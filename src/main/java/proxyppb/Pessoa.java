package proxyppb;
import java.util.Arrays;
import java.util.List;
public class Pessoa implements  IPessoa{

    private String nome;

    public String getTelefone() {
        return telefone;
    }

    private String telefone;
    private String email;
    private String cpf;

    public Pessoa(String telefone) {
        this.telefone = telefone;
        Pessoa objeto = DB.getPessoa(telefone);
        this.nome = objeto.nome;
        this.email = objeto.email;
        this.cpf = objeto.cpf;
    }
    public Pessoa(String nome, String telefone, String email, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    @Override
    public List<String> obterNome() {
        return Arrays.asList(this.nome, this.telefone);
    }

    @Override
    public List<String> obterTodosDados(boolean admin) {
        return Arrays.asList(this.nome, this.telefone, this.cpf, this.email);
    }
}
