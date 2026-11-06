package com.hzchum.scim.bim.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimBridgeProductMeteGroupVO;
import com.hzchum.scim.bim.core.api.pojo.vo.BimProductMeteGroupVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimArtifactVO;
import com.hzchum.scim.plan.core.api.pojo.vo.BimBoxOrElementsVO;
import java.util.List;
import java.util.Map;

public interface BimModelBiz {
   Map<String, List<String>> getOldArtifactStatus(Long fileId, Integer menuBar);

   Map<String, List<String>> getArtifactStatus(Long fileId, Integer menuBar);

   Map<String, List<String>> getBridgeStatus(Long fileId, Integer menuBar);

   ListVO getProjectTree(Long fileId);

   ListVO getBridgeProjectTree(Long fileId);

   BimArtifactVO getArtifactInfo(Long fileId, String elementId, Integer menuBar);

   BimBoxOrElementsVO getBridgeSegmentationInfo(Long fileId, String elementId, Integer menuBar);

   ListVO getProduction(Long fileId, Integer menuBar);

   ListVO getBridgeProduction(Long fileId, Integer menuBar);

   BimProductMeteGroupVO getDetailsByStatus(Long fileId, Integer status, Integer menuBar);

   BimBridgeProductMeteGroupVO getBridgeDetailsByStatus(Long fileId, Integer status, Integer menuBar);

   ListVO getLogisticsByBim(Long fileId);

   ListVO getBridgeLogisticsByBim(Long fileId);
}
