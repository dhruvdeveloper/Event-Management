package edu.sdp.ntcc.i2.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_proposals")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventProposal {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "proposal_id")
    private Integer proposalId;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "approver")
    private String approver;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "domain")
    private String domain;

    @Column(name = "description")
    private String description;

    public EventProposal(String name, String domain, String description, Integer userId) {
        this.name = name;
        this.userId = userId;
        this.domain = domain;
        this.description = description;
        this.approver = "Ironman";
        this.date = LocalDateTime.now();
        this.status = "Pending";
    }
}
