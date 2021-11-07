package android.newapi.Api;

import android.annotation.SuppressLint;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClients {

    public static Retrofit retrofit;
    public static final String BASES_URL="https://newsapi.org/v2/";
    public static Retrofit getAPIClients() {
        if (retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASES_URL).client(getOkHttpClient().build()).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }
    public static OkHttpClient.Builder getOkHttpClient() {
        try {
            final  TrustManager[] TM = new TrustManager[]{
                    new X509TrustManager() {

                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {

                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }

            };
            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, TM, new java.security.SecureRandom());
            final SSLSocketFactory SSSF= sslContext.getSocketFactory();
            OkHttpClient.Builder OKBu = new OkHttpClient.Builder();
            OKBu.sslSocketFactory(SSSF, (X509TrustManager) TM[0]);
            OKBu.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return OKBu;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }}