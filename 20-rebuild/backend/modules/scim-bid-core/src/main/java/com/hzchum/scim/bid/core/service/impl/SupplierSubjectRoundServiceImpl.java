package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.SupplierSubjectRound;
import com.hzchum.scim.bid.core.api.service.SupplierSubjectRoundService;
import com.hzchum.scim.bid.core.mapper.SupplierSubjectRoundMapper;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class SupplierSubjectRoundServiceImpl extends ServiceImpl<SupplierSubjectRoundMapper, SupplierSubjectRound> implements SupplierSubjectRoundService {
}
