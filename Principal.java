import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

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
        JMenu menu, submenu;  
        JMenuItem i1, i2, i3, i4, i5;  
        JMenuBar mb=new JMenuBar();  
        menu=new JMenu("Menu");  
        submenu=new JMenu("Sub Menu");  
        i1=new JMenuItem("Item 1");  
        i2=new JMenuItem("Item 2");  
        i3=new JMenuItem("Item 3");  
        i4=new JMenuItem("Item 4");  
        i5=new JMenuItem("Item 5");  
        menu.add(i1); menu.add(i2); menu.add(i3);  
        submenu.add(i4); submenu.add(i5);  
        menu.add(submenu);  
        mb.add(menu);  
        setJMenuBar(mb);  
        setSize(400,400);  
        setLayout(null);  
        setVisible(true);  
    }  
}