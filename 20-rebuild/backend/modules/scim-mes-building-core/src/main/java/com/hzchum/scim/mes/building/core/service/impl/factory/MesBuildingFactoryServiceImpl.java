package com.hzchum.scim.mes.building.core.service.impl.factory;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.device.MesWeighbridgeManagement;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingFactoryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingFactoryDTOParam;
import com.hzchum.scim.mes.building.core.api.service.MesWeighbridgeManagementService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingFactoryMapper;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingWorkshopMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class MesBuildingFactoryServiceImpl extends ServiceImpl<MesBuildingFactoryMapper, MesBuildingFactory> implements MesBuildingFactoryService {
   @Resource
   private MesBuildingWorkshopMapper mesBuildingWorkshopMapper;
   @Autowired
   @Lazy
   private BranchCompanyService branchCompanyService;
   @Autowired
   private MesWeighbridgeManagementService weighbridgeService;

   @Override
   public PageVO<MesBuildingFactoryDTO> factoryPage(MesBuildingFactoryDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listByCondition(dtoParam));
   }

   @Override
   public Boolean factoryUpdateState(MesBuildingFactoryDTOParam dtoParam) {
      Preconditions.checkArgument(dtoParam.getId() != null & dtoParam.getBoolEnabledEnum() != null, "传入数据有误");
      MesBuildingFactory mesBuildingFactory = this.baseMapper.selectById(dtoParam.getId());
      LambdaQueryWrapper<MesBuildingWorkshop> wrapper = (LambdaQueryWrapper<MesBuildingWorkshop>)new LambdaQueryWrapper<MesBuildingWorkshop>()
         .eq(MesBuildingWorkshop::getFactoryId, mesBuildingFactory.getId());
      List<MesBuildingWorkshop> mesBuildingWorkshopList = this.mesBuildingWorkshopMapper.selectList(wrapper);
      mesBuildingWorkshopList.stream().forEach(e -> Preconditions.checkArgument(!e.getBoolEnabledEnum(), "修改失败,该工厂下有车间处于未禁用状态,请先禁用车间"));
      mesBuildingFactory.setBoolEnabledEnum(dtoParam.getBoolEnabledEnum());
      this.baseMapper.updateById(mesBuildingFactory);
      return true;
   }

   @Override
   public List<MesBuildingFactoryDTO> listByCondition(MesBuildingFactoryDTOParam dtoParam) {
      MesBuildingFactory mesBuildingFactory = BeanUtil.copy(dtoParam, MesBuildingFactory.class);
      LambdaQueryWrapper<MesBuildingFactory> wrapper = (LambdaQueryWrapper<MesBuildingFactory>)((((new LambdaQueryWrapper<MesBuildingFactory>()
                     .like(mesBuildingFactory.getName() != null, MesBuildingFactory::getName, mesBuildingFactory.getName()))
                  .like(mesBuildingFactory.getShortName() != null, MesBuildingFactory::getShortName, mesBuildingFactory.getShortName()))
               .eq(mesBuildingFactory.getBoolEnabledEnum() != null, MesBuildingFactory::getBoolEnabledEnum, mesBuildingFactory.getBoolEnabledEnum()))
            .eq(mesBuildingFactory.getBranchCompanyId() != null, MesBuildingFactory::getBranchCompanyId, mesBuildingFactory.getBranchCompanyId()))
         .orderByAsc(MesBuildingFactory::getSort);
      List<MesBuildingFactory> mesBuildingFactories = this.baseMapper.selectList(wrapper);
      Map<Long, String> branchMap = this.branchCompanyService.list(null).stream().collect(Collectors.toMap(e -> e.getId(), e -> e.getName()));
      Map<Long, MesWeighbridgeManagement> weighbridgeMap = this.weighbridgeService
         .list(null)
         .stream()
         .collect(Collectors.toMap(e -> e.getFactoryId(), Function.identity()));
      return mesBuildingFactories.stream().map(e -> {
         MesBuildingFactoryDTO copy = BeanUtil.copy(e, MesBuildingFactoryDTO.class);
         copy.setBranchCompanyName(branchMap.getOrDefault(e.getBranchCompanyId(), ""));
         copy.setBoolDeviceConfigure(weighbridgeMap.getOrDefault(e.getId(), null) != null);
         return copy;
      }).collect(Collectors.toList());
   }

   @Override
   public ListVO<NameInfo> listFactorySimple() {
      List<MesBuildingFactory> factories = this.baseMapper.selectList(null);
      return new ListVO<>(factories.stream().map(e -> BeanUtil.copy(e, NameInfo.class)).collect(Collectors.toList()));
   }

   @Override
   public ListVO<NameInfo> listFactoryUser() {
      return new ListVO<>(this.baseMapper.listFactoryUser(UserUtil.getCurrentUserId()));
   }

   @Override
   public MesBuildingFactory getFactoryById(Long factoryId) {
      return this.baseMapper.getFactoryById(factoryId);
   }
}
