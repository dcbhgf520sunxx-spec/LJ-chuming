package com.hzchum.scim.wms.core.manager;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.scim.wms.core.api.enums.PickingStatusEnum;
import com.hzchum.scim.wms.core.api.manager.PickingApproveOutboundMesManger;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPicking;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.WmsPickingApproveDetail;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.WmsPickingApproveDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.WmsPickingService;
import com.hzchum.scim.wms.core.mapper.wmsUse.WmsPickingApproveDetailMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PickingApproveOutboundMesMangerImpl implements PickingApproveOutboundMesManger {
   @Resource
   private WmsPickingService wmsPickingService;
   @Resource
   private WmsPickingApproveDetailMapper wmsPickingApproveDetailMapper;

   @Override
   public Boolean boolComplete(Long id) {
      WmsPicking one = this.wmsPickingService.getOne((Wrapper<WmsPicking>)new LambdaQueryWrapper<WmsPicking>().eq(WmsPicking::getTaskOrderId, id));
      Preconditions.checkArgument(ObjectUtil.isNotEmpty(one), "未找到对应的领料单信息");
      return one.getTransactStatus() == PickingStatusEnum.HANDLED.getType();
   }

   @Override
   public List<WmsPickingApproveDetailDTO> getPickingApproveDetail(QueryPickingApproveDetailDTOParam param) {
      param.setTransactStatus(PickingStatusEnum.HANDLED.getType());
      return this.wmsPickingApproveDetailMapper.selectPassPickingApproveDetails(param);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean yesProcess(List<Long> ids) {
      List<WmsPickingApproveDetail> wmsPickingApproveDetails = this.wmsPickingApproveDetailMapper.selectBatchIds(ids);
      List<WmsPickingApproveDetail> collect = wmsPickingApproveDetails.stream().filter(WmsPickingApproveDetail::getBoolProcess).collect(Collectors.toList());
      Preconditions.checkArgument(CollectionUtil.isEmpty(collect), "存在已报工数据，请刷新页面重试");
      return this.wmsPickingApproveDetailMapper
            .update(
               null,
               (Wrapper<WmsPickingApproveDetail>)(new LambdaUpdateWrapper<WmsPickingApproveDetail>().in(WmsPickingApproveDetail::getId, ids))
                  .set(WmsPickingApproveDetail::getBoolProcess, Boolean.TRUE)
            )
         > 1;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean notProcess(List<Long> ids) {
      return this.wmsPickingApproveDetailMapper
            .update(
               null,
               (Wrapper<WmsPickingApproveDetail>)(new LambdaUpdateWrapper<WmsPickingApproveDetail>().in(WmsPickingApproveDetail::getId, ids))
                  .set(WmsPickingApproveDetail::getBoolProcess, Boolean.FALSE)
            )
         > 1;
   }
}
