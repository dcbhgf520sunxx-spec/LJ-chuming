package com.hzchum.scim.bim.core.biz.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.bimface.data.bean.ElementIdWithFileId;
import com.bimface.data.bean.ElementsWithBoundingBox;
import com.bimface.data.bean.Property;
import com.bimface.data.bean.PropertyGroup;
import com.bimface.data.bean.PropertyItem;
import com.bimface.data.bean.SearchElementIdsResp;
import com.bimface.exception.BimfaceException;
import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.bean.request.QueryElementIdsRequest;
import com.bimface.sdk.service.ElementService;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.bim.core.api.biz.BimModelBiz;
import com.hzchum.scim.bim.core.api.enums.BimImportModeEnum;
import com.hzchum.scim.bim.core.api.enums.BimMenuBarEnum;
import com.hzchum.scim.bim.core.api.enums.BimModelTypeEnum;
import com.hzchum.scim.bim.core.api.enums.BimStatusEnum;
import com.hzchum.scim.bim.core.api.enums.BimStatusIntegrationEnum;
import com.hzchum.scim.bim.core.api.enums.BimTeklaEditionEnum;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimArtifactProductionVO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimArtifactRecordResponseVO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimBridgeProductMeteGroupVO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimProductMeteGroupVO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.common.core.api.pojo.vo.BimArtifactStatusDetailVO;
import com.hzchum.scim.common.core.api.pojo.vo.BimLogisticsLinkVO;
import com.hzchum.scim.common.core.api.pojo.vo.BimLogisticsVO;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.cargoList.CargoListStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse.MesBuildingWarehouseSummary;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskRecordBiz;
import com.hzchum.scim.plan.core.api.enums.DrawingProductTypeEnum;
import com.hzchum.scim.plan.core.api.enums.TechDataTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleDetail;
import com.hzchum.scim.plan.core.api.pojo._do.TechDrawing;
import com.hzchum.scim.plan.core.api.pojo.dto.BridgeElementPartDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductWeldCountDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DrawingAndSerialNumberDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.TechMachinePartDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimArtifactVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimSummaryDetailsVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleDetailService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechDrawingService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallSummary;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReceivingSummary;
import com.hzchum.scim.project.core.api.service.ProjectInstallSummaryService;
import com.hzchum.scim.project.core.api.service.ProjectReceivingSummaryService;
import com.hzchum.scim.system.core.api.common.utils.NumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BimModelBizImpl implements BimModelBiz {
   private static final Logger log = LoggerFactory.getLogger(BimModelBizImpl.class);
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private PlanAreaService planAreaService;
   @Resource
   private ContractProjectService contractProjectService;
   @Resource
   private BimModelCommonService bimModelCommonService;
   @Resource
   private BimfaceClient bimfaceClient;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private MesBuildingWarehouseSummaryService mesBuildingWarehouseSummaryService;
   @Resource
   private MesBuildingTaskService mesBuildingTaskService;
   @Resource
   private TechMachinePartService techMachinePartService;
   @Resource
   private MesBuildingTaskService taskService;
   @Resource
   private MesBuildingCargoListService mesBuildingCargoListService;
   @Resource
   private TechDrawingService techDrawingService;
   @Resource
   private BimModelConfigurationService bimModelConfigurationService;
   @Resource
   private ProjectInstallSummaryService projectInstallSummaryService;
   @Resource
   private ProjectReceivingSummaryService projectReceivingSummaryService;
   @Resource
   private TechAssembleDetailService assembleDetailService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechCappCraftProductPassTaskRecordBiz techCappCraftProductPassTaskRecordBiz;

   @Override
   public Map<String, List<String>> getOldArtifactStatus(Long fileId, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      ContractProject project = this.contractProjectService.getById(bimModelCommonDO.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, bimModelCommonDO.getMonomerId()));
      Map<String, BimArtifactRecordResponseVO> artifactMap = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         Preconditions.checkArgument(BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType()), "模型类型错误!!!");
         Preconditions.checkArgument(bimModelCommonDO.getAreaId() == null, "模型类型错误!!!");
         artifactMap = this.buildArtifactMap(bimModelCommonDO.getMonomerId(), null);
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            Preconditions.checkArgument(bimModelCommonDO.getAreaId() != null, "区域不能为null");
            artifactMap = this.buildArtifactMap(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()));
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            Preconditions.checkArgument(bimModelCommonDO.getAreaId() == null, "模型类型错误!!!");
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                 .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                              .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                           .isNotNull(BimModelCommonDO::getAreaId))
                        .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
            artifactMap = this.buildArtifactMap(
               bimModelCommonDO.getMonomerId(), bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList())
            );
         }
      }

      Map<Integer, List<String>> artifactStatusMap = new HashMap<>();
      assert artifactMap != null;
      artifactMap.forEach((serialNumber, record) -> {
         Integer type = this.getType(record, menuBar).getType();
         List<String> serialNumberList = artifactStatusMap.get(type);
         if (CollectionUtils.isEmpty(serialNumberList)) {
            serialNumberList = new ArrayList<>();
         }

         serialNumberList.add(serialNumber);
         artifactStatusMap.put(type, serialNumberList);
      });
      Map<String, List<String>> responseVOMap = new HashMap<>();
      artifactStatusMap.forEach(
         (type, serialNumbers) -> {
            if (CollectionUtils.isNotEmpty(serialNumbers)) {
               List<String> allElementIds = new ArrayList<>();
               serialNumbers.forEach(
                  serialNumber -> {
                     List<String> elementIdsx = null;
                     if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                        || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                        elementIdsx = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber));
                     }

                     if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                        && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                        elementIdsx = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber));
                     }

                     if (CollectionUtils.isNotEmpty(elementIdsx)) {
                        allElementIds.addAll(elementIdsx);
                     } else {
                        List<String> serialNumberList = new ArrayList<>();
                        serialNumberList.add(serialNumber);
                        String requestBody = getOldSerialNumberListJSON(
                           fileId.toString(), serialNumberList, configurationDO.getEdition(), bimModelCommonDO.getModelType()
                        );
                        List<String> elementsx = this.getElementIds(requestBody);
                        if (CollectionUtils.isEmpty(elementsx)) {
                           if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, new ArrayList());
                           }

                           if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber, new ArrayList());
                           }

                           allElementIds.addAll(new ArrayList<>());
                        } else {
                           if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, elementsx);
                           }

                           if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber, elementsx);
                           }

                           allElementIds.addAll(elementsx);
                        }
                     }
                  }
               );
               responseVOMap.put(type.toString(), allElementIds);
            }
         }
      );
      List<String> elementIdsV2 = null;

      try {
         if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
            || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIdsV2 = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), fileId.toString()));
         }

         if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
            && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIdsV2 = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), fileId.toString()));
         }

         if (CollectionUtils.isEmpty(elementIdsV2)) {
            elementIdsV2 = new ArrayList<>();
            String paginationContextId = this.bimfaceClient.getPaginationContextId();
            QueryElementIdsRequest queryElementIdsRequest = new QueryElementIdsRequest();
            queryElementIdsRequest.setPaginationContextId(paginationContextId);
            queryElementIdsRequest.setPaginationSize(10000);

            while (true) {
               if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  List<String> elementIds = this.bimfaceClient.getElementService().getElementIdsV2(fileId, queryElementIdsRequest);
                  elementIdsV2.addAll(elementIds);
                  if (elementIds.size() < queryElementIdsRequest.getPaginationSize()) {
                     break;
                  }
               }

               if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  ElementsWithBoundingBox integrateModelElementIds = this.bimfaceClient.getIntegrateModelElementIds(fileId, queryElementIdsRequest);
                  List<ElementIdWithFileId> elements = integrateModelElementIds.getElements();
                  List<String> elementIds = elements.stream().map(ex -> ex.getFileId() + "." + ex.getElementId()).collect(Collectors.toList());
                  elementIdsV2.addAll(elementIds);
                  if (elementIds.size() < queryElementIdsRequest.getPaginationSize()) {
                     break;
                  }
               }
            }

            if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
               || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
               this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), fileId.toString(), elementIdsV2);
            }

            if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
               && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
               this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), fileId.toString(), elementIdsV2);
            }
         }

         responseVOMap.put(BimStatusEnum.ALL.getType().toString(), elementIdsV2);
      } catch (BimfaceException e) {
         e.printStackTrace();
      }

      this.setNoListByMenuBar(menuBar, elementIdsV2, responseVOMap);
      return responseVOMap;
   }

   @Override
   public Map<String, List<String>> getArtifactStatus(Long fileId, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      ContractProject project = this.contractProjectService.getById(bimModelCommonDO.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, bimModelCommonDO.getMonomerId()));
      Map<String, BimArtifactRecordResponseVO> artifactMap = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         Preconditions.checkArgument(BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType()), "模型类型错误!!!");
         Preconditions.checkArgument(bimModelCommonDO.getAreaId() == null, "模型类型错误!!!");
         artifactMap = this.buildArtifactMap(bimModelCommonDO.getMonomerId(), null);
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            Preconditions.checkArgument(bimModelCommonDO.getAreaId() != null, "区域不能为null");
            artifactMap = this.buildArtifactMap(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()));
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            Preconditions.checkArgument(bimModelCommonDO.getAreaId() == null, "模型类型错误!!!");
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                 .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                              .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                           .isNotNull(BimModelCommonDO::getAreaId))
                        .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
            artifactMap = this.buildArtifactMap(
               bimModelCommonDO.getMonomerId(), bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList())
            );
         }
      }

      Map<Integer, List<String>> artifactStatusMap = new HashMap<>();
      assert artifactMap != null;
      artifactMap.forEach((serialNumber, record) -> {
         Integer type = this.getType(record, menuBar).getType();
         List<String> serialNumberList = artifactStatusMap.get(type);
         if (CollectionUtils.isEmpty(serialNumberList)) {
            serialNumberList = new ArrayList<>();
         }

         serialNumberList.add(serialNumber);
         artifactStatusMap.put(type, serialNumberList);
      });
      Map<String, List<String>> responseVOMap = new HashMap<>();
      artifactStatusMap.forEach(
         (type, serialNumbers) -> {
            if (CollectionUtils.isNotEmpty(serialNumbers)) {
               List<String> allElementIds = new ArrayList<>();
               List<String> haveElementIdSerialNumberList = new ArrayList<>();

               for (String serialNumber : serialNumbers) {
                  List<String> elementIdsx = null;
                  if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                     || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                     elementIdsx = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber));
                  }

                  if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                     && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                     elementIdsx = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber));
                  }

                  if (CollectionUtils.isNotEmpty(elementIdsx)) {
                     allElementIds.addAll(elementIdsx);
                     haveElementIdSerialNumberList.add(serialNumber);
                  }
               }

               List<String> nohaveElementIdSerialNumberList = serialNumbers.stream()
                  .filter(ex -> !haveElementIdSerialNumberList.contains(ex))
                  .collect(Collectors.toList());
               if (CollectionUtils.isNotEmpty(nohaveElementIdSerialNumberList)) {
                  String allRequestBody = getSerialNumberListJSON(
                     fileId.toString(), nohaveElementIdSerialNumberList, configurationDO.getEdition(), bimModelCommonDO.getModelType()
                  );
                  List<String> allElementIdList = this.getAllElementIds(allRequestBody);
                  if (CollectionUtils.isEmpty(allElementIdList)) {
                     allElementIds.addAll(new ArrayList<>());
                  } else {
                     nohaveElementIdSerialNumberList.forEach(
                        serialNumber -> {
                           List<String> serialNumberList = new ArrayList<>();
                           serialNumberList.add(serialNumber);
                           String requestBody = getSerialNumberListJSON(
                              fileId.toString(), serialNumberList, configurationDO.getEdition(), bimModelCommonDO.getModelType()
                           );
                           List<String> elementsx = this.getElementIds(requestBody);
                           if (CollectionUtils.isEmpty(elementsx)) {
                              if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                                 || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                                 this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, new ArrayList());
                              }

                              if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                                 && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                                 this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber, new ArrayList());
                              }

                              allElementIds.addAll(new ArrayList<>());
                           } else {
                              if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                                 || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                                 this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, elementsx);
                              }

                              if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                                 && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                                 this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber, elementsx);
                              }

                              allElementIds.addAll(elementsx);
                           }
                        }
                     );
                  }
               }

               responseVOMap.put(type.toString(), allElementIds);
            }
         }
      );
      List<String> elementIdsV2 = null;

      try {
         if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
            || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIdsV2 = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), fileId.toString()));
         }

         if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
            && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIdsV2 = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), fileId.toString()));
         }

         if (CollectionUtils.isEmpty(elementIdsV2)) {
            elementIdsV2 = new ArrayList<>();
            String paginationContextId = this.bimfaceClient.getPaginationContextId();
            QueryElementIdsRequest queryElementIdsRequest = new QueryElementIdsRequest();
            queryElementIdsRequest.setPaginationContextId(paginationContextId);
            queryElementIdsRequest.setPaginationSize(10000);

            while (true) {
               if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  List<String> elementIds = this.bimfaceClient.getElementService().getElementIdsV2(fileId, queryElementIdsRequest);
                  elementIdsV2.addAll(elementIds);
                  if (elementIds.size() < queryElementIdsRequest.getPaginationSize()) {
                     break;
                  }
               }

               if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  ElementsWithBoundingBox integrateModelElementIds = this.bimfaceClient.getIntegrateModelElementIds(fileId, queryElementIdsRequest);
                  List<ElementIdWithFileId> elements = integrateModelElementIds.getElements();
                  List<String> elementIds = elements.stream().map(ex -> ex.getFileId() + "." + ex.getElementId()).collect(Collectors.toList());
                  elementIdsV2.addAll(elementIds);
                  if (elementIds.size() < queryElementIdsRequest.getPaginationSize()) {
                     break;
                  }
               }
            }

            if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
               || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
               this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), fileId.toString(), elementIdsV2);
            }

            if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
               && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
               this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), fileId.toString(), elementIdsV2);
            }
         }

         responseVOMap.put(BimStatusEnum.ALL.getType().toString(), elementIdsV2);
      } catch (BimfaceException e) {
         throw new RuntimeException(e);
      }

      this.setNoListByMenuBar(menuBar, elementIdsV2, responseVOMap);
      return responseVOMap;
   }

   @Override
   public Map<String, List<String>> getBridgeStatus(Long fileId, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      ContractProject project = this.contractProjectService.getById(bimModelCommonDO.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, bimModelCommonDO.getMonomerId()));
      Map<String, BimArtifactRecordResponseVO> segmentationMap = null;
      Map<String, List<String>> hashMap = new HashedMap<>();
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         Preconditions.checkArgument(BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType()), "模型类型错误!!!");
         Preconditions.checkArgument(bimModelCommonDO.getAreaId() == null, "模型类型错误!!!");
         segmentationMap = this.bridgeBoxMap(bimModelCommonDO.getMonomerId(), null, hashMap);
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            Preconditions.checkArgument(bimModelCommonDO.getAreaId() != null, "区域不能为null");
            segmentationMap = this.bridgeBoxMap(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), hashMap);
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            Preconditions.checkArgument(bimModelCommonDO.getAreaId() == null, "模型类型错误!!!");
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                 .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                              .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                           .isNotNull(BimModelCommonDO::getAreaId))
                        .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
            segmentationMap = this.bridgeBoxMap(
               bimModelCommonDO.getMonomerId(), bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList()), hashMap
            );
         }
      }

      Map<Integer, List<String>> segmentationStatusMap = new HashMap<>();
      assert segmentationMap != null;
      segmentationMap.forEach((serialNumber, record) -> {
         Integer type = this.getType(record, menuBar).getType();
         List<String> serialNumberList = segmentationStatusMap.get(type);
         if (CollectionUtils.isEmpty(serialNumberList)) {
            serialNumberList = new ArrayList<>();
         }

         serialNumberList.add(serialNumber);
         segmentationStatusMap.put(type, serialNumberList);
      });
      Map<String, List<String>> responseVOMap = new HashMap<>();
      segmentationStatusMap.forEach(
         (type, serialNumbers) -> {
            if (CollectionUtils.isNotEmpty(serialNumbers)) {
               List<String> allElementIds = new ArrayList<>();
               serialNumbers.forEach(
                  serialNumber -> {
                     List<String> elementIdsx = null;
                     if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                        || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                        elementIdsx = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber));
                     }

                     if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                        && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                        elementIdsx = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber));
                     }

                     if (CollectionUtils.isNotEmpty(elementIdsx)) {
                        allElementIds.addAll(elementIdsx);
                     } else {
                        List<String> serialNumberList = new ArrayList<>();
                        serialNumberList.add(serialNumber);
                        String requestBody = getSerialNumberListJSON(
                           fileId.toString(), serialNumberList, configurationDO.getEdition(), bimModelCommonDO.getModelType()
                        );
                        String requestUnitBody = getUnitSerialNumberListJSON(
                           fileId.toString(), serialNumberList, configurationDO.getEdition(), bimModelCommonDO.getModelType()
                        );
                        List<String> elementsx = this.getElementIds(requestBody);
                        elementsx = CollectionUtils.isEmpty(elementsx) ? new ArrayList<>() : elementsx;
                        List<String> unitElements = this.getElementIds(requestUnitBody);
                        if (CollectionUtils.isNotEmpty(unitElements)) {
                           elementsx.addAll(unitElements);
                        }

                        if (CollectionUtils.isEmpty(elementsx)) {
                           if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, new ArrayList());
                           }

                           if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber, new ArrayList());
                           }

                           allElementIds.addAll(new ArrayList<>());
                        } else {
                           if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, elementsx);
                           }

                           if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                              && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                              this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), serialNumber, elementsx);
                           }

                           allElementIds.addAll(elementsx);
                        }
                     }

                     List<String> unitSerialNumberList = hashMap.get(serialNumber);
                     if (CollUtil.isNotEmpty(unitSerialNumberList)) {
                        List<String> boxElements = Convert.toList(
                           String.class, this.redisUtils.hget("BRIDGE_BOX:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber)
                        );
                        if (CollUtil.isEmpty(boxElements)) {
                           String boxRequestBody = getSerialNumberListJSON(
                              fileId.toString(), ImmutableList.of(serialNumber), configurationDO.getEdition(), bimModelCommonDO.getModelType()
                           );
                           boxElements = this.getElementIds(boxRequestBody);
                           this.redisUtils.hset("BRIDGE_BOX:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, boxElements);
                        }

                        List<String> finalBoxElements = boxElements;
                        unitSerialNumberList.forEach(
                           ex -> {
                              List<String> unitList = Convert.toList(
                                 String.class, this.redisUtils.hget("BRIDGE_UNIT:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), ex)
                              );
                              if (CollUtil.isEmpty(unitList)) {
                                 String unitRequestBody = getSerialNumberListJSON(
                                    fileId.toString(), ImmutableList.of(ex), configurationDO.getEdition(), bimModelCommonDO.getModelType()
                                 );
                                 List<String> unitElementsx = this.getElementIds(unitRequestBody);
                                 unitElementsx = CollectionUtils.isEmpty(unitElementsx) ? new ArrayList<>() : unitElementsx;
                                 if (CollectionUtils.isNotEmpty(finalBoxElements)) {
                                    unitElementsx.addAll(finalBoxElements);
                                 }

                                 this.redisUtils.hset("BRIDGE_UNIT:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), ex, unitElementsx);
                              }
                           }
                        );
                     }
                  }
               );
               responseVOMap.put(type.toString(), allElementIds);
            }
         }
      );
      List<String> elementIdsV2 = null;

      try {
         if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
            || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIdsV2 = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), fileId.toString()));
         }

         if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
            && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            elementIdsV2 = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), fileId.toString()));
         }

         if (CollectionUtils.isEmpty(elementIdsV2)) {
            elementIdsV2 = new ArrayList<>();
            String paginationContextId = this.bimfaceClient.getPaginationContextId();
            QueryElementIdsRequest queryElementIdsRequest = new QueryElementIdsRequest();
            queryElementIdsRequest.setPaginationContextId(paginationContextId);
            queryElementIdsRequest.setPaginationSize(10000);

            while (true) {
               if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  List<String> elementIds = this.bimfaceClient.getElementService().getElementIdsV2(fileId, queryElementIdsRequest);
                  elementIdsV2.addAll(elementIds);
                  if (elementIds.size() < queryElementIdsRequest.getPaginationSize()) {
                     break;
                  }
               }

               if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  ElementsWithBoundingBox integrateModelElementIds = this.bimfaceClient.getIntegrateModelElementIds(fileId, queryElementIdsRequest);
                  List<ElementIdWithFileId> elements = integrateModelElementIds.getElements();
                  List<String> elementIds = elements.stream().map(ex -> ex.getFileId() + "." + ex.getElementId()).collect(Collectors.toList());
                  elementIdsV2.addAll(elementIds);
                  if (elementIds.size() < queryElementIdsRequest.getPaginationSize()) {
                     break;
                  }
               }
            }

            if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
               || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
               this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), fileId.toString(), elementIdsV2);
            }

            if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
               && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
               this.redisUtils.hset("AREA_MODEL:" + bimModelCommonDO.getAreaId(), fileId.toString(), elementIdsV2);
            }
         }

         responseVOMap.put(BimStatusEnum.ALL.getType().toString(), elementIdsV2);
      } catch (BimfaceException e) {
         throw new RuntimeException(e);
      }

      this.setNoListByMenuBar(menuBar, elementIdsV2, responseVOMap);
      return responseVOMap;
   }

   private Map<String, BimArtifactRecordResponseVO> buildArtifactMap(Long monomerId, List<Long> areaIds) {
      Map<String, BimArtifactRecordResponseVO> resultMap = new HashMap<>();
      List<TechArtifact> techArtifacts = this.techArtifactService
         .list(
            (new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, monomerId))
               .in(CollectionUtils.isNotEmpty(areaIds), TechArtifact::getAreaId, areaIds)
         );
      if (CollectionUtils.isNotEmpty(techArtifacts)) {
         Map<Long, List<MesBuildingTask>> producedQuantityMap = this.mesBuildingTaskService
            .list(
               ((new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getMonomerId, monomerId))
                     .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                  .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingTask::getAreaId, areaIds)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingTask::getProductId, y -> new ArrayList<>(Collections.singleton((MesBuildingTask)y)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));
         Map<Long, List<MesBuildingWarehouseSummary>> inboundQuantityMap = this.mesBuildingWarehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)(((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                           .eq(MesBuildingWarehouseSummary::getMonomerId, monomerId))
                        .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingWarehouseSummary::getAreaId, areaIds))
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingWarehouseSummary::getType, 1)
            )
            .stream()
            .collect(
               Collectors.toMap(
                  MesBuildingWarehouseSummary::getProductId,
                  y -> new ArrayList<>(Collections.singleton((MesBuildingWarehouseSummary)y)),
                  (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         Map<Long, List<MesBuildingWarehouseSummary>> outboundQuantityMap = this.mesBuildingWarehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)(((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                           .eq(MesBuildingWarehouseSummary::getMonomerId, monomerId))
                        .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingWarehouseSummary::getAreaId, areaIds))
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingWarehouseSummary::getType, 2)
            )
            .stream()
            .collect(
               Collectors.toMap(
                  MesBuildingWarehouseSummary::getProductId,
                  y -> new ArrayList<>(Collections.singleton((MesBuildingWarehouseSummary)y)),
                  (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         Map<Long, List<ProjectReceivingSummary>> receivingSummaryMap = this.projectReceivingSummaryService
            .list(
               (Wrapper<ProjectReceivingSummary>)((new LambdaQueryWrapper<ProjectReceivingSummary>()
                        .eq(ProjectReceivingSummary::getMonomerId, monomerId))
                     .in(CollectionUtils.isNotEmpty(areaIds), ProjectReceivingSummary::getAreaId, areaIds))
                  .eq(ProjectReceivingSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
            )
            .stream()
            .collect(
               Collectors.toMap(
                  ProjectReceivingSummary::getProductId, y -> new ArrayList<>(Collections.singleton((ProjectReceivingSummary)y)), (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         Map<Long, List<ProjectInstallSummary>> installSummaryMap = this.projectInstallSummaryService
            .list(
               (Wrapper<ProjectInstallSummary>)((new LambdaQueryWrapper<ProjectInstallSummary>()
                        .eq(ProjectInstallSummary::getMonomerId, monomerId))
                     .in(CollectionUtils.isNotEmpty(areaIds), ProjectInstallSummary::getAreaId, areaIds))
                  .eq(ProjectInstallSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
            )
            .stream()
            .collect(
               Collectors.toMap(
                  ProjectInstallSummary::getProductId, y -> new ArrayList<>(Collections.singleton((ProjectInstallSummary)y)), (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         techArtifacts.forEach(
            techArtifact -> {
               Integer quantity = techArtifact.getQuantity();
               Integer inProductionQuantity = producedQuantityMap.get(techArtifact.getId()) == null
                  ? 0
                  : producedQuantityMap.get(techArtifact.getId())
                     .stream()
                     .mapToInt(a -> a.getInProductionQuantity() == null ? 0 : a.getInProductionQuantity())
                     .sum();
               Integer inboundQuantity = inboundQuantityMap.get(techArtifact.getId()) == null
                  ? 0
                  : inboundQuantityMap.get(techArtifact.getId()).stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity().intValue()).sum();
               Integer outboundQuantity = outboundQuantityMap.get(techArtifact.getId()) == null
                  ? 0
                  : outboundQuantityMap.get(techArtifact.getId()).stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity().intValue()).sum();
               Integer receivingQuantity = receivingSummaryMap.get(techArtifact.getId()) == null
                  ? 0
                  : receivingSummaryMap.get(techArtifact.getId()).stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity().intValue()).sum();
               Integer installationQuantity = installSummaryMap.get(techArtifact.getId()) == null
                  ? 0
                  : installSummaryMap.get(techArtifact.getId())
                     .stream()
                     .mapToInt(a -> a.getActualQuantity() == null ? 0 : a.getActualQuantity().intValue())
                     .sum();
               BimArtifactRecordResponseVO record = resultMap.get(techArtifact.getSerialNumber());
               if (record == null) {
                  record = BimArtifactRecordResponseVO.builder()
                     .inboundQuantity(inboundQuantity)
                     .quantity(quantity)
                     .producedQuantity(inProductionQuantity)
                     .outboundQuantity(outboundQuantity)
                     .installationQuantity(installationQuantity)
                     .receiptQuantity(receivingQuantity)
                     .build();
               } else {
                  record.setQuantity(record.getQuantity() + quantity);
                  record.setProducedQuantity(record.getProducedQuantity() + inProductionQuantity);
                  record.setInboundQuantity(record.getInboundQuantity() + inboundQuantity);
                  record.setOutboundQuantity(record.getOutboundQuantity() + outboundQuantity);
                  record.setInstallationQuantity(record.getInstallationQuantity() + installationQuantity);
                  record.setReceiptQuantity(record.getReceiptQuantity() + installationQuantity);
               }

               resultMap.put(techArtifact.getSerialNumber(), record);
            }
         );
      }

      return resultMap;
   }

   private Map<String, BimArtifactRecordResponseVO> bridgeBoxMap(Long monomerId, List<Long> areaIds, Map<String, List<String>> hashMap) {
      Map<String, BimArtifactRecordResponseVO> resultMap = new HashMap<>();
      List<TechArtifact> bridgeTechBoxList = this.artifactService
         .list(
            (new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, monomerId))
               .in(CollectionUtils.isNotEmpty(areaIds), TechArtifact::getAreaId, areaIds)
         );
      if (CollectionUtils.isNotEmpty(bridgeTechBoxList)) {
         Map<String, List<TechArtifact>> boxMap = bridgeTechBoxList.stream().collect(Collectors.groupingBy(TechArtifact::getSerialNumber));

         for (String serialNumber : boxMap.keySet()) {
            List<TechArtifact> boxList = boxMap.get(serialNumber);
            List<Long> boxIds = boxList.stream().map(TechArtifact::getId).collect(Collectors.toList());
            List<TechAssembleDetail> techBoxElementLinks = this.assembleDetailService
               .list((Wrapper<TechAssembleDetail>)new LambdaQueryWrapper<TechAssembleDetail>().in(TechAssembleDetail::getArtifactId, boxIds));
            if (CollectionUtils.isNotEmpty(techBoxElementLinks)) {
               List<TechAssemble> bridgeElements = this.assembleService
                  .listByIds(techBoxElementLinks.stream().map(TechAssembleDetail::getAssembleId).collect(Collectors.toList()));
               hashMap.put(serialNumber, bridgeElements.stream().map(TechAssemble::getSerialNumber).distinct().collect(Collectors.toList()));
            }
         }

         Map<Long, List<MesBuildingTask>> producedQuantityMap = this.taskService
            .list(
               ((new LambdaQueryWrapper<MesBuildingTask>().eq(MesBuildingTask::getMonomerId, monomerId))
                     .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                  .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingTask::getAreaId, areaIds)
            )
            .stream()
            .collect(Collectors.toMap(MesBuildingTask::getProductId, y -> new ArrayList<>(Collections.singleton((MesBuildingTask)y)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));
         Map<Long, List<MesBuildingWarehouseSummary>> inboundQuantityMap = this.mesBuildingWarehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)(((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                           .eq(MesBuildingWarehouseSummary::getMonomerId, monomerId))
                        .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingWarehouseSummary::getAreaId, areaIds))
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingWarehouseSummary::getType, 1)
            )
            .stream()
            .collect(
               Collectors.toMap(
                  MesBuildingWarehouseSummary::getProductId,
                  y -> new ArrayList<>(Collections.singleton((MesBuildingWarehouseSummary)y)),
                  (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         Map<Long, List<MesBuildingWarehouseSummary>> outboundQuantityMap = this.mesBuildingWarehouseSummaryService
            .list(
               (Wrapper<MesBuildingWarehouseSummary>)(((new LambdaQueryWrapper<MesBuildingWarehouseSummary>()
                           .eq(MesBuildingWarehouseSummary::getMonomerId, monomerId))
                        .in(CollectionUtils.isNotEmpty(areaIds), MesBuildingWarehouseSummary::getAreaId, areaIds))
                     .eq(MesBuildingWarehouseSummary::getProductType, ProductTypeEnum.ARTIFACT.getType()))
                  .eq(MesBuildingWarehouseSummary::getType, 2)
            )
            .stream()
            .collect(
               Collectors.toMap(
                  MesBuildingWarehouseSummary::getProductId,
                  y -> new ArrayList<>(Collections.singleton((MesBuildingWarehouseSummary)y)),
                  (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         Map<Long, List<ProjectReceivingSummary>> receivingSummaryMap = this.projectReceivingSummaryService
            .list(
               (Wrapper<ProjectReceivingSummary>)((new LambdaQueryWrapper<ProjectReceivingSummary>()
                        .eq(ProjectReceivingSummary::getMonomerId, monomerId))
                     .in(CollectionUtils.isNotEmpty(areaIds), ProjectReceivingSummary::getAreaId, areaIds))
                  .eq(ProjectReceivingSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
            )
            .stream()
            .collect(
               Collectors.toMap(
                  ProjectReceivingSummary::getProductId, y -> new ArrayList<>(Collections.singleton((ProjectReceivingSummary)y)), (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         Map<Long, List<ProjectInstallSummary>> installSummaryMap = this.projectInstallSummaryService
            .list(
               (Wrapper<ProjectInstallSummary>)((new LambdaQueryWrapper<ProjectInstallSummary>()
                        .eq(ProjectInstallSummary::getMonomerId, monomerId))
                     .in(CollectionUtils.isNotEmpty(areaIds), ProjectInstallSummary::getAreaId, areaIds))
                  .eq(ProjectInstallSummary::getProductType, ProductTypeEnum.ARTIFACT.getType())
            )
            .stream()
            .collect(
               Collectors.toMap(
                  ProjectInstallSummary::getProductId, y -> new ArrayList<>(Collections.singleton((ProjectInstallSummary)y)), (oldList, newList) -> {
                     oldList.addAll(newList);
                     return oldList;
                  }
               )
            );
         bridgeTechBoxList.forEach(
            techBox -> {
               Integer quantity = techBox.getQuantity();
               Integer inProductionQuantity = producedQuantityMap.get(techBox.getId()) == null
                  ? 0
                  : producedQuantityMap.get(techBox.getId())
                     .stream()
                     .mapToInt(a -> a.getInProductionQuantity() == null ? 0 : a.getInProductionQuantity())
                     .sum();
               Integer inboundQuantity = inboundQuantityMap.get(techBox.getId()) == null
                  ? 0
                  : inboundQuantityMap.get(techBox.getId()).stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity().intValue()).sum();
               Integer outboundQuantity = outboundQuantityMap.get(techBox.getId()) == null
                  ? 0
                  : outboundQuantityMap.get(techBox.getId()).stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity().intValue()).sum();
               Integer receivingQuantity = receivingSummaryMap.get(techBox.getId()) == null
                  ? 0
                  : receivingSummaryMap.get(techBox.getId()).stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity().intValue()).sum();
               Integer installationQuantity = installSummaryMap.get(techBox.getId()) == null
                  ? 0
                  : installSummaryMap.get(techBox.getId()).stream().mapToInt(a -> a.getActualQuantity() == null ? 0 : a.getActualQuantity().intValue()).sum();
               BimArtifactRecordResponseVO record = resultMap.get(techBox.getSerialNumber());
               List<String> unitSerialNumberList = hashMap.get(techBox.getSerialNumber());
               if (record == null) {
                  record = BimArtifactRecordResponseVO.builder()
                     .inboundQuantity(inboundQuantity)
                     .quantity(quantity)
                     .producedQuantity(inProductionQuantity)
                     .outboundQuantity(outboundQuantity)
                     .installationQuantity(installationQuantity)
                     .receiptQuantity(receivingQuantity)
                     .unitSerialNumberList(unitSerialNumberList)
                     .build();
               } else {
                  record.setQuantity(record.getQuantity() + quantity);
                  record.setProducedQuantity(record.getProducedQuantity() + inProductionQuantity);
                  record.setInboundQuantity(record.getInboundQuantity() + inboundQuantity);
                  record.setOutboundQuantity(record.getOutboundQuantity() + outboundQuantity);
                  record.setInstallationQuantity(record.getInstallationQuantity() + installationQuantity);
                  record.setReceiptQuantity(record.getReceiptQuantity() + installationQuantity);
               }

               resultMap.put(techBox.getSerialNumber(), record);
            }
         );
      }

      return resultMap;
   }

   private BimStatusEnum getType(BimArtifactRecordResponseVO artifactRecord, Integer menuBar) {
      BimStatusEnum type = BimStatusEnum.NO_LIST;
      if (BimMenuBarEnum.COMPONENT_TREE.getType().equals(menuBar)) {
         if (artifactRecord.getQuantity() == 0) {
            type = BimStatusEnum.NO_LIST;
         } else {
            type = BimStatusEnum.IS_LIST;
         }
      }

      if (BimMenuBarEnum.SHIPMENT_STATUS.getType().equals(menuBar)) {
         if (artifactRecord.getQuantity().equals(artifactRecord.getOutboundQuantity())) {
            type = BimStatusEnum.OUTBOUND;
         } else if (artifactRecord.getInboundQuantity().equals(artifactRecord.getQuantity())) {
            type = BimStatusEnum.STORAGE;
         } else {
            type = BimStatusEnum.NO_STORAGE;
         }
      }

      if (BimMenuBarEnum.PRODUCTION_STATE.getType().equals(menuBar)) {
         if (artifactRecord.getQuantity() != 0 && artifactRecord.getProducedQuantity() != 0) {
            if (artifactRecord.getQuantity().equals(artifactRecord.getInboundQuantity())) {
               type = BimStatusEnum.FINISHED_PRODUCTION;
            } else {
               type = BimStatusEnum.PRODUCTION;
            }
         } else {
            type = BimStatusEnum.NO_PRODUCE;
         }
      }

      if (BimMenuBarEnum.INSTALLATION_CONDITION.getType().equals(menuBar)) {
         if (artifactRecord.getQuantity().equals(artifactRecord.getInstallationQuantity())) {
            type = BimStatusEnum.FINISHED_INSTALLED;
         } else if (artifactRecord.getQuantity().equals(artifactRecord.getReceiptQuantity())) {
            type = BimStatusEnum.RECEIVING;
         } else {
            type = BimStatusEnum.NO_RECEIVING;
         }
      }

      return type;
   }

   private List<String> getElementIds(String requestBody) {
      try {
         return this.bimfaceClient.getElements(requestBody).get(0).getElementIds();
      } catch (Exception e) {
         log.error("请求bimFace接口报错", e);
         return null;
      }
   }

   private List<String> getAllElementIds(String requestBody) {
      try {
         List<SearchElementIdsResp> elementIdsResps = this.bimfaceClient.getElements(requestBody);
         if (CollectionUtils.isEmpty(elementIdsResps)) {
            return null;
         }

         List<String> elementIds = elementIdsResps.get(0).getElementIds();
         return CollectionUtils.isEmpty(elementIds) ? null : elementIds;
      } catch (Exception e) {
         log.error("请求bimFace接口报错", e);
         return null;
      }
   }

   @Override
   public ListVO getProjectTree(Long fileId) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      PlanMonomer monomer = this.planMonomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      List<TechArtifact> techArtifactList = null;
      List<BimProductMeteGroupVO> bimProductMeteGroupVOS = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         techArtifactList = this.techArtifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()));
         bimProductMeteGroupVOS = this.techArtifactService
            .sumMeteGroup(null, bimModelCommonDO.getMonomerId(), null, null)
            .stream()
            .map(e -> BeanUtil.copy(e, BimProductMeteGroupVO.class))
            .collect(Collectors.toList());
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            techArtifactList = this.techArtifactService
               .list(
                  (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()))
                     .eq(TechArtifact::getAreaId, bimModelCommonDO.getAreaId())
               );
            bimProductMeteGroupVOS = this.techArtifactService
               .sumMeteGroupByAreaIds(ImmutableList.of(bimModelCommonDO.getAreaId()))
               .stream()
               .map(e -> BeanUtil.copy(e, BimProductMeteGroupVO.class))
               .collect(Collectors.toList());
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                 .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                              .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                           .isNotNull(BimModelCommonDO::getAreaId))
                        .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
            List<Long> areaList = bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList());
            techArtifactList = this.techArtifactService
               .list(
                  (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()))
                     .in(TechArtifact::getAreaId, areaList)
               );
            bimProductMeteGroupVOS = this.techArtifactService
               .sumMeteGroupByAreaIds(areaList)
               .stream()
               .map(e -> BeanUtil.copy(e, BimProductMeteGroupVO.class))
               .collect(Collectors.toList());
         }
      }

      if (CollectionUtils.isNotEmpty(techArtifactList)) {
         Map<Long, List<TechArtifact>> artifactMap = techArtifactList.stream()
            .collect(Collectors.toMap(TechArtifact::getAreaId, y -> new ArrayList<>(Collections.singleton((TechArtifact)y)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));
         bimProductMeteGroupVOS.forEach(
            e -> {
               Set<String> treeSet = new TreeSet<>();
               List<TechArtifact> techArtifacts = artifactMap.get(e.getArea().getId());
               if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  BimModelCommonDO one = this.bimModelCommonService
                     .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getAreaId, e.getArea().getId()));
                  e.setFileId(one.getFileId());
               }

               if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  techArtifacts.forEach(
                     artifact -> {
                        List<String> elementIds = null;
                        if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                           || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           elementIds = Convert.toList(
                              String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), artifact.getSerialNumber())
                           );
                        }

                        if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                           && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           elementIds = Convert.toList(
                              String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), artifact.getSerialNumber())
                           );
                        }

                        if (CollectionUtils.isNotEmpty(elementIds)) {
                           treeSet.addAll(elementIds);
                        }
                     }
                  );
               }

               List<BimArtifactStatusDetailVO> basicsVOS = techArtifacts.stream()
                  .map(
                     b -> {
                        BimArtifactStatusDetailVO detailVO = BeanUtil.copy(b, BimArtifactStatusDetailVO.class);
                        detailVO.setProductWeldCount(
                           this.techCappCraftProductPassTaskRecordBiz
                              .productWeldCount(
                                 CappCraftCardProductWeldCountDTO.builder()
                                    .productId(detailVO.getId())
                                    .areaId(bimModelCommonDO.getAreaId())
                                    .monomerId(bimModelCommonDO.getMonomerId())
                                    .build()
                              )
                        );
                        return detailVO;
                     }
                  )
                  .collect(Collectors.toList());
               e.setBasicsVOS(basicsVOS);
               e.setElementIds(treeSet);
            }
         );
      }

      return new ListVO<>(bimProductMeteGroupVOS);
   }

   @Override
   public ListVO getBridgeProjectTree(Long fileId) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      PlanMonomer monomer = this.planMonomerService.getById(bimModelCommonDO.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      List<TechArtifact> bridgeTechBoxList = null;
      List<BimBridgeProductMeteGroupVO> bimProductMeteGroupVOS = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         bridgeTechBoxList = this.artifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()));
         bimProductMeteGroupVOS = this.techArtifactService
            .sumMeteGroup(null, bimModelCommonDO.getMonomerId(), null, null)
            .stream()
            .map(e -> BeanUtil.copy(e, BimBridgeProductMeteGroupVO.class))
            .collect(Collectors.toList());
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            bridgeTechBoxList = this.artifactService
               .list(
                  (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()))
                     .eq(TechArtifact::getAreaId, bimModelCommonDO.getAreaId())
               );
            bimProductMeteGroupVOS = this.techArtifactService
               .sumMeteGroupByAreaIds(ImmutableList.of(bimModelCommonDO.getAreaId()))
               .stream()
               .map(e -> BeanUtil.copy(e, BimBridgeProductMeteGroupVO.class))
               .collect(Collectors.toList());
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                 .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                              .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                           .isNotNull(BimModelCommonDO::getAreaId))
                        .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
            List<Long> areaList = bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList());
            bridgeTechBoxList = this.techArtifactService
               .list(
                  (Wrapper<TechArtifact>)(new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()))
                     .in(TechArtifact::getAreaId, areaList)
               );
            bimProductMeteGroupVOS = this.techArtifactService
               .sumMeteGroupByAreaIds(areaList)
               .stream()
               .map(e -> BeanUtil.copy(e, BimBridgeProductMeteGroupVO.class))
               .collect(Collectors.toList());
         }
      }

      if (CollectionUtils.isNotEmpty(bridgeTechBoxList)) {
         Map<Long, List<TechArtifact>> segmentationMap = bridgeTechBoxList.stream()
            .collect(Collectors.toMap(TechArtifact::getAreaId, y -> new ArrayList<>(Collections.singleton((TechArtifact)y)), (oldList, newList) -> {
               oldList.addAll(newList);
               return oldList;
            }));
         bimProductMeteGroupVOS.forEach(
            e -> {
               Set<String> treeSet = new TreeSet<>();
               List<TechArtifact> techBoxList = segmentationMap.get(e.getArea().getId());
               if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  BimModelCommonDO one = this.bimModelCommonService
                     .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getAreaId, e.getArea().getId()));
                  e.setFileId(one.getFileId());
               }

               if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  techBoxList.forEach(
                     artifact -> {
                        List<String> elementIds = null;
                        if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                           || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           elementIds = Convert.toList(
                              String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), artifact.getSerialNumber())
                           );
                        }

                        if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                           && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           elementIds = Convert.toList(
                              String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), artifact.getSerialNumber())
                           );
                        }

                        if (CollectionUtils.isNotEmpty(elementIds)) {
                           treeSet.addAll(elementIds);
                        }
                     }
                  );
               }

               List<BimArtifactStatusDetailVO> basicsVOS = techBoxList.stream()
                  .map(b -> BeanUtil.copy(b, BimArtifactStatusDetailVO.class))
                  .collect(Collectors.toList());
               e.setBasicsVOS(basicsVOS);
               e.setElementIds(treeSet);
            }
         );
      }

      return new ListVO<>(bimProductMeteGroupVOS);
   }

   @Override
   public BimArtifactVO getArtifactInfo(Long fileId, String elementId, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim文件不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      BimArtifactVO result = null;

      try {
         Property property = null;
         ElementService elementService = this.bimfaceClient.getElementService();
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            property = elementService.getSingleModelElementV2(fileId, elementId, true);
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            bimModelCommonDO = this.bimModelCommonService
               .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, Long.valueOf(elementId.split("\\.")[0])));
            property = elementService.getSingleModelElementV2(Long.valueOf(elementId.split("\\.")[0]), elementId.split("\\.")[1], true);
         }

         assert property != null;

         for (PropertyGroup propertyGroup : property.getProperties()) {
            if ("TeklaCommon".equals(propertyGroup.getGroup().replace("_", "").replace(" ", ""))) {
               for (PropertyItem propertyItem : propertyGroup.getItems()) {
                  if ("Assemblymark".equals(propertyItem.getKey().replace("_", "").replace(" ", ""))) {
                     String serialNumber = (String)propertyItem.getValue();
                     if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
                        result = this.techArtifactService.selectArtifactByBim(bimModelCommonDO.getMonomerId(), null, serialNumber);
                     }

                     if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
                        if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           result = this.techArtifactService
                              .selectArtifactByBim(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), serialNumber);
                        }

                        if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
                              .list(
                                 (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                                .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                                             .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                                          .isNotNull(BimModelCommonDO::getAreaId))
                                       .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                                    .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
                              );
                           Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
                           result = this.techArtifactService
                              .selectArtifactByBim(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), serialNumber);
                        }
                     }
                     break;
                  }
               }
            }
         }
      } catch (BimfaceException e) {
         e.printStackTrace();
      }

      this.setResult(result, menuBar, bimModelCommonDO.getImportMode());
      return result;
   }

   @Override
   public BimBoxOrElementsVO getBridgeSegmentationInfo(Long fileId, String elementId, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      BimModelConfigurationDO bimModelConfigurationDO = this.bimModelConfigurationService
         .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, bimModelCommonDO.getMonomerId()));
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      BimBoxOrElementsVO result = null;

      try {
         Property property = null;
         ElementService elementService = this.bimfaceClient.getElementService();
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            property = elementService.getSingleModelElementV2(fileId, elementId, true);
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            bimModelCommonDO = this.bimModelCommonService
               .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, Long.valueOf(elementId.split("\\.")[0])));
            property = elementService.getSingleModelElementV2(Long.valueOf(elementId.split("\\.")[0]), elementId.split("\\.")[1], true);
         }

         assert property != null;
         boolean flag = false;

         for (PropertyGroup propertyGroup : property.getProperties()) {
            if ("TeklaCommon".equals(propertyGroup.getGroup().replace("_", "").replace(" ", ""))) {
               for (PropertyItem propertyItem : propertyGroup.getItems()) {
                  if ("Assemblytop".equals(propertyItem.getKey().replace("_", "").replace(" ", ""))) {
                     String serialNumber = (String)propertyItem.getValue();
                     if (StrUtil.isNotBlank(serialNumber)) {
                        flag = true;
                        break;
                     }
                  }
               }
            }
         }

         List<String> boxElements = new ArrayList<>();
         String serialNumber = "";

         for (PropertyGroup propertyGroup : property.getProperties()) {
            if ("TeklaCommon".equals(propertyGroup.getGroup().replace("_", "").replace(" ", ""))) {
               for (PropertyItem propertyItem : propertyGroup.getItems()) {
                  if ("Assemblytop".equals(propertyItem.getKey().replace("_", "").replace(" ", ""))) {
                     serialNumber = (String)propertyItem.getValue();
                     if (StrUtil.isNotBlank(serialNumber)) {
                        boxElements = Convert.toList(
                           String.class, this.redisUtils.hget("BRIDGE_BOX:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber)
                        );
                        if (CollUtil.isEmpty(boxElements)) {
                           String requestUnitBody = getSerialNumberListJSON(
                              fileId.toString(), ImmutableList.of(serialNumber), bimModelConfigurationDO.getEdition(), bimModelCommonDO.getModelType()
                           );
                           boxElements = this.getElementIds(requestUnitBody);
                           this.redisUtils.hset("BRIDGE_BOX:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), serialNumber, boxElements);
                        }
                     }
                  }

                  if ("Assemblymark".equals(propertyItem.getKey().replace("_", "").replace(" ", "")) && flag) {
                     String unitSerialNumber = (String)propertyItem.getValue();
                     if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
                        result = this.assembleService.selectElementByBim(bimModelCommonDO.getMonomerId(), null, unitSerialNumber);
                     }

                     if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
                        if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           result = this.assembleService
                              .selectElementByBim(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), unitSerialNumber);
                        }

                        if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
                              .list(
                                 (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                                .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                                             .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                                          .isNotNull(BimModelCommonDO::getAreaId))
                                       .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                                    .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
                              );
                           Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
                           result = this.assembleService
                              .selectElementByBim(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), unitSerialNumber);
                        }
                     }

                     if (!Objects.isNull(result)) {
                        String requestUnitBody = getSerialNumberListJSON(
                           fileId.toString(), ImmutableList.of(result.getSerialNumber()), bimModelConfigurationDO.getEdition(), bimModelCommonDO.getModelType()
                        );
                        List<String> elementIds = this.getElementIds(requestUnitBody);
                        if (!CollUtil.isEmpty(elementIds)) {
                           assert boxElements != null;
                           elementIds.addAll(boxElements);
                           this.redisUtils.hset("BRIDGE_UNIT:MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), result.getSerialNumber(), elementIds);
                           result.setUnitElementIds(boxElements);
                           result.setBoxSerialNumber(serialNumber);
                        }
                     }
                     break;
                  }

                  if ("Assemblymark".equals(propertyItem.getKey().replace("_", "").replace(" ", "")) && !flag) {
                     String boxSerialNumber = (String)propertyItem.getValue();
                     if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
                        result = this.artifactService.selectBridgeArtifactByBim(bimModelCommonDO.getMonomerId(), null, boxSerialNumber);
                     }

                     if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
                        if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           result = this.artifactService
                              .selectBridgeArtifactByBim(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), boxSerialNumber);
                        }

                        if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                           List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
                              .list(
                                 (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                                .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                                             .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                                          .isNotNull(BimModelCommonDO::getAreaId))
                                       .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                                    .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
                              );
                           Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
                           result = this.artifactService
                              .selectBridgeArtifactByBim(bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), boxSerialNumber);
                        }
                     }

                     if (!Objects.isNull(result)) {
                        List<String> elements = Convert.toList(
                           String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), result.getSerialNumber())
                        );
                        if (CollUtil.isEmpty(elements)) {
                           String requestUnitBody = getUnitSerialNumberListJSON(
                              fileId.toString(),
                              ImmutableList.of(result.getSerialNumber()),
                              bimModelConfigurationDO.getEdition(),
                              bimModelCommonDO.getModelType()
                           );
                           String requestBoxBody = getSerialNumberListJSON(
                              fileId.toString(),
                              ImmutableList.of(result.getSerialNumber()),
                              bimModelConfigurationDO.getEdition(),
                              bimModelCommonDO.getModelType()
                           );
                           List<String> unitElements = this.getElementIds(requestUnitBody);
                           List<String> boxElementsList = this.getElementIds(requestBoxBody);
                           assert unitElements != null;
                           elements.addAll(unitElements);
                           assert boxElementsList != null;
                           elements.addAll(boxElementsList);
                           this.redisUtils.hset("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), result.getSerialNumber(), elements);
                        }

                        result.setUnitElementIds(elements);
                     }
                     break;
                  }
               }
            }
         }
      } catch (BimfaceException e) {
         e.printStackTrace();
      }

      this.setBridgeResult(result, menuBar, bimModelCommonDO.getImportMode());
      return result;
   }

   @Override
   public ListVO getProduction(Long fileId, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "该单体下模型文件不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      List<PlanArea> planAreaList = null;
      List<TechArtifact> techArtifacts = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         techArtifacts = this.techArtifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()));
         planAreaList = this.planAreaService.list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, bimModelCommonDO.getMonomerId()));
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
         techArtifacts = this.techArtifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaId, bimModelCommonDO.getAreaId()));
         planAreaList = this.planAreaService.list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getId, bimModelCommonDO.getAreaId()));
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
         List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
            .list(
               (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                              .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                           .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                        .isNotNull(BimModelCommonDO::getAreaId))
                     .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                  .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
         List<Long> areaList = bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList());
         techArtifacts = this.techArtifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getAreaId, areaList));
         planAreaList = this.planAreaService.listByIds(areaList);
      }

      if (CollectionUtils.isEmpty(techArtifacts)) {
         return null;
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(planAreaList), "该单体下未创建区域");
      Map<Long, List<TechArtifact>> artifactListMap = techArtifacts.stream()
         .collect(Collectors.toMap(TechArtifact::getAreaId, y -> new ArrayList<>(Collections.singleton((TechArtifact)y)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
         }));
      List<BimArtifactProductionVO> list = new ArrayList<>();
      planAreaList.forEach(
         area -> {
            List<TechArtifact> artifacts = artifactListMap.get(area.getId());
            if (!CollectionUtils.isEmpty(artifacts)) {
               BimArtifactProductionVO build = BimArtifactProductionVO.builder()
                  .areaId(area.getId())
                  .areaName(area.getName())
                  .quantity(artifacts.stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity()).sum())
                  .totalGrossWeight(artifacts.stream().map(TechArtifact::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .totalNetWeight(artifacts.stream().map(TechArtifact::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .build();
               List<BimArtifactStatusDetailVO> bimArtifactAsStatus = this.mesBuildingTaskService
                  .getBimArtifactAsStatus(ProductTypeEnum.ARTIFACT.getType(), null, bimModelCommonDO.getMonomerId(), ImmutableList.of(area.getId()), menuBar);
               this.setBimArtifact(bimArtifactAsStatus, build, menuBar);
               list.add(build);
            }
         }
      );
      return new ListVO<>(list);
   }

   @Override
   public ListVO getBridgeProduction(Long fileId, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "该单体下模型文件不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      List<PlanArea> planAreaList = null;
      List<TechArtifact> bridgeTechBoxList = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         bridgeTechBoxList = this.artifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()));
         planAreaList = this.planAreaService.list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getMonomerId, bimModelCommonDO.getMonomerId()));
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
         bridgeTechBoxList = this.artifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaId, bimModelCommonDO.getAreaId()));
         planAreaList = this.planAreaService.list((Wrapper<PlanArea>)new LambdaQueryWrapper<PlanArea>().eq(PlanArea::getId, bimModelCommonDO.getAreaId()));
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
         List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
            .list(
               (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                              .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                           .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                        .isNotNull(BimModelCommonDO::getAreaId))
                     .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                  .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
         List<Long> areaList = bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList());
         bridgeTechBoxList = this.artifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getAreaId, areaList));
         planAreaList = this.planAreaService.listByIds(areaList);
      }

      if (CollectionUtils.isEmpty(bridgeTechBoxList)) {
         return null;
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(planAreaList), "该单体下未创建区域");
      Map<Long, List<TechArtifact>> bridgeTechBoxMap = bridgeTechBoxList.stream()
         .collect(Collectors.toMap(TechArtifact::getAreaId, y -> new ArrayList<>(Collections.singleton((TechArtifact)y)), (oldList, newList) -> {
            oldList.addAll(newList);
            return oldList;
         }));
      List<BimArtifactProductionVO> list = new ArrayList<>();
      planAreaList.forEach(
         area -> {
            List<TechArtifact> artifacts = bridgeTechBoxMap.get(area.getId());
            if (!CollectionUtils.isEmpty(artifacts)) {
               BimArtifactProductionVO build = BimArtifactProductionVO.builder()
                  .areaId(area.getId())
                  .areaName(area.getName())
                  .quantity(artifacts.stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity()).sum())
                  .totalGrossWeight(artifacts.stream().map(TechArtifact::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .totalNetWeight(artifacts.stream().map(TechArtifact::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add))
                  .build();
               List<BimArtifactStatusDetailVO> bimArtifactAsStatus = this.mesBuildingTaskService
                  .getBimArtifactAsStatus(ProductTypeEnum.ARTIFACT.getType(), null, bimModelCommonDO.getMonomerId(), ImmutableList.of(area.getId()), menuBar);
               this.setBimArtifact(bimArtifactAsStatus, build, menuBar);
               list.add(build);
            }
         }
      );
      return new ListVO<>(list);
   }

   @Override
   public BimProductMeteGroupVO getDetailsByStatus(Long fileId, Integer status, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim文件不存在");
      Preconditions.checkArgument(BimStatusEnum.isExist(status), "构件状态不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      BimProductMeteGroupVO meteGroupVO = new BimProductMeteGroupVO();
      List<TechArtifact> techArtifacts = null;
      List<BimArtifactStatusDetailVO> bimArtifactAsStatus = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         techArtifacts = this.techArtifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()));
         if (CollectionUtils.isEmpty(techArtifacts)) {
            return meteGroupVO;
         }

         bimArtifactAsStatus = this.mesBuildingTaskService
            .getBimArtifactAsStatus(ProductTypeEnum.ARTIFACT.getType(), status, bimModelCommonDO.getMonomerId(), null, menuBar);
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
         techArtifacts = this.techArtifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaId, bimModelCommonDO.getAreaId()));
         if (CollectionUtils.isEmpty(techArtifacts)) {
            return meteGroupVO;
         }

         bimArtifactAsStatus = this.mesBuildingTaskService
            .getBimArtifactAsStatus(
               ProductTypeEnum.ARTIFACT.getType(), status, bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), menuBar
            );
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
         List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
            .list(
               (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                              .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                           .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                        .isNotNull(BimModelCommonDO::getAreaId))
                     .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                  .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
         List<Long> areaList = bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList());
         techArtifacts = this.techArtifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getAreaId, areaList));
         if (CollectionUtils.isEmpty(techArtifacts)) {
            return meteGroupVO;
         }

         bimArtifactAsStatus = this.mesBuildingTaskService
            .getBimArtifactAsStatus(ProductTypeEnum.ARTIFACT.getType(), status, bimModelCommonDO.getMonomerId(), areaList, menuBar);
      }

      assert techArtifacts != null;
      Integer sum = techArtifacts.stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity()).sum();
      if (CollectionUtils.isNotEmpty(bimArtifactAsStatus)) {
         meteGroupVO.setQuantity(bimArtifactAsStatus.stream().mapToInt(BimArtifactStatusDetailVO::getQuantity).sum());
         meteGroupVO.setTotalGrossWeight(
            bimArtifactAsStatus.stream().map(BimArtifactStatusDetailVO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         meteGroupVO.setTotalNetWeight(bimArtifactAsStatus.stream().map(BimArtifactStatusDetailVO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         meteGroupVO.setProportion(NumberUtils.scale2Double(Double.parseDouble(meteGroupVO.getQuantity().toString()) / sum.intValue() * 100.0));
         List<BimArtifactStatusDetailVO> collect = bimArtifactAsStatus.stream().filter(e -> e.getQuantity() != 0).collect(Collectors.toList());
         meteGroupVO.setBasicsVOS(collect);
         Set<String> treeSet = new TreeSet<>();
         collect.forEach(
            artifact -> {
               List<String> elementIds = null;
               if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                  && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  elementIds = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), artifact.getSerialNumber()));
               }

               if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                  || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  elementIds = Convert.toList(
                     String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), artifact.getSerialNumber())
                  );
               }

               if (CollectionUtils.isNotEmpty(elementIds)) {
                  treeSet.addAll(elementIds);
               }
            }
         );
         meteGroupVO.setElementIds(treeSet);
      }

      return meteGroupVO;
   }

   @Override
   public BimBridgeProductMeteGroupVO getBridgeDetailsByStatus(Long fileId, Integer status, Integer menuBar) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim文件不存在");
      Preconditions.checkArgument(BimStatusEnum.isExist(status), "构件状态不存在");
      Preconditions.checkArgument(BimMenuBarEnum.isExist(menuBar), "子菜单类型不存在");
      BimBridgeProductMeteGroupVO meteGroupVO = new BimBridgeProductMeteGroupVO();
      List<TechArtifact> bridgeTechBoxList = null;
      List<BimArtifactStatusDetailVO> bimBridgeStatusDetailList = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         bridgeTechBoxList = this.artifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getMonomerId, bimModelCommonDO.getMonomerId()));
         if (CollectionUtils.isEmpty(bridgeTechBoxList)) {
            return meteGroupVO;
         }

         bimBridgeStatusDetailList = this.mesBuildingTaskService
            .getBimArtifactAsStatus(ProductTypeEnum.ARTIFACT.getType(), status, bimModelCommonDO.getMonomerId(), null, menuBar);
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
         bridgeTechBoxList = this.artifactService
            .list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().eq(TechArtifact::getAreaId, bimModelCommonDO.getAreaId()));
         if (CollectionUtils.isEmpty(bridgeTechBoxList)) {
            return meteGroupVO;
         }

         bimBridgeStatusDetailList = this.mesBuildingTaskService
            .getBimArtifactAsStatus(
               ProductTypeEnum.ARTIFACT.getType(), status, bimModelCommonDO.getMonomerId(), ImmutableList.of(bimModelCommonDO.getAreaId()), menuBar
            );
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
         && BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
         List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
            .list(
               (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                              .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                           .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                        .isNotNull(BimModelCommonDO::getAreaId))
                     .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                  .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
            );
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
         List<Long> areaList = bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList());
         bridgeTechBoxList = this.artifactService.list((Wrapper<TechArtifact>)new LambdaQueryWrapper<TechArtifact>().in(TechArtifact::getAreaId, areaList));
         if (CollectionUtils.isEmpty(bridgeTechBoxList)) {
            return meteGroupVO;
         }

         bimBridgeStatusDetailList = this.mesBuildingTaskService
            .getBimArtifactAsStatus(ProductTypeEnum.ARTIFACT.getType(), status, bimModelCommonDO.getMonomerId(), areaList, menuBar);
      }

      assert bridgeTechBoxList != null;
      Integer sum = bridgeTechBoxList.stream().mapToInt(a -> a.getQuantity() == null ? 0 : a.getQuantity()).sum();
      if (CollectionUtils.isNotEmpty(bimBridgeStatusDetailList)) {
         meteGroupVO.setQuantity(bimBridgeStatusDetailList.stream().mapToInt(BimArtifactStatusDetailVO::getQuantity).sum());
         meteGroupVO.setTotalGrossWeight(
            bimBridgeStatusDetailList.stream().map(BimArtifactStatusDetailVO::getTotalGrossWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         meteGroupVO.setTotalNetWeight(
            bimBridgeStatusDetailList.stream().map(BimArtifactStatusDetailVO::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         meteGroupVO.setProportion(NumberUtils.scale2Double(Double.parseDouble(meteGroupVO.getQuantity().toString()) / sum.intValue() * 100.0));
         bimBridgeStatusDetailList.forEach(
            item -> item.setProductWeldCount(
               this.techCappCraftProductPassTaskRecordBiz
                  .productWeldCount(
                     CappCraftCardProductWeldCountDTO.builder()
                        .productId(item.getId())
                        .areaId(bimModelCommonDO.getAreaId())
                        .monomerId(bimModelCommonDO.getMonomerId())
                        .build()
                  )
            )
         );
         List<BimArtifactStatusDetailVO> collect = bimBridgeStatusDetailList.stream().filter(e -> e.getQuantity() != 0).collect(Collectors.toList());
         meteGroupVO.setBasicsVOS(collect);
         Set<String> treeSet = new TreeSet<>();
         collect.forEach(
            artifact -> {
               List<String> elementIds = null;
               if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
                  && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  elementIds = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), artifact.getSerialNumber()));
               }

               if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
                  || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
                  elementIds = Convert.toList(
                     String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), artifact.getSerialNumber())
                  );
               }

               if (CollectionUtils.isNotEmpty(elementIds)) {
                  treeSet.addAll(elementIds);
               }
            }
         );
         meteGroupVO.setElementIds(treeSet);
      }

      return meteGroupVO;
   }

   @Override
   public ListVO getLogisticsByBim(Long fileId) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      List<BimLogisticsVO> artifactLogisticsByBim = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         artifactLogisticsByBim = this.mesBuildingCargoListService
            .getArtifactLogisticsByBim(
               bimModelCommonDO.getProjectId(),
               bimModelCommonDO.getMonomerId(),
               null,
               ProductTypeEnum.ARTIFACT.getType(),
               CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType()
            );
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            artifactLogisticsByBim = this.mesBuildingCargoListService
               .getArtifactLogisticsByBim(
                  bimModelCommonDO.getProjectId(),
                  bimModelCommonDO.getMonomerId(),
                  ImmutableList.of(bimModelCommonDO.getAreaId()),
                  ProductTypeEnum.ARTIFACT.getType(),
                  CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType()
               );
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                 .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                              .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                           .isNotNull(BimModelCommonDO::getAreaId))
                        .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
            artifactLogisticsByBim = this.mesBuildingCargoListService
               .getArtifactLogisticsByBim(
                  bimModelCommonDO.getProjectId(),
                  bimModelCommonDO.getMonomerId(),
                  bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList()),
                  ProductTypeEnum.ARTIFACT.getType(),
                  CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType()
               );
         }
      }

      assert artifactLogisticsByBim != null;
      List<BimLogisticsVO> collect = artifactLogisticsByBim.stream()
         .filter(e -> CollectionUtils.isNotEmpty(e.getBimLogisticsLinkVOList()))
         .collect(Collectors.toList());

      for (BimLogisticsVO bimLogisticsVO : collect) {
         Set<String> treeSet = new TreeSet<>();

         for (BimLogisticsLinkVO linkVO : bimLogisticsVO.getBimLogisticsLinkVOList()) {
            List<String> elementIds = null;
            if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
               && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
               elementIds = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), linkVO.getSerialNumber()));
            }

            if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
               || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
               elementIds = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), linkVO.getSerialNumber()));
            }

            if (CollectionUtils.isNotEmpty(elementIds)) {
               treeSet.addAll(elementIds);
            }
         }

         bimLogisticsVO.setElementIds(treeSet);
      }

      return new ListVO<>(collect);
   }

   @Override
   public ListVO getBridgeLogisticsByBim(Long fileId) {
      BimModelCommonDO bimModelCommonDO = this.bimModelCommonService
         .getOne((Wrapper<BimModelCommonDO>)new LambdaQueryWrapper<BimModelCommonDO>().eq(BimModelCommonDO::getFileId, fileId));
      Preconditions.checkArgument(bimModelCommonDO != null, "bim模型不存在");
      List<BimLogisticsVO> artifactLogisticsByBim = null;
      if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         artifactLogisticsByBim = this.mesBuildingCargoListService
            .getArtifactLogisticsByBim(
               bimModelCommonDO.getProjectId(),
               bimModelCommonDO.getMonomerId(),
               null,
               ProductTypeEnum.ARTIFACT.getType(),
               CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType()
            );
      }

      if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())) {
         if (BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
            artifactLogisticsByBim = this.mesBuildingCargoListService
               .getArtifactLogisticsByBim(
                  bimModelCommonDO.getProjectId(),
                  bimModelCommonDO.getMonomerId(),
                  ImmutableList.of(bimModelCommonDO.getAreaId()),
                  ProductTypeEnum.ARTIFACT.getType(),
                  CargoListStatusEnum.SHIPMENT.getType() | CargoListStatusEnum.RECEIPT.getType()
               );
         }

         if (BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
            List<BimModelCommonDO> bimModelCommonDOS = this.bimModelCommonService
               .list(
                  (Wrapper<BimModelCommonDO>)((((new LambdaQueryWrapper<BimModelCommonDO>()
                                 .eq(BimModelCommonDO::getMonomerId, bimModelCommonDO.getMonomerId()))
                              .eq(BimModelCommonDO::getImportMode, bimModelCommonDO.getImportMode()))
                           .isNotNull(BimModelCommonDO::getAreaId))
                        .eq(BimModelCommonDO::getModelType, BimModelTypeEnum.FILETYPE.getName()))
                     .eq(BimModelCommonDO::getIntegrationStatus, BimStatusIntegrationEnum.SUCCESS.getName())
               );
            Preconditions.checkArgument(CollectionUtils.isNotEmpty(bimModelCommonDOS), "模型未集成成功");
            artifactLogisticsByBim = this.mesBuildingCargoListService
               .getArtifactLogisticsByBim(
                  bimModelCommonDO.getProjectId(),
                  bimModelCommonDO.getMonomerId(),
                  bimModelCommonDOS.stream().map(BimModelCommonDO::getAreaId).collect(Collectors.toList()),
                  ProductTypeEnum.ARTIFACT.getType(),
                  CargoListStatusEnum.SHIPMENT.getType()
               );
         }
      }

      assert artifactLogisticsByBim != null;
      List<BimLogisticsVO> collect = artifactLogisticsByBim.stream()
         .filter(e -> CollectionUtils.isNotEmpty(e.getBimLogisticsLinkVOList()))
         .collect(Collectors.toList());

      for (BimLogisticsVO bimLogisticsVO : collect) {
         Set<String> treeSet = new TreeSet<>();

         for (BimLogisticsLinkVO linkVO : bimLogisticsVO.getBimLogisticsLinkVOList()) {
            List<String> elementIds = null;
            if (BimImportModeEnum.INTEGRATION_MODE.getType().equals(bimModelCommonDO.getImportMode())
               && BimModelTypeEnum.FILETYPE.getName().equals(bimModelCommonDO.getModelType())) {
               elementIds = Convert.toList(String.class, this.redisUtils.hget("AREA_MODEL:" + bimModelCommonDO.getAreaId(), linkVO.getSerialNumber()));
            }

            if (BimImportModeEnum.MONOMER_MODE.getType().equals(bimModelCommonDO.getImportMode())
               || BimModelTypeEnum.INTEGRATIONTYPE.getName().equals(bimModelCommonDO.getModelType())) {
               elementIds = Convert.toList(String.class, this.redisUtils.hget("MONOMER_MODEL:" + bimModelCommonDO.getMonomerId(), linkVO.getSerialNumber()));
            }

            if (CollectionUtils.isNotEmpty(elementIds)) {
               treeSet.addAll(elementIds);
            }
         }

         bimLogisticsVO.setElementIds(treeSet);
      }

      return new ListVO<>(collect);
   }

   private void setBimArtifact(List<BimArtifactStatusDetailVO> bimArtifactAsStatus, BimArtifactProductionVO build, Integer menuBar) {
      if (CollectionUtils.isNotEmpty(bimArtifactAsStatus)) {
         build.setStorageQuantity(bimArtifactAsStatus.stream().mapToInt(BimArtifactStatusDetailVO::getCompleteQuantity).sum());
         build.setStorageTotalGrossWeight(
            bimArtifactAsStatus.stream()
               .map(e -> e.getGrossWeight().multiply(new BigDecimal(e.getCompleteQuantity())))
               .reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         build.setStorageTotalNetWeight(
            bimArtifactAsStatus.stream().map(e -> e.getNetWeight().multiply(new BigDecimal(e.getCompleteQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add)
         );
         if (BimMenuBarEnum.PRODUCTION_STATE.getType().equals(menuBar)) {
            build.setProducedQuantity(bimArtifactAsStatus.stream().mapToInt(e -> e.getInProductionQuantity() - e.getCompleteQuantity()).sum());
            build.setProducedTotalGrossWeight(
               bimArtifactAsStatus.stream()
                  .map(e -> e.getGrossWeight().multiply(new BigDecimal(e.getInProductionQuantity() - e.getCompleteQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            build.setProducedTotalNetWeight(
               bimArtifactAsStatus.stream()
                  .map(e -> e.getNetWeight().multiply(new BigDecimal(e.getInProductionQuantity() - e.getCompleteQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            build.setUnProducedQuantity(build.getQuantity() - build.getStorageQuantity() - build.getProducedQuantity());
            build.setUnProducedTotalGrossWeight(
               build.getTotalGrossWeight().subtract(build.getProducedTotalGrossWeight()).subtract(build.getStorageTotalGrossWeight())
            );
            build.setUnProducedTotalNetWeight(build.getTotalNetWeight().subtract(build.getProducedTotalNetWeight()).subtract(build.getStorageTotalNetWeight()));
         }

         if (BimMenuBarEnum.SHIPMENT_STATUS.getType().equals(menuBar)) {
            build.setProducedQuantity(bimArtifactAsStatus.stream().mapToInt(BimArtifactStatusDetailVO::getInProductionQuantity).sum());
            build.setProducedTotalGrossWeight(
               bimArtifactAsStatus.stream()
                  .map(e -> e.getGrossWeight().multiply(new BigDecimal(e.getInProductionQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            build.setProducedTotalNetWeight(
               bimArtifactAsStatus.stream()
                  .map(e -> e.getNetWeight().multiply(new BigDecimal(e.getInProductionQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            build.setUnProducedQuantity(build.getQuantity() - build.getStorageQuantity());
            build.setUnProducedTotalGrossWeight(build.getTotalGrossWeight().subtract(build.getStorageTotalGrossWeight()));
            build.setUnProducedTotalNetWeight(build.getTotalNetWeight().subtract(build.getStorageTotalNetWeight()));
         }

         if (BimMenuBarEnum.INSTALLATION_CONDITION.getType().equals(menuBar)) {
            build.setUnProducedQuantity(build.getQuantity() - build.getStorageQuantity());
            build.setUnProducedTotalGrossWeight(build.getTotalGrossWeight().subtract(build.getStorageTotalGrossWeight()));
            build.setUnProducedTotalNetWeight(build.getTotalNetWeight().subtract(build.getStorageTotalNetWeight()));
            build.setProducedQuantity(bimArtifactAsStatus.stream().mapToInt(BimArtifactStatusDetailVO::getInProductionQuantity).sum());
            build.setProducedTotalGrossWeight(
               bimArtifactAsStatus.stream()
                  .map(e -> e.getGrossWeight().multiply(new BigDecimal(e.getInProductionQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
            build.setProducedTotalNetWeight(
               bimArtifactAsStatus.stream()
                  .map(e -> e.getNetWeight().multiply(new BigDecimal(e.getInProductionQuantity())))
                  .reduce(BigDecimal.ZERO, BigDecimal::add)
            );
         }
      }
   }

   private void setResult(BimArtifactVO result, Integer menuBar, Integer importMode) {
      if (result != null) {
         if (BimMenuBarEnum.COMPONENT_TREE.getType().equals(menuBar)) {
            List<TechMachinePartDTO> techMachinePartDTOS = this.techMachinePartService.listMachinePartByArtifact(result.getId());
            result.setTechMachinePartDTOS(techMachinePartDTOS);
            List<TechDrawing> techDrawings = this.techDrawingService
               .list(
                  (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                              .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                           .eq(TechDrawing::getProductType, DrawingProductTypeEnum.ARTIFACT.getType()))
                        .eq(TechDrawing::getSerialNumber, result.getSerialNumber()))
                     .eq(TechDrawing::getMonomerId, result.getMonomerId())
               );
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               result.setNumbers(techDrawings.stream().map(TechDrawing::getNumber).collect(Collectors.toList()));
               result.setDrawingAndSerialNumber(
                  techDrawings.stream().map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }
         }

         if (BimMenuBarEnum.PRODUCTION_STATE.getType().equals(menuBar)) {
            List<MesBuildingTask> mesBuildingTask = this.mesBuildingTaskService
               .list(
                  (Wrapper<MesBuildingTask>)((new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, ProductTypeEnum.ARTIFACT.getType()))
                        .eq(MesBuildingTask::getProductId, result.getId()))
                     .eq(MesBuildingTask::getMonomerId, result.getMonomerId())
               );
            if (CollectionUtils.isNotEmpty(mesBuildingTask)) {
               result.setCompleteQuantity(mesBuildingTask.stream().mapToInt(MesBuildingTask::getCompleteQuantity).sum());
               result.setInProductionQuantity(mesBuildingTask.stream().mapToInt(a -> a.getInProductionQuantity() - a.getCompleteQuantity()).sum());
            }

            if (BimImportModeEnum.MONOMER_MODE.getType().equals(importMode)) {
               List<BimSummaryDetailsVO> summaryByIdAndType = this.taskService
                  .getSummaryBySerialNumberAndType(result.getSerialNumber(), result.getMonomerId(), ProductTypeEnum.ARTIFACT.getType())
                  .stream()
                  .map(e -> BeanUtil.copy(e, BimSummaryDetailsVO.class))
                  .collect(Collectors.toList());
               result.setProcessSummaryDetailsList(summaryByIdAndType);
            } else {
               List<BimSummaryDetailsVO> summaryByIdAndType = this.taskService
                  .getSummaryByIdAndType(result.getId(), ProductTypeEnum.ARTIFACT.getType())
                  .stream()
                  .map(e -> BeanUtil.copy(e, BimSummaryDetailsVO.class))
                  .collect(Collectors.toList());
               result.setProcessSummaryDetailsList(summaryByIdAndType);
            }
         }

         if (result.getSurfaceArea() != null) {
            result.setSurfaceArea(result.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
         }
      }
   }

   private void setBridgeResult(BimBoxOrElementsVO result, Integer menuBar, Integer importMode) {
      if (result != null) {
         if (BimMenuBarEnum.COMPONENT_TREE.getType().equals(menuBar)) {
            List<BridgeElementPartDTO> techMachinePartDTOS = this.assembleService.listMachinePartByArtifact(result.getId());
            result.setTechMachinePartDTOS(techMachinePartDTOS);
            List<TechDrawing> techDrawings = this.techDrawingService
               .list(
                  (Wrapper<TechDrawing>)(((new LambdaQueryWrapper<TechDrawing>()
                              .eq(TechDrawing::getDataType, TechDataTypeEnum.DEEPEN.getType()))
                           .eq(TechDrawing::getProductType, result.getProductType()))
                        .eq(TechDrawing::getSerialNumber, result.getSerialNumber()))
                     .eq(TechDrawing::getMonomerId, result.getMonomerId())
               );
            if (CollectionUtils.isNotEmpty(techDrawings)) {
               result.setDrawingAndSerialNumber(
                  techDrawings.stream().map(drawing -> BeanUtil.copy(drawing, DrawingAndSerialNumberDTO.class)).collect(Collectors.toList())
               );
            }
         }

         if (BimMenuBarEnum.PRODUCTION_STATE.getType().equals(menuBar)) {
            List<MesBuildingTask> mesBuildingTask = this.taskService
               .list(
                  (Wrapper<MesBuildingTask>)((new LambdaQueryWrapper<MesBuildingTask>()
                           .eq(MesBuildingTask::getTaskTypeEnum, result.getProductType()))
                        .eq(MesBuildingTask::getProductId, result.getId()))
                     .eq(MesBuildingTask::getMonomerId, result.getMonomerId())
               );
            if (CollectionUtils.isNotEmpty(mesBuildingTask)) {
               result.setCompleteQuantity(mesBuildingTask.stream().mapToInt(MesBuildingTask::getCompleteQuantity).sum());
               result.setInProductionQuantity(mesBuildingTask.stream().mapToInt(a -> a.getInProductionQuantity() - a.getCompleteQuantity()).sum());
            }

            if (BimImportModeEnum.MONOMER_MODE.getType().equals(importMode)) {
               List<BimSummaryDetailsVO> summaryByIdAndType = this.taskService
                  .getSummaryBySerialNumberAndType(result.getSerialNumber(), result.getMonomerId(), result.getProductType())
                  .stream()
                  .map(e -> BeanUtil.copy(e, BimSummaryDetailsVO.class))
                  .collect(Collectors.toList());
               result.setProcessSummaryDetailsList(summaryByIdAndType);
            } else {
               List<BimSummaryDetailsVO> summaryByIdAndType = this.taskService
                  .getSummaryByIdAndType(result.getId(), result.getProductType())
                  .stream()
                  .map(e -> BeanUtil.copy(e, BimSummaryDetailsVO.class))
                  .collect(Collectors.toList());
               result.setProcessSummaryDetailsList(summaryByIdAndType);
            }
         }

         if (result.getSurfaceArea() != null) {
            result.setSurfaceArea(result.getSurfaceArea().divide(BigDecimal.valueOf(1000000L), 2, RoundingMode.HALF_UP));
         }
      }
   }

   private static String getUnitSerialNumberListJSON(String targetIds, List<String> serialNumberList, Integer edition, String targetType) {
      if (BimTeklaEditionEnum.SEVENTEEN.getType() >= edition) {
         serialNumberList = serialNumberList.stream().map(e -> "{ \"match\" : {\"Assembly_top\" : \"" + e + "\"}}").collect(Collectors.toList());
      } else {
         serialNumberList = serialNumberList.stream().map(e -> "{ \"match\" : {\"Assembly top\" : \"" + e + "\"}}").collect(Collectors.toList());
      }

      return serialNumberList.size() == 1
         ? "{\"targetType\":\"" + targetType + "\",\"targetIds\":[\"" + targetIds + "\"],\"query\":" + String.join(",", serialNumberList) + "}"
         : "{\"targetType\":\"" + targetType + "\",\"targetIds\":[\"" + targetIds + "\"],\"query\":{\"boolOr\":[" + String.join(",", serialNumberList) + "]}}";
   }

   private static String getSerialNumberListJSON(String targetIds, List<String> serialNumberList, Integer edition, String targetType) {
      JSONArray jsonArray = new JSONArray();
      jsonArray.addAll(serialNumberList);
      String jsonString = jsonArray.toJSONString();
      String result;
      if (BimTeklaEditionEnum.SEVENTEEN.getType() >= edition) {
         result = "{ \"in\" : {\"Assembly_mark\":" + jsonString + "}}";
      } else {
         result = "{ \"in\" : {\"Assembly mark\":" + jsonString + "}}";
      }

      return "{\"targetType\":\"" + targetType + "\",\"targetIds\":[\"" + targetIds + "\"],\"query\":" + result + "}";
   }

   private static String getOldSerialNumberListJSON(String targetIds, List<String> serialNumberList, Integer edition, String targetType) {
      if (BimTeklaEditionEnum.SEVENTEEN.getType() >= edition) {
         serialNumberList = serialNumberList.stream().map(e -> "{ \"match\" : {\"Assembly_mark\" : \"" + e + "\"}}").collect(Collectors.toList());
      } else {
         serialNumberList = serialNumberList.stream().map(e -> "{ \"match\" : {\"Assembly mark\" : \"" + e + "\"}}").collect(Collectors.toList());
      }

      return serialNumberList.size() == 1
         ? "{\"targetType\":\"" + targetType + "\",\"targetIds\":[\"" + targetIds + "\"],\"query\":" + String.join(",", serialNumberList) + "}"
         : "{\"targetType\":\"" + targetType + "\",\"targetIds\":[\"" + targetIds + "\"],\"query\":{\"boolOr\":[" + String.join(",", serialNumberList) + "]}}";
   }

   private void setNoListByMenuBar(Integer menuBar, List<String> elementIdsV2, Map<String, List<String>> responseVOMap) {
      if (BimMenuBarEnum.COMPONENT_TREE.getType().equals(menuBar)) {
         List<String> isList = responseVOMap.get(BimStatusEnum.IS_LIST.getType().toString());
         if (CollectionUtils.isNotEmpty(isList)) {
            LinkedList<String> result = new LinkedList<>(elementIdsV2);
            HashSet<String> othHash = new HashSet<>(isList);
            result.removeIf(othHash::contains);
         }

         responseVOMap.put(BimStatusEnum.NO_LIST.getType().toString(), elementIdsV2);
      }
   }
}
