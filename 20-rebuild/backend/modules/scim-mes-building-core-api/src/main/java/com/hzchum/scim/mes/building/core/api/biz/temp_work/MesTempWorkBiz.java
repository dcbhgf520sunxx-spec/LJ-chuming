package com.hzchum.scim.mes.building.core.api.biz.temp_work;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.temp_work.MesTempWork;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.temp_work.MesTempWorkRecordDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.temp_work.MesTempWorkRecordQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesTempWorkBiz extends IBiz<MesTempWork> {
   PageVO<MesTempWorkDTO> myTempWork(LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize, List<String> sort);

   MesTempWorkDTO tempWorkDetail(Long id);

   Boolean add(MesTempWorkParam param);

   PageVO<MesTempWorkDTO> myTempWorkApproval(Integer pageNumber, Integer pageSize, List<String> sort);

   MesTempWorkDTO tempWorkApprovalDetail(Long id);

   PageVO<MesTempWorkDTO> approvalRecord(Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean approval(MesTempWorkApprovalParam param);

   PageVO<MesTempWorkRecordDTO> recordPage(MesTempWorkRecordQuery query, Integer pageNumber, Integer pageSize, List<String> sortList);

   Map<String, Object> recordSummary(MesTempWorkRecordQuery query);

   Map<String, Object> recordCumulativeSummary();

   void recordDownload(MesTempWorkRecordQuery query, HttpServletResponse response);
}
