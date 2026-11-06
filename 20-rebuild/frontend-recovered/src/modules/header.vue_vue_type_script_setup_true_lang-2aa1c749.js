import { defineComponent as b } from "vue";
import { ref as c } from "vue";
import { resolveComponent as V } from "vue";
import { openBlock as u } from "vue";
import { createElementBlock as D } from "vue";
import { withDirectives as k } from "vue";
import { vShow as I } from "vue";
import { unref as a } from "vue";
import { createElementVNode as w } from "vue";
import { createVNode as r } from "vue";
import { withCtx as i } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as x } from "vue";
import { createBlock as O } from "vue";
import { createCommentVNode as T } from "vue";
import { ElDatePicker as W } from "element-plus";
import { ElTag as L } from "element-plus";
import { B as Q, kg as U, iH as q, C as E, G as y, E as N } from "../shared/runtime.js";
import { g as R } from "./product-waste-c86c76d6.js";
import { g as A } from "./scrap-sell-e306ced6.js";
const H = { class: "head-container" }, G = b({ __name: "header", setup(S) {
  const g = { date: [], startDate: void 0, endDate: void 0, branchCompanyId: void 0, contractWasteId: void 0 }, { crud: n, query: t, CRUD: f } = Q(g), d = c(0), m = c([]), h = c([]);
  _();
  async function _() {
    try {
      const { content: o } = await A();
      h.value = o, m.value = o.map((e) => {
        const s = {};
        return s.id = e.id, s.name = e.purchaser, s;
      });
    } catch (o) {
      console.log("获取购买单位失败", o);
    }
  }
  async function p() {
    if (y(n.permission.get)) try {
      d.value = await R({ branchCompanyId: t.branchCompanyId, contractWasteId: t.contractWasteId });
    } catch (o) {
      console.log(o, "=========>");
    }
  }
  return p(), f.HOOK.beforeToQuery = (o) => {
    const { query: { date: e } } = o;
    e != null && e.length ? (t.startDate = e[0], t.endDate = e[1]) : (t.startDate = void 0, t.endDate = void 0), p(), console.log(t, "query");
  }, (o, e) => {
    const s = W, v = L, C = V("print-table");
    return u(), D("div", H, [k(w("div", null, [r(s, { modelValue: a(t).date, "onUpdate:modelValue": e[0] || (e[0] = (l) => a(t).date = l), class: "filter-item", "end-placeholder": "结束时间", "range-separator": "-", "start-placeholder": "开始时间", type: "daterange", "value-format": "x", onChange: a(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(U, { modelValue: a(t).contractWasteId, "onUpdate:modelValue": e[1] || (e[1] = (l) => a(t).contractWasteId = l), options: m.value, class: "filter-item", clearable: "", filterable: "", placeholder: "购买方", onChange: a(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(q, { modelValue: a(t).branchCompanyId, "onUpdate:modelValue": e[2] || (e[2] = (l) => a(t).branchCompanyId = l), class: "filter-item", clearable: "", placeholder: "出售方", style: { width: "200px" }, onChange: a(n).toQuery }, null, 8, ["modelValue", "onChange"]), r(a(E))], 512), [[I, a(n).searchToggle]]), r(a(N), null, { optLeft: i(() => [r(v, { type: "primary" }, { default: i(() => [B("累计出售金额：" + x(d.value) + "元", 1)]), _: 1 })]), viewLeft: i(() => [a(y)(a(n).permission.print) ? (u(), O(C, { key: 0, params: a(t), "api-key": "productWasteList", size: "default", type: "warning" }, null, 8, ["params"])) : T("", true)]), _: 1 })]);
  };
} });
export {
  G as _
};
