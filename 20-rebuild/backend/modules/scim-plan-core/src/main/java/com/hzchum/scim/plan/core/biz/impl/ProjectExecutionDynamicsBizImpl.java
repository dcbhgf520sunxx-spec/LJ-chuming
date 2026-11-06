package com.hzchum.scim.plan.core.biz.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.StringUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.plan.core.api.biz.ProjectExecutionDynamicsBiz;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDetailDTO;
import com.hzchum.scim.plan.core.api.pojo.dto.ProjectExecutionDynamicsDetailProductDTO;
import com.hzchum.scim.plan.core.mapper.ProjectExecutionDynamicsMapper;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectExecutionDynamicsBizImpl implements ProjectExecutionDynamicsBiz {
   @Autowired
   private ContractProjectService projectService;
   @Autowired
   private ProjectExecutionDynamicsMapper projectExecutionDynamicsMapper;

   @Override
   public PageVO<ProjectExecutionDynamicsDTO> pageInfo(Integer year, Integer status, Long projectId, Integer pageNumber, Integer pageSize, List<String> sort) {
      Page page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<Long> projectIds = this.projectService
         .list(
            Wrappers.lambdaQuery(ContractProject.class)
               .apply(year != null, "YEAR(create_time) = {0}", year)
               .eq(projectId != null, ContractProject::getId, projectId)
               .eq(status != null, ContractProject::getStatus, status)
         )
         .stream()
         .map(ContractProject::getId)
         .collect(Collectors.toList());
      if (CollUtil.isEmpty(projectIds)) {
         return new PageVO<>(page, new ArrayList<>());
      }

      List<ProjectExecutionDynamicsDTO> dtoList = this.projectExecutionDynamicsMapper.listInfo(projectIds);
      return new PageVO<>(page, dtoList);
   }

   @Override
   public List<ProjectExecutionDynamicsDetailDTO> deepenDetail(Long projectId) {
      Map<Long, List<ProjectExecutionDynamicsDetailDTO>> detailDTOGroup = this.projectExecutionDynamicsMapper
         .deepenDetail(projectId)
         .stream()
         .collect(Collectors.groupingBy(ProjectExecutionDynamicsDetailDTO::getMonomerId));
      List<ProjectExecutionDynamicsDetailDTO> resultList = new ArrayList<>();
      detailDTOGroup.forEach((k, v) -> {
         if (CollUtil.isNotEmpty(v)) {
            ProjectExecutionDynamicsDetailDTO detailDTO = new ProjectExecutionDynamicsDetailDTO();
            detailDTO.setProjectId(projectId);
            detailDTO.setMonomerId(k);
            detailDTO.setAreaList((List<ProjectExecutionDynamicsDetailDTO>)v);
            ProjectExecutionDynamicsDetailDTO areaDetail = v.get(0);
            detailDTO.setMonomerName(areaDetail.getMonomerName());
            detailDTO.setWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            resultList.add(detailDTO);
         }
      });
      if (CollUtil.isNotEmpty(resultList)) {
         BigDecimal totalWeight = resultList.stream().map(ProjectExecutionDynamicsDetailDTO::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
         resultList.forEach(i -> {
            i.setTotalWeight(totalWeight);
            i.setRatio(i.getWeight().divide(totalWeight, 2, RoundingMode.HALF_UP));
         });
      }

      return resultList;
   }

   @Override
   public PageVO<ProjectExecutionDynamicsDetailProductDTO> deepenDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ProjectExecutionDynamicsDetailProductDTO> productDTOList = this.projectExecutionDynamicsMapper.deepenDetailProduct(projectId, monomerId, areaId);
      return new PageVO<>(page, productDTOList);
   }

   @Override
   public List<ProjectExecutionDynamicsDetailDTO> schedulingDetail(Long projectId) {
      Map<Long, List<ProjectExecutionDynamicsDetailDTO>> detailDTOGroup = this.projectExecutionDynamicsMapper
         .schedulingDetail(projectId)
         .stream()
         .collect(Collectors.groupingBy(ProjectExecutionDynamicsDetailDTO::getMonomerId));
      List<ProjectExecutionDynamicsDetailDTO> resultList = new ArrayList<>();
      detailDTOGroup.forEach((k, v) -> {
         if (CollUtil.isNotEmpty(v)) {
            ProjectExecutionDynamicsDetailDTO detailDTO = new ProjectExecutionDynamicsDetailDTO();
            detailDTO.setProjectId(projectId);
            detailDTO.setMonomerId(k);
            detailDTO.setAreaList((List<ProjectExecutionDynamicsDetailDTO>)v);
            ProjectExecutionDynamicsDetailDTO areaDetail = v.get(0);
            detailDTO.setMonomerName(areaDetail.getMonomerName());
            detailDTO.setWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            detailDTO.setTotalWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            if (BigDecimal.ZERO.compareTo(detailDTO.getTotalWeight()) != 0) {
               detailDTO.setRatio(detailDTO.getWeight().divide(detailDTO.getTotalWeight(), 4, RoundingMode.HALF_UP));
            }

            resultList.add(detailDTO);
         }
      });
      return resultList;
   }

   @Override
   public PageVO<ProjectExecutionDynamicsDetailProductDTO> schedulingDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ProjectExecutionDynamicsDetailProductDTO> productDTOList = this.projectExecutionDynamicsMapper.schedulingDetailProduct(projectId, monomerId, areaId);
      return new PageVO<>(page, productDTOList);
   }

   @Override
   public PrintVO schedulingDetailProductPrint(Long projectId, Long monomerId, Long areaId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<ProjectExecutionDynamicsDetailProductDTO> list = this.projectExecutionDynamicsMapper.schedulingDetailProduct(projectId, monomerId, areaId);
      if (CollUtil.isNotEmpty(list)) {
         ProjectExecutionDynamicsDetailProductDTO one = list.get(0);
         header.put("project", one.getProjectSerialNumber() + " " + one.getProjectShortName());
         header.put("monomer", monomerId != null ? one.getMonomerName() : null);
         header.put("are", areaId != null ? one.getAreaName() : null);
         BigDecimal netWeightTotal = list.stream()
            .map(ProjectExecutionDynamicsDetailProductDTO::getProductNetWeight)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("netWeightTotal", netWeightTotal);
      }

      List<Map<String, Object>> table = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public List<ProjectExecutionDynamicsDetailDTO> producedDetail(Long projectId) {
      Map<Long, List<ProjectExecutionDynamicsDetailDTO>> detailDTOGroup = this.projectExecutionDynamicsMapper
         .producedDetail(projectId)
         .stream()
         .collect(Collectors.groupingBy(ProjectExecutionDynamicsDetailDTO::getMonomerId));
      List<ProjectExecutionDynamicsDetailDTO> resultList = new ArrayList<>();
      detailDTOGroup.forEach((k, v) -> {
         if (CollUtil.isNotEmpty(v)) {
            ProjectExecutionDynamicsDetailDTO detailDTO = new ProjectExecutionDynamicsDetailDTO();
            detailDTO.setProjectId(projectId);
            detailDTO.setMonomerId(k);
            detailDTO.setAreaList((List<ProjectExecutionDynamicsDetailDTO>)v);
            ProjectExecutionDynamicsDetailDTO areaDetail = v.get(0);
            detailDTO.setMonomerName(areaDetail.getMonomerName());
            detailDTO.setWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            detailDTO.setTotalWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            if (BigDecimal.ZERO.compareTo(detailDTO.getTotalWeight()) != 0) {
               detailDTO.setRatio(detailDTO.getWeight().divide(detailDTO.getTotalWeight(), 4, RoundingMode.HALF_UP));
            }

            resultList.add(detailDTO);
         }
      });
      return resultList;
   }

   @Override
   public PageVO<ProjectExecutionDynamicsDetailProductDTO> producedDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ProjectExecutionDynamicsDetailProductDTO> productDTOList = this.projectExecutionDynamicsMapper.producedDetailProduct(projectId, monomerId, areaId);
      return new PageVO<>(page, productDTOList);
   }

   @Override
   public PrintVO producedDetailProductPrint(Long projectId, Long monomerId, Long areaId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<ProjectExecutionDynamicsDetailProductDTO> list = this.projectExecutionDynamicsMapper.producedDetailProduct(projectId, monomerId, areaId);
      if (CollUtil.isNotEmpty(list)) {
         ProjectExecutionDynamicsDetailProductDTO one = list.get(0);
         header.put("project", one.getProjectSerialNumber() + " " + one.getProjectShortName());
         header.put("monomer", monomerId != null ? one.getMonomerName() : null);
         header.put("are", areaId != null ? one.getAreaName() : null);
         BigDecimal netWeightTotal = list.stream()
            .map(ProjectExecutionDynamicsDetailProductDTO::getProductNetWeight)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("netWeightTotal", netWeightTotal);
      }

      List<Map<String, Object>> table = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public List<ProjectExecutionDynamicsDetailDTO> notProducedDetail(Long projectId) {
      Map<Long, List<ProjectExecutionDynamicsDetailDTO>> detailDTOGroup = this.projectExecutionDynamicsMapper
         .notProducedDetail(projectId)
         .stream()
         .collect(Collectors.groupingBy(ProjectExecutionDynamicsDetailDTO::getMonomerId));
      List<ProjectExecutionDynamicsDetailDTO> resultList = new ArrayList<>();
      detailDTOGroup.forEach((k, v) -> {
         if (CollUtil.isNotEmpty(v)) {
            ProjectExecutionDynamicsDetailDTO detailDTO = new ProjectExecutionDynamicsDetailDTO();
            detailDTO.setProjectId(projectId);
            detailDTO.setMonomerId(k);
            detailDTO.setAreaList((List<ProjectExecutionDynamicsDetailDTO>)v);
            ProjectExecutionDynamicsDetailDTO areaDetail = v.get(0);
            detailDTO.setMonomerName(areaDetail.getMonomerName());
            detailDTO.setWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            detailDTO.setTotalWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            if (BigDecimal.ZERO.compareTo(detailDTO.getTotalWeight()) != 0) {
               detailDTO.setRatio(detailDTO.getWeight().divide(detailDTO.getTotalWeight(), 4, RoundingMode.HALF_UP));
            }

            resultList.add(detailDTO);
         }
      });
      return resultList;
   }

   @Override
   public PageVO<ProjectExecutionDynamicsDetailProductDTO> notProducedDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ProjectExecutionDynamicsDetailProductDTO> productDTOList = this.projectExecutionDynamicsMapper
         .notProducedDetailProduct(projectId, monomerId, areaId);
      return new PageVO<>(page, productDTOList);
   }

   @Override
   public PrintVO notProducedDetailProductPrint(Long projectId, Long monomerId, Long areaId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<ProjectExecutionDynamicsDetailProductDTO> list = this.projectExecutionDynamicsMapper.notProducedDetailProduct(projectId, monomerId, areaId);
      if (CollUtil.isNotEmpty(list)) {
         ProjectExecutionDynamicsDetailProductDTO one = list.get(0);
         header.put("project", one.getProjectSerialNumber() + " " + one.getProjectShortName());
         header.put("monomer", monomerId != null ? one.getMonomerName() : null);
         header.put("are", areaId != null ? one.getAreaName() : null);
         BigDecimal netWeightTotal = list.stream()
            .map(ProjectExecutionDynamicsDetailProductDTO::getProductNetWeight)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("netWeightTotal", netWeightTotal);
      }

      List<Map<String, Object>> table = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public List<ProjectExecutionDynamicsDetailDTO> deliveryDetail(Long projectId) {
      Map<Long, List<ProjectExecutionDynamicsDetailDTO>> detailDTOGroup = this.projectExecutionDynamicsMapper
         .deliveryDetail(projectId)
         .stream()
         .collect(Collectors.groupingBy(ProjectExecutionDynamicsDetailDTO::getMonomerId));
      List<ProjectExecutionDynamicsDetailDTO> resultList = new ArrayList<>();
      detailDTOGroup.forEach((k, v) -> {
         if (CollUtil.isNotEmpty(v)) {
            ProjectExecutionDynamicsDetailDTO detailDTO = new ProjectExecutionDynamicsDetailDTO();
            detailDTO.setProjectId(projectId);
            detailDTO.setMonomerId(k);
            detailDTO.setAreaList((List<ProjectExecutionDynamicsDetailDTO>)v);
            ProjectExecutionDynamicsDetailDTO areaDetail = v.get(0);
            detailDTO.setMonomerName(areaDetail.getMonomerName());
            detailDTO.setWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            detailDTO.setTotalWeight(v.stream().map(ProjectExecutionDynamicsDetailDTO::getTotalWeight).reduce(BigDecimal.ZERO, BigDecimal::add));
            if (BigDecimal.ZERO.compareTo(detailDTO.getTotalWeight()) != 0) {
               detailDTO.setRatio(detailDTO.getWeight().divide(detailDTO.getTotalWeight(), 4, RoundingMode.HALF_UP));
            }

            resultList.add(detailDTO);
         }
      });
      return resultList;
   }

   @Override
   public PageVO<ProjectExecutionDynamicsDetailProductDTO> deliveryDetailProduct(
      Long projectId, Long monomerId, Long areaId, Integer pageNumber, Integer pageSize, List<String> sort
   ) {
      Page<Object> page = PageHelper.startPage(pageNumber, pageSize, StringUtils.analyzeSortConditions(sort));
      List<ProjectExecutionDynamicsDetailProductDTO> productDTOList = this.projectExecutionDynamicsMapper.deliveryDetailProduct(projectId, monomerId, areaId);
      return new PageVO<>(page, productDTOList);
   }

   @Override
   public PrintVO deliveryDetailProductPrint(Long projectId, Long monomerId, Long areaId) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      List<ProjectExecutionDynamicsDetailProductDTO> list = this.projectExecutionDynamicsMapper.deliveryDetailProduct(projectId, monomerId, areaId);
      if (CollUtil.isNotEmpty(list)) {
         ProjectExecutionDynamicsDetailProductDTO one = list.get(0);
         header.put("project", one.getProjectSerialNumber() + " " + one.getProjectShortName());
         header.put("monomer", monomerId != null ? one.getMonomerName() : null);
         header.put("are", areaId != null ? one.getAreaName() : null);
         BigDecimal netWeightTotal = list.stream()
            .map(ProjectExecutionDynamicsDetailProductDTO::getProductNetWeight)
            .filter(Objects::nonNull)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         header.put("netWeightTotal", netWeightTotal);
      }

      List<Map<String, Object>> table = list.stream().map(BeanUtil::beanToMap).collect(Collectors.toList());
      printVO.setHeader(header);
      printVO.setTable(table);
      return printVO;
   }

   @Override
   public ProjectExecutionDynamicsDTO getProjectExecutionDynamics(Long projectId, Long branchCompanyId) {
      List<ProjectExecutionDynamicsDTO> dtoList = this.projectExecutionDynamicsMapper.listInfo(Arrays.asList(projectId));
      if (CollUtil.isNotEmpty(dtoList)) {
         ProjectExecutionDynamicsDTO dto = dtoList.get(0);
         BigDecimal installMete = this.projectService.getInstallMete(projectId, branchCompanyId);
         dto.setInstallWeight(installMete != null ? installMete : BigDecimal.ZERO);
         return dto;
      } else {
         return null;
      }
   }
}
