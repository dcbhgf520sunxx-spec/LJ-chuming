package com.hzchum.scim.mes.enclosure.core.biz.impl.factory;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.IBizImpl;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureInspectionTeamBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.factory.MesEnclosureLineInspectionTeamLinkBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.task.MesEnclosureTaskBiz;
import com.hzchum.scim.mes.enclosure.core.api.biz.util.MesEnclosureUtilsBiz;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureInspectionTeamUserLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.factory.MesEnclosureLineInspectionTeamLink;
import com.hzchum.scim.mes.enclosure.core.api.pojo._doModel.process.MesEnclosureProcess;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureInspectionTeamDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory.MesEnclosureInspectionTeamUserLinkDTO;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureInspectionTeamDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.factory.MesEnclosureInspectionTeamUserLinkDTOParam;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureInspectionTeamService;
import com.hzchum.scim.mes.enclosure.core.api.service.factory.MesEnclosureInspectionTeamUserLinkService;
import com.hzchum.scim.mes.enclosure.core.api.service.process.MesEnclosureProcessService;
import com.hzchum.scim.mes.enclosure.core.mapper.factory.MesEnclosureInspectionTeamMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesEnclosureInspectionTeamBizImpl
   extends IBizImpl<MesEnclosureInspectionTeamService, MesEnclosureInspectionTeamMapper, MesEnclosureInspectionTeam>
   implements MesEnclosureInspectionTeamBiz {
   @Autowired
   private MesEnclosureInspectionTeamUserLinkService inspectionTeamUserLinkService;
   @Autowired
   private MesEnclosureTaskBiz taskBiz;
   @Autowired
   private MesEnclosureProcessService processService;
   @Autowired
   private MesEnclosureUtilsBiz utilsBiz;
   @Autowired
   private MesEnclosureLineInspectionTeamLinkBiz productionLineInspectionTeamLinkBiz;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveTeam(MesEnclosureInspectionTeamDTOParam dtoParam) {
      this.checkInspectionTeamUser(dtoParam.getUserLinks(), dtoParam.getProcessId());
      MesEnclosureInspectionTeam inspectionTeam = BeanUtil.copy(dtoParam, MesEnclosureInspectionTeam.class);
      inspectionTeam.setUserId(UserUtil.getCurrentUserId());
      inspectionTeam.setFactoryId(dtoParam.getFactoryId());
      inspectionTeam.setProcessId(this.processService.list().get(0).getId());
      this.baseService.save(inspectionTeam);
      dtoParam.getUserLinks()
         .forEach(
            e -> this.inspectionTeamUserLinkService
               .save(BeanUtil.copy(e, MesEnclosureInspectionTeamUserLink.class).setInspectionTeamId(inspectionTeam.getId()))
         );
      return Boolean.TRUE;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateTeam(MesEnclosureInspectionTeamDTOParam dtoParam) {
      Preconditions.checkArgument(this.baseService.getById(dtoParam.getId()) != null, "修改失败，未查询到相关班组");
      MesEnclosureInspectionTeam inspectionTeam = BeanUtil.copy(dtoParam, MesEnclosureInspectionTeam.class);
      MesEnclosureProcess mesEnclosureProcess = this.processService.getById(inspectionTeam.getProcessId());
      this.baseService.updateById(inspectionTeam);
      this.inspectionTeamUserLinkService
         .remove(
            Wrappers.lambdaQuery(MesEnclosureInspectionTeamUserLink.class).eq(MesEnclosureInspectionTeamUserLink::getInspectionTeamId, inspectionTeam.getId())
         );
      this.checkInspectionTeamUser(dtoParam.getUserLinks(), inspectionTeam.getProcessId());
      dtoParam.getUserLinks()
         .forEach(
            e -> this.inspectionTeamUserLinkService
               .save(BeanUtil.copy(e, MesEnclosureInspectionTeamUserLink.class).setInspectionTeamId(inspectionTeam.getId()))
         );
      return Boolean.TRUE;
   }

   @Override
   public List<MesEnclosureInspectionTeamDTO> listByCondition(MesEnclosureInspectionTeamDTOParam dtoParam) {
      LambdaQueryWrapper<MesEnclosureInspectionTeam> wrapper = (LambdaQueryWrapper<MesEnclosureInspectionTeam>)(new LambdaQueryWrapper<MesEnclosureInspectionTeam>()
            .eq(dtoParam.getFactoryId() != null, MesEnclosureInspectionTeam::getFactoryId, dtoParam.getFactoryId()))
         .eq(dtoParam.getProcessId() != null, MesEnclosureInspectionTeam::getProcessId, dtoParam.getProcessId());
      List<MesEnclosureInspectionTeam> inspectionTeamList = this.baseService.list(wrapper);
      List<MesEnclosureInspectionTeamDTO> inspectionTeamDTOS = inspectionTeamList.stream()
         .map(e -> BeanUtil.copy(e, MesEnclosureInspectionTeamDTO.class))
         .collect(Collectors.toList());
      inspectionTeamDTOS.forEach(
         e -> {
            MesEnclosureProcess process = this.processService.getById(e.getProcessId());
            e.setProcessName(process.getName());
            List<MesEnclosureInspectionTeamUserLink> mesEnclosureInspectionTeamUserLinkList = this.inspectionTeamUserLinkService
               .list((Wrapper<MesEnclosureInspectionTeamUserLink>)Wrappers.<MesEnclosureInspectionTeamUserLink>lambdaQuery().eq(MesEnclosureInspectionTeamUserLink::getInspectionTeamId, e.getId()));
            List<MesEnclosureInspectionTeamUserLinkDTO> inspectionTeamUserLinkDTOS = new ArrayList<>();
            mesEnclosureInspectionTeamUserLinkList.forEach(
               teamUser -> inspectionTeamUserLinkDTOS.add(BeanUtil.copy(teamUser, MesEnclosureInspectionTeamUserLinkDTO.class))
            );
            e.setUserLinkList(inspectionTeamUserLinkDTOS);
         }
      );
      return inspectionTeamDTOS;
   }

   @Override
   public PageVO<MesEnclosureInspectionTeamDTO> inspectionTeamPage(
      MesEnclosureInspectionTeamDTOParam dtoParam, String sort, Integer pageNumber, Integer pageSize
   ) {
      return new PageVO<>(PageHelper.startPage(pageNumber, pageSize), this.listByCondition(dtoParam));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public boolean deleteTeamByIds(List<Long> ids) {
      ids.forEach(
         e -> {
            MesEnclosureInspectionTeam inspectionTeam = this.baseService.getById(e);
            Preconditions.checkArgument(inspectionTeam != null, "删除失败，未查询到相关质检班组");
            List<MesEnclosureLineInspectionTeamLink> productionLineInspectionTeamLinks = this.productionLineInspectionTeamLinkBiz
               .list(Wrappers.lambdaQuery(MesEnclosureLineInspectionTeamLink.class).eq(MesEnclosureLineInspectionTeamLink::getInspectionTeamId, e));
            Preconditions.checkArgument(productionLineInspectionTeamLinks == null || productionLineInspectionTeamLinks.size() == 0, "操作失败，请先删除生产线对应质检班组配置");
            this.baseService.removeById(e);
            this.inspectionTeamUserLinkService
               .remove(Wrappers.lambdaQuery(MesEnclosureInspectionTeamUserLink.class).eq(MesEnclosureInspectionTeamUserLink::getInspectionTeamId, e));
         }
      );
      return true;
   }

   @Override
   public MesEnclosureInspectionTeamDTO inspectionTeamById(Long id) {
      MesEnclosureInspectionTeam inspectionTeam = this.baseService.getById(id);
      Preconditions.checkArgument(inspectionTeam != null, "查询失败，为查询到相关班组");
      MesEnclosureInspectionTeamDTO dto = BeanUtil.copy(inspectionTeam, MesEnclosureInspectionTeamDTO.class)
         .setProcessName(this.processService.getById(inspectionTeam.getProcessId()).getName());
      List<MesEnclosureInspectionTeamUserLink> mesEnclosureInspectionTeamUserLinkList = this.inspectionTeamUserLinkService
         .list(Wrappers.lambdaQuery(MesEnclosureInspectionTeamUserLink.class).eq(MesEnclosureInspectionTeamUserLink::getInspectionTeamId, dto.getId()));
      List<MesEnclosureInspectionTeamUserLinkDTO> inspectionTeamUserLinkDTOS = new ArrayList<>();
      mesEnclosureInspectionTeamUserLinkList.forEach(e -> inspectionTeamUserLinkDTOS.add(BeanUtil.copy(e, MesEnclosureInspectionTeamUserLinkDTO.class)));
      dto.setUserLinkList(inspectionTeamUserLinkDTOS);
      return dto;
   }

   private void checkInspectionTeamUser(List<MesEnclosureInspectionTeamUserLinkDTOParam> userLinkDTOParams, Long porcessId) {
      Preconditions.checkArgument(userLinkDTOParams.size() >= 1, "添加失败,未添加组长或组员");
      Preconditions.checkArgument(userLinkDTOParams.stream().noneMatch(e -> e.getUserName() == null), "添加失败，人员姓名不能为空");
      Preconditions.checkArgument(userLinkDTOParams.stream().noneMatch(e -> e.getUserId() == null), "添加失败，人员id不能为空");
      List<MesEnclosureInspectionTeamUserLink> userLinks = this.inspectionTeamUserLinkService
         .list(
            Wrappers.lambdaQuery(MesEnclosureInspectionTeamUserLink.class)
               .in(
                  MesEnclosureInspectionTeamUserLink::getUserId,
                  userLinkDTOParams.stream().map(MesEnclosureInspectionTeamUserLinkDTOParam::getUserId).collect(Collectors.toList())
               )
         );
      if (userLinks != null && userLinks.size() > 0) {
         Preconditions.checkArgument(
            this.baseService
               .listByIds(userLinks.stream().map(MesEnclosureInspectionTeamUserLink::getInspectionTeamId).collect(Collectors.toList()))
               .stream()
               .noneMatch(e -> e.getProcessId().equals(porcessId)),
            "操作失败，用户已存在其他班组"
         );
      }
   }

   @Override
   public List<MesEnclosureInspectionTeam> selectByLine(List<Long> ids) {
      return this.baseService.selectByLine(ids);
   }
}
