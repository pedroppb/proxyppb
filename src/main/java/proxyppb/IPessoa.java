package proxyppb;
import java.util.List;
public interface IPessoa {
        List<String> obterNome();
        List<String> obterTodosDados(boolean admin);
}
