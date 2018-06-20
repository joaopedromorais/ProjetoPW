
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioDao {
	
   public void cadastrarFuncionario(FuncionarioBean func) throws SQLException, ClassNotFoundException{
		
		
		String sql = "INSERT INTO funcionario VALUES (?,?,?)";
		
			
			PreparedStatement comandoSql = Conexao.getInstance().prepareStatement(sql);
			comandoSql.setInt(1,0); 
			comandoSql.setString(2,func.getNomeFunc());
			comandoSql.setString(3, func.getCpf());
						
			
			comandoSql.execute(); 
			Conexao.getInstance().commit(); 
	}

   
   public void alterarFuncionario(FuncionarioBean func) throws SQLException, ClassNotFoundException{
		String sql="UPDATE funcionario SET nomefunc=? WHERE codfunc=?";
		PreparedStatement comandoSql=Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1,func.getNomeFunc());
		comandoSql.execute();
		Conexao.getInstance().commit();
	}
   
   public void excluirFuncionario(int codfunc) throws SQLException, ClassNotFoundException{
		String sql="DELETE FROM funcionario WHERE codfunc = ?";
		PreparedStatement comandoSql= Conexao.getInstance().prepareStatement(sql);
		comandoSql.setInt(1, codfunc);
		comandoSql.execute();
		Conexao.getInstance().commit();
		
	}
   
   public List<FuncionarioBean> consultarFuncionario(String nome) throws SQLException, ClassNotFoundException{
		List<FuncionarioBean> listaFuncionarios = null;
		String sql="SELECT * FROM funcionario WHERE nomefunc LIKE ?";
		
		PreparedStatement comandoSql= Conexao.getInstance().prepareStatement(sql);
		comandoSql.setString(1, "%" + nome + "%" );
		ResultSet rs=comandoSql.executeQuery(); 
			
		listaFuncionarios = new ArrayList<FuncionarioBean>();
		
		
		while(rs.next()){
			FuncionarioBean func = new FuncionarioBean();
			func.setCodFunc(rs.getInt("codfunc"));
			func.setNomeFunc(rs.getString("nomefunc"));
						
			listaFuncionarios.add(func);
		
		}
				
		return listaFuncionarios;
	}


}
