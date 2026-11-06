package com.hzchum.scim.system.core.biz.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.mes.building.core.api.enums.statistica.SpecPrefixEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import com.hzchum.scim.plan.core.api.pojo._do.TechMachinePart;
import com.hzchum.scim.plan.core.api.service.TechMachinePartService;
import com.hzchum.scim.system.core.api.biz.SysSteelClassificationBiz;
import com.hzchum.scim.system.core.api.pojo._do.SysAssembleSpec;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassSpecNameLink;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassification;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassificationMatch;
import com.hzchum.scim.system.core.api.pojo._do.SysSteelClassifyLink;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTO;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationSaveDTOParam;
import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationUpdateDTOParam;
import com.hzchum.scim.system.core.api.service.SysAssembleSpecService;
import com.hzchum.scim.system.core.api.service.SysSteelClassSpecNameLinkService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationMatchService;
import com.hzchum.scim.system.core.api.service.SysSteelClassificationService;
import com.hzchum.scim.system.core.api.service.SysSteelClassifyLinkService;
import com.hzchum.scim.system.core.api.service.SysSteelSectionSpecNameLinkService;
import com.hzchum.scim.wms.core.api.enums.BasicClassEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Classification;
import com.hzchum.scim.wms.core.api.service.wmsConfig.ClassificationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysSteelClassificationBizImpl implements SysSteelClassificationBiz {
   @Resource
   private SysSteelClassificationService steelClassificationService;
   @Resource
   private SysSteelClassificationMatchService steelClassificationMatchService;
   @Resource
   private SysSteelClassifyLinkService sysSteelClassifyLinkService;
   @Resource
   private ClassificationService classificationService;
   @Resource
   private TechMachinePartService machinePartService;
   @Resource
   private SysAssembleSpecService assembleSpecService;
   @Resource
   private MesBuildingProductProcessService productProcessService;
   @Resource
   private SysSteelClassSpecNameLinkService sysSteelClassSpecNameLinkService;
   @Resource
   private SysSteelSectionSpecNameLinkService sysSteelSectionSpecNameLinkService;

   @Override
   public List<SteelClassificationDTO> list(Integer productClassificationEnum, Integer mesProductEnum, String sectionAndNameAndType) {
      List<Long> classificationIds = this.steelClassificationService.listIdsSteel(productClassificationEnum, mesProductEnum, sectionAndNameAndType);
      return CollectionUtils.isEmpty(classificationIds) ? new ArrayList<>() : this.steelClassificationService.listSteel(classificationIds);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean add(SteelClassificationSaveDTOParam param) {
      int count = this.steelClassificationService
         .count(
            (Wrapper<SysSteelClassification>)((Wrappers.<SysSteelClassification>lambdaQuery()
                     .eq(SysSteelClassification::getName, param.getName()))
                  .eq(SysSteelClassification::getProductClassificationEnum, param.getProductClassificationEnum()))
               .eq(SysSteelClassification::getMesProductEnum, param.getMesProductEnum())
         );
      Preconditions.checkArgument(count == 0, "该零件分类名称已存在，请勿重复添加");
      param.getLinks()
         .forEach(
            link -> {
               if (param.getMesProductEnum().equals(MesProductEnum.BUILDING.getType())) {
                  int assembleCount = this.assembleSpecService
                     .count(Wrappers.lambdaQuery(SysAssembleSpec.class).eq(SysAssembleSpec::getSpecPrefix, link.getKeyword()));
                  Preconditions.checkArgument(assembleCount == 0, "新增失败,零件前缀类型[" + link.getKeyword() + "]已配置在部件定义中!");
               }

               if (param.getProductClassificationEnum().equals(ProductClassificationEnum.SECTION_PRODUCT.getType())) {
                  Preconditions.checkArgument(!SpecPrefixEnum.isExist(link.getKeyword()), "成品型材规格前缀类型不能设置为PL");
               }
            }
         );
      SysSteelClassification steelClassification = BeanUtil.copy(param, SysSteelClassification.class);
      steelClassification.setBasicClass(
         param.getProductClassificationEnum().equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())
            ? BasicClassEnum.STEEL_PLATE.getType()
            : BasicClassEnum.SECTION_STEEL.getType()
      );
      if (steelClassification.getProductClassificationEnum().equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())) {
         steelClassification.setSteelPlateTypeEnum(SteelPlateTypeEnum.PRIMARY_MEMBER.getType());
         if (steelClassification.getName().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getName())) {
            steelClassification.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
         }
      }

      if (steelClassification.getProductClassificationEnum().equals(ProductClassificationEnum.SECTION_PRODUCT.getType())) {
         steelClassification.setSteelPlateTypeEnum(SteelPlateTypeEnum.SECTIONSTEEL.getType());
      }

      this.steelClassificationService.save(steelClassification);
      this.saveSteelSpec(steelClassification, param.getLinks(), param.getSteelClassNamePrefixDTOParams());
      return true;
   }

   private void saveSteelClassifyLink(SysSteelClassification steelClassification, List<Long> classifyIds) {
      this.sysSteelClassifyLinkService.removeBySteelId(steelClassification.getId());
      classifyIds.forEach(
         classifyId -> {
            Classification classification = this.classificationService.getById(classifyId);
            Preconditions.checkArgument(classification != null, "关联科目不存在");
            if (steelClassification.getProductClassificationEnum().equals(ProductClassificationEnum.STEEL_PLATE_PRODUCT.getType())) {
               Preconditions.checkArgument(BasicClassEnum.STEEL_PLATE.getType().equals(classification.getBasicClass()), "操作失败,钢板只能添加钢板类科目!");
            }

            if (steelClassification.getProductClassificationEnum().equals(ProductClassificationEnum.SECTION_PRODUCT.getType())) {
               Preconditions.checkArgument(BasicClassEnum.SECTION_STEEL.getType().equals(classification.getBasicClass()), "操作失败,型材只能添加型材类科目!");
            }

            SysSteelClassifyLink link = SysSteelClassifyLink.builder()
               .steelId(steelClassification.getId())
               .classifyId(classifyId)
               .classifyName(classification.getName())
               .path(classification.getPath())
               .build();
            this.sysSteelClassifyLinkService.save(link);
         }
      );
   }

   private void saveSteelSpec(SysSteelClassification steelClassification, List<SteelClassificationMatchDTOParam> links, List<String> matchingNameList) {
      this.steelClassificationMatchService
         .remove((Wrapper<SysSteelClassificationMatch>)Wrappers.<SysSteelClassificationMatch>lambdaQuery().eq(SysSteelClassificationMatch::getSteelId, steelClassification.getId()));
      Map<String, SteelClassificationMatchDTOParam> steelMatchMap = links.stream()
         .filter(Objects::nonNull)
         .peek(s -> s.setKeyword(s.getKeyword().trim().toUpperCase()))
         .collect(Collectors.toMap(SteelClassificationMatchDTOParam::getKeyword, Function.identity(), (s1, s2) -> s2));
      List<SysSteelClassificationMatch> classificationMatchList = new ArrayList<>();
      steelMatchMap.forEach(
         (keyword, link) -> {
            if (steelClassification.getSteelPlateTypeEnum().equals(SteelPlateTypeEnum.SECONDARY_MEMBER.getType())) {
               int count = this.steelClassificationMatchService
                  .count(
                     Wrappers.lambdaQuery(SysSteelClassificationMatch.class)
                        .eq(SysSteelClassificationMatch::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECTIONSTEEL.getType())
                        .eq(SysSteelClassificationMatch::getMesProductEnum, steelClassification.getMesProductEnum())
                        .eq(SysSteelClassificationMatch::getKeyword, keyword)
                  );
               Preconditions.checkArgument(count == 0, "翼腹板规格前缀不可与成品型材一致");
            } else {
               int count = this.steelClassificationMatchService
                  .count(
                     Wrappers.lambdaQuery(SysSteelClassificationMatch.class)
                        .ne(SysSteelClassificationMatch::getSteelPlateTypeEnum, SteelPlateTypeEnum.SECONDARY_MEMBER.getType())
                        .eq(SysSteelClassificationMatch::getMesProductEnum, steelClassification.getMesProductEnum())
                        .eq(SysSteelClassificationMatch::getKeyword, keyword)
                  );
               Preconditions.checkArgument(count == 0, "零件规格前缀类型已存在");
            }

            SysSteelClassificationMatch match = SysSteelClassificationMatch.builder()
               .steelId(steelClassification.getId())
               .keyword(keyword)
               .steelPlateTypeEnum(steelClassification.getSteelPlateTypeEnum())
               .specIndex(link.getSpecIndex())
               .mesProductEnum(steelClassification.getMesProductEnum())
               .build();
            classificationMatchList.add(match);
         }
      );
      this.steelClassificationMatchService.saveBatch(classificationMatchList);
      this.sysSteelClassSpecNameLinkService
         .remove((Wrapper<SysSteelClassSpecNameLink>)Wrappers.<SysSteelClassSpecNameLink>lambdaQuery().eq(SysSteelClassSpecNameLink::getSteelId, steelClassification.getId()));
      if (SteelPlateTypeEnum.SECONDARY_MEMBER.getName().equals(steelClassification.getName())) {
         ArrayList<SysSteelClassSpecNameLink> steelClassSpecNameLinks = new ArrayList<>();
         Preconditions.checkArgument(CollectionUtils.isNotEmpty(matchingNameList), "翼腹板的匹配名称不可为空!!!");
         classificationMatchList.forEach(
            classificationMatch -> matchingNameList.forEach(
               matchingName -> {
                  SysSteelClassSpecNameLink link = SysSteelClassSpecNameLink.builder()
                     .steelId(steelClassification.getId())
                     .specPrefix(classificationMatch.getKeyword())
                     .matchingName(matchingName)
                     .mesProductEnum(steelClassification.getMesProductEnum())
                     .build();
                  steelClassSpecNameLinks.add(link);
               }
            )
         );
         this.sysSteelClassSpecNameLinkService.saveBatch(steelClassSpecNameLinks);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean update(SteelClassificationUpdateDTOParam param) {
      SysSteelClassification steel = this.steelClassificationService.getById(param.getId());
      Preconditions.checkArgument(steel != null, "零件配置不存在");
      Preconditions.checkArgument(param.getMesProductEnum().equals(steel.getMesProductEnum()), "操作失败,mes产品类型不可修改!");
      if (!steel.getName().equals(param.getName())) {
         SysSteelClassification check = this.steelClassificationService
            .getOne(
               (Wrapper<SysSteelClassification>)((Wrappers.<SysSteelClassification>lambdaQuery()
                        .eq(SysSteelClassification::getName, param.getName()))
                     .eq(SysSteelClassification::getProductClassificationEnum, param.getProductClassificationEnum()))
                  .eq(SysSteelClassification::getMesProductEnum, param.getMesProductEnum())
            );
         Preconditions.checkArgument(check == null, "该零件分类已存在，请勿重复添加");
      }

      Map<String, SysSteelClassificationMatch> oldMap = this.steelClassificationMatchService
         .list(Wrappers.lambdaQuery(SysSteelClassificationMatch.class).eq(SysSteelClassificationMatch::getSteelId, param.getId()))
         .stream()
         .collect(Collectors.toMap(SysSteelClassificationMatch::getKeyword, Function.identity()));
      Map<String, SteelClassificationMatchDTOParam> newMap = param.getLinks()
         .stream()
         .peek(s -> s.setKeyword(s.getKeyword().trim().toUpperCase()))
         .collect(Collectors.toMap(SteelClassificationMatchDTOParam::getKeyword, Function.identity(), (s1, s2) -> s2));
      int processCount = this.productProcessService
         .count(Wrappers.lambdaQuery(MesBuildingProductProcess.builder().productType(ProductTypeEnum.MACHINE_PART.getType()).typeId(param.getId()).build()));
      oldMap.forEach(
         (keyword, matchDto) -> {
            Preconditions.checkArgument(
               processCount == 0 || newMap.containsKey(keyword) && newMap.get(keyword).getSpecIndex().equals(matchDto.getSpecIndex()), "修改失败,零件类型已配置工序"
            );
            if (!newMap.containsKey(keyword)) {
               Preconditions.checkArgument(this.machinePartService.getOneByPrefix(param.getId(), keyword) == null, "修改失败,零件规格前缀正在使用");
            }
         }
      );
      newMap.forEach(
         (keyword, matchDto) -> {
            if (!oldMap.containsKey(keyword)) {
               Preconditions.checkArgument(
                  this.steelClassificationMatchService
                        .count(
                           Wrappers.lambdaQuery(SysSteelClassificationMatch.class)
                              .eq(SysSteelClassificationMatch::getKeyword, keyword)
                              .eq(SysSteelClassificationMatch::getMesProductEnum, param.getMesProductEnum())
                        )
                     == 0,
                  "修改失败,零件规格前缀已配置"
               );
            }
         }
      );
      BeanUtil.copy(param, steel);
      this.steelClassificationService.updateById(steel);
      this.saveSteelSpec(steel, param.getLinks(), param.getSteelClassNamePrefixDTOParams());
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean delete(List<Long> ids) {
      ids.forEach(
         id -> {
            SysSteelClassification steel = this.steelClassificationService.getById(id);
            Preconditions.checkArgument(steel != null, "删除失败，钢材分类不存在");
            int processCount = this.productProcessService
               .count(Wrappers.lambdaQuery(MesBuildingProductProcess.builder().productType(ProductTypeEnum.MACHINE_PART.getType()).typeId(id).build()));
            Preconditions.checkArgument(processCount == 0, "删除失败,已配置工序!");
            Preconditions.checkArgument(this.machinePartService.getOneByPrefix(id, null) == null, "删除失败,零件类型已导入清单!");
            this.steelClassificationService.removeById(id);
            this.steelClassificationMatchService
               .remove((Wrapper<SysSteelClassificationMatch>)Wrappers.<SysSteelClassificationMatch>lambdaQuery().eq(SysSteelClassificationMatch::getSteelId, id));
            this.sysSteelClassifyLinkService.removeBySteelId(steel.getId());
            this.sysSteelClassSpecNameLinkService
               .remove((Wrapper<SysSteelClassSpecNameLink>)Wrappers.<SysSteelClassSpecNameLink>lambdaQuery().eq(SysSteelClassSpecNameLink::getSteelId, steel.getId()));
         }
      );
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void setPartSteelInfo(TechMachinePart machinePart) {
      SteelClassificationMatchDTO steelInfo = this.getSteelInfo(machinePart.getSpecification());
      if (steelInfo != null) {
         machinePart.setSteelId(steelInfo.getSteelId());
         machinePart.setSteelSpec(steelInfo.getSpec());
      }
   }

   @Override
   public SteelClassificationMatchDTO getSteelInfo(String spec) {
      char[] chars = spec.toCharArray();
      int startNumberIndex = -1;

      for (int i = 0; i < chars.length; i++) {
         if (Character.isDigit(chars[i])) {
            startNumberIndex = i;
            break;
         }
      }

      if (startNumberIndex == -1) {
         return null;
      }

      String keyword = spec.substring(0, startNumberIndex);
      SysSteelClassificationMatch match = this.steelClassificationMatchService
         .getOne((Wrapper<SysSteelClassificationMatch>)Wrappers.<SysSteelClassificationMatch>lambdaQuery().eq(SysSteelClassificationMatch::getKeyword, keyword));
      if (match != null) {
         String thickness = this.getThicknessBySpec(match.getSpecIndex(), spec.substring(startNumberIndex));
         if (StringUtils.isNotBlank(thickness)) {
            SteelClassificationMatchDTO matchDTO = new SteelClassificationMatchDTO();
            matchDTO.setSteelId(match.getSteelId());
            matchDTO.setSpec(thickness);
            return matchDTO;
         }
      }

      return null;
   }

   @Override
   public Integer getBasicClass(String steelId) {
      return this.steelClassificationService.getById(steelId).getBasicClass();
   }

   private String getThicknessBySpec(Integer specIndex, String spec) {
      if (specIndex == 0) {
         return spec;
      }

      String[] specArray = spec.split("\\*");
      return specIndex > specArray.length ? "" : specArray[specIndex - 1];
   }
}
