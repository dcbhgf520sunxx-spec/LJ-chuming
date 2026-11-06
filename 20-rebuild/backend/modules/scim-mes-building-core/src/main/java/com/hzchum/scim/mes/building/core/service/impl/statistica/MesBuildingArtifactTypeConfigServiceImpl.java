package com.hzchum.scim.mes.building.core.service.impl.statistica;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingArtifactTypeConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingStructureClassificationTypeLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingArtifactTypeConfigDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingArtifactTypeConfigService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingStructureClassificationTypeLinkService;
import com.hzchum.scim.mes.building.core.mapper.statistica.MesBuildingArtifactTypeConfigMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingArtifactTypeConfigServiceImpl
   extends ServiceImpl<MesBuildingArtifactTypeConfigMapper, MesBuildingArtifactTypeConfig>
   implements MesBuildingArtifactTypeConfigService {
   @Resource
   private MesBuildingStructureClassificationTypeLinkService structureClassificationTypeLinkService;

   @Override
   public ListVO getArtifactTypeConfig() {
      List<MesBuildingArtifactTypeConfig> mesBuildingArtifactTypeConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      List<MesBuildingArtifactTypeConfigDTO> dtoList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(mesBuildingArtifactTypeConfigs)) {
         mesBuildingArtifactTypeConfigs.forEach(config -> {
            MesBuildingArtifactTypeConfigDTO copy = BeanUtil.copy(config, MesBuildingArtifactTypeConfigDTO.class);
            if (StringUtils.isNotBlank(config.getInventoryName())) {
               copy.setInventoryNames(new HashSet<>(Arrays.asList(config.getInventoryName().split(","))));
            }

            dtoList.add(copy);
         });
      }

      return new ListVO<>(dtoList);
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean setArtifactTypeConfig(MesBuildingArtifactTypeConfigDTO dto) {
      MesBuildingArtifactTypeConfig mesBuildingArtifactTypeConfig = this.baseMapper
         .selectOne((Wrapper<MesBuildingArtifactTypeConfig>)new LambdaQueryWrapper<MesBuildingArtifactTypeConfig>().eq(MesBuildingArtifactTypeConfig::getTypeName, dto.getTypeName()));
      Preconditions.checkArgument(mesBuildingArtifactTypeConfig == null, "新增失败，构件种类名称已存在!!!");
      mesBuildingArtifactTypeConfig = MesBuildingArtifactTypeConfig.builder().typeName(dto.getTypeName()).build();
      if (CollectionUtils.isNotEmpty(dto.getInventoryNames())) {
         List<MesBuildingArtifactTypeConfig> inventoryNamesConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
         if (CollectionUtils.isNotEmpty(inventoryNamesConfigs)) {
            inventoryNamesConfigs.forEach(
               e -> dto.getInventoryNames()
                  .forEach(s -> Preconditions.checkArgument(!Arrays.asList(StringUtils.split(e.getInventoryName(), ",")).contains(s), "新增失败,包含的清单编号已存在!!!"))
            );
         }

         mesBuildingArtifactTypeConfig.setInventoryName(StringUtils.join(dto.getInventoryNames(), ","));
      }

      this.baseMapper.insert(mesBuildingArtifactTypeConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateArtifactTypeConfig(MesBuildingArtifactTypeConfigDTO dto) {
      MesBuildingArtifactTypeConfig mesBuildingArtifactTypeConfig = this.baseMapper
         .selectOne((Wrapper<MesBuildingArtifactTypeConfig>)new LambdaQueryWrapper<MesBuildingArtifactTypeConfig>().eq(MesBuildingArtifactTypeConfig::getId, dto.getId()));
      Preconditions.checkArgument(mesBuildingArtifactTypeConfig != null, "更新失败，构件种类配置不存在!!!");
      Boolean flag = false;
      if (dto.getTypeName() != null && !mesBuildingArtifactTypeConfig.getTypeName().equals(dto.getTypeName())) {
         List<MesBuildingArtifactTypeConfig> mesBuildingArtifactTypeConfigs = this.baseMapper
            .selectList(
               (Wrapper<MesBuildingArtifactTypeConfig>)(new LambdaQueryWrapper<MesBuildingArtifactTypeConfig>()
                     .eq(MesBuildingArtifactTypeConfig::getTypeName, dto.getTypeName()))
                  .ne(MesBuildingArtifactTypeConfig::getId, dto.getId())
            );
         Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingArtifactTypeConfigs), "更新失败，构件种类名称重复");
         mesBuildingArtifactTypeConfig.setTypeName(dto.getTypeName());
         flag = true;
      }

      if (!mesBuildingArtifactTypeConfig.getInventoryName().equals(StringUtils.join(dto.getInventoryNames(), ","))) {
         List<MesBuildingArtifactTypeConfig> inventoryNamesConfigs = this.baseMapper
            .selectList((Wrapper<MesBuildingArtifactTypeConfig>)new LambdaQueryWrapper<MesBuildingArtifactTypeConfig>().ne(MesBuildingArtifactTypeConfig::getId, dto.getId()));
         if (CollectionUtils.isNotEmpty(inventoryNamesConfigs)) {
            inventoryNamesConfigs.forEach(
               e -> dto.getInventoryNames()
                  .forEach(s -> Preconditions.checkArgument(!Arrays.asList(StringUtils.split(e.getInventoryName(), ",")).contains(s), "更新失败,包含的清单编号已存在!!!"))
            );
         }

         mesBuildingArtifactTypeConfig.setInventoryName(StringUtils.join(dto.getInventoryNames(), ","));
         flag = true;
      }

      if (flag) {
         this.baseMapper.updateById(mesBuildingArtifactTypeConfig);
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean removeArtifactTypeConfig(Set<Long> ids) {
      ids.forEach(
         id -> {
            MesBuildingArtifactTypeConfig mesBuildingArtifactTypeConfig = this.baseMapper.selectById(id);
            Preconditions.checkArgument(mesBuildingArtifactTypeConfig != null, "删除失败,构件种类配置不存在");
            List<MesBuildingStructureClassificationTypeLink> classificationTypeLinks = this.structureClassificationTypeLinkService
               .list(
                  (Wrapper<MesBuildingStructureClassificationTypeLink>)new LambdaQueryWrapper<MesBuildingStructureClassificationTypeLink>()
                     .eq(MesBuildingStructureClassificationTypeLink::getArtifactTypeId, id)
               );
            Preconditions.checkArgument(CollectionUtils.isEmpty(classificationTypeLinks), "删除失败，已存在对应的组铆焊配置!!!");
            this.baseMapper.deleteById(mesBuildingArtifactTypeConfig.getId());
         }
      );
      return Boolean.TRUE;
   }
}
