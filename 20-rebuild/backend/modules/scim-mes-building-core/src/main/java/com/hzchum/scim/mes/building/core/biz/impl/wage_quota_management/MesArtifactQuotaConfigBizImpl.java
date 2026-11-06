package com.hzchum.scim.mes.building.core.biz.impl.wage_quota_management;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.wage_quota_management.MesArtifactQuotaConfigBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota_management.MesArtifactQuotaConfig;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota_management.MesArtifactQuotaConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesArtifactQuotaConfigParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management.MesQuotaConfigQuery;
import com.hzchum.scim.mes.building.core.api.service.wage_quota_management.MesArtifactQuotaConfigService;
import com.hzchum.scim.mes.building.core.mapper.wage_quota_management.MesArtifactQuotaConfigMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesArtifactQuotaConfigBizImpl
   extends IBizImpl<MesArtifactQuotaConfigService, MesArtifactQuotaConfigMapper, MesArtifactQuotaConfig>
   implements MesArtifactQuotaConfigBiz {
   @Override
   public PageVO<MesArtifactQuotaConfigDTO> pageInfo(MesQuotaConfigQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesArtifactQuotaConfigDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesArtifactQuotaConfigParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesArtifactQuotaConfigParam param) {
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
