package com.hzchum.pangu.common.exception;

import com.hzchum.pangu.common.base.IResultCode;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;

public class ParameterExpireException extends RuntimeException {
   private ResultVO result;
   private IResultCode resultCode;

   public ParameterExpireException(String msg) {
      super(msg);
      this.resultCode = ResultCodeEnum.PARAMETER_EXPIRE;
      this.result = ResultBuilder.failed(msg, this.resultCode);
   }

   public ParameterExpireException(String msg, Object data) {
      super(msg);
      this.resultCode = ResultCodeEnum.PARAMETER_EXPIRE;
      this.result = ResultBuilder.failed(data, msg, this.resultCode);
   }

   public ParameterExpireException(IResultCode resultCode) {
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
