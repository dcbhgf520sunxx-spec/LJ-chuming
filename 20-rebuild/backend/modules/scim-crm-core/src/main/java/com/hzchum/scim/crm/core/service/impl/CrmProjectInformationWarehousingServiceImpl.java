package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.crm.core.api.pojo._do.CrmProjectInformationWarehousing;
import com.hzchum.scim.crm.core.api.pojo._do.CrmWinningContractWarehousing;
import com.hzchum.scim.crm.core.api.service.CrmProjectInformationWarehousingService;
import com.hzchum.scim.crm.core.api.service.CrmWinningContractWarehousingService;
import com.hzchum.scim.crm.core.mapper.CrmProjectInformationWarehousingMapper;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CrmProjectInformationWarehousingServiceImpl
   extends ServiceImpl<CrmProjectInformationWarehousingMapper, CrmProjectInformationWarehousing>
   implements CrmProjectInformationWarehousingService {
   @Resource
   private CrmWinningContractWarehousingService crmWinningContractWarehousingService;
   @Resource
   private UserService userService;

   @Override
   public void updateInformationOperatorDeptId() {
      Set<Long> userIdSet = new HashSet<>();
      List<CrmProjectInformationWarehousing> crmProjectInformationWarehousings = this.list();
      List<CrmWinningContractWarehousing> crmWinningContractWarehousings = this.crmWinningContractWarehousingService.list();
      userIdSet.addAll(
         crmProjectInformationWarehousings.stream().map(CrmProjectInformationWarehousing::getInformationOperatorUserId).collect(Collectors.toList())
      );
      userIdSet.addAll(crmWinningContractWarehousings.stream().map(CrmWinningContractWarehousing::getInformantUserId).collect(Collectors.toList()));
      if (CollectionUtils.isNotEmpty(userIdSet)) {
         List<CrmProjectInformationWarehousing> updateProjectList = new ArrayList<>();
         List<CrmWinningContractWarehousing> updateWinningList = new ArrayList<>();
         Map<Long, User> userMap = this.userService
            .list(Wrappers.lambdaQuery(User.class).in(User::getId, userIdSet))
            .stream()
            .collect(Collectors.toMap(User::getId, Function.identity()));
         crmProjectInformationWarehousings.forEach(crmProjectInformationWarehousing -> {
            User user = userMap.get(crmProjectInformationWarehousing.getInformationOperatorUserId());
            boolean flag = false;
            if (user != null && !user.getDepartmentId().equals(crmProjectInformationWarehousing.getInformationOperatorDeptId())) {
               crmProjectInformationWarehousing.setInformationOperatorDeptId(user.getDepartmentId());
               flag = true;
            }

            User user1 = userMap.get(crmProjectInformationWarehousing.getInformantUserId());
            if (user1 != null && !user1.getDepartmentId().equals(crmProjectInformationWarehousing.getInformantUserId())) {
               crmProjectInformationWarehousing.setDepartmentId(user1.getDepartmentId());
               flag = true;
            }

            if (flag) {
               updateProjectList.add(crmProjectInformationWarehousing);
            }
         });
         crmWinningContractWarehousings.forEach(crmWinningContractWarehousing -> {
            User user = userMap.get(crmWinningContractWarehousing.getInformantUserId());
            if (user != null && !user.getDepartmentId().equals(crmWinningContractWarehousing.getInformantUserId())) {
               crmWinningContractWarehousing.setDepartmentId(user.getDepartmentId());
               updateWinningList.add(crmWinningContractWarehousing);
            }
         });
         if (CollectionUtils.isNotEmpty(updateProjectList)) {
            this.updateBatchById(updateProjectList);
         }

         if (CollectionUtils.isNotEmpty(updateWinningList)) {
            this.crmWinningContractWarehousingService.updateBatchById(updateWinningList);
         }
      }
   }
}
