package com.hzchum.scim.scm.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrderDetail;
import java.math.BigDecimal;
import java.util.List;

public class PurchaseOrderDetailDTO extends PurchaseOrderDetail {
   @JsonInclude(Include.NON_NULL)
   private String name;
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @JsonInclude(Include.NON_NULL)
   private List<ProjectInfo> projects;
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @JsonInclude(Include.NON_NULL)
   private NameInfo structureClassify;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal applyPurchaseQuantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal applyPurchaseMete;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal productQuantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal productMete;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inboundTotalQuantity;
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inboundTotalMete;
   private List<BriefIdAndSNDTO> applyPurchase;
   @JsonInclude(Include.NON_NULL)
   private List<ApplyPurchaseDetailDTO> inboundList;
   private BuildingFactoryDTO factoryDTO;
   private com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO workshop;
   private BigDecimal MRInboundQuantity;
   private Boolean boolUsed;

   public String getName() {
      return this.name;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public List<ProjectInfo> getProjects() {
      return this.projects;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public NameInfo getStructureClassify() {
      return this.structureClassify;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getApplyPurchaseQuantity() {
      return this.applyPurchaseQuantity;
   }

   public BigDecimal getApplyPurchaseMete() {
      return this.applyPurchaseMete;
   }

   public BigDecimal getProductQuantity() {
      return this.productQuantity;
   }

   public BigDecimal getProductMete() {
      return this.productMete;
   }

   public BigDecimal getInboundTotalQuantity() {
      return this.inboundTotalQuantity;
   }

   public BigDecimal getInboundTotalMete() {
      return this.inboundTotalMete;
   }

   public List<BriefIdAndSNDTO> getApplyPurchase() {
      return this.applyPurchase;
   }

   public List<ApplyPurchaseDetailDTO> getInboundList() {
      return this.inboundList;
   }

   public BuildingFactoryDTO getFactoryDTO() {
      return this.factoryDTO;
   }

   public com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BigDecimal getMRInboundQuantity() {
      return this.MRInboundQuantity;
   }

   public Boolean getBoolUsed() {
      return this.boolUsed;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setProjects(final List<ProjectInfo> projects) {
      this.projects = projects;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setStructureClassify(final NameInfo structureClassify) {
      this.structureClassify = structureClassify;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setApplyPurchaseQuantity(final BigDecimal applyPurchaseQuantity) {
      this.applyPurchaseQuantity = applyPurchaseQuantity;
   }

   public void setApplyPurchaseMete(final BigDecimal applyPurchaseMete) {
      this.applyPurchaseMete = applyPurchaseMete;
   }

   public void setProductQuantity(final BigDecimal productQuantity) {
      this.productQuantity = productQuantity;
   }

   public void setProductMete(final BigDecimal productMete) {
      this.productMete = productMete;
   }

   public void setInboundTotalQuantity(final BigDecimal inboundTotalQuantity) {
      this.inboundTotalQuantity = inboundTotalQuantity;
   }

   public void setInboundTotalMete(final BigDecimal inboundTotalMete) {
      this.inboundTotalMete = inboundTotalMete;
   }

   public void setApplyPurchase(final List<BriefIdAndSNDTO> applyPurchase) {
      this.applyPurchase = applyPurchase;
   }

   public void setInboundList(final List<ApplyPurchaseDetailDTO> inboundList) {
      this.inboundList = inboundList;
   }

   public void setFactoryDTO(final BuildingFactoryDTO factoryDTO) {
      this.factoryDTO = factoryDTO;
   }

   public void setWorkshop(final com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setMRInboundQuantity(final BigDecimal MRInboundQuantity) {
      this.MRInboundQuantity = MRInboundQuantity;
   }

   public void setBoolUsed(final Boolean boolUsed) {
      this.boolUsed = boolUsed;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderDetailDTO)) {
         return false;
      }

      PurchaseOrderDetailDTO other = (PurchaseOrderDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolUsed = this.getBoolUsed();
      Object other$boolUsed = other.getBoolUsed();
      if (this$boolUsed == null ? other$boolUsed == null : this$boolUsed.equals(other$boolUsed)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$projects = this.getProjects();
               Object other$projects = other.getProjects();
               if (this$projects == null ? other$projects == null : this$projects.equals(other$projects)) {
                  Object this$monomer = this.getMonomer();
                  Object other$monomer = other.getMonomer();
                  if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                     Object this$area = this.getArea();
                     Object other$area = other.getArea();
                     if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$structureClassify = this.getStructureClassify();
                           Object other$structureClassify = other.getStructureClassify();
                           if (this$structureClassify == null ? other$structureClassify == null : this$structureClassify.equals(other$structureClassify)) {
                              Object this$netWeight = this.getNetWeight();
                              Object other$netWeight = other.getNetWeight();
                              if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                 Object this$applyPurchaseQuantity = this.getApplyPurchaseQuantity();
                                 Object other$applyPurchaseQuantity = other.getApplyPurchaseQuantity();
                                 if (this$applyPurchaseQuantity == null
                                    ? other$applyPurchaseQuantity == null
                                    : this$applyPurchaseQuantity.equals(other$applyPurchaseQuantity)) {
                                    Object this$applyPurchaseMete = this.getApplyPurchaseMete();
                                    Object other$applyPurchaseMete = other.getApplyPurchaseMete();
                                    if (this$applyPurchaseMete == null
                                       ? other$applyPurchaseMete == null
                                       : this$applyPurchaseMete.equals(other$applyPurchaseMete)) {
                                       Object this$productQuantity = this.getProductQuantity();
                                       Object other$productQuantity = other.getProductQuantity();
                                       if (this$productQuantity == null ? other$productQuantity == null : this$productQuantity.equals(other$productQuantity)) {
                                          Object this$productMete = this.getProductMete();
                                          Object other$productMete = other.getProductMete();
                                          if (this$productMete == null ? other$productMete == null : this$productMete.equals(other$productMete)) {
                                             Object this$inboundTotalQuantity = this.getInboundTotalQuantity();
                                             Object other$inboundTotalQuantity = other.getInboundTotalQuantity();
                                             if (this$inboundTotalQuantity == null
                                                ? other$inboundTotalQuantity == null
                                                : this$inboundTotalQuantity.equals(other$inboundTotalQuantity)) {
                                                Object this$inboundTotalMete = this.getInboundTotalMete();
                                                Object other$inboundTotalMete = other.getInboundTotalMete();
                                                if (this$inboundTotalMete == null
                                                   ? other$inboundTotalMete == null
                                                   : this$inboundTotalMete.equals(other$inboundTotalMete)) {
                                                   Object this$applyPurchase = this.getApplyPurchase();
                                                   Object other$applyPurchase = other.getApplyPurchase();
                                                   if (this$applyPurchase == null
                                                      ? other$applyPurchase == null
                                                      : this$applyPurchase.equals(other$applyPurchase)) {
                                                      Object this$inboundList = this.getInboundList();
                                                      Object other$inboundList = other.getInboundList();
                                                      if (this$inboundList == null ? other$inboundList == null : this$inboundList.equals(other$inboundList)) {
                                                         Object this$factoryDTO = this.getFactoryDTO();
                                                         Object other$factoryDTO = other.getFactoryDTO();
                                                         if (this$factoryDTO == null ? other$factoryDTO == null : this$factoryDTO.equals(other$factoryDTO)) {
                                                            Object this$workshop = this.getWorkshop();
                                                            Object other$workshop = other.getWorkshop();
                                                            if (this$workshop == null ? other$workshop == null : this$workshop.equals(other$workshop)) {
                                                               Object this$MRInboundQuantity = this.getMRInboundQuantity();
                                                               Object other$MRInboundQuantity = other.getMRInboundQuantity();
                                                               return this$MRInboundQuantity == null
                                                                  ? other$MRInboundQuantity == null
                                                                  : this$MRInboundQuantity.equals(other$MRInboundQuantity);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PurchaseOrderDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolUsed = this.getBoolUsed();
      result = result * 59 + ($boolUsed == null ? 43 : $boolUsed.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $projects = this.getProjects();
      result = result * 59 + ($projects == null ? 43 : $projects.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $structureClassify = this.getStructureClassify();
      result = result * 59 + ($structureClassify == null ? 43 : $structureClassify.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $applyPurchaseQuantity = this.getApplyPurchaseQuantity();
      result = result * 59 + ($applyPurchaseQuantity == null ? 43 : $applyPurchaseQuantity.hashCode());
      Object $applyPurchaseMete = this.getApplyPurchaseMete();
      result = result * 59 + ($applyPurchaseMete == null ? 43 : $applyPurchaseMete.hashCode());
      Object $productQuantity = this.getProductQuantity();
      result = result * 59 + ($productQuantity == null ? 43 : $productQuantity.hashCode());
      Object $productMete = this.getProductMete();
      result = result * 59 + ($productMete == null ? 43 : $productMete.hashCode());
      Object $inboundTotalQuantity = this.getInboundTotalQuantity();
      result = result * 59 + ($inboundTotalQuantity == null ? 43 : $inboundTotalQuantity.hashCode());
      Object $inboundTotalMete = this.getInboundTotalMete();
      result = result * 59 + ($inboundTotalMete == null ? 43 : $inboundTotalMete.hashCode());
      Object $applyPurchase = this.getApplyPurchase();
      result = result * 59 + ($applyPurchase == null ? 43 : $applyPurchase.hashCode());
      Object $inboundList = this.getInboundList();
      result = result * 59 + ($inboundList == null ? 43 : $inboundList.hashCode());
      Object $factoryDTO = this.getFactoryDTO();
      result = result * 59 + ($factoryDTO == null ? 43 : $factoryDTO.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $MRInboundQuantity = this.getMRInboundQuantity();
      return result * 59 + ($MRInboundQuantity == null ? 43 : $MRInboundQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderDetailDTO(name="
         + this.getName()
         + ", project="
         + this.getProject()
         + ", projects="
         + this.getProjects()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", structureClassify="
         + this.getStructureClassify()
         + ", netWeight="
         + this.getNetWeight()
         + ", applyPurchaseQuantity="
         + this.getApplyPurchaseQuantity()
         + ", applyPurchaseMete="
         + this.getApplyPurchaseMete()
         + ", productQuantity="
         + this.getProductQuantity()
         + ", productMete="
         + this.getProductMete()
         + ", inboundTotalQuantity="
         + this.getInboundTotalQuantity()
         + ", inboundTotalMete="
         + this.getInboundTotalMete()
         + ", applyPurchase="
         + this.getApplyPurchase()
         + ", inboundList="
         + this.getInboundList()
         + ", factoryDTO="
         + this.getFactoryDTO()
         + ", workshop="
         + this.getWorkshop()
         + ", MRInboundQuantity="
         + this.getMRInboundQuantity()
         + ", boolUsed="
         + this.getBoolUsed()
         + ")";
   }
}
