import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {

	private FuncionarioDao funcDao;
	
	public FuncionarioController(){
		funcDao = new FuncionarioDao();
	}
	
	public void cadastrarFuncionario(FuncionarioBean func) throws SQLException, ClassNotFoundException{
		funcDao.cadastrarFuncionario(func);
	}
	
	public void excluirFuncionario(int codFunc) throws SQLException, ClassNotFoundException{
		funcDao.excluirFuncionario(codFunc);
	}
	
	public void alterarFuncionario(FuncionarioBean func) throws SQLException, ClassNotFoundException{
		funcDao.alterarFuncionario(func);
	}
	
	public List<FuncionarioBean> consultarFuncionario(String nome) throws SQLException, ClassNotFoundException{
		 return funcDao.consultarFuncionario(nome);
	}
	
	
	
}
