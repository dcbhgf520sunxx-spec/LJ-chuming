package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "零件排产作业零件明细", description = "零件排产作业零件明细")
public class MachinePartNestingJobDetailDTO {
   private String guid;
   private String partName;
   private String material;
   private double thickness;
   private String gas;
   private int amount;
   private int un_nest_amount;
   private int in_nest_amount;
   private int finish_nest_amount;
   private int un_cut_amount;
   private int in_cut_amount;
   private int finish_cut_amount;
   private int width;
   private int height;
   private String partfile_path;
   private String partfile_url;
   private String thumbnail_path;
   private String thumbnail_url;
   private int create_by;
   private int update_by;

   public static MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder builder() {
      return new MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder();
   }

   public MachinePartNestingJobDetailDTO(
      final String guid,
      final String partName,
      final String material,
      final double thickness,
      final String gas,
      final int amount,
      final int un_nest_amount,
      final int in_nest_amount,
      final int finish_nest_amount,
      final int un_cut_amount,
      final int in_cut_amount,
      final int finish_cut_amount,
      final int width,
      final int height,
      final String partfile_path,
      final String partfile_url,
      final String thumbnail_path,
      final String thumbnail_url,
      final int create_by,
      final int update_by
   ) {
      this.guid = guid;
      this.partName = partName;
      this.material = material;
      this.thickness = thickness;
      this.gas = gas;
      this.amount = amount;
      this.un_nest_amount = un_nest_amount;
      this.in_nest_amount = in_nest_amount;
      this.finish_nest_amount = finish_nest_amount;
      this.un_cut_amount = un_cut_amount;
      this.in_cut_amount = in_cut_amount;
      this.finish_cut_amount = finish_cut_amount;
      this.width = width;
      this.height = height;
      this.partfile_path = partfile_path;
      this.partfile_url = partfile_url;
      this.thumbnail_path = thumbnail_path;
      this.thumbnail_url = thumbnail_url;
      this.create_by = create_by;
      this.update_by = update_by;
   }

   public MachinePartNestingJobDetailDTO() {
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

   public double getThickness() {
      return this.thickness;
   }

   public String getGas() {
      return this.gas;
   }

   public int getAmount() {
      return this.amount;
   }

   public int getUn_nest_amount() {
      return this.un_nest_amount;
   }

   public int getIn_nest_amount() {
      return this.in_nest_amount;
   }

   public int getFinish_nest_amount() {
      return this.finish_nest_amount;
   }

   public int getUn_cut_amount() {
      return this.un_cut_amount;
   }

   public int getIn_cut_amount() {
      return this.in_cut_amount;
   }

   public int getFinish_cut_amount() {
      return this.finish_cut_amount;
   }

   public int getWidth() {
      return this.width;
   }

   public int getHeight() {
      return this.height;
   }

   public String getPartfile_path() {
      return this.partfile_path;
   }

   public String getPartfile_url() {
      return this.partfile_url;
   }

   public String getThumbnail_path() {
      return this.thumbnail_path;
   }

   public String getThumbnail_url() {
      return this.thumbnail_url;
   }

   public int getCreate_by() {
      return this.create_by;
   }

   public int getUpdate_by() {
      return this.update_by;
   }

   public MachinePartNestingJobDetailDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public MachinePartNestingJobDetailDTO setPartName(final String partName) {
      this.partName = partName;
      return this;
   }

   public MachinePartNestingJobDetailDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public MachinePartNestingJobDetailDTO setThickness(final double thickness) {
      this.thickness = thickness;
      return this;
   }

   public MachinePartNestingJobDetailDTO setGas(final String gas) {
      this.gas = gas;
      return this;
   }

   public MachinePartNestingJobDetailDTO setAmount(final int amount) {
      this.amount = amount;
      return this;
   }

   public MachinePartNestingJobDetailDTO setUn_nest_amount(final int un_nest_amount) {
      this.un_nest_amount = un_nest_amount;
      return this;
   }

   public MachinePartNestingJobDetailDTO setIn_nest_amount(final int in_nest_amount) {
      this.in_nest_amount = in_nest_amount;
      return this;
   }

   public MachinePartNestingJobDetailDTO setFinish_nest_amount(final int finish_nest_amount) {
      this.finish_nest_amount = finish_nest_amount;
      return this;
   }

   public MachinePartNestingJobDetailDTO setUn_cut_amount(final int un_cut_amount) {
      this.un_cut_amount = un_cut_amount;
      return this;
   }

   public MachinePartNestingJobDetailDTO setIn_cut_amount(final int in_cut_amount) {
      this.in_cut_amount = in_cut_amount;
      return this;
   }

   public MachinePartNestingJobDetailDTO setFinish_cut_amount(final int finish_cut_amount) {
      this.finish_cut_amount = finish_cut_amount;
      return this;
   }

   public MachinePartNestingJobDetailDTO setWidth(final int width) {
      this.width = width;
      return this;
   }

   public MachinePartNestingJobDetailDTO setHeight(final int height) {
      this.height = height;
      return this;
   }

   public MachinePartNestingJobDetailDTO setPartfile_path(final String partfile_path) {
      this.partfile_path = partfile_path;
      return this;
   }

   public MachinePartNestingJobDetailDTO setPartfile_url(final String partfile_url) {
      this.partfile_url = partfile_url;
      return this;
   }

   public MachinePartNestingJobDetailDTO setThumbnail_path(final String thumbnail_path) {
      this.thumbnail_path = thumbnail_path;
      return this;
   }

   public MachinePartNestingJobDetailDTO setThumbnail_url(final String thumbnail_url) {
      this.thumbnail_url = thumbnail_url;
      return this;
   }

   public MachinePartNestingJobDetailDTO setCreate_by(final int create_by) {
      this.create_by = create_by;
      return this;
   }

   public MachinePartNestingJobDetailDTO setUpdate_by(final int update_by) {
      this.update_by = update_by;
      return this;
   }

   @Override
   public String toString() {
      return "MachinePartNestingJobDetailDTO(guid="
         + this.getGuid()
         + ", partName="
         + this.getPartName()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", gas="
         + this.getGas()
         + ", amount="
         + this.getAmount()
         + ", un_nest_amount="
         + this.getUn_nest_amount()
         + ", in_nest_amount="
         + this.getIn_nest_amount()
         + ", finish_nest_amount="
         + this.getFinish_nest_amount()
         + ", un_cut_amount="
         + this.getUn_cut_amount()
         + ", in_cut_amount="
         + this.getIn_cut_amount()
         + ", finish_cut_amount="
         + this.getFinish_cut_amount()
         + ", width="
         + this.getWidth()
         + ", height="
         + this.getHeight()
         + ", partfile_path="
         + this.getPartfile_path()
         + ", partfile_url="
         + this.getPartfile_url()
         + ", thumbnail_path="
         + this.getThumbnail_path()
         + ", thumbnail_url="
         + this.getThumbnail_url()
         + ", create_by="
         + this.getCreate_by()
         + ", update_by="
         + this.getUpdate_by()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MachinePartNestingJobDetailDTO)) {
         return false;
      }

      MachinePartNestingJobDetailDTO other = (MachinePartNestingJobDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (Double.compare(this.getThickness(), other.getThickness()) != 0) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (this.getUn_nest_amount() != other.getUn_nest_amount()) {
         return false;
      }

      if (this.getIn_nest_amount() != other.getIn_nest_amount()) {
         return false;
      }

      if (this.getFinish_nest_amount() != other.getFinish_nest_amount()) {
         return false;
      }

      if (this.getUn_cut_amount() != other.getUn_cut_amount()) {
         return false;
      }

      if (this.getIn_cut_amount() != other.getIn_cut_amount()) {
         return false;
      }

      if (this.getFinish_cut_amount() != other.getFinish_cut_amount()) {
         return false;
      }

      if (this.getWidth() != other.getWidth()) {
         return false;
      }

      if (this.getHeight() != other.getHeight()) {
         return false;
      }

      if (this.getCreate_by() != other.getCreate_by()) {
         return false;
      }

      if (this.getUpdate_by() != other.getUpdate_by()) {
         return false;
      }

      Object this$guid = this.getGuid();
      Object other$guid = other.getGuid();
      if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
         Object this$partName = this.getPartName();
         Object other$partName = other.getPartName();
         if (this$partName == null ? other$partName == null : this$partName.equals(other$partName)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$gas = this.getGas();
               Object other$gas = other.getGas();
               if (this$gas == null ? other$gas == null : this$gas.equals(other$gas)) {
                  Object this$partfile_path = this.getPartfile_path();
                  Object other$partfile_path = other.getPartfile_path();
                  if (this$partfile_path == null ? other$partfile_path == null : this$partfile_path.equals(other$partfile_path)) {
                     Object this$partfile_url = this.getPartfile_url();
                     Object other$partfile_url = other.getPartfile_url();
                     if (this$partfile_url == null ? other$partfile_url == null : this$partfile_url.equals(other$partfile_url)) {
                        Object this$thumbnail_path = this.getThumbnail_path();
                        Object other$thumbnail_path = other.getThumbnail_path();
                        if (this$thumbnail_path == null ? other$thumbnail_path == null : this$thumbnail_path.equals(other$thumbnail_path)) {
                           Object this$thumbnail_url = this.getThumbnail_url();
                           Object other$thumbnail_url = other.getThumbnail_url();
                           return this$thumbnail_url == null ? other$thumbnail_url == null : this$thumbnail_url.equals(other$thumbnail_url);
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
      return other instanceof MachinePartNestingJobDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      long $thickness = Double.doubleToLongBits(this.getThickness());
      result = result * 59 + (int)($thickness >>> 32 ^ $thickness);
      result = result * 59 + this.getAmount();
      result = result * 59 + this.getUn_nest_amount();
      result = result * 59 + this.getIn_nest_amount();
      result = result * 59 + this.getFinish_nest_amount();
      result = result * 59 + this.getUn_cut_amount();
      result = result * 59 + this.getIn_cut_amount();
      result = result * 59 + this.getFinish_cut_amount();
      result = result * 59 + this.getWidth();
      result = result * 59 + this.getHeight();
      result = result * 59 + this.getCreate_by();
      result = result * 59 + this.getUpdate_by();
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $partName = this.getPartName();
      result = result * 59 + ($partName == null ? 43 : $partName.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $gas = this.getGas();
      result = result * 59 + ($gas == null ? 43 : $gas.hashCode());
      Object $partfile_path = this.getPartfile_path();
      result = result * 59 + ($partfile_path == null ? 43 : $partfile_path.hashCode());
      Object $partfile_url = this.getPartfile_url();
      result = result * 59 + ($partfile_url == null ? 43 : $partfile_url.hashCode());
      Object $thumbnail_path = this.getThumbnail_path();
      result = result * 59 + ($thumbnail_path == null ? 43 : $thumbnail_path.hashCode());
      Object $thumbnail_url = this.getThumbnail_url();
      return result * 59 + ($thumbnail_url == null ? 43 : $thumbnail_url.hashCode());
   }

   public static class MachinePartNestingJobDetailDTOBuilder {
      private String guid;
      private String partName;
      private String material;
      private double thickness;
      private String gas;
      private int amount;
      private int un_nest_amount;
      private int in_nest_amount;
      private int finish_nest_amount;
      private int un_cut_amount;
      private int in_cut_amount;
      private int finish_cut_amount;
      private int width;
      private int height;
      private String partfile_path;
      private String partfile_url;
      private String thumbnail_path;
      private String thumbnail_url;
      private int create_by;
      private int update_by;

      MachinePartNestingJobDetailDTOBuilder() {
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder partName(final String partName) {
         this.partName = partName;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder thickness(final double thickness) {
         this.thickness = thickness;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder gas(final String gas) {
         this.gas = gas;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder amount(final int amount) {
         this.amount = amount;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder un_nest_amount(final int un_nest_amount) {
         this.un_nest_amount = un_nest_amount;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder in_nest_amount(final int in_nest_amount) {
         this.in_nest_amount = in_nest_amount;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder finish_nest_amount(final int finish_nest_amount) {
         this.finish_nest_amount = finish_nest_amount;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder un_cut_amount(final int un_cut_amount) {
         this.un_cut_amount = un_cut_amount;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder in_cut_amount(final int in_cut_amount) {
         this.in_cut_amount = in_cut_amount;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder finish_cut_amount(final int finish_cut_amount) {
         this.finish_cut_amount = finish_cut_amount;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder width(final int width) {
         this.width = width;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder height(final int height) {
         this.height = height;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder partfile_path(final String partfile_path) {
         this.partfile_path = partfile_path;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder partfile_url(final String partfile_url) {
         this.partfile_url = partfile_url;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder thumbnail_path(final String thumbnail_path) {
         this.thumbnail_path = thumbnail_path;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder thumbnail_url(final String thumbnail_url) {
         this.thumbnail_url = thumbnail_url;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder create_by(final int create_by) {
         this.create_by = create_by;
         return this;
      }

      public MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder update_by(final int update_by) {
         this.update_by = update_by;
         return this;
      }

      public MachinePartNestingJobDetailDTO build() {
         return new MachinePartNestingJobDetailDTO(
            this.guid,
            this.partName,
            this.material,
            this.thickness,
            this.gas,
            this.amount,
            this.un_nest_amount,
            this.in_nest_amount,
            this.finish_nest_amount,
            this.un_cut_amount,
            this.in_cut_amount,
            this.finish_cut_amount,
            this.width,
            this.height,
            this.partfile_path,
            this.partfile_url,
            this.thumbnail_path,
            this.thumbnail_url,
            this.create_by,
            this.update_by
         );
      }

      @Override
      public String toString() {
         return "MachinePartNestingJobDetailDTO.MachinePartNestingJobDetailDTOBuilder(guid="
            + this.guid
            + ", partName="
            + this.partName
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", gas="
            + this.gas
            + ", amount="
            + this.amount
            + ", un_nest_amount="
            + this.un_nest_amount
            + ", in_nest_amount="
            + this.in_nest_amount
            + ", finish_nest_amount="
            + this.finish_nest_amount
            + ", un_cut_amount="
            + this.un_cut_amount
            + ", in_cut_amount="
            + this.in_cut_amount
            + ", finish_cut_amount="
            + this.finish_cut_amount
            + ", width="
            + this.width
            + ", height="
            + this.height
            + ", partfile_path="
            + this.partfile_path
            + ", partfile_url="
            + this.partfile_url
            + ", thumbnail_path="
            + this.thumbnail_path
            + ", thumbnail_url="
            + this.thumbnail_url
            + ", create_by="
            + this.create_by
            + ", update_by="
            + this.update_by
            + ")";
      }
   }
}
