package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;

public class RealTimeOutboundDTO {
   private String projectName;
   private String basicClassName;
   private String classifyName;
   private String specification;
   private BigDecimal mete;
   private String accountingUnit;
   private String userName;

   public static RealTimeOutboundDTO.RealTimeOutboundDTOBuilder builder() {
      return new RealTimeOutboundDTO.RealTimeOutboundDTOBuilder();
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getBasicClassName() {
      return this.basicClassName;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getUserName() {
      return this.userName;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setBasicClassName(final String basicClassName) {
      this.basicClassName = basicClassName;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof RealTimeOutboundDTO)) {
         return false;
      }

      RealTimeOutboundDTO other = (RealTimeOutboundDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectName = this.getProjectName();
      Object other$projectName = other.getProjectName();
      if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
         Object this$basicClassName = this.getBasicClassName();
         Object other$basicClassName = other.getBasicClassName();
         if (this$basicClassName == null ? other$basicClassName == null : this$basicClassName.equals(other$basicClassName)) {
            Object this$classifyName = this.getClassifyName();
            Object other$classifyName = other.getClassifyName();
            if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$mete = this.getMete();
                  Object other$mete = other.getMete();
                  if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                     Object this$accountingUnit = this.getAccountingUnit();
                     Object other$accountingUnit = other.getAccountingUnit();
                     if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
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
      return other instanceof RealTimeOutboundDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $basicClassName = this.getBasicClassName();
      result = result * 59 + ($basicClassName == null ? 43 : $basicClassName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "RealTimeOutboundDTO(projectName="
         + this.getProjectName()
         + ", basicClassName="
         + this.getBasicClassName()
         + ", classifyName="
         + this.getClassifyName()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   public RealTimeOutboundDTO(
      final String projectName,
      final String basicClassName,
      final String classifyName,
      final String specification,
      final BigDecimal mete,
      final String accountingUnit,
      final String userName
   ) {
      this.projectName = projectName;
      this.basicClassName = basicClassName;
      this.classifyName = classifyName;
      this.specification = specification;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.userName = userName;
   }

   public RealTimeOutboundDTO() {
   }

   public static class RealTimeOutboundDTOBuilder {
      private String projectName;
      private String basicClassName;
      private String classifyName;
      private String specification;
      private BigDecimal mete;
      private String accountingUnit;
      private String userName;

      RealTimeOutboundDTOBuilder() {
      }

      public RealTimeOutboundDTO.RealTimeOutboundDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public RealTimeOutboundDTO.RealTimeOutboundDTOBuilder basicClassName(final String basicClassName) {
         this.basicClassName = basicClassName;
         return this;
      }

      public RealTimeOutboundDTO.RealTimeOutboundDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public RealTimeOutboundDTO.RealTimeOutboundDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public RealTimeOutboundDTO.RealTimeOutboundDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public RealTimeOutboundDTO.RealTimeOutboundDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public RealTimeOutboundDTO.RealTimeOutboundDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public RealTimeOutboundDTO build() {
         return new RealTimeOutboundDTO(
            this.projectName, this.basicClassName, this.classifyName, this.specification, this.mete, this.accountingUnit, this.userName
         );
      }

      @Override
      public String toString() {
         return "RealTimeOutboundDTO.RealTimeOutboundDTOBuilder(projectName="
            + this.projectName
            + ", basicClassName="
            + this.basicClassName
            + ", classifyName="
            + this.classifyName
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
