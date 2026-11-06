package com.hzchum.scim.project.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.project.core.api.enums.ConstructionStageTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("施工资料配置")
public class DataConstructionConfigDTOParam {
   @ApiModelProperty(name = "id", value = "id")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   @NotEmpty(message = "名称不能为空")
   private String name;
   @ApiModelProperty(name = "format", value = "文件格式")
   @NotNull(message = "格式不能为空")
   @Min(value = 1L, message = "格式类型错误")
   @Max(value = 63L, message = "格式类型错误")
   private Integer format;
   @ApiModelProperty(name = "stage", value = "开工阶段 1开工前2施工中3玩工后")
   @NotNull
   @EnumValidator(value = ConstructionStageTypeEnum.class, message = "开工阶段类型错误")
   private Integer stage;

   public static DataConstructionConfigDTOParam.DataConstructionConfigDTOParamBuilder builder() {
      return new DataConstructionConfigDTOParam.DataConstructionConfigDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getFormat() {
      return this.format;
   }

   public Integer getStage() {
      return this.stage;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setFormat(final Integer format) {
      this.format = format;
   }

   public void setStage(final Integer stage) {
      this.stage = stage;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DataConstructionConfigDTOParam)) {
         return false;
      }

      DataConstructionConfigDTOParam other = (DataConstructionConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$format = this.getFormat();
         Object other$format = other.getFormat();
         if (this$format == null ? other$format == null : this$format.equals(other$format)) {
            Object this$stage = this.getStage();
            Object other$stage = other.getStage();
            if (this$stage == null ? other$stage == null : this$stage.equals(other$stage)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
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
      return other instanceof DataConstructionConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $format = this.getFormat();
      result = result * 59 + ($format == null ? 43 : $format.hashCode());
      Object $stage = this.getStage();
      result = result * 59 + ($stage == null ? 43 : $stage.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "DataConstructionConfigDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", format="
         + this.getFormat()
         + ", stage="
         + this.getStage()
         + ")";
   }

   public DataConstructionConfigDTOParam() {
   }

   public DataConstructionConfigDTOParam(final Long id, final String name, final Integer format, final Integer stage) {
      this.id = id;
      this.name = name;
      this.format = format;
      this.stage = stage;
   }

   public static class DataConstructionConfigDTOParamBuilder {
      private Long id;
      private String name;
      private Integer format;
      private Integer stage;

      DataConstructionConfigDTOParamBuilder() {
      }

      public DataConstructionConfigDTOParam.DataConstructionConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public DataConstructionConfigDTOParam.DataConstructionConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public DataConstructionConfigDTOParam.DataConstructionConfigDTOParamBuilder format(final Integer format) {
         this.format = format;
         return this;
      }

      public DataConstructionConfigDTOParam.DataConstructionConfigDTOParamBuilder stage(final Integer stage) {
         this.stage = stage;
         return this;
      }

      public DataConstructionConfigDTOParam build() {
         return new DataConstructionConfigDTOParam(this.id, this.name, this.format, this.stage);
      }

      @Override
      public String toString() {
         return "DataConstructionConfigDTOParam.DataConstructionConfigDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", format="
            + this.format
            + ", stage="
            + this.stage
            + ")";
      }
   }
}
