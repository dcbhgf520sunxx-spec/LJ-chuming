package com.hzchum.scim.bid.core.api.biz;

import com.hzchum.scim.bid.core.api.pojo._do.ProjectTendering;
import java.util.Date;
import java.util.List;
import org.springframework.scheduling.annotation.Async;

public interface MessageTemplateBiz {
   @Async
   void sendSupplier(ProjectTendering projectTendering, List<Long> ids, Date bidDeadline);

   @Async
   void sendSupplierOffer(ProjectTendering projectTendering, Integer round, String bidDead);
}
