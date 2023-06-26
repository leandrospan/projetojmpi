import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

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
import java.sql.ResultSet;

/**
 * Tela de cadastro de clientes do sistema.
 *
 * @author Leandro Spanghero - Fera
 * @version 1.0 - 30/05/2023
 */
public class CadCli extends JFrame {
    /**
     * Construtor para objetos da classe CadCli
     */
    public CadCli() {
        super("..:: CADASTRO DE CLIENTES ::..");
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        JLabel jlblTitulo = new JLabel("CADASTRO DE CLIENTES");
        JLabel jlblNome = new JLabel("Nome: ");
        JTextField jtfNome = new JTextField();
        jtfNome.setPreferredSize(new Dimension(100, 20));
        JLabel jlblSobrenome = new JLabel("Sobrenome: ");
        JTextField jtfSobrenome = new JTextField();
        jtfSobrenome.setPreferredSize(new Dimension(100, 20));
        JLabel jlblRg = new JLabel("R.G.: ");
        JTextField jtfRg = new JTextField();
        jtfRg.setPreferredSize(new Dimension(100, 20));
        JLabel jlblCpf = new JLabel("C.P.F.: ");
        JTextField jtfCpf = new JTextField();
        jtfCpf.setPreferredSize(new Dimension(100, 20));
        JLabel jlblRua = new JLabel("Rua: ");
        JTextField jtfRua = new JTextField();
        jtfRua.setPreferredSize(new Dimension(100, 20));
        JLabel jlblBairro = new JLabel("Bairro: ");
        JTextField jtfBairro = new JTextField();
        jtfBairro.setPreferredSize(new Dimension(100, 20));
        JLabel jlblNumero = new JLabel("Número: ");
        JTextField jtfNumero = new JTextField();
        jtfNumero.setPreferredSize(new Dimension(100, 20));
        JLabel jlblComplemento = new JLabel("Complemento: ");
        JTextField jtfComplemento = new JTextField();
        jtfComplemento.setPreferredSize(new Dimension(100, 20));
        JLabel jlblCep = new JLabel("CEP: ");
        JTextField jtfCep = new JTextField();
        jtfCep.setPreferredSize(new Dimension(100, 20));
        JLabel jlblCidade = new JLabel("Cidade: ");
        JTextField jtfCidade = new JTextField();
        jtfCidade.setPreferredSize(new Dimension(100, 20));
        JLabel jlblEstado = new JLabel("Estado: ");
        String[] estado = { "Acre", "Alagoes", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Paraná", "Paraíba", "Pará", "Pernambuco", "Piauí", "Rio Grande do Norte", "Rio Grande do Sul", "Rio de Janeiro", "Rondônia", "Roraima", "Santa Catarina", "Sergipe", "São Paulo", "Tocantins"};
        JComboBox jcbEstado = new JComboBox<>(estado);
        JLabel jlblSexo = new JLabel("Sexo: ");
        String[] sexo = { "Macho", "Fêmea" };
        JComboBox jcbSexo = new JComboBox<>(sexo);
        JLabel jlblEstadoCivil = new JLabel("Estado Civil: ");
        String[] civil = { "Solteiro", "Casado", "Divorciado", "Viúvo" };
        JComboBox jcbEstadoCivil = new JComboBox<>(civil);
        JLabel jlblDataNascimento = new JLabel("Data de Nascimento: ");
        JTextField jtfDataNascimento = new JTextField();
        jtfDataNascimento.setPreferredSize(new Dimension(100, 20));

        ATMUsuarios modeloTabela = new ATMUsuarios();
        JTable tabela = new JTable(modeloTabela);

        JButton jbtnInserir = new JButton("SALVAR");
        jbtnInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String no = jtfNome.getText();
                String so = jtfSobrenome.getText();
                String rg = jtfRg.getText();
                String cp = jtfCpf.getText();
                String ru = jtfRua.getText();
                String ba = jtfBairro.getText();
                String nu = jtfNumero.getText();
                String co = jtfComplemento.getText();
                String ce = jtfCep.getText();
                String ci = jtfCidade.getText();
                String es = String.valueOf(jcbEstado.getSelectedItem());
                String se = String.valueOf(jcbSexo.getSelectedItem());
                String ec = String.valueOf(jcbEstadoCivil.getSelectedItem());
                String dn = jtfDataNascimento.getText();
                JOptionPane.showMessageDialog(null, "Nome : " + no + "\nSobrenome: " + so + "\nR.G.: " + rg + "\nC.P.F. : " + cp + "\nRua: " + ru + "\nBairro: " + ba + "\nNúmero: " + nu + "\nComplemento: " + co + "\nCEP : " + ce + "\nCidade: " + ci + "\nEstado: " + es + "\nSexo: " + se + "\nEstado Civil: " + ec + "\nData de Nascimento : " + dn);
                try {
                    Class.forName("org.mariadb.jdbc.Driver");// .newInstance();
                    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/banco01", "root", "etec8");
                    String sql = "INSERT INTO clientes ( nome, sobrenome, rg, cpf, rua, bairro, numero, complemento, cep, cidade, estado, sexo, estadocivil, datanascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, no);
                    pstmt.setString(2, so);
                    pstmt.setString(3, rg);
                    pstmt.setString(4, cp);
                    pstmt.setString(5, ru);
                    pstmt.setString(6, ba);
                    pstmt.setString(7, nu);
                    pstmt.setString(8, co);
                    pstmt.setString(9, ce);
                    pstmt.setString(10, ci);
                    pstmt.setString(11, es);
                    pstmt.setString(12, se);
                    pstmt.setString(13, ec);
                    pstmt.setString(14, dn);
                    
                    pstmt.executeUpdate();
                    sql = "SELECT * FROM clientes";
                    pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery();
                    while (rs.next()) {
                        int codcli = rs.getInt("codcli");
                        String Nome = rs.getString("nome");
                        String Sobrenome = rs.getString("sobrenome");
                        String Rg = rs.getString("rg");

                        modeloTabela.addRow(new Clientes(Nome, Sobrenome, Rg, cpf, rua, bairro, numero, complemento, cep, cidade, estado, sexo, estadocivil, datanascimento));
                    }
                    conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception er) {
                    er.printStackTrace();
                }
            }
        });

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
        // getContentPane().add(sp);

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

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 6;

        JPanel jpPainel = new JPanel();
        jpPainel.add(sp);
        gbl.setConstraints(jpPainel, gbc);
        add(jpPainel);
        pack();

        // tamanho da tela
        setSize(600, 600);
        // ícone do canto superior esquerdo
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/javaicon.png")));
        // centralizar tela
        setLocationRelativeTo(null);
        // quando clicar no X fechar a tela
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

