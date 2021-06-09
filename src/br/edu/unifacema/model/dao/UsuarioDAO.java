package br.edu.unifacema.model.dao;

import br.edu.unifacema.conexao.ConnectionFactory;
import br.edu.unifacema.model.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author talison
 */
public class UsuarioDAO {

//Método para validar login.     
    public boolean login(String usuario, String senha){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;        
        boolean check = false;
        
        try{
            
            stmt = con.prepareStatement("SELECT * FROM login WHERE usuario = ? and senha = ?");
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){                          
                check = true;
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return check;
    }
    
}
