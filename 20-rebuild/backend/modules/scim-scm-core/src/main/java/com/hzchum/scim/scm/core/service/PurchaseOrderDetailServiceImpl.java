package com.hzchum.scim.scm.core.service;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderDetailService;
import com.hzchum.scim.scm.core.mapper.PurchaseOrderDetailMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderDetailServiceImpl extends ServiceImpl<PurchaseOrderDetailMapper, PurchaseOrderDetail> implements PurchaseOrderDetailService {
   @Override
   public void updateInboundMete(Long purchaseOrderDetailId, BigDecimal mete, BigDecimal quantity) {
      this.baseMapper.updateInboundMete(purchaseOrderDetailId, mete, quantity);
   }

   @Override
   public List<PurchaseOrderDetail> selectPassDetailByApplyDetailIds(List<Long> applyDetailIds) {
      return CollectionUtil.isEmpty(applyDetailIds) ? new ArrayList<>() : this.baseMapper.selectPassDetailByApplyDetailIds(applyDetailIds);
   }
}
