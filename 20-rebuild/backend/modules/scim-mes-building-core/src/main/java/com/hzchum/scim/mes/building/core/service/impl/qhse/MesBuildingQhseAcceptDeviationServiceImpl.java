package com.hzchum.scim.mes.building.core.service.impl.qhse;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.mes.building.core.api.biz.qhse.MesBuildingQhseBiz;
import com.hzchum.scim.mes.building.core.api.enums.AcceptDeviationStatusEnum;
import com.hzchum.scim.mes.building.core.api.enums.QhseStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhse;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.qhse.MesBuildingQhseAcceptDeviation;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseAcceptDeviationDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.qhse.MesBuildingQhseDTO;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseAcceptDeviationService;
import com.hzchum.scim.mes.building.core.api.service.qhse.MesBuildingQhseService;
import com.hzchum.scim.mes.building.core.mapper.qhse.MesBuildingQhseAcceptDeviationMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.service.UserRoleLinkService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MesBuildingQhseAcceptDeviationServiceImpl
   extends ServiceImpl<MesBuildingQhseAcceptDeviationMapper, MesBuildingQhseAcceptDeviation>
   implements MesBuildingQhseAcceptDeviationService {
   @Autowired
   private MesBuildingQhseBiz qhseBiz;
   @Autowired
   private MesBuildingQhseService qhseService;
   @Autowired
   private UserRoleLinkService userRoleLinkService;

   @Override
   protected void closeSqlSession(SqlSession sqlSession) {
      super.closeSqlSession(sqlSession);
   }

   @Override
   public PageVO<MesBuildingQhseDTO> findAcceptDeviationList(Integer status, Integer pageNumber, Integer pageSize) {
      Boolean hasPermission = this.userRoleLinkService.whetherUserHasPermission(UserUtil.getCurrentUserId(), "concessionAuditing");
      if (!hasPermission && !UserUtil.getCurrentUser().isAdmin()) {
         return new PageVO<>();
      }

      List<MesBuildingQhseAcceptDeviation> acceptDeviations = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(MesBuildingQhseAcceptDeviation.class)
               .eq(MesBuildingQhseAcceptDeviation::getStatus, status == null ? AcceptDeviationStatusEnum.UNAUDITED.getType() : status)
         );
      if (CollectionUtils.isEmpty(acceptDeviations)) {
         return new PageVO<>();
      }

      List<Long> qhseIds = acceptDeviations.stream().map(MesBuildingQhseAcceptDeviation::getQhseId).collect(Collectors.toList());
      return this.qhseBiz
         .qhsePage(null, null, null, null, null, null, null, null, null, null, null, pageNumber, pageSize, null, null, null, qhseIds, null, null, null);
   }

   @Transactional
   @Override
   public Boolean saveQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO) {
      MesBuildingQhse qhse = this.qhseService.getById(qhseAcceptDeviationDTO.getQhseId());
      Preconditions.checkArgument(qhse != null, "相关问题不存在");
      qhse.setStatus(QhseStatusEnum.CONCESSION_ACCEPTED.getType());
      this.qhseService.updateById(qhse);
      MesBuildingQhseAcceptDeviation qhseAcceptDeviation = new MesBuildingQhseAcceptDeviation();
      BeanUtils.copyProperties(qhseAcceptDeviationDTO, qhseAcceptDeviation);
      qhseAcceptDeviation.setUserId(UserUtil.getCurrentUserId());
      qhseAcceptDeviation.setStatus(AcceptDeviationStatusEnum.UNAUDITED.getType());
      return this.save(qhseAcceptDeviation);
   }

   @Transactional
   @Override
   public Boolean updateQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO) {
      MesBuildingQhse qhse = this.qhseService.getById(qhseAcceptDeviationDTO.getQhseId());
      Preconditions.checkArgument(qhse != null, "相关问题不存在");
      MesBuildingQhseAcceptDeviation acceptDeviation = this.baseMapper
         .selectOne(
            (Wrapper<MesBuildingQhseAcceptDeviation>)Wrappers.<MesBuildingQhseAcceptDeviation>lambdaQuery().eq(MesBuildingQhseAcceptDeviation::getQhseId, qhseAcceptDeviationDTO.getQhseId())
         );
      Preconditions.checkArgument(acceptDeviation != null, "找不到相关的让步接收审核记录");
      acceptDeviation.setApprovalRemark(qhseAcceptDeviationDTO.getApprovalRemark());
      if (qhseAcceptDeviationDTO.getStatus() == AcceptDeviationStatusEnum.RELEASED.getType()) {
         qhse.setStatus(QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType());
         acceptDeviation.setStatus(AcceptDeviationStatusEnum.RELEASED.getType());
      } else if (qhseAcceptDeviationDTO.getStatus() == AcceptDeviationStatusEnum.NOT_PASS.getType()) {
         qhse.setStatus(QhseStatusEnum.CONCESSION_ACCEPTED_UN_APPROVED.getType());
         acceptDeviation.setStatus(AcceptDeviationStatusEnum.NOT_PASS.getType());
      } else {
         Preconditions.checkArgument(false, "审核状态错误");
      }

      if (qhse.getFirstRectifyTime() == null) {
         qhse.setFirstRectifyTime(LocalDateTime.now());
      }

      this.qhseService.updateById(qhse);
      this.updateById(acceptDeviation);
      if (qhseAcceptDeviationDTO.getStatus() == AcceptDeviationStatusEnum.RELEASED.getType()) {
         this.qhseBiz.updateQhseStatus(qhseAcceptDeviationDTO.getQhseId(), QhseStatusEnum.CONCESSION_ACCEPTED_APPROVED.getType());
      }

      return true;
   }

   @Transactional
   @Override
   public Boolean rejectQhseAcceptDeviation(MesBuildingQhseAcceptDeviationDTO qhseAcceptDeviationDTO) {
      MesBuildingQhseAcceptDeviation acceptDeviation = this.baseMapper
         .selectOne(
            (Wrapper<MesBuildingQhseAcceptDeviation>)Wrappers.<MesBuildingQhseAcceptDeviation>lambdaQuery().eq(MesBuildingQhseAcceptDeviation::getQhseId, qhseAcceptDeviationDTO.getQhseId())
         );
      acceptDeviation.setStatus(AcceptDeviationStatusEnum.NOT_PASS.getType());
      acceptDeviation.setApprovalRemark(qhseAcceptDeviationDTO.getApprovalRemark());
      this.updateById(acceptDeviation);
      return true;
   }
}
