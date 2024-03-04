/*
  Essa classe serve básicamente para permitir a aplicação a nível de console limpar a tela.
*/
package console;





public class Cls
{
      public static void clear ()
      {
            try
            {
               final String os = System . getProperty ( "os.name" );
                  
               if ( os . contains ( "Windows" ) ) new ProcessBuilder ("cmd" , "/c" , "cls" ) . inheritIO () . start () . waitFor ();
               else                               new ProcessBuilder ( "clear" ) . inheritIO () . start () . waitFor ();
            }
            
            catch ( Exception e ) { e . printStackTrace (); }
      }
}
