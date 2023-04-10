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

    public List<Troca> listarTrocas(Long cpf) {
        List<Troca> trocas = new ArrayList<>();

        try {
            PreparedStatement ps = DatabaseManager.getConnection().prepareStatement("SELECT * FROM troca WHERE cpf_usuario=" + cpf);
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
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return trocas;
    }
}
