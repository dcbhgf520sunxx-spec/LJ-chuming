package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiOperation("成本报表返回表-其他事项")
public class ProjectElseAllDto {
   @ApiModelProperty("日期")
   private LocalDateTime createTime;
   @ApiModelProperty("事项")
   private String matter;
   @ApiModelProperty("金额")
   private BigDecimal amount;
   @ApiModelProperty("填报人")
   private String userName;

   public static ProjectElseAllDto.ProjectElseAllDtoBuilder builder() {
      return new ProjectElseAllDto.ProjectElseAllDtoBuilder();
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getMatter() {
      return this.matter;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getUserName() {
      return this.userName;
   }

   public ProjectElseAllDto setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ProjectElseAllDto setMatter(final String matter) {
      this.matter = matter;
      return this;
   }

   public ProjectElseAllDto setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   public ProjectElseAllDto setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectElseAllDto)) {
         return false;
      }

      ProjectElseAllDto other = (ProjectElseAllDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$matter = this.getMatter();
         Object other$matter = other.getMatter();
         if (this$matter == null ? other$matter == null : this$matter.equals(other$matter)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof ProjectElseAllDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $matter = this.getMatter();
      result = result * 59 + ($matter == null ? 43 : $matter.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectElseAllDto(createTime="
         + this.getCreateTime()
         + ", matter="
         + this.getMatter()
         + ", amount="
         + this.getAmount()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public ProjectElseAllDto(final LocalDateTime createTime, final String matter, final BigDecimal amount, final String userName) {
      this.createTime = createTime;
      this.matter = matter;
      this.amount = amount;
      this.userName = userName;
   }

   public ProjectElseAllDto() {
   }

   public static class ProjectElseAllDtoBuilder {
      private LocalDateTime createTime;
      private String matter;
      private BigDecimal amount;
      private String userName;

      ProjectElseAllDtoBuilder() {
      }

      public ProjectElseAllDto.ProjectElseAllDtoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectElseAllDto.ProjectElseAllDtoBuilder matter(final String matter) {
         this.matter = matter;
         return this;
      }

      public ProjectElseAllDto.ProjectElseAllDtoBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public ProjectElseAllDto.ProjectElseAllDtoBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectElseAllDto build() {
         return new ProjectElseAllDto(this.createTime, this.matter, this.amount, this.userName);
      }

      @Override
      public String toString() {
         return "ProjectElseAllDto.ProjectElseAllDtoBuilder(createTime="
            + this.createTime
            + ", matter="
            + this.matter
            + ", amount="
            + this.amount
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
