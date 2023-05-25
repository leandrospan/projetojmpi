
/**
 * Classe Usuário
 * 
 * @author Leandro Spanghero - Fera
 * @version 24/05/2023
 */
public class Usuario
{
    private final int codigo;
        private final String usuario;
        private final String senha;
        private final String tipo;

        public Usuario(int codigo, String usuario, String senha, String tipo) {
            this.codigo = codigo;
            this.usuario = usuario;
            this.senha = senha;
            this.tipo = tipo;
        }

        public int getCodigo() {
            return codigo;
        }

        public String getUsuario() {
            return usuario;
        }

        public String getSenha() {
            return senha;
        }

        public String getTipo() {
            return tipo;
        }
}
