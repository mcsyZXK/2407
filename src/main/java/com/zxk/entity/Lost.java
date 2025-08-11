package com.zxk.entity;

import lombok.Data;

@Data
public class Lost {
    private Integer loid;
    private String itemName;
    private String description;
    private Boolean isClaimed;
}
