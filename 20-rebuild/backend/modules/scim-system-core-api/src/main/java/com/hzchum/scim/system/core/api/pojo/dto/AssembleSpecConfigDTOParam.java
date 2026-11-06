package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "组立截面配置DTO类 ")
public class AssembleSpecConfigDTOParam {
   @ApiModelProperty("部件配置id")
   private Long id;
   @ApiModelProperty("组立名称")
   private String name;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [0 否, 1 是]", notes = "是否成品型材 [0 否, 1 是]")
   private Boolean boolSectionSteel;
   @ApiModelProperty(name = "specPrefix", value = "截面类型")
   private String specPrefix;

   public static AssembleSpecConfigDTOParam.AssembleSpecConfigDTOParamBuilder builder() {
      return new AssembleSpecConfigDTOParam.AssembleSpecConfigDTOParamBuilder();
   }

   public AssembleSpecConfigDTOParam() {
   }

   public AssembleSpecConfigDTOParam(final Long id, final String name, final Boolean boolSectionSteel, final String specPrefix) {
      this.id = id;
      this.name = name;
      this.boolSectionSteel = boolSectionSteel;
      this.specPrefix = specPrefix;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getBoolSectionSteel() {
      return this.boolSectionSteel;
   }

   public String getSpecPrefix() {
      return this.specPrefix;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBoolSectionSteel(final Boolean boolSectionSteel) {
      this.boolSectionSteel = boolSectionSteel;
   }

   public void setSpecPrefix(final String specPrefix) {
      this.specPrefix = specPrefix;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleSpecConfigDTOParam)) {
         return false;
      }

      AssembleSpecConfigDTOParam other = (AssembleSpecConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolSectionSteel = this.getBoolSectionSteel();
         Object other$boolSectionSteel = other.getBoolSectionSteel();
         if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$specPrefix = this.getSpecPrefix();
               Object other$specPrefix = other.getSpecPrefix();
               return this$specPrefix == null ? other$specPrefix == null : this$specPrefix.equals(other$specPrefix);
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
      return other instanceof AssembleSpecConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specPrefix = this.getSpecPrefix();
      return result * 59 + ($specPrefix == null ? 43 : $specPrefix.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleSpecConfigDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", specPrefix="
         + this.getSpecPrefix()
         + ")";
   }

   public static class AssembleSpecConfigDTOParamBuilder {
      private Long id;
      private String name;
      private Boolean boolSectionSteel;
      private String specPrefix;

      AssembleSpecConfigDTOParamBuilder() {
      }

      public AssembleSpecConfigDTOParam.AssembleSpecConfigDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleSpecConfigDTOParam.AssembleSpecConfigDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AssembleSpecConfigDTOParam.AssembleSpecConfigDTOParamBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      public AssembleSpecConfigDTOParam.AssembleSpecConfigDTOParamBuilder specPrefix(final String specPrefix) {
         this.specPrefix = specPrefix;
         return this;
      }

      public AssembleSpecConfigDTOParam build() {
         return new AssembleSpecConfigDTOParam(this.id, this.name, this.boolSectionSteel, this.specPrefix);
      }

      @Override
      public String toString() {
         return "AssembleSpecConfigDTOParam.AssembleSpecConfigDTOParamBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", specPrefix="
            + this.specPrefix
            + ")";
      }
   }
}
