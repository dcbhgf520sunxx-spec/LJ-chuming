package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(99)
@Component
public class ProjectInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProjectInitRunner.class);
   private final ContractProjectService contractProjectService;
   private final BranchCompanyService branchCompanyService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      log.info("新增项目/分支机构单位属性开始............................................");
      List<BranchCompany> branchCompanyList = this.branchCompanyService.list(new LambdaQueryWrapper<>());

      for (BranchCompany branchCompany : branchCompanyList) {
         if (branchCompany.getLevel() == null) {
            branchCompany.setLevel(BranchCompanyLevelEnum.SECONDARY_UNIT.getType());
            this.branchCompanyService.updateById(branchCompany);
         }
      }

      Map<Long, BranchCompany> branchCompanyMap = branchCompanyList.stream().collect(Collectors.toMap(BranchCompany::getId, Function.identity()));
      List<ContractProject> projectList = this.contractProjectService
         .list((Wrapper<ContractProject>)new LambdaQueryWrapper<ContractProject>().isNull(ContractProject::getLevel));
      if (CollectionUtils.isNotEmpty(projectList)) {
         for (ContractProject project : projectList) {
            BranchCompany branchCompany = branchCompanyMap.get(project.getContractSignBodyId());
            if (branchCompany != null) {
               project.setLevel(branchCompany.getLevel());
               this.contractProjectService.updateById(project);
            }
         }
      }

      log.info("新增项目/分支机构单位属性结束............................................");
      this.contractProjectService
         .update(
            Wrappers.lambdaUpdate(ContractProject.class)
               .isNull(ContractProject::getProjectAttribute)
               .set(ContractProject::getProjectAttribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
         );
   }

   public ProjectInitRunner(final ContractProjectService contractProjectService, final BranchCompanyService branchCompanyService) {
      this.contractProjectService = contractProjectService;
      this.branchCompanyService = branchCompanyService;
   }
}
