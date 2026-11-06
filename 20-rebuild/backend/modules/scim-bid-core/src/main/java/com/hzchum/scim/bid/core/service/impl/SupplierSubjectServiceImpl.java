package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubject;
import com.hzchum.scim.bid.core.api.service.SupplierSubjectService;
import com.hzchum.scim.bid.core.mapper.SupplierSubjectMapper;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class SupplierSubjectServiceImpl extends ServiceImpl<SupplierSubjectMapper, SupplierSubject> implements SupplierSubjectService {
}
