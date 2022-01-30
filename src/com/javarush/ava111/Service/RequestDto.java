package com.javarush.ava111.Service;

import com.javarush.ava111.Dto.CreateDto;
import com.javarush.ava111.Dto.DeleteDto;
import com.javarush.ava111.Dto.ReadDto;
import com.javarush.ava111.Dto.UpdateDto;

import java.text.ParseException;

import static com.javarush.ava111.Service.Util.*;

public class RequestDto {

   private String[] params;

   public  RequestDto(String[] params) {
       this.params = params;
   }

   public CreateDto createDto() throws ParseException {
       CreateDto createDto = new CreateDto();
       createDto.setName(params[1]);
       createDto.setAge(Integer.parseInt(params[2]));
       createDto.setPassportSeries(params[3]);
       createDto.setPassportNumber(params[4]);
       createDto.setPassportIssueDate(formatter.parse(params[5]));
       createDto.setCity(params[6]);


       return createDto;
   }

   public UpdateDto updateDto() throws ParseException {
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

   public static DeleteDto deleteDto(String id) {
       DeleteDto deleteDto = new DeleteDto();
       deleteDto.setID(Integer.parseInt(id));

       return deleteDto;
   }

   public static ReadDto readDto(String id) {
       ReadDto readDto = new ReadDto();
       readDto.setID(Integer.parseInt(id));

       return readDto;
   }
}
