package com.hzchum.scim.mes.building.core.service.impl.report_work;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesProductionReportingApprovalPassed;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesReportWorkApproved;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjust;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.report_work.MesWageAdjustProduct;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesProductionReportingApprovalPassedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report_work.MesWageAdjustProductDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesProductionReportingApprovalPassedQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work.MesWageAdjustQuery;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesProductionReportingApprovalPassedService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesReportWorkApprovedService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesWageAdjustProductService;
import com.hzchum.scim.mes.building.core.api.service.report_work.MesWageAdjustService;
import com.hzchum.scim.mes.building.core.mapper.report_work.MesWageAdjustMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesWageAdjustServiceImpl extends ServiceImpl<MesWageAdjustMapper, MesWageAdjust> implements MesWageAdjustService {
   @Autowired
   private WmsApproveRecordService wmsApproveRecordService;
   @Autowired
   private MesWageAdjustProductService wageAdjustProductService;
   @Autowired
   private MesBuildingTeamUserLinkService teamUserLinkService;
   @Autowired
   private WmsApproveRecordService approveRecordService;
   @Autowired
   private MesReportWorkApprovedService reportWorkApprovedService;
   @Autowired
   private MesProductionReportingApprovalPassedService productionReportingApprovalPassedService;

   @Override
   public List<MesWageAdjustDTO> listInfo(MesWageAdjustQuery query) {
      return this.baseMapper.listInfo(query);
   }

   @Override
   public MesWageAdjustDTO detailById(Long id) {
      MesWageAdjustDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(dto), "数据不存在, 请刷新后重试");
      if (StrUtil.isNotBlank(dto.getTeamIds())) {
         List<NameInfo> teamList = this.teamUserLinkService
            .list(
               Wrappers.lambdaQuery(MesBuildingTeamUserLink.class)
                  .eq(MesBuildingTeamUserLink::getBoolLeaderEnum, Boolean.TRUE)
                  .in(MesBuildingTeamUserLink::getTeamId, dto.getTeamIdList())
            )
            .stream()
            .map(i -> new NameInfo(i.getTeamId(), i.getUserName(), null))
            .collect(Collectors.toList());
         dto.setTeamList(teamList);
      }

      List<MesWageAdjustProductDTO> wageAdjustProductList = this.wageAdjustProductService.listInfoByWageAdjustId(id, dto.getProductTypeEnum());
      dto.setProductList(wageAdjustProductList);
      WmsApproveRecordFlowDTO approveRecord = this.wmsApproveRecordService.getApproveRecordDTO(dto.getApproveRecordId());
      dto.setApproveRecord(approveRecord);
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean initiateApproval(MesWageAdjustParam param) {
      MesWageAdjust wageAdjust = BeanUtil.toBean(param, MesWageAdjust.class);
      wageAdjust.setCreateUserId(UserUtil.getCurrentUserId());
      wageAdjust.setTeamIds(CollUtil.join(param.getTeamIdList(), ","));
      this.save(wageAdjust);
      List<MesWageAdjustProduct> productList = param.getProductList().stream().map(p -> {
         MesWageAdjustProduct product = BeanUtil.toBean(p, MesWageAdjustProduct.class);
         product.setWageAdjustId(wageAdjust.getId());
         product.setProjectId(wageAdjust.getProjectId());
         product.setMonomerId(wageAdjust.getMonomerId());
         product.setProductSerialNumber(p.getProductSerialNumber());
         return product;
      }).collect(Collectors.toList());
      this.wageAdjustProductService.saveBatch(productList);
      WmsApproveRecord approveRecord = this.approveRecordService
         .createRecord(wageAdjust.getId(), null, ApproveProcessTypeEnumV2.MES_WAGE_ADJUST.getType(), null, null, null, true, null, null, null);
      wageAdjust.setApproveRecordId(approveRecord.getId());
      wageAdjust.setApproveRecordSerialNumber(approveRecord.getSerialNumber());
      wageAdjust.setApprovalStatus(approveRecord.getReviewStatus());
      this.updateById(wageAdjust);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean initiateApprovalV2(MesWageAdjustParam param) {
      MesWageAdjust wageAdjust = BeanUtil.toBean(param, MesWageAdjust.class);
      wageAdjust.setCreateUserId(UserUtil.getCurrentUserId());
      wageAdjust.setTeamIds(CollUtil.join(param.getTeamIdList(), ","));
      this.save(wageAdjust);
      List<MesWageAdjustProduct> productList = param.getProductList().stream().map(p -> {
         MesWageAdjustProduct product = BeanUtil.toBean(p, MesWageAdjustProduct.class);
         product.setWageAdjustId(wageAdjust.getId());
         product.setProjectId(wageAdjust.getProjectId());
         product.setMonomerId(wageAdjust.getMonomerId());
         product.setProductSerialNumber(p.getProductSerialNumber());
         return product;
      }).collect(Collectors.toList());
      this.wageAdjustProductService.saveBatch(productList);
      WmsApproveRecord approveRecord = this.approveRecordService
         .createRecord(wageAdjust.getId(), null, ApproveProcessTypeEnumV2.MES_WAGE_ADJUST.getType(), null, null, null, true, null, null, null);
      wageAdjust.setApproveRecordId(approveRecord.getId());
      wageAdjust.setApproveRecordSerialNumber(approveRecord.getSerialNumber());
      wageAdjust.setApprovalStatus(approveRecord.getReviewStatus());
      this.updateById(wageAdjust);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approval(MesWageAdjustApprovalParam param) {
      MesWageAdjust wageAdjust = this.getById(param.getWageAdjustId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(wageAdjust), "数据不存在, 请刷新后重试");
      Boolean approvalResult = this.wmsApproveRecordService
         .commonApproveStep(wageAdjust.getId(), param.getApprovalResult(), param.getRemark(), wageAdjust.getApproveRecordSerialNumber(), null);
      if (approvalResult) {
         wageAdjust.setApprovalStatus(param.getApprovalResult());
         wageAdjust.setApproveDate(LocalDateTime.now());
         wageAdjust.setApproveUserId(UserUtil.getCurrentUserId());
         this.wageAdjustProductService
            .update(
               Wrappers.lambdaUpdate(MesWageAdjustProduct.class)
                  .eq(MesWageAdjustProduct::getWageAdjustId, wageAdjust.getId())
                  .set(MesWageAdjustProduct::getApprovalStatus, wageAdjust.getApprovalStatus())
            );
         this.updateById(wageAdjust);
         if (ReviewStatusEnum.REVIEWED.getType().equals(wageAdjust.getApprovalStatus())) {
            List<MesWageAdjustProductDTO> wageAdjustProductList = this.wageAdjustProductService
               .listInfoByWageAdjustId(wageAdjust.getId(), wageAdjust.getProductTypeEnum());
            Map<String, BigDecimal> wageAdjustProductMap = wageAdjustProductList.stream()
               .collect(Collectors.toMap(MesWageAdjustProduct::getProductSerialNumber, MesWageAdjustProduct::getNewPrice, (v1, v2) -> v1));
            List<String> productSerialNumbers = wageAdjustProductList.stream()
               .map(MesWageAdjustProduct::getProductSerialNumber)
               .distinct()
               .collect(Collectors.toList());
            List<MesReportWorkApproved> reportWorkApprovedList = this.reportWorkApprovedService
               .list(
                  Wrappers.lambdaQuery(MesReportWorkApproved.class)
                     .eq(MesReportWorkApproved::getProjectId, wageAdjust.getProjectId())
                     .eq(MesReportWorkApproved::getMonomerId, wageAdjust.getMonomerId())
                     .in(MesReportWorkApproved::getProductSerialNumber, productSerialNumbers)
               );
            reportWorkApprovedList.forEach(i -> {
               BigDecimal newPrice = wageAdjustProductMap.get(i.getProductSerialNumber());
               if (newPrice != null) {
                  i.setPrice(newPrice);
                  i.setTotalPrice(newPrice.multiply(i.getAccountingQuantity()));
               }
            });
            this.reportWorkApprovedService.updateBatchById(reportWorkApprovedList);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvalV2(MesWageAdjustApprovalParam param) {
      MesWageAdjust wageAdjust = this.getById(param.getWageAdjustId());
      Preconditions.checkArgument(BeanUtil.isNotEmpty(wageAdjust), "数据不存在, 请刷新后重试");
      Boolean approvalResult = this.wmsApproveRecordService
         .commonApproveStep(wageAdjust.getId(), param.getApprovalResult(), param.getRemark(), wageAdjust.getApproveRecordSerialNumber(), null);
      if (approvalResult) {
         wageAdjust.setApprovalStatus(param.getApprovalResult());
         wageAdjust.setApproveDate(LocalDateTime.now());
         wageAdjust.setApproveUserId(UserUtil.getCurrentUserId());
         this.wageAdjustProductService
            .update(
               Wrappers.lambdaUpdate(MesWageAdjustProduct.class)
                  .eq(MesWageAdjustProduct::getWageAdjustId, wageAdjust.getId())
                  .set(MesWageAdjustProduct::getApprovalStatus, wageAdjust.getApprovalStatus())
            );
         this.updateById(wageAdjust);
         if (ReviewStatusEnum.REVIEWED.getType().equals(wageAdjust.getApprovalStatus())) {
            List<MesWageAdjustProductDTO> wageAdjustProductList = this.wageAdjustProductService
               .listInfoByWageAdjustId(wageAdjust.getId(), wageAdjust.getProductTypeEnum());
            Map<String, MesWageAdjustProductDTO> wageAdjustProductMap = wageAdjustProductList.stream()
               .collect(Collectors.toMap(MesWageAdjustProduct::getProductSerialNumber, Function.identity(), (v1, v2) -> v1));
            List<String> productSerialNumberList = wageAdjustProductList.stream()
               .map(MesWageAdjustProduct::getProductSerialNumber)
               .distinct()
               .collect(Collectors.toList());
            MesProductionReportingApprovalPassedQuery productionReportingApprovalPassedQuery = new MesProductionReportingApprovalPassedQuery();
            productionReportingApprovalPassedQuery.setProjectId(wageAdjust.getProjectId());
            productionReportingApprovalPassedQuery.setMonomerId(wageAdjust.getMonomerId());
            productionReportingApprovalPassedQuery.setProductTypeEnum(wageAdjust.getProductTypeEnum());
            productionReportingApprovalPassedQuery.setProductSerialNumberList(productSerialNumberList);
            List<MesProductionReportingApprovalPassedDTO> productionReportingApprovalPassedDTOList = this.productionReportingApprovalPassedService
               .listInfo(productionReportingApprovalPassedQuery);
            List<MesProductionReportingApprovalPassed> productionReportingApprovalPassedList = productionReportingApprovalPassedDTOList.stream()
               .map(
                  i -> {
                     MesWageAdjustProductDTO wageAdjustProductDTO = wageAdjustProductMap.get(i.getProduct().getSerialNumber());
                     if (wageAdjustProductDTO != null) {
                        BigDecimal price = i.getTeam().getOrganizationType()
                           ? wageAdjustProductDTO.getNewOrganizationInsidePrice()
                           : wageAdjustProductDTO.getNewOrganizationOutsidePrice();
                        i.setPrice(price);
                        i.setAmount(i.getPrice().multiply(i.getMeasurementQuantity()));
                     }

                     return BeanUtil.toBean(i, MesProductionReportingApprovalPassed.class);
                  }
               )
               .collect(Collectors.toList());
            this.productionReportingApprovalPassedService.updateBatchById(productionReportingApprovalPassedList);
         }
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      MesWageAdjust wageAdjust = this.getById(id);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(wageAdjust), "数据不存在, 请刷新后重试");
      Long currentUserId = UserUtil.getCurrentUserId();
      Preconditions.checkArgument(currentUserId.equals(wageAdjust.getCreateUserId()), "仅创建人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(wageAdjust.getApprovalStatus()), "当前状态不可撤销");
      wageAdjust.setApprovalStatus(ReviewStatusEnum.CANCEL.getType());
      this.wmsApproveRecordService.revocation(wageAdjust.getApproveRecordId());
      this.updateById(wageAdjust);
      return true;
   }
}
