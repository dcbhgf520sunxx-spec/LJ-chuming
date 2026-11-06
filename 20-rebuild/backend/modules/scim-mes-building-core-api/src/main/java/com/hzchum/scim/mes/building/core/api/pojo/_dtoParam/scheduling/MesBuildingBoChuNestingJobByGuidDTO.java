package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "MesBuildingBoChuNestingJobByGuidDTO", description = "零件套料排版查询")
public class MesBuildingBoChuNestingJobByGuidDTO {
   private String uuid;
   private String plate_guid;
   private int amount;
   private int plate_type;
   private List<MesBuildingBoChuNestingResultByGuidJob> job_list;

   public static MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder builder() {
      return new MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder();
   }

   public MesBuildingBoChuNestingJobByGuidDTO(
      final String uuid, final String plate_guid, final int amount, final int plate_type, final List<MesBuildingBoChuNestingResultByGuidJob> job_list
   ) {
      this.uuid = uuid;
      this.plate_guid = plate_guid;
      this.amount = amount;
      this.plate_type = plate_type;
      this.job_list = job_list;
   }

   public MesBuildingBoChuNestingJobByGuidDTO() {
   }

   public String getUuid() {
      return this.uuid;
   }

   public String getPlate_guid() {
      return this.plate_guid;
   }

   public int getAmount() {
      return this.amount;
   }

   public int getPlate_type() {
      return this.plate_type;
   }

   public List<MesBuildingBoChuNestingResultByGuidJob> getJob_list() {
      return this.job_list;
   }

   public MesBuildingBoChuNestingJobByGuidDTO setUuid(final String uuid) {
      this.uuid = uuid;
      return this;
   }

   public MesBuildingBoChuNestingJobByGuidDTO setPlate_guid(final String plate_guid) {
      this.plate_guid = plate_guid;
      return this;
   }

   public MesBuildingBoChuNestingJobByGuidDTO setAmount(final int amount) {
      this.amount = amount;
      return this;
   }

   public MesBuildingBoChuNestingJobByGuidDTO setPlate_type(final int plate_type) {
      this.plate_type = plate_type;
      return this;
   }

   public MesBuildingBoChuNestingJobByGuidDTO setJob_list(final List<MesBuildingBoChuNestingResultByGuidJob> job_list) {
      this.job_list = job_list;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingBoChuNestingJobByGuidDTO(uuid="
         + this.getUuid()
         + ", plate_guid="
         + this.getPlate_guid()
         + ", amount="
         + this.getAmount()
         + ", plate_type="
         + this.getPlate_type()
         + ", job_list="
         + this.getJob_list()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingBoChuNestingJobByGuidDTO)) {
         return false;
      }

      MesBuildingBoChuNestingJobByGuidDTO other = (MesBuildingBoChuNestingJobByGuidDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (this.getPlate_type() != other.getPlate_type()) {
         return false;
      }

      Object this$uuid = this.getUuid();
      Object other$uuid = other.getUuid();
      if (this$uuid == null ? other$uuid == null : this$uuid.equals(other$uuid)) {
         Object this$plate_guid = this.getPlate_guid();
         Object other$plate_guid = other.getPlate_guid();
         if (this$plate_guid == null ? other$plate_guid == null : this$plate_guid.equals(other$plate_guid)) {
            Object this$job_list = this.getJob_list();
            Object other$job_list = other.getJob_list();
            return this$job_list == null ? other$job_list == null : this$job_list.equals(other$job_list);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingBoChuNestingJobByGuidDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAmount();
      result = result * 59 + this.getPlate_type();
      Object $uuid = this.getUuid();
      result = result * 59 + ($uuid == null ? 43 : $uuid.hashCode());
      Object $plate_guid = this.getPlate_guid();
      result = result * 59 + ($plate_guid == null ? 43 : $plate_guid.hashCode());
      Object $job_list = this.getJob_list();
      return result * 59 + ($job_list == null ? 43 : $job_list.hashCode());
   }

   public static class MesBuildingBoChuNestingJobByGuidDTOBuilder {
      private String uuid;
      private String plate_guid;
      private int amount;
      private int plate_type;
      private List<MesBuildingBoChuNestingResultByGuidJob> job_list;

      MesBuildingBoChuNestingJobByGuidDTOBuilder() {
      }

      public MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder uuid(final String uuid) {
         this.uuid = uuid;
         return this;
      }

      public MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder plate_guid(final String plate_guid) {
         this.plate_guid = plate_guid;
         return this;
      }

      public MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder amount(final int amount) {
         this.amount = amount;
         return this;
      }

      public MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder plate_type(final int plate_type) {
         this.plate_type = plate_type;
         return this;
      }

      public MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder job_list(
         final List<MesBuildingBoChuNestingResultByGuidJob> job_list
      ) {
         this.job_list = job_list;
         return this;
      }

      public MesBuildingBoChuNestingJobByGuidDTO build() {
         return new MesBuildingBoChuNestingJobByGuidDTO(this.uuid, this.plate_guid, this.amount, this.plate_type, this.job_list);
      }

      @Override
      public String toString() {
         return "MesBuildingBoChuNestingJobByGuidDTO.MesBuildingBoChuNestingJobByGuidDTOBuilder(uuid="
            + this.uuid
            + ", plate_guid="
            + this.plate_guid
            + ", amount="
            + this.amount
            + ", plate_type="
            + this.plate_type
            + ", job_list="
            + this.job_list
            + ")";
      }
   }
}
