package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.bid.core.api.pojo._do.CnaRegion;

public interface CnaRegionService extends IService<CnaRegion> {
   ListVO listAll();
}
