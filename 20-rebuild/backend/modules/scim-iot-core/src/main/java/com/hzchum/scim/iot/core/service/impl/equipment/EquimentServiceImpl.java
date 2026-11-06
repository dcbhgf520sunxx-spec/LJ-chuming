package com.hzchum.scim.iot.core.service.impl.equipment;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.CorporationStructrure;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo._doModel.equipment.EquipmentType;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics.AmeterFindStatisticsData;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.ameterFindStatistics.AmeterStatisticsVos;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead.DeviceTypeReadVos;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.deviceTypeRead.deviceTypeReadData;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.CappEquipmentCurrentVoltageIofo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.CappEquipmentInfo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.GasFindStatisticsData;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.gasFindStatistics.GasMeterStatisticsVo;
import com.hzchum.scim.iot.core.api.pojo.dto.equipment.plc.PlcData;
import com.hzchum.scim.iot.core.api.service.equiment.EquimentService;
import com.hzchum.scim.system.core.api.common.utils.RequestUtils;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EquimentServiceImpl implements EquimentService {
   private static final Logger log = LoggerFactory.getLogger(EquimentServiceImpl.class);
   @Value("${equiment.ip}")
   private String ip;

   @Override
   public List<DeviceTypeReadVos> deviceTypeRead() {
      String url = this.ip + "/equipment/DeviceLongRangeApi/deviceTypeRead";
      String json = RequestUtils.sendHttpsPostRequest(url, null, String.class);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      JsonNode dataNode = rootNode.get("data");
      deviceTypeReadData vo = JSONObject.parseObject(dataNode.toString(), deviceTypeReadData.class);
      return vo.getDeviceTypeReadVos();
   }

   @Override
   public List<AmeterStatisticsVos> ameterFindStatistics(Long equipmentId, Long prodLineId, Long startTime, Long endTime, Integer abscissa) {
      String url = this.ip + "/equipment/DeviceLongRangeApi/ameterFindStatistics";
      JSONObject map = new JSONObject();
      if (equipmentId != null) {
         map.put("equipmentId", equipmentId);
      }

      if (prodLineId != null) {
         map.put("prodLineId", prodLineId);
      }

      if (startTime != null) {
         map.put("startTime", startTime);
      }

      if (endTime != null) {
         map.put("endTime", endTime);
      }

      if (abscissa != null) {
         map.put("abscissa", abscissa);
      }

      String json = RequestUtils.sendHttpsPostRequest(url, map, String.class);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      JsonNode dataNode = rootNode.get("data");
      AmeterFindStatisticsData vo = JSONObject.parseObject(dataNode.toString(), AmeterFindStatisticsData.class);
      return vo.getAmeterStatisticsVos();
   }

   @Override
   public List<GasMeterStatisticsVo> gasFindStatistics(Long equipmentId, Long prodLineId, Long startTime, Long endTime, Integer gasType, Integer abscissa) {
      String url = this.ip + "/equipment/DeviceLongRangeApi/gasFindStatistics";
      JSONObject map = new JSONObject();
      if (equipmentId != null) {
         map.put("equipmentId", equipmentId);
      }

      if (prodLineId != null) {
         map.put("prodLineId", prodLineId);
      }

      if (startTime != null) {
         map.put("startTime", startTime);
      }

      if (endTime != null) {
         map.put("endTime", endTime);
      }

      if (abscissa != null) {
         map.put("abscissa", abscissa);
      }

      if (gasType != null) {
         map.put("gasType", gasType);
      }

      String json = RequestUtils.sendHttpsPostRequest(url, map, String.class);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      JsonNode dataNode = rootNode.get("data");
      GasFindStatisticsData vo = JSONObject.parseObject(dataNode.toString(), GasFindStatisticsData.class);
      return vo.getGasMeterStatisticsVo();
   }

   @Override
   public List<CorporationStructrure> syncCorporationStructrureInfo() {
      String url = this.ip + "/equipment/DeviceLongRangeApi/syncCorporationStructrureInfo";
      String json = RequestUtils.sendHttpsGetRequest(url);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      JsonNode dataNode = rootNode.get("data");
      return JSONObject.parseArray(dataNode.toString(), CorporationStructrure.class);
   }

   @Override
   public List<EquipmentInfo> syncDeviceInfo() {
      String url = this.ip + "/equipment/DeviceLongRangeApi/syncDeviceInfo";
      String json = RequestUtils.sendHttpsGetRequest(url);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      JsonNode dataNode = rootNode.get("data");
      return JSONObject.parseArray(dataNode.toString(), EquipmentInfo.class);
   }

   @Override
   public List<PlcData> findNow(Long prodLineId, Long deviceId) {
      String url = this.ip + "/equipment/DeviceLongRangeApi/findNow";
      url = url + "?prodLineId=" + prodLineId + "&deviceId=" + deviceId;
      String json = RequestUtils.sendHttpsGetRequest(url);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      JsonNode dataNode = rootNode.get("data");
      return JSONObject.parseArray(dataNode.toString(), PlcData.class);
   }

   @Override
   public List<EquipmentType> syncEquipmentTypeInfo() {
      String url = this.ip + "/equipment/DeviceLongRangeApi/syncEquipmentTypeInfo";
      String json = RequestUtils.sendHttpsGetRequest(url);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         e.printStackTrace();
      }

      JsonNode dataNode = rootNode.get("data");
      return JSONObject.parseArray(dataNode.toString(), EquipmentType.class);
   }

   @Override
   public CappEquipmentInfo cappFindEquipmentInfo(String deviceId) {
      String url = this.ip + "/deviceApi/deviceLongRange/findDeviceBaseInfoById";
      url = url + "?id=" + deviceId;
      String json = RequestUtils.sendHttpsGetRequest(url);
      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         throw new RuntimeException("设备调用异常:" + e.getMessage());
      }

      log.info("焊接设备调用返回详情:" + rootNode);
      Preconditions.checkArgument("000000".equals(rootNode.get("code").toString().replaceAll("\"", "")), "焊接设备调用失败:" + rootNode.get("msg"));
      JsonNode dataNode = rootNode.get("data");
      return JSONObject.parseObject(dataNode.toString(), CappEquipmentInfo.class);
   }

   @Override
   public String cappAddWeldTask(
      String bizId,
      Integer bizType,
      BigDecimal currentLowerLimit,
      BigDecimal currentUpperLimit,
      Long deviceId,
      BigDecimal voltageLowerLimit,
      BigDecimal voltageUpperLimit,
      String weldingGunCode
   ) {
      String url = this.ip + "/deviceApi/deviceLongRange/addDeviceWeldingTask";
      Map<String, Object> params = new HashMap<>();
      params.put("bizId", bizId);
      params.put("bizType", bizType);
      params.put("currentLowerLimit", currentLowerLimit);
      params.put("currentUpperLimit", currentUpperLimit);
      params.put("deviceId", deviceId);
      params.put("voltageLowerLimit", voltageLowerLimit);
      params.put("voltageUpperLimit", voltageUpperLimit);
      params.put("weldingGunCode", weldingGunCode);
      String json = null;

      try {
         JSONObject jsonObject = new JSONObject(params);
         json = RequestUtils.sendHttpsPostRequest(url, jsonObject, String.class);
      } catch (Exception e) {
         e.printStackTrace();
      }

      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         throw new RuntimeException("设备调用异常:" + e.getMessage());
      }

      log.info("焊接设备调用返回详情:" + rootNode);
      Preconditions.checkArgument("000000".equals(rootNode.get("code").toString().replaceAll("\"", "")), "焊接设备调用失败:" + rootNode.get("msg"));
      return rootNode.get("data").toString();
   }

   @Override
   public CappEquipmentCurrentVoltageIofo cappFindEquipmentCurrentVoltageInfo(Long bizId) {
      String url = this.ip + "/deviceApi/deviceLongRange/findDeviceWeldingTaskRealDataById";
      url = url + "?id=" + bizId;
      String json = null;

      try {
         json = RequestUtils.sendHttpsGetRequest(url);
      } catch (Exception e) {
         return null;
      }

      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode rootNode = null;

      try {
         rootNode = objectMapper.readTree(json);
      } catch (JsonProcessingException e) {
         throw new RuntimeException("设备调用异常:" + e.getMessage());
      }

      log.info("焊接设备调用返回详情:" + rootNode);
      Preconditions.checkArgument("000000".equals(rootNode.get("code").toString().replaceAll("\"", "")), "焊接设备调用失败:" + rootNode.get("msg"));
      JsonNode dataNode = rootNode.get("data");
      return JSONObject.parseObject(dataNode.toString(), CappEquipmentCurrentVoltageIofo.class);
   }
}
