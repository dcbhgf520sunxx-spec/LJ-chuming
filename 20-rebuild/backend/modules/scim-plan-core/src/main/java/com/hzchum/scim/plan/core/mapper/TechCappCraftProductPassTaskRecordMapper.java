package com.hzchum.scim.plan.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductPassTaskRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductCurrentVoltageVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardWeldingGatherVO;
import java.math.BigDecimal;
import java.util.List;

public interface TechCappCraftProductPassTaskRecordMapper extends BaseMapper<TechCappCraftProductPassTaskRecord> {
   List<CappCraftCardWeldingGatherVO> weldingGatherList(CappCraftCardWeldingGatherListDTO dto);

   List<CappCraftCardProductCurrentVoltageVO> weldingGatherDetail(
      Long passId,
      Boolean isWithinTheRatedRange,
      BigDecimal ratedMinElectricity,
      BigDecimal ratedMaxElectricity,
      BigDecimal ratedMinVoltage,
      BigDecimal ratedMaxVoltage
   );
}
