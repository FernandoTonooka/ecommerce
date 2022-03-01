
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.EntidadeDominio;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConnectionFactory;


public abstract class AbstractDAO implements IDAO {

	protected Connection connection;
        protected String table;
        protected String idTable;
        protected boolean ctrTransacao=true;
        
        public AbstractDAO(Connection connection, String table, String idTable){
            this.connection=connection;
            this.table=table;
            this.idTable=idTable;
        }
        
        public AbstractDAO( String table, String idTable){
            this.table=table;
            this.idTable=idTable;
        }
        
        @Override
        public void excluir(EntidadeDominio entidade) {		
            try {
                openConnection();
            } catch (Exception ex) {
                Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
		PreparedStatement pst=null;		
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(table);
		sb.append(" WHERE ");
		sb.append(idTable);
		sb.append("=");
		sb.append("?");	
		try {
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sb.toString());
			pst.setInt(1, entidade.getId());

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
				pst.close();
				if(ctrTransacao)
					connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
        
	protected void openConnection() throws Exception{
		try {
                        if(connection == null || connection.isClosed())
                            connection = ConnectionFactory.getConnectionMysql();
                } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}