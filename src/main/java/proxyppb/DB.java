package proxyppb;

import java.util.HashMap;
import java.util.Map;

public class DB {
    private static Map<String, Pessoa> pessoas = new HashMap<>();

    public static Pessoa getPessoa(String telefone) {
        return pessoas.get(telefone);
    }
    public static void addPessoa(Pessoa pessoa) {
        pessoas.put(pessoa.getTelefone(), pessoa);
    }
}
