package org.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@Table(name="tbl_categories")
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name", length = 250, nullable = false)
    private String name;
    @Column(name="description", length = 250, nullable = false)
    private String description;
}
