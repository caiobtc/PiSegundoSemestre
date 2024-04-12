
package com.mycompany.exemplopdv.dao;

import com.mycompany.exemplopdv.models.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author henri
 */
public class ClienteDAO {
    
    static String URL = "jdbc:musql://localhost:3306/exemplopdv";
    static String login = "root";
    static String senha = "Caio25121998@";
    
    
    
    public static boolean salvar(Cliente obj) {
        Connection conexao = null;
        
        boolean retorno = false;
        
        try {
            
            //1) Carregar o driver o mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Fazer conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //3) Preparar o comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement (
                        "INSERT INTO cliente (nomeCliente, cpf, emailCliente) VALUES (?,?,?);"
            );
            
            
            instrucaoSQL.setString(1, obj.getNomeCliente());
            instrucaoSQL.setString(2, obj.getCPF());
            instrucaoSQL.setString(3, obj.getEmailCliente());
            
            
            //4) Executar o comando
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            
            }        
            
            
        } catch(ClassNotFoundException e) {        
            System.out.println("Driver nao encontrado");   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        } finally {
            if(conexao!=null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return retorno;
    }
    
    public static ArrayList<Cliente> listar(){
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        Connection conexao = null;
        ResultSet rs = null;
        
        try {
            //1) Carregar o driver o mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Fazer conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //3) Preparar o comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement (
                        "SELECT * FROM Cliente"
            );
            
            //4) Executar comando SQL
            rs = instrucaoSQL.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    int id = rs.getInt("idCliente");
                    String nome = rs.getString("nomeCliente");
                    String CPF = rs.getString("CPF");
                    String email = rs.getString("emailCliente");
                    
                    Cliente item = new Cliente(id, nome, email, CPF);
                    listaRetorno.add(item);
                }
            }
            
        } catch (Exception e) {
            listaRetorno = null;
            
        } finally {
            
            if(conexao != null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            
        }
        
        return listaRetorno;
    }
    
     public static boolean alterar(Cliente obj) {
        Connection conexao = null;
        
        boolean retorno = false;
        
        try {
            
            //1) Carregar o driver o mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Fazer conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //3) Preparar o comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement (
                        "UPDATE cliente SET nomeCliente=?, emailCliente=? WHERE idCliente = ?;"
            );
            
            
            instrucaoSQL.setString(1, obj.getNomeCliente());
            instrucaoSQL.setString(2, obj.getEmailCliente());
            instrucaoSQL.setInt(3, obj.getIdCliente());

            
            
            //4) Executar o comando
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            
            }        
            
            
        } catch(ClassNotFoundException e) {        
            System.out.println("Driver nao encontrado");   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        } finally {
            if(conexao!=null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return retorno;
    }
     
    public static boolean excluir(int idExcluir) {
        Connection conexao = null;
        
        boolean retorno = false;
        
        try {
            
            //1) Carregar o driver o mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //2) Fazer conexao com o banco
            conexao = DriverManager.getConnection(URL, login, senha);
            
            //3) Preparar o comando SQL
            PreparedStatement instrucaoSQL = conexao.prepareStatement (
                        "DELETE FROM Cliente WHERE idCliente = ?;"
            );
            
            instrucaoSQL.setInt(1, idExcluir);
            
            //4) Executar o comando
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            
            if(linhasAfetadas>0){
                retorno = true;
            
            }        
            
            
        } catch(ClassNotFoundException e) {        
            System.out.println("Driver nao encontrado");   
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        } finally {
            if(conexao!=null) {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        return retorno;
    } 
    
}
