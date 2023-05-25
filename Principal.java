import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

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
        /*JMenu menu, submenu;  
        JMenuItem i1, i2, i3, i4, i5;  
        JMenuBar mb=new JMenuBar();  
        menu=new JMenu("Menu");  
        submenu=new JMenu("Sub Menu");  
        i1=new JMenuItem("Item 1");  
        i2=new JMenuItem("Item 2");  
        i3=new JMenuItem("Item 3");  
        i4=new JMenuItem("Item 4");  
        i5=new JMenuItem("Item 5");  
        menu.add(i1); 
        menu.add(i2); 
        menu.add(i3);  
        submenu.add(i4); 
        submenu.add(i5);  
        menu.add(submenu);  
        mb.add(menu);  
        setJMenuBar(mb);*/
        super("..:: PRINCIPAL ::..");
        // Criacão da barra de Menu
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        // Criacão de menu
        JMenu jmCad = new JMenu("Cadastros");
        // Criacão de item do menu
        JMenuItem jmiUsuarios = new JMenuItem("Usuários"); 
        jmiUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                CadUsu cu = new CadUsu();
                cu.setVisible(true);
            }
        });
        JMenuItem jmiMostraUsuarios = new JMenuItem("Lista Usuários"); 
        jmiMostraUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                MostraUsuarios mu = new MostraUsuarios();
                mu.setVisible(true);
            }
        });
        
        jmCad.add(jmiUsuarios);
        jmCad.add(jmiMostraUsuarios);
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