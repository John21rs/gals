package com.mycompany.projeto_m2;

import java.io.IOException;
import gals.*;

/**
 *
 * @author João
 */
public class Projeto_m2 {
     public static void main(String[] args) throws IOException{
         
         try
         {
            Lexico lexico = new Lexico("A = 100; B = 10; B = 111 + A ^ B; show(A);");
            //Lexico lexico = new Lexico("A=(100+11*11);B=A;show(B);");
            
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        }
            catch ( LexicalError | SyntaticError | SemanticError e )
            {
                System.out.println("Comando não identificado.");
            }
  }
}