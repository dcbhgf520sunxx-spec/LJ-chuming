package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.biz.finance.ContractEarnestMoneyBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AmountOperationTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AmountTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractEarnestMoney;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractEarnestMoneyDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractEarnestMoneyDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractEarnestMoneyService;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.contract.core.mapper.finance.ContractEarnestMoneyMapper;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractEarnestMoneyBizImpl
   extends IBizImpl<ContractEarnestMoneyService, ContractEarnestMoneyMapper, ContractEarnestMoney>
   implements ContractEarnestMoneyBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private SecurityDepositAndManagementCostService securityDepositAndManagementCostService;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ContractCollectionBiz collectionBiz;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;

   @Override
   public PageVO<ContractEarnestMoneyDto> pageSize(Integer pageNumber, Integer pageSize) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<ContractEarnestMoney> list = this.baseMapper.selectList(Wrappers.lambdaQuery());
      List<ContractEarnestMoneyDto> moneyDto = list.stream()
         .map(money -> BeanUtil.copy(money, ContractEarnestMoneyDto.class))
         .sorted(Comparator.comparing(ContractEarnestMoneyDto::getProjectAttribute))
         .collect(Collectors.toList());
      return new PageVO<>(objects, moneyDto);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addEarnestMoney(List<ContractEarnestMoneyDtoParam> dto) {
      dto.forEach(
         money -> {
            Preconditions.checkArgument(money.getAmountMax().compareTo(money.getAmountMin()) >= 0, "该区间最大金额不能小于等于最小金额");
            Preconditions.checkArgument(money.getAmountMax().compareTo(money.getCashDeposit()) >= 0, "保证金不能大于最大合同额");
            List<ContractEarnestMoney> list = this.baseMapper
               .selectList(Wrappers.lambdaQuery(ContractEarnestMoney.class).eq(ContractEarnestMoney::getProjectAttribute, money.getProjectAttribute()));
            saveCheck(list, money);
            ContractEarnestMoney earnestMoney = BeanUtil.copy(money, ContractEarnestMoney.class);
            earnestMoney.setUserId(UserUtil.getCurrentUserId());
            earnestMoney.setStatus(0);
            this.baseMapper.insert(earnestMoney);
         }
      );
      return Boolean.TRUE;
   }

   private static void saveCheck(List<ContractEarnestMoney> list, ContractEarnestMoneyDtoParam param) {
      List<List<BigDecimal>> intervals = new ArrayList<>();
      list.forEach(s -> intervals.add(Arrays.asList(s.getAmountMin(), s.getAmountMax())));
      intervals.add(Arrays.asList(param.getAmountMin(), param.getAmountMax()));
      intervals.sort(Comparator.comparing(interval -> interval.get(0)));

      for (int i = 1; i < intervals.size(); i++) {
         List<BigDecimal> prev = intervals.get(i - 1);
         List<BigDecimal> curr = intervals.get(i);
         if (curr.get(0).compareTo(prev.get(1)) < 0) {
            throw new IllegalArgumentException("该区间已存在，请重新定义区间");
         }
      }
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateEarnestMoney(ContractEarnestMoneyDtoParam dto) {
      ContractEarnestMoney contractEarnestMoney = this.baseMapper.selectById(dto.getId());
      Preconditions.checkArgument(dto.getAmountMax().compareTo(dto.getCashDeposit()) > 0, "保证金必须小于等于最大合同额合同额");
      ContractEarnestMoney earnestMoney = BeanUtil.copy(dto, ContractEarnestMoney.class);
      earnestMoney.setUserId(UserUtil.getCurrentUserId());
      this.baseMapper.updateById(earnestMoney);
      List<ContractEarnestMoney> list = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ContractEarnestMoney.class).eq(ContractEarnestMoney::getProjectAttribute, earnestMoney.getProjectAttribute()));
      Boolean result = earnestMoney.getAmountMax() != null && !earnestMoney.getAmountMax().equals(contractEarnestMoney.getAmountMax())
         || earnestMoney.getAmountMin() != null && !earnestMoney.getAmountMin().equals(contractEarnestMoney.getAmountMin());
      if (result) {
         list = list.stream().filter(s -> !s.getId().equals(dto.getId())).collect(Collectors.toList());
         saveCheck(list, dto);
      }

      return Boolean.TRUE;
   }

   @Transactional
   public void contractEarnestMoneyCheck(ContractEarnestMoney earnestMoney, ContractEarnestMoney contractEarnestMoney) {
      List<ContractProject> projectList = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .in(ContractProject::getStatus, 1, 2)
               .in(ContractProject::getProjectAttribute, 2, 3)
               .apply("contract_amount >= {0}", contractEarnestMoney.getAmountMin())
               .apply("contract_amount <= {0}", contractEarnestMoney.getAmountMax())
               .eq(ContractProject::getIsDeposit, 1)
               .eq(ContractProject::getSettlementStatus, SettlementStatusEnum.UN_SETTLED.getType())
         );
      if (!projectList.isEmpty()) {
         Map<Long, List<ContractCollection>> collected = this.collectionService
            .list(
               Wrappers.lambdaQuery(ContractCollection.class)
                  .in(ContractCollection::getProjectId, projectList.stream().map(ContractProject::getId).collect(Collectors.toList()))
            )
            .stream()
            .collect(Collectors.groupingBy(ContractCollection::getProjectId));
         Map<Long, BigDecimal> collectMap = new HashMap<>();
         collected.forEach((k, v) -> collectMap.put(k, v.stream().map(ContractCollection::getCollectionAmount).reduce(BigDecimal.ZERO, BigDecimal::add)));
         List<SecurityDepositAndManagementCost> costList = this.securityDepositAndManagementCostService
            .list(
               Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
                  .in(SecurityDepositAndManagementCost::getProjectId, projectList.stream().map(ContractProject::getId).collect(Collectors.toList()))
                  .eq(SecurityDepositAndManagementCost::getAmountType, 2)
            );
         Map<Long, BigDecimal> managementFeeMap = new HashMap<>();
         costList.stream()
            .collect(Collectors.groupingBy(SecurityDepositAndManagementCost::getProjectId))
            .forEach(
               (k, v) -> {
                  BigDecimal managementDeductIncome = v.stream()
                     .filter(a -> a.getManagementDeductIncome() != null)
                     .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  BigDecimal managementRecord = v.stream()
                     .filter(a -> a.getManagementRecord() != null)
                     .map(SecurityDepositAndManagementCost::getManagementRecord)
                     .reduce(BigDecimal.ZERO, BigDecimal::add);
                  managementFeeMap.put(k, managementDeductIncome.subtract(managementRecord));
               }
            );
         projectList.forEach(
            project -> {
               if (project.getContractAmount().compareTo(earnestMoney.getAmountMin()) >= 0
                  && project.getContractAmount().compareTo(earnestMoney.getAmountMax()) <= 0) {
                  this.saveSecurityDepositAndManagementCostCheck(project, collectMap, managementFeeMap, contractEarnestMoney, earnestMoney);
               } else {
                  ContractProject contractProject = this.managementFeeAndMarginCheck(project.getProjectAttribute(), project.getContractAmount(), project);
                  this.saveSecurityDepositAndManagementCostCheck(contractProject, collectMap, managementFeeMap, contractEarnestMoney, earnestMoney);
               }
            }
         );
      }
   }

   private void saveSecurityDepositAndManagementCostCheck(
      ContractProject project,
      Map<Long, BigDecimal> collectMap,
      Map<Long, BigDecimal> managementFeeMap,
      ContractEarnestMoney earnestMoney,
      ContractEarnestMoney contractEarnestMoney
   ) {
      if (collectMap.get(project.getId()) != null) {
         project.setCollectionSummary(collectMap.get(project.getId()).subtract(managementFeeMap.get(project.getId())));
         SecurityDepositAndManagementCost managementCost = new SecurityDepositAndManagementCost()
            .setProjectId(project.getId())
            .setUserId(UserUtil.getCurrentUserId())
            .setIncome(project.getPrepayments())
            .setSecurityRecord(earnestMoney.getCashDeposit())
            .setRemark("保证金修改，退还原保证金")
            .setDateTime(LocalDateTime.now())
            .setAmountType(1);
         if (project.getCollectionSummary().compareTo(contractEarnestMoney.getCashDeposit()) > 0) {
            managementCost.setSecurityDeductIncome(contractEarnestMoney.getCashDeposit());
            project.setCollectionSummary(project.getCollectionSummary().subtract(contractEarnestMoney.getCashDeposit()));
            project.setIsDeposit(Boolean.TRUE);
         } else {
            project.setIsDeposit(Boolean.FALSE);
         }

         this.securityDepositAndManagementCostService.save(managementCost);
         this.projectService.updateById(project);
      }
   }

   private ContractProject managementFeeAndMarginCheck(Integer projectAttribute, BigDecimal contractAmount, ContractProject project) {
      if (projectAttribute.equals(ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()) || projectAttribute.equals(ProjectAttributeEnum.JOINT_VENTURE.getType())) {
         ContractEarnestMoney earnestMoney = this.baseMapper
            .selectOne(
               Wrappers.lambdaQuery(ContractEarnestMoney.class)
                  .le(ContractEarnestMoney::getAmountMin, contractAmount)
                  .ge(ContractEarnestMoney::getAmountMax, contractAmount)
                  .eq(ContractEarnestMoney::getProjectAttribute, projectAttribute)
            );
         Preconditions.checkArgument(earnestMoney != null, "项目名称" + project.getShortName() + "合同金额为" + contractAmount + "，请前往合同管理配置中为该金额创建保证金");
         project.setMarginAmount(earnestMoney.getCashDeposit());
      }

      return project;
   }

   @Override
   public Boolean deleteEarnestMoney(List<Long> ids) {
      this.baseMapper.deleteBatchIds(ids);
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateEarnestMoneyStatus(Long id, Integer status) {
      ContractEarnestMoney earnestMoney = this.baseMapper.selectById(id);
      Preconditions.checkArgument(earnestMoney != null, "保证金不存在");
      this.baseMapper.updateById(BeanUtil.copy(earnestMoney, ContractEarnestMoney.class).setStatus(status));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean putEarnestMoney(ContractEarnestMoneyDtoParam dto) {
      ContractProject project = this.projectService.getById(dto.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(dto.getCashDeposit().compareTo(project.getMarginAmount()) != 0, "保证金金额未改变!");
      BigDecimal newProjectManagerScaleMarginAmount = dto.getCashDeposit()
         .multiply(project.getProjectManagerScale())
         .divide(BigDecimal.valueOf(100L), 4, RoundingMode.HALF_UP);
      if (newProjectManagerScaleMarginAmount.compareTo(project.getCollectionMarginAmount()) < 0) {
         BigDecimal amount = project.getCollectionMarginAmount().subtract(newProjectManagerScaleMarginAmount);
         SecurityDepositAndManagementCost cost = SecurityDepositAndManagementCost.builder()
            .projectId(dto.getProjectId())
            .userId(UserUtil.getCurrentUserId())
            .dateTime(LocalDateTime.now())
            .amountOperationTypeEnum(AmountOperationTypeEnum.RETURN.getType())
            .amountType(AmountTypeEnum.SECURITY_DEPOSIT.getType())
            .amount(amount)
            .securityRecord(amount)
            .remark("修改保证金,退还保证金!")
            .voucherNumber(this.serialNumber("B"))
            .auditStatus(AuditStatusEnum.SUCCEED.getType())
            .build();
         this.securityDepositAndManagementCostService.save(cost);
         project.setCollectionMarginAmount(newProjectManagerScaleMarginAmount);
         project.setProjectManagerCollectBalance(project.getProjectManagerCollectBalance().add(amount));
         project.setProjectManagerAmount(project.getProjectManagerAmount().add(amount));
         project.setCollectionSummary(project.getCollectionSummary().add(amount));
      }

      if (newProjectManagerScaleMarginAmount.compareTo(project.getCollectionMarginAmount()) > 0) {
         BigDecimal amount = newProjectManagerScaleMarginAmount.subtract(project.getCollectionMarginAmount());
         if (project.getProjectManagerCollectBalance().compareTo(amount) >= 0) {
            SecurityDepositAndManagementCost cost = SecurityDepositAndManagementCost.builder()
               .projectId(dto.getProjectId())
               .userId(UserUtil.getCurrentUserId())
               .dateTime(LocalDateTime.now())
               .amountOperationTypeEnum(AmountOperationTypeEnum.DEDUCT.getType())
               .amountType(AmountTypeEnum.SECURITY_DEPOSIT.getType())
               .amount(amount)
               .securityDeductIncome(amount)
               .remark("修改保证金,补交保证金!")
               .voucherNumber(this.serialNumber("B"))
               .auditStatus(AuditStatusEnum.SUCCEED.getType())
               .build();
            this.securityDepositAndManagementCostService.save(cost);
            project.setCollectionMarginAmount(project.getCollectionMarginAmount().add(amount));
            project.setProjectManagerCollectBalance(project.getProjectManagerCollectBalance().subtract(amount));
            project.setProjectManagerAmount(project.getProjectManagerAmount().subtract(amount));
            project.setCollectionSummary(project.getCollectionSummary().subtract(amount));
         }
      }

      project.setMarginAmount(dto.getCashDeposit());
      this.projectService.updateById(project);
      return Boolean.TRUE;
   }

   private String serialNumber(String unit) {
      String supplierPaymentNumber = null;

      try {
         Object number = this.redisUtils.get("supplierPaymentNumber");
         if (ObjectUtils.isEmpty(number)) {
            this.projectSerialNumberUtils.redisSaveSerialNumber();
            number = this.redisUtils.get("supplierPaymentNumber");
         }

         supplierPaymentNumber = this.projectSerialNumberUtils.dateUtil(number.toString());
         this.redisUtils.incr("supplierPaymentNumber", 1L);
      } catch (Exception e) {
         throw new RuntimeException("获取流水号失败");
      }

      return unit + supplierPaymentNumber;
   }
}
