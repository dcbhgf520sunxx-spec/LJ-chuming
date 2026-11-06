package com.hzchum.scim.rest.runner.contract;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

@Order(500)
public class ProjectBranchCompanyLinkRunner implements CommandLineRunner {
   private final ContractProjectService projectService;
   private final ProjectBranchCompanyLinkService projectBranchCompanyLinkService;
   private final BranchCompanyService branchCompanyService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      int count = this.projectBranchCompanyLinkService.count();
      if (count == 0) {
         List<BranchCompany> branchCompanyList = this.branchCompanyService
            .list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getEnabled, EnableEnum.ENABLE.getType()));
         if (ObjectUtils.isEmpty(branchCompanyList)) {
            return;
         }

         Map<Integer, Long> levelCount = branchCompanyList.stream()
            .filter(a -> ObjectUtils.isNotEmpty(a.getLevel()))
            .collect(Collectors.groupingBy(BranchCompany::getLevel, Collectors.counting()));
         if (ObjectUtils.isEmpty(levelCount.get(1)) || levelCount.get(1) != 1L) {
            return;
         }

         if (ObjectUtils.isEmpty(levelCount.get(2)) || levelCount.get(2) != 1L) {
            return;
         }

         Map<Integer, Long> branchCompanyMap = branchCompanyList.stream().collect(Collectors.toMap(BranchCompany::getLevel, BranchCompany::getId));
         List<ContractProject> projectList = this.projectService.list();
         List<ProjectBranchCompanyLink> projectBranchCompanyLinkList = new ArrayList<>();
         projectList.forEach(
            project -> {
               if (project.getLevel() == 1) {
                  projectBranchCompanyLinkList.add(
                     ProjectBranchCompanyLink.builder().projectId(project.getId()).branchCompanyId(branchCompanyMap.get(1)).branchCompanyLevel(1).build()
                  );
               }

               if (project.getLevel() == 2) {
                  projectBranchCompanyLinkList.add(
                     ProjectBranchCompanyLink.builder().projectId(project.getId()).branchCompanyId(branchCompanyMap.get(2)).branchCompanyLevel(2).build()
                  );
               }

               if (project.getLevel() == 3) {
                  projectBranchCompanyLinkList.add(
                     ProjectBranchCompanyLink.builder().projectId(project.getId()).branchCompanyId(branchCompanyMap.get(1)).branchCompanyLevel(1).build()
                  );
                  projectBranchCompanyLinkList.add(
                     ProjectBranchCompanyLink.builder().projectId(project.getId()).branchCompanyId(branchCompanyMap.get(2)).branchCompanyLevel(2).build()
                  );
               }
            }
         );
         this.projectBranchCompanyLinkService.saveBatch(projectBranchCompanyLinkList);
      }
   }

   public ProjectBranchCompanyLinkRunner(
      final ContractProjectService projectService,
      final ProjectBranchCompanyLinkService projectBranchCompanyLinkService,
      final BranchCompanyService branchCompanyService
   ) {
      this.projectService = projectService;
      this.projectBranchCompanyLinkService = projectBranchCompanyLinkService;
      this.branchCompanyService = branchCompanyService;
   }
}
