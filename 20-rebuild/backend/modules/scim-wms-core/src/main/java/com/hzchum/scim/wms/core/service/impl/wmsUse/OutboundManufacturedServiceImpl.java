package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventoryManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.OutboundManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.OutboundManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundDetailManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.OutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryOutboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsMonthManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundManufacturedService;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundManufacturedMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OutboundManufacturedServiceImpl extends ServiceImpl<OutboundManufacturedMapper, OutboundManufactured> implements OutboundManufacturedService {
   @Resource
   OutboundDetailManufacturedService outboundDetailManufacturedService;
   @Resource
   MaterialInventoryManufacturedService materialInventoryManufacturedService;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   StatisticsMonthManufacturedService statisticsMonthManufacturedService;
   @Resource
   UserService userService;
   @Resource
   QueryUtilImpl queryUtil;

   @Override
   public PageVO<OutboundManufacturedDTO> pageInfo(QueryOutboundManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<OutboundManufactured> outboundManufactureds = this.baseMapper.list(param);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      List<OutboundManufacturedDTO> outboundManufacturedDTOS = new ArrayList<>();

      for (OutboundManufactured outboundManufactured : outboundManufactureds) {
         OutboundManufacturedDTO bean = BeanUtil.toBean(outboundManufactured, OutboundManufacturedDTO.class);
         if (StrUtil.isNotBlank(outboundManufactured.getProjectIds())) {
            List<Long> idList = Arrays.stream(org.apache.commons.lang3.StringUtils.split(outboundManufactured.getProjectIds(), ","))
               .map(Long::parseLong)
               .collect(Collectors.toList());
            List<ContractProject> list = new ArrayList<>();
            idList.forEach(id -> {
               if (projectMap.containsKey(id)) {
                  list.add(projectMap.get(id));
               }
            });
            List<ProjectInfo> collect = list.stream()
               .map(project -> com.hzchum.pangu.common.util.BeanUtil.copy(project, ProjectInfo.class))
               .collect(Collectors.toList());
            bean.setProjects(collect);
         }

         outboundManufacturedDTOS.add(bean);
      }

      return new PageVO<>(page, outboundManufacturedDTOS);
   }

   @Override
   public PageVO<OutboundDetailManufacturedDTO> pageInfoDetail(QueryOutboundManufacturedDTOParam param, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<InboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<OutboundDetailManufactured> outboundDetailManufactureds = this.outboundDetailManufacturedService.selectList(param);
      if (CollectionUtil.isEmpty(outboundDetailManufactureds)) {
         return new PageVO<>();
      }

      List<OutboundDetailManufacturedDTO> outboundDetailManufacturedDTOS = this.outboundDetailManufacturedService.convertDetailDto(outboundDetailManufactureds);
      return new PageVO<>(page, outboundDetailManufacturedDTOS);
   }

   @Override
   public OutboundManufacturedDTO getOutboundById(Long id) {
      OutboundManufactured outboundManufactured = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(outboundManufactured), "出库单不存在！！！");
      OutboundManufacturedDTO outboundManufacturedDTO = BeanUtil.toBean(outboundManufactured, OutboundManufacturedDTO.class);
      List<OutboundDetailManufactured> outboundDetailManufactureds = this.outboundDetailManufacturedService
         .list(
            (Wrapper<OutboundDetailManufactured>)new LambdaQueryWrapper<OutboundDetailManufactured>()
               .eq(OutboundDetailManufactured::getOutboundManufacturedId, outboundManufactured.getId())
         );
      List<OutboundDetailManufacturedDTO> list = this.outboundDetailManufacturedService.convertDetailDto(outboundDetailManufactureds);
      outboundManufacturedDTO.setList(list);
      return outboundManufacturedDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean save(OutboundManufacturedDTOParam param) {
      param.setBoolSubmitCheck(false);
      param.setReviewStatus(ReviewStatusEnum.NOT_SUBMITTED.getType());
      this.saveOutboundManufactured(param);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSubmit(OutboundManufacturedDTOParam param) {
      param.setBoolSubmitCheck(true);
      param.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      OutboundManufactured outboundManufactured = this.saveOutboundManufactured(param);
      outboundManufactured.setApplicationTime(LocalDateTime.now());
      outboundManufactured.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      WmsApproveRecord wmsApproveRecord = this.submitCheck(outboundManufactured);
      outboundManufactured.setApproveRecordId(wmsApproveRecord.getId());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passed(outboundManufactured);
      }

      return this.baseMapper.updateById(outboundManufactured) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean submitReview(OutboundManufacturedDTOParam param) {
      OutboundManufactured outboundManufactured = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(outboundManufactured), "出库单不存在请刷新页面");
      outboundManufactured.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      outboundManufactured.setApplicationTime(LocalDateTime.now());
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            outboundManufactured.getId(),
            outboundManufactured.getSerialNumber(),
            ApproveProcessTypeEnumV2.MANUFACTURED_OUT.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
      outboundManufactured.setApproveRecordId(wmsApproveRecord.getId());
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passed(outboundManufactured);
      }

      return this.baseMapper.updateById(outboundManufactured) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean review(Long approveRecordId, Integer decision, String opinion) {
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      OutboundManufactured outboundManufactured = this.baseMapper.selectById(wmsApproveRecord.getDataId());
      Boolean b = this.wmsApproveRecordService.commonApproveStep(outboundManufactured.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passed(outboundManufactured);
         } else {
            this.fail(outboundManufactured, decision);
         }

         this.baseMapper.updateById(outboundManufactured);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      OutboundManufactured outboundManufactured = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(outboundManufactured.getApplicantId()), "仅创建此出库单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outboundManufactured.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(outboundManufactured.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(outboundManufactured.getApproveRecordId());
      }

      this.fail(outboundManufactured, ReviewStatusEnum.CANCEL.getType());
      return this.baseMapper.updateById(outboundManufactured) == 1;
   }

   @Override
   public Boolean promptlyOut(InboundManufacturedDTOParam request) {
      InboundManufactured inboundManufactured = request.getInboundManufactured();
      List<InboundDetailManufactured> inboundDetailManufactureds = request.getInboundDetailManufactureds();
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_MANUFACTURED, this.baseMapper.getCount(LocalDateTime.now()));
      OutboundManufactured outboundManufactured = OutboundManufactured.builder()
         .serialNumber(serviceNumber)
         .applicantId(inboundManufactured.getApplicantId())
         .applicantName(inboundManufactured.getApplicantName())
         .applicationTime(LocalDateTime.now())
         .reviewStatus(ReviewStatusEnum.REVIEWED.getType())
         .reviewPassTime(LocalDateTime.now())
         .basicClass(inboundManufactured.getBasicClass())
         .projectIds(inboundManufactured.getProjectIds())
         .amountExcludingVat(inboundManufactured.getAmountExcludingVat())
         .amount(inboundManufactured.getAmount())
         .approveRecordId(inboundManufactured.getApproveRecordId())
         .inboundManufacturedId(inboundManufactured.getId())
         .build();
      this.baseMapper.insert(outboundManufactured);
      String monthStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));

      for (InboundDetailManufactured inboundDetailManufactured : inboundDetailManufactureds) {
         OutboundDetailManufactured bean = BeanUtil.toBean(inboundDetailManufactured, OutboundDetailManufactured.class);
         bean.setOutboundManufacturedId(outboundManufactured.getId());
         bean.setInboundManufacturedId(inboundManufactured.getId());
         bean.setInboundDetailManufacturedId(inboundDetailManufactured.getId());
         bean.setOutboundTime(LocalDateTime.now());
         this.outboundDetailManufacturedService.save(bean);
         this.setStatisticsMonthManufactured(bean, monthStr);
      }

      return true;
   }

   private void passed(OutboundManufactured outboundManufactured) {
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outboundManufactured.getReviewStatus()), "出库单已审核,请核对后操作！！！");
      List<OutboundDetailManufactured> outboundDetailManufactureds = this.outboundDetailManufacturedService
         .list(
            (Wrapper<OutboundDetailManufactured>)new LambdaQueryWrapper<OutboundDetailManufactured>()
               .eq(OutboundDetailManufactured::getOutboundManufacturedId, outboundManufactured.getId())
         );
      String monthStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));

      for (OutboundDetailManufactured outboundDetailManufactured : outboundDetailManufactureds) {
         MaterialInventoryManufactured materialInventoryManufactured = this.materialInventoryManufacturedService
            .getById(outboundDetailManufactured.getMaterialInventoryManufacturedId());
         this.setStatisticsMonthManufactured(outboundDetailManufactured, monthStr);
      }

      outboundManufactured.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      outboundManufactured.setReviewPassTime(LocalDateTime.now());
   }

   public Boolean fail(OutboundManufactured outboundManufactured, Integer reviewStatus) {
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(outboundManufactured.getReviewStatus()), "出库单已审核,请核对后操作！！！");
      outboundManufactured.setReviewStatus(reviewStatus);

      for (OutboundDetailManufactured outboundDetailManufactured : this.outboundDetailManufacturedService
         .list(
            (Wrapper<OutboundDetailManufactured>)new LambdaQueryWrapper<OutboundDetailManufactured>()
               .eq(OutboundDetailManufactured::getOutboundManufacturedId, outboundManufactured.getId())
         )) {
         this.updateMaterialInventoryManufactured(outboundDetailManufactured, null, true);
      }

      return true;
   }

   private OutboundManufactured saveOutboundManufactured(OutboundManufacturedDTOParam param) {
      OutboundManufactured outboundManufactured = null;
      if (!param.getBoolSubmitCheck()) {
         outboundManufactured = this.baseMapper
            .selectOne(
               (Wrapper<OutboundManufactured>)(Wrappers.<OutboundManufactured>lambdaQuery().eq(OutboundManufactured::getApplicantId, UserUtil.getCurrentUserId()))
                  .eq(OutboundManufactured::getReviewStatus, ReviewStatusEnum.NOT_SUBMITTED.getType())
            );
      }

      if (ObjectUtil.isEmpty(outboundManufactured)) {
         outboundManufactured = OutboundManufactured.builder()
            .applicantId(UserUtil.getCurrentUserId())
            .applicantName(UserUtil.getCurrentName())
            .reviewStatus(param.getReviewStatus())
            .build();
         String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.OUTBOUND_MANUFACTURED, this.baseMapper.getCount(LocalDateTime.now()));
         outboundManufactured.setSerialNumber(serviceNumber);
         this.baseMapper.insert(outboundManufactured);
      }

      for (OutboundDetailManufacturedDTOParam detailParam : param.getList()) {
         MaterialInventoryManufactured materialInventoryManufactured = this.materialInventoryManufacturedService.getById(detailParam.getMaterialId());
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(materialInventoryManufactured), "仓库中不存在该制成品！！！");
         Preconditions.checkArgument(
            detailParam.getQuantity().compareTo(materialInventoryManufactured.getQuantity()) <= 0,
            materialInventoryManufactured.getManufacturedName() + "制成品库存量不足！！！"
         );
         OutboundDetailManufactured outboundDetailManufactured = OutboundDetailManufactured.builder()
            .outboundManufacturedId(outboundManufactured.getId())
            .materialInventoryManufacturedId(materialInventoryManufactured.getId())
            .basicClass(materialInventoryManufactured.getBasicClass())
            .monomerId(materialInventoryManufactured.getMonomerId())
            .areaId(materialInventoryManufactured.getAreaId())
            .projectId(materialInventoryManufactured.getProjectId())
            .artifactEnclosureId(materialInventoryManufactured.getArtifactEnclosureId())
            .manufacturedName(materialInventoryManufactured.getManufacturedName())
            .manufacturedSn(materialInventoryManufactured.getManufacturedSn())
            .material(materialInventoryManufactured.getMaterial())
            .specification(materialInventoryManufactured.getSpecification())
            .length(materialInventoryManufactured.getLength())
            .width(materialInventoryManufactured.getWidth())
            .thickness(materialInventoryManufactured.getThickness())
            .brand(materialInventoryManufactured.getBrand())
            .color(materialInventoryManufactured.getColor())
            .weight(materialInventoryManufactured.getWeight())
            .surfaceArea(materialInventoryManufactured.getSurfaceArea())
            .wageQuotaType(materialInventoryManufactured.getWageQuotaType())
            .quantity(detailParam.getQuantity())
            .manufacturedUnit(materialInventoryManufactured.getManufacturedUnit())
            .recipientId(detailParam.getRecipientId())
            .recipientName(this.userService.getNameById(detailParam.getRecipientId()))
            .outboundTime(detailParam.getOutboundTime())
            .taxRate(materialInventoryManufactured.getTaxRate())
            .unitPrice(materialInventoryManufactured.getUnitPrice())
            .unitPriceExcludingVat(materialInventoryManufactured.getUnitPriceExcludingVat())
            .remark(detailParam.getRemark())
            .build();
         outboundManufactured.setBasicClass(
            outboundManufactured.getBasicClass() != null
               ? outboundManufactured.getBasicClass() | outboundDetailManufactured.getBasicClass()
               : outboundDetailManufactured.getBasicClass()
         );
         this.updateMaterialInventoryManufactured(outboundDetailManufactured, materialInventoryManufactured, false);
         Preconditions.checkArgument(outboundDetailManufactured.getUnitPrice() != null && outboundDetailManufactured.getUnitPriceExcludingVat() != null, "制成品库存单价不存在");
         BigDecimal priceQuantity;
         if (Integer.valueOf(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType()).equals(outboundDetailManufactured.getWageQuotaType())) {
            priceQuantity = outboundDetailManufactured.getTotalWeight();
         } else if (Integer.valueOf(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType()).equals(outboundDetailManufactured.getWageQuotaType())) {
            priceQuantity = outboundDetailManufactured.getTotalLength();
         } else if (Integer.valueOf(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType()).equals(outboundDetailManufactured.getWageQuotaType())) {
            priceQuantity = outboundDetailManufactured.getTotalArea();
         } else {
            Preconditions.checkArgument(Integer.valueOf(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType()).equals(outboundDetailManufactured.getWageQuotaType()), "未知计价方式");
            priceQuantity = outboundDetailManufactured.getQuantity();
         }
         Preconditions.checkArgument(priceQuantity != null, "制成品计价数量不存在");
         outboundDetailManufactured.setAmount(outboundDetailManufactured.getUnitPrice().multiply(priceQuantity));
         outboundDetailManufactured.setAmountExcludingVat(outboundDetailManufactured.getUnitPriceExcludingVat().multiply(priceQuantity));
         this.outboundDetailManufacturedService.save(outboundDetailManufactured);
      }

      this.updateAmountSummary(outboundManufactured);
      return outboundManufactured;
   }

   private void updateAmountSummary(OutboundManufactured outbound) {
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountExcludingVat = BigDecimal.ZERO;
      for (OutboundDetailManufactured detail : this.outboundDetailManufacturedService.list(
         Wrappers.<OutboundDetailManufactured>lambdaQuery().eq(OutboundDetailManufactured::getOutboundManufacturedId, outbound.getId()))) {
         if (detail.getAmount() != null) {
            amount = amount.add(detail.getAmount());
         }
         if (detail.getAmountExcludingVat() != null) {
            amountExcludingVat = amountExcludingVat.add(detail.getAmountExcludingVat());
         }
      }
      outbound.setAmount(amount);
      outbound.setAmountExcludingVat(amountExcludingVat);
      this.baseMapper.updateById(outbound);
   }

   private void updateMaterialInventoryManufactured(
      OutboundDetailManufactured outboundDetailManufactured, MaterialInventoryManufactured materialInventoryManufactured, Boolean boolAdd
   ) {
      if (ObjectUtil.isEmpty(materialInventoryManufactured)) {
         materialInventoryManufactured = this.materialInventoryManufacturedService.getById(outboundDetailManufactured.getMaterialInventoryManufacturedId());
      }

      // Use the same per-unit quantity calculation as manufactured inbound.
      if (outboundDetailManufactured.getTotalWeight() == null && materialInventoryManufactured.getWeight() != null) {
         outboundDetailManufactured.setTotalWeight(outboundDetailManufactured.getQuantity().multiply(materialInventoryManufactured.getWeight()));
      }
      if (outboundDetailManufactured.getTotalLength() == null && materialInventoryManufactured.getLength() != null) {
         outboundDetailManufactured.setTotalLength(outboundDetailManufactured.getQuantity().multiply(materialInventoryManufactured.getLength()));
      }
      if (outboundDetailManufactured.getTotalArea() == null && materialInventoryManufactured.getSurfaceArea() != null) {
         outboundDetailManufactured.setTotalArea(outboundDetailManufactured.getQuantity().multiply(materialInventoryManufactured.getSurfaceArea()));
      }

      BigDecimal direction = Boolean.TRUE.equals(boolAdd) ? BigDecimal.ONE : BigDecimal.ONE.negate();
      materialInventoryManufactured.setQuantity(materialInventoryManufactured.getQuantity().add(outboundDetailManufactured.getQuantity().multiply(direction)));
      if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalWeight())) {
         Preconditions.checkArgument(outboundDetailManufactured.getTotalWeight() != null, "制成品出库重量未配置");
         materialInventoryManufactured.setTotalWeight(materialInventoryManufactured.getTotalWeight().add(outboundDetailManufactured.getTotalWeight().multiply(direction)));
      }
      if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalLength())) {
         Preconditions.checkArgument(outboundDetailManufactured.getTotalLength() != null, "制成品出库长度未配置");
         materialInventoryManufactured.setTotalLength(materialInventoryManufactured.getTotalLength().add(outboundDetailManufactured.getTotalLength().multiply(direction)));
      }
      if (ObjectUtil.isNotEmpty(materialInventoryManufactured.getTotalArea())) {
         Preconditions.checkArgument(outboundDetailManufactured.getTotalArea() != null, "制成品出库面积未配置");
         materialInventoryManufactured.setTotalArea(materialInventoryManufactured.getTotalArea().add(outboundDetailManufactured.getTotalArea().multiply(direction)));
      }

      this.materialInventoryManufacturedService.updateById(materialInventoryManufactured);
   }

   private void setStatisticsMonthManufactured(OutboundDetailManufactured outboundDetailManufactured, String monthStr) {
      StatisticsMonthManufactured statisticsMonthManufactured = this.statisticsMonthManufacturedService
         .getOne(
            (Wrapper<StatisticsMonthManufactured>)(((((new LambdaQueryWrapper<StatisticsMonthManufactured>()
                              .eq(StatisticsMonthManufactured::getMonomerId, outboundDetailManufactured.getMonomerId()))
                           .eq(StatisticsMonthManufactured::getAreaId, outboundDetailManufactured.getAreaId()))
                        .eq(StatisticsMonthManufactured::getManufacturedSn, outboundDetailManufactured.getManufacturedSn()))
                     .eq(StatisticsMonthManufactured::getUnitPrice, outboundDetailManufactured.getUnitPrice()))
                  .eq(StatisticsMonthManufactured::getTaxRate, outboundDetailManufactured.getTaxRate()))
               .eq(StatisticsMonthManufactured::getMonthStr, monthStr)
         );
      if (ObjectUtil.isEmpty(statisticsMonthManufactured)) {
         statisticsMonthManufactured = BeanUtil.toBean(outboundDetailManufactured, StatisticsMonthManufactured.class);
         statisticsMonthManufactured.setOutboundTotalQuantity(outboundDetailManufactured.getQuantity());
         statisticsMonthManufactured.setOutboundTotalWeight(outboundDetailManufactured.getTotalWeight());
         statisticsMonthManufactured.setOutboundTotalLength(outboundDetailManufactured.getTotalLength());
         statisticsMonthManufactured.setOutboundTotalArea(outboundDetailManufactured.getTotalArea());
         statisticsMonthManufactured.setOutboundAmount(outboundDetailManufactured.getAmount());
         statisticsMonthManufactured.setOutboundAmountExcludingVat(outboundDetailManufactured.getAmountExcludingVat());
         statisticsMonthManufactured.setMonthStr(monthStr);
         this.statisticsMonthManufacturedService.save(statisticsMonthManufactured);
      } else {
         statisticsMonthManufactured.setOutboundTotalQuantity(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalQuantity())
               ? statisticsMonthManufactured.getOutboundTotalQuantity().add(outboundDetailManufactured.getQuantity())
               : outboundDetailManufactured.getQuantity()
         );
         statisticsMonthManufactured.setOutboundTotalWeight(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalWeight())
               ? statisticsMonthManufactured.getOutboundTotalWeight().add(outboundDetailManufactured.getTotalWeight())
               : outboundDetailManufactured.getTotalWeight()
         );
         statisticsMonthManufactured.setOutboundTotalLength(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalLength())
               ? statisticsMonthManufactured.getOutboundTotalLength().add(outboundDetailManufactured.getTotalLength())
               : outboundDetailManufactured.getTotalLength()
         );
         statisticsMonthManufactured.setOutboundTotalArea(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundTotalArea())
               ? statisticsMonthManufactured.getOutboundTotalArea().add(outboundDetailManufactured.getTotalArea())
               : outboundDetailManufactured.getTotalArea()
         );
         statisticsMonthManufactured.setOutboundAmount(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundAmount())
               ? statisticsMonthManufactured.getOutboundAmount().add(outboundDetailManufactured.getAmount())
               : outboundDetailManufactured.getAmount()
         );
         statisticsMonthManufactured.setOutboundAmountExcludingVat(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getOutboundAmountExcludingVat())
               ? statisticsMonthManufactured.getOutboundAmountExcludingVat().add(outboundDetailManufactured.getAmountExcludingVat())
               : outboundDetailManufactured.getAmountExcludingVat()
         );
         this.statisticsMonthManufacturedService.updateById(statisticsMonthManufactured);
      }
   }

   private WmsApproveRecord submitCheck(OutboundManufactured outboundManufactured) {
      return this.wmsApproveRecordService
         .createRecord(
            outboundManufactured.getId(),
            outboundManufactured.getSerialNumber(),
            ApproveProcessTypeEnumV2.MANUFACTURED_OUT.getType(),
            null,
            null,
            null,
            false,
            null,
            null,
            null
         );
   }

   @Override
   public Integer getCount(LocalDateTime dateTime) {
      return this.baseMapper.getCount(dateTime);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteOut(Long id) {
      OutboundManufactured outbound = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(outbound), "出库单不存在，请刷新页面");
      Preconditions.checkArgument(UserUtil.getCurrentUserId().equals(outbound.getApplicantId()), "仅创建此出库单的人才可删除");
      Preconditions.checkArgument(ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "仅未提交的出库单可删除");
      for (OutboundDetailManufactured outboundDetailManufactured : this.outboundDetailManufacturedService
         .list((Wrapper<OutboundDetailManufactured>)new LambdaQueryWrapper<OutboundDetailManufactured>().eq(OutboundDetailManufactured::getOutboundManufacturedId, id))) {
         this.updateMaterialInventoryManufactured(outboundDetailManufactured, null, true);
         this.outboundDetailManufacturedService.removeById(outboundDetailManufactured.getId());
      }

      return this.removeById(id);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteOutDetail(Long id) {
      OutboundDetailManufactured byId = this.outboundDetailManufacturedService.getById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(byId), "出库明细不存在！！！");
      OutboundManufactured outbound = this.baseMapper.selectById(byId.getOutboundManufacturedId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(outbound), "出库单不存在，请刷新页面");
      Preconditions.checkArgument(UserUtil.getCurrentUserId().equals(outbound.getApplicantId()), "仅创建此出库单的人才可删除");
      Preconditions.checkArgument(ReviewStatusEnum.NOT_SUBMITTED.getType().equals(outbound.getReviewStatus()), "仅未提交的出库单可删除");
      this.updateMaterialInventoryManufactured(byId, null, true);
      boolean removed = this.outboundDetailManufacturedService.removeById(id);
      this.updateAmountSummary(outbound);
      return removed;
   }
}
