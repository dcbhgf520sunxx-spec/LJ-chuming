package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PartyABorrowDTO {
   private Long id;
   private Long classifyId;
   private Integer basicClass;
   private String specification;
   private BigDecimal mete;
   private BigDecimal returnedMete;
   private BigDecimal underReviewMete;
   private BigDecimal quantity;
   private BigDecimal returnedQuantity;
   private BigDecimal underReviewQuantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String heatNoAndBatchNo;
   private String remark;
   private ProjectInfoDTO project;
   private ProjectInfoDTO borrowProject;
   private BriefIdAndNameDTO borrowWorkShop;
   private BriefIdAndNameDTO borrowWareHouse;
   private Integer returnStatus;
   private BriefIdAndSNDTO borrowTransfer;
   private List<BriefIdAndSNDTO> returnTransfers;
   private LocalDateTime returnTime;
   private String transferorName;
   private LocalDateTime transferTime;
   private String nationalStandard;

   public static PartyABorrowDTO.PartyABorrowDTOBuilder builder() {
      return new PartyABorrowDTO.PartyABorrowDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getReturnedMete() {
      return this.returnedMete;
   }

   public BigDecimal getUnderReviewMete() {
      return this.underReviewMete;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getReturnedQuantity() {
      return this.returnedQuantity;
   }

   public BigDecimal getUnderReviewQuantity() {
      return this.underReviewQuantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getRemark() {
      return this.remark;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public ProjectInfoDTO getBorrowProject() {
      return this.borrowProject;
   }

   public BriefIdAndNameDTO getBorrowWorkShop() {
      return this.borrowWorkShop;
   }

   public BriefIdAndNameDTO getBorrowWareHouse() {
      return this.borrowWareHouse;
   }

   public Integer getReturnStatus() {
      return this.returnStatus;
   }

   public BriefIdAndSNDTO getBorrowTransfer() {
      return this.borrowTransfer;
   }

   public List<BriefIdAndSNDTO> getReturnTransfers() {
      return this.returnTransfers;
   }

   public LocalDateTime getReturnTime() {
      return this.returnTime;
   }

   public String getTransferorName() {
      return this.transferorName;
   }

   public LocalDateTime getTransferTime() {
      return this.transferTime;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setReturnedMete(final BigDecimal returnedMete) {
      this.returnedMete = returnedMete;
   }

   public void setUnderReviewMete(final BigDecimal underReviewMete) {
      this.underReviewMete = underReviewMete;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setReturnedQuantity(final BigDecimal returnedQuantity) {
      this.returnedQuantity = returnedQuantity;
   }

   public void setUnderReviewQuantity(final BigDecimal underReviewQuantity) {
      this.underReviewQuantity = underReviewQuantity;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setBorrowProject(final ProjectInfoDTO borrowProject) {
      this.borrowProject = borrowProject;
   }

   public void setBorrowWorkShop(final BriefIdAndNameDTO borrowWorkShop) {
      this.borrowWorkShop = borrowWorkShop;
   }

   public void setBorrowWareHouse(final BriefIdAndNameDTO borrowWareHouse) {
      this.borrowWareHouse = borrowWareHouse;
   }

   public void setReturnStatus(final Integer returnStatus) {
      this.returnStatus = returnStatus;
   }

   public void setBorrowTransfer(final BriefIdAndSNDTO borrowTransfer) {
      this.borrowTransfer = borrowTransfer;
   }

   public void setReturnTransfers(final List<BriefIdAndSNDTO> returnTransfers) {
      this.returnTransfers = returnTransfers;
   }

   public void setReturnTime(final LocalDateTime returnTime) {
      this.returnTime = returnTime;
   }

   public void setTransferorName(final String transferorName) {
      this.transferorName = transferorName;
   }

   public void setTransferTime(final LocalDateTime transferTime) {
      this.transferTime = transferTime;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PartyABorrowDTO)) {
         return false;
      }

      PartyABorrowDTO other = (PartyABorrowDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$returnStatus = this.getReturnStatus();
               Object other$returnStatus = other.getReturnStatus();
               if (this$returnStatus == null ? other$returnStatus == null : this$returnStatus.equals(other$returnStatus)) {
                  Object this$specification = this.getSpecification();
                  Object other$specification = other.getSpecification();
                  if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                     Object this$mete = this.getMete();
                     Object other$mete = other.getMete();
                     if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                        Object this$returnedMete = this.getReturnedMete();
                        Object other$returnedMete = other.getReturnedMete();
                        if (this$returnedMete == null ? other$returnedMete == null : this$returnedMete.equals(other$returnedMete)) {
                           Object this$underReviewMete = this.getUnderReviewMete();
                           Object other$underReviewMete = other.getUnderReviewMete();
                           if (this$underReviewMete == null ? other$underReviewMete == null : this$underReviewMete.equals(other$underReviewMete)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                 Object this$returnedQuantity = this.getReturnedQuantity();
                                 Object other$returnedQuantity = other.getReturnedQuantity();
                                 if (this$returnedQuantity == null ? other$returnedQuantity == null : this$returnedQuantity.equals(other$returnedQuantity)) {
                                    Object this$underReviewQuantity = this.getUnderReviewQuantity();
                                    Object other$underReviewQuantity = other.getUnderReviewQuantity();
                                    if (this$underReviewQuantity == null
                                       ? other$underReviewQuantity == null
                                       : this$underReviewQuantity.equals(other$underReviewQuantity)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                             Object this$width = this.getWidth();
                                             Object other$width = other.getWidth();
                                             if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                Object this$brand = this.getBrand();
                                                Object other$brand = other.getBrand();
                                                if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                   Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                   Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                   if (this$heatNoAndBatchNo == null
                                                      ? other$heatNoAndBatchNo == null
                                                      : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                      Object this$remark = this.getRemark();
                                                      Object other$remark = other.getRemark();
                                                      if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                         Object this$project = this.getProject();
                                                         Object other$project = other.getProject();
                                                         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                            Object this$borrowProject = this.getBorrowProject();
                                                            Object other$borrowProject = other.getBorrowProject();
                                                            if (this$borrowProject == null
                                                               ? other$borrowProject == null
                                                               : this$borrowProject.equals(other$borrowProject)) {
                                                               Object this$borrowWorkShop = this.getBorrowWorkShop();
                                                               Object other$borrowWorkShop = other.getBorrowWorkShop();
                                                               if (this$borrowWorkShop == null
                                                                  ? other$borrowWorkShop == null
                                                                  : this$borrowWorkShop.equals(other$borrowWorkShop)) {
                                                                  Object this$borrowWareHouse = this.getBorrowWareHouse();
                                                                  Object other$borrowWareHouse = other.getBorrowWareHouse();
                                                                  if (this$borrowWareHouse == null
                                                                     ? other$borrowWareHouse == null
                                                                     : this$borrowWareHouse.equals(other$borrowWareHouse)) {
                                                                     Object this$borrowTransfer = this.getBorrowTransfer();
                                                                     Object other$borrowTransfer = other.getBorrowTransfer();
                                                                     if (this$borrowTransfer == null
                                                                        ? other$borrowTransfer == null
                                                                        : this$borrowTransfer.equals(other$borrowTransfer)) {
                                                                        Object this$returnTransfers = this.getReturnTransfers();
                                                                        Object other$returnTransfers = other.getReturnTransfers();
                                                                        if (this$returnTransfers == null
                                                                           ? other$returnTransfers == null
                                                                           : this$returnTransfers.equals(other$returnTransfers)) {
                                                                           Object this$returnTime = this.getReturnTime();
                                                                           Object other$returnTime = other.getReturnTime();
                                                                           if (this$returnTime == null
                                                                              ? other$returnTime == null
                                                                              : this$returnTime.equals(other$returnTime)) {
                                                                              Object this$transferorName = this.getTransferorName();
                                                                              Object other$transferorName = other.getTransferorName();
                                                                              if (this$transferorName == null
                                                                                 ? other$transferorName == null
                                                                                 : this$transferorName.equals(other$transferorName)) {
                                                                                 Object this$transferTime = this.getTransferTime();
                                                                                 Object other$transferTime = other.getTransferTime();
                                                                                 if (this$transferTime == null
                                                                                    ? other$transferTime == null
                                                                                    : this$transferTime.equals(other$transferTime)) {
                                                                                    Object this$nationalStandard = this.getNationalStandard();
                                                                                    Object other$nationalStandard = other.getNationalStandard();
                                                                                    return this$nationalStandard == null
                                                                                       ? other$nationalStandard == null
                                                                                       : this$nationalStandard.equals(other$nationalStandard);
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
      return other instanceof PartyABorrowDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $returnStatus = this.getReturnStatus();
      result = result * 59 + ($returnStatus == null ? 43 : $returnStatus.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $returnedMete = this.getReturnedMete();
      result = result * 59 + ($returnedMete == null ? 43 : $returnedMete.hashCode());
      Object $underReviewMete = this.getUnderReviewMete();
      result = result * 59 + ($underReviewMete == null ? 43 : $underReviewMete.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $returnedQuantity = this.getReturnedQuantity();
      result = result * 59 + ($returnedQuantity == null ? 43 : $returnedQuantity.hashCode());
      Object $underReviewQuantity = this.getUnderReviewQuantity();
      result = result * 59 + ($underReviewQuantity == null ? 43 : $underReviewQuantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $borrowProject = this.getBorrowProject();
      result = result * 59 + ($borrowProject == null ? 43 : $borrowProject.hashCode());
      Object $borrowWorkShop = this.getBorrowWorkShop();
      result = result * 59 + ($borrowWorkShop == null ? 43 : $borrowWorkShop.hashCode());
      Object $borrowWareHouse = this.getBorrowWareHouse();
      result = result * 59 + ($borrowWareHouse == null ? 43 : $borrowWareHouse.hashCode());
      Object $borrowTransfer = this.getBorrowTransfer();
      result = result * 59 + ($borrowTransfer == null ? 43 : $borrowTransfer.hashCode());
      Object $returnTransfers = this.getReturnTransfers();
      result = result * 59 + ($returnTransfers == null ? 43 : $returnTransfers.hashCode());
      Object $returnTime = this.getReturnTime();
      result = result * 59 + ($returnTime == null ? 43 : $returnTime.hashCode());
      Object $transferorName = this.getTransferorName();
      result = result * 59 + ($transferorName == null ? 43 : $transferorName.hashCode());
      Object $transferTime = this.getTransferTime();
      result = result * 59 + ($transferTime == null ? 43 : $transferTime.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      return result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
   }

   @Override
   public String toString() {
      return "PartyABorrowDTO(id="
         + this.getId()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", returnedMete="
         + this.getReturnedMete()
         + ", underReviewMete="
         + this.getUnderReviewMete()
         + ", quantity="
         + this.getQuantity()
         + ", returnedQuantity="
         + this.getReturnedQuantity()
         + ", underReviewQuantity="
         + this.getUnderReviewQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", remark="
         + this.getRemark()
         + ", project="
         + this.getProject()
         + ", borrowProject="
         + this.getBorrowProject()
         + ", borrowWorkShop="
         + this.getBorrowWorkShop()
         + ", borrowWareHouse="
         + this.getBorrowWareHouse()
         + ", returnStatus="
         + this.getReturnStatus()
         + ", borrowTransfer="
         + this.getBorrowTransfer()
         + ", returnTransfers="
         + this.getReturnTransfers()
         + ", returnTime="
         + this.getReturnTime()
         + ", transferorName="
         + this.getTransferorName()
         + ", transferTime="
         + this.getTransferTime()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ")";
   }

   public PartyABorrowDTO(
      final Long id,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal mete,
      final BigDecimal returnedMete,
      final BigDecimal underReviewMete,
      final BigDecimal quantity,
      final BigDecimal returnedQuantity,
      final BigDecimal underReviewQuantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String heatNoAndBatchNo,
      final String remark,
      final ProjectInfoDTO project,
      final ProjectInfoDTO borrowProject,
      final BriefIdAndNameDTO borrowWorkShop,
      final BriefIdAndNameDTO borrowWareHouse,
      final Integer returnStatus,
      final BriefIdAndSNDTO borrowTransfer,
      final List<BriefIdAndSNDTO> returnTransfers,
      final LocalDateTime returnTime,
      final String transferorName,
      final LocalDateTime transferTime,
      final String nationalStandard
   ) {
      this.id = id;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.mete = mete;
      this.returnedMete = returnedMete;
      this.underReviewMete = underReviewMete;
      this.quantity = quantity;
      this.returnedQuantity = returnedQuantity;
      this.underReviewQuantity = underReviewQuantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.remark = remark;
      this.project = project;
      this.borrowProject = borrowProject;
      this.borrowWorkShop = borrowWorkShop;
      this.borrowWareHouse = borrowWareHouse;
      this.returnStatus = returnStatus;
      this.borrowTransfer = borrowTransfer;
      this.returnTransfers = returnTransfers;
      this.returnTime = returnTime;
      this.transferorName = transferorName;
      this.transferTime = transferTime;
      this.nationalStandard = nationalStandard;
   }

   public PartyABorrowDTO() {
   }

   public static class PartyABorrowDTOBuilder {
      private Long id;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal mete;
      private BigDecimal returnedMete;
      private BigDecimal underReviewMete;
      private BigDecimal quantity;
      private BigDecimal returnedQuantity;
      private BigDecimal underReviewQuantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String heatNoAndBatchNo;
      private String remark;
      private ProjectInfoDTO project;
      private ProjectInfoDTO borrowProject;
      private BriefIdAndNameDTO borrowWorkShop;
      private BriefIdAndNameDTO borrowWareHouse;
      private Integer returnStatus;
      private BriefIdAndSNDTO borrowTransfer;
      private List<BriefIdAndSNDTO> returnTransfers;
      private LocalDateTime returnTime;
      private String transferorName;
      private LocalDateTime transferTime;
      private String nationalStandard;

      PartyABorrowDTOBuilder() {
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder returnedMete(final BigDecimal returnedMete) {
         this.returnedMete = returnedMete;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder underReviewMete(final BigDecimal underReviewMete) {
         this.underReviewMete = underReviewMete;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder returnedQuantity(final BigDecimal returnedQuantity) {
         this.returnedQuantity = returnedQuantity;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder underReviewQuantity(final BigDecimal underReviewQuantity) {
         this.underReviewQuantity = underReviewQuantity;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder borrowProject(final ProjectInfoDTO borrowProject) {
         this.borrowProject = borrowProject;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder borrowWorkShop(final BriefIdAndNameDTO borrowWorkShop) {
         this.borrowWorkShop = borrowWorkShop;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder borrowWareHouse(final BriefIdAndNameDTO borrowWareHouse) {
         this.borrowWareHouse = borrowWareHouse;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder returnStatus(final Integer returnStatus) {
         this.returnStatus = returnStatus;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder borrowTransfer(final BriefIdAndSNDTO borrowTransfer) {
         this.borrowTransfer = borrowTransfer;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder returnTransfers(final List<BriefIdAndSNDTO> returnTransfers) {
         this.returnTransfers = returnTransfers;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder returnTime(final LocalDateTime returnTime) {
         this.returnTime = returnTime;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder transferorName(final String transferorName) {
         this.transferorName = transferorName;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder transferTime(final LocalDateTime transferTime) {
         this.transferTime = transferTime;
         return this;
      }

      public PartyABorrowDTO.PartyABorrowDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public PartyABorrowDTO build() {
         return new PartyABorrowDTO(
            this.id,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.mete,
            this.returnedMete,
            this.underReviewMete,
            this.quantity,
            this.returnedQuantity,
            this.underReviewQuantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.heatNoAndBatchNo,
            this.remark,
            this.project,
            this.borrowProject,
            this.borrowWorkShop,
            this.borrowWareHouse,
            this.returnStatus,
            this.borrowTransfer,
            this.returnTransfers,
            this.returnTime,
            this.transferorName,
            this.transferTime,
            this.nationalStandard
         );
      }

      @Override
      public String toString() {
         return "PartyABorrowDTO.PartyABorrowDTOBuilder(id="
            + this.id
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", returnedMete="
            + this.returnedMete
            + ", underReviewMete="
            + this.underReviewMete
            + ", quantity="
            + this.quantity
            + ", returnedQuantity="
            + this.returnedQuantity
            + ", underReviewQuantity="
            + this.underReviewQuantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", remark="
            + this.remark
            + ", project="
            + this.project
            + ", borrowProject="
            + this.borrowProject
            + ", borrowWorkShop="
            + this.borrowWorkShop
            + ", borrowWareHouse="
            + this.borrowWareHouse
            + ", returnStatus="
            + this.returnStatus
            + ", borrowTransfer="
            + this.borrowTransfer
            + ", returnTransfers="
            + this.returnTransfers
            + ", returnTime="
            + this.returnTime
            + ", transferorName="
            + this.transferorName
            + ", transferTime="
            + this.transferTime
            + ", nationalStandard="
            + this.nationalStandard
            + ")";
      }
   }
}
