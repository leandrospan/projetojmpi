import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
        setLayout(new FlowLayout());
        JLabel jlblTitulo = new JLabel("CADASTRO DE USUÁRIOS");
        JLabel jlblUsuario = new JLabel("Usuário: ");
        JTextField jtfUsuario = new JTextField();
        JLabel jlblSenha = new JLabel("Senha: ");
        JTextField jtfSenha = new JTextField();
        JLabel jlblTipo = new JLabel("Tipo: ");
        String[] tipos = {"Administrador", "Usuário"};
        JComboBox jcbTipo = new JComboBox<>(tipos);
        JButton jbtnInserir = new JButton("SALVAR");
        jbtnInserir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "Usuário Salvo com Sucesso!");
            }
        });
                
        add(jlblTitulo);
        add(jlblUsuario);
        add(jtfUsuario);
        add(jlblSenha);
        add(jtfSenha);
        add(jlblTipo);
        add(jcbTipo);
        add(jbtnInserir);
        // tamanho da tela
        setSize(600,400);  
        // ícone do canto superior esquerdo
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/javaicon.png")));
        // centralizar tela
        setLocationRelativeTo(null);
        //quando clicar no X fechar a tela
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setVisible(true);  
    }
}
