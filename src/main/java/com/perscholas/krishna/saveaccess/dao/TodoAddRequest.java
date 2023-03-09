package com.perscholas.krishna.saveaccess.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TodoAddRequest {
    private Integer userId;
    private String text;
}
