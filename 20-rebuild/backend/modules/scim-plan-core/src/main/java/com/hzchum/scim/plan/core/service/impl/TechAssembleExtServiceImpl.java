package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssemble;
import com.hzchum.scim.plan.core.api.pojo._do.TechAssembleExt;
import com.hzchum.scim.plan.core.api.service.TechAssembleExtService;
import com.hzchum.scim.plan.core.mapper.TechAssembleExtMapper;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TechAssembleExtServiceImpl extends ServiceImpl<TechAssembleExtMapper, TechAssembleExt> implements TechAssembleExtService {
   @Override
   public void addReduceExt(TechAssemble assemble, Integer quantity) {
      Preconditions.checkArgument(quantity != 0, "参数不能为0!");
      List<TechAssembleExt> allAssembleExts = this.baseMapper
         .listAllAssembleExt(assemble.getMonomerId(), Collections.singletonList(assemble.getSerialNumber()));
      List<TechAssembleExt> assembleExtList = this.baseMapper.selectList(Wrappers.lambdaQuery(TechAssembleExt.builder().assembleId(assemble.getId()).build()));
      if (quantity > 0) {
         int max = 0;
         if (CollectionUtils.isNotEmpty(allAssembleExts)) {
            allAssembleExts = allAssembleExts.stream().sorted(Comparator.comparing(TechAssembleExt::getSortNumber).reversed()).collect(Collectors.toList());
            max = allAssembleExts.get(0).getSortNumber() >= allAssembleExts.size() ? allAssembleExts.get(0).getSortNumber() : assembleExtList.size();
         }

         for (int i = 1; i <= quantity; i++) {
            TechAssembleExt assembleExt = TechAssembleExt.builder()
               .projectId(assemble.getProjectId())
               .monomerId(assemble.getMonomerId())
               .areaBatchId(assemble.getAreaBatchId())
               .areaId(assemble.getAreaId())
               .serialNumber(assemble.getSerialNumber())
               .assembleId(assemble.getId())
               .sortNumber(max + i)
               .build();
            this.baseMapper.insert(assembleExt);
         }
      } else {
         List<Long> delExtIds = assembleExtList.stream().limit(Math.abs(quantity)).map(TechAssembleExt::getId).collect(Collectors.toList());
         this.baseMapper.deleteBatchIds(delExtIds);
      }
   }

   @Override
   public List<TechAssembleExt> listAssExt(List<NumberInfoDTO> assNumberInfors) {
      return this.baseMapper.listAssExt(assNumberInfors);
   }

   @Override
   public List<TechAssembleExt> listAllAssembleExt(Long monomerId, List<String> serialNumberList) {
      return this.baseMapper.listAllAssembleExt(monomerId, serialNumberList);
   }
}
