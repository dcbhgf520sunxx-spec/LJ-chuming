package com.hzchum.scim.scm.core.api.biz.scm;

import com.hzchum.pangu.common.util.IBiz;
import com.hzchum.scim.scm.core.api.pojo._doModel.scm.ScmSupplierConfig;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierConfigDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ReviewTemplateDTOParam;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierConfigDTOParam;
import java.util.List;

public interface ScmSupplierConfigBiz extends IBiz<ScmSupplierConfig> {
   List<ScmSupplierConfigDTO> listEvaluationCategory();

   Boolean editEvaluationCategory(List<ScmSupplierConfigDTOParam> params);

   List<ScmSupplierConfigDTO> listScoreRating();

   Boolean editScoreRating(List<ScmSupplierConfigDTOParam> params);

   List<ScmSupplierConfigDTO> listQualification();

   Boolean editQualification(List<ScmSupplierConfigDTOParam> params);

   ScmSupplierConfigDTO getReviewTemplate(Long classifyId);

   Boolean editReviewTemplate(ReviewTemplateDTOParam params);
}
