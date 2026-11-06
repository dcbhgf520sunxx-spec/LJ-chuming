package com.hzchum.scim.system.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.system.core.api.pojo._do.MesOtherApportionment;
import com.hzchum.scim.system.core.api.pojo.dto.MesOtherApportionmentDTO;
import com.hzchum.scim.system.core.api.pojo.request.MesOtherApportionmentSaveDTOParam;
import com.hzchum.scim.system.core.api.service.MesOtherApportionmentService;
import com.hzchum.scim.system.core.api.service.MesPriceModifyConfigService;
import com.hzchum.scim.system.core.mapper.MesOtherApportionmentMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesOtherApportionmentServiceImpl extends ServiceImpl<MesOtherApportionmentMapper, MesOtherApportionment> implements MesOtherApportionmentService {
   @Autowired
   private MesPriceModifyConfigService priceModifyConfigService;
   @Autowired
   private MesBuildingWorkshopService workshopService;

   @Override
   public List<MesOtherApportionmentDTO> listInfo() {
      return this.baseMapper.listInfo();
   }

   @Override
   public MesOtherApportionmentDTO detailById(Long id) {
      MesOtherApportionment otherApportionment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(otherApportionment != null, "当前其他分摊不存在，请核对后操作");
      MesBuildingWorkshop workshop = this.workshopService.getById(otherApportionment.getWorkshopId());
      MesOtherApportionmentDTO dto = BeanUtil.toBean(otherApportionment, MesOtherApportionmentDTO.class);
      dto.setWorkshopName(workshop.getName());
      return dto;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveOtherApportionment(MesOtherApportionmentSaveDTOParam param) {
      Preconditions.checkArgument(this.priceModifyConfigService.isConfigured(), "价格修改配置未选择，请前往统计配置中选择");
      this.verifyParameters(param);
      MesOtherApportionment otherApportionment = BeanUtil.toBean(param, MesOtherApportionment.class);
      this.baseMapper.insert(otherApportionment);
      return Boolean.TRUE;
   }

   private void verifyParameters(MesOtherApportionmentSaveDTOParam param) {
      int repeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesOtherApportionment.class)
               .ne(param.getId() != null, MesOtherApportionment::getId, param.getId())
               .eq(MesOtherApportionment::getType, param.getType())
         );
      Preconditions.checkArgument(repeat == 0, "类型重复");
      int workshopRepeat = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(MesOtherApportionment.class)
               .ne(param.getId() != null, MesOtherApportionment::getId, param.getId())
               .eq(MesOtherApportionment::getWorkshopId, param.getWorkshopId())
         );
      Preconditions.checkArgument(workshopRepeat == 0, "类型重复");
      int workshopCount = this.workshopService
         .count(
            Wrappers.lambdaQuery(MesBuildingWorkshop.class)
               .eq(MesBuildingWorkshop::getBoolEnabledEnum, Boolean.TRUE)
               .eq(MesBuildingWorkshop::getId, param.getWorkshopId())
         );
      Preconditions.checkArgument(workshopCount > 0, "车间不存在");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean editOtherApportionment(MesOtherApportionmentSaveDTOParam param) {
      MesOtherApportionment otherApportionmentOld = this.baseMapper.selectById(param.getId());
      Preconditions.checkArgument(otherApportionmentOld != null, "当前其他分摊不存在，请核对后操作");
      this.verifyParameters(param);
      MesOtherApportionment otherApportionment = BeanUtil.toBean(param, MesOtherApportionment.class);
      this.baseMapper.updateById(otherApportionment);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateStatus(Long id, Boolean status) {
      MesOtherApportionment otherApportionment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(otherApportionment != null, "当前其他分摊不存在，请核对后操作");
      otherApportionment.setStatus(status);
      this.baseMapper.updateById(otherApportionment);
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      MesOtherApportionment otherApportionment = this.baseMapper.selectById(id);
      Preconditions.checkArgument(otherApportionment != null, "当前其他分摊不存在，请核对后操作");
      this.baseMapper.deleteById(id);
      return Boolean.TRUE;
   }
}
