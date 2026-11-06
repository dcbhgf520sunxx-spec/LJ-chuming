package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.system.core.api.pojo.dto.AssembleSpecDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "组立配置修改类 ")
public class AssembleConfigUpdateDTOParam {
   @ApiModelProperty("mes分类")
   @NotNull(message = "mes分类不能为空")
   @EnumValidator(value = MesProductEnum.class, message = "mes分类不存在!")
   private Integer mesProductEnum;
   @ApiModelProperty("组立配置id")
   @NotNull(message = "组立配置id不能为空")
   private Long id;
   @ApiModelProperty("组立名称")
   @NotBlank(message = "组立名称不能为空")
   @Size(min = 1, max = 32, message = "组立类型名称长度超出范围")
   private String name;
   @ApiModelProperty(name = "boolSectionSteel", value = "是否成品型材 [0 否, 1 是]", notes = "是否成品型材 [0 否, 1 是]")
   @NotNull(message = "是否成品型材不能为空")
   private Boolean boolSectionSteel;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("组立规格前缀列表")
   @NotEmpty(message = "组立规格前缀列表不能为空")
   @Valid
   private List<AssembleSpecDTOParam> assembleSpecList;

   public static AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder builder() {
      return new AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder();
   }

   public AssembleConfigUpdateDTOParam() {
   }

   public AssembleConfigUpdateDTOParam(
      final Integer mesProductEnum,
      final Long id,
      final String name,
      final Boolean boolSectionSteel,
      final Integer sort,
      final List<AssembleSpecDTOParam> assembleSpecList
   ) {
      this.mesProductEnum = mesProductEnum;
      this.id = id;
      this.name = name;
      this.boolSectionSteel = boolSectionSteel;
      this.sort = sort;
      this.assembleSpecList = assembleSpecList;
   }

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
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

   public Integer getSort() {
      return this.sort;
   }

   public List<AssembleSpecDTOParam> getAssembleSpecList() {
      return this.assembleSpecList;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
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

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setAssembleSpecList(final List<AssembleSpecDTOParam> assembleSpecList) {
      this.assembleSpecList = assembleSpecList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AssembleConfigUpdateDTOParam)) {
         return false;
      }

      AssembleConfigUpdateDTOParam other = (AssembleConfigUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$mesProductEnum = this.getMesProductEnum();
      Object other$mesProductEnum = other.getMesProductEnum();
      if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
         Object this$id = this.getId();
         Object other$id = other.getId();
         if (this$id == null ? other$id == null : this$id.equals(other$id)) {
            Object this$boolSectionSteel = this.getBoolSectionSteel();
            Object other$boolSectionSteel = other.getBoolSectionSteel();
            if (this$boolSectionSteel == null ? other$boolSectionSteel == null : this$boolSectionSteel.equals(other$boolSectionSteel)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$assembleSpecList = this.getAssembleSpecList();
                     Object other$assembleSpecList = other.getAssembleSpecList();
                     return this$assembleSpecList == null ? other$assembleSpecList == null : this$assembleSpecList.equals(other$assembleSpecList);
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
      return other instanceof AssembleConfigUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolSectionSteel = this.getBoolSectionSteel();
      result = result * 59 + ($boolSectionSteel == null ? 43 : $boolSectionSteel.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $assembleSpecList = this.getAssembleSpecList();
      return result * 59 + ($assembleSpecList == null ? 43 : $assembleSpecList.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleConfigUpdateDTOParam(mesProductEnum="
         + this.getMesProductEnum()
         + ", id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", boolSectionSteel="
         + this.getBoolSectionSteel()
         + ", sort="
         + this.getSort()
         + ", assembleSpecList="
         + this.getAssembleSpecList()
         + ")";
   }

   public static class AssembleConfigUpdateDTOParamBuilder {
      private Integer mesProductEnum;
      private Long id;
      private String name;
      private Boolean boolSectionSteel;
      private Integer sort;
      private List<AssembleSpecDTOParam> assembleSpecList;

      AssembleConfigUpdateDTOParamBuilder() {
      }

      public AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder mesProductEnum(final Integer mesProductEnum) {
         this.mesProductEnum = mesProductEnum;
         return this;
      }

      public AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder boolSectionSteel(final Boolean boolSectionSteel) {
         this.boolSectionSteel = boolSectionSteel;
         return this;
      }

      public AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder sort(final Integer sort) {
         this.sort = sort;
         return this;
      }

      public AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder assembleSpecList(final List<AssembleSpecDTOParam> assembleSpecList) {
         this.assembleSpecList = assembleSpecList;
         return this;
      }

      public AssembleConfigUpdateDTOParam build() {
         return new AssembleConfigUpdateDTOParam(this.mesProductEnum, this.id, this.name, this.boolSectionSteel, this.sort, this.assembleSpecList);
      }

      @Override
      public String toString() {
         return "AssembleConfigUpdateDTOParam.AssembleConfigUpdateDTOParamBuilder(mesProductEnum="
            + this.mesProductEnum
            + ", id="
            + this.id
            + ", name="
            + this.name
            + ", boolSectionSteel="
            + this.boolSectionSteel
            + ", sort="
            + this.sort
            + ", assembleSpecList="
            + this.assembleSpecList
            + ")";
      }
   }
}
