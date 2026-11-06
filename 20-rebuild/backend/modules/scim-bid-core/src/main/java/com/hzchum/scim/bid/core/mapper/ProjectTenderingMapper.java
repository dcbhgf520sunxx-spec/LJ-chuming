package com.hzchum.scim.bid.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import com.hzchum.scim.bid.core.api.pojo.dto.TendQueryConditionsDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.BiddingOverviewVO;
import com.hzchum.scim.bid.core.api.pojo.vo.ProjectTenderingVO;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectTenderingMapper extends BaseMapper<ProjectTendering> {
   List<ProjectTenderingVO> selectListByValue(
      @Param("dto") TendQueryConditionsDTO dto,
      @Param("startDateVerifier") Date startDateVerifier,
      @Param("endDateVerifier") Date endDateVerifier,
      @Param("startDate") Date startDate,
      @Param("endDate") Date endDate,
      @Param("menu") Integer menu,
      @Param("uuid") String UUID
   );

   List<ProjectTenderingVO> getProjectAll(@Param("UUID") String UUID);

   List<ProjectTendering> getProject(@Param("UUID") String UUID);

   ProjectTenderingVO selectByProjectId(@Param("id") Long id);

   List<BiddingOverviewVO> getOverview(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("uuid") String uuid);

   List<BiddingOverviewVO> getBidType(
      @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("projectType") Long projectType, @Param("uuid") String uuid
   );
}
