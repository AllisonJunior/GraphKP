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
                    case Attr . CONSOLE_LIST    -> grafo . mostrar_Arestas ();
                    case Attr . CONSOLE_KRUSKAL -> grafo . execMST_Kruskal ();
                    case Attr . CONSOLE_PRIM    -> grafo . execMST_Prim ();
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
}
