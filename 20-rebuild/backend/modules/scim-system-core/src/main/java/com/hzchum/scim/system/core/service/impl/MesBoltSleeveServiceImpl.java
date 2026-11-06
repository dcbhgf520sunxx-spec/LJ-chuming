package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import com.hzchum.scim.common.core.api.enums.ProductSectionNameEnum;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.system.core.api.pojo._do.MesBoltSleeve;
import com.hzchum.scim.system.core.api.pojo.dto.MesBoltSleeveDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesBoltSleeveSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesBoltSleeveService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigService;
import com.hzchum.scim.system.core.mapper.MesBoltSleeveMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBoltSleeveServiceImpl extends ServiceImpl<MesBoltSleeveMapper, MesBoltSleeve> implements MesBoltSleeveService {
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private MesSectionWarehouseConfigService sectionWarehouseConfigService;

   @Override
   public List<MesBoltSleeveDTO> listInfo() {
      List<MesBoltSleeveDTO> dtoList = this.baseMapper.selectListInfo();
      dtoList.forEach(e -> e.setTypeNameList(StrUtil.split(e.getType(), ",")));
      return dtoList;
   }

   @Override
   public MesBoltSleeveDTO detailById(Long id) {
      MesBoltSleeveDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前栓钉套筒不存在");
      dto.setTypeNameList(StrUtil.split(dto.getType(), ","));
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveMesBoltSleeve(MesBoltSleeveSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      List<String> typeNameList = this.sectionWarehouseConfigService
         .getSectionConfigNameList(
            ProductTypeEnum.AUXILIARY_MATERIAL.getType(), ProductClassificationEnum.AUXILIARY_MATERIAL.getType(), ProductSectionNameEnum.PRODUCT_NAME.getType()
         )
         .stream()
         .map(NameInfo::getName)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollUtil.containsAll(typeNameList, param.getTypeNameList()), "包含不存在的类型");
      Boolean isTypeExistence = this.baseMapper.isTypeExistence(null, param.getTypeNameList());
      Preconditions.checkArgument(!isTypeExistence, "类型不能重复");
      MesBuildingProcess buildingProcess = this.buildingProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getId, param.getProcessId())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType())
         );
      Preconditions.checkArgument(buildingProcess != null, "工序不存在");
      MesBoltSleeve boltSleeve = BeanUtil.toBean(param, MesBoltSleeve.class);
      boltSleeve.setType(CollUtil.join(param.getTypeNameList(), ","));
      this.baseMapper.insert(boltSleeve);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateMesBoltSleeve(MesBoltSleeveSaveDTOParam param) {
      MesBoltSleeve boltSleeveOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(boltSleeveOld != null, "当前栓钉套筒不存在");
      List<String> typeNameList = this.sectionWarehouseConfigService
         .getSectionConfigNameList(
            ProductTypeEnum.AUXILIARY_MATERIAL.getType(), ProductClassificationEnum.AUXILIARY_MATERIAL.getType(), ProductSectionNameEnum.PRODUCT_NAME.getType()
         )
         .stream()
         .map(NameInfo::getName)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollUtil.containsAll(typeNameList, param.getTypeNameList()), "包含不存在的类型");
      Boolean isTypeExistence = this.baseMapper.isTypeExistence(param.getId(), param.getTypeNameList());
      Preconditions.checkArgument(!isTypeExistence, "类型不能重复");
      MesBuildingProcess buildingProcess = this.buildingProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getId, param.getProcessId())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType())
         );
      Preconditions.checkArgument(buildingProcess != null, "工序不存在");
      MesBoltSleeve boltSleeve = BeanUtil.toBean(param, MesBoltSleeve.class);
      boltSleeve.setType(CollUtil.join(param.getTypeNameList(), ","));
      this.baseMapper.updateById(boltSleeve);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesBoltSleeve boltSleeveOld = this.baseMapper.selectById(id);
      Preconditions.checkArgument(boltSleeveOld != null, "当前栓钉套筒不存在");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }
}
