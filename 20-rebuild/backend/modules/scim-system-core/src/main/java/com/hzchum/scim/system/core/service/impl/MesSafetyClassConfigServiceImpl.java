package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesSafetyClassConfig;
import com.hzchum.scim.system.core.api.pojo.dto.config.ChangStatusDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigSaveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesSafetyClassConfigTreeDTO;
import com.hzchum.scim.system.core.api.service.MesSafetyClassConfigService;
import com.hzchum.scim.system.core.mapper.MesSafetyClassConfigMapper;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesSafetyClassConfigServiceImpl extends ServiceImpl<MesSafetyClassConfigMapper, MesSafetyClassConfig> implements MesSafetyClassConfigService {
   @Override
   public PageVO<MesSafetyClassConfigDTO> findSafetyClassConfigList(Long safetyClassId, Integer factoryOrConstructionSite, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      safetyClassId = safetyClassId == null ? 0L : safetyClassId;
      List<MesSafetyClassConfigDTO> allConfigList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesSafetyClassConfig.class)
               .eq(MesSafetyClassConfig::getPid, safetyClassId)
               .eq(MesSafetyClassConfig::getFactoryOrConstructionSite, factoryOrConstructionSite)
         )
         .stream()
         .map(e -> BeanUtil.copy(e, MesSafetyClassConfigDTO.class))
         .collect(Collectors.toList());
      return CollectionUtils.isEmpty(allConfigList) ? new PageVO<>() : new PageVO<>(allConfigList);
   }

   @Override
   public Boolean saveFirstClassConfig(MesSafetyClassConfigSaveDTO classConfig) {
      if (classConfig.getPid() == null || classConfig.getPid() == 0L) {
         boolean allMatch = classConfig.getSafetyConfigs().stream().allMatch(s -> Pattern.compile("[a-zA-Z0-9]{2}").matcher(s.getSerialNumber()).matches());
         Preconditions.checkArgument(allMatch, "代码必须符合两个数字或字母");
      }

      MesSafetyClassConfig parent = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(MesSafetyClassConfig.class)
               .eq(MesSafetyClassConfig::getPid, classConfig.getPid())
               .in(MesSafetyClassConfig::getSerialNumber, classConfig.getSafetyConfigs().stream().map(e -> e.getSerialNumber()).collect(Collectors.toList()))
         );
      Preconditions.checkArgument(parent == null, "编号已存在，请重新输入");
      List<MesSafetyClassConfig> saveList = classConfig.getSafetyConfigs().stream().map(e -> {
         MesSafetyClassConfig config = BeanUtil.copy(e, MesSafetyClassConfig.class);
         config.setFactoryOrConstructionSite(classConfig.getFactoryOrConstructionSite());
         config.setPid(classConfig.getPid());
         config.setType(classConfig.getType());
         return config;
      }).collect(Collectors.toList());
      this.saveBatch(saveList);
      return Boolean.TRUE;
   }

   @Override
   public Boolean updateConfig(MesSafetyClassConfigDTO classConfig) {
      this.baseMapper.updateById(BeanUtil.copy(classConfig, MesSafetyClassConfig.class));
      if (classConfig.getPid() == 0L && classConfig.getStatus().equals(Boolean.FALSE)) {
         List<MesSafetyClassConfig> classConfigs = this.baseMapper
            .selectList(Wrappers.lambdaQuery(MesSafetyClassConfig.class).eq(MesSafetyClassConfig::getPid, classConfig.getId()));
         Preconditions.checkArgument(classConfigs.stream().allMatch(s -> s.getStatus().equals(Boolean.TRUE)), "存在子分类配置正在启用");
      }

      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean delClassConfig(Long classConfigId) {
      MesSafetyClassConfig classConfig = this.baseMapper.selectById(classConfigId);
      Preconditions.checkArgument(classConfig != null, "安环分类不存在");
      this.baseMapper.delete(Wrappers.lambdaQuery(MesSafetyClassConfig.class).eq(MesSafetyClassConfig::getPid, classConfigId));
      this.baseMapper.deleteById(classConfig.getId());
      return Boolean.TRUE;
   }

   @Override
   public Boolean changeState(ChangStatusDTO classConfig) {
      MesSafetyClassConfig config = BeanUtil.copy(classConfig, MesSafetyClassConfig.class);
      return this.updateById(config);
   }

   @Override
   public List<MesSafetyClassConfigTreeDTO> findsSafetyClassConfigTree(Integer type, Integer factoryOrConstructionSite) {
      List<MesSafetyClassConfig> classConfigs = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesSafetyClassConfig.class)
               .eq(factoryOrConstructionSite != null, MesSafetyClassConfig::getFactoryOrConstructionSite, factoryOrConstructionSite)
         );
      List<MesSafetyClassConfig> fatherConfigs;
      if (type != null) {
         fatherConfigs = classConfigs.stream().filter(e -> e.getPid().equals(0L) && e.getType() == type).collect(Collectors.toList());
      } else {
         fatherConfigs = classConfigs.stream().filter(e -> e.getPid().equals(0L)).collect(Collectors.toList());
      }

      Map<Long, List<MesSafetyClassConfig>> childrenMap = classConfigs.stream()
         .filter(e -> !e.getPid().equals(0L))
         .collect(Collectors.groupingBy(MesSafetyClassConfig::getPid));
      return fatherConfigs.stream().map(e -> {
         MesSafetyClassConfigTreeDTO treeDTO = BeanUtil.copy(e, MesSafetyClassConfigTreeDTO.class);
         treeDTO.setChildren(childrenMap.get(e.getId()));
         return treeDTO;
      }).collect(Collectors.toList());
   }
}
