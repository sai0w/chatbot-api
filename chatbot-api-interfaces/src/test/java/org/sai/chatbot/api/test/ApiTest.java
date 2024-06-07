package org.sai.chatbot.api.test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;


public class ApiTest {
   @Test
   public void query_unanswered_questions() throws IOException {
      CloseableHttpClient httpClient = HttpClientBuilder.create().build();
      HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88888255418422/topics?scope=unanswered_questions&count=20");
      get.addHeader("cookie","zsxq_access_token=E5702869-E10A-0895-9223-FC833DDA2D2E_47BC1D8FFC9A576B; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22421154148214558%22%2C%22first_id%22%3A%2218f6cadcbba61b-0baef36da24f15-4c657b58-1600000-18f6cadcbbb56c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmNmNhZGNiYmE2MWItMGJhZWYzNmRhMjRmMTUtNGM2NTdiNTgtMTYwMDAwMC0xOGY2Y2FkY2JiYjU2YyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQyMTE1NDE0ODIxNDU1OCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22421154148214558%22%7D%2C%22%24device_id%22%3A%2218f6cadcbba61b-0baef36da24f15-4c657b58-1600000-18f6cadcbbb56c%22%7D; abtest_env=product; zsxqsessionid=161ed7ba6f07eafef15ce11f63cf1b79");
      get.addHeader("Content-Type","application/json;charset=utf8");

      CloseableHttpResponse response = httpClient.execute(get);
      if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
         String res = EntityUtils.toString(response.getEntity());
         System.out.println(res);
      }else{
        System.out.println(response.getStatusLine().getStatusCode());
      }
   }
   @Test
   public void answer() throws IOException {
      CloseableHttpClient httpClient = HttpClientBuilder.create().build();

      HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/8855451154828852/answer");
      post.addHeader("cookie","zsxq_access_token=E5702869-E10A-0895-9223-FC833DDA2D2E_47BC1D8FFC9A576B; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22421154148214558%22%2C%22first_id%22%3A%2218f6cadcbba61b-0baef36da24f15-4c657b58-1600000-18f6cadcbbb56c%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThmNmNhZGNiYmE2MWItMGJhZWYzNmRhMjRmMTUtNGM2NTdiNTgtMTYwMDAwMC0xOGY2Y2FkY2JiYjU2YyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjQyMTE1NDE0ODIxNDU1OCJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22421154148214558%22%7D%2C%22%24device_id%22%3A%2218f6cadcbba61b-0baef36da24f15-4c657b58-1600000-18f6cadcbbb56c%22%7D; abtest_env=product; zsxqsessionid=161ed7ba6f07eafef15ce11f63cf1b79");
      post.addHeader("Content-Type","application/json;charset=utf8");

      String paramJson = "{\n" +
              "  \"req_data\": {\n" +
              "    \"text\": \"请你去百度！\\n\",\n" +
              "    \"image_ids\": []\n" +
              "  }\n" +
              "}";

      StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
      post.setEntity(stringEntity);
      CloseableHttpResponse response = httpClient.execute(post);
      if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
         String res = EntityUtils.toString(response.getEntity());
         System.out.println(res);
      }else{
         System.out.println(response.getStatusLine().getStatusCode());
      }

   }

}
