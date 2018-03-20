package com.example.jiali.myapplication.network.conveter;

import com.bbit.catering.http.HttpUrl;
import com.bbit.catering.util.PreferenceHelper;
import com.bbit.catering.util.constant.AESUtil;
import com.bbit.catering.util.constant.UUIDGenerator;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by jiali on 2018/3/19.
 */

public class CustomRequestConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    CustomRequestConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
//        String string = gson.toJson(value);
//
//        Buffer buffer = new Buffer();
//        Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
//        JsonWriter jsonWriter = gson.newJsonWriter(writer);
//        adapter.write(jsonWriter, value);
//        jsonWriter.close();
//        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
        return encryptData(gson.toJson(value));
    }

    private RequestBody encryptData(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            jsonObject.put("merchantUserId", PreferenceHelper.getInt(PreferenceHelper.USER_ID) + "");
            jsonObject.put("mId", PreferenceHelper.getInt(PreferenceHelper.USER_ID) + "");
            jsonObject.put("apiver", HttpUrl.VER);
            jsonObject.put("token", PreferenceHelper.get(PreferenceHelper.LOGINUSER_TOKEN));
            String data = AESUtil.encrypt(jsonObject.toString());
            long systemTime = System.currentTimeMillis();

            String nonceStr = UUIDGenerator.getInstance().getReplaceUUIDTo32();
            String signature = "data=" + data + "&timestamp=" + systemTime + "&nonceStr=" + nonceStr + "&product=restaurant";
            signature = AESUtil.encryptSHA(signature);

            return new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("data", data)
                    .addFormDataPart("timestamp", "" + systemTime)
                    .addFormDataPart("nonceStr", nonceStr)
                    .addFormDataPart("product", "restaurant")
                    .addFormDataPart("signature", signature)
                    .build();
        } catch (JSONException e) {
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
