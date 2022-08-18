import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class usuarioDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void cadastrar(usuario usu) {

		String sql = "INSERT INTO usuario(email, senha)" + " VALUES(?,?)";

		try {
			conn = conexaoBD.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setNString(1, usu.getEmail());
			pstm.setInt(2, usu.getSenha());
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public usuario verificar(String usu) {
		String sql = "SELECT * FROM usuario WHERE email IN (?);";
		ResultSet rset = null;
		usuario usuar = new usuario();
		try {
			conn = conexaoBD.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usu);
			
			rset = pstm.executeQuery();
			rset.next();
			usuar.setEmail(rset.getString("email"));
			usuar.setSenha(rset.getInt("senha"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
		return usuar;
	}
	
	
}
