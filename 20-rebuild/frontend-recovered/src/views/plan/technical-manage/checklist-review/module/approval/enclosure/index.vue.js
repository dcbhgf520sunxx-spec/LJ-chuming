import { ref as m } from "vue";
import { inject as g } from "vue";
import { watch as b } from "vue";
import { resolveComponent as _ } from "vue";
import { openBlock as p } from "vue";
import { createElementBlock as h } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as y } from "vue";
import { unref as o } from "vue";
import { createBlock as f } from "vue";
import { withCtx as x } from "vue";
import { ElTableColumn as w } from "element-plus";
import { vLoading as v } from "element-plus";
import { l, o as k, x as A, P as B } from "../../../../../../../shared/runtime.js";
import R from "./module/header.vue.js";
function q(r) {
  return l({ url: "/api/plan/inventory/record/inventory/list", method: "get", params: r });
}
function C(r) {
  return l({ url: "/api/plan/enclosure/inventory/detail", method: "get", params: r });
}
function I(r) {
  return l({ url: "/api/plan/enclosure/inventory/check", method: "put", data: r });
}
function M(r) {
  return l({ url: "/api/plan/inventory/record/enclosure/export", method: "get", responseType: "blob", params: r });
}
const N = { get: q }, H = { __name: "index", setup(r) {
  const i = m(), c = g("currentRow"), { maxHeight: s } = k({ mainBox: ".approval-drawer", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", minHeight: 300, navbar: false, clientHRepMain: true, paginate: true }, i), { crud: a } = A({ title: "围护清单明细", crudApi: { get: C }, queryOnPresenterCreated: false, requiredQuery: ["inventoryId"] }, i);
  return b(() => c.value, (n) => {
    n != null && n.id && (a.query.inventoryId = n.id, a.toQuery());
  }, { deep: true, immediate: true }), (n, D) => {
    const t = w, d = _("common-table"), u = v;
    return p(), h("div", null, [e(R), y((p(), f(d, { ref_key: "tableRef", ref: i, data: o(a).data, "empty-text": o(a).emptyText, "max-height": o(s), style: { "margin-bottom": "10px" } }, { default: x(() => [e(t, { align: "center", label: "序号", type: "index", width: "60" }), e(t, { align: "center", label: "类型", prop: "dictionaryName", width: "120" }), e(t, { align: "center", label: "编号", prop: "serialNumber", width: "120" }), e(t, { align: "center", label: "规格", prop: "plate" }), e(t, { align: "center", label: "展开宽度（mm）", prop: "unfoldedWidth" }), e(t, { align: "center", label: "有效宽度（mm）", prop: "width" }), e(t, { align: "center", label: "厚度（mm）", prop: "thickness" }), e(t, { align: "center", label: "单长（mm）", prop: "length" }), e(t, { align: "center", label: "计量单位", prop: "unit" }), e(t, { align: "center", label: "数量", prop: "quantity" }), e(t, { align: "center", label: "核算量（米）", prop: "accountingVolume" }), e(t, { align: "center", label: "重量（kg）", prop: "weight" }), e(t, { align: "center", label: "总重量（kg）", prop: "totalWeight" }), e(t, { align: "center", label: "备注", prop: "remark", width: "160" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[u, o(a).loading]]), e(B)]);
  };
} }, O = Object.freeze(Object.defineProperty({ __proto__: null, default: H }, Symbol.toStringTag, { value: "Module" }));
export {
  H as _,
  N as c,
  M as g,
  O as i,
  I as p
};
