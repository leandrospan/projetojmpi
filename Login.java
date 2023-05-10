import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de login do sistema.
 * 
 * @author Leandro Spanghero - Fera 
 * @version 1.0 - 08/05/2023
 */
public class Login extends JFrame
{
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/banco01";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "etec8";
    /**
     * Construtor para objetos da classe Login
     */
    public Login() {
        // tamanho da tela
        setSize(250,200);
        
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
        gbc.gridwidth = 4;
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
        gbc.gridwidth = 4;
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
        
        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.mariadb.jdbc.Driver").newInstance();

            //STEP 3: Open a connection
            System.out.println("Conectando no banco de dados selecionado...");
            conn = DriverManager.getConnection("jdbc:mariadb://localhost/banco01", "root", "etec8");
            System.out.println("Banco de dados conectado com sucesso...");

            
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    conn.close();
                }
            } catch (SQLException se) {
            }// do nothing
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Tchau!");
    
    }
}
