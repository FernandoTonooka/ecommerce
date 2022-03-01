
package dao;

import domain.Cartao;
import domain.Cliente;
import domain.EntidadeDominio;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CartaoDAO extends AbstractDAO {
    
    public CartaoDAO() {
            super ("tb_cartao", "car_id");//construtor da superclasse AbstractDAO
    }
    
    @Override
    public void salvar(EntidadeDominio entidade) {
                
            try {
                openConnection();
            } catch (Exception ex) {
                Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                PreparedStatement pst = null;
                Cartao cartao = (Cartao) entidade;
                
		try {
			connection.setAutoCommit(false);
                        
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cartao(bandeira, nome, numero, validade, cvv, id_cli)");
			sql.append("VALUES (?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString());
                        
                        pst.setString(1, cartao.getBandeira());
                        pst.setString(2, cartao.getNome());
			pst.setString(3, cartao.getNumero());
                        pst.setObject(4, cartao.getValidade());
			pst.setString(5, cartao.getCvv());
                        pst.setInt(6, cartao.getCliente().getId());
                        
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
                Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		PreparedStatement pst = null;
		Cartao cartao = (Cartao)entidade;
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_cartao SET bandeira=?, nome=?, numero=?, validade=?, cvv=?, id_cli=? WHERE car_id=?");
			
                        pst = connection.prepareStatement(sql.toString());
                        
			pst.setString(1, cartao.getBandeira());
                        pst.setString(2, cartao.getNome());
			pst.setString(3, cartao.getNumero());
                        pst.setObject(4, cartao.getValidade());
			pst.setString(5, cartao.getCvv());
                        pst.setInt(6, cartao.getCliente().getId());
                        pst.setInt(7, cartao.getId());
                        
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
			
                    Cartao cartao = (Cartao)entidade;
                    String sql=null;

                    if(cartao.getNome() == null){//se parâmetro logradouro for null
                            cartao.setNome(""); //altera para vazio
                    }
                    
                    if(cartao.getCliente().getId() != 0){
                            sql = "SELECT * FROM tb_cartao WHERE id_cli=?";
                    }else if(cartao.getId() == 0 && cartao.getNome().equals("")){//se não definir os parâmetros id e nome
                            sql = "SELECT * FROM tb_cartao";//seleciona todos os elementos da tabela
                    }else if(cartao.getId() != 0 && cartao.getNome().equals("")){//se definir o parâmetro id
                            sql = "SELECT * FROM tb_cartao WHERE car_id=?";//seleciona o elemento a partir do id
                    }else if(cartao.getId() == 0 && !cartao.getNome().equals("")){//se definir o parâmetro nome
                            sql = "SELECT * FROM tb_cartao WHERE nome like ?";//seleciona o elemento a partir da descrição
                    }else if(cartao.getId() != 0 && !cartao.getNome().equals("")){
                            sql = "SELECT * FROM tb_cartao WHERE car_id=?";
                    }	

                    try {
                            openConnection();
                            pst = connection.prepareStatement(sql);//executa a query no BD de acordo com os IF's

                            if(cartao.getCliente().getId() != 0){
                                    pst.setInt(1, cartao.getCliente().getId());
                            }else if(cartao.getId() != 0 && cartao.getNome().equals("")){
                                    pst.setInt(1, cartao.getId());
                            }else if(cartao.getId() == 0 && !cartao.getNome().equals("")){
                                    pst.setString(1, "%"+cartao.getNome()+"%");			
                            }else if(cartao.getId() != 0 && !cartao.getNome().equals("")){
                                    pst.setInt(1, cartao.getId());
                            }
                            

                            ResultSet rs = pst.executeQuery();
                            List<EntidadeDominio> cartoes = new ArrayList<>();
                            while (rs.next()) {
                                    Cartao c = new Cartao();
                                    Cliente cli = new Cliente();
                                    
                                    c.setId(rs.getInt("car_id"));
                                    c.setBandeira(rs.getString("bandeira"));
                                    c.setNome(rs.getString("nome"));
                                    c.setNumero(rs.getString("numero"));
                                    Date d = (rs.getDate("validade"));
                                    c.setValidade(d.toLocalDate());
                                    c.setCvv(rs.getString("cvv"));
                                    cli.setId(rs.getInt("id_cli"));
                                    c.setCliente(cli);
                                    cartoes.add(c);
                            }
                            return cartoes;
                    } catch (SQLException e) {
                            e.printStackTrace();
                    } catch (Exception ex) {
                Logger.getLogger(CartaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
                    return null;
            }
    
}
