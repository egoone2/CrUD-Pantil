package com.javarush.ava111;

import java.text.ParseException;

public class RequestParser {

    private String params;

    public RequestParser(String params) throws ParseException {
        this.params = params;
        sendRequest(params);
    }

    public void sendRequest(String params) throws ParseException {     //распределение запросов и отправление в ПерсонСервис
        String[] paramsArr = params.split("\t");

        switch (paramsArr[0]) {
            case ("create"):
                PersonService.getInstance().createPerson(paramsArr);
                break;
            case ("update"):
                PersonService.getInstance().updatePerson(paramsArr);
                break;
            case ("delete"):
                PersonService.getInstance().deletePerson(paramsArr);
                break;
            case("read"):
                PersonService.getInstance().readPerson(paramsArr);
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
