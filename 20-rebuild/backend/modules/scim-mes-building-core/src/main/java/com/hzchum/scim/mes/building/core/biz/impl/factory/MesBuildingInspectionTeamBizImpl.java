package com.hzchum.scim.mes.building.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsInspectionTeamLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingInspectionTeamBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.util.MesBuildingUtilsBiz;
import com.hzchum.scim.mes.building.core.api.enums.MesBuildingInspectionAndTeamEnum;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroups;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingGroupsInspectionTeamLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingInspectionTeamUserLink;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingInspectionTeamDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.factory.MesBuildingInspectionTeamUserLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingInspectionTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingInspectionTeamUserLinkDTOParam;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingInspectionTeamUserLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.mapper.factory.MesBuildingInspectionTeamMapper;
import com.hzchum.scim.system.core.api.common.enums.ProductionLineTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingInspectionTeamBizImpl
   extends IBizImpl<MesBuildingInspectionTeamService, MesBuildingInspectionTeamMapper, MesBuildingInspectionTeam>
   implements MesBuildingInspectionTeamBiz {
   @Autowired
   private MesBuildingInspectionTeamUserLinkService inspectionTeamUserLinkService;
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingProcessService processService;
   @Autowired
   private MesBuildingUtilsBiz utilsBiz;
   @Autowired
   private MesBuildingGroupsBiz mesBuildingGroupsBiz;
   @Autowired
   private MesBuildingGroupsInspectionTeamLinkBiz productionLineInspectionTeamLinkBiz;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveTeam(MesBuildingInspectionTeamDTOParam dtoParam) {
      this.utilsBiz
         .checkFactoryAndWorkshopAndProductionLineAndProcessIsExist(
            dtoParam.getFactoryId(),
            null,
            null,
            dtoParam.getProcessId(),
            dtoParam.getProductionLineTypeEnum(),
            MesBuildingInspectionAndTeamEnum.Inspection.getType()
         );
      this.checkInspectionTeamUser(dtoParam.getUserLinks(), dtoParam.getProcessId());
      MesBuildingInspectionTeam inspectionTeam = BeanUtil.copy(dtoParam, MesBuildingInspectionTeam.class);
      inspectionTeam.setUserId(UserUtil.getCurrentUserId());
      inspectionTeam.setFactoryId(dtoParam.getFactoryId());
      this.baseService.save(inspectionTeam);
      dtoParam.getUserLinks()
         .forEach(
            e -> this.inspectionTeamUserLinkService.save(BeanUtil.copy(e, MesBuildingInspectionTeamUserLink.class).setInspectionTeamId(inspectionTeam.getId()))
         );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateTeam(MesBuildingInspectionTeamDTOParam dtoParam) {
      Preconditions.checkArgument(this.baseService.getById(dtoParam.getId()) != null, "修改失败，未查询到相关班组");
      MesBuildingInspectionTeam inspectionTeam = BeanUtil.copy(dtoParam, MesBuildingInspectionTeam.class);
      MesBuildingProcess mesBuildingProcess = this.processService.getById(inspectionTeam.getProcessId());
      Preconditions.checkArgument(
         ProductTypeEnum.ASSEMBLE.getType().equals(mesBuildingProcess.getProductType())
            || ProductTypeEnum.ARTIFACT.getType().equals(mesBuildingProcess.getProductType()),
         "只有组立和构件能设置质检班组"
      );
      if (ProductTypeEnum.ASSEMBLE.getType().equals(mesBuildingProcess.getProductType())
         || ProductTypeEnum.MACHINE_PART.getType().equals(mesBuildingProcess.getProductType())) {
         Preconditions.checkArgument(ProductionLineTypeEnum.TRADITIONAL_LINE.getType().equals(inspectionTeam.getProductionLineTypeEnum()), "组立和零件无法设置为智能线");
      }

      this.baseService.updateById(inspectionTeam);
      this.inspectionTeamUserLinkService
         .remove(
            Wrappers.lambdaQuery(MesBuildingInspectionTeamUserLink.class).eq(MesBuildingInspectionTeamUserLink::getInspectionTeamId, inspectionTeam.getId())
         );
      this.checkInspectionTeamUser(dtoParam.getUserLinks(), inspectionTeam.getProcessId());
      dtoParam.getUserLinks()
         .forEach(
            e -> this.inspectionTeamUserLinkService.save(BeanUtil.copy(e, MesBuildingInspectionTeamUserLink.class).setInspectionTeamId(inspectionTeam.getId()))
         );
      return Boolean.TRUE;
   }

   @Override
   public List<MesBuildingInspectionTeamDTO> listByCondition(MesBuildingInspectionTeamDTOParam dtoParam) {
      LambdaQueryWrapper<MesBuildingInspectionTeam> wrapper = (LambdaQueryWrapper<MesBuildingInspectionTeam>)(new LambdaQueryWrapper<MesBuildingInspectionTeam>()
            .eq(dtoParam.getFactoryId() != null, MesBuildingInspectionTeam::getFactoryId, dtoParam.getFactoryId()))
         .eq(dtoParam.getProcessId() != null, MesBuildingInspectionTeam::getProcessId, dtoParam.getProcessId());
      List<MesBuildingInspectionTeam> inspectionTeamList = this.baseService.list(wrapper);
      List<MesBuildingInspectionTeamDTO> inspectionTeamDTOS = inspectionTeamList.stream()
         .map(e -> BeanUtil.copy(e, MesBuildingInspectionTeamDTO.class))
         .collect(Collectors.toList());
      inspectionTeamDTOS.forEach(
         e -> {
            MesBuildingProcess process = this.processService.getById(e.getProcessId());
            e.setProcessName(process.getName());
            e.setProductType(process.getProductType());
            List<MesBuildingInspectionTeamUserLink> mesBuildingInspectionTeamUserLinkList = this.inspectionTeamUserLinkService
               .list((Wrapper<MesBuildingInspectionTeamUserLink>)Wrappers.<MesBuildingInspectionTeamUserLink>lambdaQuery().eq(MesBuildingInspectionTeamUserLink::getInspectionTeamId, e.getId()));
            List<MesBuildingInspectionTeamUserLinkDTO> inspectionTeamUserLinkDTOS = new ArrayList<>();
            mesBuildingInspectionTeamUserLinkList.forEach(
               teamUser -> inspectionTeamUserLinkDTOS.add(BeanUtil.copy(teamUser, MesBuildingInspectionTeamUserLinkDTO.class))
            );
            e.setUserLinkList(inspectionTeamUserLinkDTOS);
         }
      );
      return inspectionTeamDTOS;
   }

   @Override
   public PageVO<MesBuildingInspectionTeamDTO> inspectionTeamPage(MesBuildingInspectionTeamDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listByCondition(dtoParam));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean deleteTeamByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            MesBuildingInspectionTeam inspectionTeam = this.baseService.getById(e);
            Preconditions.checkArgument(inspectionTeam != null, "删除失败，未查询到相关质检班组");
            List<MesBuildingGroupsInspectionTeamLink> productionLineInspectionTeamLinks = this.productionLineInspectionTeamLinkBiz
               .list(Wrappers.lambdaQuery(MesBuildingGroupsInspectionTeamLink.class).eq(MesBuildingGroupsInspectionTeamLink::getInspectionTeamId, e));
            Preconditions.checkArgument(productionLineInspectionTeamLinks == null || productionLineInspectionTeamLinks.size() == 0, "操作失败，请先删除生产线对应质检班组配置");
            this.baseService.removeById(e);
            this.inspectionTeamUserLinkService
               .remove(Wrappers.lambdaQuery(MesBuildingInspectionTeamUserLink.class).eq(MesBuildingInspectionTeamUserLink::getInspectionTeamId, e));
            this.taskBiz.deleteInspection(inspectionTeam);
         }
      );
      return true;
   }

   @Override
   public MesBuildingInspectionTeamDTO inspectionTeamById(Long id) {
      MesBuildingInspectionTeam inspectionTeam = this.baseService.getById(id);
      Preconditions.checkArgument(inspectionTeam != null, "查询失败，为查询到相关班组");
      MesBuildingInspectionTeamDTO dto = BeanUtil.copy(inspectionTeam, MesBuildingInspectionTeamDTO.class)
         .setProcessName(this.processService.getById(inspectionTeam.getProcessId()).getName());
      List<MesBuildingInspectionTeamUserLink> mesBuildingInspectionTeamUserLinkList = this.inspectionTeamUserLinkService
         .list(Wrappers.lambdaQuery(MesBuildingInspectionTeamUserLink.class).eq(MesBuildingInspectionTeamUserLink::getInspectionTeamId, dto.getId()));
      List<MesBuildingInspectionTeamUserLinkDTO> inspectionTeamUserLinkDTOS = new ArrayList<>();
      mesBuildingInspectionTeamUserLinkList.forEach(e -> inspectionTeamUserLinkDTOS.add(BeanUtil.copy(e, MesBuildingInspectionTeamUserLinkDTO.class)));
      dto.setUserLinkList(inspectionTeamUserLinkDTOS);
      return dto;
   }

   private void checkInspectionTeamUser(List<MesBuildingInspectionTeamUserLinkDTOParam> userLinkDTOParams, Long porcessId) {
      Preconditions.checkArgument(userLinkDTOParams.size() >= 1, "添加失败,未添加组长或组员");
      Preconditions.checkArgument(userLinkDTOParams.stream().noneMatch(e -> e.getUserName() == null), "添加失败，人员姓名不能为空");
      Preconditions.checkArgument(userLinkDTOParams.stream().noneMatch(e -> e.getUserId() == null), "添加失败，人员id不能为空");
      List<MesBuildingInspectionTeamUserLink> userLinks = this.inspectionTeamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesBuildingInspectionTeamUserLink.class)
               .in(
                  MesBuildingInspectionTeamUserLink::getUserId,
                  userLinkDTOParams.stream().map(MesBuildingInspectionTeamUserLinkDTOParam::getUserId).collect(Collectors.toList())
               )
         );
      if (userLinks != null && userLinks.size() > 0) {
         Preconditions.checkArgument(
            this.baseService
               .listByIds(userLinks.stream().map(MesBuildingInspectionTeamUserLink::getInspectionTeamId).collect(Collectors.toList()))
               .stream()
               .noneMatch(e -> e.getProcessId().equals(porcessId)),
            "操作失败，用户已存在其他班组"
         );
      }
   }

   @Override
   public List<MesBuildingInspectionTeam> selectByLine(List<Long> ids) {
      return this.baseService.selectByLine(ids);
   }

   @Override
   public List<MesBuildingGroups> selectGroupByLine(List<Long> lineIds) {
      return this.mesBuildingGroupsBiz.list(Wrappers.lambdaQuery(MesBuildingGroups.class).in(MesBuildingGroups::getProductionLineId, lineIds));
   }
}
