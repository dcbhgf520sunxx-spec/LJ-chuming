package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.plan.core.api.pojo.dto.change.SimpleUser;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolConfig;
import com.hzchum.scim.system.core.api.pojo._do.MesMachineToolUserLink;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesMachineToolConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesMachineToolConfigSaveDTO;
import com.hzchum.scim.system.core.api.service.MesMachineToolConfigService;
import com.hzchum.scim.system.core.api.service.MesMachineToolUserLinkService;
import com.hzchum.scim.system.core.mapper.MesMachineToolConfigMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesMachineToolConfigServiceImpl extends ServiceImpl<MesMachineToolConfigMapper, MesMachineToolConfig> implements MesMachineToolConfigService {
   @Resource
   MesMachineToolUserLinkService toolUserLinkService;

   @Override
   public PageVO<MesMachineToolConfigDTO> findMachineToolConfigList(MesMachineToolConfigDTO toolConfig, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<MesMachineToolConfigDTO> dtos = this.baseMapper.findMachineToolConfigList();
      Map<Long, List<SimpleUser>> userToolLinkMap = this.toolUserLinkService
         .findUserInfoByCondition(null, CollUtil.getFieldValues(dtos, "id", Long.class), null)
         .stream()
         .collect(Collectors.groupingBy(SimpleUser::getMachineToolId));

      for (MesMachineToolConfigDTO dto : dtos) {
         dto.setUser(userToolLinkMap.get(dto.getId()));
      }

      return new PageVO<>(dtos);
   }

   @Transactional
   @Override
   public Boolean saveConfig(MesMachineToolConfigSaveDTO toolConfig) {
      this.checkSameConfig(toolConfig);
      MesMachineToolConfig config = BeanUtil.copy(toolConfig, MesMachineToolConfig.class);
      this.baseMapper.insert(config);
      List<MesMachineToolUserLink> toolUserLinks = new ArrayList<>();
      MesMachineToolUserLink userLink = new MesMachineToolUserLink();
      userLink.setMachineToolId(config.getId());

      for (Long userId : toolConfig.getUser()) {
         userLink.setUserId(userId);
         toolUserLinks.add(userLink);
      }

      Preconditions.checkArgument(CollectionUtils.isNotEmpty(toolUserLinks), "请检查关联生产负责人配置");
      this.toolUserLinkService.saveBatch(toolUserLinks);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateConfigStatus(MesMachineToolConfigSaveDTO toolConfig) {
      this.checkSameConfig(toolConfig);
      MesMachineToolConfig config = BeanUtil.copy(toolConfig, MesMachineToolConfig.class);
      this.baseMapper.updateById(config);
      List<MesMachineToolUserLink> oldUserIdList = this.toolUserLinkService
         .list(Wrappers.lambdaQuery(MesMachineToolUserLink.class).eq(MesMachineToolUserLink::getMachineToolId, toolConfig.getId()));
      List<Long> oldUserIds = oldUserIdList.stream().map(MesMachineToolUserLink::getUserId).collect(Collectors.toList());
      List<Long> delUserlinkList = oldUserIds.stream().filter(e -> !toolConfig.getUser().contains(e)).collect(Collectors.toList());
      List<Long> addUserLinkList = toolConfig.getUser().stream().filter(e -> !oldUserIds.contains(e)).collect(Collectors.toList());
      ArrayList<MesMachineToolUserLink> addLinkList = new ArrayList<>();
      MesMachineToolUserLink userLink = new MesMachineToolUserLink();
      userLink.setMachineToolId(toolConfig.getId());

      for (Long id : addUserLinkList) {
         userLink.setUserId(id);
         addLinkList.add(userLink);
      }

      this.toolUserLinkService.removeByIds(delUserlinkList);
      this.toolUserLinkService.saveBatch(addLinkList);
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean delToolConfig(Long toolConfigId) {
      this.baseMapper.deleteById(toolConfigId);
      this.toolUserLinkService.remove(Wrappers.lambdaQuery(MesMachineToolUserLink.class).eq(MesMachineToolUserLink::getMachineToolId, toolConfigId));
      return Boolean.TRUE;
   }

   public void checkSameConfig(MesMachineToolConfigSaveDTO toolConfig) {
      List<SimpleUser> users = this.toolUserLinkService.findUserInfoByCondition(toolConfig.getPartProcessId(), null, toolConfig.getUser());
      if (CollectionUtils.isNotEmpty(users)) {
         List<String> list = users.stream().map(SimpleUser::getName).collect(Collectors.toList());
         Preconditions.checkArgument(CollectionUtils.isEmpty(users), list.toString() + "负责人此工序无法重复配置");
      }
   }
}
