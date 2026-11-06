package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingProductionLineSumDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.factory.ProductionLineDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingTeamDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.ProductLineDetailDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingArtifactSchedulingLineSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingProductionLineDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingProductionLineMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingProductionLineServiceImpl
   extends ServiceImpl<MesBuildingProductionLineMapper, MesBuildingProductionLine>
   implements MesBuildingProductionLineService {
   @Resource
   private MesBuildingProductionLineMapper mesBuildingProductionLineMapper;
   @Resource
   private MesBuildingFactoryService factoryService;
   @Resource
   private MesBuildingWorkshopService workshopService;

   @Override
   public PageVO<MesBuildingProductionLineDTO> productionLinePage(MesBuildingProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listByCondition(dtoParam));
   }

   @Override
   public List<MesBuildingProductionLineDTO> listByCondition(MesBuildingProductionLineDTOParam dtoParam) {
      MesBuildingProductionLine productionLine = BeanUtil.copy(dtoParam, MesBuildingProductionLine.class);
      return this.mesBuildingProductionLineMapper
         .selectList(
            (Wrapper<MesBuildingProductionLine>)(((((Wrappers.<MesBuildingProductionLine>lambdaQuery()
                              .like(productionLine.getName() != null, MesBuildingProductionLine::getName, productionLine.getName()))
                           .eq(productionLine.getFactoryId() != null, MesBuildingProductionLine::getFactoryId, productionLine.getFactoryId()))
                        .eq(productionLine.getWorkshopId() != null, MesBuildingProductionLine::getWorkshopId, productionLine.getWorkshopId()))
                     .eq(productionLine.getBoolEnabledEnum() != null, MesBuildingProductionLine::getBoolEnabledEnum, productionLine.getBoolEnabledEnum()))
                  .eq(productionLine.getProductType() != null, MesBuildingProductionLine::getProductType, productionLine.getProductType()))
               .orderByAsc(MesBuildingProductionLine::getSort)
         )
         .stream()
         .map(e -> {
            MesBuildingProductionLineDTO dto = BeanUtil.copy(e, MesBuildingProductionLineDTO.class);
            dto.setFactoryName(this.factoryService.getById(dto.getFactoryId()).getName());
            dto.setWorkshopName(this.workshopService.getById(dto.getWorkshopId()).getName());
            return dto;
         })
         .collect(Collectors.toList());
   }

   @Override
   public List<DistributionDO> listByCondition(Long factory, Long workshopId) {
      return this.baseMapper.listByCondition(factory, workshopId);
   }

   @Override
   public ListVO<NameInfo> listProductionLineSimple(Long workshopId) {
      List<MesBuildingProductionLine> factories = this.baseMapper
         .selectList(Wrappers.<MesBuildingProductionLine>lambdaQuery().eq(workshopId != null, MesBuildingProductionLine::getFactoryId, workshopId));
      return new ListVO<>(factories.stream().map(e -> BeanUtil.copy(e, NameInfo.class)).collect(Collectors.toList()));
   }

   @Override
   public ListVO<NameInfo> listProductionLineUser(Long workshopId) {
      return new ListVO<>(this.baseMapper.listProductionLineUser(workshopId, UserUtil.getCurrentUserId()));
   }

   @Override
   public List<ProductionLineDO> productionLineList(Long factoryId, Long workshopId, Long productionLineId, Integer productType) {
      return this.baseMapper.productionLineList(factoryId, workshopId, productionLineId, productType);
   }

   @Override
   public List<MesBuildingProductionLineSumDO> selectProductLine(String factoryId, String workShopId, String productionLineId, int type) {
      return this.baseMapper.selectProductLine(factoryId, workShopId, productionLineId, type);
   }

   @Override
   public List<MesBuildingProductionLineSumDO> selectProductLineByids(Set<Long> lineIds) {
      return this.baseMapper.selectProductLineByids(lineIds);
   }

   @Override
   public List<MesBuildingFactoryDTO> getSchedulingLineTree(MesBuildingTeamDOParam doParam, Integer type) {
      return this.baseMapper.getSchedulingLineTree(doParam, type);
   }

   @Override
   public List<MesBuildingFactoryDTO> getEnclosureSchedulingLineTree(MesBuildingTeamDOParam doParam, Integer type) {
      return this.baseMapper.getEnclosureSchedulingLineTree(doParam, type);
   }

   @Override
   public List<MesBuildingArtifactSchedulingLineSummaryDTO> getLinesRecordSummary(MesBuildingArtifactSchedulingDOParam dtoParam) {
      return this.baseMapper.getLinesRecordSummary(dtoParam);
   }

   @Override
   public List<ProductLineDetailDTO> getTreeByLineIds(List<Long> lineIds) {
      return this.baseMapper.getTreeByLineIds(lineIds);
   }

   @Override
   public ProductLineDetailDTO getTreeByLineId(Long lineId) {
      return this.baseMapper.getTreeByLineId(lineId);
   }
}
