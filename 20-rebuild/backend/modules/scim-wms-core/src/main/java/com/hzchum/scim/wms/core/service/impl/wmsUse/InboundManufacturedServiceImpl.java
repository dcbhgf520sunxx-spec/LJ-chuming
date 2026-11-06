package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ApproveRecordStatusEnum;
import com.hzchum.scim.common.core.api.enums.ApproveTemplateVersionsFlowEnum;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.enums.TableNameTypeEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveFlowDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordDetailDTO;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.manager.TechMesWmsManager;
import com.hzchum.scim.plan.core.api.pojo.dto.SubscribeProductWarehouseDTO;
import com.hzchum.scim.scm.core.api.enums.LogisticsPayerEnum;
import com.hzchum.scim.scm.core.api.enums.LogisticsTransportTypeEnum;
import com.hzchum.scim.scm.core.api.enums.PlaceEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.enums.SupplyTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.LogisticsOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.LogisticsOrderService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.NumberConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.wms.core.api.enums.WmsWageQuotaTypeEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.InboundDetailDO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.StatisticsMonthManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundDetailManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.InboundManufactured;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialInventoryManufactured;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDetailManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundManufacturedDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundDetailManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.InboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryInboundManufacturedDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsReport.StatisticsMonthManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialInventoryManufacturedService;
import com.hzchum.scim.wms.core.api.service.wmsUse.OutboundManufacturedService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.api.utils.QueryUtilService;
import com.hzchum.scim.wms.core.mapper.wmsUse.InboundManufacturedMapper;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InboundManufacturedServiceImpl extends ServiceImpl<InboundManufacturedMapper, InboundManufactured> implements InboundManufacturedService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private UserService userService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private PurchaseOrderDetailService purchaseOrderDetailService;
   @Resource
   InboundDetailManufacturedService inboundDetailManufacturedService;
   @Resource
   MaterialInventoryManufacturedService materialInventoryManufacturedService;
   @Resource
   LogisticsOrderService logisticsOrderService;
   @Resource
   SupplierService supplierService;
   @Resource
   NumberConfigService numberConfigService;
   @Resource
   WmsApproveRecordService wmsApproveRecordService;
   @Resource
   OutboundManufacturedService outboundManufacturedService;
   @Resource
   StatisticsMonthManufacturedService statisticsMonthManufacturedService;
   @Resource
   TechMesWmsManager techMesWmsManager;
   @Resource
   QueryUtilService queryUtilService;
   @Resource
   NotificationTemplateDetailsUtils detailsUtils;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;

   @Override
   public PageVO<InboundManufacturedDTO> pageInfo(QueryInboundManufacturedDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page page = PageHelper.startPage(pageNumber, pageSize, s);
      List<InboundManufactured> inboundManufactureds = this.baseMapper.listInfo(queryDTOParam);
      if (CollectionUtil.isEmpty(inboundManufactureds)) {
         return new PageVO<>();
      }

      Set<Long> purchaseIds = new TreeSet<>();
      Set<Long> supplierIds = new TreeSet<>();
      Set<Long> projectIds = new TreeSet<>();

      for (InboundManufactured inboundManufactured : inboundManufactureds) {
         if (ObjectUtil.isNotEmpty(inboundManufactured.getPurchaseId())) {
            purchaseIds.add(inboundManufactured.getPurchaseId());
         }

         if (ObjectUtil.isNotEmpty(inboundManufactured.getSupplierId())) {
            supplierIds.add(inboundManufactured.getSupplierId());
         }

         if (ObjectUtil.isNotEmpty(inboundManufactured.getProjectIds())) {
            projectIds.addAll(Arrays.stream(inboundManufactured.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList()));
         }
      }

      Map<Long, PurchaseOrder> prchaseOrderMap = this.queryUtilService.getPurchaseOrderMapByIds(purchaseIds);
      Map<Long, Supplier> supplierMap = this.queryUtilService.getSupplierMapByIds(supplierIds);
      Map<Long, ContractProject> projectMap = this.queryUtilService.getProjectMapByIds(projectIds);
      List<InboundManufacturedDTO> inboundManufacturedDTOS = new ArrayList<>();

      for (InboundManufactured inboundManufactured : inboundManufactureds) {
         InboundManufacturedDTO inboundManufacturedTO = BeanUtil.toBean(inboundManufactured, InboundManufacturedDTO.class);
         inboundManufacturedTO.setPurchaseSN(inboundManufactured.getPurchaseSn());
         inboundManufacturedTO.setSupplier(supplierMap.get(inboundManufactured.getSupplierId()));
         if (StrUtil.isNotBlank(inboundManufactured.getProjectIds())) {
            List<Long> idList = Arrays.stream(org.apache.commons.lang3.StringUtils.split(inboundManufactured.getProjectIds(), ","))
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
            inboundManufacturedTO.setProjects(collect);
         }

         if (inboundManufactured.getPurchaseId() != null) {
            PurchaseOrder byId = prchaseOrderMap.get(inboundManufactured.getPurchaseId());
            inboundManufacturedTO.setPurchaseId(byId.getId());
            inboundManufacturedTO.setPurchaseSN(byId.getSerialNumber());
         }

         inboundManufacturedDTOS.add(inboundManufacturedTO);
      }

      return new PageVO<>(page, inboundManufacturedDTOS);
   }

   @Override
   public PageVO<InboundDetailManufacturedDTO> pageInfoDetail(
      QueryInboundManufacturedDTOParam queryDTOParam, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      String s = StringUtils.analyzeSortConditions(sort);
      Page<InboundDetailDO> page = PageHelper.startPage(pageNumber, pageSize, s);
      List<InboundDetailManufactured> inboundDetailManufactureds = this.inboundDetailManufacturedService.selectList(queryDTOParam);
      if (CollectionUtil.isEmpty(inboundDetailManufactureds)) {
         return new PageVO<>();
      }

      List<InboundDetailManufacturedDTO> inboundDetailManufacturedDTOS = this.inboundDetailManufacturedService.convertDetailDto(inboundDetailManufactureds);
      return new PageVO<>(page, inboundDetailManufacturedDTOS);
   }

   @Override
   public InboundManufacturedDTO getList(Long id) {
      InboundManufactured inboundManufactured = this.baseMapper.selectById(id);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundManufactured), "入库单不存在");
      InboundManufacturedDTO inboundManufacturedDTO = BeanUtil.toBean(inboundManufactured, InboundManufacturedDTO.class);
      if (ObjectUtil.isNotEmpty(inboundManufactured.getPurchaseId())) {
         inboundManufacturedDTO.setPurchaseOrder(this.purchaseOrderService.selectById(inboundManufactured.getPurchaseId()));
         BigDecimal sumAmount = this.baseMapper.selectSunAmount(inboundManufactured.getPurchaseId());
         inboundManufacturedDTO.setSumAmount(sumAmount);
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundId, inboundManufactured.getId()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND_MANUFACTURED.getType())
         );
      if (logisticsOrder != null) {
         inboundManufacturedDTO.setLogisticsOrder(logisticsOrder);
      }

      List<InboundDetailManufactured> inboundDetailManufactureds = this.inboundDetailManufacturedService
         .list((Wrapper<InboundDetailManufactured>)Wrappers.<InboundDetailManufactured>lambdaQuery().eq(InboundDetailManufactured::getInboundManufacturedId, inboundManufactured.getId()));
      List<InboundDetailManufacturedDTO> inboundDetailManufacturedDTOS = this.inboundDetailManufacturedService.convertDetailDto(inboundDetailManufactureds);
      inboundManufacturedDTO.setList(inboundDetailManufacturedDTOS);
      if (ObjectUtil.isNotEmpty(inboundManufactured.getApproveRecordId())) {
         WmsApproveRecordFlowDTO approveRecordFlowDTO = this.wmsApproveRecordService.getApproveRecordDTO(inboundManufactured.getApproveRecordId());
         inboundManufacturedDTO.setWmsApproveRecordFlowDTOS(approveRecordFlowDTO);
      }

      return inboundManufacturedDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveInboundManufactured(InboundManufacturedDTOParam dtoParam) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(dtoParam.getPurchaseId());
      Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在");
      Preconditions.checkArgument(purchaseOrder.getPurchaseType().equals(PurchaseEnum.FINISHED_GOODS.getType()), "采购订单不为制成品采购");
      Preconditions.checkArgument(
         PurchaseStatusEnum.DURING.getType().equals(purchaseOrder.getPurchaseStatus()), "新增入库单失败订单[" + purchaseOrder.getSerialNumber() + "]已完成采购."
      );
      Preconditions.checkArgument(
         SettlementStatusEnum.UN_SETTLED.getType().equals(purchaseOrder.getSettlementStatus()), "新增入库单失败,订单[" + purchaseOrder.getSerialNumber() + "]已结算"
      );
      InboundManufactured inboundManufactured = new InboundManufactured();
      if (LogisticsPayerEnum.DEMAND.getType().equals(purchaseOrder.getLogisticsPayerType())
         && LogisticsTransportTypeEnum.FREIGHT.getType().equals(purchaseOrder.getLogisticsTransportType())) {
         Preconditions.checkArgument(StrUtil.isNotBlank(dtoParam.getLicensePlate()), "请输入车牌号");
      }

      if (StrUtil.isNotBlank(dtoParam.getLicensePlate())) {
         StringBuilder builder = CommonUtil.checkLicensePlate(dtoParam.getLicensePlate());
         inboundManufactured.setLicensePlate(builder.toString());
      }

      inboundManufactured.setSupplierId(purchaseOrder.getSupplierId());
      inboundManufactured.setPurchaseSn(purchaseOrder.getSerialNumber());
      inboundManufactured.setPurchaseId(purchaseOrder.getId());
      inboundManufactured.setReviewStatus(ReviewStatusEnum.AUDITING.getType());
      inboundManufactured.setApplicantId(UserUtil.getCurrentUserId());
      inboundManufactured.setApplicantName(UserUtil.getCurrentName());
      inboundManufactured.setShipmentNumber(dtoParam.getShipmentNumber());
      inboundManufactured.setLoadingWeight(dtoParam.getLoadingWeight());
      if ((dtoParam.getReviewStatus() == null || !ReviewStatusEnum.RETURNED.getType().equals(dtoParam.getReviewStatus()))
         && !ReviewStatusEnum.CANCEL.getType().equals(dtoParam.getReviewStatus())) {
         Integer maxDayNumber = this.baseMapper.getMaxDayNumber(LocalDateTime.now());
         if (maxDayNumber == null) {
            maxDayNumber = 0;
         }

         inboundManufactured.setEditable(true);
         inboundManufactured.setEstablishQuantity(maxDayNumber + 1);
         inboundManufactured.setSerialNumber(this.numberConfigService.getNumber(NumberTypeEnum.INBOUND_MANUFACTURED, maxDayNumber));
      } else {
         InboundManufactured sourceInbound = this.baseMapper.selectById(dtoParam.getId());
         if (sourceInbound.getOriginalId() != null) {
            sourceInbound = this.baseMapper.selectById(sourceInbound.getOriginalId());
         }

         Integer number = sourceInbound.getOriginalNumber();
         number = number + 1;
         sourceInbound.setOriginalNumber(number);
         sourceInbound.setEditable(false);
         this.baseMapper.updateById(sourceInbound);
         inboundManufactured.setSerialNumber(sourceInbound.getSerialNumber() + "-" + number);
         inboundManufactured.setOriginalId(sourceInbound.getId());
         inboundManufactured.setEditable(true);
      }

      this.baseMapper.insert(inboundManufactured);
      this.checkInboundDetailManufacturedParam(inboundManufactured, dtoParam, purchaseOrder);
      if (LogisticsPayerEnum.DEMAND.getType().equals(purchaseOrder.getLogisticsPayerType()) && ObjectUtil.isNotEmpty(dtoParam.getLogistics())) {
         LogisticsOrder logistics = dtoParam.getLogistics();
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(logistics.getFreight()), "请设置运费");
         Preconditions.checkArgument(ObjectUtil.isNotEmpty(logistics.getSupplierId()), "请设置物流公司");
         inboundManufactured.setLogisticsSupplierId(logistics.getSupplierId());
         inboundManufactured.setFreight(logistics.getFreight());
         inboundManufactured.setFreightWeight(logistics.getFreightWeight());
         this.generateLogisticsOrder(dtoParam, inboundManufactured, purchaseOrder, ReviewStatusEnum.UN_REVIEWED.getType());
      }

      StringBuilder subjoinMsgBuilder = new StringBuilder();
      String subjoinMsg = null;
      if (subjoinMsgBuilder.length() > 0) {
         subjoinMsg = subjoinMsgBuilder.toString();
      }

      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService
         .createRecord(
            inboundManufactured.getId(),
            inboundManufactured.getSerialNumber(),
            ApproveProcessTypeEnumV2.MANUFACTURED_IN.getType(),
            dtoParam.getCause(),
            null,
            null,
            false,
            null,
            subjoinMsg,
            null
         );
      inboundManufactured.setApproveRecordId(wmsApproveRecord.getId());
      this.baseMapper.updateById(inboundManufactured);
      if (wmsApproveRecord.getStatus().equals(ApproveRecordStatusEnum.END.getType())) {
         dtoParam.setInboundManufactured(inboundManufactured);
         this.passedInboundManufactured(dtoParam, purchaseOrder);
      }

      this.pushMessage(
         inboundManufactured,
         wmsApproveRecord,
         NotificationModuleTypeEnum.WMS_MATERIAL_SELF_PURCHASE_INBOUND.getNotificationType(),
         SupplyTypeEnum.SELF.getType()
      );
      return true;
   }

   private void pushMessage(
      InboundManufactured inboundManufactured, WmsApproveRecord wmsApproveRecord, Integer notificationModuleTypeEnum, Integer supplyTypeEnum
   ) {
      List<String> userPhoneList = new ArrayList<>();
      WmsApproveRecordFlowDTO approveRecordDTO = this.wmsApproveRecordService.getApproveRecordDTO(wmsApproveRecord.getId());
      if (approveRecordDTO != null) {
         List<WmsApproveFlowDTO> wmsApproveFlowDTOS = approveRecordDTO.getWmsApproveFlowDTOS();
         if (CollectionUtils.isNotEmpty(wmsApproveFlowDTOS)) {
            wmsApproveFlowDTOS.forEach(
               wmsApproveFlowDTO -> {
                  List<WmsApproveRecordDetailDTO> wmsApproveRecordDetailDTOS = wmsApproveFlowDTO.getWmsApproveRecordDetailDTOS();
                  if (CollectionUtils.isNotEmpty(wmsApproveRecordDetailDTOS)) {
                     wmsApproveRecordDetailDTOS.forEach(
                        wmsApproveRecordDetailDTO -> {
                           if (wmsApproveRecordDetailDTO.getUserSimpleResponseVOS() != null
                              && !wmsApproveRecordDetailDTO.getFlowType().equals(ApproveTemplateVersionsFlowEnum.LAUNCH_APPLICATION.getType())) {
                              userPhoneList.add(wmsApproveRecordDetailDTO.getUserSimpleResponseVOS().getPhone());
                           }
                        }
                     );
                  }
               }
            );
         }
      }

      if (CollectionUtils.isNotEmpty(userPhoneList)) {
         this.sysPushFlowConfigBiz
            .triggerFlow(
               NotificationServiceTriggerDTO.builder()
                  .projectId(null)
                  .dataId(inboundManufactured.getId())
                  .userPhoneList(userPhoneList)
                  .contentDetails(
                     supplyTypeEnum.equals(SupplyTypeEnum.SELF.getType())
                        ? this.detailsUtils.getMaterialInboundDetails2(UserUtil.getCurrentUser().getName(), inboundManufactured.getSerialNumber())
                        : this.detailsUtils.getMaterialInboundDetails(UserUtil.getCurrentUser().getName(), inboundManufactured.getSerialNumber())
                  )
                  .notificationTypeEnum(notificationModuleTypeEnum)
                  .userList(new ArrayList<>())
                  .build()
            );
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean revocation(Long id) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      InboundManufactured inboundManufactured = this.baseMapper.selectById(id);
      Preconditions.checkArgument(currentUser.getId().equals(inboundManufactured.getApplicantId()), "仅创建此入库单的人才可进行撤销操作");
      Preconditions.checkArgument(ReviewStatusEnum.AUDITING.getType().equals(inboundManufactured.getReviewStatus()), "只可在创建中才可撤销申请，撤销失败");
      if (ObjectUtil.isNotEmpty(inboundManufactured.getApproveRecordId())) {
         this.wmsApproveRecordService.revocation(inboundManufactured.getApproveRecordId());
      }

      inboundManufactured.setReviewStatus(ReviewStatusEnum.CANCEL.getType());

      for (InboundDetailManufactured detailManufactured : this.inboundDetailManufacturedService
         .list(
            (Wrapper<InboundDetailManufactured>)new LambdaQueryWrapper<InboundDetailManufactured>().eq(InboundDetailManufactured::getInboundManufacturedId, inboundManufactured.getId())
         )) {
         this.updatePDetailInboundData(detailManufactured, null, false);
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundSn, inboundManufactured.getSerialNumber()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND_MANUFACTURED.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.RETURNED.getType());
         logisticsOrder.setUserUpdateTime(LocalDateTime.now());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      int i = this.baseMapper.updateById(inboundManufactured);
      Preconditions.checkArgument(i == 1, "撤销失败");
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean approvalManufacturedInbound(InboundManufacturedDTOParam dtoParam, Long approveRecordId, Integer decision, String opinion) {
      InboundManufactured inboundManufactured = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundManufactured), "入库单不存在");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(inboundManufactured.getReviewStatus()), "当前入库单已审核通过,不能修改");
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(inboundManufactured.getPurchaseId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(purchaseOrder), "采购订单不存在");
      WmsApproveRecord wmsApproveRecord = this.wmsApproveRecordService.getById(approveRecordId);
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(wmsApproveRecord), "审批日志不存在");
      Boolean b = this.wmsApproveRecordService.commonApproveStep(inboundManufactured.getId(), decision, opinion, wmsApproveRecord.getSerialNumber(), null);
      if (b) {
         List<InboundDetailManufactured> list = this.inboundDetailManufacturedService
            .list(
               (Wrapper<InboundDetailManufactured>)new LambdaQueryWrapper<InboundDetailManufactured>()
                  .eq(InboundDetailManufactured::getInboundManufacturedId, inboundManufactured.getId())
            );
         dtoParam.setInboundDetailManufactureds(list);
         if (decision.equals(CheckStatusEnum.PASS.getType())) {
            inboundManufactured.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
            dtoParam.setInboundManufactured(inboundManufactured);
            this.passedInboundManufactured(dtoParam, purchaseOrder);
         } else {
            this.returned(dtoParam);
         }
      }

      return true;
   }

   @Override
   public List<PuchaseInboundDetailDTO> orderDetailV2(Long orderId, List<Long> orderDetailIds) {
      List<InboundManufactured> inboundManufactureds = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(InboundManufactured.class)
               .eq(InboundManufactured::getPurchaseId, orderId)
               .eq(InboundManufactured::getReviewStatus, ReviewStatusEnum.REVIEWED.getType())
         );
      if (CollectionUtils.isEmpty(inboundManufactureds)) {
         return Collections.emptyList();
      }

      List<Long> inboundIds = inboundManufactureds.stream().map(InboundManufactured::getId).collect(Collectors.toList());
      Map<Long, InboundManufactured> inboundManufacturedMap = inboundManufactureds.stream()
         .collect(Collectors.toMap(InboundManufactured::getId, Function.identity()));
      List<WmsApproveRecord> approveRecordList = this.wmsApproveRecordService
         .listByIds(inboundManufactureds.stream().map(InboundManufactured::getApproveRecordId).collect(Collectors.toList()));
      Map<Long, Long> approveRecordIdUserIdMap = approveRecordList.stream()
         .collect(Collectors.toMap(WmsApproveRecord::getId, WmsApproveRecord::getLastApproverId));
      Map<Long, String> reviewUserMap = this.userService
         .listByIds(approveRecordList.stream().map(WmsApproveRecord::getLastApproverId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(User::getId, User::getName));
      List<InboundDetailManufactured> inboundDetailManufactureds = this.inboundDetailManufacturedService
         .list(
            Wrappers.lambdaQuery(InboundDetailManufactured.class)
               .in(InboundDetailManufactured::getInboundManufacturedId, inboundIds)
               .in(CollectionUtils.isNotEmpty(orderDetailIds), InboundDetailManufactured::getPurchaseOrderDetailId, orderDetailIds)
               .orderByDesc(InboundDetailManufactured::getId)
         );
      if (CollectionUtils.isEmpty(inboundDetailManufactureds)) {
         return Collections.emptyList();
      }

      Map<Long, ProjectInfo> projectMap = this.projectService
         .listInfoByIdList(inboundDetailManufactureds.stream().map(InboundDetailManufactured::getProjectId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService
         .list(
            (new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, orderId))
               .in(CollectionUtils.isNotEmpty(orderDetailIds), PurchaseOrderDetail::getId, orderDetailIds)
         );
      List<PuchaseInboundDetailDTO> dtos = new ArrayList<>();
      inboundDetailManufactureds.forEach(
         detail -> {
            InboundManufactured inboundManufactured = inboundManufacturedMap.get(detail.getInboundManufacturedId());
            List<PurchaseOrderDetail> purchaseOrderDetailList = purchaseOrderDetails.stream()
               .filter(d -> d.getId().equals(detail.getPurchaseOrderDetailId()))
               .collect(Collectors.toList());
            BigDecimal mete;
            if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
               mete = detail.getTotalWeight();
            } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
               mete = detail.getTotalLength();
            } else if (detail.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
               mete = detail.getTotalArea();
            } else {
               mete = detail.getQuantity();
            }

            PuchaseInboundDetailDTO build = PuchaseInboundDetailDTO.builder()
               .inboundId(detail.getInboundManufacturedId())
               .inboundSerialNumber(inboundManufactured.getSerialNumber())
               .projectId(detail.getProjectId())
               .project(projectMap.get(detail.getProjectId()))
               .classifyId(null)
               .inboundDetailId(detail.getId())
               .basicClassEnum(detail.getBasicClass())
               .unit(null)
               .brand(detail.getBrand())
               .color(detail.getColor())
               .mete(mete)
               .quantity(detail.getQuantity())
               .accountingUnit(null)
               .wageQuotaType(detail.getWageQuotaType())
               .manufacturedName(detail.getManufacturedName())
               .manufacturedSn(detail.getManufacturedSn())
               .price(detail.getUnitPrice())
               .amount(detail.getAmount())
               .priceExcludingVat(detail.getUnitPriceExcludingVat())
               .amountExcludingVat(detail.getAmountExcludingVat())
               .rejectAmount(null)
               .differentAmount(null)
               .applicant(NameInfo.builder().id(inboundManufactured.getApplicantId()).name(inboundManufactured.getApplicantName()).build())
               .applicantDate(inboundManufactured.getCreateTime())
               .reviewer(
                  NameInfo.builder()
                     .id(approveRecordIdUserIdMap.get(inboundManufactured.getApproveRecordId()))
                     .name(reviewUserMap.get(approveRecordIdUserIdMap.get(inboundManufactured.getApproveRecordId())))
                     .build()
               )
               .reviewerDate(inboundManufactured.getReviewPassTime())
               .finishedGoodsTypeName(purchaseOrderDetailList.get(0).getFinishedGoodsTypeName())
               .material(detail.getMaterial())
               .build();
            build.setRealityInboundAmount(
               build.getAmount()
                  .add(ObjectUtil.isNotEmpty(build.getDifferentAmount()) ? build.getDifferentAmount() : BigDecimal.ZERO)
                  .subtract(ObjectUtil.isNotEmpty(build.getRejectAmount()) ? build.getRejectAmount() : BigDecimal.ZERO)
            );
            String specification = "";
            if (ObjectUtil.isNotEmpty(detail.getThickness())) {
               specification = detail.getThickness() + "";
            }

            if (ObjectUtil.isNotEmpty(detail.getWidth())) {
               specification = ObjectUtil.isEmpty(specification) ? detail.getWidth() + "" : specification + "*" + detail.getWidth();
            }

            if (ObjectUtil.isNotEmpty(detail.getLength())) {
               specification = ObjectUtil.isEmpty(specification) ? detail.getLength() + "" : specification + "*" + detail.getLength();
            }

            if (ObjectUtil.isNotEmpty(detail.getSpecification())) {
               specification = ObjectUtil.isEmpty(specification) ? detail.getSpecification() + "" : specification + "*" + detail.getSpecification();
            }

            build.setSpecification(specification);
            dtos.add(build);
         }
      );
      return dtos;
   }

   private Boolean returned(InboundManufacturedDTOParam dtoParam) {
      InboundManufactured inboundManufactured = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(inboundManufactured != null, "入库单不存在");
      inboundManufactured.setReviewStatus(ReviewStatusEnum.RETURNED.getType());
      inboundManufactured.setReviewPassTime(LocalDateTime.now());
      inboundManufactured.setEditable(true);

      for (InboundDetailManufactured inboundDetailManufactured : this.inboundDetailManufacturedService
         .list(
            (Wrapper<InboundDetailManufactured>)new LambdaQueryWrapper<InboundDetailManufactured>().eq(InboundDetailManufactured::getInboundManufacturedId, inboundManufactured.getId())
         )) {
         this.updatePDetailInboundData(inboundDetailManufactured, null, false);
      }

      if (inboundManufactured.getOriginalId() != null) {
         this.baseMapper.updateEditable(inboundManufactured.getOriginalId(), 1);
      }

      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundSn, inboundManufactured.getSerialNumber()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.RETURNED.getType());
         logisticsOrder.setUserUpdateTime(LocalDateTime.now());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      return this.baseMapper.updateById(inboundManufactured) == 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean returnUpdateInboundManufactured(InboundManufacturedDTOParam dtoParam) {
      PurchaseOrder order = null;
      if (dtoParam.getPurchaseId() != null) {
         order = this.purchaseOrderService.getById(dtoParam.getPurchaseId());
         Preconditions.checkArgument(order != null, "采购订单不存在");
      }

      InboundManufactured inboundManufactured = this.baseMapper.selectById(dtoParam.getId());
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundManufactured), "制成品入库单不存在！！！");
      Preconditions.checkArgument(!ReviewStatusEnum.REVIEWED.getType().equals(inboundManufactured.getReviewStatus()), "当前制成品入库单已审核通过,不能修改！！！");
      if (inboundManufactured.getReviewStatus().equals(ReviewStatusEnum.AUDITING.getType())) {
         dtoParam.setReviewStatus(ReviewStatusEnum.CANCEL.getType());
         this.revocation(inboundManufactured.getId());
      }

      if (!ReviewStatusEnum.RETURNED.getType().equals(inboundManufactured.getReviewStatus())
         && !ReviewStatusEnum.CANCEL.getType().equals(inboundManufactured.getReviewStatus())) {
         Preconditions.checkArgument(false, "仅驳回或撤销后可编辑入库单");
      } else {
         this.saveInboundManufactured(dtoParam);
      }

      return true;
   }

   private void checkInboundDetailManufacturedParam(InboundManufactured inboundManufactured, InboundManufacturedDTOParam dtoParam, PurchaseOrder purchaseOrder) {
      if (!CollectionUtil.isEmpty(dtoParam.getList())) {
         Integer basicClass = 0;
         List<String> projectIds = new ArrayList<>();
         BigDecimal inboundTotalWeight = new BigDecimal(BigInteger.ZERO);
         BigDecimal sumAmount = new BigDecimal(0);
         BigDecimal sumAmountExcludingVat = new BigDecimal(0);
         List<InboundDetailManufactured> inboundDetailManufactureds = new ArrayList<>();

         for (InboundDetailManufacturedDTOParam detailDTOParam : dtoParam.getList()) {
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(detailDTOParam.getPurchaseOrderDetailId()), "缺少采购明细参数！！！");
            PurchaseOrderDetail purchaseOrderDetail = this.purchaseOrderDetailService.getById(detailDTOParam.getPurchaseOrderDetailId());
            Preconditions.checkArgument(ObjectUtil.isNotEmpty(purchaseOrderDetail), "未获取到采购明细信息！！！");
            BigDecimal inboundQuantity = ObjectUtil.isNotEmpty(purchaseOrderDetail.getInboundQuantity())
               ? purchaseOrderDetail.getInboundQuantity()
               : BigDecimal.ZERO;
            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getInboundMete())) {
               purchaseOrderDetail.getInboundMete();
            }

            Preconditions.checkArgument(
               purchaseOrderDetail.getQuantity().compareTo(inboundQuantity.add(detailDTOParam.getQuantity())) > -1,
               "入库数量已超过采购数量，名称为：" + purchaseOrderDetail.getClassifyName()
            );
            basicClass = basicClass | purchaseOrderDetail.getBasicClass();
            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getProjectId())) {
               projectIds.add(purchaseOrderDetail.getProjectId().toString());
            }

            InboundDetailManufactured inboundDetailManufactured = InboundDetailManufactured.builder()
               .inboundManufacturedId(inboundManufactured.getId())
               .purchaseId(purchaseOrder.getId())
               .purchaseOrderDetailId(purchaseOrderDetail.getId())
               .applyPurchaseId(purchaseOrderDetail.getApplyPurchaseId())
               .basicClass(purchaseOrderDetail.getBasicClass())
               .monomerId(purchaseOrderDetail.getMonomerId())
               .areaId(purchaseOrderDetail.getAreaId())
               .projectId(purchaseOrderDetail.getProjectId())
               .artifactEnclosureId(purchaseOrderDetail.getArtifactEnclosureId())
               .manufacturedName(purchaseOrderDetail.getManufacturedName())
               .manufacturedSn(purchaseOrderDetail.getManufacturedSn())
               .material(purchaseOrderDetail.getMaterial())
               .specification(purchaseOrderDetail.getSpecification())
               .length(purchaseOrderDetail.getLength())
               .width(purchaseOrderDetail.getWidth())
               .thickness(purchaseOrderDetail.getThickness())
               .brand(purchaseOrderDetail.getBrand())
               .color(purchaseOrderDetail.getColor())
               .weight(purchaseOrderDetail.getWeight())
               .surfaceArea(purchaseOrderDetail.getSurfaceArea())
               .wageQuotaType(purchaseOrderDetail.getWageQuotaType())
               .manufacturedUnit(purchaseOrderDetail.getManufacturedUnit())
               .unitPriceExcludingVat(purchaseOrderDetail.getUnitPriceExcludingVat())
               .unitPrice(purchaseOrderDetail.getUnitPrice())
               .taxRate(purchaseOrder.getTaxRate())
               .quantity(detailDTOParam.getQuantity())
               .workshopId(ObjectUtil.notEqual(-1L, detailDTOParam.getWorkshopId()) ? detailDTOParam.getWorkshopId() : null)
               .warehouseId(ObjectUtil.notEqual(-1L, detailDTOParam.getWorkshopId()) ? detailDTOParam.getWarehouseId() : null)
               .remark(detailDTOParam.getRemark())
               .build();
            inboundDetailManufactured.setCreateTime(LocalDateTime.now());
            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getLength())) {
               BigDecimal totalLength = inboundDetailManufactured.getQuantity().multiply(purchaseOrderDetail.getLength());
               inboundDetailManufactured.setTotalLength(totalLength);
            }

            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getSurfaceArea())) {
               BigDecimal totalArea = inboundDetailManufactured.getQuantity().multiply(purchaseOrderDetail.getSurfaceArea());
               inboundDetailManufactured.setTotalArea(totalArea);
            }

            if (ObjectUtil.isNotEmpty(purchaseOrderDetail.getWeight())) {
               BigDecimal totalWeight = inboundDetailManufactured.getQuantity().multiply(purchaseOrderDetail.getWeight());
               inboundDetailManufactured.setTotalWeight(totalWeight);
               inboundTotalWeight = inboundTotalWeight.add(totalWeight);
            }

            BigDecimal amount = new BigDecimal(0);
            BigDecimal amountExcludingVat = new BigDecimal(0);
            if (inboundDetailManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_WEIGHT_PRICE.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetailManufactured.getTotalWeight()), "重量不存在，不可为重量计价！！！");
               amount = inboundDetailManufactured.getUnitPrice().multiply(inboundDetailManufactured.getTotalWeight());
               amountExcludingVat = inboundDetailManufactured.getUnitPriceExcludingVat().multiply(inboundDetailManufactured.getTotalWeight());
            } else if (inboundDetailManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_LENGTH_PRICE.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetailManufactured.getTotalLength()), "长度不存在，不可为长度计价！！！");
               amount = inboundDetailManufactured.getUnitPrice().multiply(inboundDetailManufactured.getTotalLength());
               amountExcludingVat = inboundDetailManufactured.getUnitPriceExcludingVat().multiply(inboundDetailManufactured.getTotalLength());
            } else if (inboundDetailManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_AREA_PRICE.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetailManufactured.getTotalArea()), "面积不存在，不可为面积计价！！！");
               amount = inboundDetailManufactured.getUnitPrice().multiply(inboundDetailManufactured.getTotalArea());
               amountExcludingVat = inboundDetailManufactured.getUnitPriceExcludingVat().multiply(inboundDetailManufactured.getTotalArea());
            } else if (inboundDetailManufactured.getWageQuotaType().equals(WmsWageQuotaTypeEnum.WMS_QUANTITY_PRICE.getType())) {
               Preconditions.checkArgument(ObjectUtil.isNotEmpty(inboundDetailManufactured.getQuantity()), "数量不存在，不可为数量计价！！！");
               amount = inboundDetailManufactured.getUnitPrice().multiply(inboundDetailManufactured.getQuantity());
               amountExcludingVat = inboundDetailManufactured.getUnitPriceExcludingVat().multiply(inboundDetailManufactured.getQuantity());
            } else {
               Preconditions.checkArgument(false, "未知计价方式");
            }

            inboundDetailManufactured.setAmount(amount);
            inboundDetailManufactured.setAmountExcludingVat(amountExcludingVat);
            sumAmount = sumAmount.add(amount);
            sumAmountExcludingVat = sumAmountExcludingVat.add(amountExcludingVat);
            if (InvoiceTypeEnum.SPECIAL.getType().equals(purchaseOrder.getInvoiceType())
               || InvoiceTypeEnum.ORDINARY.getType().equals(purchaseOrder.getInvoiceType())) {
               inboundDetailManufactured.setInputVat(amount.subtract(amountExcludingVat));
            }

            this.inboundDetailManufacturedService.save(inboundDetailManufactured);
            inboundDetailManufactureds.add(inboundDetailManufactured);
            this.updatePDetailInboundData(inboundDetailManufactured, purchaseOrderDetail, true);
         }

         dtoParam.setInboundDetailManufactureds(inboundDetailManufactureds);
         inboundManufactured.setBasicClass(basicClass);
         inboundManufactured.setInboundTotalWeight(inboundTotalWeight);
         inboundManufactured.setAmount(sumAmount);
         inboundManufactured.setAmountExcludingVat(sumAmountExcludingVat);
         if (CollectionUtil.isNotEmpty(projectIds)) {
            List<String> projectDistinctIds = projectIds.stream().distinct().collect(Collectors.toList());
            inboundManufactured.setProjectIds(StringUtils.list2String(projectDistinctIds, ","));
         }
      }
   }

   private void updatePDetailInboundData(InboundDetailManufactured detail, PurchaseOrderDetail purchaseOrderDetail, Boolean boolAdd) {
      if (ObjectUtil.isEmpty(purchaseOrderDetail)) {
         purchaseOrderDetail = this.purchaseOrderDetailService.getById(detail.getPurchaseOrderDetailId());
      }

      if (boolAdd) {
         purchaseOrderDetail.setInboundQuantity(
            purchaseOrderDetail.getInboundQuantity() != null ? purchaseOrderDetail.getInboundQuantity().add(detail.getQuantity()) : detail.getQuantity()
         );
      } else {
         purchaseOrderDetail.setInboundQuantity(purchaseOrderDetail.getInboundQuantity().subtract(detail.getQuantity()));
      }

      this.purchaseOrderDetailService.updateById(purchaseOrderDetail);
   }

   private void generateLogisticsOrder(InboundManufacturedDTOParam dtoParam, InboundManufactured inboundManufactured, PurchaseOrder order, Integer type) {
      Supplier byId = this.supplierService.getById(dtoParam.getLogistics().getSupplierId());
      LogisticsOrder logistics = LogisticsOrder.builder()
         .purchaseId(order.getId())
         .invoiceType(dtoParam.getLogistics().getInvoiceType())
         .basicClass(inboundManufactured.getBasicClass())
         .purchaseType(order.getPurchaseType())
         .inboundId(inboundManufactured.getId())
         .inboundSn(inboundManufactured.getSerialNumber())
         .purchaseSn(order.getSerialNumber())
         .licensePlate(inboundManufactured.getLicensePlate())
         .shipmentNumber(dtoParam.getShipmentNumber())
         .projectIds(inboundManufactured.getProjectIds())
         .loadingWeight(inboundManufactured.getLoadingWeight())
         .freight(inboundManufactured.getFreight())
         .freightInitial(inboundManufactured.getFreight())
         .supplierName(byId.getName())
         .supplierId(dtoParam.getLogistics().getSupplierId())
         .applicantId(UserUtil.getCurrentUserId())
         .applicantName(UserUtil.getCurrentName())
         .userUpdateTime(LocalDateTime.now())
         .inboundReviewStatus(type)
         .logisticsPayerType(order.getLogisticsPayerType())
         .logisticsTransportType(order.getLogisticsTransportType())
         .freightWeight(dtoParam.getLogistics().getFreightWeight())
         .loadingCharge(dtoParam.getLogistics().getLoadingCharge())
         .tableNameType(TableNameTypeEnum.WMS_INBOUND_MANUFACTURED.getType())
         .build();
      Integer count = this.logisticsOrderService.getCreateCount();
      NumberConfig numberConfig = this.numberConfigService
         .getOne((Wrapper<NumberConfig>)Wrappers.<NumberConfig>lambdaQuery().eq(NumberConfig::getType, NumberTypeEnum.LOGISTICS_ORDER.getType()));
      String code = CommonUtil.generateSerialNumber(numberConfig.getCode(), LocalDate.now(), count);
      logistics.setSerialNumber(code);
      if ((logistics.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType()) || logistics.getInvoiceType().equals(InvoiceTypeEnum.ORDINARY.getType()))
         && inboundManufactured.getFreight() != null) {
         logistics.setTaxRate(dtoParam.getLogistics().getTaxRate());
         BigDecimal taxRate = logistics.getTaxRate();
         BigDecimal value = taxRate.divide(new BigDecimal(100)).add(BigDecimal.ONE);
         logistics.setAmountExcludingVat(logistics.getFreight().divide(value, 12, 4));
         logistics.setAmountExcludingVatInitial(logistics.getFreight().divide(value, 12, 4));
         if (logistics.getInvoiceType().equals(InvoiceTypeEnum.SPECIAL.getType())) {
            logistics.setInputVat(logistics.getFreight().subtract(logistics.getAmountExcludingVat()));
            logistics.setInputVatInitial(logistics.getFreight().subtract(logistics.getAmountExcludingVat()));
         }

         if (ObjectUtil.isNotEmpty(logistics.getLoadingCharge())) {
            logistics.setLoadingChargeExcludingVat(logistics.getLoadingCharge().divide(value, 12, 4));
         }
      } else {
         logistics.setAmountExcludingVat(logistics.getFreight());
         logistics.setAmountExcludingVatInitial(logistics.getFreight());
         if (ObjectUtil.isNotEmpty(logistics.getLoadingCharge())) {
            logistics.setLoadingChargeExcludingVat(logistics.getLoadingCharge());
         }
      }

      this.logisticsOrderService.save(logistics);
   }

   private boolean passedInboundManufactured(InboundManufacturedDTOParam request, PurchaseOrder purchaseOrder) {
      InboundManufactured inboundManufactured = request.getInboundManufactured();
      List<InboundDetailManufactured> inboundDetailManufactureds = request.getInboundDetailManufactureds();
      PurchaseOrder order = this.purchaseOrderService.getById(inboundManufactured.getPurchaseId());
      Preconditions.checkArgument(!order.getPurchaseStatus().equals(PurchaseStatusEnum.FINISH.getType()), "订单[" + order.getSerialNumber() + "]已完成采购.");
      inboundManufactured.setReviewStatus(ReviewStatusEnum.REVIEWED.getType());
      inboundManufactured.setReviewPassTime(LocalDateTime.now());
      inboundManufactured.setEditable(false);
      BigDecimal amount = BigDecimal.ZERO;
      BigDecimal amountExcludingVAT = BigDecimal.ZERO;
      String monthStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
      ArrayList<SubscribeProductWarehouseDTO> subscribeProductWarehouseDTOS = new ArrayList<>();

      for (InboundDetailManufactured inboundDetailManufactured : inboundDetailManufactureds) {
         amount = amount.add(inboundDetailManufactured.getAmount());
         amountExcludingVAT = amountExcludingVAT.add(inboundDetailManufactured.getAmountExcludingVat());
         this.setMaterialInventoryManufactured(inboundDetailManufactured);
         this.setStatisticsMonthManufactured(inboundDetailManufactured, monthStr);
         this.inboundDetailManufacturedService.updateById(inboundDetailManufactured);
         subscribeProductWarehouseDTOS.add(
            SubscribeProductWarehouseDTO.builder()
               .id(inboundDetailManufactured.getArtifactEnclosureId())
               .quantity(inboundDetailManufactured.getQuantity().intValue())
               .materialInventoryId(inboundDetailManufactured.getMaterialInventoryManufacturedId())
               .basicClass(inboundDetailManufactured.getBasicClass())
               .build()
         );
      }

      this.updatePurchaseStatus(order);
      inboundManufactured.setAmount(amount);
      inboundManufactured.setAmountExcludingVat(amountExcludingVAT);
      LogisticsOrder logisticsOrder = this.logisticsOrderService
         .getOne(
            (Wrapper<LogisticsOrder>)(Wrappers.<LogisticsOrder>lambdaQuery().eq(LogisticsOrder::getInboundSn, inboundManufactured.getSerialNumber()))
               .eq(LogisticsOrder::getTableNameType, TableNameTypeEnum.WMS_INBOUND_MANUFACTURED.getType())
         );
      if (logisticsOrder != null) {
         logisticsOrder.setInboundReviewStatus(ReviewStatusEnum.REVIEWED.getType());
         this.logisticsOrderService.updateById(logisticsOrder);
      }

      if (purchaseOrder.getOrderPlace().equals(PlaceEnum.CONSTRUCTION_SITE.getType())) {
         request.setInboundManufactured(inboundManufactured);
         request.setInboundDetailManufactureds(
            this.inboundDetailManufacturedService
               .list(
                  (Wrapper<InboundDetailManufactured>)new LambdaQueryWrapper<InboundDetailManufactured>()
                     .eq(InboundDetailManufactured::getInboundManufacturedId, inboundManufactured.getId())
               )
         );
         this.outboundManufacturedService.promptlyOut(request);
      } else {
         this.techMesWmsManager.saveSubscribeProductWarehouseEntry(subscribeProductWarehouseDTOS);
      }

      return this.baseMapper.updateById(inboundManufactured) == 1;
   }

   private void updatePurchaseStatus(PurchaseOrder order) {
      List<PurchaseOrderDetail> purchaseOrderDetails = this.purchaseOrderDetailService
         .list((Wrapper<PurchaseOrderDetail>)new LambdaQueryWrapper<PurchaseOrderDetail>().eq(PurchaseOrderDetail::getPurchaseId, order.getId()));
      List<PurchaseOrderDetail> collect = purchaseOrderDetails.stream()
         .filter(p -> p.getQuantity().compareTo(p.getInboundQuantity()) != 0)
         .collect(Collectors.toList());
      if (CollectionUtil.isEmpty(collect)) {
         order.setPurchaseStatus(PurchaseStatusEnum.FINISH.getType());
         order.setUpdateTime(LocalDateTime.now());
         // Keep the loaded fields: a partial entity would clear fields configured with IGNORED.
         Preconditions.checkArgument(this.purchaseOrderService.updateById(order), "采购订单已发生变化，请刷新后重试");
      }
   }

   private void setStatisticsMonthManufactured(InboundDetailManufactured inboundDetailManufactured, String monthStr) {
      StatisticsMonthManufactured statisticsMonthManufactured = this.statisticsMonthManufacturedService
         .getOne(
            (Wrapper<StatisticsMonthManufactured>)(((((new LambdaQueryWrapper<StatisticsMonthManufactured>()
                              .eq(StatisticsMonthManufactured::getMonomerId, inboundDetailManufactured.getMonomerId()))
                           .eq(StatisticsMonthManufactured::getAreaId, inboundDetailManufactured.getAreaId()))
                        .eq(StatisticsMonthManufactured::getManufacturedSn, inboundDetailManufactured.getManufacturedSn()))
                     .eq(StatisticsMonthManufactured::getUnitPrice, inboundDetailManufactured.getUnitPrice()))
                  .eq(StatisticsMonthManufactured::getTaxRate, inboundDetailManufactured.getTaxRate()))
               .eq(StatisticsMonthManufactured::getMonthStr, monthStr)
         );
      if (ObjectUtil.isEmpty(statisticsMonthManufactured)) {
         statisticsMonthManufactured = BeanUtil.toBean(inboundDetailManufactured, StatisticsMonthManufactured.class);
         statisticsMonthManufactured.setInboundTotalQuantity(inboundDetailManufactured.getQuantity());
         statisticsMonthManufactured.setInboundTotalWeight(inboundDetailManufactured.getTotalWeight());
         statisticsMonthManufactured.setInboundTotalLength(inboundDetailManufactured.getTotalLength());
         statisticsMonthManufactured.setInboundTotalArea(inboundDetailManufactured.getTotalArea());
         statisticsMonthManufactured.setInboundAmount(inboundDetailManufactured.getAmount());
         statisticsMonthManufactured.setInboundAmountExcludingVat(inboundDetailManufactured.getAmountExcludingVat());
         statisticsMonthManufactured.setMonthStr(monthStr);
         this.statisticsMonthManufacturedService.save(statisticsMonthManufactured);
      } else {
         statisticsMonthManufactured.setInboundTotalQuantity(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalQuantity())
               ? statisticsMonthManufactured.getInboundTotalQuantity().add(inboundDetailManufactured.getQuantity())
               : inboundDetailManufactured.getQuantity()
         );
         statisticsMonthManufactured.setInboundTotalWeight(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalWeight())
               ? statisticsMonthManufactured.getInboundTotalWeight().add(inboundDetailManufactured.getTotalWeight())
               : inboundDetailManufactured.getTotalWeight()
         );
         statisticsMonthManufactured.setInboundTotalLength(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalLength())
               ? statisticsMonthManufactured.getInboundTotalLength().add(inboundDetailManufactured.getTotalLength())
               : inboundDetailManufactured.getTotalWeight()
         );
         statisticsMonthManufactured.setInboundTotalArea(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundTotalArea())
               ? statisticsMonthManufactured.getInboundTotalArea().add(inboundDetailManufactured.getTotalArea())
               : inboundDetailManufactured.getTotalWeight()
         );
         statisticsMonthManufactured.setInboundAmount(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundAmount())
               ? statisticsMonthManufactured.getInboundAmount().add(inboundDetailManufactured.getAmount())
               : inboundDetailManufactured.getAmount()
         );
         statisticsMonthManufactured.setInboundAmountExcludingVat(
            ObjectUtil.isNotEmpty(statisticsMonthManufactured.getInboundAmountExcludingVat())
               ? statisticsMonthManufactured.getInboundAmountExcludingVat().add(inboundDetailManufactured.getAmountExcludingVat())
               : inboundDetailManufactured.getAmountExcludingVat()
         );
         this.statisticsMonthManufacturedService.updateById(statisticsMonthManufactured);
      }
   }

   private MaterialInventoryManufactured setMaterialInventoryManufactured(InboundDetailManufactured inboundDetailManufactured) {
      MaterialInventoryManufactured materialInventory = this.materialInventoryManufacturedService
         .getOne(
            (Wrapper<MaterialInventoryManufactured>)((((((new LambdaQueryWrapper<MaterialInventoryManufactured>()
                                 .eq(MaterialInventoryManufactured::getMonomerId, inboundDetailManufactured.getMonomerId()))
                              .eq(MaterialInventoryManufactured::getAreaId, inboundDetailManufactured.getAreaId()))
                           .eq(MaterialInventoryManufactured::getManufacturedSn, inboundDetailManufactured.getManufacturedSn()))
                        .eq(MaterialInventoryManufactured::getUnitPrice, inboundDetailManufactured.getUnitPrice()))
                     .eq(MaterialInventoryManufactured::getTaxRate, inboundDetailManufactured.getTaxRate()))
                  .eq(MaterialInventoryManufactured::getWorkshopId, inboundDetailManufactured.getWorkshopId()))
               .eq(MaterialInventoryManufactured::getWarehouseId, inboundDetailManufactured.getWarehouseId())
         );
      if (ObjectUtil.isEmpty(materialInventory)) {
         materialInventory = BeanUtil.toBean(inboundDetailManufactured, MaterialInventoryManufactured.class);
         this.materialInventoryManufacturedService.save(materialInventory);
      } else {
         materialInventory.setQuantity(materialInventory.getQuantity().add(inboundDetailManufactured.getQuantity()));
         materialInventory.setTotalWeight(
            ObjectUtil.isNotEmpty(materialInventory.getTotalWeight())
               ? materialInventory.getTotalWeight().add(inboundDetailManufactured.getTotalWeight())
               : inboundDetailManufactured.getTotalWeight()
         );
         materialInventory.setTotalLength(
            ObjectUtil.isNotEmpty(materialInventory.getTotalLength())
               ? materialInventory.getTotalLength().add(inboundDetailManufactured.getTotalLength())
               : inboundDetailManufactured.getTotalLength()
         );
         materialInventory.setTotalArea(
            ObjectUtil.isNotEmpty(materialInventory.getTotalArea())
               ? materialInventory.getTotalArea().add(inboundDetailManufactured.getTotalArea())
               : inboundDetailManufactured.getTotalArea()
         );
         this.materialInventoryManufacturedService.updateById(materialInventory);
      }

      inboundDetailManufactured.setMaterialInventoryManufacturedId(materialInventory.getId());
      return materialInventory;
   }
}
