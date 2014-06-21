package com.formigone.easylearntutorial.api;

public class TutorialApi extends JsonApi {
    private static final String BASE_URL = "http://dev.easylearntutorial.com/";
    private static final String METHOD_GET_SERIES = "get-series";
    
    public Response getSeries(int max) {
	String url = BASE_URL + METHOD_GET_SERIES + "?max=" + max;
	
	return call(url);
    }
}
