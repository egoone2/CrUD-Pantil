package com.javarush.ava111;

import java.text.ParseException;

public class RequestParser {

    private String params;

    public RequestParser()  {

    }

    public void sendRequest(String params) throws ParseException {     //распределение запросов и отправление в ПерсонСервис
        String[] paramsArr = params.split("\t");

        switch (paramsArr[0]) {
            case ("create"):
                PersonService.getInstance().createPerson(new RequestDto(paramsArr).createUpdateDto());
                break;
            case ("update"):
                PersonService.getInstance().updatePerson(new RequestDto(paramsArr).createUpdateDto());
                break;
            case ("delete"):
                for (int i = 1; i < paramsArr.length; i++) {
                    PersonService.getInstance().deletePerson(RequestDto.deleteDto(paramsArr[i]));
                }
                break;
            case("read"):
                for (int i = 1; i < paramsArr.length; i++) {
                    PersonService.getInstance().readPerson(RequestDto.readDto(paramsArr[i]));
                }
                break;
            default:
                System.out.println("Wrong command, check source file.");
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
