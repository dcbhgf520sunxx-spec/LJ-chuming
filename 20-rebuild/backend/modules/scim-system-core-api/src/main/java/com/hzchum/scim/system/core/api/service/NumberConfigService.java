package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.valid.ValidList;
import com.hzchum.scim.system.core.api.common.enums.NumberTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.NumberConfig;
import com.hzchum.scim.system.core.api.pojo.dto.NumberConfigDTOParam;

public interface NumberConfigService extends IService<NumberConfig> {
   ListVO listConfig();

   Boolean updateConfig(ValidList<NumberConfigDTOParam> request);

   String getNumber(NumberTypeEnum typeEnum, String contractNo, int count);

   String getNumber(NumberTypeEnum typeEnum, int count);

   String getNumber(NumberTypeEnum typeEnum, int count, String dateFormat);
}
