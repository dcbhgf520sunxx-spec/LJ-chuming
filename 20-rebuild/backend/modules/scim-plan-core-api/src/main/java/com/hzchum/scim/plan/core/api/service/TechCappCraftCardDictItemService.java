package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardDictItem;
import java.util.Map;

public interface TechCappCraftCardDictItemService extends IService<TechCappCraftCardDictItem> {
   Map<String, TechCappCraftCardDictItem> getMapByDictTypeAndDictValue(String dictType);
}
