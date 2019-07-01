package teste;

import java.time.LocalDate;
import pojo.Departamento;
import pojo.Permissao;
import pojo.Sistema;
import pojo.Usuario;

public class Principal {

    public static void main(String[] args) {
        Sistema s = new Sistema(true, LocalDate.now(), new Usuario(100, "Guilherme", new Departamento(100, "TI"), new Permissao(100, "Operador")));
        s.insert();
    }

}
