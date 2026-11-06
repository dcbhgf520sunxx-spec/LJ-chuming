package com.hzchum.scim.scm.core.biz;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.enums.visa.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSubVisa;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.service.ProjectSubVisaService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderBiz;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderTempBiz;
import com.hzchum.scim.scm.core.api.common.ScmConstants;
import com.hzchum.scim.scm.core.api.enums.InvoiceTypeEnum;
import com.hzchum.scim.scm.core.api.enums.OrderSettlementStatusEnum;
import com.hzchum.scim.scm.core.api.enums.SubOrderChangeTypeEnum;
import com.hzchum.scim.scm.core.api.enums.SubOrderStatusEnum;
import com.hzchum.scim.scm.core.api.enums.SubSupplyTypeEnum;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractClassConfig;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrderTemp;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectBranchCompanyDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubOrderMonomerDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderSummaryDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderV2DTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierInvoiceDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPaymentDetailDto;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SaveSubcontractOrderDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDtoParamV2;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderSaveDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderUpdateDTOParam;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderTempService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.scm.core.mapper.SubcontractOrderMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.NumberConfigService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcontractOrderBizImpl implements SubcontractOrderBiz {
   private static final Logger log = LoggerFactory.getLogger(SubcontractOrderBizImpl.class);
   private final Object $lock = new Object[0];
   @Resource
   private SubcontractClassConfigService subcontractClassConfigService;
   @Resource
   private SubcontractMonomerLinkService subcontractMonomerLinkService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private SubcontractOrderMapper subcontractOrderMapper;
   @Resource
   private NumberConfigService numberConfigService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private ProjectSupplierAreaLinkService supplierAreaLinkService;
   @Resource
   private ProjectSubVisaService projectSubVisaService;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private UserService userService;
   @Resource
   private ConfigService configService;
   @Resource
   private WmsApproveRecordService approvalsService;
   @Resource
   private RedisTemplate redisTemplate;
   @Resource
   private SupplierPaymentService paymentService;
   @Resource
   private SupplierInvoiceService invoiceService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private SubcontractOrderTempService subcontractOrderTempService;
   @Resource
   private SubcontractOrderTempBiz subcontractOrderTempBiz;
   @Resource
   private ProjectBranchCompanyLinkService projectBranchCompanyLinkService;

   @Override
   public PageVO<SubcontractOrderDTO> pageListOrders(SubcontractOrderQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SubcontractOrderDTO> orderDTOList = this.subcontractOrderService.listSubcontractOrder(param);
      if (CollectionUtils.isNotEmpty(orderDTOList)) {
         List<Long> orderIds = orderDTOList.stream().map(SubcontractOrderDTO::getId).collect(Collectors.toList());
         Map<Long, List<Long>> orderIdMonomerIdListMap = this.subcontractMonomerLinkService
            .list(Wrappers.lambdaQuery(SubcontractMonomerLink.class).in(SubcontractMonomerLink::getSubcontractOrderId, orderIds))
            .stream()
            .collect(
               Collectors.groupingBy(
                  SubcontractMonomerLink::getSubcontractOrderId, Collectors.mapping(SubcontractMonomerLink::getMonomerId, Collectors.toList())
               )
            );
         orderDTOList.forEach(dto -> {
            List<Long> monomerIds = orderIdMonomerIdListMap.getOrDefault(dto.getId(), Collections.emptyList());
            dto.setMonomerList(monomerIds.isEmpty() ? Collections.emptyList() : this.monomerService.listNameInfo(monomerIds));
         });
      }

      return new PageVO<>(orderDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean save(SubcontractOrderSaveDTOParam param) {
      SubcontractOrder order = BeanUtil.copy(param, SubcontractOrder.class);
      this.checkSaveOrder(param, order);
      order.setOrderStatus(SubOrderStatusEnum.PROCESSING.getType());
      order.setBoolSettlementStatus(false);
      order.setUserId(UserUtil.getCurrentUserId());
      order.setUserName(UserUtil.getCurrentName());
      order.setSignDate(param.getSignDate() != null ? param.getSignDate() : LocalDate.now());
      this.subcontractOrderService.save(order);
      this.saveLink(order, param.getMonomerIds());
      return true;
   }

   private void checkSaveOrder(SubcontractOrderSaveDTOParam saveDtoParam, SubcontractOrder order) {
      ContractProject project = this.projectService.checkProjectStatus(saveDtoParam.getProjectId());
      Preconditions.checkArgument(project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType()), "项目业务类型不能为加工承揽!");
      int count = this.subcontractOrderService.count(Wrappers.lambdaQuery(SubcontractOrder.builder().serialNumber(saveDtoParam.getSerialNumber()).build()));
      Preconditions.checkArgument(order.getId() != null || count == 0, "订单编号已存在!");
      Supplier supplier = this.supplierService.getById(saveDtoParam.getSupplierId());
      Preconditions.checkArgument(supplier != null, "分包单位(供应商)不存在");
      order.setSupplierName(supplier.getName());
      SubcontractClassConfig subcontractClassConfig = this.subcontractClassConfigService.getById(saveDtoParam.getSubcontractClassId());
      Preconditions.checkArgument(subcontractClassConfig != null, "分包类别不存在");
      order.setSubcontractClassName(subcontractClassConfig.getName());
      Preconditions.checkArgument(
         saveDtoParam.getInvoiceType().equals(InvoiceTypeEnum.RECEIPT.getType())
            || saveDtoParam.getTaxRate() != null && saveDtoParam.getTaxRate().compareTo(BigDecimal.ZERO) >= 0,
         "税率超出范围!"
      );
      order.setTaxRate(saveDtoParam.getInvoiceType().equals(InvoiceTypeEnum.RECEIPT.getType()) ? BigDecimal.ZERO : saveDtoParam.getTaxRate());
      if (CollectionUtils.isNotEmpty(saveDtoParam.getAttachmentIds())) {
         saveDtoParam.getAttachmentIds().forEach(aId -> {
            AttachmentDTO attachmentDTO = this.attachmentService.getById(aId);
            Preconditions.checkArgument(attachmentDTO != null, "附件不存在!");
         });
         order.setAttachmentIds(StringUtils.join(saveDtoParam.getAttachmentIds(), ","));
      }

      saveDtoParam.getMonomerIds()
         .forEach(
            monomerId -> {
               int count2 = this.subcontractMonomerLinkService
                  .count(
                     Wrappers.lambdaQuery(SubcontractMonomerLink.class)
                        .eq(SubcontractMonomerLink::getMonomerId, monomerId)
                        .eq(SubcontractMonomerLink::getSubcontractClassId, saveDtoParam.getSubcontractClassId())
                        .eq(SubcontractMonomerLink::getBoolSettlementStatus, false)
                        .eq(SubcontractMonomerLink::getSupplierId, saveDtoParam.getSupplierId())
                  );
               Preconditions.checkArgument(order.getId() != null || count2 == 0, "单体和分包商之间,已存在" + subcontractClassConfig.getName() + "订单");
            }
         );
   }

   private void saveLink(SubcontractOrder order, Set<Long> monomerIds) {
      monomerIds.forEach(
         id -> {
            PlanMonomer monomer = this.monomerService.getById(id);
            Preconditions.checkArgument(monomer != null, "单体不存在!");
            SubcontractMonomerLink link = SubcontractMonomerLink.builder()
               .subcontractOrderId(order.getId())
               .subcontractClassId(order.getSubcontractClassId())
               .boolSettlementStatus(order.getBoolSettlementStatus())
               .monomerId(id)
               .projectId(order.getProjectId())
               .supplierId(order.getSupplierId())
               .supplierName(order.getSupplierName())
               .build();
            this.subcontractMonomerLinkService.save(link);
         }
      );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean update(SubcontractOrderUpdateDTOParam updateParam) {
      SubcontractOrder order = this.subcontractOrderService.getById(updateParam.getId());
      this.checkUpdateOrder(order, updateParam);
      SubcontractOrderSaveDTOParam saveParam = BeanUtil.copy(updateParam, SubcontractOrderSaveDTOParam.class);
      saveParam.setAttachmentIds(updateParam.getAttachmentIds());
      saveParam.setMonomerIds(updateParam.getMonomerIds());
      this.checkSaveOrder(saveParam, order);
      BeanUtil.copy(updateParam, order);
      this.subcontractOrderService.updateById(order);
      this.subcontractMonomerLinkService.remove(Wrappers.lambdaQuery(SubcontractMonomerLink.builder().subcontractOrderId(order.getId()).build()));
      this.saveLink(order, updateParam.getMonomerIds());
      return true;
   }

   void checkUpdateOrder(SubcontractOrder order, SubcontractOrderUpdateDTOParam param) {
      Preconditions.checkArgument(order != null, "修改失败,订单不存在");
      Preconditions.checkArgument(!order.getBoolSettlementStatus(), "修改失败,订单已结算");
      Preconditions.checkArgument(param.getProjectId().equals(order.getProjectId()), "修改失败,不能修改订单项目!");
      int count = this.supplierPaymentService
         .count(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, order.getId())
               .eq(SupplierPayment::getReceivingUnitId, order.getSupplierId())
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         );
      Preconditions.checkArgument(param.getSupplierId().equals(order.getSupplierId()) || count == 0, "修改失败,分包订单已付款!");
      Preconditions.checkArgument(param.getSerialNumber().equals(order.getSerialNumber()) || count == 0, "修改失败,分包订单已付款!");
      count = this.supplierInvoiceService
         .count(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, order.getId())
               .eq(SupplierInvoice::getSupplierId, order.getSupplierId())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         );
      Preconditions.checkArgument(param.getSupplierId().equals(order.getSupplierId()) || count == 0, "修改失败,分包订单已开票!");
      Preconditions.checkArgument(
         param.getInvoiceType().equals(order.getInvoiceType()) && Objects.equals(param.getTaxRate(), order.getTaxRate()) || count == 0, "修改失败,分包订单已开票!"
      );
      count = this.projectSubVisaService
         .count(
            Wrappers.lambdaQuery(ProjectSubVisa.class)
               .eq(ProjectSubVisa::getSubcontractOrderId, order.getId())
               .ne(ProjectSubVisa::getAuditStatus, AuditStatusEnum.FAILED.getType())
         );
      Preconditions.checkArgument(param.getSupplierId().equals(order.getSupplierId()) || count == 0, "修改失败,订单供应商已提交签证");
      List<ProjectSupplierAreaLink> supplierAreaLinks = this.supplierAreaLinkService
         .list(Wrappers.lambdaQuery(ProjectSupplierAreaLink.class).eq(ProjectSupplierAreaLink::getSubcontractOrderId, order.getId()));
      Preconditions.checkArgument(
         param.getSubcontractClassId().equals(order.getSubcontractClassId()) || count == 0 && supplierAreaLinks.isEmpty(), "不可修改订单类别,订单已执行!"
      );
      Preconditions.checkArgument(param.getSupplierId().equals(order.getSupplierId()) || supplierAreaLinks.isEmpty(), "不可修改订单分包商,订单已执行!");
      List<Long> oldMonomerIdList = this.subcontractMonomerLinkService
         .list(Wrappers.lambdaQuery(SubcontractMonomerLink.builder().subcontractOrderId(param.getId()).build()))
         .stream()
         .map(SubcontractMonomerLink::getMonomerId)
         .collect(Collectors.toList());
      oldMonomerIdList.forEach(
         monomerId -> {
            if (!param.getMonomerIds().contains(monomerId)) {
               List<ProjectSupplierAreaLink> areaLinkList = supplierAreaLinks.stream()
                  .filter(s -> s.getMonomerId().equals(monomerId))
                  .collect(Collectors.toList());
               Preconditions.checkArgument(areaLinkList.isEmpty(), "不可删除单体,单体区域已执行该订单!");
            }
         }
      );
      param.getMonomerIds()
         .forEach(
            monomerId -> {
               if (!oldMonomerIdList.contains(monomerId)) {
                  int count2 = this.subcontractMonomerLinkService
                     .count(
                        Wrappers.lambdaQuery(SubcontractMonomerLink.class)
                           .eq(SubcontractMonomerLink::getMonomerId, monomerId)
                           .eq(SubcontractMonomerLink::getSubcontractClassId, param.getSubcontractClassId())
                           .eq(SubcontractMonomerLink::getSupplierId, param.getSupplierId())
                           .eq(SubcontractMonomerLink::getBoolSettlementStatus, false)
                     );
                  Preconditions.checkArgument(count2 == 0, "新增单体失败,单体和分包商已存在订单!");
               }
            }
         );
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         this.checkRemoveOrder(id);
         this.subcontractOrderService.removeById(id);
         this.subcontractMonomerLinkService.remove(Wrappers.lambdaQuery(SubcontractMonomerLink.builder().subcontractOrderId(id).build()));
      });
      return true;
   }

   private void checkRemoveOrder(Long id) {
      SubcontractOrder order = this.subcontractOrderService.getById(id);
      Preconditions.checkArgument(order != null, "删除失败,分包订单不存在");
      this.projectService.checkProjectStatus(order.getProjectId());
      Preconditions.checkArgument(!order.getBoolSettlementStatus(), "删除失败,订单已结算");
      int count = this.supplierSettlementService
         .count(Wrappers.lambdaQuery(SupplierSettlement.builder().orderId(id).orderClass(OrderClassEnum.SUB_ORDER.getType()).build()));
      Preconditions.checkArgument(count == 0, "删除失败,订单存在结算申请记录");
      count = this.supplierPaymentService
         .count(Wrappers.lambdaQuery(SupplierPayment.builder().orderId(id).propertyType(SupplierPropertyTypeEnum.SUB_FEE.getType()).build()));
      Preconditions.checkArgument(count == 0, "删除失败,订单已存在付款记录!");
      count = this.supplierInvoiceService
         .count(Wrappers.lambdaQuery(SupplierInvoice.builder().orderId(id).propertyType(SupplierPropertyTypeEnum.SUB_FEE.getType()).build()));
      Preconditions.checkArgument(count == 0, "删除失败,订单已存在收票记录!");
      count = this.projectSubVisaService.count(Wrappers.lambdaQuery(ProjectSubVisa.class).eq(ProjectSubVisa::getSubcontractOrderId, order.getId()));
      Preconditions.checkArgument(count == 0, "删除失败,订单供应商已提交签证!");
      count = this.supplierAreaLinkService.count(Wrappers.lambdaQuery(ProjectSupplierAreaLink.builder().subcontractOrderId(id).build()));
      Preconditions.checkArgument(count == 0, "删除失败,订单已执行!");
   }

   @Override
   public SubcontractOrderSummaryDTO getSumSubcontractOrder() {
      List<SubcontractOrder> orderList = this.subcontractOrderService.list();
      long count = orderList.stream().filter(o -> o.getBoolSettlementStatus().equals(OrderSettlementStatusEnum.SETTLED.isType())).count();
      BigDecimal amount = orderList.stream().map(SubcontractOrder::getAmount).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
      BigDecimal settlementAmount = orderList.stream()
         .filter(o -> o.getBoolSettlementStatus().equals(OrderSettlementStatusEnum.SETTLED.isType()))
         .map(SubcontractOrder::getSettlementAmount)
         .reduce(BigDecimal::add)
         .orElse(BigDecimal.ZERO);
      return SubcontractOrderSummaryDTO.builder()
         .amount(amount)
         .orderQuantity(orderList.size())
         .settlementQuantity(Math.toIntExact(count))
         .unSettlementQuantity(orderList.size() - Math.toIntExact(count))
         .settlementAmount(settlementAmount)
         .build();
   }

   @Override
   public List<SubOrderMonomerDTO> listByCondition(Long projectId) {
      ProjectSupplierAccount supplierAccount = this.supplierAccountService
         .getOne(Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getUserId, UserUtil.getCurrentUserId()));
      return this.subcontractMonomerLinkService.listByCondition(projectId, supplierAccount.getSupplierId(), ScmConstants.LABOR_SUB_ID);
   }

   @Override
   public PageVO<SubcontractOrderV2DTO> getPage(SubcontractOrderQueryDtoParamV2 param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SubcontractOrder> list = this.subcontractOrderService.getPageList(param);
      if (CollectionUtils.isNotEmpty(list)) {
         List<Long> orderIds = list.stream().map(SubcontractOrder::getId).collect(Collectors.toList());
         Map<Long, String> branchCompanyMap = this.branchCompanyService.list().stream().collect(Collectors.toMap(BranchCompany::getId, BranchCompany::getName));
         Map<Long, ProjectInfo> projectMap = this.projectService
            .listSimpleByIdList(list.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(ProjectInfo::getId, Function.identity()));
         Map<Long, Supplier> supplierMap = this.supplierService.list().stream().collect(Collectors.toMap(Supplier::getId, Function.identity()));
         List<SubcontractOrderV2DTO> dtoList = new ArrayList<>();
         list.forEach(
            order -> {
               SubcontractOrderV2DTO build = SubcontractOrderV2DTO.builder()
                  .id(order.getId())
                  .serialNumber(order.getSerialNumber())
                  .project(projectMap.get(order.getProjectId()))
                  .createDate(order.getSignDate().atStartOfDay())
                  .subSupplyTypeEnum(order.getSubcontractClassId())
                  .branchCompanyId(order.getBranchCompanyId())
                  .branchCompanyName(branchCompanyMap.getOrDefault(order.getBranchCompanyId(), "/"))
                  .supplier(SupplierInfo.builder().supplierId(order.getSupplierId()).supplierName(supplierMap.get(order.getSupplierId()).getName()).build())
                  .amount(order.getAmount())
                  .boolSettlementStatus(order.getBoolSettlementStatus())
                  .settlementAmount(order.getSettlementAmount())
                  .orderStatus(order.getOrderStatus())
                  .user(NameInfo.builder().id(order.getUserId()).name(order.getUserName()).build())
                  .build();
               dtoList.add(build);
            }
         );
         this.setSubOrderFinanceInfo(dtoList, orderIds);
         return new PageVO<>(PageUtils.getPageInfo(dtoList, list));
      } else {
         return new PageVO<>();
      }
   }

   private void setSubOrderFinanceInfo(List<SubcontractOrderV2DTO> subcontractOrderV2DTOList, List<Long> orderIds) {
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getOrderId, orderIds)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         );
      Map<Long, BigDecimal> supplierPaymentMap = supplierPaymentList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(
            Collectors.groupingBy(
               SupplierPayment::getOrderId,
               Collectors.mapping(SupplierPayment::getActuallyPaymentAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, Long> orderUnAuditPaymentCountMap = supplierPaymentList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()))
         .collect(Collectors.groupingBy(SupplierPayment::getOrderId, Collectors.counting()));
      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               .in(SupplierInvoice::getOrderId, orderIds)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         );
      Map<Long, BigDecimal> supplierInvoiceMap = supplierInvoiceList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getOrderId, Collectors.mapping(SupplierInvoice::getActualInvoiceAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
      Map<Long, Long> orderUnAuditInvoiceCountMap = supplierInvoiceList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()))
         .collect(Collectors.groupingBy(SupplierInvoice::getOrderId, Collectors.counting()));
      List<SupplierSettlement> settlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderId, orderIds)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
         );
      Map<Long, BigDecimal> orderIdPreSettleAmountMap = settlementList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .filter(SupplierSettlement::getBoolPreSettlement)
         .collect(Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.reducing(BigDecimal.ZERO, SupplierSettlement::getAmount, BigDecimal::add)));
      Map<Long, Map<Boolean, Long>> orderUnAuditSettlementCountMap = settlementList.stream()
         .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()))
         .collect(Collectors.groupingBy(SupplierSettlement::getOrderId, Collectors.groupingBy(SupplierSettlement::getBoolPreSettlement, Collectors.counting())));
      subcontractOrderV2DTOList.forEach(dto -> {
         dto.setTotalPayment(supplierPaymentMap.getOrDefault(dto.getId(), BigDecimal.ZERO));
         dto.setTotalInvoice(supplierInvoiceMap.getOrDefault(dto.getId(), BigDecimal.ZERO));
         dto.setPreSettlementAmount(orderIdPreSettleAmountMap.getOrDefault(dto.getId(), BigDecimal.ZERO));
         if (!dto.getBoolSettlementStatus()) {
            dto.setPaymentRate(dto.getTotalPayment().multiply(BigDecimal.valueOf(100L)).divide(dto.getAmount(), 4, RoundingMode.DOWN));
            dto.setInvoiceRate(dto.getTotalInvoice().multiply(BigDecimal.valueOf(100L)).divide(dto.getAmount(), 4, RoundingMode.DOWN));
         } else {
            dto.setPaymentRate(dto.getTotalPayment().multiply(BigDecimal.valueOf(100L)).divide(dto.getSettlementAmount(), 4, RoundingMode.DOWN));
            dto.setInvoiceRate(dto.getTotalInvoice().multiply(BigDecimal.valueOf(100L)).divide(dto.getSettlementAmount(), 4, RoundingMode.DOWN));
         }

         dto.setPaymentSize(orderUnAuditPaymentCountMap.getOrDefault(dto.getId(), 0L).intValue());
         dto.setInvoiceSize(orderUnAuditInvoiceCountMap.getOrDefault(dto.getId(), 0L).intValue());
         dto.setSettlementSize(orderUnAuditSettlementCountMap.getOrDefault(dto.getId(), Collections.emptyMap()).getOrDefault(false, 0L).intValue());
         dto.setPreSettlementSize(orderUnAuditSettlementCountMap.getOrDefault(dto.getId(), Collections.emptyMap()).getOrDefault(true, 0L).intValue());
      });
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSubcontractOrder(SaveSubcontractOrderDTOParam param) {
      synchronized (this.$lock) {
         Preconditions.checkArgument(param.getAmount().compareTo(BigDecimal.ZERO) > 0, "创建失败,合同额不能为0!");
         ContractProject project = this.projectService.getOne(Wrappers.lambdaQuery(ContractProject.class).eq(ContractProject::getId, param.getProjectId()));
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
         Preconditions.checkArgument(!project.getBusinessType().equals(ProjectBusinessTypeEnum.PROCESS.getType()), "创建失败,该项目类型为加工订单!");
         Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "项目已结算，无法新增分包合同");
         ProjectBranchCompanyLink projectBranchCompanyLink = this.projectBranchCompanyLinkService
            .getOne(
               Wrappers.lambdaQuery(ProjectBranchCompanyLink.builder().projectId(param.getProjectId()).branchCompanyId(param.getBranchCompanyId()).build())
            );
         Preconditions.checkArgument(projectBranchCompanyLink != null, "项目不能选择当前分支机构!");
         param.setLevel(projectBranchCompanyLink.getBranchCompanyLevel());
         Supplier supplier = this.supplierService.getById(param.getSupplierId());
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(supplier), "供应商不存在");
         param.setSupplierName(supplier.getName());
         SubSupplyTypeEnum supplyTypeEnum = SubSupplyTypeEnum.getByType(param.getSubcontractClassId());
         Preconditions.checkArgument(supplyTypeEnum != null, "分供类型不存在!");
         param.setSubcontractClassName(supplyTypeEnum.getName());
         this.checkTaxRate(param);
         if (StringUtils.isBlank(param.getSerialNumber())) {
            String number = this.getSerialNumber("subcontract_order", 3);
            param.setSerialNumber(supplier.getShortName() + number);
         }

         SubcontractOrder one = this.subcontractOrderService
            .getOne(Wrappers.lambdaQuery(SubcontractOrder.class).eq(SubcontractOrder::getSerialNumber, param.getSerialNumber()));
         Preconditions.checkArgument(one == null, "分包合同编号已存在!");
         int count = this.subcontractOrderTempService
            .count(
               Wrappers.lambdaQuery(SubcontractOrderTemp.class)
                  .eq(SubcontractOrderTemp::getChangeTypeEnum, SubOrderChangeTypeEnum.ADD.getType())
                  .eq(SubcontractOrderTemp::getAuditStatusEnum, AuditStatusEnum.AUDITING.getType())
            );
         Preconditions.checkArgument(count == 0, "合同编号已存在!");
         SubcontractOrderTemp orderTemp = this.saveTempOrder(project, SubOrderChangeTypeEnum.ADD.getType(), param);
         this.subcontractOrderTempBiz.handleAuditSuccess(orderTemp);
         return Boolean.TRUE;
      }
   }

   private void checkTaxRate(SaveSubcontractOrderDTOParam param) {
      if (!param.getInvoiceType().equals(InvoiceTypeEnum.RECEIPT.getType())) {
         Preconditions.checkArgument(StringUtils.isNotBlank(param.getTaxRateTypeValue()), "税率类型不能为空!");
         SysDictionary dictionary = this.dictionaryService
            .getOne(
               Wrappers.lambdaQuery(SysDictionary.class)
                  .eq(SysDictionary::getName, DictionaryEnum.INVOICE_TAX_RATE.getName())
                  .eq(SysDictionary::getValue, param.getTaxRateTypeValue())
            );
         Preconditions.checkArgument(dictionary != null, "税率类型有误!");
         param.setTaxRateTypeValue(dictionary.getValue());
         param.setTaxRate(new BigDecimal(dictionary.getLabel()));
      } else {
         param.setTaxRateTypeValue(null);
         param.setTaxRate(BigDecimal.ZERO);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateSubcontractOrder(SaveSubcontractOrderDTOParam param) {
      Preconditions.checkArgument(param.getAmount().compareTo(BigDecimal.ZERO) > 0, "创建失败,合同额不能为0!");
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(param.getId());
      Preconditions.checkArgument(subcontractOrder != null, "订单不存在!");
      Preconditions.checkArgument(!subcontractOrder.getBoolSettlementStatus(), "订单已结算!不可修改!");
      int count = this.subcontractOrderTempService
         .count(Wrappers.lambdaQuery(SubcontractOrderTemp.builder().orderId(param.getId()).auditStatusEnum(AuditStatusEnum.AUDITING.getType()).build()));
      Preconditions.checkArgument(count == 0, "订单正在审批中!暂无法修改!");
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, param.getId())
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, param.getId())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      List<SupplierSettlement> supplierSettlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getId())
               .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
               .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project != null, "项目数据不存在!");
      if (!param.getProjectId().equals(subcontractOrder.getProjectId())) {
         Preconditions.checkArgument(supplierPaymentList.isEmpty(), "修改失败,订单已存在付款记录!");
         Preconditions.checkArgument(supplierInvoiceList.isEmpty(), "修改失败,订单已存在收票记录!");
         Preconditions.checkArgument(supplierSettlementList.isEmpty(), "修改失败,订单正在结算中!");
         Preconditions.checkArgument(!project.getBusinessType().equals(ProjectBusinessTypeEnum.PROCESS.getType()), "修改失败,该项目为加工订单!");
         Preconditions.checkArgument(project.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "项目已结算，无法新增分包合同");
      }

      Preconditions.checkArgument(StringUtils.isNotBlank(param.getSerialNumber()), "订单编号不能为空!");
      if (!param.getSerialNumber().equals(subcontractOrder.getSerialNumber())) {
         count = this.subcontractOrderService.count(Wrappers.lambdaQuery(SubcontractOrder.builder().serialNumber(param.getSerialNumber()).build()));
         Preconditions.checkArgument(count == 0, "修改失败,订单编号已存在!");
         count = this.subcontractOrderTempService
            .count(
               Wrappers.lambdaQuery(
                  SubcontractOrderTemp.builder()
                     .serialNumber(param.getSerialNumber())
                     .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
                     .changeTypeEnum(SubOrderChangeTypeEnum.ADD.getType())
                     .build()
               )
            );
         Preconditions.checkArgument(count == 0, "修改失败,订单编号已使用!");
      }

      if (!subcontractOrder.getBranchCompanyId().equals(param.getBranchCompanyId())) {
         Preconditions.checkArgument(supplierPaymentList.isEmpty(), "修改失败,订单已存在付款记录!");
         Preconditions.checkArgument(supplierInvoiceList.isEmpty(), "修改失败,订单已存在收票记录!");
         Preconditions.checkArgument(supplierSettlementList.isEmpty(), "修改失败,订单正在结算中!");
         ProjectBranchCompanyLink projectBranchCompanyLink = this.projectBranchCompanyLinkService
            .getOne(
               Wrappers.lambdaQuery(ProjectBranchCompanyLink.builder().projectId(param.getProjectId()).branchCompanyId(param.getBranchCompanyId()).build())
            );
         Preconditions.checkArgument(projectBranchCompanyLink != null, "项目不能选择当前分支机构!");
         param.setLevel(projectBranchCompanyLink.getBranchCompanyLevel());
      }

      if (!param.getSupplierId().equals(subcontractOrder.getSupplierId())) {
         Preconditions.checkArgument(supplierPaymentList.isEmpty(), "修改失败,订单已存在付款记录!");
         Preconditions.checkArgument(supplierInvoiceList.isEmpty(), "修改失败,订单已存在收票记录!");
         Preconditions.checkArgument(supplierSettlementList.isEmpty(), "修改失败,订单正在结算中!");
         Supplier supplier = this.supplierService.getById(param.getSupplierId());
         Preconditions.checkArgument(supplier != null, "修改失败,供应商不存在!");
         param.setSupplierName(supplier.getName());
      }

      if (param.getAmount().compareTo(subcontractOrder.getAmount()) < 0) {
         FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
         if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
            BigDecimal paymentAmount = supplierPaymentList.stream()
               .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            Preconditions.checkArgument(param.getAmount().compareTo(paymentAmount) >= 0, "合同额不能小于付款总额(含未审批)!");
            BigDecimal invoiceAmount = supplierInvoiceList.stream()
               .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            Preconditions.checkArgument(param.getAmount().compareTo(invoiceAmount) >= 0, "合同额不能小于收票总额(含未审批)!");
         }
      }

      if (!param.getSubcontractClassId().equals(subcontractOrder.getSubcontractClassId())) {
         SubSupplyTypeEnum subSupplyTypeEnum = SubSupplyTypeEnum.getByType(param.getSubcontractClassId());
         Preconditions.checkArgument(subSupplyTypeEnum != null, "分工类型不存在!");
         param.setSubcontractClassName(subSupplyTypeEnum.getName());
      }

      this.checkTaxRate(param);
      SubcontractOrderTemp orderTemp = this.saveTempOrder(project, SubOrderChangeTypeEnum.UPDATE.getType(), param);
      this.subcontractOrderTempBiz.handleAuditSuccess(orderTemp);
      return true;
   }

   private SubcontractOrderTemp saveTempOrder(ContractProject project, Integer changeTypeEnum, SaveSubcontractOrderDTOParam param) {
      if (param.getUserId() != null) {
         String userName = this.userService.getNameById(param.getUserId());
         Preconditions.checkArgument(StringUtils.isNotBlank(userName), "创建人不存在!");
      }

      SubcontractOrderTemp temp = BeanUtil.copy(param, SubcontractOrderTemp.class);
      temp.setOrderId(param.getId());
      temp.setChangeTypeEnum(changeTypeEnum);
      temp.setSignDate(param.getSignDate() != null ? param.getSignDate() : LocalDate.now());
      temp.setProjectAttribute(project.getProjectAttribute());
      temp.setProjectManagerId(project.getProjectManagerId());
      temp.setUserId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId());
      temp.setUserName(this.userService.getNameById(temp.getUserId()));
      temp.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      temp.setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      temp.setOperationUserId(UserUtil.getCurrentUserId());
      this.subcontractOrderTempService.save(temp);
      return temp;
   }

   @Override
   public PageVO<SupplierPaymentDetailDto> getPaymentList(Long orderId, Integer pageNumber, Integer pageSize) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "合同不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierPayment> paymentList = this.paymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(SupplierPayment::getId)
         );
      List<SupplierPaymentDetailDto> subPaymentList = this.getSubPaymentList(paymentList);
      return new PageVO<>(PageUtils.getPageInfo(subPaymentList, paymentList));
   }

   private List<SupplierPaymentDetailDto> getSubPaymentList(List<SupplierPayment> paymentList) {
      if (paymentList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, BranchCompany> branchCompanyMap = this.branchCompanyService
         .list()
         .stream()
         .collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      Map<Long, Supplier> supplierMap = this.supplierService
         .listByIds(paymentList.stream().map(SupplierPayment::getSupplierId).collect(Collectors.toSet()))
         .stream()
         .collect(Collectors.toMap(Supplier::getId, Function.identity()));
      return paymentList.stream()
         .map(
            s -> {
               BranchCompany branchCompany = branchCompanyMap.get(s.getBranchCompanyId());
               Supplier supplier = supplierMap.get(s.getSupplierId());
               return SupplierPaymentDetailDto.builder()
                  .paymentDate(s.getPaymentDate().atStartOfDay())
                  .paymentType(StringUtils.isNotBlank(s.getPaymentReasonId()) ? Integer.valueOf(s.getPaymentReasonId()) : null)
                  .paymentAmount(s.getActuallyPaymentAmount())
                  .contractSignBody(NameInfo.builder().id(s.getBranchCompanyId()).name(branchCompany != null ? branchCompany.getName() : "").build())
                  .paymentBank(s.getPaymentBank())
                  .supplierId(s.getSupplierId())
                  .supplierName(supplier != null ? supplier.getName() : "")
                  .paymentPerson(NameInfo.builder().id(s.getApplyUserId()).name(s.getApplyUserName()).build())
                  .paymentAttributeId(s.getPaymentAttributeId())
                  .paymentAttributeName(s.getPaymentAttributeName())
                  .auditUser(NameInfo.builder().id(s.getAuditUserId()).name(s.getAuditUserName()).build())
                  .attachmentList(this.attachmentService.listByIds(s.getAttachmentIds()))
                  .attachments(this.attachmentService.listByIds(s.getAttachmentIds()))
                  .build();
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<SupplierPaymentDetailDto>> printPaymentList(Long orderId) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在!");
      PrintVO<List<SupplierPaymentDetailDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      this.setPrintHeader(header, subcontractOrder);
      printVO.setHeader(header);
      List<SupplierPayment> paymentList = this.paymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(SupplierPayment::getId)
         );
      List<SupplierPaymentDetailDto> subPaymentList = this.getSubPaymentList(paymentList);
      printVO.setTable(subPaymentList);
      return printVO;
   }

   private void setPrintHeader(Map<String, Object> header, SubcontractOrder subcontractOrder) {
      ProjectInfo project = this.projectService.getSimpleById(subcontractOrder.getProjectId());
      Preconditions.checkArgument(project != null, "订单所属项目不存在!");
      header.put("serialNumber", subcontractOrder.getSerialNumber());
      header.put("applicantName", subcontractOrder.getUserName());
      header.put("createTime", subcontractOrder.getSignDate());
      header.put("branchCompany", this.branchCompanyService.getNameById(subcontractOrder.getBranchCompanyId()));
      header.put("supplier", this.supplierService.getNameById(subcontractOrder.getSupplierId()));
      header.put("project", project.getSerialNumber() + "_" + project.getShortName());
      header.put("amount", subcontractOrder.getAmount());
      header.put("settlementStatus", subcontractOrder.getBoolSettlementStatus() ? "已结算" : "未结算");
      header.put("settlementAmount", subcontractOrder.getBoolSettlementStatus() ? subcontractOrder.getSettlementAmount() : "/");
      header.put("basicClass", SubSupplyTypeEnum.getNameByType(subcontractOrder.getSubcontractClassId()));
      BigDecimal paymentAmount = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierPayment::getOrderId, subcontractOrder.getId())
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         )
         .stream()
         .map(SupplierPayment::getActuallyPaymentAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      BigDecimal invoiceAmount = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getOrderId, subcontractOrder.getId())
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         )
         .stream()
         .map(SupplierInvoice::getActualInvoiceAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      header.put("cumulativePayment", paymentAmount);
      BigDecimal paymentRate = subcontractOrder.getBoolSettlementStatus()
         ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(subcontractOrder.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            subcontractOrder.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? paymentAmount.multiply(BigDecimal.valueOf(100L)).divide(subcontractOrder.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("paymentRate", paymentRate);
      header.put("cumulativeInvoice", invoiceAmount);
      BigDecimal invoiceRate = subcontractOrder.getBoolSettlementStatus()
         ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(subcontractOrder.getSettlementAmount(), 2, RoundingMode.HALF_UP)
         : (
            subcontractOrder.getAmount().compareTo(BigDecimal.ZERO) > 0
               ? invoiceAmount.multiply(BigDecimal.valueOf(100L)).divide(subcontractOrder.getAmount(), 2, RoundingMode.HALF_UP)
               : BigDecimal.ZERO
         );
      header.put("invoiceRate", invoiceRate);
   }

   @Override
   public PageVO<SupplierInvoiceDetailDto> getInvoiceList(Long orderId, Integer pageNumber, Integer pageSize) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "合同不存在");
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierInvoice> invoiceList = this.invoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .orderByDesc(SupplierInvoice::getAuditTime)
         );
      List<SupplierInvoiceDetailDto> subInvoiceList = this.getSubInvoiceList(invoiceList);
      return new PageVO<>(PageUtils.getPageInfo(subInvoiceList, invoiceList));
   }

   private List<SupplierInvoiceDetailDto> getSubInvoiceList(List<SupplierInvoice> invoiceList) {
      return invoiceList.isEmpty()
         ? Collections.emptyList()
         : invoiceList.stream()
            .map(
               s -> SupplierInvoiceDetailDto.builder()
                  .invoiceDate(s.getReceiveInvoiceDate().atStartOfDay())
                  .invoiceType(s.getInvoiceType())
                  .invoiceAmount(s.getActualInvoiceAmount())
                  .taxRate(s.getTaxRate())
                  .invoiceSignBody(NameInfo.builder().id(s.getBranchCompanyId()).name(s.getBranchCompanyName()).build())
                  .invoiceNumber(s.getInvoiceSerialNumber())
                  .supplierId(s.getSupplierId())
                  .supplierName(s.getSupplierName())
                  .paymentPerson(NameInfo.builder().id(s.getApplyUserId()).name(s.getApplyUserName()).build())
                  .auditUser(NameInfo.builder().id(s.getAuditUserId()).name(s.getAuditUserName()).build())
                  .attachmentList(this.attachmentService.listByIds(s.getAttachmentIds()))
                  .attachments(this.attachmentService.listByIds(s.getAttachmentIds()))
                  .build()
            )
            .collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<SupplierInvoiceDetailDto>> printInvoiceList(Long orderId) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在!");
      PrintVO<List<SupplierInvoiceDetailDto>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      this.setPrintHeader(header, subcontractOrder);
      printVO.setHeader(header);
      List<SupplierInvoice> invoiceList = this.invoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .orderByDesc(SupplierInvoice::getAuditTime)
         );
      List<SupplierInvoiceDetailDto> subInvoiceList = this.getSubInvoiceList(invoiceList);
      printVO.setTable(subInvoiceList);
      return printVO;
   }

   @Override
   public List<SupplierSettlementDTO> listSubOrderSettle(Long orderId, Boolean boolPreSettlement) {
      SubcontractOrder order = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(order != null, "订单不存在!");
      List<SupplierSettlement> settlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, orderId)
               .eq(boolPreSettlement != null, SupplierSettlement::getBoolPreSettlement, boolPreSettlement)
               .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      if (settlementList.isEmpty()) {
         return Collections.emptyList();
      }

      ProjectInfo projectInfo = this.projectService.getSimpleById(order.getProjectId());
      BranchCompany branchCompany = this.branchCompanyService.getById(order.getBranchCompanyId());
      return settlementList.stream().map(s -> {
         SupplierSettlementDTO settlementDTO = BeanUtil.copy(s, SupplierSettlementDTO.class);
         settlementDTO.setBranchCompanyId(order.getBranchCompanyId());
         settlementDTO.setBranchCompanyName(branchCompany != null ? branchCompany.getName() : "");
         settlementDTO.setSupplierId(order.getSupplierId());
         settlementDTO.setSupplierName(order.getSupplierName());
         settlementDTO.setProjectName(projectInfo.getName());
         settlementDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         return settlementDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public PrintVO<List<SupplierSettlementDTO>> printListSubOrderSettle(Long orderId, Boolean boolPreSettlement) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在!");
      PrintVO<List<SupplierSettlementDTO>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      this.setPrintHeader(header, subcontractOrder);
      printVO.setHeader(header);
      List<SupplierSettlementDTO> listSubOrderSettle = this.listSubOrderSettle(orderId, boolPreSettlement);
      printVO.setTable(listSubOrderSettle);
      return printVO;
   }

   @Override
   public SubcontractOrderDTO getSubcontractOrderDetail(Long orderId) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "分包合同不存在");
      SubcontractOrderDTO subcontractOrderDTO = BeanUtil.copy(subcontractOrder, SubcontractOrderDTO.class);
      if (StringUtils.isBlank(subcontractOrder.getSubcontractClassName())) {
         subcontractOrderDTO.setSubcontractClassName(SubSupplyTypeEnum.getByType(subcontractOrder.getSubcontractClassId()).getName());
      }

      BranchCompany branchCompany = this.branchCompanyService.getById(subcontractOrder.getBranchCompanyId());
      subcontractOrderDTO.setBranchCompany(
         NameInfo.builder().id(subcontractOrder.getBranchCompanyId()).name(branchCompany != null ? branchCompany.getName() : "/").build()
      );
      Supplier supplier = this.supplierService.getById(subcontractOrder.getSupplierId());
      subcontractOrderDTO.setSupplierName(
         supplier != null ? (StringUtils.isNotBlank(supplier.getShortName()) ? supplier.getShortName() : supplier.getName()) : "/"
      );
      ContractProject project = this.projectService.getById(subcontractOrder.getProjectId());
      subcontractOrderDTO.setProject(
         ProjectInfo.builder()
            .id(subcontractOrder.getProjectId())
            .name(project.getName())
            .shortName(project.getShortName())
            .serialNumber(project.getSerialNumber())
            .projectAttribute(project.getProjectAttribute())
            .build()
      );
      Long projectManagerId;
      if (project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         projectManagerId = project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId();
      } else {
         projectManagerId = project.getProjectManagerId();
      }

      subcontractOrderDTO.setProjectManagerId(projectManagerId);
      subcontractOrderDTO.setProjectManagerName(this.userService.getNameById(projectManagerId));
      List<Long> attachmentIds = StringUtils.isNotBlank(subcontractOrder.getAttachmentIds())
         ? Arrays.stream(StringUtils.split(subcontractOrder.getAttachmentIds(), ",")).map(Long::valueOf).collect(Collectors.toList())
         : Collections.emptyList();
      subcontractOrderDTO.setAttachmentIds(attachmentIds);
      subcontractOrderDTO.setAttachments(this.attachmentService.listByIds(subcontractOrder.getAttachmentIds()));
      return subcontractOrderDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteSubcontractOrder(List<Long> orderId) {
      orderId.forEach(
         id -> {
            SubcontractOrder order = this.subcontractOrderService.getById(id);
            Preconditions.checkArgument(order != null, "删除失败,分包订单不存在");
            Preconditions.checkArgument(!order.getBoolSettlementStatus(), "删除失败,订单已结算!");
            int count = this.supplierSettlementService
               .count(
                  Wrappers.lambdaQuery(SupplierSettlement.class)
                     .eq(SupplierSettlement::getOrderId, id)
                     .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                     .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
               );
            Preconditions.checkArgument(count == 0, "删除失败,订单存在结算申请记录");
            count = this.subcontractOrderTempService
               .count(Wrappers.lambdaQuery(SubcontractOrderTemp.builder().orderId(id).auditStatusEnum(AuditStatusEnum.AUDITING.getType()).build()));
            Preconditions.checkArgument(count == 0, "订单正在审批中!");
            count = this.supplierPaymentService
               .count(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getOrderId, id)
                     .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               );
            Preconditions.checkArgument(count == 0, "删除失败,订单已存在付款记录!");
            count = this.supplierInvoiceService
               .count(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .eq(SupplierInvoice::getOrderId, id)
                     .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                     .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               );
            Preconditions.checkArgument(count == 0, "删除失败,订单已存在收票记录!");
            ContractProject project = this.projectService.getById(order.getProjectId());
            SaveSubcontractOrderDTOParam param = BeanUtil.copy(order, SaveSubcontractOrderDTOParam.class);
            param.setAttachmentIds(
               order.getAttachmentIds() != null
                  ? Arrays.stream(StringUtils.split(order.getAttachmentIds(), ",")).map(Long::valueOf).collect(Collectors.toSet())
                  : null
            );
            SubcontractOrderTemp orderTemp = this.saveTempOrder(project, SubOrderChangeTypeEnum.DEL.getType(), param);
            this.subcontractOrderTempBiz.handleAuditSuccess(orderTemp);
         }
      );
      return true;
   }

   @Override
   public List<NameInfo> getProjectManagerList() {
      SecurityUser user = UserUtil.getCurrentUser();
      List<User> list = this.userService.list();
      new ArrayList();
      List userList;
      if (user.isAdmin()) {
         userList = list.stream().map(a -> NameInfo.builder().id(a.getId()).name(a.getName()).build()).collect(Collectors.toList());
      } else {
         userList = list.stream()
            .filter(a -> a.getId().equals(user.getId()))
            .map(a -> NameInfo.builder().id(a.getId()).name(a.getName()).build())
            .collect(Collectors.toList());
      }

      return userList;
   }

   @Override
   public List<ProjectBranchCompanyDTO> getProjectList() {
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
               .ne(ContractProject::getBusinessType, ProjectBusinessTypeEnum.PROCESS.getType())
               .eq(ContractProject::getSettlementStatus, SettlementStatusEnum.UN_SETTLED.getType())
               .orderByDesc(ContractProject::getId)
         );
      if (projectList.isEmpty()) {
         return Collections.emptyList();
      }

      Map<Long, String> branchCompanyMap = this.branchCompanyService.list().stream().collect(Collectors.toMap(BranchCompany::getId, BranchCompany::getName));
      List<Long> projectIds = projectList.stream().map(ContractProject::getId).collect(Collectors.toList());
      Map<Long, List<NameInfo>> collectMap = this.projectBranchCompanyLinkService
         .list(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class).in(ProjectBranchCompanyLink::getProjectId, projectIds))
         .stream()
         .collect(
            Collectors.groupingBy(
               ProjectBranchCompanyLink::getProjectId,
               Collectors.mapping(
                  s -> NameInfo.builder().id(s.getBranchCompanyId()).name(branchCompanyMap.get(s.getBranchCompanyId())).build(), Collectors.toList()
               )
            )
         );
      return projectList.stream().map(cp -> {
         ProjectBranchCompanyDTO branchCompanyDTO = BeanUtil.copy(cp, ProjectBranchCompanyDTO.class);
         List<NameInfo> nameInfoList = collectMap.getOrDefault(cp.getId(), Collections.emptyList());
         branchCompanyDTO.setBranchCompanyList(nameInfoList);
         return branchCompanyDTO;
      }).collect(Collectors.toList());
   }

   public String getSerialNumber(String tableNameKey, Integer size) {
      String yyyy_mm_dd = new SimpleDateFormat("yyyy_MM_dd").format(new Date());
      String key = MessageFormat.format("{0}:{1}", tableNameKey, yyyy_mm_dd);
      Long increment = this.redisTemplate.opsForValue().increment(key, 1L);
      if (increment.equals(1L)) {
         this.redisTemplate.expire(key, 24L, TimeUnit.HOURS);
      }

      String datetime = new SimpleDateFormat("yyyyMMdd").format(new Date());
      String value = org.apache.commons.lang.StringUtils.leftPad(String.valueOf(increment), size, "0");
      return MessageFormat.format("{0}{1}", datetime, value);
   }
}
