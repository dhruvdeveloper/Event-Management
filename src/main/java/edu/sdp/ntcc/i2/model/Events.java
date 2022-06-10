package edu.sdp.ntcc.i2.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "events")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Events {

    public Events(String name, String description, String domain, Integer proposalId, LocalDateTime date){
        this.name = name;
        this.description = description;
        this.domain = domain;
        this.proposalId = proposalId;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="event_id")
    private Integer eventId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "domain")
    private String domain;

    @Column(name = "proposal_id")
    private Integer proposalId;

    @Column(name = "date")
    private LocalDateTime date;

}
