package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordMonthDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordUserDTO;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.ibatis.annotations.Param;

public interface TechDeepenRecordMapper extends BaseMapper<TechDeepenRecord> {
   List<DeepenRecordMonthDTO> selectListMonthDeepenMete(@NotNull @Param("year") Integer year);

   List<DeepenRecordProjectDTO> selectListProjectDeepenMete(
      @Param("year") Integer year, @Param("month") Integer month, @Param("projectIds") List<Long> projectIds
   );

   List<DeepenRecordUserDTO> selectListUserDeepenMete(@Param("year") Integer year, @Param("month") Integer month);

   BigDecimal selectUserDeepenMete(@Param("year") Integer year, @Param("month") Integer month, @Param("userId") Long userId);

   List<DeepenRecordProjectDTO> selectListProjectMete(@Param("year") Integer year, @Param("projectIds") List<Long> projectIds);
}
