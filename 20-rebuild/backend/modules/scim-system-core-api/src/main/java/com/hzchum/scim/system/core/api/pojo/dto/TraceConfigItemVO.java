package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("溯源配置明细VO")
public class TraceConfigItemVO {
   @ApiModelProperty("明细主键")
   private Long id;
   @ApiModelProperty("页面展示序号")
   private Integer sort;
   @ApiModelProperty("字段名称")
   private String fieldName;
   @ApiModelProperty("字段值")
   private String fieldValue;
   @ApiModelProperty("要展示到的项目列表")
   private List<ProjectInfo> displayProjects;
   @ApiModelProperty("是否启用 0否 1是")
   private Integer enableFlag;

   public static TraceConfigItemVO.TraceConfigItemVOBuilder builder() {
      return new TraceConfigItemVO.TraceConfigItemVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getFieldName() {
      return this.fieldName;
   }

   public String getFieldValue() {
      return this.fieldValue;
   }

   public List<ProjectInfo> getDisplayProjects() {
      return this.displayProjects;
   }

   public Integer getEnableFlag() {
      return this.enableFlag;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setFieldName(final String fieldName) {
      this.fieldName = fieldName;
   }

   public void setFieldValue(final String fieldValue) {
      this.fieldValue = fieldValue;
   }

   public void setDisplayProjects(final List<ProjectInfo> displayProjects) {
      this.displayProjects = displayProjects;
   }

   public void setEnableFlag(final Integer enableFlag) {
      this.enableFlag = enableFlag;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TraceConfigItemVO)) {
         return false;
      }

      TraceConfigItemVO other = (TraceConfigItemVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$enableFlag = this.getEnableFlag();
            Object other$enableFlag = other.getEnableFlag();
            if (this$enableFlag == null ? other$enableFlag == null : this$enableFlag.equals(other$enableFlag)) {
               Object this$fieldName = this.getFieldName();
               Object other$fieldName = other.getFieldName();
               if (this$fieldName == null ? other$fieldName == null : this$fieldName.equals(other$fieldName)) {
                  Object this$fieldValue = this.getFieldValue();
                  Object other$fieldValue = other.getFieldValue();
                  if (this$fieldValue == null ? other$fieldValue == null : this$fieldValue.equals(other$fieldValue)) {
                     Object this$displayProjects = this.getDisplayProjects();
                     Object other$displayProjects = other.getDisplayProjects();
                     return this$displayProjects == null ? other$displayProjects == null : this$displayProjects.equals(other$displayProjects);
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
      return other instanceof TraceConfigItemVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $enableFlag = this.getEnableFlag();
      result = result * 59 + ($enableFlag == null ? 43 : $enableFlag.hashCode());
      Object $fieldName = this.getFieldName();
      result = result * 59 + ($fieldName == null ? 43 : $fieldName.hashCode());
      Object $fieldValue = this.getFieldValue();
      result = result * 59 + ($fieldValue == null ? 43 : $fieldValue.hashCode());
      Object $displayProjects = this.getDisplayProjects();
      return result * 59 + ($displayProjects == null ? 43 : $displayProjects.hashCode());
   }

   @Override
   public String toString() {
      return "TraceConfigItemVO(id="
         + this.getId()
         + ", sort="
         + this.getSort()
         + ", fieldName="
         + this.getFieldName()
         + ", fieldValue="
         + this.getFieldValue()
         + ", displayProjects="
         + this.getDisplayProjects()
         + ", enableFlag="
         + this.getEnableFlag()
         + ")";
   }

   public TraceConfigItemVO() {
   }

   public TraceConfigItemVO(
      final Long id, final Integer sort, final String fieldName, final String fieldValue, final List<ProjectInfo> displayProjects, final Integer enableFlag
   ) {
      this.id = id;
      this.sort = sort;
      this.fieldName = fieldName;
      this.fieldValue = fieldValue;
      this.displayProjects = displayProjects;
      this.enableFlag = enableFlag;
   }

   public static class TraceConfigItemVOBuilder {
      private Long id;
      private Integer sort;
      private String fieldName;
      private String fieldValue;
      private List<ProjectInfo> displayProjects;
      private Integer enableFlag;

      TraceConfigItemVOBuilder() {
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder fieldName(final String fieldName) {
         this.fieldName = fieldName;
         return this;
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder fieldValue(final String fieldValue) {
         this.fieldValue = fieldValue;
         return this;
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder displayProjects(final List<ProjectInfo> displayProjects) {
         this.displayProjects = displayProjects;
         return this;
      }

      public TraceConfigItemVO.TraceConfigItemVOBuilder enableFlag(final Integer enableFlag) {
         this.enableFlag = enableFlag;
         return this;
      }

      public TraceConfigItemVO build() {
         return new TraceConfigItemVO(this.id, this.sort, this.fieldName, this.fieldValue, this.displayProjects, this.enableFlag);
      }

      @Override
      public String toString() {
         return "TraceConfigItemVO.TraceConfigItemVOBuilder(id="
            + this.id
            + ", sort="
            + this.sort
            + ", fieldName="
            + this.fieldName
            + ", fieldValue="
            + this.fieldValue
            + ", displayProjects="
            + this.displayProjects
            + ", enableFlag="
            + this.enableFlag
            + ")";
      }
   }
}
