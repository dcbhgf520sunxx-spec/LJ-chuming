package com.hzchum.scim.system.core.api.common.enums;

public enum PermissionTypeEnum {
   EYE_OPEN(3L, "查看权", "eye-open", 1),
   WRITE(2L, "编辑权", "write", 2),
   DOWNLOAD(1L, "下载权", "download", 3),
   COMPLEX(4L, "复合权", "complex", 4);

   private Long id;
   private String name;
   private String icon;
   private Integer sort;

   PermissionTypeEnum(Long id, String name, String icon, Integer sort) {
      this.id = id;
      this.name = name;
      this.icon = icon;
      this.sort = sort;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getIcon() {
      return this.icon;
   }

   public Integer getSort() {
      return this.sort;
   }
}
