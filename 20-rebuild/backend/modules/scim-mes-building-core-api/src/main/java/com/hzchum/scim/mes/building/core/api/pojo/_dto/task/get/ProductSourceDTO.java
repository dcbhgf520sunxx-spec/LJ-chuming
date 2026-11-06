package com.hzchum.scim.mes.building.core.api.pojo._dto.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.InspectionReportSourceDO;
import com.hzchum.scim.mes.building.core.api.pojo._do.report.ReportSourceDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProductSourceDTO", description = "产品溯源返回类")
public class ProductSourceDTO {
   @ApiModelProperty(name = "reportSourceList", notes = "生产信息")
   @JsonProperty("reportSourceList")
   @JSONField(name = "reportSourceList")
   private List<ReportSourceDO> reportSourceList;
   @ApiModelProperty(name = "inspectionReportSourceList", notes = "质检信息")
   @JsonProperty("inspectionReportSourceList")
   @JSONField(name = "inspectionReportSourceList")
   private List<InspectionReportSourceDO> inspectionReportSourceList;

   public static ProductSourceDTO.ProductSourceDTOBuilder builder() {
      return new ProductSourceDTO.ProductSourceDTOBuilder();
   }

   public ProductSourceDTO() {
   }

   public ProductSourceDTO(final List<ReportSourceDO> reportSourceList, final List<InspectionReportSourceDO> inspectionReportSourceList) {
      this.reportSourceList = reportSourceList;
      this.inspectionReportSourceList = inspectionReportSourceList;
   }

   public List<ReportSourceDO> getReportSourceList() {
      return this.reportSourceList;
   }

   public List<InspectionReportSourceDO> getInspectionReportSourceList() {
      return this.inspectionReportSourceList;
   }

   @JsonProperty("reportSourceList")
   public ProductSourceDTO setReportSourceList(final List<ReportSourceDO> reportSourceList) {
      this.reportSourceList = reportSourceList;
      return this;
   }

   @JsonProperty("inspectionReportSourceList")
   public ProductSourceDTO setInspectionReportSourceList(final List<InspectionReportSourceDO> inspectionReportSourceList) {
      this.inspectionReportSourceList = inspectionReportSourceList;
      return this;
   }

   @Override
   public String toString() {
      return "ProductSourceDTO(reportSourceList=" + this.getReportSourceList() + ", inspectionReportSourceList=" + this.getInspectionReportSourceList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductSourceDTO)) {
         return false;
      } else {
         ProductSourceDTO other = (ProductSourceDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$reportSourceList = this.getReportSourceList();
            Object other$reportSourceList = other.getReportSourceList();
            if (this$reportSourceList == null ? other$reportSourceList == null : this$reportSourceList.equals(other$reportSourceList)) {
               Object this$inspectionReportSourceList = this.getInspectionReportSourceList();
               Object other$inspectionReportSourceList = other.getInspectionReportSourceList();
               return this$inspectionReportSourceList == null
                  ? other$inspectionReportSourceList == null
                  : this$inspectionReportSourceList.equals(other$inspectionReportSourceList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductSourceDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reportSourceList = this.getReportSourceList();
      result = result * 59 + ($reportSourceList == null ? 43 : $reportSourceList.hashCode());
      Object $inspectionReportSourceList = this.getInspectionReportSourceList();
      return result * 59 + ($inspectionReportSourceList == null ? 43 : $inspectionReportSourceList.hashCode());
   }

   public static class ProductSourceDTOBuilder {
      private List<ReportSourceDO> reportSourceList;
      private List<InspectionReportSourceDO> inspectionReportSourceList;

      ProductSourceDTOBuilder() {
      }

      @JsonProperty("reportSourceList")
      public ProductSourceDTO.ProductSourceDTOBuilder reportSourceList(final List<ReportSourceDO> reportSourceList) {
         this.reportSourceList = reportSourceList;
         return this;
      }

      @JsonProperty("inspectionReportSourceList")
      public ProductSourceDTO.ProductSourceDTOBuilder inspectionReportSourceList(final List<InspectionReportSourceDO> inspectionReportSourceList) {
         this.inspectionReportSourceList = inspectionReportSourceList;
         return this;
      }

      public ProductSourceDTO build() {
         return new ProductSourceDTO(this.reportSourceList, this.inspectionReportSourceList);
      }

      @Override
      public String toString() {
         return "ProductSourceDTO.ProductSourceDTOBuilder(reportSourceList="
            + this.reportSourceList
            + ", inspectionReportSourceList="
            + this.inspectionReportSourceList
            + ")";
      }
   }
}
