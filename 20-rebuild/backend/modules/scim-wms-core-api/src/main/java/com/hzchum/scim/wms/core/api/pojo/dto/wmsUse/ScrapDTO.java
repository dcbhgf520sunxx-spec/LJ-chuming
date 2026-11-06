package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Warehouse;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ScrapDTO {
   private Long id;
   private Integer basicClass;
   private Long classifyId;
   private String serialNumber;
   private ProjectInfoDTO project;
   private BigDecimal quantity;
   private String specification;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private BigDecimal mete;
   private Boolean boolPartyA;
   @JsonInclude(Include.NON_NULL)
   private String brand;
   @JsonInclude(Include.NON_NULL)
   private String heatNoAndBatchNo;
   @JsonInclude(Include.NON_NULL)
   private String color;
   private Warehouse warehouse;
   private BriefIdAndNameDTO workshop;
   private String nationalStandard;
   private LocalDateTime createTime;
   private String convertNumber;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
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

   public BigDecimal getMete() {
      return this.mete;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Warehouse getWarehouse() {
      return this.warehouse;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getConvertNumber() {
      return this.convertNumber;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
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

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setWarehouse(final Warehouse warehouse) {
      this.warehouse = warehouse;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setConvertNumber(final String convertNumber) {
      this.convertNumber = convertNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScrapDTO)) {
         return false;
      }

      ScrapDTO other = (ScrapDTO)o;
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
               Object this$boolPartyA = this.getBoolPartyA();
               Object other$boolPartyA = other.getBoolPartyA();
               if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
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
                                       Object this$mete = this.getMete();
                                       Object other$mete = other.getMete();
                                       if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                             Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                             if (this$heatNoAndBatchNo == null
                                                ? other$heatNoAndBatchNo == null
                                                : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                Object this$color = this.getColor();
                                                Object other$color = other.getColor();
                                                if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                   Object this$warehouse = this.getWarehouse();
                                                   Object other$warehouse = other.getWarehouse();
                                                   if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                                                      Object this$workshop = this.getWorkshop();
                                                      Object other$workshop = other.getWorkshop();
                                                      if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                         Object this$nationalStandard = this.getNationalStandard();
                                                         Object other$nationalStandard = other.getNationalStandard();
                                                         if (this$nationalStandard == null
                                                            ? other$nationalStandard == null
                                                            : this$nationalStandard.equals(other$nationalStandard)) {
                                                            Object this$createTime = this.getCreateTime();
                                                            Object other$createTime = other.getCreateTime();
                                                            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                               Object this$convertNumber = this.getConvertNumber();
                                                               Object other$convertNumber = other.getConvertNumber();
                                                               return this$convertNumber == null
                                                                  ? other$convertNumber == null
                                                                  : this$convertNumber.equals(other$convertNumber);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScrapDTO;
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
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $convertNumber = this.getConvertNumber();
      return result * 59 + ($convertNumber == null ? 43 : $convertNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ScrapDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", quantity="
         + this.getQuantity()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", mete="
         + this.getMete()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", warehouse="
         + this.getWarehouse()
         + ", workshop="
         + this.getWorkshop()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", createTime="
         + this.getCreateTime()
         + ", convertNumber="
         + this.getConvertNumber()
         + ")";
   }

   public ScrapDTO() {
   }

   public ScrapDTO(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String serialNumber,
      final ProjectInfoDTO project,
      final BigDecimal quantity,
      final String specification,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal mete,
      final Boolean boolPartyA,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Warehouse warehouse,
      final BriefIdAndNameDTO workshop,
      final String nationalStandard,
      final LocalDateTime createTime,
      final String convertNumber
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.serialNumber = serialNumber;
      this.project = project;
      this.quantity = quantity;
      this.specification = specification;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.mete = mete;
      this.boolPartyA = boolPartyA;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.warehouse = warehouse;
      this.workshop = workshop;
      this.nationalStandard = nationalStandard;
      this.createTime = createTime;
      this.convertNumber = convertNumber;
   }
}
