package com.hotel.v2soru.config;

import lombok.Data;

@Data
public class ResponseStructure<T>
{
          private String messages;
          private int statuscode;
          private T data;
          
}
