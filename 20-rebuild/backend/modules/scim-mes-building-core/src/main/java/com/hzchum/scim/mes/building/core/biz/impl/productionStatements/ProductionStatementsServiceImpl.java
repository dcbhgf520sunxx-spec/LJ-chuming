package com.hzchum.scim.mes.building.core.biz.impl.productionStatements;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionStatements.ProductionStatementsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ArtifactProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.ArtifactSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.EnclosureProductionStatementsDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.productionStatements.EnclosureSummaryDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.productionStatements.ProductionStatementsDTOParam;
import com.hzchum.scim.mes.building.core.api.service.productionStatements.ProductionStatementsService;
import com.hzchum.scim.mes.building.core.mapper.productionStatements.ProductionStatementsMapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProductionStatementsServiceImpl implements ProductionStatementsService {
   @Resource
   private ProductionStatementsMapper productionStatementsMapper;

   @Override
   public ArtifactSummaryDTO summaryByCondition(ProductionStatementsDTOParam dtoParam) {
      List<ArtifactProductionStatementsDTO> statementsDTOList = this.artifactlistByCondition(dtoParam);
      ArtifactSummaryDTO summaryDTO = ArtifactSummaryDTO.builder().quantity(0).totalGrossWeight(BigDecimal.ZERO).totalNetWeight(BigDecimal.ZERO).build();
      statementsDTOList.forEach(e -> {
         summaryDTO.setQuantity(summaryDTO.getQuantity() + e.getQuantity());
         summaryDTO.setTotalGrossWeight(summaryDTO.getTotalNetWeight().add(e.getTotalGrossWeight()));
         summaryDTO.setTotalNetWeight(summaryDTO.getTotalNetWeight().add(e.getTotalNetWeight()));
      });
      return summaryDTO;
   }

   @Override
   public List<ArtifactProductionStatementsDTO> artifactlistByCondition(ProductionStatementsDTOParam dtoParam) {
      return this.productionStatementsMapper
         .artifactlistByCondition(BeanUtil.copy(dtoParam, ProductionStatementsDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, ArtifactProductionStatementsDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<ArtifactProductionStatementsDTO> artifactPage(ProductionStatementsDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(page, this.artifactlistByCondition(dtoParam));
   }

   @Override
   public EnclosureSummaryDTO enclosureSummary(ProductionStatementsDTOParam dtoParam) {
      List<EnclosureProductionStatementsDTO> statementsDOS = this.enclosurelistByCondition(dtoParam);
      EnclosureSummaryDTO summaryDTO = EnclosureSummaryDTO.builder().quantity(0).totalArea(BigDecimal.ZERO).totalLength(BigDecimal.ZERO).build();
      statementsDOS.forEach(e -> {
         summaryDTO.setQuantity(summaryDTO.getQuantity() + e.getQuantity());
         summaryDTO.setTotalArea(summaryDTO.getTotalArea().add(e.getTotalArea()));
         summaryDTO.setTotalLength(summaryDTO.getTotalLength().add(e.getTotalLength()));
      });
      return null;
   }

   @Override
   public List<EnclosureProductionStatementsDTO> enclosurelistByCondition(ProductionStatementsDTOParam dtoParam) {
      return this.productionStatementsMapper
         .enclosurelistByCondition(BeanUtil.copy(dtoParam, ProductionStatementsDOParam.class))
         .stream()
         .map(e -> BeanUtil.copy(e, EnclosureProductionStatementsDTO.class))
         .collect(Collectors.toList());
   }

   @Override
   public PageVO<EnclosureProductionStatementsDTO> enclosurePage(ProductionStatementsDTOParam dtoParam, Integer pageNumber, Integer pageSize) {
      Page page = PageHelper.startPage(pageNumber, pageSize);
      return new PageVO<>(this.enclosurelistByCondition(dtoParam));
   }
}
