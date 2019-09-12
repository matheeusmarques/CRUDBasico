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

/**
 *
 * @author aluno
 */
public class EstadoController {

    public void inserir(String sigla, String nome) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("insert into estado (sigla, nome) values (?, ?)");
            comando.setString(1, sigla);
            comando.setString(2, nome);
            comando.executeUpdate();
            comando.close();
            conexao.close();
            System.out.println("ok");
        } catch (SQLException ex) {

        }
    }

    public void editar(String nome, String sigla, int id) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("UPDATE estado SET nome = ?, sigla = ? WHERE id = ?");
            comando.setString(1, sigla);
            comando.setString(2, nome);
            comando.setString(2, nome);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void excluir(int id) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("DELETE * FROM estado WHERE id = ?");
            comando.setInt(1, id);
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }
}
