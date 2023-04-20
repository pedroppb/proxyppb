package proxyppb;

import java.util.List;

public class PessoaProxy implements IPessoa{
    private Pessoa pessoa;
    private String telefone;

    public PessoaProxy(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public List<String> obterNome() {
        if (this.pessoa == null) {
            this.pessoa = new Pessoa(this.telefone);
        }
        return this.pessoa.obterNome();
    }
    @Override
    public List<String> obterTodosDados(boolean admin){
        if (!admin) {
            throw new IllegalArgumentException("Não autorizado");
        }
        if (this.pessoa == null) {
            this.pessoa = new Pessoa(this.telefone);
        }
        return this.pessoa.obterTodosDados(admin);

    }

}
