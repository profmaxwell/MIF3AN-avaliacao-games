package com.mobile.pacifier.services;

import com.mobile.pacifier.config.DatabaseManager;
import com.mobile.pacifier.model.Anuncio;
import com.mobile.pacifier.model.ItemPedido;
import com.mobile.pacifier.model.Pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private static final String TAG = "PedidoService";

    public List<Pedido> listarPedido(Long cpf) {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM pedido WHERE cod_usuario=?");
            statement.setLong(1, cpf);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setCodPedido(rs.getLong("cod_pedido"));
                pedido.setDataPedido(rs.getString("data_pedido"));
                pedido.setStatusPedido(rs.getString("status_pedido"));
                pedidos.add(pedido);
            }

            rs.close();
            statement.close();
            DatabaseManager.getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return pedidos;
    }

    public List<Anuncio> listarPedidoAntigo(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM pedido WHERE cod_usuario=?");
            statement.setLong(1, cpf);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setCodPedido(rs.getLong("cod_pedido"));
                pedido.setDataPedido(rs.getString("data_pedido"));
                pedido.setStatusPedido(rs.getString("status_pedido"));

                PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM item_pedido WHERE cod_pedido=" + pedido.getCodPedido());
                ResultSet rs2 = statement2.executeQuery();

                while (rs2.next()) {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setPreco(rs2.getDouble("preco"));
                    itemPedido.setCodAnuncio(rs2.getLong("cod_anuncio"));

                    PreparedStatement statement3 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM anuncio WHERE cod_anuncio=" + itemPedido.getCodAnuncio());
                    ResultSet rs3 = statement3.executeQuery();

                    while (rs3.next()) {
                        Anuncio anuncio = new Anuncio();
                        anuncio.setCodAnuncio(rs3.getLong("cod_anuncio"));
                        anuncio.setNomeAnuncio(rs3.getString("nome_anuncio"));
                        anuncio.setValorAnuncio(rs3.getDouble("valor_anuncio"));
                        anuncio.setQuantVendida(rs3.getInt("quant_vendida"));
                        anuncio.setStatusPedido(pedido.getStatusPedido());

                        anuncios.add(anuncio);
                    }
                }
            }

            rs.close();
            statement.close();
            DatabaseManager.getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return anuncios;
    }

    public List<Pedido> listarPedidoWhereStatus(Long cpf) {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM pedido WHERE cod_usuario=? AND status_pedido='ENTREGUE'");
            statement.setLong(1, cpf);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setCodPedido(rs.getLong("cod_pedido"));
                pedido.setDataPedido(rs.getString("data_pedido"));
                pedido.setStatusPedido(rs.getString("status_pedido"));
                pedidos.add(pedido);
            }

            rs.close();
            statement.close();
            DatabaseManager.getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return pedidos;
    }

    public List<ItemPedido> listarItemPedido(Long codPedido) throws SQLException, ClassNotFoundException {
        List<ItemPedido> itensPedidos = new ArrayList<>();

        PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM item_pedido WHERE cod_pedido=?");
        statement.setLong(1, codPedido);

        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setPreco(rs.getDouble("preco"));
            itemPedido.setQuantidade(rs.getInt("quantidade"));
            itemPedido.setCodPedido(rs.getLong("cod_pedido"));
            itemPedido.setCodAnuncio(rs.getLong("cod_anuncio"));
            itensPedidos.add(itemPedido);
        }

        rs.close();
        statement.close();
        DatabaseManager.getConnection().close();

        return itensPedidos;
    }

}
