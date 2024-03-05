import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Teste {
      public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                  JFrame frame = new JFrame("Inserir e Remover Texto - JList");
                  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  
                  DefaultListModel<String> listModel = new DefaultListModel<>();
                  JList<String> list = new JList<>(listModel);
                  
                  // Cria um JTextField para inserir texto
                  JTextField textField = new JTextField(20);
                  
                  // Cria um botão para adicionar texto à lista
                  JButton addButton = new JButton("Adicionar Texto");
                  addButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                              String text = textField.getText();
                              listModel.addElement(text);
                              textField.setText(""); // Limpa o campo de texto após a adição
                        }
                  });
                  
                  // Cria um botão para remover texto da lista
                  JButton removeButton = new JButton("Remover Selecionado");
                  removeButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                              int selectedIndex = list.getSelectedIndex();
                              if (selectedIndex != -1) {
                                    listModel.remove(selectedIndex);
                              }
                        }
                  });
                  
                  // Adiciona os componentes ao frame
                  frame.getContentPane().setLayout(new BorderLayout());
                  frame.getContentPane().add(new JScrollPane(list), BorderLayout.CENTER);
                  frame.getContentPane().add(textField, BorderLayout.NORTH);
                  JPanel buttonPanel = new JPanel();
                  buttonPanel.add(addButton);
                  buttonPanel.add(removeButton);
                  frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
                  
                  // Configura o tamanho do JFrame e o torna visível
                  frame.setSize(300, 200);
                  frame.setLocationRelativeTo(null); // Centraliza a janela na tela
                  frame.setVisible(true);
            });
      }
}
