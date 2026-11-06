package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SourceEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesSectionWarehouseConfigDetail;
import com.hzchum.scim.system.core.api.pojo.dto.MesSectionWarehouseConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesSectionWarehouseConfigDetailDTO;
import com.hzchum.scim.system.core.api.pojo.vo.MesSectionWarehouseConfigVO;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigDetailService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigService;
import com.hzchum.scim.system.core.mapper.MesSectionWarehouseConfigMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesSectionWarehouseConfigServiceImpl
   extends ServiceImpl<MesSectionWarehouseConfigMapper, MesSectionWarehouseConfig>
   implements MesSectionWarehouseConfigService {
   @Resource
   private MesSectionWarehouseConfigDetailService mesSectionWarehouseConfigDetailService;

   @Override
   public Map<Integer, List<MesSectionWarehouseConfigDTO>> getSectionWarehouseConfigList(
      Integer productType, Integer productClassificationEnum, Integer productSectionNameEnum
   ) {
      List<MesSectionWarehouseConfig> sectionWarehouseConfigList = this.baseMapper
         .selectList(
            ((new LambdaQueryWrapper<MesSectionWarehouseConfig>().eq(productType != null, MesSectionWarehouseConfig::getProductType, productType))
                  .eq(productClassificationEnum != null, MesSectionWarehouseConfig::getProductClassificationEnum, productClassificationEnum))
               .eq(productSectionNameEnum != null, MesSectionWarehouseConfig::getProductSectionNameEnum, productSectionNameEnum)
         );
      if (CollectionUtils.isEmpty(sectionWarehouseConfigList)) {
         return new HashMap<>();
      }

      Map<Long, List<MesSectionWarehouseConfigDetail>> configDetailMap = this.mesSectionWarehouseConfigDetailService
         .list()
         .stream()
         .collect(Collectors.groupingBy(MesSectionWarehouseConfigDetail::getConfigId));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(configDetailMap), "截面类型库详情不存在!!!");
      return sectionWarehouseConfigList.stream().map(config -> {
         MesSectionWarehouseConfigDTO warehouseConfigDTO = BeanUtil.copy(config, MesSectionWarehouseConfigDTO.class);
         List<MesSectionWarehouseConfigDetail> detailList = configDetailMap.get(config.getId());
         if (CollectionUtils.isNotEmpty(detailList)) {
            warehouseConfigDTO.setSectionWarehouseConfigDTOList(cn.hutool.core.bean.BeanUtil.copyToList(detailList, MesSectionWarehouseConfigDetailDTO.class));
         }

         return warehouseConfigDTO;
      }).collect(Collectors.groupingBy(MesSectionWarehouseConfigDTO::getProductSectionNameEnum));
   }

   @Override
   public List<MesSectionWarehouseConfigDTO> getSimplenessList(Integer productType, Integer productClassificationEnum, Integer productSectionNameEnum) {
      List<MesSectionWarehouseConfig> sectionWarehouseConfigList = this.baseMapper
         .selectList(
            ((new LambdaQueryWrapper<MesSectionWarehouseConfig>().eq(productType != null, MesSectionWarehouseConfig::getProductType, productType))
                  .eq(productClassificationEnum != null, MesSectionWarehouseConfig::getProductClassificationEnum, productClassificationEnum))
               .eq(productSectionNameEnum != null, MesSectionWarehouseConfig::getProductSectionNameEnum, productSectionNameEnum)
         );
      if (CollectionUtils.isEmpty(sectionWarehouseConfigList)) {
         return new ArrayList<>();
      }

      Map<Long, List<MesSectionWarehouseConfigDetail>> configDetailMap = this.mesSectionWarehouseConfigDetailService
         .list(
            (Wrapper<MesSectionWarehouseConfigDetail>)new LambdaQueryWrapper<MesSectionWarehouseConfigDetail>()
               .in(
                  MesSectionWarehouseConfigDetail::getConfigId,
                  sectionWarehouseConfigList.stream().map(MesSectionWarehouseConfig::getId).collect(Collectors.toList())
               )
         )
         .stream()
         .collect(Collectors.groupingBy(MesSectionWarehouseConfigDetail::getConfigId));
      return sectionWarehouseConfigList.stream().map(config -> {
         MesSectionWarehouseConfigDTO warehouseConfigDTO = BeanUtil.copy(config, MesSectionWarehouseConfigDTO.class);
         List<MesSectionWarehouseConfigDetail> detailList = configDetailMap.get(config.getId());
         if (CollectionUtils.isNotEmpty(detailList)) {
            warehouseConfigDTO.setSectionWarehouseConfigDTOList(cn.hutool.core.bean.BeanUtil.copyToList(detailList, MesSectionWarehouseConfigDetailDTO.class));
         }

         warehouseConfigDTO.setSectionWarehouseConfigDTOList(cn.hutool.core.bean.BeanUtil.copyToList(detailList, MesSectionWarehouseConfigDetailDTO.class));
         return warehouseConfigDTO;
      }).collect(Collectors.toList());
   }

   @Override
   public List<NameInfo> getSectionConfigNameList(Integer productType, Integer productClassificationEnum, Integer productSectionNameEnum) {
      Preconditions.checkArgument(productType != null && productClassificationEnum != null && productSectionNameEnum != null, "操作失败,参数有误");
      MesSectionWarehouseConfig config = this.baseMapper
         .selectOne(
            (Wrapper<MesSectionWarehouseConfig>)((new LambdaQueryWrapper<MesSectionWarehouseConfig>()
                     .eq(MesSectionWarehouseConfig::getProductType, productType))
                  .eq(MesSectionWarehouseConfig::getProductClassificationEnum, productClassificationEnum))
               .eq(MesSectionWarehouseConfig::getProductSectionNameEnum, productSectionNameEnum)
         );
      if (config == null) {
         return new ArrayList<>();
      }

      List<MesSectionWarehouseConfigDetail> detailList = this.mesSectionWarehouseConfigDetailService
         .list((Wrapper<MesSectionWarehouseConfigDetail>)new LambdaQueryWrapper<MesSectionWarehouseConfigDetail>().eq(MesSectionWarehouseConfigDetail::getConfigId, config.getId()));
      return cn.hutool.core.bean.BeanUtil.copyToList(detailList, NameInfo.class);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateSectionWarehouseConfig(MesSectionWarehouseConfigVO vo) {
      MesSectionWarehouseConfig config = this.baseMapper.selectById(vo.getId());
      Preconditions.checkArgument(config != null, "操作失败,截面类型库不存在!!!");
      List<String> productSectionNameList = vo.getProductSectionNameList();
      Preconditions.checkArgument(productSectionNameList.stream().distinct().count() == productSectionNameList.size(), "操作失败,名称不能重复!!!");
      if (ProductTypeEnum.ASSEMBLE.getType().equals(config.getProductType()) || ProductTypeEnum.MACHINE_PART.getType().equals(config.getProductType())) {
         Preconditions.checkArgument(!vo.getProductSectionNameEnum().equals(ProductSectionNameEnum.PRODUCT_NAME.getType()), "操作失败,零件/部件无名称库!");
      }

      if (ProductTypeEnum.AUXILIARY_MATERIAL.getType().equals(config.getProductType())) {
         Preconditions.checkArgument(
            vo.getProductSectionNameEnum().equals(ProductSectionNameEnum.PRODUCT_NAME.getType())
               || vo.getProductSectionNameEnum().equals(ProductSectionNameEnum.NUMBERING_PREFIX.getType()),
            "操作失败,配套件(辅材)只可配置名称/编号前缀库!"
         );
      } else {
         Preconditions.checkArgument(!vo.getProductSectionNameEnum().equals(ProductSectionNameEnum.NUMBERING_PREFIX.getType()), "操作失败,仅配套件(辅材)可配置编号前缀库!");
      }

      Map<Integer, List<MesSectionWarehouseConfigDetail>> configDetailListMap = this.mesSectionWarehouseConfigDetailService
         .list((Wrapper<MesSectionWarehouseConfigDetail>)new LambdaQueryWrapper<MesSectionWarehouseConfigDetail>().eq(MesSectionWarehouseConfigDetail::getConfigId, config.getId()))
         .stream()
         .collect(Collectors.groupingBy(MesSectionWarehouseConfigDetail::getSource));
      List<MesSectionWarehouseConfigDetail> systemConfigDetailList = configDetailListMap.get(SourceEnum.CURRENT_SYSTEM.getType());
      if (CollUtil.isNotEmpty(systemConfigDetailList)) {
         Preconditions.checkArgument(systemConfigDetailList.stream().allMatch(e -> productSectionNameList.contains(e.getName())), "操作失败,系统默认配置不可删除/修改!");
      }

      List<MesSectionWarehouseConfigDetail> userConfigDetailList = configDetailListMap.get(SourceEnum.USER_ADDITION.getType());
      if (CollectionUtils.isNotEmpty(userConfigDetailList)) {
         List<MesSectionWarehouseConfigDetail> removeDetailList = userConfigDetailList.stream()
            .filter(e -> !productSectionNameList.contains(e.getName()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(removeDetailList)) {
            this.mesSectionWarehouseConfigDetailService
               .removeByIds(removeDetailList.stream().map(MesSectionWarehouseConfigDetail::getId).collect(Collectors.toList()));
         }
      }

      List<String> systemNames = configDetailListMap.getOrDefault(SourceEnum.CURRENT_SYSTEM.getType(), new ArrayList<>())
         .stream()
         .map(MesSectionWarehouseConfigDetail::getName)
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(userConfigDetailList)) {
         systemNames.addAll(userConfigDetailList.stream().map(MesSectionWarehouseConfigDetail::getName).collect(Collectors.toList()));
      }

      List<String> addNameList = productSectionNameList.stream().filter(name -> !systemNames.contains(name)).collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(addNameList)) {
         addNameList.forEach(
            name -> {
               MesSectionWarehouseConfigDetail configDetail = MesSectionWarehouseConfigDetail.builder()
                  .name(name)
                  .productType(config.getProductType())
                  .productSectionNameEnum(config.getProductSectionNameEnum())
                  .productClassificationEnum(config.getProductClassificationEnum())
                  .configId(config.getId())
                  .build();
               if (ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType().equals(configDetail.getProductClassificationEnum())
                  && ProductSectionNameEnum.PRODUCT_TYPE_ENUM.getType().equals(configDetail.getProductSectionNameEnum())) {
                  configDetail.setSteelPlateTypeEnum(
                     SteelPlateTypeEnum.SECONDARY_MEMBER.getName().equals(configDetail.getName())
                        ? SteelPlateTypeEnum.SECONDARY_MEMBER.getType()
                        : SteelPlateTypeEnum.PRIMARY_MEMBER.getType()
                  );
               }

               this.mesSectionWarehouseConfigDetailService.save(configDetail);
            }
         );
      }

      return Boolean.TRUE;
   }

   private void checkAssembleSpecPrefix(String specPrefix) {
      Preconditions.checkArgument(StringUtils.isNotBlank(specPrefix), "规格前缀不能为空!");
      char[] chars = specPrefix.toCharArray();

      for (char c : chars) {
         Preconditions.checkArgument(c >= 'A' && c <= 'Z' || String.valueOf(c).matches("[一-龥 ]"), "规格前缀只可配置大写字母或者汉字!");
      }
   }

   @Override
   public int deleteAllFromTable(String tableName) {
      return this.baseMapper.deleteAllFromTable(tableName);
   }
}
