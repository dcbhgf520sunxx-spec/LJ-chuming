package com.hzchum.scim.scm.core.api.biz.scm;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.scm.core.api.pojo._doModel.scm.ScmSupplierEvaluate;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierEvaluateDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierEvaluateDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierEvaluateQueryParam;
import javax.servlet.http.HttpServletResponse;

public interface ScmSupplierEvaluateBiz extends IBiz<ScmSupplierEvaluate> {
   Boolean addEvaluate(ScmSupplierEvaluateDTOParam param);

   PageVO<ScmSupplierEvaluateDTO> listEvaluateRecords(ScmSupplierEvaluateQueryParam param);

   void listEvaluateRecordsDownload(ScmSupplierEvaluateQueryParam query, HttpServletResponse response);

   ScmSupplierEvaluateDTO getLatestEvaluateBySupplierId(Long supplierId);

   ScmSupplierEvaluateDTO getEvaluateDetailById(Long evaluateId);

   void exportEvaluateDetail(Long evaluateId, HttpServletResponse response);

   Boolean checkEvaluate(Long evaluateId, Integer decision, String opinion);

   Boolean cancelApproveEvaluate(Long evaluateId);
}
