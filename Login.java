import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

/**
 * Classe de login do sistema.
 * 
 * @author Leandro Spanghero - Fera 
 * @version 1.0 - 08/05/2023
 */
public class Login extends JFrame
{
    /**
     * Construtor para objetos da classe Login
     */
    public Login() {
        // tamanho da tela
        setSize(200,200);
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        
        JLabel jlblTitulo = new JLabel("ENTRADA");
        JLabel jlblUsu = new JLabel("Usuário: ");
        jlblUsu.setPreferredSize(new Dimension(200, 20));
        //jlblUsu.setMaximumSize(new Dimension(100, 20));
        //jlblUsu.setMinimumSize(new Dimension(100, 20));
        JTextField jtfUsu = new JTextField();
        //jtfUsu.setSize(50, 20);
        jtfUsu.setPreferredSize(new Dimension(100, 20));
        //jtfUsu.setMaximumSize(new Dimension(100, 20));
        //jtfUsu.setMinimumSize(new Dimension(100, 20));
        JLabel jlblSen = new JLabel("Senha: ");
        jlblSen.setPreferredSize(new Dimension(200, 20));
        //jlblSen.setMaximumSize(new Dimension(100, 20));
        //jlblSen.setMinimumSize(new Dimension(100, 20));
        JTextField jtfSen = new JTextField();
        jtfSen.setPreferredSize(new Dimension(100, 20));
        //jtfSen.setMaximumSize(new Dimension(100, 20));
        //jtfSen.setMinimumSize(new Dimension(100, 20));
        JButton jbtnEntra = new JButton("ENTRAR");
        
        //gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridy = 0; 
        gbl.setConstraints(jlblTitulo, gbc);
        add(jlblTitulo);
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        //gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbl.setConstraints(jlblUsu, gbc);
        add(jlblUsu);
        //gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.weightx = 0.5;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbl.setConstraints(jtfUsu, gbc);
        add(jtfUsu);
        //gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbl.setConstraints(jlblSen, gbc);
        add(jlblSen);
        //gbc.weightx = 1;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbl.setConstraints(jtfSen, gbc);
        add(jtfSen);
        //gbc.weightx = 0.5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.gridy = 3;
        gbl.setConstraints(jbtnEntra, gbc);
        add(jbtnEntra);
        // ícone do canto superior esquerdo
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/javaicon.png")));
        // centralizar tela
        setLocationRelativeTo(null);
        //quando clicar no X fechar a tela
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        // deixar a tela visível
        setVisible(true);
    
    }
}
