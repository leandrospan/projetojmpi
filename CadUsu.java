import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        JLabel jlblTitulo = new JLabel("CADASTRO DE USUÁRIOS");
        JLabel jlblUsuario = new JLabel("Usuário: ");
        JTextField jtfUsuario = new JTextField();
        jtfUsuario.setPreferredSize(new Dimension(100, 20));
        JLabel jlblSenha = new JLabel("Senha: ");
        JTextField jtfSenha = new JTextField();
        jtfSenha.setPreferredSize(new Dimension(100, 20));
        JLabel jlblTipo = new JLabel("Tipo: ");
        String[] tipos = {"Administrador", "Usuário"};
        JComboBox jcbTipo = new JComboBox<>(tipos);
        JButton jbtnInserir = new JButton("SALVAR");
        jbtnInserir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String u = jtfUsuario.getText();
                String s = jtfSenha.getText();
                String t = String.valueOf(jcbTipo.getSelectedItem());
                JOptionPane.showMessageDialog(null, "Usuário : " + u + "\nSenha: " + s + "\nTipo: "+ t);
                try{
                    Class.forName("org.mariadb.jdbc.Driver").newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/banco01", "root", "etec8");
                    String sql = "INSERT INTO usuarios ("
                    + " usuario,"
                    + " senha,"
                    + " tipo) VALUES ("
                    + "?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, u);
                    pstmt.setString(2, s);
                    pstmt.setString(3, t);
                    pstmt.executeUpdate();
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception er) {
                    er.printStackTrace();
                } 
            }
        });
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbl.setConstraints(jlblTitulo, gbc);
        add(jlblTitulo);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbl.setConstraints(jlblUsuario, gbc);
        add(jlblUsuario);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbl.setConstraints(jtfUsuario, gbc);
        add(jtfUsuario);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbl.setConstraints(jlblSenha, gbc);
        add(jlblSenha);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbl.setConstraints(jtfSenha, gbc);
        add(jtfSenha);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbl.setConstraints(jlblTipo, gbc);
        add(jlblTipo);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbl.setConstraints(jcbTipo, gbc);
        add(jcbTipo);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbl.setConstraints(jbtnInserir, gbc);
        add(jbtnInserir);
        // tamanho da tela
        setSize(300,200);  
        // ícone do canto superior esquerdo
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/javaicon.png")));
        // centralizar tela
        setLocationRelativeTo(null);
        //quando clicar no X fechar a tela
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setVisible(true);  
    }
}
