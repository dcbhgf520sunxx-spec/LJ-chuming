package com.hzchum.scim.common.core.api.service.zhongnanoa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.common.core.api.pojo._do.zhongnanoa.OaUserInfo;

public interface OaPersonnelOrganizationServier extends IService<OaUserInfo> {
   String getToken();

   String getHrmsubcompanyWithPage(String id, String supsubcomid);

   String getHrmdepartmentWithPage(String subcompanyid1, String departmentcode);

   String getJobtitleInfoWithPage();

   String getHrmUserInfoWithPage(String subcompanyid1, String workcode);

   String getCreateWorkflowList(String userId);
}
