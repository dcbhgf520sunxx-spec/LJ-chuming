package com.hzchum.scim.contract.core.biz.impl.finance;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
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
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.finance.ContractReimbursementFeeBiz;
import com.hzchum.scim.contract.core.api.biz.finance.FinanceFillFeeUtils;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractExpenseType;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ContractReimbursementFeeDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.finance.ContractReimbursementFeeSaveParam;
import com.hzchum.scim.contract.core.api.pojo.query.ContractReimbursementFeeQuery;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.finance.ContractExpenseTypeService;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import com.hzchum.scim.contract.core.mapper.finance.ContractReimbursementFeeMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Department;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.DepartmentService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractReimbursementFeeBizImpl
   extends IBizImpl<ContractReimbursementFeeService, ContractReimbursementFeeMapper, ContractReimbursementFee>
   implements ContractReimbursementFeeBiz {
   @Autowired
   private BranchCompanyService branchCompanyService;
   @Autowired
   private ContractExpenseTypeService expenseTypeService;
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private DepartmentService deptService;
   @Autowired
   private UserService userService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private FinanceFillFeeUtils financeFillFeeUtils;

   @Override
   public PageVO<ContractReimbursementFeeDTO> pageInfo(ContractReimbursementFeeQuery query) {
      Page page = PageHelper.startPage(query.getPageNumber(), query.getPageSize(), StringUtils.analyzeSortConditions(query.getSort()));
      List<ContractReimbursementFeeDTO> dtoList = this.baseMapper.listInfo(query);
      List<ContractReimbursementFeeDTO> newDtoList = dtoList.stream()
         .filter(dto -> org.apache.commons.lang3.StringUtils.isNotBlank(dto.getAttachmentIds()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(newDtoList)) {
         List<Long> attachmentIdList = new ArrayList<>(newDtoList.size() * 2);
         newDtoList.forEach(
            dto -> {
               List<Long> ids = Arrays.stream(dto.getAttachmentIds().split(","))
                  .filter(org.apache.commons.lang3.StringUtils::isNotBlank)
                  .map(Long::valueOf)
                  .collect(Collectors.toList());
               attachmentIdList.addAll(ids);
            }
         );
         Map<Long, AttachmentDTO> attachmentMap = this.attachmentService
            .listByIdList(attachmentIdList)
            .stream()
            .collect(Collectors.toMap(AttachmentDTO::getId, Function.identity()));
         newDtoList.forEach(
            dto -> {
               List<AttachmentDTO> attachmentList = Arrays.stream(dto.getAttachmentIds().split(","))
                  .filter(org.apache.commons.lang3.StringUtils::isNotBlank)
                  .map(Long::valueOf)
                  .map(attachmentMap::get)
                  .collect(Collectors.toList());
               dto.setAttachmentList(attachmentList);
            }
         );
      }

      return new PageVO<>(page, dtoList);
   }

   @Override
   public PrintVO<List<Map<String, Object>>> listPrint(ContractReimbursementFeeQuery query) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      header.put("title", "报销费用");
      printVO.setHeader(header);
      List<ContractReimbursementFeeDTO> dtoList = this.baseMapper.listInfo(query);
      List<Map<String, Object>> mapList = dtoList.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveInfo(ContractReimbursementFeeSaveParam param) {
      ContractProject project = this.verifyParameters(param);
      ContractReimbursementFee reimbursementFee = BeanUtil.toBean(param, ContractReimbursementFee.class);
      reimbursementFee.setWrittenById(UserUtil.getCurrentUserId());
      reimbursementFee.setAttachmentIds(null);
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         reimbursementFee.setAttachmentIds(org.apache.commons.lang3.StringUtils.join(param.getAttachmentIds(), ","));
      }

      this.baseMapper.insert(reimbursementFee);
      Integer reviewStatus = this.financeFillFeeUtils
         .addApproveData(
            reimbursementFee.getId(),
            AuditPaymentEnum.REIMBURSEMENT_FEE.getType(),
            ApproveProcessTypeEnumV2.CONTRACT_REIMBURSEMENT_AUDIT.getType(),
            param.getBranchCompanyId(),
            param.getReimbursementAmount(),
            project
         );
      if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
         reimbursementFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         reimbursementFee.setAuditorId(UserUtil.getCurrentUserId());
         reimbursementFee.setAuditorName(UserUtil.getCurrentName());
         reimbursementFee.setAuditTime(LocalDateTime.now());
         this.baseMapper.updateById(reimbursementFee);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateInfo(ContractReimbursementFeeSaveParam param) {
      ContractReimbursementFee oldReimbursementFee = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldReimbursementFee != null, "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldReimbursementFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "报销记录已审批!!修改失败!!");
      ContractProject project = this.verifyParameters(param);
      ContractReimbursementFee reimbursementFee = BeanUtil.toBean(param, ContractReimbursementFee.class);
      reimbursementFee.setWrittenById(UserUtil.getCurrentUserId());
      reimbursementFee.setAttachmentIds(null);
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         reimbursementFee.setAttachmentIds(org.apache.commons.lang3.StringUtils.join(param.getAttachmentIds(), ","));
      }

      this.baseMapper.updateById(reimbursementFee);
      this.financeFillFeeUtils
         .removeApproveData(param.getId(), AuditPaymentEnum.REIMBURSEMENT_FEE.getType(), ApproveProcessTypeEnumV2.CONTRACT_REIMBURSEMENT_AUDIT.getType());
      Integer reviewStatus = this.financeFillFeeUtils
         .addApproveData(
            reimbursementFee.getId(),
            AuditPaymentEnum.REIMBURSEMENT_FEE.getType(),
            ApproveProcessTypeEnumV2.CONTRACT_REIMBURSEMENT_AUDIT.getType(),
            param.getBranchCompanyId(),
            param.getReimbursementAmount(),
            project
         );
      if (reviewStatus.equals(ReviewStatusEnum.REVIEWED.getType())) {
         reimbursementFee.setAuditStatusEnum(AuditStatusEnum.SUCCEED.getType());
         reimbursementFee.setAuditorId(UserUtil.getCurrentUserId());
         reimbursementFee.setAuditorName(UserUtil.getCurrentName());
         reimbursementFee.setAuditTime(LocalDateTime.now());
         this.baseMapper.updateById(reimbursementFee);
      }

      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      ContractReimbursementFee oldReimbursementFee = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldReimbursementFee != null, "当前数据不存在, 请刷新后重试");
      Preconditions.checkArgument(oldReimbursementFee.getAuditStatusEnum().equals(AuditStatusEnum.AUDITING.getType()), "报销记录已审批!!删除失败!!");
      this.baseMapper.deleteById(id);
      this.financeFillFeeUtils
         .removeApproveData(id, AuditPaymentEnum.REIMBURSEMENT_FEE.getType(), ApproveProcessTypeEnumV2.CONTRACT_REIMBURSEMENT_AUDIT.getType());
      return true;
   }

   private ContractProject verifyParameters(ContractReimbursementFeeSaveParam param) {
      Preconditions.checkArgument(param.getReimbursementAmount().compareTo(BigDecimal.ZERO) != 0, "报销金额不能为0!");
      BranchCompany branchCompany = this.branchCompanyService
         .getOne(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getId, param.getBranchCompanyId()).eq(BranchCompany::getEnabled, true));
      Preconditions.checkArgument(branchCompany != null, "费用归属已禁用或不存在");
      ContractExpenseType expenseType = this.expenseTypeService.getById(param.getExpenseTypeId());
      Preconditions.checkArgument(expenseType != null, "费用类型不存在");
      ContractProject project = null;
      if (param.getProjectId() != null) {
         project = this.projectService.getById(param.getProjectId());
         Preconditions.checkArgument(project != null, "项目不存在");
      }

      Department dept = this.deptService.getById(param.getDeptId());
      Preconditions.checkArgument(dept != null, "部门不存在");
      User user = this.userService.getOne(Wrappers.lambdaQuery(User.class).eq(User::getId, param.getReimburserId()).eq(User::getIsEnabled, true));
      Preconditions.checkArgument(user != null, "报销人已禁用或不存在");
      return project;
   }
}
