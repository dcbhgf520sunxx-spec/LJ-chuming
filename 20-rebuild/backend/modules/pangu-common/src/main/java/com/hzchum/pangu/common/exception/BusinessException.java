package com.hzchum.pangu.common.exception;

import com.hzchum.pangu.common.base.IResultCode;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;

public class BusinessException extends RuntimeException {
   private ResultVO result;
   private IResultCode resultCode;

   public BusinessException(String msg) {
      super(msg);
      this.resultCode = ResultCodeEnum.ERROR;
      this.result = ResultBuilder.failed(msg, this.resultCode);
   }

   public BusinessException(IResultCode resultCode, String msg) {
      super(msg);
      this.resultCode = resultCode;
      this.result = ResultBuilder.failed(msg, resultCode);
   }

   public BusinessException(IResultCode resultCode) {
      super(resultCode.getMessage());
      this.resultCode = resultCode;
      this.result = ResultBuilder.failed(resultCode);
   }

   public ResultVO getResult() {
      return this.result;
   }

   public IResultCode getResultCode() {
      return this.resultCode;
   }
}
