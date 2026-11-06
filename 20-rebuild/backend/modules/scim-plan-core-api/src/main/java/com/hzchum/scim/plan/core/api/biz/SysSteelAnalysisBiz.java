package com.hzchum.scim.plan.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import java.util.List;
import java.util.Map;

public interface SysSteelAnalysisBiz {
   PageVO analysis(Long projectId, List<Long> monomerIds, Integer pageNumber, Integer pageSize);

   PageVO inventoryDetails(Long projectId, String thickness, String material, Long configId, Long basicId, Integer pageNumber, Integer pageSize);

   PageVO useDetail(Long projectId, String thickness, String material, Long configId, Long basicId, Integer pageNumber, Integer pageSize);

   PrintVO<List<Map<String, Object>>> analysisPrint(Long projectId, List<Long> monomerIds);

   PrintVO<List<Map<String, Object>>> inventoryDetailsPrint(Long projectId, String thickness, String material, Long configId, Long basicId);

   PrintVO<List<Map<String, Object>>> useDetailPrint(Long projectId, String thickness, String material, Long configId, Long basicId);
}
