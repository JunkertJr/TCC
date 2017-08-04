package aula20160919.repositoryJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class CorRepositoryPersistent implements CorRepository {

	public CorRepositoryPersistent() {
	}

	@Override
	public void incluir(Cor cor) {
		try {
			Connection conexao = abrirConexao();
			PreparedStatement insert = conexao
					.prepareStatement("insert into cor (codigo, nome) values (?,?)"); //$NON-NLS-1$
			insert.setString(1, cor.getCodigo());
			insert.setString(2, cor.getNome());
			insert.execute();
			insert.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<Cor> getTodas() {
		try {
			Connection conexao = abrirConexao();
			PreparedStatement select = conexao
					.prepareStatement("select codigo, nome from cor"); //$NON-NLS-1$
			ResultSet resultado = select.executeQuery();
			Set<Cor> cores = new HashSet<>();
			while (resultado.next()) {
				Cor nova = new Cor(
						resultado.getString("codigo"), resultado.getString("nome")); //$NON-NLS-1$ //$NON-NLS-2$
				cores.add(nova);
			}
			select.close();
			conexao.close();
			return cores;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new HashSet<>();
	}

	@Override
	public boolean excluir(String codigoParaExclusao) {
		try {
			Connection conexao = abrirConexao();
			PreparedStatement delete = conexao
					.prepareStatement("delete from cor where codigo = ?"); //$NON-NLS-1$
			delete.setString(1, codigoParaExclusao);
			boolean retorno = delete.execute();
			delete.close();
			conexao.close();
			return retorno;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private Connection abrirConexao() {
		try {
			Connection conexao = DriverManager.getConnection(
					Messages.getString("db-url"),
					Messages.getString("db-user"),
					Messages.getString("db-password"));
			conexao.createStatement().execute(
					"create table if not exists cor ( " //$NON-NLS-1$
							+ "codigo varchar(40) not null primary key," //$NON-NLS-1$
							+ "nome varchar(200) not null unique" //$NON-NLS-1$
							+ ")"); //$NON-NLS-1$
			return conexao;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
