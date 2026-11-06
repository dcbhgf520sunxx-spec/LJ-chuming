package com.hzchum.scim.contract.core.biz.impl.finance;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.contract.core.api.biz.finance.ContractWageFeeBiz;
import com.hzchum.scim.contract.core.api.biz.finance.FinanceFillFeeUtils;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractWageFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractWageFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractWageFeeSaveParam;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseTypeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractWageFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractWageFeeMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractWageFeeBizImpl extends IBizImpl<ContractWageFeeService, ContractWageFeeMapper, ContractWageFee> implements ContractWageFeeBiz {
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Autowired
   private ContractExpenseTypeService expenseTypeService;
   @Autowired
   private FinanceFillFeeUtils financeFillFeeUtils;

   @Override
   public PageVO<ContractWageFeeDTO> pageInfo(Integer year, Long branchCompanyId, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ContractWageFeeDTO> dtoList = this.baseMapper.listInfo(year, branchCompanyId);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> listPrint(Integer year, Long branchCompanyId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "工资费用");
      printVO.setHeader(header);
      List<ContractWageFeeDTO> dtoList = this.baseMapper.listInfo(year, branchCompanyId);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveInfo(ContractWageFeeSaveParam param) {
      this.verifyParameters(param);
      ContractWageFee wageFee = BeanUtil.toBean(param, ContractWageFee.class);
      this.populateData(wageFee);
      this.baseMapper.insert(wageFee);
      Integer reviewStatus = this.financeFillFeeUtils
         .addApproveData(
            wageFee.getId(),
            AuditPaymentEnum.STAFF_WAGE.getType(),
            ApproveProcessTypeEnumV2.CONTRACT_STAFF_WAGE_AUDIT.getType(),
            param.getBranchCompanyId(),
            param.getTotalWage(),
            null
         );
      if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
         wageFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         wageFee.setAuditTime(LocalDateTime.now());
         wageFee.setAuditorId(UserUtil.getCurrentUserId());
         wageFee.setAuditorName(UserUtil.getCurrentName());
         this.baseService.updateById(wageFee);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateInfo(ContractWageFeeSaveParam param) {
      ContractWageFee oldWageFee = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldWageFee != null, "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldWageFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "工资填报记录已审批!!修改失败!!");
      this.verifyParameters(param);
      ContractWageFee wageFee = BeanUtil.toBean(param, ContractWageFee.class);
      this.populateData(wageFee);
      this.baseMapper.updateById(wageFee);
      this.financeFillFeeUtils
         .removeApproveData(param.getId(), AuditPaymentEnum.STAFF_WAGE.getType(), ApproveProcessTypeEnumV2.CONTRACT_STAFF_WAGE_AUDIT.getType());
      Integer reviewStatus = this.financeFillFeeUtils
         .addApproveData(
            param.getId(),
            AuditPaymentEnum.STAFF_WAGE.getType(),
            ApproveProcessTypeEnumV2.CONTRACT_STAFF_WAGE_AUDIT.getType(),
            param.getBranchCompanyId(),
            param.getTotalWage(),
            null
         );
      if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
         wageFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         wageFee.setAuditTime(LocalDateTime.now());
         wageFee.setAuditorId(UserUtil.getCurrentUserId());
         wageFee.setAuditorName(UserUtil.getCurrentName());
         this.baseService.updateById(wageFee);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      ContractWageFee oldWageFee = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldWageFee != null, "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldWageFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "工资填报记录已审批!!删除失败!!");
      this.baseMapper.deleteById(id);
      this.financeFillFeeUtils.removeApproveData(id, AuditPaymentEnum.STAFF_WAGE.getType(), ApproveProcessTypeEnumV2.CONTRACT_STAFF_WAGE_AUDIT.getType());
      return true;
   }

   private void populateData(ContractWageFee wageFee) {
      wageFee.setFounderId(UserUtil.getCurrentUserId());
      wageFee.setFillInYear(wageFee.getFillInDate().getYear());
      wageFee.setFillInMonth(wageFee.getFillInDate().getMonthValue());
      wageFee.setAverageWage(wageFee.getTotalWage().divide(BigDecimal.valueOf(wageFee.getEmployeeQuantity().intValue()), 8, RoundingMode.HALF_UP));
   }

   private void verifyParameters(ContractWageFeeSaveParam param) {
      BranchCompany branchCompany = this.branchCompanyService
         .getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getId, param.getBranchCompanyId()).eq(BranchCompany::getEnabled, true));
      Preconditions.checkArgument(branchCompany != null, "费用归属已禁用或不存在");
      ContractExpenseType expenseType = this.expenseTypeService.getById(param.getExpenseTypeId());
      Preconditions.checkArgument(expenseType != null, "费用类型不存在");
   }
}
