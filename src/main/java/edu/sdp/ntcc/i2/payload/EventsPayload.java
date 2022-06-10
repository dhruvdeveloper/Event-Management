package edu.sdp.ntcc.i2.payload;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventsPayload {

    private Integer eventId;
    private String name;
    private String description;
    private String domain;
    private String proposalId;
    private String date;

}
