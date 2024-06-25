package com.example.Dining;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @JdbcTypeCode(SqlTypes.INTEGER)
    @Getter @Setter  private Integer id;

    @Column(name = "name", nullable = false)
    @Getter @Setter private String name;

    @Column(name = "city")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Getter @Setter private String city;

    @Column(name = "state")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Getter @Setter private String state;

    @Column(name = "zip_code")
    @Getter @Setter private Long zipCode;

    @Column(name = "peanut_allergies")
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    @Getter @Setter  private Boolean peanutAllergies;

    @Column(name = "egg_allergies")
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    @Getter @Setter private Boolean eggAllergies;

    @Column(name = "dairy_allergies")
    @JdbcTypeCode(SqlTypes.BOOLEAN)
    @Getter @Setter private Boolean dairyAllergies;

}