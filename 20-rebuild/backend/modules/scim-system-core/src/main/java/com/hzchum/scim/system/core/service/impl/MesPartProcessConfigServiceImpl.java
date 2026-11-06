package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.system.core.api.pojo._do.MesPartProcessConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesPartProcessConfigLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesPartProcessConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesPartProcessConfigLinkDTO;
import com.hzchum.scim.system.core.api.service.MesPartProcessConfigLinkService;
import com.hzchum.scim.system.core.api.service.MesPartProcessConfigService;
import com.hzchum.scim.system.core.mapper.MesPartProcessConfigMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesPartProcessConfigServiceImpl extends ServiceImpl<MesPartProcessConfigMapper, MesPartProcessConfig> implements MesPartProcessConfigService {
   @Resource
   MesPartProcessConfigLinkService configLinkService;

   @Override
   public List<MesPartProcessConfigDTO> listInfo() {
      return this.baseMapper.listInfo();
   }

   @Override
   public MesPartProcessConfigDTO detailById(Long id) {
      MesPartProcessConfig processConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(processConfig != null, "零件配置信息不存在");
      List<MesPartProcessConfigLinkDTO> list = this.configLinkService
         .list(Wrappers.lambdaQuery(MesPartProcessConfigLink.class).eq(MesPartProcessConfigLink::getProcessConfigId, processConfig.getId()))
         .stream()
         .map(s -> BeanUtil.copy(s, MesPartProcessConfigLinkDTO.class))
         .collect(Collectors.toList());
      MesPartProcessConfigDTO dto = BeanUtil.copy(processConfig, MesPartProcessConfigDTO.class);
      dto.setProcessConfigLinkList(list);
      return dto;
   }

   @Transactional
   @Override
   public Boolean savePartProcessConfig(MesPartProcessConfigDTO param) {
      List<MesPartProcessConfig> list = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesPartProcessConfig.class)
               .eq(MesPartProcessConfig::getProductCategoryType, param.getProductCategoryType())
               .eq(MesPartProcessConfig::getPartProdMode, param.getPartProdMode())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(list), "配置已存在，请检查");
      MesPartProcessConfig processConfig = BeanUtil.copy(param, MesPartProcessConfig.class);
      this.baseMapper.insert(processConfig);
      List<MesPartProcessConfigLink> links = param.getProcessConfigLinkList()
         .stream()
         .map(s -> BeanUtil.copy(s, MesPartProcessConfigLink.class))
         .collect(Collectors.toList());
      this.configLinkService.saveBatch(links);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updatePartProcessConfig(MesPartProcessConfigDTO param) {
      MesPartProcessConfig list = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(list != null, "配置不存在");
      MesPartProcessConfig processConfig = BeanUtil.copy(param, MesPartProcessConfig.class);
      this.baseMapper.updateById(processConfig);
      List<MesPartProcessConfigLink> links = param.getProcessConfigLinkList()
         .stream()
         .map(s -> BeanUtil.copy(s, MesPartProcessConfigLink.class))
         .collect(Collectors.toList());
      List<MesPartProcessConfigLink> oldLinks = this.configLinkService
         .list(Wrappers.lambdaQuery(MesPartProcessConfigLink.class).eq(MesPartProcessConfigLink::getProcessConfigId, param.getId()));
      List<Long> delIdsList = oldLinks.stream().filter(s -> !links.contains(s)).map(MesPartProcessConfigLink::getId).collect(Collectors.toList());
      List<MesPartProcessConfigLink> addList = links.stream().filter(s -> !oldLinks.contains(s)).collect(Collectors.toList());
      this.configLinkService.saveBatch(addList);
      this.configLinkService.removeByIds(delIdsList);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean deleteById(Long id) {
      this.baseMapper.deleteById(id);
      this.configLinkService.remove(Wrappers.lambdaQuery(MesPartProcessConfigLink.class).eq(MesPartProcessConfigLink::getProcessConfigId, id));
      return Boolean.TRUE;
   }
}
