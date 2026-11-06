package com.hzchum.scim.wms.core.service.impl.wmsUse;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.MaterialReturnable;
import com.hzchum.scim.wms.core.api.pojo._do.wmsUse.ReturnDetail;
import com.hzchum.scim.wms.core.api.service.wmsUse.MaterialReturnableService;
import com.hzchum.scim.wms.core.mapper.wmsUse.MaterialReturnableMapper;
import com.hzchum.scim.wms.core.mapper.wmsUse.ReturnDetailMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class MaterialReturnableServiceImpl extends ServiceImpl<MaterialReturnableMapper, MaterialReturnable> implements MaterialReturnableService {
   @Resource
   ReturnDetailMapper returnDetailMapper;

   @Override
   public void updateReviewById(Long id, Boolean bool) {
      List<ReturnDetail> returnDetails = this.returnDetailMapper.selectList((Wrapper<ReturnDetail>)new LambdaQueryWrapper<ReturnDetail>().eq(ReturnDetail::getReturnId, id));
      List<Long> collect = returnDetails.stream().map(ReturnDetail::getMaterialReturnableId).collect(Collectors.toList());
      UpdateWrapper<MaterialReturnable> objectUpdateWrapper = new UpdateWrapper<>();
      Preconditions.checkArgument(CollectionUtil.isNotEmpty(collect), "可退库表id不存在");
      objectUpdateWrapper.in("id", collect);
      this.baseMapper.update(MaterialReturnable.builder().boolReviewPending(bool).build(), objectUpdateWrapper);
   }
}
