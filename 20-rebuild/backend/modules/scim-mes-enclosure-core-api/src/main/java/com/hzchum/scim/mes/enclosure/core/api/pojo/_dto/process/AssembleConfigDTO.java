package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(description = "组立配置dto类 ")
public class AssembleConfigDTO {
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("组立名称")
   private String name;
   @ApiModelProperty("生产线类型 1传统线 2智能线")
   private Integer productionLineTypeEnum;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("组立规格前缀列表")
   private List<AssembleSpecDTO> assembleSpecList;
   @ApiModelProperty(name = "productProcessLinkList", notes = "工序详情")
   @JsonProperty("productProcessLinkList")
   @JSONField(name = "productProcessLinkList")
   @JsonInclude(Include.NON_NULL)
   private List<MesEnclosureProductProcessLinkDTO> productProcessLinkList;

   public static AssembleConfigDTO.AssembleConfigDTOBuilder builder() {
      return new AssembleConfigDTO.AssembleConfigDTOBuilder();
   }

   public AssembleConfigDTO() {
   }

   public AssembleConfigDTO(
      final Long id,
      final String name,
      final Integer productionLineTypeEnum,
      final Integer sort,
      final List<AssembleSpecDTO> assembleSpecList,
      final List<MesEnclosureProductProcessLinkDTO> productProcessLinkList
   ) {
      this.id = id;
      this.name = name;
      this.productionLineTypeEnum = productionLineTypeEnum;
      this.sort = sort;
      this.assembleSpecList = assembleSpecList;
      this.productProcessLinkList = productProcessLinkList;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductionLineTypeEnum() {
      return this.productionLineTypeEnum;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<AssembleSpecDTO> getAssembleSpecList() {
      return this.assembleSpecList;
   }

   public List<MesEnclosureProductProcessLinkDTO> getProductProcessLinkList() {
      return this.productProcessLinkList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProductionLineTypeEnum(final Integer productionLineTypeEnum) {
      this.productionLineTypeEnum = productionLineTypeEnum;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setAssembleSpecList(final List<AssembleSpecDTO> assembleSpecList) {
      this.assembleSpecList = assembleSpecList;
   }

   @JsonProperty("productProcessLinkList")
   public void setProductProcessLinkList(final List<MesEnclosureProductProcessLinkDTO> productProcessLinkList) {
      this.productProcessLinkList = productProcessLinkList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleConfigDTO)) {
         return false;
      }

      AssembleConfigDTO other = (AssembleConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productionLineTypeEnum = this.getProductionLineTypeEnum();
         Object other$productionLineTypeEnum = other.getProductionLineTypeEnum();
         if (this$productionLineTypeEnum == null ? other$productionLineTypeEnum == null : this$productionLineTypeEnum.equals(other$productionLineTypeEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$assembleSpecList = this.getAssembleSpecList();
                  Object other$assembleSpecList = other.getAssembleSpecList();
                  if (this$assembleSpecList == null ? other$assembleSpecList == null : this$assembleSpecList.equals(other$assembleSpecList)) {
                     Object this$productProcessLinkList = this.getProductProcessLinkList();
                     Object other$productProcessLinkList = other.getProductProcessLinkList();
                     return this$productProcessLinkList == null
                        ? other$productProcessLinkList == null
                        : this$productProcessLinkList.equals(other$productProcessLinkList);
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
      return other instanceof AssembleConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productionLineTypeEnum = this.getProductionLineTypeEnum();
      result = result * 59 + ($productionLineTypeEnum == null ? 43 : $productionLineTypeEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $assembleSpecList = this.getAssembleSpecList();
      result = result * 59 + ($assembleSpecList == null ? 43 : $assembleSpecList.hashCode());
      Object $productProcessLinkList = this.getProductProcessLinkList();
      return result * 59 + ($productProcessLinkList == null ? 43 : $productProcessLinkList.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleConfigDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productionLineTypeEnum="
         + this.getProductionLineTypeEnum()
         + ", sort="
         + this.getSort()
         + ", assembleSpecList="
         + this.getAssembleSpecList()
         + ", productProcessLinkList="
         + this.getProductProcessLinkList()
         + ")";
   }

   public static class AssembleConfigDTOBuilder {
      private Long id;
      private String name;
      private Integer productionLineTypeEnum;
      private Integer sort;
      private List<AssembleSpecDTO> assembleSpecList;
      private List<MesEnclosureProductProcessLinkDTO> productProcessLinkList;

      AssembleConfigDTOBuilder() {
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder productionLineTypeEnum(final Integer productionLineTypeEnum) {
         this.productionLineTypeEnum = productionLineTypeEnum;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public AssembleConfigDTO.AssembleConfigDTOBuilder assembleSpecList(final List<AssembleSpecDTO> assembleSpecList) {
         this.assembleSpecList = assembleSpecList;
         return this;
      }

      @JsonProperty("productProcessLinkList")
      public AssembleConfigDTO.AssembleConfigDTOBuilder productProcessLinkList(final List<MesEnclosureProductProcessLinkDTO> productProcessLinkList) {
         this.productProcessLinkList = productProcessLinkList;
         return this;
      }

      public AssembleConfigDTO build() {
         return new AssembleConfigDTO(this.id, this.name, this.productionLineTypeEnum, this.sort, this.assembleSpecList, this.productProcessLinkList);
      }

      @Override
      public String toString() {
         return "AssembleConfigDTO.AssembleConfigDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", productionLineTypeEnum="
            + this.productionLineTypeEnum
            + ", sort="
            + this.sort
            + ", assembleSpecList="
            + this.assembleSpecList
            + ", productProcessLinkList="
            + this.productProcessLinkList
            + ")";
      }
   }
}
