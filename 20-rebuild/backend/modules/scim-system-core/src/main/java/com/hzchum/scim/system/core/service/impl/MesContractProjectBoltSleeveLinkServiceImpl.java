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
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.system.core.api.pojo._do.MesContractProjectBoltSleeveLink;
import com.hzchum.scim.system.core.api.pojo.dto.MesBoltSleeveDTO;
import com.hzchum.scim.system.core.api.pojo.dto.MesContractProjectBoltSleeveLinkDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesContractProjectBoltSleeveLinkSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesBoltSleeveService;
import com.hzchum.scim.system.core.api.service.MesContractProjectBoltSleeveLinkService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.api.service.MesSectionWarehouseConfigService;
import com.hzchum.scim.system.core.mapper.MesContractProjectBoltSleeveLinkMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesContractProjectBoltSleeveLinkServiceImpl
   extends ServiceImpl<MesContractProjectBoltSleeveLinkMapper, MesContractProjectBoltSleeveLink>
   implements MesContractProjectBoltSleeveLinkService {
   @Autowired
   private MesBuildingProcessService buildingProcessService;
   @Autowired
   private MesSectionWarehouseConfigService sectionWarehouseConfigService;
   @Autowired
   private ContractProjectService contractProjectService;
   @Autowired
   private MesBoltSleeveService boltSleeveService;
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;

   @Override
   public List<MesContractProjectBoltSleeveLinkDTO> listInfo(Long projectId) {
      List<MesContractProjectBoltSleeveLinkDTO> dtoList = this.baseMapper.selectListInfo(projectId);
      dtoList.forEach(e -> e.setTypeNameList(StrUtil.split(e.getType(), ",")));
      return dtoList;
   }

   @Override
   public List<MesContractProjectBoltSleeveLinkDTO> listInfoByCondition(Long processId, List<Long> contractProjectIds) {
      List<MesContractProjectBoltSleeveLinkDTO> dtoList = this.baseMapper.listInfoByCondition(processId, contractProjectIds);
      dtoList.forEach(e -> e.setTypeNameList(StrUtil.split(e.getType(), ",")));
      return dtoList;
   }

   @Override
   public MesContractProjectBoltSleeveLinkDTO detailById(Long id) {
      MesContractProjectBoltSleeveLinkDTO dto = this.baseMapper.detailById(id);
      Preconditions.checkArgument(dto != null, "当前栓钉套筒不存在");
      dto.setTypeNameList(StrUtil.split(dto.getType(), ","));
      return dto;
   }

   @Override
   public MesContractProjectBoltSleeveLinkDTO getOneByCondition(Long projectId, String typeName, Long processId) {
      return this.baseMapper.getOneByCondition(projectId, typeName, processId);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveConfig(MesContractProjectBoltSleeveLinkSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      List<String> typeNameList = this.sectionWarehouseConfigService
         .getSectionConfigNameList(
            ProductTypeEnum.AUXILIARY_MATERIAL.getType(), ProductClassificationEnum.AUXILIARY_MATERIAL.getType(), ProductSectionNameEnum.PRODUCT_NAME.getType()
         )
         .stream()
         .map(NameInfo::getName)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollUtil.containsAll(typeNameList, param.getTypeNameList()), "包含不存在的类型");
      Boolean isTypeExistence = this.baseMapper.isTypeExistence(null, param.getContractProjectId(), param.getTypeNameList());
      Preconditions.checkArgument(!isTypeExistence, "类型不能重复");
      MesBuildingProcess buildingProcess = this.buildingProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getId, param.getProcessId())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType())
         );
      Preconditions.checkArgument(buildingProcess != null, "工序不存在");
      MesContractProjectBoltSleeveLink config = BeanUtil.toBean(param, MesContractProjectBoltSleeveLink.class);
      config.setType(CollUtil.join(param.getTypeNameList(), ","));
      this.baseMapper.insert(config);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateConfig(MesContractProjectBoltSleeveLinkSaveDTOParam param) {
      MesContractProjectBoltSleeveLink oldConfig = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(oldConfig != null, "当前栓钉套筒不存在");
      List<String> typeNameList = this.sectionWarehouseConfigService
         .getSectionConfigNameList(
            ProductTypeEnum.AUXILIARY_MATERIAL.getType(), ProductClassificationEnum.AUXILIARY_MATERIAL.getType(), ProductSectionNameEnum.PRODUCT_NAME.getType()
         )
         .stream()
         .map(NameInfo::getName)
         .collect(Collectors.toList());
      Preconditions.checkArgument(CollUtil.containsAll(typeNameList, param.getTypeNameList()), "包含不存在的类型");
      Boolean isTypeExistence = this.baseMapper.isTypeExistence(param.getId(), param.getContractProjectId(), param.getTypeNameList());
      Preconditions.checkArgument(!isTypeExistence, "类型不能重复");
      MesBuildingProcess buildingProcess = this.buildingProcessService
         .getOne(
            Wrappers.lambdaQuery(MesBuildingProcess.class)
               .eq(MesBuildingProcess::getId, param.getProcessId())
               .eq(MesBuildingProcess::getProductType, ProductTypeEnum.ARTIFACT.getType())
         );
      Preconditions.checkArgument(buildingProcess != null, "工序不存在");
      MesContractProjectBoltSleeveLink newConfig = BeanUtil.toBean(param, MesContractProjectBoltSleeveLink.class);
      newConfig.setType(CollUtil.join(param.getTypeNameList(), ","));
      this.baseMapper.updateById(newConfig);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesContractProjectBoltSleeveLink oldConfig = this.baseMapper.selectById(id);
      Preconditions.checkArgument(oldConfig != null, "当前栓钉套筒不存在");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveContractProjectBoltSleeveLink(Long contractProjectId) {
      ContractProject contractProject = this.contractProjectService.getById(contractProjectId);
      Preconditions.checkArgument(contractProject != null, "合同项目不存在");
      List<MesBoltSleeveDTO> boltSleeveDTOList = this.boltSleeveService.listInfo();
      if (CollUtil.isEmpty(boltSleeveDTOList)) {
         return Boolean.TRUE;
      }

      List<MesContractProjectBoltSleeveLink> boltSleeveLinkList = boltSleeveDTOList.stream().map(bs -> {
         MesContractProjectBoltSleeveLink boltSleeveLink = BeanUtil.toBean(bs, MesContractProjectBoltSleeveLink.class);
         boltSleeveLink.setContractProjectId(contractProjectId);
         return boltSleeveLink;
      }).collect(Collectors.toList());
      this.saveBatch(boltSleeveLinkList, boltSleeveLinkList.size());
      return Boolean.TRUE;
   }
}
