package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.common.core.api.pojo.common.IdAndNameDTO;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class WmsPickingDetailDTO {
   @ApiModelProperty("领料详情ID")
   private Long id;
   @ApiModelProperty("领料ID")
   private Long pickingId;
   @ApiModelProperty("工单号")
   private String taskOrderNumber;
   @ApiModelProperty("领料类型")
   private String pickingType;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("厚度")
   private BigDecimal thick;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("单位")
   private String unit;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("领料量")
   private BigDecimal pickingAmount;
   @ApiModelProperty("办理量")
   private BigDecimal volume;
   @ApiModelProperty("领料面积")
   private BigDecimal pickingArea;
   @ApiModelProperty("办理面积")
   private BigDecimal handlingArea;
   @ApiModelProperty("领料长度")
   private BigDecimal pickingLength;
   @ApiModelProperty("办理长度")
   private BigDecimal handlingLength;
   @ApiModelProperty("工单ID")
   private Long taskOrderId;
   @ApiModelProperty("本次办理核算量")
   private BigDecimal nowMete;
   @ApiModelProperty("本次办理面积（钢板）")
   private BigDecimal nowArea;
   @ApiModelProperty("本次办理长度（型材）")
   private BigDecimal nowLength;
   @ApiModelProperty("是否齐套")
   private Boolean boolComplete;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("车间信息")
   private IdAndNameDTO mesWorkshop;
   private List<WmsPickingDetailDTO> wmsPickingDetailDTOList;
   @ApiModelProperty("领料审核详情信息")
   private List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOList;

   public static WmsPickingDetailDTO.WmsPickingDetailDTOBuilder builder() {
      return new WmsPickingDetailDTO.WmsPickingDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getPickingId() {
      return this.pickingId;
   }

   public String getTaskOrderNumber() {
      return this.taskOrderNumber;
   }

   public String getPickingType() {
      return this.pickingType;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getThick() {
      return this.thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getPickingAmount() {
      return this.pickingAmount;
   }

   public BigDecimal getVolume() {
      return this.volume;
   }

   public BigDecimal getPickingArea() {
      return this.pickingArea;
   }

   public BigDecimal getHandlingArea() {
      return this.handlingArea;
   }

   public BigDecimal getPickingLength() {
      return this.pickingLength;
   }

   public BigDecimal getHandlingLength() {
      return this.handlingLength;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public BigDecimal getNowMete() {
      return this.nowMete;
   }

   public BigDecimal getNowArea() {
      return this.nowArea;
   }

   public BigDecimal getNowLength() {
      return this.nowLength;
   }

   public Boolean getBoolComplete() {
      return this.boolComplete;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public IdAndNameDTO getMesWorkshop() {
      return this.mesWorkshop;
   }

   public List<WmsPickingDetailDTO> getWmsPickingDetailDTOList() {
      return this.wmsPickingDetailDTOList;
   }

   public List<WmsPickingApproveDetailDTO> getWmsPickingApproveDetailDTOList() {
      return this.wmsPickingApproveDetailDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPickingId(final Long pickingId) {
      this.pickingId = pickingId;
   }

   public void setTaskOrderNumber(final String taskOrderNumber) {
      this.taskOrderNumber = taskOrderNumber;
   }

   public void setPickingType(final String pickingType) {
      this.pickingType = pickingType;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setThick(final BigDecimal thick) {
      this.thick = thick;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setPickingAmount(final BigDecimal pickingAmount) {
      this.pickingAmount = pickingAmount;
   }

   public void setVolume(final BigDecimal volume) {
      this.volume = volume;
   }

   public void setPickingArea(final BigDecimal pickingArea) {
      this.pickingArea = pickingArea;
   }

   public void setHandlingArea(final BigDecimal handlingArea) {
      this.handlingArea = handlingArea;
   }

   public void setPickingLength(final BigDecimal pickingLength) {
      this.pickingLength = pickingLength;
   }

   public void setHandlingLength(final BigDecimal handlingLength) {
      this.handlingLength = handlingLength;
   }

   public void setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
   }

   public void setNowMete(final BigDecimal nowMete) {
      this.nowMete = nowMete;
   }

   public void setNowArea(final BigDecimal nowArea) {
      this.nowArea = nowArea;
   }

   public void setNowLength(final BigDecimal nowLength) {
      this.nowLength = nowLength;
   }

   public void setBoolComplete(final Boolean boolComplete) {
      this.boolComplete = boolComplete;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMesWorkshop(final IdAndNameDTO mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setWmsPickingDetailDTOList(final List<WmsPickingDetailDTO> wmsPickingDetailDTOList) {
      this.wmsPickingDetailDTOList = wmsPickingDetailDTOList;
   }

   public void setWmsPickingApproveDetailDTOList(final List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOList) {
      this.wmsPickingApproveDetailDTOList = wmsPickingApproveDetailDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WmsPickingDetailDTO)) {
         return false;
      }

      WmsPickingDetailDTO other = (WmsPickingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pickingId = this.getPickingId();
         Object other$pickingId = other.getPickingId();
         if (this$pickingId == null ? other$pickingId == null : this$pickingId.equals(other$pickingId)) {
            Object this$taskOrderId = this.getTaskOrderId();
            Object other$taskOrderId = other.getTaskOrderId();
            if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
               Object this$boolComplete = this.getBoolComplete();
               Object other$boolComplete = other.getBoolComplete();
               if (this$boolComplete == null ? other$boolComplete == null : this$boolComplete.equals(other$boolComplete)) {
                  Object this$taskOrderNumber = this.getTaskOrderNumber();
                  Object other$taskOrderNumber = other.getTaskOrderNumber();
                  if (this$taskOrderNumber == null ? other$taskOrderNumber == null : this$taskOrderNumber.equals(other$taskOrderNumber)) {
                     Object this$pickingType = this.getPickingType();
                     Object other$pickingType = other.getPickingType();
                     if (this$pickingType == null ? other$pickingType == null : this$pickingType.equals(other$pickingType)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$thick = this.getThick();
                           Object other$thick = other.getThick();
                           if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                 Object this$unit = this.getUnit();
                                 Object other$unit = other.getUnit();
                                 if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$pickingAmount = this.getPickingAmount();
                                       Object other$pickingAmount = other.getPickingAmount();
                                       if (this$pickingAmount == null ? other$pickingAmount == null : this$pickingAmount.equals(other$pickingAmount)) {
                                          Object this$volume = this.getVolume();
                                          Object other$volume = other.getVolume();
                                          if (this$volume == null ? other$volume == null : this$volume.equals(other$volume)) {
                                             Object this$pickingArea = this.getPickingArea();
                                             Object other$pickingArea = other.getPickingArea();
                                             if (this$pickingArea == null ? other$pickingArea == null : this$pickingArea.equals(other$pickingArea)) {
                                                Object this$handlingArea = this.getHandlingArea();
                                                Object other$handlingArea = other.getHandlingArea();
                                                if (this$handlingArea == null ? other$handlingArea == null : this$handlingArea.equals(other$handlingArea)) {
                                                   Object this$pickingLength = this.getPickingLength();
                                                   Object other$pickingLength = other.getPickingLength();
                                                   if (this$pickingLength == null
                                                      ? other$pickingLength == null
                                                      : this$pickingLength.equals(other$pickingLength)) {
                                                      Object this$handlingLength = this.getHandlingLength();
                                                      Object other$handlingLength = other.getHandlingLength();
                                                      if (this$handlingLength == null
                                                         ? other$handlingLength == null
                                                         : this$handlingLength.equals(other$handlingLength)) {
                                                         Object this$nowMete = this.getNowMete();
                                                         Object other$nowMete = other.getNowMete();
                                                         if (this$nowMete == null ? other$nowMete == null : this$nowMete.equals(other$nowMete)) {
                                                            Object this$nowArea = this.getNowArea();
                                                            Object other$nowArea = other.getNowArea();
                                                            if (this$nowArea == null ? other$nowArea == null : this$nowArea.equals(other$nowArea)) {
                                                               Object this$nowLength = this.getNowLength();
                                                               Object other$nowLength = other.getNowLength();
                                                               if (this$nowLength == null ? other$nowLength == null : this$nowLength.equals(other$nowLength)) {
                                                                  Object this$project = this.getProject();
                                                                  Object other$project = other.getProject();
                                                                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                                                     Object this$mesWorkshop = this.getMesWorkshop();
                                                                     Object other$mesWorkshop = other.getMesWorkshop();
                                                                     if (this$mesWorkshop == null
                                                                        ? other$mesWorkshop == null
                                                                        : this$mesWorkshop.equals(other$mesWorkshop)) {
                                                                        Object this$wmsPickingDetailDTOList = this.getWmsPickingDetailDTOList();
                                                                        Object other$wmsPickingDetailDTOList = other.getWmsPickingDetailDTOList();
                                                                        if (this$wmsPickingDetailDTOList == null
                                                                           ? other$wmsPickingDetailDTOList == null
                                                                           : this$wmsPickingDetailDTOList.equals(other$wmsPickingDetailDTOList)) {
                                                                           Object this$wmsPickingApproveDetailDTOList = this.getWmsPickingApproveDetailDTOList();
                                                                           Object other$wmsPickingApproveDetailDTOList = other.getWmsPickingApproveDetailDTOList();
                                                                           return this$wmsPickingApproveDetailDTOList == null
                                                                              ? other$wmsPickingApproveDetailDTOList == null
                                                                              : this$wmsPickingApproveDetailDTOList.equals(other$wmsPickingApproveDetailDTOList);
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
      return other instanceof WmsPickingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pickingId = this.getPickingId();
      result = result * 59 + ($pickingId == null ? 43 : $pickingId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $boolComplete = this.getBoolComplete();
      result = result * 59 + ($boolComplete == null ? 43 : $boolComplete.hashCode());
      Object $taskOrderNumber = this.getTaskOrderNumber();
      result = result * 59 + ($taskOrderNumber == null ? 43 : $taskOrderNumber.hashCode());
      Object $pickingType = this.getPickingType();
      result = result * 59 + ($pickingType == null ? 43 : $pickingType.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $pickingAmount = this.getPickingAmount();
      result = result * 59 + ($pickingAmount == null ? 43 : $pickingAmount.hashCode());
      Object $volume = this.getVolume();
      result = result * 59 + ($volume == null ? 43 : $volume.hashCode());
      Object $pickingArea = this.getPickingArea();
      result = result * 59 + ($pickingArea == null ? 43 : $pickingArea.hashCode());
      Object $handlingArea = this.getHandlingArea();
      result = result * 59 + ($handlingArea == null ? 43 : $handlingArea.hashCode());
      Object $pickingLength = this.getPickingLength();
      result = result * 59 + ($pickingLength == null ? 43 : $pickingLength.hashCode());
      Object $handlingLength = this.getHandlingLength();
      result = result * 59 + ($handlingLength == null ? 43 : $handlingLength.hashCode());
      Object $nowMete = this.getNowMete();
      result = result * 59 + ($nowMete == null ? 43 : $nowMete.hashCode());
      Object $nowArea = this.getNowArea();
      result = result * 59 + ($nowArea == null ? 43 : $nowArea.hashCode());
      Object $nowLength = this.getNowLength();
      result = result * 59 + ($nowLength == null ? 43 : $nowLength.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $wmsPickingDetailDTOList = this.getWmsPickingDetailDTOList();
      result = result * 59 + ($wmsPickingDetailDTOList == null ? 43 : $wmsPickingDetailDTOList.hashCode());
      Object $wmsPickingApproveDetailDTOList = this.getWmsPickingApproveDetailDTOList();
      return result * 59 + ($wmsPickingApproveDetailDTOList == null ? 43 : $wmsPickingApproveDetailDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "WmsPickingDetailDTO(id="
         + this.getId()
         + ", pickingId="
         + this.getPickingId()
         + ", taskOrderNumber="
         + this.getTaskOrderNumber()
         + ", pickingType="
         + this.getPickingType()
         + ", specification="
         + this.getSpecification()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", unit="
         + this.getUnit()
         + ", quantity="
         + this.getQuantity()
         + ", pickingAmount="
         + this.getPickingAmount()
         + ", volume="
         + this.getVolume()
         + ", pickingArea="
         + this.getPickingArea()
         + ", handlingArea="
         + this.getHandlingArea()
         + ", pickingLength="
         + this.getPickingLength()
         + ", handlingLength="
         + this.getHandlingLength()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", nowMete="
         + this.getNowMete()
         + ", nowArea="
         + this.getNowArea()
         + ", nowLength="
         + this.getNowLength()
         + ", boolComplete="
         + this.getBoolComplete()
         + ", project="
         + this.getProject()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", wmsPickingDetailDTOList="
         + this.getWmsPickingDetailDTOList()
         + ", wmsPickingApproveDetailDTOList="
         + this.getWmsPickingApproveDetailDTOList()
         + ")";
   }

   public WmsPickingDetailDTO(
      final Long id,
      final Long pickingId,
      final String taskOrderNumber,
      final String pickingType,
      final String specification,
      final BigDecimal thick,
      final String material,
      final String unit,
      final BigDecimal quantity,
      final BigDecimal pickingAmount,
      final BigDecimal volume,
      final BigDecimal pickingArea,
      final BigDecimal handlingArea,
      final BigDecimal pickingLength,
      final BigDecimal handlingLength,
      final Long taskOrderId,
      final BigDecimal nowMete,
      final BigDecimal nowArea,
      final BigDecimal nowLength,
      final Boolean boolComplete,
      final ProjectInfo project,
      final IdAndNameDTO mesWorkshop,
      final List<WmsPickingDetailDTO> wmsPickingDetailDTOList,
      final List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOList
   ) {
      this.id = id;
      this.pickingId = pickingId;
      this.taskOrderNumber = taskOrderNumber;
      this.pickingType = pickingType;
      this.specification = specification;
      this.thick = thick;
      this.material = material;
      this.unit = unit;
      this.quantity = quantity;
      this.pickingAmount = pickingAmount;
      this.volume = volume;
      this.pickingArea = pickingArea;
      this.handlingArea = handlingArea;
      this.pickingLength = pickingLength;
      this.handlingLength = handlingLength;
      this.taskOrderId = taskOrderId;
      this.nowMete = nowMete;
      this.nowArea = nowArea;
      this.nowLength = nowLength;
      this.boolComplete = boolComplete;
      this.project = project;
      this.mesWorkshop = mesWorkshop;
      this.wmsPickingDetailDTOList = wmsPickingDetailDTOList;
      this.wmsPickingApproveDetailDTOList = wmsPickingApproveDetailDTOList;
   }

   public WmsPickingDetailDTO() {
   }

   public static class WmsPickingDetailDTOBuilder {
      private Long id;
      private Long pickingId;
      private String taskOrderNumber;
      private String pickingType;
      private String specification;
      private BigDecimal thick;
      private String material;
      private String unit;
      private BigDecimal quantity;
      private BigDecimal pickingAmount;
      private BigDecimal volume;
      private BigDecimal pickingArea;
      private BigDecimal handlingArea;
      private BigDecimal pickingLength;
      private BigDecimal handlingLength;
      private Long taskOrderId;
      private BigDecimal nowMete;
      private BigDecimal nowArea;
      private BigDecimal nowLength;
      private Boolean boolComplete;
      private ProjectInfo project;
      private IdAndNameDTO mesWorkshop;
      private List<WmsPickingDetailDTO> wmsPickingDetailDTOList;
      private List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOList;

      WmsPickingDetailDTOBuilder() {
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder pickingId(final Long pickingId) {
         this.pickingId = pickingId;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder taskOrderNumber(final String taskOrderNumber) {
         this.taskOrderNumber = taskOrderNumber;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder pickingType(final String pickingType) {
         this.pickingType = pickingType;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder thick(final BigDecimal thick) {
         this.thick = thick;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder unit(final String unit) {
         this.unit = unit;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder pickingAmount(final BigDecimal pickingAmount) {
         this.pickingAmount = pickingAmount;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder volume(final BigDecimal volume) {
         this.volume = volume;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder pickingArea(final BigDecimal pickingArea) {
         this.pickingArea = pickingArea;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder handlingArea(final BigDecimal handlingArea) {
         this.handlingArea = handlingArea;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder pickingLength(final BigDecimal pickingLength) {
         this.pickingLength = pickingLength;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder handlingLength(final BigDecimal handlingLength) {
         this.handlingLength = handlingLength;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder nowMete(final BigDecimal nowMete) {
         this.nowMete = nowMete;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder nowArea(final BigDecimal nowArea) {
         this.nowArea = nowArea;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder nowLength(final BigDecimal nowLength) {
         this.nowLength = nowLength;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder boolComplete(final Boolean boolComplete) {
         this.boolComplete = boolComplete;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder mesWorkshop(final IdAndNameDTO mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder wmsPickingDetailDTOList(final List<WmsPickingDetailDTO> wmsPickingDetailDTOList) {
         this.wmsPickingDetailDTOList = wmsPickingDetailDTOList;
         return this;
      }

      public WmsPickingDetailDTO.WmsPickingDetailDTOBuilder wmsPickingApproveDetailDTOList(
         final List<WmsPickingApproveDetailDTO> wmsPickingApproveDetailDTOList
      ) {
         this.wmsPickingApproveDetailDTOList = wmsPickingApproveDetailDTOList;
         return this;
      }

      public WmsPickingDetailDTO build() {
         return new WmsPickingDetailDTO(
            this.id,
            this.pickingId,
            this.taskOrderNumber,
            this.pickingType,
            this.specification,
            this.thick,
            this.material,
            this.unit,
            this.quantity,
            this.pickingAmount,
            this.volume,
            this.pickingArea,
            this.handlingArea,
            this.pickingLength,
            this.handlingLength,
            this.taskOrderId,
            this.nowMete,
            this.nowArea,
            this.nowLength,
            this.boolComplete,
            this.project,
            this.mesWorkshop,
            this.wmsPickingDetailDTOList,
            this.wmsPickingApproveDetailDTOList
         );
      }

      @Override
      public String toString() {
         return "WmsPickingDetailDTO.WmsPickingDetailDTOBuilder(id="
            + this.id
            + ", pickingId="
            + this.pickingId
            + ", taskOrderNumber="
            + this.taskOrderNumber
            + ", pickingType="
            + this.pickingType
            + ", specification="
            + this.specification
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", unit="
            + this.unit
            + ", quantity="
            + this.quantity
            + ", pickingAmount="
            + this.pickingAmount
            + ", volume="
            + this.volume
            + ", pickingArea="
            + this.pickingArea
            + ", handlingArea="
            + this.handlingArea
            + ", pickingLength="
            + this.pickingLength
            + ", handlingLength="
            + this.handlingLength
            + ", taskOrderId="
            + this.taskOrderId
            + ", nowMete="
            + this.nowMete
            + ", nowArea="
            + this.nowArea
            + ", nowLength="
            + this.nowLength
            + ", boolComplete="
            + this.boolComplete
            + ", project="
            + this.project
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", wmsPickingDetailDTOList="
            + this.wmsPickingDetailDTOList
            + ", wmsPickingApproveDetailDTOList="
            + this.wmsPickingApproveDetailDTOList
            + ")";
      }
   }
}
