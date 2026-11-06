package com.hzchum.scim.plan.core.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardDictItemBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardDictItem;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemSaveDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardDictItemSaveDTO.Item;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardDictItemVO;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardDictItemService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardDictItemMapper;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechCappCraftCardDictItemBizImpl
   extends IBizImpl<TechCappCraftCardDictItemService, TechCappCraftCardDictItemMapper, TechCappCraftCardDictItem>
   implements TechCappCraftCardDictItemBiz {
   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean save(CappCraftCardDictItemSaveDTO saveDTO) {
      String dictType = saveDTO.getDictType();
      List<Item> itemList = saveDTO.getItems();
      SecurityUser currentUser = UserUtil.getCurrentUser();
      Map<String, TechCappCraftCardDictItem> oldMapByDictValue = this.baseService.getMapByDictTypeAndDictValue(dictType);
      List<TechCappCraftCardDictItem> newItemList = new ArrayList<>();

      for (Item item : itemList) {
         String dictValue = item.getDictValue();
         TechCappCraftCardDictItem thisOldItem = oldMapByDictValue.get(dictValue);
         Preconditions.checkArgument(thisOldItem == null, String.format("字典值「%s」已存在", dictValue));
         TechCappCraftCardDictItem thisNewItem = new TechCappCraftCardDictItem()
            .setDictType(dictType)
            .setDictValue(dictValue)
            .setSort(item.getSort())
            .setEnabledFlag(item.getEnabledFlag())
            .setCreateUserId(currentUser.getId())
            .setCreateUserName(currentUser.getName());
         newItemList.add(thisNewItem);
         oldMapByDictValue.put(dictValue, thisNewItem);
      }

      return this.baseService.saveBatch(newItemList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean update(CappCraftCardDictItemUpdateDTO updateDTO) {
      String dictValue = updateDTO.getDictValue();
      TechCappCraftCardDictItem item = this.baseService.getById(updateDTO.getId());
      Preconditions.checkArgument(item != null, "字典值不存在");
      TechCappCraftCardDictItem oldItem = this.baseMapper.selectOneByDictTypeAndDictValue(item.getDictType(), dictValue);
      if (oldItem != null && !oldItem.getId().equals(item.getId())) {
         throw new IllegalArgumentException(String.format("字典值「%s」已存在", dictValue));
      }

      SecurityUser currentUser = UserUtil.getCurrentUser();
      TechCappCraftCardDictItem updateItem = new TechCappCraftCardDictItem()
         .setId(item.getId())
         .setDictValue(dictValue)
         .setSort(updateDTO.getSort())
         .setEnabledFlag(updateDTO.getEnabledFlag())
         .setUpdateUserId(currentUser.getId())
         .setUpdateUserName(currentUser.getName());
      return this.baseService.updateById(updateItem);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateEnabledFlag(Long id, Boolean enabledFlag) {
      SecurityUser currentUser = UserUtil.getCurrentUser();
      TechCappCraftCardDictItem updateItem = new TechCappCraftCardDictItem()
         .setId(id)
         .setEnabledFlag(enabledFlag)
         .setUpdateUserId(currentUser.getId())
         .setUpdateUserName(currentUser.getName());
      return this.baseService.updateById(updateItem);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delete(Long id) {
      return this.baseService.removeById(id);
   }

   private List<CappCraftCardDictItemVO> convertVOList(List<TechCappCraftCardDictItem> list) {
      return list.stream().map(item -> BeanUtil.copyProperties(item, CappCraftCardDictItemVO.class)).collect(Collectors.toList());
   }

   @Override
   public List<CappCraftCardDictItemVO> getList(CappCraftCardDictItemListDTO listDTO) {
      List<TechCappCraftCardDictItem> list = this.baseMapper.selectList(listDTO);
      return this.convertVOList(list);
   }

   @Override
   public Map<String, List<CappCraftCardDictItemVO>> getMapByDictType() {
      List<TechCappCraftCardDictItem> list = this.baseMapper.selectList(Wrappers.emptyWrapper());
      List<CappCraftCardDictItemVO> voList = this.convertVOList(list);
      return voList.stream().collect(Collectors.groupingBy(CappCraftCardDictItemVO::getDictType));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void autoAddDict(String dictType, String dictValue) {
      TechCappCraftCardDictItem dictItem = this.baseService
         .getOne(
            Wrappers.lambdaQuery(TechCappCraftCardDictItem.class)
               .eq(TechCappCraftCardDictItem::getDictType, dictType)
               .eq(TechCappCraftCardDictItem::getDictValue, dictValue)
         );
      if (dictItem == null) {
         List<TechCappCraftCardDictItem> list = this.baseService
            .list(Wrappers.lambdaQuery(TechCappCraftCardDictItem.class).eq(TechCappCraftCardDictItem::getDictType, dictType));
         this.baseService
            .save(
               TechCappCraftCardDictItem.builder()
                  .dictType(dictType)
                  .dictValue(dictValue)
                  .sort(list.size() + 1)
                  .enabledFlag(Boolean.TRUE)
                  .createUserName(UserUtil.getCurrentName())
                  .createUserId(UserUtil.getCurrentUserId())
                  .build()
            );
      }
   }
}
