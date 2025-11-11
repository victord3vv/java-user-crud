package com.popezada.cadastro_usuario.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter // Serve para gerar os métodos getters automaticamente
@Setter // Serve para gerar os métodos setters automaticamente
@AllArgsConstructor // Serve para gerar o construtor com todos os atributos automaticamente
@NoArgsConstructor // Serve para gerar o construtor vazio automaticamente
@Builder // Serve para gerar o padrão de projeto Builder automaticamente
@Table(name = "usuario") // Define o nome da tabela no banco de dados
@Entity // Indica que a classe é uma entidade JPA
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nome")
    private String nome;
}
