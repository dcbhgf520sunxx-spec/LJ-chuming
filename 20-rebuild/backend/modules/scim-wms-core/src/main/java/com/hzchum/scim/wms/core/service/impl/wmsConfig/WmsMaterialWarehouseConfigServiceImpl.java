package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.WmsMaterialWarehouseConfig;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig.WmsMaterialWarehouseConfigDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsConfig.MaterialWarehouseDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import com.hzchum.scim.wms.core.api.service.wmsConfig.WmsMaterialWarehouseConfigService;
import com.hzchum.scim.wms.core.api.utils.CommonUtil;
import com.hzchum.scim.wms.core.mapper.wmsConfig.WmsMaterialWarehouseConfigMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WmsMaterialWarehouseConfigServiceImpl
   extends ServiceImpl<WmsMaterialWarehouseConfigMapper, WmsMaterialWarehouseConfig>
   implements WmsMaterialWarehouseConfigService {
   @Resource
   ClassificationService classificationService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean addWmsMaterialWarehouseConfig(MaterialWarehouseDTOParam request) {
      if (CollectionUtils.isNotEmpty(request.getClassifyIds())) {
         ArrayList<Long> distinct = CollectionUtil.distinct(request.getClassifyIds());
         WmsMaterialWarehouseConfig build = WmsMaterialWarehouseConfig.builder()
            .basicClass(request.getBasicClass())
            .classifyIds(StrUtil.join(",", distinct))
            .name(request.getName())
            .build();
         this.baseMapper.insert(build);
      }

      return true;
   }

   @Override
   public List<WmsMaterialWarehouseConfigDTO> getWmsMaterialWarehouseConfig() {
      List<WmsMaterialWarehouseConfig> wmsMaterialWarehouseConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      List<Long> ids = new ArrayList<>();
      ArrayList<WmsMaterialWarehouseConfigDTO> objects = new ArrayList<>();
      wmsMaterialWarehouseConfigs.forEach(
         wmsMaterialWarehouseConfig -> {
            List<Long> spilt = CommonUtil.spilt(wmsMaterialWarehouseConfig.getClassifyIds(), ",");
            ids.addAll(spilt);
            List<Classification> listx = this.classificationService.list((Wrapper<Classification>)new LambdaQueryWrapper<Classification>().in(Classification::getId, spilt));
            WmsMaterialWarehouseConfigDTO buildx = WmsMaterialWarehouseConfigDTO.builder()
               .id(wmsMaterialWarehouseConfig.getId())
               .list(listx)
               .basicClass(wmsMaterialWarehouseConfig.getBasicClass())
               .name(wmsMaterialWarehouseConfig.getName())
               .build();
            objects.add(buildx);
         }
      );
      List<Classification> classificationList = this.classificationService
         .list(
            (Wrapper<Classification>)((new LambdaQueryWrapper<Classification>().notIn(Classification::getBasicClass, 1, 2, 4))
                  .notIn(CollectionUtils.isNotEmpty(ids), Classification::getId, ids))
               .eq(Classification::getBoolLastEnum, 1)
         );
      List<Long> reduce1 = classificationList.stream().map(Classification::getId).collect(Collectors.toList());
      List<Classification> list = this.classificationService
         .list(new LambdaQueryWrapper<Classification>().in(CollectionUtil.isNotEmpty(reduce1), Classification::getId, reduce1));
      WmsMaterialWarehouseConfigDTO build = WmsMaterialWarehouseConfigDTO.builder().list(list).name("默认仓库").build();
      objects.add(build);
      return objects;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateWmsMaterialWarehouseConfig(MaterialWarehouseDTOParam request) {
      if (CollectionUtils.isNotEmpty(request.getClassifyIds())) {
         ArrayList<Long> distinct = CollectionUtil.distinct(request.getClassifyIds());
         WmsMaterialWarehouseConfig build = WmsMaterialWarehouseConfig.builder()
            .id(request.getId())
            .basicClass(request.getBasicClass())
            .classifyIds(StrUtil.join(",", distinct))
            .name(request.getName())
            .build();
         this.baseMapper.updateById(build);
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean deleteWmsMaterialWarehouseConfig(List<Long> ids) {
      this.baseMapper.deleteBatchIds(ids);
      return true;
   }
}
