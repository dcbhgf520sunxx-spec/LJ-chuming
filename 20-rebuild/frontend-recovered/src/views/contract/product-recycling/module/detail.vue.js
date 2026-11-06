import { ref as V } from "vue";
import { watch as b } from "vue";
import { openBlock as m } from "vue";
import { createBlock as c } from "vue";
import { withCtx as _ } from "vue";
import { createVNode as d } from "vue";
import { unref as l } from "vue";
import { createCommentVNode as y } from "vue";
import { isRef as k } from "vue";
import { ElTabPane as q } from "element-plus";
import { ElTabs as A } from "element-plus";
import { x as B, u as D, o as H, kb as U } from "../../../../shared/runtime.js";
import { b as E, p as R, d as T } from "../../../../modules/product-recycling-d772694e.js";
import I from "./payment-table.vue.js";
import M from "./invoice-table.vue.js";
import { J as N } from "../../../../modules/contract-9b18cc88.js";
import "./add/payment.vue.js";
import "../../../../modules/UploadBtn-b4cfb47a.js";
import "./add/invoice.vue.js";
const G = { __name: "detail", props: ["visible", "currentLine", "status"], emits: ["update:visible", "update:status", "close"], setup(n, { emit: h }) {
  const s = n, r = h, { crud: t } = B({ optShow: { add: false, delete: false }, crudApi: { get: E, add: R, edit: T }, permission: N, props: { auditStatus: void 0 }, queryOnPresenterCreated: false }), { visible: o, handleClose: g } = D({ emit: r, props: s, field: "visible", showHook: x }), a = V();
  b(() => s.status, () => {
    t.query.status = s.status, a.value = s.status;
  }, { immediate: true }), b(a, (e) => {
    r("update:status", e);
  });
  function x() {
    const { currentLine: e } = s;
    t.query.branchCompanyId = e == null ? void 0 : e.branchCompanyId, t.query.customerUnit = e == null ? void 0 : e.customerUnit, t.toQuery();
  }
  const { maxHeight: p } = H({ mainBox: ".recycling-detail", extraBox: [".el-drawer__header", ".el-tabs__header", ".crud-opts"], wrapperBox: [".el-drawer__body"], paginate: true, navbar: false, clientHRepMainH: true }, o);
  function v(e) {
    t.loading = true, t.query.status = e.paneName, t.toQuery(), setTimeout(() => {
      t.loading = false;
    }, 400);
  }
  function w() {
    r("close");
  }
  return (e, i) => {
    const f = q, C = A;
    return m(), c(U, { modelValue: l(o), "onUpdate:modelValue": i[1] || (i[1] = (u) => k(o) ? o.value = u : null), "before-close": l(g), "custom-class": "recycling-detail", size: "100%", title: "付款收票", onClose: w }, { content: _(() => [d(C, { modelValue: a.value, "onUpdate:modelValue": i[0] || (i[0] = (u) => a.value = u), onTabClick: v }, { default: _(() => [d(f, { label: "付款列表", name: "payment" }), d(f, { label: "收票列表", name: "invoice" }), a.value === "payment" ? (m(), c(I, { key: 0, "current-line": n.currentLine, "max-height": l(p) }, null, 8, ["current-line", "max-height"])) : y("", true), a.value === "invoice" ? (m(), c(M, { key: 1, "current-line": n.currentLine, "max-height": l(p) }, null, 8, ["current-line", "max-height"])) : y("", true)]), _: 1 }, 8, ["modelValue"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  G as default
};
