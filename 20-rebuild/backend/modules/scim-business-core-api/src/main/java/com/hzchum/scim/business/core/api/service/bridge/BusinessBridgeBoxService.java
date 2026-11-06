package com.hzchum.scim.business.core.api.service.bridge;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.business.core.api.pojo.doModel.bridge.BusinessBridgeBox;
import com.hzchum.scim.business.core.api.pojo.dtoParam.bridge.BridgeBoxAddDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.bridge.BridgeBoxEditDTOParam;
import com.hzchum.scim.business.core.api.pojo.dtoParam.bridge.BridgeBoxFindDTOParam;

public interface BusinessBridgeBoxService extends IService<BusinessBridgeBox> {
   Long addBusinessInfo(BridgeBoxAddDTOParam param);

   BusinessBridgeBox getByCondition(BridgeBoxFindDTOParam param);

   void editBusinessInfo(BridgeBoxEditDTOParam param);
}
