package com.hzchum.scim.system.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.vo.ApproveInfoVO;
import com.hzchum.scim.system.core.api.common.enums.ApproveProcessTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.ApproveProcess;
import com.hzchum.scim.system.core.api.pojo.dto.DingDing.ApproveProcessDTO;
import com.hzchum.scim.system.core.api.pojo.request.ApprovalProcessDTOParam;
import com.hzchum.scim.system.core.api.pojo.request.ApproverDTOParam;
import java.util.List;

public interface ApproveProcessService extends IService<ApproveProcess> {
   void create(ApproveProcessTypeEnum type);

   List<ApproveProcessDTO> getList(Integer type);

   Boolean updateAP(ApprovalProcessDTOParam param);

   String getStrInfo(List<ApproverDTOParam> approveInfos);

   List<ApproveInfoVO> getObjInfo(String approveInfo);

   ApproveProcessDTO byId(Long id);

   List<NameInfo> getCode();

   Boolean saveAP(ApprovalProcessDTOParam param);

   Boolean delete(List<Long> ids);

   Boolean updateStatus(Integer status);

   Boolean getStatus();
}
