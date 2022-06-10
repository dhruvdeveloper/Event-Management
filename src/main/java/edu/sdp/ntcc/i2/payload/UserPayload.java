package edu.sdp.ntcc.i2.payload;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPayload {

    private int id;
    private String name;
    private String password;
    private String email;
    private String role;

}
