package com.hzchum.scim.wms.core.service.impl.wmsConfig;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.SpecificationDetail;
import com.hzchum.scim.wms.core.api.service.wmsConfig.SpecificationDetailsService;
import com.hzchum.scim.wms.core.mapper.wmsConfig.SpecificationDetailsMapper;
import org.springframework.stereotype.Service;

@Service
public class SpecificationDetailsServiceImpl extends ServiceImpl<SpecificationDetailsMapper, SpecificationDetail> implements SpecificationDetailsService {
}
