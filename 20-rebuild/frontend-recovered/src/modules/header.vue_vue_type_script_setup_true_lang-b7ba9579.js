import { defineComponent as C } from "vue";
import { ref as v } from "vue";
import * as b from "lodash";
import { watch as V } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as D } from "vue";
import { withDirectives as U } from "vue";
import { vShow as k } from "vue";
import { unref as t } from "vue";
import { createElementVNode as I } from "vue";
import { createVNode as o } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as B } from "vue";
import { createBlock as T } from "vue";
import { createCommentVNode as E } from "vue";
import { ElDatePicker as O } from "element-plus";
import { ElInput as R } from "element-plus";
import { ElTag as q } from "element-plus";
import { B as A, G as u, iH as L, C as N, E as Q } from "../shared/runtime.js";
import { g as H } from "./product-recycling-d772694e.js";
const G = { class: "head-container" }, z = C({ __name: "header", setup(P) {
  const y = { date: [], startDate: void 0, endDate: void 0, branchCompanyId: void 0, customerUnit: void 0 }, { crud: n, query: e, CRUD: f } = A(y), d = v(0), g = b.debounce(l, 500);
  async function l() {
    if (u(n.permission.get)) try {
      d.value = await H({ branchCompanyId: e.branchCompanyId, customerUnit: e.customerUnit });
    } catch (r) {
      console.log(r, "=========>");
    }
  }
  return l(), V(() => [e.branchCompanyId, e.customerUnit], ([r, a], [m, c]) => {
    a !== c ? g() : l();
  }), f.HOOK.beforeToQuery = (r) => {
    const { query: { date: a } } = r;
    a != null && a.length ? (e.startDate = a[0], e.endDate = a[1]) : (e.startDate = void 0, e.endDate = void 0), console.log(e, "query");
  }, (r, a) => {
    const m = O, c = R, h = q, _ = w("print-table");
    return p(), D("div", G, [U(I("div", null, [o(m, { modelValue: t(e).date, "onUpdate:modelValue": a[0] || (a[0] = (s) => t(e).date = s), class: "filter-item", "end-placeholder": "结束时间", "range-separator": "-", "start-placeholder": "开始时间", type: "daterange", "value-format": "x", onChange: t(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(L, { modelValue: t(e).branchCompanyId, "onUpdate:modelValue": a[1] || (a[1] = (s) => t(e).branchCompanyId = s), class: "filter-item", clearable: "", placeholder: "合同签订主体", style: { width: "200px" }, onChange: t(n).toQuery }, null, 8, ["modelValue", "onChange"]), o(c, { modelValue: t(e).customerUnit, "onUpdate:modelValue": a[2] || (a[2] = (s) => t(e).customerUnit = s), class: "filter-item", placeholder: "出售方检索", style: { width: "200px" } }, null, 8, ["modelValue"]), o(t(N))], 512), [[k, t(n).searchToggle]]), o(t(Q), null, { optLeft: i(() => [o(h, { type: "primary" }, { default: i(() => [x("累计回收金额：" + B(d.value) + "元", 1)]), _: 1 })]), viewLeft: i(() => [t(u)(t(n).permission.print) ? (p(), T(_, { key: 0, params: t(e), "api-key": "returnLedgerList", size: "default", type: "warning" }, null, 8, ["params"])) : E("", true)]), _: 1 })]);
  };
} });
export {
  z as _
};
