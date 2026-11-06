package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTenderingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubject;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundDetailVO;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundsVO;
import com.hzchum.scim.bid.core.api.pojo.vo.SubjectProjectVO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderingSupplierVO;
import java.util.List;

public interface ProjectTenderingSupplierService extends IService<ProjectTenderingSupplier> {
   List<TenderingSupplierVO> getSupplierByProjectId(Long projectId, List<Long> ids);

   List<OfferRoundDetailVO> getEvaluationDetailsAndRound(Long id);

   List<SubjectProjectVO> getWinBidding(Long id);

   List<OfferRoundsVO> getOfferRounds(Long id);

   List<OfferRoundDetailVO> getEvaluationDetails(Long id, Integer round);

   List<OfferRoundDetailVO> getOfferRoundDetail(Long id, Long supplierId, Integer isHold);

   List<SupplierSubject> getNotOffer(Long id);

   List<SupplierSubject> getSupplierOfferRound(Long id, Integer round);
}
