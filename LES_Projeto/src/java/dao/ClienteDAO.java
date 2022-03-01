    
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.EntidadeDominio;
import domain.Cliente;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO extends AbstractDAO {
	
	public ClienteDAO() {
            super ("tb_cliente", "cli_id");//construtor da superclasse AbstractDAO
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
                
            try {
                openConnection();
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                PreparedStatement pst = null;
                Cliente cliente = (Cliente) entidade;
                
		try {
			connection.setAutoCommit(false);
                        
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cliente(nome, genero, dtnascimento, cpf, telefone,");
			sql.append("email, senha) VALUES (?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString());
                        
                        pst.setString(1, cliente.getNome());
                        pst.setString(2, cliente.getGenero());
			pst.setObject(3, cliente.getDtNascimento());
                        pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getTelefone());
                        pst.setString(6, cliente.getEmail());
                        pst.setString(7, cliente.getSenha());
                        
			pst.executeUpdate();	
			
			connection.commit();	
			
                    } catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
                                connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void alterar(EntidadeDominio entidade) {
            try {
                openConnection();
            } catch (Exception ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		PreparedStatement pst = null;
		Cliente cliente = (Cliente)entidade;
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_cliente SET nome=?, genero=?, dtnascimento=?, cpf=?, telefone=?, email=?, senha=? WHERE cli_id=?");
			
                        pst = connection.prepareStatement(sql.toString());
                        
			pst.setString(1, cliente.getNome());
                        pst.setString(2, cliente.getGenero());
                        pst.setObject(3, cliente.getDtNascimento());
                        pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getTelefone());	
                        pst.setString(6, cliente.getEmail());
			pst.setString(7, cliente.getSenha());
                        pst.setInt(8, cliente.getId());
                        
                        pst.executeUpdate();
                        
			connection.commit();		
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				//pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
			
                    PreparedStatement pst = null;
			
                    Cliente cliente = (Cliente)entidade;
                    String sql=null;

                    if(cliente.getNome() == null){//se parâmetro nome for null
                            cliente.setNome(""); //altera para vazio
                    }
                    if(cliente.getCpf() == null){
                            cliente.setCpf("");
                    }
                    if(cliente.getSenha() == null){
                            cliente.setSenha("");
                    }
                    if(cliente.getId() == 0 && cliente.getNome().equals("") && !cliente.getCpf().equals("") && !cliente.getSenha().equals("")){
                            sql = "SELECT * FROM tb_cliente WHERE cpf=? AND senha=?";
                    }else if(cliente.getId() == 0 && cliente.getNome().equals("")){//se não definir os parâmetros id e nome
                            sql = "SELECT * FROM tb_cliente ORDER BY nome";//seleciona todos os elementos da tabela
                    }else if(cliente.getId() != 0 && cliente.getNome().equals("")){//se definir o parâmetro id
                            sql = "SELECT * FROM tb_cliente WHERE cli_id=? ORDER BY nome";//seleciona o elemento a partir do id
                    }else if(cliente.getId() == 0 && !cliente.getNome().equals("")){//se definir o parâmetro nome
                            sql = "SELECT * FROM tb_cliente WHERE nome like ? ORDER BY nome";//seleciona o elemento a partir da descrição
                    }else if(cliente.getId() != 0 && !cliente.getNome().equals("")){
                            sql = "SELECT * FROM tb_cliente WHERE cli_id=? ORDER BY nome";
                    }
                    try {
                            openConnection();
                            pst = connection.prepareStatement(sql);//executa a query no BD de acordo com os IF's

                            if(cliente.getId() == 0 && cliente.getNome().equals("") && !cliente.getCpf().equals("") && !cliente.getSenha().equals("")){
                                pst.setString(1, cliente.getCpf());
                                pst.setString(2, cliente.getSenha());
                            }else if(cliente.getId() != 0 && cliente.getNome().equals("")){
                                    pst.setInt(1, cliente.getId());
                            }else if(cliente.getId() == 0 && !cliente.getNome().equals("")){
                                    pst.setString(1, "%"+cliente.getNome()+"%");			
                            }else if(cliente.getId() != 0 && !cliente.getNome().equals("")){
                                    pst.setInt(1, cliente.getId());
                            }
                            

                            ResultSet rs = pst.executeQuery();
                            List<EntidadeDominio> clientes = new ArrayList<>();
                            while (rs.next()) {//loop para adicionar em clientes[] os elementos da tabela
                                    Cliente c = new Cliente();
                                    c.setId(rs.getInt("cli_id"));
                                    c.setNome(rs.getString("nome"));
                                    c.setGenero(rs.getString("genero"));
                                    Date d = (rs.getDate("dtnascimento"));
                                    c.setDtNascimento(d.toLocalDate());
                                    c.setCpf(rs.getString("cpf"));
                                    c.setTelefone(rs.getString("telefone"));
                                    c.setEmail(rs.getString("email"));
                                    c.setSenha(rs.getString("senha"));
                                    clientes.add(c);
                            }
                            return clientes;
                    } catch (SQLException e) {
                            e.printStackTrace();
                    } catch (Exception ex) {
                Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                    return null;
        }
}