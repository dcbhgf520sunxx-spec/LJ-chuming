package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@ApiModel(value = "SysAuxiliaryClassification对象", description = "配套件类型配置表 ")
public class SysAuxiliaryClassificationDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   @NotBlank(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "type", value = "配套件类型 1栓钉 2套筒 4其他")
   private Integer type;
   @ApiModelProperty(name = "auxiliarySerialNumberList", value = "编号列表", notes = "编号列表")
   @NotEmpty(message = "编号列表不能为空")
   private List<String> auxiliarySerialNumberList;
   @ApiModelProperty("科目关联")
   @NotEmpty(message = "科目不能为空")
   private List<Long> classifyIds;

   public static SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder builder() {
      return new SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder();
   }

   public SysAuxiliaryClassificationDTOParam() {
   }

   public SysAuxiliaryClassificationDTOParam(
      final Long id, final String name, final Integer sort, final Integer type, final List<String> auxiliarySerialNumberList, final List<Long> classifyIds
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.type = type;
      this.auxiliarySerialNumberList = auxiliarySerialNumberList;
      this.classifyIds = classifyIds;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getType() {
      return this.type;
   }

   public List<String> getAuxiliarySerialNumberList() {
      return this.auxiliarySerialNumberList;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setAuxiliarySerialNumberList(final List<String> auxiliarySerialNumberList) {
      this.auxiliarySerialNumberList = auxiliarySerialNumberList;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAuxiliaryClassificationDTOParam)) {
         return false;
      }

      SysAuxiliaryClassificationDTOParam other = (SysAuxiliaryClassificationDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$auxiliarySerialNumberList = this.getAuxiliarySerialNumberList();
                  Object other$auxiliarySerialNumberList = other.getAuxiliarySerialNumberList();
                  if (this$auxiliarySerialNumberList == null
                     ? other$auxiliarySerialNumberList == null
                     : this$auxiliarySerialNumberList.equals(other$auxiliarySerialNumberList)) {
                     Object this$classifyIds = this.getClassifyIds();
                     Object other$classifyIds = other.getClassifyIds();
                     return this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds);
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
      return other instanceof SysAuxiliaryClassificationDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $auxiliarySerialNumberList = this.getAuxiliarySerialNumberList();
      result = result * 59 + ($auxiliarySerialNumberList == null ? 43 : $auxiliarySerialNumberList.hashCode());
      Object $classifyIds = this.getClassifyIds();
      return result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
   }

   @Override
   public String toString() {
      return "SysAuxiliaryClassificationDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", type="
         + this.getType()
         + ", auxiliarySerialNumberList="
         + this.getAuxiliarySerialNumberList()
         + ", classifyIds="
         + this.getClassifyIds()
         + ")";
   }

   public static class SysAuxiliaryClassificationDTOParamBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Integer type;
      private List<String> auxiliarySerialNumberList;
      private List<Long> classifyIds;

      SysAuxiliaryClassificationDTOParamBuilder() {
      }

      public SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder auxiliarySerialNumberList(
         final List<String> auxiliarySerialNumberList
      ) {
         this.auxiliarySerialNumberList = auxiliarySerialNumberList;
         return this;
      }

      public SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public SysAuxiliaryClassificationDTOParam build() {
         return new SysAuxiliaryClassificationDTOParam(this.id, this.name, this.sort, this.type, this.auxiliarySerialNumberList, this.classifyIds);
      }

      @Override
      public String toString() {
         return "SysAuxiliaryClassificationDTOParam.SysAuxiliaryClassificationDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", type="
            + this.type
            + ", auxiliarySerialNumberList="
            + this.auxiliarySerialNumberList
            + ", classifyIds="
            + this.classifyIds
            + ")";
      }
   }
}
