import { ref as _ } from "vue";
import { computed as k } from "vue";
import { resolveComponent as N } from "vue";
import { openBlock as a } from "vue";
import { createElementBlock as C } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { withDirectives as D } from "vue";
import { createBlock as o } from "vue";
import { withCtx as f } from "vue";
import { createCommentVNode as r } from "vue";
import { ElTableColumn as R } from "element-plus";
import { vLoading as P } from "element-plus";
import { c as j, m as I } from "./module/header.vue.js";
import { _ as H, t as O, x as B, wI as n, o as E, G as A, an as F, P as L } from "../../../shared/runtime.js";
import M from "./module/form.vue.js";
import S from "./module/detail.vue.js";
import "../../../modules/index-5b9e6004.js";
import "../../../modules/vue3-count-to.esm-8987f38d.js";
import "../../../modules/UploadBtn-b4cfb47a.js";
const U = { class: "app-container" }, V = { __name: "index", setup(q) {
  const { decimalPrecision: h } = O(), b = { add: true, edit: false, del: false, download: false }, p = _(), w = _(), g = k(() => [["signDate", ["parse-time", "{y}-{m}-{d}"]], ["project", "parse-project"], ["amount", ["to-thousand", h.value.supplyChain]]]), { crud: u, columns: s, CRUD: v } = B({ title: "分包订单", sort: [], permission: { ...n }, crudApi: j, invisibleColumns: [], optShow: { ...b } }, p), { maxHeight: y } = E({ paginate: true });
  return v.HOOK.handleRefresh = (x, { data: d }) => {
    d.content.forEach((t) => {
      var m;
      const c = [];
      return t.monomerList.map((l) => {
        c.push(l.id);
      }), t.monomerIds = c, t.attachmentIds = ((m = t.attachments) == null ? void 0 : m.map((l) => l.id)) || [], t;
    });
  }, (x, d) => {
    const t = R, c = N("common-table"), m = P;
    return a(), C("div", U, [i(e(I), { ref_key: "headerRef", ref: w }, null, 512), D((a(), o(c, { ref_key: "tableRef", ref: p, "data-format": g.value, data: e(u).data, style: { width: "100%" }, "max-height": e(y) }, { default: f(() => [i(t, { label: "序号", type: "index", align: "center", width: "60" }), e(s).visible("signDate") ? (a(), o(t, { key: "signDate", prop: "signDate", "show-overflow-tooltip": true, label: "签订日期", align: "center" })) : r("", true), e(s).visible("serialNumber") ? (a(), o(t, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "订单号", align: "center" })) : r("", true), e(s).visible("project") ? (a(), o(t, { key: "project", prop: "project", "show-overflow-tooltip": true, label: "项目", align: "center", "min-width": "180" })) : r("", true), e(s).visible("supplierName") ? (a(), o(t, { key: "supplierName", prop: "supplierName", "show-overflow-tooltip": true, label: "分包单位", align: "center" })) : r("", true), e(s).visible("subcontractClassName") ? (a(), o(t, { key: "subcontractClassName", prop: "subcontractClassName", "show-overflow-tooltip": true, label: "分包类别", align: "center" })) : r("", true), e(s).visible("amount") ? (a(), o(t, { key: "amount", prop: "amount", "show-overflow-tooltip": true, label: "合同额", align: "center" })) : r("", true), e(s).visible("userName") ? (a(), o(t, { key: "userName", prop: "userName", "show-overflow-tooltip": true, label: "创建人", align: "center" })) : r("", true), e(A)([...e(n).detail, ...e(n).del, ...e(n).edit]) ? (a(), o(t, { key: 7, label: "操作", width: "180px", align: "center" }, { default: f(({ row: l }) => [i(F, { data: l, permission: e(n), "show-detail": "" }, null, 8, ["data", "permission"])]), _: 1 })) : r("", true)]), _: 1 }, 8, ["data-format", "data", "max-height"])), [[m, e(u).loading]]), i(e(L)), i(e(M)), i(e(S))]);
  };
} }, Y = H(V, [["__scopeId", "data-v-aeb1e150"]]);
export {
  Y as default
};
