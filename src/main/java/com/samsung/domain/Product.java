package com.samsung.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)//cascade
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "composition")
    private String composition;




}
