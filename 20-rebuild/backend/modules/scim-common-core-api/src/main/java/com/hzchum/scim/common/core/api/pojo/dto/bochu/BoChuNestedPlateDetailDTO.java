package com.hzchum.scim.common.core.api.pojo.dto.bochu;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApiModel("柏楚套料板详情DTO")
public class BoChuNestedPlateDetailDTO {
   @JsonProperty("task_plate_id")
   @Alias("task_plate_id")
   private Integer taskPlateId;
   @JsonProperty("guid")
   @Alias("guid")
   private String guid;
   @JsonProperty("result_name")
   @Alias("result_name")
   private String resultName;
   @JsonProperty("amount")
   @Alias("amount")
   private Integer amount;
   @JsonProperty("part_amount")
   @Alias("part_amount")
   private BigDecimal partAmount;
   @JsonProperty("in_cut_amount")
   @Alias("in_cut_amount")
   private BigDecimal inCutAmount;
   @JsonProperty("finish_cut_amount")
   @Alias("finish_cut_amount")
   private BigDecimal finishCutAmount;
   @JsonProperty("part_in_cut_amount")
   @Alias("part_in_cut_amount")
   private BigDecimal partInCutAmount;
   @JsonProperty("part_finish_cut_amount")
   @Alias("part_finish_cut_amount")
   private BigDecimal partFinishCutAmount;
   @JsonProperty("plate_guid")
   @Alias("plate_guid")
   private String plateGuid;
   @JsonProperty("plate_name")
   @Alias("plate_name")
   private String plateName;
   @JsonProperty("plate_idx")
   @Alias("plate_idx")
   private BigDecimal plateIdx;
   @JsonProperty("utilization")
   @Alias("utilization")
   private BigDecimal utilization;
   @JsonProperty("thickness")
   @Alias("thickness")
   private BigDecimal thickness;
   @JsonProperty("plate_library")
   @Alias("plate_library")
   private BoChuNestedPlateDetailDTO.PlateLibraryDTO plateLibrary;
   @JsonProperty("parts")
   @Alias("parts")
   private List<BoChuNestedPlateDetailDTO.PartDTO> partList;

   public Integer getTaskPlateId() {
      return this.taskPlateId;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getResultName() {
      return this.resultName;
   }

   public Integer getAmount() {
      return this.amount;
   }

   public BigDecimal getPartAmount() {
      return this.partAmount;
   }

   public BigDecimal getInCutAmount() {
      return this.inCutAmount;
   }

   public BigDecimal getFinishCutAmount() {
      return this.finishCutAmount;
   }

   public BigDecimal getPartInCutAmount() {
      return this.partInCutAmount;
   }

   public BigDecimal getPartFinishCutAmount() {
      return this.partFinishCutAmount;
   }

   public String getPlateGuid() {
      return this.plateGuid;
   }

   public String getPlateName() {
      return this.plateName;
   }

   public BigDecimal getPlateIdx() {
      return this.plateIdx;
   }

   public BigDecimal getUtilization() {
      return this.utilization;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BoChuNestedPlateDetailDTO.PlateLibraryDTO getPlateLibrary() {
      return this.plateLibrary;
   }

   public List<BoChuNestedPlateDetailDTO.PartDTO> getPartList() {
      return this.partList;
   }

   @JsonProperty("task_plate_id")
   public void setTaskPlateId(final Integer taskPlateId) {
      this.taskPlateId = taskPlateId;
   }

   @JsonProperty("guid")
   public void setGuid(final String guid) {
      this.guid = guid;
   }

   @JsonProperty("result_name")
   public void setResultName(final String resultName) {
      this.resultName = resultName;
   }

   @JsonProperty("amount")
   public void setAmount(final Integer amount) {
      this.amount = amount;
   }

   @JsonProperty("part_amount")
   public void setPartAmount(final BigDecimal partAmount) {
      this.partAmount = partAmount;
   }

   @JsonProperty("in_cut_amount")
   public void setInCutAmount(final BigDecimal inCutAmount) {
      this.inCutAmount = inCutAmount;
   }

   @JsonProperty("finish_cut_amount")
   public void setFinishCutAmount(final BigDecimal finishCutAmount) {
      this.finishCutAmount = finishCutAmount;
   }

   @JsonProperty("part_in_cut_amount")
   public void setPartInCutAmount(final BigDecimal partInCutAmount) {
      this.partInCutAmount = partInCutAmount;
   }

   @JsonProperty("part_finish_cut_amount")
   public void setPartFinishCutAmount(final BigDecimal partFinishCutAmount) {
      this.partFinishCutAmount = partFinishCutAmount;
   }

   @JsonProperty("plate_guid")
   public void setPlateGuid(final String plateGuid) {
      this.plateGuid = plateGuid;
   }

   @JsonProperty("plate_name")
   public void setPlateName(final String plateName) {
      this.plateName = plateName;
   }

   @JsonProperty("plate_idx")
   public void setPlateIdx(final BigDecimal plateIdx) {
      this.plateIdx = plateIdx;
   }

   @JsonProperty("utilization")
   public void setUtilization(final BigDecimal utilization) {
      this.utilization = utilization;
   }

   @JsonProperty("thickness")
   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   @JsonProperty("plate_library")
   public void setPlateLibrary(final BoChuNestedPlateDetailDTO.PlateLibraryDTO plateLibrary) {
      this.plateLibrary = plateLibrary;
   }

   @JsonProperty("parts")
   public void setPartList(final List<BoChuNestedPlateDetailDTO.PartDTO> partList) {
      this.partList = partList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuNestedPlateDetailDTO)) {
         return false;
      }

      BoChuNestedPlateDetailDTO other = (BoChuNestedPlateDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskPlateId = this.getTaskPlateId();
      Object other$taskPlateId = other.getTaskPlateId();
      if (this$taskPlateId == null ? other$taskPlateId == null : this$taskPlateId.equals(other$taskPlateId)) {
         Object this$amount = this.getAmount();
         Object other$amount = other.getAmount();
         if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
            Object this$guid = this.getGuid();
            Object other$guid = other.getGuid();
            if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
               Object this$resultName = this.getResultName();
               Object other$resultName = other.getResultName();
               if (this$resultName == null ? other$resultName == null : this$resultName.equals(other$resultName)) {
                  Object this$partAmount = this.getPartAmount();
                  Object other$partAmount = other.getPartAmount();
                  if (this$partAmount == null ? other$partAmount == null : this$partAmount.equals(other$partAmount)) {
                     Object this$inCutAmount = this.getInCutAmount();
                     Object other$inCutAmount = other.getInCutAmount();
                     if (this$inCutAmount == null ? other$inCutAmount == null : this$inCutAmount.equals(other$inCutAmount)) {
                        Object this$finishCutAmount = this.getFinishCutAmount();
                        Object other$finishCutAmount = other.getFinishCutAmount();
                        if (this$finishCutAmount == null ? other$finishCutAmount == null : this$finishCutAmount.equals(other$finishCutAmount)) {
                           Object this$partInCutAmount = this.getPartInCutAmount();
                           Object other$partInCutAmount = other.getPartInCutAmount();
                           if (this$partInCutAmount == null ? other$partInCutAmount == null : this$partInCutAmount.equals(other$partInCutAmount)) {
                              Object this$partFinishCutAmount = this.getPartFinishCutAmount();
                              Object other$partFinishCutAmount = other.getPartFinishCutAmount();
                              if (this$partFinishCutAmount == null
                                 ? other$partFinishCutAmount == null
                                 : this$partFinishCutAmount.equals(other$partFinishCutAmount)) {
                                 Object this$plateGuid = this.getPlateGuid();
                                 Object other$plateGuid = other.getPlateGuid();
                                 if (this$plateGuid == null ? other$plateGuid == null : this$plateGuid.equals(other$plateGuid)) {
                                    Object this$plateName = this.getPlateName();
                                    Object other$plateName = other.getPlateName();
                                    if (this$plateName == null ? other$plateName == null : this$plateName.equals(other$plateName)) {
                                       Object this$plateIdx = this.getPlateIdx();
                                       Object other$plateIdx = other.getPlateIdx();
                                       if (this$plateIdx == null ? other$plateIdx == null : this$plateIdx.equals(other$plateIdx)) {
                                          Object this$utilization = this.getUtilization();
                                          Object other$utilization = other.getUtilization();
                                          if (this$utilization == null ? other$utilization == null : this$utilization.equals(other$utilization)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                Object this$plateLibrary = this.getPlateLibrary();
                                                Object other$plateLibrary = other.getPlateLibrary();
                                                if (this$plateLibrary == null ? other$plateLibrary == null : this$plateLibrary.equals(other$plateLibrary)) {
                                                   Object this$partList = this.getPartList();
                                                   Object other$partList = other.getPartList();
                                                   return this$partList == null ? other$partList == null : this$partList.equals(other$partList);
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
      return other instanceof BoChuNestedPlateDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskPlateId = this.getTaskPlateId();
      result = result * 59 + ($taskPlateId == null ? 43 : $taskPlateId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $resultName = this.getResultName();
      result = result * 59 + ($resultName == null ? 43 : $resultName.hashCode());
      Object $partAmount = this.getPartAmount();
      result = result * 59 + ($partAmount == null ? 43 : $partAmount.hashCode());
      Object $inCutAmount = this.getInCutAmount();
      result = result * 59 + ($inCutAmount == null ? 43 : $inCutAmount.hashCode());
      Object $finishCutAmount = this.getFinishCutAmount();
      result = result * 59 + ($finishCutAmount == null ? 43 : $finishCutAmount.hashCode());
      Object $partInCutAmount = this.getPartInCutAmount();
      result = result * 59 + ($partInCutAmount == null ? 43 : $partInCutAmount.hashCode());
      Object $partFinishCutAmount = this.getPartFinishCutAmount();
      result = result * 59 + ($partFinishCutAmount == null ? 43 : $partFinishCutAmount.hashCode());
      Object $plateGuid = this.getPlateGuid();
      result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
      Object $plateName = this.getPlateName();
      result = result * 59 + ($plateName == null ? 43 : $plateName.hashCode());
      Object $plateIdx = this.getPlateIdx();
      result = result * 59 + ($plateIdx == null ? 43 : $plateIdx.hashCode());
      Object $utilization = this.getUtilization();
      result = result * 59 + ($utilization == null ? 43 : $utilization.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $plateLibrary = this.getPlateLibrary();
      result = result * 59 + ($plateLibrary == null ? 43 : $plateLibrary.hashCode());
      Object $partList = this.getPartList();
      return result * 59 + ($partList == null ? 43 : $partList.hashCode());
   }

   @Override
   public String toString() {
      return "BoChuNestedPlateDetailDTO(taskPlateId="
         + this.getTaskPlateId()
         + ", guid="
         + this.getGuid()
         + ", resultName="
         + this.getResultName()
         + ", amount="
         + this.getAmount()
         + ", partAmount="
         + this.getPartAmount()
         + ", inCutAmount="
         + this.getInCutAmount()
         + ", finishCutAmount="
         + this.getFinishCutAmount()
         + ", partInCutAmount="
         + this.getPartInCutAmount()
         + ", partFinishCutAmount="
         + this.getPartFinishCutAmount()
         + ", plateGuid="
         + this.getPlateGuid()
         + ", plateName="
         + this.getPlateName()
         + ", plateIdx="
         + this.getPlateIdx()
         + ", utilization="
         + this.getUtilization()
         + ", thickness="
         + this.getThickness()
         + ", plateLibrary="
         + this.getPlateLibrary()
         + ", partList="
         + this.getPartList()
         + ")";
   }

   public static class PartDTO {
      @JsonProperty("part_id")
      @Alias("part_id")
      private Integer partId;
      @JsonProperty("guid")
      @Alias("guid")
      private String guid;
      @JsonProperty("part_name")
      @Alias("part_name")
      private String partName;
      @JsonProperty("material")
      @Alias("material")
      private String material;
      @JsonProperty("thickness")
      @Alias("thickness")
      private BigDecimal thickness;
      @JsonProperty("drawing_name")
      @Alias("drawing_name")
      private String drawingName;
      @JsonProperty("drawing_guid")
      @Alias("drawing_guid")
      private String drawingGuid;
      @JsonProperty("job_id")
      @Alias("job_id")
      private Integer jobId;
      @JsonProperty("area")
      @Alias("area")
      private BigDecimal area;
      @JsonProperty("width")
      @Alias("width")
      private BigDecimal width;
      @JsonProperty("height")
      @Alias("height")
      private BigDecimal height;
      @JsonProperty("props")
      @Alias("props")
      private List<PropDTO> propList;
      private Map<String, Object> propMap;
      @JsonProperty("amount")
      @Alias("amount")
      private Integer amount;

      public Map<String, Object> getPropMap() {
         return CollUtil.isEmpty(this.propMap) && CollUtil.isNotEmpty(this.getPropList())
            ? this.getPropList().stream().collect(Collectors.toMap(PropDTO::getPropName, PropDTO::getPropValue))
            : this.propMap;
      }

      public Integer getPartId() {
         return this.partId;
      }

      public String getGuid() {
         return this.guid;
      }

      public String getPartName() {
         return this.partName;
      }

      public String getMaterial() {
         return this.material;
      }

      public BigDecimal getThickness() {
         return this.thickness;
      }

      public String getDrawingName() {
         return this.drawingName;
      }

      public String getDrawingGuid() {
         return this.drawingGuid;
      }

      public Integer getJobId() {
         return this.jobId;
      }

      public BigDecimal getArea() {
         return this.area;
      }

      public BigDecimal getWidth() {
         return this.width;
      }

      public BigDecimal getHeight() {
         return this.height;
      }

      public List<PropDTO> getPropList() {
         return this.propList;
      }

      public Integer getAmount() {
         return this.amount;
      }

      @JsonProperty("part_id")
      public void setPartId(final Integer partId) {
         this.partId = partId;
      }

      @JsonProperty("guid")
      public void setGuid(final String guid) {
         this.guid = guid;
      }

      @JsonProperty("part_name")
      public void setPartName(final String partName) {
         this.partName = partName;
      }

      @JsonProperty("material")
      public void setMaterial(final String material) {
         this.material = material;
      }

      @JsonProperty("thickness")
      public void setThickness(final BigDecimal thickness) {
         this.thickness = thickness;
      }

      @JsonProperty("drawing_name")
      public void setDrawingName(final String drawingName) {
         this.drawingName = drawingName;
      }

      @JsonProperty("drawing_guid")
      public void setDrawingGuid(final String drawingGuid) {
         this.drawingGuid = drawingGuid;
      }

      @JsonProperty("job_id")
      public void setJobId(final Integer jobId) {
         this.jobId = jobId;
      }

      @JsonProperty("area")
      public void setArea(final BigDecimal area) {
         this.area = area;
      }

      @JsonProperty("width")
      public void setWidth(final BigDecimal width) {
         this.width = width;
      }

      @JsonProperty("height")
      public void setHeight(final BigDecimal height) {
         this.height = height;
      }

      @JsonProperty("props")
      public void setPropList(final List<PropDTO> propList) {
         this.propList = propList;
      }

      public void setPropMap(final Map<String, Object> propMap) {
         this.propMap = propMap;
      }

      @JsonProperty("amount")
      public void setAmount(final Integer amount) {
         this.amount = amount;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof BoChuNestedPlateDetailDTO.PartDTO)) {
            return false;
         }

         BoChuNestedPlateDetailDTO.PartDTO other = (BoChuNestedPlateDetailDTO.PartDTO)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$partId = this.getPartId();
         Object other$partId = other.getPartId();
         if (this$partId == null ? other$partId == null : this$partId.equals(other$partId)) {
            Object this$jobId = this.getJobId();
            Object other$jobId = other.getJobId();
            if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                  Object this$guid = this.getGuid();
                  Object other$guid = other.getGuid();
                  if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                     Object this$partName = this.getPartName();
                     Object other$partName = other.getPartName();
                     if (this$partName == null ? other$partName == null : this$partName.equals(other$partName)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$thickness = this.getThickness();
                           Object other$thickness = other.getThickness();
                           if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                              Object this$drawingName = this.getDrawingName();
                              Object other$drawingName = other.getDrawingName();
                              if (this$drawingName == null ? other$drawingName == null : this$drawingName.equals(other$drawingName)) {
                                 Object this$drawingGuid = this.getDrawingGuid();
                                 Object other$drawingGuid = other.getDrawingGuid();
                                 if (this$drawingGuid == null ? other$drawingGuid == null : this$drawingGuid.equals(other$drawingGuid)) {
                                    Object this$area = this.getArea();
                                    Object other$area = other.getArea();
                                    if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                       Object this$width = this.getWidth();
                                       Object other$width = other.getWidth();
                                       if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                          Object this$height = this.getHeight();
                                          Object other$height = other.getHeight();
                                          if (this$height == null ? other$height == null : this$height.equals(other$height)) {
                                             Object this$propList = this.getPropList();
                                             Object other$propList = other.getPropList();
                                             if (this$propList == null ? other$propList == null : this$propList.equals(other$propList)) {
                                                Object this$propMap = this.getPropMap();
                                                Object other$propMap = other.getPropMap();
                                                return this$propMap == null ? other$propMap == null : this$propMap.equals(other$propMap);
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
         return other instanceof BoChuNestedPlateDetailDTO.PartDTO;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $partId = this.getPartId();
         result = result * 59 + ($partId == null ? 43 : $partId.hashCode());
         Object $jobId = this.getJobId();
         result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
         Object $amount = this.getAmount();
         result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
         Object $guid = this.getGuid();
         result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
         Object $partName = this.getPartName();
         result = result * 59 + ($partName == null ? 43 : $partName.hashCode());
         Object $material = this.getMaterial();
         result = result * 59 + ($material == null ? 43 : $material.hashCode());
         Object $thickness = this.getThickness();
         result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
         Object $drawingName = this.getDrawingName();
         result = result * 59 + ($drawingName == null ? 43 : $drawingName.hashCode());
         Object $drawingGuid = this.getDrawingGuid();
         result = result * 59 + ($drawingGuid == null ? 43 : $drawingGuid.hashCode());
         Object $area = this.getArea();
         result = result * 59 + ($area == null ? 43 : $area.hashCode());
         Object $width = this.getWidth();
         result = result * 59 + ($width == null ? 43 : $width.hashCode());
         Object $height = this.getHeight();
         result = result * 59 + ($height == null ? 43 : $height.hashCode());
         Object $propList = this.getPropList();
         result = result * 59 + ($propList == null ? 43 : $propList.hashCode());
         Object $propMap = this.getPropMap();
         return result * 59 + ($propMap == null ? 43 : $propMap.hashCode());
      }

      @Override
      public String toString() {
         return "BoChuNestedPlateDetailDTO.PartDTO(partId="
            + this.getPartId()
            + ", guid="
            + this.getGuid()
            + ", partName="
            + this.getPartName()
            + ", material="
            + this.getMaterial()
            + ", thickness="
            + this.getThickness()
            + ", drawingName="
            + this.getDrawingName()
            + ", drawingGuid="
            + this.getDrawingGuid()
            + ", jobId="
            + this.getJobId()
            + ", area="
            + this.getArea()
            + ", width="
            + this.getWidth()
            + ", height="
            + this.getHeight()
            + ", propList="
            + this.getPropList()
            + ", propMap="
            + this.getPropMap()
            + ", amount="
            + this.getAmount()
            + ")";
      }
   }

   public static class PlateLibraryDTO {
      @JsonProperty("guid")
      @Alias("guid")
      private String guid;
      @JsonProperty("plate_name")
      @Alias("plate_name")
      private String plateName;
      @JsonProperty("width")
      @Alias("width")
      private BigDecimal width;
      @JsonProperty("height")
      @Alias("height")
      private BigDecimal height;

      public String getGuid() {
         return this.guid;
      }

      public String getPlateName() {
         return this.plateName;
      }

      public BigDecimal getWidth() {
         return this.width;
      }

      public BigDecimal getHeight() {
         return this.height;
      }

      @JsonProperty("guid")
      public void setGuid(final String guid) {
         this.guid = guid;
      }

      @JsonProperty("plate_name")
      public void setPlateName(final String plateName) {
         this.plateName = plateName;
      }

      @JsonProperty("width")
      public void setWidth(final BigDecimal width) {
         this.width = width;
      }

      @JsonProperty("height")
      public void setHeight(final BigDecimal height) {
         this.height = height;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof BoChuNestedPlateDetailDTO.PlateLibraryDTO)) {
            return false;
         }

         BoChuNestedPlateDetailDTO.PlateLibraryDTO other = (BoChuNestedPlateDetailDTO.PlateLibraryDTO)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$guid = this.getGuid();
         Object other$guid = other.getGuid();
         if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
            Object this$plateName = this.getPlateName();
            Object other$plateName = other.getPlateName();
            if (this$plateName == null ? other$plateName == null : this$plateName.equals(other$plateName)) {
               Object this$width = this.getWidth();
               Object other$width = other.getWidth();
               if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                  Object this$height = this.getHeight();
                  Object other$height = other.getHeight();
                  return this$height == null ? other$height == null : this$height.equals(other$height);
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
         return other instanceof BoChuNestedPlateDetailDTO.PlateLibraryDTO;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $guid = this.getGuid();
         result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
         Object $plateName = this.getPlateName();
         result = result * 59 + ($plateName == null ? 43 : $plateName.hashCode());
         Object $width = this.getWidth();
         result = result * 59 + ($width == null ? 43 : $width.hashCode());
         Object $height = this.getHeight();
         return result * 59 + ($height == null ? 43 : $height.hashCode());
      }

      @Override
      public String toString() {
         return "BoChuNestedPlateDetailDTO.PlateLibraryDTO(guid="
            + this.getGuid()
            + ", plateName="
            + this.getPlateName()
            + ", width="
            + this.getWidth()
            + ", height="
            + this.getHeight()
            + ")";
      }
   }
}
