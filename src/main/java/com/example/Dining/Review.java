package com.example.Dining;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.INTEGER)
    @Getter @Setter private Integer id;

    @Column(name = "name", nullable = false)
    @Getter @Setter private String name;

    @Column(name = "review_peanut")
    @JdbcTypeCode(SqlTypes.FLOAT)
    @Getter @Setter private Float reviewPeanut;

    @Column(name = "review_egg")
    @JdbcTypeCode(SqlTypes.FLOAT)
    @Getter @Setter private Float reviewEgg;

    @Column(name = "review_dairy")
    @JdbcTypeCode(SqlTypes.FLOAT)
    @Getter @Setter private Float reviewDairy;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Getter @Setter private String status;

}