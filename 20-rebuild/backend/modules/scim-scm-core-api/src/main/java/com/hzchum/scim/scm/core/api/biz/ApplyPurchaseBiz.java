package com.hzchum.scim.scm.core.api.biz;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public interface ApplyPurchaseBiz {
   void export(Long id, HttpServletResponse response) throws IOException;

   void applyTrackExport(Long id, HttpServletResponse response) throws IOException;
}
