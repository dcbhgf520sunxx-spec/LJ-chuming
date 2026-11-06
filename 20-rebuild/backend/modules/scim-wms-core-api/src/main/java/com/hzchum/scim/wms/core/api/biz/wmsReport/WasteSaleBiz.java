package com.hzchum.scim.wms.core.api.biz.wmsReport;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.dto.BasicClassMeteAndAmountDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsReport.WasteSale;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsReport.WasteSaleDetailWholeInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleCheckDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDetailQueryDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleDtoParam;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport.WasteSaleQueryDtoParam;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface WasteSaleBiz extends IBiz<WasteSale> {
   PageVO<WasteSaleDTO> pageList(WasteSaleQueryDtoParam queryDtoParam, Integer pageNumber, Integer pageSize);

   PrintVO<List<WasteSaleDTO>> printList(WasteSaleQueryDtoParam queryDtoParam);

   Boolean downLoadWasteSale(Long id, HttpServletResponse response);

   PageVO<WasteSaleDetailWholeInfoDTO> pageListDetail(WasteSaleDetailQueryDtoParam param, Integer pageNumber, Integer pageSize);

   PrintVO<List<WasteSaleDetailWholeInfoDTO>> printListDetail(WasteSaleDetailQueryDtoParam param);

   Boolean saveList(List<WasteSaleDtoParam> paramList);

   Boolean updateList(List<WasteSaleDtoParam> paramList);

   Boolean auditWasteSale(WasteSaleCheckDtoParam param);

   Boolean deleteList(List<Long> ids);

   List<BasicClassMeteAndAmountDTO> getAmountByMonth(Long sysBranchCompanyByProjectId, LocalDateTime startTime, LocalDateTime endTime);
}
