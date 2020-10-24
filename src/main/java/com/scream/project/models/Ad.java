package com.scream.project.models;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "AD",schema = "public")
public class Ad {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JoinColumn(name = "id")
    private Long id;
    @Column(name = "title")
    @NotBlank(message = "Title is mandatory")
    private String title;
    @Column(name = "descriptions")
    @NotBlank(message = "Description is mandatory")
    private String descriptions;
    @Column(name = "category")
    @NotBlank(message = "Category is mandatory")
    private String category;
    @Column(name = "numberphone")
    @NotBlank(message = "Number phone is mandatory")
    private long numberPhone;
    @Column(name="date")
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH-mm")
    private LocalDateTime date;

}
