package com.hzchum.scim.plan.core.api.biz.approve;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanApproveOpinionDTOParam;
import com.hzchum.scim.plan.core.api.pojo.dtoParam.TechArtifactProcessFileSaveDTOParam;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface TechnologicalAchievementBiz {
   ResultVO commonApprove(PlanApproveOpinionDTOParam planApproveOpinionDTOParam) throws Exception;

   Boolean OaCommonApprove(PlanApproveOpinionDTOParam planApproveOpinionDTOParam) throws Exception;

   ResultVO<Object> getApproveDetail(long approvalRecordId);

   Boolean cancelApproveDetail(long approvalRecordId);

   ResultVO createDrawingApprove(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long dataId,
      Integer dataType,
      Integer productType,
      Long productId,
      String fileName,
      Integer cover,
      Boolean normal,
      HttpServletResponse response
   ) throws Exception;

   ResultVO createAllDrawingApprove(
      MultipartFile multipartFile,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long dataId,
      Integer dataType,
      Integer productType,
      Long productId,
      String fileName,
      Integer cover,
      Boolean normal,
      HttpServletResponse response
   ) throws Exception;

   ResultVO createTechnologyApprove(TechArtifactProcessFileSaveDTOParam param) throws RuntimeException;

   void downloadFile(Long id, Long approvalRecordId);
}
