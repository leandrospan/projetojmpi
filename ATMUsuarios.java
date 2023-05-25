 import javax.swing.table.AbstractTableModel;
 
/**
 * Classe de AbstractTableModel do usuarios
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class ATMUsuarios extends AbstractTableModel {
    private final String[] columnNames = {"Código", "Usuário", "Senha", "Tipo"};
    private final java.util.List<Usuario> data = new java.util.ArrayList<>();

    public void addRow(Usuario usuario) {
        data.add(usuario);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Usuario usuario = data.get(row);
        switch (column) {
            case 0:
                return usuario.getCodigo();
            case 1:
                return usuario.getUsuario();
            case 2:
                return usuario.getSenha();
            case 3:
                return usuario.getTipo();
            default:
                return null;
        }
    }
}
