package com.example.demo.dtos.internal;

import com.example.demo.enums.Field;
import com.google.cloud.storage.Blob;

public class postAddInternalDTO {
    private Long OwnerId;
    private String title;
    private String description;
    private Field field;
    private Blob[] images;
    private String fullDescription;
    private boolean show;
    private Integer perHour;
    private Integer perDay;
    private Integer perWeek;
    private Integer perMonth;
    private Integer perYear;


}
