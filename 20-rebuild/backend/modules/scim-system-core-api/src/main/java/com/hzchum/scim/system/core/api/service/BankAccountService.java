package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.system.core.api.pojo._do.BankAccount;
import com.hzchum.scim.system.core.api.pojo.dto.BankAccountVO;

public interface BankAccountService extends IService<BankAccount> {
   ListVO<BankAccountVO> listByCompanyId(Long companyId);
}
