package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.OfferRoundDetail;
import com.hzchum.scim.bid.core.api.service.OfferRoundDetailService;
import com.hzchum.scim.bid.core.mapper.OfferRoundDetailMapper;
import org.springframework.stereotype.Service;

@Service
@DS("bidding")
public class OfferRoundDetailServiceImpl extends ServiceImpl<OfferRoundDetailMapper, OfferRoundDetail> implements OfferRoundDetailService {
}
