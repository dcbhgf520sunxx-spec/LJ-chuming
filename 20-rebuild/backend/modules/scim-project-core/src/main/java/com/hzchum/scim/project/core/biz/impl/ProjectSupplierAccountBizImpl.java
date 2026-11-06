package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.contract.core.api.enums.DivideMethodEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.enums.laborManagement.EmployeeStatusEnum;
import com.hzchum.scim.plan.core.api.pojo._do.PlanArea;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.service.PlanAreaService;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.project.core.api.biz.ProjectManageRosterBiz;
import com.hzchum.scim.project.core.api.biz.ProjectSupplierAccountBiz;
import com.hzchum.scim.project.core.api.pojo._do.ProjectLaborSubsupplierOrderProductLink;
import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRoster;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAccount;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SubAreaDTO;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SubMonomerDTO;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SubProjectDTO;
import com.hzchum.scim.project.core.api.service.ProjectLaborSubsupplierOrderProductLinkService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAccountService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.UserTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ProjectSupplierAccountBizImpl implements ProjectSupplierAccountBiz {
   private static final Logger log = LoggerFactory.getLogger(ProjectSupplierAccountBizImpl.class);
   @Resource
   ProjectSupplierAccountService supplierAccountService;
   @Resource
   ContractProjectService projectService;
   @Resource
   PlanMonomerService monomerService;
   @Resource
   PlanAreaService areaService;
   @Resource
   private PasswordEncoder passwordEncoder;
   @Resource
   ProjectSupplierAreaLinkService supplierAreaLinkService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private UserService userService;
   @Resource
   private ProjectLaborSubsupplierOrderProductLinkService orderProductLinkService;
   @Resource
   private ProjectManageRosterBiz rosterBiz;

   @Override
   public List<SubProjectDTO> listProject() {
      Long supplierId = this.supplierAccountService.getSupplierIdByUserId(UserUtil.getCurrentUserId());
      List<ProjectSupplierAreaLink> areaLinkList = this.supplierAreaLinkService
         .list(
            Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
               .eq(ProjectSupplierAreaLink::getSupplierId, supplierId)
               .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
               .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
         );
      Map<Long, List<ProjectSupplierAreaLink>> listMap = areaLinkList.stream().collect(Collectors.groupingBy(ProjectSupplierAreaLink::getProjectId));
      List<SubProjectDTO> projectDTOList = new ArrayList<>();
      listMap.forEach((projectId, projectLinkList) -> {
         ContractProject project = this.projectService.getById(projectId);
         SubProjectDTO subProjectDTO = BeanUtil.copy(project, SubProjectDTO.class);
         List<SubMonomerDTO> subMonomerDTOList = new ArrayList<>();
         Map<Long, List<ProjectSupplierAreaLink>> monomerMap = projectLinkList.stream().collect(Collectors.groupingBy(ProjectSupplierAreaLink::getMonomerId));
         monomerMap.forEach((monomerId, monomerLinkList) -> {
            PlanMonomer monomer = this.monomerService.getById(monomerId);
            SubMonomerDTO subMonomerDTO = BeanUtil.copy(monomer, SubMonomerDTO.class);
            List<SubAreaDTO> areaList = new ArrayList<>();
            monomerLinkList.forEach(link -> {
               PlanArea area = this.areaService.getById(link.getAreaId());
               SubAreaDTO subAreaDTO = BeanUtil.copy(area, SubAreaDTO.class);
               areaList.add(subAreaDTO);
            });
            subMonomerDTO.setChildren(areaList);
            subMonomerDTOList.add(subMonomerDTO);
         });
         subProjectDTO.setChildren(subMonomerDTOList);
         projectDTOList.add(subProjectDTO);
      });
      return projectDTOList;
   }

   @Override
   public List<SubProjectDTO> listProjectV2() {
      Long currentUserId = UserUtil.getCurrentUserId();
      ProjectManageRoster roster = this.rosterBiz
         .getOne(
            Wrappers.lambdaQuery(ProjectManageRoster.class)
               .eq(ProjectManageRoster::getUserId, currentUserId)
               .eq(ProjectManageRoster::getStatus, EmployeeStatusEnum.ON_JOB.getType())
         );
      if (roster == null) {
         return new ArrayList<>();
      }

      ContractProject project = this.projectService
         .getOne(
            Wrappers.lambdaQuery(ContractProject.class)
               .eq(ContractProject::getId, roster.getProjectId())
               .eq(ContractProject::getStatus, ProjectStatusEnum.PROCESSING.getType())
         );
      if (project == null) {
         return new ArrayList<>();
      }

      SubProjectDTO subProjectDTO = BeanUtil.copy(project, SubProjectDTO.class);
      if (project.getInstallDivideMethod() != null) {
         List<SubMonomerDTO> subMonomerDTOList = new ArrayList<>();
         if (project.getInstallDivideMethod().equals(DivideMethodEnum.LIST.getType())) {
            Map<Long, List<ProjectLaborSubsupplierOrderProductLink>> monomerMap = this.orderProductLinkService
               .list(
                  Wrappers.lambdaQuery(ProjectLaborSubsupplierOrderProductLink.class)
                     .eq(ProjectLaborSubsupplierOrderProductLink::getProjectId, project.getId())
                     .eq(ProjectLaborSubsupplierOrderProductLink::getSupplierId, roster.getSupplierId())
               )
               .stream()
               .collect(Collectors.groupingBy(ProjectLaborSubsupplierOrderProductLink::getMonomerId));
            monomerMap.forEach((monomerId, areaLink) -> {
               PlanMonomer monomer = this.monomerService.getById(monomerId);
               SubMonomerDTO subMonomerDTO = BeanUtil.copy(monomer, SubMonomerDTO.class);
               List<SubAreaDTO> areaList = new ArrayList<>();
               List<Long> areaIds = areaLink.stream().map(ProjectLaborSubsupplierOrderProductLink::getAreaId).distinct().collect(Collectors.toList());
               areaIds.forEach(areaId -> {
                  PlanArea area = this.areaService.getById(areaId);
                  SubAreaDTO subAreaDTO = BeanUtil.copy(area, SubAreaDTO.class);
                  areaList.add(subAreaDTO);
               });
               subMonomerDTO.setChildren(areaList);
               subMonomerDTOList.add(subMonomerDTO);
            });
            subProjectDTO.setChildren(subMonomerDTOList);
         }

         if (project.getInstallDivideMethod().equals(DivideMethodEnum.AREA.getType())) {
            Map<Long, List<ProjectSupplierAreaLink>> monomerMap = this.supplierAreaLinkService
               .list(
                  Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
                     .eq(ProjectSupplierAreaLink::getProjectId, project.getId())
                     .eq(ProjectSupplierAreaLink::getSupplierId, roster.getSupplierId())
                     .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
                     .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
               )
               .stream()
               .collect(Collectors.groupingBy(ProjectSupplierAreaLink::getMonomerId));
            monomerMap.forEach((monomerId, areaLink) -> {
               PlanMonomer monomer = this.monomerService.getById(monomerId);
               SubMonomerDTO subMonomerDTO = BeanUtil.copy(monomer, SubMonomerDTO.class);
               List<SubAreaDTO> areaList = new ArrayList<>();
               areaLink.forEach(link -> {
                  PlanArea area = this.areaService.getById(link.getAreaId());
                  SubAreaDTO subAreaDTO = BeanUtil.copy(area, SubAreaDTO.class);
                  areaList.add(subAreaDTO);
               });
               subMonomerDTO.setChildren(areaList);
               subMonomerDTOList.add(subMonomerDTO);
            });
            subProjectDTO.setChildren(subMonomerDTOList);
         }
      }

      return Arrays.asList(subProjectDTO);
   }

   @Override
   public void buildAccount(Long supplierId) {
      ProjectSupplierAccount account = this.supplierAccountService
         .getOne(Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getSupplierId, supplierId));
      Supplier supplier = this.supplierService.getById(supplierId);
      if (account == null) {
         String supplierUsername = this.getSubSupplierUsername(supplierId);
         int count = this.userService.count(Wrappers.lambdaQuery(User.class).eq(User::getUsername, supplierUsername));
         if (count > 0) {
            supplierUsername = supplierUsername + LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE);
         }

         User user = User.builder()
            .name(supplier.getName())
            .username(supplierUsername)
            .phone(StringUtils.isNotBlank(supplier.getCompanyPhone()) ? supplier.getCompanyPhone() : supplier.getId() + "00000000")
            .isEnabled(true)
            .sex(0)
            .userType(UserTypeEnum.TEMP_USER.getType())
            .password(this.passwordEncoder.encode(java.util.Objects.requireNonNull(System.getenv("LJAPS_INITIAL_USER_PASSWORD"), "LJAPS_INITIAL_USER_PASSWORD is required")))
            .build();
         this.userService.save(user);
         account = ProjectSupplierAccount.builder()
            .supplierId(supplier.getId())
            .supplierName(supplier.getName())
            .boolStatus(true)
            .username(user.getUsername())
            .userId(user.getId())
            .build();
         this.supplierAccountService.save(account);
      } else {
         account.setBoolStatus(true);
         this.supplierAccountService.updateById(account);
         User user = this.userService.getById(account.getUserId());
         user.setIsEnabled(true);
         this.userService.updateById(user);
      }
   }

   private String getSubSupplierUsername(Long supplierId) {
      return "FBS" + this.getUsernameSuffixNum(supplierId);
   }

   private String getUsernameSuffixNum(Long supplierId) {
      int num = 4;
      if (supplierId.toString().length() > num) {
         return supplierId.toString().substring(supplierId.toString().length() - num);
      }

      int quality = num - supplierId.toString().length();
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < quality; i++) {
         builder.append(0);
      }

      return builder.append(supplierId).toString();
   }

   @Override
   public void shutDownAccount(Long supplierId) {
      int count = this.supplierAreaLinkService
         .count(
            Wrappers.lambdaQuery(ProjectSupplierAreaLink.class)
               .eq(ProjectSupplierAreaLink::getSupplierId, supplierId)
               .eq(ProjectSupplierAreaLink::getBoolRelationStatus, true)
               .eq(ProjectSupplierAreaLink::getBoolSettlementStatus, false)
         );
      if (count == 0) {
         ProjectSupplierAccount account = this.supplierAccountService
            .getOne(Wrappers.lambdaQuery(ProjectSupplierAccount.class).eq(ProjectSupplierAccount::getSupplierId, supplierId));
         if (account != null) {
            account.setBoolStatus(false);
            this.supplierAccountService.updateById(account);
            User user = this.userService.getById(account.getUserId());
            if (user != null && user.getIsEnabled()) {
               user.setIsEnabled(false);
               this.userService.updateById(user);
            }
         }
      }
   }
}
