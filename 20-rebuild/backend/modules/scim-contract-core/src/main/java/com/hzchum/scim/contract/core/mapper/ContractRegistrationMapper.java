package com.hzchum.scim.contract.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzchum.scim.contract.core.api.pojo._do.ContractRegistration;
import com.hzchum.scim.contract.core.api.pojo._doParam.ContractRegistrationQueryDTOParam;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContractRegistrationMapper extends BaseMapper<ContractRegistration> {
   Integer getCountByDay(@RequestParam("date") LocalDateTime date, @RequestParam("registrationType") Integer registrationType);

   List<ContractRegistration> listInfo(ContractRegistrationQueryDTOParam param);
}
