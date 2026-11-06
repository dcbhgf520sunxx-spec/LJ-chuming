package com.hzchum.scim.system.core.api.pojo.dto.steel;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.common.core.api.enums.MesProductEnum;
import com.hzchum.scim.common.core.api.enums.ProductClassificationEnum;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SteelClassificationSaveDTOParam {
   @ApiModelProperty("mes分类")
   @NotNull(message = "mes分类不能为空")
   @EnumValidator(value = MesProductEnum.class, message = "mes分类不存在!")
   private Integer mesProductEnum;
   @ApiModelProperty("零件类型")
   @NotNull(message = "零件类型不能为空")
   @EnumValidator(value = ProductClassificationEnum.class, message = "零件类型不存在!")
   private Integer productClassificationEnum;
   @ApiModelProperty("零件翼腹板名称匹配列表")
   private List<String> steelClassNamePrefixDTOParams;
   @ApiModelProperty("零件种类名称")
   @NotBlank(message = "零件种类名称不能为空")
   @Size(min = 1, max = 32, message = "零件种类名称长度超出范围")
   private String name;
   @ApiModelProperty("排序")
   @NotNull(message = "排序不能为空")
   @Min(value = 1L, message = "排序最小为1")
   private Integer sort;
   @ApiModelProperty("关键字符")
   @NotEmpty(message = "关键字符不能为空")
   @Valid
   private List<SteelClassificationMatchDTOParam> links;
   @ApiModelProperty("科目关联")
   private List<Long> classifyIds;

   public Integer getMesProductEnum() {
      return this.mesProductEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public List<String> getSteelClassNamePrefixDTOParams() {
      return this.steelClassNamePrefixDTOParams;
   }

   public String getName() {
      return this.name;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<SteelClassificationMatchDTOParam> getLinks() {
      return this.links;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public void setMesProductEnum(final Integer mesProductEnum) {
      this.mesProductEnum = mesProductEnum;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setSteelClassNamePrefixDTOParams(final List<String> steelClassNamePrefixDTOParams) {
      this.steelClassNamePrefixDTOParams = steelClassNamePrefixDTOParams;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setLinks(final List<SteelClassificationMatchDTOParam> links) {
      this.links = links;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelClassificationSaveDTOParam)) {
         return false;
      }

      SteelClassificationSaveDTOParam other = (SteelClassificationSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$mesProductEnum = this.getMesProductEnum();
      Object other$mesProductEnum = other.getMesProductEnum();
      if (this$mesProductEnum == null ? other$mesProductEnum == null : this$mesProductEnum.equals(other$mesProductEnum)) {
         Object this$productClassificationEnum = this.getProductClassificationEnum();
         Object other$productClassificationEnum = other.getProductClassificationEnum();
         if (this$productClassificationEnum == null
            ? other$productClassificationEnum == null
            : this$productClassificationEnum.equals(other$productClassificationEnum)) {
            Object this$sort = this.getSort();
            Object other$sort = other.getSort();
            if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
               Object this$steelClassNamePrefixDTOParams = this.getSteelClassNamePrefixDTOParams();
               Object other$steelClassNamePrefixDTOParams = other.getSteelClassNamePrefixDTOParams();
               if (this$steelClassNamePrefixDTOParams == null
                  ? other$steelClassNamePrefixDTOParams == null
                  : this$steelClassNamePrefixDTOParams.equals(other$steelClassNamePrefixDTOParams)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$links = this.getLinks();
                     Object other$links = other.getLinks();
                     if (this$links == null ? other$links == null : this$links.equals(other$links)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelClassificationSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $mesProductEnum = this.getMesProductEnum();
      result = result * 59 + ($mesProductEnum == null ? 43 : $mesProductEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $steelClassNamePrefixDTOParams = this.getSteelClassNamePrefixDTOParams();
      result = result * 59 + ($steelClassNamePrefixDTOParams == null ? 43 : $steelClassNamePrefixDTOParams.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $links = this.getLinks();
      result = result * 59 + ($links == null ? 43 : $links.hashCode());
      Object $classifyIds = this.getClassifyIds();
      return result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassificationSaveDTOParam(mesProductEnum="
         + this.getMesProductEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", steelClassNamePrefixDTOParams="
         + this.getSteelClassNamePrefixDTOParams()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", links="
         + this.getLinks()
         + ", classifyIds="
         + this.getClassifyIds()
         + ")";
   }
}
