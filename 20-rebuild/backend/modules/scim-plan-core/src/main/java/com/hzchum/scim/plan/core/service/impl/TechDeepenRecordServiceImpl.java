package com.hzchum.scim.plan.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.pojo._do.TechArtifact;
import com.hzchum.scim.plan.core.api.pojo._do.TechDeepenRecord;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordMonthDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordProjectDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordUserDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.DeepenRecordUserMonthDTO;
import com.hzchum.scim.plan.core.api.service.TechDeepenRecordService;
import com.hzchum.scim.plan.core.mapper.TechDeepenRecordMapper;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TechDeepenRecordServiceImpl extends ServiceImpl<TechDeepenRecordMapper, TechDeepenRecord> implements TechDeepenRecordService {
   @Autowired
   private ContractProjectService projectService;

   @Override
   public ListVO<DeepenRecordMonthDTO> listDeepenMeteByYear(@NotNull Integer year) {
      List<DeepenRecordMonthDTO> monthDTOS = this.baseMapper.selectListMonthDeepenMete(year);
      List<Integer> monthList = monthDTOS.stream().map(DeepenRecordMonthDTO::getMonth).sorted().collect(Collectors.toList());
      int currentYear = LocalDate.now().getYear();
      if (year <= currentYear) {
         int maxMonth = year == currentYear ? LocalDate.now().getMonthValue() : 12;

         for (int i = 1; i <= maxMonth; i++) {
            if (!monthList.contains(i)) {
               monthDTOS.add(i - 1, new DeepenRecordMonthDTO(i, BigDecimal.ZERO));
            }
         }
      }

      return new ListVO<>(monthDTOS);
   }

   @Override
   public ListVO<DeepenRecordProjectDTO> listProjectDeepenMete(Integer year, Integer month) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      return projectIds.size() == 0 ? new ListVO<>() : new ListVO<>(this.baseMapper.selectListProjectDeepenMete(year, month, projectIds));
   }

   @Override
   public ListVO<DeepenRecordUserDTO> listUserDeepenMete(Integer year) {
      return new ListVO<>(this.baseMapper.selectListUserDeepenMete(year, null));
   }

   @Override
   public ListVO<DeepenRecordUserMonthDTO> listUserMonthMete(Integer year, Integer month) {
      if (year == null) {
         year = LocalDate.now().getYear();
      }

      if (month == null) {
         month = LocalDate.now().getMonthValue();
      }

      List<DeepenRecordUserDTO> recordUserDTOS = this.baseMapper.selectListUserDeepenMete(year, month);
      Integer finalYear = year;
      Integer finalMonth = month;
      List<DeepenRecordUserMonthDTO> userMonthDTOList = recordUserDTOS.stream().map(s -> {
         DeepenRecordUserMonthDTO userMonthDTO = BeanUtil.copy(s, DeepenRecordUserMonthDTO.class);
         BigDecimal lastMonthMete;
         if (finalMonth == 1) {
            lastMonthMete = this.baseMapper.selectUserDeepenMete(finalYear - 1, 12, s.getUserId());
         } else {
            lastMonthMete = this.baseMapper.selectUserDeepenMete(finalYear, finalMonth - 1, s.getUserId());
         }

         userMonthDTO.setLastMonthMete(lastMonthMete != null ? lastMonthMete : BigDecimal.ZERO);
         return userMonthDTO;
      }).collect(Collectors.toList());
      return new ListVO<>(userMonthDTOList);
   }

   @Override
   public ListVO<DeepenRecordProjectDTO> listProjectDeepen(Integer year) {
      List<Long> projectIds = this.projectService
         .listSimpleProject(null, null, null, null)
         .getContent()
         .stream()
         .map(ProjectSimpleInfoDTO::getId)
         .collect(Collectors.toList());
      if (projectIds.size() == 0) {
         return new ListVO<>();
      }

      List<DeepenRecordProjectDTO> projectDTOS = this.baseMapper.selectListProjectMete(year, projectIds);
      projectDTOS = projectDTOS.stream().map(s -> {
         if (s.getPlanMete().compareTo(BigDecimal.ZERO) == 0) {
            s.setPlanMete(BigDecimal.ZERO);
            s.setMete(BigDecimal.ZERO);
         }

         return (DeepenRecordProjectDTO)s;
      }).collect(Collectors.toList());
      return new ListVO<>(projectDTOS);
   }

   @Override
   public Boolean deleteDeepenRecord(Integer productType, Long productId) {
      this.baseMapper
         .delete(Wrappers.lambdaQuery(TechDeepenRecord.class).eq(TechDeepenRecord::getProductType, productType).eq(TechDeepenRecord::getProductId, productId));
      return true;
   }

   @Override
   public TechDeepenRecord getByProductTypeProductId(Integer productType, Long productId) {
      return this.baseMapper.selectOne(Wrappers.lambdaQuery(TechDeepenRecord.builder().productType(productType).productId(productId).build()));
   }

   @Override
   public TechDeepenRecord buildDeepenRecord(TechArtifact artifact, Integer importQuantity) {
      return TechDeepenRecord.builder()
         .projectId(artifact.getProjectId())
         .monomerId(artifact.getMonomerId())
         .areaId(artifact.getAreaId())
         .areaBatchId(artifact.getAreaBatchId())
         .productId(artifact.getId())
         .productType(ProductTypeEnum.ARTIFACT.getType())
         .quantity(importQuantity)
         .mete(artifact.getNetWeight().multiply(BigDecimal.valueOf(importQuantity.intValue())).divide(BigDecimal.valueOf(1000L), 8, RoundingMode.HALF_UP))
         .userId(artifact.getUserId())
         .build();
   }
}
