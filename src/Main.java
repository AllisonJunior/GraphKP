/*
  Essa classe é básicamente o runner da aplicação. A mesma possui a classe de execução princípal
  que checa o que será executado: O modo terminal ou o modo gráfico, com base nos argumentos de
  entrada fornecidos na execução inicial.
*/
import graphics.Janela;
import console.Console;





public class Main
{
      public static void main ( String [] args )
      {
            if ( args . length == 0 ) new Janela ();
            else                      new Console ();
      }
}
