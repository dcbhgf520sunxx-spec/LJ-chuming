package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.process;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SteelClassificationProcessDTO {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("钢材种类")
   private String name;
   @ApiModelProperty(name = "productProcessLinkList", notes = "工序详情")
   @JsonProperty("productProcessLinkList")
   @JSONField(name = "productProcessLinkList")
   @JsonInclude(Include.NON_NULL)
   private List<MesEnclosureProductProcessLinkDTO> productProcessLinkList;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<MesEnclosureProductProcessLinkDTO> getProductProcessLinkList() {
      return this.productProcessLinkList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @JsonProperty("productProcessLinkList")
   public void setProductProcessLinkList(final List<MesEnclosureProductProcessLinkDTO> productProcessLinkList) {
      this.productProcessLinkList = productProcessLinkList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SteelClassificationProcessDTO)) {
         return false;
      }

      SteelClassificationProcessDTO other = (SteelClassificationProcessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelClassificationProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $productProcessLinkList = this.getProductProcessLinkList();
      return result * 59 + ($productProcessLinkList == null ? 43 : $productProcessLinkList.hashCode());
   }

   @Override
   public String toString() {
      return "SteelClassificationProcessDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productProcessLinkList="
         + this.getProductProcessLinkList()
         + ")";
   }
}
