import { ref as j } from "vue";
import { watch as I } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as p } from "vue";
import { createBlock as f } from "vue";
import { withCtx as t } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as B } from "vue";
import { toDisplayString as E } from "vue";
import { unref as o } from "vue";
import { ElTabs as T } from "element-plus";
import { ElTabPane as C } from "element-plus";
import { createElementVNode as g } from "vue";
import { createCommentVNode as S } from "vue";
import { isRef as D } from "vue";
import { ElTag as O } from "element-plus";
import { ElBadge as z } from "element-plus";
import { p as A } from "../../../../../modules/contract-ledger-2ee7c4ce.js";
import { _ as M, u as P, z as U, G as R } from "../../../../../shared/runtime.js";
import q from "./collection/index.vue.js";
import F from "./invoice/index.vue.js";
import "../../../../../modules/collection-9275714a.js";
import "../../../../../modules/contract-9b18cc88.js";
import "./collection/form.vue.js";
import "../../../../../modules/invoice-2cd386aa.js";
import "./invoice/form.vue.js";
const G = { __name: "index", props: { modelValue: { type: Boolean, require: true }, currentRow: { type: Object, default: () => {
} }, moneySum: { type: Object, default: () => {
} }, projectId: { type: [String, Number], default: void 0 }, tabName: { type: [String], default: "collection" }, permission: { type: Object, default: () => {
} } }, emits: ["success", "update:modelValue"], setup(e, { emit: k }) {
  const i = j("collection"), a = e, b = k, { visible: d, handleClose: _ } = P({ emit: b, props: a }), m = j({});
  I(() => a.tabName, (l) => {
    i.value = l;
  }, { deep: true, immediate: true }), I(() => a.projectId, (l) => {
    v();
  }, { deep: true, immediate: true });
  async function v() {
    if (a.projectId) try {
      const l = await A({ projectId: a.projectId });
      m.value = l || {};
    } catch (l) {
      console.log("获取累计金额", l);
    }
  }
  function y() {
    v(), b("success");
  }
  return (l, n) => {
    const h = O, w = z, x = N("common-drawer");
    return p(), f(x, { "append-to-body": "", modelValue: o(d), "onUpdate:modelValue": n[1] || (n[1] = (c) => D(d) ? d.value = c : null), top: "10vh", width: "600px", "before-close": o(_), title: "收款开票", "wrapper-closable": false, size: "100%" }, { titleAfter: t(() => [u(h, null, { default: t(() => [B("项目：" + E(o(U)(e.currentRow)), 1)]), _: 1 })]), content: t(() => [u(o(T), { modelValue: i.value, "onUpdate:modelValue": n[0] || (n[0] = (c) => i.value = c), class: "tab-container" }, { default: t(() => {
      var c, V;
      return [o(R)((c = e.permission.collection) == null ? void 0 : c.get) ? (p(), f(o(C), { key: 0, label: "收款列表", name: "collection" }, { label: t(() => {
        var r, s;
        return [u(w, { value: (r = e.currentRow) == null ? void 0 : r.unCheckCollectionCount, hidden: !((s = e.currentRow) != null && s.unCheckCollectionCount), class: "badge-item" }, { default: t(() => n[2] || (n[2] = [g("span", null, "收款列表", -1)])), _: 1, __: [2] }, 8, ["value", "hidden"])];
      }), default: t(() => [u(o(q), { class: "tab-content", projectId: a.projectId, visibleValue: e.modelValue, onSuccess: y, moneySum: m.value, currentRow: e.currentRow }, null, 8, ["projectId", "visibleValue", "moneySum", "currentRow"])]), _: 1 })) : S("", true), o(R)((V = e.permission.invoice) == null ? void 0 : V.get) ? (p(), f(o(C), { key: 1, label: "开票列表", name: "invoice" }, { label: t(() => {
        var r, s;
        return [u(w, { value: (r = e.currentRow) == null ? void 0 : r.unCheckInvoiceCount, hidden: !((s = e.currentRow) != null && s.unCheckInvoiceCount), class: "badge-item" }, { default: t(() => n[3] || (n[3] = [g("span", null, "开票列表", -1)])), _: 1, __: [3] }, 8, ["value", "hidden"])];
      }), default: t(() => [u(o(F), { class: "tab-content", projectId: a.projectId, visibleValue: e.modelValue, onSuccess: y, moneySum: m.value, currentRow: e.currentRow }, null, 8, ["projectId", "visibleValue", "moneySum", "currentRow"])]), _: 1 })) : S("", true)];
    }), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ee = M(G, [["__scopeId", "data-v-d2ec928d"]]);
export {
  ee as default
};
