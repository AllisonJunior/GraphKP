package graphics;
import implementation.Aresta;
import implementation.Grafo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static graphics.Attr.*;
import static graphics.Attr.init_label;





public class Janela extends JFrame
{
      private Grafo grafo;
      private int vertices , origem , destino , peso;
      
      
      public Janela ()
      {
            // Configuração da janela
            this . setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
            this . setTitle ( WINDOW_TITLE );
            this . setSize ( WINDOW_WIDTH , WINDOW_HEIGHT );
            this . setResizable ( false );
            this . setLocationRelativeTo ( null );
            this . setIconImage ( WINDOW_ICON );
            this . setLayout ( null );
            
            // Adicionando os componentes
            config_components ();
            add_components ();
            
            // Configurando os listeners
            // Botão para definir a quantidade de vértices
            BUTTON_CONFIRM_VERTICES . addActionListener ( new ActionListener ()
            {
                  @Override public void actionPerformed ( ActionEvent action )
                  {
                        String get_text = TXTFIELD_VERTICES . getText ();
                        
                        // Pega a quantidade de vértices
                        try { vertices = Integer . parseInt ( get_text ); }
                        catch ( NumberFormatException ex ) { JOptionPane . showMessageDialog ( null , "Entrada inválida! Digite um número inteiro." ); }
                        
                        // Limpa todos os campos de texto
                        TXTFIELD_PESO . setText ( "" );
                        TXTFIELD_ORIGEM . setText ( "" );
                        TXTFIELD_DESTINO . setText ( "" );
                        
                        // Limpa todos as listas
                        DLM_ARESTAS . clear ();
                        DLM_RESULTADOS . clear ();
                        
                        // Atualiza o grafo
                        grafo = new Grafo ( vertices);
                        
                        // Tudo certo
                        JOptionPane . showMessageDialog ( null , "Vértice configurado com sucesso." );
                  }
            });
            
            // Botão para adicionar uma aresta
            BUTTON_INSERT . addActionListener ( new ActionListener ()
            {
                  @Override public void actionPerformed ( ActionEvent action )
                  {
                        String get_origem = TXTFIELD_ORIGEM . getText ();
                        String get_destino = TXTFIELD_DESTINO . getText ();
                        String get_peso = TXTFIELD_PESO . getText ();
                        
                        // Origem
                        try { origem = Integer . parseInt ( get_origem ); }
                        catch ( NumberFormatException ex ) { JOptionPane . showMessageDialog ( null , "Entrada inválida! Digite um número inteiro." ); }
                        
                        // Destino
                        try { destino = Integer . parseInt ( get_destino ); }
                        catch ( NumberFormatException ex ) { JOptionPane . showMessageDialog ( null , "Entrada inválida! Digite um número inteiro." ); }
                        
                        // Peso
                        try { peso = Integer . parseInt ( get_peso ); }
                        catch ( NumberFormatException ex ) { JOptionPane . showMessageDialog ( null , "Entrada inválida! Digite um número inteiro." ); }
                        
                        // Adicionar uma aresta ao nosso grafo
                        grafo . adicionar_Aresta ( origem , destino , peso );
                        
                        // Limpando os campos
                        TXTFIELD_DESTINO . setText ( "" );
                        TXTFIELD_ORIGEM . setText ( "" );
                        TXTFIELD_PESO . setText ( "" );
                        
                        // Atualizando a lista
                        String element = "[ " + origem + " ⭢ " + destino + " : " + peso + " ]";
                        DLM_ARESTAS . addElement ( element );
                  }
            });
            
            // Botão para executar os algoritmos
            BUTTON_EXEC . addActionListener ( new ActionListener ()
            {
                  @Override public void actionPerformed ( ActionEvent action )
                  {
                          grafo . graphics_execMST_Kruskal ( DLM_RESULTADOS );
                          DLM_RESULTADOS . addElement ( "" );
                          grafo . graphics_execMST_Prim ( DLM_RESULTADOS );
                  }
            });
            
            // Rodando a aplicação
            this . setVisible ( WINDOW_IS_RUNNING );
      }
      
      // Metódo para configurar os componentes da nossa janela
      void config_components ()
      {
           init_label ( LABEL_TITLENAME , "GraphPK" , 0 , 10 , 800 , 50 , H1 );
           init_label ( LABEL_VERTICES_TEXT , "Insira a quantidade de vértices do seu grafo:" , 10 , 60 , 340 , 50 , H3 );
           init_label ( LABEL_ARESTA_CADASTRADA , "Arestas cadastradas" , 365 , 60 , 340 , 50 , H3 );
           init_label ( LABEL_RESULTADOS , "Resultados" , 365 , 300 , 280 , 50 , H3 );
           init_label ( LABEL_ORIGEM , "Insira o vértice de origem:" , 15 , 155 , 195 , 50 , H3 );
           init_label ( LABEL_DESTINO , "Insira o vértice de destino:" , 15 , 240 , 200 , 50 , H3 );
           init_label ( LABEL_PESO , "Insira o peso da aresta:" , 15 , 325 , 175 , 50 , H3 );
           
           init_textfield ( TXTFIELD_VERTICES , 15 , 100 , 200 , 40 );
           init_textfield ( TXTFIELD_ORIGEM , 15 , 195 , 425 , 40 );
           init_textfield ( TXTFIELD_DESTINO , 15 , 280 , 425 , 40 );
           init_textfield ( TXTFIELD_PESO , 15 , 365 , 425 , 40 );
           
           init_button ( BUTTON_CONFIRM_VERTICES , "Confirmar" , 220 , 100 , 220 , 40 , BT );
           init_button ( BUTTON_EXEC , "Executar os algoritmos" , 15 , 510 , 420 , 40 , BT );
           init_button ( BUTTON_INSERT , "Adicionar aresta" , 15 , 430 , 420 , 40 , BT );
           
           init_separator ( SEPA_MENU , 0 , 60 , 800 , 10 );
           init_separator ( SEPA_DATA , 450 , 60 , 10 , 500 );
           init_separator ( SEPA_ARESTA_TOP , 0 , 155 , 450 , 10 );
           init_separator ( SEPA_ARESTA_BOTTOM, 0 , 490 , 450 , 10 );
           
           init_list ( LIST_ARESTAS , 460 , 100 , 315 , 205 );
           init_list ( LIST_RESULTADOS , 460 , 340 , 315 , 205 );
      }
      
      // Metódo para inserir os componentes que foram configurados
      void add_components ()
      {
          // Labels
          this . add ( LABEL_TITLENAME );
          this . add ( LABEL_VERTICES_TEXT );
          this . add ( LABEL_ARESTA_CADASTRADA );
          this . add ( LABEL_RESULTADOS );
          this . add ( LABEL_ORIGEM );
          this . add ( LABEL_DESTINO );
          this . add ( LABEL_PESO );
          
          // Text-Fields
          this . add ( TXTFIELD_VERTICES );
          this . add ( TXTFIELD_ORIGEM );
          this . add ( TXTFIELD_DESTINO );
          this . add ( TXTFIELD_PESO );
          
          // Buttons
          this . add ( BUTTON_CONFIRM_VERTICES );
          this . add ( BUTTON_EXEC );
          this . add ( BUTTON_INSERT );
          
          // Separadores
          this . add ( SEPA_MENU );
          this . add ( SEPA_DATA );
          this . add ( SEPA_ARESTA_TOP );
          this . add ( SEPA_ARESTA_BOTTOM );
          
          // Jlists
          this . add ( LIST_ARESTAS );
          this . add ( LIST_RESULTADOS );
      }
}
