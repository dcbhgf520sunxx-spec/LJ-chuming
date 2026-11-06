package com.hzchum.scim.mes.building.core.service.impl.factory;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.WorkshopSaveVORequest;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.workshop.WorkshopUpdateVORequest;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingWorkshopDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesWorkShopProctionLineDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingWorkshopDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingWorkshopMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingWorkshopServiceImpl extends ServiceImpl<MesBuildingWorkshopMapper, MesBuildingWorkshop> implements MesBuildingWorkshopService {
   @Resource
   private MesBuildingWorkshopMapper mesBuildingWorkshopMapper;
   @Resource
   private MesBuildingFactoryService factoryService;

   @Override
   public PageVO<MesBuildingWorkshop> workshopPage(MesBuildingWorkshopDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize, Integer type) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize, sort), this.listByCondition(dtoParam, null));
   }

   @Override
   public List<MesBuildingWorkshop> listByCondition(MesBuildingWorkshopDTOParam dtoParam, Integer type) {
      return this.mesBuildingWorkshopMapper
         .selectList(
            (Wrapper<MesBuildingWorkshop>)((((Wrappers.<MesBuildingWorkshop>lambdaQuery()
                           .like(dtoParam.getName() != null, MesBuildingWorkshop::getName, dtoParam.getName()))
                        .eq(dtoParam.getBoolEnabledEnum() != null, MesBuildingWorkshop::getBoolEnabledEnum, dtoParam.getBoolEnabledEnum()))
                     .eq(dtoParam.getFactoryId() != null, MesBuildingWorkshop::getFactoryId, dtoParam.getFactoryId()))
                  .eq(type != null, MesBuildingWorkshop::getType, type)
                  .in(type == null, MesBuildingWorkshop::getType, WorkShopTypeEnum.BUILDING.getType(), WorkShopTypeEnum.BRIDGE.getType()))
               .orderByAsc(MesBuildingWorkshop::getSort)
         );
   }

   @Override
   public ListVO<NameInfo> listWorkShopSimple(Long factoryId, Integer type) {
      List<MesBuildingWorkshop> factories = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingWorkshop>)(Wrappers.<MesBuildingWorkshop>lambdaQuery().eq(factoryId != null, MesBuildingWorkshop::getFactoryId, factoryId))
               .eq(MesBuildingWorkshop::getType, type)
         );
      return new ListVO<>(factories.stream().map(e -> BeanUtil.copy(e, NameInfo.class)).collect(Collectors.toList()));
   }

   @Override
   public ListVO<NameInfo> listWorkShopUser(Long factoryId, Integer type) {
      return new ListVO<>(this.baseMapper.listWorkShopUser(factoryId, UserUtil.getCurrentUserId(), type));
   }

   @Override
   public NameInfo getSimpleById(Long workshopId) {
      MesBuildingWorkshop workshop = this.baseMapper.selectById(workshopId);
      return BeanUtil.copy(workshop, NameInfo.class);
   }

   @Override
   public MesBuildingWorkshop getWorkshopById(Long workshopId) {
      return this.baseMapper.getWorkshopById(workshopId);
   }

   @Override
   public List<MesBuildingWorkshopDTO> newlistByCondition(MesBuildingWorkshopDTOParam dtoParam, Integer type) {
      List<MesBuildingWorkshop> mesBuildingWorkshops = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingWorkshop>)((((Wrappers.<MesBuildingWorkshop>lambdaQuery()
                           .like(dtoParam.getName() != null, MesBuildingWorkshop::getName, dtoParam.getName()))
                        .eq(dtoParam.getBoolEnabledEnum() != null, MesBuildingWorkshop::getBoolEnabledEnum, dtoParam.getBoolEnabledEnum()))
                     .eq(dtoParam.getFactoryId() != null, MesBuildingWorkshop::getFactoryId, dtoParam.getFactoryId()))
                  .eq(dtoParam.getType() != null, MesBuildingWorkshop::getType, dtoParam.getType()))
               .orderByAsc(MesBuildingWorkshop::getSort)
         );
      if (CollectionUtils.isEmpty(mesBuildingWorkshops)) {
         return new ArrayList<>();
      }

      Map<Long, MesBuildingFactory> factoryMap = this.factoryService
         .listByIds(CollUtil.getFieldValues(mesBuildingWorkshops, "factoryId", Long.class))
         .stream()
         .collect(Collectors.toMap(MesBuildingFactory::getId, Function.identity()));
      return mesBuildingWorkshops.stream().map(s -> {
         MesBuildingWorkshopDTO copy = BeanUtil.copy(s, MesBuildingWorkshopDTO.class);
         copy.setFactoryName(factoryMap.get(s.getFactoryId()).getName());
         return copy;
      }).collect(Collectors.toList());
   }

   @Override
   public List<MesWorkShopProctionLineDTO> listShopLineLink(MesBuildingWorkshopDTOParam dtoParam, Integer type) {
      return this.baseMapper.listShopLineLink(dtoParam, type);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean workshopSave(WorkshopSaveVORequest voRequest, Long currentUserId) {
      MesBuildingWorkshop workshop = BeanUtil.copy(voRequest, MesBuildingWorkshop.class);
      Preconditions.checkArgument(this.factoryService.getById(workshop.getFactoryId()) != null, "添加失败，未查询到相关工厂");
      Preconditions.checkArgument(
         this.list(
               (Wrapper<MesBuildingWorkshop>)(Wrappers.<MesBuildingWorkshop>lambdaQuery().eq(MesBuildingWorkshop::getFactoryId, workshop.getFactoryId()))
                  .eq(MesBuildingWorkshop::getName, workshop.getName())
            )
            .isEmpty(),
         "操作失败，该工厂下不允许有重名车间"
      );
      workshop.setBoolEnabledEnum(true);
      workshop.setUserId(UserUtil.getCurrentUserId());
      return this.save(workshop);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean workshopUpdate(WorkshopUpdateVORequest voRequest, Long currentUserId) {
      if (voRequest.getName() != null) {
         Preconditions.checkArgument(
            this.count(
                  (Wrapper<MesBuildingWorkshop>)(Wrappers.<MesBuildingWorkshop>lambdaQuery().ne(MesBuildingWorkshop::getId, voRequest.getId()))
                     .eq(MesBuildingWorkshop::getName, voRequest.getName())
               )
               == 0,
            "修改失败，车间名重复"
         );
      }

      return this.updateById(BeanUtil.copy(voRequest, MesBuildingWorkshop.class).setUserId(currentUserId));
   }
}
