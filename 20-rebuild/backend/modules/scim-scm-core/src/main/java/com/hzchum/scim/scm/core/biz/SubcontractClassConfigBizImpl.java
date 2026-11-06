package com.hzchum.scim.scm.core.biz;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.scm.core.api.biz.SubcontractClassConfigBiz;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractClassConfig;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractClassConfigDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractClassConfigDTOParam;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcontractClassConfigBizImpl implements SubcontractClassConfigBiz {
   private static final Logger log = LoggerFactory.getLogger(SubcontractClassConfigBizImpl.class);
   @Resource
   private SubcontractClassConfigService subcontractClassConfigService;
   @Resource
   private SubcontractOrderService subcontractOrderService;

   @Override
   public List<SubcontractClassConfigDTO> list(String name) {
      List<SubcontractClassConfig> classConfigList = this.subcontractClassConfigService
         .list(
            Wrappers.lambdaQuery(SubcontractClassConfig.builder().build())
               .like(name != null, SubcontractClassConfig::getName, name)
               .orderByAsc(SubcontractClassConfig::getId)
         );
      return classConfigList.stream().map(s -> BeanUtil.copy(s, SubcontractClassConfigDTO.class)).collect(Collectors.toList());
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean save(List<SubcontractClassConfigDTOParam> params) {
      params.forEach(
         param -> {
            int count = this.subcontractClassConfigService
               .count(Wrappers.lambdaQuery(SubcontractClassConfig.class).eq(SubcontractClassConfig::getName, param.getName()));
            Preconditions.checkArgument(count == 0, "新增失败,名称(" + param.getName() + ")已存在");
            SubcontractClassConfig classConfig = SubcontractClassConfig.builder().name(param.getName()).build();
            this.subcontractClassConfigService.save(classConfig);
         }
      );
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean update(SubcontractClassConfigDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "id不能为空");
      SubcontractClassConfig classConfig = this.subcontractClassConfigService.getById(param.getId());
      Preconditions.checkArgument(classConfig != null, "修改失败,数据不存在");
      Preconditions.checkArgument(!classConfig.getName().equals("劳务分包"), "劳务分包不可修改");
      if (!param.getName().equals(classConfig.getName())) {
         int count = this.subcontractClassConfigService
            .count(Wrappers.lambdaQuery(SubcontractClassConfig.class).eq(SubcontractClassConfig::getName, param.getName()));
         Preconditions.checkArgument(count == 0, "修改失败,名称(" + param.getName() + ")已存在");
      }

      BeanUtil.copy(param, classConfig);
      this.subcontractClassConfigService.updateById(classConfig);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean delete(List<Long> ids) {
      ids.forEach(id -> {
         SubcontractClassConfig classConfig = this.subcontractClassConfigService.getById(id);
         Preconditions.checkArgument(classConfig != null, "删除失败,数据不存在");
         Preconditions.checkArgument(!classConfig.getName().equals("劳务分包"), "劳务分包不可删除");
         int count = this.subcontractOrderService.count(Wrappers.lambdaQuery(SubcontractOrder.builder().subcontractClassId(id).build()));
         Preconditions.checkArgument(count == 0, "删除失败,分包类别正在使用");
         this.subcontractClassConfigService.removeById(id);
      });
      return null;
   }
}
