package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotEmpty;

@ApiModel(value = "WorkshopRequestParam", description = "")
public class WorkshopRequestParam {
   private List<Long> workshopIds;
   private Boolean sendStatus;
   @ApiModelProperty(name = "steelPlateTypeEnum", value = "零件类型 1.零件板 2.翼腹板 4成品型材 ")
   @JsonProperty("steelPlateTypeEnum")
   @JSONField(name = "steelPlateTypeEnum")
   @NotEmpty(message = "零件类型不能为空")
   private List<Integer> steelPlateTypeEnum;

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public Boolean getSendStatus() {
      return this.sendStatus;
   }

   public List<Integer> getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   public WorkshopRequestParam setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
      return this;
   }

   public WorkshopRequestParam setSendStatus(final Boolean sendStatus) {
      this.sendStatus = sendStatus;
      return this;
   }

   @JsonProperty("steelPlateTypeEnum")
   public WorkshopRequestParam setSteelPlateTypeEnum(final List<Integer> steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "WorkshopRequestParam(workshopIds="
         + this.getWorkshopIds()
         + ", sendStatus="
         + this.getSendStatus()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopRequestParam)) {
         return false;
      }

      WorkshopRequestParam other = (WorkshopRequestParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sendStatus = this.getSendStatus();
      Object other$sendStatus = other.getSendStatus();
      if (this$sendStatus == null ? other$sendStatus == null : this$sendStatus.equals(other$sendStatus)) {
         Object this$workshopIds = this.getWorkshopIds();
         Object other$workshopIds = other.getWorkshopIds();
         if (this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds)) {
            Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
            Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
            return this$steelPlateTypeEnum == null ? other$steelPlateTypeEnum == null : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopRequestParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sendStatus = this.getSendStatus();
      result = result * 59 + ($sendStatus == null ? 43 : $sendStatus.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      return result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
   }
}
