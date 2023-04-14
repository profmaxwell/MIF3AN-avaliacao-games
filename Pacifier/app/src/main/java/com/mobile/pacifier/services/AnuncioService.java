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

public class AnuncioService {

    private static final String TAG = "AnuncioService";

    public List<Anuncio> listarAnuncio(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT a.*, i.url FROM anuncio a LEFT JOIN imagem i ON a.cod_imagem = i.cod_imagem WHERE a.cpf_usuario=?");
            statement.setLong(1, cpf);
            statement.setMaxRows(1000); // Se atrapalhar retire

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Anuncio anuncio = new Anuncio();
                    anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                    anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                    anuncio.setDescAnuncio(rs.getString("desc_anuncio"));
                    anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                    anuncio.setQuantAnuncio(rs.getInt("quant_anuncio"));
                    anuncio.setStatusAnuncio(rs.getBoolean("status_anuncio"));
                    anuncio.setGeneroAnuncio(rs.getString("genero_anuncio"));
                    anuncio.setQuantVendida(rs.getInt("quant_vendida"));
                    anuncio.setCodImagem(rs.getLong("cod_imagem"));
                    anuncio.setUrlImagem(rs.getString("url"));
                    anuncios.add(anuncio);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return anuncios;
    }

    public List<Anuncio> listarAnuncioAntigo(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM anuncio WHERE cpf_usuario=?");
            statement.setLong(1, cpf);
            statement.setFetchSize(1000); // Se atrapalhar retire

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Anuncio anuncio = new Anuncio();
                    anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                    anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                    anuncio.setDescAnuncio(rs.getString("desc_anuncio"));
                    anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                    anuncio.setQuantAnuncio(rs.getInt("quant_anuncio"));
                    anuncio.setStatusAnuncio(rs.getBoolean("status_anuncio"));
                    anuncio.setGeneroAnuncio(rs.getString("genero_anuncio"));
                    anuncio.setQuantVendida(rs.getInt("quant_vendida"));
                    anuncio.setCodImagem(rs.getLong("cod_imagem"));

                    PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM imagem WHERE cod_imagem=" + anuncio.getCodImagem());
                    ResultSet rs2 = statement2.executeQuery();

                    if (rs2.next()) {
                        anuncio.setCodImagem(rs2.getLong("cod_imagem"));
                        anuncio.setUrlImagem(rs2.getString("url"));
                    }

                    anuncios.add(anuncio);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return anuncios;
    }

    public Anuncio listarAnuncioPorCodAnuncio(Long codAnuncio) {
        Anuncio anuncio = null;

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM anuncio WHERE cod_anuncio=?");
            statement.setLong(1, codAnuncio);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                anuncio = new Anuncio();
                anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                anuncio.setDescAnuncio(rs.getString("desc_anuncio"));
                anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                anuncio.setQuantAnuncio(rs.getInt("quant_anuncio"));
                anuncio.setStatusAnuncio(rs.getBoolean("status_anuncio"));
                anuncio.setGeneroAnuncio(rs.getString("genero_anuncio"));
                anuncio.setCpfUsuario(rs.getLong("cpf_usuario"));
                anuncio.setQuantVendida(rs.getInt("quant_vendida"));
            }

            rs.close();
            statement.close();
            DatabaseManager.getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return anuncio;
    }

    public Anuncio listarAnuncioAndNomePorCodAnuncio(Long codAnuncio) {
        Anuncio anuncio = null;

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM anuncio WHERE cod_anuncio=?");
            statement.setLong(1, codAnuncio);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                anuncio = new Anuncio();
                anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                anuncio.setDescAnuncio(rs.getString("desc_anuncio"));
                anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                anuncio.setQuantAnuncio(rs.getInt("quant_anuncio"));
                anuncio.setStatusAnuncio(rs.getBoolean("status_anuncio"));
                anuncio.setGeneroAnuncio(rs.getString("genero_anuncio"));
                anuncio.setCpfUsuario(rs.getLong("cpf_usuario"));
                anuncio.setQuantVendida(rs.getInt("quant_vendida"));

                PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM usuario WHERE cpf=" + anuncio.getCpfUsuario());
                ResultSet rs2 = statement2.executeQuery();
                if (rs2.next()) {
                    anuncio.setNomeVendedor(rs2.getString("nome"));
                }

                rs2.close();
                statement2.close();
                DatabaseManager.getConnection().close();
            }

            rs.close();
            statement.close();
            DatabaseManager.getConnection().close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return anuncio;
    }

    public List<Anuncio> listarAnuncioByPedido(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            String sql = "SELECT anuncio.cod_anuncio, anuncio.nome_anuncio, anuncio.valor_anuncio, anuncio.quant_vendida, pedido.status_pedido, anuncio.cod_imagem, imagem.url " +
                    "FROM anuncio " +
                    "JOIN item_pedido ON item_pedido.cod_anuncio = anuncio.cod_anuncio " +
                    "JOIN pedido ON pedido.cod_pedido = item_pedido.cod_pedido " +
                    "LEFT JOIN imagem ON anuncio.cod_imagem = imagem.cod_imagem " +
                    "WHERE pedido.cod_usuario = ?";

            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
            statement.setLong(1, cpf);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                anuncio.setQuantVendida(rs.getInt("quant_vendida"));
                anuncio.setStatusPedido(rs.getString("status_pedido"));
                anuncio.setCodImagem(rs.getLong("cod_imagem"));
                anuncio.setUrlImagem(rs.getString("url"));

                anuncios.add(anuncio);
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

    public List<Anuncio> listarAnuncioByPedidoSemImagem(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            String sql = "SELECT anuncio.cod_anuncio, anuncio.nome_anuncio, anuncio.valor_anuncio, anuncio.quant_vendida, pedido.status_pedido " +
                    "FROM anuncio " +
                    "JOIN item_pedido ON item_pedido.cod_anuncio = anuncio.cod_anuncio " +
                    "JOIN pedido ON pedido.cod_pedido = item_pedido.cod_pedido " +
                    "WHERE pedido.cod_usuario = ?";

            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement(sql);
            statement.setLong(1, cpf);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                anuncio.setQuantVendida(rs.getInt("quant_vendida"));
                anuncio.setStatusPedido(rs.getString("status_pedido"));

                anuncios.add(anuncio);
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

    public List<Anuncio> listarAnuncioWherePedidoStatusAntigo(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM pedido WHERE cod_usuario=? AND status_pedido='ENTREGUE'");
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
                        anuncio.setCpfUsuario(rs3.getLong("cpf_usuario"));
                        anuncio.setStatusPedido(pedido.getStatusPedido());

                        PreparedStatement statement4 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM usuario WHERE cpf=" + anuncio.getCpfUsuario());
                        ResultSet rs4 = statement4.executeQuery();

                        if (rs4.next()) {
                            anuncio.setNomeVendedor(rs4.getString("nome"));
                        }

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

    public List<Anuncio> listarAnuncioWherePedidoStatus(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT a.cod_anuncio, a.nome_anuncio, a.valor_anuncio, a.quant_vendida, u.nome, i.cod_imagem, i.url " +
                    "FROM anuncio a " +
                    "JOIN item_pedido ip ON a.cod_anuncio = ip.cod_anuncio " +
                    "JOIN pedido p ON ip.cod_pedido = p.cod_pedido " +
                    "JOIN usuario u ON a.cpf_usuario = u.cpf " +
                    "LEFT JOIN imagem i ON a.cod_imagem = i.cod_imagem " +
                    "WHERE p.cod_usuario = ? AND p.status_pedido = 'ENTREGUE' AND a.cod_anuncio NOT IN (SELECT cod_anuncio FROM comentario WHERE cpf_usuario = ?)");
            statement.setLong(1, cpf);
            statement.setLong(2, cpf);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                anuncio.setQuantVendida(rs.getInt("quant_vendida"));
                anuncio.setNomeVendedor(rs.getString("nome"));
                anuncio.setStatusPedido("ENTREGUE");

                long codImagem = rs.getLong("cod_imagem");
                if (!rs.wasNull()) {
                    anuncio.setCodImagem(codImagem);
                    anuncio.setUrlImagem(rs.getString("url"));
                }

                anuncios.add(anuncio);
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

    public List<Anuncio> listarAnuncioWherePedidoStatusSemImagem(Long cpf) {
        List<Anuncio> anuncios = new ArrayList<>();

        try {
            //PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT a.cod_anuncio, a.nome_anuncio, a.valor_anuncio, a.quant_vendida, u.nome FROM anuncio a JOIN item_pedido ip ON a.cod_anuncio = ip.cod_anuncio JOIN pedido p ON ip.cod_pedido = p.cod_pedido JOIN usuario u ON a.cpf_usuario = u.cpf WHERE p.cod_usuario = ? AND p.status_pedido = 'ENTREGUE'");
            //statement.setLong(1, cpf);

            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT a.cod_anuncio, a.nome_anuncio, a.valor_anuncio, a.quant_vendida, u.nome FROM anuncio a JOIN item_pedido ip ON a.cod_anuncio = ip.cod_anuncio JOIN pedido p ON ip.cod_pedido = p.cod_pedido JOIN usuario u ON a.cpf_usuario = u.cpf WHERE p.cod_usuario = ? AND p.status_pedido = 'ENTREGUE' AND a.cod_anuncio NOT IN (SELECT cod_anuncio FROM comentario WHERE cpf_usuario = ?)");
            statement.setLong(1, cpf);
            statement.setLong(2, cpf);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                anuncio.setQuantVendida(rs.getInt("quant_vendida"));
                anuncio.setNomeVendedor(rs.getString("nome"));
                anuncio.setStatusPedido("ENTREGUE");

                anuncios.add(anuncio);
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
}
