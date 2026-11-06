package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.contract.core.api.biz.finance.ContractManagementCostBiz;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractManagementCost;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractManagementCostDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.SaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractManagementCostDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractManagementCostService;
import com.hzchum.scim.contract.core.mapper.finance.ContractManagementCostMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractManagementCostBizImpl
   extends IBizImpl<ContractManagementCostService, ContractManagementCostMapper, ContractManagementCost>
   implements ContractManagementCostBiz {
   @Resource
   private ContractProjectService projectService;

   @Override
   public PageVO<ContractManagementCostDto> pageSize(Integer pageNumber, Integer pageSize) {
      Page<Object> objects = PageHelper.startPage(pageNumber, pageSize);
      List<ContractManagementCost> costList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractManagementCost.class)
               .isNull(ContractManagementCost::getProjectId)
               .orderByAsc(ContractManagementCost::getProjectAttribute)
         );
      List<ContractManagementCostDto> costDtoList = costList.stream()
         .map(list -> BeanUtil.copy(list, ContractManagementCostDto.class))
         .collect(Collectors.toList());
      return new PageVO<>(objects, costDtoList);
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addEarnestMoney(List<ContractManagementCostDtoParam> list) {
      list.forEach(
         s -> {
            Preconditions.checkArgument(s.getAmountMax().compareTo(s.getAmountMin()) > 0, "该区间最大金额不能小于等于最小金额");
            List<ContractManagementCost> costList = this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(ContractManagementCost.class)
                     .eq(ContractManagementCost::getProjectAttribute, s.getProjectAttribute())
                     .isNull(ContractManagementCost::getStartTime)
               );
            this.saveCheck(costList, s);
            ContractManagementCost cost = BeanUtil.copy(s, ContractManagementCost.class);
            cost.setUserId(UserUtil.getCurrentUserId());
            this.baseMapper.insert(cost);
         }
      );
      return Boolean.TRUE;
   }

   private void saveCheck(List<ContractManagementCost> costList, ContractManagementCostDtoParam param) {
      List<List<BigDecimal>> intervals = new ArrayList<>();
      costList.forEach(s -> intervals.add(Arrays.asList(s.getAmountMin(), s.getAmountMax())));
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
   public Boolean updateEarnestMoney(ContractManagementCostDtoParam dto) {
      ContractManagementCost managementCost = this.baseMapper.selectById(dto.getId());
      Preconditions.checkArgument(managementCost != null, "管理费不存在！！！");
      Preconditions.checkArgument(dto.getAmountMin().compareTo(dto.getAmountMax()) < 0, "区间最大金额不能小于等于最小金额");
      List<ContractManagementCost> costList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractManagementCost.class)
               .eq(ContractManagementCost::getProjectAttribute, managementCost.getProjectAttribute())
               .isNull(ContractManagementCost::getStartTime)
         );
      costList = costList.stream().filter(s -> !s.getId().equals(dto.getId())).collect(Collectors.toList());
      this.saveCheck(costList, dto);
      ContractManagementCost cost = BeanUtil.copy(dto, ContractManagementCost.class);
      cost.setUserId(UserUtil.getCurrentUserId());
      this.baseMapper.updateById(cost);
      return Boolean.TRUE;
   }

   @Override
   public Boolean deleteEarnestMoney(List<Long> ids) {
      this.baseMapper.deleteBatchIds(ids);
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateEarnestMoneyStatus(Long id, Integer status) {
      ContractManagementCost managementCost = this.baseMapper.selectById(id);
      Preconditions.checkArgument(managementCost != null, "管理费不存在！！！");
      this.baseMapper.updateById(BeanUtil.copy(managementCost, ContractManagementCost.class).setStatus(status));
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateProjectManagementCost(SaveDtoParam dtoParam) {
      ContractProject project = this.projectService.getById(dtoParam.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在！！！");
      this.baseMapper
         .insert(
            new ContractManagementCost()
               .setProjectId(dtoParam.getProjectId())
               .setCashDeposit(dtoParam.getCashDeposit())
               .setStartTime(dtoParam.getStartTime())
               .setUserId(UserUtil.getCurrentUserId())
               .setProjectAttribute(project.getProjectAttribute())
               .setStatus(0)
         );
      return Boolean.TRUE;
   }

   @Override
   public BigDecimal getProjectManagementCost(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在！！！");
      Preconditions.checkArgument(!project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()), "自营项目没有管理费合保证金！！！");
      List<ContractManagementCost> costList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractManagementCost.class)
               .eq(ContractManagementCost::getProjectAttribute, project.getProjectAttribute())
               .le(ContractManagementCost::getStartTime, LocalDateTime.now())
               .eq(ContractManagementCost::getProjectId, project.getId())
         );
      if (costList.isEmpty()) {
         costList = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(ContractManagementCost.class)
                  .eq(ContractManagementCost::getProjectAttribute, project.getProjectAttribute())
                  .le(ContractManagementCost::getAmountMin, project.getContractAmount())
                  .ge(ContractManagementCost::getAmountMax, project.getContractAmount())
            );
      } else {
         costList.sort(Comparator.<ContractManagementCost, java.time.LocalDateTime>comparing(BaseEntity::getCreateTime).reversed());
      }

      Preconditions.checkArgument(!costList.isEmpty(), "管理费未配置！！！");
      return costList.get(0).getCashDeposit();
   }
}
