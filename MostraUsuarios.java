import javax.swing.JFrame;
import javax.swing.JTable;
//import javax.swing.table.AbstractTableModel;
import javax.swing.JScrollPane;
//import javax.swing.*;
import java.sql.*;
/**
 * Lista os Usuários Cadastrados
 * 
 * @author Leandro Spanghero - Fera
 * @version 24/05/2023
 */
public class MostraUsuarios extends JFrame
{
    /**
     * Construtor para objetos da classe MostraUsuarios
     */
    public MostraUsuarios()
    {
        super("Exemplo de JTable");

        ATMUsuarios modeloTabela = new ATMUsuarios();
        JTable tabela = new JTable(modeloTabela);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/banco01", "root", "etec8");
            String sql = "SELECT * FROM usuarios";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codusu");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                String tipo = rs.getString("tipo");

                modeloTabela.addRow(new Usuario(codigo, usuario, senha, tipo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(tabela);
        getContentPane().add(sp);

        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
