package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.BranchAttributeEnum;
import com.hzchum.scim.common.core.api.enums.BranchCompanyLevelEnum;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.contract.core.api.utils.ProjectFinanceUtils;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.Menu;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.MenuService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MenuRunner implements CommandLineRunner {
   @Autowired
   private MenuService menuService;
   @Autowired
   private ProjectFinanceUtils projectFinanceUtils;
   @Autowired
   private BranchCompanyService branchCompanyService;

   @Override
   public void run(String... args) throws Exception {
      Boolean boolTwoLevelUnit = this.projectFinanceUtils.getBoolTwoLevelUnit();
      if (boolTwoLevelUnit) {
         List<BranchCompany> branchCompanyList = this.branchCompanyService
            .list(Wrappers.lambdaQuery(BranchCompany.class).eq(BranchCompany::getEnabled, EnableEnum.ENABLE.getType()));
         branchCompanyList = branchCompanyList.stream()
            .filter(
               bc -> bc.getLevel().equals(BranchCompanyLevelEnum.PRIMARY_UNIT.getType())
                  ? bc.getBranchAttributeEnum().equals(BranchAttributeEnum.INSTALLATION.getType())
                  : bc.getBranchAttributeEnum().equals(BranchAttributeEnum.MANUFACTURING.getType())
            )
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(branchCompanyList)) {
            Map<Integer, BranchCompany> branchCompanyMap = branchCompanyList.stream().collect(Collectors.toMap(BranchCompany::getLevel, Function.identity()));
            List<Menu> list = this.menuService.list();
            list.forEach(
               me -> {
                  if ("一级单位".equals(me.getName()) && ObjectUtils.isNotEmpty(branchCompanyMap.get(1))) {
                     me.setName(
                        ObjectUtils.isNotEmpty(branchCompanyMap.get(1).getShortName())
                           ? branchCompanyMap.get(1).getShortName()
                           : branchCompanyMap.get(1).getName()
                     );
                  }

                  if ("二级单位".equals(me.getName()) && ObjectUtils.isNotEmpty(branchCompanyMap.get(2))) {
                     me.setName(
                        ObjectUtils.isNotEmpty(branchCompanyMap.get(2).getShortName())
                           ? branchCompanyMap.get(2).getShortName()
                           : branchCompanyMap.get(2).getName()
                     );
                  }
               }
            );
            this.menuService.updateBatchById(list);
         }
      }
   }
}
