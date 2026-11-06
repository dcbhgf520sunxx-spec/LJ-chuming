import { _ as q, iF as G, G as u, a as b, e6 as W, j0 as V } from "../../../../../../shared/runtime.js";
import { inject as J } from "vue";
import { ref as s } from "vue";
import { provide as K } from "vue";
import { computed as Q } from "vue";
import { watch as h } from "vue";
import { resolveComponent as A } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as U } from "vue";
import { createElementVNode as i } from "vue";
import { createVNode as a } from "vue";
import { unref as t } from "vue";
import { withDirectives as X } from "vue";
import { createBlock as d } from "vue";
import { withCtx as p } from "vue";
import { createTextVNode as m } from "vue";
import { createCommentVNode as w } from "vue";
import { resolveDynamicComponent as Y } from "vue";
import { Fragment as Z } from "vue";
import { defineAsyncComponent as S } from "vue";
import { ElDatePicker as ee } from "element-plus";
import { ElButton as te } from "element-plus";
import { ElCascader as oe } from "element-plus";
import { vLoading as le } from "element-plus";
import { P } from "../../../../../../modules/index-5b9e6004.js";
import { g as ae, a as ne } from "../../../../../../modules/self-healing-29154caf.js";
import { W as v } from "../../../../../../modules/contract-9b18cc88.js";
import "../../../../../../modules/vue3-count-to.esm-8987f38d.js";
const se = { class: "head-container" }, re = { class: "date-container" }, ie = { class: "panel-group" }, ce = { class: "card-panel-col" }, ue = { class: "card-panel-col" }, de = { class: "card-panel-col" }, pe = { class: "create box-container" }, me = { class: "search-container box-container" }, ve = { __name: "header", setup(_e, { expose: I }) {
  const { formData: l, tableRef: x, projectLeaderList: E } = J("selfParentData"), k = s(false), _ = s([]), f = s(null), C = s([]), j = s([]);
  K("selfHeaderData", { projectTypeList: C, settleList: j, projectLeaderList: E });
  const L = async () => {
    if (u(v.secondUnit.self.get)) try {
      k.value = true, _.value = await ae(l.value);
    } catch (o) {
      console.error("获取台账汇总失败：", o);
    } finally {
      k.value = false;
    }
  };
  L(), (async () => {
    try {
      const { content: o } = await ne({ year: l.value.year });
      j.value = o.filter((e) => e.settlementStatus !== 1).map((e) => ({ ...e, newSerialNumber: e.serialNumber + "-" + e.shortName })), C.value = o.map((e) => ({ ...e, newSerialNumber: e.serialNumber + "-" + e.shortName }));
    } catch (o) {
      console.error("获取项目失败", o);
    }
  })();
  const T = s({ key: "id", value: "id", label: "newSerialNumber" }), D = s(""), O = { collection: S(() => V(() => import("../../../common/components/estabish/collection.vue.js"), ["static/js/collection-232c959c.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/rules-3ea35934.js", "static/css/collection-baa1738a.css"])), billing: S(() => V(() => import("../../../common/components/estabish/billing.vue.js"), ["static/js/billing-731cdf27.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/rules-3ea35934.js", "static/css/billing-f23013df.css"])), settle: S(() => V(() => import("../../../common/components/estabish/settle.vue.js"), ["static/js/settle-f41fd090.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/self-healing-6f411a5c.js", "static/css/settle-4b6de6c5.css"])), preSettle: S(() => V(() => import("../../../common/components/estabish/pre-settle.vue.js"), ["static/js/pre-settle-c7584dcd.js", "static/js/vendor-7ae57976.js", "static/css/vendor-e73d6e39.css", "static/js/index-50216080.js", "static/css/index-685b5588.css", "static/js/self-healing-6f411a5c.js", "static/css/pre-settle-7e157fe8.css"])) }, R = Q(() => O[D.value]), y = async (o) => {
    D.value = o, f.value && (f.value.visible = true);
  }, B = (o) => {
    o && (f.value.visible = true);
  }, N = async () => {
    W(l.value, { sustainable: ["year"] }), l.value.settlementStatus = "", await x.value.getSelfProjectList();
  };
  function z(o) {
    return Object.entries(o).every(([e, g]) => e === "year" ? true : g === null || g === "");
  }
  return h(() => l, async (o) => {
    if (z(l)) return N();
    await x.value.getSelfProjectList(), await L();
  }, { deep: true }), h(() => l.settlementStatus, async (o, e) => {
    o !== e && await x.value.getSelfProjectList();
  }), I({ getSelfEmployed: L }), (o, e) => {
    const g = ee, F = A("common-radio-button"), c = te, $ = A("common-select-v2"), H = oe, M = le;
    return r(), U(Z, null, [i("div", se, [i("div", re, [a(g, { modelValue: t(l).year, "onUpdate:modelValue": e[0] || (e[0] = (n) => t(l).year = n), clearable: "", editable: "", placeholder: "请选择年份", style: { width: "100px" }, type: "year", "value-format": "x" }, null, 8, ["modelValue"]), a(F, { modelValue: t(l).settlementStatus, "onUpdate:modelValue": e[1] || (e[1] = (n) => t(l).settlementStatus = n), options: t(G).V, class: "filter-item", showOptionAll: "", type: "enum" }, null, 8, ["modelValue", "options"])]), X((r(), U("div", ie, [i("div", ce, [a(P, { "end-val": _.value.projectSum || 0, precision: 0, name: "项目总数", "num-color": "#097237", "text-color": "#626262" }, null, 8, ["end-val"])]), i("div", ue, [a(P, { "end-val": _.value.unsettled || 0, precision: 0, name: "未结算", "num-color": "#F50A0A", "text-color": "#626262" }, null, 8, ["end-val"])]), i("div", de, [a(P, { "end-val": _.value.settled || 0, precision: 0, name: "已结算", "num-color": "#097237", "text-color": "#626262" }, null, 8, ["end-val"])])])), [[M, k.value]]), i("div", pe, [t(u)(t(v).secondUnit.self.collection) ? (r(), d(c, { key: 0, size: "default", type: "success", onClick: e[2] || (e[2] = (n) => y("collection")) }, { default: p(() => [a(b, { class: "icon", "icon-class": "contract-collection", style: { "margin-right": "4px" } }), e[8] || (e[8] = m(" 创建收款 "))]), _: 1 })) : w("", true), t(u)(t(v).secondUnit.self.billing) ? (r(), d(c, { key: 1, size: "default", type: "warning", onClick: e[3] || (e[3] = (n) => y("billing")) }, { default: p(() => [a(b, { class: "icon", "icon-class": "contract-invoice", style: { "margin-right": "4px" } }), e[9] || (e[9] = m(" 创建开票 "))]), _: 1 })) : w("", true), t(u)(t(v).secondUnit.self.settle) ? (r(), d(c, { key: 2, size: "default", type: "primary", onClick: e[4] || (e[4] = (n) => y("settle")) }, { default: p(() => [a(b, { class: "icon", "icon-class": "contract-settle", style: { "margin-right": "4px" } }), e[10] || (e[10] = m(" 项目结算 "))]), _: 1 })) : w("", true), t(u)(t(v).secondUnit.self.preSettle) ? (r(), d(c, { key: 3, size: "default", type: "info", onClick: e[5] || (e[5] = (n) => y("preSettle")) }, { default: p(() => [a(b, { class: "icon", "icon-class": "contract-settle", style: { "margin-right": "4px" } }), e[11] || (e[11] = m(" 项目预结算 "))]), _: 1 })) : w("", true)]), i("div", me, [a($, { modelValue: t(l).projectId, "onUpdate:modelValue": e[6] || (e[6] = (n) => t(l).projectId = n), "data-structure": T.value, options: C.value, clearable: "", filterable: "", placeholder: "项目", style: { width: "340px" } }, null, 8, ["modelValue", "data-structure", "options"]), a(H, { modelValue: t(l).salesLeaderId, "onUpdate:modelValue": e[7] || (e[7] = (n) => t(l).salesLeaderId = n), options: t(E), props: { value: "id", emitPath: false }, "show-all-levels": false, clearable: "", filterable: "", placeholder: "销售负责人" }, null, 8, ["modelValue", "options"]), a(c, { icon: "el-icon-refresh", size: "default", style: { "margin-left": "0" }, type: "warning", onClick: N }, { default: p(() => e[12] || (e[12] = [m("重置 ")])), _: 1, __: [12] })])]), (r(), d(Y(R.value), { ref_key: "currentComponentRef", ref: f, level: 2, onComponentMounted: B }, null, 544))], 64);
  };
} }, xe = q(ve, [["__scopeId", "data-v-44c3e99c"]]);
export {
  xe as default
};
