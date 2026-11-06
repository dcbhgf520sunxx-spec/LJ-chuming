package com.hzchum.scim.scm.core.api.pojo.dto;

public class ProjectInfoDTO {
   private Long id;
   private String name;
   private String shortName;
   private String serialNumber;

   public static ProjectInfoDTO.ProjectInfoDTOBuilder builder() {
      return new ProjectInfoDTO.ProjectInfoDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInfoDTO)) {
         return false;
      }

      ProjectInfoDTO other = (ProjectInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            if (this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof ProjectInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      result = result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInfoDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", shortName="
         + this.getShortName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   public ProjectInfoDTO(final Long id, final String name, final String shortName, final String serialNumber) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
      this.serialNumber = serialNumber;
   }

   public ProjectInfoDTO() {
   }

   public static class ProjectInfoDTOBuilder {
      private Long id;
      private String name;
      private String shortName;
      private String serialNumber;

      ProjectInfoDTOBuilder() {
      }

      public ProjectInfoDTO.ProjectInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInfoDTO.ProjectInfoDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInfoDTO.ProjectInfoDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public ProjectInfoDTO.ProjectInfoDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectInfoDTO build() {
         return new ProjectInfoDTO(this.id, this.name, this.shortName, this.serialNumber);
      }

      @Override
      public String toString() {
         return "ProjectInfoDTO.ProjectInfoDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", shortName="
            + this.shortName
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
