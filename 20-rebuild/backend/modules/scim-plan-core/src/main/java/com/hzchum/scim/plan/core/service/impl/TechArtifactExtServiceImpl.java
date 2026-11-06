package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifactExt;
import com.hzchum.scim.plan.core.api.service.TechArtifactExtService;
import com.hzchum.scim.plan.core.mapper.TechArtifactExtMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TechArtifactExtServiceImpl extends ServiceImpl<TechArtifactExtMapper, TechArtifactExt> implements TechArtifactExtService {
   @Override
   public TechArtifactExt getOne(Long artifactId, Integer sortNumber) {
      Preconditions.checkArgument(artifactId != null && sortNumber != null, "传参不能为空!");
      return this.baseMapper.selectOne(Wrappers.lambdaQuery(TechArtifactExt.builder().artifactId(artifactId).sortNumber(sortNumber).build()));
   }

   @Override
   public void addReduceExt(Long monomerId, Long artifactId, String serialNumber, Integer quantity) {
      List<TechArtifactExt> artifactExts = this.baseMapper.listAllArtifactExt(monomerId, Collections.singletonList(serialNumber));
      Preconditions.checkArgument(CollectionUtils.isNotEmpty(artifactExts), "操作失败,构件一物一码信息不存在!!!");
      int maxSortNumber = Collections.max(artifactExts.stream().map(TechArtifactExt::getSortNumber).collect(Collectors.toList()));
      TechArtifactExt techArtifactExt = artifactExts.stream().filter(e -> !e.getBoolDeleteEnum()).collect(Collectors.toList()).get(0);

      for (int i = 1; i <= quantity; i++) {
         TechArtifactExt ext = TechArtifactExt.builder()
            .projectId(techArtifactExt.getProjectId())
            .monomerId(techArtifactExt.getMonomerId())
            .areaId(techArtifactExt.getAreaId())
            .artifactId(artifactId)
            .areaBatchId(techArtifactExt.getAreaBatchId())
            .serialNumber(serialNumber)
            .sortNumber(maxSortNumber + i)
            .importUserId(UserUtil.getCurrentUserId())
            .importUserName(UserUtil.getCurrentName())
            .build();
         this.baseMapper.insert(ext);
      }
   }

   @Override
   public List<TechArtifactExt> listArtifact(List<NumberInfoDTO> NumberInfos) {
      return this.baseMapper.listArtifact(NumberInfos);
   }

   @Override
   public List<TechArtifactExt> listAllArtifactExt(Long monomerId, List<String> serialNumberList) {
      return this.baseMapper.listAllArtifactExt(monomerId, serialNumberList);
   }
}
