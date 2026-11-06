package com.hzchum.scim.plan.core.biz.impl;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardStorehouseCraftparameterPassLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductPassTaskRecordBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductWeldTaskBiz;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductWelding;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouse;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseCraftParameterPassLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductPassTask;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductPassTaskRecord;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductWeldTask;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductCodeNumberListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductWeldCountDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardBimVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardPassVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductBimVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductCodeNumberVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductCurrentVoltageVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardWeldingGatherVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardWeldingVO;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardProductWeldingService;
import com.hzchum.scim.plan.core.api.service.TechCappCraftProductPassTaskRecordService;
import com.hzchum.scim.plan.core.api.service.TechCappCraftProductPassTaskService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftProductPassTaskRecordMapper;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import jodd.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechCappCraftProductPassTaskRecordBizImpl
   extends IBizImpl<TechCappCraftProductPassTaskRecordService, TechCappCraftProductPassTaskRecordMapper, TechCappCraftProductPassTaskRecord>
   implements TechCappCraftProductPassTaskRecordBiz {
   @Resource
   private TechCappCraftCardProductLinkBiz techCappCraftCardProductLinkBiz;
   @Resource
   private TechCappCraftCardProductWeldingService techCappCraftCardProductWeldingService;
   @Resource
   private TechArtifactService techArtifactService;
   @Resource
   private TechAssembleService techAssembleService;
   @Resource
   private TechArtifactExtService techArtifactExtService;
   @Resource
   private TechAssembleExtService techAssembleExtService;
   @Resource
   private TechCappCraftCardStorehouseBiz techCappCraftCardStorehouseBiz;
   @Resource
   private TechCappCraftCardStorehouseCraftparameterPassLinkBiz techCappCraftCardStorehouseCraftparameterPassLinkBiz;
   @Resource
   private TechCappCraftProductPassTaskService techCappCraftProductPassTaskService;
   @Resource
   private TechCappCraftProductTaskBiz techCappCraftProductTaskBiz;
   @Resource
   private TechCappCraftProductWeldTaskBiz techCappCraftProductWeldTaskBiz;
   @Resource
   private PlanMonomerService planMonomerService;
   @Resource
   private PlanAreaService planAreaService;

   @Override
   public Integer productWeldCount(CappCraftCardProductWeldCountDTO dto) {
      Integer count = 0;
      TechArtifact techArtifact = this.techArtifactService.getById(dto.getProductId());
      if (techArtifact == null) {
         return count;
      }

      List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldings = this.techCappCraftCardProductWeldingService
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class)
               .eq(TechCappCraftCardProductWelding::getProjectId, techArtifact.getProjectId())
               .eq(TechCappCraftCardProductWelding::getSerialNumber, techArtifact.getSerialNumber())
               .eq(TechCappCraftCardProductWelding::getProductType, ProductTypeEnum.ARTIFACT.getType())
               .eq(TechCappCraftCardProductWelding::getMonomerId, dto.getMonomerId())
         );
      return CollectionUtils.isEmpty(techCappCraftCardProductWeldings) ? count : techArtifact.getQuantity() * techCappCraftCardProductWeldings.size();
   }

   @Override
   public List<CappCraftCardProductVO> productList(CappCraftCardProductListDTO dto) {
      List<CappCraftCardProductVO> list = new ArrayList<>();
      if (dto.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<TechArtifact> techArtifacts = this.techArtifactService
            .list(
               Wrappers.lambdaQuery(TechArtifact.class)
                  .eq(TechArtifact::getAreaId, dto.getAreaId())
                  .eq(TechArtifact::getMonomerId, dto.getMonomerId())
                  .eq(TechArtifact::getProjectId, dto.getProjectId())
                  .like(dto.getProductSerialNumber() != null, TechArtifact::getSerialNumber, dto.getProductSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(techArtifacts)) {
            techArtifacts.forEach(
               item -> list.add(
                  CappCraftCardProductVO.builder()
                     .productId(item.getId())
                     .productType(ProductTypeEnum.ARTIFACT.getType())
                     .productSerialNumber(item.getSerialNumber())
                     .build()
               )
            );
         }
      } else if (dto.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
         List<TechAssemble> techAssembles = this.techAssembleService
            .list(
               Wrappers.lambdaQuery(TechAssemble.class)
                  .eq(TechAssemble::getAreaId, dto.getAreaId())
                  .eq(TechAssemble::getMonomerId, dto.getMonomerId())
                  .eq(TechAssemble::getProjectId, dto.getProjectId())
                  .like(dto.getProductSerialNumber() != null, TechAssemble::getSerialNumber, dto.getProductSerialNumber())
            );
         if (CollectionUtils.isNotEmpty(techAssembles)) {
            techAssembles.forEach(
               item -> list.add(
                  CappCraftCardProductVO.builder()
                     .productType(ProductTypeEnum.ASSEMBLE.getType())
                     .productId(item.getId())
                     .productSerialNumber(item.getSerialNumber())
                     .build()
               )
            );
         }
      }

      return list;
   }

   @Override
   public List<CappCraftCardProductCodeNumberVO> productCodeNumberList(CappCraftCardProductCodeNumberListDTO dto) {
      List<CappCraftCardProductCodeNumberVO> cappCraftCardProductCodeNumberVOS = new ArrayList<>();
      if (dto.getProductType().equals(ProductTypeEnum.ARTIFACT.getType())) {
         List<TechArtifactExt> techArtifactExts = this.techArtifactExtService
            .list(Wrappers.lambdaQuery(TechArtifactExt.class).eq(TechArtifactExt::getArtifactId, dto.getProductId()));
         if (CollectionUtils.isNotEmpty(techArtifactExts)) {
            techArtifactExts.forEach(
               item -> cappCraftCardProductCodeNumberVOS.add(
                  CappCraftCardProductCodeNumberVO.builder().id(item.getId()).productId(item.getArtifactId()).productCodeNumber(item.getSortNumber()).build()
               )
            );
         }
      } else if (dto.getProductType().equals(ProductTypeEnum.ASSEMBLE.getType())) {
         List<TechAssembleExt> techAssembleExtList = this.techAssembleExtService
            .list(Wrappers.lambdaQuery(TechAssembleExt.class).eq(TechAssembleExt::getAssembleId, dto.getProductId()));
         if (CollectionUtils.isNotEmpty(techAssembleExtList)) {
            techAssembleExtList.forEach(
               item -> cappCraftCardProductCodeNumberVOS.add(
                  CappCraftCardProductCodeNumberVO.builder().id(item.getId()).productId(item.getAssembleId()).productCodeNumber(item.getSortNumber()).build()
               )
            );
         }
      }

      return cappCraftCardProductCodeNumberVOS;
   }

   @Override
   public List<CappCraftCardProductCurrentVoltageVO> productCurrentVoltageList(Long passId) {
      List<CappCraftCardProductCurrentVoltageVO> cappCraftCardProductCurrentVoltageVOS = new ArrayList<>();
      List<TechCappCraftProductPassTaskRecord> techCappCraftProductPassTaskRecords = this.baseService
         .list(
            Wrappers.lambdaQuery(TechCappCraftProductPassTaskRecord.class)
               .eq(TechCappCraftProductPassTaskRecord::getTechCappCraftProductPassTaskId, passId)
               .orderByAsc(BaseEntity::getCreateTime)
         );
      if (CollectionUtils.isNotEmpty(techCappCraftProductPassTaskRecords)) {
         techCappCraftProductPassTaskRecords.forEach(
            item -> cappCraftCardProductCurrentVoltageVOS.add(
               CappCraftCardProductCurrentVoltageVO.builder()
                  .id(item.getId())
                  .createTime(item.getCreateTime())
                  .voltage(item.getVoltage())
                  .electricity(item.getElectricity())
                  .build()
            )
         );
      }

      return cappCraftCardProductCurrentVoltageVOS;
   }

   @Override
   public CappCraftCardBimVO productBimList(CappCraftCardProductListDTO dto) {
      PlanMonomer planMonomer = this.planMonomerService.getById(dto.getMonomerId());
      Preconditions.checkArgument(planMonomer != null, "单体不存在");
      PlanArea planArea = this.planAreaService.getById(dto.getAreaId());
      Preconditions.checkArgument(planArea != null, "区域不存在");
      CappCraftCardBimVO craftCardBimVO = new CappCraftCardBimVO();
      craftCardBimVO.setMonomerId(planMonomer.getId());
      craftCardBimVO.setMonomerName(planMonomer.getName());
      craftCardBimVO.setAreaId(planArea.getId());
      craftCardBimVO.setAreaName(planArea.getName());
      List<TechArtifact> techArtifacts = this.techArtifactService
         .list(
            Wrappers.lambdaQuery(TechArtifact.class)
               .eq(TechArtifact::getProjectId, dto.getProjectId())
               .eq(TechArtifact::getMonomerId, dto.getMonomerId())
               .eq(TechArtifact::getAreaId, dto.getAreaId())
         );
      if (CollectionUtils.isNotEmpty(techArtifacts)) {
         craftCardBimVO.setProductCount(techArtifacts.stream().mapToInt(TechArtifact::getQuantity).sum());
         craftCardBimVO.setProductNetWeight(techArtifacts.stream().map(TechArtifact::getTotalNetWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
         List<CappCraftCardProductBimVO> cappCraftCardProductBimVOList = new ArrayList<>();
         Map<String, List<TechCappCraftCardProductWelding>> map = this.techCappCraftCardProductWeldingService
            .list(
               Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class)
                  .eq(TechCappCraftCardProductWelding::getProjectId, dto.getProjectId())
                  .eq(TechCappCraftCardProductWelding::getProductType, ProductTypeEnum.ARTIFACT.getType())
                  .eq(TechCappCraftCardProductWelding::getMonomerId, dto.getMonomerId())
            )
            .stream()
            .collect(Collectors.groupingBy(TechCappCraftCardProductWelding::getSerialNumber));
         techArtifacts.forEach(
            item -> {
               if (CollectionUtils.isNotEmpty(map)) {
                  List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldings = map.get(item.getSerialNumber());
                  if (CollectionUtils.isNotEmpty(techCappCraftCardProductWeldings)) {
                     cappCraftCardProductBimVOList.add(
                        CappCraftCardProductBimVO.builder()
                           .productId(item.getId())
                           .productSerialNumber(item.getSerialNumber())
                           .productCount(item.getQuantity())
                           .productNetWeight(item.getTotalNetWeight())
                           .productWeldCount(techCappCraftCardProductWeldings.size() * item.getQuantity())
                           .build()
                     );
                  }
               }
            }
         );
         craftCardBimVO.setCappCraftCardProductBimVOList(cappCraftCardProductBimVOList);
      }

      return craftCardBimVO;
   }

   @Override
   public PageVO<CappCraftCardWeldingGatherVO> weldingGatherList(CappCraftCardWeldingGatherListDTO dto) {
      Page<Object> objects = PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
      List<CappCraftCardWeldingGatherVO> cappCraftCardWeldingGatherVOList = this.baseMapper.weldingGatherList(dto);
      if (CollectionUtils.isEmpty(cappCraftCardWeldingGatherVOList)) {
         return new PageVO<>();
      }

      Map<Long, List<TechCappCraftProductPassTaskRecord>> records = this.baseService
         .list(
            Wrappers.lambdaQuery(TechCappCraftProductPassTaskRecord.class)
               .in(
                  TechCappCraftProductPassTaskRecord::getTechCappCraftProductPassTaskId,
                  cappCraftCardWeldingGatherVOList.stream().map(CappCraftCardWeldingGatherVO::getPassId).collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.groupingBy(TechCappCraftProductPassTaskRecord::getTechCappCraftProductPassTaskId));
      cappCraftCardWeldingGatherVOList.forEach(
         item -> {
            List<TechCappCraftProductPassTaskRecord> techCappCraftProductPassTaskRecords = records.get(item.getPassId());
            if (CollectionUtils.isNotEmpty(techCappCraftProductPassTaskRecords)) {
               BigDecimal maxVoltage = techCappCraftProductPassTaskRecords.stream()
                  .map(TechCappCraftProductPassTaskRecord::getVoltage)
                  .max(BigDecimal::compareTo)
                  .orElse(BigDecimal.ZERO);
               BigDecimal minVoltage = techCappCraftProductPassTaskRecords.stream()
                  .map(TechCappCraftProductPassTaskRecord::getVoltage)
                  .min(BigDecimal::compareTo)
                  .orElse(BigDecimal.ZERO);
               item.setActualVoltage(NumberUtil.toStr(minVoltage) + "~" + NumberUtil.toStr(maxVoltage));
               BigDecimal maxElectricity = techCappCraftProductPassTaskRecords.stream()
                  .map(TechCappCraftProductPassTaskRecord::getElectricity)
                  .max(BigDecimal::compareTo)
                  .orElse(BigDecimal.ZERO);
               BigDecimal minElectricity = techCappCraftProductPassTaskRecords.stream()
                  .map(TechCappCraftProductPassTaskRecord::getElectricity)
                  .min(BigDecimal::compareTo)
                  .orElse(BigDecimal.ZERO);
               item.setActualElectricity(NumberUtil.toStr(minElectricity) + "~" + NumberUtil.toStr(maxElectricity));
            }

            if (item.getStartTime() != null && item.getEndTime() != null) {
               Duration duration = Duration.between(item.getStartTime(), item.getEndTime());
               long hours = duration.toHours();
               long minutes = duration.toMinutes() % 60L;
               item.setActualTime(String.format("%d:%02d", hours, minutes));
            }
         }
      );
      return new PageVO<>(objects, cappCraftCardWeldingGatherVOList);
   }

   @Override
   public List<CappCraftCardProductCurrentVoltageVO> weldingGatherDetail(CappCraftCardWeldingGatherDetailDTO dto) {
      BigDecimal ratedMinElectricity = null;
      BigDecimal ratedMaxElectricity = null;
      BigDecimal ratedMinVoltage = null;
      BigDecimal ratedMaxVoltage = null;
      if (dto.getIsWithinTheRatedRange() != null) {
         Preconditions.checkArgument(StringUtil.isNotBlank(dto.getRatedVoltage()), "额定电压不能为空");
         Preconditions.checkArgument(StringUtil.isNotBlank(dto.getRatedElectricity()), "额定电流不能为空");
         String[] electricityArray = dto.getRatedElectricity().split("~");
         Preconditions.checkArgument(electricityArray.length == 2, "电流格式错误!!!");
         ratedMinElectricity = new BigDecimal(electricityArray[0]);
         ratedMaxElectricity = new BigDecimal(electricityArray[1]);
         String[] voltageArray = dto.getRatedVoltage().split("~");
         Preconditions.checkArgument(voltageArray.length == 2, "电压格式错误!!!");
         ratedMinVoltage = new BigDecimal(voltageArray[0]);
         ratedMaxVoltage = new BigDecimal(voltageArray[1]);
      }

      return this.baseMapper
         .weldingGatherDetail(dto.getPassId(), dto.getIsWithinTheRatedRange(), ratedMinElectricity, ratedMaxElectricity, ratedMinVoltage, ratedMaxVoltage);
   }

   @Transactional
   @Override
   public Boolean weldingGatherUpdate(List<CappCraftCardWeldingGatherUpdateDTO> dto) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(dto), "需修改的数据不能为空!!");
      Map<Long, TechCappCraftProductPassTaskRecord> taskRecordMap = this.baseService
         .list(
            Wrappers.lambdaQuery(TechCappCraftProductPassTaskRecord.class)
               .in(TechCappCraftProductPassTaskRecord::getId, dto.stream().map(CappCraftCardWeldingGatherUpdateDTO::getId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.toMap(TechCappCraftProductPassTaskRecord::getId, Function.identity()));
      List<TechCappCraftProductPassTaskRecord> updateList = new ArrayList<>();
      dto.forEach(item -> {
         TechCappCraftProductPassTaskRecord techCappCraftProductPassTaskRecord = taskRecordMap.get(item.getId());
         techCappCraftProductPassTaskRecord.setElectricity(item.getElectricity());
         techCappCraftProductPassTaskRecord.setVoltage(item.getVoltage());
         updateList.add(techCappCraftProductPassTaskRecord);
      });
      if (CollectionUtils.isNotEmpty(updateList)) {
         this.baseService.updateBatchById(updateList);
      }

      return Boolean.TRUE;
   }

   @Override
   public List<CappCraftCardWeldingVO> weldingList(CappCraftCardWeldingListDTO dto) {
      List<CappCraftCardWeldingVO> cappCraftCardWeldingVOS = new ArrayList<>();
      List<TechCappCraftCardProductWelding> techCappCraftCardProductWeldings = this.techCappCraftCardProductWeldingService
         .list(
            Wrappers.lambdaQuery(TechCappCraftCardProductWelding.class)
               .eq(TechCappCraftCardProductWelding::getProductType, dto.getProductType())
               .eq(TechCappCraftCardProductWelding::getMonomerId, dto.getMonomerId())
               .eq(TechCappCraftCardProductWelding::getSerialNumber, dto.getProductSerialNumber())
               .orderByAsc(BaseEntity::getCreateTime)
         );
      TechCappCraftProductTask techCappCraftProductTask = this.techCappCraftProductTaskBiz
         .getOne(
            Wrappers.lambdaQuery(TechCappCraftProductTask.class)
               .eq(TechCappCraftProductTask::getOneCodeExtId, dto.getId())
               .eq(TechCappCraftProductTask::getProductType, dto.getProductType())
               .eq(TechCappCraftProductTask::getProductId, dto.getProductId())
         );
      if (CollectionUtils.isEmpty(techCappCraftCardProductWeldings)) {
         return cappCraftCardWeldingVOS;
      }

      Map<Long, TechCappCraftCardStorehouse> techCappCraftCardStorehouseMap = this.techCappCraftCardStorehouseBiz
         .listAll()
         .stream()
         .collect(Collectors.toMap(TechCappCraftCardStorehouse::getId, Function.identity()));
      Map<Long, List<TechCappCraftProductPassTask>> techPassTaskMap = this.techCappCraftProductPassTaskService
         .list(
            Wrappers.lambdaQuery(TechCappCraftProductPassTask.class)
               .eq(TechCappCraftProductPassTask::getProductId, dto.getProductId())
               .eq(TechCappCraftProductPassTask::getProductType, dto.getProductType())
         )
         .stream()
         .collect(Collectors.groupingBy(TechCappCraftProductPassTask::getTechCappCraftProductWeldTaskId));
      Map<Long, TechCappCraftCardStorehouseCraftParameterPassLink> parameterPassLinkMap = this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
         .getAllList()
         .stream()
         .collect(Collectors.toMap(TechCappCraftCardStorehouseCraftParameterPassLink::getId, Function.identity()));
      Map<Long, List<TechCappCraftCardStorehouseCraftParameterPassLink>> parameterPassLinkListMap = this.techCappCraftCardStorehouseCraftparameterPassLinkBiz
         .getAllList()
         .stream()
         .collect(Collectors.groupingBy(TechCappCraftCardStorehouseCraftParameterPassLink::getTechCappCraftCardStorehouseId));
      techCappCraftCardProductWeldings.forEach(
         item -> {
            CappCraftCardWeldingVO cappCraftCardWeldingVO = new CappCraftCardWeldingVO();
            cappCraftCardWeldingVO.setWeldingSerialNumber(item.getWeldingSerialNumber());
            TechCappCraftProductWeldTask productWeldTask = null;
            if (techCappCraftProductTask != null) {
               productWeldTask = this.techCappCraftProductWeldTaskBiz
                  .getOne(
                     Wrappers.lambdaQuery(TechCappCraftProductWeldTask.class)
                        .eq(TechCappCraftProductWeldTask::getWeldingSerialNumber, item.getWeldingSerialNumber())
                        .eq(TechCappCraftProductWeldTask::getProductId, dto.getProductId())
                        .eq(TechCappCraftProductWeldTask::getTechCappCraftProductTaskId, techCappCraftProductTask.getId())
                        .eq(TechCappCraftProductWeldTask::getProductType, dto.getProductType())
                        .eq(TechCappCraftProductWeldTask::getAreaId, dto.getAreaId())
                  );
            }

            if (productWeldTask != null) {
               TechCappCraftCardStorehouse techCappCraftCardStorehouse = techCappCraftCardStorehouseMap.get(productWeldTask.getTechCappCraftCardStorehouseId());
               if (techCappCraftCardStorehouse != null) {
                  cappCraftCardWeldingVO.setTechCappCraftCardStorehouseSerialNumber(techCappCraftCardStorehouse.getSerialNumber());
                  cappCraftCardWeldingVO.setWeldingBaseWeldingPosition(techCappCraftCardStorehouse.getWeldingBaseWeldingPosition());
               }

               List<TechCappCraftProductPassTask> techCappCraftProductPassTasks = techPassTaskMap.get(productWeldTask.getId());
               techCappCraftProductPassTasks.sort(Comparator.comparingInt(TechCappCraftProductPassTask::getSort));
               List<CappCraftCardPassVO> cappCraftCardPassVOS = new ArrayList<>();
               techCappCraftProductPassTasks.forEach(
                  pass -> {
                     CappCraftCardPassVO cappCraftCardPassVO = new CappCraftCardPassVO();
                     TechCappCraftCardStorehouseCraftParameterPassLink techCappCraftCardStorehouseCraftParameterPassLink = parameterPassLinkMap.get(
                        pass.getTechCappCraftCardStorehouseCraftParameterPassLinkId()
                     );
                     cappCraftCardPassVO.setPassId(pass.getId());
                     cappCraftCardPassVO.setPassName(techCappCraftCardStorehouseCraftParameterPassLink.getWeldingCraftParameterPass());
                     cappCraftCardPassVO.setEquimentSerialNumber(pass.getEquimentSerialNumber());
                     cappCraftCardPassVO.setEquimentName(pass.getEquimentName());
                     cappCraftCardPassVO.setEquimentCode(pass.getEquimentCode());
                     cappCraftCardPassVO.setWeldUserName(pass.getWeldUserName());
                     cappCraftCardPassVO.setStartTime(pass.getStartTime());
                     cappCraftCardPassVO.setEndTime(pass.getEndTime());
                     if (cappCraftCardPassVO.getStartTime() != null && cappCraftCardPassVO.getEndTime() != null) {
                        Duration duration = Duration.between(cappCraftCardPassVO.getStartTime(), cappCraftCardPassVO.getEndTime());
                        long hours = duration.toHours();
                        long minutes = duration.toMinutes() % 60L;
                        cappCraftCardPassVO.setActualTime(String.format("%d:%02d", hours, minutes));
                     }

                     cappCraftCardPassVOS.add(cappCraftCardPassVO);
                  }
               );
               cappCraftCardWeldingVO.setCappCraftCardPassVOS(cappCraftCardPassVOS);
            } else {
               TechCappCraftCardProductLink techCappCraftCardProductLink = this.techCappCraftCardProductLinkBiz
                  .getOne(
                     Wrappers.lambdaQuery(TechCappCraftCardProductLink.class)
                        .eq(TechCappCraftCardProductLink::getProductType, dto.getProductType())
                        .eq(TechCappCraftCardProductLink::getProductId, dto.getProductId())
                        .eq(TechCappCraftCardProductLink::getAreaId, dto.getAreaId())
                        .eq(TechCappCraftCardProductLink::getMonomerId, dto.getMonomerId())
                        .eq(TechCappCraftCardProductLink::getWeldingSerialNumber, item.getWeldingSerialNumber())
                  );
               if (techCappCraftCardProductLink != null) {
                  TechCappCraftCardStorehouse techCappCraftCardStorehouse = techCappCraftCardStorehouseMap.get(
                     techCappCraftCardProductLink.getTechCappCraftCardStorehouseId()
                  );
                  if (techCappCraftCardStorehouse != null) {
                     cappCraftCardWeldingVO.setTechCappCraftCardStorehouseSerialNumber(techCappCraftCardStorehouse.getSerialNumber());
                     cappCraftCardWeldingVO.setWeldingBaseWeldingPosition(techCappCraftCardStorehouse.getWeldingBaseWeldingPosition());
                     List<TechCappCraftCardStorehouseCraftParameterPassLink> techCappCraftCardStorehouseCraftParameterPassLinks = parameterPassLinkListMap.get(
                        techCappCraftCardProductLink.getTechCappCraftCardStorehouseId()
                     );
                     techCappCraftCardStorehouseCraftParameterPassLinks.sort(
                        Comparator.comparingInt(TechCappCraftCardStorehouseCraftParameterPassLink::getSort)
                     );
                     List<CappCraftCardPassVO> cappCraftCardPassVOS = new ArrayList<>();
                     techCappCraftCardStorehouseCraftParameterPassLinks.forEach(pass -> {
                        CappCraftCardPassVO cappCraftCardPassVO = new CappCraftCardPassVO();
                        cappCraftCardPassVO.setPassName(pass.getWeldingCraftParameterPass());
                        cappCraftCardPassVOS.add(cappCraftCardPassVO);
                     });
                     cappCraftCardWeldingVO.setCappCraftCardPassVOS(cappCraftCardPassVOS);
                  }
               }
            }

            cappCraftCardWeldingVOS.add(cappCraftCardWeldingVO);
         }
      );
      return cappCraftCardWeldingVOS;
   }
}
