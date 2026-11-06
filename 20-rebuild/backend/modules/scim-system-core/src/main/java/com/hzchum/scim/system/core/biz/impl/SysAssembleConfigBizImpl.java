package com.hzchum.scim.system.core.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.service.TechAssembleService;
import com.hzchum.scim.system.core.api.biz.SysAssembleConfigBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLink;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleClassifyLinkChange;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfig;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleConfigChange;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpecChange;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleBasicConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleConfigDTO;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.AssembleConfigUpdateDTOParam;
import com.hzchum.scim.system.core.api.service.SysAssembleClassifyLinkChangeService;
import com.hzchum.scim.system.core.api.service.SysAssembleClassifyLinkService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigChangeService;
import com.hzchum.scim.system.core.api.service.SysAssembleConfigService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecChangeService;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysAssembleConfigBizImpl implements SysAssembleConfigBiz {
   private static final Logger log = LoggerFactory.getLogger(SysAssembleConfigBizImpl.class);
   @Resource
   private SysAssembleConfigService assembleConfigService;
   @Resource
   private SysAssembleSpecService assembleSpecService;
   @Resource
   private TechAssembleService assembleService;
   @Resource
   private SysSteelClassificationMatchService steelClassificationMatchService;
   @Resource
   private SysAssembleClassifyLinkService sysAssembleClassifyLinkService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private UserService userService;
   @Resource
   private SysAssembleConfigChangeService assembleConfigChangeService;
   @Resource
   private SysAssembleSpecChangeService assembleSpecChangeService;
   @Resource
   private SysAssembleClassifyLinkChangeService assembleClassifyLinkChangeService;

   @Override
   public PageVO<AssembleConfigDTO> listPage(
      Boolean boolSectionSteel,
      Integer productionLineType,
      String name,
      String specPrefix,
      Integer mesProductEnum,
      String sectionAndNameAndType,
      Integer pageNumber,
      Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<AssembleConfigDTO> configDTOList = this.assembleConfigService
         .listByCondition(boolSectionSteel, productionLineType, name, specPrefix, mesProductEnum, sectionAndNameAndType);
      configDTOList.forEach(s -> {
         s.setAssembleSpecList(this.assembleSpecService.listByCondition(s.getId(), null, mesProductEnum));
         s.setClassifyLinks(this.sysAssembleClassifyLinkService.listByCondition(s.getId()));
      });
      this.setChangeInfo(configDTOList);
      return new PageVO<>(configDTOList);
   }

   @Override
   public List<AssembleConfigDTO> listAll(Integer mesProductEnum) {
      List<AssembleConfigDTO> configDTOList = this.assembleConfigService.listByCondition(null, null, null, null, mesProductEnum, null);
      configDTOList.forEach(dto -> dto.setAssembleSpecList(this.assembleSpecService.listByCondition(dto.getId(), null, mesProductEnum)));
      return configDTOList;
   }

   @Override
   public List<AssembleBasicConfigDTO> listWeldingAll(Integer mesProductEnum) {
      List<String> weldProductTypeList = Arrays.asList("焊接H型部件,焊接箱型部件,焊接十字部件,焊接T型部件".split(","));
      List<SysAssembleConfig> assembleConfigs = this.assembleConfigService
         .list(
            (Wrapper<SysAssembleConfig>)(new LambdaQueryWrapper<SysAssembleConfig>().eq(SysAssembleConfig::getMesProductEnum, mesProductEnum))
               .in(SysAssembleConfig::getName, weldProductTypeList)
         );
      if (!CollectionUtils.isNotEmpty(assembleConfigs)) {
         return new ArrayList<>();
      }

      Map<Long, List<SysAssembleSpec>> assembleSpecMap = this.assembleSpecService
         .list(
            (Wrapper<SysAssembleSpec>)new LambdaQueryWrapper<SysAssembleSpec>()
               .in(SysAssembleSpec::getAssembleConfigId, assembleConfigs.stream().map(SysAssembleConfig::getId).collect(Collectors.toList()))
         )
         .stream()
         .collect(Collectors.groupingBy(SysAssembleSpec::getAssembleConfigId));
      List<AssembleBasicConfigDTO> assembleBasicConfigDTOS = BeanUtil.copyToList(assembleConfigs, AssembleBasicConfigDTO.class);

      for (AssembleBasicConfigDTO basicDTO : assembleBasicConfigDTOS) {
         List<SysAssembleSpec> assembleSpecs = assembleSpecMap.get(basicDTO.getId());
         basicDTO.setAssembleSpecList(assembleSpecs.stream().map(SysAssembleSpec::getSpecPrefix).collect(Collectors.toList()));
      }

      return assembleBasicConfigDTOS;
   }

   private void setChangeInfo(List<AssembleConfigDTO> configDTOList) {
      Set<Long> changeIds = configDTOList.stream().map(AssembleConfigDTO::getLastChangeId).filter(Objects::nonNull).collect(Collectors.toSet());
      if (!CollUtil.isEmpty(changeIds)) {
         List<SysAssembleConfigChange> acChageList = this.assembleConfigChangeService.listByIds(changeIds);
         if (!CollUtil.isEmpty(acChageList)) {
            Set<Long> auditUserIds = acChageList.stream().map(SysAssembleConfigChange::getAuditUserId).filter(Objects::nonNull).collect(Collectors.toSet());
            Map<Long, String> auditUserMap = MapUtil.newHashMap();
            if (CollUtil.isNotEmpty(auditUserIds)) {
               auditUserMap = this.userService.listByIds(auditUserIds).stream().collect(Collectors.toMap(User::getId, User::getName));
            }

            List<SysAssembleSpecChange> spChangeList = this.assembleSpecChangeService
               .list(Wrappers.lambdaQuery(SysAssembleSpecChange.class).in(SysAssembleSpecChange::getAssembleConfigChangeId, changeIds));
            Map<Long, List<SysAssembleSpecChange>> spChangeMap = MapUtil.newHashMap();
            if (CollUtil.isNotEmpty(spChangeList)) {
               spChangeMap = spChangeList.stream().collect(Collectors.groupingBy(SysAssembleSpecChange::getAssembleConfigChangeId));
            }

            Map<Long, SysAssembleConfigChange> acChangeMap = acChageList.stream()
               .collect(Collectors.toMap(SysAssembleConfigChange::getAssembleConfigId, Function.identity()));

            for (AssembleConfigDTO dto : configDTOList) {
               SysAssembleConfigChange acChange = acChangeMap.get(dto.getId());
               if (acChange != null) {
                  dto.setNewName(acChange.getName());
                  dto.setNewBoolSectionSteel(acChange.getBoolSectionSteel());
                  dto.setNewSort(acChange.getSort());
                  dto.setAuditName(auditUserMap.get(acChange.getAuditUserId()));
                  dto.setAuditStatus(acChange.getAuditStatus());
                  dto.setAuditTime(acChange.getAuditTime());
                  Map<Long, AssembleSpecDTOParam> spMap = dto.getAssembleSpecList()
                     .stream()
                     .collect(Collectors.toMap(AssembleSpecDTOParam::getId, Function.identity()));
                  List<SysAssembleSpecChange> spChanges = spChangeMap.get(acChange.getId());
                  if (CollUtil.isNotEmpty(spChanges)) {
                     List<AssembleSpecDTOParam> spNewDTOList = CollUtil.newArrayList();

                     for (SysAssembleSpecChange spChange : spChanges) {
                        AssembleSpecDTOParam spNewDTO = AssembleSpecDTOParam.builder().build();
                        AssembleSpecDTOParam spOldDTO = spMap.get(spChange.getSpecId());
                        if (spOldDTO != null) {
                           spNewDTO.setId(spOldDTO.getId());
                           spNewDTO.setSpecPrefix(spOldDTO.getSpecPrefix());
                           spNewDTO.setSpecIndex(spOldDTO.getSpecIndex());
                        }

                        spNewDTO.setNewSpecPrefix(spChange.getSpecPrefix());
                        spNewDTO.setNewSpecIndex(spChange.getSpecIndex());
                        spNewDTO.setChangeType(spChange.getChangeType());
                        spNewDTOList.add(spNewDTO);
                     }

                     dto.setNewAssembleSpecList(spNewDTOList);
                  }

                  List<SysAssembleClassifyLinkChange> classifyLinkChangeList = this.assembleClassifyLinkChangeService
                     .list(Wrappers.lambdaQuery(SysAssembleClassifyLinkChange.class).in(SysAssembleClassifyLinkChange::getAssembleConfigChangeId, changeIds));
                  dto.setNewClassifyLinks(BeanUtil.copyToList(classifyLinkChangeList, SteelClassifyLinkDTO.class));
               }
            }
         }
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean add(AssembleConfigSaveDTOParam param) {
      int count = this.assembleConfigService
         .count(
            Wrappers.lambdaQuery(SysAssembleConfig.class)
               .eq(SysAssembleConfig::getName, param.getName())
               .eq(SysAssembleConfig::getMesProductEnum, param.getMesProductEnum())
         );
      Preconditions.checkArgument(count == 0, "新增失败,部件类型名称已存在");
      SysAssembleConfig assembleConfig = com.hzchum.pangu.common.util.BeanUtil.copy(param, SysAssembleConfig.class);
      this.assembleConfigService.save(assembleConfig);
      param.getAssembleSpecList()
         .forEach(
            s -> {
               s.setSpecPrefix(s.getSpecPrefix().toUpperCase());
               this.checkAssembleSpecPrefix(s.getSpecPrefix());
               SysAssembleSpec sysAssembleSpec = this.assembleSpecService
                  .getOne(
                     Wrappers.lambdaQuery(SysAssembleSpec.class)
                        .eq(SysAssembleSpec::getSpecPrefix, s.getSpecPrefix())
                        .eq(SysAssembleSpec::getMesProductEnum, param.getMesProductEnum())
                  );
               Preconditions.checkArgument(sysAssembleSpec == null, "新增失败,部件规格前缀类型已存在");
               if (param.getMesProductEnum().equals(MesProductEnum.BUILDING.getType())) {
                  Preconditions.checkArgument(
                     this.steelClassificationMatchService
                           .count(Wrappers.lambdaQuery(SysSteelClassificationMatch.class).eq(SysSteelClassificationMatch::getKeyword, s.getSpecPrefix()))
                        == 0,
                     "新增失败,规格前缀类型" + s.getSpecPrefix() + "已定义在零件配置中"
                  );
               }

               SysAssembleSpec assembleSpec = com.hzchum.pangu.common.util.BeanUtil.copy(s, SysAssembleSpec.class);
               assembleSpec.setAssembleConfigId(assembleConfig.getId());
               assembleSpec.setBoolSectionSteel(assembleConfig.getBoolSectionSteel());
               assembleSpec.setInventoryTypeEnum(InventoryTypeEnum.getTypeBySpecPrefix(assembleSpec.getSpecPrefix()));
               assembleSpec.setMesProductEnum(param.getMesProductEnum());
               this.assembleSpecService.save(assembleSpec);
            }
         );
      return true;
   }

   private void checkAssembleSpecPrefix(String specPrefix) {
      Preconditions.checkArgument(StringUtils.isNotBlank(specPrefix), "规格前缀不能为空");
      char[] chars = specPrefix.toCharArray();

      for (char c : chars) {
         Preconditions.checkArgument(c >= 'A' && c <= 'Z' || String.valueOf(c).matches("[一-龥 ]"), "规格前缀只可配置大写字母或者汉字");
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateAssembleConfig(AssembleConfigUpdateDTOParam param) {
      SysAssembleConfig assembleConfig = this.assembleConfigService.getById(param.getId());
      Preconditions.checkArgument(assembleConfig != null, "修改失败,数据不存在");
      Preconditions.checkArgument(param.getMesProductEnum().equals(assembleConfig.getMesProductEnum()), "操作失败,不可修改mes分类");
      this.checkUpdate(assembleConfig, param);
      this.assembleSpecService.remove(Wrappers.lambdaQuery(SysAssembleSpec.class).eq(SysAssembleSpec::getAssembleConfigId, param.getId()));
      this.sysAssembleClassifyLinkService
         .remove(Wrappers.lambdaQuery(SysAssembleClassifyLink.class).eq(SysAssembleClassifyLink::getAssembleConfigId, param.getId()));
      com.hzchum.pangu.common.util.BeanUtil.copy(param, assembleConfig);
      this.assembleConfigService.updateById(assembleConfig);
      param.getAssembleSpecList().forEach(specDtoParam -> {
         SysAssembleSpec assembleSpec = com.hzchum.pangu.common.util.BeanUtil.copy(specDtoParam, SysAssembleSpec.class);
         assembleSpec.setAssembleConfigId(param.getId());
         assembleSpec.setBoolSectionSteel(param.getBoolSectionSteel());
         assembleSpec.setInventoryTypeEnum(InventoryTypeEnum.getTypeBySpecPrefix(assembleSpec.getSpecPrefix()));
         assembleSpec.setMesProductEnum(assembleConfig.getMesProductEnum());
         this.assembleSpecService.save(assembleSpec);
      });
      return true;
   }

   @Override
   public void checkUpdate(SysAssembleConfig assembleConfig, AssembleConfigUpdateDTOParam param) {
      int processCount = this.productProcessService
         .count(Wrappers.lambdaQuery(MesBuildingProductProcess.builder().productType(ProductTypeEnum.ASSEMBLE.getType()).typeId(param.getId()).build()));
      Preconditions.checkArgument(processCount == 0 || assembleConfig.getBoolSectionSteel().equals(param.getBoolSectionSteel()), "修改失败,该部件类型已配置工序!");
      TechAssemble assemble = this.assembleService.getOneByPrefix(param.getId(), null);
      Preconditions.checkArgument(assemble == null || param.getBoolSectionSteel().equals(assembleConfig.getBoolSectionSteel()), "修改失败,该部件类型已导入清单!");
      if (!param.getName().equals(assembleConfig.getName())) {
         int count = this.assembleConfigService
            .count(
               Wrappers.lambdaQuery(SysAssembleConfig.class)
                  .eq(SysAssembleConfig::getMesProductEnum, assembleConfig.getMesProductEnum())
                  .eq(SysAssembleConfig::getName, param.getName())
            );
         Preconditions.checkArgument(count == 0, "修改失败,名称已存在");
      }

      Map<String, SysAssembleSpec> oldAssembleSpecMap = this.assembleSpecService
         .list(Wrappers.lambdaQuery(SysAssembleSpec.class).eq(SysAssembleSpec::getAssembleConfigId, param.getId()))
         .stream()
         .collect(Collectors.toMap(SysAssembleSpec::getSpecPrefix, Function.identity(), (specPrefix1, specPrefix2) -> specPrefix2));
      Map<String, AssembleSpecDTOParam> newSpecParamMap = param.getAssembleSpecList()
         .stream()
         .collect(Collectors.toMap(AssembleSpecDTOParam::getSpecPrefix, Function.identity(), (k1, k2) -> k2));
      oldAssembleSpecMap.forEach((specPrefix, assembleSpec) -> {
         Preconditions.checkArgument(processCount == 0 || newSpecParamMap.containsKey(specPrefix), "修改失败,该部件类型已配置工序!");
         if (!newSpecParamMap.containsKey(specPrefix)) {
            TechAssemble oneByPrefix = this.assembleService.getOneByPrefix(param.getId(), specPrefix);
            Preconditions.checkArgument(oneByPrefix == null, "修改失败,部件规格前缀类型(" + specPrefix + ")已导入清单,不能删除");
         }
      });
      newSpecParamMap.forEach(
         (specPrefix, specParam) -> {
            if (!oldAssembleSpecMap.containsKey(specPrefix)) {
               this.checkAssembleSpecPrefix(specPrefix);
               SysAssembleSpec assembleSpec = this.assembleSpecService
                  .getOne(
                     Wrappers.lambdaQuery(SysAssembleSpec.class)
                        .eq(SysAssembleSpec::getSpecPrefix, specPrefix)
                        .eq(SysAssembleSpec::getMesProductEnum, assembleConfig.getMesProductEnum())
                  );
               Preconditions.checkArgument(assembleSpec == null, "修改失败,部件规格前缀类型(" + specPrefix + ")已定义!");
               if (assembleConfig.getMesProductEnum().equals(MesProductEnum.BUILDING.getType())) {
                  int count = this.steelClassificationMatchService
                     .count(Wrappers.lambdaQuery(SysSteelClassificationMatch.class).eq(SysSteelClassificationMatch::getKeyword, specPrefix));
                  Preconditions.checkArgument(count == 0, "修改失败,规格前缀类型(" + specPrefix + ")已配置在零件规格前缀类型中");
               }
            }
         }
      );
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean deleteList(List<Long> ids) {
      ids.forEach(
         id -> {
            SysAssembleConfig assembleConfig = this.assembleConfigService.getById(id);
            Preconditions.checkArgument(assembleConfig != null, "删除失败,数据不存在");
            int processCount = this.productProcessService
               .count(Wrappers.lambdaQuery(MesBuildingProductProcess.builder().productType(ProductTypeEnum.ASSEMBLE.getType()).typeId(id).build()));
            Preconditions.checkArgument(processCount == 0, "删除失败,该部件类型已配置工序!");
            Preconditions.checkArgument(this.assembleService.getOneByPrefix(id, null) == null, "删除失败,改部件类型已导入清单");
            this.assembleSpecService.remove(Wrappers.lambdaQuery(SysAssembleSpec.class).eq(SysAssembleSpec::getAssembleConfigId, id));
            this.sysAssembleClassifyLinkService
               .remove(Wrappers.lambdaQuery(SysAssembleClassifyLink.class).eq(SysAssembleClassifyLink::getAssembleConfigId, id));
            this.assembleConfigService.removeById(id);
         }
      );
      return true;
   }

   private void saveAssembleClassifyLink(Long assembleConfigId, List<Classification> classificationList) {
      classificationList.forEach(
         classification -> {
            SysAssembleClassifyLink link = SysAssembleClassifyLink.builder()
               .assembleConfigId(assembleConfigId)
               .classifyId(classification.getId())
               .classifyName(classification.getName())
               .path(classification.getPath())
               .build();
            this.sysAssembleClassifyLinkService.save(link);
         }
      );
   }
}
