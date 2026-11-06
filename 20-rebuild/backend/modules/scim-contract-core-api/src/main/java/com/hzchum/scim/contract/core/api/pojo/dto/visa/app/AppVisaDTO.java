package com.hzchum.scim.contract.core.api.pojo.dto.visa.app;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.contract.core.api.pojo.dto.visa.ContractVisaDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("每月完成量")
public class AppVisaDTO {
   @ApiModelProperty(name = "internallyVisaList", notes = "对内签证")
   @JsonProperty("internallyVisaList")
   @JSONField(name = "internallyVisaList")
   @JsonInclude(Include.NON_NULL)
   List<ContractVisaDTO> internallyVisaList;
   @ApiModelProperty(name = "foreignVisaList", notes = "对外签证")
   @JsonProperty("foreignVisaList")
   @JSONField(name = "foreignVisaList")
   @JsonInclude(Include.NON_NULL)
   List<ContractVisaDTO> foreignVisaList;

   public static AppVisaDTO.AppVisaDTOBuilder builder() {
      return new AppVisaDTO.AppVisaDTOBuilder();
   }

   public List<ContractVisaDTO> getInternallyVisaList() {
      return this.internallyVisaList;
   }

   public List<ContractVisaDTO> getForeignVisaList() {
      return this.foreignVisaList;
   }

   @JsonProperty("internallyVisaList")
   public void setInternallyVisaList(final List<ContractVisaDTO> internallyVisaList) {
      this.internallyVisaList = internallyVisaList;
   }

   @JsonProperty("foreignVisaList")
   public void setForeignVisaList(final List<ContractVisaDTO> foreignVisaList) {
      this.foreignVisaList = foreignVisaList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AppVisaDTO)) {
         return false;
      } else {
         AppVisaDTO other = (AppVisaDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$internallyVisaList = this.getInternallyVisaList();
            Object other$internallyVisaList = other.getInternallyVisaList();
            if (this$internallyVisaList == null ? other$internallyVisaList == null : this$internallyVisaList.equals(other$internallyVisaList)) {
               Object this$foreignVisaList = this.getForeignVisaList();
               Object other$foreignVisaList = other.getForeignVisaList();
               return this$foreignVisaList == null ? other$foreignVisaList == null : this$foreignVisaList.equals(other$foreignVisaList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AppVisaDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $internallyVisaList = this.getInternallyVisaList();
      result = result * 59 + ($internallyVisaList == null ? 43 : $internallyVisaList.hashCode());
      Object $foreignVisaList = this.getForeignVisaList();
      return result * 59 + ($foreignVisaList == null ? 43 : $foreignVisaList.hashCode());
   }

   @Override
   public String toString() {
      return "AppVisaDTO(internallyVisaList=" + this.getInternallyVisaList() + ", foreignVisaList=" + this.getForeignVisaList() + ")";
   }

   public AppVisaDTO(final List<ContractVisaDTO> internallyVisaList, final List<ContractVisaDTO> foreignVisaList) {
      this.internallyVisaList = internallyVisaList;
      this.foreignVisaList = foreignVisaList;
   }

   public AppVisaDTO() {
   }

   public static class AppVisaDTOBuilder {
      private List<ContractVisaDTO> internallyVisaList;
      private List<ContractVisaDTO> foreignVisaList;

      AppVisaDTOBuilder() {
      }

      @JsonProperty("internallyVisaList")
      public AppVisaDTO.AppVisaDTOBuilder internallyVisaList(final List<ContractVisaDTO> internallyVisaList) {
         this.internallyVisaList = internallyVisaList;
         return this;
      }

      @JsonProperty("foreignVisaList")
      public AppVisaDTO.AppVisaDTOBuilder foreignVisaList(final List<ContractVisaDTO> foreignVisaList) {
         this.foreignVisaList = foreignVisaList;
         return this;
      }

      public AppVisaDTO build() {
         return new AppVisaDTO(this.internallyVisaList, this.foreignVisaList);
      }

      @Override
      public String toString() {
         return "AppVisaDTO.AppVisaDTOBuilder(internallyVisaList=" + this.internallyVisaList + ", foreignVisaList=" + this.foreignVisaList + ")";
      }
   }
}
