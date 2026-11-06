package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.scim.system.core.api.pojo.dto.SysEnclosureDictionaryDetailDTOParam;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnclosureDictionaryDTOParam {
   private Long id;
   @ApiModelProperty("围护类型")
   @NotNull(message = "围护类型不能为空")
   private Integer type;
   @NotBlank(message = "字典名称不能为空")
   @ApiModelProperty("字典名称")
   private String name;
   @NotBlank(message = "字典详情名称或值不能为空")
   @ApiModelProperty("字典详情名称或值")
   private String label;
   @ApiModelProperty("版型详情")
   private SysEnclosureDictionaryDetailDTOParam dictionaryDetail;
   @NotNull(message = "排序不能为空")
   @ApiModelProperty("排序")
   @Min(value = 0L, message = "排序值太大,超出范围!")
   @Max(value = 10000L, message = "排序值太大,超出范围!")
   private Integer sort;

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getLabel() {
      return this.label;
   }

   public SysEnclosureDictionaryDetailDTOParam getDictionaryDetail() {
      return this.dictionaryDetail;
   }

   public Integer getSort() {
      return this.sort;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   public void setDictionaryDetail(final SysEnclosureDictionaryDetailDTOParam dictionaryDetail) {
      this.dictionaryDetail = dictionaryDetail;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureDictionaryDTOParam)) {
         return false;
      }

      EnclosureDictionaryDTOParam other = (EnclosureDictionaryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$label = this.getLabel();
                  Object other$label = other.getLabel();
                  if (this$label == null ? other$label == null : this$label.equals(other$label)) {
                     Object this$dictionaryDetail = this.getDictionaryDetail();
                     Object other$dictionaryDetail = other.getDictionaryDetail();
                     return this$dictionaryDetail == null ? other$dictionaryDetail == null : this$dictionaryDetail.equals(other$dictionaryDetail);
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
      return other instanceof EnclosureDictionaryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $label = this.getLabel();
      result = result * 59 + ($label == null ? 43 : $label.hashCode());
      Object $dictionaryDetail = this.getDictionaryDetail();
      return result * 59 + ($dictionaryDetail == null ? 43 : $dictionaryDetail.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureDictionaryDTOParam(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", name="
         + this.getName()
         + ", label="
         + this.getLabel()
         + ", dictionaryDetail="
         + this.getDictionaryDetail()
         + ", sort="
         + this.getSort()
         + ")";
   }
}
