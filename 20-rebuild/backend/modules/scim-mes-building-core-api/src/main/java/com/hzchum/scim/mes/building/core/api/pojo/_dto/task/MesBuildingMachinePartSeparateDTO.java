package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "MesBuildingMachinePartSeparateDTO", description = "零件分拣单 ")
public class MesBuildingMachinePartSeparateDTO {
   @ApiModelProperty(name = "id", notes = "零件id", value = "零件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "serialNumber", notes = "编号", value = "编号")
   @JsonProperty("serialNumber")
   @JSONField(name = "serialNumber")
   private String serialNumber;
   @ApiModelProperty(name = "picturePath", value = "图片路径(DXF:记录转换后的.sug位置  部件(主部件):记录导入的原构件NC1的图纸位子)")
   @JsonProperty("picturePath")
   @JSONField(name = "picturePath")
   private String picturePath;
   @ApiModelProperty(name = "monomerId", notes = "单体id", value = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域Id", value = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   private Long areaId;
   @ApiModelProperty(name = "sumQuantity", notes = "总数量")
   @JsonProperty("sumQuantity")
   @JSONField(name = "sumQuantity")
   private Integer sumQuantity;
   @ApiModelProperty(name = "list", value = "每个班组分配的零件数量")
   @JsonProperty("list")
   @JSONField(name = "list")
   private List<WorkshopAndLineQuantityDTO> workshopAndLineQuantityDTOList;

   public static MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder builder() {
      return new MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder();
   }

   public MesBuildingMachinePartSeparateDTO() {
   }

   public MesBuildingMachinePartSeparateDTO(
      final Long id,
      final String serialNumber,
      final String picturePath,
      final Long monomerId,
      final Long areaId,
      final Integer sumQuantity,
      final List<WorkshopAndLineQuantityDTO> workshopAndLineQuantityDTOList
   ) {
      this.id = id;
      this.serialNumber = serialNumber;
      this.picturePath = picturePath;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.sumQuantity = sumQuantity;
      this.workshopAndLineQuantityDTOList = workshopAndLineQuantityDTOList;
   }

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPicturePath() {
      return this.picturePath;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Integer getSumQuantity() {
      return this.sumQuantity;
   }

   public List<WorkshopAndLineQuantityDTO> getWorkshopAndLineQuantityDTOList() {
      return this.workshopAndLineQuantityDTOList;
   }

   @JsonProperty("id")
   public MesBuildingMachinePartSeparateDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("serialNumber")
   public MesBuildingMachinePartSeparateDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @JsonProperty("picturePath")
   public MesBuildingMachinePartSeparateDTO setPicturePath(final String picturePath) {
      this.picturePath = picturePath;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingMachinePartSeparateDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingMachinePartSeparateDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("sumQuantity")
   public MesBuildingMachinePartSeparateDTO setSumQuantity(final Integer sumQuantity) {
      this.sumQuantity = sumQuantity;
      return this;
   }

   @JsonProperty("list")
   public MesBuildingMachinePartSeparateDTO setWorkshopAndLineQuantityDTOList(final List<WorkshopAndLineQuantityDTO> workshopAndLineQuantityDTOList) {
      this.workshopAndLineQuantityDTOList = workshopAndLineQuantityDTOList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSeparateDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", picturePath="
         + this.getPicturePath()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", sumQuantity="
         + this.getSumQuantity()
         + ", workshopAndLineQuantityDTOList="
         + this.getWorkshopAndLineQuantityDTOList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSeparateDTO)) {
         return false;
      }

      MesBuildingMachinePartSeparateDTO other = (MesBuildingMachinePartSeparateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$sumQuantity = this.getSumQuantity();
               Object other$sumQuantity = other.getSumQuantity();
               if (this$sumQuantity == null ? other$sumQuantity == null : this$sumQuantity.equals(other$sumQuantity)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$picturePath = this.getPicturePath();
                     Object other$picturePath = other.getPicturePath();
                     if (this$picturePath == null ? other$picturePath == null : this$picturePath.equals(other$picturePath)) {
                        Object this$workshopAndLineQuantityDTOList = this.getWorkshopAndLineQuantityDTOList();
                        Object other$workshopAndLineQuantityDTOList = other.getWorkshopAndLineQuantityDTOList();
                        return this$workshopAndLineQuantityDTOList == null
                           ? other$workshopAndLineQuantityDTOList == null
                           : this$workshopAndLineQuantityDTOList.equals(other$workshopAndLineQuantityDTOList);
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
      return other instanceof MesBuildingMachinePartSeparateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $sumQuantity = this.getSumQuantity();
      result = result * 59 + ($sumQuantity == null ? 43 : $sumQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $picturePath = this.getPicturePath();
      result = result * 59 + ($picturePath == null ? 43 : $picturePath.hashCode());
      Object $workshopAndLineQuantityDTOList = this.getWorkshopAndLineQuantityDTOList();
      return result * 59 + ($workshopAndLineQuantityDTOList == null ? 43 : $workshopAndLineQuantityDTOList.hashCode());
   }

   public static class MesBuildingMachinePartSeparateDTOBuilder {
      private Long id;
      private String serialNumber;
      private String picturePath;
      private Long monomerId;
      private Long areaId;
      private Integer sumQuantity;
      private List<WorkshopAndLineQuantityDTO> workshopAndLineQuantityDTOList;

      MesBuildingMachinePartSeparateDTOBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("serialNumber")
      public MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      @JsonProperty("picturePath")
      public MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder picturePath(final String picturePath) {
         this.picturePath = picturePath;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("sumQuantity")
      public MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder sumQuantity(final Integer sumQuantity) {
         this.sumQuantity = sumQuantity;
         return this;
      }

      @JsonProperty("list")
      public MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder workshopAndLineQuantityDTOList(
         final List<WorkshopAndLineQuantityDTO> workshopAndLineQuantityDTOList
      ) {
         this.workshopAndLineQuantityDTOList = workshopAndLineQuantityDTOList;
         return this;
      }

      public MesBuildingMachinePartSeparateDTO build() {
         return new MesBuildingMachinePartSeparateDTO(
            this.id, this.serialNumber, this.picturePath, this.monomerId, this.areaId, this.sumQuantity, this.workshopAndLineQuantityDTOList
         );
      }

      @Override
      public String toString() {
         return "MesBuildingMachinePartSeparateDTO.MesBuildingMachinePartSeparateDTOBuilder(id="
            + this.id
            + ", serialNumber="
            + this.serialNumber
            + ", picturePath="
            + this.picturePath
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", sumQuantity="
            + this.sumQuantity
            + ", workshopAndLineQuantityDTOList="
            + this.workshopAndLineQuantityDTOList
            + ")";
      }
   }
}
