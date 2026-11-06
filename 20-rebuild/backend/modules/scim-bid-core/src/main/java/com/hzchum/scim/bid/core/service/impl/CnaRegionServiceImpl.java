package com.hzchum.scim.bid.core.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.bid.core.api.pojo._do.CnaRegion;
import com.hzchum.scim.bid.core.api.pojo.vo.CnaRegionVO;
import com.hzchum.scim.bid.core.api.service.CnaRegionService;
import com.hzchum.scim.bid.core.mapper.CnaRegionMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

@DS("bidding")
@Service
public class CnaRegionServiceImpl extends ServiceImpl<CnaRegionMapper, CnaRegion> implements CnaRegionService {
   @Override
   public ListVO listAll() {
      List<CnaRegion> cnaRegions = this.baseMapper.selectList((Wrapper<CnaRegion>)new LambdaQueryWrapper<CnaRegion>().orderByDesc(CnaRegion::getPid));
      if (CollectionUtils.isEmpty(cnaRegions)) {
         return new ListVO();
      }

      Map<Long, List<CnaRegion>> cnaRegionMap = cnaRegions.stream().collect(Collectors.groupingBy(CnaRegion::getPid));
      return new ListVO<>(this.buildTree(0L, cnaRegionMap));
   }

   private List<CnaRegionVO> buildTree(Long pid, Map<Long, List<CnaRegion>> cnaRegionMap) {
      List<CnaRegion> cnaRegions = cnaRegionMap.get(pid);
      return CollectionUtils.isEmpty(cnaRegions) ? new ArrayList<>() : cnaRegions.stream().map(CnaRegion -> {
         CnaRegionVO treeVO = new CnaRegionVO();
         BeanUtil.copyProperties(CnaRegion, treeVO);
         treeVO.setChildren(this.buildTree(treeVO.getId(), cnaRegionMap));
         return treeVO;
      }).collect(Collectors.toList());
   }
}
