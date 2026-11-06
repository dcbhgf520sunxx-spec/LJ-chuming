package com.hzchum.scim.bid.core.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.bid.core.api.pojo._do.BiddingRounds;
import com.hzchum.scim.bid.core.api.service.BiddingRoundsService;
import com.hzchum.scim.bid.core.mapper.BiddingRoundsMapper;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class BiddingRoundsServiceImpl extends ServiceImpl<BiddingRoundsMapper, BiddingRounds> implements BiddingRoundsService {
}
