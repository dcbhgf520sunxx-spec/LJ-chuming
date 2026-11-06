package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.FormComponentValue;
import com.hzchum.scim.system.core.api.pojo._do.ApproveInstance;
import java.util.List;

public interface ApproveInstanceService extends IService<ApproveInstance> {
   void createApproveInstance(Long receiptId, Long approveProcessId, List<FormComponentValue> values, String info);

   void handleApproveInstanceService(Integer approveStatus, ApproveInstance approveInstance, String staffId);
}
