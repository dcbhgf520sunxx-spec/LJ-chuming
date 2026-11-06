package com.hzchum.scim.wms.core.api.pojo._do.wmsConfig;

public class OutboundUpdateConfig {
   private Boolean quantity;
   private Boolean project;
   private Boolean mesWorkshop;
   private Boolean recipient;

   public static OutboundUpdateConfig.OutboundUpdateConfigBuilder builder() {
      return new OutboundUpdateConfig.OutboundUpdateConfigBuilder();
   }

   public Boolean getQuantity() {
      return this.quantity;
   }

   public Boolean getProject() {
      return this.project;
   }

   public Boolean getMesWorkshop() {
      return this.mesWorkshop;
   }

   public Boolean getRecipient() {
      return this.recipient;
   }

   public void setQuantity(final Boolean quantity) {
      this.quantity = quantity;
   }

   public void setProject(final Boolean project) {
      this.project = project;
   }

   public void setMesWorkshop(final Boolean mesWorkshop) {
      this.mesWorkshop = mesWorkshop;
   }

   public void setRecipient(final Boolean recipient) {
      this.recipient = recipient;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundUpdateConfig)) {
         return false;
      }

      OutboundUpdateConfig other = (OutboundUpdateConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$project = this.getProject();
         Object other$project = other.getProject();
         if (this$project == null ? other$project == null : this$project.equals(other$project)) {
            Object this$mesWorkshop = this.getMesWorkshop();
            Object other$mesWorkshop = other.getMesWorkshop();
            if (this$mesWorkshop == null ? other$mesWorkshop == null : this$mesWorkshop.equals(other$mesWorkshop)) {
               Object this$recipient = this.getRecipient();
               Object other$recipient = other.getRecipient();
               return this$recipient == null ? other$recipient == null : this$recipient.equals(other$recipient);
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
      return other instanceof OutboundUpdateConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $mesWorkshop = this.getMesWorkshop();
      result = result * 59 + ($mesWorkshop == null ? 43 : $mesWorkshop.hashCode());
      Object $recipient = this.getRecipient();
      return result * 59 + ($recipient == null ? 43 : $recipient.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundUpdateConfig(quantity="
         + this.getQuantity()
         + ", project="
         + this.getProject()
         + ", mesWorkshop="
         + this.getMesWorkshop()
         + ", recipient="
         + this.getRecipient()
         + ")";
   }

   public OutboundUpdateConfig(final Boolean quantity, final Boolean project, final Boolean mesWorkshop, final Boolean recipient) {
      this.quantity = quantity;
      this.project = project;
      this.mesWorkshop = mesWorkshop;
      this.recipient = recipient;
   }

   public OutboundUpdateConfig() {
   }

   public static class OutboundUpdateConfigBuilder {
      private Boolean quantity;
      private Boolean project;
      private Boolean mesWorkshop;
      private Boolean recipient;

      OutboundUpdateConfigBuilder() {
      }

      public OutboundUpdateConfig.OutboundUpdateConfigBuilder quantity(final Boolean quantity) {
         this.quantity = quantity;
         return this;
      }

      public OutboundUpdateConfig.OutboundUpdateConfigBuilder project(final Boolean project) {
         this.project = project;
         return this;
      }

      public OutboundUpdateConfig.OutboundUpdateConfigBuilder mesWorkshop(final Boolean mesWorkshop) {
         this.mesWorkshop = mesWorkshop;
         return this;
      }

      public OutboundUpdateConfig.OutboundUpdateConfigBuilder recipient(final Boolean recipient) {
         this.recipient = recipient;
         return this;
      }

      public OutboundUpdateConfig build() {
         return new OutboundUpdateConfig(this.quantity, this.project, this.mesWorkshop, this.recipient);
      }

      @Override
      public String toString() {
         return "OutboundUpdateConfig.OutboundUpdateConfigBuilder(quantity="
            + this.quantity
            + ", project="
            + this.project
            + ", mesWorkshop="
            + this.mesWorkshop
            + ", recipient="
            + this.recipient
            + ")";
      }
   }
}
