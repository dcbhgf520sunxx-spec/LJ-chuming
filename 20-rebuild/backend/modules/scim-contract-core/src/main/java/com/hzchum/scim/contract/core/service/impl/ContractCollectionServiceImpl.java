package com.hzchum.scim.contract.core.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum;
import com.hzchum.scim.contract.core.api.enums.PayTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractCollection;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractCollectionQueryDoParam;
import com.hzchum.scim.contract.core.api.pojo.dto.AcceptanceDraftDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractCollectionWarningDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectIncomeExpenseDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractCollectionQueryDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.mapper.ContractCollectionMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ContractCollectionServiceImpl extends ServiceImpl<ContractCollectionMapper, ContractCollection> implements ContractCollectionService {
   @Override
   public BigDecimal getCollectionAmount(Long projectId) {
      return this.baseMapper.selectCollectionAmount(projectId, AuditStatusEnum.SUCCEED.getType());
   }

   @Override
   public List<ContractCollectionDTO> listCollection(ContractCollectionQueryDtoParam param) {
      Preconditions.checkArgument(param.getType() == null || CollectionTypeEnum.boolContain(param.getType()), "收款类型有误!");
      if (CollectionTypeEnum.PROJECT_COLLECTION.getType().equals(param.getType())) {
         param.setContractWasteId(null);
      }

      if (CollectionTypeEnum.WASTE_COLLECTION.getType().equals(param.getType()) || CollectionTypeEnum.SCRAP_COLLECTION.getType().equals(param.getType())) {
         param.setProjectId(null);
      }

      SecurityUser user = UserUtil.getCurrentUser();
      ContractCollectionQueryDoParam doParam = BeanUtil.copy(param, ContractCollectionQueryDoParam.class);
      doParam.setUserId(user.isAdmin() ? null : user.getId());
      List<ContractCollectionDTO> contractCollectionDTOS = this.baseMapper.listByCondition(doParam);
      contractCollectionDTOS.forEach(c -> {
         if (c.getCollectionMode().equals(PayTypeEnum.ACCEPTANCE_DRAFT.getType()) && StringUtils.isNotBlank(c.getAcceptanceDraftJson())) {
            List<AcceptanceDraftDTO> acceptanceDraftDTOS = JSON.parseArray(c.getAcceptanceDraftJson(), AcceptanceDraftDTO.class);
            c.setAcceptanceDraftDTOList(acceptanceDraftDTOS);
         }
      });
      return contractCollectionDTOS;
   }

   @Override
   public List<ContractCollectionWarningDTO> listCollectionWarning(Integer year, Long projectId, Boolean boolArrears) {
      SecurityUser user = UserUtil.getCurrentUser();
      List<ContractCollectionWarningDTO> collectionWarningDTOList;
      if (user.isAdmin()) {
         collectionWarningDTOList = this.baseMapper.selectCollectionWarning(null, year, projectId, boolArrears);
      } else {
         collectionWarningDTOList = this.baseMapper.selectCollectionWarning(user.getId(), year, projectId, boolArrears);
      }

      collectionWarningDTOList.forEach(
         c -> c.setArrearAmount(
            c.getCollectionAmount().compareTo(c.getHappenedAmount()) < 0 ? c.getHappenedAmount().subtract(c.getCollectionAmount()) : BigDecimal.ZERO
         )
      );
      return collectionWarningDTOList;
   }

   @Override
   public List<ProjectIncomeExpenseDTO> listIncomeExpense(Integer year, Long branchCompanyId) {
      return this.baseMapper.selectIncomeExpenseList(year, branchCompanyId);
   }

   @Override
   public List<ContractCollection> selectIncomeAndExpenses(Long projectId, String remark, Integer collectionMode, LocalDate startDate, LocalDate endDate) {
      return this.baseMapper.selectIncomeAndExpenses(projectId, remark, collectionMode, startDate, endDate);
   }

   @Override
   public List<ContractCollection> listCollectionLedger(Long projectId, Long collectionId) {
      return this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(ContractCollection.class)
               .eq(ContractCollection::getProjectId, projectId)
               .eq(collectionId != null, ContractCollection::getCollectionUnitId, collectionId)
               .eq(ContractCollection::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .orderByDesc(ContractCollection::getCollectionDate)
               .orderByDesc(BaseEntity::getCreateTime)
         );
   }
}
