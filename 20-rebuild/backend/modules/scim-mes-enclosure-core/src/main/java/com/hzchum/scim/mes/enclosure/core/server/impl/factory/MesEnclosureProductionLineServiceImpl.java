package com.hzchum.scim.mes.enclosure.core.server.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineSumDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.ProductionLineDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._do.wages.DistributionDO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureProductionLine;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureProductionLineDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureProductionLineDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureProductionLineService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureProductionLineMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MesEnclosureProductionLineServiceImpl
   extends ServiceImpl<MesEnclosureProductionLineMapper, MesEnclosureProductionLine>
   implements MesEnclosureProductionLineService {
   @Resource
   private MesEnclosureProductionLineMapper mesEnclosureProductionLineMapper;
   @Resource
   private MesBuildingFactoryService factoryService;
   @Resource
   private MesBuildingWorkshopService workshopService;

   @Override
   public PageVO<MesEnclosureProductionLineDTO> productionLinePage(
      MesEnclosureProductionLineDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listByCondition(dtoParam));
   }

   @Override
   public List<MesEnclosureProductionLineDTO> listByCondition(MesEnclosureProductionLineDTOParam dtoParam) {
      MesEnclosureProductionLine productionLine = BeanUtil.copy(dtoParam, MesEnclosureProductionLine.class);
      return this.mesEnclosureProductionLineMapper
         .selectList(
            (Wrapper<MesEnclosureProductionLine>)((((Wrappers.<MesEnclosureProductionLine>lambdaQuery()
                           .like(productionLine.getName() != null, MesEnclosureProductionLine::getName, productionLine.getName()))
                        .eq(productionLine.getFactoryId() != null, MesEnclosureProductionLine::getFactoryId, productionLine.getFactoryId()))
                     .eq(productionLine.getWorkshopId() != null, MesEnclosureProductionLine::getWorkshopId, productionLine.getWorkshopId()))
                  .eq(productionLine.getBoolEnabledEnum() != null, MesEnclosureProductionLine::getBoolEnabledEnum, productionLine.getBoolEnabledEnum()))
               .orderByAsc(MesEnclosureProductionLine::getSort)
         )
         .stream()
         .map(e -> {
            MesEnclosureProductionLineDTO dto = BeanUtil.copy(e, MesEnclosureProductionLineDTO.class);
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
      List<MesEnclosureProductionLine> factories = this.baseMapper
         .selectList(Wrappers.<MesEnclosureProductionLine>lambdaQuery().eq(workshopId != null, MesEnclosureProductionLine::getFactoryId, workshopId));
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
   public List<MesEnclosureProductionLineSumDO> selectProductLine(String factoryId, String workShopId, String productionLineId, int type) {
      return this.baseMapper.selectProductLine(factoryId, workShopId, productionLineId, type);
   }

   @Override
   public List<MesEnclosureProductionLineSumDO> selectProductLineByids(Set<Long> lineIds) {
      return this.baseMapper.selectProductLineByids(lineIds);
   }

   @Override
   public MesEnclosureProductionLine getLineById(Long productionLineId) {
      return this.baseMapper.getLineById(productionLineId);
   }
}
