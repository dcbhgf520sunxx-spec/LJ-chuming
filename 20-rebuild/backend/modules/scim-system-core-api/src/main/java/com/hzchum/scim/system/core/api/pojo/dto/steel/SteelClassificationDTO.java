package com.hzchum.scim.system.core.api.pojo.dto.steel;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SteelClassificationDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("零件名称")
   private String name;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("物料基础分类")
   private Integer basicClass;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "钢板类型 1.零件板 2.翼腹板")
   private Integer steelPlateTypeEnum;
   @ApiModelProperty("零件类型")
   private Integer productClassificationEnum;
   @ApiModelProperty("关键字符")
   private List<SteelClassificationMatchDTOParam> links;
   @ApiModelProperty("科目关联")
   private List<SteelClassifyLinkDTO> classifyLinks;
   @ApiModelProperty("科目关联")
   private List<Long> boundFinalClassifyIds;
   @ApiModelProperty("零件翼腹板名称匹配列表")
   private List<String> steelClassNames;
   @ApiModelProperty("零件翼腹板名称匹配列表")
   private List<String> steelClassNamePrefixDTOParams;

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

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public Integer getProductClassificationEnum() {
      return this.productClassificationEnum;
   }

   public List<SteelClassificationMatchDTOParam> getLinks() {
      return this.links;
   }

   public List<SteelClassifyLinkDTO> getClassifyLinks() {
      return this.classifyLinks;
   }

   public List<Long> getBoundFinalClassifyIds() {
      return this.boundFinalClassifyIds;
   }

   public List<String> getSteelClassNames() {
      return this.steelClassNames;
   }

   public List<String> getSteelClassNamePrefixDTOParams() {
      return this.steelClassNamePrefixDTOParams;
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

   public void setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public void setProductClassificationEnum(final Integer productClassificationEnum) {
      this.productClassificationEnum = productClassificationEnum;
   }

   public void setLinks(final List<SteelClassificationMatchDTOParam> links) {
      this.links = links;
   }

   public void setClassifyLinks(final List<SteelClassifyLinkDTO> classifyLinks) {
      this.classifyLinks = classifyLinks;
   }

   public void setBoundFinalClassifyIds(final List<Long> boundFinalClassifyIds) {
      this.boundFinalClassifyIds = boundFinalClassifyIds;
   }

   public void setSteelClassNames(final List<String> steelClassNames) {
      this.steelClassNames = steelClassNames;
   }

   public void setSteelClassNamePrefixDTOParams(final List<String> steelClassNamePrefixDTOParams) {
      this.steelClassNamePrefixDTOParams = steelClassNamePrefixDTOParams;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelClassificationDTO)) {
         return false;
      }

      SteelClassificationDTO other = (SteelClassificationDTO)o;
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
               Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
               Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
               if (this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                  Object this$productClassificationEnum = this.getProductClassificationEnum();
                  Object other$productClassificationEnum = other.getProductClassificationEnum();
                  if (this$productClassificationEnum == null
                     ? other$productClassificationEnum == null
                     : this$productClassificationEnum.equals(other$productClassificationEnum)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$links = this.getLinks();
                        Object other$links = other.getLinks();
                        if (this$links == null ? other$links == null : this$links.equals(other$links)) {
                           Object this$classifyLinks = this.getClassifyLinks();
                           Object other$classifyLinks = other.getClassifyLinks();
                           if (this$classifyLinks == null ? other$classifyLinks == null : this$classifyLinks.equals(other$classifyLinks)) {
                              Object this$boundFinalClassifyIds = this.getBoundFinalClassifyIds();
                              Object other$boundFinalClassifyIds = other.getBoundFinalClassifyIds();
                              if (this$boundFinalClassifyIds == null
                                 ? other$boundFinalClassifyIds == null
                                 : this$boundFinalClassifyIds.equals(other$boundFinalClassifyIds)) {
                                 Object this$steelClassNames = this.getSteelClassNames();
                                 Object other$steelClassNames = other.getSteelClassNames();
                                 if (this$steelClassNames == null ? other$steelClassNames == null : this$steelClassNames.equals(other$steelClassNames)) {
                                    Object this$steelClassNamePrefixDTOParams = this.getSteelClassNamePrefixDTOParams();
                                    Object other$steelClassNamePrefixDTOParams = other.getSteelClassNamePrefixDTOParams();
                                    return this$steelClassNamePrefixDTOParams == null
                                       ? other$steelClassNamePrefixDTOParams == null
                                       : this$steelClassNamePrefixDTOParams.equals(other$steelClassNamePrefixDTOParams);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelClassificationDTO;
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
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $productClassificationEnum = this.getProductClassificationEnum();
      result = result * 59 + ($productClassificationEnum == null ? 43 : $productClassificationEnum.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $links = this.getLinks();
      result = result * 59 + ($links == null ? 43 : $links.hashCode());
      Object $classifyLinks = this.getClassifyLinks();
      result = result * 59 + ($classifyLinks == null ? 43 : $classifyLinks.hashCode());
      Object $boundFinalClassifyIds = this.getBoundFinalClassifyIds();
      result = result * 59 + ($boundFinalClassifyIds == null ? 43 : $boundFinalClassifyIds.hashCode());
      Object $steelClassNames = this.getSteelClassNames();
      result = result * 59 + ($steelClassNames == null ? 43 : $steelClassNames.hashCode());
      Object $steelClassNamePrefixDTOParams = this.getSteelClassNamePrefixDTOParams();
      return result * 59 + ($steelClassNamePrefixDTOParams == null ? 43 : $steelClassNamePrefixDTOParams.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassificationDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sort="
         + this.getSort()
         + ", basicClass="
         + this.getBasicClass()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ", productClassificationEnum="
         + this.getProductClassificationEnum()
         + ", links="
         + this.getLinks()
         + ", classifyLinks="
         + this.getClassifyLinks()
         + ", boundFinalClassifyIds="
         + this.getBoundFinalClassifyIds()
         + ", steelClassNames="
         + this.getSteelClassNames()
         + ", steelClassNamePrefixDTOParams="
         + this.getSteelClassNamePrefixDTOParams()
         + ")";
   }
}
