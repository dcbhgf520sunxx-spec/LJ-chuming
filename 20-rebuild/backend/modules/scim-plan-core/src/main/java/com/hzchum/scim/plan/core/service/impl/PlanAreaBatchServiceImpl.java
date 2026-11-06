package com.hzchum.scim.plan.core.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.plan.core.api.pojo._do.PlanAreaBatch;
import com.hzchum.scim.plan.core.api.pojo.dto.PlanAreaBatchDTO;
import com.hzchum.scim.plan.core.api.pojo.vo.AreaBatchUpdateVORequest;
import com.hzchum.scim.plan.core.api.service.PlanAreaBatchService;
import com.hzchum.scim.plan.core.mapper.PlanAreaBatchMapper;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.TransactionalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlanAreaBatchServiceImpl extends ServiceImpl<PlanAreaBatchMapper, PlanAreaBatch> implements PlanAreaBatchService {
   private static final Logger log = LoggerFactory.getLogger(PlanAreaBatchServiceImpl.class);

   @Override
   public PageVO<PlanAreaBatchDTO> appPageByMonomerIdAndAreaBatchType(
      Long projectId, Long monomerId, Integer productType, Integer itemizedType, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<PlanAreaBatch> areaList = this.baseMapper
         .selectList(
            (Wrapper<PlanAreaBatch>)((((new LambdaQueryWrapper<PlanAreaBatch>()
                           .eq(projectId != null, PlanAreaBatch::getProjectId, projectId))
                        .eq(monomerId != null, PlanAreaBatch::getMonomerId, monomerId))
                     .eq(productType != null, PlanAreaBatch::getProductType, productType))
                  .eq(itemizedType != null, PlanAreaBatch::getItemizedType, itemizedType))
               .orderByAsc(PlanAreaBatch::getSort)
         );
      List<PlanAreaBatchDTO> areaDTOList = areaList.stream().map(a -> BeanUtil.copy(a, PlanAreaBatchDTO.class)).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(areaDTOList, areaList));
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateAreaBatch(AreaBatchUpdateVORequest voRequest) {
      PlanAreaBatch areaBatch = this.baseMapper.selectById(voRequest.getId());
      Preconditions.checkArgument(areaBatch != null, "操作失败,所选批次不存在!");
      Preconditions.checkArgument(!areaBatch.getName().equals(voRequest.getName()), "操作失败,名称未发生改动!");
      List<PlanAreaBatch> areaBatchList = this.baseMapper
         .selectList(
            (Wrapper<PlanAreaBatch>)((new LambdaQueryWrapper<PlanAreaBatch>()
                     .eq(PlanAreaBatch::getMonomerId, areaBatch.getMonomerId()))
                  .eq(PlanAreaBatch::getAreaId, areaBatch.getAreaId()))
               .eq(PlanAreaBatch::getName, voRequest.getName().trim())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(areaBatchList), "操作失败,修改后的批次名称在该单体下已存在!");
      areaBatch.setName(voRequest.getName().trim());
      this.baseMapper.updateById(areaBatch);
      return Boolean.TRUE;
   }

   @Override
   public List<PlanAreaBatchDTO> getList(Long projectId, Long monomerId, Integer productType, Integer itemizedType, String name) {
      List<PlanAreaBatch> areaList = this.baseMapper
         .selectList(
            (Wrapper<PlanAreaBatch>)(((((new LambdaQueryWrapper<PlanAreaBatch>()
                              .eq(projectId != null, PlanAreaBatch::getProjectId, projectId))
                           .eq(monomerId != null, PlanAreaBatch::getMonomerId, monomerId))
                        .eq(productType != null, PlanAreaBatch::getProductType, productType))
                     .eq(itemizedType != null, PlanAreaBatch::getItemizedType, itemizedType))
                  .like(StrUtil.isNotBlank(name), PlanAreaBatch::getName, name))
               .orderByAsc(PlanAreaBatch::getSort)
         );
      return areaList.stream().map(a -> BeanUtil.copy(a, PlanAreaBatchDTO.class)).collect(Collectors.toList());
   }
}
