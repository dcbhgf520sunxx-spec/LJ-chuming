import { ref as v } from "vue";
import { watch as _ } from "vue";
import { resolveComponent as I } from "vue";
import { openBlock as g } from "vue";
import { createBlock as x } from "vue";
import { withCtx as t } from "vue";
import { createVNode as n } from "vue";
import { unref as l } from "vue";
import { ElTabs as C } from "element-plus";
import { ElTabPane as w } from "element-plus";
import { createElementVNode as y } from "vue";
import { isRef as B } from "vue";
import { ElBadge as N } from "element-plus";
import { s as E } from "../../../../../modules/scrap-ledger-452ee452.js";
import { _ as h, u as k } from "../../../../../shared/runtime.js";
import W from "./collection/index.vue.js";
import D from "./invoice/index.vue.js";
import "../../../../../modules/contract-9b18cc88.js";
import "./collection/form.vue.js";
import "./invoice/form.vue.js";
const M = { __name: "index", props: { modelValue: { type: Boolean, default: false }, currentRow: { type: Object, default: () => {
} }, tabName: { type: String, default: "collection" } }, emits: ["update:modelValue"], setup(s, { emit: V }) {
  const a = s, f = V, { visible: m, handleClose: R } = k({ props: a, emit: f, showHook: S }), i = v({}), d = v("collection");
  _(() => a.tabName, (c) => {
    d.value = c;
  }, { deep: true, immediate: true }), _(() => a.currentRow.id, (c) => {
    b();
  }, { deep: true, immediate: true });
  async function S() {
  }
  async function b() {
    var c, e, u, r;
    if (!(!((c = a.currentRow) != null && c.contractWasteId) || !((e = a.currentRow) != null && e.branchCompanyId))) try {
      const o = await E({ contractWasteId: (u = a.currentRow) == null ? void 0 : u.contractWasteId, branchCompanyId: (r = a.currentRow) == null ? void 0 : r.branchCompanyId });
      i.value = o || {};
    } catch (o) {
      console.log("获取累计金额", o);
    }
  }
  function p() {
    b(), f("success");
  }
  return (c, e) => {
    const u = N, r = I("common-drawer");
    return g(), x(r, { title: "收款开票", size: "100%", modelValue: l(m), "onUpdate:modelValue": e[1] || (e[1] = (o) => B(m) ? m.value = o : null), "before-close": l(R) }, { content: t(() => [n(l(C), { modelValue: d.value, "onUpdate:modelValue": e[0] || (e[0] = (o) => d.value = o), class: "tab-container" }, { default: t(() => [n(l(w), { label: "收款列表", name: "collection" }, { label: t(() => [n(u, { class: "badge-item" }, { default: t(() => e[2] || (e[2] = [y("span", null, "收款列表", -1)])), _: 1, __: [2] })]), default: t(() => [n(l(W), { class: "tab-content", visibleValue: s.modelValue, onSuccess: p, moneySum: i.value, currentRow: s.currentRow }, null, 8, ["visibleValue", "moneySum", "currentRow"])]), _: 1 }), n(l(w), { label: "开票列表", name: "invoice" }, { label: t(() => [n(u, { class: "badge-item" }, { default: t(() => e[3] || (e[3] = [y("span", null, "开票列表", -1)])), _: 1, __: [3] })]), default: t(() => [n(l(D), { class: "tab-content", visibleValue: s.modelValue, onSuccess: p, moneySum: i.value, currentRow: s.currentRow }, null, 8, ["visibleValue", "moneySum", "currentRow"])]), _: 1 })]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, q = h(M, [["__scopeId", "data-v-c101bcef"]]);
export {
  q as default
};
