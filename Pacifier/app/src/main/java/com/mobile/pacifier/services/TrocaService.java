package com.mobile.pacifier.services;

import com.mobile.pacifier.config.DatabaseManager;
import com.mobile.pacifier.model.ItemPedidoTroca;
import com.mobile.pacifier.model.PedidoTroca;
import com.mobile.pacifier.model.Troca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrocaService {

    private static final String TAG = "TrocaService";

    public List<Troca> listarTrocas(Long cpf) {
        List<Troca> trocas = new ArrayList<>();

        try {
            PreparedStatement ps = DatabaseManager.getConnection().prepareStatement("SELECT * FROM troca WHERE cpf_usuario=?");
            ps.setLong(1, cpf);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Troca troca = new Troca();
                troca.setCodTroca(rs.getLong("cod_troca"));
                troca.setNomeTroca(rs.getString("nome_troca"));
                troca.setDescTroca(rs.getString("desc_troca"));
                troca.setStatusTroca(rs.getBoolean("status_troca"));
                //troca.setCod_imagem(rs.getObject("cod_imagem")),
                //troca.setCod_cad_produto(rs.getObject("cod_cad_produto")),
                //troca.setCpf_usuario(rs.getObject("cpf_usuario"));
                trocas.add(troca);
            }

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

    public List<Troca> listarTrocaByPedidoAntigo(Long cpf) {
        List<Troca> trocas = new ArrayList<>();

        try {
            PreparedStatement ps = DatabaseManager.getConnection().prepareStatement("SELECT cod_pedido_troca, status_destinatario, status_remetente FROM pedido_troca WHERE cpf_usuario=?");
            ps.setLong(1, cpf);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PedidoTroca pedidoTroca = new PedidoTroca();
                pedidoTroca.setCodPedidoTroca(rs.getLong("cod_pedido_troca"));
                pedidoTroca.setStatusDestinatario(rs.getString("status_destinatario"));
                pedidoTroca.setStatusRemetente(rs.getString("status_remetente"));

                PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT cod_troca FROM item_pedido_troca WHERE cod_pedido_troca=" + pedidoTroca.getCodPedidoTroca());
                ResultSet rs2 = statement.executeQuery();

                while (rs2.next()) {
                    ItemPedidoTroca itemPedidoTroca = new ItemPedidoTroca();
                    itemPedidoTroca.setCodTroca(rs2.getLong("cod_troca"));

                    PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM troca WHERE cod_troca=" + itemPedidoTroca.getCodTroca());
                    ResultSet rs3 = statement2.executeQuery();
                    while (rs3.next()) {
                        Troca troca = new Troca();
                        troca.setCodTroca(rs3.getLong("cod_troca"));
                        troca.setNomeTroca(rs3.getString("nome_troca"));
                        troca.setCodImagem(rs3.getLong("cod_imagem"));
                        troca.setStatusDestinatario(pedidoTroca.getStatusDestinatario());
                        troca.setStatusRemetente(pedidoTroca.getStatusRemetente());

                        PreparedStatement statement3 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM imagem WHERE cod_troca=" + troca.getCodImagem());
                        ResultSet rs4 = statement3.executeQuery();

                        if (rs4.next()) {
                            troca.setUrlImagem(rs4.getString("url"));
                        }

                        trocas.add(troca);
                    }

                    rs3.close();
                    statement2.close();
                    DatabaseManager.getConnection().close();
                }

                rs2.close();
                statement.close();
                DatabaseManager.getConnection().close();
            }

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

    public List<Troca> listarTrocaByPedido(Long cpf) {
        List<Troca> trocas = new ArrayList<>();

        try {
            // Consulta principal
            String consulta = "SELECT t.cod_troca, t.nome_troca, i.cod_imagem, i.url, pt.status_destinatario, pt.status_remetente "
                    + "FROM pedido_troca pt "
                    + "INNER JOIN item_pedido_troca ipt ON pt.cod_pedido_troca = ipt.cod_pedido_troca "
                    + "INNER JOIN troca t ON ipt.cod_troca = t.cod_troca "
                    + "LEFT JOIN imagem i ON t.cod_imagem = i.cod_imagem "
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
                troca.setCodImagem(rs.getLong("cod_imagem"));
                troca.setUrlImagem(rs.getString("url"));
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
