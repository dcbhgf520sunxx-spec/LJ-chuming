package com.hzchum.scim.common.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@ApiModel(value = "BimArtifactStatusDetailVO", description = "bim模型构件物流信息")
public class BimLogisticsVO {
   @ApiModelProperty(name = "id", notes = "发运表id")
   private Long id;
   @ApiModelProperty("车次编号")
   private String serialNumber;
   @ApiModelProperty("车牌号")
   private String licensePlate;
   @ApiModelProperty("发运时间")
   private LocalDateTime auditTime;
   @ApiModelProperty("构件elementIds")
   private Set<String> elementIds;
   @ApiModelProperty("发运详情")
   private List<BimLogisticsLinkVO> bimLogisticsLinkVOList;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public Set<String> getElementIds() {
      return this.elementIds;
   }

   public List<BimLogisticsLinkVO> getBimLogisticsLinkVOList() {
      return this.bimLogisticsLinkVOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
   }

   public void setElementIds(final Set<String> elementIds) {
      this.elementIds = elementIds;
   }

   public void setBimLogisticsLinkVOList(final List<BimLogisticsLinkVO> bimLogisticsLinkVOList) {
      this.bimLogisticsLinkVOList = bimLogisticsLinkVOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BimLogisticsVO)) {
         return false;
      }

      BimLogisticsVO other = (BimLogisticsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$licensePlate = this.getLicensePlate();
            Object other$licensePlate = other.getLicensePlate();
            if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
               Object this$auditTime = this.getAuditTime();
               Object other$auditTime = other.getAuditTime();
               if (this$auditTime == null ? other$auditTime == null : this$auditTime.equals(other$auditTime)) {
                  Object this$elementIds = this.getElementIds();
                  Object other$elementIds = other.getElementIds();
                  if (this$elementIds == null ? other$elementIds == null : this$elementIds.equals(other$elementIds)) {
                     Object this$bimLogisticsLinkVOList = this.getBimLogisticsLinkVOList();
                     Object other$bimLogisticsLinkVOList = other.getBimLogisticsLinkVOList();
                     return this$bimLogisticsLinkVOList == null
                        ? other$bimLogisticsLinkVOList == null
                        : this$bimLogisticsLinkVOList.equals(other$bimLogisticsLinkVOList);
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
      return other instanceof BimLogisticsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $elementIds = this.getElementIds();
      result = result * 59 + ($elementIds == null ? 43 : $elementIds.hashCode());
      Object $bimLogisticsLinkVOList = this.getBimLogisticsLinkVOList();
      return result * 59 + ($bimLogisticsLinkVOList == null ? 43 : $bimLogisticsLinkVOList.hashCode());
   }

   @Override
   public String toString() {
      return "BimLogisticsVO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", auditTime="
         + this.getAuditTime()
         + ", elementIds="
         + this.getElementIds()
         + ", bimLogisticsLinkVOList="
         + this.getBimLogisticsLinkVOList()
         + ")";
   }
}
