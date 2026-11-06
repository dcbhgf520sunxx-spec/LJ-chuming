package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingFactoryBiz;
import com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingProductionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingFactoryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingFactoryMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingFactoryBizImpl
   extends IBizImpl<MesBuildingFactoryService, MesBuildingFactoryMapper, MesBuildingFactory>
   implements MesBuildingFactoryBiz {
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingProductionLineService productionLineService;
   @Resource
   private MesBuildingTaskService taskService;

   @Override
   public List<MesBuildingFactoryDTO> listProductionLineByFactoryByCondition(MesBuildingFactoryDTOParam dtoParam, Integer type) {
      return this.baseService
         .list(
            (((Wrappers.<MesBuildingFactory>lambdaQuery()
                        .eq(dtoParam.getId() != null, MesBuildingFactory::getId, dtoParam.getId()))
                     .eq(dtoParam.getBoolEnabledEnum() != null, MesBuildingFactory::getBoolEnabledEnum, dtoParam.getBoolEnabledEnum()))
                  .like(dtoParam.getName() != null, MesBuildingFactory::getName, dtoParam.getName()))
               .like(dtoParam.getShortName() != null, MesBuildingFactory::getShortName, dtoParam.getShortName())
         )
         .stream()
         .map(
            factory -> {
               MesBuildingFactoryDTO factoryDTO = BeanUtil.copy(factory, MesBuildingFactoryDTO.class);
               factoryDTO.setWorkshopList(
                  this.workshopService
                     .list(
                        (Wrapper<MesBuildingWorkshop>)((Wrappers.<MesBuildingWorkshop>lambdaQuery()
                                 .eq(MesBuildingWorkshop::getFactoryId, factoryDTO.getId()))
                              .eq(MesBuildingWorkshop::getBoolEnabledEnum, true))
                           .apply("type & {0}", type)
                     )
                     .stream()
                     .map(
                        workshop -> {
                           MesBuildingWorkshopDTO workshopDTO = BeanUtil.copy(workshop, MesBuildingWorkshopDTO.class);
                           workshopDTO.setProductionLineList(
                              this.productionLineService
                                 .list(
                                    (Wrapper<MesBuildingProductionLine>)(Wrappers.<MesBuildingProductionLine>lambdaQuery()
                                          .eq(MesBuildingProductionLine::getWorkshopId, workshopDTO.getId()))
                                       .eq(MesBuildingProductionLine::getBoolEnabledEnum, true)
                                 )
                                 .stream()
                                 .map(productionLine -> BeanUtil.copy(productionLine, MesBuildingProductionLineDTO.class))
                                 .collect(Collectors.toList())
                           );
                           return workshopDTO;
                        }
                     )
                     .collect(Collectors.toList())
               );
               return factoryDTO;
            }
         )
         .collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingWorkshopDTO> listProductionLineByWorkShopByCondition(MesBuildingFactoryDTOParam dtoParam, Integer type) {
      dtoParam.setTaskTypeEnum(dtoParam.getTaskTypeEnum() == null ? TaskTypeEnum.MACHINE_PART.getType() : dtoParam.getTaskTypeEnum());
      List<MesBuildingWorkshopDTO> workshopDTOS = this.workshopService
         .list(
            (Wrapper<MesBuildingWorkshop>)(Wrappers.<MesBuildingWorkshop>lambdaQuery().eq(MesBuildingWorkshop::getBoolEnabledEnum, true))
               .eq(MesBuildingWorkshop::getType, type)
         )
         .stream()
         .map(
            workshop -> {
               MesBuildingWorkshopDTO workshopDTO = BeanUtil.copy(workshop, MesBuildingWorkshopDTO.class);
               workshopDTO.setProductionLineList(
                  this.productionLineService
                     .list(
                        (Wrapper<MesBuildingProductionLine>)((Wrappers.<MesBuildingProductionLine>lambdaQuery()
                                 .eq(MesBuildingProductionLine::getWorkshopId, workshopDTO.getId()))
                              .eq(MesBuildingProductionLine::getProductType, dtoParam.getTaskTypeEnum()))
                           .eq(MesBuildingProductionLine::getBoolEnabledEnum, true)
                     )
                     .stream()
                     .map(productionLine -> BeanUtil.copy(productionLine, MesBuildingProductionLineDTO.class))
                     .collect(Collectors.toList())
               );
               return workshopDTO;
            }
         )
         .collect(Collectors.toList());
      return workshopDTOS.stream().filter(e -> CollectionUtils.isNotEmpty(e.getProductionLineList())).collect(Collectors.toList());
   }

   @Override
   public List<MesBuildingWorkshopDTO> listAllWorkShopProductionLine(Integer type) {
      List<MesBuildingWorkshopDTO> workshopDTOS = this.workshopService
         .list(
            (Wrapper<MesBuildingWorkshop>)(Wrappers.<MesBuildingWorkshop>lambdaQuery().eq(MesBuildingWorkshop::getBoolEnabledEnum, true))
               .eq(MesBuildingWorkshop::getType, type)
         )
         .stream()
         .map(
            workshop -> {
               MesBuildingWorkshopDTO workshopDTO = BeanUtil.copy(workshop, MesBuildingWorkshopDTO.class);
               workshopDTO.setProductionLineList(
                  this.productionLineService
                     .list(
                        (Wrapper<MesBuildingProductionLine>)(Wrappers.<MesBuildingProductionLine>lambdaQuery()
                              .eq(MesBuildingProductionLine::getWorkshopId, workshopDTO.getId()))
                           .eq(MesBuildingProductionLine::getBoolEnabledEnum, true)
                     )
                     .stream()
                     .map(productionLine -> BeanUtil.copy(productionLine, MesBuildingProductionLineDTO.class))
                     .collect(Collectors.toList())
               );
               return workshopDTO;
            }
         )
         .collect(Collectors.toList());
      return workshopDTOS.stream().filter(e -> CollectionUtils.isNotEmpty(e.getProductionLineList())).collect(Collectors.toList());
   }

   @Override
   public PageVO<MesBuildingFactoryDTO> factoryPage(MesBuildingFactoryDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return this.baseService.factoryPage(dtoParam, sort, pageNumber, pageSize);
   }

   @Override
   public Boolean factoryUpdateState(MesBuildingFactoryDTOParam dtoParam) {
      return this.baseService.factoryUpdateState(dtoParam);
   }

   @Override
   public List<MesBuildingFactoryDTO> listByCondition(MesBuildingFactoryDTOParam dtoParam) {
      return this.baseService.listByCondition(dtoParam);
   }

   @Override
   public ListVO<NameInfo> listFactorySimple() {
      return this.baseService.listFactorySimple();
   }

   @Override
   public ListVO<NameInfo> listFactoryUser() {
      return this.baseService.listFactoryUser();
   }
}
