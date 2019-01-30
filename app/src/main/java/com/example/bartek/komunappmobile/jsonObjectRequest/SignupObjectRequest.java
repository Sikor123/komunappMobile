package com.example.bartek.komunappmobile.jsonObjectRequest;

import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.UnsupportedEncodingException;

public class SignupObjectRequest extends JsonObjectRequest {
    public SignupObjectRequest(int method, String url, JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, jsonRequest, listener, errorListener);
    }

    public SignupObjectRequest(String url, @Nullable JSONObject jsonRequest, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(url, jsonRequest, listener, errorListener);
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {

            String jsonString = "{}";
            JSONObject jsonResponse = new JSONObject(jsonString);
            jsonResponse.put("headers", new JSONObject(response.headers));

            return Response.success(jsonResponse,
                    HttpHeaderParser.parseCacheHeaders(response));
        }  catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }
}