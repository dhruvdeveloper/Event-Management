package edu.sdp.ntcc.i2.payload;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EventProposalPayload {

    private String name;
    private String email;
    private String domain;
    private String description;
}
