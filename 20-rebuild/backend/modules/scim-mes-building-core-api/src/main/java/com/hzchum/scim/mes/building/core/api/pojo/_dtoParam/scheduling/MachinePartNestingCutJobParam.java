package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MachinePartNestingCutParam", description = "切割任务下发请求类")
public class MachinePartNestingCutJobParam {
   private String cutType;
   private String guid;
   private String childGuid;
   private String id;
   private String thick;
   private String width;
   private String length;
   private Integer quantity;
   private String material;
   private Integer partQuantity;
   private Long machineToolId;

   public static MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder builder() {
      return new MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder();
   }

   public MachinePartNestingCutJobParam(
      final String cutType,
      final String guid,
      final String childGuid,
      final String id,
      final String thick,
      final String width,
      final String length,
      final Integer quantity,
      final String material,
      final Integer partQuantity,
      final Long machineToolId
   ) {
      this.cutType = cutType;
      this.guid = guid;
      this.childGuid = childGuid;
      this.id = id;
      this.thick = thick;
      this.width = width;
      this.length = length;
      this.quantity = quantity;
      this.material = material;
      this.partQuantity = partQuantity;
      this.machineToolId = machineToolId;
   }

   public MachinePartNestingCutJobParam() {
   }

   public String getCutType() {
      return this.cutType;
   }

   public String getGuid() {
      return this.guid;
   }

   public String getChildGuid() {
      return this.childGuid;
   }

   public String getId() {
      return this.id;
   }

   public String getThick() {
      return this.thick;
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

   public String getMaterial() {
      return this.material;
   }

   public Integer getPartQuantity() {
      return this.partQuantity;
   }

   public Long getMachineToolId() {
      return this.machineToolId;
   }

   public MachinePartNestingCutJobParam setCutType(final String cutType) {
      this.cutType = cutType;
      return this;
   }

   public MachinePartNestingCutJobParam setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public MachinePartNestingCutJobParam setChildGuid(final String childGuid) {
      this.childGuid = childGuid;
      return this;
   }

   public MachinePartNestingCutJobParam setId(final String id) {
      this.id = id;
      return this;
   }

   public MachinePartNestingCutJobParam setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   public MachinePartNestingCutJobParam setWidth(final String width) {
      this.width = width;
      return this;
   }

   public MachinePartNestingCutJobParam setLength(final String length) {
      this.length = length;
      return this;
   }

   public MachinePartNestingCutJobParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MachinePartNestingCutJobParam setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MachinePartNestingCutJobParam setPartQuantity(final Integer partQuantity) {
      this.partQuantity = partQuantity;
      return this;
   }

   public MachinePartNestingCutJobParam setMachineToolId(final Long machineToolId) {
      this.machineToolId = machineToolId;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingCutJobParam)) {
         return false;
      }

      MachinePartNestingCutJobParam other = (MachinePartNestingCutJobParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$partQuantity = this.getPartQuantity();
         Object other$partQuantity = other.getPartQuantity();
         if (this$partQuantity == null ? other$partQuantity == null : this$partQuantity.equals(other$partQuantity)) {
            Object this$machineToolId = this.getMachineToolId();
            Object other$machineToolId = other.getMachineToolId();
            if (this$machineToolId == null ? other$machineToolId == null : this$machineToolId.equals(other$machineToolId)) {
               Object this$cutType = this.getCutType();
               Object other$cutType = other.getCutType();
               if (this$cutType == null ? other$cutType == null : this$cutType.equals(other$cutType)) {
                  Object this$guid = this.getGuid();
                  Object other$guid = other.getGuid();
                  if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                     Object this$childGuid = this.getChildGuid();
                     Object other$childGuid = other.getChildGuid();
                     if (this$childGuid == null ? other$childGuid == null : this$childGuid.equals(other$childGuid)) {
                        Object this$id = this.getId();
                        Object other$id = other.getId();
                        if (this$id == null ? other$id == null : this$id.equals(other$id)) {
                           Object this$thick = this.getThick();
                           Object other$thick = other.getThick();
                           if (this$thick == null ? other$thick == null : this$thick.equals(other$thick)) {
                              Object this$width = this.getWidth();
                              Object other$width = other.getWidth();
                              if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$material = this.getMaterial();
                                    Object other$material = other.getMaterial();
                                    return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof MachinePartNestingCutJobParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $partQuantity = this.getPartQuantity();
      result = result * 59 + ($partQuantity == null ? 43 : $partQuantity.hashCode());
      Object $machineToolId = this.getMachineToolId();
      result = result * 59 + ($machineToolId == null ? 43 : $machineToolId.hashCode());
      Object $cutType = this.getCutType();
      result = result * 59 + ($cutType == null ? 43 : $cutType.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $childGuid = this.getChildGuid();
      result = result * 59 + ($childGuid == null ? 43 : $childGuid.hashCode());
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $thick = this.getThick();
      result = result * 59 + ($thick == null ? 43 : $thick.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "MachinePartNestingCutJobParam(cutType="
         + this.getCutType()
         + ", guid="
         + this.getGuid()
         + ", childGuid="
         + this.getChildGuid()
         + ", id="
         + this.getId()
         + ", thick="
         + this.getThick()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", material="
         + this.getMaterial()
         + ", partQuantity="
         + this.getPartQuantity()
         + ", machineToolId="
         + this.getMachineToolId()
         + ")";
   }

   public static class MachinePartNestingCutJobParamBuilder {
      private String cutType;
      private String guid;
      private String childGuid;
      private String id;
      private String thick;
      private String width;
      private String length;
      private Integer quantity;
      private String material;
      private Integer partQuantity;
      private Long machineToolId;

      MachinePartNestingCutJobParamBuilder() {
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder cutType(final String cutType) {
         this.cutType = cutType;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder childGuid(final String childGuid) {
         this.childGuid = childGuid;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder id(final String id) {
         this.id = id;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder width(final String width) {
         this.width = width;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder length(final String length) {
         this.length = length;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder partQuantity(final Integer partQuantity) {
         this.partQuantity = partQuantity;
         return this;
      }

      public MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder machineToolId(final Long machineToolId) {
         this.machineToolId = machineToolId;
         return this;
      }

      public MachinePartNestingCutJobParam build() {
         return new MachinePartNestingCutJobParam(
            this.cutType,
            this.guid,
            this.childGuid,
            this.id,
            this.thick,
            this.width,
            this.length,
            this.quantity,
            this.material,
            this.partQuantity,
            this.machineToolId
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingCutJobParam.MachinePartNestingCutJobParamBuilder(cutType="
            + this.cutType
            + ", guid="
            + this.guid
            + ", childGuid="
            + this.childGuid
            + ", id="
            + this.id
            + ", thick="
            + this.thick
            + ", width="
            + this.width
            + ", length="
            + this.length
            + ", quantity="
            + this.quantity
            + ", material="
            + this.material
            + ", partQuantity="
            + this.partQuantity
            + ", machineToolId="
            + this.machineToolId
            + ")";
      }
   }
}
