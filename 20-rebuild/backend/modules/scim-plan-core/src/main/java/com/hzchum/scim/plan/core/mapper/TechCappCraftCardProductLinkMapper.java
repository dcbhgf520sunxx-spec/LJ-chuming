package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductLinkListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductLinkVO;
import java.util.List;

public interface TechCappCraftCardProductLinkMapper extends BaseMapper<TechCappCraftCardProductLink> {
   List<CappCraftCardProductLinkVO> list(CappCraftCardProductLinkListDTO dto);
}
