package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingFactory;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingWorkshop;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingBoChuJobDirectory;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingFactoryService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.scheduling.MesBuildingBoChuJobDirectoryService;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.pojo.dto.config.MesBuildingNestingTeamDTO;
import com.hzchum.scim.system.core.api.pojo.vo.MesBuildingNestingTeamVO;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import com.hzchum.scim.system.core.mapper.MesBuildingNestingTeamMapper;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingNestingTeamServiceImpl
   extends ServiceImpl<MesBuildingNestingTeamMapper, MesBuildingNestingTeam>
   implements MesBuildingNestingTeamService {
   @Resource
   private MesBuildingFactoryService factoryService;
   @Resource
   private MesBuildingWorkshopService workshopService;
   @Resource
   private MesBuildingBoChuJobDirectoryService mesBuildingBoChuJobDirectoryService;

   @Override
   public PageVO<MesBuildingNestingTeamDTO> page(Integer pageNumber, Integer pageSize) {
      Page<MesBuildingNestingTeam> page = PageHelper.startPage(pageNumber, pageSize);
      List<MesBuildingNestingTeamDTO> mesBuildingNestingTeamList = this.baseMapper.selectListMesBuildingNestingTeam(null);
      return new PageVO<>(page, mesBuildingNestingTeamList);
   }

   @Override
   public List<MesBuildingNestingTeamDTO> allMesBuildingNestingTeam(Long workshopId) {
      return this.baseMapper.selectListMesBuildingNestingTeamAll(workshopId);
   }

   @Override
   public MesBuildingNestingTeamDTO getByIdMesBuildingNestingTeam(Long id) {
      Preconditions.checkArgument(id != null, "id不能为空");
      return this.baseMapper.getByIdMesBuildingNestingTeam(id);
   }

   @Override
   public void save(MesBuildingNestingTeamVO vo) {
      Preconditions.checkArgument(vo.getCompany() != null, "二级单位不能为空");
      Preconditions.checkArgument(vo.getWorkshopId() != null, "车间不能为空");
      Preconditions.checkArgument(vo.getNestingChargePerson() != null, "负责人不能为空");
      Preconditions.checkArgument(vo.getTeamCode() != null, "团队码不能为空");
      MesBuildingWorkshop workshop = this.workshopService.getById(vo.getWorkshopId());
      Preconditions.checkArgument(workshop != null, "操作失败,车间不存在!");
      MesBuildingFactory factory = this.factoryService.getById(workshop.getFactoryId());
      Preconditions.checkArgument(factory != null, "操作失败,工厂不存在!");
      Preconditions.checkArgument(factory.getBranchCompanyId().equals(Long.valueOf(vo.getCompany())), "操作失败,所选车间的的分支机构与所选分支机构不一致!");
      List<MesBuildingNestingTeam> mesBuildingNestingTeamListTwo = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingNestingTeam>)(new LambdaQueryWrapper<MesBuildingNestingTeam>()
                  .eq(MesBuildingNestingTeam::getNestingChargePerson, vo.getNestingChargePerson()))
               .eq(MesBuildingNestingTeam::getWorkshopId, vo.getWorkshopId())
         );
      Preconditions.checkArgument(mesBuildingNestingTeamListTwo.isEmpty(), "该车间下负责人已存在");
      MesBuildingNestingTeam mesBuildingNestingTeam = new MesBuildingNestingTeam();
      BeanUtil.copy(vo, mesBuildingNestingTeam);
      this.baseMapper.insert(mesBuildingNestingTeam);
   }

   @Override
   public void update(MesBuildingNestingTeamVO vo) {
      Preconditions.checkArgument(vo.getCompany() != null, "二级单位不能为空");
      Preconditions.checkArgument(vo.getWorkshopId() != null, "车间不能为空");
      Preconditions.checkArgument(vo.getNestingChargePerson() != null, "负责人不能为空");
      Preconditions.checkArgument(vo.getTeamCode() != null, "团队码不能为空");
      List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
         .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getTeamCodeId, vo.getId()));
      Preconditions.checkArgument(mesBuildingBoChuJobDirectoryList.isEmpty(), "该团队码有已经绑定的作业，无法修改");
      MesBuildingWorkshop workshop = this.workshopService.getById(vo.getWorkshopId());
      Preconditions.checkArgument(workshop != null, "操作失败,车间不存在!");
      MesBuildingFactory factory = this.factoryService.getById(workshop.getFactoryId());
      Preconditions.checkArgument(factory != null, "操作失败,工厂不存在!");
      Preconditions.checkArgument(factory.getBranchCompanyId().equals(Long.valueOf(vo.getCompany())), "操作失败,所选车间的的分支机构与所选分支机构不一致!");
      List<MesBuildingNestingTeam> mesBuildingNestingTeamListTwo = this.baseMapper
         .selectList(
            (Wrapper<MesBuildingNestingTeam>)((new LambdaQueryWrapper<MesBuildingNestingTeam>()
                     .eq(MesBuildingNestingTeam::getNestingChargePerson, vo.getNestingChargePerson()))
                  .eq(MesBuildingNestingTeam::getWorkshopId, vo.getWorkshopId()))
               .ne(MesBuildingNestingTeam::getId, vo.getId())
         );
      Preconditions.checkArgument(mesBuildingNestingTeamListTwo.isEmpty(), "负责人已存在");
      MesBuildingNestingTeam mesBuildingNestingTeam = new MesBuildingNestingTeam();
      BeanUtil.copy(vo, mesBuildingNestingTeam);
      this.updateById(mesBuildingNestingTeam);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void delete(MesBuildingNestingTeamVO vo) {
      List<Long> idList = vo.getIds();
      Preconditions.checkArgument(idList != null && !idList.isEmpty(), "id不能为空");
      idList.forEach(
         id -> {
            List<MesBuildingBoChuJobDirectory> mesBuildingBoChuJobDirectoryList = this.mesBuildingBoChuJobDirectoryService
               .list((Wrapper<MesBuildingBoChuJobDirectory>)new LambdaQueryWrapper<MesBuildingBoChuJobDirectory>().eq(MesBuildingBoChuJobDirectory::getTeamCodeId, id));
            Preconditions.checkArgument(mesBuildingBoChuJobDirectoryList.isEmpty(), "该团队码有任务进行中，无法删除");
         }
      );
      this.removeByIds(idList);
   }

   public MesBuildingNestingTeamServiceImpl(
      final MesBuildingFactoryService factoryService,
      final MesBuildingWorkshopService workshopService,
      final MesBuildingBoChuJobDirectoryService mesBuildingBoChuJobDirectoryService
   ) {
      this.factoryService = factoryService;
      this.workshopService = workshopService;
      this.mesBuildingBoChuJobDirectoryService = mesBuildingBoChuJobDirectoryService;
   }
}
