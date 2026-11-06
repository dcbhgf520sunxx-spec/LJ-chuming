package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigMachinePartBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePart;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigMachinePartDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigMachinePartParam;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigMachinePartService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigMachinePartMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigMachinePartBizImpl
   extends IBizImpl<MesQuotaConfigMachinePartService, MesQuotaConfigMachinePartMapper, MesQuotaConfigMachinePart>
   implements MesQuotaConfigMachinePartBiz {
   @Override
   public PageVO<MesQuotaConfigMachinePartDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page<MesQuotaConfigMachinePartDTO> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesQuotaConfigMachinePartDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesQuotaConfigMachinePartDTO> listInfo(MesQuotaConfigConditionQuery query) {
      return this.baseService.listInfo(query);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigMachinePartParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchAdd(List<MesQuotaConfigMachinePartParam> param) {
      param.forEach(this.baseService::add);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigMachinePartParam param) {
      return this.baseService.edit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      return this.baseService.delete(id);
   }
}
