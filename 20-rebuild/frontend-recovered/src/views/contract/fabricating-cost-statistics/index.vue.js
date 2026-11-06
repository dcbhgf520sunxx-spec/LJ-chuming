import { ref as n } from "vue";
import { computed as T } from "vue";
import { provide as V } from "vue";
import { resolveComponent as M } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as _ } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { withDirectives as A } from "vue";
import { createBlock as b } from "vue";
import { withCtx as r } from "vue";
import { createElementVNode as d } from "vue";
import { toDisplayString as s } from "vue";
import { createTextVNode as U } from "vue";
import { resolveDynamicComponent as R } from "vue";
import { createCommentVNode as j } from "vue";
import { nextTick as Y } from "vue";
import { ElTableColumn as E } from "element-plus";
import { ElTag as q } from "element-plus";
import { vLoading as H } from "element-plus";
import { C as S } from "../../../modules/fabricating-cost-statistics-5d4cd0ec.js";
import { x as $, D as u, o as F, c1 as k, P as L } from "../../../shared/runtime.js";
import z from "./module/header.vue.js";
import G from "./cumulative-cost/index.vue.js";
import { z as J } from "../../../modules/contract-9b18cc88.js";
import K from "./cost-details/main-business-income.vue.js";
import O from "./cost-details/no-main-business-income.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "./cost-details/principal-material-cost.vue.js";
import "./cost-details/material-direct-cost.vue.js";
import "./cost-details/material-amortization-cost.vue.js";
import "./cost-details/material-amortization-cost-details.vue.js";
import "../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../modules/bimfaceAPI-c2661893.js";
import "../../../modules/model-0ac957f7.js";
import "./cost-details/material-paint-cost.vue.js";
import "./cost-details/welding-material-cost.vue.js";
import "./cost-details/other-steel-materials.vue.js";
import "./cost-details/production-labor-cost.vue.js";
import "./cost-details/odd-jobs-amortization.vue.js";
import "./cost-details/managerial-staff-amortization.vue.js";
import "./cost-details/material-construction-site-cost.vue.js";
import "./cost-details/material-construction-site-cost-payment.vue.js";
import "./cost-details/transport-cost.vue.js";
import "./cost-details/water-electricity-amortization.vue.js";
import "./cost-details/gas-fee.vue.js";
import "./cost-details/gas-direct-cost.vue.js";
import "./cost-details/property-amortization.vue.js";
import "./cost-details/direct-cost.vue.js";
import "./cost-details/amortization-cost.vue.js";
import "./cost-details/factory-depreciation.vue.js";
import "./cost-details/equipment-depreciation.vue.js";
import "./cost-details/testing-fee.vue.js";
import "./cost-details/finished-product-scrap-loss.vue.js";
import "./cost-details/manuf-return-repair.vue.js";
import "./cost-details/manuf-reuse.vue.js";
const Q = { class: "app-container" }, W = ["onClick"], X = ["onClick"], Z = { key: 1 }, ee = ["onClick"], He = { __name: "index", setup(te) {
  const g = n(), v = n(false), h = n(), p = n(), w = n(false);
  n();
  const { crud: c } = $({ title: "制造成本统计", sort: [], permission: { ...J }, crudApi: { ...S }, hasPagination: true }, g), B = n([["cumulativeCost", ["to-thousand", u.YUAN]], ["mainBusinessIncome", ["to-thousand", u.YUAN]], ["nonMainBusinessIncome", ["to-thousand", u.YUAN]], ["incomeTotal", ["to-thousand", u.YUAN]], ["grossProfit", ["to-thousand", u.YUAN]]]);
  function y(f, i) {
    p.value = f, h.value = i, Y(() => {
      w.value = true;
    });
  }
  const C = T(() => {
    switch (h.value) {
      case "mainBusinessIncome":
        return K;
      case "nonMainBusinessIncome":
        return O;
      default:
        return null;
    }
  }), { maxHeight: x } = F({ paginate: true });
  function I(f) {
    v.value = true, p.value = f;
  }
  return V("query", c.query), (f, i) => {
    const o = E, D = q, N = M("common-table"), P = H;
    return m(), _("div", Q, [t(a(z)), A((m(), b(N, { ref_key: "tableRef", ref: g, data: a(c).data, "data-format": B.value, "empty-text": a(c).emptyText, "max-height": a(x) }, { default: r(() => [t(o, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(o, { align: "center", key: "createTime", prop: "createTime", "show-overflow-tooltip": true, label: "立项日期" }), t(o, { align: "center", key: "projectName", prop: "projectName", "show-overflow-tooltip": true, label: "项目", width: "240px" }, { default: r((e) => [d("span", null, s(e.row.serialNumber) + " " + s(e.row.projectName), 1)]), _: 1 }), t(o, { align: "center", key: "status", prop: "status", "show-overflow-tooltip": true, label: "状态" }, { default: r((e) => {
      var l;
      return [t(D, { type: (l = a(k).V[e.row.status]) == null ? void 0 : l.TAG }, { default: r(() => [U(s(a(k).VL[e.row.status]), 1)]), _: 2 }, 1032, ["type"])];
    }), _: 1 }), t(o, { align: "center", key: "mainBusinessIncome", prop: "mainBusinessIncome", "show-overflow-tooltip": true, label: "主营业务收入" }, { default: r((e) => [d("span", { onClick: (l) => y(e.row, "mainBusinessIncome"), style: { cursor: "pointer", color: "#409eff" } }, s(e.row.mainBusinessIncome), 9, W)]), _: 1 }), t(o, { align: "center", key: "nonMainBusinessIncome", prop: "nonMainBusinessIncome", "show-overflow-tooltip": true, label: "非主营业务收入" }, { default: r((e) => [e.row.nonMainBusinessIncome ? (m(), _("span", { key: 0, onClick: (l) => y(e.row, "nonMainBusinessIncome"), style: { cursor: "pointer", color: "#409eff" } }, s(e.row.nonMainBusinessIncome), 9, X)) : (m(), _("span", Z, "-"))]), _: 1 }), t(o, { align: "center", key: "incomeTotal", prop: "incomeTotal", "show-overflow-tooltip": true, label: "收入合计" }), t(o, { align: "center", key: "cumulativeCost", prop: "cumulativeCost", "show-overflow-tooltip": true, label: "累计成本" }, { default: r((e) => [d("span", { onClick: (l) => I(e.row), style: { cursor: "pointer", color: "#409eff" } }, s(e.row.cumulativeCost || "-"), 9, ee)]), _: 1 }), t(o, { align: "center", key: "grossProfit", prop: "grossProfit", "show-overflow-tooltip": true, label: "毛利润" }), t(o, { align: "center", key: "grossProfitRate", prop: "grossProfitRate", "show-overflow-tooltip": true, label: "毛利率" }, { default: r((e) => [d("span", null, s(e.row.grossProfitRate ? (e.row.grossProfitRate * 100).toFixed(2) : "0") + "%", 1)]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "empty-text", "max-height"])), [[P, a(c).loading]]), t(a(G), { visible: v.value, "onUpdate:visible": i[0] || (i[0] = (e) => v.value = e), currentData: p.value }, null, 8, ["visible", "currentData"]), C.value ? (m(), b(R(C.value), { key: 0, modelValue: w.value, "onUpdate:modelValue": i[1] || (i[1] = (e) => w.value = e), currentData: p.value }, null, 8, ["modelValue", "currentData"])) : j("", true), t(a(L))]);
  };
} };
export {
  He as default
};
