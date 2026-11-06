package com.hzchum.scim.business.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.business.core.api.pojo._do.BusinessCheckDetailDO;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckDetail;
import com.hzchum.scim.business.core.api.pojo.doModel.BusinessCheckInfo;
import com.hzchum.scim.business.core.api.service.BusinessCheckDetailService;
import com.hzchum.scim.business.core.api.service.BusinessCheckInfoService;
import com.hzchum.scim.business.core.mapper.BusinessCheckDetailMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class BusinessCheckDetailServiceImpl extends ServiceImpl<BusinessCheckDetailMapper, BusinessCheckDetail> implements BusinessCheckDetailService {
   @Resource
   private BusinessCheckInfoService businessCheckInfoService;

   @Override
   public ListVO<BusinessCheckDetailDO> listByCheckId(Long checkId) {
      BusinessCheckInfo checkInfo = this.businessCheckInfoService.getById(checkId);
      Preconditions.checkArgument(checkInfo != null, "审核记录不存在");
      List<BusinessCheckDetailDO> doList = this.baseMapper
         .listByCheckId(checkId, checkInfo.getProjectType(), checkInfo.getType())
         .stream()
         .peek(e -> e.setType(checkInfo.getType()))
         .collect(Collectors.toList());
      return new ListVO<>(doList);
   }
}
