package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardDictItem;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardDictItemVO;
import java.util.List;
import java.util.Map;

public interface TechCappCraftCardDictItemBiz extends IBiz<TechCappCraftCardDictItem> {
   Boolean save(CappCraftCardDictItemSaveDTO saveDTO);

   Boolean update(CappCraftCardDictItemUpdateDTO updateDTO);

   Boolean updateEnabledFlag(Long id, Boolean enabledFlag);

   Boolean delete(Long id);

   List<CappCraftCardDictItemVO> getList(CappCraftCardDictItemListDTO listDTO);

   Map<String, List<CappCraftCardDictItemVO>> getMapByDictType();

   void autoAddDict(String dictType, String dictValue);
}
