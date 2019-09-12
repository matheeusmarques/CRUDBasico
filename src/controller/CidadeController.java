/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import crud.modelo.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class CidadeController {

    public void inserir(String nome, int idestado) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("insert into cidade (nome, idestado) values (?, ?)");
            comando.setString(1, nome);
            comando.setInt(2, idestado);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void editar(String nome, int idestado, int id) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("UPDATE cidade SET nome = ?, idestado = ? WHERE id = ?");
            comando.setString(1, nome);
            comando.setInt(2, idestado);
            comando.setInt(3, id);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void excluir(int id) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("DELETE * FROM cidade WHERE id = ?");
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }
}
