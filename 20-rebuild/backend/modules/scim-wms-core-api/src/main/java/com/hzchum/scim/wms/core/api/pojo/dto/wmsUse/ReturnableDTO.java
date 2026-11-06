package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.scm.core.api.pojo.dto.BriefIdAndNameDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.ProjectInfoDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReturnableDTO {
   private Long id;
   private Boolean boolReviewPending;
   private Long classifyId;
   private Boolean boolPartyA;
   private Integer outboundUnitType;
   private Integer basicClass;
   private String specification;
   private BigDecimal mete;
   private BigDecimal returnableMete;
   private String monomerName;
   private String areaName;
   private BigDecimal singleMete;
   private BigDecimal singleReturnableMete;
   private BigDecimal singleReturnableLength;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal unitNet;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String color;
   private String heatNoAndBatchNo;
   private ProjectInfoDTO project;
   private BriefIdAndSNDTO outbound;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO mesWorkshop;
   private BriefIdAndNameDTO warehouse;
   private String nationalStandard;
   private String recipientName;
   private LocalDateTime createTime;
   private Long sourceWorkshopId;
   private String workshopName;
   private Long materialReturnableId;
   private Long areaBatchId;
   private String areaBatchName;
   private String outboundDetailRemark;

   public static ReturnableDTO.ReturnableDTOBuilder builder() {
      return new ReturnableDTO.ReturnableDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolReviewPending() {
      return this.boolReviewPending;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getOutboundUnitType() {
      return this.outboundUnitType;
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

   public BigDecimal getReturnableMete() {
      return this.returnableMete;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public BigDecimal getSingleMete() {
      return this.singleMete;
   }

   public BigDecimal getSingleReturnableMete() {
      return this.singleReturnableMete;
   }

   public BigDecimal getSingleReturnableLength() {
      return this.singleReturnableLength;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public String getColor() {
      return this.color;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public ProjectInfoDTO getProject() {
      return this.project;
   }

   public BriefIdAndSNDTO getOutbound() {
      return this.outbound;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getSourceWorkshopId() {
      return this.sourceWorkshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Long getMaterialReturnableId() {
      return this.materialReturnableId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public String getAreaBatchName() {
      return this.areaBatchName;
   }

   public String getOutboundDetailRemark() {
      return this.outboundDetailRemark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolReviewPending(final Boolean boolReviewPending) {
      this.boolReviewPending = boolReviewPending;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setOutboundUnitType(final Integer outboundUnitType) {
      this.outboundUnitType = outboundUnitType;
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

   public void setReturnableMete(final BigDecimal returnableMete) {
      this.returnableMete = returnableMete;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setSingleMete(final BigDecimal singleMete) {
      this.singleMete = singleMete;
   }

   public void setSingleReturnableMete(final BigDecimal singleReturnableMete) {
      this.singleReturnableMete = singleReturnableMete;
   }

   public void setSingleReturnableLength(final BigDecimal singleReturnableLength) {
      this.singleReturnableLength = singleReturnableLength;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
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

   public void setColor(final String color) {
      this.color = color;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setProject(final ProjectInfoDTO project) {
      this.project = project;
   }

   public void setOutbound(final BriefIdAndSNDTO outbound) {
      this.outbound = outbound;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setMesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSourceWorkshopId(final Long sourceWorkshopId) {
      this.sourceWorkshopId = sourceWorkshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setMaterialReturnableId(final Long materialReturnableId) {
      this.materialReturnableId = materialReturnableId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setAreaBatchName(final String areaBatchName) {
      this.areaBatchName = areaBatchName;
   }

   public void setOutboundDetailRemark(final String outboundDetailRemark) {
      this.outboundDetailRemark = outboundDetailRemark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReturnableDTO)) {
         return false;
      }

      ReturnableDTO other = (ReturnableDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolReviewPending = this.getBoolReviewPending();
         Object other$boolReviewPending = other.getBoolReviewPending();
         if (this$boolReviewPending == null ? other$boolReviewPending == null : this$boolReviewPending.equals(other$boolReviewPending)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$boolPartyA = this.getBoolPartyA();
               Object other$boolPartyA = other.getBoolPartyA();
               if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                  Object this$outboundUnitType = this.getOutboundUnitType();
                  Object other$outboundUnitType = other.getOutboundUnitType();
                  if (this$outboundUnitType == null ? other$outboundUnitType == null : this$outboundUnitType.equals(other$outboundUnitType)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$sourceWorkshopId = this.getSourceWorkshopId();
                        Object other$sourceWorkshopId = other.getSourceWorkshopId();
                        if (this$sourceWorkshopId == null ? other$sourceWorkshopId == null : this$sourceWorkshopId.equals(other$sourceWorkshopId)) {
                           Object this$materialReturnableId = this.getMaterialReturnableId();
                           Object other$materialReturnableId = other.getMaterialReturnableId();
                           if (this$materialReturnableId == null
                              ? other$materialReturnableId == null
                              : this$materialReturnableId.equals(other$materialReturnableId)) {
                              Object this$areaBatchId = this.getAreaBatchId();
                              Object other$areaBatchId = other.getAreaBatchId();
                              if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$mete = this.getMete();
                                    Object other$mete = other.getMete();
                                    if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                       Object this$returnableMete = this.getReturnableMete();
                                       Object other$returnableMete = other.getReturnableMete();
                                       if (this$returnableMete == null ? other$returnableMete == null : this$returnableMete.equals(other$returnableMete)) {
                                          Object this$monomerName = this.getMonomerName();
                                          Object other$monomerName = other.getMonomerName();
                                          if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                                             Object this$areaName = this.getAreaName();
                                             Object other$areaName = other.getAreaName();
                                             if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                                Object this$singleMete = this.getSingleMete();
                                                Object other$singleMete = other.getSingleMete();
                                                if (this$singleMete == null ? other$singleMete == null : this$singleMete.equals(other$singleMete)) {
                                                   Object this$singleReturnableMete = this.getSingleReturnableMete();
                                                   Object other$singleReturnableMete = other.getSingleReturnableMete();
                                                   if (this$singleReturnableMete == null
                                                      ? other$singleReturnableMete == null
                                                      : this$singleReturnableMete.equals(other$singleReturnableMete)) {
                                                      Object this$singleReturnableLength = this.getSingleReturnableLength();
                                                      Object other$singleReturnableLength = other.getSingleReturnableLength();
                                                      if (this$singleReturnableLength == null
                                                         ? other$singleReturnableLength == null
                                                         : this$singleReturnableLength.equals(other$singleReturnableLength)) {
                                                         Object this$quantity = this.getQuantity();
                                                         Object other$quantity = other.getQuantity();
                                                         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                            Object this$thickness = this.getThickness();
                                                            Object other$thickness = other.getThickness();
                                                            if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                               Object this$unitNet = this.getUnitNet();
                                                               Object other$unitNet = other.getUnitNet();
                                                               if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$width = this.getWidth();
                                                                     Object other$width = other.getWidth();
                                                                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                        Object this$brand = this.getBrand();
                                                                        Object other$brand = other.getBrand();
                                                                        if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                           Object this$color = this.getColor();
                                                                           Object other$color = other.getColor();
                                                                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                              Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                              Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                              if (this$heatNoAndBatchNo == null
                                                                                 ? other$heatNoAndBatchNo == null
                                                                                 : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                 Object this$project = this.getProject();
                                                                                 Object other$project = other.getProject();
                                                                                 if (this$project == null
                                                                                    ? other$project == null
                                                                                    : this$project.equals(other$project)) {
                                                                                    Object this$outbound = this.getOutbound();
                                                                                    Object other$outbound = other.getOutbound();
                                                                                    if (this$outbound == null
                                                                                       ? other$outbound == null
                                                                                       : this$outbound.equals(other$outbound)) {
                                                                                       Object this$workshop = this.getWorkshop();
                                                                                       Object other$workshop = other.getWorkshop();
                                                                                       if (this$workshop == null
                                                                                          ? other$workshop == null
                                                                                          : this$workshop.equals(other$workshop)) {
                                                                                          Object this$mesWorkshop = this.getMesWorkshop();
                                                                                          Object other$mesWorkshop = other.getMesWorkshop();
                                                                                          if (this$mesWorkshop == null
                                                                                             ? other$mesWorkshop == null
                                                                                             : this$mesWorkshop.equals(other$mesWorkshop)) {
                                                                                             Object this$warehouse = this.getWarehouse();
                                                                                             Object other$warehouse = other.getWarehouse();
                                                                                             if (this$warehouse == null
                                                                                                ? other$warehouse == null
                                                                                                : this$warehouse.equals(other$warehouse)) {
                                                                                                Object this$nationalStandard = this.getNationalStandard();
                                                                                                Object other$nationalStandard = other.getNationalStandard();
                                                                                                if (this$nationalStandard == null
                                                                                                   ? other$nationalStandard == null
                                                                                                   : this$nationalStandard.equals(other$nationalStandard)) {
                                                                                                   Object this$recipientName = this.getRecipientName();
                                                                                                   Object other$recipientName = other.getRecipientName();
                                                                                                   if (this$recipientName == null
                                                                                                      ? other$recipientName == null
                                                                                                      : this$recipientName.equals(other$recipientName)) {
                                                                                                      Object this$createTime = this.getCreateTime();
                                                                                                      Object other$createTime = other.getCreateTime();
                                                                                                      if (this$createTime == null
                                                                                                         ? other$createTime == null
                                                                                                         : this$createTime.equals(other$createTime)) {
                                                                                                         Object this$workshopName = this.getWorkshopName();
                                                                                                         Object other$workshopName = other.getWorkshopName();
                                                                                                         if (this$workshopName == null
                                                                                                            ? other$workshopName == null
                                                                                                            : this$workshopName.equals(other$workshopName)) {
                                                                                                            Object this$areaBatchName = this.getAreaBatchName();
                                                                                                            Object other$areaBatchName = other.getAreaBatchName();
                                                                                                            if (this$areaBatchName == null
                                                                                                               ? other$areaBatchName == null
                                                                                                               : this$areaBatchName.equals(other$areaBatchName)
                                                                                                               )
                                                                                                             {
                                                                                                               Object this$outboundDetailRemark = this.getOutboundDetailRemark();
                                                                                                               Object other$outboundDetailRemark = other.getOutboundDetailRemark();
                                                                                                               return this$outboundDetailRemark == null
                                                                                                                  ? other$outboundDetailRemark == null
                                                                                                                  : this$outboundDetailRemark.equals(
                                                                                                                     other$outboundDetailRemark
                                                                                                                  );
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
      return other instanceof ReturnableDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolReviewPending = this.getBoolReviewPending();
      result = result * 59 + ($boolReviewPending == null ? 43 : $boolReviewPending.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $outboundUnitType = this.getOutboundUnitType();
      result = result * 59 + ($outboundUnitType == null ? 43 : $outboundUnitType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $sourceWorkshopId = this.getSourceWorkshopId();
      result = result * 59 + ($sourceWorkshopId == null ? 43 : $sourceWorkshopId.hashCode());
      Object $materialReturnableId = this.getMaterialReturnableId();
      result = result * 59 + ($materialReturnableId == null ? 43 : $materialReturnableId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $returnableMete = this.getReturnableMete();
      result = result * 59 + ($returnableMete == null ? 43 : $returnableMete.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $singleMete = this.getSingleMete();
      result = result * 59 + ($singleMete == null ? 43 : $singleMete.hashCode());
      Object $singleReturnableMete = this.getSingleReturnableMete();
      result = result * 59 + ($singleReturnableMete == null ? 43 : $singleReturnableMete.hashCode());
      Object $singleReturnableLength = this.getSingleReturnableLength();
      result = result * 59 + ($singleReturnableLength == null ? 43 : $singleReturnableLength.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $outbound = this.getOutbound();
      result = result * 59 + ($outbound == null ? 43 : $outbound.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $areaBatchName = this.getAreaBatchName();
      result = result * 59 + ($areaBatchName == null ? 43 : $areaBatchName.hashCode());
      Object $outboundDetailRemark = this.getOutboundDetailRemark();
      return result * 59 + ($outboundDetailRemark == null ? 43 : $outboundDetailRemark.hashCode());
   }

   @Override
   public String toString() {
      return "ReturnableDTO(id="
         + this.getId()
         + ", boolReviewPending="
         + this.getBoolReviewPending()
         + ", classifyId="
         + this.getClassifyId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", outboundUnitType="
         + this.getOutboundUnitType()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", mete="
         + this.getMete()
         + ", returnableMete="
         + this.getReturnableMete()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaName="
         + this.getAreaName()
         + ", singleMete="
         + this.getSingleMete()
         + ", singleReturnableMete="
         + this.getSingleReturnableMete()
         + ", singleReturnableLength="
         + this.getSingleReturnableLength()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", unitNet="
         + this.getUnitNet()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", project="
         + this.getProject()
         + ", outbound="
         + this.getOutbound()
         + ", workshop="
         + this.getWorkshop()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", recipientName="
         + this.getRecipientName()
         + ", createTime="
         + this.getCreateTime()
         + ", sourceWorkshopId="
         + this.getSourceWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", materialReturnableId="
         + this.getMaterialReturnableId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaBatchName="
         + this.getAreaBatchName()
         + ", outboundDetailRemark="
         + this.getOutboundDetailRemark()
         + ")";
   }

   public ReturnableDTO(
      final Long id,
      final Boolean boolReviewPending,
      final Long classifyId,
      final Boolean boolPartyA,
      final Integer outboundUnitType,
      final Integer basicClass,
      final String specification,
      final BigDecimal mete,
      final BigDecimal returnableMete,
      final String monomerName,
      final String areaName,
      final BigDecimal singleMete,
      final BigDecimal singleReturnableMete,
      final BigDecimal singleReturnableLength,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal unitNet,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String color,
      final String heatNoAndBatchNo,
      final ProjectInfoDTO project,
      final BriefIdAndSNDTO outbound,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO mesWorkshop,
      final BriefIdAndNameDTO warehouse,
      final String nationalStandard,
      final String recipientName,
      final LocalDateTime createTime,
      final Long sourceWorkshopId,
      final String workshopName,
      final Long materialReturnableId,
      final Long areaBatchId,
      final String areaBatchName,
      final String outboundDetailRemark
   ) {
      this.id = id;
      this.boolReviewPending = boolReviewPending;
      this.classifyId = classifyId;
      this.boolPartyA = boolPartyA;
      this.outboundUnitType = outboundUnitType;
      this.basicClass = basicClass;
      this.specification = specification;
      this.mete = mete;
      this.returnableMete = returnableMete;
      this.monomerName = monomerName;
      this.areaName = areaName;
      this.singleMete = singleMete;
      this.singleReturnableMete = singleReturnableMete;
      this.singleReturnableLength = singleReturnableLength;
      this.quantity = quantity;
      this.thickness = thickness;
      this.unitNet = unitNet;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.project = project;
      this.outbound = outbound;
      this.workshop = workshop;
      this.mesWorkshop = mesWorkshop;
      this.warehouse = warehouse;
      this.nationalStandard = nationalStandard;
      this.recipientName = recipientName;
      this.createTime = createTime;
      this.sourceWorkshopId = sourceWorkshopId;
      this.workshopName = workshopName;
      this.materialReturnableId = materialReturnableId;
      this.areaBatchId = areaBatchId;
      this.areaBatchName = areaBatchName;
      this.outboundDetailRemark = outboundDetailRemark;
   }

   public ReturnableDTO() {
   }

   public static class ReturnableDTOBuilder {
      private Long id;
      private Boolean boolReviewPending;
      private Long classifyId;
      private Boolean boolPartyA;
      private Integer outboundUnitType;
      private Integer basicClass;
      private String specification;
      private BigDecimal mete;
      private BigDecimal returnableMete;
      private String monomerName;
      private String areaName;
      private BigDecimal singleMete;
      private BigDecimal singleReturnableMete;
      private BigDecimal singleReturnableLength;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal unitNet;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String color;
      private String heatNoAndBatchNo;
      private ProjectInfoDTO project;
      private BriefIdAndSNDTO outbound;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO mesWorkshop;
      private BriefIdAndNameDTO warehouse;
      private String nationalStandard;
      private String recipientName;
      private LocalDateTime createTime;
      private Long sourceWorkshopId;
      private String workshopName;
      private Long materialReturnableId;
      private Long areaBatchId;
      private String areaBatchName;
      private String outboundDetailRemark;

      ReturnableDTOBuilder() {
      }

      public ReturnableDTO.ReturnableDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder boolReviewPending(final Boolean boolReviewPending) {
         this.boolReviewPending = boolReviewPending;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder outboundUnitType(final Integer outboundUnitType) {
         this.outboundUnitType = outboundUnitType;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder returnableMete(final BigDecimal returnableMete) {
         this.returnableMete = returnableMete;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder areaName(final String areaName) {
         this.areaName = areaName;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder singleMete(final BigDecimal singleMete) {
         this.singleMete = singleMete;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder singleReturnableMete(final BigDecimal singleReturnableMete) {
         this.singleReturnableMete = singleReturnableMete;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder singleReturnableLength(final BigDecimal singleReturnableLength) {
         this.singleReturnableLength = singleReturnableLength;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder project(final ProjectInfoDTO project) {
         this.project = project;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder outbound(final BriefIdAndSNDTO outbound) {
         this.outbound = outbound;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder mesWorkshop(final BriefIdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder recipientName(final String recipientName) {
         this.recipientName = recipientName;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder sourceWorkshopId(final Long sourceWorkshopId) {
         this.sourceWorkshopId = sourceWorkshopId;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder materialReturnableId(final Long materialReturnableId) {
         this.materialReturnableId = materialReturnableId;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder areaBatchName(final String areaBatchName) {
         this.areaBatchName = areaBatchName;
         return this;
      }

      public ReturnableDTO.ReturnableDTOBuilder outboundDetailRemark(final String outboundDetailRemark) {
         this.outboundDetailRemark = outboundDetailRemark;
         return this;
      }

      public ReturnableDTO build() {
         return new ReturnableDTO(
            this.id,
            this.boolReviewPending,
            this.classifyId,
            this.boolPartyA,
            this.outboundUnitType,
            this.basicClass,
            this.specification,
            this.mete,
            this.returnableMete,
            this.monomerName,
            this.areaName,
            this.singleMete,
            this.singleReturnableMete,
            this.singleReturnableLength,
            this.quantity,
            this.thickness,
            this.unitNet,
            this.length,
            this.width,
            this.brand,
            this.color,
            this.heatNoAndBatchNo,
            this.project,
            this.outbound,
            this.workshop,
            this.mesWorkshop,
            this.warehouse,
            this.nationalStandard,
            this.recipientName,
            this.createTime,
            this.sourceWorkshopId,
            this.workshopName,
            this.materialReturnableId,
            this.areaBatchId,
            this.areaBatchName,
            this.outboundDetailRemark
         );
      }

      @Override
      public String toString() {
         return "ReturnableDTO.ReturnableDTOBuilder(id="
            + this.id
            + ", boolReviewPending="
            + this.boolReviewPending
            + ", classifyId="
            + this.classifyId
            + ", boolPartyA="
            + this.boolPartyA
            + ", outboundUnitType="
            + this.outboundUnitType
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", mete="
            + this.mete
            + ", returnableMete="
            + this.returnableMete
            + ", monomerName="
            + this.monomerName
            + ", areaName="
            + this.areaName
            + ", singleMete="
            + this.singleMete
            + ", singleReturnableMete="
            + this.singleReturnableMete
            + ", singleReturnableLength="
            + this.singleReturnableLength
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", unitNet="
            + this.unitNet
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", brand="
            + this.brand
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", project="
            + this.project
            + ", outbound="
            + this.outbound
            + ", workshop="
            + this.workshop
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", warehouse="
            + this.warehouse
            + ", nationalStandard="
            + this.nationalStandard
            + ", recipientName="
            + this.recipientName
            + ", createTime="
            + this.createTime
            + ", sourceWorkshopId="
            + this.sourceWorkshopId
            + ", workshopName="
            + this.workshopName
            + ", materialReturnableId="
            + this.materialReturnableId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaBatchName="
            + this.areaBatchName
            + ", outboundDetailRemark="
            + this.outboundDetailRemark
            + ")";
      }
   }
}
