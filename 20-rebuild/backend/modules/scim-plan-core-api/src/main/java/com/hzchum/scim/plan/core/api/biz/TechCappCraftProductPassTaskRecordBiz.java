package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.plan.core.api.pojo._do.TechCappCraftProductPassTaskRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductCodeNumberListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardProductWeldCountDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherListDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingGatherUpdateDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.CappCraftCardWeldingListDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardBimVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductCodeNumberVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductCurrentVoltageVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardProductVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardWeldingGatherVO;
import com.hzchum.scim.plan.core.api.pojo.vo.CappCraftCardWeldingVO;
import java.util.List;

public interface TechCappCraftProductPassTaskRecordBiz extends IBiz<TechCappCraftProductPassTaskRecord> {
   Integer productWeldCount(CappCraftCardProductWeldCountDTO dto);

   List<CappCraftCardProductVO> productList(CappCraftCardProductListDTO dto);

   List<CappCraftCardWeldingVO> weldingList(CappCraftCardWeldingListDTO dto);

   List<CappCraftCardProductCodeNumberVO> productCodeNumberList(CappCraftCardProductCodeNumberListDTO dto);

   List<CappCraftCardProductCurrentVoltageVO> productCurrentVoltageList(Long passId);

   CappCraftCardBimVO productBimList(CappCraftCardProductListDTO dto);

   PageVO<CappCraftCardWeldingGatherVO> weldingGatherList(CappCraftCardWeldingGatherListDTO dto);

   List<CappCraftCardProductCurrentVoltageVO> weldingGatherDetail(CappCraftCardWeldingGatherDetailDTO dto);

   Boolean weldingGatherUpdate(List<CappCraftCardWeldingGatherUpdateDTO> dto);
}
