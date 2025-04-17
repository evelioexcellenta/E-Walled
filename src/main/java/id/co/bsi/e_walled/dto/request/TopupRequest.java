package id.co.bsi.e_walled.dto.request;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TopupRequest {
    private String from;
    private int amount;
    private String notes;
    private String type;
    private LocalDateTime dateTime;
}
