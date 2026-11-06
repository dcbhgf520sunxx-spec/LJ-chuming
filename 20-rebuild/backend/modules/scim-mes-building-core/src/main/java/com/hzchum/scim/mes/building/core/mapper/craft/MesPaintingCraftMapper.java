package com.hzchum.scim.mes.building.core.mapper.craft;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraft;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintingCraftDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftQuery;
import java.time.LocalDateTime;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesPaintingCraftMapper extends BaseMapper<MesPaintingCraft> {
   Integer getMaxDigit(@Param("prefix") String prefix);

   List<MesPaintingCraftDTO> listInfo(MesPaintingCraftQuery query);

   MesPaintingCraftDTO detailById(@Param("id") Long id);

   MesPaintingCraftDTO approvalDataDetailById(@Param("id") Long id);

   MesPaintingCraft selectApprovalDataById(@Param("id") Long id);

   MesPaintingCraft selectApprovalDataByOldId(@Param("oldId") Long oldId);

   int approvalDataUpdateById(
      @Param("id") Long id,
      @Param("approvalStatus") Integer approvalStatus,
      @Param("approvalUserId") Long approvalUserId,
      @Param("approvalTime") LocalDateTime approvalTime,
      @Param("boolInApproval") Boolean boolInApproval
   );
}
