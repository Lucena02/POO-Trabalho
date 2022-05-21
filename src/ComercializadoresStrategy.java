package POOTrabalho.src;

import java.util.HashMap;
import java.util.Map;

public class ComercializadoresStrategy {

    public static final double precoBase = 10;
    public static final double imposto =0.23;
    public static final Map<Integer,FornecedoresInterface> mapFornecedores = Map.of(
            1,(energiaGasta) -> {  return ((precoBase+3) * energiaGasta  * (1 + imposto)) * 0.9; },
            2,(energiaGasta) -> {  return ((precoBase+2) * energiaGasta * (2 + imposto)) * 0.8; },
            3,(energiaGasta) -> {  return ((precoBase+0.5) * energiaGasta * (0.5 + imposto)) * 0.95; }
    );






}









