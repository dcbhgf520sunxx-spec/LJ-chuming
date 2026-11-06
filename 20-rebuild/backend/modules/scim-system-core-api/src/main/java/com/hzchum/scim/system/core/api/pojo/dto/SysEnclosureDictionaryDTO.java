package com.hzchum.scim.system.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("围护字典响应类")
public class SysEnclosureDictionaryDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "label", notes = "字典详情名称")
   private String label;
   @ApiModelProperty(name = "name", notes = "字典类型名称")
   private String name;
   @ApiModelProperty(name = "remark", notes = "字典类型描述")
   private String remark;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "dictionaryDetail", notes = "版型详情")
   private SysEnclosureDictionaryDetailDTO dictionaryDetail;
   @ApiModelProperty(name = "sort", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "type", notes = " 类型 2:压型彩板 4:夹芯板 8:桁架楼承板 16:压型楼承板")
   private Integer type;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "code", notes = " 编号:桁架楼承板特有")
   private String code;
   @ApiModelProperty(name = "status", notes = " 状态 1启用 0禁用  ")
   private Boolean status;

   public static SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder builder() {
      return new SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder();
   }

   public SysEnclosureDictionaryDTO() {
   }

   public SysEnclosureDictionaryDTO(
      final Long id,
      final String label,
      final String name,
      final String remark,
      final SysEnclosureDictionaryDetailDTO dictionaryDetail,
      final Integer sort,
      final Integer type,
      final String code,
      final Boolean status
   ) {
      this.id = id;
      this.label = label;
      this.name = name;
      this.remark = remark;
      this.dictionaryDetail = dictionaryDetail;
      this.sort = sort;
      this.type = type;
      this.code = code;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public String getLabel() {
      return this.label;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public SysEnclosureDictionaryDetailDTO getDictionaryDetail() {
      return this.dictionaryDetail;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Integer getType() {
      return this.type;
   }

   public String getCode() {
      return this.code;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setDictionaryDetail(final SysEnclosureDictionaryDetailDTO dictionaryDetail) {
      this.dictionaryDetail = dictionaryDetail;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysEnclosureDictionaryDTO)) {
         return false;
      }

      SysEnclosureDictionaryDTO other = (SysEnclosureDictionaryDTO)o;
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
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$label = this.getLabel();
                  Object other$label = other.getLabel();
                  if (this$label == null ? other$label == null : this$label.equals(other$label)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$remark = this.getRemark();
                        Object other$remark = other.getRemark();
                        if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                           Object this$dictionaryDetail = this.getDictionaryDetail();
                           Object other$dictionaryDetail = other.getDictionaryDetail();
                           if (this$dictionaryDetail == null ? other$dictionaryDetail == null : this$dictionaryDetail.equals(other$dictionaryDetail)) {
                              Object this$code = this.getCode();
                              Object other$code = other.getCode();
                              return this$code == null ? other$code == null : this$code.equals(other$code);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysEnclosureDictionaryDTO;
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
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $dictionaryDetail = this.getDictionaryDetail();
      result = result * 59 + ($dictionaryDetail == null ? 43 : $dictionaryDetail.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "SysEnclosureDictionaryDTO(id="
         + this.getId()
         + ", label="
         + this.getLabel()
         + ", name="
         + this.getName()
         + ", remark="
         + this.getRemark()
         + ", dictionaryDetail="
         + this.getDictionaryDetail()
         + ", sort="
         + this.getSort()
         + ", type="
         + this.getType()
         + ", code="
         + this.getCode()
         + ", status="
         + this.getStatus()
         + ")";
   }

   public static class SysEnclosureDictionaryDTOBuilder {
      private Long id;
      private String label;
      private String name;
      private String remark;
      private SysEnclosureDictionaryDetailDTO dictionaryDetail;
      private Integer sort;
      private Integer type;
      private String code;
      private Boolean status;

      SysEnclosureDictionaryDTOBuilder() {
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder label(final String label) {
         this.label = label;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder dictionaryDetail(final SysEnclosureDictionaryDetailDTO dictionaryDetail) {
         this.dictionaryDetail = dictionaryDetail;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder code(final String code) {
         this.code = code;
         return this;
      }

      public SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SysEnclosureDictionaryDTO build() {
         return new SysEnclosureDictionaryDTO(this.id, this.label, this.name, this.remark, this.dictionaryDetail, this.sort, this.type, this.code, this.status);
      }

      @Override
      public String toString() {
         return "SysEnclosureDictionaryDTO.SysEnclosureDictionaryDTOBuilder(id="
            + this.id
            + ", label="
            + this.label
            + ", name="
            + this.name
            + ", remark="
            + this.remark
            + ", dictionaryDetail="
            + this.dictionaryDetail
            + ", sort="
            + this.sort
            + ", type="
            + this.type
            + ", code="
            + this.code
            + ", status="
            + this.status
            + ")";
      }
   }
}
