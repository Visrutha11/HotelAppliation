package com.hotel.v2soru.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component

public class DeviveryBoy 
{
    private int DeliverBoyId;
    private String DeviveryBoyName;
    private String Phonenumber;
    private List<Orders>orders;
}
