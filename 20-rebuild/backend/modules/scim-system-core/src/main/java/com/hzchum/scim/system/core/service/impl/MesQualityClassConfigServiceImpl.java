package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesQualityClassConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigSaveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesQualityClassConfigTreeDTO;
import com.hzchum.scim.system.core.api.service.MesQualityClassConfigService;
import com.hzchum.scim.system.core.mapper.MesQualityClassConfigMapper;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MesQualityClassConfigServiceImpl extends ServiceImpl<MesQualityClassConfigMapper, MesQualityClassConfig> implements MesQualityClassConfigService {
   @Override
   public PageVO<MesQualityClassConfigDTO> findQualityClassConfigList(
      Long qualityClassId, Integer factoryOrConstructionSite, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      qualityClassId = qualityClassId == null ? 0L : qualityClassId;
      List<MesQualityClassConfigDTO> allConfigList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesQualityClassConfig.class)
               .eq(MesQualityClassConfig::getPid, qualityClassId)
               .eq(MesQualityClassConfig::getFactoryOrConstructionSite, factoryOrConstructionSite)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesQualityClassConfigDTO.class))
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(allConfigList) ? new PageVO<>() : new PageVO<>(allConfigList);
   }

   @Override
   public Boolean saveClassConfig(MesQualityClassConfigSaveDTO classConfig) {
      if (classConfig.getPid() == null || classConfig.getPid() == 0L) {
         boolean allMatch = classConfig.getClassConfigs().stream().allMatch(s -> Pattern.compile("[a-zA-Z0-9]{2}").matcher(s.getSerialNumber()).matches());
         Preconditions.checkArgument(allMatch, "代码必须符合两个数字或字母");
      }

      MesQualityClassConfig parent = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(MesQualityClassConfig.class)
               .eq(MesQualityClassConfig::getPid, classConfig.getPid())
               .in(MesQualityClassConfig::getSerialNumber, classConfig.getClassConfigs().stream().map(e -> e.getSerialNumber()).collect(Collectors.toList()))
         );
      Preconditions.checkArgument(parent == null, "编号已存在，请重新输入");
      List<MesQualityClassConfig> saveList = classConfig.getClassConfigs().stream().map(e -> {
         MesQualityClassConfig config = BeanUtil.copy(e, MesQualityClassConfig.class);
         config.setFactoryOrConstructionSite(classConfig.getFactoryOrConstructionSite());
         config.setPid(classConfig.getPid());
         return config;
      }).collect(Collectors.toList());
      this.saveBatch(saveList);
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateConfig(MesQualityClassConfigDTO classConfig) {
      this.baseMapper.updateById(BeanUtil.copy(classConfig, MesQualityClassConfig.class));
      return Boolean.TRUE;
   }

   @Override
   public Boolean delClassConfig(Long calssId) {
      MesQualityClassConfig configList = this.baseMapper.selectById(calssId);
      Preconditions.checkArgument(configList != null, "质检问题数据不存在");
      if (configList.getPid().equals(0L)) {
         List<MesQualityClassConfig> childList = this.baseMapper
            .selectList(Wrappers.lambdaQuery(MesQualityClassConfig.class).eq(MesQualityClassConfig::getPid, configList.getId()));
         Preconditions.checkArgument(CollectionUtils.isEmpty(childList), "存在子分类无法删除");
         this.baseMapper.deleteById(configList.getId());
      } else {
         this.baseMapper.deleteById(configList.getId());
      }

      return Boolean.TRUE;
   }

   @Override
   public Boolean changeState(ChangStatusDTO classConfig) {
      MesQualityClassConfig config = BeanUtil.copy(classConfig, MesQualityClassConfig.class);
      if (config.getPid() == null && config.getStatus().equals(Boolean.FALSE)) {
         List<MesQualityClassConfig> classConfigs = this.baseMapper
            .selectList(Wrappers.lambdaQuery(MesQualityClassConfig.class).eq(MesQualityClassConfig::getPid, config.getId()));
         Preconditions.checkArgument(classConfigs.stream().allMatch(s -> s.getStatus().equals(Boolean.TRUE)), "存在子分类配置正在启用");
      }

      return this.updateById(config);
   }

   @Override
   public List<MesQualityClassConfigTreeDTO> findQualityClassConfigTree(Integer factoryOrConstructionSite) {
      List<MesQualityClassConfig> classConfigs = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesQualityClassConfig.class)
               .eq(factoryOrConstructionSite != null, MesQualityClassConfig::getFactoryOrConstructionSite, factoryOrConstructionSite)
         );
      List<MesQualityClassConfig> fatherConfigs = classConfigs.stream().filter(e -> e.getPid().equals(0L)).collect(Collectors.toList());
      Map<Long, List<MesQualityClassConfig>> childrenMap = classConfigs.stream()
         .filter(e -> !e.getPid().equals(0L))
         .collect(Collectors.groupingBy(MesQualityClassConfig::getPid));
      return fatherConfigs.stream().map(e -> {
         MesQualityClassConfigTreeDTO treeDTO = BeanUtil.copy(e, MesQualityClassConfigTreeDTO.class);
         treeDTO.setChildren(childrenMap.get(e.getId()));
         return treeDTO;
      }).collect(Collectors.toList());
   }
}
