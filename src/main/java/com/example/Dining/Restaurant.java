package com.example.Dining;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter @Setter private Integer id;

    @Column(name = "name_restaurant")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Getter @Setter private String nameRestaurant;

    @Column(name = "review")
    @JdbcTypeCode(SqlTypes.FLOAT)
    @Getter @Setter private Float review;

    @Column(name = "review_peanut")
    @JdbcTypeCode(SqlTypes.FLOAT)
    @Getter @Setter private Float reviewPeanut;

    @Column(name = "review_egg")
    @JdbcTypeCode(SqlTypes.FLOAT)
    @Getter @Setter private Float reviewEgg;

    @Column(name = "review_dairy")
    @JdbcTypeCode(SqlTypes.FLOAT)
    @Getter @Setter private Float reviewDairy;

}