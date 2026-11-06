import { ref as u } from "vue";
import { computed as b } from "vue";
import { resolveComponent as z } from "vue";
import { openBlock as o } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { withDirectives as O } from "vue";
import { createBlock as l } from "vue";
import { withCtx as m } from "vue";
import { createElementVNode as T } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as x } from "vue";
import { createCommentVNode as i } from "vue";
import { ElTableColumn as P } from "element-plus";
import { vLoading as V } from "element-plus";
import { l as $, _ as B, yb as y, yg as S, x as A, yh as F, o as I, pB as L, cO as U, jl as q, aR as M, k4 as H, sL as K, yi as J, sM as W, sN as Y, ux as G, P as Q } from "../../../../../shared/runtime.js";
import X from "./module/header.vue.js";
function Z(w) {
  return $({ module: "wms", url: "freeze/raw-material/unfreeze", method: "get", params: w });
}
const ee = { get: Z };
const ae = { class: "app-container" }, te = { key: 0 }, se = { __name: "index", setup(w) {
  const k = { add: false, edit: false, del: false, download: false }, h = u(), N = u(), d = u([]), g = u([["remark", "empty-text"], ["createTime", "parse-time"], ["project", ["parse-project", { onlyShortName: true }]], ["projectFullName", "parse-project", { source: "project" }], ["freezeTypeName", ["parse-enum", y], ["suffix", "冻结"], { source: "freezeType" }], ...S]), { CRUD: C, crud: n, columns: s } = A({ title: "解冻记录", sort: ["id.desc"], invisibleColumns: ["receiptType", "project"], requiredQuery: [], permission: { ...F }, optShow: { ...k }, crudApi: { ...ee } }, h), { maxHeight: R } = I({ paginate: true }), f = b(() => n.query.basicClass), j = b(() => n.query.projectWarehouseType === L.PROJECT.V);
  return C.HOOK.handleRefresh = async (E, { data: c }) => {
    let a = [];
    c.content.forEach((p) => a.push(p.material)), await U(a), a = await q(a, { toSmallest: false, toNum: false }), c.content.forEach((p, _) => {
      p.material = a[_];
    });
  }, (E, c) => {
    const a = P, p = z("common-table"), _ = V;
    return o(), v("div", ae, [r(e(X), { ref_key: "headerRef", ref: N }, null, 512), O((o(), l(p, { key: `material_freeze_${e(n).query.basicClass}`, ref_key: "tableRef", ref: h, data: e(n).data, "data-format": g.value, "default-expand-all": false, "expand-row-keys": d.value, "max-height": e(R), "row-key": "id" }, { default: m(() => [r(M, { "expand-row-keys": d.value, "onUpdate:expandRowKeys": c[0] || (c[0] = (t) => d.value = t), data: e(n).data, "row-key": "id" }, { default: m(({ row: t }) => [t.material ? (o(), l(H, { key: 0, "basic-class": t.material.basicClass, row: t.material }, { default: m(() => [T("p", null, [c[1] || (c[1] = D(" 备注：")), T("span", null, x(t.remark), 1)])]), _: 2 }, 1032, ["basic-class", "row"])) : i("", true)]), _: 1 }, 8, ["expand-row-keys", "data"]), r(K, { "basic-class": f.value, columns: e(s), "spec-merge": "" }, null, 8, ["basic-class", "columns"]), r(J, { "basic-class": f.value, columns: e(s), "label-prefix": "解冻", "outbound-type-mode": "" }, null, 8, ["basic-class", "columns"]), r(W, { "basic-class": f.value, columns: e(s), "show-batch-no": false }, null, 8, ["basic-class", "columns"]), r(Y, { columns: e(s), "show-area": j.value, "show-monomer": false, "show-project": false }, null, 8, ["columns", "show-area"]), e(s).visible("freezeTypeName") ? (o(), l(a, { key: "freezeTypeName", "show-overflow-tooltip": true, align: "center", label: "类型", prop: "freezeTypeName", width: "100" })) : i("", true), e(s).visible("receiptType") ? (o(), l(a, { key: "receiptType", "show-overflow-tooltip": true, align: "center", label: "对应单据", prop: "receiptType", width: "120" }, { default: m(({ row: t }) => [e(y).V[t.freezeType] ? (o(), v("span", te, x(e(y).V[t.freezeType].DOC), 1)) : i("", true)]), _: 1 })) : i("", true), e(s).visible("receipt") ? (o(), l(a, { key: "receipt", "show-overflow-tooltip": true, align: "center", label: "单据编号", "min-width": "120", prop: "receipt" }, { default: m(({ row: t }) => [r(e(G), { receipt: t.receipt, "receipt-types": ["PREPARATION", "OUTBOUND_APPLY", "TRANSFER", "REJECTED", "MOVING_INVENTORY"] }, null, 8, ["receipt"])]), _: 1 })) : i("", true), e(s).visible("project") ? (o(), l(a, { key: "project", label: "单据项目", "min-width": "150", prop: "project", "show-overflow-tooltip": "" })) : i("", true), e(s).visible("applicantName") ? (o(), l(a, { key: "applicantName", "show-overflow-tooltip": true, align: "center", label: "解冻人", prop: "applicantName", width: "90" })) : i("", true), e(s).visible("createTime") ? (o(), l(a, { key: "createTime", "show-overflow-tooltip": true, align: "center", label: "解冻时间", prop: "createTime", width: "140" })) : i("", true)]), _: 1 }, 8, ["data", "data-format", "expand-row-keys", "max-height"])), [[_, e(n).loading]]), r(e(Q))]);
  };
} }, ie = B(se, [["__scopeId", "data-v-c08274ee"]]);
export {
  ie as default
};
