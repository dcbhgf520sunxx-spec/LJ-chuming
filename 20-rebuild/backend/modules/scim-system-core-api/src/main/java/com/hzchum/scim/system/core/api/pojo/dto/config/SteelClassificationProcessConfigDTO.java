package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.hzchum.scim.system.core.api.pojo.dto.steel.SteelClassificationMatchDTO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SteelClassificationProcessConfigDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("零件类型[1 板材零件 2 型材零件]")
   private Integer partType;
   @ApiModelProperty(name = "name", value = "产品截面类型名称(产品名称/产品截面名称/截面类型名称)")
   private String name;
   @ApiModelProperty("匹配名称")
   private String matchingNames;
   @ApiModelProperty("匹配截面")
   private List<SteelClassificationMatchDTO> matchDTOList;
   @ApiModelProperty(name = "productProcessLinkList", notes = "工序详情")
   private List<ProductProcessLinkDTO> productProcessLinkList;

   public Long getId() {
      return this.id;
   }

   public Integer getPartType() {
      return this.partType;
   }

   public String getName() {
      return this.name;
   }

   public String getMatchingNames() {
      return this.matchingNames;
   }

   public List<SteelClassificationMatchDTO> getMatchDTOList() {
      return this.matchDTOList;
   }

   public List<ProductProcessLinkDTO> getProductProcessLinkList() {
      return this.productProcessLinkList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPartType(final Integer partType) {
      this.partType = partType;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMatchingNames(final String matchingNames) {
      this.matchingNames = matchingNames;
   }

   public void setMatchDTOList(final List<SteelClassificationMatchDTO> matchDTOList) {
      this.matchDTOList = matchDTOList;
   }

   public void setProductProcessLinkList(final List<ProductProcessLinkDTO> productProcessLinkList) {
      this.productProcessLinkList = productProcessLinkList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelClassificationProcessConfigDTO)) {
         return false;
      }

      SteelClassificationProcessConfigDTO other = (SteelClassificationProcessConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$partType = this.getPartType();
         Object other$partType = other.getPartType();
         if (this$partType == null ? other$partType == null : this$partType.equals(other$partType)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$matchingNames = this.getMatchingNames();
               Object other$matchingNames = other.getMatchingNames();
               if (this$matchingNames == null ? other$matchingNames == null : this$matchingNames.equals(other$matchingNames)) {
                  Object this$matchDTOList = this.getMatchDTOList();
                  Object other$matchDTOList = other.getMatchDTOList();
                  if (this$matchDTOList == null ? other$matchDTOList == null : this$matchDTOList.equals(other$matchDTOList)) {
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
      return other instanceof SteelClassificationProcessConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $partType = this.getPartType();
      result = result * 59 + ($partType == null ? 43 : $partType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $matchingNames = this.getMatchingNames();
      result = result * 59 + ($matchingNames == null ? 43 : $matchingNames.hashCode());
      Object $matchDTOList = this.getMatchDTOList();
      result = result * 59 + ($matchDTOList == null ? 43 : $matchDTOList.hashCode());
      Object $productProcessLinkList = this.getProductProcessLinkList();
      return result * 59 + ($productProcessLinkList == null ? 43 : $productProcessLinkList.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassificationProcessConfigDTO(id="
         + this.getId()
         + ", partType="
         + this.getPartType()
         + ", name="
         + this.getName()
         + ", matchingNames="
         + this.getMatchingNames()
         + ", matchDTOList="
         + this.getMatchDTOList()
         + ", productProcessLinkList="
         + this.getProductProcessLinkList()
         + ")";
   }
}
