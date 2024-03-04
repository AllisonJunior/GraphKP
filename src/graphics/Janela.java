package graphics;
import javax.swing.*;





public class Janela extends JFrame
{
      public Janela ()
      {
            this . setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
            this . setTitle ( Attr . WINDOW_TITLE );
            this . setSize ( Attr . WINDOW_WIDTH , Attr . WINDOW_HEIGHT );
            this . setResizable ( false );
            this . setLocationRelativeTo ( null );
            this . setLayout ( null );
            
            
            this . setVisible ( Attr . WINDOW_IS_RUNNING );
      }
}
