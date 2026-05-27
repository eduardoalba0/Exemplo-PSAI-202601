package br.edu.ifpr.bsi.projetoexemplo.utils;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;

    public String uploadImagem(String pasta, MultipartFile arquivo, String idPublico) {
        try {
            var uploadResult = cloudinary.uploader().upload(arquivo.getBytes(),
                    ObjectUtils.asMap(
                            "folder", pasta,
                            "public_id", idPublico,
                            "overwrite", true,
                            "resource_type", "image"
                    ));
            return uploadResult.get("url").toString();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Falha no upload do arquivo." + e.getMessage());
        }
    }

    public void deletarImagem(String pasta, String url) {
        try {
            String idPublico = pasta + "/" + url.replaceAll(".*/", "").replaceAll("\\.[^.]+$", "");
            System.out.println("ID público extraído: " + idPublico);
            cloudinary.uploader().destroy(idPublico,
                    ObjectUtils.asMap(
                            "resource_type", "image"
                    ));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao remover a imagem do Cloudinary. " + e.getMessage());
        }
    }
}
