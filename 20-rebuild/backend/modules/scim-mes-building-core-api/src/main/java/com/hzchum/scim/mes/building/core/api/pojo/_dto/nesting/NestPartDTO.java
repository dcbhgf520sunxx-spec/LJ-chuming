package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import io.swagger.annotations.ApiModel;
import java.util.List;

@ApiModel(value = "零件排产明细", description = "零件排产明细")
public class NestPartDTO {
   private String guid;
   private String part_name;
   private String material;
   private Integer thickness;
   private String drawing_name;
   private String job_id;
   private Double area;
   private Integer jobId;
   private List<PropsDTO> props;
   private Integer amount;

   public static NestPartDTO.NestPartDTOBuilder builder() {
      return new NestPartDTO.NestPartDTOBuilder();
   }

   public NestPartDTO(
      final String guid,
      final String part_name,
      final String material,
      final Integer thickness,
      final String drawing_name,
      final String job_id,
      final Double area,
      final Integer jobId,
      final List<PropsDTO> props,
      final Integer amount
   ) {
      this.guid = guid;
      this.part_name = part_name;
      this.material = material;
      this.thickness = thickness;
      this.drawing_name = drawing_name;
      this.job_id = job_id;
      this.area = area;
      this.jobId = jobId;
      this.props = props;
      this.amount = amount;
   }

   public NestPartDTO() {
   }

   public String getGuid() {
      return this.guid;
   }

   public String getPart_name() {
      return this.part_name;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getThickness() {
      return this.thickness;
   }

   public String getDrawing_name() {
      return this.drawing_name;
   }

   public String getJob_id() {
      return this.job_id;
   }

   public Double getArea() {
      return this.area;
   }

   public Integer getJobId() {
      return this.jobId;
   }

   public List<PropsDTO> getProps() {
      return this.props;
   }

   public Integer getAmount() {
      return this.amount;
   }

   public NestPartDTO setGuid(final String guid) {
      this.guid = guid;
      return this;
   }

   public NestPartDTO setPart_name(final String part_name) {
      this.part_name = part_name;
      return this;
   }

   public NestPartDTO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public NestPartDTO setThickness(final Integer thickness) {
      this.thickness = thickness;
      return this;
   }

   public NestPartDTO setDrawing_name(final String drawing_name) {
      this.drawing_name = drawing_name;
      return this;
   }

   public NestPartDTO setJob_id(final String job_id) {
      this.job_id = job_id;
      return this;
   }

   public NestPartDTO setArea(final Double area) {
      this.area = area;
      return this;
   }

   public NestPartDTO setJobId(final Integer jobId) {
      this.jobId = jobId;
      return this;
   }

   public NestPartDTO setProps(final List<PropsDTO> props) {
      this.props = props;
      return this;
   }

   public NestPartDTO setAmount(final Integer amount) {
      this.amount = amount;
      return this;
   }

   @Override
   public String toString() {
      return "NestPartDTO(guid="
         + this.getGuid()
         + ", part_name="
         + this.getPart_name()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", drawing_name="
         + this.getDrawing_name()
         + ", job_id="
         + this.getJob_id()
         + ", area="
         + this.getArea()
         + ", jobId="
         + this.getJobId()
         + ", props="
         + this.getProps()
         + ", amount="
         + this.getAmount()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NestPartDTO)) {
         return false;
      }

      NestPartDTO other = (NestPartDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$thickness = this.getThickness();
      Object other$thickness = other.getThickness();
      if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
         Object this$area = this.getArea();
         Object other$area = other.getArea();
         if (this$area == null ? other$area == null : this$area.equals(other$area)) {
            Object this$jobId = this.getJobId();
            Object other$jobId = other.getJobId();
            if (this$jobId == null ? other$jobId == null : this$jobId.equals(other$jobId)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                  Object this$guid = this.getGuid();
                  Object other$guid = other.getGuid();
                  if (this$guid == null ? other$guid == null : this$guid.equals(other$guid)) {
                     Object this$part_name = this.getPart_name();
                     Object other$part_name = other.getPart_name();
                     if (this$part_name == null ? other$part_name == null : this$part_name.equals(other$part_name)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$drawing_name = this.getDrawing_name();
                           Object other$drawing_name = other.getDrawing_name();
                           if (this$drawing_name == null ? other$drawing_name == null : this$drawing_name.equals(other$drawing_name)) {
                              Object this$job_id = this.getJob_id();
                              Object other$job_id = other.getJob_id();
                              if (this$job_id == null ? other$job_id == null : this$job_id.equals(other$job_id)) {
                                 Object this$props = this.getProps();
                                 Object other$props = other.getProps();
                                 return this$props == null ? other$props == null : this$props.equals(other$props);
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
      return other instanceof NestPartDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $jobId = this.getJobId();
      result = result * 59 + ($jobId == null ? 43 : $jobId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $guid = this.getGuid();
      result = result * 59 + ($guid == null ? 43 : $guid.hashCode());
      Object $part_name = this.getPart_name();
      result = result * 59 + ($part_name == null ? 43 : $part_name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $drawing_name = this.getDrawing_name();
      result = result * 59 + ($drawing_name == null ? 43 : $drawing_name.hashCode());
      Object $job_id = this.getJob_id();
      result = result * 59 + ($job_id == null ? 43 : $job_id.hashCode());
      Object $props = this.getProps();
      return result * 59 + ($props == null ? 43 : $props.hashCode());
   }

   public static class NestPartDTOBuilder {
      private String guid;
      private String part_name;
      private String material;
      private Integer thickness;
      private String drawing_name;
      private String job_id;
      private Double area;
      private Integer jobId;
      private List<PropsDTO> props;
      private Integer amount;

      NestPartDTOBuilder() {
      }

      public NestPartDTO.NestPartDTOBuilder guid(final String guid) {
         this.guid = guid;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder part_name(final String part_name) {
         this.part_name = part_name;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder thickness(final Integer thickness) {
         this.thickness = thickness;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder drawing_name(final String drawing_name) {
         this.drawing_name = drawing_name;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder job_id(final String job_id) {
         this.job_id = job_id;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder area(final Double area) {
         this.area = area;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder jobId(final Integer jobId) {
         this.jobId = jobId;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder props(final List<PropsDTO> props) {
         this.props = props;
         return this;
      }

      public NestPartDTO.NestPartDTOBuilder amount(final Integer amount) {
         this.amount = amount;
         return this;
      }

      public NestPartDTO build() {
         return new NestPartDTO(
            this.guid, this.part_name, this.material, this.thickness, this.drawing_name, this.job_id, this.area, this.jobId, this.props, this.amount
         );
      }

      @Override
      public String toString() {
         return "NestPartDTO.NestPartDTOBuilder(guid="
            + this.guid
            + ", part_name="
            + this.part_name
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", drawing_name="
            + this.drawing_name
            + ", job_id="
            + this.job_id
            + ", area="
            + this.area
            + ", jobId="
            + this.jobId
            + ", props="
            + this.props
            + ", amount="
            + this.amount
            + ")";
      }
   }
}
