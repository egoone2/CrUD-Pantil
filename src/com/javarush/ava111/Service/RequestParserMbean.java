package com.javarush.ava111.Service;

import com.javarush.ava111.Dto.CreateDto;
import com.javarush.ava111.Dto.DeleteDto;
import com.javarush.ava111.Dto.ReadDto;
import com.javarush.ava111.Dto.UpdateDto;

import java.text.ParseException;

public interface RequestParserMbean {

    public void sendRequest(String params) throws ParseException;

    public String getParam();

    public void setParam(String param);
}
