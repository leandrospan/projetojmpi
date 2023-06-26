import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Tela principal do sistema
 *
 * @author Leandro Spanghero - Fera
 * @version 1.0 - 18/05/2023
 */
public class Principal extends JFrame
{
    /**
     * Construtor para objetos da classe Principal
     */
    public Principal() {
        super("..:: PRINCIPAL ::..");
        // Criacão da barra de Menu
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        // Criacão de menu
        JMenu jmCad = new JMenu("Cadastros");
        // Criacão de item do menu
        JMenuItem jmiCadUsuarios = new JMenuItem("Usuários");
        jmiCadUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                CadUsu cu = new CadUsu();
                cu.setVisible(true);
            }
        });
        JMenuItem jmiCadClientes = new JMenuItem("Clientes");
        jmiCadClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                CadCli cc = new CadCli();
                cc.setVisible(true);
            }
        });
        
        jmCad.add(jmiCadUsuarios);
        jmCad.add(jmiCadClientes);
        mb.add(jmCad);
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