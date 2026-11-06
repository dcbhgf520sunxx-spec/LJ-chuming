package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechPaintTechnology;
import com.hzchum.scim.plan.core.api.pojo.dto.craft.TechPaintTechnologyProjectGroupDTO;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.craft.TechPaintTechnologyQueryParam;
import java.util.List;

public interface TechPaintTechnologyService extends IService<TechPaintTechnology> {
   List<TechPaintTechnologyProjectGroupDTO> listPaintTechnologyGroupByProject(TechPaintTechnologyQueryParam param);
}
