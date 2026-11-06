package com.hzchum.scim.system.core.biz.impl.gdMap;

import com.hzchum.scim.common.core.api.config.GdMapConfigProperties;
import com.hzchum.scim.common.core.api.pojo.vo.KeyAndSecretVO;
import com.hzchum.scim.common.core.api.utils.GdMapUtils;
import com.hzchum.scim.system.core.api.biz.gdMap.ProjectManageGdMapBiz;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageGdMapBizImpl implements ProjectManageGdMapBiz {
   @Resource
   private GdMapConfigProperties gdMapConfigProperties;

   @Override
   public KeyAndSecretVO getkey(Integer keyType) {
      return GdMapUtils.getKeyByType(keyType);
   }
}
