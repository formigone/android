package com.formigone.easylearntutorial.api;

import com.formigone.easylearntutorial.api.JsonApi.Response.CODE;

public class JsonApi {
    public static class Response {
	public static enum CODE {
	    OK, ERROR, USE_CACHE
	};

	public CODE code;
	public String data;

	public Response(CODE code) {
	    this(code, null);
	}

	public Response(CODE code, String data) {
	    this.code = code;
	    this.data = data;
	}
    }

    protected Response call(String url) {
	Response response = new Response(CODE.ERROR);
	
	String data = "{\"data\":[{\"title\":\"A\", \"img\":\"http://dev.rnd.com/img/cssoff/story1img.png\"},{\"title\":\"B\", \"img\":\"http://dev.rnd.com/img/cssoff/story2img.png\"},{\"title\":\"C\", \"img\":\"http://dev.rnd.com/img/cssoff/story3img.png\"}]}";
	response.data = data;
	response.code = CODE.OK;
	
	return response;
    }
}
