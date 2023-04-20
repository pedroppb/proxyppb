package proxyppb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
public class PessoaTest {

    @BeforeEach
    void setUp() {
        DB.addPessoa(new Pessoa("pedro","21991202675","pedro@minharola.com.br","12345678912"));
        DB.addPessoa(new Pessoa("pedro vasconselos","32154181615","email@falso.com","98765432112"));
        DB.addPessoa(new Pessoa("alguem","324124151233","email@falso.com","98765432112"));
    }
    @Test
    void deveRetornarnome() {
        PessoaProxy pessoa = new PessoaProxy("21991202675");

        assertEquals(Arrays.asList("pedro", "21991202675"), pessoa.obterNome());
    }
    @Test
    void deveRetonarTodosDados() {
        PessoaProxy pessoa = new PessoaProxy("32154181615");

        assertEquals(Arrays.asList("pedro vasconselos","32154181615","98765432112","email@falso.com"), pessoa.obterTodosDados(true));
    }
    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarTodosDados() {
        try {
            PessoaProxy pessoa = new PessoaProxy("32154181615");

            pessoa.obterTodosDados(false);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Não autorizado", e.getMessage());
        }
    }


}
