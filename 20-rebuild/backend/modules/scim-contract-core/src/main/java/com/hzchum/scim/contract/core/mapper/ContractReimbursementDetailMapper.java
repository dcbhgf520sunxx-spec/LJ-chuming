package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractReimbursementDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.ReimbursementDetailClassifyDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractReimbursementDetailMapper extends BaseMapper<ContractReimbursementDetail> {
   List<ReimbursementDetailClassifyDTO> selectDetailClassify(@Param("reimbursementId") Long reimbursementId);
}
