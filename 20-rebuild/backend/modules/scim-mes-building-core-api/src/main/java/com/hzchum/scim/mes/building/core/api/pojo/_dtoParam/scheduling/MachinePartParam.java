package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MachinePartParam", description = "零件套料零件集合")
public class MachinePartParam {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   private Long projectId;
   @ApiModelProperty(name = "taskOrderId", value = "工单id", notes = "工单id")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private Long taskOrderId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   @JsonProperty("teamId")
   @JSONField(name = "teamId")
   private Long teamId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "serialNumber", value = "零件编号", notes = "零件编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "thumbnail", value = "缩略图", notes = "缩略图")
   @JsonProperty("thumbnail")
   @JSONField(name = "thumbnail")
   private String thumbnail;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   private Long workshopId;
   @ApiModelProperty(name = "machinePartNeedId", value = "零件id", notes = "零件id")
   @JsonProperty("machinePartNeedId")
   @JSONField(name = "machinePartNeedId")
   private Long machinePartNeedId;
   @ApiModelProperty(name = "machinePartId", value = "零件id", notes = "零件id")
   @JsonProperty("machinePartId")
   @JSONField(name = "machinePartId")
   private Long machinePartId;
   @ApiModelProperty(name = "thick", value = "厚度", notes = "厚度")
   @JsonProperty("thick")
   @JSONField(name = "thick")
   private String thick;
   @ApiModelProperty(name = "material", value = "材质", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "weight", value = "重量", notes = "重量")
   @JsonProperty("weight")
   @JSONField(name = "weight")
   private String weight;
   @ApiModelProperty(name = "width", value = "宽度", notes = "宽度")
   @JsonProperty("width")
   @JSONField(name = "width")
   private String width;
   @ApiModelProperty(name = "length", value = "长度", notes = "长度")
   @JsonProperty("length")
   @JSONField(name = "length")
   private String length;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty("零件需要排产Ids")
   private String taskNeedMachinePartSchedulingIds;
   @ApiModelProperty("零件需要排产IdList")
   private List<Long> taskNeedMachinePartSchedulingIdList;
   @ApiModelProperty("对应的jobId")
   private Integer jobId;
   @ApiModelProperty("是否直发件(0:否,1:是)")
   private Boolean boolSendDirectly;
   @ApiModelProperty("零件类型[1:零件板,2:翼腹板,4:成品型材]")
   private Integer steelPlateTypeEnum;

   public List<Long> getTaskNeedMachinePartSchedulingIdList() {
      return CollUtil.isEmpty(this.taskNeedMachinePartSchedulingIdList) && StrUtil.isNotBlank(this.getTaskNeedMachinePartSchedulingIds())
         ? Convert.toList(Long.class, StrUtil.split(this.getTaskNeedMachinePartSchedulingIds(), ","))
         : this.taskNeedMachinePartSchedulingIdList;
   }

   public static MachinePartParam.MachinePartParamBuilder builder() {
      return new MachinePartParam.MachinePartParamBuilder();
   }

   public MachinePartParam(
      final Long projectId,
      final Long taskOrderId,
      final Long teamId,
      final Long monomerId,
      final String serialNumber,
      final String thumbnail,
      final Long workshopId,
      final Long machinePartNeedId,
      final Long machinePartId,
      final String thick,
      final String material,
      final String weight,
      final String width,
      final String length,
      final Integer quantity,
      final String taskNeedMachinePartSchedulingIds,
      final List<Long> taskNeedMachinePartSchedulingIdList,
      final Integer jobId,
      final Boolean boolSendDirectly,
      final Integer steelPlateTypeEnum
   ) {
      this.projectId = projectId;
      this.taskOrderId = taskOrderId;
      this.teamId = teamId;
      this.monomerId = monomerId;
      this.serialNumber = serialNumber;
      this.thumbnail = thumbnail;
      this.workshopId = workshopId;
      this.machinePartNeedId = machinePartNeedId;
      this.machinePartId = machinePartId;
      this.thick = thick;
      this.material = material;
      this.weight = weight;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
      this.taskNeedMachinePartSchedulingIdList = taskNeedMachinePartSchedulingIdList;
      this.jobId = jobId;
      this.boolSendDirectly = boolSendDirectly;
      this.steelPlateTypeEnum = steelPlateTypeEnum;
   }

   public MachinePartParam() {
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getTaskOrderId() {
      return this.taskOrderId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getThumbnail() {
      return this.thumbnail;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getMachinePartNeedId() {
      return this.machinePartNeedId;
   }

   public Long getMachinePartId() {
      return this.machinePartId;
   }

   public String getThick() {
      return this.thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getWeight() {
      return this.weight;
   }

   public String getWidth() {
      return this.width;
   }

   public String getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getTaskNeedMachinePartSchedulingIds() {
      return this.taskNeedMachinePartSchedulingIds;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public Integer getSteelPlateTypeEnum() {
      return this.steelPlateTypeEnum;
   }

   @JsonProperty("projectId")
   public MachinePartParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("taskOrderId")
   public MachinePartParam setTaskOrderId(final Long taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("teamId")
   public MachinePartParam setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   @JsonProperty("monomerId")
   public MachinePartParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("serialNumber")
   public MachinePartParam setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("thumbnail")
   public MachinePartParam setThumbnail(final String thumbnail) {
      this.thumbnail = thumbnail;
      return this;
   }

   @JsonProperty("workshopId")
   public MachinePartParam setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("machinePartNeedId")
   public MachinePartParam setMachinePartNeedId(final Long machinePartNeedId) {
      this.machinePartNeedId = machinePartNeedId;
      return this;
   }

   @JsonProperty("machinePartId")
   public MachinePartParam setMachinePartId(final Long machinePartId) {
      this.machinePartId = machinePartId;
      return this;
   }

   @JsonProperty("thick")
   public MachinePartParam setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @JsonProperty("material")
   public MachinePartParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("weight")
   public MachinePartParam setWeight(final String weight) {
      this.weight = weight;
      return this;
   }

   @JsonProperty("width")
   public MachinePartParam setWidth(final String width) {
      this.width = width;
      return this;
   }

   @JsonProperty("length")
   public MachinePartParam setLength(final String length) {
      this.length = length;
      return this;
   }

   @JsonProperty("quantity")
   public MachinePartParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MachinePartParam setTaskNeedMachinePartSchedulingIds(final String taskNeedMachinePartSchedulingIds) {
      this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
      return this;
   }

   public MachinePartParam setTaskNeedMachinePartSchedulingIdList(final List<Long> taskNeedMachinePartSchedulingIdList) {
      this.taskNeedMachinePartSchedulingIdList = taskNeedMachinePartSchedulingIdList;
      return this;
   }

   public MachinePartParam setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public MachinePartParam setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
      return this;
   }

   public MachinePartParam setSteelPlateTypeEnum(final Integer steelPlateTypeEnum) {
      this.steelPlateTypeEnum = steelPlateTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartParam(projectId="
         + this.getProjectId()
         + ", taskOrderId="
         + this.getTaskOrderId()
         + ", teamId="
         + this.getTeamId()
         + ", monomerId="
         + this.getMonomerId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", thumbnail="
         + this.getThumbnail()
         + ", workshopId="
         + this.getWorkshopId()
         + ", machinePartNeedId="
         + this.getMachinePartNeedId()
         + ", machinePartId="
         + this.getMachinePartId()
         + ", thick="
         + this.getThick()
         + ", material="
         + this.getMaterial()
         + ", weight="
         + this.getWeight()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", taskNeedMachinePartSchedulingIds="
         + this.getTaskNeedMachinePartSchedulingIds()
         + ", taskNeedMachinePartSchedulingIdList="
         + this.getTaskNeedMachinePartSchedulingIdList()
         + ", jobId="
         + this.getJobId()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ", steelPlateTypeEnum="
         + this.getSteelPlateTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartParam)) {
         return false;
      }

      MachinePartParam other = (MachinePartParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$taskOrderId = this.getTaskOrderId();
         Object other$taskOrderId = other.getTaskOrderId();
         if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$machinePartNeedId = this.getMachinePartNeedId();
                     Object other$machinePartNeedId = other.getMachinePartNeedId();
                     if (this$machinePartNeedId == null ? other$machinePartNeedId == null : this$machinePartNeedId.equals(other$machinePartNeedId)) {
                        Object this$machinePartId = this.getMachinePartId();
                        Object other$machinePartId = other.getMachinePartId();
                        if (this$machinePartId == null ? other$machinePartId == null : this$machinePartId.equals(other$machinePartId)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$jobId = this.getJobId();
                              Object other$jobId = other.getJobId();
                              if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
                                 Object this$boolSendDirectly = this.getBoolSendDirectly();
                                 Object other$boolSendDirectly = other.getBoolSendDirectly();
                                 if (this$boolSendDirectly == null ? other$boolSendDirectly == null : this$boolSendDirectly.equals(other$boolSendDirectly)) {
                                    Object this$steelPlateTypeEnum = this.getSteelPlateTypeEnum();
                                    Object other$steelPlateTypeEnum = other.getSteelPlateTypeEnum();
                                    if (this$steelPlateTypeEnum == null
                                       ? other$steelPlateTypeEnum == null
                                       : this$steelPlateTypeEnum.equals(other$steelPlateTypeEnum)) {
                                       Object this$serialNumber = this.getSerialNumber();
                                       Object other$serialNumber = other.getSerialNumber();
                                       if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                          Object this$thumbnail = this.getThumbnail();
                                          Object other$thumbnail = other.getThumbnail();
                                          if (this$thumbnail == null ? other$thumbnail == null : this$thumbnail.equals(other$thumbnail)) {
                                             Object this$thick = this.getThick();
                                             Object other$thick = other.getThick();
                                             if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                                                Object this$material = this.getMaterial();
                                                Object other$material = other.getMaterial();
                                                if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                   Object this$weight = this.getWeight();
                                                   Object other$weight = other.getWeight();
                                                   if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                      Object this$width = this.getWidth();
                                                      Object other$width = other.getWidth();
                                                      if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$taskNeedMachinePartSchedulingIds = this.getTaskNeedMachinePartSchedulingIds();
                                                            Object other$taskNeedMachinePartSchedulingIds = other.getTaskNeedMachinePartSchedulingIds();
                                                            if (this$taskNeedMachinePartSchedulingIds == null
                                                               ? other$taskNeedMachinePartSchedulingIds == null
                                                               : this$taskNeedMachinePartSchedulingIds.equals(other$taskNeedMachinePartSchedulingIds)) {
                                                               Object this$taskNeedMachinePartSchedulingIdList = this.getTaskNeedMachinePartSchedulingIdList();
                                                               Object other$taskNeedMachinePartSchedulingIdList = other.getTaskNeedMachinePartSchedulingIdList();
                                                               return this$taskNeedMachinePartSchedulingIdList == null
                                                                  ? other$taskNeedMachinePartSchedulingIdList == null
                                                                  : this$taskNeedMachinePartSchedulingIdList.equals(other$taskNeedMachinePartSchedulingIdList);
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
      return other instanceof MachinePartParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $machinePartNeedId = this.getMachinePartNeedId();
      result = result * 59 + ($machinePartNeedId == null ? 43 : $machinePartNeedId.hashCode());
      Object $machinePartId = this.getMachinePartId();
      result = result * 59 + ($machinePartId == null ? 43 : $machinePartId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      result = result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
      Object $steelPlateTypeEnum = this.getSteelPlateTypeEnum();
      result = result * 59 + ($steelPlateTypeEnum == null ? 43 : $steelPlateTypeEnum.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $thumbnail = this.getThumbnail();
      result = result * 59 + ($thumbnail == null ? 43 : $thumbnail.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $taskNeedMachinePartSchedulingIds = this.getTaskNeedMachinePartSchedulingIds();
      result = result * 59 + ($taskNeedMachinePartSchedulingIds == null ? 43 : $taskNeedMachinePartSchedulingIds.hashCode());
      Object $taskNeedMachinePartSchedulingIdList = this.getTaskNeedMachinePartSchedulingIdList();
      return result * 59 + ($taskNeedMachinePartSchedulingIdList == null ? 43 : $taskNeedMachinePartSchedulingIdList.hashCode());
   }

   public static class MachinePartParamBuilder {
      private Long projectId;
      private Long taskOrderId;
      private Long teamId;
      private Long monomerId;
      private String serialNumber;
      private String thumbnail;
      private Long workshopId;
      private Long machinePartNeedId;
      private Long machinePartId;
      private String thick;
      private String material;
      private String weight;
      private String width;
      private String length;
      private Integer quantity;
      private String taskNeedMachinePartSchedulingIds;
      private List<Long> taskNeedMachinePartSchedulingIdList;
      private Integer jobId;
      private Boolean boolSendDirectly;
      private Integer steelPlateTypeEnum;

      MachinePartParamBuilder() {
      }

      @JsonProperty("projectId")
      public MachinePartParam.MachinePartParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("taskOrderId")
      public MachinePartParam.MachinePartParamBuilder taskOrderId(final Long taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("teamId")
      public MachinePartParam.MachinePartParamBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      @JsonProperty("monomerId")
      public MachinePartParam.MachinePartParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("serialNumber")
      public MachinePartParam.MachinePartParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("thumbnail")
      public MachinePartParam.MachinePartParamBuilder thumbnail(final String thumbnail) {
         this.thumbnail = thumbnail;
         return this;
      }

      @JsonProperty("workshopId")
      public MachinePartParam.MachinePartParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("machinePartNeedId")
      public MachinePartParam.MachinePartParamBuilder machinePartNeedId(final Long machinePartNeedId) {
         this.machinePartNeedId = machinePartNeedId;
         return this;
      }

      @JsonProperty("machinePartId")
      public MachinePartParam.MachinePartParamBuilder machinePartId(final Long machinePartId) {
         this.machinePartId = machinePartId;
         return this;
      }

      @JsonProperty("thick")
      public MachinePartParam.MachinePartParamBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      @JsonProperty("material")
      public MachinePartParam.MachinePartParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("weight")
      public MachinePartParam.MachinePartParamBuilder weight(final String weight) {
         this.weight = weight;
         return this;
      }

      @JsonProperty("width")
      public MachinePartParam.MachinePartParamBuilder width(final String width) {
         this.width = width;
         return this;
      }

      @JsonProperty("length")
      public MachinePartParam.MachinePartParamBuilder length(final String length) {
         this.length = length;
         return this;
      }

      @JsonProperty("quantity")
      public MachinePartParam.MachinePartParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MachinePartParam.MachinePartParamBuilder taskNeedMachinePartSchedulingIds(final String taskNeedMachinePartSchedulingIds) {
         this.taskNeedMachinePartSchedulingIds = taskNeedMachinePartSchedulingIds;
         return this;
      }

      public MachinePartParam.MachinePartParamBuilder taskNeedMachinePartSchedulingIdList(final List<Long> taskNeedMachinePartSchedulingIdList) {
         this.taskNeedMachinePartSchedulingIdList = taskNeedMachinePartSchedulingIdList;
         return this;
      }

      public MachinePartParam.MachinePartParamBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public MachinePartParam.MachinePartParamBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public MachinePartParam.MachinePartParamBuilder steelPlateTypeEnum(final Integer steelPlateTypeEnum) {
         this.steelPlateTypeEnum = steelPlateTypeEnum;
         return this;
      }

      public MachinePartParam build() {
         return new MachinePartParam(
            this.projectId,
            this.taskOrderId,
            this.teamId,
            this.monomerId,
            this.serialNumber,
            this.thumbnail,
            this.workshopId,
            this.machinePartNeedId,
            this.machinePartId,
            this.thick,
            this.material,
            this.weight,
            this.width,
            this.length,
            this.quantity,
            this.taskNeedMachinePartSchedulingIds,
            this.taskNeedMachinePartSchedulingIdList,
            this.jobId,
            this.boolSendDirectly,
            this.steelPlateTypeEnum
         );
      }

      @Override
      public String toString() {
         return "MachinePartParam.MachinePartParamBuilder(projectId="
            + this.projectId
            + ", taskOrderId="
            + this.taskOrderId
            + ", teamId="
            + this.teamId
            + ", monomerId="
            + this.monomerId
            + ", serialNumber="
            + this.serialNumber
            + ", thumbnail="
            + this.thumbnail
            + ", workshopId="
            + this.workshopId
            + ", machinePartNeedId="
            + this.machinePartNeedId
            + ", machinePartId="
            + this.machinePartId
            + ", thick="
            + this.thick
            + ", material="
            + this.material
            + ", weight="
            + this.weight
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", taskNeedMachinePartSchedulingIds="
            + this.taskNeedMachinePartSchedulingIds
            + ", taskNeedMachinePartSchedulingIdList="
            + this.taskNeedMachinePartSchedulingIdList
            + ", jobId="
            + this.jobId
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ", steelPlateTypeEnum="
            + this.steelPlateTypeEnum
            + ")";
      }
   }
}
