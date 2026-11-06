package com.hzchum.scim.scm.core.api.pojo.dtoParam.scm;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

@ApiModel(value = "ReviewTemplateDTOParam", description = "评审模板配置编辑入参")
public class ReviewTemplateDTOParam {
   @ApiModelProperty(value = "主键ID", required = true)
   @NotNull(message = "id不能为空")
   private Long id;
   @ApiModelProperty(value = "评审模板内容JSON字符串", required = true)
   @NotNull(message = "评审模板内容不能为空")
   private String value;
   @ApiModelProperty("评审模板 固定字段 ")
   private Map<String, String> columnMap = new HashMap<>();

   public static ReviewTemplateDTOParam.ReviewTemplateDTOParamBuilder builder() {
      return new ReviewTemplateDTOParam.ReviewTemplateDTOParamBuilder();
   }

   public ReviewTemplateDTOParam() {
   }

   public ReviewTemplateDTOParam(final Long id, final String value, final Map<String, String> columnMap) {
      this.id = id;
      this.value = value;
      this.columnMap = columnMap;
   }

   public Long getId() {
      return this.id;
   }

   public String getValue() {
      return this.value;
   }

   public Map<String, String> getColumnMap() {
      return this.columnMap;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setValue(final String value) {
      this.value = value;
   }

   public void setColumnMap(final Map<String, String> columnMap) {
      this.columnMap = columnMap;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReviewTemplateDTOParam)) {
         return false;
      }

      ReviewTemplateDTOParam other = (ReviewTemplateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$value = this.getValue();
         Object other$value = other.getValue();
         if (this$value == null ? other$value == null : this$value.equals(other$value)) {
            Object this$columnMap = this.getColumnMap();
            Object other$columnMap = other.getColumnMap();
            return this$columnMap == null ? other$columnMap == null : this$columnMap.equals(other$columnMap);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReviewTemplateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $value = this.getValue();
      result = result * 59 + ($value == null ? 43 : $value.hashCode());
      Object $columnMap = this.getColumnMap();
      return result * 59 + ($columnMap == null ? 43 : $columnMap.hashCode());
   }

   @Override
   public String toString() {
      return "ReviewTemplateDTOParam(id=" + this.getId() + ", value=" + this.getValue() + ", columnMap=" + this.getColumnMap() + ")";
   }

   public static class ReviewTemplateDTOParamBuilder {
      private Long id;
      private String value;
      private Map<String, String> columnMap;

      ReviewTemplateDTOParamBuilder() {
      }

      public ReviewTemplateDTOParam.ReviewTemplateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReviewTemplateDTOParam.ReviewTemplateDTOParamBuilder value(final String value) {
         this.value = value;
         return this;
      }

      public ReviewTemplateDTOParam.ReviewTemplateDTOParamBuilder columnMap(final Map<String, String> columnMap) {
         this.columnMap = columnMap;
         return this;
      }

      public ReviewTemplateDTOParam build() {
         return new ReviewTemplateDTOParam(this.id, this.value, this.columnMap);
      }

      @Override
      public String toString() {
         return "ReviewTemplateDTOParam.ReviewTemplateDTOParamBuilder(id=" + this.id + ", value=" + this.value + ", columnMap=" + this.columnMap + ")";
      }
   }
}
