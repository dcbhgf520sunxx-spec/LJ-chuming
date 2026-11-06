package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class WmsShipmentReceiveApproveDetailDTO {
   @ApiModelProperty(name = "id", value = "主键")
   private Long id;
   @ApiModelProperty(name = "shipmentReceiveApproveId", value = "发运领用出库审核单ID")
   private Long shipmentReceiveApproveId;
   @ApiModelProperty(name = "detailId", value = "配套件明细的ID")
   private Long detailId;
   @ApiModelProperty(name = "detailName", value = "配套件名称")
   private String detailName;
   @ApiModelProperty(name = "outId", value = "关联出库单ID")
   private Long outId;
   @ApiModelProperty(name = "outDetailId", value = "关联出库明细ID")
   private Long outDetailId;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   private Integer basicClass;
   @ApiModelProperty(name = "classifyId", value = "科目ID")
   private Long classifyId;
   @ApiModelProperty(name = "outSpecification", value = "出库规格")
   private String outSpecification;
   @ApiModelProperty(name = "outLength", value = "出库物料单个长度")
   private BigDecimal outLength;
   @ApiModelProperty(name = "outWidth", value = "出库物料单个宽度")
   private BigDecimal outWidth;
   @ApiModelProperty(name = "outThickness", value = "出库物料单个厚度")
   private BigDecimal outThickness;
   @ApiModelProperty(name = "outBrand", value = "出库品牌")
   private String outBrand;
   @ApiModelProperty(name = "outColor", value = "出库颜色")
   private String outColor;
   @ApiModelProperty(name = "outHeatNoAndBatchNo", value = "出库炉批号")
   private String outHeatNoAndBatchNo;
   @ApiModelProperty(name = "outBoolPartyA", value = "是否为甲供")
   private Boolean outBoolPartyA;
   @ApiModelProperty(name = "outTheoryThickness", value = "出库理论厚")
   private BigDecimal outTheoryThickness;
   @ApiModelProperty(name = "outStandardId", value = "出库型材执行的国标")
   private Long outStandardId;
   @ApiModelProperty(name = "outStandardName", value = "出库型材执行的国标")
   private String outStandardName;
   @ApiModelProperty(name = "outMaterialSn", value = "出库物料编号")
   private String outMaterialSn;
   @ApiModelProperty(name = "outbound", value = ",出库单")
   private IdAndNameDTO outbound;
   @ApiModelProperty(name = "project", value = ",项目信息")
   private ProjectInfo project;
   @ApiModelProperty("发运领用车间信息")
   private IdAndNameDTO mesWorkshop;
   @ApiModelProperty("物料存储仓库")
   private IdAndNameDTO workshop;
   @ApiModelProperty("物料存储仓库位置")
   private IdAndNameDTO warehouse;
   @ApiModelProperty("出库目的地")
   private Integer outboundAddress;
   @ApiModelProperty("领用人名称")
   private String recipientName;
   @ApiModelProperty("出库数量")
   private BigDecimal outQuantity;
   @ApiModelProperty("出库核算量")
   private BigDecimal outMete;
   @ApiModelProperty("备注")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public Long getShipmentReceiveApproveId() {
      return this.shipmentReceiveApproveId;
   }

   public Long getDetailId() {
      return this.detailId;
   }

   public String getDetailName() {
      return this.detailName;
   }

   public Long getOutId() {
      return this.outId;
   }

   public Long getOutDetailId() {
      return this.outDetailId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getOutSpecification() {
      return this.outSpecification;
   }

   public BigDecimal getOutLength() {
      return this.outLength;
   }

   public BigDecimal getOutWidth() {
      return this.outWidth;
   }

   public BigDecimal getOutThickness() {
      return this.outThickness;
   }

   public String getOutBrand() {
      return this.outBrand;
   }

   public String getOutColor() {
      return this.outColor;
   }

   public String getOutHeatNoAndBatchNo() {
      return this.outHeatNoAndBatchNo;
   }

   public Boolean getOutBoolPartyA() {
      return this.outBoolPartyA;
   }

   public BigDecimal getOutTheoryThickness() {
      return this.outTheoryThickness;
   }

   public Long getOutStandardId() {
      return this.outStandardId;
   }

   public String getOutStandardName() {
      return this.outStandardName;
   }

   public String getOutMaterialSn() {
      return this.outMaterialSn;
   }

   public IdAndNameDTO getOutbound() {
      return this.outbound;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public IdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public IdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public IdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public Integer getOutboundAddress() {
      return this.outboundAddress;
   }

   public String getRecipientName() {
      return this.recipientName;
   }

   public BigDecimal getOutQuantity() {
      return this.outQuantity;
   }

   public BigDecimal getOutMete() {
      return this.outMete;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setShipmentReceiveApproveId(final Long shipmentReceiveApproveId) {
      this.shipmentReceiveApproveId = shipmentReceiveApproveId;
   }

   public void setDetailId(final Long detailId) {
      this.detailId = detailId;
   }

   public void setDetailName(final String detailName) {
      this.detailName = detailName;
   }

   public void setOutId(final Long outId) {
      this.outId = outId;
   }

   public void setOutDetailId(final Long outDetailId) {
      this.outDetailId = outDetailId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setOutSpecification(final String outSpecification) {
      this.outSpecification = outSpecification;
   }

   public void setOutLength(final BigDecimal outLength) {
      this.outLength = outLength;
   }

   public void setOutWidth(final BigDecimal outWidth) {
      this.outWidth = outWidth;
   }

   public void setOutThickness(final BigDecimal outThickness) {
      this.outThickness = outThickness;
   }

   public void setOutBrand(final String outBrand) {
      this.outBrand = outBrand;
   }

   public void setOutColor(final String outColor) {
      this.outColor = outColor;
   }

   public void setOutHeatNoAndBatchNo(final String outHeatNoAndBatchNo) {
      this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
   }

   public void setOutBoolPartyA(final Boolean outBoolPartyA) {
      this.outBoolPartyA = outBoolPartyA;
   }

   public void setOutTheoryThickness(final BigDecimal outTheoryThickness) {
      this.outTheoryThickness = outTheoryThickness;
   }

   public void setOutStandardId(final Long outStandardId) {
      this.outStandardId = outStandardId;
   }

   public void setOutStandardName(final String outStandardName) {
      this.outStandardName = outStandardName;
   }

   public void setOutMaterialSn(final String outMaterialSn) {
      this.outMaterialSn = outMaterialSn;
   }

   public void setOutbound(final IdAndNameDTO outbound) {
      this.outbound = outbound;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMesWorkshop(final IdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setWorkshop(final IdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final IdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setOutboundAddress(final Integer outboundAddress) {
      this.outboundAddress = outboundAddress;
   }

   public void setRecipientName(final String recipientName) {
      this.recipientName = recipientName;
   }

   public void setOutQuantity(final BigDecimal outQuantity) {
      this.outQuantity = outQuantity;
   }

   public void setOutMete(final BigDecimal outMete) {
      this.outMete = outMete;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsShipmentReceiveApproveDetailDTO)) {
         return false;
      }

      WmsShipmentReceiveApproveDetailDTO other = (WmsShipmentReceiveApproveDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$shipmentReceiveApproveId = this.getShipmentReceiveApproveId();
         Object other$shipmentReceiveApproveId = other.getShipmentReceiveApproveId();
         if (this$shipmentReceiveApproveId == null
            ? other$shipmentReceiveApproveId == null
            : this$shipmentReceiveApproveId.equals(other$shipmentReceiveApproveId)) {
            Object this$detailId = this.getDetailId();
            Object other$detailId = other.getDetailId();
            if (this$detailId == null ? other$detailId == null : this$detailId.equals(other$detailId)) {
               Object this$outId = this.getOutId();
               Object other$outId = other.getOutId();
               if (this$outId == null ? other$outId == null : this$outId.equals(other$outId)) {
                  Object this$outDetailId = this.getOutDetailId();
                  Object other$outDetailId = other.getOutDetailId();
                  if (this$outDetailId == null ? other$outDetailId == null : this$outDetailId.equals(other$outDetailId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$basicClass = this.getBasicClass();
                        Object other$basicClass = other.getBasicClass();
                        if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                           Object this$classifyId = this.getClassifyId();
                           Object other$classifyId = other.getClassifyId();
                           if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                              Object this$outBoolPartyA = this.getOutBoolPartyA();
                              Object other$outBoolPartyA = other.getOutBoolPartyA();
                              if (this$outBoolPartyA == null ? other$outBoolPartyA == null : this$outBoolPartyA.equals(other$outBoolPartyA)) {
                                 Object this$outStandardId = this.getOutStandardId();
                                 Object other$outStandardId = other.getOutStandardId();
                                 if (this$outStandardId == null ? other$outStandardId == null : this$outStandardId.equals(other$outStandardId)) {
                                    Object this$outboundAddress = this.getOutboundAddress();
                                    Object other$outboundAddress = other.getOutboundAddress();
                                    if (this$outboundAddress == null ? other$outboundAddress == null : this$outboundAddress.equals(other$outboundAddress)) {
                                       Object this$detailName = this.getDetailName();
                                       Object other$detailName = other.getDetailName();
                                       if (this$detailName == null ? other$detailName == null : this$detailName.equals(other$detailName)) {
                                          Object this$outSpecification = this.getOutSpecification();
                                          Object other$outSpecification = other.getOutSpecification();
                                          if (this$outSpecification == null
                                             ? other$outSpecification == null
                                             : this$outSpecification.equals(other$outSpecification)) {
                                             Object this$outLength = this.getOutLength();
                                             Object other$outLength = other.getOutLength();
                                             if (this$outLength == null ? other$outLength == null : this$outLength.equals(other$outLength)) {
                                                Object this$outWidth = this.getOutWidth();
                                                Object other$outWidth = other.getOutWidth();
                                                if (this$outWidth == null ? other$outWidth == null : this$outWidth.equals(other$outWidth)) {
                                                   Object this$outThickness = this.getOutThickness();
                                                   Object other$outThickness = other.getOutThickness();
                                                   if (this$outThickness == null ? other$outThickness == null : this$outThickness.equals(other$outThickness)) {
                                                      Object this$outBrand = this.getOutBrand();
                                                      Object other$outBrand = other.getOutBrand();
                                                      if (this$outBrand == null ? other$outBrand == null : this$outBrand.equals(other$outBrand)) {
                                                         Object this$outColor = this.getOutColor();
                                                         Object other$outColor = other.getOutColor();
                                                         if (this$outColor == null ? other$outColor == null : this$outColor.equals(other$outColor)) {
                                                            Object this$outHeatNoAndBatchNo = this.getOutHeatNoAndBatchNo();
                                                            Object other$outHeatNoAndBatchNo = other.getOutHeatNoAndBatchNo();
                                                            if (this$outHeatNoAndBatchNo == null
                                                               ? other$outHeatNoAndBatchNo == null
                                                               : this$outHeatNoAndBatchNo.equals(other$outHeatNoAndBatchNo)) {
                                                               Object this$outTheoryThickness = this.getOutTheoryThickness();
                                                               Object other$outTheoryThickness = other.getOutTheoryThickness();
                                                               if (this$outTheoryThickness == null
                                                                  ? other$outTheoryThickness == null
                                                                  : this$outTheoryThickness.equals(other$outTheoryThickness)) {
                                                                  Object this$outStandardName = this.getOutStandardName();
                                                                  Object other$outStandardName = other.getOutStandardName();
                                                                  if (this$outStandardName == null
                                                                     ? other$outStandardName == null
                                                                     : this$outStandardName.equals(other$outStandardName)) {
                                                                     Object this$outMaterialSn = this.getOutMaterialSn();
                                                                     Object other$outMaterialSn = other.getOutMaterialSn();
                                                                     if (this$outMaterialSn == null
                                                                        ? other$outMaterialSn == null
                                                                        : this$outMaterialSn.equals(other$outMaterialSn)) {
                                                                        Object this$outbound = this.getOutbound();
                                                                        Object other$outbound = other.getOutbound();
                                                                        if (this$outbound == null
                                                                           ? other$outbound == null
                                                                           : this$outbound.equals(other$outbound)) {
                                                                           Object this$project = this.getProject();
                                                                           Object other$project = other.getProject();
                                                                           if (this$project == null
                                                                              ? other$project == null
                                                                              : this$project.equals(other$project)) {
                                                                              Object this$mesWorkshop = this.getMesWorkshop();
                                                                              Object other$mesWorkshop = other.getMesWorkshop();
                                                                              if (this$mesWorkshop == null
                                                                                 ? other$mesWorkshop == null
                                                                                 : this$mesWorkshop.equals(other$mesWorkshop)) {
                                                                                 Object this$workshop = this.getWorkshop();
                                                                                 Object other$workshop = other.getWorkshop();
                                                                                 if (this$workshop == null
                                                                                    ? other$workshop == null
                                                                                    : this$workshop.equals(other$workshop)) {
                                                                                    Object this$warehouse = this.getWarehouse();
                                                                                    Object other$warehouse = other.getWarehouse();
                                                                                    if (this$warehouse == null
                                                                                       ? other$warehouse == null
                                                                                       : this$warehouse.equals(other$warehouse)) {
                                                                                       Object this$recipientName = this.getRecipientName();
                                                                                       Object other$recipientName = other.getRecipientName();
                                                                                       if (this$recipientName == null
                                                                                          ? other$recipientName == null
                                                                                          : this$recipientName.equals(other$recipientName)) {
                                                                                          Object this$outQuantity = this.getOutQuantity();
                                                                                          Object other$outQuantity = other.getOutQuantity();
                                                                                          if (this$outQuantity == null
                                                                                             ? other$outQuantity == null
                                                                                             : this$outQuantity.equals(other$outQuantity)) {
                                                                                             Object this$outMete = this.getOutMete();
                                                                                             Object other$outMete = other.getOutMete();
                                                                                             if (this$outMete == null
                                                                                                ? other$outMete == null
                                                                                                : this$outMete.equals(other$outMete)) {
                                                                                                Object this$remark = this.getRemark();
                                                                                                Object other$remark = other.getRemark();
                                                                                                return this$remark == null
                                                                                                   ? other$remark == null
                                                                                                   : this$remark.equals(other$remark);
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
      return other instanceof WmsShipmentReceiveApproveDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $shipmentReceiveApproveId = this.getShipmentReceiveApproveId();
      result = result * 59 + ($shipmentReceiveApproveId == null ? 43 : $shipmentReceiveApproveId.hashCode());
      Object $detailId = this.getDetailId();
      result = result * 59 + ($detailId == null ? 43 : $detailId.hashCode());
      Object $outId = this.getOutId();
      result = result * 59 + ($outId == null ? 43 : $outId.hashCode());
      Object $outDetailId = this.getOutDetailId();
      result = result * 59 + ($outDetailId == null ? 43 : $outDetailId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $outBoolPartyA = this.getOutBoolPartyA();
      result = result * 59 + ($outBoolPartyA == null ? 43 : $outBoolPartyA.hashCode());
      Object $outStandardId = this.getOutStandardId();
      result = result * 59 + ($outStandardId == null ? 43 : $outStandardId.hashCode());
      Object $outboundAddress = this.getOutboundAddress();
      result = result * 59 + ($outboundAddress == null ? 43 : $outboundAddress.hashCode());
      Object $detailName = this.getDetailName();
      result = result * 59 + ($detailName == null ? 43 : $detailName.hashCode());
      Object $outSpecification = this.getOutSpecification();
      result = result * 59 + ($outSpecification == null ? 43 : $outSpecification.hashCode());
      Object $outLength = this.getOutLength();
      result = result * 59 + ($outLength == null ? 43 : $outLength.hashCode());
      Object $outWidth = this.getOutWidth();
      result = result * 59 + ($outWidth == null ? 43 : $outWidth.hashCode());
      Object $outThickness = this.getOutThickness();
      result = result * 59 + ($outThickness == null ? 43 : $outThickness.hashCode());
      Object $outBrand = this.getOutBrand();
      result = result * 59 + ($outBrand == null ? 43 : $outBrand.hashCode());
      Object $outColor = this.getOutColor();
      result = result * 59 + ($outColor == null ? 43 : $outColor.hashCode());
      Object $outHeatNoAndBatchNo = this.getOutHeatNoAndBatchNo();
      result = result * 59 + ($outHeatNoAndBatchNo == null ? 43 : $outHeatNoAndBatchNo.hashCode());
      Object $outTheoryThickness = this.getOutTheoryThickness();
      result = result * 59 + ($outTheoryThickness == null ? 43 : $outTheoryThickness.hashCode());
      Object $outStandardName = this.getOutStandardName();
      result = result * 59 + ($outStandardName == null ? 43 : $outStandardName.hashCode());
      Object $outMaterialSn = this.getOutMaterialSn();
      result = result * 59 + ($outMaterialSn == null ? 43 : $outMaterialSn.hashCode());
      Object $outbound = this.getOutbound();
      result = result * 59 + ($outbound == null ? 43 : $outbound.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $recipientName = this.getRecipientName();
      result = result * 59 + ($recipientName == null ? 43 : $recipientName.hashCode());
      Object $outQuantity = this.getOutQuantity();
      result = result * 59 + ($outQuantity == null ? 43 : $outQuantity.hashCode());
      Object $outMete = this.getOutMete();
      result = result * 59 + ($outMete == null ? 43 : $outMete.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "WmsShipmentReceiveApproveDetailDTO(id="
         + this.getId()
         + ", shipmentReceiveApproveId="
         + this.getShipmentReceiveApproveId()
         + ", detailId="
         + this.getDetailId()
         + ", detailName="
         + this.getDetailName()
         + ", outId="
         + this.getOutId()
         + ", outDetailId="
         + this.getOutDetailId()
         + ", projectId="
         + this.getProjectId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", outSpecification="
         + this.getOutSpecification()
         + ", outLength="
         + this.getOutLength()
         + ", outWidth="
         + this.getOutWidth()
         + ", outThickness="
         + this.getOutThickness()
         + ", outBrand="
         + this.getOutBrand()
         + ", outColor="
         + this.getOutColor()
         + ", outHeatNoAndBatchNo="
         + this.getOutHeatNoAndBatchNo()
         + ", outBoolPartyA="
         + this.getOutBoolPartyA()
         + ", outTheoryThickness="
         + this.getOutTheoryThickness()
         + ", outStandardId="
         + this.getOutStandardId()
         + ", outStandardName="
         + this.getOutStandardName()
         + ", outMaterialSn="
         + this.getOutMaterialSn()
         + ", outbound="
         + this.getOutbound()
         + ", project="
         + this.getProject()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", outboundAddress="
         + this.getOutboundAddress()
         + ", recipientName="
         + this.getRecipientName()
         + ", outQuantity="
         + this.getOutQuantity()
         + ", outMete="
         + this.getOutMete()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public WmsShipmentReceiveApproveDetailDTO(
      final Long id,
      final Long shipmentReceiveApproveId,
      final Long detailId,
      final String detailName,
      final Long outId,
      final Long outDetailId,
      final Long projectId,
      final Integer basicClass,
      final Long classifyId,
      final String outSpecification,
      final BigDecimal outLength,
      final BigDecimal outWidth,
      final BigDecimal outThickness,
      final String outBrand,
      final String outColor,
      final String outHeatNoAndBatchNo,
      final Boolean outBoolPartyA,
      final BigDecimal outTheoryThickness,
      final Long outStandardId,
      final String outStandardName,
      final String outMaterialSn,
      final IdAndNameDTO outbound,
      final ProjectInfo project,
      final IdAndNameDTO mesWorkshop,
      final IdAndNameDTO workshop,
      final IdAndNameDTO warehouse,
      final Integer outboundAddress,
      final String recipientName,
      final BigDecimal outQuantity,
      final BigDecimal outMete,
      final String remark
   ) {
      this.id = id;
      this.shipmentReceiveApproveId = shipmentReceiveApproveId;
      this.detailId = detailId;
      this.detailName = detailName;
      this.outId = outId;
      this.outDetailId = outDetailId;
      this.projectId = projectId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.outSpecification = outSpecification;
      this.outLength = outLength;
      this.outWidth = outWidth;
      this.outThickness = outThickness;
      this.outBrand = outBrand;
      this.outColor = outColor;
      this.outHeatNoAndBatchNo = outHeatNoAndBatchNo;
      this.outBoolPartyA = outBoolPartyA;
      this.outTheoryThickness = outTheoryThickness;
      this.outStandardId = outStandardId;
      this.outStandardName = outStandardName;
      this.outMaterialSn = outMaterialSn;
      this.outbound = outbound;
      this.project = project;
      this.mesWorkshop = mesWorkshop;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.outboundAddress = outboundAddress;
      this.recipientName = recipientName;
      this.outQuantity = outQuantity;
      this.outMete = outMete;
      this.remark = remark;
   }

   public WmsShipmentReceiveApproveDetailDTO() {
   }
}
