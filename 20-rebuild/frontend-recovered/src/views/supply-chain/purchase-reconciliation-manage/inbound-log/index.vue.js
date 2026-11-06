import { ref as r } from "vue";
import { computed as E } from "vue";
import { provide as P } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as U } from "vue";
import { createVNode as c } from "vue";
import { unref as e } from "vue";
import { withDirectives as B } from "vue";
import { createBlock as a } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as i } from "vue";
import { createElementVNode as I } from "vue";
import { toDisplayString as y } from "vue";
import { nextTick as M } from "vue";
import { ElTableColumn as H } from "element-plus";
import { vLoading as O } from "element-plus";
import { c as S } from "../../../../modules/payment-ledger-cb1d373c.js";
import { _ as $, t as L, x as j, vZ as d, o as q, bv as z, am as F, G as g, P as G } from "../../../../shared/runtime.js";
import K from "./module/header.vue.js";
import Y from "../payment-ledger/module/inbound-record.vue.js";
const Z = { class: "app-container" }, J = { __name: "index", setup(Q) {
  const { decimalPrecision: x } = L(), k = { add: false, edit: false, del: false, download: false }, b = r(), C = r(), N = E(() => [["createTime", "parse-time"], ["amount", ["to-thousand", x.value.supplyChain]], ["inboundAmount", ["to-thousand-ck", "YUAN"]], ["inboundRate", ["to-fixed", 2]]]), { crud: _, columns: n, CRUD: R } = j({ title: "入库记录", sort: [], permission: { ...d }, crudApi: { ...S }, invisibleColumns: [], optShow: { ...k } }, b), { maxHeight: T } = q({ paginate: true }), h = r({}), v = r(void 0), u = r(false);
  P("orderId", v), R.HOOK.handleRefresh = (m, { data: s }) => {
    s.content.forEach((t) => {
      const p = z.getBits(F.ENUM, t.basicClass, "L");
      t.typeText = p.join(" | ");
    });
  };
  function A(m, s) {
    h.value = m.sourceRow, v.value = m.id, M(() => {
      u.value = true;
    });
  }
  return (m, s) => {
    const t = H, p = w("common-button"), V = w("common-table"), D = O;
    return o(), U("div", Z, [c(e(K), { ref_key: "headerRef", ref: C }, null, 512), B((o(), a(V, { ref_key: "tableRef", ref: b, data: e(_).data, "data-format": N.value, "max-height": e(T), style: { width: "100%" } }, { default: f(() => [c(t, { align: "center", label: "序号", type: "index", width: "60" }), e(n).visible("createTime") ? (o(), a(t, { key: "createTime", align: "center", label: "日期", prop: "createTime", "show-overflow-tooltip": "", width: "130" })) : i("", true), e(n).visible("serialNumber") ? (o(), a(t, { key: "serialNumber", "show-overflow-tooltip": true, align: "center", label: "采购合同编号", "min-width": "120", prop: "serialNumber" })) : i("", true), e(n).visible("supplierName") ? (o(), a(t, { key: "supplierName", label: "供应商", "min-width": "140", prop: "supplierName", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("typeText") ? (o(), a(t, { key: "typeText", label: "物料种类", "min-width": "140", prop: "typeText", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("mete") ? (o(), a(t, { key: "mete", align: "center", label: "合同量", "min-width": "110", prop: "mete", "show-overflow-tooltip": "" }, { default: f(({ row: l }) => [I("span", null, y(l.mete) + y(l.meteUnit), 1)]), _: 1 })) : i("", true), e(n).visible("amount") ? (o(), a(t, { key: "amount", align: "right", label: "合同额", "min-width": "110", prop: "amount", "show-overflow-tooltip": "" })) : i("", true), e(n).visible("inboundAmount") ? (o(), a(t, { key: "inboundAmount", align: "right", label: "入库额", "min-width": "110", prop: "inboundAmount", "show-overflow-tooltip": "" })) : i("", true), e(g)(e(d).detail) ? (o(), a(t, { key: 7, align: "center", label: "操作", width: "80px" }, { default: f(({ row: l }) => [e(g)(e(d).detail) ? (o(), a(p, { key: 0, icon: "el-icon-view", size: "default", type: "primary", onClick: (W) => A(l) }, null, 8, ["onClick"])) : i("", true)]), _: 1 })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[D, e(_).loading]]), c(e(G)), c(e(Y), { modelValue: u.value, "onUpdate:modelValue": s[0] || (s[0] = (l) => u.value = l), "detail-info": h.value, permission: e(d) }, null, 8, ["modelValue", "detail-info", "permission"])]);
  };
} }, ie = $(J, [["__scopeId", "data-v-27bcb870"]]);
export {
  ie as default
};
