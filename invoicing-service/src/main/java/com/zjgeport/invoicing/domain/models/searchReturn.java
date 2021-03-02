package com.zjgeport.invoicing.domain.models;

import lombok.Data;

@Data
public class searchReturn{

    private  String waybillNo;
    private  String payState;
    private  String invoiceState;
    private  String writeOffSate;
    private  String receiptSendState;
}