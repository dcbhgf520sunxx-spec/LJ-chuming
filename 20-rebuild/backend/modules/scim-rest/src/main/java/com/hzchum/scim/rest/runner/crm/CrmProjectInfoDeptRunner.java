package com.hzchum.scim.rest.runner.crm;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Order(99)
@Component
public class CrmProjectInfoDeptRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectInfoDeptRunner.class);
   @Resource
   private CrmProjectInformationWarehousingService crmProjectInformationWarehousingService;
   @Resource
   private UserService userService;

   @Transactional
   @Override
   public void run(String... args) throws Exception {
      List<CrmProjectInformationWarehousing> list = this.crmProjectInformationWarehousingService
         .list(Wrappers.lambdaQuery(CrmProjectInformationWarehousing.class).isNull(CrmProjectInformationWarehousing::getInformationOperatorDeptId));
      List<CrmProjectInformationWarehousing> updateList = new ArrayList<>();
      Map<Long, User> map = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      list.forEach(item -> {
         User aLong = map.get(item.getInformationOperatorUserId());
         if (aLong.getDepartmentId() != null) {
            item.setInformationOperatorDeptId(aLong.getDepartmentId());
         }

         updateList.add(item);
      });
      if (CollectionUtils.isNotEmpty(updateList)) {
         this.crmProjectInformationWarehousingService.updateBatchById(updateList);
      }
   }

   public CrmProjectInfoDeptRunner(final CrmProjectInformationWarehousingService crmProjectInformationWarehousingService, final UserService userService) {
      this.crmProjectInformationWarehousingService = crmProjectInformationWarehousingService;
      this.userService = userService;
   }
}
