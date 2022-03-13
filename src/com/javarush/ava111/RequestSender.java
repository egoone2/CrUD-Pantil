package com.javarush.ava111;

import com.javarush.ava111.Dto.*;
import com.javarush.ava111.Service.DtoConverter;
import com.javarush.ava111.Service.PersonService;

import java.text.ParseException;
import java.util.logging.Logger;


public class RequestSender {
    private static Logger logger = Logger.getLogger(RequestSender.class.getName());
    private String params;

    public RequestSender() {

    }

    public void sendRequest(String params) throws ParseException {     //распределение запросов и отправka в ПерсонСервис
        String[] paramsArr = params.split("\t");
        PersonService personService = PersonService.getInstance();

        switch (paramsArr[0]) {
            case ("create"):
                CreateDto createDto = DtoConverter.createDto(paramsArr);
                personService.createPerson(createDto);
                break;
            case ("update"):
                UpdateDto updateDto = DtoConverter.updateDto(paramsArr);
                personService.updatePerson(updateDto);
                break;
            case ("delete"):
                for (int i = 1; i < paramsArr.length; i++) {
                    DeleteDto deleteDto = DtoConverter.deleteDto(paramsArr[i]);
                    personService.deletePerson(deleteDto);
                }
                break;
            case ("read"):
                for (int i = 1; i < paramsArr.length; i++) {
                    ReadDto readDto = DtoConverter.readDto(paramsArr[i]);
                    personService.readPerson(readDto);
                }
                break;
            default:
                logger.info("Wrong command, check source file");
                break;
        }
    }

    public String getParam() {
        return params;
    }

    public void setParam(String param) {
        this.params = param;
    }
}
