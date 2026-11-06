package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardDictItem;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardDictItemService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardDictItemMapper;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TechCappCraftCardDictItemServiceImpl
   extends ServiceImpl<TechCappCraftCardDictItemMapper, TechCappCraftCardDictItem>
   implements TechCappCraftCardDictItemService {
   private List<TechCappCraftCardDictItem> getListByDictType(String dictType) {
      return this.baseMapper.selectListByDictType(dictType);
   }

   @Override
   public Map<String, TechCappCraftCardDictItem> getMapByDictTypeAndDictValue(String dictType) {
      List<TechCappCraftCardDictItem> itemList = this.getListByDictType(dictType);
      return itemList.stream().collect(Collectors.toMap(TechCappCraftCardDictItem::getDictValue, Function.identity()));
   }
}
