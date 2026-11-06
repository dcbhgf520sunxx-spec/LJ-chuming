package com.hzchum.scim.mes.building.core.biz.impl.wage_quota;

import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota.MesTempWorkQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesTempWorkQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota.MesTempWorkQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota.MesTempWorkQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.service.wage_quota.MesTempWorkQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota.MesTempWorkQuotaConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesTempWorkQuotaConfigBizImpl
   extends IBizImpl<MesTempWorkQuotaConfigService, MesTempWorkQuotaConfigMapper, MesTempWorkQuotaConfig>
   implements MesTempWorkQuotaConfigBiz {
   @Override
   public List<MesTempWorkQuotaConfigDTO> listInfo() {
      return this.baseService.listInfo();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesTempWorkQuotaConfigParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesTempWorkQuotaConfigParam param) {
      return this.baseService.edit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editStatus(Long id, Boolean status) {
      return this.baseService.editStatus(id, status);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      return this.baseService.deleteById(id);
   }
}
