package br.edu.unifacema.model.dao;

import br.edu.unifacema.conexao.ConnectionFactory;
import br.edu.unifacema.model.bean.Quarto;
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
public class QuartoDAO {
    
//Método para inserir dados. 
    public void create (Quarto p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("INSERT INTO quarto (numero, andar, preco, estado, periodo) VALUES(?,?,?,?,?)");
            stmt.setInt(1,   p.getNumero());
            stmt.setInt(2,   p.getAndar());
            stmt.setDouble(3,   p.getPreco());
            stmt.setString(4, p.getEstado());
            stmt.setInt(5, p.getPeriodo());           
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Salvo com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    }

//Método para ler dados.     
    public List<Quarto> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        List <Quarto> quartos = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM quarto");
            rs = stmt.executeQuery();
            while(rs.next()){
                Quarto quarto = new Quarto();
                quarto.setId_quarto(rs.getInt("id_quarto"));
                quarto.setNumero(rs.getInt("numero"));
                quarto.setAndar(rs.getInt("andar"));
                quarto.setPreco(rs.getDouble("preco"));
                quarto.setEstado(rs.getString("estado"));
                quarto.setPeriodo(rs.getInt("periodo"));
                
                quartos.add(quarto);               
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro na leitura: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return quartos;
    }
    
//Método para ler dados especificos.     
    public Quarto readForId(int id){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        Quarto quarto = new Quarto();
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM quarto WHERE id_quarto = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                
                quarto.setNumero(rs.getInt("numero"));
                quarto.setAndar(rs.getInt("andar"));
                quarto.setPreco(rs.getDouble("preco"));
                quarto.setEstado(rs.getString("estado"));
                quarto.setPeriodo(rs.getInt("periodo"));
                               
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro na leitura: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return quarto;
    }

//Método para atualizar dados. 
    public void update (Quarto p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("UPDATE quarto SET numero = ?, andar = ?, preco = ?, estado = ?, periodo = ? WHERE id_quarto = ?");
            stmt.setInt(1,   p.getNumero());
            stmt.setInt(2,   p.getAndar());
            stmt.setDouble(3,   p.getPreco());
            stmt.setString(4, p.getEstado());
            stmt.setInt(5, p.getPeriodo());
            stmt.setInt(6, p.getId_quarto());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Atualizado com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    }

//Método para excluir dados. 
    public void delete (Quarto p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM quarto WHERE id_quarto = ?");
            stmt.setInt(1, p.getId_quarto());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Excluido com sucesso.");
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro ao excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);}        
    }    
    
}
