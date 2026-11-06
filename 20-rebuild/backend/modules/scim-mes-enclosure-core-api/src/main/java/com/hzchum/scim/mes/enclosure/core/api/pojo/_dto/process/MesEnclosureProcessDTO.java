package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesEnclosureProcessDTO对象", description = "")
public class MesEnclosureProcessDTO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "name", notes = "工序名称", value = "工序名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;
   @ApiModelProperty(
      name = "reportType",
      notes = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      value = "上报类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("reportType")
   @JSONField(name = "reportType")
   private Integer reportType;
   @ApiModelProperty(
      name = "inspectType",
      notes = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]",
      value = "质检类型 [0 单件(不扫码), 1  单件(需扫码), 2 批量(不扫码), 3 批量(需扫码)]"
   )
   @JsonProperty("inspectType")
   @JSONField(name = "inspectType")
   private Integer inspectType;
   @ApiModelProperty(name = "userId", notes = "操作人", value = "操作人")
   @JsonProperty("userId")
   @JSONField(name = "userId")
   private Long userId;
   @ApiModelProperty(name = "sort", notes = "排序", value = "排序")
   @JsonProperty("sort")
   @JSONField(name = "sort")
   private Integer sort;
   @ApiModelProperty(name = "wageQuotaType", notes = "计价方式 [0 重量, 1 长度，2 面积]", value = "计价方式 [0 重量, 1 长度，2 面积]")
   @JsonProperty("wageQuotaType")
   @JSONField(name = "wageQuotaType")
   private Integer wageQuotaType;
   @ApiModelProperty(name = "processWageList", notes = "工序工价", value = "工序工价")
   @JsonProperty("processWageList")
   @JSONField(name = "processWageList")
   private List<ProcessWageDTO> processWageList;

   public static MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder builder() {
      return new MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder();
   }

   public MesEnclosureProcessDTO() {
   }

   public MesEnclosureProcessDTO(
      final Long id,
      final String name,
      final Integer reportType,
      final Integer inspectType,
      final Long userId,
      final Integer sort,
      final Integer wageQuotaType,
      final List<ProcessWageDTO> processWageList
   ) {
      this.id = id;
      this.name = name;
      this.reportType = reportType;
      this.inspectType = inspectType;
      this.userId = userId;
      this.sort = sort;
      this.wageQuotaType = wageQuotaType;
      this.processWageList = processWageList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getReportType() {
      return this.reportType;
   }

   public Integer getInspectType() {
      return this.inspectType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getWageQuotaType() {
      return this.wageQuotaType;
   }

   public List<ProcessWageDTO> getProcessWageList() {
      return this.processWageList;
   }

   @JsonProperty("id")
   public MesEnclosureProcessDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public MesEnclosureProcessDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("reportType")
   public MesEnclosureProcessDTO setReportType(final Integer reportType) {
      this.reportType = reportType;
      return this;
   }

   @JsonProperty("inspectType")
   public MesEnclosureProcessDTO setInspectType(final Integer inspectType) {
      this.inspectType = inspectType;
      return this;
   }

   @JsonProperty("userId")
   public MesEnclosureProcessDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @JsonProperty("sort")
   public MesEnclosureProcessDTO setSort(final Integer sort) {
      this.sort = sort;
      return this;
   }

   @JsonProperty("wageQuotaType")
   public MesEnclosureProcessDTO setWageQuotaType(final Integer wageQuotaType) {
      this.wageQuotaType = wageQuotaType;
      return this;
   }

   @JsonProperty("processWageList")
   public MesEnclosureProcessDTO setProcessWageList(final List<ProcessWageDTO> processWageList) {
      this.processWageList = processWageList;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureProcessDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", reportType="
         + this.getReportType()
         + ", inspectType="
         + this.getInspectType()
         + ", userId="
         + this.getUserId()
         + ", sort="
         + this.getSort()
         + ", wageQuotaType="
         + this.getWageQuotaType()
         + ", processWageList="
         + this.getProcessWageList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProcessDTO)) {
         return false;
      }

      MesEnclosureProcessDTO other = (MesEnclosureProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$reportType = this.getReportType();
         Object other$reportType = other.getReportType();
         if (this$reportType == null ? other$reportType == null : this$reportType.equals(other$reportType)) {
            Object this$inspectType = this.getInspectType();
            Object other$inspectType = other.getInspectType();
            if (this$inspectType == null ? other$inspectType == null : this$inspectType.equals(other$inspectType)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$sort = this.getSort();
                  Object other$sort = other.getSort();
                  if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                     Object this$wageQuotaType = this.getWageQuotaType();
                     Object other$wageQuotaType = other.getWageQuotaType();
                     if (this$wageQuotaType == null ? other$wageQuotaType == null : this$wageQuotaType.equals(other$wageQuotaType)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$processWageList = this.getProcessWageList();
                           Object other$processWageList = other.getProcessWageList();
                           return this$processWageList == null ? other$processWageList == null : this$processWageList.equals(other$processWageList);
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $reportType = this.getReportType();
      result = result * 59 + ($reportType == null ? 43 : $reportType.hashCode());
      Object $inspectType = this.getInspectType();
      result = result * 59 + ($inspectType == null ? 43 : $inspectType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $wageQuotaType = this.getWageQuotaType();
      result = result * 59 + ($wageQuotaType == null ? 43 : $wageQuotaType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $processWageList = this.getProcessWageList();
      return result * 59 + ($processWageList == null ? 43 : $processWageList.hashCode());
   }

   public static class MesEnclosureProcessDTOBuilder {
      private Long id;
      private String name;
      private Integer reportType;
      private Integer inspectType;
      private Long userId;
      private Integer sort;
      private Integer wageQuotaType;
      private List<ProcessWageDTO> processWageList;

      MesEnclosureProcessDTOBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("reportType")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder reportType(final Integer reportType) {
         this.reportType = reportType;
         return this;
      }

      @JsonProperty("inspectType")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder inspectType(final Integer inspectType) {
         this.inspectType = inspectType;
         return this;
      }

      @JsonProperty("userId")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      @JsonProperty("sort")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      @JsonProperty("wageQuotaType")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder wageQuotaType(final Integer wageQuotaType) {
         this.wageQuotaType = wageQuotaType;
         return this;
      }

      @JsonProperty("processWageList")
      public MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder processWageList(final List<ProcessWageDTO> processWageList) {
         this.processWageList = processWageList;
         return this;
      }

      public MesEnclosureProcessDTO build() {
         return new MesEnclosureProcessDTO(
            this.id, this.name, this.reportType, this.inspectType, this.userId, this.sort, this.wageQuotaType, this.processWageList
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureProcessDTO.MesEnclosureProcessDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", reportType="
            + this.reportType
            + ", inspectType="
            + this.inspectType
            + ", userId="
            + this.userId
            + ", sort="
            + this.sort
            + ", wageQuotaType="
            + this.wageQuotaType
            + ", processWageList="
            + this.processWageList
            + ")";
      }
   }
}
