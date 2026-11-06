package com.hzchum.scim.crm.core.api.pojo.param;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CaLockedParam {
   private Long id;
   @ApiModelProperty(name = "caDate", notes = "上锁时间")
   private LocalDate caDate;
   @ApiModelProperty(name = "platformFees", value = "平台费用", notes = "平台费用")
   private BigDecimal platformFees;

   public CaLockedParam(final Long id, final LocalDate caDate, final BigDecimal platformFees) {
      this.id = id;
      this.caDate = caDate;
      this.platformFees = platformFees;
   }

   public CaLockedParam() {
   }

   public Long getId() {
      return this.id;
   }

   public LocalDate getCaDate() {
      return this.caDate;
   }

   public BigDecimal getPlatformFees() {
      return this.platformFees;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCaDate(final LocalDate caDate) {
      this.caDate = caDate;
   }

   public void setPlatformFees(final BigDecimal platformFees) {
      this.platformFees = platformFees;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CaLockedParam)) {
         return false;
      }

      CaLockedParam other = (CaLockedParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$caDate = this.getCaDate();
         Object other$caDate = other.getCaDate();
         if (this$caDate == null ? other$caDate == null : this$caDate.equals(other$caDate)) {
            Object this$platformFees = this.getPlatformFees();
            Object other$platformFees = other.getPlatformFees();
            return this$platformFees == null ? other$platformFees == null : this$platformFees.equals(other$platformFees);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CaLockedParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $caDate = this.getCaDate();
      result = result * 59 + ($caDate == null ? 43 : $caDate.hashCode());
      Object $platformFees = this.getPlatformFees();
      return result * 59 + ($platformFees == null ? 43 : $platformFees.hashCode());
   }

   @Override
   public String toString() {
      return "CaLockedParam(id=" + this.getId() + ", caDate=" + this.getCaDate() + ", platformFees=" + this.getPlatformFees() + ")";
   }
}
