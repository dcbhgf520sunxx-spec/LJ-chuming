package com.hzchum.scim.system.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountDTO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyConditionVO;
import com.hzchum.scim.system.core.api.pojo.dto.BranchCompanyDTO;
import java.util.List;

public interface BranchCompanyMapper extends BaseMapper<BranchCompany> {
   List<BranchCompanyDTO> listByCondition(BranchCompanyConditionVO vo);

   List<BankAccountDTO> listBlankAccount();
}
