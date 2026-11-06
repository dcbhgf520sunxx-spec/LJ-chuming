package com.hzchum.scim.system.core.api.pojo.dto;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ApiModel("溯源配置明细DTO")
public class TraceConfigItemDTO {
   @ApiModelProperty("明细主键（修改时必传）")
   @NotNull(groups = Update.class, message = "id不能为空")
   private Long id;
   @ApiModelProperty("页面展示序号，不传默认为1")
   private Integer sort;
   @ApiModelProperty("字段名称")
   @NotBlank(groups = {Add.class, Update.class}, message = "字段名称不能为空")
   private String fieldName;
   @ApiModelProperty("字段值")
   @NotBlank(groups = {Add.class, Update.class}, message = "字段值不能为空")
   private String fieldValue;
   @ApiModelProperty("要展示到的项目id列表")
   private List<Long> displayProjectIds;
   @ApiModelProperty("是否启用 0否 1是")
   private Integer enableFlag;

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

   public List<Long> getDisplayProjectIds() {
      return this.displayProjectIds;
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

   public void setDisplayProjectIds(final List<Long> displayProjectIds) {
      this.displayProjectIds = displayProjectIds;
   }

   public void setEnableFlag(final Integer enableFlag) {
      this.enableFlag = enableFlag;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TraceConfigItemDTO)) {
         return false;
      }

      TraceConfigItemDTO other = (TraceConfigItemDTO)o;
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
                     Object this$displayProjectIds = this.getDisplayProjectIds();
                     Object other$displayProjectIds = other.getDisplayProjectIds();
                     return this$displayProjectIds == null ? other$displayProjectIds == null : this$displayProjectIds.equals(other$displayProjectIds);
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
      return other instanceof TraceConfigItemDTO;
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
      Object $displayProjectIds = this.getDisplayProjectIds();
      return result * 59 + ($displayProjectIds == null ? 43 : $displayProjectIds.hashCode());
   }

   @Override
   public String toString() {
      return "TraceConfigItemDTO(id="
         + this.getId()
         + ", sort="
         + this.getSort()
         + ", fieldName="
         + this.getFieldName()
         + ", fieldValue="
         + this.getFieldValue()
         + ", displayProjectIds="
         + this.getDisplayProjectIds()
         + ", enableFlag="
         + this.getEnableFlag()
         + ")";
   }
}
