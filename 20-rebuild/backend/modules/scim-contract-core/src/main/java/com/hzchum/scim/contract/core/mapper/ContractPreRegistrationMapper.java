package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractPreRegistration;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractPreRegistrationQueryDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContractPreRegistrationMapper extends BaseMapper<ContractPreRegistration> {
   Integer getCountByDay(@RequestParam("date") LocalDateTime date);

   List<ContractPreRegistration> listInfo(ContractPreRegistrationQueryDTOParam param);
}
