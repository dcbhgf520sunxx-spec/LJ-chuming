import { ref as V } from "vue";
import { watch as b } from "vue";
import { openBlock as c } from "vue";
import { createBlock as d } from "vue";
import { withCtx as _ } from "vue";
import { createVNode as m } from "vue";
import { unref as i } from "vue";
import { createCommentVNode as h } from "vue";
import { isRef as k } from "vue";
import { ElTabPane as L } from "element-plus";
import { ElTabs as q } from "element-plus";
import { x as A, u as B, o as D, kb as H } from "../../../../shared/runtime.js";
import { b as I, p as E, d as T } from "../../../../modules/product-waste-c86c76d6.js";
import M from "./collection-table.vue.js";
import N from "./invoice-table.vue.js";
import { K as P } from "../../../../modules/contract-9b18cc88.js";
import "./add/collection.vue.js";
import "../../../../modules/scrap-sell-e306ced6.js";
import "./add/invoice.vue.js";
const F = { __name: "detail", props: ["visible", "currentLine", "status"], emits: ["update:visible", "update:status", "close"], setup(r, { emit: g }) {
  const e = r, l = g, { crud: t } = A({ optShow: { add: false, delete: false }, crudApi: { get: I, add: E, edit: T }, permission: P, props: { auditStatus: void 0 }, queryOnPresenterCreated: false }), { visible: n, handleClose: x } = B({ emit: l, props: e, field: "visible", showHook: y }), o = V();
  b(() => e.status, () => {
    t.query.status = e.status, o.value = e.status;
  }, { immediate: true }), b(o, (a) => {
    l("update:status", a);
  });
  function y() {
    var a, s;
    t.query.branchCompanyId = (a = e == null ? void 0 : e.currentLine) == null ? void 0 : a.branchCompanyId, t.query.contractWasteId = (s = e == null ? void 0 : e.currentLine) == null ? void 0 : s.contractWasteId, t.toQuery();
  }
  const { maxHeight: p } = D({ mainBox: ".recycling-detail", extraBox: [".el-drawer__header", ".el-tabs__header", ".crud-opts"], wrapperBox: [".el-drawer__body"], paginate: true, navbar: false, clientHRepMainH: true }, n);
  function v(a) {
    t.loading = true, t.query.status = a.paneName, t.toQuery(), setTimeout(() => {
      t.loading = false;
    }, 600);
  }
  function w() {
    l("close");
  }
  return (a, s) => {
    const f = L, C = q;
    return c(), d(H, { modelValue: i(n), "onUpdate:modelValue": s[1] || (s[1] = (u) => k(n) ? n.value = u : null), "before-close": i(x), "custom-class": "recycling-detail", size: "100%", title: "收款开票", onClose: w }, { content: _(() => [m(C, { modelValue: o.value, "onUpdate:modelValue": s[0] || (s[0] = (u) => o.value = u), onTabClick: v }, { default: _(() => [m(f, { label: "收款列表", name: "collection" }), m(f, { label: "开票列表", name: "invoice" }), o.value === "collection" ? (c(), d(M, { key: 0, "current-line": r.currentLine, "max-height": i(p) }, null, 8, ["current-line", "max-height"])) : h("", true), o.value === "invoice" ? (c(), d(N, { key: 1, "current-line": r.currentLine, "max-height": i(p) }, null, 8, ["current-line", "max-height"])) : h("", true)]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  F as default
};
