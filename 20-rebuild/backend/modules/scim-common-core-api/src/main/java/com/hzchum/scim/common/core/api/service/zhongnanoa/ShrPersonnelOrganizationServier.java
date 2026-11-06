package com.hzchum.scim.common.core.api.service.zhongnanoa;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.scim.common.core.api.pojo._do.zhongnanoa.OaUserInfo;

public interface ShrPersonnelOrganizationServier extends IService<OaUserInfo> {
   ResultVO syncSHRDept();

   ResultVO syncSHRJob();

   ResultVO syncSHRUser();
}
