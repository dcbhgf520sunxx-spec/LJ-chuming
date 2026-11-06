package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "MachinePartNestingPdfDTO", description = "车间班组对象")
public class AbnormalInfoDTO {
   private int amount;
   private int count;
   private List<AbnormalInfoListDTO> list;
   private String result_guid;
   private String result_uuid;

   public static AbnormalInfoDTO.AbnormalInfoDTOBuilder builder() {
      return new AbnormalInfoDTO.AbnormalInfoDTOBuilder();
   }

   public AbnormalInfoDTO(final int amount, final int count, final List<AbnormalInfoListDTO> list, final String result_guid, final String result_uuid) {
      this.amount = amount;
      this.count = count;
      this.list = list;
      this.result_guid = result_guid;
      this.result_uuid = result_uuid;
   }

   public AbnormalInfoDTO() {
   }

   public int getAmount() {
      return this.amount;
   }

   public int getCount() {
      return this.count;
   }

   public List<AbnormalInfoListDTO> getList() {
      return this.list;
   }

   public String getResult_guid() {
      return this.result_guid;
   }

   public String getResult_uuid() {
      return this.result_uuid;
   }

   public AbnormalInfoDTO setAmount(final int amount) {
      this.amount = amount;
      return this;
   }

   public AbnormalInfoDTO setCount(final int count) {
      this.count = count;
      return this;
   }

   public AbnormalInfoDTO setList(final List<AbnormalInfoListDTO> list) {
      this.list = list;
      return this;
   }

   public AbnormalInfoDTO setResult_guid(final String result_guid) {
      this.result_guid = result_guid;
      return this;
   }

   public AbnormalInfoDTO setResult_uuid(final String result_uuid) {
      this.result_uuid = result_uuid;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalInfoDTO(amount="
         + this.getAmount()
         + ", count="
         + this.getCount()
         + ", list="
         + this.getList()
         + ", result_guid="
         + this.getResult_guid()
         + ", result_uuid="
         + this.getResult_uuid()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AbnormalInfoDTO)) {
         return false;
      }

      AbnormalInfoDTO other = (AbnormalInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getAmount() != other.getAmount()) {
         return false;
      }

      if (this.getCount() != other.getCount()) {
         return false;
      }

      Object this$list = this.getList();
      Object other$list = other.getList();
      if (this$list == null ? other$list == null : this$list.equals(other$list)) {
         Object this$result_guid = this.getResult_guid();
         Object other$result_guid = other.getResult_guid();
         if (this$result_guid == null ? other$result_guid == null : this$result_guid.equals(other$result_guid)) {
            Object this$result_uuid = this.getResult_uuid();
            Object other$result_uuid = other.getResult_uuid();
            return this$result_uuid == null ? other$result_uuid == null : this$result_uuid.equals(other$result_uuid);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getAmount();
      result = result * 59 + this.getCount();
      Object $list = this.getList();
      result = result * 59 + ($list == null ? 43 : $list.hashCode());
      Object $result_guid = this.getResult_guid();
      result = result * 59 + ($result_guid == null ? 43 : $result_guid.hashCode());
      Object $result_uuid = this.getResult_uuid();
      return result * 59 + ($result_uuid == null ? 43 : $result_uuid.hashCode());
   }

   public static class AbnormalInfoDTOBuilder {
      private int amount;
      private int count;
      private List<AbnormalInfoListDTO> list;
      private String result_guid;
      private String result_uuid;

      AbnormalInfoDTOBuilder() {
      }

      public AbnormalInfoDTO.AbnormalInfoDTOBuilder amount(final int amount) {
         this.amount = amount;
         return this;
      }

      public AbnormalInfoDTO.AbnormalInfoDTOBuilder count(final int count) {
         this.count = count;
         return this;
      }

      public AbnormalInfoDTO.AbnormalInfoDTOBuilder list(final List<AbnormalInfoListDTO> list) {
         this.list = list;
         return this;
      }

      public AbnormalInfoDTO.AbnormalInfoDTOBuilder result_guid(final String result_guid) {
         this.result_guid = result_guid;
         return this;
      }

      public AbnormalInfoDTO.AbnormalInfoDTOBuilder result_uuid(final String result_uuid) {
         this.result_uuid = result_uuid;
         return this;
      }

      public AbnormalInfoDTO build() {
         return new AbnormalInfoDTO(this.amount, this.count, this.list, this.result_guid, this.result_uuid);
      }

      @Override
      public String toString() {
         return "AbnormalInfoDTO.AbnormalInfoDTOBuilder(amount="
            + this.amount
            + ", count="
            + this.count
            + ", list="
            + this.list
            + ", result_guid="
            + this.result_guid
            + ", result_uuid="
            + this.result_uuid
            + ")";
      }
   }
}
