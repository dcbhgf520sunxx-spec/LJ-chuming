import { ref as p } from "vue";
import w from "moment";
import { watch as C } from "vue";
import { onMounted as H } from "vue";
import { openBlock as f } from "vue";
import { createElementBlock as k } from "vue";
import { createElementVNode as y } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as q } from "vue";
import { createBlock as D } from "vue";
import { withCtx as s } from "vue";
import { unref as l } from "vue";
import { ElDatePicker as V } from "element-plus";
import { ElCol as E } from "element-plus";
import { ElRow as A } from "element-plus";
import { ElDivider as I } from "element-plus";
import { vLoading as M } from "element-plus";
import { P } from "../../../modules/index-5b9e6004.js";
import { g as B } from "./module/order-detail.vue.js";
import { _ as Y, o as $, G as L, iH as N } from "../../../shared/runtime.js";
import { c as r } from "../../../modules/operation-4e9312fe.js";
import S from "./module/order-quantity-statistics.vue.js";
import U from "./module/order-amount-statistics.vue.js";
import z from "./module/order-mete-statistics.vue.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const G = { class: "app-container" }, O = { class: "head-container" }, Q = { class: "content-warp" }, R = { __name: "index", setup(j) {
  const { maxHeight: i } = $({ extraBox: [".panel-group", ".head-container"], extraHeight: 60 }), a = p({ yearDate: w().valueOf(), branchCompanyId: void 0, workshopId: void 0 }), c = p(false), t = p({});
  C(() => a.value, (o) => {
    _();
  }, { deep: true }), H(() => {
    _();
  });
  function h(o) {
    return o > /* @__PURE__ */ new Date();
  }
  async function _() {
    if (L(r.get)) try {
      c.value = true;
      const o = await B({ ...a.value });
      t.value = o || {}, t.value.contractAmount = t.value.contractAmount / 1e4, t.value.deepMete = t.value.deepMete / 1e3;
    } catch (o) {
      console.log(o);
    } finally {
      c.value = false;
    }
  }
  return (o, n) => {
    const x = V, u = P, d = E, g = A, v = I, b = M;
    return f(), k("div", G, [y("div", O, [e(x, { modelValue: a.value.yearDate, "onUpdate:modelValue": n[0] || (n[0] = (m) => a.value.yearDate = m), type: "year", size: "default", "value-format": "x", format: "YYYY", clearable: false, placeholder: "选择年份", style: { width: "120px" }, class: "filter-item", "disabled-date": h }, null, 8, ["modelValue"]), e(N, { modelValue: a.value.branchCompanyId, "onUpdate:modelValue": n[1] || (n[1] = (m) => a.value.branchCompanyId = m), class: "filter-item", clearable: "", placeholder: "选择分支机构", style: { width: "260px" } }, null, 8, ["modelValue"])]), q((f(), D(g, { gutter: 24, class: "panel-group" }, { default: s(() => [e(d, { span: 8, class: "card-panel-col" }, { default: s(() => [e(u, { name: "订单数量", "text-color": "#626262", "num-color": "#337ECC", "end-val": t.value.contractQuantity || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(d, { span: 8, class: "card-panel-col" }, { default: s(() => [e(u, { name: "合同额（万元）", "text-color": "#626262", "num-color": "#67C23A", "end-val": t.value.contractAmount || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 }), e(d, { span: 8, class: "card-panel-col" }, { default: s(() => [e(u, { name: "清单量（吨）", "text-color": "#626262", "num-color": "#337ECC", "end-val": t.value.deepMete || 0, precision: 0 }, null, 8, ["end-val"])]), _: 1 })]), _: 1 })), [[b, c.value]]), y("div", Q, [e(S, { query: a.value, maxHeight: l(i) / 2, permission: l(r) }, null, 8, ["query", "maxHeight", "permission"]), e(v, { class: "divider" }), e(U, { query: a.value, maxHeight: l(i) / 2, permission: l(r) }, null, 8, ["query", "maxHeight", "permission"]), e(v, { class: "divider" }), e(z, { query: a.value, maxHeight: l(i) / 2, permission: l(r) }, null, 8, ["query", "maxHeight", "permission"])])]);
  };
} }, le = Y(R, [["__scopeId", "data-v-296528b6"]]);
export {
  le as default
};
