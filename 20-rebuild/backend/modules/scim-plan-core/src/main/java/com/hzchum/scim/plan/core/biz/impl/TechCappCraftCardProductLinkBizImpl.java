package com.hzchum.scim.plan.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftCardProductLinkBiz;
import com.hzchum.scim.plan.core.api.biz.TechCappCraftProductTaskBiz;
import com.hzchum.scim.plan.core.api.enums.CappProductUpdateTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftCardProductLink;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductTask;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductLinkListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductLinkUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductLinkVO;
import com.hzchum.scim.plan.core.api.service.TechCappCraftCardProductLinkService;
import com.hzchum.scim.plan.core.mapper.TechCappCraftCardProductLinkMapper;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechCappCraftCardProductLinkBizImpl
   extends IBizImpl<TechCappCraftCardProductLinkService, TechCappCraftCardProductLinkMapper, TechCappCraftCardProductLink>
   implements TechCappCraftCardProductLinkBiz {
   @Resource
   private TechCappCraftProductTaskBiz techCappCraftProductTaskBiz;

   @Override
   public PageVO<CappCraftCardProductLinkVO> list(CappCraftCardProductLinkListDTO dto) {
      if (dto.getPageNumber() == null || dto.getPageSize() == null) {
         dto.setPageNumber(1);
         dto.setPageSize(Integer.MAX_VALUE);
      }

      Page<Object> objects = PageHelper.startPage(dto.getPageNumber(), dto.getPageSize());
      return new PageVO<>(objects, this.baseMapper.list(dto));
   }

   @Transactional
   @Override
   public Boolean update(List<CappCraftCardProductLinkUpdateDTO> updateDTO) {
      Map<Long, List<TechCappCraftProductTask>> map = this.techCappCraftProductTaskBiz
         .list(
            Wrappers.lambdaQuery(TechCappCraftProductTask.class)
               .eq(TechCappCraftProductTask::getProductType, updateDTO.get(0).getProductType())
               .in(TechCappCraftProductTask::getProductId, updateDTO.stream().map(CappCraftCardProductLinkUpdateDTO::getProductId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.groupingBy(TechCappCraftProductTask::getProductId));
      updateDTO.forEach(item -> {
         if (!item.getCappProductUpdateTypeEnum().equals(CappProductUpdateTypeEnum.NEW.getType())) {
            if (CollectionUtils.isNotEmpty(map)) {
               List<TechCappCraftProductTask> techCappCraftProductTasks = map.get(item.getProductId());
               Preconditions.checkArgument(CollectionUtils.isEmpty(techCappCraftProductTasks), item.getProductSerialNumber() + "该产品已下发任务,不可进行编辑");
            }

            this.baseService.removeById(item.getId());
         }

         if (!item.getCappProductUpdateTypeEnum().equals(CappProductUpdateTypeEnum.UNBIND.getType())) {
            this.baseService.save(BeanUtil.copy(item, TechCappCraftCardProductLink.class));
         }
      });
      updateDTO.forEach(item -> {
         if (!item.getCappProductUpdateTypeEnum().equals(CappProductUpdateTypeEnum.UNBIND.getType())) {
            this.techCappCraftProductTaskBiz.reissuedCappTask(item.getProductId(), item.getProductType());
         }
      });
      return Boolean.TRUE;
   }
}
