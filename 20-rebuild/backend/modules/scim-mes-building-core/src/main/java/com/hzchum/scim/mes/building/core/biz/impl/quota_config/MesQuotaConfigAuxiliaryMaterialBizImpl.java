package com.hzchum.scim.mes.building.core.biz.impl.quota_config;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.mes.building.core.api.biz.quota_config.MesQuotaConfigAuxiliaryMaterialBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAuxiliaryMaterial;
import com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config.MesQuotaConfigAuxiliaryMaterialDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigAuxiliaryMaterialParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config.MesQuotaConfigConditionQuery;
import com.hzchum.scim.mes.building.core.api.service.quota_config.MesQuotaConfigAuxiliaryMaterialService;
import com.hzchum.scim.mes.building.core.mapper.quota_config.MesQuotaConfigAuxiliaryMaterialMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechStandardPart;
import com.hzchum.scim.plan.core.api.service.TechStandardPartService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesQuotaConfigAuxiliaryMaterialBizImpl
   extends IBizImpl<MesQuotaConfigAuxiliaryMaterialService, MesQuotaConfigAuxiliaryMaterialMapper, MesQuotaConfigAuxiliaryMaterial>
   implements MesQuotaConfigAuxiliaryMaterialBiz {
   @Autowired
   private TechStandardPartService standardPartService;

   @Override
   public PageVO<MesQuotaConfigAuxiliaryMaterialDTO> pageInfo(MesQuotaConfigConditionQuery query, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<MesQuotaConfigAuxiliaryMaterialDTO> list = this.baseService.listInfo(query);
      return new PageVO<>(page, list);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(MesQuotaConfigAuxiliaryMaterialParam param) {
      return this.baseService.add(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean edit(MesQuotaConfigAuxiliaryMaterialParam param) {
      return this.baseService.edit(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      return this.baseService.deleteById(id);
   }

   @Override
   public List<String> typeSelectList() {
      return this.standardPartService.list().stream().map(TechStandardPart::getName).distinct().collect(Collectors.toList());
   }
}
