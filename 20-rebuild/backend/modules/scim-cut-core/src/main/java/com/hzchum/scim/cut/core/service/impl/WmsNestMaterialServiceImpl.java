package com.hzchum.scim.cut.core.service.impl;

import com.hzchum.scim.common.core.api.third_party_api.BoChuNesting;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtils;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.enums.OutboundTypeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.cut.core.api.pojo._do.WmsNestMaterial;
import com.hzchum.scim.cut.core.api.pojo._do.WmsPlantPart;
import com.hzchum.scim.cut.core.api.pojo._do.WmsSurplusMaterials;
import com.hzchum.scim.cut.core.api.service.WmsNestMaterialService;
import com.hzchum.scim.cut.core.api.service.WmsPlantPartService;
import com.hzchum.scim.cut.core.api.service.WmsSurplusMaterialsService;
import com.hzchum.scim.cut.core.mapper.WmsNestMaterialMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuNestingResult;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskOrder;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuNestingResultService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskOrderService;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.biz.OutBoundServiceBiz;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialFreezeTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialLabelPrintTypeEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialOutboundModeEnum;
import com.hzchum.scim.wms.core.api.enums.MessageEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundRelationTypeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.TransferTypeEnum;
import com.hzchum.scim.wms.core.api.enums.UnitsPrecisionEnum;
import com.hzchum.scim.wms.core.api.enums.WeightedPriceEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedExecutionPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WeightedPriceConf;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.Statistics;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsEndPeriod;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsInbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsOutbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreeze;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialFreezeRecord;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MonthWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MoveOutboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Outbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Print;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.PrintDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Transfer;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.TransferDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WholeWeightedAveragePrice;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvert;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPlantConvertDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.PriceDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.InstantMessageHintDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.SteelPlateInventoryDTO;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.MeasureService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarningService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WarehouseDataDashboardService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeRecordService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialFreezeService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MoveOutboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.PrintService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.TransferService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsCutService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPlantConvertService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.DownloadFile;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.api.utils.WmsUtil;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsNestMaterialServiceImpl extends ServiceImpl<WmsNestMaterialMapper, WmsNestMaterial> implements WmsNestMaterialService {
   private static final Logger log = LoggerFactory.getLogger(WmsNestMaterialServiceImpl.class);
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   WmsCutService wmsCutService;
   @Resource
   WmsSurplusMaterialsService wmsSurplusMaterialsService;
   @Resource
   DownloadFile downloadFile;
   @Resource
   OutboundService outboundService;
   @Resource
   MoveOutboundDetailService outboundDetailService;
   @Resource
   WmsPlantPartService wmsPlantPartService;
   @Resource
   MesBuildingBoChuNestingResultService mesBuildingBoChuNestingResultService;
   @Resource
   MesBuildingBoChuJobDirectoryService mesBuildingBoChuJobDirectoryService;
   @Resource
   BasicConfigService basicConfigService;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   OutBoundServiceBiz outBoundServiceBiz;
   @Resource
   MeasureService measureService;
   @Resource
   MaterialFreezeService materialFreezeService;
   @Resource
   MaterialFreezeRecordService materialFreezeRecordService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   PrintService printService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   InboundService inboundService;
   @Resource
   TransferService transferService;
   @Resource
   TransferDetailService transferDetailService;
   @Resource
   WarningService warningService;
   @Resource
   MesBuildingTaskOrderService mesBuildingTaskOrderService;
   RoundingMode ROUNDING = RoundingMode.HALF_UP;
   @Resource
   private ConfigProperties configProperties;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   WmsPlantConvertService wmsPlantConvertService;
   @Resource
   WmsPlantConvertDetailService wmsPlantConvertDetailService;
   @Resource
   MesBuildingNestingTeamService mesBuildingNestingTeamService;
   @Resource
   MesBuildingTaskNeedMachinePartSchedulingService mesBuildingTaskNeedMachinePartSchedulingService;
   @Resource
   WarehouseDataDashboardService warehouseDataDashboardService;
   private static final BigDecimal thousand = new BigDecimal("1000");
   @Resource
   WmsUtil wmsUtil;
   @Value("${wms.amount-accuracy}")
   private Integer amountAccuracy;

   @Override
   public ResultVO getMaterial(String teamCode) {
      HttpHeaders headers = getHeadedr(teamCode);
      HttpResponse execute1 = HttpRequest.get(this.configProperties.getBoChuUrl() + "api/material/list/v2")
         .header(headers)
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      if (execute1.isOk()) {
         JSONObject jsonObject1 = JSON.parseObject(execute1.body());
         JSONArray data = jsonObject1.getJSONArray("data");
         List<String> materialList1 = new ArrayList<>();
         data.forEach(data1 -> {
            JSONObject jsonObject2 = JSON.parseObject(data1.toString());
            materialList1.add(jsonObject2.getString("material"));
         });
         List<String> materialList = this.baseMapper.getMaterialList();
         Collection<String> disjunction = CollUtil.subtract(materialList, materialList1);
         disjunction.forEach(disjunction1 -> this.addMaterial(disjunction1, String.valueOf(7850), teamCode));
      }

      return ResultBuilder.success("成功");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public JSONArray getPlant(Long materialId, Double thickness, String teamCode) {
      JSONObject jsonObject1 = new JSONObject();
      jsonObject1.put("material_id", materialId);
      jsonObject1.put("thickness", thickness.toString());
      HttpHeaders headers = getHeadedr(teamCode);
      log.info("调用获取板材接口:{}", materialId + "------->" + thickness);
      HttpResponse execute3 = HttpRequest.get(this.configProperties.getBoChuUrl() + "api/plate/list/v2")
         .header(headers)
         .body(JSONObject.toJSONString(jsonObject1))
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      JSONArray jsonArray = new JSONArray();
      if (execute3.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute3.body());
         JSONArray data = jsonObject3.getJSONArray("data");
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("获取板材成功:{}", materialId + "--->" + thickness);
            log.info("获取板材成功:{}", data);
            jsonArray = data;
         }
      }

      return jsonArray;
   }

   @Override
   public WmsNestMaterial addMaterial(String name, String density, String teamCode) {
      HttpHeaders header = getHeadedr(teamCode);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("name", name);
      jsonObject.put("density", density);
      log.info("调用新增材质接口:{}", name + "--->" + density);
      HttpResponse execute = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/material/add")
         .header(header)
         .body(JSONObject.toJSONString(jsonObject))
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      if (execute.isOk()) {
         JSONObject jsonObject1 = JSON.parseObject(execute.body());
         if (jsonObject1.get("msg").equals("OK")) {
            log.info("新增材质成功:{}", name + "--->" + jsonObject1.toJSONString());
            JSONObject data = jsonObject1.getJSONObject("data");
            WmsNestMaterial material_id = WmsNestMaterial.builder()
               .materialId(data.getLong("material_id"))
               .material(name)
               .density(density)
               .teamCode(teamCode)
               .build();
            this.saveOrUpdate(material_id, (Wrapper<WmsNestMaterial>)((UpdateWrapper)new UpdateWrapper().eq("material", name)).eq("team_code", teamCode));
            return material_id;
         }

         if (jsonObject1.get("msg").equals("材质已存在")) {
            log.info("材质已存在:{}", name + "--->" + jsonObject1.toJSONString());
            JSONObject data = jsonObject1.getJSONObject("data");
            WmsNestMaterial material_id = WmsNestMaterial.builder()
               .materialId(data.getLong("material_id"))
               .material(name)
               .teamCode(teamCode)
               .density(density)
               .build();
            this.saveOrUpdate(material_id, (Wrapper<WmsNestMaterial>)((UpdateWrapper)new UpdateWrapper().eq("material", name)).eq("team_code", teamCode));
            return material_id;
         }
      }

      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updatePlant(Double thickness, String material, String syncKey, String teamCode) {
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      List<SteelPlateInventoryDTO> steelPlateList = this.wmsCutService.getSteelPlateList(material, thickness, teamCode);
      WmsNestMaterial one = this.getOne(
         (Wrapper<WmsNestMaterial>)(new LambdaQueryWrapper<WmsNestMaterial>().eq(StrUtil.isNotBlank(material), WmsNestMaterial::getMaterial, material))
            .eq(WmsNestMaterial::getTeamCode, teamCode)
      );
      if (ObjectUtil.isNull(one) || one.getMaterialId() == null) {
         log.info("新增板材时材质id不存在,新增:{}", material);
         one = this.addMaterial(material, String.valueOf(7850), teamCode);
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(one), "材质编码新增失败");
      }

      if (inventoryTypeConfig.getInventoryGainType() == 1) {
         JSONArray plant = this.getPlant(one.getMaterialId(), thickness, teamCode);
         JSONArray jsonArray = new JSONArray();
         ArrayList<Long> plantIds = new ArrayList<>();
         if (CollectionUtil.isNotEmpty(plant)) {
            plant.forEach(data1 -> {
               JSONObject jsonObject2 = JSON.parseObject(data1.toString());
               Long id = jsonObject2.getLong("id");
               if (jsonObject2.containsKey("sync_id")) {
                  String sync_id = jsonObject2.getString("sync_id");
                  if (StrUtil.isNotEmpty(sync_id)) {
                     plantIds.add(id);
                  }
               }
            });
         }

         WmsNestMaterial finalOne = one;
         JSONArray jsonArray1 = new JSONArray();
         steelPlateList.forEach(steelPlateInventoryDTO -> {
            if (steelPlateInventoryDTO.getPlateId() != null && plantIds.contains(steelPlateInventoryDTO.getPlateId())) {
               JSONObject jsonObject5 = new JSONObject();
               jsonObject5.put("id", steelPlateInventoryDTO.getPlateId());
               jsonObject5.put("is_delete", "0");
               jsonObject5.put("remain_amount", steelPlateInventoryDTO.getQuantity());
               jsonArray.add(jsonObject5);
            } else if (steelPlateInventoryDTO.getIsRemnant() == 0) {
               JSONObject jsonObject4 = new JSONObject();
               jsonObject4.put("plate_name", steelPlateInventoryDTO.getUserdata1());
               jsonObject4.put("remain_amount", steelPlateInventoryDTO.getQuantity());
               jsonObject4.put("width", steelPlateInventoryDTO.getWidth().toString());
               jsonObject4.put("height", steelPlateInventoryDTO.getLength().toString());
               jsonObject4.put("material_id", finalOne.getMaterialId());
               jsonObject4.put("thickness", steelPlateInventoryDTO.getThickness().toString());
               jsonObject4.put("gap", "1");
               jsonObject4.put("sync_id", steelPlateInventoryDTO.getId().toString());
               JSONObject propJsonObject = new JSONObject();
               propJsonObject.put("炉批号", steelPlateInventoryDTO.getHeatNoAndBatchNo());
               propJsonObject.put("仓库", steelPlateInventoryDTO.getWarehouseName());
               propJsonObject.put("来源", "WMS物料仓");
               if (steelPlateInventoryDTO.getBoolPartyA()) {
                  propJsonObject.put("是否甲供", "甲供");
               } else {
                  propJsonObject.put("是否甲供", "自采");
               }

               jsonObject4.put("prop", propJsonObject);
               jsonArray1.add(jsonObject4);
            } else if (StrUtil.isNotBlank(steelPlateInventoryDTO.getDxfUrl())) {
               steelPlateInventoryDTO.setMaterialId(finalOne.getMaterialId());
               this.addSurplusPlate1(steelPlateInventoryDTO, teamCode);
            }
         });
         Boolean aBoolean1 = this.updatePlate(jsonArray, teamCode);
         this.addSurplusPlate(thickness, one.getMaterialId(), one.getMaterial(), teamCode);
         Boolean aBoolean = this.addAllPlate(jsonArray1, teamCode);
         if (aBoolean) {
            JSONArray plant1 = this.getPlant(one.getMaterialId(), thickness, teamCode);
            if (CollectionUtil.isNotEmpty(plant1)) {
               ArrayList<MaterialInventory> objects = new ArrayList<>();
               JSONArray UpdateJsonArray = new JSONArray();
               ArrayList<Long> plantId = new ArrayList<>();
               plant1.forEach(
                  data1 -> {
                     JSONObject jsonObject2 = JSON.parseObject(data1.toString());
                     Long id = jsonObject2.getLong("id");
                     String guid = jsonObject2.getString("guid");
                     if (jsonObject2.containsKey("sync_id")) {
                        String sync_id = jsonObject2.getString("sync_id");
                        if (StrUtil.isNotBlank(sync_id)) {
                           if (StrUtil.containsAny(sync_id, "虚拟")) {
                              String 虚拟 = StrUtil.removeAll(sync_id, "虚拟");
                              WmsSurplusMaterials build = WmsSurplusMaterials.builder().id(Long.valueOf(虚拟)).plateId(id).guid(guid).build();
                              WmsSurplusMaterials byId = this.wmsSurplusMaterialsService.getById(Long.valueOf(虚拟));
                              if (ObjectUtil.isNotEmpty(byId)) {
                                 this.wmsSurplusMaterialsService.updateById(build);
                              } else {
                                 JSONObject jsonObject5 = new JSONObject();
                                 jsonObject5.put("id", id);
                                 jsonObject5.put("is_delete", "1");
                                 UpdateJsonArray.add(jsonObject5);
                              }
                           } else {
                              plantId.add(id);
                              List<MaterialInventory> list = this.materialInventoryService
                                 .list(
                                    ((((new LambdaQueryWrapper<MaterialInventory>()
                                                   .eq(MaterialInventory::getId, sync_id))
                                                .eq(MaterialInventory::getThickness, thickness))
                                             .eq(StrUtil.isNotBlank(material), MaterialInventory::getSpecification, material))
                                          .eq(jsonObject2.containsKey("width"), MaterialInventory::getWidth, jsonObject2.getDouble("width")))
                                       .eq(jsonObject2.containsKey("height"), MaterialInventory::getLength, jsonObject2.getDouble("height"))
                                 );
                              if (ObjectUtil.isNotEmpty(list)) {
                                 objects.add(MaterialInventory.builder().guid(guid).plateId(id).id(Long.valueOf(sync_id)).build());
                              } else {
                                 JSONObject jsonObject5 = new JSONObject();
                                 jsonObject5.put("id", id);
                                 jsonObject5.put("is_delete", "1");
                                 UpdateJsonArray.add(jsonObject5);
                              }
                           }
                        }
                     }
                  }
               );
               log.info("更新库存仓库柏楚板材id:{}", objects);
               this.materialInventoryService.updateBatchById(objects);
               plantId.forEach(
                  plantId1 -> {
                     List<MaterialInventory> list = this.materialInventoryService
                        .list((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getPlateId, plantId1));
                     log.info("验证库存是否有这个云排的plantId:{}", list);
                     if (CollectionUtil.isEmpty(list)) {
                        JSONObject jsonObject5 = new JSONObject();
                        jsonObject5.put("id", plantId1);
                        jsonObject5.put("is_delete", "1");
                        UpdateJsonArray.add(jsonObject5);
                     }
                  }
               );
               if (CollectionUtil.isNotEmpty(UpdateJsonArray)) {
                  log.info("更新mes库存仓库不存在的库存:{}", UpdateJsonArray);
                  Boolean var19 = this.updatePlate(UpdateJsonArray, teamCode);
               }

               this.syncTime(one.getMaterialId().toString(), String.valueOf(thickness), syncKey, teamCode);
            } else {
               this.syncTime(one.getMaterialId().toString(), String.valueOf(thickness), syncKey, teamCode);
            }
         }
      } else if (inventoryTypeConfig.getInventoryGainType() == 2) {
         this.syncTime(one.getMaterialId().toString(), String.valueOf(thickness), syncKey, teamCode);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean getJobPlant(Long jobId, JSONArray jsonArray, String teamCode, String message) {
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      if (inventoryTypeConfig.getInventoryGainType() == 1) {
         List<MesBuildingBoChuJobDirectory> list = this.mesBuildingBoChuJobDirectoryService
            .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaUpdateWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getJobId, jobId));
         if (CollectionUtil.isNotEmpty(list)) {
            jsonArray.forEach(guid -> this.getNspfPart(guid.toString(), teamCode, list.get(0).getJobName()));
            log.info("库存检查没问题,发送消息到mes，{}", message);
         } else {
            log.error("系统不存在该任务:{}", jobId);
         }
      } else {
         log.info("物料获取模式为本地{}");
      }

      this.mesBuildingTaskNeedMachinePartSchedulingService.updateMachinePartNestingJobStatusV2(message);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean generateSurplus(List<String> guids) {
      guids.forEach(
         guid -> {
            List<MesBuildingBoChuNestingResult> list1 = this.mesBuildingBoChuNestingResultService
               .list((Wrapper<MesBuildingBoChuNestingResult>)new LambdaUpdateWrapper<MesBuildingBoChuNestingResult>().eq(MesBuildingBoChuNestingResult::getChildGuid, guid));
            if (list1.get(0).getInventoryGainType() == 1) {
               List<WmsSurplusMaterials> list = this.wmsSurplusMaterialsService
                  .list(
                     (Wrapper<WmsSurplusMaterials>)(new LambdaQueryWrapper<WmsSurplusMaterials>().eq(WmsSurplusMaterials::getStockGuid, list1.get(0).getGuid()))
                        .eq(WmsSurplusMaterials::getBoolNestVirtual, false)
                  );
               list.forEach(spus -> {
                  WmsSurplusMaterials id = BeanUtil.copy(spus, WmsSurplusMaterials.class, "id");
                  id.setQuantity(spus.getQuantity());
                  id.setStockQuantity(BigDecimal.ONE);
                  id.setBoolNestVirtual(true);
                  id.setStockCutGuid(guid);
                  this.wmsSurplusMaterialsService.save(id);
               });
               this.saveOutbound(list1.get(0).getGuid(), guid, list1.get(0).getChildOrderNumber(), null, null);
            }
         }
      );
      return true;
   }

   public Boolean updatePlate(JSONArray jsonArray, String teamCode) {
      HttpHeaders header = getHeadedr(teamCode);
      if (CollectionUtil.isNotEmpty(jsonArray)) {
         log.info("更新板材:{}", jsonArray);
         HttpResponse execute4 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/plate/update")
            .header(header)
            .body(JSONObject.toJSONString(jsonArray))
            .setConnectionTimeout(60000)
            .setReadTimeout(60000)
            .execute();
         if (execute4.isOk()) {
            JSONObject plant = JSON.parseObject(execute4.body());
            if (plant.get("msg").equals("OK")) {
               log.info("更新板材成功:{}");
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @Override
   public Boolean addSurplusPlate(Double thickness, Long materialId, String material, String teamCode) {
      List<MesBuildingNestingTeam> mesBuildingNestingTeamList = this.mesBuildingNestingTeamService
         .list(
            (Wrapper<MesBuildingNestingTeam>)(new LambdaQueryWrapper<MesBuildingNestingTeam>().eq(MesBuildingNestingTeam::getBoolDrillHole, 1))
               .eq(MesBuildingNestingTeam::getTeamCode, teamCode)
         );
      MesBuildingNestingTeam mesBuildingNestingTeam = mesBuildingNestingTeamList.get(0);
      List<WmsSurplusMaterials> list = this.wmsSurplusMaterialsService
         .list(
            (Wrapper<WmsSurplusMaterials>)(((new LambdaQueryWrapper<WmsSurplusMaterials>()
                        .eq(WmsSurplusMaterials::getBoolNestFrozen, false))
                     .eq(WmsSurplusMaterials::getBoolNestVirtual, true))
                  .eq(WmsSurplusMaterials::getMaterialId, materialId))
               .eq(WmsSurplusMaterials::getThickness, thickness)
         );
      JSONArray jsonArray = new JSONArray();
      list.forEach(
         slup -> {
            if (slup.getPlateId() == null) {
               SteelPlateInventoryDTO steelPlateInventoryDTO = SteelPlateInventoryDTO.builder()
                  .id(slup.getId())
                  .IsRemnant(1)
                  .userdata1("WMS余料")
                  .quantity(slup.getQuantity())
                  .width(slup.getWidth())
                  .length(slup.getLength())
                  .thickness(slup.getThickness())
                  .dxfUrl(slup.getDxfUrl())
                  .imgUrl(slup.getImageUrl())
                  .boolNestVirtual(true)
                  .build();
               HttpHeaders headers = getHeadedr(teamCode);
               Map<String, Object> params = new HashMap<>();
               JSONObject jsonObject4 = new JSONObject();
               jsonObject4.put("plate_type", steelPlateInventoryDTO.getIsRemnant());
               jsonObject4.put("plate_name", steelPlateInventoryDTO.getUserdata1());
               jsonObject4.put("remain_amount", steelPlateInventoryDTO.getQuantity());
               jsonObject4.put("width", steelPlateInventoryDTO.getWidth());
               jsonObject4.put("height", steelPlateInventoryDTO.getLength());
               jsonObject4.put("material_id", slup.getMaterialId());
               jsonObject4.put("thickness", steelPlateInventoryDTO.getThickness());
               jsonObject4.put("gap", 1);
               jsonObject4.put("sync_id", "虚拟" + steelPlateInventoryDTO.getId().toString());
               params.put("data", jsonObject4.toString());
               File file = FileUtil.newFile(this.configProperties.getFilePath1() + steelPlateInventoryDTO.getDxfUrl());
               File file1 = FileUtil.newFile(this.configProperties.getFilePath1() + steelPlateInventoryDTO.getImgUrl());
               params.put("dxf", file);
               params.put("image", file1);
               headers.setContentType(MediaType.valueOf("multipart/form-data"));
               log.info("新增虚拟余料板材:{}", params);
               HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/plate/add")
                  .header(headers)
                  .form(params)
                  .setConnectionTimeout(60000)
                  .setReadTimeout(60000)
                  .execute();
               if (execute5.isOk()) {
                  JSONObject jsonObject3 = JSON.parseObject(execute5.body());
                  log.info("新增虚拟余料板材返回数据:{}", jsonObject3);
                  if (jsonObject3.get("msg").equals("OK")) {
                     log.info("新增余料板材成功:{}", jsonObject3.toJSONString());
                     JSONObject data = jsonObject3.getJSONObject("data");
                     Long id = data.getLong("id");
                     String guid = data.getString("guid");
                     slup.setGuid(guid);
                     this.wmsSurplusMaterialsService.updateById(slup);
                     JSONArray jsonArray1 = new JSONArray();
                     JSONObject nspf = new JSONObject();
                     JSONObject prop = new JSONObject();
                     nspf.put("guid", guid);
                     prop.put("来源", "WMS虚拟余料仓");
                     prop.put("仓库", "WMS虚拟余料仓");
                     prop.put("boolNestVirtual", steelPlateInventoryDTO.getBoolNestVirtual());
                     if (steelPlateInventoryDTO.getBoolPartyA()) {
                        prop.put("是否甲供", "甲供");
                     } else {
                        prop.put("是否甲供", "自采");
                     }

                     nspf.put("prop", prop);
                     jsonArray1.add(nspf);
                     this.updatePlateProp(jsonArray1, teamCode);
                  }
               }
            } else {
               JSONObject jsonObject5 = new JSONObject();
               jsonObject5.put("id", slup.getPlateId());
               jsonObject5.put("is_delete", "0");
               jsonObject5.put("remain_amount", slup.getQuantity());
               jsonArray.add(jsonObject5);
            }
         }
      );
      this.updatePlate(jsonArray, teamCode);
      return true;
   }

   public Boolean addSurplusPlate1(SteelPlateInventoryDTO steelPlateInventoryDTO, String teamCode) {
      HttpHeaders headers = getHeadedr(teamCode);
      Map<String, Object> params = new HashMap<>();
      JSONObject jsonObject4 = new JSONObject();
      jsonObject4.put("plate_type", steelPlateInventoryDTO.getIsRemnant());
      jsonObject4.put("plate_name", steelPlateInventoryDTO.getUserdata1());
      jsonObject4.put("remain_amount", steelPlateInventoryDTO.getQuantity());
      jsonObject4.put("width", steelPlateInventoryDTO.getWidth());
      jsonObject4.put("height", steelPlateInventoryDTO.getLength());
      jsonObject4.put("material_id", steelPlateInventoryDTO.getMaterialId());
      jsonObject4.put("thickness", steelPlateInventoryDTO.getThickness());
      jsonObject4.put("gap", 1);
      jsonObject4.put("sync_id", steelPlateInventoryDTO.getId().toString());
      params.put("data", jsonObject4.toString());
      File file = FileUtil.newFile(this.configProperties.getFilePath1() + steelPlateInventoryDTO.getDxfUrl());
      File file1 = FileUtil.newFile(this.configProperties.getFilePath1() + steelPlateInventoryDTO.getImgUrl());
      params.put("dxf", file);
      params.put("image", file1);
      headers.setContentType(MediaType.valueOf("multipart/form-data"));
      log.info("新增真实余料板材:{}", params);
      HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/plate/add")
         .header(headers)
         .form(params)
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      log.info("新增真实余料板返回数据：{}", JSON.parseObject(execute5.body()));
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("新增余料板材成功:{}", jsonObject3.toJSONString());
            JSONObject data = jsonObject3.getJSONObject("data");
            Long id = data.getLong("id");
            String guid = data.getString("guid");
            JSONArray jsonArray1 = new JSONArray();
            JSONObject nspf = new JSONObject();
            JSONObject prop = new JSONObject();
            nspf.put("guid", guid);
            prop.put("来源", "WMS余料仓");
            prop.put("仓库", "仓库");
            if (steelPlateInventoryDTO.getBoolPartyA()) {
               prop.put("是否甲供", "甲供");
            } else {
               prop.put("是否甲供", "自采");
            }

            prop.put("仓库", "仓库");
            nspf.put("prop", prop);
            jsonArray1.add(nspf);
            this.updatePlateProp(jsonArray1, teamCode);
         }
      }

      return null;
   }

   public Boolean addAllPlate(JSONArray jsonArray, String teamCode) {
      HttpHeaders header = getHeadedr(teamCode);
      log.info("批量新增板材:{}", jsonArray);
      if (CollectionUtil.isNotEmpty(jsonArray)) {
         HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/plate/add/v2")
            .header(header)
            .body(jsonArray.toJSONString())
            .setConnectionTimeout(60000)
            .setReadTimeout(60000)
            .execute();
         if (execute5.isOk()) {
            JSONObject jsonObject3 = JSON.parseObject(execute5.body());
            log.info("批量新增板材返回消息:{}", jsonObject3.toJSONString());
            if (jsonObject3.get("msg").equals("OK")) {
               log.info("批量新增板材成功:{}", jsonObject3.toJSONString());
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public JSONObject getAllPlate(Long jobId, String teamCode) {
      JSONArray jsonArray1 = new JSONArray();
      jsonArray1.add(jobId);
      JSONObject propJsonObject = new JSONObject();
      propJsonObject.put("job_id", jsonArray1);
      HttpHeaders header = getHeadedr(teamCode);
      log.info("获取作业下排版信息:{}", jobId);
      HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/job/nspf_list/v2")
         .header(header)
         .body(propJsonObject.toJSONString())
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("获取作业下排版信息:{}", jsonObject3.toJSONString());
            return jsonObject3;
         }
      }

      return null;
   }

   public JSONObject syncTime(String materialId, String thickness, String syncKey, String teamCode) {
      JSONObject propJsonObject = new JSONObject();
      propJsonObject.put("material_id", materialId);
      propJsonObject.put("thickness", thickness);
      propJsonObject.put("sync_key", syncKey);
      HttpHeaders header = getHeadedr(teamCode);
      log.info("更新板材同步时间:{}", propJsonObject);
      HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/plate/cto/update/synctime")
         .header(header)
         .body(propJsonObject.toJSONString())
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      log.info("更新板材同步时间返回的数据:{}", JSON.parseObject(execute5.body()));
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("更新板材同步时间:{}", jsonObject3.toJSONString());
            return jsonObject3;
         }
      }

      return null;
   }

   public JSONObject updateNspf(JSONArray jsonArray1, String teamCode) {
      HttpHeaders header = getHeadedr(teamCode);
      log.info("更新作业下排版信息库存不足:{}", jsonArray1);
      HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/nspf/prop/update")
         .header(header)
         .body(jsonArray1.toJSONString())
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("更新作业下排版信息库存不足:{}", jsonObject3.toJSONString());
            return jsonObject3;
         }
      }

      return null;
   }

   public JSONObject updatePlateProp(JSONArray jsonArray1, String teamCode) {
      HttpHeaders header = getHeadedr(teamCode);
      log.info("更新板材字段:{}", jsonArray1);
      HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/plate/prop/update")
         .header(header)
         .body(jsonArray1.toJSONString())
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("更新板材字段:{}", jsonObject3.toJSONString());
            return jsonObject3;
         }
      }

      return null;
   }

   @Transactional(rollbackFor = Exception.class)
   public JSONObject getSurplus(HashMap<String, Integer> objectObjectHashMap, JSONArray jsonArray1, String teamCode) {
      List<MesBuildingNestingTeam> mesBuildingNestingTeamList = this.mesBuildingNestingTeamService
         .list(
            (Wrapper<MesBuildingNestingTeam>)(new LambdaQueryWrapper<MesBuildingNestingTeam>().eq(MesBuildingNestingTeam::getBoolDrillHole, 1))
               .eq(MesBuildingNestingTeam::getTeamCode, teamCode)
         );
      MesBuildingNestingTeam mesBuildingNestingTeam = mesBuildingNestingTeamList.get(0);
      HttpHeaders header = getHeadedr(teamCode);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("guids", jsonArray1);
      log.info("根据guids获取排版余料:{}", jsonObject);
      HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/nspf/abnormal/plate")
         .header(header)
         .body(jsonObject.toJSONString())
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("根据guids获取排版余料成功:{}", jsonObject3.toJSONString());
            JSONArray updateJsonArray = new JSONArray();
            JSONObject data = jsonObject3.getJSONObject("data");
            jsonArray1.forEach(
               ad -> {
                  if (data.containsKey(ad.toString())) {
                     JSONArray surplusJsonArray = data.getJSONArray(ad.toString());
                     surplusJsonArray.forEach(
                        surplus -> {
                           JSONObject surplusJSONObject = JSON.parseObject(surplus.toString());
                           String id = surplusJSONObject.getString("id");
                           String guid = surplusJSONObject.getString("guid");
                           Long thickness = surplusJSONObject.getLong("thickness");
                           surplusJSONObject.get("material_id");
                           Long width = surplusJSONObject.getLong("width");
                           Long height = surplusJSONObject.getLong("height");
                           String image_name = surplusJSONObject.getString("image_name");
                           String dxf_name = surplusJSONObject.getString("dxf_name");
                           Long remain_amount = surplusJSONObject.getLong("remain_amount");
                           surplusJSONObject.get("result_uuid");
                           String material = surplusJSONObject.getString("material");
                           String image_url = surplusJSONObject.getString("image_url");
                           String dxf_url = surplusJSONObject.getString("dxf_url");
                           Long material_id = surplusJSONObject.getLong("material_id");
                           String parentId = this.getParent(guid, teamCode);
                           if (parentId != null) {
                              JSONObject jsonObject5 = new JSONObject();
                              jsonObject5.put("id", id);
                              jsonObject5.put("is_delete", "1");
                              String s = this.downloadFile.downloadFile(dxf_url, dxf_name);
                              String image = this.downloadFile.downloadFile(image_url, image_name);
                              Double area = this.inboundService.getArea(s);
                              log.info(":{}", guid + "面积为：" + area);
                              BigDecimal surplusMete = BigDecimal.valueOf(remain_amount)
                                 .divide(BigDecimal.valueOf(objectObjectHashMap.get(ad).intValue()))
                                 .multiply(BigDecimal.valueOf(area))
                                 .multiply(BigDecimal.valueOf(thickness).divide(BigDecimal.valueOf(1000000L)).multiply(BigDecimal.valueOf(7.85)))
                                 .setScale(0, 4)
                                 .multiply(BigDecimal.valueOf(1000L));
                              if (surplusMete == null || surplusMete.compareTo(BigDecimal.valueOf(1000L)) <= 0) {
                                 log.info("跳过小于1千克无效余料: guid={}, 核算量={}", guid, surplusMete);
                                 return;
                              }

                              Boolean boolPartyA;
                              if (StrUtil.containsAny("虚拟", parentId)) {
                                 String stringWithoutChinese = ReUtil.replaceAll(parentId, "虚拟", "");
                                 WmsSurplusMaterials byId = this.wmsSurplusMaterialsService.getById(stringWithoutChinese);
                                 boolPartyA = byId.getBoolPartyA();
                              } else {
                                 MaterialInventory byId = this.materialInventoryService.getById(parentId);
                                 boolPartyA = byId.getBoolPartyA();
                              }

                              String stringWithoutChinese = ReUtil.replaceAll(parentId, "虚拟", "");
                              WmsSurplusMaterials build = WmsSurplusMaterials.builder()
                                 .stockGuid((String)ad)
                                 .width(BigDecimal.valueOf(width))
                                 .length(BigDecimal.valueOf(height))
                                 .guid(guid)
                                 .thickness(BigDecimal.valueOf(thickness))
                                 .specification(material)
                                 .dxfUrl(s)
                                 .imageUrl(image)
                                 .imageName(image_name)
                                 .dxfName(dxf_name)
                                 .mete(surplusMete)
                                 .materialInventoryId(Long.valueOf(stringWithoutChinese))
                                 .quantity(BigDecimal.valueOf(remain_amount).divide(BigDecimal.valueOf(objectObjectHashMap.get(ad).intValue())))
                                 .stockQuantity(BigDecimal.valueOf(objectObjectHashMap.get(ad).intValue()))
                                 .boolNestVirtual(false)
                                 .boolNestFrozen(false)
                                 .materialId(material_id)
                                 .boolPartyA(boolPartyA)
                                 .area(BigDecimal.valueOf(area))
                                 .ossImageUrl(image_url)
                                 .ossDxfUrl(dxf_url)
                                 .build();
                              log.info("保存余料与整板的关系:{}", build);
                              boolean guid1 = this.wmsSurplusMaterialsService
                                 .saveOrUpdate(build, (Wrapper<WmsSurplusMaterials>)new UpdateWrapper().eq("guid", guid));
                              if (guid1) {
                                 updateJsonArray.add(jsonObject5);
                              }
                           }
                        }
                     );
                  }
               }
            );
            if (CollectionUtil.isNotEmpty(updateJsonArray)) {
               log.info("更新余料板防止该余料板所在的排样图未开始切割就被使用了:{}", updateJsonArray);
               this.updatePlate(updateJsonArray, teamCode);
            }

            return jsonObject3;
         }
      }

      return null;
   }

   public String getParent(String guid, String teamCode) {
      HttpHeaders header = getHeadedr(teamCode);
      log.info("获取余料层级:{}", guid);
      HttpResponse execute5 = HttpRequest.get(this.configProperties.getBoChuUrl() + "api/plate/get_parent/" + guid)
         .header(header)
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      HashMap<String, String> objectObjectHashMap = new HashMap<>();
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("获取余料层级成功:{}", jsonObject3.toJSONString());
            JSONArray data = jsonObject3.getJSONArray("data");
            data.forEach(parent -> {
               JSONObject jsonObject = (JSONObject)parent;
               if (jsonObject.containsKey("original_guid") && StrUtil.isBlank(jsonObject.getString("original_guid")) && jsonObject.containsKey("sync_id")) {
                  String sync_id = jsonObject.getString("sync_id");
                  objectObjectHashMap.put("sync_id", sync_id);
               }
            });
         }
      }

      return objectObjectHashMap.get("sync_id");
   }

   @Override
   public JSONArray getNspfPart(String guid, String teamCode, String jobName) {
      HttpHeaders header = getHeadedr(teamCode);
      JSONObject jsonObject = new JSONObject();
      JSONArray jsonArray = new JSONArray();
      jsonArray.add(guid);
      jsonObject.put("guid_list", jsonArray);
      List<WmsPlantPart> list = this.wmsPlantPartService.list((Wrapper<WmsPlantPart>)new LambdaQueryWrapper<WmsPlantPart>().eq(WmsPlantPart::getStockGuid, guid));
      if (CollectionUtil.isNotEmpty(list)) {
         log.info("该排样图已经上传过,跳过:{}", guid);
      } else {
         Map<Long, BigDecimal> sumFreezeMeteMap = new HashMap<>();
         log.info("根据排样图guid 获取零件信息:{}", guid);
         HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/result/detail")
            .header(header)
            .body(jsonObject.toJSONString())
            .setConnectionTimeout(60000)
            .setReadTimeout(60000)
            .execute();
         if (execute5.isOk()) {
            JSONObject jsonObject3 = JSON.parseObject(execute5.body());
            if (jsonObject3.get("msg").equals("OK")) {
               JSONArray getSurplus = new JSONArray();
               HashMap<String, Integer> objectObjectHashMap = new HashMap<>();
               log.info("根据排样图guid 获取零件信息:{}", jsonObject3.toJSONString());
               JSONArray data = jsonObject3.getJSONArray("data");
               List<MesBuildingNestingTeam> mesBuildingNestingTeamList = this.mesBuildingNestingTeamService
                  .list(
                     (Wrapper<MesBuildingNestingTeam>)(new LambdaQueryWrapper<MesBuildingNestingTeam>().eq(MesBuildingNestingTeam::getBoolDrillHole, 1))
                        .eq(MesBuildingNestingTeam::getTeamCode, teamCode)
                  );
               MesBuildingNestingTeam mesBuildingNestingTeam = mesBuildingNestingTeamList.get(0);
               log.info("团队码:{}", mesBuildingNestingTeam);
               data.forEach(
                  parent -> {
                     JSONObject nspfJsonObject = (JSONObject)parent;
                     Integer amount = nspfJsonObject.getInteger("amount");
                     JSONArray part_list = nspfJsonObject.getJSONArray("part_list");
                     String plate_guid = nspfJsonObject.getString("plate_guid");
                     Long thickness = nspfJsonObject.getLong("thickness");
                     JSONObject plate = nspfJsonObject.getJSONObject("plate");
                     String material = nspfJsonObject.getString("material");
                     if (ObjectUtil.isNotEmpty(plate)) {
                        log.info("获取余料参数:plate{}, guid{}", plate, guid);
                        String sync_id = plate.getString("sync_id");
                        if (plate.containsKey("sync_id")) {
                           if (StrUtil.isNotBlank(sync_id)) {
                              if (StrUtil.containsAny(sync_id, "虚拟")) {
                                 String sync_id1 = StrUtil.removeAll(sync_id, "虚拟");
                                 WmsSurplusMaterials build = WmsSurplusMaterials.builder()
                                    .id(Long.valueOf(sync_id1))
                                    .boolNestFrozen(true)
                                    .nestFrozenGuid(guid)
                                    .build();
                                 log.info("冻结排样图使用的虚拟余料:{}", build.toString());
                                 this.wmsSurplusMaterialsService.updateById(build);
                              } else {
                                 log.info("冻结排样图使用的真实板材:{}", "库存id" + sync_id);
                                 MaterialInventory byId = this.materialInventoryService
                                    .getOne((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getGuid, plate_guid));
                                 JSONArray jsonArray1 = new JSONArray();
                                 if (!this.chrackMaterial(byId, Long.valueOf(sync_id), amount)) {
                                    JSONObject nspf = new JSONObject();
                                    JSONObject prop = new JSONObject();
                                    nspf.put("guid", guid);
                                    prop.put("备注", "库存不足");
                                    prop.put("note", "库存不足");
                                    nspf.put("prop", prop);
                                    jsonArray1.add(nspf);
                                    this.updateNspf(jsonArray1, teamCode);
                                 }

                                 Preconditions.checkArgument(ObjectUtil.isNotEmpty(byId), material + thickness + "当前物料不存在" + sync_id + "排样图guid" + guid);
                                 Outbound outbound = new Outbound();
                                 this.wmsCutService
                                    .setMaterialFreeze(outbound, material, thickness, String.valueOf(guid), Long.valueOf(sync_id), amount, sumFreezeMeteMap);
                              }
                           }
                        } else {
                           Preconditions.checkArgument(plate.containsKey("sync_id"), "排样图绑定的板材不是来自于系统的:{}", guid);
                        }

                        String finalSync_id = sync_id;
                        getSurplus.add(guid);
                        objectObjectHashMap.put(guid, amount);
                        part_list.forEach(
                           part -> {
                              JSONObject partJsonObject = (JSONObject)part;
                              Long part_area = partJsonObject.getLong("part_area");
                              String partGuid = partJsonObject.getString("guid");
                              Long amount_used = partJsonObject.getLong("amount_used");
                              JSONObject props = partJsonObject.getJSONObject("props");
                              if (props.containsKey("projectId")) {
                                 Long projectId = props.getLong("projectId");
                                 BigDecimal mete = BigDecimal.valueOf(part_area)
                                    .multiply(BigDecimal.valueOf(thickness).divide(BigDecimal.valueOf(1000000L)).multiply(BigDecimal.valueOf(7.85)))
                                    .setScale(2, 4)
                                    .multiply(BigDecimal.valueOf(1000L));
                                 BigDecimal multiply = mete.multiply(BigDecimal.valueOf(amount_used));
                                 String sync_id1 = StrUtil.removeAll(finalSync_id, "虚拟");
                                 WmsPlantPart build = WmsPlantPart.builder()
                                    .stockGuid(guid)
                                    .plateGuid(plate_guid)
                                    .partArea(BigDecimal.valueOf(part_area))
                                    .projectId(projectId)
                                    .partGuid(partGuid)
                                    .quantity(BigDecimal.valueOf(amount_used))
                                    .thickness(BigDecimal.valueOf(thickness))
                                    .mete(mete)
                                    .sumMete(multiply)
                                    .syncId(Long.valueOf(sync_id1))
                                    .syncVirtualId(sync_id)
                                    .build();
                                 log.info("保存或者更新零件与板材的关系:{}", build.toString());
                                 this.wmsPlantPartService
                                    .saveOrUpdate(
                                       build, (Wrapper<WmsPlantPart>)((UpdateWrapper)new UpdateWrapper().eq("stock_guid", guid)).eq("part_guid", partGuid)
                                    );
                              }
                           }
                        );
                     } else {
                        Preconditions.checkArgument(ObjectUtil.isNotEmpty(plate), "排样图绑定的板材没回传:{}", guid);
                     }
                  }
               );
               if (CollectionUtil.isNotEmpty(getSurplus)) {
                  this.getSurplus(objectObjectHashMap, getSurplus, teamCode);
               }

               this.saveInstantMessageHint(jobName, sumFreezeMeteMap);
               return data;
            }
         }
      }

      return null;
   }

   @Transactional(propagation = Propagation.REQUIRES_NEW)
   public void saveInstantMessageHint(String jobName, Map<Long, BigDecimal> sumFreezeMeteMap) {
      sumFreezeMeteMap.forEach(
         (k, v) -> this.warehouseDataDashboardService
            .saveInstantMessageHint(
               InstantMessageHintDTO.builder()
                  .type(MessageEnum.FREEZE_INFORMATION.getType())
                  .typeName(MessageEnum.FREEZE_INFORMATION.getName())
                  .dateTimeStr(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").format(LocalDateTime.now()))
                  .createUser(null)
                  .serialNumber(jobName)
                  .freezeMete(v.divide(thousand, 2, RoundingMode.HALF_UP))
                  .workshopId(Collections.singletonList(k))
                  .build()
            )
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOutbound(String guid, String childGuid, String childOrderNumber, Long factoryId, Long branchId) {
      List<Outbound> list1 = this.outboundService.list((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getStockCutGuid, childGuid));
      if (CollectionUtil.isNotEmpty(list1)) {
         return true;
      }

      List<WmsPlantPart> list = this.wmsPlantPartService.list((Wrapper<WmsPlantPart>)new LambdaQueryWrapper<WmsPlantPart>().eq(WmsPlantPart::getStockGuid, guid));
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(list), "当前排样图没有零件在系统:{}" + guid);
      Map<Long, List<WmsPlantPart>> partMap = list.stream().collect(Collectors.groupingBy(WmsPlantPart::getProjectId));
      Outbound outbound = Outbound.builder()
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
         .outboundStartTime(LocalDateTime.now())
         .outboundEndTime(LocalDateTime.now())
         .stockGuid(guid)
         .stockCutGuid(childGuid)
         .childOrderNumber(childOrderNumber)
         .outboundTypeSelection(OutboundTypeEnum.SCHEDULING_OUTBOUND.getType())
         .build();
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_APPLY, this.outBoundServiceBiz.getCount());
      outbound.setApplicationSn(serviceNumber);
      outbound.setContainBasicClass(BasicClassEnum.STEEL_PLATE.getType());
      BigDecimal sumMete = list.stream().map(WmsPlantPart::getSumMete).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
      WmsPlantPart wmsPlantPart = list.get(0);
      MaterialInventory materialInventory;
      if (StrUtil.containsAny(wmsPlantPart.getSyncVirtualId(), "虚拟")) {
         materialInventory = this.materialInventoryService
            .getOne((Wrapper<MaterialInventory>)new LambdaQueryWrapper<MaterialInventory>().eq(MaterialInventory::getSyncVirtualId, wmsPlantPart.getSyncVirtualId()));
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventory), childOrderNumber + ":使用的虚拟余料未切割完成，请切割完成之后下发");
      } else {
         materialInventory = this.materialInventoryService.getById(wmsPlantPart.getSyncId());
      }

      Measure measure = this.measureService
         .getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      BigDecimal precision = UnitsPrecisionEnum.getByName(measure.getAccountingUnit());
      BigDecimal materialInventoryMete = this.getMaterialInventoryMete(materialInventory, measure, guid);
      List<WmsSurplusMaterials> list3 = this.wmsSurplusMaterialsService
         .list(
            (Wrapper<WmsSurplusMaterials>)(new LambdaQueryWrapper<WmsSurplusMaterials>().eq(WmsSurplusMaterials::getStockCutGuid, childGuid))
               .eq(WmsSurplusMaterials::getBoolNestVirtual, true)
         );
      Preconditions.checkArgument(
         list3.stream().allMatch(surplus -> surplus.getMete() != null && surplus.getMete().signum() >= 0
            && surplus.getMete().stripTrailingZeros().scale() <= 2 && surplus.getMete().setScale(2).precision() <= 19),
         "当前套料余料重量超出可保存精度,请重新操作"
      );
      if (CollectionUtil.isNotEmpty(list3)) {
         BigDecimal totalMete = list3.stream()
            .collect(Collectors.toMap(WmsSurplusMaterials::getStockCutGuid, WmsSurplusMaterials::getMete, BigDecimal::add))
            .values()
            .stream()
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(totalMete.compareTo(materialInventoryMete) <= 0, "当前套料余料重量超出来源重量,请重新操作");
         materialInventoryMete = materialInventoryMete.subtract(totalMete);
      }

      this.outboundService.save(outbound);

      for (Entry<Long, List<WmsPlantPart>> entry : partMap.entrySet()) {
         Long key = entry.getKey();
         List<WmsPlantPart> value = entry.getValue();
         List<WmsPlantPart> wmsPlantParts = partMap.get(key);
         BigDecimal keyMete = wmsPlantParts.stream().map(WmsPlantPart::getSumMete).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal outMete = CommonUtil.getStockOutboundMete(keyMete, sumMete, materialInventoryMete);
         materialInventoryMete = materialInventoryMete.subtract(outMete);
         sumMete = sumMete.subtract(keyMete);
         BasicOutbound outboundBasicConf = this.basicConfigService.getOutboundBasicConf();
         Preconditions.checkArgument(materialInventory != null, "仓库中不存在该物料");
         MoveOutboundDetail moveOutboundDetail = MoveOutboundDetail.builder()
            .warehouseId(materialInventory.getWarehouseId())
            .materialIsWhole(materialInventory.getMaterialIsWhole())
            .workshopId(1L)
            .sourceWorkshopId(materialInventory.getWorkshopId())
            .materialInventoryId(materialInventory.getId())
            .outboundId(outbound.getId())
            .basicClass(materialInventory.getBasicClass())
            .classifyId(materialInventory.getClassifyId())
            .specification(materialInventory.getSpecification())
            .sourceProjectId(materialInventory.getProjectId())
            .sourceMonomerId(materialInventory.getMonomerId())
            .sourceAreaId(materialInventory.getAreaId())
            .thickness(materialInventory.getThickness())
            .theoryThickness(materialInventory.getTheoryThickness())
            .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
            .brand(materialInventory.getBrand())
            .outboundTime(LocalDateTime.now())
            .color(materialInventory.getColor())
            .outboundMode(1)
            .boolPartyA(materialInventory.getBoolPartyA())
            .taxRate(materialInventory.getTaxRate())
            .invoiceType(materialInventory.getInvoiceType())
            .standardId(materialInventory.getStandardId())
            .standardName(materialInventory.getStandardName())
            .materialSn(materialInventory.getSerialNumber())
            .outboundAddress(1)
            .stockGuid(guid)
            .surplusSn(materialInventory.getSurplusSn())
            .build();
         if (CollectionUtil.isEmpty(list3) && partMap.size() == 1) {
            moveOutboundDetail.setLength(materialInventory.getLength());
            moveOutboundDetail.setWidth(materialInventory.getWidth());
         }

         if (materialInventory.getBoolPartyA()) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(wmsPlantPart.getProjectId()), "出库失败,甲供物料不能出库到其他项目.");
         }

         if (!outboundBasicConf.getBoolCanOutToOtherProject() && materialInventory.getProjectId() != null) {
            Preconditions.checkArgument(materialInventory.getProjectId().equals(wmsPlantPart.getProjectId()), "当前出库项目与物料项目不一致,请核对.");
         }

         if (materialInventory.getProjectId() != null) {
            moveOutboundDetail.setOutboundRelationType(
               materialInventory.getProjectId().equals(wmsPlantPart.getProjectId())
                  ? OutboundRelationTypeEnum.ROUTINE.getType()
                  : OutboundRelationTypeEnum.TRANSFER.getType()
            );
         }

         moveOutboundDetail.setProjectId(key);
         if (moveOutboundDetail.getProjectId() != null) {
            ContractProject project = this.contractProjectService.getById(moveOutboundDetail.getProjectId());
            Preconditions.checkArgument(
               moveOutboundDetail.getProjectId() != null && SettlementStatusEnum.UN_SETTLED.getType().equals(project.getSettlementStatus()), "出库失败,当前项目已结算"
            );
         }

         moveOutboundDetail.setOutboundType(MaterialOutboundModeEnum.WHOLE.getType());
         if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
            moveOutboundDetail.setQuantity(BigDecimal.ONE);
            moveOutboundDetail.setMete(outMete);
         }

         if (moveOutboundDetail.getRecipientName() != null) {
            List<String> recipientName = new ArrayList<>();
            if (StrUtil.isNotBlank(outbound.getRecipients())) {
               List<String> names = Arrays.asList(outbound.getRecipients().split(","));
               if (!names.contains(moveOutboundDetail.getRecipientName())) {
                  recipientName.add("," + moveOutboundDetail.getRecipientName());
               }
            } else {
               recipientName.add(moveOutboundDetail.getRecipientName());
            }

            outbound.setRecipients(StrUtil.join(",", recipientName));
         }

         if (moveOutboundDetail.getProjectId() != null) {
            if (StrUtil.isNotBlank(outbound.getProjectIds())) {
               List<Long> list2 = CommonUtil.spilt(outbound.getProjectIds(), ",");
               if (!list2.contains(moveOutboundDetail.getProjectId())) {
                  outbound.setProjectIds(outbound.getProjectIds() + "," + moveOutboundDetail.getProjectId());
               }
            } else {
               outbound.setProjectIds(moveOutboundDetail.getProjectId() + "");
            }
         }

         this.outboundDetailService.save(moveOutboundDetail);
         this.outboundService.updateById(outbound);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean passed(String childGuid) {
      LocalDateTime dateTime = LocalDateTime.now();
      Outbound outbound = this.outboundService.getOne((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getStockCutGuid, childGuid));
      String currentName = outbound.getApplicantName();
      Long currentUserId = outbound.getApplicantId();
      Preconditions.checkArgument(outbound != null, "出库单不存在,请核对后操作.");
      Preconditions.checkArgument(OutboundStatusEnum.UN_REVIEWED.getType().equals(outbound.getReviewStatus()), "出库单已审核,请核对后操作");
      List<MoveOutboundDetail> details = this.outboundDetailService
         .list((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()));
      outbound.setReviewerId(outbound.getApplicantId());
      outbound.setReviewerName(outbound.getApplicantName());
      outbound.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
      outbound.setReviewTime(dateTime);
      outbound.setOutboundTime(dateTime);
      outbound.setUserUpdateTime(dateTime);
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_REVIEW, this.outBoundServiceBiz.getCount());
      String replace = outbound.getApplicationSn().replace("O", "OR");
      outbound.setSerialNumber(replace);
      Long statisticsId = null;
      outbound.setOutboundStartTime(null);
      outbound.setOutboundEndTime(null);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      Map<String, Transfer> transferMap = new HashMap<>();
      Transfer transfer = null;
      MaterialInventory materialInventory1 = this.materialInventoryService.getById(details.get(0).getMaterialInventoryId());
      this.getMaterialInventorys(outbound, details, materialInventory1, outbound.getStockGuid());

      for (MoveOutboundDetail outboundDetail : this.outboundDetailService
         .list((Wrapper<MoveOutboundDetail>)Wrappers.<MoveOutboundDetail>lambdaQuery().eq(MoveOutboundDetail::getOutboundId, outbound.getId()))) {
         MaterialInventory materialInventory = this.materialInventoryService.getById(outboundDetail.getMaterialInventoryId());
         Statistics statistics = this.outBoundServiceBiz.get(materialInventory);
         MonthWeightedAveragePrice wap = this.weightedAveragePriceService.getPrice(materialInventory);
         outboundDetail.setWapId(wap.getId());
         if (ObjectUtil.isNotEmpty(outboundDetail.getOutboundTime())) {
            outboundDetail.setOutboundTime(outboundDetail.getOutboundTime());
            if (outbound.getOutboundStartTime() != null) {
               if (outboundDetail.getOutboundTime().compareTo(outbound.getOutboundEndTime()) > 0) {
                  outbound.setOutboundEndTime(outboundDetail.getOutboundTime());
               }

               if (outboundDetail.getOutboundTime().compareTo(outbound.getOutboundStartTime()) < 0) {
                  outbound.setOutboundStartTime(outboundDetail.getOutboundTime());
               }
            } else {
               outbound.setOutboundEndTime(outboundDetail.getOutboundTime());
               outbound.setOutboundStartTime(outboundDetail.getOutboundTime());
            }
         }

         if (ObjectUtil.isEmpty(outboundDetail.getOutboundTime())) {
            outboundDetail.setOutboundTime(dateTime);
         }

         materialInventory.setMete(materialInventory.getMete().subtract(outboundDetail.getMete()));
         materialInventory.setQuantity(outboundDetail.getQuantity() != null ? materialInventory.getQuantity().subtract(outboundDetail.getQuantity()) : null);
         if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
            this.materialInventoryService.removeById(materialInventory);
         } else {
            if (materialInventory.getQuantity() != null) {
               materialInventory.setUseStatus(materialInventory.getQuantity().compareTo(BigDecimal.ZERO) == 0);
            }

            this.materialInventoryService.updateById(materialInventory);
         }

         this.wmsUtil
            .setInventoryUse(
               materialInventory,
               outboundDetail.getQuantity(),
               outboundDetail.getMete(),
               ReceiptTypeEnum.OUTBOUND,
               outbound.getId(),
               outbound.getSerialNumber(),
               2,
               true
            );
         this.setStatisticsEndPeriod(materialInventory, statistics);
         statisticsId = statistics.getId();
         long outPId = outboundDetail.getProjectId() != null ? outboundDetail.getProjectId() : -1L;
         long sourcePId = materialInventory.getProjectId() != null ? materialInventory.getProjectId() : -1L;
         if (outPId != sourcePId) {
            String key = outPId + "-" + materialInventory.getWorkshopId() + "-" + materialInventory.getWarehouseId();
            if (!transferMap.containsKey(key)) {
               transfer = Transfer.builder()
                  .basicClass(outboundDetail.getBasicClass())
                  .directionProjectId(outboundDetail.getProjectId())
                  .directionWorkshopId(materialInventory.getWorkshopId())
                  .directionWarehouseId(materialInventory.getWarehouseId())
                  .directionMonomerId(outboundDetail.getMonomerId())
                  .directionAreaId(outboundDetail.getAreaId())
                  .transferType(TransferTypeEnum.PROJECT_WARE.getType())
                  .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
                  .applicantId(currentUserId)
                  .editorId(currentUserId)
                  .applicantName(currentName)
                  .editorName(currentName)
                  .reviewerName(currentName)
                  .reviewTime(dateTime)
                  .reviewerId(currentUserId)
                  .userUpdateTime(dateTime)
                  .transferCreateType(2)
                  .outboundSn(outbound.getSerialNumber())
                  .outboundId(outbound.getId())
                  .build();
               Integer count = this.outBoundServiceBiz.getMaxDayNumber();
               String sn = this.numberConfigService.getNumber(NumberTypeEnum.TRANSFER, count);
               transfer.setSerialNumber(sn);
               this.transferService.save(transfer);
               transferMap.put(key, transfer);
            } else {
               transfer = transferMap.get(key);
            }

            BigDecimal amountNoFreight;
            BigDecimal amountExcludingVatNoFreight;
            BigDecimal amount;
            BigDecimal amountExcludingVat;
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               BigDecimal p = outboundDetail.getMete().divide(wap.getMete(), 20, this.ROUNDING);
               amount = wap.getAmount().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVat = wap.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
               amountNoFreight = wap.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVatNoFreight = wap.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
            } else {
               WholeWeightedAveragePrice price = this.outBoundServiceBiz.getWholePrice(materialInventory);
               BigDecimal p = outboundDetail.getMete().divide(price.getMete(), 20, this.ROUNDING);
               amount = price.getAmount().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVat = price.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
               amountNoFreight = price.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
               amountExcludingVatNoFreight = price.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
            }

            TransferDetail transferDetail = TransferDetail.builder()
               .boolPartyA(materialInventory.getBoolPartyA())
               .transferId(transfer.getId())
               .materialInventoryId(materialInventory.getId())
               .specification(materialInventory.getSpecification())
               .basicClass(materialInventory.getBasicClass())
               .length(materialInventory.getLength())
               .width(materialInventory.getWidth())
               .thickness(materialInventory.getThickness())
               .brand(materialInventory.getBrand())
               .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
               .classifyId(materialInventory.getClassifyId())
               .transferType(TransferTypeEnum.PROJECT_WARE.getType())
               .sourceWorkshopId(materialInventory.getWorkshopId())
               .sourceWarehouseId(materialInventory.getWarehouseId())
               .sourceProjectId(materialInventory.getProjectId())
               .sourceMonomerId(materialInventory.getMonomerId())
               .sourceAreaId(materialInventory.getAreaId())
               .mete(outboundDetail.getMete())
               .quantity(outboundDetail.getQuantity())
               .color(materialInventory.getColor())
               .remark(outboundDetail.getRemark())
               .taxRate(materialInventory.getTaxRate())
               .invoiceType(materialInventory.getInvoiceType())
               .standardId(materialInventory.getStandardId())
               .standardName(materialInventory.getStandardName())
               .build();
            if (amount.compareTo(BigDecimal.ZERO) != 0) {
               transferDetail.setUnitPrice(amount.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               transferDetail.setUnitPriceExcludingVat(amountExcludingVat.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
            } else {
               transferDetail.setUnitPrice(BigDecimal.ZERO);
               transferDetail.setUnitPriceExcludingVat(BigDecimal.ZERO);
            }

            transferDetail.setAmount(amount);
            transferDetail.setAmountExcludingVat(amountExcludingVat);
            transferDetail.setInputVat(transferDetail.getAmount().subtract(transferDetail.getAmountExcludingVat()));
            if (amountNoFreight.compareTo(BigDecimal.ZERO) != 0) {
               transferDetail.setUnitPriceNoFreight(amountNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
               transferDetail.setUnitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(outboundDetail.getMete(), 12, RoundingMode.HALF_UP));
            } else {
               transferDetail.setUnitPriceNoFreight(BigDecimal.ZERO);
               transferDetail.setUnitPriceExcludingVatNoFreight(BigDecimal.ZERO);
            }

            transferDetail.setAmountNoFreight(amountNoFreight);
            transferDetail.setAmountExcludingVatNoFreight(amountExcludingVatNoFreight);
            transferDetail.setInputVatNoFreight(transferDetail.getAmountNoFreight().subtract(transferDetail.getAmountExcludingVatNoFreight()));
            this.transferDetailService.save(transferDetail);
            if (transferDetail.getQuantity() != null && outboundDetail.getHalfMode() == null) {
               wap.setQuantity(wap.getQuantity().subtract(transferDetail.getQuantity()));
            }

            wap.setMete(wap.getMete().subtract(transferDetail.getMete()));
            if (WeightedPriceEnum.SINGLE.getType().equals(weightedPriceConf.getWeightedType())) {
               wap.setAmount(wap.getAmount().subtract(amount));
               wap.setAmountExcludingVat(wap.getAmountExcludingVat().subtract(amountExcludingVat));
               wap.setAmountNoFreight(wap.getAmountNoFreight().subtract(amountNoFreight));
               wap.setAmountExcludingVatNoFreight(wap.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
            }

            this.outBoundServiceBiz.updateMonthById(wap);
            statistics.setInboundMete(
               statistics.getInboundMete() != null ? statistics.getInboundMete().subtract(transferDetail.getMete()) : transferDetail.getMete().negate()
            );
            if (transferDetail.getQuantity() != null) {
               statistics.setInboundQuantity(
                  statistics.getInboundQuantity() != null
                     ? statistics.getInboundQuantity().subtract(transferDetail.getQuantity())
                     : transferDetail.getQuantity().negate()
               );
            }

            statistics.setInboundUnitPrice(transferDetail.getUnitPrice());
            statistics.setInboundUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
            statistics.setInboundAmount(statistics.getInboundAmount() != null ? statistics.getInboundAmount().subtract(amount) : amount.negate());
            statistics.setInboundAmountExcludingVat(
               statistics.getInboundAmountExcludingVat() != null
                  ? statistics.getInboundAmountExcludingVat().subtract(amountExcludingVat)
                  : amountExcludingVat.negate()
            );
            statistics.setInboundUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
            statistics.setInboundUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
            statistics.setInboundAmountNoFreight(
               statistics.getInboundAmountNoFreight() != null ? statistics.getInboundAmountNoFreight().subtract(amountNoFreight) : amountNoFreight.negate()
            );
            statistics.setInboundAmountExcludingVatNoFreight(
               statistics.getInboundAmountExcludingVatNoFreight() != null
                  ? statistics.getInboundAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight)
                  : amountExcludingVatNoFreight.negate()
            );
            StatisticsInbound si = BeanUtil.copy(materialInventory, StatisticsInbound.class, "createTime");
            si.setMaterialInventoryId(materialInventory.getId());
            si.setReceiptType(ReceiptTypeEnum.TRANSFER.getType());
            si.setReceiptId(transfer.getId());
            si.setReceiptSerialNumber(transfer.getSerialNumber());
            si.setStatisticsId(statistics.getId());
            si.setMete(transferDetail.getMete().negate());
            if (materialInventory.getQuantity() != null) {
               si.setQuantity(transferDetail.getQuantity().negate());
            }

            si.setUnitPrice(transferDetail.getUnitPrice());
            si.setUnitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat());
            si.setAmount(transferDetail.getAmount().negate());
            si.setAmountExcludingVat(transferDetail.getAmountExcludingVat().negate());
            si.setUnitPriceNoFreight(transferDetail.getUnitPriceNoFreight());
            si.setUnitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight());
            si.setAmountNoFreight(transferDetail.getAmountNoFreight().negate());
            si.setAmountExcludingVatNoFreight(transferDetail.getAmountExcludingVatNoFreight().negate());
            this.outBoundServiceBiz.saveStatisticsInbound(si);
            MaterialInventory inventory = BeanUtil.copy(materialInventory, MaterialInventory.class);
            inventory.setId(-1L);
            inventory.setProjectId(outboundDetail.getProjectId());
            inventory.setWorkshopId(outboundDetail.getWorkshopId());
            InboundDetail inboundDetail = InboundDetail.builder()
               .basicClass(inventory.getBasicClass())
               .classifyId(inventory.getClassifyId())
               .accountingUnit(inventory.getAccountingUnit())
               .length(inventory.getLength())
               .width(inventory.getWidth())
               .thickness(inventory.getThickness())
               .brand(inventory.getBrand())
               .heatNoAndBatchNo(inventory.getHeatNoAndBatchNo())
               .specification(inventory.getSpecification())
               .color(inventory.getColor())
               .unitNet(inventory.getUnitNet())
               .quantity(outboundDetail.getQuantity())
               .mete(outboundDetail.getMete())
               .workshopId(transfer.getDirectionWorkshopId())
               .warehouseId(transfer.getDirectionWarehouseId())
               .measureUnit(inventory.getMeasureUnit())
               .taxRate(inventory.getTaxRate())
               .invoiceType(inventory.getInvoiceType())
               .standardName(inventory.getStandardName())
               .standardId(inventory.getStandardId())
               .oneTheoryWeight(inventory.getOneTheoryWeight())
               .sectionSteelWeight(inventory.getSectionSteelWeight())
               .boolPartyA(inventory.getBoolPartyA())
               .amount(amount)
               .amountExcludingVat(amountExcludingVat)
               .unitPrice(transferDetail.getUnitPrice())
               .unitPriceExcludingVat(transferDetail.getUnitPriceExcludingVat())
               .amountNoFreight(amountNoFreight)
               .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
               .unitPriceNoFreight(transferDetail.getUnitPriceNoFreight())
               .unitPriceExcludingVatNoFreight(transferDetail.getUnitPriceExcludingVatNoFreight())
               .projectId(outboundDetail.getProjectId())
               .build();
            Statistics targetStatistics = this.weightedAveragePriceService
               .createMonthWAP(inboundDetail, inventory, transfer.getId(), transfer.getSerialNumber(), ReceiptTypeEnum.TRANSFER.getType());
            targetStatistics.setOutboundMete(
               targetStatistics.getOutboundMete() != null ? targetStatistics.getOutboundMete().add(outboundDetail.getMete()) : outboundDetail.getMete()
            );
            targetStatistics.setOutboundQuantity(
               targetStatistics.getOutboundQuantity() != null
                  ? targetStatistics.getOutboundQuantity().add(outboundDetail.getQuantity())
                  : outboundDetail.getQuantity()
            );
            targetStatistics.setEndMete(targetStatistics.getEndMete().subtract(outboundDetail.getMete()));
            if (targetStatistics.getEndQuantity() != null) {
               targetStatistics.setEndQuantity(targetStatistics.getEndQuantity().subtract(outboundDetail.getQuantity()));
            }

            this.outBoundServiceBiz.updateStatisticsById(targetStatistics);
            outboundDetail.setWapId(targetStatistics.getWapId());
            statisticsId = targetStatistics.getId();
         }

         if (statistics.getId().equals(statisticsId)) {
            statistics.setOutboundMete(
               statistics.getOutboundMete() != null ? outboundDetail.getMete().add(statistics.getOutboundMete()) : outboundDetail.getMete()
            );
            statistics.setOutboundQuantity(
               statistics.getOutboundQuantity() != null ? outboundDetail.getQuantity().add(statistics.getOutboundQuantity()) : outboundDetail.getQuantity()
            );
         }

         this.saveStatisticsOutbound(outbound, outboundDetail, materialInventory, statisticsId);
         statistics.setEndQuantity(statistics.getEndQuantity().subtract(BigDecimal.ONE));
         statistics.setEndMete(statistics.getEndMete().subtract(outboundDetail.getMete()));
         this.outBoundServiceBiz.updateStatisticsById(statistics);
         this.outboundDetailService.updateById(outboundDetail);
      }

      return this.outboundService.updateById(outbound);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void testOutbound(String Guid) {
      Outbound one = this.outboundService
         .getOne(
            (Wrapper<Outbound>)(new LambdaQueryWrapper<Outbound>().eq(Outbound::getStockCutGuid, Guid))
               .eq(Outbound::getReviewStatus, OutboundStatusEnum.UN_REVIEWED.getType())
         );
      this.passed(one.getStockCutGuid());
   }

   @Override
   public void getdad(String guid, String teamCode) {
      HttpHeaders header = getHeadedr(teamCode);
      JSONArray jsonArray1 = new JSONArray();
      jsonArray1.add(guid);
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("guids", jsonArray1);
      log.info("根据guids获取排版余料:{}", jsonObject);
      HttpResponse execute5 = HttpRequest.post(this.configProperties.getBoChuUrl() + "api/nspf/abnormal/plate")
         .header(header)
         .body(jsonObject.toJSONString())
         .setConnectionTimeout(60000)
         .setReadTimeout(60000)
         .execute();
      if (execute5.isOk()) {
         JSONObject jsonObject3 = JSON.parseObject(execute5.body());
         if (jsonObject3.get("msg").equals("OK")) {
            log.info("根据guids获取排版余料成功:{}", jsonObject3.toJSONString());
            new JSONArray();
            JSONObject var9 = jsonObject3.getJSONObject("data");
         }
      }
   }

   @Override
   public Boolean deleteNesting(String guid) {
      this.deleteMaterialfreeze(null, guid, MaterialFreezeTypeEnum.NESTING.getType());
      this.wmsSurplusMaterialsService.remove((Wrapper<WmsSurplusMaterials>)new LambdaQueryWrapper<WmsSurplusMaterials>().eq(WmsSurplusMaterials::getStockGuid, guid));
      this.wmsPlantPartService.remove((Wrapper<WmsPlantPart>)new LambdaQueryWrapper<WmsPlantPart>().eq(WmsPlantPart::getStockGuid, guid));
      log.info("删除套料出库" + guid);
      this.outboundService.remove((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getStockGuid, guid));
      return true;
   }

   @Override
   public Boolean deleteNestingByChildGuid(String stockCutGuid) {
      log.info("工单撤回:" + stockCutGuid);
      this.outboundService.remove((Wrapper<Outbound>)new LambdaQueryWrapper<Outbound>().eq(Outbound::getStockCutGuid, stockCutGuid));
      return true;
   }

   private void setStatisticsEndPeriod(MaterialInventory materialInventory, Statistics statistics) {
      StatisticsEndPeriod endPeriod = this.outBoundServiceBiz.getOne(statistics.getId(), materialInventory.getId());
      endPeriod.setMete(materialInventory.getMete());
      endPeriod.setQuantity(materialInventory.getQuantity());
      this.outBoundServiceBiz.updateStatisticsEndPeriodById(endPeriod);
   }

   private void saveStatisticsOutbound(Outbound outbound, MoveOutboundDetail outboundDetail, MaterialInventory materialInventory, Long statisticsId) {
      StatisticsOutbound statisticsOutbound = BeanUtil.copy(outboundDetail, StatisticsOutbound.class, "createTime");
      statisticsOutbound.setReceiptType(ReceiptTypeEnum.OUTBOUND.getType());
      statisticsOutbound.setReceiptId(outbound.getId());
      statisticsOutbound.setReceiptSerialNumber(outbound.getSerialNumber());
      statisticsOutbound.setWarehouseType(materialInventory.getWarehouseType());
      statisticsOutbound.setBoolPartyA(materialInventory.getBoolPartyA());
      statisticsOutbound.setStatisticsId(statisticsId);
      statisticsOutbound.setClassifyName(materialInventory.getClassifyName());
      statisticsOutbound.setTheoryThickness(materialInventory.getTheoryThickness());
      statisticsOutbound.setDetailId(outboundDetail.getId());
      this.outBoundServiceBiz.saveStatisticsOutbound(statisticsOutbound);
   }

   public static HttpHeaders getHeadedr(String teamCode) {
      HttpHeaders headers = BoChuNesting.headers(teamCode);
      log.info("消息头团队码:{}", teamCode);
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("X-FS-Encode", "utf-8");
      return headers;
   }

   public void getMaterialInventory(
      Outbound outbound,
      List<WmsSurplusMaterials> list3,
      MaterialInventory materialInventory,
      PriceDTO price1,
      WmsPlantConvert wmsPlantConvert,
      WmsPlantConvertDetail wmsPlantConvertDetail
   ) {
      if (CollectionUtil.isNotEmpty(list3)) {
         list3.forEach(
            surplus -> {
               MaterialInventory newMaterialInventory = BeanUtil.copy(materialInventory, MaterialInventory.class, "createTime");
               newMaterialInventory.setSourceMaterielId(materialInventory.getId());
               newMaterialInventory.setMaterialIsWhole(2);
               newMaterialInventory.setLength(surplus.getLength());
               newMaterialInventory.setWidth(surplus.getWidth());
               newMaterialInventory.setCreateTime(LocalDateTime.now());
               newMaterialInventory.setInventoryStartTime(LocalDateTime.now());
               newMaterialInventory.setOutboundSn(outbound.getSerialNumber());
               newMaterialInventory.setOutboundId(outbound.getId());
               newMaterialInventory.setBoolHasFrozen(false);
               newMaterialInventory.setBoolNestSurplus(true);
               newMaterialInventory.setMete(surplus.getMete());
               newMaterialInventory.setQuantity(surplus.getQuantity());
               newMaterialInventory.setDxfUrl(surplus.getDxfUrl());
               newMaterialInventory.setImgUrl(surplus.getImageUrl());
               newMaterialInventory.setSyncVirtualId("虚拟" + surplus.getId());
               newMaterialInventory.setPlateId(null);
               newMaterialInventory.setGuid(null);
               newMaterialInventory.setStockGuid(surplus.getStockGuid());
               MesBuildingTaskOrder one = this.mesBuildingTaskOrderService
                  .getOne((Wrapper<MesBuildingTaskOrder>)new LambdaQueryWrapper<MesBuildingTaskOrder>().eq(MesBuildingTaskOrder::getChildGuid, surplus.getStockCutGuid()));
               newMaterialInventory.setStockCutGuid(surplus.getStockCutGuid());
               newMaterialInventory.setChildOrderId(one.getId());
               newMaterialInventory.setChildOrderNumber(outbound.getChildOrderNumber());
               Integer count = this.materialInventoryService.getCount(LocalDateTime.now());
               String projectName;
               if (newMaterialInventory.getProjectId() == null) {
                  projectName = "公共库";
               } else {
                  ContractProject byId = this.contractProjectService.getById(newMaterialInventory.getProjectId());
                  projectName = byId.getShortName();
               }

               String currentDateOfYYMMDD = DateTimeUtils.getCurrentDateOfYYMMDD();
               newMaterialInventory.setArea(surplus.getArea());
               newMaterialInventory.setSurplusSn(materialInventory.getBoolPartyA() ? "(甲供)-" : "" + projectName + "-余-" + currentDateOfYYMMDD + "-" + count + 1);
               if (BasicClassEnum.STEEL_PLATE.getType().equals(materialInventory.getBasicClass())) {
                  newMaterialInventory.setOneTheoryWeight(surplus.getMete());
               }

               Print print = Print.builder()
                  .receiptId(outbound.getId())
                  .receiptSerialNumber(outbound.getSerialNumber())
                  .receiptReviewer(outbound.getReviewerName())
                  .receiptReviewTime(outbound.getReviewTime())
                  .receiptType(ReceiptTypeEnum.OUTBOUND.getType())
                  .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
                  .totalNotPrintNumber(newMaterialInventory.getQuantity().intValue())
                  .projectIds(materialInventory.getProjectId() != null ? "" + materialInventory.getProjectId() : null)
                  .containBasicClass(materialInventory.getBasicClass())
                  .build();
               this.printService.save(print);
               String barcode = this.printService
                  .savePrint1(
                     PrintDetail.builder()
                        .printId(print.getId())
                        .basicClass(newMaterialInventory.getBasicClass())
                        .classifyId(newMaterialInventory.getClassifyId())
                        .classifyName(materialInventory.getClassifyName())
                        .specification(newMaterialInventory.getSpecification())
                        .mete(newMaterialInventory.getMete())
                        .quantity(newMaterialInventory.getQuantity())
                        .brand(newMaterialInventory.getBrand())
                        .heatNoAndBatchNo(newMaterialInventory.getHeatNoAndBatchNo())
                        .workshopId(newMaterialInventory.getWorkshopId())
                        .warehouseId(newMaterialInventory.getWarehouseId())
                        .projectId(newMaterialInventory.getProjectId())
                        .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
                        .boolPartyA(newMaterialInventory.getBoolPartyA())
                        .length(newMaterialInventory.getLength())
                        .width(newMaterialInventory.getWidth())
                        .thickness(newMaterialInventory.getThickness())
                        .color(newMaterialInventory.getColor())
                        .notPrintNumber(1)
                        .standardId(newMaterialInventory.getStandardId())
                        .standardName(newMaterialInventory.getStandardName())
                        .materialIsWhole(newMaterialInventory.getMaterialIsWhole())
                        .monomerId(newMaterialInventory.getMonomerId())
                        .areaId(newMaterialInventory.getAreaId())
                        .build(),
                     outbound
                  );
               newMaterialInventory.setBarcode(barcode);
               this.materialInventoryService.save(newMaterialInventory);
               this.warehouseDataDashboardService
                  .saveInstantMessageHint(
                     InstantMessageHintDTO.builder()
                        .type(MessageEnum.RETURN_INVENTORY_INFORMATION.getType())
                        .typeName(MessageEnum.RETURN_INVENTORY_INFORMATION.getName())
                        .dateTimeStr(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm").format(LocalDateTime.now()))
                        .serialNumber(outbound.getSerialNumber())
                        .thickness(newMaterialInventory.getThickness())
                        .material(newMaterialInventory.getSpecification())
                        .returnMete(newMaterialInventory.getMete().divide(thousand, 2, RoundingMode.HALF_UP))
                        .workshopId(Collections.singletonList(newMaterialInventory.getWorkshopId()))
                        .build()
                  );
               this.wmsUtil
                  .setInventoryUse(
                     newMaterialInventory,
                     newMaterialInventory.getQuantity(),
                     newMaterialInventory.getMete(),
                     ReceiptTypeEnum.PLANT_CONVERT,
                     wmsPlantConvert.getId(),
                     wmsPlantConvert.getReceiptSerialNumber(),
                     1,
                     true
                  );
               WmsPlantConvertDetail copy1 = BeanUtil.copy(newMaterialInventory, WmsPlantConvertDetail.class);
               copy1.setWmsPlantConvertId(wmsPlantConvert.getId());
               copy1.setWmsPlantConvertDetailId(wmsPlantConvertDetail.getId());
               this.wmsPlantConvertDetailService.save(copy1);
               if (surplus.getBoolNestFrozen()) {
                  this.wmsCutService
                     .setMaterialFreeze(
                        outbound,
                        newMaterialInventory.getSpecification(),
                        surplus.getThickness().longValue(),
                        surplus.getNestFrozenGuid(),
                        newMaterialInventory.getId(),
                        surplus.getQuantity().intValue(),
                        new HashMap<>()
                     );
               }

               BigDecimal p = newMaterialInventory.getMete().divide(price1.getOneMete(), 20, this.ROUNDING);
               BigDecimal amount = price1.getAmount().multiply(p).setScale(2, this.ROUNDING);
               BigDecimal amountExcludingVat = price1.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
               BigDecimal amountNoFreight = price1.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
               BigDecimal amountExcludingVatNoFreight = price1.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
               price1.setAmount(price1.getAmount().subtract(amount));
               price1.setAmountExcludingVat(price1.getAmountExcludingVat().subtract(amountExcludingVat));
               price1.setAmountNoFreight(price1.getAmountNoFreight().subtract(amountNoFreight));
               price1.setAmountExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
               price1.setOneMete(price1.getOneMete().subtract(newMaterialInventory.getMete()));
               this.weightedAveragePriceService
                  .createMonthWAP(
                     InboundDetail.builder()
                        .mete(newMaterialInventory.getMete())
                        .quantity(newMaterialInventory.getQuantity())
                        .projectId(newMaterialInventory.getProjectId())
                        .accountingUnit(newMaterialInventory.getAccountingUnit())
                        .unitPrice(amount.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                        .unitPriceExcludingVat(amountExcludingVat.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                        .amount(amount)
                        .amountExcludingVat(amountExcludingVat)
                        .invoiceType(newMaterialInventory.getInvoiceType())
                        .workshopId(newMaterialInventory.getWorkshopId())
                        .unitPriceNoFreight(amountNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                        .unitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                        .amountNoFreight(amountNoFreight)
                        .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                        .realTime(LocalDateTime.now())
                        .build(),
                     newMaterialInventory,
                     wmsPlantConvert.getId(),
                     wmsPlantConvert.getReceiptSerialNumber(),
                     ReceiptTypeEnum.PLANT_CONVERT.getType()
                  );
               surplus.setStockQuantity(surplus.getStockQuantity().subtract(BigDecimal.ONE));
               if (surplus.getStockQuantity().compareTo(BigDecimal.ZERO) == 0) {
                  this.wmsSurplusMaterialsService.removeById(surplus);
               } else {
                  this.wmsSurplusMaterialsService.updateById(surplus);
               }
            }
         );
      }
   }

   public void materialUnfreeze(Long id, String freezeSourceSn, Integer freezeType, BigDecimal materialInventoryMete) {
      MaterialFreezeRecord freezeRecord = this.materialFreezeRecordService
         .getOne(
            (Wrapper<MaterialFreezeRecord>)(Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getFreezeType, freezeType))
               .eq(MaterialFreezeRecord::getFreezeSourceSn, freezeSourceSn)
         );
      if (freezeRecord != null) {
         MaterialFreeze materialFreeze = this.materialFreezeService.getById(freezeRecord.getMaterialFreezeId());
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(materialInventoryMete));
         materialFreeze.setTotalQuantity(materialFreeze.getTotalQuantity() != null ? materialFreeze.getTotalQuantity().subtract(BigDecimal.ONE) : null);
         if (materialFreeze.getTotalMete().compareTo(BigDecimal.ZERO) > 0) {
            this.materialFreezeService.updateById(materialFreeze);
         } else {
            this.materialInventoryService.updateBoolHasFrozen(materialFreeze.getMaterialInventoryId(), false);
            this.materialFreezeService.removeById(materialFreeze);
         }

         freezeRecord.setMete(freezeRecord.getMete().subtract(materialInventoryMete));
         freezeRecord.setQuantity(freezeRecord.getQuantity() != null ? freezeRecord.getQuantity().subtract(BigDecimal.ONE) : null);
         if (freezeRecord.getQuantity().compareTo(BigDecimal.ZERO) <= 0) {
            this.materialFreezeRecordService.removeById(freezeRecord);
         } else {
            this.materialFreezeRecordService.updateById(freezeRecord);
         }
      }
   }

   public void deleteMaterialfreeze(Long id, String freezeSourceSn, Integer freezeType) {
      MaterialFreezeRecord freezeRecord = this.materialFreezeRecordService
         .getOne(
            (Wrapper<MaterialFreezeRecord>)(Wrappers.<MaterialFreezeRecord>lambdaQuery().eq(MaterialFreezeRecord::getFreezeType, freezeType))
               .eq(MaterialFreezeRecord::getFreezeSourceSn, freezeSourceSn)
         );
      if (freezeRecord != null) {
         MaterialFreeze materialFreeze = this.materialFreezeService.getById(freezeRecord.getMaterialFreezeId());
         materialFreeze.setTotalMete(materialFreeze.getTotalMete().subtract(freezeRecord.getMete()));
         materialFreeze.setTotalQuantity(
            materialFreeze.getTotalQuantity() != null ? materialFreeze.getTotalQuantity().subtract(freezeRecord.getQuantity()) : null
         );
         if (materialFreeze.getTotalMete().compareTo(BigDecimal.ZERO) > 0) {
            this.materialFreezeService.updateById(materialFreeze);
         } else {
            this.materialInventoryService.updateBoolHasFrozen(materialFreeze.getMaterialInventoryId(), false);
            this.materialFreezeService.removeById(materialFreeze);
         }

         this.materialFreezeRecordService.removeById(freezeRecord);
      }
   }

   public void getMaterialInventorys(Outbound outbound, List<MoveOutboundDetail> outboundDetailList, MaterialInventory materialInventory, String guid) {
      Measure measure = this.measureService
         .getOne((Wrapper<Measure>)Wrappers.<Measure>lambdaQuery().eq(Measure::getClassificationId, materialInventory.getClassifyId()));
      BigDecimal materialInventoryMete = this.getMaterialInventoryMete(materialInventory, measure, guid);
      List<WmsSurplusMaterials> list3 = this.wmsSurplusMaterialsService
         .list(
            (Wrapper<WmsSurplusMaterials>)(new LambdaQueryWrapper<WmsSurplusMaterials>().eq(WmsSurplusMaterials::getStockCutGuid, outbound.getStockCutGuid()))
               .eq(WmsSurplusMaterials::getBoolNestVirtual, true)
         );
      Preconditions.checkArgument(
         list3.stream().allMatch(surplus -> surplus.getMete() != null && surplus.getMete().signum() >= 0
            && surplus.getMete().stripTrailingZeros().scale() <= 2 && surplus.getMete().setScale(2).precision() <= 19),
         "当前套料余料重量超出可保存精度,请重新操作"
      );
      BigDecimal convertedMete = outboundDetailList.stream().map(MoveOutboundDetail::getMete).reduce(BigDecimal.ZERO, BigDecimal::add)
         .add(list3.stream().map(WmsSurplusMaterials::getMete).reduce(BigDecimal.ZERO, BigDecimal::add));
      Preconditions.checkArgument(
         convertedMete.compareTo(materialInventoryMete) == 0,
         "当前套料出库及余料重量与冻结重量不一致,请重新操作"
      );
      this.materialUnfreeze(outbound.getId(), guid, MaterialFreezeTypeEnum.NESTING.getType(), materialInventoryMete);
      Integer count = this.wmsPlantConvertService.getMaxDayConventNumber(LocalDateTime.now());
      String sn = this.numberConfigService.getNumber(NumberTypeEnum.PLANT_CONVERT, count);
      String currentName = "超级管理员";
      Long currentUserId = 1L;
      WmsPlantConvert build = WmsPlantConvert.builder()
         .outSerialNumber(outbound.getSerialNumber())
         .receiptSerialNumber(sn)
         .reviewerId(currentUserId)
         .reviewerName(currentName)
         .taskOrderNumber(outbound.getChildOrderNumber())
         .reviewTime(LocalDateTime.now())
         .basicClass(materialInventory.getBasicClass())
         .outboundId(outbound.getId())
         .projectIds(materialInventory.getProjectId() != null ? materialInventory.getProjectId().toString() : null)
         .build();
      this.wmsPlantConvertService.save(build);
      WeightedPriceConf weightedPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权模式配置")).getValue(), WeightedPriceConf.class
      );
      WeightedExecutionPriceConf weightedExecutionPriceConf = JSON.parseObject(
         this.basicConfigService.getOne((Wrapper<BasicConfig>)Wrappers.<BasicConfig>lambdaQuery().eq(BasicConfig::getName, "加权执行方式配置")).getValue(),
         WeightedExecutionPriceConf.class
      );
      MaterialInventory copy = BeanUtil.copy(materialInventory, MaterialInventory.class);
      copy.setQuantity(BigDecimal.ONE);
      copy.setMete(materialInventoryMete);
      WmsPlantConvertDetail plant = BeanUtil.copy(copy, WmsPlantConvertDetail.class);
      plant.setWmsPlantConvertId(build.getId());
      this.wmsPlantConvertDetailService.save(plant);
      PriceDTO price1 = this.queryUtilService.getPrice(weightedPriceConf, weightedExecutionPriceConf, copy, outboundDetailList.get(0).getOutboundTime());
      price1.setOneMete(materialInventoryMete);
      this.weightedAveragePriceService
         .createMonthWAP(
            InboundDetail.builder()
               .mete(materialInventoryMete.negate())
               .quantity(BigDecimal.ONE.negate())
               .projectId(materialInventory.getProjectId())
               .accountingUnit(materialInventory.getAccountingUnit())
               .invoiceType(materialInventory.getInvoiceType())
               .unitPrice(price1.getAmount().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
               .unitPriceExcludingVat(price1.getAmountExcludingVat().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
               .amount(price1.getAmount().negate())
               .amountExcludingVat(price1.getAmountExcludingVat().negate())
               .unitPriceNoFreight(price1.getAmountNoFreight().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
               .unitPriceExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().divide(materialInventoryMete, 12, RoundingMode.HALF_UP))
               .amountNoFreight(price1.getAmountNoFreight().negate())
               .amountExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().negate())
               .realTime(LocalDateTime.now())
               .build(),
            materialInventory,
            build.getId(),
            build.getReceiptSerialNumber(),
            ReceiptTypeEnum.PLANT_CONVERT.getType()
         );
      materialInventory.setQuantity(materialInventory.getQuantity().subtract(BigDecimal.ONE));
      materialInventory.setMete(materialInventory.getMete().subtract(materialInventoryMete));
      this.wmsUtil
         .setInventoryUse(
            materialInventory, BigDecimal.ONE, materialInventoryMete, ReceiptTypeEnum.PLANT_CONVERT, build.getId(), build.getReceiptSerialNumber(), 1, false
         );
      if (materialInventory.getMete().compareTo(BigDecimal.ZERO) == 0) {
         this.materialInventoryService.removeById(materialInventory);
      } else {
         this.materialInventoryService.updateById(materialInventory);
      }

      this.warningService.updateStatus(materialInventory, 2);
      Statistics statistics = this.outBoundServiceBiz.get(materialInventory);
      this.setStatisticsEndPeriod(materialInventory, statistics);

      for (MoveOutboundDetail outboundDetail : outboundDetailList) {
         MaterialInventory newMaterialInventory = this.getNewMaterialInventory(materialInventory, outboundDetail, outbound);
         this.wmsUtil
            .setInventoryUse(
               newMaterialInventory,
               newMaterialInventory.getQuantity(),
               newMaterialInventory.getMete(),
               ReceiptTypeEnum.PLANT_CONVERT,
               build.getId(),
               build.getReceiptSerialNumber(),
               1,
               true
            );
         WmsPlantConvertDetail copy1 = BeanUtil.copy(newMaterialInventory, WmsPlantConvertDetail.class);
         copy1.setWmsPlantConvertId(build.getId());
         copy1.setWmsPlantConvertDetailId(plant.getId());
         copy1.setOutboundDetailId(outboundDetail.getId());
         this.wmsPlantConvertDetailService.save(copy1);
         BigDecimal p = newMaterialInventory.getMete().divide(price1.getOneMete(), 20, this.ROUNDING);
         BigDecimal amount = price1.getAmount().multiply(p).setScale(2, this.ROUNDING);
         BigDecimal amountExcludingVat = price1.getAmountExcludingVat().multiply(p).setScale(2, this.ROUNDING);
         BigDecimal amountNoFreight = price1.getAmountNoFreight().multiply(p).setScale(2, this.ROUNDING);
         BigDecimal amountExcludingVatNoFreight = price1.getAmountExcludingVatNoFreight().multiply(p).setScale(2, this.ROUNDING);
         price1.setAmount(price1.getAmount().subtract(amount));
         price1.setAmountExcludingVat(price1.getAmountExcludingVat().subtract(amountExcludingVat));
         price1.setAmountNoFreight(price1.getAmountNoFreight().subtract(amountNoFreight));
         price1.setAmountExcludingVatNoFreight(price1.getAmountExcludingVatNoFreight().subtract(amountExcludingVatNoFreight));
         price1.setOneMete(price1.getOneMete().subtract(newMaterialInventory.getMete()));
         outboundDetail.setMaterialInventoryId(newMaterialInventory.getId());
         outboundDetail.setWmsPlantConvertNumber(build.getReceiptSerialNumber());
         this.weightedAveragePriceService
            .createMonthWAP(
               InboundDetail.builder()
                  .mete(outboundDetail.getMete())
                  .quantity(outboundDetail.getQuantity())
                  .projectId(newMaterialInventory.getProjectId())
                  .accountingUnit(newMaterialInventory.getAccountingUnit())
                  .unitPrice(amount.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVat(amountExcludingVat.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                  .amount(amount)
                  .amountExcludingVat(amountExcludingVat)
                  .invoiceType(newMaterialInventory.getInvoiceType())
                  .workshopId(newMaterialInventory.getWorkshopId())
                  .unitPriceNoFreight(amountNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                  .unitPriceExcludingVatNoFreight(amountExcludingVatNoFreight.divide(newMaterialInventory.getMete(), 12, RoundingMode.HALF_UP))
                  .amountNoFreight(amountNoFreight)
                  .amountExcludingVatNoFreight(amountExcludingVatNoFreight)
                  .realTime(LocalDateTime.now())
                  .build(),
               newMaterialInventory,
               build.getId(),
               build.getReceiptSerialNumber(),
               ReceiptTypeEnum.PLANT_CONVERT.getType()
            );
         this.outboundDetailService.updateById(outboundDetail);
      }

      if (CollectionUtil.isNotEmpty(list3)) {
         this.getMaterialInventory(outbound, list3, materialInventory, price1, build, plant);
      }

      this.wmsPlantConvertService.updateById(build);
   }

   private MaterialInventory getNewMaterialInventory(MaterialInventory materialInventory, MoveOutboundDetail moveOutboundDetail, Outbound outbound) {
      MaterialInventory mi = MaterialInventory.builder()
         .basicClass(materialInventory.getBasicClass())
         .sourceMaterialInventoryId(materialInventory.getId())
         .warehouseType(materialInventory.getProjectId() != null ? 2 : 1)
         .classifyId(materialInventory.getClassifyId())
         .classifyName(materialInventory.getClassifyName())
         .brand(materialInventory.getBrand())
         .boolPartyA(materialInventory.getBoolPartyA())
         .thickness(materialInventory.getThickness())
         .quantity(moveOutboundDetail.getQuantity())
         .mete(moveOutboundDetail.getMete())
         .theoryThickness(materialInventory.getTheoryThickness())
         .heatNoAndBatchNo(materialInventory.getHeatNoAndBatchNo())
         .specification(materialInventory.getSpecification())
         .workshopId(materialInventory.getWorkshopId())
         .warehouseId(materialInventory.getWarehouseId())
         .weightedAverageSpec(materialInventory.getWeightedAverageSpec())
         .projectId(materialInventory.getProjectId())
         .monomerId(materialInventory.getMonomerId())
         .areaId(materialInventory.getAreaId())
         .invoiceType(materialInventory.getInvoiceType())
         .taxRate(materialInventory.getTaxRate())
         .accountingPrecision(materialInventory.getAccountingPrecision())
         .accountingUnit(materialInventory.getAccountingUnit())
         .materialIsWhole(1)
         .oneTheoryWeight(moveOutboundDetail.getMete().divide(new BigDecimal(1000), 12, RoundingMode.HALF_UP))
         .length(moveOutboundDetail.getLength())
         .width(moveOutboundDetail.getWidth())
         .serialNumber(materialInventory.getSerialNumber())
         .build();
      String barcode = this.printService
         .savePrint1(
            PrintDetail.builder()
               .basicClass(mi.getBasicClass())
               .classifyId(mi.getClassifyId())
               .classifyName(materialInventory.getClassifyName())
               .specification(mi.getSpecification())
               .mete(mi.getMete())
               .quantity(mi.getQuantity())
               .brand(mi.getBrand())
               .heatNoAndBatchNo(mi.getHeatNoAndBatchNo())
               .workshopId(mi.getWorkshopId())
               .warehouseId(mi.getWarehouseId())
               .type(MaterialLabelPrintTypeEnum.OUTBOUND.getType())
               .boolPartyA(mi.getBoolPartyA())
               .length(mi.getLength())
               .width(mi.getWidth())
               .thickness(mi.getThickness())
               .color(mi.getColor())
               .notPrintNumber(moveOutboundDetail.getQuantity().intValue())
               .standardId(mi.getStandardId())
               .standardName(mi.getStandardName())
               .materialIsWhole(mi.getMaterialIsWhole())
               .monomerId(mi.getMonomerId())
               .areaId(mi.getAreaId())
               .build(),
            outbound
         );
      mi.setBarcode(barcode);
      this.materialInventoryService.save(mi);
      return mi;
   }

   private BigDecimal getMaterialInventoryMete(MaterialInventory materialInventory, Measure measure, String guid) {
      MaterialFreeze materialFreeze = this.materialFreezeService
         .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, materialInventory.getId()));
      MaterialFreezeRecord freezeRecord = this.materialFreezeRecordService
         .getOne(
            (Wrapper<MaterialFreezeRecord>)((Wrappers.<MaterialFreezeRecord>lambdaQuery()
                     .eq(MaterialFreezeRecord::getMaterialFreezeId, materialFreeze.getId()))
                  .eq(MaterialFreezeRecord::getFreezeType, MaterialFreezeTypeEnum.NESTING.getType()))
               .eq(MaterialFreezeRecord::getFreezeSourceSn, guid)
         );
      BigDecimal mete = CommonUtil.getStockOutboundMete(BigDecimal.ONE, freezeRecord.getQuantity(), freezeRecord.getMete());
      Preconditions.checkArgument(
         materialInventory.getQuantity().compareTo(BigDecimal.ONE) >= 0 && mete.compareTo(materialInventory.getMete()) <= 0,
         "当前套料冻结重量超出库存,请重新操作"
      );
      return mete;
   }

   private Boolean chrackMaterial(MaterialInventory materialInventory, Long syncId, Integer quantity) {
      if (materialInventory == null) {
         log.warn("MaterialInventory is null, syncId: {}", syncId);
         return false;
      } else if (quantity != null && quantity >= 0) {
         MaterialFreeze materialFreeze = this.materialFreezeService
            .getOne((Wrapper<MaterialFreeze>)Wrappers.<MaterialFreeze>lambdaQuery().eq(MaterialFreeze::getMaterialInventoryId, syncId));
         log.info("本地冻结主表记录信息: {}", materialFreeze);
         BigDecimal frozenQuantity = materialFreeze != null ? materialFreeze.getTotalQuantity() : BigDecimal.ZERO;
         BigDecimal totalQuantity = frozenQuantity.add(BigDecimal.valueOf(quantity.intValue()));
         boolean isSufficient = totalQuantity.compareTo(materialInventory.getQuantity()) <= 0;
         log.info("库存校验结果: syncId={}, 冻结库存={}, 新增数量={}, 总数量={}, 库存是否足够={}", syncId, frozenQuantity, quantity, totalQuantity, isSufficient);
         return isSufficient;
      } else {
         log.warn("Invalid quantity: {}, syncId: {}", quantity, syncId);
         return false;
      }
   }
}
