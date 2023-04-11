package com.mobile.pacifier.services;

import com.mobile.pacifier.config.DatabaseManager;
import com.mobile.pacifier.model.Anuncio;

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
            PreparedStatement statement = DatabaseManager.getConnection().prepareStatement("SELECT * FROM anuncio WHERE cpf_usuario=?");
            statement.setLong(1, cpf);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Anuncio anuncio = new Anuncio();
                anuncio.setCodAnuncio(rs.getLong("cod_anuncio"));
                anuncio.setNomeAnuncio(rs.getString("nome_anuncio"));
                anuncio.setDescAnuncio(rs.getString("desc_anuncio"));
                anuncio.setValorAnuncio(rs.getDouble("valor_anuncio"));
                anuncio.setQuantAnuncio(rs.getInt("quant_anuncio"));
                anuncio.setStatusAnuncio(rs.getBoolean("status_anuncio"));
                anuncio.setGeneroAnuncio(rs.getString("genero_anuncio"));
                anuncios.add(anuncio);
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
            }

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

                PreparedStatement statement2 = DatabaseManager.getConnection().prepareStatement("SELECT * FROM usuario WHERE cpf=" + anuncio.getCpfUsuario());
                ResultSet rs2 = statement2.executeQuery();
                if(rs2.next()) {
                    anuncio.setNomeVendedor(rs2.getString("nome"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return anuncio;
    }
}
