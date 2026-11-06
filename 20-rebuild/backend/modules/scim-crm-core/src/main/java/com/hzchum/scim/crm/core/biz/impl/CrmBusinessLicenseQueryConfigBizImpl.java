package com.hzchum.scim.crm.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseQueryConfigBiz;
import com.hzchum.scim.crm.core.api.biz.CrmBusinessLicenseQueryLogBiz;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryLog;
import com.hzchum.scim.crm.core.api.service.CrmBusinessLicenseQueryConfigService;
import com.hzchum.scim.crm.core.mapper.CrmBusinessLicenseQueryConfigMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CrmBusinessLicenseQueryConfigBizImpl
   extends IBizImpl<CrmBusinessLicenseQueryConfigService, CrmBusinessLicenseQueryConfigMapper, CrmBusinessLicenseQueryConfig>
   implements CrmBusinessLicenseQueryConfigBiz {
   @Resource
   private CrmBusinessLicenseQueryLogBiz crmBusinessLicenseQueryLogBiz;

   @Override
   public Boolean updateBusinessLicenseQueryConfig(Integer times) {
      CrmBusinessLicenseQueryConfig crmBusinessLicenseQueryConfig = this.baseService.getOne(Wrappers.lambdaQuery(CrmBusinessLicenseQueryConfig.class));
      if (crmBusinessLicenseQueryConfig == null) {
         this.baseService.save(CrmBusinessLicenseQueryConfig.builder().times(times).build());
      } else {
         crmBusinessLicenseQueryConfig.setTimes(times);
         this.baseService.updateById(crmBusinessLicenseQueryConfig);
      }

      return Boolean.TRUE;
   }

   @Override
   public Integer getBusinessLicenseQueryConfig() {
      CrmBusinessLicenseQueryConfig crmBusinessLicenseQueryConfig = this.baseService.getOne(Wrappers.lambdaQuery(CrmBusinessLicenseQueryConfig.class));
      return crmBusinessLicenseQueryConfig != null ? crmBusinessLicenseQueryConfig.getTimes() : 0;
   }

   @Override
   public Boolean whetherItIsCappedOrNot() {
      CrmBusinessLicenseQueryConfig crmBusinessLicenseQueryConfig = this.baseService.getOne(Wrappers.lambdaQuery(CrmBusinessLicenseQueryConfig.class));
      Preconditions.checkArgument(crmBusinessLicenseQueryConfig != null, "工商企业查询次数暂未配置，请先配置");
      Integer crmBusinessLicenseQueryConfigTimes = crmBusinessLicenseQueryConfig.getTimes();
      List<CrmBusinessLicenseQueryLog> crmBusinessLicenseQueryLogs = this.crmBusinessLicenseQueryLogBiz
         .list(Wrappers.lambdaQuery(CrmBusinessLicenseQueryLog.class).apply("date_format(create_time,'%Y-%m-%d') = date_format(now(),'%Y-%m-%d')"));
      return crmBusinessLicenseQueryConfigTimes > crmBusinessLicenseQueryLogs.size();
   }
}
