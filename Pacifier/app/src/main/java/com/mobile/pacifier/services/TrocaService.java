package com.mobile.pacifier.services;

import com.mobile.pacifier.config.DatabaseManager;
import com.mobile.pacifier.model.PedidoTroca;
import com.mobile.pacifier.model.Troca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrocaService {

    private static final String TAG = "TrocaService";

    public List<Troca> listarTrocaByPedidoAntigo(Long cpf) {
        List<Troca> trocas = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM pedido_troca WHERE cpf_usuario=?");
            statement.setLong(1, cpf);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                PedidoTroca pedidoTroca = new PedidoTroca();
                pedidoTroca.setCodPedidoTroca(rs.getLong("cod_pedido_troca"));
                pedidoTroca.setStatusDestinatario(rs.getString("status_destinatario"));
                pedidoTroca.setStatusRemetente(rs.getString("status_remetente"));
                pedidoTroca.setCodTroca(rs.getLong("cod_troca"));

                PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM troca WHERE cod_troca=" + pedidoTroca.getCodTroca());
                ResultSet rs2 = statement2.executeQuery();
                while (rs2.next()) {
                    Troca troca = new Troca();
                    troca.setCodTroca(rs2.getLong("cod_troca"));
                    troca.setNomeTroca(rs2.getString("nome_troca"));
                    troca.setCodImagem(rs2.getLong("cod_imagem"));
                    troca.setStatusDestinatario(pedidoTroca.getStatusDestinatario());
                    troca.setStatusRemetente(pedidoTroca.getStatusRemetente());

                    PreparedStatement statement3 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM imagem WHERE cod_imagem=" + troca.getCodImagem());
                    ResultSet rs3 = statement3.executeQuery();

                    if (rs3.next()) {
                        troca.setUrlImagem(rs3.getString("url"));

                        trocas.add(troca);
                    }

                }

                rs2.close();
                statement2.close();
                DatabaseManager.getConnection().close();
            }

            rs.close();
            statement.close();
            DatabaseManager.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return trocas;
    }

    public List<Troca> listarTrocaByPedido(Long cpf) {
        List<Troca> trocas = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT t.cod_troca, t.nome_troca, t.cod_imagem, pt.status_destinatario, pt.status_remetente, i.url FROM pedido_troca pt JOIN troca t ON pt.cod_troca = t.cod_troca JOIN imagem i ON t.cod_imagem = i.cod_imagem WHERE pt.cpf_usuario=?");
            statement.setLong(1, cpf);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Troca troca = new Troca();
                    troca.setCodTroca(rs.getLong("cod_troca"));
                    troca.setNomeTroca(rs.getString("nome_troca"));
                    troca.setCodImagem(rs.getLong("cod_imagem"));
                    troca.setStatusDestinatario(rs.getString("status_destinatario"));
                    troca.setStatusRemetente(rs.getString("status_remetente"));
                    troca.setUrlImagem(rs.getString("url"));

                    trocas.add(troca);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return trocas;
    }

    public List<Troca> listarTrocaByPedidoSemImagem(Long cpf) {
        List<Troca> trocas = new ArrayList<>();

        try {
            // Consulta principal
            String consulta = "SELECT t.cod_troca, t.nome_troca, pt.status_destinatario, pt.status_remetente "
                    + "FROM pedido_troca pt "
                    + "INNER JOIN item_pedido_troca ipt ON pt.cod_pedido_troca = ipt.cod_pedido_troca "
                    + "INNER JOIN troca t ON ipt.cod_troca = t.cod_troca "
                    + "WHERE pt.cpf_usuario = ?";
            PreparedStatement ps = DatabaseManager.getConnection().prepareStatement(consulta);
            ps.setLong(1, cpf);
            ResultSet rs = ps.executeQuery();

            // Loop principal
            while (rs.next()) {
                Troca troca = new Troca();
                troca.setCodTroca(rs.getLong("cod_troca"));
                troca.setNomeTroca(rs.getString("nome_troca"));
                troca.setStatusDestinatario(rs.getString("status_destinatario"));
                troca.setStatusRemetente(rs.getString("status_remetente"));
                trocas.add(troca);
            }

            // Fechando as conexões
            rs.close();
            ps.close();
            DatabaseManager.getConnection().close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return trocas;
    }

}
