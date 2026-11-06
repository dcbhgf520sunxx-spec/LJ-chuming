package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class WmsPickingApproveDetailDTO {
   @ApiModelProperty(name = "id", value = "主键")
   private Long id;
   @ApiModelProperty(name = "pickingApproveId", value = "领料排产出库审核单ID")
   private Long pickingApproveId;
   @ApiModelProperty(name = "pickingId", value = "领料单ID")
   private Long pickingId;
   @ApiModelProperty(name = "pickingDetailId", value = "领料明细")
   private Long pickingDetailId;
   @ApiModelProperty(name = "outId", value = "关联出库单ID")
   private Long outId;
   @ApiModelProperty(name = "outDetailId", value = "关联出库明细ID")
   private Long outDetailId;
   @ApiModelProperty(name = "projectId", value = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "pickingDetailMaterial", value = "领料材质")
   private String pickingDetailMaterial;
   @ApiModelProperty(name = "pickingDetailSpecification", value = "领料规格")
   private String pickingDetailSpecification;
   @ApiModelProperty(name = "pickingDetailThickness", value = "领料厚度")
   private BigDecimal pickingDetailThickness;
   @ApiModelProperty(name = "pickingOutSumQuantity", value = "当前领料单关联出库明细总量")
   private BigDecimal pickingOutSumQuantity;
   @ApiModelProperty(name = "pickingOutSumMete", value = "当前领料单关联出库明细总核算量(g)")
   private BigDecimal pickingOutSumMete;
   @ApiModelProperty(name = "pickingOutSumArea", value = "当前领料单关联出库明细总面积(㎜²)")
   private BigDecimal pickingOutSumArea;
   @ApiModelProperty(name = "pickingOutSumLength", value = "当前领料单关联出库明细总长度(㎜)")
   private BigDecimal pickingOutSumLength;
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
   @ApiModelProperty(name = "boolProcess", value = "是否报工 0未报工 1已报工")
   private String boolProcess;
   @ApiModelProperty(name = "picking", value = ",领料单工单号")
   private IdAndNameDTO picking;
   @ApiModelProperty(name = "outbound", value = ",出库单")
   private IdAndNameDTO outbound;
   @ApiModelProperty(name = "project", value = ",项目信息")
   private ProjectInfo project;
   private BigDecimal actualTheoryWeight;

   public Long getId() {
      return this.id;
   }

   public Long getPickingApproveId() {
      return this.pickingApproveId;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public Long getPickingDetailId() {
      return this.pickingDetailId;
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

   public String getPickingDetailMaterial() {
      return this.pickingDetailMaterial;
   }

   public String getPickingDetailSpecification() {
      return this.pickingDetailSpecification;
   }

   public BigDecimal getPickingDetailThickness() {
      return this.pickingDetailThickness;
   }

   public BigDecimal getPickingOutSumQuantity() {
      return this.pickingOutSumQuantity;
   }

   public BigDecimal getPickingOutSumMete() {
      return this.pickingOutSumMete;
   }

   public BigDecimal getPickingOutSumArea() {
      return this.pickingOutSumArea;
   }

   public BigDecimal getPickingOutSumLength() {
      return this.pickingOutSumLength;
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

   public String getBoolProcess() {
      return this.boolProcess;
   }

   public IdAndNameDTO getPicking() {
      return this.picking;
   }

   public IdAndNameDTO getOutbound() {
      return this.outbound;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public BigDecimal getActualTheoryWeight() {
      return this.actualTheoryWeight;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPickingApproveId(final Long pickingApproveId) {
      this.pickingApproveId = pickingApproveId;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setPickingDetailId(final Long pickingDetailId) {
      this.pickingDetailId = pickingDetailId;
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

   public void setPickingDetailMaterial(final String pickingDetailMaterial) {
      this.pickingDetailMaterial = pickingDetailMaterial;
   }

   public void setPickingDetailSpecification(final String pickingDetailSpecification) {
      this.pickingDetailSpecification = pickingDetailSpecification;
   }

   public void setPickingDetailThickness(final BigDecimal pickingDetailThickness) {
      this.pickingDetailThickness = pickingDetailThickness;
   }

   public void setPickingOutSumQuantity(final BigDecimal pickingOutSumQuantity) {
      this.pickingOutSumQuantity = pickingOutSumQuantity;
   }

   public void setPickingOutSumMete(final BigDecimal pickingOutSumMete) {
      this.pickingOutSumMete = pickingOutSumMete;
   }

   public void setPickingOutSumArea(final BigDecimal pickingOutSumArea) {
      this.pickingOutSumArea = pickingOutSumArea;
   }

   public void setPickingOutSumLength(final BigDecimal pickingOutSumLength) {
      this.pickingOutSumLength = pickingOutSumLength;
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

   public void setBoolProcess(final String boolProcess) {
      this.boolProcess = boolProcess;
   }

   public void setPicking(final IdAndNameDTO picking) {
      this.picking = picking;
   }

   public void setOutbound(final IdAndNameDTO outbound) {
      this.outbound = outbound;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setActualTheoryWeight(final BigDecimal actualTheoryWeight) {
      this.actualTheoryWeight = actualTheoryWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingApproveDetailDTO)) {
         return false;
      }

      WmsPickingApproveDetailDTO other = (WmsPickingApproveDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pickingApproveId = this.getPickingApproveId();
         Object other$pickingApproveId = other.getPickingApproveId();
         if (this$pickingApproveId == null ? other$pickingApproveId == null : this$pickingApproveId.equals(other$pickingApproveId)) {
            Object this$pickingId = this.getPickingId();
            Object other$pickingId = other.getPickingId();
            if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
               Object this$pickingDetailId = this.getPickingDetailId();
               Object other$pickingDetailId = other.getPickingDetailId();
               if (this$pickingDetailId == null ? other$pickingDetailId == null : this$pickingDetailId.equals(other$pickingDetailId)) {
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
                                       Object this$pickingDetailMaterial = this.getPickingDetailMaterial();
                                       Object other$pickingDetailMaterial = other.getPickingDetailMaterial();
                                       if (this$pickingDetailMaterial == null
                                          ? other$pickingDetailMaterial == null
                                          : this$pickingDetailMaterial.equals(other$pickingDetailMaterial)) {
                                          Object this$pickingDetailSpecification = this.getPickingDetailSpecification();
                                          Object other$pickingDetailSpecification = other.getPickingDetailSpecification();
                                          if (this$pickingDetailSpecification == null
                                             ? other$pickingDetailSpecification == null
                                             : this$pickingDetailSpecification.equals(other$pickingDetailSpecification)) {
                                             Object this$pickingDetailThickness = this.getPickingDetailThickness();
                                             Object other$pickingDetailThickness = other.getPickingDetailThickness();
                                             if (this$pickingDetailThickness == null
                                                ? other$pickingDetailThickness == null
                                                : this$pickingDetailThickness.equals(other$pickingDetailThickness)) {
                                                Object this$pickingOutSumQuantity = this.getPickingOutSumQuantity();
                                                Object other$pickingOutSumQuantity = other.getPickingOutSumQuantity();
                                                if (this$pickingOutSumQuantity == null
                                                   ? other$pickingOutSumQuantity == null
                                                   : this$pickingOutSumQuantity.equals(other$pickingOutSumQuantity)) {
                                                   Object this$pickingOutSumMete = this.getPickingOutSumMete();
                                                   Object other$pickingOutSumMete = other.getPickingOutSumMete();
                                                   if (this$pickingOutSumMete == null
                                                      ? other$pickingOutSumMete == null
                                                      : this$pickingOutSumMete.equals(other$pickingOutSumMete)) {
                                                      Object this$pickingOutSumArea = this.getPickingOutSumArea();
                                                      Object other$pickingOutSumArea = other.getPickingOutSumArea();
                                                      if (this$pickingOutSumArea == null
                                                         ? other$pickingOutSumArea == null
                                                         : this$pickingOutSumArea.equals(other$pickingOutSumArea)) {
                                                         Object this$pickingOutSumLength = this.getPickingOutSumLength();
                                                         Object other$pickingOutSumLength = other.getPickingOutSumLength();
                                                         if (this$pickingOutSumLength == null
                                                            ? other$pickingOutSumLength == null
                                                            : this$pickingOutSumLength.equals(other$pickingOutSumLength)) {
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
                                                                     if (this$outThickness == null
                                                                        ? other$outThickness == null
                                                                        : this$outThickness.equals(other$outThickness)) {
                                                                        Object this$outBrand = this.getOutBrand();
                                                                        Object other$outBrand = other.getOutBrand();
                                                                        if (this$outBrand == null
                                                                           ? other$outBrand == null
                                                                           : this$outBrand.equals(other$outBrand)) {
                                                                           Object this$outColor = this.getOutColor();
                                                                           Object other$outColor = other.getOutColor();
                                                                           if (this$outColor == null
                                                                              ? other$outColor == null
                                                                              : this$outColor.equals(other$outColor)) {
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
                                                                                          Object this$boolProcess = this.getBoolProcess();
                                                                                          Object other$boolProcess = other.getBoolProcess();
                                                                                          if (this$boolProcess == null
                                                                                             ? other$boolProcess == null
                                                                                             : this$boolProcess.equals(other$boolProcess)) {
                                                                                             Object this$picking = this.getPicking();
                                                                                             Object other$picking = other.getPicking();
                                                                                             if (this$picking == null
                                                                                                ? other$picking == null
                                                                                                : this$picking.equals(other$picking)) {
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
                                                                                                      Object this$actualTheoryWeight = this.getActualTheoryWeight();
                                                                                                      Object other$actualTheoryWeight = other.getActualTheoryWeight();
                                                                                                      return this$actualTheoryWeight == null
                                                                                                         ? other$actualTheoryWeight == null
                                                                                                         : this$actualTheoryWeight.equals(
                                                                                                            other$actualTheoryWeight
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WmsPickingApproveDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pickingApproveId = this.getPickingApproveId();
      result = result * 59 + ($pickingApproveId == null ? 43 : $pickingApproveId.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $pickingDetailId = this.getPickingDetailId();
      result = result * 59 + ($pickingDetailId == null ? 43 : $pickingDetailId.hashCode());
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
      Object $pickingDetailMaterial = this.getPickingDetailMaterial();
      result = result * 59 + ($pickingDetailMaterial == null ? 43 : $pickingDetailMaterial.hashCode());
      Object $pickingDetailSpecification = this.getPickingDetailSpecification();
      result = result * 59 + ($pickingDetailSpecification == null ? 43 : $pickingDetailSpecification.hashCode());
      Object $pickingDetailThickness = this.getPickingDetailThickness();
      result = result * 59 + ($pickingDetailThickness == null ? 43 : $pickingDetailThickness.hashCode());
      Object $pickingOutSumQuantity = this.getPickingOutSumQuantity();
      result = result * 59 + ($pickingOutSumQuantity == null ? 43 : $pickingOutSumQuantity.hashCode());
      Object $pickingOutSumMete = this.getPickingOutSumMete();
      result = result * 59 + ($pickingOutSumMete == null ? 43 : $pickingOutSumMete.hashCode());
      Object $pickingOutSumArea = this.getPickingOutSumArea();
      result = result * 59 + ($pickingOutSumArea == null ? 43 : $pickingOutSumArea.hashCode());
      Object $pickingOutSumLength = this.getPickingOutSumLength();
      result = result * 59 + ($pickingOutSumLength == null ? 43 : $pickingOutSumLength.hashCode());
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
      Object $boolProcess = this.getBoolProcess();
      result = result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
      Object $picking = this.getPicking();
      result = result * 59 + ($picking == null ? 43 : $picking.hashCode());
      Object $outbound = this.getOutbound();
      result = result * 59 + ($outbound == null ? 43 : $outbound.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $actualTheoryWeight = this.getActualTheoryWeight();
      return result * 59 + ($actualTheoryWeight == null ? 43 : $actualTheoryWeight.hashCode());
   }

   @Override
   public String toString() {
      return "WmsPickingApproveDetailDTO(id="
         + this.getId()
         + ", pickingApproveId="
         + this.getPickingApproveId()
         + ", pickingId="
         + this.getPickingId()
         + ", pickingDetailId="
         + this.getPickingDetailId()
         + ", outId="
         + this.getOutId()
         + ", outDetailId="
         + this.getOutDetailId()
         + ", projectId="
         + this.getProjectId()
         + ", pickingDetailMaterial="
         + this.getPickingDetailMaterial()
         + ", pickingDetailSpecification="
         + this.getPickingDetailSpecification()
         + ", pickingDetailThickness="
         + this.getPickingDetailThickness()
         + ", pickingOutSumQuantity="
         + this.getPickingOutSumQuantity()
         + ", pickingOutSumMete="
         + this.getPickingOutSumMete()
         + ", pickingOutSumArea="
         + this.getPickingOutSumArea()
         + ", pickingOutSumLength="
         + this.getPickingOutSumLength()
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
         + ", boolProcess="
         + this.getBoolProcess()
         + ", picking="
         + this.getPicking()
         + ", outbound="
         + this.getOutbound()
         + ", project="
         + this.getProject()
         + ", actualTheoryWeight="
         + this.getActualTheoryWeight()
         + ")";
   }

   public WmsPickingApproveDetailDTO(
      final Long id,
      final Long pickingApproveId,
      final Long pickingId,
      final Long pickingDetailId,
      final Long outId,
      final Long outDetailId,
      final Long projectId,
      final String pickingDetailMaterial,
      final String pickingDetailSpecification,
      final BigDecimal pickingDetailThickness,
      final BigDecimal pickingOutSumQuantity,
      final BigDecimal pickingOutSumMete,
      final BigDecimal pickingOutSumArea,
      final BigDecimal pickingOutSumLength,
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
      final String boolProcess,
      final IdAndNameDTO picking,
      final IdAndNameDTO outbound,
      final ProjectInfo project,
      final BigDecimal actualTheoryWeight
   ) {
      this.id = id;
      this.pickingApproveId = pickingApproveId;
      this.pickingId = pickingId;
      this.pickingDetailId = pickingDetailId;
      this.outId = outId;
      this.outDetailId = outDetailId;
      this.projectId = projectId;
      this.pickingDetailMaterial = pickingDetailMaterial;
      this.pickingDetailSpecification = pickingDetailSpecification;
      this.pickingDetailThickness = pickingDetailThickness;
      this.pickingOutSumQuantity = pickingOutSumQuantity;
      this.pickingOutSumMete = pickingOutSumMete;
      this.pickingOutSumArea = pickingOutSumArea;
      this.pickingOutSumLength = pickingOutSumLength;
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
      this.boolProcess = boolProcess;
      this.picking = picking;
      this.outbound = outbound;
      this.project = project;
      this.actualTheoryWeight = actualTheoryWeight;
   }

   public WmsPickingApproveDetailDTO() {
   }
}
