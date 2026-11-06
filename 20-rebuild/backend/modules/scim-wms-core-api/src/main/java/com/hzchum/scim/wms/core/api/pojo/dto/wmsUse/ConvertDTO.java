package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.WmsApproveRecordFlowDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;

public class ConvertDTO {
   private Long id;
   private Long materialInventoryId;
   private String receiptSerialNumber;
   private String brand;
   private String specification;
   private String serialNumber;
   private BigDecimal width;
   private BigDecimal thickness;
   private String color;
   private String heatNoAndBatchNo;
   private Long warehouseId;
   private String classifyName;
   private Long projectId;
   private BriefIdAndNameDTO warehouse;
   private ProjectInfo project;
   private Integer status;
   private Long applyUserId;
   private String applyUserName;
   private LocalDate applyTime;
   private Long reviewerId;
   private String reviewerName;
   private LocalDateTime reviewTime;
   private String remark;
   private List<ConvertDetailDTO> convertDetailDTOList;
   @ApiModelProperty(name = "amountExcludingVat", value = "转换总金额（不含税）")
   @JsonProperty("amountExcludingVat")
   @JSONField(name = "amountExcludingVat")
   @TableField("amount_excluding_VAT")
   @Column(name = "amount_excluding_VAT")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "quantity", value = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity")
   private BigDecimal quantity;
   @ApiModelProperty(name = "mete", value = "卷板总核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   @TableField("mete")
   @Column(name = "mete")
   private BigDecimal mete;
   private Long classifyId;
   private String outSerialNumber;
   private Boolean boolPartyA;
   private Long approveRecordId;
   private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;

   public static ConvertDTO.ConvertDTOBuilder builder() {
      return new ConvertDTO.ConvertDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public String getReceiptSerialNumber() {
      return this.receiptSerialNumber;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public LocalDate getApplyTime() {
      return this.applyTime;
   }

   public Long getReviewerId() {
      return this.reviewerId;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<ConvertDetailDTO> getConvertDetailDTOList() {
      return this.convertDetailDTOList;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getOutSerialNumber() {
      return this.outSerialNumber;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getApproveRecordId() {
      return this.approveRecordId;
   }

   public WmsApproveRecordFlowDTO getWmsApproveRecordFlowDTO() {
      return this.wmsApproveRecordFlowDTO;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setReceiptSerialNumber(final String receiptSerialNumber) {
      this.receiptSerialNumber = receiptSerialNumber;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
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

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setApplyTime(final LocalDate applyTime) {
      this.applyTime = applyTime;
   }

   public void setReviewerId(final Long reviewerId) {
      this.reviewerId = reviewerId;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setConvertDetailDTOList(final List<ConvertDetailDTO> convertDetailDTOList) {
      this.convertDetailDTOList = convertDetailDTOList;
   }

   @JsonProperty("amountExcludingVat")
   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   @JsonProperty("quantity")
   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setOutSerialNumber(final String outSerialNumber) {
      this.outSerialNumber = outSerialNumber;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setApproveRecordId(final Long approveRecordId) {
      this.approveRecordId = approveRecordId;
   }

   public void setWmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ConvertDTO)) {
         return false;
      }

      ConvertDTO other = (ConvertDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$materialInventoryId = this.getMaterialInventoryId();
         Object other$materialInventoryId = other.getMaterialInventoryId();
         if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$status = this.getStatus();
                  Object other$status = other.getStatus();
                  if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                     Object this$applyUserId = this.getApplyUserId();
                     Object other$applyUserId = other.getApplyUserId();
                     if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
                        Object this$reviewerId = this.getReviewerId();
                        Object other$reviewerId = other.getReviewerId();
                        if (this$reviewerId == null ? other$reviewerId == null : this$reviewerId.equals(other$reviewerId)) {
                           Object this$classifyId = this.getClassifyId();
                           Object other$classifyId = other.getClassifyId();
                           if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                              Object this$boolPartyA = this.getBoolPartyA();
                              Object other$boolPartyA = other.getBoolPartyA();
                              if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                 Object this$approveRecordId = this.getApproveRecordId();
                                 Object other$approveRecordId = other.getApproveRecordId();
                                 if (this$approveRecordId == null ? other$approveRecordId == null : this$approveRecordId.equals(other$approveRecordId)) {
                                    Object this$receiptSerialNumber = this.getReceiptSerialNumber();
                                    Object other$receiptSerialNumber = other.getReceiptSerialNumber();
                                    if (this$receiptSerialNumber == null
                                       ? other$receiptSerialNumber == null
                                       : this$receiptSerialNumber.equals(other$receiptSerialNumber)) {
                                       Object this$brand = this.getBrand();
                                       Object other$brand = other.getBrand();
                                       if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                          Object this$specification = this.getSpecification();
                                          Object other$specification = other.getSpecification();
                                          if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$width = this.getWidth();
                                                Object other$width = other.getWidth();
                                                if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                   Object this$thickness = this.getThickness();
                                                   Object other$thickness = other.getThickness();
                                                   if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                         Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                         if (this$heatNoAndBatchNo == null
                                                            ? other$heatNoAndBatchNo == null
                                                            : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                            Object this$classifyName = this.getClassifyName();
                                                            Object other$classifyName = other.getClassifyName();
                                                            if (this$classifyName == null
                                                               ? other$classifyName == null
                                                               : this$classifyName.equals(other$classifyName)) {
                                                               Object this$warehouse = this.getWarehouse();
                                                               Object other$warehouse = other.getWarehouse();
                                                               if (this$warehouse == null ? other$warehouse == null : this$warehouse.equals(other$warehouse)) {
                                                                  Object this$project = this.getProject();
                                                                  Object other$project = other.getProject();
                                                                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                     Object this$applyUserName = this.getApplyUserName();
                                                                     Object other$applyUserName = other.getApplyUserName();
                                                                     if (this$applyUserName == null
                                                                        ? other$applyUserName == null
                                                                        : this$applyUserName.equals(other$applyUserName)) {
                                                                        Object this$applyTime = this.getApplyTime();
                                                                        Object other$applyTime = other.getApplyTime();
                                                                        if (this$applyTime == null
                                                                           ? other$applyTime == null
                                                                           : this$applyTime.equals(other$applyTime)) {
                                                                           Object this$reviewerName = this.getReviewerName();
                                                                           Object other$reviewerName = other.getReviewerName();
                                                                           if (this$reviewerName == null
                                                                              ? other$reviewerName == null
                                                                              : this$reviewerName.equals(other$reviewerName)) {
                                                                              Object this$reviewTime = this.getReviewTime();
                                                                              Object other$reviewTime = other.getReviewTime();
                                                                              if (this$reviewTime == null
                                                                                 ? other$reviewTime == null
                                                                                 : this$reviewTime.equals(other$reviewTime)) {
                                                                                 Object this$remark = this.getRemark();
                                                                                 Object other$remark = other.getRemark();
                                                                                 if (this$remark == null
                                                                                    ? other$remark == null
                                                                                    : this$remark.equals(other$remark)) {
                                                                                    Object this$convertDetailDTOList = this.getConvertDetailDTOList();
                                                                                    Object other$convertDetailDTOList = other.getConvertDetailDTOList();
                                                                                    if (this$convertDetailDTOList == null
                                                                                       ? other$convertDetailDTOList == null
                                                                                       : this$convertDetailDTOList.equals(other$convertDetailDTOList)) {
                                                                                       Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                                       Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                                       if (this$amountExcludingVat == null
                                                                                          ? other$amountExcludingVat == null
                                                                                          : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                                          Object this$quantity = this.getQuantity();
                                                                                          Object other$quantity = other.getQuantity();
                                                                                          if (this$quantity == null
                                                                                             ? other$quantity == null
                                                                                             : this$quantity.equals(other$quantity)) {
                                                                                             Object this$mete = this.getMete();
                                                                                             Object other$mete = other.getMete();
                                                                                             if (this$mete == null
                                                                                                ? other$mete == null
                                                                                                : this$mete.equals(other$mete)) {
                                                                                                Object this$outSerialNumber = this.getOutSerialNumber();
                                                                                                Object other$outSerialNumber = other.getOutSerialNumber();
                                                                                                if (this$outSerialNumber == null
                                                                                                   ? other$outSerialNumber == null
                                                                                                   : this$outSerialNumber.equals(other$outSerialNumber)) {
                                                                                                   Object this$wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
                                                                                                   Object other$wmsApproveRecordFlowDTO = other.getWmsApproveRecordFlowDTO();
                                                                                                   return this$wmsApproveRecordFlowDTO == null
                                                                                                      ? other$wmsApproveRecordFlowDTO == null
                                                                                                      : this$wmsApproveRecordFlowDTO.equals(
                                                                                                         other$wmsApproveRecordFlowDTO
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ConvertDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $reviewerId = this.getReviewerId();
      result = result * 59 + ($reviewerId == null ? 43 : $reviewerId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $approveRecordId = this.getApproveRecordId();
      result = result * 59 + ($approveRecordId == null ? 43 : $approveRecordId.hashCode());
      Object $receiptSerialNumber = this.getReceiptSerialNumber();
      result = result * 59 + ($receiptSerialNumber == null ? 43 : $receiptSerialNumber.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $applyTime = this.getApplyTime();
      result = result * 59 + ($applyTime == null ? 43 : $applyTime.hashCode());
      Object $reviewerName = this.getReviewerName();
      result = result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $convertDetailDTOList = this.getConvertDetailDTOList();
      result = result * 59 + ($convertDetailDTOList == null ? 43 : $convertDetailDTOList.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $outSerialNumber = this.getOutSerialNumber();
      result = result * 59 + ($outSerialNumber == null ? 43 : $outSerialNumber.hashCode());
      Object $wmsApproveRecordFlowDTO = this.getWmsApproveRecordFlowDTO();
      return result * 59 + ($wmsApproveRecordFlowDTO == null ? 43 : $wmsApproveRecordFlowDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ConvertDTO(id="
         + this.getId()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", receiptSerialNumber="
         + this.getReceiptSerialNumber()
         + ", brand="
         + this.getBrand()
         + ", specification="
         + this.getSpecification()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", color="
         + this.getColor()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", classifyName="
         + this.getClassifyName()
         + ", projectId="
         + this.getProjectId()
         + ", warehouse="
         + this.getWarehouse()
         + ", project="
         + this.getProject()
         + ", status="
         + this.getStatus()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", applyTime="
         + this.getApplyTime()
         + ", reviewerId="
         + this.getReviewerId()
         + ", reviewerName="
         + this.getReviewerName()
         + ", reviewTime="
         + this.getReviewTime()
         + ", remark="
         + this.getRemark()
         + ", convertDetailDTOList="
         + this.getConvertDetailDTOList()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", quantity="
         + this.getQuantity()
         + ", mete="
         + this.getMete()
         + ", classifyId="
         + this.getClassifyId()
         + ", outSerialNumber="
         + this.getOutSerialNumber()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", approveRecordId="
         + this.getApproveRecordId()
         + ", wmsApproveRecordFlowDTO="
         + this.getWmsApproveRecordFlowDTO()
         + ")";
   }

   public ConvertDTO(
      final Long id,
      final Long materialInventoryId,
      final String receiptSerialNumber,
      final String brand,
      final String specification,
      final String serialNumber,
      final BigDecimal width,
      final BigDecimal thickness,
      final String color,
      final String heatNoAndBatchNo,
      final Long warehouseId,
      final String classifyName,
      final Long projectId,
      final BriefIdAndNameDTO warehouse,
      final ProjectInfo project,
      final Integer status,
      final Long applyUserId,
      final String applyUserName,
      final LocalDate applyTime,
      final Long reviewerId,
      final String reviewerName,
      final LocalDateTime reviewTime,
      final String remark,
      final List<ConvertDetailDTO> convertDetailDTOList,
      final BigDecimal amountExcludingVat,
      final BigDecimal quantity,
      final BigDecimal mete,
      final Long classifyId,
      final String outSerialNumber,
      final Boolean boolPartyA,
      final Long approveRecordId,
      final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO
   ) {
      this.id = id;
      this.materialInventoryId = materialInventoryId;
      this.receiptSerialNumber = receiptSerialNumber;
      this.brand = brand;
      this.specification = specification;
      this.serialNumber = serialNumber;
      this.width = width;
      this.thickness = thickness;
      this.color = color;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.warehouseId = warehouseId;
      this.classifyName = classifyName;
      this.projectId = projectId;
      this.warehouse = warehouse;
      this.project = project;
      this.status = status;
      this.applyUserId = applyUserId;
      this.applyUserName = applyUserName;
      this.applyTime = applyTime;
      this.reviewerId = reviewerId;
      this.reviewerName = reviewerName;
      this.reviewTime = reviewTime;
      this.remark = remark;
      this.convertDetailDTOList = convertDetailDTOList;
      this.amountExcludingVat = amountExcludingVat;
      this.quantity = quantity;
      this.mete = mete;
      this.classifyId = classifyId;
      this.outSerialNumber = outSerialNumber;
      this.boolPartyA = boolPartyA;
      this.approveRecordId = approveRecordId;
      this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
   }

   public ConvertDTO() {
   }

   public static class ConvertDTOBuilder {
      private Long id;
      private Long materialInventoryId;
      private String receiptSerialNumber;
      private String brand;
      private String specification;
      private String serialNumber;
      private BigDecimal width;
      private BigDecimal thickness;
      private String color;
      private String heatNoAndBatchNo;
      private Long warehouseId;
      private String classifyName;
      private Long projectId;
      private BriefIdAndNameDTO warehouse;
      private ProjectInfo project;
      private Integer status;
      private Long applyUserId;
      private String applyUserName;
      private LocalDate applyTime;
      private Long reviewerId;
      private String reviewerName;
      private LocalDateTime reviewTime;
      private String remark;
      private List<ConvertDetailDTO> convertDetailDTOList;
      private BigDecimal amountExcludingVat;
      private BigDecimal quantity;
      private BigDecimal mete;
      private Long classifyId;
      private String outSerialNumber;
      private Boolean boolPartyA;
      private Long approveRecordId;
      private WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO;

      ConvertDTOBuilder() {
      }

      public ConvertDTO.ConvertDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder receiptSerialNumber(final String receiptSerialNumber) {
         this.receiptSerialNumber = receiptSerialNumber;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder applyUserId(final Long applyUserId) {
         this.applyUserId = applyUserId;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder applyUserName(final String applyUserName) {
         this.applyUserName = applyUserName;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder applyTime(final LocalDate applyTime) {
         this.applyTime = applyTime;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder reviewerId(final Long reviewerId) {
         this.reviewerId = reviewerId;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder convertDetailDTOList(final List<ConvertDetailDTO> convertDetailDTOList) {
         this.convertDetailDTOList = convertDetailDTOList;
         return this;
      }

      @JsonProperty("amountExcludingVat")
      public ConvertDTO.ConvertDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      @JsonProperty("quantity")
      public ConvertDTO.ConvertDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("mete")
      public ConvertDTO.ConvertDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder outSerialNumber(final String outSerialNumber) {
         this.outSerialNumber = outSerialNumber;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder approveRecordId(final Long approveRecordId) {
         this.approveRecordId = approveRecordId;
         return this;
      }

      public ConvertDTO.ConvertDTOBuilder wmsApproveRecordFlowDTO(final WmsApproveRecordFlowDTO wmsApproveRecordFlowDTO) {
         this.wmsApproveRecordFlowDTO = wmsApproveRecordFlowDTO;
         return this;
      }

      public ConvertDTO build() {
         return new ConvertDTO(
            this.id,
            this.materialInventoryId,
            this.receiptSerialNumber,
            this.brand,
            this.specification,
            this.serialNumber,
            this.width,
            this.thickness,
            this.color,
            this.heatNoAndBatchNo,
            this.warehouseId,
            this.classifyName,
            this.projectId,
            this.warehouse,
            this.project,
            this.status,
            this.applyUserId,
            this.applyUserName,
            this.applyTime,
            this.reviewerId,
            this.reviewerName,
            this.reviewTime,
            this.remark,
            this.convertDetailDTOList,
            this.amountExcludingVat,
            this.quantity,
            this.mete,
            this.classifyId,
            this.outSerialNumber,
            this.boolPartyA,
            this.approveRecordId,
            this.wmsApproveRecordFlowDTO
         );
      }

      @Override
      public String toString() {
         return "ConvertDTO.ConvertDTOBuilder(id="
            + this.id
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", receiptSerialNumber="
            + this.receiptSerialNumber
            + ", brand="
            + this.brand
            + ", specification="
            + this.specification
            + ", serialNumber="
            + this.serialNumber
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", color="
            + this.color
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", warehouseId="
            + this.warehouseId
            + ", classifyName="
            + this.classifyName
            + ", projectId="
            + this.projectId
            + ", warehouse="
            + this.warehouse
            + ", project="
            + this.project
            + ", status="
            + this.status
            + ", applyUserId="
            + this.applyUserId
            + ", applyUserName="
            + this.applyUserName
            + ", applyTime="
            + this.applyTime
            + ", reviewerId="
            + this.reviewerId
            + ", reviewerName="
            + this.reviewerName
            + ", reviewTime="
            + this.reviewTime
            + ", remark="
            + this.remark
            + ", convertDetailDTOList="
            + this.convertDetailDTOList
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ", classifyId="
            + this.classifyId
            + ", outSerialNumber="
            + this.outSerialNumber
            + ", boolPartyA="
            + this.boolPartyA
            + ", approveRecordId="
            + this.approveRecordId
            + ", wmsApproveRecordFlowDTO="
            + this.wmsApproveRecordFlowDTO
            + ")";
      }
   }
}
