/*
  Essa classe serve como um container / seção de salvamento de variáveis referente a parte
  de execução via console dessa aplicação.
*/
package console;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;





public class Attr
{
      // Objeto do tipo scanner para fazer o handling de input direto do console, variável
      // que serve para controlar a escolha do usuário.
      public static final Scanner input = new Scanner ( System . in , StandardCharsets. UTF_8 );
      public static int user_choice = 0;
      
      // String-Flags
      public static final String MENU_NAME = "-- IMPLEMENTAÇÃO DOS ALGORITMOS DE KRUSKAL E PRIM -- \n";
      public static final String MENU_QUIT = "\n-- Obrigado por me testar! --";
      public static final String MENU_VERTICES = "Insira a quantidade de vértices do seu grafo ::> ";
      public static final String FULL_MENU = "-- IMPLEMENTAÇÃO DOS ALGORITMOS DE KRUSKAL E PRIM -- \n\n1 - Inserir uma aresta ao grafo.\n2 - Listar todos as arestas do grafo.\n3 - Executar o Algoritmo de Kruskal.\n4 - Executar o Algoritmo de Prim.\n5 - Encerrar a execução da aplicação.\n6, 7, 8, 9 - Executar testes rápidos.\n\nO que você deseja fazer? ::> ";
      
      public static final String MENU_INSERT_ORIGEM = "Insira o vértice de origem ::> ";
      public static final String MENU_INSERT_DESTINO = "Insira o vértice de destino ::> ";
      public static final String MENU_INSERT_PESO = "Insira o peso da aresta ::> ";
      public static final String MENU_INSERT_FINISHED = "\n-- Aresta adicionada com sucesso, para continuar pressione qualquer tecla! --";
      public static final String MENU_TESTS_FINISHEDS = "\n-- Testes dos algortimos de Kruskal e Prim executados. Para continuar pressione qualquer tecla! --";
      public static final String MENU_TEST_KRUSKAL_ENDED = "\n-- Teste utilizando o algoritmo de Kruskal foi concluído. Para continuar pressione qualquer tecla! --";
      public static final String MENU_TEST_PRIM_ENDED = "\n-- Teste utilizando o algoritmo de Prim foi concluído. Para continuar pressione qualquer tecla! --";
      public static final String MENU_ARESTS_SHOWCASE = "\n-- Essas são todas as arestas cadastradas até agora. Para continuar pressione qualquer tecla! --";
      
      // Int-Flags
      public static final int CONSOLE_INSERT  = 1;
      public static final int CONSOLE_LIST  = 2;
      public static final int CONSOLE_KRUSKAL = 3;
      public static final int CONSOLE_PRIM    = 4;
      public static final int CONSOLE_END     = 5;
      
      public static final int CONSOLE_TEST1   = 6;
      public static final int CONSOLE_TEST2   = 7;
      public static final int CONSOLE_TEST3   = 8;
      public static final int CONSOLE_TEST4   = 9;
}
