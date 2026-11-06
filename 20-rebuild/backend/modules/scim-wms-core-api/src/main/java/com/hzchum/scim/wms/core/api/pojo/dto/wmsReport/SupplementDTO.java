package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SupplementDTO {
   private Long id;
   private Integer basicClass;
   private Long classifyId;
   private String specification;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private String color;
   private String accountingUnit;
   private BigDecimal mete;
   private BigDecimal amount;
   private String brand;
   private BigDecimal amountExcludingVAT;
   private String serialNumber;
   private BriefIdAndSNDTO receipt;
   private BriefIdAndNameDTO workshop;
   private ProjectInfo project;
   private LocalDateTime createTime;

   public static SupplementDTO.SupplementDTOBuilder builder() {
      return new SupplementDTO.SupplementDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getColor() {
      return this.color;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getBrand() {
      return this.brand;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplementDTO)) {
         return false;
      }

      SupplementDTO other = (SupplementDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                  Object this$length = this.getLength();
                  Object other$length = other.getLength();
                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                     Object this$width = this.getWidth();
                     Object other$width = other.getWidth();
                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                        Object this$thickness = this.getThickness();
                        Object other$thickness = other.getThickness();
                        if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                           Object this$color = this.getColor();
                           Object other$color = other.getColor();
                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                              Object this$accountingUnit = this.getAccountingUnit();
                              Object other$accountingUnit = other.getAccountingUnit();
                              if (this$accountingUnit == null ? other$accountingUnit == null : this$accountingUnit.equals(other$accountingUnit)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$amount = this.getAmount();
                                    Object other$amount = other.getAmount();
                                    if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                       Object this$brand = this.getBrand();
                                       Object other$brand = other.getBrand();
                                       if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                          Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                          Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                          if (this$amountExcludingVAT == null
                                             ? other$amountExcludingVAT == null
                                             : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$receipt = this.getReceipt();
                                                Object other$receipt = other.getReceipt();
                                                if (this$receipt == null ? other$receipt == null : this$receipt.equals(other$receipt)) {
                                                   Object this$workshop = this.getWorkshop();
                                                   Object other$workshop = other.getWorkshop();
                                                   if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                      Object this$project = this.getProject();
                                                      Object other$project = other.getProject();
                                                      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                         Object this$createTime = this.getCreateTime();
                                                         Object other$createTime = other.getCreateTime();
                                                         return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof SupplementDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "SupplementDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", amount="
         + this.getAmount()
         + ", brand="
         + this.getBrand()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", receipt="
         + this.getReceipt()
         + ", workshop="
         + this.getWorkshop()
         + ", project="
         + this.getProject()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public SupplementDTO(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal amount,
      final String brand,
      final BigDecimal amountExcludingVAT,
      final String serialNumber,
      final BriefIdAndSNDTO receipt,
      final BriefIdAndNameDTO workshop,
      final ProjectInfo project,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.amount = amount;
      this.brand = brand;
      this.amountExcludingVAT = amountExcludingVAT;
      this.serialNumber = serialNumber;
      this.receipt = receipt;
      this.workshop = workshop;
      this.project = project;
      this.createTime = createTime;
   }

   public SupplementDTO() {
   }

   public static class SupplementDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String specification;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal amount;
      private String brand;
      private BigDecimal amountExcludingVAT;
      private String serialNumber;
      private BriefIdAndSNDTO receipt;
      private BriefIdAndNameDTO workshop;
      private ProjectInfo project;
      private LocalDateTime createTime;

      SupplementDTOBuilder() {
      }

      public SupplementDTO.SupplementDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public SupplementDTO.SupplementDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SupplementDTO build() {
         return new SupplementDTO(
            this.id,
            this.basicClass,
            this.classifyId,
            this.specification,
            this.length,
            this.width,
            this.thickness,
            this.color,
            this.accountingUnit,
            this.mete,
            this.amount,
            this.brand,
            this.amountExcludingVAT,
            this.serialNumber,
            this.receipt,
            this.workshop,
            this.project,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "SupplementDTO.SupplementDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", amount="
            + this.amount
            + ", brand="
            + this.brand
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", serialNumber="
            + this.serialNumber
            + ", receipt="
            + this.receipt
            + ", workshop="
            + this.workshop
            + ", project="
            + this.project
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
