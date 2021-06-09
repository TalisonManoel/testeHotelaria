package br.edu.unifacema.model.dao;

import br.edu.unifacema.conexao.ConnectionFactory;
import br.edu.unifacema.model.bean.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ClienteDAO {
//Método para inserir dados. 
    public void create (Cliente p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO cliente (nome, cpf, situacao, id_quarto) VALUES (?,?,?,?)");
            stmt.setString(1,   p.getNome());
            stmt.setString(2,   p.getCpf());
            stmt.setString(3,   p.getSituacao());
            stmt.setInt(4, p.getId_quarto());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    }

//Método para ler dados.     
    public List<Cliente> read() {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        List <Cliente> clientes = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM cliente");
            rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSituacao(rs.getString("situacao"));
                cliente.setId_quarto(rs.getInt("id_quarto"));
                cliente.setCheckin(rs.getTimestamp("checkin"));
                
                clientes.add(cliente);               
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro na leitura: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return clientes;
    }
    
//Método para ler dados especificos.     
    public List<Cliente> readForDesc(String desc) throws SQLException {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        List <Cliente> clientes = new ArrayList<>();
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM nome LIKE ?");
            stmt.setString(1, "%"+desc+"%");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setSituacao(rs.getString("situacao"));
                cliente.setId_quarto(rs.getInt("id_quarto"));
                cliente.setCheckin(rs.getTimestamp("checkin"));
                
                clientes.add(cliente);               
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro na leitura: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return clientes;
    }

//Método para atualizar dados. 
    public void update (Cliente p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE cliente SET nome = ?, cpf = ?, situacao = ?, id_quarto = ?, checkin = ? WHERE id_cliente = ?");
            stmt.setString(1,   p.getNome());
            stmt.setString(2,   p.getCpf());
            stmt.setString(3,   p.getSituacao());
            stmt.setInt(4, p.getId_quarto());
            stmt.setTimestamp(5, p.getCheckin());
            stmt.setInt(6, p.getId_cliente());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    }

//Método para excluir dados. 
    public void delete (Cliente p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM cliente WHERE id_cliente = ?");
            stmt.setInt(1, p.getId_cliente());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    }    
}
