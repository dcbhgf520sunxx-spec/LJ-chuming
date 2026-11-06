package com.hzchum.scim.contract.core.biz.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.UUIDUtil;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessEnclosure;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.api.service.BusinessEnclosureService;
import com.hzchum.scim.common.core.api.enums.CheckStatusEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.contract.core.api.biz.ContractChangeBiz;
import com.hzchum.scim.contract.core.api.common.AddressUtil;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.ContractTechTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectAddressTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectChangeTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentNoEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.enums.StructureMeasureModeEnum;
import com.hzchum.scim.contract.core.api.enums.TaxEnum;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractChange;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectTemp;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTech;
import com.hzchum.scim.contract.core.api.pojo._do.ContractTechTemp;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractAmountRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractChangeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectChangeInfoDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractProjectTempDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.StructureTypeDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ContractTechListDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ChangeAuditDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ContractChangeSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.MeasureModeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.PressureBearingPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProfiledPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.SandwichBoardDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.StructureDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.TrussFloorPlateDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ContractProjectTempDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectBaseChangeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectBusinessChangeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectChangeDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectCustomerChangeDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractChangeService;
import com.hzchum.scim.contract.core.api.service.ContractCollectionService;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractProjectTempService;
import com.hzchum.scim.contract.core.api.service.ContractTechService;
import com.hzchum.scim.contract.core.api.service.ContractTechTempService;
import com.hzchum.scim.mes.building.core.api.service.cargoList.MesBuildingCargoListService;
import com.hzchum.scim.plan.core.api.manager.ProjectLevelManager;
import com.hzchum.scim.plan.core.api.pojo._do.EnclosurePlan;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanMaxMinDateDTO;
import com.hzchum.scim.plan.core.api.service.EnclosurePlanService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechEnclosureService;
import com.hzchum.scim.scm.core.api.pojo._do.ApplyPurchase;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.service.ApplyPurchaseService;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.system.core.api.biz.notification.SysPushFlowConfigBiz;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.common.utils.notification.NotificationTemplateDetailsUtils;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.ProjectUserLink;
import com.hzchum.scim.system.core.api.pojo._do.SysCity;
import com.hzchum.scim.system.core.api.pojo._do.SysCountry;
import com.hzchum.scim.system.core.api.pojo._do.SysProvince;
import com.hzchum.scim.system.core.api.pojo._do.SysRegion;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureType;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.TechnicalTypeDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.ContractTechConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.notification.NotificationServiceTriggerDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.ProjectUserLinkService;
import com.hzchum.scim.system.core.api.service.SysCityService;
import com.hzchum.scim.system.core.api.service.SysCountryService;
import com.hzchum.scim.system.core.api.service.SysProvinceService;
import com.hzchum.scim.system.core.api.service.SysRegionService;
import com.hzchum.scim.system.core.api.service.SysStructureTypeService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractChangeBizImpl implements ContractChangeBiz {
   private static final Logger log = LoggerFactory.getLogger(ContractChangeBizImpl.class);
   @Resource
   private ContractChangeService contractChangeService;
   @Resource
   private ContractProjectTempService projectTempService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectUserLinkService projectUserLinkService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private MesBuildingCargoListService cargoListService;
   @Resource
   private UserService userService;
   @Resource
   private SysStructureTypeService structureTypeService;
   @Resource
   private ContractTechTempService contractTechTempService;
   @Resource
   private ContractTechService contractTechService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private ContractProjectContentService projectContentService;
   @Resource
   private TechEnclosureService enclosureService;
   @Resource
   private SysCountryService countryService;
   @Resource
   private SysProvinceService provinceService;
   @Resource
   private SysCityService cityService;
   @Resource
   private SysRegionService regionService;
   @Resource
   private ContractCollectionService collectionService;
   @Resource
   private ApplyPurchaseService applyPurchaseService;
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ConfigService configService;
   @Resource
   private EnclosurePlanService enclosurePlanService;
   @Resource
   private BusinessEnclosureService businessEnclosureService;
   @Resource
   private BusinessCheckInfoService businessCheckInfoService;
   @Resource
   private BusinessCheckDetailService businessCheckDetailService;
   @Resource
   private SysPushFlowConfigBiz sysPushFlowConfigBiz;
   @Resource
   private NotificationTemplateDetailsUtils detailsUtils;
   @Autowired
   private ProjectLevelManager projectLevelManager;
   @Value("${enclosure.version}")
   private String enclosureVersion;

   @Override
   public PageVO<ContractChangeDTO> listContractChanges(
      Long projectId, Integer year, Integer type, String name, String userName, String auditorName, Integer auditStatus, Integer pageNumber, Integer pageSize
   ) {
      SecurityUser user = UserUtil.getCurrentUser();
      PageHelper.startPage(pageNumber, pageSize);
      List<ContractChangeDTO> contractChangeDTOS;
      if (user.isAdmin()) {
         contractChangeDTOS = this.contractChangeService.listByCondition(null, projectId, year, type, name, userName, auditorName, auditStatus);
      } else {
         contractChangeDTOS = this.contractChangeService.listByCondition(user.getId(), projectId, year, type, name, userName, auditorName, auditStatus);
      }

      contractChangeDTOS.forEach(change -> {
         change.setLeaderList(this.userService.listSimpleName(change.getChangeLeaderIds()));
         change.setAttachmentList(this.attachmentService.listByIds(change.getAttachmentIds()));
      });
      return new PageVO<>(contractChangeDTOS);
   }

   @Override
   public ContractProjectChangeInfoDTO getByChangeId(Long changeId) {
      ContractChange change = this.contractChangeService.getById(changeId);
      Preconditions.checkArgument(change != null, "变更信息不存在!");
      ContractProjectTempDTO projectTempInfo = this.getProjectTempInfo(changeId);
      ContractProjectDTO projectInfo = this.getProjectInfo(change.getProjectId());
      return ContractProjectChangeInfoDTO.builder().projectDto(projectInfo).projectTempDto(projectTempInfo).build();
   }

   private ContractProjectDTO getProjectInfo(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      ContractProjectDTO projectDTO = BeanUtil.copy(project, ContractProjectDTO.class);
      projectDTO.setRegionalFullName(AddressUtil.getAddress(project, ProjectAddressTypeEnum.PROJECT_ADDRESS.getType()));
      if (StringUtils.isNotBlank(project.getAttachments())) {
         List<AttachmentDTO> attachmentDTOS = this.attachmentService.listByIds(project.getAttachments());
         projectDTO.setAttachments(attachmentDTOS);
      }

      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      projectDTO.setContractSignBodyName(branchCompany.getName());
      projectDTO.setSignerName(this.userService.getNameById(project.getSignerId()));
      SysStructureType structureType = this.structureTypeService.getById(project.getStructureTypeId());
      projectDTO.setStructureTypeName(structureType != null ? structureType.getName() : null);
      List<ContractTech> contractTechList = this.contractTechService
         .list(Wrappers.lambdaQuery(ContractTech.class).eq(ContractTech::getProjectId, projectId).orderByAsc(ContractTech::getType));
      projectDTO.setQuantityWork(BigDecimal.ZERO);
      Optional<ContractTech> techOptional = contractTechList.stream()
         .filter(t -> t.getCategoryType().equals(ProjectContentCategoryEnum.STRUCTURE.getType()))
         .findFirst();
      if (techOptional.isPresent() && techOptional.get().getQuantityWork() != null) {
         projectDTO.setQuantityWork(techOptional.get().getQuantityWork().divide(new BigDecimal(1000), 2));
      }

      List<Integer> noList = new ArrayList<>(16);
      int monomerQuantity = this.monomerService.count(Wrappers.lambdaQuery(PlanMonomer.class).eq(PlanMonomer::getProjectId, projectId));
      projectDTO.setMonomerQuantity(monomerQuantity);
      if ((project.getProjectType().equals(ProjectTypeEnum.MES.getType()) || project.getProjectType().equals(ProjectTypeEnum.BRIDGE.getType()))
         && monomerQuantity > 0) {
         noList.add(ProjectContentNoEnum.STRUCTURE.getType());
      }

      List<Integer> categoryList = this.enclosurePlanService
         .list(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(projectId).build()))
         .stream()
         .map(EnclosurePlan::getCategory)
         .distinct()
         .sorted()
         .collect(Collectors.toList());
      noList.addAll(categoryList);
      projectDTO.setProjectContentNoList(noList);
      ContractTechListDTO techListDTO = this.contractTechService.listTech(projectId, null);
      projectDTO.setStructureList(techListDTO.getStructureList());
      projectDTO.setProfiledPlateList(techListDTO.getProfiledPlateList());
      projectDTO.setTrussFloorPlateList(techListDTO.getTrussFloorPlateList());
      projectDTO.setSandwichBoardList(techListDTO.getSandwichBoardList());
      projectDTO.setPressureBearingPlateList(techListDTO.getPressureBearingPlateList());
      if (projectDTO.getCustomerCountryId() != null) {
         SysCountry country = this.countryService.getById(projectDTO.getCustomerCountryId());
         projectDTO.setCustomerCountryName(country != null ? country.getName() : "");
      }

      if (projectDTO.getCustomerProvinceId() != null) {
         SysProvince province = this.provinceService.getById(projectDTO.getCustomerProvinceId());
         projectDTO.setCustomerProvinceName(province != null ? province.getName() : "");
      }

      if (projectDTO.getCustomerCityId() != null) {
         SysCity city = this.cityService.getById(projectDTO.getCustomerCityId());
         projectDTO.setCustomerCityName(city != null ? city.getName() : "");
      }

      if (projectDTO.getCustomerRegionId() != null) {
         SysRegion region = this.regionService.getById(projectDTO.getCustomerRegionId());
         projectDTO.setCustomerRegionName(region != null ? region.getName() : "");
      }

      List<Long> userIds = this.projectUserLinkService
         .list(Wrappers.lambdaQuery(ProjectUserLink.builder().projectId(projectId).build()))
         .stream()
         .map(ProjectUserLink::getUserId)
         .sorted()
         .collect(Collectors.toList());
      List<NameInfo> nameInfoList = this.userService.listByIds(userIds).stream().map(u -> BeanUtil.copy(u, NameInfo.class)).collect(Collectors.toList());
      projectDTO.setRelationUserList(nameInfoList);
      return projectDTO;
   }

   private ContractProjectTempDTO getProjectTempInfo(Long changeId) {
      ContractProjectTemp projectTemp = this.projectTempService
         .getOne(Wrappers.lambdaQuery(ContractProjectTemp.class).eq(ContractProjectTemp::getChangeId, changeId));
      Preconditions.checkArgument(projectTemp != null, "合同修改信息不存在");
      ContractProjectTempDTO projectTempDTO = BeanUtil.copy(projectTemp, ContractProjectTempDTO.class);
      projectTempDTO.setRegionalFullName(AddressUtil.getAddress(projectTemp, ProjectAddressTypeEnum.PROJECT_ADDRESS.getType()));
      projectTempDTO.setProjectContentList(this.projectContentService.listByContentStr(projectTemp.getProjectContent()));
      projectTempDTO.setAttachments(this.attachmentService.listByIds(projectTemp.getAttachments()));
      projectTempDTO.setContractSignBodyName(this.branchCompanyService.getNameById(projectTemp.getContractSignBodyId()));
      projectTempDTO.setRelationUserList(this.userService.listSimpleName(projectTemp.getRelationUserIds()));
      SysStructureType structureType = this.structureTypeService.getById(projectTemp.getStructureTypeId());
      projectTempDTO.setStructureTypeName(structureType != null ? structureType.getName() : null);
      List<MeasureModeDTOParam> modeDTOParamList = new ArrayList<>();
      this.contractTechTempService
         .list(Wrappers.lambdaQuery(ContractTechTemp.class).eq(ContractTechTemp::getProjectTempId, projectTemp.getId()))
         .forEach(t -> {
            if (t.getCategoryType().equals(ProjectContentCategoryEnum.ENCLOSURE.getType()) && t.getMeasureMode() != null) {
               MeasureModeDTOParam modeDTOParam = MeasureModeDTOParam.builder().no(t.getType()).measureMode(t.getMeasureMode()).build();
               if (t.getMeasureMode() == 2) {
                  modeDTOParam.setQuantityWork(t.getQuantityWork().divide(new BigDecimal(1000000), 2));
               }

               if (t.getMeasureMode() == 1) {
                  modeDTOParam.setQuantityWork(t.getQuantityWork().divide(new BigDecimal(1000), 2));
               }

               modeDTOParamList.add(modeDTOParam);
            }

            if (t.getCategoryType().equals(ProjectContentCategoryEnum.STRUCTURE.getType())) {
               projectTempDTO.setQuantityWork(t.getQuantityWork().divide(new BigDecimal(1000), 2));
            }

            if (t.getType().equals(ContractTechTypeEnum.STRUCTURE.getType()) && StringUtils.isNotBlank(t.getNewJsonList())) {
               List<StructureDTOParam> structureList = JSON.parseArray(t.getNewJsonList(), StructureDTOParam.class);
               List<StructureTypeDTO> structureTypeDTOList = structureList.stream().map(dtoParam -> {
                  StructureTypeDTO structureTypeDTO = BeanUtil.copy(dtoParam, StructureTypeDTO.class);
                  structureTypeDTO.setAttachments(this.attachmentService.listByIds(dtoParam.getAttachmentIds()));
                  return structureTypeDTO;
               }).collect(Collectors.toList());
               projectTempDTO.setStructureList(structureTypeDTOList);
            }

            if (t.getType().equals(ContractTechTypeEnum.PROFILED_PLATE.getType())) {
               List<ProfiledPlateDTOParam> profiledPlateList = JSON.parseArray(t.getNewJsonList(), ProfiledPlateDTOParam.class);
               projectTempDTO.setProfiledPlateList(profiledPlateList);
            }

            if (t.getType().equals(ContractTechTypeEnum.SANDWICH_BOARD.getType())) {
               List<SandwichBoardDTOParam> sandwichBoardList = JSON.parseArray(t.getNewJsonList(), SandwichBoardDTOParam.class);
               projectTempDTO.setSandwichBoardList(sandwichBoardList);
            }

            if (t.getType().equals(ContractTechTypeEnum.TRUSS_FLOOR_PLATE.getType())) {
               List<TrussFloorPlateDTOParam> trussFloorPlateList = JSON.parseArray(t.getNewJsonList(), TrussFloorPlateDTOParam.class);
               projectTempDTO.setTrussFloorPlateList(trussFloorPlateList);
            }

            if (t.getType().equals(ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType())) {
               List<PressureBearingPlateDTOParam> pressureBearingPlateList = JSON.parseArray(t.getNewJsonList(), PressureBearingPlateDTOParam.class);
               projectTempDTO.setPressureBearingPlateList(pressureBearingPlateList);
            }
         });
      projectTempDTO.setMeasureModeList(modeDTOParamList);
      return projectTempDTO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean changeProject(ContractChangeSaveDTOParam dtoParam) {
      ContractProject project = this.projectService.checkProjectStatus(dtoParam.getProjectId());
      Preconditions.checkArgument(
         this.contractChangeService
               .count(
                  (Wrapper<ContractChange>)(new LambdaQueryWrapper<ContractChange>().eq(ContractChange::getProjectId, dtoParam.getProjectId()))
                     .eq(ContractChange::getAuditStatus, AuditStatusEnum.AUDITING.getType())
               )
            == 0,
         "项目变更正在审核中,请先完成审核,再进行修改!"
      );
      ContractChange change = BeanUtil.copy(dtoParam, ContractChange.class);
      change.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      if (dtoParam.getUserId() != null) {
         User user = this.userService.getById(dtoParam.getUserId());
         Preconditions.checkArgument(user != null, "用户不存在");
         change.setUserName(user.getName());
      } else {
         change.setUserId(UserUtil.getCurrentUserId());
         change.setUserName(UserUtil.getCurrentName());
      }

      if (ProjectChangeTypeEnum.AMOUNT_CHANGE.getType().equals(dtoParam.getType())) {
         BigDecimal changeAmount = dtoParam.getChangeAmount();
         Preconditions.checkArgument(changeAmount != null, "合同金额不能为空!");
         Preconditions.checkArgument(changeAmount.compareTo(BigDecimal.ZERO) >= 0, "合同金额不能小于0!");
         Preconditions.checkArgument(changeAmount.compareTo(project.getContractAmount()) != 0, "合同金额与原金额相同!");
         change.setContractAmount(project.getContractAmount());
         change.setAttachmentIds(StringUtils.join(dtoParam.getAttachmentIds(), ","));
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(dtoParam.getUserList()), "变更负责人不能为空!");
         change.setChangeLeaderIds(StringUtils.join(dtoParam.getUserList(), ","));
         this.contractChangeService.save(change);
      }

      if (ProjectChangeTypeEnum.INFO_CHANGE.getType().equals(dtoParam.getType())) {
         change.setContractAmount(project.getContractAmount());
         change.setChangeDate(dtoParam.getChangeDate() == null ? LocalDate.now() : dtoParam.getChangeDate());
         this.contractChangeService.save(change);
         Preconditions.checkArgument(dtoParam.getProjectUpdateDTOParam() != null, "合同信息不能为空!");
         ProjectChangeDTOParam projectUpdateDTOParam = dtoParam.getProjectUpdateDTOParam();
         ProjectBaseChangeDTOParam baseUpdateDTOParam = projectUpdateDTOParam.getBaseUpdateDTOParam();
         ProjectBusinessChangeDTOParam businessUpdateDTOParam = projectUpdateDTOParam.getBusinessUpdateDTOParam();
         ProjectCustomerChangeDTOParam customerUpdateDTOParam = projectUpdateDTOParam.getCustomerUpdateDTOParam();
         ContractProjectTemp tempProject = ContractProjectTemp.builder().projectId(dtoParam.getProjectId()).changeId(change.getId()).build();
         Preconditions.checkArgument(baseUpdateDTOParam.getStartDate() != null && baseUpdateDTOParam.getEndDate() != null, "项目计划开工日期和完工日期不能为空");
         Preconditions.checkArgument(!baseUpdateDTOParam.getEndDate().isBefore(baseUpdateDTOParam.getStartDate()), "计划完工日期不能早于计划开工日期!");
         PlanMaxMinDateDTO monomerDate = this.monomerService.getMonomerDate(dtoParam.getProjectId());
         if (monomerDate != null && monomerDate.getMinDate() != null) {
         }

         BeanUtil.copy(baseUpdateDTOParam, tempProject);
         tempProject.setManagementFeeRate(baseUpdateDTOParam.getManagementFeeRate() != null ? baseUpdateDTOParam.getManagementFeeRate() : BigDecimal.ZERO);
         tempProject.setPrepayments(baseUpdateDTOParam.getPrepayments() != null ? baseUpdateDTOParam.getPrepayments() : BigDecimal.ZERO);
         tempProject.setMarginAmount(baseUpdateDTOParam.getMarginAmount() != null ? baseUpdateDTOParam.getMarginAmount() : BigDecimal.ZERO);
         Preconditions.checkArgument(
            StringUtils.isBlank(baseUpdateDTOParam.getProjectManagerPhone())
               || Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", baseUpdateDTOParam.getProjectManagerPhone()),
            "项目经理电话号码有误!"
         );
         if (baseUpdateDTOParam.getProjectManagerId() != null) {
            User user = this.userService.getById(baseUpdateDTOParam.getProjectManagerId());
            Preconditions.checkArgument(user != null, "项目经理不存在!");
            tempProject.setProjectManagerName(user.getName());
            tempProject.setProjectManagerPhone(
               StringUtils.isNotBlank(baseUpdateDTOParam.getProjectManagerPhone()) ? baseUpdateDTOParam.getProjectManagerPhone() : user.getPhone()
            );
         }

         Preconditions.checkArgument(
            StringUtils.isBlank(baseUpdateDTOParam.getSignerPhone())
               || Pattern.matches("((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$", baseUpdateDTOParam.getSignerPhone()),
            "销售负责人电话号码有误!"
         );
         if (baseUpdateDTOParam.getSignerId() != null) {
            User user = this.userService.getById(baseUpdateDTOParam.getSignerId());
            Preconditions.checkArgument(user != null, "销售负责人不存在!");
            tempProject.setSignerName(user.getName());
            tempProject.setSignerPhone(StringUtils.isNotBlank(baseUpdateDTOParam.getSignerPhone()) ? baseUpdateDTOParam.getSignerPhone() : user.getPhone());
         }

         if (!businessUpdateDTOParam.getContractSignBodyId().equals(project.getContractSignBodyId())) {
            BranchCompany branchCompany = this.branchCompanyService.getById(businessUpdateDTOParam.getContractSignBodyId());
            Preconditions.checkArgument(branchCompany != null, "合同签订主体不存在!");
            List<ApplyPurchase> applyPurchases = this.applyPurchaseService
               .list(
                  Wrappers.lambdaQuery(ApplyPurchase.class)
                     .in(
                        ApplyPurchase::getDataStatus,
                        DataStatusEnum.UNDER_REVIEW.getType(),
                        DataStatusEnum.SUCCEED.getType(),
                        DataStatusEnum.CANCELLATION_UNDER_WAY.getType()
                     )
                     .and(
                        a -> {
                           LambdaQueryWrapper var10000 = a.eq(ApplyPurchase::getProjectId, dtoParam.getProjectId())
                              .or()
                              .apply("find_in_set({0}, project_ids)", dtoParam.getProjectId());
                        }
                     )
               );
            Preconditions.checkArgument(applyPurchases.isEmpty(), "项目已创建物料申购单!!!禁止修改合同签订主体!!!");
            List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
               .list(
                  Wrappers.lambdaQuery(PurchaseOrder.class)
                     .in(
                        PurchaseOrder::getDataStatus,
                        DataStatusEnum.UNDER_REVIEW.getType(),
                        DataStatusEnum.SUCCEED.getType(),
                        DataStatusEnum.CANCELLATION_UNDER_WAY.getType()
                     )
                     .apply("find_in_set({0}, project_ids)", dtoParam.getProjectId())
               );
            Preconditions.checkArgument(purchaseOrders.isEmpty(), "项目已创建物料采购单!!!禁止修改合同签订主体!!!");
         }

         Preconditions.checkArgument(monomerDate == null || businessUpdateDTOParam.getBusinessType().equals(project.getBusinessType()), "项目已创建单体计划,不可修改业务类型!");
         Preconditions.checkArgument(monomerDate == null || businessUpdateDTOParam.getProjectType().equals(project.getProjectType()), "项目已创建单体计划,不可修改项目类型!");
         List<MeasureModeDTOParam> measureModeList = businessUpdateDTOParam.getMeasureModeList();
         boolean isModifyTransportMode = false;
         if (businessUpdateDTOParam.getTransportMode() != null) {
            isModifyTransportMode = !businessUpdateDTOParam.getTransportMode().equals(project.getTransportMode());
         }

         this.checkProjectContent(project, businessUpdateDTOParam.getProjectContent());
         boolean isModifyStructureMeasureMode = project.getStructureMeasureMode() != null
            && !project.getStructureMeasureMode().equals(businessUpdateDTOParam.getStructureMeasureMode());
         List<Integer> categoryList = this.contractTechService.changeEnclosureMeasureMode(dtoParam.getProjectId(), measureModeList);
         this.cargoListService.checkIsLoad(dtoParam.getProjectId(), isModifyTransportMode, isModifyStructureMeasureMode, categoryList);
         Preconditions.checkArgument(
            businessUpdateDTOParam.getIsTax().equals(TaxEnum.NO_TAX.getType()) || businessUpdateDTOParam.getInvoiceType() != null, "含税条件下,必须填写发票类型"
         );
         Preconditions.checkArgument(
            businessUpdateDTOParam.getIsTax().equals(TaxEnum.NO_TAX.getType())
               || InvoiceTypeEnum.RECEIPTS.getType().equals(businessUpdateDTOParam.getInvoiceType())
               || businessUpdateDTOParam.getTaxRate() != null,
            "税率不能为空"
         );
         TechnicalTypeDTO technicalType = this.configService.getTechnicalType();
         if (technicalType.getTechnicalType()) {
            this.checkUpdateTech(dtoParam.getProjectId(), businessUpdateDTOParam);
         }

         BeanUtil.copy(businessUpdateDTOParam, tempProject);
         tempProject.setProjectContent(StringUtils.join(businessUpdateDTOParam.getProjectContent(), ","));
         Set<Integer> content = this.projectContentService
            .listByIds(businessUpdateDTOParam.getProjectContent())
            .stream()
            .map(ContractProjectContent::getCategoryType)
            .collect(Collectors.toSet());
         tempProject.setProductCategory(content.stream().mapToInt(Integer::intValue).sum());
         if ((tempProject.getProductCategory() & ProjectContentCategoryEnum.STRUCTURE.getType()) > 0) {
            Preconditions.checkArgument(businessUpdateDTOParam.getTransportMode() != null, "操作失败,该项目含结构产品类型，结构运输方式不可为空!");
         }

         if ((tempProject.getProductCategory() & ProjectContentCategoryEnum.ENCLOSURE.getType()) > 0) {
            Preconditions.checkArgument(businessUpdateDTOParam.getEnclosureTransportMode() != null, "操作失败,该项目含围护产品类型，围护运输方式不可为空!");
         }

         if ((tempProject.getProductCategory() & ProjectContentCategoryEnum.STRUCTURE.getType()) > 0) {
            Preconditions.checkArgument(businessUpdateDTOParam.getStructureTypeId() != null, "结构类型不能为空!");
            SysStructureType structureType = this.structureTypeService.getById(businessUpdateDTOParam.getStructureTypeId());
            Preconditions.checkArgument(structureType != null, "选择结构类型不存在!");
            Preconditions.checkArgument(structureType.getProjectType().equals(businessUpdateDTOParam.getProjectType()), "选择结构类型有误!");
            Preconditions.checkArgument(structureType.getBoolEnableEnum(), "选择结构类型已禁用!");
            ContractTechConfigDTO contractTechConfig = this.configService.getContractTechConfig();
            Preconditions.checkArgument(
               !contractTechConfig.getBoolRequiredInput() || CollectionUtils.isNotEmpty(businessUpdateDTOParam.getStructureList()), "未填写技术交底!"
            );
         }

         BeanUtil.copy(customerUpdateDTOParam, tempProject);
         this.setTempProjectRegionInfo(tempProject);
         tempProject.setAttachments(StringUtils.join(baseUpdateDTOParam.getAttachments(), ","));
         tempProject.setRelationUserIds(StringUtils.join(projectUpdateDTOParam.getUserIdList(), ","));
         this.projectTempService.save(tempProject);
         this.setTechChange(dtoParam.getProjectId(), change.getId(), tempProject.getId(), businessUpdateDTOParam);
      }

      this.sysPushFlowConfigBiz
         .triggerFlow(
            NotificationServiceTriggerDTO.builder()
               .projectId(change.getProjectId())
               .dataId(change.getId())
               .contentDetails(this.detailsUtils.getProjectTemplateDetails(project.getSerialNumber(), project.getShortName(), false))
               .notificationTypeEnum(NotificationModuleTypeEnum.UPDATE_CONTRACT.getNotificationType())
               .userList(new ArrayList<>())
               .build()
         );
      return true;
   }

   private void checkProjectContent(ContractProject project, List<Long> projectContent) {
      List<ContractProjectContent> projectContentList = this.projectContentService.listByIds(projectContent);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(projectContentList), "项目内容传值错误!");
      Preconditions.checkArgument(projectContentList.size() == projectContent.size(), "项目内容传值出现错误!");
      if (this.enclosureVersion.equals("old")) {
         List<EnclosurePlan> enclosurePlanList = this.enclosurePlanService
            .list(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(project.getId()).build()));
         if (CollectionUtils.isNotEmpty(enclosurePlanList)) {
            List<Integer> projectContentNoList = projectContentList.stream()
               .filter(c -> c.getCategoryType().equals(ProjectContentCategoryEnum.ENCLOSURE.getType()))
               .map(ContractProjectContent::getNo)
               .collect(Collectors.toList());
            enclosurePlanList.forEach(
               enclosurePlan -> Preconditions.checkArgument(
                  projectContentNoList.contains(enclosurePlan.getCategory()),
                  ProjectContentNoEnum.getNameByType(enclosurePlan.getCategory()) + "计划已创建,不可删除该项目内容!"
               )
            );
         }
      }
   }

   private void checkUpdateTech(Long projectId, ProjectBusinessChangeDTOParam businessUpdateDTOParam) {
      List<ProfiledPlateDTOParam> profiledPlateList = businessUpdateDTOParam.getProfiledPlateList();
      List<String> plateTypeList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(profiledPlateList)) {
         plateTypeList = profiledPlateList.stream().map(ProfiledPlateDTOParam::getPlateType).collect(Collectors.toList());
      }

      List<String> listPlateTypeList = this.enclosureService.listPlateTypeList(projectId, ContractTechTypeEnum.PROFILED_PLATE.getType());
      if (CollectionUtils.isNotEmpty(listPlateTypeList)) {
         List<String> finalPlateTypeList = plateTypeList;
         listPlateTypeList.forEach(plate -> Preconditions.checkArgument(finalPlateTypeList.contains(plate), "不能删除正在围护清单中正在使用的板型"));
      }

      List<SandwichBoardDTOParam> sandwichBoardList = businessUpdateDTOParam.getSandwichBoardList();
      plateTypeList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(sandwichBoardList)) {
         plateTypeList = sandwichBoardList.stream().map(SandwichBoardDTOParam::getPlateType).collect(Collectors.toList());
      }

      listPlateTypeList = this.enclosureService.listPlateTypeList(projectId, ContractTechTypeEnum.SANDWICH_BOARD.getType());
      if (CollectionUtils.isNotEmpty(listPlateTypeList)) {
         List<String> finalPlateTypeList1 = plateTypeList;
         listPlateTypeList.forEach(plate -> Preconditions.checkArgument(finalPlateTypeList1.contains(plate), "不能删除正在围护清单中正在使用的板型"));
      }

      List<TrussFloorPlateDTOParam> trussFloorPlateList = businessUpdateDTOParam.getTrussFloorPlateList();
      plateTypeList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(trussFloorPlateList)) {
         plateTypeList = trussFloorPlateList.stream().map(TrussFloorPlateDTOParam::getSerialNumber).collect(Collectors.toList());
      }

      listPlateTypeList = this.enclosureService.listPlateTypeList(projectId, ContractTechTypeEnum.TRUSS_FLOOR_PLATE.getType());
      if (CollectionUtils.isNotEmpty(listPlateTypeList)) {
         List<String> finalPlateTypeList2 = plateTypeList;
         listPlateTypeList.forEach(plate -> Preconditions.checkArgument(finalPlateTypeList2.contains(plate), "不能删除正在围护清单中正在使用的板型"));
      }

      List<PressureBearingPlateDTOParam> pressureBearingPlateList = businessUpdateDTOParam.getPressureBearingPlateList();
      plateTypeList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(pressureBearingPlateList)) {
         plateTypeList = pressureBearingPlateList.stream().map(PressureBearingPlateDTOParam::getPlateType).collect(Collectors.toList());
      }

      listPlateTypeList = this.enclosureService.listPlateTypeList(projectId, ContractTechTypeEnum.PRESSURE_BEARING_PLATE.getType());
      if (CollectionUtils.isNotEmpty(listPlateTypeList)) {
         List<String> finalPlateTypeList3 = plateTypeList;
         listPlateTypeList.forEach(plate -> Preconditions.checkArgument(finalPlateTypeList3.contains(plate), "不能删除正在围护清单中正在使用的板型"));
      }
   }

   private void setTempProjectRegionInfo(ContractProjectTemp project) {
      if (project.getCountryId() != null) {
         SysCountry country = this.countryService.getById(project.getCountryId());
         Preconditions.checkArgument(country != null, "项目所在国家不存在!");
         project.setCountryName(country.getName());
         if (project.getProvinceId() != null) {
            SysProvince province = this.provinceService.getById(project.getProvinceId());
            Preconditions.checkArgument(province != null, "项目所在省份(直辖市)不存在!");
            Preconditions.checkArgument(province.getCountryId().equals(project.getCountryId()), "项目所在国家与省份(城市)不匹配!");
            project.setProvinceName(province.getName());
         } else {
            project.setProvinceName(null);
         }

         if (project.getCityId() != null) {
            SysCity city = this.cityService.getById(project.getCityId());
            Preconditions.checkArgument(city != null, "项目所在城市(区)不存在!");
            Preconditions.checkArgument(city.getProvinceId().equals(project.getProvinceId()), "项目所在省份(城市)与城市(区)不匹配!");
            project.setCityName(city.getName());
         } else {
            project.setCityName(null);
         }

         if (project.getRegionId() != null) {
            SysRegion region = this.regionService.getById(project.getRegionId());
            Preconditions.checkArgument(region != null, "项目所在区(县)不存在!");
            Preconditions.checkArgument(region.getCityId().equals(project.getCityId()), "项目所在城市(区)与区(县)不匹配!");
            project.setRegionName(region.getName());
         } else {
            project.setRegionName(null);
         }
      } else {
         project.setCountryName(null);
         project.setProvinceId(null);
         project.setProvinceName(null);
         project.setCityId(null);
         project.setCityName(null);
         project.setRegionId(null);
         project.setRegionName(null);
      }

      if (project.getCustomerCountryId() != null) {
         SysCountry country = this.countryService.getById(project.getCustomerCountryId());
         Preconditions.checkArgument(country != null, "客户所在国家不存在!");
         project.setCustomerCountryName(country.getName());
         if (project.getCustomerProvinceId() != null) {
            SysProvince province = this.provinceService.getById(project.getCustomerProvinceId());
            Preconditions.checkArgument(province != null, "客户所在省份(城市)不存在!");
            project.setCustomerProvinceName(province.getName());
         } else {
            project.setCustomerProvinceName(null);
         }

         if (project.getCustomerCityId() != null) {
            SysCity city = this.cityService.getById(project.getCustomerCityId());
            Preconditions.checkArgument(city != null, "客户所在城市(区)不存在!");
            project.setCustomerCityName(city.getName());
         } else {
            project.setCustomerCityName(null);
         }

         if (project.getCustomerRegionId() != null) {
            SysRegion region = this.regionService.getById(project.getCustomerRegionId());
            Preconditions.checkArgument(region != null, "客户所在区(县)不存在!");
            project.setCustomerRegionName(region.getName());
         } else {
            project.setCustomerRegionName(null);
         }
      } else {
         project.setCustomerCountryName(null);
         project.setCustomerProvinceId(null);
         project.setCustomerProvinceName(null);
         project.setCustomerCityId(null);
         project.setCustomerCityName(null);
         project.setCustomerRegionId(null);
         project.setCustomerRegionName(null);
      }
   }

   private void setTechChange(Long projectId, Long changeId, Long projectTempId, ProjectBusinessChangeDTOParam businessParam) {
      Map<Integer, ContractTech> techTypeMap = this.contractTechService
         .list(Wrappers.lambdaQuery(ContractTech.builder().projectId(projectId).build()))
         .stream()
         .collect(Collectors.toMap(ContractTech::getType, Function.identity()));
      businessParam.getProjectContent()
         .forEach(
            contentId -> {
               ContractProjectContent content = this.projectContentService.getById(contentId);
               Preconditions.checkArgument(content != null, "项目内容不存在");
               if (!content.getCategoryType().equals(ProjectContentCategoryEnum.AUXILIARY.getType())) {
                  ContractTechTemp techTemp = ContractTechTemp.builder()
                     .changeId(changeId)
                     .projectTempId(projectTempId)
                     .projectId(projectId)
                     .type(content.getNo())
                     .categoryType(content.getCategoryType())
                     .oldJsonList(techTypeMap.containsKey(content.getNo()) ? techTypeMap.get(content.getNo()).getDetailJson() : null)
                     .newJsonList("")
                     .auditStatus(AuditStatusEnum.AUDITING.getType())
                     .userId(UserUtil.getCurrentUserId())
                     .build();
                  if (content.getCategoryType().equals(ProjectContentCategoryEnum.STRUCTURE.getType())) {
                     Preconditions.checkArgument(StructureMeasureModeEnum.isExist(businessParam.getStructureMeasureMode()), "结构结算方式有误!");
                     techTemp.setMeasureMode(businessParam.getStructureMeasureMode());
                     techTemp.setQuantityWork(businessParam.getQuantityWork().multiply(BigDecimal.valueOf(1000L)));
                     techTemp.setStructureStatus(businessParam.getStructureStatus());
                     if (CollectionUtils.isNotEmpty(businessParam.getStructureList())) {
                        businessParam.getStructureList().forEach(s -> {
                           if (StringUtils.isBlank(s.getId())) {
                              s.setId(UUIDUtil.getUUID());
                           }
                        });
                        techTemp.setNewJsonList(JSON.toJSONString(businessParam.getStructureList()));
                     }
                  }

                  this.contractTechTempService.save(techTemp);
               }
            }
         );
   }

   @Override
   public ListVO<ContractAmountRecordDTO> listContractAmountRecord(Long projectId) {
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在!");
      List<ContractAmountRecordDTO> amountRecordDTOList = new ArrayList<>();
      List<ContractChange> contractChangeList = this.contractChangeService
         .list(
            Wrappers.lambdaQuery(ContractChange.class)
               .eq(ContractChange::getProjectId, projectId)
               .eq(ContractChange::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(ContractChange::getType, ProjectChangeTypeEnum.AMOUNT_CHANGE.getType())
               .orderByAsc(ContractChange::getId)
         );
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      if (CollectionUtils.isEmpty(contractChangeList)) {
         ContractAmountRecordDTO recordDTO = ContractAmountRecordDTO.builder()
            .status("合同立项金额")
            .amount(project.getContractAmount())
            .date(project.getCreateTime().toLocalDate())
            .userId(project.getUserId())
            .build();
         if (project.getUserId() != null && ObjectUtils.isNotEmpty(userMap.get(project.getUserId()))) {
            recordDTO.setUserName(userMap.get(project.getUserId()).getName());
         }

         amountRecordDTOList.add(recordDTO);
      } else {
         for (int i = 0; i < contractChangeList.size(); i++) {
            ContractChange change = contractChangeList.get(i);
            if (i == 0) {
               ContractAmountRecordDTO recordDTO = ContractAmountRecordDTO.builder()
                  .status("合同立项金额")
                  .amount(change.getContractAmount())
                  .date(project.getCreateTime().toLocalDate())
                  .userId(project.getUserId())
                  .build();
               if (project.getUserId() != null && ObjectUtils.isNotEmpty(userMap.get(project.getUserId()))) {
                  recordDTO.setUserName(userMap.get(project.getUserId()).getName());
               }

               amountRecordDTOList.add(recordDTO);
            }

            ContractAmountRecordDTO recordDTO = ContractAmountRecordDTO.builder()
               .status("合同金额变更")
               .amount(change.getChangeAmount())
               .date(change.getChangeDate())
               .userId(change.getUserId())
               .userName(change.getUserName())
               .build();
            amountRecordDTOList.add(recordDTO);
         }
      }

      return new ListVO<>(amountRecordDTOList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditProjectChange(ChangeAuditDTOParam dtoParam) {
      ContractChange change = this.contractChangeService.getById(dtoParam.getId());
      Preconditions.checkArgument(change != null, "变更信息不存在");
      Preconditions.checkArgument(change.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "变更信息已审核!");
      ContractProject project = this.projectService.checkProjectStatus(change.getProjectId());
      BeanUtil.copy(dtoParam, change);
      change.setAuditorId(UserUtil.getCurrentUserId());
      change.setAuditorName(UserUtil.getCurrentName());
      change.setAuditTime(LocalDateTime.now());
      if (change.getType().equals(ProjectChangeTypeEnum.INFO_CHANGE.getType())) {
         ContractProjectTemp temp = this.projectTempService
            .getOne((Wrapper<ContractProjectTemp>)new LambdaQueryWrapper<ContractProjectTemp>().eq(ContractProjectTemp::getChangeId, dtoParam.getId()));
         Preconditions.checkArgument(temp != null, "合同信息修改详情不存在");
         if (dtoParam.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
            if (!temp.getContractSignBodyId().equals(project.getContractSignBodyId())) {
               List<ApplyPurchase> applyPurchases = this.applyPurchaseService
                  .list(
                     Wrappers.lambdaQuery(ApplyPurchase.class)
                        .in(
                           ApplyPurchase::getDataStatus,
                           DataStatusEnum.UNDER_REVIEW.getType(),
                           DataStatusEnum.SUCCEED.getType(),
                           DataStatusEnum.CANCELLATION_UNDER_WAY.getType()
                        )
                        .and(
                           a -> {
                              LambdaQueryWrapper var10000 = a.eq(ApplyPurchase::getProjectId, change.getProjectId())
                                 .or()
                                 .apply("find_in_set({0}, project_ids)", change.getProjectId());
                           }
                        )
                  );
               Preconditions.checkArgument(applyPurchases.isEmpty(), "项目已创建物料申购单!!!禁止修改合同签订主体!!!");
               List<PurchaseOrder> purchaseOrders = this.purchaseOrderService
                  .list(
                     Wrappers.lambdaQuery(PurchaseOrder.class)
                        .in(
                           PurchaseOrder::getDataStatus,
                           DataStatusEnum.UNDER_REVIEW.getType(),
                           DataStatusEnum.SUCCEED.getType(),
                           DataStatusEnum.CANCELLATION_UNDER_WAY.getType()
                        )
                        .apply("find_in_set({0}, project_ids)", change.getProjectId())
                  );
               Preconditions.checkArgument(purchaseOrders.isEmpty(), "项目已创建物料采购单!!!禁止修改合同签订主体!!!");
            }

            this.attachmentService.replaceAttachment(project.getAttachments(), temp.getAttachments());
            ContractProjectTempDtoParam tempDtoParam = BeanUtil.copy(temp, ContractProjectTempDtoParam.class);
            BeanUtil.copy(tempDtoParam, project);
            project.setLastUpdateTime(LocalDateTime.now());
            project.setLastUpdateUserId(change.getUserId());
            this.projectService.updateById(project);
            this.projectUserLinkService.remove((Wrapper<ProjectUserLink>)Wrappers.<ProjectUserLink>lambdaQuery().eq(ProjectUserLink::getProjectId, change.getProjectId()));
            Arrays.stream(StringUtils.split(temp.getRelationUserIds(), ",")).map(Long::parseLong).forEach(userId -> {
               ProjectUserLink link = ProjectUserLink.builder().projectId(change.getProjectId()).userId(userId).build();
               this.projectUserLinkService.save(link);
            });
            this.projectLevelManager.updateProjectBranchCompany(change.getProjectId(), temp.getContractSignBodyId());
         }

         this.setChangeTechList(temp.getId(), project.getId(), change.getUserId(), dtoParam.getAuditStatus());
      }

      if (change.getType().equals(ProjectChangeTypeEnum.AMOUNT_CHANGE.getType()) && dtoParam.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         project.setContractAmount(change.getChangeAmount());
         this.projectService.updateById(project);
      }

      this.contractChangeService.updateById(change);
      if (dtoParam.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
         this.redisUtils.del("simpleProjectList");
      }

      return Boolean.TRUE;
   }

   private void setChangeTechList(Long projectTempId, Long projectId, Long userId, Integer auditStatus) {
      List<ContractTechTemp> techTempList = this.contractTechTempService
         .list(Wrappers.lambdaQuery(ContractTechTemp.builder().projectTempId(projectTempId).auditStatus(AuditStatusEnum.AUDITING.getType()).build()));
      techTempList.forEach(techTemp -> techTemp.setAuditStatus(auditStatus));
      this.contractTechTempService.updateBatchById(techTempList);
      if (auditStatus.equals(AuditStatusEnum.SUCCEED.getType())) {
         Map<Integer, Integer> enclosureMeasureModeMap = new HashMap<>();
         this.contractTechService.remove(Wrappers.lambdaQuery(ContractTech.builder().build()).eq(ContractTech::getProjectId, projectId));
         Map<Integer, List<EnclosurePlan>> categoryPlanListMap = this.enclosurePlanService
            .list(Wrappers.lambdaQuery(EnclosurePlan.builder().projectId(projectId).build()))
            .stream()
            .collect(Collectors.groupingBy(EnclosurePlan::getCategory));
         techTempList.forEach(
            temp -> {
               ContractTech tech = BeanUtil.copy(temp, ContractTech.class);
               tech.setDetailJson(temp.getNewJsonList());
               tech.setUserId(userId);
               tech.setStatus(categoryPlanListMap.containsKey(temp.getType()) ? 1 : 0);
               this.contractTechService.save(tech);
               if (enclosureMeasureModeMap.containsKey(temp.getType()) && !enclosureMeasureModeMap.get(temp.getType()).equals(temp.getMeasureMode())) {
                  List<BusinessEnclosure> businessEnclosureList = this.businessEnclosureService
                     .list(Wrappers.lambdaQuery(BusinessEnclosure.builder().projectId(projectId).category(temp.getType()).build()));
                  if (CollectionUtils.isNotEmpty(businessEnclosureList)) {
                     businessEnclosureList.forEach(businessEnclosure -> {
                        businessEnclosure.setPricingManner(temp.getMeasureMode());
                        businessEnclosure.setUnitPrice(null);
                        businessEnclosure.setTotalPrice(null);
                     });
                     this.businessEnclosureService.updateBatchById(businessEnclosureList);
                     List<BusinessCheckInfo> checkInfoList = this.businessCheckInfoService
                        .list(
                           Wrappers.lambdaQuery(BusinessCheckInfo.class)
                              .eq(BusinessCheckInfo::getProjectId, projectId)
                              .eq(BusinessCheckInfo::getType, ProductTypeEnum.ENCLOSURE.getType())
                              .eq(BusinessCheckInfo::getStatus, CheckStatusEnum.PENDING.getType())
                              .in(
                                 BusinessCheckInfo::getEnclosurePlanId,
                                 categoryPlanListMap.get(temp.getType()).stream().map(EnclosurePlan::getId).collect(Collectors.toList())
                              )
                        );
                     if (CollectionUtils.isNotEmpty(checkInfoList)) {
                        List<Long> infoIds = checkInfoList.stream().map(BusinessCheckInfo::getId).collect(Collectors.toList());
                        this.businessCheckInfoService.removeByIds(infoIds);
                        this.businessCheckDetailService
                           .remove(Wrappers.lambdaQuery(BusinessCheckDetail.class).in(BusinessCheckDetail::getCheckInfoId, infoIds));
                     }
                  }
               }
            }
         );
      }
   }
}
