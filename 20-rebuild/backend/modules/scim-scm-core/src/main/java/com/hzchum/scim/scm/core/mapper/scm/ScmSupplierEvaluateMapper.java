package com.hzchum.scim.scm.core.mapper.scm;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.scm.core.api.pojo._doModel.scm.ScmSupplierEvaluate;
import com.hzchum.scim.scm.core.api.pojo.dto.scm.ScmSupplierEvaluateDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.scm.ScmSupplierEvaluateQueryParam;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScmSupplierEvaluateMapper extends BaseMapper<ScmSupplierEvaluate> {
   List<ScmSupplierEvaluateDTO> listEvaluateRecords(@Param("param") ScmSupplierEvaluateQueryParam param);

   ScmSupplierEvaluateDTO getLatestEvaluateBySupplierIdAndYear(@Param("supplierId") Long supplierId, @Param("year") Integer year);
}
