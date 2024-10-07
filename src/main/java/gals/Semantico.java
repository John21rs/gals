package gals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String variavelAtual;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        Integer a, b;
        switch (action)
        { 
            case 1: //Empilha numeros
              stack.push(Integer.parseInt(token.getLexeme(), 2));
              break;
            case 2://adição
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() + b.intValue()));
              break;
            case 3://multiplicação
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() * b.intValue()));
              break;
            case 4: //Empilha variavel
              stack.push(vars.get(token.getLexeme()));
              break;
            case 5://subtração
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() - b.intValue()));
              break;            
            case 6://divisão
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() / b.intValue()));
              break;
            case 7: //exponeciação
              b = stack.pop();
              a = stack.pop();
              Double A = Math.pow(a, b);
              stack.push(A.intValue());
              break;
            case 8: // imprimir
              System.out.print("Resultado: "+Integer.toBinaryString(vars.get(variavelAtual))+"\n");
              break;            
            case 9: //salva variavel e valor
              vars.put(variavelAtual, stack.pop());
              break;
            case 10:    //variavel atual
              variavelAtual = token.getLexeme();
              break;
            /*case 14:
              b = stack.pop();
              a = stack.pop();
              stack.push((int) (Math.log(a) / Math.log(b)));
              break;
             case 15: // Captura o valor da variável digitada
                String varName = token.getLexeme(); // pega o nome da variável
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite um valor para " + varName + " (em binário): ");
                String binaryString = scanner.nextLine();
                int valor = Integer.parseInt(binaryString, 2); // Convertendo a string binária para decimal
                vars.put(varName, valor); // armazena o valor da variável
             break;
            */
        }
    }	
}
