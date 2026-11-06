package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.system.core.api.biz.TemplatePanelAssemblyConfigBiz;
import com.hzchum.scim.system.core.api.common.enums.ArtifactTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.pojo._do.TemplatePanelAssemblyConfig;
import com.hzchum.scim.system.core.api.pojo.dto.TemplatePanelAssemblyConfigDTO;
import com.hzchum.scim.system.core.api.pojo.vo.TemplatePanelAssemblyConfigVO;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import com.hzchum.scim.system.core.api.service.TemplatePanelAssemblyConfigService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TemplatePanelAssemblyConfigBizImpl implements TemplatePanelAssemblyConfigBiz {
   @Resource
   private SysStructureSpecService sysStructureSpecService;
   @Resource
   private SysStructureClassificationService classificationService;
   @Resource
   private TemplatePanelAssemblyConfigService panelAssemblyConfigService;

   @Override
   public List<TemplatePanelAssemblyConfigDTO> listAssemblyTemplateConfigs() {
      List<SysStructureSpec> structureSpecs = this.sysStructureSpecService
         .list(
            (Wrapper<SysStructureSpec>)((new LambdaQueryWrapper<SysStructureSpec>().in(SysStructureSpec::getSpecPrefix, "BH", "BOX"))
                  .eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType()))
               .eq(SysStructureSpec::getMesProductEnum, MesProductEnum.BUILDING.getType())
         );
      if (CollectionUtils.isEmpty(structureSpecs)) {
         return new ArrayList<>();
      }

      List<Long> structureClassificationIds = structureSpecs.stream()
         .map(SysStructureSpec::getStructureClassificationId)
         .distinct()
         .collect(Collectors.toList());
      List<SysStructureClassification> structureClassifications = this.classificationService.listByIds(structureClassificationIds);
      Map<Long, TemplatePanelAssemblyConfig> assemblyConfigMap = this.panelAssemblyConfigService
         .list(
            (Wrapper<TemplatePanelAssemblyConfig>)new LambdaQueryWrapper<TemplatePanelAssemblyConfig>()
               .in(TemplatePanelAssemblyConfig::getStructureClassificationId, structureClassificationIds)
         )
         .stream()
         .collect(Collectors.toMap(TemplatePanelAssemblyConfig::getStructureClassificationId, Function.identity()));
      return structureClassifications.stream()
         .map(
            structureClass -> {
               TemplatePanelAssemblyConfigDTO build = TemplatePanelAssemblyConfigDTO.builder()
                  .structureClassificationId(structureClass.getId())
                  .artifactType(structureClass.getArtifactType())
                  .structureClassificationName(structureClass.getClassificationName())
                  .build();
               TemplatePanelAssemblyConfig panelAssemblyConfig = assemblyConfigMap.get(structureClass.getId());
               if (panelAssemblyConfig != null) {
                  build.setArtifactPartNumberPrefixList(
                     StringUtils.isBlank(panelAssemblyConfig.getArtifactPartNumberPrefix())
                        ? null
                        : Arrays.stream(panelAssemblyConfig.getArtifactPartNumberPrefix().split(",")).collect(Collectors.toList())
                  );
                  build.setWebPartNumberPrefixList(
                     StringUtils.isBlank(panelAssemblyConfig.getWebPartNumberPrefix())
                        ? null
                        : Arrays.stream(panelAssemblyConfig.getWebPartNumberPrefix().split(",")).collect(Collectors.toList())
                  );
                  build.setSailPartNumberPrefixList(
                     StringUtils.isBlank(panelAssemblyConfig.getSailPartNumberPrefix())
                        ? null
                        : Arrays.stream(panelAssemblyConfig.getSailPartNumberPrefix().split(",")).collect(Collectors.toList())
                  );
                  build.setId(panelAssemblyConfig.getId());
               }

               return build;
            }
         )
         .collect(Collectors.toList());
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateAssemblyTemplateConfigs(List<TemplatePanelAssemblyConfigVO> panelAssemblyConfigVOS) {
      List<SysStructureSpec> sysStructureSpecs = this.sysStructureSpecService
         .list(
            (Wrapper<SysStructureSpec>)((new LambdaQueryWrapper<SysStructureSpec>()
                     .in(
                        SysStructureSpec::getStructureClassificationId,
                        panelAssemblyConfigVOS.stream().map(TemplatePanelAssemblyConfigVO::getStructureClassificationId).collect(Collectors.toList())
                     ))
                  .in(SysStructureSpec::getSpecPrefix, "BH", "BOX"))
               .eq(SysStructureSpec::getArtifactType, ArtifactTypeEnum.COMMON.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(sysStructureSpecs), "操作失败,构件特征定义列表不存在!");
      List<Long> structureClassificationIds = sysStructureSpecs.stream()
         .map(SysStructureSpec::getStructureClassificationId)
         .distinct()
         .collect(Collectors.toList());
      Preconditions.checkArgument(sysStructureSpecs.size() == structureClassificationIds.size() && sysStructureSpecs.size() <= 2, "操作失败,构件特征定义列表不存在!");
      Map<Long, TemplatePanelAssemblyConfig> assemblyConfigMap = this.panelAssemblyConfigService
         .list()
         .stream()
         .collect(Collectors.toMap(TemplatePanelAssemblyConfig::getStructureClassificationId, Function.identity()));

      for (TemplatePanelAssemblyConfigVO assemblyConfigVO : panelAssemblyConfigVOS) {
         TemplatePanelAssemblyConfig templatePanelAssemblyConfig = assemblyConfigMap.get(assemblyConfigVO.getStructureClassificationId());
         if (templatePanelAssemblyConfig != null) {
            templatePanelAssemblyConfig.setArtifactPartNumberPrefix(
               CollectionUtils.isEmpty(assemblyConfigVO.getArtifactPartNumberPrefixList())
                  ? null
                  : String.join(",", assemblyConfigVO.getArtifactPartNumberPrefixList())
            );
            templatePanelAssemblyConfig.setWebPartNumberPrefix(
               CollectionUtils.isEmpty(assemblyConfigVO.getWebPartNumberPrefixList()) ? null : String.join(",", assemblyConfigVO.getWebPartNumberPrefixList())
            );
            templatePanelAssemblyConfig.setSailPartNumberPrefix(
               CollectionUtils.isEmpty(assemblyConfigVO.getSailPartNumberPrefixList())
                  ? null
                  : String.join(",", assemblyConfigVO.getSailPartNumberPrefixList())
            );
            this.panelAssemblyConfigService.updateById(templatePanelAssemblyConfig);
         } else {
            TemplatePanelAssemblyConfig assemblyConfig = TemplatePanelAssemblyConfig.builder()
               .structureClassificationId(assemblyConfigVO.getStructureClassificationId())
               .artifactPartNumberPrefix(
                  CollectionUtils.isEmpty(assemblyConfigVO.getArtifactPartNumberPrefixList())
                     ? null
                     : String.join(",", assemblyConfigVO.getArtifactPartNumberPrefixList())
               )
               .webPartNumberPrefix(
                  CollectionUtils.isEmpty(assemblyConfigVO.getWebPartNumberPrefixList())
                     ? null
                     : String.join(",", assemblyConfigVO.getWebPartNumberPrefixList())
               )
               .sailPartNumberPrefix(
                  CollectionUtils.isEmpty(assemblyConfigVO.getSailPartNumberPrefixList())
                     ? null
                     : String.join(",", assemblyConfigVO.getSailPartNumberPrefixList())
               )
               .build();
            this.panelAssemblyConfigService.save(assemblyConfig);
         }
      }

      return Boolean.TRUE;
   }
}
