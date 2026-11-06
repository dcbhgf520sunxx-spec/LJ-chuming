package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnology;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyQueryParam;
import java.util.List;

public interface TechPaintTechnologyMapper extends BaseMapper<TechPaintTechnology> {
   List<TechPaintTechnologyProjectGroupDTO> selectListPaintTechnologyGroupByProject(TechPaintTechnologyQueryParam param);
}
