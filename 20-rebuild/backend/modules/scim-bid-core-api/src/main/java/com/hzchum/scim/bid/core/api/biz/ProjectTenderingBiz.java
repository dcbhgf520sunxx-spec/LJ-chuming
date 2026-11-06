package com.hzchum.scim.bid.core.api.biz;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.scim.bid.core.api.pojo.dto.EvaluationBidDTO;
import com.hzchum.scim.bid.core.api.pojo.vo.ProjectTenderingVO;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
import javax.servlet.http.HttpServletResponse;
import org.springframework.scheduling.annotation.Async;

public interface ProjectTenderingBiz {
   ProjectTenderingVO getDetail(Long id);

   ListVO getDetailSupplier(Long id, Long supplierId);

   @Async
   Future<Boolean> saveSupplier(Long id, List<Long> ids);

   @Async
   Future<Boolean> evaluationBid(Long projectId, Long bidDeadline, Long bidOpeningTime, List<EvaluationBidDTO> evaluationBidDTOS);

   ProjectTenderingVO getManually(Long id);

   ListVO getEvaluation(Long id);

   void projectDetailExport(Long id, HttpServletResponse response) throws IOException;

   void projectExport(Long id, HttpServletResponse response) throws IOException;
}
