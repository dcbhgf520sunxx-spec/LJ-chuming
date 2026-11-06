package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnology;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyQueryParam;
import com.hzchum.scim.plan.core.api.service.TechPaintTechnologyService;
import com.hzchum.scim.plan.core.mapper.TechPaintTechnologyMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TechPaintTechnologyServiceImpl extends ServiceImpl<TechPaintTechnologyMapper, TechPaintTechnology> implements TechPaintTechnologyService {
   @Override
   public List<TechPaintTechnologyProjectGroupDTO> listPaintTechnologyGroupByProject(TechPaintTechnologyQueryParam param) {
      return this.baseMapper.selectListPaintTechnologyGroupByProject(param);
   }
}
