package com.hzchum.scim.project.core.api.biz;

import javax.servlet.http.HttpServletResponse;

public interface ProjectForeignVisaBiz {
   void exportSettlement(Long id, HttpServletResponse response);
}
