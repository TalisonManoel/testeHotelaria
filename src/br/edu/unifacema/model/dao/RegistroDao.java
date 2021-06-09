package br.edu.unifacema.model.dao;

import br.edu.unifacema.conexao.ConnectionFactory;
import br.edu.unifacema.model.bean.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author talison
 */
public class RegistroDao {
//Método para inserir dados. 
    public void create (Registro p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO registro (registro) VALUES(?)");
            stmt.setString(1,   p.getRegistro());           
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    }

//Método para ler dados.     
    public List<Registro> read() throws SQLException {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        List <Registro> registros = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM registro");
            rs = stmt.executeQuery();
            while(rs.next()){
                Registro registro = new Registro();
                registro.setRegistro(rs.getString("registro"));
                registro.setData(rs.getTimestamp("data"));
                registro.setId_registro(rs.getInt("id_registro"));
                
                registros.add(registro);               
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro na leitura: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return registros;
    }
    
//Método para ler dados especificos.     
    public List<Registro> readForDesc(String desc) throws SQLException {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        List <Registro> registros = new ArrayList<>();
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM registro LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Registro registro = new Registro();
                registro.setRegistro(rs.getString("registro"));
                registro.setData(rs.getTimestamp("data"));
                registro.setId_registro(rs.getInt("id_registro"));
                
                registros.add(registro);               
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro na leitura: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return registros;
    }

//Método para excluir dados. 
    public void delete (Registro p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM registro WHERE id_registro = ?");
            stmt.setInt(1, p.getId_registro());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    } 
}
