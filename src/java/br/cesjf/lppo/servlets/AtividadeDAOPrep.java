/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo.servlets;

import br.cesjf.lppo.Atividade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aluno
 */
public class AtividadeDAOPrep {
    private PreparedStatement operacaoListarTodos;
    private PreparedStatement operacaoCriar;
        public AtividadeDAOPrep() throws Exception{
        try{
           operacaoListarTodos = ConexaoJDBC.getInstance().prepareStatement("SELECT * FROM atividade");
           operacaoCriar = ConexaoJDBC.getInstance().prepareStatement("INSERT INTO atividade(funcionario, descricao, tipo, horas) VALUES(?,?,?,?)", new String[]{"id"});
           
        }catch (SQLException ex){
            Logger.getLogger(AtividadeDAOPrep.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);   
        }
    }
    public List<Atividade> listaTodos() throws Exception {
          
        List<Atividade> todos = new ArrayList<>();
        
        try {
            ResultSet resultado = operacaoListarTodos.executeQuery();
            while (resultado.next()) {
                Atividade atab = new Atividade();
                atab.setId(resultado.getLong("id"));
                atab.setFuncionario(resultado.getString("funcionario"));
                atab.setTipo(resultado.getString("tipo"));
                atab.setHoras(resultado.getInt("horas"));
                todos.add(atab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AtividadeDAOPrep.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }

        return todos;
    }
    
    public void criar(Atividade novoAti) throws Exception {
        try {
                   
            operacaoCriar.setString(1, novoAti.getFuncionario());
            operacaoCriar.setString(2, novoAti.getDescricao());
            operacaoCriar.setString(3, novoAti.getTipo());
            operacaoCriar.setInt(4, novoAti.getHoras());
            operacaoCriar.executeUpdate();
            ResultSet keys = operacaoCriar.getGeneratedKeys();
            if(keys.next()){
                novoAti.setId(keys.getLong(1));
            }
            
        }
        catch (SQLException ex) {
            Logger.getLogger(AtividadeDAOPrep.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception(ex);
        }
    }

    
    
    
}
