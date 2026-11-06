package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigArtifactBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifact;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigArtifactDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigArtifactParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigArtifactService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigArtifactMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigArtifactBizImpl
   extends IBizImpl<MesQuotaConfigArtifactService, MesQuotaConfigArtifactMapper, MesQuotaConfigArtifact>
   implements MesQuotaConfigArtifactBiz {
   @Override
   public PageVO<MesQuotaConfigArtifactDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page<MesQuotaConfigArtifactDTO> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesQuotaConfigArtifactDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesQuotaConfigArtifactDTO> listInfo(MesQuotaConfigConditionQuery query) {
      return this.baseService.listInfo(query);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigArtifactParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean batchAdd(List<MesQuotaConfigArtifactParam> param) {
      param.forEach(this.baseService::add);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigArtifactParam param) {
      return this.baseService.edit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      return this.baseService.delete(id);
   }
}
