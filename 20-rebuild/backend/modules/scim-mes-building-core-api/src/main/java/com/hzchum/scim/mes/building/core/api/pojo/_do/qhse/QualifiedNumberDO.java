package com.hzchum.scim.mes.building.core.api.pojo._do.qhse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QualifiedNumberDO对象", description = "质检合格统计返回类")
public class QualifiedNumberDO {
   @ApiModelProperty(name = "processName", value = "工序名称", notes = "工序名称")
   private String processName;
   @ApiModelProperty(name = "totalNumberInspection", value = "检验总数", notes = "检验总数")
   private Integer totalNumberInspection;
   @ApiModelProperty(name = "totalNumberInspection", value = "不合格数", notes = "不合格数")
   private Integer unqualifiedNumber;

   public static QualifiedNumberDO.QualifiedNumberDOBuilder builder() {
      return new QualifiedNumberDO.QualifiedNumberDOBuilder();
   }

   public QualifiedNumberDO() {
   }

   public QualifiedNumberDO(final String processName, final Integer totalNumberInspection, final Integer unqualifiedNumber) {
      this.processName = processName;
      this.totalNumberInspection = totalNumberInspection;
      this.unqualifiedNumber = unqualifiedNumber;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getTotalNumberInspection() {
      return this.totalNumberInspection;
   }

   public Integer getUnqualifiedNumber() {
      return this.unqualifiedNumber;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setTotalNumberInspection(final Integer totalNumberInspection) {
      this.totalNumberInspection = totalNumberInspection;
   }

   public void setUnqualifiedNumber(final Integer unqualifiedNumber) {
      this.unqualifiedNumber = unqualifiedNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QualifiedNumberDO)) {
         return false;
      }

      QualifiedNumberDO other = (QualifiedNumberDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalNumberInspection = this.getTotalNumberInspection();
      Object other$totalNumberInspection = other.getTotalNumberInspection();
      if (this$totalNumberInspection == null ? other$totalNumberInspection == null : this$totalNumberInspection.equals(other$totalNumberInspection)) {
         Object this$unqualifiedNumber = this.getUnqualifiedNumber();
         Object other$unqualifiedNumber = other.getUnqualifiedNumber();
         if (this$unqualifiedNumber == null ? other$unqualifiedNumber == null : this$unqualifiedNumber.equals(other$unqualifiedNumber)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QualifiedNumberDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalNumberInspection = this.getTotalNumberInspection();
      result = result * 59 + ($totalNumberInspection == null ? 43 : $totalNumberInspection.hashCode());
      Object $unqualifiedNumber = this.getUnqualifiedNumber();
      result = result * 59 + ($unqualifiedNumber == null ? 43 : $unqualifiedNumber.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   @Override
   public String toString() {
      return "QualifiedNumberDO(processName="
         + this.getProcessName()
         + ", totalNumberInspection="
         + this.getTotalNumberInspection()
         + ", unqualifiedNumber="
         + this.getUnqualifiedNumber()
         + ")";
   }

   public static class QualifiedNumberDOBuilder {
      private String processName;
      private Integer totalNumberInspection;
      private Integer unqualifiedNumber;

      QualifiedNumberDOBuilder() {
      }

      public QualifiedNumberDO.QualifiedNumberDOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public QualifiedNumberDO.QualifiedNumberDOBuilder totalNumberInspection(final Integer totalNumberInspection) {
         this.totalNumberInspection = totalNumberInspection;
         return this;
      }

      public QualifiedNumberDO.QualifiedNumberDOBuilder unqualifiedNumber(final Integer unqualifiedNumber) {
         this.unqualifiedNumber = unqualifiedNumber;
         return this;
      }

      public QualifiedNumberDO build() {
         return new QualifiedNumberDO(this.processName, this.totalNumberInspection, this.unqualifiedNumber);
      }

      @Override
      public String toString() {
         return "QualifiedNumberDO.QualifiedNumberDOBuilder(processName="
            + this.processName
            + ", totalNumberInspection="
            + this.totalNumberInspection
            + ", unqualifiedNumber="
            + this.unqualifiedNumber
            + ")";
      }
   }
}
