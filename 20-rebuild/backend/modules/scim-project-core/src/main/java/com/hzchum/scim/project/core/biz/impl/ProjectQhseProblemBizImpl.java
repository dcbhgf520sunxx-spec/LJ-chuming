package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.NumberUtil;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.common.core.api.utils.PoiUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.project.core.api.biz.ProjectManageRosterBiz;
import com.hzchum.scim.project.core.api.biz.ProjectQhseProblemBiz;
import com.hzchum.scim.project.core.api.enums.BoolChangeStatusEnum;
import com.hzchum.scim.project.core.api.enums.PowerTypeEnum;
import com.hzchum.scim.project.core.api.enums.QhseStatusEnumV2;
import com.hzchum.scim.project.core.api.enums.QhseTypeEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseChange;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblemType;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectQhseProblemDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseChangeDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemDTO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemDTOV2;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemSumInfo;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectQhseProblemSumInfoV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.QhseProblemQueryDTOParamV2;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.save.ProjectQhseProblemDTOParamV2;
import com.hzchum.scim.project.core.api.service.ProjectQhseChangeService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemTypeService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.scm.core.api.common.ScmConstants;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.enums.config.ProjectNameShowModeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesSafetyClassConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.ProjectConfigVO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.api.service.MesSafetyClassConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.TransactionalException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class ProjectQhseProblemBizImpl implements ProjectQhseProblemBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectQhseProblemBizImpl.class);
   @Resource
   ProjectQhseProblemService qhseProblemService;
   @Resource
   ProjectQhseProblemTypeService qhseProblemTypeService;
   @Resource
   private ProjectQhseChangeService qhseChangeService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private SubcontractClassConfigService subcontractClassConfigService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private SubcontractMonomerLinkService subcontractMonomerLinkService;
   @Resource
   private ConfigService configService;
   @Resource
   private ProjectSupplierAccountService supplierAccountService;
   @Resource
   UserService userService;
   @Resource
   private MesSafetyClassConfigService safetyClassConfigService;
   @Resource
   private MesQualityClassConfigService qualityClassConfigService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private ProjectManageRosterBiz rosterBiz;

   @Override
   public PageVO<ProjectQhseProblemDTO> pageList(QhseProblemQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectQhseProblemDO> problemDOList = this.qhseProblemService.listQhseProblem(param);
      List<ProjectQhseProblemDTO> problemDTOList = problemDOList.stream()
         .map(
            p -> {
               ProjectQhseProblemDTO problemDTO = BeanUtil.copy(p, ProjectQhseProblemDTO.class);
               problemDTO.setMonomer(this.monomerService.getSimpleById(p.getMonomerId()));
               problemDTO.setBeforeChangeImgs(this.attachmentService.listByIds(p.getBeforeChangeImgs()));
               problemDTO.setAfterChangeImgs(this.attachmentService.listByIds(p.getAfterChangeImgs()));
               if (p.getBoolReply()) {
                  ProjectQhseChange qhseChange = this.qhseChangeService
                     .getOne(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, p.getId()));
                  if (qhseChange != null) {
                     ProjectQhseChangeDTO qhseChangeDTO = BeanUtil.copy(qhseChange, ProjectQhseChangeDTO.class);
                     qhseChangeDTO.setAfterChangeImgs(this.attachmentService.listByIds(qhseChange.getAfterChangeImgs()));
                     problemDTO.setQhseChange(qhseChangeDTO);
                     problemDTO.setProblemDesc(qhseChangeDTO.getProblemDesc());
                  }
               }

               return problemDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(problemDTOList, problemDOList));
   }

   @Override
   public ProjectQhseProblemSumInfoV2 getSumInfoV2() {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      ProjectQhseProblemSumInfoV2 sumInfoV2 = new ProjectQhseProblemSumInfoV2();
      if (UserTypeEnum.COMMON_USER.getType().equals(currentUser.getUserType())) {
         List<Long> projectIds = this.projectService
            .listSimpleProject(null, null, null, null)
            .getContent()
            .stream()
            .map(ProjectSimpleInfoDTO::getId)
            .collect(Collectors.toList());
         if (CollectionUtils.isEmpty(projectIds)) {
            return sumInfoV2;
         }

         List<ProjectQhseProblem> problemList = this.qhseProblemService
            .list(Wrappers.lambdaQuery(ProjectQhseProblem.class).in(ProjectQhseProblem::getProjectId, projectIds));
         return this.convertToSumInfo(problemList);
      } else if (UserTypeEnum.TEMP_USER.getType().equals(currentUser.getUserType())) {
         ProjectManageRoster roster = this.rosterBiz
            .getOne(
               Wrappers.lambdaQuery(ProjectManageRoster.class)
                  .eq(ProjectManageRoster::getUserId, UserUtil.getCurrentUserId())
                  .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
            );
         if (roster == null) {
            return sumInfoV2;
         }

         List<ProjectQhseProblem> problemList = this.qhseProblemService
            .list(
               Wrappers.lambdaQuery(ProjectQhseProblem.class)
                  .eq(ProjectQhseProblem::getProjectId, roster.getProjectId())
                  .eq(ProjectQhseProblem::getSupplierId, roster.getSupplierId())
                  .eq(ProjectQhseProblem::getUserId, currentUser.getId())
                  .eq(ProjectQhseProblem::getIsInternal, Boolean.FALSE)
            );
         return this.convertToSumInfo(problemList);
      } else {
         return sumInfoV2;
      }
   }

   private ProjectQhseProblemSumInfoV2 convertToSumInfo(List<ProjectQhseProblem> problemList) {
      ProjectQhseProblemSumInfoV2 sumInfoV2 = new ProjectQhseProblemSumInfoV2();
      if (CollectionUtils.isEmpty(problemList)) {
         return sumInfoV2;
      }

      sumInfoV2.setTotalQuantity(problemList.size());
      sumInfoV2.setQualityQuantity(problemList.stream().filter(e -> QhseTypeEnum.QUALITY.getType().equals(e.getType())).count());
      sumInfoV2.setSafetyQuantity(problemList.stream().filter(e -> QhseTypeEnum.SECURITY.getType().equals(e.getType())).count());
      sumInfoV2.setAmbienceQuantity(problemList.stream().filter(e -> QhseTypeEnum.ENVIRONMENT.getType().equals(e.getType())).count());
      return sumInfoV2;
   }

   @Override
   public PageVO<ProjectQhseProblemDTOV2> pageAppListManage(QhseProblemQueryDTOParamV2 param, Integer pageNumber, Integer pageSize) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (CollectionUtils.isEmpty(projectIds)) {
         return new PageVO<>();
      }

      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectQhseProblem> problemList = this.qhseProblemService
         .list(
            Wrappers.lambdaQuery(ProjectQhseProblem.class)
               .in(ProjectQhseProblem::getProjectId, projectIds)
               .eq(param.getProjectId() != null, ProjectQhseProblem::getProjectId, param.getProjectId())
               .eq(param.getIsInternal() != null, ProjectQhseProblem::getIsInternal, param.getIsInternal())
               .eq(param.getBoolChangeStatusV2() != null, ProjectQhseProblem::getBoolChangeStatusV2, param.getBoolChangeStatusV2())
               .eq(param.getType() != null, ProjectQhseProblem::getType, param.getType())
               .apply(param.getStartDate() != null, "date_format(problem_date, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", param.getStartDate())
               .apply(param.getEndDate() != null, "date_format(problem_date, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", param.getEndDate())
               .orderByDesc(ProjectQhseProblem::getProblemDate)
         );
      if (CollectionUtils.isEmpty(problemList)) {
         return new PageVO<>();
      }

      List<ProjectQhseProblemDTOV2> dtov2List = this.convertToDTO(problemList, true);
      return new PageVO<>(page, dtov2List);
   }

   @Override
   public PageVO<ProjectQhseProblemDTOV2> pageAppListManageHistory(Long projectId, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectQhseProblem> problemList = this.qhseProblemService
         .list(
            Wrappers.lambdaQuery(ProjectQhseProblem.class)
               .eq(projectId != null, ProjectQhseProblem::getProjectId, projectId)
               .eq(ProjectQhseProblem::getPromoterId, UserUtil.getCurrentUserId())
               .orderByDesc(ProjectQhseProblem::getProblemDate)
         );
      if (CollectionUtils.isEmpty(problemList)) {
         return new PageVO<>();
      }

      List<ProjectQhseProblemDTOV2> dtov2List = this.convertToDTO(problemList, true);
      return new PageVO<>(page, dtov2List);
   }

   @Override
   public PageVO<ProjectQhseProblemDTOV2> pageListV2(QhseProblemQueryDTOParamV2 param, Integer pageNumber, Integer pageSize) {
      Preconditions.checkArgument(param.getProjectId() != null, "项目id不能为空！");
      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectQhseProblem> problemList = this.qhseProblemService
         .list(
            Wrappers.lambdaQuery(ProjectQhseProblem.class)
               .eq(param.getProjectId() != null, ProjectQhseProblem::getProjectId, param.getProjectId())
               .eq(param.getIsInternal() != null, ProjectQhseProblem::getIsInternal, param.getIsInternal())
               .eq(param.getBoolChangeStatusV2() != null, ProjectQhseProblem::getBoolChangeStatusV2, param.getBoolChangeStatusV2())
               .eq(param.getType() != null, ProjectQhseProblem::getType, param.getType())
               .apply(param.getStartDate() != null, "date_format(problem_date, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", param.getStartDate())
               .apply(param.getEndDate() != null, "date_format(problem_date, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", param.getEndDate())
               .orderByDesc(ProjectQhseProblem::getProblemDate)
         );
      if (CollectionUtils.isEmpty(problemList)) {
         return new PageVO<>();
      }

      List<ProjectQhseProblemDTOV2> dtov2List = this.convertToDTO(problemList, false);
      return new PageVO<>(page, dtov2List);
   }

   @Override
   public PageVO<ProjectQhseProblemDTOV2> pageAppListLabor(QhseProblemQueryDTOParamV2 param, Integer pageNumber, Integer pageSize) {
      ProjectManageRoster roster = this.rosterBiz
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, UserUtil.getCurrentUserId())
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster == null) {
         return new PageVO<>();
      }

      Page page = PageHelper.startPage(pageNumber, pageSize);
      List<ProjectQhseProblem> problemList = this.qhseProblemService
         .list(
            Wrappers.lambdaQuery(ProjectQhseProblem.class)
               .eq(ProjectQhseProblem::getProjectId, roster.getProjectId())
               .eq(ProjectQhseProblem::getSupplierId, roster.getSupplierId())
               .eq(ProjectQhseProblem::getUserId, roster.getUserId())
               .eq(ProjectQhseProblem::getIsInternal, Boolean.FALSE)
               .eq(param.getBoolChangeStatusV2() != null, ProjectQhseProblem::getBoolChangeStatusV2, param.getBoolChangeStatusV2())
               .eq(param.getType() != null, ProjectQhseProblem::getType, param.getType())
               .apply(param.getStartDate() != null, "date_format(problem_date, '%Y-%m-%d') >= date_format({0}, '%Y-%m-%d')", param.getStartDate())
               .apply(param.getEndDate() != null, "date_format(problem_date, '%Y-%m-%d') <= date_format({0}, '%Y-%m-%d')", param.getEndDate())
               .orderByDesc(ProjectQhseProblem::getProblemDate)
         );
      if (CollectionUtils.isEmpty(problemList)) {
         return new PageVO<>();
      }

      List<ProjectQhseProblemDTOV2> dtov2List = this.convertToDTO(problemList, false);
      return new PageVO<>(page, dtov2List);
   }

   @Override
   public ProjectQhseProblemDTOV2 getByIdV2(Long id) {
      ProjectQhseProblem problem = this.qhseProblemService.getById(id);
      Preconditions.checkArgument(problem != null, "问题不存在");
      List<ProjectQhseProblemDTOV2> dtov2List = this.convertToDTO(Arrays.asList(problem), true);
      return dtov2List.get(0);
   }

   @Override
   public ProjectQhseProblemDTO getById(Long id) {
      ProjectQhseProblem problem = this.qhseProblemService.getById(id);
      Preconditions.checkArgument(problem != null, "问题不存在");
      ProjectQhseProblemDTO problemDTO = BeanUtil.copy(problem, ProjectQhseProblemDTO.class);
      problemDTO.setProject(this.projectService.getSimpleById(problem.getProjectId()));
      problemDTO.setMonomer(this.monomerService.getSimpleById(problem.getMonomerId()));
      problemDTO.setBeforeChangeImgs(this.attachmentService.listByIds(problem.getBeforeChangeImgs()));
      problemDTO.setAfterChangeImgs(this.attachmentService.listByIds(problem.getAfterChangeImgs()));
      if (problem.getBoolReply()) {
         ProjectQhseChange qhseChange = this.qhseChangeService.getOne(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, id));
         if (qhseChange != null) {
            ProjectQhseChangeDTO changeDTO = BeanUtil.copy(qhseChange, ProjectQhseChangeDTO.class);
            changeDTO.setAfterChangeImgs(this.attachmentService.listByIds(qhseChange.getAfterChangeImgs()));
            problemDTO.setQhseChange(changeDTO);
         }
      }

      return problemDTO;
   }

   @Override
   public Boolean printQhseProblem(Long id, HttpServletResponse response) {
      ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(id);
      ProjectQhseProblemDTO problemDTO = BeanUtil.copy(qhseProblem, ProjectQhseProblemDTO.class);
      if (qhseProblem.getBoolReply()) {
         ProjectQhseChange qhseChange = this.qhseChangeService.getOne(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, id));
         if (qhseChange != null) {
            problemDTO.setProblemDesc(qhseChange.getProblemDesc());
         }
      }

      ProjectInfo project = this.projectService.getSimpleById(qhseProblem.getProjectId());
      Map<String, Object> map = BeanUtil.beanToMap(problemDTO);
      ProjectConfigVO configVO = this.configService.getProjectConfig();
      String projectName = configVO.getShowProjectFullName() ? project.getName() : project.getShortName();
      if (configVO.getArrangement().equals(ProjectNameShowModeEnum.SN_NAME.getType())) {
         map.put("projectName", project.getSerialNumber() + projectName);
      } else {
         map.put("projectName", projectName + project.getSerialNumber());
      }

      map.put("serialNumber", "质安-" + project.getShortName() + "-" + qhseProblem.getNumber());
      String resourcePath = "files/QhseProblemTemplate.xlsx";
      String tempFileName = "QhseProblemTemplate";
      String exportFileName = "质安问题报告.xlsx";
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveQhseProblem(ProjectQhseProblemDTOParam param) {
      ProjectQhseProblem qhseProblem = ProjectQhseProblem.builder().build();
      this.saveInfo(param, qhseProblem);
      qhseProblem.setBeforeChangeImgs(StringUtils.join(param.getBeforeChangeImgIds(), ","));
      qhseProblem.setPromoterId(UserUtil.getCurrentUserId());
      qhseProblem.setPromoterName(UserUtil.getCurrentName());
      this.qhseProblemService.save(qhseProblem);
      return true;
   }

   @Transactional
   @Override
   public Boolean saveQhseProblemV2(ProjectQhseProblemDTOParamV2 param) {
      ContractProject project = this.projectService.checkProjectStatus(param.getProjectId());
      if (param.getId() == null) {
         ProjectQhseProblem qhseProblem = BeanUtil.copy(param, ProjectQhseProblem.class);
         if (!param.getIsInternal()) {
            Preconditions.checkArgument(param.getSupplierId() != null, "对外问题分包单位不能为空！");
            Supplier supplier = this.supplierService.getById(param.getSupplierId());
            Preconditions.checkArgument(supplier != null, "分包单位不存在");
            Map<Long, Long> subcontractOrderMap = this.subcontractOrderService
               .list(
                  Wrappers.lambdaQuery(SubcontractOrder.class)
                     .eq(SubcontractOrder::getProjectId, project.getId())
                     .eq(SubcontractOrder::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
               )
               .stream()
               .collect(Collectors.toMap(SubcontractOrder::getSupplierId, SubcontractOrder::getId));
            Preconditions.checkArgument(
               CollectionUtils.isNotEmpty(subcontractOrderMap.keySet()) && subcontractOrderMap.containsKey(param.getSupplierId()), "操作失败,改分包商未简单该项目劳务订单！"
            );
            qhseProblem.setSubcontractOrderId(subcontractOrderMap.get(param.getSupplierId()));
         }

         String serialNumber = "";
         if (QhseTypeEnum.QUALITY.getType().equals(param.getType())) {
            MesQualityClassConfig qualityClassConfig = this.qualityClassConfigService.getById(param.getProblemId());
            Preconditions.checkArgument(qualityClassConfig != null, "操作失败,问题编号不存在！");
            MesQualityClassConfig pConfig = this.qualityClassConfigService.getById(qualityClassConfig.getPid());
            Preconditions.checkArgument(pConfig != null, "操作失败,父级别问题编号不存在！");
            serialNumber = pConfig.getSerialNumber();
            qhseProblem.setPenalty(param.getIsInternal() ? BigDecimal.ZERO : qualityClassConfig.getPenalty());
         } else {
            MesSafetyClassConfig safetyClassConfig = this.safetyClassConfigService.getById(param.getProblemId());
            Preconditions.checkArgument(safetyClassConfig != null, "操作失败,问题编号不存在！");
            MesSafetyClassConfig pConfig = this.safetyClassConfigService.getById(safetyClassConfig.getPid());
            Preconditions.checkArgument(pConfig != null, "操作失败,父级别问题编号不存在！");
            serialNumber = pConfig.getSerialNumber();
            qhseProblem.setPenalty(param.getIsInternal() ? BigDecimal.ZERO : safetyClassConfig.getPenalty());
         }

         DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
         qhseProblem.setNumber(serialNumber + "-" + LocalDate.now().format(df) + "-" + this.getNumberV2(qhseProblem.getProjectId()));
         qhseProblem.setSubcontractClassId(ScmConstants.LABOR_SUB_ID);
         qhseProblem.setSubcontractClassName("劳务分包");
         qhseProblem.setProblemDate(qhseProblem.getProblemDate() == null ? LocalDate.now() : null);
         qhseProblem.setBoolChangeStatusV2(param.getBoolReply() ? QhseStatusEnumV2.NO_REPLY.getType() : QhseStatusEnumV2.NOT_NEED_REPLY.getType());
         qhseProblem.setBeforeChangeImgs(StringUtils.join(param.getBeforeChangeImgIds(), ","));
         qhseProblem.setPromoterId(UserUtil.getCurrentUserId());
         qhseProblem.setPromoterName(UserUtil.getCurrentName());
         this.qhseProblemService.save(qhseProblem);
      }

      return true;
   }

   private void saveInfo(ProjectQhseProblemDTOParam param, ProjectQhseProblem qhseProblem) {
      PlanMonomer monomer = this.monomerService.getById(param.getMonomerId());
      Preconditions.checkArgument(monomer != null, "单体不存在");
      Preconditions.checkArgument(qhseProblem.getProjectId() == null || qhseProblem.getProjectId().equals(monomer.getProjectId()), "不能修改项目");
      this.projectService.checkProjectStatus(monomer.getProjectId());
      Supplier supplier = this.supplierService.getById(param.getSupplierId());
      Preconditions.checkArgument(supplier != null, "分包单位不存在");
      ProjectQhseProblemType problemType = this.qhseProblemTypeService.getById(param.getProblemTypeId());
      Preconditions.checkArgument(problemType != null, "问题类型未配置");
      SubcontractMonomerLink monomerLink = this.subcontractMonomerLinkService
         .getOne(
            Wrappers.lambdaQuery(SubcontractMonomerLink.class)
               .eq(SubcontractMonomerLink::getMonomerId, param.getMonomerId())
               .eq(SubcontractMonomerLink::getSupplierId, param.getSupplierId())
               .eq(SubcontractMonomerLink::getSubcontractClassId, ScmConstants.LABOR_SUB_ID)
               .eq(SubcontractMonomerLink::getBoolSettlementStatus, false)
         );
      Preconditions.checkArgument(monomerLink != null, "单体和分包商之间,不存在未结算的劳务分包订单");
      BeanUtil.copy(param, qhseProblem);
      qhseProblem.setProjectId(monomer.getProjectId());
      if (StringUtils.isBlank(qhseProblem.getNumber())) {
         qhseProblem.setNumber(this.getNumber(qhseProblem.getProjectId()));
      }

      qhseProblem.setProblemDate(qhseProblem.getProblemDate() == null ? LocalDate.now() : null);
      qhseProblem.setSubcontractOrderId(monomerLink.getSubcontractOrderId());
      qhseProblem.setSupplierName(supplier.getName());
      qhseProblem.setSubcontractClassId(ScmConstants.LABOR_SUB_ID);
      qhseProblem.setSubcontractClassName("劳务分包");
      qhseProblem.setProblemTypeName(problemType.getName());
      qhseProblem.setBoolChangeStatus(BoolChangeStatusEnum.NOT_CHANGE.isType());
      qhseProblem.setPenalty(param.getPenalty() != null ? param.getPenalty() : BigDecimal.ZERO);
   }

   String getNumber(Long projectId) {
      List<ProjectQhseProblem> problemList = this.qhseProblemService
         .list(Wrappers.lambdaQuery(ProjectQhseProblem.class).eq(ProjectQhseProblem::getProjectId, projectId).orderByAsc(ProjectQhseProblem::getId));
      int size = problemList.size();
      String number;
      if (size == 0) {
         number = "001";
      } else {
         ProjectQhseProblem problem = problemList.get(size - 1);
         int flag = problem.getId().intValue() + 1;
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

   String getNumberV2(Long projectId) {
      int size = this.qhseProblemService.countNumber(projectId);
      return NumberUtil.getDigitsNumber(++size, 4);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateQhseProblem(ProjectQhseProblemDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "问题id不能为空");
      ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(param.getId());
      Preconditions.checkArgument(qhseProblem != null, "质安问题数据不存在");
      Preconditions.checkArgument(qhseProblem.getBoolChangeStatus().equals(BoolChangeStatusEnum.NOT_CHANGE.isType()), "问题已整改");
      this.saveInfo(param, qhseProblem);
      this.attachmentService.replaceAttachment(qhseProblem.getBeforeChangeImgs(), param.getBeforeChangeImgIds());
      qhseProblem.setBeforeChangeImgs(StringUtils.join(param.getBeforeChangeImgIds(), ","));
      this.qhseProblemService.updateById(qhseProblem);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(id);
         Preconditions.checkArgument(qhseProblem != null, "删除失败,问题不存在");
         Preconditions.checkArgument(qhseProblem.getBoolChangeStatus().equals(BoolChangeStatusEnum.NOT_CHANGE.isType()), "删除失败,问题已整改");
         this.attachmentService.deleteIds(qhseProblem.getBeforeChangeImgs());
         this.qhseProblemService.removeById(id);
         this.qhseChangeService.remove(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, id));
      });
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean closeProblem(Long id) {
      ProjectQhseProblem qhseProblem = this.qhseProblemService.getById(id);
      Preconditions.checkArgument(qhseProblem != null, "问题不存在");
      Preconditions.checkArgument(qhseProblem.getBoolReply().equals(false), "问题需要审核整改报告,不能直接关闭");
      Preconditions.checkArgument(qhseProblem.getBoolChangeStatus().equals(false), "问题已关闭");
      qhseProblem.setBoolChangeStatus(true);
      qhseProblem.setBoolChangeStatusV2(QhseStatusEnumV2.CLOSED.getType());
      this.qhseProblemService.updateById(qhseProblem);
      return true;
   }

   @Override
   public ProjectQhseProblemSumInfo getSumInfo(Long projectId, Long supplierId) {
      User user = this.userService.getById(UserUtil.getCurrentUserId());
      if (supplierId == null && user.getUserType().equals(UserTypeEnum.TEMP_USER.getType())) {
         supplierId = this.supplierAccountService.getSupplierIdByUserId(user.getId());
      }

      List<ProjectQhseProblem> problemList = this.qhseProblemService.listByCondition(projectId, supplierId, null, null);
      long count = problemList.stream().filter(s -> s.getBoolChangeStatus().equals(true)).count();
      return ProjectQhseProblemSumInfo.builder()
         .totalQuantity(problemList.size())
         .closedQuantity(Math.toIntExact(count))
         .notCloseQuantity(problemList.size() - Math.toIntExact(count))
         .build();
   }

   @Override
   public PageVO<ProjectQhseProblemDTO> listByCondition(Long projectId, Long problemTypeId, Boolean boolChangeStatus, Integer pageNumber, Integer pageSize) {
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(UserUtil.getCurrentUserId());
      PageHelper.startPage(pageNumber, pageSize);
      List<ProjectQhseProblem> problemList = this.qhseProblemService.listByCondition(projectId, supplierId, problemTypeId, boolChangeStatus);
      List<ProjectQhseProblemDTO> problemDTOList = problemList.stream()
         .map(
            p -> {
               ProjectQhseProblemDTO problemDTO = BeanUtil.copy(p, ProjectQhseProblemDTO.class);
               problemDTO.setProject(this.projectService.getSimpleById(p.getProjectId()));
               problemDTO.setMonomer(this.monomerService.getSimpleById(p.getMonomerId()));
               problemDTO.setBeforeChangeImgs(this.attachmentService.listByIds(p.getBeforeChangeImgs()));
               problemDTO.setAfterChangeImgs(this.attachmentService.listByIds(p.getAfterChangeImgs()));
               if (p.getBoolReply()) {
                  ProjectQhseChange qhseChange = this.qhseChangeService
                     .getOne(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, p.getId()));
                  if (qhseChange != null) {
                     ProjectQhseChangeDTO qhseChangeDTO = BeanUtil.copy(qhseChange, ProjectQhseChangeDTO.class);
                     qhseChangeDTO.setAfterChangeImgs(this.attachmentService.listByIds(qhseChange.getAfterChangeImgs()));
                     problemDTO.setQhseChange(qhseChangeDTO);
                  }
               }

               return problemDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(problemDTOList, problemList));
   }

   @Override
   public void downloadProblemV2(Long id) {
      ProjectQhseProblem problem = this.qhseProblemService.getById(id);
      Preconditions.checkArgument(problem != null, "问题不存在");
      List<ProjectQhseProblemDTOV2> dtov2List = this.convertToDTO(Arrays.asList(problem), false);
      ProjectQhseProblemDTOV2 problemDTO = dtov2List.get(0);
      Preconditions.checkArgument(problemDTO != null, "问题不存在");
      ProjectInfo project = this.projectService.getSimpleById(problemDTO.getProjectId());
      problemDTO.setTypeName(QhseTypeEnum.getNameByType(problem.getType()));
      if (problemDTO.getIsInternal()) {
         problemDTO.setIsInternalName("对内");
      } else {
         problemDTO.setIsInternalName("对外");
      }

      problemDTO.setPenalty(problemDTO.getProblemDTO().getPenalty().toString());
      Map<String, Object> map = BeanUtil.beanToMap(problemDTO);
      ProjectConfigVO configVO = this.configService.getProjectConfig();
      String projectName = configVO.getShowProjectFullName() ? project.getName() : project.getShortName();
      if (configVO.getArrangement().equals(ProjectNameShowModeEnum.SN_NAME.getType())) {
         map.put("projectName", project.getSerialNumber() + projectName);
      } else {
         map.put("projectName", projectName + project.getSerialNumber());
      }

      String resourcePath = "files/QhseProblemTemplateV2.xlsx";
      String tempFileName = "QhseProblemTemplateV2";
      String exportFileName = "质安问题报告.xlsx";
      ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert servletRequestAttributes != null;
      HttpServletResponse response = servletRequestAttributes.getResponse();
      PoiUtils.downLoadExcel(resourcePath, tempFileName, exportFileName, map, response);
   }

   private List<ProjectQhseProblemDTOV2> convertToDTO(List<ProjectQhseProblem> problemList, boolean isBuildPowerType) {
      List<Long> userIds = problemList.stream().map(ProjectQhseProblem::getUserId).distinct().collect(Collectors.toList());
      List<Long> projectIdList = problemList.stream().map(ProjectQhseProblem::getProjectId).distinct().collect(Collectors.toList());
      Map<Long, String> userNameMap = this.userService.listByIds(userIds).stream().collect(Collectors.toMap(User::getId, User::getName));
      Map<Long, ContractProject> projectMap = this.projectService
         .listByIds(projectIdList)
         .stream()
         .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
      return problemList.stream()
         .map(
            e -> {
               ProjectQhseProblemDTOV2 dtoV2 = BeanUtil.copy(e, ProjectQhseProblemDTOV2.class);
               dtoV2.setBeforeChangeImgs(this.attachmentService.listByIds(e.getBeforeChangeImgs()));
               dtoV2.setAfterChangeImgs(this.attachmentService.listByIds(e.getAfterChangeImgs()));
               dtoV2.setUserName(userNameMap.getOrDefault(e.getUserId(), null));
               if (projectMap.containsKey(e.getProjectId())) {
                  ProjectInfo projectInfo = BeanUtil.copy(projectMap.get(e.getProjectId()), ProjectInfo.class);
                  dtoV2.setProject(projectInfo);
               }

               if (e.getSupplierId() != null) {
                  Supplier supplier = this.supplierService.getById(e.getSupplierId());
                  if (supplier != null) {
                     dtoV2.setSupplierName(supplier.getName());
                  }
               }

               if (QhseTypeEnum.QUALITY.getType().equals(e.getType())) {
                  MesQualityClassConfig qualityClassConfig = this.qualityClassConfigService.getById(e.getProblemId());
                  if (qualityClassConfig != null) {
                     MesSafetyClassConfigDTO configDTO = BeanUtil.copy(qualityClassConfig, MesSafetyClassConfigDTO.class);
                     dtoV2.setProblemDTO(configDTO);
                     MesQualityClassConfig pClassConfig = this.qualityClassConfigService.getById(configDTO.getPid());
                     if (pClassConfig != null) {
                        dtoV2.setParentClassDTO(BeanUtil.copy(pClassConfig, MesSafetyClassConfigDTO.class));
                     }
                  }
               } else {
                  MesSafetyClassConfig safetyClassConfig = this.safetyClassConfigService.getById(e.getProblemId());
                  if (safetyClassConfig != null) {
                     MesSafetyClassConfigDTO configDTO = BeanUtil.copy(safetyClassConfig, MesSafetyClassConfigDTO.class);
                     if (e.getIsInternal()) {
                        configDTO.setBehaviorScore(null);
                        configDTO.setPenalty(null);
                     }

                     dtoV2.setProblemDTO(configDTO);
                     MesSafetyClassConfig pClassConfig = this.safetyClassConfigService.getById(configDTO.getPid());
                     if (pClassConfig != null) {
                        dtoV2.setParentClassDTO(BeanUtil.copy(pClassConfig, MesSafetyClassConfigDTO.class));
                     }
                  }
               }

               if (e.getBoolReply()) {
                  ProjectQhseChange qhseChange = this.qhseChangeService
                     .getOne(Wrappers.lambdaQuery(ProjectQhseChange.class).eq(ProjectQhseChange::getProblemId, e.getId()));
                  if (qhseChange != null) {
                     ProjectQhseChangeDTO qhseChangeDTO = BeanUtil.copy(qhseChange, ProjectQhseChangeDTO.class);
                     qhseChangeDTO.setAfterChangeImgs(this.attachmentService.listByIds(qhseChange.getAfterChangeImgs()));
                     dtoV2.setQhseChange(qhseChangeDTO);
                     dtoV2.setProblemDesc(qhseChangeDTO.getProblemDesc());
                  }
               }

               if (isBuildPowerType) {
                  SecurityUser currentUser = UserUtil.getCurrentUser();
                  if (UserTypeEnum.COMMON_USER.getType().equals(currentUser.getUserType())) {
                     Integer type = PowerTypeEnum.VIEW.getType();
                     if (e.getUserId().equals(currentUser.getId())) {
                        type = type + PowerTypeEnum.REPLY.getType();
                     }

                     if (!e.getIsInternal()) {
                        type = type + PowerTypeEnum.EXAMINE.getType();
                     } else if (e.getPromoterId().equals(currentUser.getId())) {
                        type = type + PowerTypeEnum.EXAMINE.getType();
                     }

                     dtoV2.setPowerType(type);
                  }
               }

               return dtoV2;
            }
         )
         .sorted(Comparator.comparingInt(p -> Arrays.asList(4, 2, 1, 8).indexOf(p.getBoolChangeStatusV2())))
         .collect(Collectors.toList());
   }
}
