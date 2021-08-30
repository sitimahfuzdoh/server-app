package com.MCC53.springsecurity.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFile {

//    private Long id;
    private String name;
    private String url;
    private String type;
    private long size;

}
