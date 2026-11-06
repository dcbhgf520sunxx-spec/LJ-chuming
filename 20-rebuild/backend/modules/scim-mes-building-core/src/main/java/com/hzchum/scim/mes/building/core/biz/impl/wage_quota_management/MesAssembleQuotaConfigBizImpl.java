package com.hzchum.scim.mes.building.core.biz.impl.wage_quota_management;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota_management.MesAssembleQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesAssembleQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesAssembleQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesAssembleQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesAssembleQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesAssembleQuotaConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesAssembleQuotaConfigBizImpl
   extends IBizImpl<MesAssembleQuotaConfigService, MesAssembleQuotaConfigMapper, MesAssembleQuotaConfig>
   implements MesAssembleQuotaConfigBiz {
   @Override
   public PageVO<MesAssembleQuotaConfigDTO> pageInfo(MesQuotaConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesAssembleQuotaConfigDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesAssembleQuotaConfigParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesAssembleQuotaConfigParam param) {
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
