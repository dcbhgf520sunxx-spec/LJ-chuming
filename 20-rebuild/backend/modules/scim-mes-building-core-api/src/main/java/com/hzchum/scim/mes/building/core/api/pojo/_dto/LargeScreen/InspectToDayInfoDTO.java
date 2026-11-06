package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "今日上报问题信息")
public class InspectToDayInfoDTO {
   @ApiModelProperty(name = "qhseCount", notes = "今日上报数", value = "今日上报数")
   @JsonProperty("qhseCount")
   @JSONField(name = "qhseCount")
   private BigDecimal qhseCount;
   @ApiModelProperty(name = "successQhseCount", notes = "今日通过数", value = "今日通过数")
   @JsonProperty("successQhseCount")
   @JSONField(name = "successQhseCount")
   private BigDecimal successQhseCount;
   @ApiModelProperty(name = "unSuccessQhseCount", notes = "今日未通过数", value = "今日未通过数")
   @JsonProperty("unSuccessQhseCount")
   @JSONField(name = "unSuccessQhseCount")
   private BigDecimal unSuccessQhseCount;
   @ApiModelProperty(name = "list", notes = "质检上报列表", value = "质检上报列表")
   private List<InspectToDayListDTO> list;

   public static InspectToDayInfoDTO.InspectToDayInfoDTOBuilder builder() {
      return new InspectToDayInfoDTO.InspectToDayInfoDTOBuilder();
   }

   public BigDecimal getQhseCount() {
      return this.qhseCount;
   }

   public BigDecimal getSuccessQhseCount() {
      return this.successQhseCount;
   }

   public BigDecimal getUnSuccessQhseCount() {
      return this.unSuccessQhseCount;
   }

   public List<InspectToDayListDTO> getList() {
      return this.list;
   }

   @JsonProperty("qhseCount")
   public void setQhseCount(final BigDecimal qhseCount) {
      this.qhseCount = qhseCount;
   }

   @JsonProperty("successQhseCount")
   public void setSuccessQhseCount(final BigDecimal successQhseCount) {
      this.successQhseCount = successQhseCount;
   }

   @JsonProperty("unSuccessQhseCount")
   public void setUnSuccessQhseCount(final BigDecimal unSuccessQhseCount) {
      this.unSuccessQhseCount = unSuccessQhseCount;
   }

   public void setList(final List<InspectToDayListDTO> list) {
      this.list = list;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InspectToDayInfoDTO)) {
         return false;
      }

      InspectToDayInfoDTO other = (InspectToDayInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$qhseCount = this.getQhseCount();
      Object other$qhseCount = other.getQhseCount();
      if (this$qhseCount == null ? other$qhseCount == null : this$qhseCount.equals(other$qhseCount)) {
         Object this$successQhseCount = this.getSuccessQhseCount();
         Object other$successQhseCount = other.getSuccessQhseCount();
         if (this$successQhseCount == null ? other$successQhseCount == null : this$successQhseCount.equals(other$successQhseCount)) {
            Object this$unSuccessQhseCount = this.getUnSuccessQhseCount();
            Object other$unSuccessQhseCount = other.getUnSuccessQhseCount();
            if (this$unSuccessQhseCount == null ? other$unSuccessQhseCount == null : this$unSuccessQhseCount.equals(other$unSuccessQhseCount)) {
               Object this$list = this.getList();
               Object other$list = other.getList();
               return this$list == null ? other$list == null : this$list.equals(other$list);
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
      return other instanceof InspectToDayInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $qhseCount = this.getQhseCount();
      result = result * 59 + ($qhseCount == null ? 43 : $qhseCount.hashCode());
      Object $successQhseCount = this.getSuccessQhseCount();
      result = result * 59 + ($successQhseCount == null ? 43 : $successQhseCount.hashCode());
      Object $unSuccessQhseCount = this.getUnSuccessQhseCount();
      result = result * 59 + ($unSuccessQhseCount == null ? 43 : $unSuccessQhseCount.hashCode());
      Object $list = this.getList();
      return result * 59 + ($list == null ? 43 : $list.hashCode());
   }

   @Override
   public String toString() {
      return "InspectToDayInfoDTO(super="
         + super.toString()
         + ", qhseCount="
         + this.getQhseCount()
         + ", successQhseCount="
         + this.getSuccessQhseCount()
         + ", unSuccessQhseCount="
         + this.getUnSuccessQhseCount()
         + ", list="
         + this.getList()
         + ")";
   }

   public InspectToDayInfoDTO(
      final BigDecimal qhseCount, final BigDecimal successQhseCount, final BigDecimal unSuccessQhseCount, final List<InspectToDayListDTO> list
   ) {
      this.qhseCount = qhseCount;
      this.successQhseCount = successQhseCount;
      this.unSuccessQhseCount = unSuccessQhseCount;
      this.list = list;
   }

   public InspectToDayInfoDTO() {
   }

   public static class InspectToDayInfoDTOBuilder {
      private BigDecimal qhseCount;
      private BigDecimal successQhseCount;
      private BigDecimal unSuccessQhseCount;
      private List<InspectToDayListDTO> list;

      InspectToDayInfoDTOBuilder() {
      }

      @JsonProperty("qhseCount")
      public InspectToDayInfoDTO.InspectToDayInfoDTOBuilder qhseCount(final BigDecimal qhseCount) {
         this.qhseCount = qhseCount;
         return this;
      }

      @JsonProperty("successQhseCount")
      public InspectToDayInfoDTO.InspectToDayInfoDTOBuilder successQhseCount(final BigDecimal successQhseCount) {
         this.successQhseCount = successQhseCount;
         return this;
      }

      @JsonProperty("unSuccessQhseCount")
      public InspectToDayInfoDTO.InspectToDayInfoDTOBuilder unSuccessQhseCount(final BigDecimal unSuccessQhseCount) {
         this.unSuccessQhseCount = unSuccessQhseCount;
         return this;
      }

      public InspectToDayInfoDTO.InspectToDayInfoDTOBuilder list(final List<InspectToDayListDTO> list) {
         this.list = list;
         return this;
      }

      public InspectToDayInfoDTO build() {
         return new InspectToDayInfoDTO(this.qhseCount, this.successQhseCount, this.unSuccessQhseCount, this.list);
      }

      @Override
      public String toString() {
         return "InspectToDayInfoDTO.InspectToDayInfoDTOBuilder(qhseCount="
            + this.qhseCount
            + ", successQhseCount="
            + this.successQhseCount
            + ", unSuccessQhseCount="
            + this.unSuccessQhseCount
            + ", list="
            + this.list
            + ")";
      }
   }
}
