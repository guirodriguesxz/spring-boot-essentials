package br.com.guilherme.spring_boot_essentials.database.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder // Habilita o padrão Builder (ProdutoEntity.builder()...)
@NoArgsConstructor // Cria o construtor vazio (essencial para o Hibernate/JPA)
@AllArgsConstructor // Cria o construtor com todos os campos (necessário para o @Builder)
public class ProdutoEntity {

    private Long id;
    private String nome;
    private String categoria;
    private Double preco;
    private Integer quantidade;

    // O método manual "public static void builder()" foi removido
    // porque a anotação @Builder já gera um muito mais potente.
}