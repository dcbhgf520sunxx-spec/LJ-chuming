package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigCoatingBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigCoating;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigCoatingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigCoatingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigCoatingService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigCoatingMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigCoatingBizImpl
   extends IBizImpl<MesQuotaConfigCoatingService, MesQuotaConfigCoatingMapper, MesQuotaConfigCoating>
   implements MesQuotaConfigCoatingBiz {
   @Override
   public PageVO<MesQuotaConfigCoatingDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesQuotaConfigCoatingDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesQuotaConfigCoatingDTO> listInfo(MesQuotaConfigConditionQuery query) {
      return this.baseService.listInfo(query);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigCoatingParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigCoatingParam param) {
      return this.baseService.edit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      return this.baseService.deleteById(id);
   }
}
