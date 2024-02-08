
package com.soccerteammanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String history;
    private String pictures;
    private String logo;

    @Temporal(TemporalType.DATE)
    private Date foundationDate;

    private String description;
}
