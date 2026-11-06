package com.hzchum.scim.system.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.base.Preconditions;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.system.core.api.pojo._do.TraceConfigItem;
import com.hzchum.scim.system.core.api.pojo.dto.TraceConfigItemDTO;
import com.hzchum.scim.system.core.api.pojo.dto.TraceConfigItemVO;
import com.hzchum.scim.system.core.api.service.TraceConfigItemService;
import com.hzchum.scim.system.core.mapper.TraceConfigItemMapper;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TraceConfigItemServiceImpl extends ServiceImpl<TraceConfigItemMapper, TraceConfigItem> implements TraceConfigItemService {
   @Resource
   private ContractProjectService contractProjectService;

   @Override
   public List<TraceConfigItemVO> listVO() {
      List<TraceConfigItem> list = this.list((Wrapper<TraceConfigItem>)new LambdaQueryWrapper<TraceConfigItem>().orderByAsc(TraceConfigItem::getSort));
      return list.stream().map(this::toVO).collect(Collectors.toList());
   }

   @Override
   public Boolean saveBatch(List<TraceConfigItemDTO> dtoList) {
      List<String> uniqueKeys = dtoList.stream().map(dtox -> dtox.getFieldName() + "|" + dtox.getFieldValue()).collect(Collectors.toList());
      long distinctCount = uniqueKeys.stream().distinct().count();
      Preconditions.checkArgument(distinctCount == uniqueKeys.size(), "批量新增中存在【字段名称+字段值】重复的数据");

      for (TraceConfigItemDTO dto : dtoList) {
         long dbCount = this.count(
            (Wrapper<TraceConfigItem>)(new LambdaQueryWrapper<TraceConfigItem>().eq(TraceConfigItem::getFieldName, dto.getFieldName()))
               .eq(TraceConfigItem::getFieldValue, dto.getFieldValue())
         );
         Preconditions.checkArgument(dbCount == 0L, "存在重复的【字段名称+字段值】组合，请勿重复添加");
      }

      List<TraceConfigItem> items = dtoList.stream().map(this::toEntity).collect(Collectors.toList());
      return this.saveBatch(items);
   }

   @Override
   public Boolean updateOne(TraceConfigItemDTO dto) {
      long dbCount = this.count(
         (Wrapper<TraceConfigItem>)((new LambdaQueryWrapper<TraceConfigItem>().eq(TraceConfigItem::getFieldName, dto.getFieldName()))
               .eq(TraceConfigItem::getFieldValue, dto.getFieldValue()))
            .ne(TraceConfigItem::getId, dto.getId())
      );
      Preconditions.checkArgument(dbCount == 0L, "字段名称和属性值已存在，请勿重复");
      return this.updateById(this.toEntity(dto));
   }

   private TraceConfigItem toEntity(TraceConfigItemDTO dto) {
      String displayProject = "";
      if (dto.getDisplayProjectIds() != null && !dto.getDisplayProjectIds().isEmpty()) {
         List<Long> distinctIds = dto.getDisplayProjectIds().stream().distinct().collect(Collectors.toList());
         List<ProjectInfo> existProjects = this.contractProjectService.getSimpleByIds(distinctIds);
         Preconditions.checkArgument(existProjects.size() == distinctIds.size(), "存在无效的项目id，请检查后重试");
         displayProject = distinctIds.stream().map(String::valueOf).collect(Collectors.joining(","));
      }

      return TraceConfigItem.builder()
         .id(dto.getId())
         .sort(dto.getSort() != null ? dto.getSort() : 1)
         .fieldName(dto.getFieldName())
         .fieldValue(dto.getFieldValue())
         .displayProject(displayProject)
         .enableFlag(dto.getEnableFlag())
         .build();
   }

   private TraceConfigItemVO toVO(TraceConfigItem item) {
      List<ProjectInfo> displayProjects = Collections.emptyList();
      if (StringUtils.hasText(item.getDisplayProject())) {
         List<Long> ids = Arrays.stream(item.getDisplayProject().split(",")).map(Long::valueOf).collect(Collectors.toList());
         displayProjects = this.contractProjectService.getSimpleByIds(ids);
      }

      return TraceConfigItemVO.builder()
         .id(item.getId())
         .sort(item.getSort())
         .fieldName(item.getFieldName())
         .fieldValue(item.getFieldValue())
         .displayProjects(displayProjects)
         .enableFlag(item.getEnableFlag())
         .build();
   }
}
