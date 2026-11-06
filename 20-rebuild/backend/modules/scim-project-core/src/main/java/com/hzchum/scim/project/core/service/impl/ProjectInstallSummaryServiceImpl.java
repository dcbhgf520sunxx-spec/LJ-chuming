package com.hzchum.scim.project.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.pojo._dto.product.MesBuildingAreaProductDTO;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.service.TechArtifactService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallReport;
import com.hzchum.scim.project.core.api.pojo._do.ProjectInstallSummary;
import com.hzchum.scim.project.core.api.pojo.dao.ProjectInstallMeteDO;
import com.hzchum.scim.project.core.api.pojo.dto.ProjectInstallBoardDTO;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.InstallBoardQueryDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectInstallSummaryService;
import com.hzchum.scim.project.core.mapper.ProjectInstallSummaryMapper;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectInstallSummaryServiceImpl extends ServiceImpl<ProjectInstallSummaryMapper, ProjectInstallSummary> implements ProjectInstallSummaryService {
   @Autowired
   private TechArtifactService artifactService;

   @Override
   public ProjectInstallMeteDO getActualInstallMete(Long projectId, Long monomerId, Long areaId, Integer productType, Integer category) {
      return this.baseMapper.selectActualInstallMete(projectId, monomerId, areaId, productType, category);
   }

   @Override
   public BigDecimal getActualInstallQuantity(List<Long> areaIds) {
      List<ProjectInstallSummary> summaryList = this.baseMapper
         .selectList(Wrappers.lambdaQuery(ProjectInstallSummary.class).in(areaIds != null, ProjectInstallSummary::getAreaId, areaIds));
      return summaryList.stream().map(ProjectInstallSummary::getActualQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
   }

   @Override
   public BigDecimal getActualInstallQuantity(Integer projectType, Integer productType, Long productId) {
      ProjectInstallSummary installSummary = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectInstallSummary.class)
               .eq(ProjectInstallSummary::getProjectType, projectType)
               .eq(ProjectInstallSummary::getProductType, productType)
               .eq(ProjectInstallSummary::getProductId, productId)
         );
      return installSummary != null ? installSummary.getActualQuantity() : BigDecimal.ZERO;
   }

   @Override
   public Boolean saveInstallSummary(ProjectInstallReport installReport) {
      ProjectInstallSummary installSummary = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(ProjectInstallSummary.class)
               .eq(ProjectInstallSummary::getProjectType, installReport.getProjectType())
               .eq(ProjectInstallSummary::getProductType, installReport.getProductType())
               .eq(ProjectInstallSummary::getProductId, installReport.getProductId())
         );
      if (installSummary != null) {
         installSummary.setActualQuantity(installSummary.getActualQuantity().add(installReport.getActualQuantity()));
         installSummary.setActualMete(installSummary.getActualMete().add(installReport.getActualMete()));
         installSummary.setActualTotalArea(
            installReport.getActualTotalArea() != null
               ? installSummary.getActualTotalArea().add(installReport.getActualTotalArea())
               : installReport.getActualTotalArea()
         );
         this.baseMapper.updateById(installSummary);
      } else {
         installSummary = BeanUtil.copy(installReport, ProjectInstallSummary.class);
         installSummary.setActualMete(installReport.getActualMete());
         this.baseMapper.insert(installSummary);
      }

      return true;
   }

   @Override
   public List<ProjectInstallBoardDTO> listInstallBoard(InstallBoardQueryDTOParam param) {
      return this.baseMapper.selectInstallBoard(param);
   }

   @Override
   public List<ProjectInstallBoardDTO> listInstallBoardV2(InstallBoardQueryDTOParam param) {
      return this.baseMapper.selectInstallBoardV2(param);
   }

   @Override
   public List getAreaInstallData(List<Long> areas, Integer productType) {
      List<MesBuildingAreaProductDTO> productDTOS = new ArrayList<>();
      if (CollectionUtils.isEmpty(areas)) {
         return productDTOS;
      }

      Map<Long, List<TechArtifact>> artifactMap = this.artifactService
         .list(Wrappers.lambdaQuery(TechArtifact.class).in(TechArtifact::getAreaId, areas))
         .stream()
         .collect(Collectors.groupingBy(TechArtifact::getAreaId));
      Map<Long, List<ProjectInstallSummary>> projectInstallSummaryMap = this.list(
            Wrappers.lambdaQuery(ProjectInstallSummary.class)
               .in(ProjectInstallSummary::getAreaId, areas)
               .eq(ProjectInstallSummary::getProductType, productType)
         )
         .stream()
         .collect(Collectors.groupingBy(ProjectInstallSummary::getAreaId));

      for (Long areaId : areas) {
         int allQuantity = 0;
         BigDecimal allWeight = BigDecimal.ZERO;
         int productQuantity = 0;
         BigDecimal productWeight = BigDecimal.ZERO;
         List<ProjectInstallSummary> completes = projectInstallSummaryMap.getOrDefault(areaId, new ArrayList<>());
         Map<Long, List<ProjectInstallSummary>> productMap = completes.stream().collect(Collectors.groupingBy(ProjectInstallSummary::getProductId));
         List<TechArtifact> techArtifacts = artifactMap.getOrDefault(areaId, new ArrayList<>());
         Map<Long, TechArtifact> allMap = techArtifacts.stream().collect(Collectors.toMap(TechArtifact::getId, Function.identity()));

         for (Long productId : techArtifacts.stream().map(TechArtifact::getId).collect(Collectors.toList())) {
            if (productMap.get(productId) != null) {
               productQuantity += productMap.get(productId).stream().mapToInt(s -> s.getActualQuantity().intValue()).sum();
            }

            productWeight = productWeight.add(allMap.get(productId).getNetWeight().multiply(new BigDecimal(productQuantity))).setScale(5, 5);
            Integer quantity = allMap.get(productId).getQuantity();
            allQuantity += quantity;
            allWeight = allWeight.add(allMap.get(productId).getNetWeight().multiply(new BigDecimal(quantity))).setScale(5, 5);
         }

         MesBuildingAreaProductDTO build = MesBuildingAreaProductDTO.builder()
            .areaId(areaId)
            .listQuantity(allQuantity)
            .listWeight(allWeight)
            .completeQuantity(productQuantity)
            .completeWeight(productWeight)
            .build();
         productDTOS.add(build);
      }

      return productDTOS;
   }
}
