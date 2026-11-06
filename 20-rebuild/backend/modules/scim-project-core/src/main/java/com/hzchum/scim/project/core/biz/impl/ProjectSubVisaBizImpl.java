package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.DateTimeUtil;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.project.core.api.biz.ProjectSubVisaBiz;
import com.hzchum.scim.project.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSubVisa;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.pojo._do.ProjectVisaReason;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectSubVisaSumInfo;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.ProjectSubVisaQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectSubVisaCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectSubVisaDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectSubVisaService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.ProjectVisaReasonService;
import com.hzchum.scim.scm.core.api.common.ScmConstants;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.config.ProjectNameShowModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectSubVisaBizImpl implements ProjectSubVisaBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectSubVisaBizImpl.class);
   @Resource
   ProjectVisaReasonService projectVisaReasonService;
   @Resource
   ProjectSubVisaService projectSubVisaService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   private SubcontractClassConfigService subcontractClassConfigService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private SubcontractMonomerLinkService subcontractMonomerLinkService;
   @Resource
   private UserService userService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private ConfigService configService;

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean delVisaReason(List<Long> ids) {
      ids.forEach(id -> {
         int count = this.projectSubVisaService.count(Wrappers.lambdaQuery(ProjectSubVisa.class).eq(ProjectSubVisa::getVisaReasonId, id));
         Preconditions.checkArgument(count == 0, "删除失败,签证原因正在使用");
         this.projectVisaReasonService.removeById(id);
      });
      return true;
   }

   @Override
   public PageVO<ProjectSubVisaDTO> list(ProjectSubVisaQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      User user = this.userService.getById(UserUtil.getCurrentUserId());
      if (user.getUserType().equals(UserTypeEnum.TEMP_USER.getType()) && param.getSupplierId() == null) {
         param.setSupplierId(this.supplierAccountService.getSupplierIdByUserId(user.getId()));
      }

      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectSubVisaDTO> visaDTOList = this.projectSubVisaService.listSubVisa(param);
      visaDTOList.forEach(v -> {
         v.setSerialNumber("签证-" + v.getProject().getShortName() + "-" + v.getNumber());
         v.setAttachments(this.attachmentService.listByIds(v.getAttachmentIds()));
      });
      return new PageVO<>(visaDTOList);
   }

   @Override
   public ProjectSubVisaDTO getById(Long id) {
      ProjectSubVisa subVisa = this.projectSubVisaService.getById(id);
      ProjectSubVisaDTO subVisaDTO = BeanUtil.copy(subVisa, ProjectSubVisaDTO.class);
      subVisaDTO.setProject(this.projectService.getSimpleById(subVisa.getProjectId()));
      subVisaDTO.setMonomer(this.monomerService.getSimpleById(subVisa.getMonomerId()));
      subVisaDTO.setAttachments(this.attachmentService.listByIds(subVisa.getAttachmentIds()));
      subVisaDTO.setSerialNumber("签证-" + subVisaDTO.getProject().getShortName() + "-" + subVisaDTO.getNumber());
      subVisaDTO.setApplyDate(subVisa.getCreateTime());
      return subVisaDTO;
   }

   @Override
   public Boolean exportSubVisa(Long id, HttpServletResponse response) {
      ProjectSubVisa subVisa = this.projectSubVisaService.getById(id);
      Preconditions.checkArgument(subVisa != null, "分包签证不存在");
      ProjectSubVisaDTO subVisaDTO = BeanUtil.copy(subVisa, ProjectSubVisaDTO.class);
      subVisaDTO.setAttachments(this.attachmentService.listByIds(subVisa.getAttachmentIds()));
      Map<String, Object> map = new HashMap<>(16);
      map.put("applyDate", DateTimeUtil.getLocalDateStr(subVisa.getApplyDate()));
      ProjectInfo project = this.projectService.getSimpleById(subVisa.getProjectId());
      ProjectConfigVO configVO = this.configService.getProjectConfig();
      String projectName = configVO.getShowProjectFullName() ? project.getName() : project.getShortName();
      if (configVO.getArrangement().equals(ProjectNameShowModeEnum.SN_NAME.getType())) {
         map.put("projectName", project.getSerialNumber() + projectName);
      } else {
         map.put("projectName", projectName + project.getSerialNumber());
      }

      map.put("supplierName", subVisa.getSupplierName());
      map.put("subcontractClassName", subVisa.getSubcontractClassName());
      map.put("visaReasonName", subVisa.getVisaReasonName());
      map.put("visaAmount", subVisa.getVisaAmount().toString());
      map.put("remark", subVisa.getRemark());
      map.put("approverName", StringUtils.isNotBlank(subVisa.getApproverName()) ? subVisa.getApproverName() : "");
      map.put("auditUserName", subVisa.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? "" : subVisa.getAuditUserName());
      map.put("sn", "签证-" + project.getShortName() + "-" + subVisa.getNumber());
      map.put("auditTime", subVisaDTO.getAuditTime() != null ? DateTimeUtil.getLocalDateStr(subVisaDTO.getAuditTime()) : "");
      map.put("approveTime", subVisaDTO.getApproveTime() != null ? DateTimeUtil.getLocalDateStr(subVisaDTO.getApproveTime()) : "");
      String resourcePath = "files/SubVisaTemplate.xlsx";
      String tempFileName = "SubVisaTemplate";
      String exportFileName = "分包签证单.xlsx";
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean save(ProjectSubVisaDTOParam param) {
      ProjectSubVisa subVisa = ProjectSubVisa.builder().build();
      this.saveVisa(param, subVisa);
      this.projectSubVisaService.save(subVisa);
      return true;
   }

   void saveVisa(ProjectSubVisaDTOParam param, ProjectSubVisa subVisa) {
      ProjectSupplierAccount supplierAccount = this.supplierAccountService
         .getOne(Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getUserId, UserUtil.getCurrentUserId()));
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      this.projectService.checkProjectStatus(monomer.getProjectId());
      SubcontractMonomerLink monomerLink = this.subcontractMonomerLinkService
         .getOne(
            Wrappers.lambdaQuery(SubcontractMonomerLink.class)
               .eq(SubcontractMonomerLink::getMonomerId, param.getMonomerId())
               .eq(SubcontractMonomerLink::getSupplierId, supplierAccount.getSupplierId())
               .eq(SubcontractMonomerLink::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
               .eq(SubcontractMonomerLink::getBoolSettlementStatus, false)
         );
      Preconditions.checkArgument(monomerLink != null, "供应商和单体订单不存在");
      ProjectVisaReason visaReason = this.projectVisaReasonService.getById(param.getVisaReasonId());
      Preconditions.checkArgument(visaReason != null, "签证原因不存在");
      BeanUtil.copy(param, subVisa);
      subVisa.setApplyDate(LocalDate.now());
      subVisa.setProjectId(monomer.getProjectId());
      subVisa.setNumber(subVisa.getNumber() == null ? this.getNumber(subVisa.getProjectId()) : null);
      subVisa.setSubcontractOrderId(monomerLink.getSubcontractOrderId());
      subVisa.setSupplierId(supplierAccount.getSupplierId());
      subVisa.setSupplierName(supplierAccount.getSupplierName());
      subVisa.setVisaReasonName(visaReason.getName());
      subVisa.setSubcontractClassId(ScmConstants.LABOR_SUB_ID);
      subVisa.setSubcontractClassName("劳务分包");
      subVisa.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      subVisa.setAuditStatus(AuditStatusEnum.AUDITING.getType());
   }

   String getNumber(Long projectId) {
      List<ProjectSubVisa> subVisaList = this.projectSubVisaService
         .list(Wrappers.lambdaQuery(ProjectSubVisa.class).eq(ProjectSubVisa::getProjectId, projectId).orderByAsc(ProjectSubVisa::getId));
      int size = subVisaList.size();
      String number;
      if (size == 0) {
         number = "001";
      } else {
         ProjectSubVisa subVisa = subVisaList.get(size - 1);
         int flag = subVisa.getId().intValue() + 1;
         if (flag < 10) {
            number = "00" + flag;
         } else if (flag < 100) {
            number = "0" + flag;
         } else {
            number = "" + flag;
         }
      }

      return number;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean update(ProjectSubVisaDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "签证ID不能为空");
      ProjectSubVisa subVisa = this.projectSubVisaService.getById(param.getId());
      Preconditions.checkArgument(subVisa != null, "签证不存在");
      Preconditions.checkArgument(subVisa.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "修改失败,签证已审核");
      this.attachmentService.replaceAttachment(subVisa.getAttachmentIds(), param.getAttachmentIds());
      this.saveVisa(param, subVisa);
      this.projectSubVisaService.updateById(subVisa);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         ProjectSubVisa subVisa = this.projectSubVisaService.getById(id);
         Preconditions.checkArgument(subVisa != null, "签证不存在");
         Preconditions.checkArgument(subVisa.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "签证已审核");
         this.projectSubVisaService.removeById(id);
      });
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean checkSubVisa(ProjectSubVisaCheckDTOParam param) {
      Preconditions.checkArgument(
         param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()) || param.getAuditStatus().equals(AuditStatusEnum.FAILED.getType()), "审核状态有误"
      );
      ProjectSubVisa subVisa = this.projectSubVisaService.getById(param.getId());
      Preconditions.checkArgument(subVisa != null, "签证不存在");
      Preconditions.checkArgument(subVisa.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "签证已审核");
      subVisa.setAuditStatus(param.getAuditStatus());
      subVisa.setAuditUserId(UserUtil.getCurrentUserId());
      subVisa.setAuditUserName(UserUtil.getCurrentName());
      subVisa.setAuditTime(LocalDateTime.now());
      subVisa.setApproverId(param.getApproverId());
      if (param.getApproverId() != null) {
         User user = this.userService.getById(param.getApproverId());
         Preconditions.checkArgument(user != null, "审批人不存在");
         subVisa.setApproverName(user.getName());
         subVisa.setApproveTime(param.getApproveTime().atStartOfDay());
      }

      this.projectSubVisaService.updateById(subVisa);
      return true;
   }

   @Override
   public ProjectSubVisaSumInfo getSumInfo(Long projectId) {
      User user = this.userService.getById(UserUtil.getCurrentUserId());
      Long supplierId = null;
      if (user.getUserType().equals(UserTypeEnum.TEMP_USER.getType())) {
         supplierId = this.supplierAccountService.getSupplierIdByUserId(user.getId());
      }

      List<ProjectSubVisa> visaList = this.projectSubVisaService
         .list(
            Wrappers.lambdaQuery(ProjectSubVisa.class)
               .eq(projectId != null, ProjectSubVisa::getProjectId, projectId)
               .eq(supplierId != null, ProjectSubVisa::getSupplierId, supplierId)
         );
      long succeedQuantity = visaList.stream().filter(v -> v.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())).count();
      long failedQuantity = visaList.stream().filter(v -> v.getAuditStatus().equals(AuditStatusEnum.FAILED.getType())).count();
      long unCheckQuantity = visaList.stream().filter(v -> v.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType())).count();
      return ProjectSubVisaSumInfo.builder()
         .totalQuantity(visaList.size())
         .succeedQuantity(Math.toIntExact(succeedQuantity))
         .failedQuantity(Math.toIntExact(failedQuantity))
         .unCheckQuantity(Math.toIntExact(unCheckQuantity))
         .build();
   }
}
