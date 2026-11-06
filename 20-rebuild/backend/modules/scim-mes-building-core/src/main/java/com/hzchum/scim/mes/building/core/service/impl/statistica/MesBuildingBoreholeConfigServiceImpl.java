package com.hzchum.scim.mes.building.core.service.impl.statistica;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.NumberUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingBoreholeConfig;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.statistica.MesBuildingBoreholeConfigLink;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeConfigDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.statistica.MesBuildingBoreholeConfigLinkDTO;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingBoreholeConfigLinkService;
import com.hzchum.scim.mes.building.core.api.service.statistica.MesBuildingBoreholeConfigService;
import com.hzchum.scim.mes.building.core.mapper.statistica.MesBuildingBoreholeConfigMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingBoreholeConfigServiceImpl
   extends ServiceImpl<MesBuildingBoreholeConfigMapper, MesBuildingBoreholeConfig>
   implements MesBuildingBoreholeConfigService {
   @Resource
   private MesBuildingBoreholeConfigLinkService mesBuildingBoreholeConfigLinkService;

   @Override
   public List<MesBuildingBoreholeConfigDTO> getBoreholeList() {
      List<MesBuildingBoreholeConfigDTO> boreholeConfigDTOS = new ArrayList<>();
      List<MesBuildingBoreholeConfig> mesBuildingBoreholeConfigs = this.baseMapper.selectList(new LambdaQueryWrapper<>());
      if (CollectionUtils.isNotEmpty(mesBuildingBoreholeConfigs)) {
         List<MesBuildingBoreholeConfigLink> configLinks = this.mesBuildingBoreholeConfigLinkService.list();
         Map<Long, List<MesBuildingBoreholeConfigLink>> configLinkMap = configLinks.stream()
            .collect(Collectors.groupingBy(MesBuildingBoreholeConfigLink::getBoreholeConfigId));
         mesBuildingBoreholeConfigs.forEach(config -> {
            MesBuildingBoreholeConfigDTO configDTO = BeanUtil.copy(config, MesBuildingBoreholeConfigDTO.class);
            List<MesBuildingBoreholeConfigLink> links = configLinkMap.get(configDTO.getId());
            if (CollectionUtils.isNotEmpty(links)) {
               configDTO.setConfigLinkDTOS(links.stream().map(e -> BeanUtil.copy(e, MesBuildingBoreholeConfigLinkDTO.class)).collect(Collectors.toList()));
            }

            boreholeConfigDTOS.add(configDTO);
         });
      }

      return boreholeConfigDTOS;
   }

   @Override
   public Boolean saveBoreholeList(List<MesBuildingBoreholeConfigDTO> dtoList) {
      dtoList.forEach(
         dto -> {
            Preconditions.checkArgument(dto.getMaxThickness().compareTo(dto.getMinThickness()) >= 0, "最小板厚不能大于最大板厚");
            List<MesBuildingBoreholeConfig> mesBuildingBoreholeConfigs = this.baseMapper
               .selectList((Wrapper<MesBuildingBoreholeConfig>)new LambdaQueryWrapper<MesBuildingBoreholeConfig>().eq(MesBuildingBoreholeConfig::getSpecPrefix, dto.getSpecPrefix()));
            if (CollectionUtils.isNotEmpty(mesBuildingBoreholeConfigs)) {
               mesBuildingBoreholeConfigs.forEach(
                  boreholeConfig -> Preconditions.checkArgument(
                     NumberUtil.rangeInDefined(dto.getMinThickness(), dto.getMaxThickness(), boreholeConfig.getMinThickness(), boreholeConfig.getMaxThickness()),
                     "规格" + dto.getSpecPrefix() + "的板厚范围已存在"
                  )
               );
            }

            MesBuildingBoreholeConfig copy = BeanUtil.copy(dto, MesBuildingBoreholeConfig.class);
            this.baseMapper.insert(copy);
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateBoreholeList(MesBuildingBoreholeConfigDTO dto) {
      MesBuildingBoreholeConfig config = this.baseMapper.selectById(dto.getId());
      Preconditions.checkArgument(config != null, "修改失败，钻孔配置不存在！！！");
      List<MesBuildingBoreholeConfig> mesBuildingBoreholeConfigs = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingBoreholeConfig>)(new LambdaQueryWrapper<MesBuildingBoreholeConfig>()
                  .eq(MesBuildingBoreholeConfig::getSpecPrefix, config.getSpecPrefix()))
               .ne(MesBuildingBoreholeConfig::getId, dto.getId())
         );
      if (dto.getMinThickness().compareTo(config.getMinThickness()) != 0 || dto.getMaxThickness().compareTo(config.getMaxThickness()) != 0) {
         if (CollectionUtils.isNotEmpty(mesBuildingBoreholeConfigs)) {
            mesBuildingBoreholeConfigs.forEach(
               boreholeConfig -> Preconditions.checkArgument(
                  NumberUtil.rangeInDefined(dto.getMinThickness(), dto.getMaxThickness(), boreholeConfig.getMinThickness(), boreholeConfig.getMaxThickness()),
                  "规格" + dto.getSpecPrefix() + "的板厚范围已存在"
               )
            );
         }

         config.setMinThickness(dto.getMinThickness());
         config.setMaxThickness(dto.getMaxThickness());
      }

      this.baseMapper.updateById(config);
      return Boolean.TRUE;
   }

   @Override
   public Boolean saveBoreholeLinkList(MesBuildingBoreholeConfigLinkDTO linkDTO) {
      MesBuildingBoreholeConfig config = this.baseMapper.selectById(linkDTO.getBoreholeConfigId());
      Preconditions.checkArgument(config != null, "钻孔配置不存在!!!");
      List<MesBuildingBoreholeConfigLink> configLinks = this.mesBuildingBoreholeConfigLinkService
         .list((Wrapper<MesBuildingBoreholeConfigLink>)new LambdaQueryWrapper<MesBuildingBoreholeConfigLink>().eq(MesBuildingBoreholeConfigLink::getBoreholeConfigId, config.getId()));
      if (CollectionUtils.isNotEmpty(configLinks)) {
         configLinks.forEach(
            link -> Preconditions.checkArgument(
               NumberUtil.rangeInDefined(linkDTO.getMinBoreDiameter(), linkDTO.getMaxBoreDiameter(), link.getMinBoreDiameter(), link.getMaxBoreDiameter()),
               "孔径范围已存在!!!"
            )
         );
      }

      MesBuildingBoreholeConfigLink configLink = BeanUtil.copy(linkDTO, MesBuildingBoreholeConfigLink.class);
      this.mesBuildingBoreholeConfigLinkService.save(configLink);
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateBoreholeLinkList(MesBuildingBoreholeConfigLinkDTO linkDTO) {
      MesBuildingBoreholeConfigLink configLink = this.mesBuildingBoreholeConfigLinkService.getById(linkDTO.getId());
      Preconditions.checkArgument(configLink != null, "钻孔关联配置不存在!!!");
      Preconditions.checkArgument(configLink.getBoreholeConfigId().equals(linkDTO.getBoreholeConfigId()), "钻孔配置不存在!!!");
      List<MesBuildingBoreholeConfigLink> configLinks = this.mesBuildingBoreholeConfigLinkService
         .list(
            (Wrapper<MesBuildingBoreholeConfigLink>)(new LambdaQueryWrapper<MesBuildingBoreholeConfigLink>()
                  .eq(MesBuildingBoreholeConfigLink::getBoreholeConfigId, configLink.getBoreholeConfigId()))
               .ne(MesBuildingBoreholeConfigLink::getId, linkDTO.getId())
         );
      if (linkDTO.getMinBoreDiameter().compareTo(configLink.getMinBoreDiameter()) != 0
         || linkDTO.getMaxBoreDiameter().compareTo(configLink.getMaxBoreDiameter()) != 0) {
         if (CollectionUtils.isNotEmpty(configLinks)) {
            configLinks.forEach(
               link -> Preconditions.checkArgument(
                  NumberUtil.rangeInDefined(linkDTO.getMinBoreDiameter(), linkDTO.getMaxBoreDiameter(), link.getMinBoreDiameter(), link.getMaxBoreDiameter()),
                  "孔径范围已存在!!!"
               )
            );
         }

         configLink.setMinBoreDiameter(linkDTO.getMinBoreDiameter());
         configLink.setMaxBoreDiameter(linkDTO.getMaxBoreDiameter());
      }

      if (configLink.getUnitPrice().compareTo(linkDTO.getUnitPrice()) != 0) {
         configLink.setUnitPrice(linkDTO.getUnitPrice());
      }

      this.mesBuildingBoreholeConfigLinkService.updateById(configLink);
      return Boolean.TRUE;
   }

   @Override
   public Boolean removeBoreholeList(List<Long> ids) {
      Preconditions.checkArgument(this.baseMapper.selectBatchIds(ids).size() == ids.size(), "删除失败，钻孔配置不存在");
      List<MesBuildingBoreholeConfigLink> configLinkList = this.mesBuildingBoreholeConfigLinkService
         .list((Wrapper<MesBuildingBoreholeConfigLink>)new LambdaQueryWrapper<MesBuildingBoreholeConfigLink>().in(MesBuildingBoreholeConfigLink::getBoreholeConfigId, ids));
      Preconditions.checkArgument(CollectionUtils.isEmpty(configLinkList), "无法删除,存在对应的钻孔关联");
      this.baseMapper.deleteBatchIds(ids);
      return Boolean.TRUE;
   }

   @Override
   public Boolean removeBoreholeLinkList(List<Long> ids) {
      List<MesBuildingBoreholeConfigLink> configLinks = this.mesBuildingBoreholeConfigLinkService.listByIds(ids);
      Preconditions.checkArgument(configLinks.size() == ids.size(), "删除失败,钻孔关联配置不存在!!!");
      this.mesBuildingBoreholeConfigLinkService.removeByIds(ids);
      return Boolean.TRUE;
   }
}
