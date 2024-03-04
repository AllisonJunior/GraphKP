/*
  Essa classe básicamente serve para o modo de debug, ou seja, foi feita para testar
  as implementações feitas e permitir a sua utilização na parte gráfica.
*/
package console;
import implementation.Grafo;
import static console.Cls.clear;





public class Console
{
      private Grafo grafo;
      
      // Construtor / contaíner da nossa aplicação no modo debug
      public Console ()
      {
            // Print da frase do menu
            clear ();
            System . out . println ( Attr . MENU_NAME );
            
            // Requisitando inicialmente a quantidade de vértices do nosso grafo, logo após
            // criamos o nosso grafo com a quantidade de vértices definidos
            System . out . print ( Attr . MENU_VERTICES );
            int vertices = Attr . input . nextInt ();
            grafo = new Grafo ( vertices );
            
            // Menu para inserir arestas e pesos no nosso grafo
            do
            {
              // Print da frase do menu novamente
              clear ();
              System . out . print ( Attr . FULL_MENU );
              Attr . user_choice = Attr . input . nextInt ();
              
              // Switch que controla o que será executado
              switch ( Attr . user_choice )
              {
                    case Attr . CONSOLE_INSERT  -> insert ();
                    case Attr . CONSOLE_LIST    -> exec_arestas_console ();
                    case Attr . CONSOLE_KRUSKAL -> exec_kruskal_console ();
                    case Attr . CONSOLE_PRIM    -> exec_prim_console ();
                    
                    case Attr . CONSOLE_TEST1   -> fast_test01 ();
                    case Attr . CONSOLE_TEST2   -> fast_test02 ();
                    case Attr . CONSOLE_TEST3   -> fast_test03 ();
                    case Attr . CONSOLE_TEST4   -> fast_test04 ();
              }
            }
            while ( Attr . user_choice != Attr . CONSOLE_END );
            
            // Fim da execução da aplicação
            System . out . println ( Attr . MENU_QUIT );
            
            // Podemos fechar nosso scanner ( java é triste )
            Attr . input . close ();
      }
      
      // Metódo para inserir uma aresta qualquer no nosso grafo
      public void insert ()
      {
            System . out . print ( "\n" + Attr . MENU_INSERT_ORIGEM );
            int source = Attr . input . nextInt ();
            
            System . out . print ( Attr . MENU_INSERT_DESTINO );
            int destiny = Attr . input . nextInt ();
            
            System . out . print ( Attr . MENU_INSERT_PESO );
            int weight = Attr . input . nextInt ();
            
            System . out . print ( Attr . MENU_INSERT_FINISHED );
            grafo . adicionar_Aresta ( source , destiny , weight );
            Attr . input . nextLine ();
            Attr . input . nextLine ();
      }

      // Metódo de Teste Rápido 01
      public void fast_test01 ()
      {
            // Criando um grafo com 4 vértices
            Grafo teste1 = new Grafo ( 4 );
            
            // Adicionando arestas ao grafo
            teste1 . adicionar_Aresta ( 0 , 1 , 10 );
            teste1 . adicionar_Aresta ( 0 , 2 , 6 );
            teste1 . adicionar_Aresta ( 0 , 3 , 5 );
            teste1 . adicionar_Aresta ( 1 , 3 , 15 );
            teste1 . adicionar_Aresta ( 2 , 3 , 4 );
            teste1 . adicionar_Aresta ( 1 , 3 , 4 );
            
            // Mostrando todas as arestas do grafo
            teste1 . mostrar_Arestas ();
            
            // Executando o algoritmo de Kruskal e de Prim
            teste1 . execMST_Kruskal ();
            teste1 . execMST_Prim ();
            
            // Pseudo-Pause
            System . out . print ( Attr . MENU_TESTS_FINISHEDS );
            Attr . input . nextLine ();
            Attr . input . nextLine ();
      }
      
      // Metódo de Teste Rápido 02
      public void fast_test02 ()
      {
            // Criando um grafo com 4 vértices
            Grafo teste2 = new Grafo ( 5 );
            
            // Adicionando arestas ao grafo
            teste2 . adicionar_Aresta ( 0 , 1 , 2 );
            teste2 . adicionar_Aresta ( 0 , 2 , 4 );
            teste2 . adicionar_Aresta ( 1 , 2 , 1 );
            teste2 . adicionar_Aresta ( 1 , 3 , 3 );
            teste2 . adicionar_Aresta ( 1 , 4 , 5 );
            teste2 . adicionar_Aresta ( 2 , 4 , 6 );
            
            // Mostrando todas as arestas do grafo
            teste2 . mostrar_Arestas ();
            
            // Executando o algoritmo de Kruskal e de Prim
            teste2 . execMST_Kruskal ();
            teste2 . execMST_Prim ();
            
            // Pseudo-Pause
            System . out . print ( Attr . MENU_TESTS_FINISHEDS );
            Attr . input . nextLine ();
            Attr . input . nextLine ();
      }
      
      // Metódo de Teste Rápido 03
      public void fast_test03 ()
      {
            // Criando um grafo com 4 vértices
            Grafo teste3 = new Grafo ( 6 );
            
            // Adicionando arestas ao grafo
            teste3 . adicionar_Aresta ( 0 , 1 , 3 );
            teste3 . adicionar_Aresta ( 0 , 2 , 5 );
            teste3 . adicionar_Aresta ( 1 , 2 , 6 );
            teste3 . adicionar_Aresta ( 1 , 3 , 2 );
            teste3 . adicionar_Aresta ( 2 , 3 , 4 );
            teste3 . adicionar_Aresta ( 2 , 4 , 7 );
            teste3 . adicionar_Aresta ( 3 , 5 , 8 );
            teste3 . adicionar_Aresta ( 4 , 5 , 9 );
            
            // Mostrando todas as arestas do grafo
            teste3 . mostrar_Arestas ();
            
            // Executando o algoritmo de Kruskal e de Prim
            teste3 . execMST_Kruskal ();
            teste3 . execMST_Prim ();
            
            // Pseudo-Pause
            System . out . print ( Attr . MENU_TESTS_FINISHEDS );
            Attr . input . nextLine ();
            Attr . input . nextLine ();
      }
      
      // Metódo de Teste Rápido 04
      public void fast_test04 ()
      {
            // Criando um grafo com 4 vértices
            Grafo teste4 = new Grafo ( 4 );
            
            // Adicionando arestas ao grafo
            teste4 . adicionar_Aresta ( 0 , 1 , 1 );
            teste4 . adicionar_Aresta ( 0 , 2 , 3 );
            teste4 . adicionar_Aresta ( 0 , 3 , 5 );
            teste4 . adicionar_Aresta ( 1 , 2 , 2 );
            teste4 . adicionar_Aresta ( 1 , 3 , 4 );
            teste4 . adicionar_Aresta ( 2 , 3 , 6 );
            
            // Mostrando todas as arestas do grafo
            teste4 . mostrar_Arestas ();
            
            // Executando o algoritmo de Kruskal e de Prim
            teste4 . execMST_Kruskal ();
            teste4 . execMST_Prim ();
            
            // Pseudo-Pause
            System . out . print ( Attr . MENU_TESTS_FINISHEDS );
            Attr . input . nextLine ();
            Attr . input . nextLine ();
      }
      
      // Metódo para listar todas as arestas inseridas
      public void exec_arestas_console () { grafo . mostrar_Arestas (); System . out . print ( Attr . MENU_ARESTS_SHOWCASE ); Attr . input . nextLine (); Attr . input . nextLine (); }
      
      // Metódo para a execução do Kruskal
      public void exec_kruskal_console () { grafo . execMST_Kruskal (); System . out . print ( Attr . MENU_TEST_KRUSKAL_ENDED ); Attr . input . nextLine (); Attr . input . nextLine (); }
      
      // Metódo para a execução do Prim
      public void exec_prim_console () { grafo . execMST_Prim (); System . out . print ( Attr . MENU_TEST_PRIM_ENDED ); Attr . input . nextLine (); Attr . input . nextLine (); }
}