
package dao;

import domain.Cidade;
import domain.Cliente;
import domain.Endereco;
import domain.EntidadeDominio;
import domain.Estado;
import domain.Pais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnderecoDAO extends AbstractDAO {
    
    public EnderecoDAO() {
            super ("tb_endereco", "end_id");//construtor da superclasse AbstractDAO
	}
    
    @Override
    public void salvar(EntidadeDominio entidade) {
                
            try {
                openConnection();
            } catch (Exception ex) {
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                PreparedStatement pst = null;
                Endereco endereco = (Endereco) entidade;
                
		try {
			connection.setAutoCommit(false);
                        
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_endereco(tpendereco, tpresidencia, tplogradouro, cep, logradouro,numero,");
			sql.append("complemento, bairro, cidade, estado , pais, observacoes, id_cli) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString());//, Statement.RETURN_GENERATED_KEYS);
                        
                        pst.setString(1, endereco.getTpEndereco());
                        pst.setString(2, endereco.getTpResidencia());
			pst.setString(3, endereco.getTpLogradouro());
                        pst.setString(4, endereco.getCep());
			pst.setString(5, endereco.getLogradouro());
                        pst.setString(6, endereco.getNumero());
                        pst.setString(7, endereco.getComplemento());
                        pst.setString(8, endereco.getBairro());
                        pst.setString(9, endereco.getCidade().getDescricao());
                        pst.setString(10, endereco.getCidade().getEstado().getDescricao());
                        pst.setString(11, endereco.getCidade().getEstado().getPais().getDescricao());
                        pst.setString(12, endereco.getObservacoes());
                        pst.setInt(13, endereco.getCliente().getId());
                        
			pst.executeUpdate();	
			
			/*ResultSet rs = pst.getGeneratedKeys();	
			if(rs.next())
                            cliente.setId(rs.getInt(1));*/  		
			
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
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		PreparedStatement pst = null;
		Endereco endereco = (Endereco)entidade;
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_endereco SET tpendereco=?, tpresidencia=?, tplogradouro=?, cep=?, logradouro=?, numero=?, complemento=?,");
                        sql.append("bairro=?, cidade=?, estado=?, pais=?, observacoes=?, id_cli=? WHERE end_id=?");
			
                        pst = connection.prepareStatement(sql.toString());
                        
			pst.setString(1, endereco.getTpEndereco());
                        pst.setString(2, endereco.getTpResidencia());
			pst.setString(3, endereco.getTpLogradouro());
                        pst.setString(4, endereco.getCep());
			pst.setString(5, endereco.getLogradouro());
                        pst.setString(6, endereco.getNumero());
                        pst.setString(7, endereco.getComplemento());
                        pst.setString(8, endereco.getBairro());
                        pst.setString(9, endereco.getCidade().getDescricao());
                        pst.setString(10, endereco.getCidade().getEstado().getDescricao());
                        pst.setString(11, endereco.getCidade().getEstado().getPais().getDescricao());
                        pst.setString(12, endereco.getObservacoes());
                        pst.setInt(13, endereco.getCliente().getId());
                        pst.setInt(14, endereco.getId());
                        
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
			
                    Endereco endereco = (Endereco)entidade;
                    String sql=null;

                    if(endereco.getLogradouro() == null){//se parâmetro logradouro for null
                            endereco.setLogradouro(""); //altera para vazio
                    }
                    
                    if(endereco.getCliente().getId() != 0){
                            sql = "SELECT * FROM tb_endereco WHERE id_cli=?";
                    }else if(endereco.getId() == 0 && endereco.getLogradouro().equals("")){//se não definir os parâmetros id e nome
                            sql = "SELECT * FROM tb_endereco";//seleciona todos os elementos da tabela
                    }else if(endereco.getId() != 0 && endereco.getLogradouro().equals("")){//se definir o parâmetro id
                            sql = "SELECT * FROM tb_endereco WHERE end_id=?";//seleciona o elemento a partir do id
                    }else if(endereco.getId() == 0 && !endereco.getLogradouro().equals("")){//se definir o parâmetro nome
                            sql = "SELECT * FROM tb_endereco WHERE nome like ?";//seleciona o elemento a partir da descrição
                    }
                    
                    try {
                            openConnection();
                            pst = connection.prepareStatement(sql);//executa a query no BD de acordo com os IF's

                            if(endereco.getCliente().getId() != 0){
                                    pst.setInt(1, endereco.getCliente().getId());
                            }else if(endereco.getId() != 0 && endereco.getLogradouro().equals("")){
                                    pst.setInt(1, endereco.getId());
                            }else if(endereco.getId() == 0 && !endereco.getLogradouro().equals("")){
                                    pst.setString(1, "%"+endereco.getLogradouro()+"%");			
                            }else if(endereco.getId() != 0 && !endereco.getLogradouro().equals("")){
                                    pst.setInt(1, endereco.getId());
                            }
                            

                            ResultSet rs = pst.executeQuery();
                            List<EntidadeDominio> enderecos = new ArrayList<>();
                            while (rs.next()) {//loop para adicionar em clientes[] os elementos da tabela
                                    Endereco e = new Endereco();
                                    Cliente cli = new Cliente();
                                    Cidade c = new Cidade();
                                    Estado s = new Estado();
                                    Pais p = new Pais();
                                    e.setId(rs.getInt("end_id"));
                                    e.setTpEndereco(rs.getString("tpendereco"));
                                    e.setTpResidencia(rs.getString("tpresidencia"));
                                    e.setTpLogradouro(rs.getString("tplogradouro"));
                                    e.setCep(rs.getString("cep"));
                                    e.setLogradouro(rs.getString("logradouro"));
                                    e.setNumero(rs.getString("numero"));
                                    e.setComplemento(rs.getString("complemento"));
                                    e.setBairro(rs.getString("bairro"));
                                    c.setDescricao(rs.getString("cidade"));
                                    s.setDescricao(rs.getString("estado"));
                                    p.setDescricao(rs.getString("pais"));
                                    c.setEstado(s);
                                    s.setPais(p);
                                    e.setCidade(c);
                                    e.setEstado(s);
                                    e.setPais(p);
                                    e.setObservacoes(rs.getString("observacoes"));
                                    cli.setId(rs.getInt("id_cli"));
                                    e.setCliente(cli);
                                    enderecos.add(e);
                            }
                            return enderecos;
                    } catch (SQLException e) {
                            e.printStackTrace();
                    } catch (Exception ex) {
                Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                    return null;
            }
}   
