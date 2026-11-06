package com.hzchum.scim.bid.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTenderingSupplier;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubject;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundDetailVO;
import com.hzchum.scim.bid.core.api.pojo.vo.OfferRoundsVO;
import com.hzchum.scim.bid.core.api.pojo.vo.SubjectProjectVO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderingSupplierVO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectTenderingSupplierMapper extends BaseMapper<ProjectTenderingSupplier> {
   List<SupplierSubject> getNotOffer(@Param("id") Long id);

   List<OfferRoundsVO> getOfferRounds(@Param("id") Long id);

   List<OfferRoundsVO> getOfferRoundsBid(@Param("id") Long id, @Param("supplierId") Long supplierId);

   List<SubjectProjectVO> getOfferRoundsBidDetail(@Param("id") Long id, @Param("supplierId") Long supplierId);

   List<OfferRoundDetailVO> getOfferRoundDetail(@Param("projectId") Long id, @Param("supplierId") Long supplierId, @Param("isHold") Integer isHold);

   List<SubjectProjectVO> getWinBidding(@Param("projectId") Long id);

   List<OfferRoundDetailVO> getEvaluationDetails(@Param("projectId") Long id, @Param("round") Integer round);

   List<OfferRoundDetailVO> getEvaluationDetailsAndRound(@Param("projectId") Long id);

   List<SubjectProjectVO> getSupplierOfferDetails(@Param("projectId") Long id, @Param("supplierId") Long supplierId);

   List<SupplierSubject> getSupplierOfferRound(@Param("projectId") Long id, @Param("round") Integer round);

   List<TenderingSupplierVO> getSupplierByProjectId(@Param("projectId") Long projectId, @Param("supplierIds") List<Long> ids);
}
