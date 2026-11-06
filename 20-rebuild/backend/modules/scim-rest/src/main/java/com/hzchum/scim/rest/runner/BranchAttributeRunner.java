package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.BranchAttributeEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BranchAttributeRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(BranchAttributeRunner.class);
   private final BranchCompanyService branchCompanyService;
   private final MesBuildingFactoryService factoryService;
   private final ProjectFinanceUtils projectFinanceUtils;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<BranchCompany> branchCompanyList = this.branchCompanyService.list(Wrappers.lambdaQuery(BranchCompany.builder().branchAttributeEnum(0).build()));
      if (CollectionUtils.isNotEmpty(branchCompanyList)) {
         log.info("分支机构属性初始化开始----------------------------------");
         Map<Long, List<MesBuildingFactory>> branchIdFactoryListMap = this.factoryService
            .list()
            .stream()
            .collect(Collectors.groupingBy(MesBuildingFactory::getBranchCompanyId));
         branchCompanyList.forEach(bc -> {
            if (bc.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())) {
               bc.setBranchAttributeEnum(BranchAttributeEnum.INSTALLATION.getType());
            } else if (branchIdFactoryListMap.containsKey(bc.getId())) {
               bc.setBranchAttributeEnum(BranchAttributeEnum.MANUFACTURING.getType());
            } else if (this.projectFinanceUtils.getBoolTwoLevelUnit()) {
               bc.setBranchAttributeEnum(BranchAttributeEnum.INSTALLATION.getType());
            } else {
               bc.setBranchAttributeEnum(BranchAttributeEnum.OTHER.getType());
            }
         });
         this.branchCompanyService.updateBatchById(branchCompanyList);
         log.info("分支机构属性初始化结束----------------------------------");
      }
   }

   public BranchAttributeRunner(
      final BranchCompanyService branchCompanyService, final MesBuildingFactoryService factoryService, final ProjectFinanceUtils projectFinanceUtils
   ) {
      this.branchCompanyService = branchCompanyService;
      this.factoryService = factoryService;
      this.projectFinanceUtils = projectFinanceUtils;
   }
}
