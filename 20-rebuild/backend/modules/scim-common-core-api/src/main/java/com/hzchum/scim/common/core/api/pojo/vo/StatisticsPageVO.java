package com.hzchum.scim.common.core.api.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.pagehelper.Page;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.BriefClassDTO;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StatisticsPageVO<T> extends PageVO<T> {
   @JsonInclude(Include.NON_NULL)
   protected Map<String, BigDecimal> totalAmount;
   @JsonInclude(Include.NON_NULL)
   protected Map<String, Object> summaryInfo;
   @JsonInclude(Include.NON_NULL)
   protected BigDecimal supplierReconciliationAmount;
   @JsonInclude(Include.NON_NULL)
   protected BigDecimal supplierReconciliationAmountNoFreight;
   @JsonInclude(Include.NON_NULL)
   protected List<ProjectInfo> project;
   @JsonInclude(Include.NON_NULL)
   protected List<BriefClassDTO> spec;
   @JsonInclude(Include.NON_NULL)
   private Integer weightedType;

   public StatisticsPageVO() {
   }

   public StatisticsPageVO(Page page, List<T> list) {
      this.totalElements = page.getTotal();
      this.content = list;
      this.hasPreviousPage = page.toPageInfo().isHasPreviousPage();
      this.hasNextPage = page.toPageInfo().isHasNextPage();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsPageVO)) {
         return false;
      }

      StatisticsPageVO<?> other = (StatisticsPageVO<?>)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$weightedType = this.getWeightedType();
      Object other$weightedType = other.getWeightedType();
      if (this$weightedType == null ? other$weightedType == null : this$weightedType.equals(other$weightedType)) {
         Object this$totalAmount = this.getTotalAmount();
         Object other$totalAmount = other.getTotalAmount();
         if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
            Object this$summaryInfo = this.getSummaryInfo();
            Object other$summaryInfo = other.getSummaryInfo();
            if (this$summaryInfo == null ? other$summaryInfo == null : this$summaryInfo.equals(other$summaryInfo)) {
               Object this$supplierReconciliationAmount = this.getSupplierReconciliationAmount();
               Object other$supplierReconciliationAmount = other.getSupplierReconciliationAmount();
               if (this$supplierReconciliationAmount == null
                  ? other$supplierReconciliationAmount == null
                  : this$supplierReconciliationAmount.equals(other$supplierReconciliationAmount)) {
                  Object this$supplierReconciliationAmountNoFreight = this.getSupplierReconciliationAmountNoFreight();
                  Object other$supplierReconciliationAmountNoFreight = other.getSupplierReconciliationAmountNoFreight();
                  if (this$supplierReconciliationAmountNoFreight == null
                     ? other$supplierReconciliationAmountNoFreight == null
                     : this$supplierReconciliationAmountNoFreight.equals(other$supplierReconciliationAmountNoFreight)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$spec = this.getSpec();
                        Object other$spec = other.getSpec();
                        return this$spec == null ? other$spec == null : this$spec.equals(other$spec);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof StatisticsPageVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $weightedType = this.getWeightedType();
      result = result * 59 + ($weightedType == null ? 43 : $weightedType.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $summaryInfo = this.getSummaryInfo();
      result = result * 59 + ($summaryInfo == null ? 43 : $summaryInfo.hashCode());
      Object $supplierReconciliationAmount = this.getSupplierReconciliationAmount();
      result = result * 59 + ($supplierReconciliationAmount == null ? 43 : $supplierReconciliationAmount.hashCode());
      Object $supplierReconciliationAmountNoFreight = this.getSupplierReconciliationAmountNoFreight();
      result = result * 59 + ($supplierReconciliationAmountNoFreight == null ? 43 : $supplierReconciliationAmountNoFreight.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $spec = this.getSpec();
      return result * 59 + ($spec == null ? 43 : $spec.hashCode());
   }

   public Map<String, BigDecimal> getTotalAmount() {
      return this.totalAmount;
   }

   public Map<String, Object> getSummaryInfo() {
      return this.summaryInfo;
   }

   public BigDecimal getSupplierReconciliationAmount() {
      return this.supplierReconciliationAmount;
   }

   public BigDecimal getSupplierReconciliationAmountNoFreight() {
      return this.supplierReconciliationAmountNoFreight;
   }

   public List<ProjectInfo> getProject() {
      return this.project;
   }

   public List<BriefClassDTO> getSpec() {
      return this.spec;
   }

   public Integer getWeightedType() {
      return this.weightedType;
   }

   public void setTotalAmount(final Map<String, BigDecimal> totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setSummaryInfo(final Map<String, Object> summaryInfo) {
      this.summaryInfo = summaryInfo;
   }

   public void setSupplierReconciliationAmount(final BigDecimal supplierReconciliationAmount) {
      this.supplierReconciliationAmount = supplierReconciliationAmount;
   }

   public void setSupplierReconciliationAmountNoFreight(final BigDecimal supplierReconciliationAmountNoFreight) {
      this.supplierReconciliationAmountNoFreight = supplierReconciliationAmountNoFreight;
   }

   public void setProject(final List<ProjectInfo> project) {
      this.project = project;
   }

   public void setSpec(final List<BriefClassDTO> spec) {
      this.spec = spec;
   }

   public void setWeightedType(final Integer weightedType) {
      this.weightedType = weightedType;
   }

   @Override
   public String toString() {
      return "StatisticsPageVO(totalAmount="
         + this.getTotalAmount()
         + ", summaryInfo="
         + this.getSummaryInfo()
         + ", supplierReconciliationAmount="
         + this.getSupplierReconciliationAmount()
         + ", supplierReconciliationAmountNoFreight="
         + this.getSupplierReconciliationAmountNoFreight()
         + ", project="
         + this.getProject()
         + ", spec="
         + this.getSpec()
         + ", weightedType="
         + this.getWeightedType()
         + ")";
   }
}
