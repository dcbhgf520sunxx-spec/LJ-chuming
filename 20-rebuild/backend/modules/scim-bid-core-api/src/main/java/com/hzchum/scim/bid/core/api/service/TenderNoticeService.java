package com.hzchum.scim.bid.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.scim.bid.core.api.pojo._do.TenderNotice;
import com.hzchum.scim.bid.core.api.pojo.dto.TenderNoticeDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.TenderNoticeVO;

public interface TenderNoticeService extends IService<TenderNotice> {
   TenderNoticeVO getMaterial(Integer type);

   Integer updateNotice(TenderNoticeDTO tenderNoticeDTO);
}
