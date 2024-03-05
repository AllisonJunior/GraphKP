/*
  Essa classe serve como um container / seção de salvamento de variáveis e componentes
  referente a parte gráfica dessa aplicação.
*/
package graphics;
import javax.swing.*;
import java.awt.*;





public class Attr
{
      // Janela
      public static final String WINDOW_TITLE = "GraphKP - Software de Grafos";
      public static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;
      public static final boolean WINDOW_IS_RUNNING = true;
      public static final Image WINDOW_ICON = new ImageIcon ( "src//resources//window_icon.png" ) . getImage ();

      // Constantes
      public static Font H1 = new Font ( "Consolas" , Font . BOLD , 32 );
      public static Font H3 = new Font ( "Calibri" , Font . BOLD , 18 );
      public static Font BT = new Font ( "Jetbrains Mono JFM" , Font . ITALIC , 18 );
      
      // Separator
      public static JSeparator SEPA_MENU = new JSeparator ( SwingConstants . HORIZONTAL );
      public static JSeparator SEPA_ARESTA_TOP = new JSeparator ( SwingConstants . HORIZONTAL );
      public static JSeparator SEPA_ARESTA_BOTTOM = new JSeparator ( SwingConstants . HORIZONTAL );
      public static JSeparator SEPA_DATA = new JSeparator ( SwingConstants . VERTICAL );
      
      // Labels
      public static JLabel LABEL_TITLENAME = new JLabel ();
      public static JLabel LABEL_VERTICES_TEXT = new JLabel ();
      public static JLabel LABEL_ARESTA_CADASTRADA = new JLabel ();
      public static JLabel LABEL_RESULTADOS = new JLabel ();
      public static JLabel LABEL_ORIGEM = new JLabel ();
      public static JLabel LABEL_DESTINO = new JLabel ();
      public static JLabel LABEL_PESO = new JLabel ();
      
      
      // Text-Field
      public static JTextField TXTFIELD_VERTICES = new JTextField ();
      public static JTextField TXTFIELD_ORIGEM = new JTextField ();
      public static JTextField TXTFIELD_DESTINO = new JTextField ();
      public static JTextField TXTFIELD_PESO = new JTextField ();
      
      // Buttons
      public static JButton BUTTON_CONFIRM_VERTICES = new JButton ();
      public static JButton BUTTON_EXEC = new JButton ();
      public static JButton BUTTON_INSERT = new JButton ();
      
      // Default List Model
      public static final DefaultListModel < String > DLM_ARESTAS = new DefaultListModel <> ();
      public static final DefaultListModel < String > DLM_RESULTADOS = new DefaultListModel <> ();
      
      // Jlists
      public static JList < String > LIST_ARESTAS = new JList <> ( DLM_ARESTAS );
      public static JList < String > LIST_RESULTADOS = new JList <> ( DLM_RESULTADOS );
      
      // Metódo para configurar uma label
      public static void init_label ( JLabel _ref , String _text , int _x , int _y , int _width , int _height , Font _font )
      {
          _ref . setText ( _text );
          _ref . setBounds ( _x , _y , _width , _height );
          _ref . setFont ( _font );
          
          _ref . setVerticalAlignment ( JLabel . CENTER );
          _ref . setHorizontalAlignment ( JLabel . CENTER );
          _ref . setHorizontalTextPosition ( JLabel . CENTER );
          _ref . setVerticalTextPosition ( JLabel . CENTER );
      }
      
      // Metódo para configurar um botão
      public static void init_button ( JButton _ref , String _text , int _x , int _y , int _width , int _height , Font _font )
      {
            _ref . setText ( _text );
            _ref . setFont ( _font );
            
            _ref . setHorizontalAlignment ( JButton . CENTER );
            _ref . setVerticalAlignment ( JButton . CENTER );
            
            _ref . setFocusable ( false );
            _ref . setBounds ( _x , _y , _width , _height );
      }
      
      // Metódo para configurar uma text-field
      public static void init_textfield ( JTextField _ref , int _x , int _y , int _width , int _height )
      {
            _ref . setBounds ( _x , _y , _width , _height );
            _ref . setAlignmentX ( JTextField . CENTER );
            _ref . setAlignmentY ( JTextField . CENTER );
            _ref . setHorizontalAlignment ( JTextField . CENTER );
      }
      
      // Metódo para configurar uma JSeparator
      public static void init_separator ( JSeparator _ref , int _x , int _y , int _widht , int _height )
      {
            _ref . setBounds ( _x , _y , _widht , _height );
      }
      
      // Metódo para configurar a JList
      public static void init_list ( JList _ref , int _x , int _y , int _width , int _height )
      {
            _ref . setBounds ( _x , _y , _width , _height );
            _ref . setSelectionMode ( ListSelectionModel . SINGLE_INTERVAL_SELECTION ); // Define o modo de seleção para bloqueado
            _ref . setEnabled ( false ); // Desabilita a lista para impedir interação do usuário
            
      }
}
