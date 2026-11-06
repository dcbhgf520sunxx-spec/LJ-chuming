package com.hzchum.scim.common.core.api.pojo.dto.bochu;

import cn.hutool.core.annotation.Alias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel("柏楚零件DTO")
public class BoChuPartDTO {
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
   private Integer amount;
   @JsonProperty("in_nest_amount")
   @Alias("in_nest_amount")
   private BigDecimal inNestAmount;
   @JsonProperty("finish_nest_amount")
   @Alias("finish_nest_amount")
   private BigDecimal finishNestAmount;
   @JsonProperty("un_cut_amount")
   @Alias("un_cut_amount")
   private BigDecimal unCutAmount;
   @JsonProperty("in_cut_amount")
   @Alias("in_cut_amount")
   private BigDecimal inCutAmount;
   @JsonProperty("finish_cut_amount")
   @Alias("finish_cut_amount")
   private BigDecimal finishCutAmount;
   @JsonProperty("un_plan_amount")
   @Alias("un_plan_amount")
   private BigDecimal unPlanAmount;
   @JsonProperty("create_by")
   @Alias("create_by")
   private Integer createBy;
   @JsonProperty("update_by")
   @Alias("update_by")
   private Integer updateBy;
   @JsonProperty("width")
   @Alias("width")
   private BigDecimal width;
   @JsonProperty("height")
   @Alias("height")
   private BigDecimal height;
   @JsonProperty("rotate_lock")
   @Alias("rotate_lock")
   private Integer rotateLock;
   @JsonProperty("full_path")
   @Alias("full_path")
   private String fullPath;
   @JsonProperty("fill_color")
   @Alias("fill_color")
   private String fillColor;
   @JsonProperty("level")
   @Alias("level")
   private String level;
   @JsonProperty("area")
   @Alias("area")
   private BigDecimal area;
   @JsonProperty("un_nest_amount")
   @Alias("un_nest_amount")
   private BigDecimal unNestAmount;
   @JsonProperty("partfile_url")
   @Alias("partfile_url")
   private String partfileUrl;
   @JsonProperty("thumbnail_url")
   @Alias("thumbnail_url")
   private String thumbnailUrl;
   @JsonProperty("weight")
   @Alias("weight")
   private BigDecimal weight;

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

   public Integer getAmount() {
      return this.amount;
   }

   public BigDecimal getInNestAmount() {
      return this.inNestAmount;
   }

   public BigDecimal getFinishNestAmount() {
      return this.finishNestAmount;
   }

   public BigDecimal getUnCutAmount() {
      return this.unCutAmount;
   }

   public BigDecimal getInCutAmount() {
      return this.inCutAmount;
   }

   public BigDecimal getFinishCutAmount() {
      return this.finishCutAmount;
   }

   public BigDecimal getUnPlanAmount() {
      return this.unPlanAmount;
   }

   public Integer getCreateBy() {
      return this.createBy;
   }

   public Integer getUpdateBy() {
      return this.updateBy;
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

   public String getFullPath() {
      return this.fullPath;
   }

   public String getFillColor() {
      return this.fillColor;
   }

   public String getLevel() {
      return this.level;
   }

   public BigDecimal getArea() {
      return this.area;
   }

   public BigDecimal getUnNestAmount() {
      return this.unNestAmount;
   }

   public String getPartfileUrl() {
      return this.partfileUrl;
   }

   public String getThumbnailUrl() {
      return this.thumbnailUrl;
   }

   public BigDecimal getWeight() {
      return this.weight;
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
   public void setAmount(final Integer amount) {
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

   @JsonProperty("un_cut_amount")
   public void setUnCutAmount(final BigDecimal unCutAmount) {
      this.unCutAmount = unCutAmount;
   }

   @JsonProperty("in_cut_amount")
   public void setInCutAmount(final BigDecimal inCutAmount) {
      this.inCutAmount = inCutAmount;
   }

   @JsonProperty("finish_cut_amount")
   public void setFinishCutAmount(final BigDecimal finishCutAmount) {
      this.finishCutAmount = finishCutAmount;
   }

   @JsonProperty("un_plan_amount")
   public void setUnPlanAmount(final BigDecimal unPlanAmount) {
      this.unPlanAmount = unPlanAmount;
   }

   @JsonProperty("create_by")
   public void setCreateBy(final Integer createBy) {
      this.createBy = createBy;
   }

   @JsonProperty("update_by")
   public void setUpdateBy(final Integer updateBy) {
      this.updateBy = updateBy;
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

   @JsonProperty("full_path")
   public void setFullPath(final String fullPath) {
      this.fullPath = fullPath;
   }

   @JsonProperty("fill_color")
   public void setFillColor(final String fillColor) {
      this.fillColor = fillColor;
   }

   @JsonProperty("level")
   public void setLevel(final String level) {
      this.level = level;
   }

   @JsonProperty("area")
   public void setArea(final BigDecimal area) {
      this.area = area;
   }

   @JsonProperty("un_nest_amount")
   public void setUnNestAmount(final BigDecimal unNestAmount) {
      this.unNestAmount = unNestAmount;
   }

   @JsonProperty("partfile_url")
   public void setPartfileUrl(final String partfileUrl) {
      this.partfileUrl = partfileUrl;
   }

   @JsonProperty("thumbnail_url")
   public void setThumbnailUrl(final String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
   }

   @JsonProperty("weight")
   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BoChuPartDTO)) {
         return false;
      }

      BoChuPartDTO other = (BoChuPartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$amount = this.getAmount();
      Object other$amount = other.getAmount();
      if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
         Object this$createBy = this.getCreateBy();
         Object other$createBy = other.getCreateBy();
         if (this$createBy == null ? other$createBy == null : this$createBy.equals(other$createBy)) {
            Object this$updateBy = this.getUpdateBy();
            Object other$updateBy = other.getUpdateBy();
            if (this$updateBy == null ? other$updateBy == null : this$updateBy.equals(other$updateBy)) {
               Object this$rotateLock = this.getRotateLock();
               Object other$rotateLock = other.getRotateLock();
               if (this$rotateLock == null ? other$rotateLock == null : this$rotateLock.equals(other$rotateLock)) {
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
                                       Object this$inNestAmount = this.getInNestAmount();
                                       Object other$inNestAmount = other.getInNestAmount();
                                       if (this$inNestAmount == null ? other$inNestAmount == null : this$inNestAmount.equals(other$inNestAmount)) {
                                          Object this$finishNestAmount = this.getFinishNestAmount();
                                          Object other$finishNestAmount = other.getFinishNestAmount();
                                          if (this$finishNestAmount == null
                                             ? other$finishNestAmount == null
                                             : this$finishNestAmount.equals(other$finishNestAmount)) {
                                             Object this$unCutAmount = this.getUnCutAmount();
                                             Object other$unCutAmount = other.getUnCutAmount();
                                             if (this$unCutAmount == null ? other$unCutAmount == null : this$unCutAmount.equals(other$unCutAmount)) {
                                                Object this$inCutAmount = this.getInCutAmount();
                                                Object other$inCutAmount = other.getInCutAmount();
                                                if (this$inCutAmount == null ? other$inCutAmount == null : this$inCutAmount.equals(other$inCutAmount)) {
                                                   Object this$finishCutAmount = this.getFinishCutAmount();
                                                   Object other$finishCutAmount = other.getFinishCutAmount();
                                                   if (this$finishCutAmount == null
                                                      ? other$finishCutAmount == null
                                                      : this$finishCutAmount.equals(other$finishCutAmount)) {
                                                      Object this$unPlanAmount = this.getUnPlanAmount();
                                                      Object other$unPlanAmount = other.getUnPlanAmount();
                                                      if (this$unPlanAmount == null ? other$unPlanAmount == null : this$unPlanAmount.equals(other$unPlanAmount)
                                                         )
                                                       {
                                                         Object this$width = this.getWidth();
                                                         Object other$width = other.getWidth();
                                                         if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                            Object this$height = this.getHeight();
                                                            Object other$height = other.getHeight();
                                                            if (this$height == null ? other$height == null : this$height.equals(other$height)) {
                                                               Object this$fullPath = this.getFullPath();
                                                               Object other$fullPath = other.getFullPath();
                                                               if (this$fullPath == null ? other$fullPath == null : this$fullPath.equals(other$fullPath)) {
                                                                  Object this$fillColor = this.getFillColor();
                                                                  Object other$fillColor = other.getFillColor();
                                                                  if (this$fillColor == null ? other$fillColor == null : this$fillColor.equals(other$fillColor)
                                                                     )
                                                                   {
                                                                     Object this$level = this.getLevel();
                                                                     Object other$level = other.getLevel();
                                                                     if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                                                        Object this$area = this.getArea();
                                                                        Object other$area = other.getArea();
                                                                        if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                                                           Object this$unNestAmount = this.getUnNestAmount();
                                                                           Object other$unNestAmount = other.getUnNestAmount();
                                                                           if (this$unNestAmount == null
                                                                              ? other$unNestAmount == null
                                                                              : this$unNestAmount.equals(other$unNestAmount)) {
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
                                                                                    Object this$weight = this.getWeight();
                                                                                    Object other$weight = other.getWeight();
                                                                                    return this$weight == null
                                                                                       ? other$weight == null
                                                                                       : this$weight.equals(other$weight);
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
      return other instanceof BoChuPartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $createBy = this.getCreateBy();
      result = result * 59 + ($createBy == null ? 43 : $createBy.hashCode());
      Object $updateBy = this.getUpdateBy();
      result = result * 59 + ($updateBy == null ? 43 : $updateBy.hashCode());
      Object $rotateLock = this.getRotateLock();
      result = result * 59 + ($rotateLock == null ? 43 : $rotateLock.hashCode());
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
      Object $inNestAmount = this.getInNestAmount();
      result = result * 59 + ($inNestAmount == null ? 43 : $inNestAmount.hashCode());
      Object $finishNestAmount = this.getFinishNestAmount();
      result = result * 59 + ($finishNestAmount == null ? 43 : $finishNestAmount.hashCode());
      Object $unCutAmount = this.getUnCutAmount();
      result = result * 59 + ($unCutAmount == null ? 43 : $unCutAmount.hashCode());
      Object $inCutAmount = this.getInCutAmount();
      result = result * 59 + ($inCutAmount == null ? 43 : $inCutAmount.hashCode());
      Object $finishCutAmount = this.getFinishCutAmount();
      result = result * 59 + ($finishCutAmount == null ? 43 : $finishCutAmount.hashCode());
      Object $unPlanAmount = this.getUnPlanAmount();
      result = result * 59 + ($unPlanAmount == null ? 43 : $unPlanAmount.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $height = this.getHeight();
      result = result * 59 + ($height == null ? 43 : $height.hashCode());
      Object $fullPath = this.getFullPath();
      result = result * 59 + ($fullPath == null ? 43 : $fullPath.hashCode());
      Object $fillColor = this.getFillColor();
      result = result * 59 + ($fillColor == null ? 43 : $fillColor.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $unNestAmount = this.getUnNestAmount();
      result = result * 59 + ($unNestAmount == null ? 43 : $unNestAmount.hashCode());
      Object $partfileUrl = this.getPartfileUrl();
      result = result * 59 + ($partfileUrl == null ? 43 : $partfileUrl.hashCode());
      Object $thumbnailUrl = this.getThumbnailUrl();
      result = result * 59 + ($thumbnailUrl == null ? 43 : $thumbnailUrl.hashCode());
      Object $weight = this.getWeight();
      return result * 59 + ($weight == null ? 43 : $weight.hashCode());
   }

   @Override
   public String toString() {
      return "BoChuPartDTO(guid="
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
         + ", unCutAmount="
         + this.getUnCutAmount()
         + ", inCutAmount="
         + this.getInCutAmount()
         + ", finishCutAmount="
         + this.getFinishCutAmount()
         + ", unPlanAmount="
         + this.getUnPlanAmount()
         + ", createBy="
         + this.getCreateBy()
         + ", updateBy="
         + this.getUpdateBy()
         + ", width="
         + this.getWidth()
         + ", height="
         + this.getHeight()
         + ", rotateLock="
         + this.getRotateLock()
         + ", fullPath="
         + this.getFullPath()
         + ", fillColor="
         + this.getFillColor()
         + ", level="
         + this.getLevel()
         + ", area="
         + this.getArea()
         + ", unNestAmount="
         + this.getUnNestAmount()
         + ", partfileUrl="
         + this.getPartfileUrl()
         + ", thumbnailUrl="
         + this.getThumbnailUrl()
         + ", weight="
         + this.getWeight()
         + ")";
   }
}
