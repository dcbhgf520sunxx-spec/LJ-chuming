import { useStore as N } from "vuex";
import { computed as m } from "vue";
import { inject as x } from "vue";
import { watch as E } from "vue";
import { reactive as B } from "vue";
import { resolveComponent as L } from "vue";
import { resolveDirective as O } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as r } from "vue";
import { withCtx as s } from "vue";
import { unref as t } from "vue";
import { withDirectives as R } from "vue";
import { createTextVNode as T } from "vue";
import { toDisplayString as q } from "vue";
import { createBlock as A } from "vue";
import { ElDatePicker as F } from "element-plus";
import { ElInput as H } from "element-plus";
import { d as z, e as $ } from "../../../../../../modules/data-33e35578.js";
import { c as G } from "../../../../../../modules/payment-settlement-a7865af1.js";
import { uD as J, e3 as K, dp as M, cy as Q, e5 as W, b as h, e2 as X, ec as Y } from "../../../../../../shared/runtime.js";
import { u as Z } from "../../../../../../modules/hook-467b8301.js";
const ee = { class: "header-container" }, ae = { key: 0, class: "notSlotValue truncate" }, ce = { __name: "header", setup(te) {
  const f = N(), b = m(() => f.getters.user.id), V = x("pre_settlement_data"), { formData: e, projectInfo: i, resetForm: p } = V, g = m(() => J(K($, i)));
  E(() => b.value, (o) => {
    e.userId = o;
  }, { immediate: true });
  const { supplierList: v, contractNoList: n, getSupplierList: D, getPurchaseContractNumber: I } = Z({ form: e });
  D();
  const y = B({ pageSize: 10, pageNumber: 1 }), S = async () => {
    try {
      const o = await G({ orderId: e.orderId, ...y });
      if (!o.supplierSettlementEchoDtoPageVO) return X("warning", "该合同号暂无付款及开票记录");
      o == null || delete o.supplierSettlementEchoDtoPageVO;
      const c = Y([o]);
      Object.assign(i, ...c), Object.assign(e, ...c);
    } catch (o) {
      console.log(o);
    }
  }, U = () => {
    e.orderId = null, n.value = [], p(), h(e.supplierId) || I({ boolSettleUse: true, boolPreSettleUse: true });
  }, k = async () => {
    p(), h(e.orderId) || await S();
  };
  return (o, c) => {
    const j = F, u = L("common-select-v2"), C = H, P = O("ellipsis");
    return d(), _("div", ee, [r(M, { "header-title": "基本信息" }), r(W, { column: 2, "form-data": t(e), "form-rules": t(z), "table-list": g.value }, { createTime: s(({ item: a }) => [r(j, { modelValue: t(e)[a], "onUpdate:modelValue": (l) => t(e)[a] = l, clearable: "", placeholder: "请选择创建日期", type: "date", "value-format": "x" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), userId: s(({ item: a }) => [r(Q, { modelValue: t(e)[a], "onUpdate:modelValue": (l) => t(e)[a] = l, clearable: false, filterable: "", placeholder: "选择创建人" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), supplierId: s(({ item: a }) => [r(u, { modelValue: t(e)[a], "onUpdate:modelValue": (l) => t(e)[a] = l, options: t(v), clearable: "", filterable: "", placeholder: "请输入或选择供应商", type: "other", onChange: U }, null, 8, ["modelValue", "onUpdate:modelValue", "options"])]), orderId: s(({ item: a }) => [r(u, { modelValue: t(e)[a], "onUpdate:modelValue": (l) => t(e)[a] = l, disabled: !t(n).length, options: t(n), clearable: "", filterable: "", placeholder: "请输入或选择采购合同号", type: "other", onChange: k }, null, 8, ["modelValue", "onUpdate:modelValue", "disabled", "options"])]), projectName: s(({ val: a, label: l }) => [a ? R((d(), _("div", ae, [T(q(a.split("/").filter(Boolean).map((w) => `【${w}】`).join(" ")), 1)])), [[P]]) : (d(), A(C, { key: 1, placeholder: l, readonly: "" }, null, 8, ["placeholder"]))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} };
export {
  ce as default
};
