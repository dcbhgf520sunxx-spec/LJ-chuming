package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassifyLinkDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "SysAuxiliaryClassification对象", description = "配套件类型配置表 ")
public class SysAuxiliaryClassificationDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称", notes = "名称")
   private String name;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private Integer sort;
   @ApiModelProperty("物料基础分类")
   private Integer basicClass;
   @ApiModelProperty(name = "type", value = "配套件类型 1栓钉 2套筒 4其他")
   private Integer type;
   @ApiModelProperty(name = "auxiliarySerialNumberList", value = "编号列表", notes = "编号列表")
   private List<SysAuxiliarySerialNumberDTO> auxiliarySerialNumberList;
   @ApiModelProperty("科目关联")
   private List<SteelClassifyLinkDTO> classifyLinks;
   @ApiModelProperty("科目关联")
   private List<Long> boundFinalClassifyIds;

   public static SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder builder() {
      return new SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder();
   }

   public SysAuxiliaryClassificationDTO() {
   }

   public SysAuxiliaryClassificationDTO(
      final Long id,
      final String name,
      final Integer sort,
      final Integer basicClass,
      final Integer type,
      final List<SysAuxiliarySerialNumberDTO> auxiliarySerialNumberList,
      final List<SteelClassifyLinkDTO> classifyLinks,
      final List<Long> boundFinalClassifyIds
   ) {
      this.id = id;
      this.name = name;
      this.sort = sort;
      this.basicClass = basicClass;
      this.type = type;
      this.auxiliarySerialNumberList = auxiliarySerialNumberList;
      this.classifyLinks = classifyLinks;
      this.boundFinalClassifyIds = boundFinalClassifyIds;
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

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getType() {
      return this.type;
   }

   public List<SysAuxiliarySerialNumberDTO> getAuxiliarySerialNumberList() {
      return this.auxiliarySerialNumberList;
   }

   public List<SteelClassifyLinkDTO> getClassifyLinks() {
      return this.classifyLinks;
   }

   public List<Long> getBoundFinalClassifyIds() {
      return this.boundFinalClassifyIds;
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

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setAuxiliarySerialNumberList(final List<SysAuxiliarySerialNumberDTO> auxiliarySerialNumberList) {
      this.auxiliarySerialNumberList = auxiliarySerialNumberList;
   }

   public void setClassifyLinks(final List<SteelClassifyLinkDTO> classifyLinks) {
      this.classifyLinks = classifyLinks;
   }

   public void setBoundFinalClassifyIds(final List<Long> boundFinalClassifyIds) {
      this.boundFinalClassifyIds = boundFinalClassifyIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysAuxiliaryClassificationDTO)) {
         return false;
      }

      SysAuxiliaryClassificationDTO other = (SysAuxiliaryClassificationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$sort = this.getSort();
         Object other$sort = other.getSort();
         if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
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
                        Object this$classifyLinks = this.getClassifyLinks();
                        Object other$classifyLinks = other.getClassifyLinks();
                        if (this$classifyLinks == null ? other$classifyLinks == null : this$classifyLinks.equals(other$classifyLinks)) {
                           Object this$boundFinalClassifyIds = this.getBoundFinalClassifyIds();
                           Object other$boundFinalClassifyIds = other.getBoundFinalClassifyIds();
                           return this$boundFinalClassifyIds == null
                              ? other$boundFinalClassifyIds == null
                              : this$boundFinalClassifyIds.equals(other$boundFinalClassifyIds);
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
      return other instanceof SysAuxiliaryClassificationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $auxiliarySerialNumberList = this.getAuxiliarySerialNumberList();
      result = result * 59 + ($auxiliarySerialNumberList == null ? 43 : $auxiliarySerialNumberList.hashCode());
      Object $classifyLinks = this.getClassifyLinks();
      result = result * 59 + ($classifyLinks == null ? 43 : $classifyLinks.hashCode());
      Object $boundFinalClassifyIds = this.getBoundFinalClassifyIds();
      return result * 59 + ($boundFinalClassifyIds == null ? 43 : $boundFinalClassifyIds.hashCode());
   }

   @Override
   public String toString() {
      return "SysAuxiliaryClassificationDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", basicClass="
         + this.getBasicClass()
         + ", type="
         + this.getType()
         + ", auxiliarySerialNumberList="
         + this.getAuxiliarySerialNumberList()
         + ", classifyLinks="
         + this.getClassifyLinks()
         + ", boundFinalClassifyIds="
         + this.getBoundFinalClassifyIds()
         + ")";
   }

   public static class SysAuxiliaryClassificationDTOBuilder {
      private Long id;
      private String name;
      private Integer sort;
      private Integer basicClass;
      private Integer type;
      private List<SysAuxiliarySerialNumberDTO> auxiliarySerialNumberList;
      private List<SteelClassifyLinkDTO> classifyLinks;
      private List<Long> boundFinalClassifyIds;

      SysAuxiliaryClassificationDTOBuilder() {
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder auxiliarySerialNumberList(
         final List<SysAuxiliarySerialNumberDTO> auxiliarySerialNumberList
      ) {
         this.auxiliarySerialNumberList = auxiliarySerialNumberList;
         return this;
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder classifyLinks(final List<SteelClassifyLinkDTO> classifyLinks) {
         this.classifyLinks = classifyLinks;
         return this;
      }

      public SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder boundFinalClassifyIds(final List<Long> boundFinalClassifyIds) {
         this.boundFinalClassifyIds = boundFinalClassifyIds;
         return this;
      }

      public SysAuxiliaryClassificationDTO build() {
         return new SysAuxiliaryClassificationDTO(
            this.id, this.name, this.sort, this.basicClass, this.type, this.auxiliarySerialNumberList, this.classifyLinks, this.boundFinalClassifyIds
         );
      }

      @Override
      public String toString() {
         return "SysAuxiliaryClassificationDTO.SysAuxiliaryClassificationDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", sort="
            + this.sort
            + ", basicClass="
            + this.basicClass
            + ", type="
            + this.type
            + ", auxiliarySerialNumberList="
            + this.auxiliarySerialNumberList
            + ", classifyLinks="
            + this.classifyLinks
            + ", boundFinalClassifyIds="
            + this.boundFinalClassifyIds
            + ")";
      }
   }
}
