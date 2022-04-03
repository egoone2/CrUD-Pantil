package com.osokin.service;

import com.osokin.dto.CreateDto;
import com.osokin.dto.DeleteDto;
import com.osokin.dto.ReadDto;
import com.osokin.dto.UpdateDto;

import java.text.ParseException;
import java.util.logging.Logger;

import static com.osokin.service.Util.*;

public class DtoConverter {
    private static Logger logger = Logger.getLogger(DtoConverter.class.getName());
    public static CreateDto createDto(String[] params) throws ParseException {
        CreateDto createDto = new CreateDto();
        createDto.setName(params[1]);
        createDto.setAge(Integer.parseInt(params[2]));
        createDto.setPassportSeries(params[3]);
        createDto.setPassportNumber(params[4]);
        createDto.setPassportIssueDate(formatter.parse(params[5]));
        createDto.setCity(params[6]);

        return createDto;
    }
    public static UpdateDto updateDto(String[] params) throws ParseException {
        UpdateDto updateDto = new UpdateDto();
        updateDto.setID(Integer.parseInt(params[1]));
        updateDto.setName(params[2]);
        updateDto.setAge(Integer.parseInt(params[3]));
        updateDto.setPassportSeries(params[4]);
        updateDto.setPassportNumber(params[5]);
        updateDto.setPassportIssueDate(formatter.parse(params[6]));
        updateDto.setCity(params[7]);

        return updateDto;
    }

    public static DeleteDto deleteDto(String ID) {
        DeleteDto deleteDto = new DeleteDto();
        deleteDto.setID(Integer.parseInt(ID));

        return deleteDto;
    }

    public static ReadDto readDto(String ID) {
        ReadDto readDto = new ReadDto();
        readDto.setID(Integer.parseInt(ID));

        return readDto;
    }
}
