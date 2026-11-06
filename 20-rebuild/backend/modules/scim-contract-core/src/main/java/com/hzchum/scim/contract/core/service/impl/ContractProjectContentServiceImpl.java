package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.contract.core.api.enums.ProjectBusinessTypeEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectContentCategoryEnum;
import com.hzchum.scim.contract.core.api.enums.ProjectTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentCategoryDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectContentDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.mapper.ContractProjectContentMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ContractProjectContentServiceImpl
   extends ServiceImpl<ContractProjectContentMapper, ContractProjectContent>
   implements ContractProjectContentService {
   @Resource
   private ContractProjectService projectService;

   @Override
   public List<String> listContentName(Long projectId) {
      Preconditions.checkArgument(projectId != null, "项目id不能为空");
      Preconditions.checkArgument(this.projectService.getSimpleById(projectId) != null, "项目不存在!");
      return this.baseMapper.selectProjectContentNameList(projectId);
   }

   @Override
   public String getProjectContentStr(Long projectId, String separator) {
      return StringUtils.join(this.listContentName(projectId), separator);
   }

   @Override
   public List<ProjectContentDTO> listProjectContentByPId(Long projectId) {
      return this.baseMapper.selectProjectContent(projectId);
   }

   @Override
   public List<ProjectContentDTO> listByContentStr(String projectContent) {
      List<ProjectContentDTO> projectContentList = new ArrayList<>();
      if (StringUtils.isBlank(projectContent)) {
         return projectContentList;
      }

      Long oldStructureProjectId = 8L;
      Long oldEnclosureProjectId = 9L;
      List<Long> ids = Arrays.stream(StringUtils.split(projectContent, ",")).map(Long::parseLong).collect(Collectors.toList());
      projectContentList.addAll(
         this.baseMapper
            .selectList(Wrappers.lambdaQuery(ContractProjectContent.class).in(ContractProjectContent::getId, ids))
            .stream()
            .map(c -> BeanUtil.copy(c, ProjectContentDTO.class))
            .collect(Collectors.toList())
      );
      if (ids.contains(oldStructureProjectId)) {
         projectContentList.addAll(
            this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(ContractProjectContent.class)
                     .eq(ContractProjectContent::getCategoryType, ProjectContentCategoryEnum.STRUCTURE.getType())
               )
               .stream()
               .map(c -> BeanUtil.copy(c, ProjectContentDTO.class))
               .collect(Collectors.toList())
         );
      }

      if (ids.contains(oldEnclosureProjectId)) {
         projectContentList.addAll(
            this.baseMapper
               .selectList(
                  Wrappers.lambdaQuery(ContractProjectContent.class)
                     .eq(ContractProjectContent::getCategoryType, ProjectContentCategoryEnum.ENCLOSURE.getType())
               )
               .stream()
               .map(c -> BeanUtil.copy(c, ProjectContentDTO.class))
               .collect(Collectors.toList())
         );
      }

      return projectContentList;
   }

   @Override
   public Map<Integer, List<ProjectContentCategoryDTO>> listProjectContentCategory(Integer businessType, int flag) {
      List<ContractProjectContent> contentList = this.baseMapper.selectList(null);
      List<ProjectContentCategoryDTO> bridgeList = new ArrayList<>();
      List<ProjectContentCategoryDTO> mesAndParkingLotList = new ArrayList<>();
      List<ProjectContentCategoryDTO> enclosureList = new ArrayList<>();
      Map<Integer, List<ProjectContentDTO>> projectContentMap = contentList.stream()
         .map(c -> BeanUtil.copy(c, ProjectContentDTO.class))
         .collect(Collectors.groupingBy(ProjectContentDTO::getCategoryType));
      projectContentMap.forEach((categoryType, dto) -> {
         ProjectContentCategoryDTO responseDTO = new ProjectContentCategoryDTO();
         responseDTO.setCategoryType(categoryType);
         if (ProjectBusinessTypeEnum.PROCESS.getType().equals(businessType)) {
            responseDTO.setCategoryName(ProjectContentCategoryEnum.getNameByType(categoryType) + "制品");
         }

         if (ProjectBusinessTypeEnum.JOB.getType().equals(businessType)) {
            responseDTO.setCategoryName(ProjectContentCategoryEnum.getNameByType(categoryType) + "工程");
         }

         responseDTO.setChildren((List<ProjectContentDTO>)dto);
         if (ProjectContentCategoryEnum.AUXILIARY.getType().equals(categoryType)) {
            bridgeList.add(responseDTO);
         }

         if (!ProjectContentCategoryEnum.BODY_PARTS.getType().equals(categoryType)) {
            mesAndParkingLotList.add(responseDTO);
         }
      });
      List<ProjectContentDTO> children = new ArrayList<>();

      for (ContractProjectContent contractProjectContent : contentList) {
         if (contractProjectContent.getCategoryType().equals(4)) {
            children.add(BeanUtil.copy(contractProjectContent, ProjectContentDTO.class));
         }
      }

      ProjectContentCategoryDTO dto = new ProjectContentCategoryDTO();
      dto.setChildren(children);
      dto.setCategoryName(ProjectContentCategoryEnum.getNameByType(4) + "工程");
      dto.setCategoryType(ProjectContentCategoryEnum.ENCLOSURE.getType());
      enclosureList.add(dto);
      if (flag == 1) {
         for (ProjectContentCategoryDTO projectContentCategoryDTO : mesAndParkingLotList) {
            if (projectContentCategoryDTO.getCategoryType() == 4) {
               mesAndParkingLotList.remove(projectContentCategoryDTO);
               break;
            }
         }
      }

      Map<Integer, List<ProjectContentCategoryDTO>> projectTypeMap = new HashMap<>();
      projectTypeMap.put(ProjectTypeEnum.MES.getType(), mesAndParkingLotList);
      projectTypeMap.put(ProjectTypeEnum.BRIDGE.getType(), mesAndParkingLotList);
      projectTypeMap.put(ProjectTypeEnum.PARKING_LOT.getType(), mesAndParkingLotList);
      if (flag == 0) {
         projectTypeMap.put(ProjectTypeEnum.ENCLOSURE.getType(), enclosureList);
      }

      return projectTypeMap;
   }
}
