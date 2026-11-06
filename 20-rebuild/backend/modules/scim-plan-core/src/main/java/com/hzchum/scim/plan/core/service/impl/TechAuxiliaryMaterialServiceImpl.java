package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.AuxiliaryMaterialEditDTOParam;
import com.hzchum.scim.business.core.api.service.BusinessAuxiliaryMaterialService;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.common.core.api.pojo.common.TechStandardPartBaseInfo;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.mes.building.core.api.biz.warehouse.WarehouseBiz;
import com.hzchum.scim.mes.building.core.api.enums.WarehouseTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseSaveDTOParam;
import com.hzchum.scim.mes.building.core.api.service.warehouse.MesBuildingWarehouseSummaryService;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomer;
import com.hzchum.scim.plan.core.api.pojo._do.TechAuxiliaryMaterial;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialClassDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialPrintDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialSaveDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dto.AuxiliaryMaterialUpdateDTOParam;
import com.hzchum.scim.plan.core.api.service.PlanMonomerService;
import com.hzchum.scim.plan.core.api.service.TechAuxiliaryMaterialService;
import com.hzchum.scim.plan.core.api.service.TechDeepenRecordService;
import com.hzchum.scim.plan.core.mapper.TechAuxiliaryMaterialMapper;
import com.hzchum.scim.project.core.api.service.ProjectAuxiliaryMaterialClassService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.UserService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TechAuxiliaryMaterialServiceImpl extends ServiceImpl<TechAuxiliaryMaterialMapper, TechAuxiliaryMaterial> implements TechAuxiliaryMaterialService {
   @Resource
   private ContractProjectService projectService;
   @Resource
   private PlanMonomerService monomerService;
   @Resource
   private UserService userService;
   @Resource
   private BusinessAuxiliaryMaterialService businessAuxiliaryMaterialService;
   @Resource
   private TechDeepenRecordService deepenRecordService;
   @Resource
   private WarehouseBiz warehouseBiz;
   @Autowired
   private MesBuildingWarehouseSummaryService warehouseSummaryService;
   @Resource
   private ProjectAuxiliaryMaterialClassService auxiliaryMaterialClassService;

   @Override
   public PageVO<AuxiliaryMaterialDTO> listAuxiliaryMaterials(
      Long projectId, Long monomerId, String classifyName, String serialNumber, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      String conditions = StringUtils.analyzeSortConditions(sort);
      PageHelper.startPage(pageNumber, pageSize, conditions);
      List<TechAuxiliaryMaterial> auxiliaryMaterials = this.baseMapper
         .selectList(
            (((Wrappers.<TechAuxiliaryMaterial>lambdaQuery()
                        .eq(projectId != null, TechAuxiliaryMaterial::getProjectId, projectId))
                     .eq(monomerId != null, TechAuxiliaryMaterial::getMonomerId, monomerId))
                  .like(org.apache.commons.lang3.StringUtils.isNotBlank(classifyName), TechAuxiliaryMaterial::getClassifyName, classifyName))
               .like(org.apache.commons.lang3.StringUtils.isNotBlank(serialNumber), TechAuxiliaryMaterial::getSerialNumber, serialNumber)
         );
      List<AuxiliaryMaterialDTO> materialDTOList = auxiliaryMaterials.stream().map(a -> {
         AuxiliaryMaterialDTO materialDTO = BeanUtil.copy(a, AuxiliaryMaterialDTO.class);
         materialDTO.setUserName(this.userService.getNameById(a.getUserId()));
         return materialDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(materialDTOList, auxiliaryMaterials));
   }

   @Transactional(rollbackFor = RuntimeException.class)
   @Override
   public Boolean saveAuxiliaryMaterial(Long projectId, Long monomerId, List<AuxiliaryMaterialSaveDTOParam> saveDTOParamList) {
      ContractProject project = this.projectService.checkProjectStatus(projectId);
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(saveDTOParamList), "新增配套件列表为空!");
      List<Long> materialIds = new ArrayList<>(16);
      saveDTOParamList.forEach(
         s -> {
            TechAuxiliaryMaterial auxiliaryMaterial = TechAuxiliaryMaterial.builder()
               .projectId(projectId)
               .monomerId(monomerId)
               .userId(UserUtil.getCurrentUserId())
               .build();
            BeanUtil.copy(s, auxiliaryMaterial);
            if (auxiliaryMaterial.getQuantity() == null) {
               auxiliaryMaterial.setQuantity(s.getMete().intValue());
            }

            if (auxiliaryMaterial.getMeasureUnit() == null) {
               auxiliaryMaterial.setMeasureUnit(s.getAccountingUnit());
            }

            Long businessId = this.businessAuxiliaryMaterialService.addBusinessInfo(BeanUtil.copy(auxiliaryMaterial, AuxiliaryMaterialAddDTOParam.class));
            auxiliaryMaterial.setBusinessId(businessId);
            auxiliaryMaterial.setUnitNet(s.getQuantity() != null ? s.getMete().divide(BigDecimal.valueOf(s.getQuantity().intValue()), 8, 4) : BigDecimal.ONE);
            this.baseMapper.insert(auxiliaryMaterial);
            if (project.getBusinessType().equals(ProjectBusinessTypeEnum.JOB.getType())) {
               this.auxiliaryMaterialClassService
                  .saveAuxiliaryMaterialClass(auxiliaryMaterial.getProjectId(), auxiliaryMaterial.getClassifyId(), auxiliaryMaterial.getClassifyName());
            }

            TechDeepenRecord record = TechDeepenRecord.builder()
               .projectId(auxiliaryMaterial.getProjectId())
               .monomerId(auxiliaryMaterial.getMonomerId())
               .quantity(auxiliaryMaterial.getQuantity())
               .mete(auxiliaryMaterial.getMete())
               .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
               .productId(auxiliaryMaterial.getId())
               .userId(UserUtil.getCurrentUserId())
               .build();
            this.deepenRecordService.save(record);
            materialIds.add(auxiliaryMaterial.getId());
            if (auxiliaryMaterial.getUseProperty().equals(1)) {
               this.warehouseBiz
                  .setStockQuantity(
                     WarehouseSaveDTOParam.builder()
                        .projectId(auxiliaryMaterial.getProjectId())
                        .monomerId(auxiliaryMaterial.getMonomerId())
                        .factoryId(0L)
                        .areaId(0L)
                        .productId(auxiliaryMaterial.getId())
                        .productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType())
                        .type(WarehouseTypeEnum.INTO.getType())
                        .quantity(BigDecimal.valueOf(auxiliaryMaterial.getQuantity().intValue()))
                        .build()
                  );
            }
         }
      );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = RuntimeException.class)
   @Override
   public Boolean updateAuxiliaryMaterial(AuxiliaryMaterialUpdateDTOParam updateDTOParam) {
      TechAuxiliaryMaterial auxiliaryMaterial = this.baseMapper.selectById(updateDTOParam.getId());
      Preconditions.checkArgument(auxiliaryMaterial != null, "辅材不存在!");
      this.projectService.checkProjectStatus(auxiliaryMaterial.getProjectId());
      if (auxiliaryMaterial.getMonomerId() != null) {
         PlanMonomer monomer = this.monomerService.getById(auxiliaryMaterial.getMonomerId());
         Preconditions.checkArgument(monomer != null, "单体不存在");
      }

      BeanUtil.copy(updateDTOParam, auxiliaryMaterial);
      Preconditions.checkArgument(this.baseMapper.updateById(auxiliaryMaterial) == 1, "修改失败");
      TechDeepenRecord deepenRecord = this.deepenRecordService.getByProductTypeProductId(ProductTypeEnum.AUXILIARY_MATERIAL.getType(), updateDTOParam.getId());
      deepenRecord.setQuantity(updateDTOParam.getQuantity());
      deepenRecord.setMete(updateDTOParam.getMete());
      this.deepenRecordService.updateById(deepenRecord);
      this.businessAuxiliaryMaterialService
         .editBusinessInfo(AuxiliaryMaterialEditDTOParam.builder().businessId(auxiliaryMaterial.getBusinessId()).mete(auxiliaryMaterial.getMete()).build());
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteAuxiliaryMaterials(Long projectId, List<Long> ids) {
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(ids), "删除配套件id列表为空!");
      this.projectService.checkProjectStatus(projectId);
      ids.forEach(
         id -> {
            TechAuxiliaryMaterial material = this.baseMapper.selectById(id);
            Preconditions.checkArgument(material != null, "配套件不存在!");
            this.baseMapper.deleteById(material);
            this.businessAuxiliaryMaterialService
               .editBusinessInfo(AuxiliaryMaterialEditDTOParam.builder().businessId(material.getBusinessId()).mete(BigDecimal.ZERO).build());
            this.deepenRecordService
               .remove(Wrappers.lambdaQuery(TechDeepenRecord.builder().productType(ProductTypeEnum.AUXILIARY_MATERIAL.getType()).productId(id).build()));
         }
      );
      return Boolean.TRUE;
   }

   @Override
   public List<TechAuxiliaryMaterial> listByBusinessId(Long businessId) {
      return this.baseMapper.selectList((Wrapper<TechAuxiliaryMaterial>)Wrappers.<TechAuxiliaryMaterial>lambdaQuery().eq(TechAuxiliaryMaterial::getBusinessId, businessId));
   }

   @Override
   public PageVO listAuxiliaryMaterialPrint(AuxiliaryMaterialPrintDTOParam param) {
      PageHelper.startPage(param.getPageNumber(), param.getPageSize());
      return new PageVO<>(this.baseMapper.listAuxiliaryMaterialPrint(param));
   }

   @Override
   public TechStandardPartBaseInfo getInfoById(Long productId) {
      TechAuxiliaryMaterial auxiliaryMaterial = this.baseMapper.selectById(productId);
      TechStandardPartBaseInfo info = BeanUtil.copy(auxiliaryMaterial, TechStandardPartBaseInfo.class);
      info.setProject(this.projectService.getSimpleById(auxiliaryMaterial.getProjectId()));
      info.setMonomer(this.monomerService.getSimpleById(auxiliaryMaterial.getMonomerId()));
      return info;
   }

   @Override
   public List<AuxiliaryMaterialClassDTO> listAuxiliaryMaterialClass(Long projectId) {
      return this.baseMapper.selectClassByProjectId(projectId);
   }
}
