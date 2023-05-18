import javax.swing.JFrame;

import java.awt.Toolkit;

/**
 * Tela de cadastro de usuários do sistema.
 * 
 * @author Leandro Spanghero - Fera
 * @version 1.0 - 18/05/2023
 */
public class CadUsu extends JFrame {
    /**
     * Construtor para objetos da classe CadUsu
     */
    public CadUsu() {
        super("..:: CADASTRO DE USUÁRIOS ::..");
        // tamanho da tela
        setSize(600,400);  
        // ícone do canto superior esquerdo
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/javaicon.png")));
        // centralizar tela
        setLocationRelativeTo(null);
        //quando clicar no X fechar a tela
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);  
    }
}
