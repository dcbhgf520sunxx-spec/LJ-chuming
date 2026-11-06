package com.hzchum.scim.common.core.api.third_party_api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuCutFileConfigDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuNestedPlateReportDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuPartDTO;
import com.hzchum.scim.common.core.api.pojo.dto.bochu.BoChuPartDetailDTO;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class BoChuNesting {
   private static final Logger log = LoggerFactory.getLogger(BoChuNesting.class);

   public static HttpHeaders headers(String teamCode) {
      HttpHeaders headers = headers();
      headers.set("X-FS-Orgcode", teamCode);
      return headers;
   }

   public static HttpHeaders headers() {
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      String appId = System.getenv("LJAPS_BOCHU_APP_ID");
      String secret = System.getenv("LJAPS_BOCHU_SECRET");
      Preconditions.checkArgument(appId != null && !appId.trim().isEmpty(), "LJAPS_BOCHU_APP_ID is required");
      Preconditions.checkArgument(secret != null && !secret.trim().isEmpty(), "LJAPS_BOCHU_SECRET is required");
      String requestTimestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
      String toSign = appId + '\n' + secret + '\n' + requestTimestamp;
      String token = SecureUtil.md5(toSign).toLowerCase();
      headers.set("X-FS-Appid", appId);
      headers.set("X-FS-Time", requestTimestamp);
      headers.set("X-FS-Token", token);
      headers.set("X-FS-Encode", "UTF-8");
      return headers;
   }

   public static BoChuNestedPlateReportDTO getNestedPlateReport(String teamCode, Collection<String> guidList) {
      String url = "https://cloudnest.fscut.com/api/web_report/nest_result_data";
      JSONObject body = JSONUtil.createObj().set("result_guid_list", guidList);

      try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
         JSONObject resultJson = JSONUtil.parseObj(response.body());
         Preconditions.checkArgument(Objects.equals(resultJson.getInt("status"), 0), "获取套料报告数据, 返回结果: " + resultJson);
         return JSONUtil.toBean(resultJson.getJSONObject("data"), BoChuNestedPlateReportDTO.class);
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
         throw new BusinessException(e.getMessage());
      }
   }

   public static byte[] getNestCutFileNC(String teamCode, Integer jobId, String guid, String type) {
      String url = "https://cloudnest.fscut.com/api/nspf/nc_export";
      JSONObject body = JSONUtil.createObj().set("job_id", jobId).set("type", type).set("name_filter_flag", false).set("result_list", ListUtil.toList(guid));

      try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
         return response.bodyBytes();
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
         throw new BusinessException(e.getMessage());
      }
   }

   public static byte[] getNestCutFileLXDS(String teamCode, Integer jobId, String guid) {
      String url = "https://cloudnest.fscut.com/api/nspf/lxds_export";
      JSONObject body = JSONUtil.createObj().set("job_id", jobId).set("result_list", ListUtil.toList(guid)).set("auto_recognized", true);

      try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
         return response.bodyBytes();
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
         throw new BusinessException(e.getMessage());
      }
   }

   public static List<BoChuCutFileConfigDTO> getNestCutFileConfig(String teamCode) {
      String url = "https://cloudnest.fscut.com/api/open_platform/nc_config";

      try (HttpResponse response = HttpRequest.get(url).header(headers(teamCode)).execute()) {
         JSONObject resultJson = JSONUtil.parseObj(response.body());
         Preconditions.checkArgument(Objects.equals(resultJson.getInt("status"), 0), "获取切割文件类型, 返回结果: " + resultJson);
         return Optional.ofNullable(resultJson.getJSONArray("data"))
            .map(o -> JSONUtil.toList(o, BoChuCutFileConfigDTO.class))
            .orElseGet(Collections::emptyList);
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败", url);
         throw new BusinessException(e.getMessage());
      }
   }

   public static List<BoChuNestedPlateDetailDTO> getNestedPlateDetail(String teamCode, Collection<Integer> jobIdList, Collection<String> guidList) {
      String url = "https://cloudnest.fscut.com/api/job/result/part_detail";
      JSONObject body = JSONUtil.createObj().set("job_id", jobIdList);

      try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
         JSONObject resultJson = JSONUtil.parseObj(response.body());
         Preconditions.checkArgument(Objects.equals(resultJson.getInt("status"), 0), "获取作业下排版详情, 返回结果: " + resultJson);
         List<BoChuNestedPlateDetailDTO> list = Optional.ofNullable(resultJson.getJSONArray("data"))
            .map(o -> JSONUtil.toList(o, BoChuNestedPlateDetailDTO.class))
            .orElseGet(Collections::emptyList);
         return Optional.ofNullable(guidList)
            .filter(CollUtil::isNotEmpty)
            .map(o -> list.stream().filter(i -> o.contains(i.getGuid())).collect(Collectors.toList()))
            .orElse(list);
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
         throw new BusinessException(e.getMessage());
      }
   }

   public static void deleteNestedPlate(String teamCode, Collection<String> guidList) {
      String url = "https://cloudnest.fscut.com/api/nspf/update";
      JSONArray body = JSONUtil.createArray();
      guidList.forEach(guid -> body.set(JSONUtil.createObj().set("guid", guid).set("is_delete", 1)));

      try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
         JSONObject resultJson = JSONUtil.parseObj(response.body());
         Preconditions.checkArgument(Objects.equals(resultJson.getInt("status"), 0), "删除套料板失败, 返回结果: " + resultJson);
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
         throw new BusinessException(e.getMessage());
      }
   }

   public static void partUpdateQuantityOrDelete(String teamCode, Map<String, Integer> partParamMap) {
      if (!MapUtil.isEmpty(partParamMap)) {
         String url = "https://cloudnest.fscut.com/api/part/update";
         JSONArray body = JSONUtil.createArray();
         partParamMap.forEach(
            (partGuid, partAmount) -> body.set(
               JSONUtil.createObj()
                  .set("guid", partGuid)
                  .set(ObjectUtil.equal(partAmount, 0) ? "is_delete" : "amount", ObjectUtil.equal(partAmount, 0) ? 1 : partAmount)
            )
         );

         try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
            JSONObject resultJson = JSONUtil.parseObj(response.body());
            Preconditions.checkArgument(Objects.equals(resultJson.getInt("status"), 0), "更新零件失败, 返回结果: " + resultJson);
         } catch (Exception e) {
            log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
            throw new BusinessException(e.getMessage());
         }
      }
   }

   public static Boolean deleteJob(String teamCode, Integer jobId) {
      Preconditions.checkArgument(jobId != null, "作业id不能为空");
      String url = "https://cloudnest.fscut.com/api/job/update";
      JSONObject body = JSONUtil.createObj().set("id", jobId).set("is_delete", 1);

      try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
         JSONObject resultJson = JSONUtil.parseObj(response.body());
         return ObjectUtil.equals(resultJson.getInt("status"), 0);
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
         throw new BusinessException(e.getMessage());
      }
   }

   public static List<BoChuPartDTO> getPartList(String teamCode, Collection<Integer> jobIdList) {
      String url = "https://cloudnest.fscut.com/api/job/part_list";
      JSONObject body = JSONUtil.createObj().set("job_id", jobIdList);

      try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
         JSONObject resultJson = JSONUtil.parseObj(response.body().replaceAll("((?<!\\\\)\\\\)", "\\\\\\\\"));
         Preconditions.checkArgument(Objects.equals(resultJson.getInt("status"), 0), "获取作业下零件列表失败, 返回结果: " + resultJson);
         return Optional.ofNullable(resultJson.getJSONArray("data")).map(o -> JSONUtil.toList(o, BoChuPartDTO.class)).orElseGet(Collections::emptyList);
      } catch (Exception e) {
         log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
         throw new BusinessException(e.getMessage());
      }
   }

   public static List<BoChuPartDetailDTO> getPartDetailList(String teamCode, Collection<Integer> jobIdList) {
      String url = "https://cloudnest.fscut.com/api/job/part_list/v2";
      List<BoChuPartDetailDTO> resultList = new ArrayList<>();
      if (CollUtil.isNotEmpty(jobIdList)) {
         resultList = jobIdList.stream()
            .map(
               jobId -> {
                  JSONObject body = JSONUtil.createObj().set("job_id", jobId);

                  try (HttpResponse response = HttpRequest.post(url).header(headers(teamCode)).body(body.toString()).execute()) {
                     JSONObject resultJson = JSONUtil.parseObj(response.body());
                     Preconditions.checkArgument(Objects.equals(resultJson.getInt("status"), 0), "获取套料作业零件List, 返回结果: " + resultJson);
                     return Optional.ofNullable(resultJson.getJSONArray("data"))
                        .map(o -> JSONUtil.toList(o, BoChuPartDetailDTO.class))
                        .orElseGet(Collections::emptyList);
                  } catch (Exception e) {
                     log.error("调用柏楚API: {} 失败, 参数: {}", url, body);
                     throw new BusinessException(e.getMessage());
                  }
               }
            )
            .filter(CollUtil::isNotEmpty)
            .flatMap(Collection::stream)
            .filter(x$0 -> BeanUtil.isNotEmpty(x$0))
            .collect(Collectors.toList());
      }

      return resultList;
   }
}
