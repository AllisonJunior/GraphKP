/*
  Essa classe busca representar uma aresta qualquer de um grafo.
*/
package implementation;





public class Aresta
{
      // Variáveis da aresta
      private int origem , destino , peso;
      
      // Construtor da aresta
      public Aresta ( int _origem , int _destino , int _peso )
      {
            this . origem = _origem;
            this . destino = _destino;
            this . peso = _peso;
      }
      
      // Getters da aresta
      public int get_origem () { return this . origem; }
      public int get_destino () { return this . destino; }
      public int get_peso () { return this . peso; }
      
      // Setters da aresta < not used >
      public void set_origem ( int _value ) { this . origem = _value; }
      public void set_destino ( int _value ) { this . destino = _value; }
      public void set_peso ( int _value ) { this . peso = _value; }
}
