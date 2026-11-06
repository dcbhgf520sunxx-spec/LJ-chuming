package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardStorehouse;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardStorehouseListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardStorehouseVO;
import java.util.List;

public interface TechCappCraftCardStorehouseMapper extends BaseMapper<TechCappCraftCardStorehouse> {
   List<CappCraftCardStorehouseVO> list(CappCraftCardStorehouseListDTO dto);

   List<TechCappCraftCardStorehouse> listAll();
}
