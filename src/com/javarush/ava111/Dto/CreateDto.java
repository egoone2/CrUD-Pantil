package com.javarush.ava111.Dto;





public class CreateDto extends Dto{
    private static int inc_ID = 0;

    public CreateDto() {
        inc_ID++;
        this.setID(inc_ID);
    }

}
