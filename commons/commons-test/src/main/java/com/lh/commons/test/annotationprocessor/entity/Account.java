package com.lh.commons.test.annotationprocessor.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.lh.commons.annotation.AutoValueDTO;
import com.lh.commons.annotation.Views;
import com.lh.commons.test.annotationprocessor.entity.value.AccountDetail;
import com.lh.commons.test.annotationprocessor.entity.value.AccountNew;
import lombok.Data;

/**
 * @author liu.hua
 */
@AutoValueDTO
@Data
public class Account {

    @JsonView(value = {Views.New.class,Views.Detail.class})
    private String name;
    private Integer age;


    public static void main(String[] args){
        AccountNew a = new AccountNew();
        AccountDetail c =new AccountDetail();
    }
}
