package com.hzchum.scim.mes.building.core.biz.impl.wage_quota_management;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota_management.MesMachinePartQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesMachinePartQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesMachinePartQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesMachinePartQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesMachinePartQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesMachinePartQuotaConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesMachinePartQuotaConfigBizImpl
   extends IBizImpl<MesMachinePartQuotaConfigService, MesMachinePartQuotaConfigMapper, MesMachinePartQuotaConfig>
   implements MesMachinePartQuotaConfigBiz {
   @Override
   public PageVO<MesMachinePartQuotaConfigDTO> pageInfo(MesQuotaConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      return this.baseService.pageInfo(query, pageNumber, pageSize, sort);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesMachinePartQuotaConfigParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesMachinePartQuotaConfigParam param) {
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

   @Override
   public List<NameInfo> machinePartProcessSelect() {
      return this.baseService.machinePartProcessSelect();
   }
}
