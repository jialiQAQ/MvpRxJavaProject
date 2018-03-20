package com.example.jiali.myapplication.network.conveter;

import android.util.Log;

import com.bbit.catering.MainApplication;
import com.bbit.catering.R;
import com.bbit.catering.bean.UserData;
import com.bbit.catering.http.HttpUrl;
import com.bbit.catering.log.Logger;
import com.example.jiali.myapplication.network.RetrofitService;
import com.example.jiali.myapplication.network.responsebean.BaseResponse;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by jiali on 2018/3/19.
 */

public class RetrofitFactory {

    private static final String TAG = "RetrofitFactory";

    private static OkHttpClient okHttpClient;

    private static Retrofit retrofit;

    static {
        initOkhttp();
        initRetrofit();
    }

    private static void initOkhttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS);
        setupCertificate(builder);
        okHttpClient = builder.build();
    }

    private static void initRetrofit() {
        retrofit = new Retrofit.Builder().baseUrl(HttpUrl.MUNE_URL + HttpUrl.KS_PATH_PREFIX + "/").client(okHttpClient).addConverterFactory(CustomGsonConvertFactory.create()).build();
    }

    private RetrofitFactory() {
    }

    public static RetrofitService createService() {
        return retrofit.create(RetrofitService.class);
    }

    private static void setupCertificate(OkHttpClient.Builder newBuilder) {
        InputStream inputStream = null;
        try {
            inputStream = MainApplication.getInstance()
                    .getResources().openRawResource(R.raw.belimaterial);
            if (inputStream == null) {
                Logger.e(TAG, "get certificate file fail!");
                return;
            }
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            keyStore.setCertificateEntry(String.valueOf(index),
                    certificateFactory.generateCertificate(inputStream));
            SSLContext sslContext = SSLContext.getInstance("TLS");

            TrustManagerFactory trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            trustManagerFactory.init(keyStore);
            sslContext.init(
                    null,
                    trustManagerFactory.getTrustManagers(),
                    new SecureRandom()
            );
            X509TrustManager x509TrustManager = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            };
            newBuilder.sslSocketFactory(sslContext.getSocketFactory(), x509TrustManager);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void test() {
        Call<BaseResponse<UserData>> queryReportData = createService().login("admin", "123456");
        queryReportData.enqueue(new Callback<BaseResponse<UserData>>() {
            @Override
            public void onResponse(Call<BaseResponse<UserData>> call, retrofit2.Response<BaseResponse<UserData>> response) {
                Log.e("jiali", "成功");
            }

            @Override
            public void onFailure(Call<BaseResponse<UserData>> call, Throwable t) {
                Log.e("jiali", "失败：" + t.getMessage());
            }
        });
    }

}
