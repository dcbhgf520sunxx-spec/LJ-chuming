package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.enums.MaterialIsWholeEnum;
import com.hzchum.scim.wms.core.api.enums.OutboundStatusEnum;
import com.hzchum.scim.wms.core.api.enums.ReceiptTypeEnum;
import com.hzchum.scim.wms.core.api.enums.RejectEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.Inbound;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetail;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventory;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjust;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsAdjustDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AdjustDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.AdjustDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.QueryReportAdjustDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.AdjustDetailDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WarehouseService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WeightedAveragePriceService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustDetailService;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsAdjustService;
import com.hzchum.scim.wms.core.mapper.wmsUse.OutboundMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsAdjustDetailMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsAdjustMapper;
import com.hzchum.scim.wms.core.utils.QueryUtilImpl;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsAdjustServiceImpl extends ServiceImpl<WmsAdjustMapper, WmsAdjust> implements WmsAdjustService {
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   OutboundMapper outboundMapper;
   @Resource
   WmsAdjustDetailService wmsAdjustDetailService;
   @Resource
   private SupplierService supplierService;
   @Resource
   ContractProjectService contractProjectService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   InboundService inboundService;
   @Resource
   InboundDetailService inboundDetailService;
   @Resource
   WarehouseService warehouseService;
   @Resource
   MaterialInventoryService materialInventoryService;
   @Resource
   SpecificationService specificationService;
   @Resource
   WeightedAveragePriceService weightedAveragePriceService;
   @Resource
   WmsAdjustDetailMapper wmsAdjustDetailMapper;
   @Resource
   QueryUtilImpl queryUtil;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public boolean saveWmsAdjust(List<AdjustDetailDTOParam> param) {
      String serviceNumber = this.numberConfigService.getNumber(NumberTypeEnum.MANUFACTURES_ADJUST, this.baseMapper.getCount(LocalDateTime.now()));
      Preconditions.checkArgument(param.size() > 0, "调整明细不能为空");
      WmsAdjust build = WmsAdjust.builder()
         .serialNumber(serviceNumber)
         .reviewStatus(OutboundStatusEnum.AUDITING.getType())
         .inboundId(param.get(0).getInboundId())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .build();
      this.baseMapper.insert(build);
      param.forEach(
         adjustDetailDTOParam -> {
            WmsAdjustDetail wmsAdjustDetail = WmsAdjustDetail.builder()
               .inboundDetailId(adjustDetailDTOParam.getInboundDetailId())
               .amount(adjustDetailDTOParam.getAmount())
               .amountExcludingVat(adjustDetailDTOParam.getAmountExcludingVat())
               .inputVat(adjustDetailDTOParam.getInputVat())
               .adjustId(build.getId())
               .reviewStatus(OutboundStatusEnum.UN_REVIEWED.getType())
               .serialNumber(serviceNumber)
               .build();
            this.wmsAdjustDetailService.save(wmsAdjustDetail);
         }
      );
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            build.getId(), build.getSerialNumber(), ApproveProcessTypeEnumV2.INBOUND_MONEY_ADJUST.getType(), null, null, null, false, null, null, null
         );
      WmsAdjust wmsAdjust = build.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(wmsAdjust);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         this.passedWmsAdjust(wmsAdjust.getId());
      }

      return true;
   }

   @Override
   public PageVO<AdjustDTO> pageInfo(QueryReportAdjustDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<WmsAdjust> pageInfo = PageHelper.<WmsAdjust>startPage(pageNumber, pageSize, s).doSelectPageInfo(() -> this.listInfo(dtoParam));
      Map<Long, Supplier> supplierMap = this.queryUtil.getSupplierMap(null);
      Map<Long, PurchaseOrder> prchaseOrderMap = this.queryUtil.getPrchaseOrderMap(null);
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      return new PageVO<>(
         pageInfo,
         pageInfo.getList()
            .stream()
            .map(
               wmsAdjust -> {
                  AdjustDTO wmsAdjustDTO = BeanUtil.copy(wmsAdjust, AdjustDTO.class);
                  Inbound byId1 = this.inboundService.getById(wmsAdjust.getInboundId());
                  wmsAdjustDTO.setPurchaseSN(byId1.getPurchaseSn());
                  wmsAdjustDTO.setSupplier(supplierMap.get(byId1.getSupplierId()));
                  wmsAdjustDTO.setInboundId(byId1.getId());
                  if (StrUtil.isNotBlank(byId1.getProjectIds()) && StrUtil.isNotBlank(byId1.getProjectIds())) {
                     List<Long> idList = Arrays.stream(org.apache.commons.lang3.StringUtils.split(byId1.getProjectIds(), ","))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
                     List<ContractProject> list = new ArrayList<>();
                     idList.forEach(id -> {
                        if (projectMap.containsKey(id)) {
                           list.add(projectMap.get(id));
                        }
                     });
                     List<ProjectInfo> collect = list.stream().map(project -> BeanUtil.copy(project, ProjectInfo.class)).collect(Collectors.toList());
                     wmsAdjustDTO.setProjects(collect);
                  }

                  if (byId1.getPurchaseId() != null) {
                     PurchaseOrder byId = prchaseOrderMap.get(byId1.getPurchaseId());
                     wmsAdjustDTO.setPurchaseSN(byId.getSerialNumber());
                  }

                  wmsAdjustDTO.setAdjustSerialNumber(wmsAdjustDTO.getSerialNumber());
                  wmsAdjustDTO.setSerialNumber(byId1.getSerialNumber());
                  wmsAdjustDTO.setBasicClass(byId1.getBasicClass());
                  wmsAdjustDTO.setInboundWay(byId1.getInboundWay());
                  return wmsAdjustDTO;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public PageVO<AdjustDetailDTO> adjustDetailList(QueryReportAdjustDTOParam dtoParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      PageInfo<AdjustDetailDTO> pageInfo = PageHelper.<AdjustDetailDTO>startPage(pageNumber, pageSize, s)
         .doSelectPageInfo(() -> this.wmsAdjustDetailMapper.listInfo(dtoParam));
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      return new PageVO<>(
         pageInfo,
         pageInfo.getList()
            .stream()
            .map(
               wmsAdjust -> {
                  AdjustDetailDTO wmsAdjustDTO = BeanUtil.copy(wmsAdjust, AdjustDetailDTO.class);
                  if (wmsAdjustDTO.getProjectId() != null) {
                     ContractProject byId = projectMap.get(wmsAdjustDTO.getProjectId());
                     wmsAdjustDTO.setProject(
                        ProjectInfo.builder().id(byId.getId()).name(byId.getName()).serialNumber(byId.getSerialNumber()).shortName(byId.getShortName()).build()
                     );
                  }

                  return wmsAdjustDTO;
               }
            )
            .collect(Collectors.toList())
      );
   }

   @Override
   public List<WmsAdjust> listInfo(QueryReportAdjustDTOParam dtoParam) {
      return this.baseMapper.listInfo(dtoParam);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean passedWmsAdjust(Long id) {
      if (id != null) {
         WmsAdjust wmsAdjust = this.baseMapper.selectById(id);
         Preconditions.checkArgument(
            OutboundStatusEnum.UN_REVIEWED.getType().equals(wmsAdjust.getReviewStatus())
               || OutboundStatusEnum.AUDITING.getType().equals(wmsAdjust.getReviewStatus()),
            "调整单已审核,请核对后操作"
         );
         wmsAdjust.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
         wmsAdjust.setReviewTime(LocalDateTime.now());
         wmsAdjust.setReviewerId(UserUtil.getCurrentUserId());
         wmsAdjust.setReviewerName(UserUtil.getCurrentName());
         this.baseMapper.updateById(wmsAdjust);
         List<WmsAdjustDetail> list = this.wmsAdjustDetailService.list((Wrapper<WmsAdjustDetail>)new LambdaQueryWrapper<WmsAdjustDetail>().eq(WmsAdjustDetail::getAdjustId, id));
         list.forEach(
            wmsAdjustDetail -> {
               InboundDetail inboundDetail = this.inboundDetailService.getById(wmsAdjustDetail.getInboundDetailId());
               Preconditions.checkArgument(
                  inboundDetail.getRejectStatus().equals(RejectEnum.NO_REJECT.getType()), "调整明细[" + inboundDetail.getClassifyName() + "]存在未审核的退货或者已经退过货"
               );
               WmsAdjustDetail one = this.wmsAdjustDetailService
                  .getOne(
                     (Wrapper<WmsAdjustDetail>)(((new LambdaQueryWrapper<WmsAdjustDetail>()
                                 .eq(WmsAdjustDetail::getInboundDetailId, wmsAdjustDetail.getInboundDetailId()))
                              .eq(WmsAdjustDetail::getReviewStatus, OutboundStatusEnum.REVIEWED.getType()))
                           .orderByDesc(BaseEntity::getCreateTime))
                        .last("limit 1")
                  );
               MaterialInventory materialInventory = null;
               if (!BasicClassEnum.COLOR_ROLL.getType().equals(inboundDetail.getBasicClass())) {
                  materialInventory = this.materialInventoryService.getByInboundDetail(inboundDetail);
               }

               InboundDetailDTOParam inboundDetailDOParam = new InboundDetailDTOParam();
               inboundDetailDOParam.setMete(BigDecimal.ZERO);
               if (one != null) {
                  wmsAdjustDetail.setDifferentAmount(wmsAdjustDetail.getAmount().subtract(one.getAmount()));
                  wmsAdjustDetail.setDifferentAmountExcludingVat(wmsAdjustDetail.getAmountExcludingVat().subtract(one.getAmountExcludingVat()));
               } else {
                  wmsAdjustDetail.setDifferentAmount(wmsAdjustDetail.getAmount().subtract(inboundDetail.getAmountNoFreight()));
                  wmsAdjustDetail.setDifferentAmountExcludingVat(
                     wmsAdjustDetail.getAmountExcludingVat().subtract(inboundDetail.getAmountExcludingVatNoFreight())
                  );
               }

               inboundDetail.setAmountNoFreight(wmsAdjustDetail.getDifferentAmount());
               inboundDetail.setAmountExcludingVatNoFreight(wmsAdjustDetail.getDifferentAmountExcludingVat());
               inboundDetail.setAmount(wmsAdjustDetail.getDifferentAmount());
               inboundDetail.setAmountExcludingVat(wmsAdjustDetail.getDifferentAmountExcludingVat());
               inboundDetail.setInputVat(inboundDetail.getAmount().subtract(inboundDetail.getAmountExcludingVat()));
               inboundDetail.setInputVatNoFreight(inboundDetail.getAmountNoFreight().subtract(inboundDetail.getAmountExcludingVatNoFreight()));
               MaterialInventory newMaterialInventory = this.setMaterialInventory(
                  PurchaseOrder.builder().weightMeasurementMode(inboundDetail.getWeightMeasurementMode()).build(),
                  inboundDetailDOParam,
                  inboundDetail,
                  materialInventory
               );
               newMaterialInventory.setId(-1L);
               newMaterialInventory.setUseStatus(false);
               inboundDetail.setQuantity(null);
               inboundDetail.setMete(BigDecimal.ZERO);
               inboundDetail.setRealTime(LocalDateTime.now());
               this.weightedAveragePriceService
                  .createMonthWAP(inboundDetail, newMaterialInventory, id, wmsAdjust.getSerialNumber(), ReceiptTypeEnum.ADJUST.getType());
               wmsAdjustDetail.setReviewStatus(OutboundStatusEnum.REVIEWED.getType());
               this.wmsAdjustDetailService.updateById(wmsAdjustDetail);
            }
         );
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean returnWmsAdjust(Long id) {
      WmsAdjust wmsAdjust = this.baseMapper.selectById(id);
      Preconditions.checkArgument(
         OutboundStatusEnum.UN_REVIEWED.getType().equals(wmsAdjust.getReviewStatus())
            || OutboundStatusEnum.AUDITING.getType().equals(wmsAdjust.getReviewStatus()),
         "调整单已审核,请核对后操作"
      );
      wmsAdjust.setReviewStatus(4);
      wmsAdjust.setReviewTime(LocalDateTime.now());
      wmsAdjust.setReviewerId(UserUtil.getCurrentUserId());
      wmsAdjust.setReviewerName(UserUtil.getCurrentName());
      this.baseMapper.updateById(wmsAdjust);
      UpdateWrapper<WmsAdjustDetail> wrapper = new UpdateWrapper<>();
      wrapper.eq("adjust_id", id);
      wrapper.set("review_status", 4);
      this.wmsAdjustDetailService.update(wrapper);
      return true;
   }

   @Override
   public List<AdjustDetailDTO> getInboundDetailById(Long id) {
      List<WmsAdjustDetail> list = this.wmsAdjustDetailService.list((Wrapper<WmsAdjustDetail>)new LambdaQueryWrapper<WmsAdjustDetail>().eq(WmsAdjustDetail::getAdjustId, id));
      Map<Long, ContractProject> projectMap = this.queryUtil.getProjectMap(null);
      return list.stream()
         .map(
            wmsAdjustDetail -> {
               InboundDetail inboundDetail = this.inboundDetailService.getById(wmsAdjustDetail.getInboundDetailId());
               WmsAdjustDetail one = this.wmsAdjustDetailService
                  .getOne(
                     (Wrapper<WmsAdjustDetail>)(((((new LambdaQueryWrapper<WmsAdjustDetail>()
                                       .eq(WmsAdjustDetail::getInboundDetailId, wmsAdjustDetail.getInboundDetailId()))
                                    .ne(WmsAdjustDetail::getId, wmsAdjustDetail.getId()))
                                 .le(BaseEntity::getCreateTime, wmsAdjustDetail.getCreateTime()))
                              .eq(WmsAdjustDetail::getReviewStatus, OutboundStatusEnum.REVIEWED.getType()))
                           .orderByDesc(BaseEntity::getCreateTime))
                        .last("limit 1")
                  );
               AdjustDetailDTO adjustDetailDTO = BeanUtil.copy(inboundDetail, AdjustDetailDTO.class);
               if (one != null) {
                  adjustDetailDTO.setPastAmount(one.getAmount());
                  adjustDetailDTO.setPastAmountExcludingVAT(one.getAmountExcludingVat());
                  adjustDetailDTO.setPastInputVAT(one.getInputVat());
               } else {
                  adjustDetailDTO.setPastAmount(inboundDetail.getAmountNoFreight());
                  adjustDetailDTO.setPastAmountExcludingVAT(inboundDetail.getAmountExcludingVatNoFreight());
                  adjustDetailDTO.setPastInputVAT(inboundDetail.getInputVatNoFreight());
               }

               adjustDetailDTO.setAmount(inboundDetail.getAmount());
               adjustDetailDTO.setAmountExcludingVAT(inboundDetail.getAmountExcludingVat());
               adjustDetailDTO.setInputVAT(inboundDetail.getInputVat());
               adjustDetailDTO.setAdjustAmount(wmsAdjustDetail.getAmount());
               adjustDetailDTO.setAdjustAmountExcludingVat(wmsAdjustDetail.getAmountExcludingVat());
               adjustDetailDTO.setAdjustInputVat(wmsAdjustDetail.getInputVat());
               if (inboundDetail.getWarehouseId() != null) {
                  Warehouse warehouse = this.warehouseService.getById(inboundDetail.getWarehouseId());
                  adjustDetailDTO.setWarehouse(BriefIdAndNameDTO.builder().id(warehouse.getId()).name(warehouse.getName()).build());
               }

               if (inboundDetail.getProjectId() != null) {
                  ContractProject project = projectMap.get(inboundDetail.getProjectId());
                  adjustDetailDTO.setProject(
                     ProjectInfo.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .shortName(project.getShortName())
                        .serialNumber(project.getSerialNumber())
                        .build()
                  );
               }

               return adjustDetailDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      WmsAdjust wmsAdjust = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(wmsAdjust.getApplicantId()), "仅创建此入库价格调整单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(wmsAdjust.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(wmsAdjust.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(wmsAdjust.getApproveRecordId());
      }

      this.wmsAdjustDetailService
         .update(
            null,
            (Wrapper<WmsAdjustDetail>)(new LambdaUpdateWrapper<WmsAdjustDetail>().eq(WmsAdjustDetail::getAdjustId, wmsAdjust.getId()))
               .set(WmsAdjustDetail::getReviewStatus, ReviewStatusEnum.CANCEL.getType())
         );
      wmsAdjust.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
      int i = this.baseMapper.updateById(wmsAdjust);
      Preconditions.checkArgument(i == 1, "撤销失败");
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvalAdjust(Long id, Long approveRecordId, Integer decision, String opinion) {
      WmsAdjust wmsAdjust = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsAdjust), "入库价格调整单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(wmsAdjust.getReviewStatus()), "当前入库单已审核通过,不能修改");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Boolean b = this.wmsApproveRecordService.commonApproveStep(wmsAdjust.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            this.passedWmsAdjust(wmsAdjust.getId());
         } else {
            this.returnWmsAdjust(wmsAdjust.getId());
         }
      }

      return true;
   }

   @NotNull
   private MaterialInventory setMaterialInventory(
      PurchaseOrder order, InboundDetailDTOParam dtoParam, InboundDetail inboundDetail, MaterialInventory materialInventory
   ) {
      if (materialInventory != null) {
         if (dtoParam.getQuantity() != null) {
            materialInventory.setQuantity(materialInventory.getQuantity().add(dtoParam.getQuantity()));
         }

         materialInventory.setMete(materialInventory.getMete().add(inboundDetail.getMete()));
         materialInventory.setInventoryEndTime(LocalDateTime.now());
         return materialInventory;
      } else {
         MaterialInventory mi = BeanUtil.copy(inboundDetail, MaterialInventory.class, "createTime");
         if (order != null) {
            mi.setWeightMeasurementMode(order.getWeightMeasurementMode());
         }

         if (mi.getProjectId() != null) {
            mi.setWarehouseType(2);
         } else {
            mi.setWarehouseType(1);
         }

         mi.setSerialNumber(inboundDetail.getMaterialSn());
         mi.setMaterialIsWhole(MaterialIsWholeEnum.WHOLE.getType());
         mi.setInventoryStartTime(LocalDateTime.now());
         if (BasicClassEnum.SECTION_STEEL.getType().equals(mi.getBasicClass())) {
            String[] split = mi.getSpecification().split(" \\* ");
            if (split.length > 1 && StrUtil.isNotBlank(split[1])) {
               String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), split[1]);
               if (StrUtil.isNotBlank(spec)) {
                  mi.setWeightedAverageSpec(split[0] + "*" + spec);
               } else {
                  mi.setWeightedAverageSpec(split[0]);
               }
            } else {
               mi.setWeightedAverageSpec(split[0]);
            }
         } else if (StrUtil.isNotBlank(inboundDetail.getSpecification())) {
            String spec = this.specificationService.getJoinSpec(inboundDetail.getClassifyId(), inboundDetail.getSpecification());
            mi.setWeightedAverageSpec(spec);
         }

         return mi;
      }
   }
}
