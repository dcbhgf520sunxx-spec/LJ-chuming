package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.biz.ContractCollectionBiz;
import com.hzchum.scim.contract.core.api.biz.finance.SecurityDepositAndManagementCostBiz;
import com.hzchum.scim.contract.core.api.enums.finance.AmountTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.finance.SecurityDepositAndManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.SecurityDepositAndManagementCostDetailDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.SecurityDepositAndManagementCostDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.SaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.SecurityDepositAndManagementCostDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.SecurityDepositAndManagementCostService;
import com.hzchum.scim.contract.core.mapper.finance.SecurityDepositAndManagementCostMapper;
import com.hzchum.scim.system.core.api.common.utils.ProjectSerialNumberUtils;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecurityDepositAndManagementCostBizImpl
   extends IBizImpl<SecurityDepositAndManagementCostService, SecurityDepositAndManagementCostMapper, SecurityDepositAndManagementCost>
   implements SecurityDepositAndManagementCostBiz {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ContractCollectionBiz collectionBiz;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ProjectSerialNumberUtils projectSerialNumberUtils;

   @Override
   public PageVO<SecurityDepositAndManagementCostDto> pagingQuery(Long projectId, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SecurityDepositAndManagementCostDto> list = this.baseMapper.pageSizeList(projectId);
      return new PageVO<>(list);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addSecurityDepositAndManagementCost(List<SecurityDepositAndManagementCostDtoParam> dto) {
      dto.forEach(m -> {
         SecurityDepositAndManagementCost cost = BeanUtil.copy(m, SecurityDepositAndManagementCost.class);
         cost.setUserId(UserUtil.getCurrentUserId());
         this.baseMapper.insert(cost);
      });
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateSecurityDepositAndManagementCost(SecurityDepositAndManagementCostDtoParam dto) {
      SecurityDepositAndManagementCost cost = BeanUtil.copy(dto, SecurityDepositAndManagementCost.class);
      cost.setUserId(UserUtil.getCurrentUserId());
      this.baseMapper.updateById(cost);
      return Boolean.TRUE;
   }

   @Override
   public Boolean deleteSecurityDepositAndManagementCost(List<Long> ids) {
      this.baseMapper.deleteBatchIds(ids);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean sendBackSecurityDepositAndManagementCost(SaveDtoParam saveDtoParam) {
      ContractProject project = this.projectService.getById(saveDtoParam.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      List<SecurityDepositAndManagementCost> costList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
               .eq(SecurityDepositAndManagementCost::getProjectId, saveDtoParam.getProjectId())
               .eq(SecurityDepositAndManagementCost::getAmountType, saveDtoParam.getAuditStatus())
         );
      if (saveDtoParam.getAuditStatus().equals(AmountTypeEnum.SECURITY_DEPOSIT.getType())) {
         BigDecimal securitySum = costList.stream()
            .map(SecurityDepositAndManagementCost::getSecurityDeductIncome)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal securityRecordSum = costList.stream()
            .map(SecurityDepositAndManagementCost::getSecurityRecord)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(saveDtoParam.getDepositRefund().compareTo(BigDecimal.ZERO) >= 0, "退还金额不能小于0");
         int compare = securitySum.subtract(securityRecordSum).compareTo(saveDtoParam.getDepositRefund());
         Preconditions.checkArgument(compare >= 0, "保证金退还金额不能大于已缴金额!");
         project.setMarginAmount(project.getMarginAmount().subtract(saveDtoParam.getDepositRefund()));
         project.setCollectionMarginAmount(project.getCollectionMarginAmount().subtract(saveDtoParam.getDepositRefund()));
      } else {
         if (!saveDtoParam.getAuditStatus().equals(AmountTypeEnum.MANAGEMENT_COST.getType())) {
            throw new IllegalArgumentException("退还类型出错");
         }

         Preconditions.checkArgument(CollectionUtils.isNotEmpty(costList), "未存在管理费扣除记录");
         Preconditions.checkArgument(saveDtoParam.getDepositRefund().compareTo(BigDecimal.ZERO) >= 0, "退还金额不能小于0");
         BigDecimal managementDeductIncome = costList.stream()
            .filter(m -> ObjectUtils.isNotEmpty(m.getManagementDeductIncome()))
            .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         BigDecimal managementRecord = costList.stream()
            .filter(m -> ObjectUtils.isNotEmpty(m.getManagementRecord()))
            .map(SecurityDepositAndManagementCost::getManagementRecord)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(managementDeductIncome.subtract(managementRecord).compareTo(saveDtoParam.getDepositRefund()) >= 0, "管理费退还金额不能大于原始金额");
      }

      project.setProjectManagerCollectBalance(project.getProjectManagerCollectBalance().add(saveDtoParam.getDepositRefund()));
      project.setProjectManagerAmount(project.getProjectManagerAmount().add(saveDtoParam.getDepositRefund()));
      project.setCollectionSummary(project.getCollectionSummary().add(saveDtoParam.getDepositRefund()));
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

   @Override
   public BigDecimal accruingAmounts(Long projectId, Integer auditStatus) {
      List<SecurityDepositAndManagementCost> costList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class)
               .eq(SecurityDepositAndManagementCost::getProjectId, projectId)
               .eq(SecurityDepositAndManagementCost::getAmountType, auditStatus)
         );
      if (auditStatus.equals(1)) {
         if (CollectionUtils.isNotEmpty(costList)) {
            BigDecimal securitySum = costList.stream()
               .filter(m -> m.getSecurityDeductIncome() != null)
               .map(SecurityDepositAndManagementCost::getSecurityDeductIncome)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal securityRecordSum = costList.stream()
               .filter(m -> m.getSecurityRecord() != null)
               .map(SecurityDepositAndManagementCost::getSecurityRecord)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            return securitySum.subtract(securityRecordSum).setScale(2, 4);
         } else {
            return BigDecimal.ZERO;
         }
      } else if (auditStatus.equals(2)) {
         if (!costList.isEmpty()) {
            BigDecimal managementSum = costList.stream()
               .filter(m -> m.getManagementDeductIncome() != null)
               .map(SecurityDepositAndManagementCost::getManagementDeductIncome)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal reduceSum = costList.stream()
               .filter(m -> m.getManagementRecord() != null)
               .map(SecurityDepositAndManagementCost::getManagementRecord)
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            return managementSum.subtract(reduceSum).setScale(2, 4);
         } else {
            return BigDecimal.ZERO;
         }
      } else {
         throw new IllegalArgumentException("类型参数错误:" + auditStatus);
      }
   }

   @Override
   public BigDecimal getAccruingAmounts(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      return project.getMarginAmount();
   }

   @Override
   public PageVO<SecurityDepositAndManagementCostDetailDTO> getSecurityDepositAndManagementCostDetail(
      Long projectId, Integer type, Integer pageNumber, Integer pageSize
   ) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(project), "项目不存在");
      List<SecurityDepositAndManagementCost> costList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(SecurityDepositAndManagementCost.class).eq(SecurityDepositAndManagementCost::getProjectId, projectId));
      if (CollectionUtils.isEmpty(costList)) {
         return new PageVO<>();
      }

      new ArrayList();
      List list;
      if (type.equals(2)) {
         list = costList.stream()
            .filter(a -> ObjectUtils.isNotEmpty(a.getManagementDeductIncome()))
            .map(
               a -> {
                  BigDecimal rate = new BigDecimal(a.getRate());
                  boolean isScale = rate.scale() > 0;
                  return SecurityDepositAndManagementCostDetailDTO.builder()
                     .date(a.getCreateTime())
                     .voucherNumber(a.getVoucherNumber())
                     .amount(a.getIncome())
                     .rate(isScale ? rate.setScale(1, RoundingMode.DOWN).toString() : a.getRate().split(".")[0])
                     .deduct(a.getManagementDeductIncome())
                     .build();
               }
            )
            .collect(Collectors.toList());
      } else {
         list = costList.stream()
            .filter(a -> ObjectUtils.isNotEmpty(a.getSecurityDeductIncome()))
            .map(
               a -> SecurityDepositAndManagementCostDetailDTO.builder()
                  .date(a.getCreateTime())
                  .voucherNumber(a.getVoucherNumber())
                  .amount(a.getIncome())
                  .deduct(a.getSecurityDeductIncome())
                  .build()
            )
            .collect(Collectors.toList());
      }

      PageVO<SecurityDepositAndManagementCostDetailDTO> dtoPageVO = new PageVO<>(PageUtils.getPage(list, pageNumber, pageSize));
      dtoPageVO.setTotalElements(list.size());
      return dtoPageVO;
   }
}
