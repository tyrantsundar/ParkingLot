package com.parkinglot.dtos.request;

import com.parkinglot.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRequestDto {
    private String gateNumber;
    private String operatorName;
    private String ticketId;
    private PaymentMode paymentMode;
    private String paymentCardDetail;
}
