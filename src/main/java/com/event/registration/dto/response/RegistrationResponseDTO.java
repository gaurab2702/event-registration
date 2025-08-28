package com.event.registration.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationResponseDTO {

    private Long id;
    private Long userId;
    private Long eventId;
}
