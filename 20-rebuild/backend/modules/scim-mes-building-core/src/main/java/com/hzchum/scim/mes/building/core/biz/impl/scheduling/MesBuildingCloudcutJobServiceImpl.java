package com.hzchum.scim.mes.building.core.biz.impl.scheduling;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingCloudcutJobService;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingCloudcutResultService;
import com.hzchum.scim.mes.building.core.api.enums.scheduling.CutSendEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutJob;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.scheduling.MesBuildingCloudcutResult;
import com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling.MesBuildingCloudcutJobDTO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.scheduling.MesBuildingCloudcutJobVO;
import com.hzchum.scim.mes.building.core.mapper.scheduling.MesBuildingCloudcutJobMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingCloudcutJobServiceImpl
   extends ServiceImpl<MesBuildingCloudcutJobMapper, MesBuildingCloudcutJob>
   implements MesBuildingCloudcutJobService {
   @Resource
   private MesBuildingCloudcutResultService mesBuildingCloudcutResultService;

   @Override
   public List<MesBuildingCloudcutJobVO> pageMesBuildingCloudcutJob(MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO) {
      List<MesBuildingCloudcutJobVO> mesBuildingCloudcutJobVOList = this.baseMapper.pageMesBuildingCloudcutJob(mesBuildingCloudcutJobDTO);
      return buildTree(mesBuildingCloudcutJobVOList);
   }

   public static List<MesBuildingCloudcutJobVO> buildTree(List<MesBuildingCloudcutJobVO> data) {
      Map<Long, MesBuildingCloudcutJobVO> nodeMap = new HashMap<>();

      for (MesBuildingCloudcutJobVO job : data) {
         nodeMap.put(job.getId(), job);
      }

      List<MesBuildingCloudcutJobVO> rootNodes = new ArrayList<>();

      for (MesBuildingCloudcutJobVO job : data) {
         if (job.getParentId() == null) {
            rootNodes.add(job);
         } else {
            MesBuildingCloudcutJobVO parentNode = nodeMap.get(job.getParentId());
            if (parentNode != null) {
               parentNode.addChild(job);
            }
         }
      }

      return rootNodes;
   }

   @Override
   public Integer saveMesBuildingCloudcutJob(MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO) {
      MesBuildingCloudcutJob mesBuildingCloudcutJob = new MesBuildingCloudcutJob();
      List<MesBuildingCloudcutJob> mesBuildingCloudcutJobList = this.list(
         (Wrapper<MesBuildingCloudcutJob>)((new LambdaQueryWrapper<MesBuildingCloudcutJob>()
                  .eq(MesBuildingCloudcutJob::getCloudcutName, mesBuildingCloudcutJobDTO.getCloudcutName()))
               .eq(MesBuildingCloudcutJob::getWorkshopId, mesBuildingCloudcutJobDTO.getWorkshopId()))
            .eq(MesBuildingCloudcutJob::getParentId, mesBuildingCloudcutJobDTO.getParentId())
      );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingCloudcutJobList), "作业单名称已经存在");
      BeanUtil.copy(mesBuildingCloudcutJobDTO, mesBuildingCloudcutJob);
      return this.baseMapper.insert(mesBuildingCloudcutJob);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Integer updateMesBuildingCloudcutJob(MesBuildingCloudcutJobDTO mesBuildingCloudcutJobDTO) {
      MesBuildingCloudcutJob mesBuildingCloudcutJob = new MesBuildingCloudcutJob();
      BeanUtil.copy(mesBuildingCloudcutJobDTO, mesBuildingCloudcutJob);
      return this.baseMapper.updateById(mesBuildingCloudcutJob);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteMesBuildingCloudcutJob(List<Long> idList) {
      List<MesBuildingCloudcutJob> mesBuildingCloudcutJobList = this.list(
         (Wrapper<MesBuildingCloudcutJob>)new LambdaQueryWrapper<MesBuildingCloudcutJob>().in(MesBuildingCloudcutJob::getParentId, idList)
      );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingCloudcutJobList), "该排产单下存在子作业，无法删除!");
      List<MesBuildingCloudcutResult> mesBuildingCloudcutResultList = this.mesBuildingCloudcutResultService
         .list(
            (Wrapper<MesBuildingCloudcutResult>)(new LambdaQueryWrapper<MesBuildingCloudcutResult>().in(MesBuildingCloudcutResult::getCloudcutId, idList))
               .eq(MesBuildingCloudcutResult::getCutSendStatus, CutSendEnum.DISPATCHED.getCode())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(mesBuildingCloudcutResultList), "该排产单下已存在下发的作业单，无法删除!");
      return this.removeByIds(idList);
   }

   @Override
   public List<MesBuildingCloudcutJobVO> teamList() {
      return this.baseMapper.teamList();
   }
}
