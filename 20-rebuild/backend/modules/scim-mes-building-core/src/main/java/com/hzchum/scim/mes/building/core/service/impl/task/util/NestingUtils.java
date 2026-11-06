package com.hzchum.scim.mes.building.core.service.impl.task.util;

import com.hzchum.scim.common.core.api.third_party_api.BoChuNesting;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.MachinePartNestingPdfDTO;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class NestingUtils {
   private static final Logger log = LoggerFactory.getLogger(NestingUtils.class);

   private void getNestPartDetailSaveMessage(Integer jobId, String teamCode) {
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/job/result/part_detail";
      HttpHeaders headers = BoChuNesting.headers(teamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(jobId);
      jsonObject.put("job_id", jobIdArray);
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> responseResult = restTemplate.postForEntity(url, entity, Object.class);
      JSONObject j = new JSONObject((Map<String, Object>)responseResult.getBody());
      String result = j.toString();
   }

   private static MachinePartNestingPdfDTO getNestingReportData(String resultId) {
      MachinePartNestingPdfDTO dto = new MachinePartNestingPdfDTO();
      JSONObject jsonObject = new JSONObject();
      JSONArray jobIdArray = new JSONArray();
      jobIdArray.add(resultId);
      jsonObject.put("result_guid_list", jobIdArray);
      RestTemplate restTemplate = new RestTemplate();
      String url = "https://cloudnest.fscut.com/api/web_report/nest_result_data";
      HttpHeaders headers = BoChuNesting.headers();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      HttpEntity<JSONObject> entity = new HttpEntity<>(jsonObject, headers);
      ResponseEntity<Object> responseResult = restTemplate.postForEntity(url, entity, Object.class);
      log.info("Response from server: " + responseResult);
      JSONObject j = new JSONObject((Map<String, Object>)responseResult.getBody());
      JSONObject dataObject = j.getJSONObject("data");
      new ObjectMapper();

      try {
         log.info(dataObject.toString());
         dto = dataObject.toJavaObject(MachinePartNestingPdfDTO.class);
         System.out.println("Name: " + dto);
      } catch (Exception e) {
         e.printStackTrace();
      }

      return dto;
   }
}
