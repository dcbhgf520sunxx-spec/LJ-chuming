package com.hzchum.scim.wms.core.biz.wmsConfig;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.wms.core.api.biz.wmsConfig.WasteClassificationBiz;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WasteClassification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSaleDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WasteClassificationDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.WasteClassificationDtoParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WasteClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsReport.WasteSaleDetailService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WasteClassificationMapper;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WasteClassificationBizImpl
   extends IBizImpl<WasteClassificationService, WasteClassificationMapper, WasteClassification>
   implements WasteClassificationBiz {
   private final WasteSaleDetailService wasteSaleDetailService;

   @Override
   public List<WasteClassificationDTO> listAll(String name) {
      return this.baseService.listWasteClassification(name);
   }

   @Override
   public PageVO<WasteClassificationDTO> pageList(String name, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<WasteClassificationDTO> dtoList = this.baseService.listWasteClassification(name);
      return new PageVO<>(dtoList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveList(List<WasteClassificationDtoParam> paramList) {
      paramList.forEach(param -> {
         int count = this.baseService.count(Wrappers.lambdaQuery(WasteClassification.builder().name(param.getName()).build()));
         Preconditions.checkArgument(count == 0, "废料种类已存在!");
         WasteClassification classification = BeanUtil.copy(param, WasteClassification.class);
         classification.setUserId(UserUtil.getCurrentUserId());
         this.baseService.save(classification);
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateList(List<WasteClassificationDtoParam> paramList) {
      paramList.forEach(param -> {
         Preconditions.checkArgument(param.getId() != null, "废料类型id不能为空!");
         WasteClassification wasteClassification = this.baseService.getById(param.getId());
         Preconditions.checkArgument(wasteClassification != null, "废料类型不存在!");
         if (!param.getName().equals(wasteClassification.getName()) || !param.getMeasureUnit().equals(wasteClassification.getMeasureUnit())) {
            int count = this.wasteSaleDetailService.count(Wrappers.lambdaQuery(WasteSaleDetail.builder().wasteClassificationId(param.getId()).build()));
            Preconditions.checkArgument(count == 0, "修改失败,废料类型存在出售记录!");
            if (!param.getName().equals(wasteClassification.getName())) {
               count = this.baseService.count(Wrappers.lambdaQuery(WasteClassification.builder().name(param.getName()).build()));
               Preconditions.checkArgument(count == 0, "废料类型已存在!");
            }
         }

         BeanUtil.copy(param, wasteClassification);
         this.baseService.updateById(wasteClassification);
      });
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(id -> {
         WasteClassification wasteClassification = this.baseService.getById(id);
         Preconditions.checkArgument(wasteClassification != null, "废料种类不存在!");
         int count = this.wasteSaleDetailService.count(Wrappers.lambdaQuery(WasteSaleDetail.builder().wasteClassificationId(id).build()));
         Preconditions.checkArgument(count == 0, "删除失败,该类型已存在出售记录!");
         this.baseService.removeById(id);
      });
      return true;
   }

   public WasteClassificationBizImpl(final WasteSaleDetailService wasteSaleDetailService) {
      this.wasteSaleDetailService = wasteSaleDetailService;
   }
}
