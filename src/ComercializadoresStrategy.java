package POOTrabalho.src;

import java.util.HashMap;
import java.util.Map;

public class ComercializadoresStrategy {

    public static final double precoBase = 10;
    public static final double imposto =0.23;
    public static final Map<Integer,FornecedoresInterface> mapFornecedores = Map.of(
            1,(income) -> {  return ((precoBase+3) * income * (1 + imposto)) * 0.9; },
            2,(income) -> {  return ((precoBase+2) * income * (2 + imposto)) * 0.8; },
            3,(income) -> {  return ((precoBase+0.5) * income * (0.5 + imposto)) * 0.95; }
    );






}









