package com.hzchum.scim.plan.core.mapper;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardDictItem;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemListDTO;
import java.util.List;

public interface TechCappCraftCardDictItemMapper extends BaseMapper<TechCappCraftCardDictItem> {
   default TechCappCraftCardDictItem selectOneByDictTypeAndDictValue(String dictType, String dictValue) {
      LambdaQueryWrapper<TechCappCraftCardDictItem> wrapper = (LambdaQueryWrapper<TechCappCraftCardDictItem>)(new LambdaQueryWrapper<TechCappCraftCardDictItem>()
            .eq(TechCappCraftCardDictItem::getDictType, dictType))
         .eq(TechCappCraftCardDictItem::getDictValue, dictValue);
      return this.selectOne(wrapper);
   }

   default List<TechCappCraftCardDictItem> selectListByDictType(String dictType) {
      LambdaQueryWrapper<TechCappCraftCardDictItem> wrapper = (LambdaQueryWrapper<TechCappCraftCardDictItem>)new LambdaQueryWrapper<TechCappCraftCardDictItem>()
         .eq(TechCappCraftCardDictItem::getDictType, dictType);
      return this.selectList(wrapper);
   }

   default List<TechCappCraftCardDictItem> selectList(CappCraftCardDictItemListDTO listDTO) {
      LambdaQueryWrapper<TechCappCraftCardDictItem> wrapper = (LambdaQueryWrapper<TechCappCraftCardDictItem>)(((new LambdaQueryWrapper<TechCappCraftCardDictItem>()
                  .eq(TechCappCraftCardDictItem::getDictType, listDTO.getDictType()))
               .like(StrUtil.isNotBlank(listDTO.getDictValue()), TechCappCraftCardDictItem::getDictValue, listDTO.getDictValue()))
            .eq(ObjectUtil.isNotNull(listDTO.getEnabledFlag()), TechCappCraftCardDictItem::getEnabledFlag, listDTO.getEnabledFlag()))
         .and(
            StrUtil.isNotBlank(listDTO.getUserName()),
            w -> {
               LambdaQueryWrapper var10000 = ((w.like(
                        TechCappCraftCardDictItem::getCreateUserName, listDTO.getUserName()
                     ))
                     .or())
                  .like(TechCappCraftCardDictItem::getUpdateUserName, listDTO.getUserName());
            }
         );
      return this.selectList(wrapper);
   }
}
