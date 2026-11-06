package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.contract.core.api.pojo._do.ContractFieldConfig;
import java.util.List;

public interface ContractFieldConfigService extends IService<ContractFieldConfig> {
   void checkField(List<Long> ids);
}
