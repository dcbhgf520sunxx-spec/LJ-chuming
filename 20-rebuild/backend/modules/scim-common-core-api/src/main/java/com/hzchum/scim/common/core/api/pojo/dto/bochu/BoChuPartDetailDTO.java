package com.hzchum.scim.common.core.api.pojo.dto.bochu;

import cn.hutool.core.annotation.Alias;
import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ApiModel("柏楚零件详情DTO")
public class BoChuPartDetailDTO {
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
   @JsonProperty("gas")
   @Alias("gas")
   private String gas;
   @JsonProperty("partfile_path")
   @Alias("partfile_path")
   private String partfilePath;
   @JsonProperty("thumbnail_path")
   @Alias("thumbnail_path")
   private String thumbnailPath;
   @JsonProperty("amount")
   @Alias("amount")
   private BigDecimal amount;
   @JsonProperty("in_nest_amount")
   @Alias("in_nest_amount")
   private BigDecimal inNestAmount;
   @JsonProperty("finish_nest_amount")
   @Alias("finish_nest_amount")
   private BigDecimal finishNestAmount;
   @JsonProperty("un_nest_amount")
   @Alias("un_nest_amount")
   private BigDecimal unNestAmount;
   @JsonProperty("in_cut_amount")
   @Alias("in_cut_amount")
   private BigDecimal inCutAmount;
   @JsonProperty("finish_cut_amount")
   @Alias("finish_cut_amount")
   private BigDecimal finishCutAmount;
   @JsonProperty("un_cut_amount")
   @Alias("un_cut_amount")
   private BigDecimal unCutAmount;
   @JsonProperty("width")
   @Alias("width")
   private BigDecimal width;
   @JsonProperty("height")
   @Alias("height")
   private BigDecimal height;
   @JsonProperty("rotate_lock")
   @Alias("rotate_lock")
   private Integer rotateLock;
   @JsonProperty("area")
   @Alias("area")
   private BigDecimal area;
   @JsonProperty("drawing_name")
   @Alias("drawing_name")
   private String drawingName;
   @JsonProperty("drawing_guid")
   @Alias("drawing_guid")
   private String drawingGuid;
   @JsonProperty("partfile_url")
   @Alias("partfile_url")
   private String partfileUrl;
   @JsonProperty("thumbnail_url")
   @Alias("thumbnail_url")
   private String thumbnailUrl;
   @JsonProperty("job_id")
   @Alias("job_id")
   private Integer jobId;
   @JsonProperty("job_title")
   @Alias("job_title")
   private String jobTitle;
   @JsonProperty("props")
   @Alias("props")
   private List<PropDTO> propList;
   private Map<String, Object> propMap;
   @JsonProperty("weight")
   @Alias("weight")
   private BigDecimal weight;
   @JsonProperty("plate_info")
   @Alias("plate_info")
   private List<BoChuPartDetailDTO.PlateInfoDTO> plateInfo;

   public Map<String, Object> getPropMap() {
      return CollUtil.isEmpty(this.propMap) && CollUtil.isNotEmpty(this.getPropList())
         ? this.getPropList().stream().collect(Collectors.toMap(PropDTO::getPropName, PropDTO::getPropValue))
         : this.propMap;
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

   public String getGas() {
      return this.gas;
   }

   public String getPartfilePath() {
      return this.partfilePath;
   }

   public String getThumbnailPath() {
      return this.thumbnailPath;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getInNestAmount() {
      return this.inNestAmount;
   }

   public BigDecimal getFinishNestAmount() {
      return this.finishNestAmount;
   }

   public BigDecimal getUnNestAmount() {
      return this.unNestAmount;
   }

   public BigDecimal getInCutAmount() {
      return this.inCutAmount;
   }

   public BigDecimal getFinishCutAmount() {
      return this.finishCutAmount;
   }

   public BigDecimal getUnCutAmount() {
      return this.unCutAmount;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getHeight() {
      return this.height;
   }

   public Integer getRotateLock() {
      return this.rotateLock;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public String getDrawingName() {
      return this.drawingName;
   }

   public String getDrawingGuid() {
      return this.drawingGuid;
   }

   public String getPartfileUrl() {
      return this.partfileUrl;
   }

   public String getThumbnailUrl() {
      return this.thumbnailUrl;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public String getJobTitle() {
      return this.jobTitle;
   }

   public List<PropDTO> getPropList() {
      return this.propList;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public List<BoChuPartDetailDTO.PlateInfoDTO> getPlateInfo() {
      return this.plateInfo;
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

   @JsonProperty("gas")
   public void setGas(final String gas) {
      this.gas = gas;
   }

   @JsonProperty("partfile_path")
   public void setPartfilePath(final String partfilePath) {
      this.partfilePath = partfilePath;
   }

   @JsonProperty("thumbnail_path")
   public void setThumbnailPath(final String thumbnailPath) {
      this.thumbnailPath = thumbnailPath;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @JsonProperty("in_nest_amount")
   public void setInNestAmount(final BigDecimal inNestAmount) {
      this.inNestAmount = inNestAmount;
   }

   @JsonProperty("finish_nest_amount")
   public void setFinishNestAmount(final BigDecimal finishNestAmount) {
      this.finishNestAmount = finishNestAmount;
   }

   @JsonProperty("un_nest_amount")
   public void setUnNestAmount(final BigDecimal unNestAmount) {
      this.unNestAmount = unNestAmount;
   }

   @JsonProperty("in_cut_amount")
   public void setInCutAmount(final BigDecimal inCutAmount) {
      this.inCutAmount = inCutAmount;
   }

   @JsonProperty("finish_cut_amount")
   public void setFinishCutAmount(final BigDecimal finishCutAmount) {
      this.finishCutAmount = finishCutAmount;
   }

   @JsonProperty("un_cut_amount")
   public void setUnCutAmount(final BigDecimal unCutAmount) {
      this.unCutAmount = unCutAmount;
   }

   @JsonProperty("width")
   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   @JsonProperty("height")
   public void setHeight(final BigDecimal height) {
      this.height = height;
   }

   @JsonProperty("rotate_lock")
   public void setRotateLock(final Integer rotateLock) {
      this.rotateLock = rotateLock;
   }

   @JsonProperty("area")
   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   @JsonProperty("drawing_name")
   public void setDrawingName(final String drawingName) {
      this.drawingName = drawingName;
   }

   @JsonProperty("drawing_guid")
   public void setDrawingGuid(final String drawingGuid) {
      this.drawingGuid = drawingGuid;
   }

   @JsonProperty("partfile_url")
   public void setPartfileUrl(final String partfileUrl) {
      this.partfileUrl = partfileUrl;
   }

   @JsonProperty("thumbnail_url")
   public void setThumbnailUrl(final String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
   }

   @JsonProperty("job_id")
   public void setJobId(final Integer jobId) {
      this.jobId = jobId;
   }

   @JsonProperty("job_title")
   public void setJobTitle(final String jobTitle) {
      this.jobTitle = jobTitle;
   }

   @JsonProperty("props")
   public void setPropList(final List<PropDTO> propList) {
      this.propList = propList;
   }

   public void setPropMap(final Map<String, Object> propMap) {
      this.propMap = propMap;
   }

   @JsonProperty("weight")
   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   @JsonProperty("plate_info")
   public void setPlateInfo(final List<BoChuPartDetailDTO.PlateInfoDTO> plateInfo) {
      this.plateInfo = plateInfo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuPartDetailDTO)) {
         return false;
      }

      BoChuPartDetailDTO other = (BoChuPartDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$rotateLock = this.getRotateLock();
      Object other$rotateLock = other.getRotateLock();
      if (this$rotateLock == null ? other$rotateLock == null : this$rotateLock.equals(other$rotateLock)) {
         Object this$jobId = this.getJobId();
         Object other$jobId = other.getJobId();
         if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
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
                        Object this$gas = this.getGas();
                        Object other$gas = other.getGas();
                        if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                           Object this$partfilePath = this.getPartfilePath();
                           Object other$partfilePath = other.getPartfilePath();
                           if (this$partfilePath == null ? other$partfilePath == null : this$partfilePath.equals(other$partfilePath)) {
                              Object this$thumbnailPath = this.getThumbnailPath();
                              Object other$thumbnailPath = other.getThumbnailPath();
                              if (this$thumbnailPath == null ? other$thumbnailPath == null : this$thumbnailPath.equals(other$thumbnailPath)) {
                                 Object this$amount = this.getAmount();
                                 Object other$amount = other.getAmount();
                                 if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                    Object this$inNestAmount = this.getInNestAmount();
                                    Object other$inNestAmount = other.getInNestAmount();
                                    if (this$inNestAmount == null ? other$inNestAmount == null : this$inNestAmount.equals(other$inNestAmount)) {
                                       Object this$finishNestAmount = this.getFinishNestAmount();
                                       Object other$finishNestAmount = other.getFinishNestAmount();
                                       if (this$finishNestAmount == null
                                          ? other$finishNestAmount == null
                                          : this$finishNestAmount.equals(other$finishNestAmount)) {
                                          Object this$unNestAmount = this.getUnNestAmount();
                                          Object other$unNestAmount = other.getUnNestAmount();
                                          if (this$unNestAmount == null ? other$unNestAmount == null : this$unNestAmount.equals(other$unNestAmount)) {
                                             Object this$inCutAmount = this.getInCutAmount();
                                             Object other$inCutAmount = other.getInCutAmount();
                                             if (this$inCutAmount == null ? other$inCutAmount == null : this$inCutAmount.equals(other$inCutAmount)) {
                                                Object this$finishCutAmount = this.getFinishCutAmount();
                                                Object other$finishCutAmount = other.getFinishCutAmount();
                                                if (this$finishCutAmount == null
                                                   ? other$finishCutAmount == null
                                                   : this$finishCutAmount.equals(other$finishCutAmount)) {
                                                   Object this$unCutAmount = this.getUnCutAmount();
                                                   Object other$unCutAmount = other.getUnCutAmount();
                                                   if (this$unCutAmount == null ? other$unCutAmount == null : this$unCutAmount.equals(other$unCutAmount)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                         Object this$height = this.getHeight();
                                                         Object other$height = other.getHeight();
                                                         if (this$height == null ? other$height == null : this$height.equals(other$height)) {
                                                            Object this$area = this.getArea();
                                                            Object other$area = other.getArea();
                                                            if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                               Object this$drawingName = this.getDrawingName();
                                                               Object other$drawingName = other.getDrawingName();
                                                               if (this$drawingName == null
                                                                  ? other$drawingName == null
                                                                  : this$drawingName.equals(other$drawingName)) {
                                                                  Object this$drawingGuid = this.getDrawingGuid();
                                                                  Object other$drawingGuid = other.getDrawingGuid();
                                                                  if (this$drawingGuid == null
                                                                     ? other$drawingGuid == null
                                                                     : this$drawingGuid.equals(other$drawingGuid)) {
                                                                     Object this$partfileUrl = this.getPartfileUrl();
                                                                     Object other$partfileUrl = other.getPartfileUrl();
                                                                     if (this$partfileUrl == null
                                                                        ? other$partfileUrl == null
                                                                        : this$partfileUrl.equals(other$partfileUrl)) {
                                                                        Object this$thumbnailUrl = this.getThumbnailUrl();
                                                                        Object other$thumbnailUrl = other.getThumbnailUrl();
                                                                        if (this$thumbnailUrl == null
                                                                           ? other$thumbnailUrl == null
                                                                           : this$thumbnailUrl.equals(other$thumbnailUrl)) {
                                                                           Object this$jobTitle = this.getJobTitle();
                                                                           Object other$jobTitle = other.getJobTitle();
                                                                           if (this$jobTitle == null
                                                                              ? other$jobTitle == null
                                                                              : this$jobTitle.equals(other$jobTitle)) {
                                                                              Object this$propList = this.getPropList();
                                                                              Object other$propList = other.getPropList();
                                                                              if (this$propList == null
                                                                                 ? other$propList == null
                                                                                 : this$propList.equals(other$propList)) {
                                                                                 Object this$propMap = this.getPropMap();
                                                                                 Object other$propMap = other.getPropMap();
                                                                                 if (this$propMap == null
                                                                                    ? other$propMap == null
                                                                                    : this$propMap.equals(other$propMap)) {
                                                                                    Object this$weight = this.getWeight();
                                                                                    Object other$weight = other.getWeight();
                                                                                    if (this$weight == null
                                                                                       ? other$weight == null
                                                                                       : this$weight.equals(other$weight)) {
                                                                                       Object this$plateInfo = this.getPlateInfo();
                                                                                       Object other$plateInfo = other.getPlateInfo();
                                                                                       return this$plateInfo == null
                                                                                          ? other$plateInfo == null
                                                                                          : this$plateInfo.equals(other$plateInfo);
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
      return other instanceof BoChuPartDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $rotateLock = this.getRotateLock();
      result = result * 59 + ($rotateLock == null ? 43 : $rotateLock.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $partName = this.getPartName();
      result = result * 59 + ($partName == null ? 43 : $partName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $partfilePath = this.getPartfilePath();
      result = result * 59 + ($partfilePath == null ? 43 : $partfilePath.hashCode());
      Object $thumbnailPath = this.getThumbnailPath();
      result = result * 59 + ($thumbnailPath == null ? 43 : $thumbnailPath.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $inNestAmount = this.getInNestAmount();
      result = result * 59 + ($inNestAmount == null ? 43 : $inNestAmount.hashCode());
      Object $finishNestAmount = this.getFinishNestAmount();
      result = result * 59 + ($finishNestAmount == null ? 43 : $finishNestAmount.hashCode());
      Object $unNestAmount = this.getUnNestAmount();
      result = result * 59 + ($unNestAmount == null ? 43 : $unNestAmount.hashCode());
      Object $inCutAmount = this.getInCutAmount();
      result = result * 59 + ($inCutAmount == null ? 43 : $inCutAmount.hashCode());
      Object $finishCutAmount = this.getFinishCutAmount();
      result = result * 59 + ($finishCutAmount == null ? 43 : $finishCutAmount.hashCode());
      Object $unCutAmount = this.getUnCutAmount();
      result = result * 59 + ($unCutAmount == null ? 43 : $unCutAmount.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $height = this.getHeight();
      result = result * 59 + ($height == null ? 43 : $height.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $drawingName = this.getDrawingName();
      result = result * 59 + ($drawingName == null ? 43 : $drawingName.hashCode());
      Object $drawingGuid = this.getDrawingGuid();
      result = result * 59 + ($drawingGuid == null ? 43 : $drawingGuid.hashCode());
      Object $partfileUrl = this.getPartfileUrl();
      result = result * 59 + ($partfileUrl == null ? 43 : $partfileUrl.hashCode());
      Object $thumbnailUrl = this.getThumbnailUrl();
      result = result * 59 + ($thumbnailUrl == null ? 43 : $thumbnailUrl.hashCode());
      Object $jobTitle = this.getJobTitle();
      result = result * 59 + ($jobTitle == null ? 43 : $jobTitle.hashCode());
      Object $propList = this.getPropList();
      result = result * 59 + ($propList == null ? 43 : $propList.hashCode());
      Object $propMap = this.getPropMap();
      result = result * 59 + ($propMap == null ? 43 : $propMap.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $plateInfo = this.getPlateInfo();
      return result * 59 + ($plateInfo == null ? 43 : $plateInfo.hashCode());
   }

   @Override
   public String toString() {
      return "BoChuPartDetailDTO(guid="
         + this.getGuid()
         + ", partName="
         + this.getPartName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", gas="
         + this.getGas()
         + ", partfilePath="
         + this.getPartfilePath()
         + ", thumbnailPath="
         + this.getThumbnailPath()
         + ", amount="
         + this.getAmount()
         + ", inNestAmount="
         + this.getInNestAmount()
         + ", finishNestAmount="
         + this.getFinishNestAmount()
         + ", unNestAmount="
         + this.getUnNestAmount()
         + ", inCutAmount="
         + this.getInCutAmount()
         + ", finishCutAmount="
         + this.getFinishCutAmount()
         + ", unCutAmount="
         + this.getUnCutAmount()
         + ", width="
         + this.getWidth()
         + ", height="
         + this.getHeight()
         + ", rotateLock="
         + this.getRotateLock()
         + ", area="
         + this.getArea()
         + ", drawingName="
         + this.getDrawingName()
         + ", drawingGuid="
         + this.getDrawingGuid()
         + ", partfileUrl="
         + this.getPartfileUrl()
         + ", thumbnailUrl="
         + this.getThumbnailUrl()
         + ", jobId="
         + this.getJobId()
         + ", jobTitle="
         + this.getJobTitle()
         + ", propList="
         + this.getPropList()
         + ", propMap="
         + this.getPropMap()
         + ", weight="
         + this.getWeight()
         + ", plateInfo="
         + this.getPlateInfo()
         + ")";
   }

   public static class PlateInfoDTO {
      @JsonProperty("plate_guid")
      @Alias("plate_guid")
      private String plateGuid;
      @JsonProperty("plate_name")
      @Alias("plate_name")
      private String plateName;
      @JsonProperty("part_amount")
      @Alias("part_amount")
      private Integer partAmount;
      @JsonProperty("plate_amount")
      @Alias("plate_amount")
      private Integer plateAmount;

      public String getPlateGuid() {
         return this.plateGuid;
      }

      public String getPlateName() {
         return this.plateName;
      }

      public Integer getPartAmount() {
         return this.partAmount;
      }

      public Integer getPlateAmount() {
         return this.plateAmount;
      }

      @JsonProperty("plate_guid")
      public void setPlateGuid(final String plateGuid) {
         this.plateGuid = plateGuid;
      }

      @JsonProperty("plate_name")
      public void setPlateName(final String plateName) {
         this.plateName = plateName;
      }

      @JsonProperty("part_amount")
      public void setPartAmount(final Integer partAmount) {
         this.partAmount = partAmount;
      }

      @JsonProperty("plate_amount")
      public void setPlateAmount(final Integer plateAmount) {
         this.plateAmount = plateAmount;
      }

      @Override
      public boolean equals(final Object o) {
         if (o == this) {
            return true;
         }

         if (!(o instanceof BoChuPartDetailDTO.PlateInfoDTO)) {
            return false;
         }

         BoChuPartDetailDTO.PlateInfoDTO other = (BoChuPartDetailDTO.PlateInfoDTO)o;
         if (!other.canEqual(this)) {
            return false;
         }

         Object this$partAmount = this.getPartAmount();
         Object other$partAmount = other.getPartAmount();
         if (this$partAmount == null ? other$partAmount == null : this$partAmount.equals(other$partAmount)) {
            Object this$plateAmount = this.getPlateAmount();
            Object other$plateAmount = other.getPlateAmount();
            if (this$plateAmount == null ? other$plateAmount == null : this$plateAmount.equals(other$plateAmount)) {
               Object this$plateGuid = this.getPlateGuid();
               Object other$plateGuid = other.getPlateGuid();
               if (this$plateGuid == null ? other$plateGuid == null : this$plateGuid.equals(other$plateGuid)) {
                  Object this$plateName = this.getPlateName();
                  Object other$plateName = other.getPlateName();
                  return this$plateName == null ? other$plateName == null : this$plateName.equals(other$plateName);
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
         return other instanceof BoChuPartDetailDTO.PlateInfoDTO;
      }

      @Override
      public int hashCode() {
         int PRIME = 59;
         int result = 1;
         Object $partAmount = this.getPartAmount();
         result = result * 59 + ($partAmount == null ? 43 : $partAmount.hashCode());
         Object $plateAmount = this.getPlateAmount();
         result = result * 59 + ($plateAmount == null ? 43 : $plateAmount.hashCode());
         Object $plateGuid = this.getPlateGuid();
         result = result * 59 + ($plateGuid == null ? 43 : $plateGuid.hashCode());
         Object $plateName = this.getPlateName();
         return result * 59 + ($plateName == null ? 43 : $plateName.hashCode());
      }

      @Override
      public String toString() {
         return "BoChuPartDetailDTO.PlateInfoDTO(plateGuid="
            + this.getPlateGuid()
            + ", plateName="
            + this.getPlateName()
            + ", partAmount="
            + this.getPartAmount()
            + ", plateAmount="
            + this.getPlateAmount()
            + ")";
      }
   }
}
