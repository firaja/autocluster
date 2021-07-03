package org.autocluster.aop;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.aspectj.lang.ProceedingJoinPoint;


public class AOPUtils
{

    private static final boolean REMOTE = true;

    public static Object intercept(ProceedingJoinPoint joinPoint) throws Throwable
    {
        Object result = null;
        if (REMOTE)
        {
            try (CloseableHttpClient httpClient = HttpClients.createDefault())
            {
                HttpGet request = new HttpGet("https://api.ipify.org?format=json");

                try (CloseableHttpResponse response = httpClient.execute(request);)
                {
                    HttpEntity entity = response.getEntity();
                    if (entity != null)
                    {
                        result = EntityUtils.toString(entity);
                    }
                }
            }
        }
        else
        {
            result = joinPoint.proceed();
        }
        return result;
    }
}
