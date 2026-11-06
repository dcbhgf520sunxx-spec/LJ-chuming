package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.scm.core.api.pojo.dto.ArtifactAndAssembleDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ManufacturesInventoryDTO {
   private Long id;
   private Integer basicClass;
   private Long areaId;
   private String serialNumber;
   private String name;
   private String specification;
   private Integer quantity;
   private BigDecimal mete;
   private String enclUnit;
   private BriefIdAndNameDTO workshop;
   private ProjectInfo project;
   private String areaName;
   private String monomerName;
   private Integer productType;
   private String measureUnit;
   private String accountingUnit;
   private ArtifactAndAssembleDTO detail;
   private Integer loadingQuantity;
   private LocalDateTime outboundTime;
   private BriefIdAndSNDTO train;

   public static ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder builder() {
      return new ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getEnclUnit() {
      return this.enclUnit;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public ArtifactAndAssembleDTO getDetail() {
      return this.detail;
   }

   public Integer getLoadingQuantity() {
      return this.loadingQuantity;
   }

   public LocalDateTime getOutboundTime() {
      return this.outboundTime;
   }

   public BriefIdAndSNDTO getTrain() {
      return this.train;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setEnclUnit(final String enclUnit) {
      this.enclUnit = enclUnit;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setDetail(final ArtifactAndAssembleDTO detail) {
      this.detail = detail;
   }

   public void setLoadingQuantity(final Integer loadingQuantity) {
      this.loadingQuantity = loadingQuantity;
   }

   public void setOutboundTime(final LocalDateTime outboundTime) {
      this.outboundTime = outboundTime;
   }

   public void setTrain(final BriefIdAndSNDTO train) {
      this.train = train;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManufacturesInventoryDTO)) {
         return false;
      }

      ManufacturesInventoryDTO other = (ManufacturesInventoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$productType = this.getProductType();
                  Object other$productType = other.getProductType();
                  if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                     Object this$loadingQuantity = this.getLoadingQuantity();
                     Object other$loadingQuantity = other.getLoadingQuantity();
                     if (this$loadingQuantity == null ? other$loadingQuantity == null : this$loadingQuantity.equals(other$loadingQuantity)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$mete = this.getMete();
                                 Object other$mete = other.getMete();
                                 if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                    Object this$enclUnit = this.getEnclUnit();
                                    Object other$enclUnit = other.getEnclUnit();
                                    if (this$enclUnit == null ? other$enclUnit == null : this$enclUnit.equals(other$enclUnit)) {
                                       Object this$workshop = this.getWorkshop();
                                       Object other$workshop = other.getWorkshop();
                                       if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                          Object this$project = this.getProject();
                                          Object other$project = other.getProject();
                                          if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                             Object this$areaName = this.getAreaName();
                                             Object other$areaName = other.getAreaName();
                                             if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                Object this$monomerName = this.getMonomerName();
                                                Object other$monomerName = other.getMonomerName();
                                                if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                                   Object this$measureUnit = this.getMeasureUnit();
                                                   Object other$measureUnit = other.getMeasureUnit();
                                                   if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                      Object this$accountingUnit = this.getAccountingUnit();
                                                      Object other$accountingUnit = other.getAccountingUnit();
                                                      if (this$accountingUnit == null
                                                         ? other$accountingUnit == null
                                                         : this$accountingUnit.equals(other$accountingUnit)) {
                                                         Object this$detail = this.getDetail();
                                                         Object other$detail = other.getDetail();
                                                         if (this$detail == null ? other$detail == null : this$detail.equals(other$detail)) {
                                                            Object this$outboundTime = this.getOutboundTime();
                                                            Object other$outboundTime = other.getOutboundTime();
                                                            if (this$outboundTime == null
                                                               ? other$outboundTime == null
                                                               : this$outboundTime.equals(other$outboundTime)) {
                                                               Object this$train = this.getTrain();
                                                               Object other$train = other.getTrain();
                                                               return this$train == null ? other$train == null : this$train.equals(other$train);
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
      return other instanceof ManufacturesInventoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $loadingQuantity = this.getLoadingQuantity();
      result = result * 59 + ($loadingQuantity == null ? 43 : $loadingQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $enclUnit = this.getEnclUnit();
      result = result * 59 + ($enclUnit == null ? 43 : $enclUnit.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $detail = this.getDetail();
      result = result * 59 + ($detail == null ? 43 : $detail.hashCode());
      Object $outboundTime = this.getOutboundTime();
      result = result * 59 + ($outboundTime == null ? 43 : $outboundTime.hashCode());
      Object $train = this.getTrain();
      return result * 59 + ($train == null ? 43 : $train.hashCode());
   }

   @Override
   public String toString() {
      return "ManufacturesInventoryDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", areaId="
         + this.getAreaId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", enclUnit="
         + this.getEnclUnit()
         + ", workshop="
         + this.getWorkshop()
         + ", project="
         + this.getProject()
         + ", areaName="
         + this.getAreaName()
         + ", monomerName="
         + this.getMonomerName()
         + ", productType="
         + this.getProductType()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", detail="
         + this.getDetail()
         + ", loadingQuantity="
         + this.getLoadingQuantity()
         + ", outboundTime="
         + this.getOutboundTime()
         + ", train="
         + this.getTrain()
         + ")";
   }

   public ManufacturesInventoryDTO(
      final Long id,
      final Integer basicClass,
      final Long areaId,
      final String serialNumber,
      final String name,
      final String specification,
      final Integer quantity,
      final BigDecimal mete,
      final String enclUnit,
      final BriefIdAndNameDTO workshop,
      final ProjectInfo project,
      final String areaName,
      final String monomerName,
      final Integer productType,
      final String measureUnit,
      final String accountingUnit,
      final ArtifactAndAssembleDTO detail,
      final Integer loadingQuantity,
      final LocalDateTime outboundTime,
      final BriefIdAndSNDTO train
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.areaId = areaId;
      this.serialNumber = serialNumber;
      this.name = name;
      this.specification = specification;
      this.quantity = quantity;
      this.mete = mete;
      this.enclUnit = enclUnit;
      this.workshop = workshop;
      this.project = project;
      this.areaName = areaName;
      this.monomerName = monomerName;
      this.productType = productType;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.detail = detail;
      this.loadingQuantity = loadingQuantity;
      this.outboundTime = outboundTime;
      this.train = train;
   }

   public ManufacturesInventoryDTO() {
   }

   public static class ManufacturesInventoryDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Long areaId;
      private String serialNumber;
      private String name;
      private String specification;
      private Integer quantity;
      private BigDecimal mete;
      private String enclUnit;
      private BriefIdAndNameDTO workshop;
      private ProjectInfo project;
      private String areaName;
      private String monomerName;
      private Integer productType;
      private String measureUnit;
      private String accountingUnit;
      private ArtifactAndAssembleDTO detail;
      private Integer loadingQuantity;
      private LocalDateTime outboundTime;
      private BriefIdAndSNDTO train;

      ManufacturesInventoryDTOBuilder() {
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder enclUnit(final String enclUnit) {
         this.enclUnit = enclUnit;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder detail(final ArtifactAndAssembleDTO detail) {
         this.detail = detail;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder loadingQuantity(final Integer loadingQuantity) {
         this.loadingQuantity = loadingQuantity;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder outboundTime(final LocalDateTime outboundTime) {
         this.outboundTime = outboundTime;
         return this;
      }

      public ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder train(final BriefIdAndSNDTO train) {
         this.train = train;
         return this;
      }

      public ManufacturesInventoryDTO build() {
         return new ManufacturesInventoryDTO(
            this.id,
            this.basicClass,
            this.areaId,
            this.serialNumber,
            this.name,
            this.specification,
            this.quantity,
            this.mete,
            this.enclUnit,
            this.workshop,
            this.project,
            this.areaName,
            this.monomerName,
            this.productType,
            this.measureUnit,
            this.accountingUnit,
            this.detail,
            this.loadingQuantity,
            this.outboundTime,
            this.train
         );
      }

      @Override
      public String toString() {
         return "ManufacturesInventoryDTO.ManufacturesInventoryDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", areaId="
            + this.areaId
            + ", serialNumber="
            + this.serialNumber
            + ", name="
            + this.name
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", enclUnit="
            + this.enclUnit
            + ", workshop="
            + this.workshop
            + ", project="
            + this.project
            + ", areaName="
            + this.areaName
            + ", monomerName="
            + this.monomerName
            + ", productType="
            + this.productType
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", detail="
            + this.detail
            + ", loadingQuantity="
            + this.loadingQuantity
            + ", outboundTime="
            + this.outboundTime
            + ", train="
            + this.train
            + ")";
      }
   }
}
