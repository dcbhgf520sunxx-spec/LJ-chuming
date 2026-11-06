package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouseCraftParameterPassLink;
import java.util.List;

public interface TechCappCraftCardStorehouseCraftParameterPassLinkMapper extends BaseMapper<TechCappCraftCardStorehouseCraftParameterPassLink> {
   List<TechCappCraftCardStorehouseCraftParameterPassLink> getAllList();
}
