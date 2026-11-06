import { inject as f } from "vue";
import { toRef as p } from "vue";
import { computed as _ } from "vue";
import { watch as b } from "vue";
import { nextTick as o } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as k } from "vue";
import { createVNode as s } from "vue";
import { withCtx as h } from "vue";
import { unref as t } from "vue";
import { ElInput as g } from "element-plus";
import { dZ as v, e3 as A, e5 as I } from "../../../../../../../shared/runtime.js";
const w = [{ key: "applyDate", label: "申请日期", verify: true }, { key: "projectAttribute", label: "项目类型" }, { key: "applyUserId", label: "申请人" }, { key: "projectId", label: "项目", verify: true }, { key: "projectManagerId", label: "项目经理", verify: true }, { key: "supplierId", label: "供应商", verify: true }, { key: "signatoryName", label: "签约主体" }, { key: "purchaseContractNumber", label: "采购合同号", verify: true }, { key: "contractAmount", label: "合同额" }, { key: "basicClass", label: "物资类型" }];
v(w);
const x = [{ key: "amount", label: "合同额" }, { key: "settlementAmount", label: "最终结算额", verify: true }, { key: "remainingAmount", label: "剩余发票额" }], V = { settlementAmount: [{ required: true, message: "最终结算额不能为空", trigger: ["change", "blur"] }] }, j = { class: "contract-info-container" }, L = { __name: "contract-info", setup(B) {
  const n = f("settlement_data"), { formData: e, contractListInfo: a } = n, c = p(n, "headerRef"), u = _(() => A(x, a));
  return b(() => e.settlementAmount, (l) => {
    l ? o(() => {
      a.remainingAmount = parseFloat(l) - c.value.invoiceInfo.sum;
    }) : o(() => {
      a.remainingAmount = null;
    });
  }), (l, D) => {
    const m = g;
    return y(), k("div", j, [s(I, { column: 3, "form-data": t(e), "form-rules": t(V), "table-list": u.value, "item-width": "10vw" }, { settlementAmount: h(({ item: r, blur: i }) => [s(m, { modelValue: t(e)[r], "onUpdate:modelValue": (d) => t(e)[r] = d, modelModifiers: { number: true }, clearable: "", placeholder: "请输入最终结算额", type: "number", onBlur: i }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  L as default
};
