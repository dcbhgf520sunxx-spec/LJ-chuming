package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductLinkListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductLinkUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductLinkVO;
import java.util.List;

public interface TechCappCraftCardProductLinkBiz extends IBiz<TechCappCraftCardProductLink> {
   PageVO<CappCraftCardProductLinkVO> list(CappCraftCardProductLinkListDTO cappCraftCardProductLinkListDTO);

   Boolean update(List<CappCraftCardProductLinkUpdateDTO> updateDTO);
}
