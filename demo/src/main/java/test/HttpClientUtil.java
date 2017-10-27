package test;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by 845477519@qq.com on 2017/10/13 0013.
 */
public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    public static final String CHARSET = "UTF-8";
    private static ThreadLocal<Map<String, String>> httpHeader = new ThreadLocal();
    private static ThreadLocal<Map<String, Object>> httpClientConfig = new ThreadLocal();
    public static final String CONNECT_TIMEOUT = "connect_timeout";
    public static final String SOCKET_TIMEOUT = "socket_timeout";
    public static final Integer DEFAULT_CONNECT_TIMEOUT = Integer.valueOf(600000);
    public static final Integer DEFAULT_SOCKET_TIMEOUT = Integer.valueOf(600000);

    private HttpClientUtil() {
    }

    public static CloseableHttpClient buildHttpClient() {
        Object configSetting = new HashMap();
        if(httpClientConfig != null && null != httpClientConfig.get()) {
            configSetting = (Map)httpClientConfig.get();
        }

        RequestConfig.Builder builder = RequestConfig.custom();
        Integer connectTimeout = DEFAULT_CONNECT_TIMEOUT;
        if(((Map)configSetting).get("connect_timeout") != null) {
            try {
                connectTimeout = Integer.valueOf(((Map)configSetting).get("connect_timeout").toString());
            } catch (Exception var6) {
                logger.warn("class covert error!", var6);
                connectTimeout = DEFAULT_CONNECT_TIMEOUT;
            }
        }

        builder.setConnectTimeout(connectTimeout.intValue());
        Integer socketTimeout = DEFAULT_SOCKET_TIMEOUT;
        if(((Map)configSetting).get("socket_timeout") != null) {
            try {
                socketTimeout = Integer.valueOf(((Map)configSetting).get("socket_timeout").toString());
            } catch (Exception var5) {
                logger.warn("class covert error!", var5);
                socketTimeout = DEFAULT_SOCKET_TIMEOUT;
            }
        }

        builder.setSocketTimeout(socketTimeout.intValue());
        RequestConfig config = builder.build();
        return HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    public static String doGet(String url, Map<String, String> params) throws Exception {
        return doGet(url, params, "UTF-8");
    }

    public static String doPost(String url, Map<String, String> params) throws Exception {
        return doPost(url, params, "UTF-8");
    }

    public static String doGet(String url, Map<String, String> params, String charset) throws Exception {
        if(StringUtils.isBlank(url)) {
            return null;
        } else {
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse response = null;

            String var9;
            try {
                String result;
                if(params != null && !params.isEmpty()) {
                    ArrayList e = new ArrayList(params.size());
                    Iterator statusCode = params.entrySet().iterator();

                    while(statusCode.hasNext()) {
                        Map.Entry entity = (Map.Entry)statusCode.next();
                        result = (String)entity.getValue();
                        if(result != null) {
                            e.add(new BasicNameValuePair((String)entity.getKey(), result));
                        }
                    }

                    url = url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(e, charset));
                }

                HttpGet e1 = new HttpGet(url);
                handlerHeader(e1);
                httpClient = buildHttpClient();
                response = httpClient.execute(e1);
                int statusCode1 = response.getStatusLine().getStatusCode();
                if(statusCode1 != 200) {
                    e1.abort();
                    throw new RuntimeException("HttpClient,error status code :" + statusCode1);
                }

                HttpEntity entity1 = response.getEntity();
                result = null;
                if(entity1 != null) {
                    result = EntityUtils.toString(entity1, "utf-8");
                }

                EntityUtils.consume(entity1);
                response.close();
                var9 = result;
            } catch (Exception var13) {
                logger.error(var13.getMessage(), var13);
                throw var13;
            } finally {
                if(response != null) {
                    response.close();
                }

                if(httpClient != null) {
                    httpClient.close();
                }

            }

            return var9;
        }
    }

    private static void handlerHeader(HttpRequestBase requestBase) {
        if(httpHeader != null && httpHeader.get() != null) {
            Map map = (Map)httpHeader.get();
            Iterator var2 = map.keySet().iterator();

            while(var2.hasNext()) {
                String key = (String)var2.next();
                requestBase.addHeader(key, (String)map.get(key));
            }
        }

    }

    public static String doPost(String url, Map<String, String> params, String charset) throws Exception {
        if(StringUtils.isBlank(url)) {
            return null;
        } else {
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse response = null;

            String var10;
            try {
                ArrayList e = null;
                if(params != null && !params.isEmpty()) {
                    e = new ArrayList(params.size());
                    Iterator httpPost = params.entrySet().iterator();

                    while(httpPost.hasNext()) {
                        Map.Entry statusCode = (Map.Entry)httpPost.next();
                        String entity = (String)statusCode.getValue();
                        if(entity != null) {
                            e.add(new BasicNameValuePair((String)statusCode.getKey(), entity));
                        }
                    }
                }

                HttpPost httpPost1 = new HttpPost(url);
                handlerHeader(httpPost1);
                if(e != null && e.size() > 0) {
                    httpPost1.setEntity(new UrlEncodedFormEntity(e, "UTF-8"));
                }

                httpClient = buildHttpClient();
                response = httpClient.execute(httpPost1);
                int statusCode1 = response.getStatusLine().getStatusCode();
                if(statusCode1 != 200) {
                    httpPost1.abort();
                    throw new RuntimeException("HttpClient,error status code :" + statusCode1);
                }

                HttpEntity entity1 = response.getEntity();
                String result = null;
                if(entity1 != null) {
                    result = EntityUtils.toString(entity1, "utf-8");
                }

                EntityUtils.consume(entity1);
                var10 = result;
            } catch (Exception var14) {
                logger.error(var14.getMessage(), var14);
                throw var14;
            } finally {
                if(response != null) {
                    response.close();
                }

                if(httpClient != null) {
                    httpClient.close();
                }

            }

            return var10;
        }
    }

    public static String doPost(String url, String jsonParam) throws Exception {
        if(StringUtils.isBlank(url)) {
            return null;
        } else {
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse response = null;

            String var8;
            try {
                HttpPost e = new HttpPost(url);
                handlerHeader(e);
                if(StringUtils.isNotBlank(jsonParam)) {
                    StringEntity statusCode = new StringEntity(jsonParam);
                    statusCode.setContentEncoding("UTF-8");
                    statusCode.setContentType("application/json");
                    e.setEntity(statusCode);
                }

                httpClient = buildHttpClient();
                response = httpClient.execute(e);
                int statusCode1 = response.getStatusLine().getStatusCode();
                if(statusCode1 != 200) {
                    e.abort();
                    throw new RuntimeException("HttpClient,error status code :" + statusCode1);
                }

                HttpEntity entity = response.getEntity();
                String result = null;
                if(entity != null) {
                    result = EntityUtils.toString(entity, "utf-8");
                }

                EntityUtils.consume(entity);
                response.close();
                var8 = result;
            } catch (Exception var12) {
                logger.error(var12.getMessage(), var12);
                throw var12;
            } finally {
                if(response != null) {
                    response.close();
                }

                if(httpClient != null) {
                    httpClient.close();
                }

            }

            return var8;
        }
    }

    public static String doPost(String url, String params, String contentType) throws Exception {
        if(StringUtils.isBlank(url)) {
            return null;
        } else {
            CloseableHttpClient httpClient = null;
            CloseableHttpResponse response = null;

            String var9;
            try {
                HttpPost e = new HttpPost(url);
                handlerHeader(e);
                if(StringUtils.isNotBlank(params)) {
                    StringEntity statusCode = new StringEntity(params, "UTF-8");
                    statusCode.setContentEncoding("UTF-8");
                    if(StringUtils.isNotBlank(contentType)) {
                        statusCode.setContentType(contentType);
                    }

                    e.setEntity(statusCode);
                }

                httpClient = buildHttpClient();
                response = httpClient.execute(e);
                int statusCode1 = response.getStatusLine().getStatusCode();
                if(statusCode1 != 200) {
                    e.abort();
                    throw new RuntimeException("HttpClient,error status code :" + statusCode1);
                }

                HttpEntity entity = response.getEntity();
                String result = null;
                if(entity != null) {
                    result = EntityUtils.toString(entity, "utf-8");
                }

                EntityUtils.consume(entity);
                response.close();
                var9 = result;
            } catch (Exception var13) {
                logger.error(var13.getMessage(), var13);
                throw var13;
            } finally {
                if(response != null) {
                    response.close();
                }

                if(httpClient != null) {
                    httpClient.close();
                }

            }

            return var9;
        }
    }

    public static void setHeader(Map<String, String> header) {
        if(header != null) {
            httpHeader.set(header);
        }

    }

    public static void setConfig(Map<String, Object> config) {
        if(config != null) {
            httpClientConfig.set(config);
        }

    }
}
