package com.hzchum.scim.contract.core.biz.impl.finance;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.contract.core.api.biz.finance.ContractExpenseReimburseBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseDictionaryLink;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseReimburse;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractExpenseReimburseDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractExpenseReimburseDtoParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseDictionaryLinkService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseReimburseService;
import com.hzchum.scim.contract.core.mapper.finance.ContractExpenseReimburseMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.DepartmentDTO;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractExpenseReimburseBizImpl
   extends IBizImpl<ContractExpenseReimburseService, ContractExpenseReimburseMapper, ContractExpenseReimburse>
   implements ContractExpenseReimburseBiz {
   @Resource
   private ContractExpenseDictionaryLinkService expenseDictionaryLinkService;
   @Resource
   private DepartmentService departmentService;
   @Resource
   private ContractProjectService projectService;

   @Override
   public PageVO<ContractExpenseReimburseDTO> listByCondition(
      Integer year, Integer month, Long expenseTypeId, Long expenseSubjectId, String reimburseUserName, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractExpenseReimburseDTO> reimburseDTOList = this.baseService.listByCondition(year, month, expenseTypeId, expenseSubjectId, reimburseUserName);
      return new PageVO<>(reimburseDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<ContractExpenseReimburseDtoParam> paramList) {
      paramList.forEach(param -> {
         ContractExpenseReimburse reimburse = BeanUtil.copy(param, ContractExpenseReimburse.class);
         this.checkArg(param, reimburse);
         reimburse.setWrittenById(UserUtil.getCurrentUserId());
         reimburse.setBoolConfirmStatus(false);
         this.baseService.save(reimburse);
      });
      return true;
   }

   private void checkArg(ContractExpenseReimburseDtoParam param, ContractExpenseReimburse reimburse) {
      if (param.getProjectId() != null) {
         ContractProject project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在");
      }

      ContractExpenseDictionaryLink link = this.expenseDictionaryLinkService
         .getOne(
            Wrappers.lambdaQuery(
               ContractExpenseDictionaryLink.builder().expenseTypeId(param.getExpenseTypeId()).dictionaryId(param.getExpenseSubjectId()).build()
            )
         );
      Preconditions.checkArgument(link != null, "费用科目有误!");
      reimburse.setYearMonthValue(param.getReimburseDate().getYear() * 100 + param.getReimburseDate().getMonthValue());
      reimburse.setYear(param.getReimburseDate().getYear());
      reimburse.setMonth(param.getReimburseDate().getMonthValue());
      DepartmentDTO departmentDTO = this.departmentService.getDepartmentByUserId(param.getReimburseUserId());
      reimburse.setDeptId(departmentDTO.getId());
      reimburse.setDeptName(departmentDTO.getName());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean update(ContractExpenseReimburseDtoParam param) {
      Preconditions.checkArgument(param.getId() != null, "修改失败,报销填报记录ID不能为空");
      ContractExpenseReimburse reimburse = this.baseService.getById(param.getId());
      Preconditions.checkArgument(reimburse != null, "修改失败,报销填报记录不存在");
      BeanUtil.copy(param, reimburse);
      this.checkArg(param, reimburse);
      this.baseService.updateById(reimburse);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         ContractExpenseReimburse reimburse = this.baseService.getById(id);
         Preconditions.checkArgument(reimburse != null, "删除失败,报销记录不存在");
         Preconditions.checkArgument(!reimburse.getBoolConfirmStatus().equals(true), "删除失败,报销记录已确认");
         this.baseService.removeById(id);
      });
      return true;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printList(Integer year, Integer month, Long expenseTypeId, Long expenseSubjectId, String reimburseUserName) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (year != null) {
         header.put("year", year);
      }

      if (month != null) {
         header.put("yearMonthValue", month);
      }

      printVO.setHeader(header);
      List<ContractExpenseReimburseDTO> dtoList = this.baseService.listByCondition(year, month, expenseTypeId, expenseSubjectId, reimburseUserName);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }
}
