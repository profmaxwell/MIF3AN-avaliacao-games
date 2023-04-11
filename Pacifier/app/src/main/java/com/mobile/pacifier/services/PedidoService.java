package com.mobile.pacifier.services;

import com.mobile.pacifier.config.DatabaseManager;
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
                pedido.setStatusPedido(rs.getBoolean("status_pedido"));
                pedidos.add(pedido);
            }

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

        return itensPedidos;
    }

}
