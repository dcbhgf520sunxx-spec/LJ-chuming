package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProduceAbonrmalReportAndLimitDTO", description = "异常处理页面返回类")
public class ProduceAbonrmalReportAndLimitDTO {
   @ApiModelProperty(name = "reportList", notes = "上报信息")
   @JsonProperty("reportList")
   @JSONField(name = "reportList")
   private List<ProduceAbonrmalReportDTO> reportList;
   @ApiModelProperty(name = "limitList", notes = "每道工序限制的操作量")
   @JsonProperty("limitList")
   @JSONField(name = "limitList")
   private List<TaskProcessAndQuantityDTO> limitList;
   @ApiModelProperty(name = "quantity", notes = "需要处理的数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static ProduceAbonrmalReportAndLimitDTO.ProduceAbonrmalReportAndLimitDTOBuilder builder() {
      return new ProduceAbonrmalReportAndLimitDTO.ProduceAbonrmalReportAndLimitDTOBuilder();
   }

   public ProduceAbonrmalReportAndLimitDTO() {
   }

   public ProduceAbonrmalReportAndLimitDTO(
      final List<ProduceAbonrmalReportDTO> reportList, final List<TaskProcessAndQuantityDTO> limitList, final Integer quantity
   ) {
      this.reportList = reportList;
      this.limitList = limitList;
      this.quantity = quantity;
   }

   public List<ProduceAbonrmalReportDTO> getReportList() {
      return this.reportList;
   }

   public List<TaskProcessAndQuantityDTO> getLimitList() {
      return this.limitList;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("reportList")
   public ProduceAbonrmalReportAndLimitDTO setReportList(final List<ProduceAbonrmalReportDTO> reportList) {
      this.reportList = reportList;
      return this;
   }

   @JsonProperty("limitList")
   public ProduceAbonrmalReportAndLimitDTO setLimitList(final List<TaskProcessAndQuantityDTO> limitList) {
      this.limitList = limitList;
      return this;
   }

   @JsonProperty("quantity")
   public ProduceAbonrmalReportAndLimitDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProduceAbonrmalReportAndLimitDTO(reportList="
         + this.getReportList()
         + ", limitList="
         + this.getLimitList()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProduceAbonrmalReportAndLimitDTO)) {
         return false;
      }

      ProduceAbonrmalReportAndLimitDTO other = (ProduceAbonrmalReportAndLimitDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$reportList = this.getReportList();
         Object other$reportList = other.getReportList();
         if (this$reportList == null ? other$reportList == null : this$reportList.equals(other$reportList)) {
            Object this$limitList = this.getLimitList();
            Object other$limitList = other.getLimitList();
            return this$limitList == null ? other$limitList == null : this$limitList.equals(other$limitList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProduceAbonrmalReportAndLimitDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $reportList = this.getReportList();
      result = result * 59 + ($reportList == null ? 43 : $reportList.hashCode());
      Object $limitList = this.getLimitList();
      return result * 59 + ($limitList == null ? 43 : $limitList.hashCode());
   }

   public static class ProduceAbonrmalReportAndLimitDTOBuilder {
      private List<ProduceAbonrmalReportDTO> reportList;
      private List<TaskProcessAndQuantityDTO> limitList;
      private Integer quantity;

      ProduceAbonrmalReportAndLimitDTOBuilder() {
      }

      @JsonProperty("reportList")
      public ProduceAbonrmalReportAndLimitDTO.ProduceAbonrmalReportAndLimitDTOBuilder reportList(final List<ProduceAbonrmalReportDTO> reportList) {
         this.reportList = reportList;
         return this;
      }

      @JsonProperty("limitList")
      public ProduceAbonrmalReportAndLimitDTO.ProduceAbonrmalReportAndLimitDTOBuilder limitList(final List<TaskProcessAndQuantityDTO> limitList) {
         this.limitList = limitList;
         return this;
      }

      @JsonProperty("quantity")
      public ProduceAbonrmalReportAndLimitDTO.ProduceAbonrmalReportAndLimitDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProduceAbonrmalReportAndLimitDTO build() {
         return new ProduceAbonrmalReportAndLimitDTO(this.reportList, this.limitList, this.quantity);
      }

      @Override
      public String toString() {
         return "ProduceAbonrmalReportAndLimitDTO.ProduceAbonrmalReportAndLimitDTOBuilder(reportList="
            + this.reportList
            + ", limitList="
            + this.limitList
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
