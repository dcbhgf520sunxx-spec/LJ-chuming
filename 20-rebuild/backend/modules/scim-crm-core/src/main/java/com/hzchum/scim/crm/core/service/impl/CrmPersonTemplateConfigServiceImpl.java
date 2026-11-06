package com.hzchum.scim.crm.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.crm.core.api.enums.CrmPersonTemplateEnum;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPersonTemplateConfig;
import com.hzchum.scim.crm.core.api.pojo._do.CrmPersonTemplateUserLink;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPersonTemplateConfigDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmPersonTemplateConfigDetailDTO;
import com.hzchum.scim.crm.core.api.pojo.dto.CrmUserSimpleInfoDTO;
import com.hzchum.scim.crm.core.api.pojo.param.udpate.CrmPersonTemplateConfigUpdateParam;
import com.hzchum.scim.crm.core.api.service.CrmPersonTemplateConfigService;
import com.hzchum.scim.crm.core.api.service.CrmPersonTemplateUserLinkService;
import com.hzchum.scim.crm.core.mapper.CrmPersonTemplateConfigMapper;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrmPersonTemplateConfigServiceImpl
   extends ServiceImpl<CrmPersonTemplateConfigMapper, CrmPersonTemplateConfig>
   implements CrmPersonTemplateConfigService {
   @Resource
   private CrmPersonTemplateUserLinkService crmPersonTemplateUserLinkService;
   @Resource
   private UserService userService;

   @Override
   public List<CrmPersonTemplateConfigDTO> getTemplateList() {
      CrmPersonTemplateEnum[] values = CrmPersonTemplateEnum.values();
      List<CrmPersonTemplateConfigDTO> crmPersonTemplateConfigDTOS = new ArrayList<>();

      for (CrmPersonTemplateEnum value : values) {
         CrmPersonTemplateConfigDTO crmPersonTemplateConfigDTO = CrmPersonTemplateConfigDTO.builder().crmPersonTemplateEnum(value.getType()).build();
         List<CrmPersonTemplateUserLink> crmPersonTemplateUserLinks = this.crmPersonTemplateUserLinkService
            .list(Wrappers.lambdaQuery(CrmPersonTemplateUserLink.class).eq(CrmPersonTemplateUserLink::getCrmPersonTemplateEnum, value.getType()));
         crmPersonTemplateConfigDTO.setPersonCount(CollectionUtils.isEmpty(crmPersonTemplateUserLinks) ? 0 : crmPersonTemplateUserLinks.size());
         crmPersonTemplateConfigDTOS.add(crmPersonTemplateConfigDTO);
      }

      return crmPersonTemplateConfigDTOS;
   }

   @Override
   public CrmPersonTemplateConfigDetailDTO getTemplateDetail(Integer crmPersonTemplateEnum) {
      CrmPersonTemplateConfig personTemplateConfig = this.getOne(
         Wrappers.lambdaQuery(CrmPersonTemplateConfig.class).eq(CrmPersonTemplateConfig::getCrmPersonTemplateEnum, crmPersonTemplateEnum)
      );
      Preconditions.checkArgument(personTemplateConfig != null, "人员模板配置不存在!");
      CrmPersonTemplateConfigDetailDTO detailDTO = CrmPersonTemplateConfigDetailDTO.builder()
         .crmPersonTemplateEnum(personTemplateConfig.getCrmPersonTemplateEnum())
         .crmPersonOperateTypeEnum(personTemplateConfig.getCrmPersonOperateTypeEnum())
         .build();
      List<CrmPersonTemplateUserLink> crmPersonTemplateUserLinks = this.crmPersonTemplateUserLinkService
         .list(Wrappers.lambdaQuery(CrmPersonTemplateUserLink.class).eq(CrmPersonTemplateUserLink::getCrmPersonTemplateEnum, crmPersonTemplateEnum));
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      if (CollectionUtils.isNotEmpty(crmPersonTemplateUserLinks)) {
         List<CrmUserSimpleInfoDTO> crmUserSimpleInfoDTOS = new ArrayList<>();
         crmPersonTemplateUserLinks.forEach(item -> {
            CrmUserSimpleInfoDTO crmUserSimpleInfoDTO = new CrmUserSimpleInfoDTO();
            crmUserSimpleInfoDTO.setUserId(item.getUserId());
            crmUserSimpleInfoDTO.setUserName(userMap.get(item.getUserId()).getName());
            crmUserSimpleInfoDTOS.add(crmUserSimpleInfoDTO);
         });
         detailDTO.setUserSimpleInfoDTOS(crmUserSimpleInfoDTOS);
      }

      return detailDTO;
   }

   @Transactional
   @Override
   public Boolean deleteTemplate(Integer crmPersonTemplateEnum) {
      this.remove(Wrappers.lambdaQuery(CrmPersonTemplateConfig.class).eq(CrmPersonTemplateConfig::getCrmPersonTemplateEnum, crmPersonTemplateEnum));
      this.crmPersonTemplateUserLinkService
         .remove(Wrappers.lambdaQuery(CrmPersonTemplateUserLink.class).eq(CrmPersonTemplateUserLink::getCrmPersonTemplateEnum, crmPersonTemplateEnum));
      return Boolean.TRUE;
   }

   @Transactional
   @Override
   public Boolean updateTemplate(CrmPersonTemplateConfigUpdateParam updateParam) {
      Preconditions.checkArgument(updateParam != null, "请配置模板!");
      Preconditions.checkArgument(updateParam.getCrmPersonTemplateEnum() != null, "请选择类型");
      Preconditions.checkArgument(updateParam.getCrmPersonOperateTypeEnum() != null, "请选择操作方式");
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(updateParam.getUserIds()), "请选择人员范围");
      this.remove(
         Wrappers.lambdaQuery(CrmPersonTemplateConfig.class).eq(CrmPersonTemplateConfig::getCrmPersonTemplateEnum, updateParam.getCrmPersonTemplateEnum())
      );
      this.crmPersonTemplateUserLinkService
         .remove(
            Wrappers.lambdaQuery(CrmPersonTemplateUserLink.class)
               .eq(CrmPersonTemplateUserLink::getCrmPersonTemplateEnum, updateParam.getCrmPersonTemplateEnum())
         );
      CrmPersonTemplateConfig templateConfig = CrmPersonTemplateConfig.builder()
         .crmPersonOperateTypeEnum(updateParam.getCrmPersonOperateTypeEnum())
         .crmPersonTemplateEnum(updateParam.getCrmPersonTemplateEnum())
         .build();
      this.save(templateConfig);
      updateParam.getUserIds()
         .forEach(
            item -> this.crmPersonTemplateUserLinkService
               .save(
                  CrmPersonTemplateUserLink.builder()
                     .crmPersonTemplateConfigId(templateConfig.getId())
                     .userId(item)
                     .crmPersonTemplateEnum(updateParam.getCrmPersonTemplateEnum())
                     .build()
               )
         );
      return Boolean.TRUE;
   }
}
