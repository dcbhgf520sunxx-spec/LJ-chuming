package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.biz.ProductClassificationConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSerialNumberPrefix;
import com.hzchum.scim.system.core.api.pojo._do.SysStructureSpec;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.SysStructureClassificationService;
import com.hzchum.scim.system.core.api.service.SysStructureSerialNumberPrefixService;
import com.hzchum.scim.system.core.api.service.SysStructureSpecService;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductClassificationConfigBizImpl implements ProductClassificationConfigBiz {
   private static final Logger log = LoggerFactory.getLogger(ProductClassificationConfigBizImpl.class);
   @Resource
   private SysAssembleSpecService assembleSpecService;
   @Resource
   private SysStructureClassificationService structureClassificationService;
   @Resource
   private SysStructureSpecService structureSpecService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private TechArtifactService artifactService;
   @Resource
   private SysSteelClassificationMatchService steelClassificationMatchService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private SysStructureSerialNumberPrefixService serialNumberSpecPrefixService;

   @Override
   public Long getProductConfigId(Long productId, Integer productType) {
      if (ProductTypeEnum.ARTIFACT.getType().equals(productType)) {
         TechArtifact artifact = this.artifactService.getById(productId);
         Preconditions.checkArgument(artifact != null, "构件不存在");
         List<SysStructureSerialNumberPrefix> serialNumberSpecPrefixList = this.serialNumberSpecPrefixService
            .list(
               (Wrapper<SysStructureSerialNumberPrefix>)Wrappers.<SysStructureSerialNumberPrefix>lambdaQuery()
                  .eq(SysStructureSerialNumberPrefix::getSerialNumberPrefix, artifact.getSerialNumberPrefix())
            );
         List<SysStructureSpec> structureSpecList = this.structureSpecService
            .list(
               Wrappers.lambdaQuery(SysStructureSpec.class)
                  .in(
                     CollectionUtils.isNotEmpty(serialNumberSpecPrefixList),
                     SysStructureSpec::getStructureClassificationId,
                     serialNumberSpecPrefixList.stream().map(SysStructureSerialNumberPrefix::getStructureClassificationId).collect(Collectors.toList())
                  )
                  .eq(SysStructureSpec::getSpecPrefix, artifact.getSpecPrefix())
            );
         return Objects.requireNonNull(structureSpecList.stream().collect(Collectors.toList()).stream().findFirst().orElse(null))
            .getStructureClassificationId();
      } else if (ProductTypeEnum.ASSEMBLE.getType().equals(productType)) {
         TechAssemble assemble = this.assembleService.getById(productId);
         Preconditions.checkArgument(assemble != null, "组立不存在");
         SysAssembleSpec assembleSpec = this.assembleSpecService
            .getOne(Wrappers.lambdaQuery(SysAssembleSpec.class).eq(SysAssembleSpec::getSpecPrefix, assemble.getSpecPrefix()));
         return assembleSpec.getAssembleConfigId();
      } else if (ProductTypeEnum.MACHINE_PART.getType().equals(productType)) {
         TechMachinePart machinePart = this.machinePartService.getById(productId);
         Preconditions.checkArgument(machinePart != null, "零件不存在");
         SysSteelClassificationMatch classificationMatch = this.steelClassificationMatchService
            .getOne(Wrappers.lambdaQuery(SysSteelClassificationMatch.class).eq(SysSteelClassificationMatch::getKeyword, machinePart.getSpecPrefix()));
         return classificationMatch.getSteelId();
      } else {
         return null;
      }
   }
}
