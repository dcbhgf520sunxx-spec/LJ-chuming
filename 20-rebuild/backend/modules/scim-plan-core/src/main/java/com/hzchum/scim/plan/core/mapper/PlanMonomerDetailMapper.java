package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.PlanMonomerDetail;
import com.hzchum.scim.plan.core.api.pojo._do.PlanSummaryDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanMonomerDetailMapper extends BaseMapper<PlanMonomerDetail> {
   List<PlanSummaryDO> listByYearAndType(@Param("year") String year, @Param("type") Integer type, @Param("projectIds") List<Long> projectIds);
}
