package com.javarush.ava111.Dto;

import java.text.ParseException;

import static com.javarush.ava111.Service.Util.*;

public class RequestDto {

   private String[] params;

   public  RequestDto(String[] params) {
       this.params = params;
   }

   public CreateUpdateDto createUpdateDto() throws ParseException {
       CreateUpdateDto createUpdateDto = new CreateUpdateDto();
       createUpdateDto.setName(params[1]);
       createUpdateDto.setAge(Integer.parseInt(params[2]));
       createUpdateDto.setPassportSeries(params[3]);
       createUpdateDto.setPassportNumber(params[4]);
       createUpdateDto.setPassportIssueDate(formatter.parse(params[5]));
       createUpdateDto.setCity(params[6]);

       return createUpdateDto;
   }

   public static DeleteDto deleteDto(String name) {
       DeleteDto deleteDto = new DeleteDto();
       deleteDto.setName(name);
       return deleteDto;
   }

   public static ReadDto readDto(String name) {
       ReadDto readDto = new ReadDto();
       readDto.setName(name);
       return readDto;
   }
}
