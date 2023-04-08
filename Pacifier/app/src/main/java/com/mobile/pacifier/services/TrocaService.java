package com.mobile.pacifier.services;

import com.mobile.pacifier.config.DatabaseManager;
import com.mobile.pacifier.model.Troca;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrocaService {

    private static final String TAG = "TrocaService";

    public List<Troca> listarTrocas() {
        List<Troca> trocas = new ArrayList<>();

        try {
            PreparedStatement ps = DatabaseManager.getConnection().prepareStatement("SELECT * FROM troca");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Troca troca = new Troca(rs.getLong("cod_troca"),
                        rs.getString("nome_troca"),
                        rs.getString("desc_troca"),
                        rs.getBoolean("status_troca"),
                        rs.getObject("cod_imagem"),
                        rs.getObject("cod_cad_produto"),
                        rs.getObject("cpf_usuario"));
                trocas.add(troca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return trocas;
    }
}
