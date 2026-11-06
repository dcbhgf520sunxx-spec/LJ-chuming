package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingNeedMachinePartSchedulingDTO", description = "每个月份需要排产的数量")
public class MesBuildingNeedMachinePartSchedulingDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @JsonInclude(Include.NON_NULL)
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "date", value = "排产日期", notes = "排产日期")
   @JsonProperty("date")
   @JSONField(name = "date")
   @JsonInclude(Include.NON_NULL)
   private String month;
   @ApiModelProperty(name = "needMachinePartLinkList", value = "每个生产组每月需要排产的数量")
   @JsonProperty("needMachinePartLinkList")
   @JSONField(name = "needMachinePartLinkList")
   private List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList;

   public static MesBuildingNeedMachinePartSchedulingDTO.MesBuildingNeedMachinePartSchedulingDTOBuilder builder() {
      return new MesBuildingNeedMachinePartSchedulingDTO.MesBuildingNeedMachinePartSchedulingDTOBuilder();
   }

   public MesBuildingNeedMachinePartSchedulingDTO(
      final Long id, final Integer quantity, final String month, final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList
   ) {
      this.id = id;
      this.quantity = quantity;
      this.month = month;
      this.needMachinePartLinkList = needMachinePartLinkList;
   }

   public MesBuildingNeedMachinePartSchedulingDTO() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getMonth() {
      return this.month;
   }

   public List<MesBuildingNeedMachinePartSchedulingLinkDTO> getNeedMachinePartLinkList() {
      return this.needMachinePartLinkList;
   }

   @JsonProperty("id")
   public MesBuildingNeedMachinePartSchedulingDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingNeedMachinePartSchedulingDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("date")
   public MesBuildingNeedMachinePartSchedulingDTO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("needMachinePartLinkList")
   public MesBuildingNeedMachinePartSchedulingDTO setNeedMachinePartLinkList(final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList) {
      this.needMachinePartLinkList = needMachinePartLinkList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingNeedMachinePartSchedulingDTO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", month="
         + this.getMonth()
         + ", needMachinePartLinkList="
         + this.getNeedMachinePartLinkList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingNeedMachinePartSchedulingDTO)) {
         return false;
      }

      MesBuildingNeedMachinePartSchedulingDTO other = (MesBuildingNeedMachinePartSchedulingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$needMachinePartLinkList = this.getNeedMachinePartLinkList();
               Object other$needMachinePartLinkList = other.getNeedMachinePartLinkList();
               return this$needMachinePartLinkList == null
                  ? other$needMachinePartLinkList == null
                  : this$needMachinePartLinkList.equals(other$needMachinePartLinkList);
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
      return other instanceof MesBuildingNeedMachinePartSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $needMachinePartLinkList = this.getNeedMachinePartLinkList();
      return result * 59 + ($needMachinePartLinkList == null ? 43 : $needMachinePartLinkList.hashCode());
   }

   public static class MesBuildingNeedMachinePartSchedulingDTOBuilder {
      private Long id;
      private Integer quantity;
      private String month;
      private List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList;

      MesBuildingNeedMachinePartSchedulingDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingNeedMachinePartSchedulingDTO.MesBuildingNeedMachinePartSchedulingDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingNeedMachinePartSchedulingDTO.MesBuildingNeedMachinePartSchedulingDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("date")
      public MesBuildingNeedMachinePartSchedulingDTO.MesBuildingNeedMachinePartSchedulingDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("needMachinePartLinkList")
      public MesBuildingNeedMachinePartSchedulingDTO.MesBuildingNeedMachinePartSchedulingDTOBuilder needMachinePartLinkList(
         final List<MesBuildingNeedMachinePartSchedulingLinkDTO> needMachinePartLinkList
      ) {
         this.needMachinePartLinkList = needMachinePartLinkList;
         return this;
      }

      public MesBuildingNeedMachinePartSchedulingDTO build() {
         return new MesBuildingNeedMachinePartSchedulingDTO(this.id, this.quantity, this.month, this.needMachinePartLinkList);
      }

      @Override
      public String toString() {
         return "MesBuildingNeedMachinePartSchedulingDTO.MesBuildingNeedMachinePartSchedulingDTOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", month="
            + this.month
            + ", needMachinePartLinkList="
            + this.needMachinePartLinkList
            + ")";
      }
   }
}
