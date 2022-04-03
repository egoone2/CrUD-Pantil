package com.osokin;

import com.osokin.dto.CreateDto;
import com.osokin.dto.DeleteDto;
import com.osokin.dto.ReadDto;
import com.osokin.service.DtoConverter;
import com.osokin.service.PersonService;
import com.osokin.dto.UpdateDto;
import com.osokin.service.jmx.AdminPage;

import java.text.ParseException;
import java.util.logging.Logger;


public class RequestSender {
    private static Logger logger = Logger.getLogger(RequestSender.class.getName());

    public RequestSender() {

    }

    public void sendRequest(String params) throws ParseException {     //распределение запросов и отправka в ПерсонСервис
        String[] paramsArr = params.split("\t");
        PersonService personService = PersonService.getInstance();

        switch (paramsArr[0]) {
            case ("create"):
                CreateDto createDto = DtoConverter.createDto(paramsArr);
//                wrapWithTimer ((), AdminPage.isEnabled())
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

    private void wrapWithTimer(boolean isNeedTimer) {

    }
}
