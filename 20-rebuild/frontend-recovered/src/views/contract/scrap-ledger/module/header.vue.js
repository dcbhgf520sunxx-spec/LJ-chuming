import { ref as t } from "vue";
import c from "moment";
import { resolveComponent as d } from "vue";
import { resolveDirective as N } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as P } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as u } from "vue";
import { withCtx as V } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as A } from "vue";
import { withDirectives as D } from "vue";
import { unref as k } from "vue";
import { createBlock as w } from "vue";
import { ElDatePicker as M } from "element-plus";
import { ElTag as R } from "element-plus";
import { b as Y, c as $ } from "../../../../modules/scrap-ledger-452ee452.js";
import { V as x } from "../../../../modules/contract-9b18cc88.js";
import F from "../contract/scrap-contract.vue.js";
import "../../../../shared/runtime.js";
import "../contract/add-contract.vue.js";
const G = { class: "head-container" }, H = { style: { display: "flex", "justify-content": "space-between" } }, J = { style: { display: "flex", "justify-content": "space-between" } }, te = { __name: "header", emits: ["wayChange", "dateChange", "typeChange"], setup(K, { emit: T }) {
  const p = T, O = t([{ label: "按购买方查询", value: 1 }, { label: "按日期查询", value: 2 }]), r = t(1), _ = t([]), m = t(false), g = t(), i = t([c().startOf("month").valueOf(), c().valueOf()]), o = t(c().startOf("month").valueOf()), n = t(c().valueOf()), s = t();
  v();
  async function v() {
    try {
      const { content: e } = await Y();
      _.value = e;
    } catch (e) {
      console.log(e);
    }
    try {
      const e = await $({ startDate: o.value, endDate: n.value, wasteClassificationId: s.value });
      g.value = e;
    } catch (e) {
      console.log(e);
    }
  }
  const z = () => {
    m.value = true;
  };
  async function B(e) {
    r.value = e, s.value = void 0, p("wayChange", r.value), v();
  }
  function S(e) {
    e && e.length > 1 ? (o.value = e[0], n.value = e[1]) : (o.value = void 0, n.value = void 0, i.value = []), i.value = e, v(), p("dateChange", o.value, n.value);
  }
  function U(e) {
    console.log(e), s.value = e, v(), p("typeChange", e);
  }
  return (e, a) => {
    const j = d("common-radio-button"), q = M, E = d("common-select"), I = d("common-button"), L = R, h = d("print-table"), C = N("permission");
    return f(), P("div", G, [y("div", H, [y("div", null, [u(j, { modelValue: r.value, "onUpdate:modelValue": a[0] || (a[0] = (l) => r.value = l), options: O.value, "data-structure": { key: "value", label: "label", value: "value" }, class: "filter-item", onChange: B }, null, 8, ["modelValue", "options"]), u(q, { modelValue: i.value, "onUpdate:modelValue": a[1] || (a[1] = (l) => i.value = l), type: "daterange", "range-separator": ":", size: "default", class: "filter-item", "value-format": "x", "start-placeholder": "开始日期", "end-placeholder": "结束日期", style: { width: "240px" }, onChange: S }, null, 8, ["modelValue"]), u(E, { placeholder: "请选择类型", size: "default", class: "filter-item", options: _.value, "data-structure": { key: "id", label: "name", value: "id" }, onChange: U, modelValue: s.value, "onUpdate:modelValue": a[2] || (a[2] = (l) => s.value = l), clearable: "" }, null, 8, ["options", "modelValue"])]), u(I, { type: "success", size: "default", class: "filter-item", onClick: z }, { default: V(() => a[4] || (a[4] = [b("合同配置")])), _: 1, __: [4] })]), y("div", J, [u(L, { size: "default" }, { default: V(() => [b("累计出售金额：" + A(g.value) + "元", 1)]), _: 1 }), r.value !== 1 ? D((f(), w(h, { key: 0, "api-key": "scrapDate", params: { startDate: o.value, endDate: n.value, wasteClassificationId: s.value }, size: "default" }, null, 8, ["params"])), [[C, k(x).print]]) : D((f(), w(h, { key: 1, "api-key": "scrapPurchaser", params: { startDate: o.value, endDate: n.value, wasteClassificationId: s.value } }, null, 8, ["params"])), [[C, k(x).print]])]), u(F, { modelValue: m.value, "onUpdate:modelValue": a[3] || (a[3] = (l) => m.value = l) }, null, 8, ["modelValue"])]);
  };
} };
export {
  te as default
};
