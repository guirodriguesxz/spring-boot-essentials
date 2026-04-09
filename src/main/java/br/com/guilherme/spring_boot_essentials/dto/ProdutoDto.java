package br.com.guilherme.spring_boot_essentials.dto;

import br.com.guilherme.spring_boot_essentials.database.model.ProdutoEntity;
import br.com.guilherme.spring_boot_essentials.service.ProdutoService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder

public class ProdutoDto {
    private String  nome;
    private String preco;
    private Integer quantidade;


}

