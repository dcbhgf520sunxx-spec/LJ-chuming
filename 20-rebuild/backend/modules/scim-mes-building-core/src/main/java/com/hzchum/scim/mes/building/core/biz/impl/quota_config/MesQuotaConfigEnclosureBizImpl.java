package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigEnclosureBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigEnclosure;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigEnclosureDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigEnclosureParam;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigEnclosureService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigEnclosureMapper;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigEnclosureBizImpl
   extends IBizImpl<MesQuotaConfigEnclosureService, MesQuotaConfigEnclosureMapper, MesQuotaConfigEnclosure>
   implements MesQuotaConfigEnclosureBiz {
   @Autowired
   private SysDictionaryService dictionaryService;

   @Override
   public PageVO<MesQuotaConfigEnclosureDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesQuotaConfigEnclosureDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Override
   public List<MesQuotaConfigEnclosureDTO> listInfo(MesQuotaConfigConditionQuery query) {
      return this.baseService.listInfo(query);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigEnclosureParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigEnclosureParam param) {
      return this.baseService.edit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      return this.baseService.deleteById(id);
   }
}
