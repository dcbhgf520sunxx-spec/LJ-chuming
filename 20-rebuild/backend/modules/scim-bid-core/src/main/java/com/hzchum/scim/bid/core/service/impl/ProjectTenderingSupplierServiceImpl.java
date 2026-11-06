package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTenderingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubject;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundDetailVO;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundsVO;
import com.hzchum.scim.bid.core.api.pojo.vo.SubjectProjectVO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderingSupplierVO;
import com.hzchum.scim.bid.core.api.service.ProjectTenderingSupplierService;
import com.hzchum.scim.bid.core.mapper.ProjectTenderingSupplierMapper;
import java.util.List;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class ProjectTenderingSupplierServiceImpl
   extends ServiceImpl<ProjectTenderingSupplierMapper, ProjectTenderingSupplier>
   implements ProjectTenderingSupplierService {
   @Override
   public List<TenderingSupplierVO> getSupplierByProjectId(Long projectId, List<Long> ids) {
      return this.baseMapper.getSupplierByProjectId(projectId, ids);
   }

   @Override
   public List<OfferRoundDetailVO> getEvaluationDetailsAndRound(Long id) {
      return this.baseMapper.getEvaluationDetailsAndRound(id);
   }

   @Override
   public List<SubjectProjectVO> getWinBidding(Long id) {
      return this.baseMapper.getWinBidding(id);
   }

   @Override
   public List<OfferRoundsVO> getOfferRounds(Long id) {
      return this.baseMapper.getOfferRounds(id);
   }

   @Override
   public List<OfferRoundDetailVO> getEvaluationDetails(Long id, Integer round) {
      return this.baseMapper.getEvaluationDetails(id, round);
   }

   @Override
   public List<OfferRoundDetailVO> getOfferRoundDetail(Long id, Long supplierId, Integer isHold) {
      return this.baseMapper.getOfferRoundDetail(id, supplierId, isHold);
   }

   @Override
   public List<SupplierSubject> getNotOffer(Long id) {
      return this.baseMapper.getNotOffer(id);
   }

   @Override
   public List<SupplierSubject> getSupplierOfferRound(Long id, Integer round) {
      return this.baseMapper.getSupplierOfferRound(id, round);
   }
}
