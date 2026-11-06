package com.hzchum.scim.mes.building.core.api.biz.craft;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.dtoParam.ApprovalParam;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintingCraft;
import com.hzchum.scim.mes.building.core.api.pojo._dto.craft.MesPaintingCraftDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.MesPaintingCraftQuery;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft.PaintingCalculationExcel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

public interface MesPaintingCraftBiz extends IBiz<MesPaintingCraft> {
   PageVO<MesPaintingCraftDTO> pageInfo(MesPaintingCraftQuery query, Integer pageNumber, Integer pageSize, List<String> sort);

   Boolean add(MesPaintingCraftParam param);

   Boolean edit(MesPaintingCraftParam param);

   Boolean approval(ApprovalParam param);

   Boolean cancelApproval(Long id);

   Boolean invalid(Long id);

   MesPaintingCraftDTO detailById(Long id);

   void paintingCalculationDownload(List<PaintingCalculationExcel> excelList, HttpServletResponse response);

   PrintVO<List<Map<String, Object>>> listPrint(MesPaintingCraftQuery query);

   PrintVO<List<Map<String, Object>>> detailPrint(Long id);

   BigDecimal getSurfaceArea(Long projectId, List<Long> monomerIdList);

   List<NameInfo> getApprovedList();

   MesPaintingCraftDTO approvalDetail(Long id);

   PrintVO<List<Map<String, Object>>> approvalDetailPrint(Long id);
}
