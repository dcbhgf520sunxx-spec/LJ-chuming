package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.OfferRounds;
import com.hzchum.scim.bid.core.api.service.OfferRoundsService;
import com.hzchum.scim.bid.core.mapper.OfferRoundsMapper;
import org.springframework.stereotype.Service;

@Service
@DS("bidding")
public class OfferRoundsServiceImpl extends ServiceImpl<OfferRoundsMapper, OfferRounds> implements OfferRoundsService {
}
