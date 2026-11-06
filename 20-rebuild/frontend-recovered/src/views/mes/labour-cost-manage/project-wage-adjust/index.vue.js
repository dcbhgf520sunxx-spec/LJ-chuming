import { ref as f } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as c } from "vue";
import { createElementBlock as y } from "vue";
import { createElementVNode as u } from "vue";
import { createVNode as e } from "vue";
import { unref as n } from "vue";
import { withCtx as t } from "vue";
import { createTextVNode as k } from "vue";
import { withDirectives as b } from "vue";
import { createBlock as x } from "vue";
import { ElTableColumn as v } from "element-plus";
import { vLoading as A } from "element-plus";
import { l as T, _ as V, x as C, o as R, ba as B, D as p } from "../../../../shared/runtime.js";
import D from "./module/header.vue.js";
import "../../../../modules/project-visa-select-e1b3658e.js";
function E(l) {
  return T({ url: "/api/mes/building/price/change/product/page", method: "get", params: l });
}
const U = { get: E };
const H = { class: "app-container" }, Y = { class: "head-container" }, q = { class: "operate-list" }, z = { __name: "index", setup(l) {
  const i = f(), { crud: s } = C({ title: "项目工价调整", crudApi: { ...U }, hasPagination: false }, i), { maxHeight: _ } = R({ paginate: false });
  function h(r) {
    return B(r, { props: ["quantity", "mete", ["amount", p.YUAN], ["amountExcludingVAT", p.YUAN], ["inputVAT", p.YUAN]], toThousandFields: ["amount", "amountExcludingVAT", "inputVAT"] });
  }
  return (r, a) => {
    const m = d("common-button"), o = v, w = d("common-table"), g = A;
    return c(), y("div", H, [u("div", Y, [e(n(D))]), u("div", q, [e(m, { size: "default", icon: "el-icon-edit", type: "primary", onClick: a[0] || (a[0] = (N) => r.addRow()) }, { default: t(() => a[2] || (a[2] = [k("修改")])), _: 1, __: [2] }), e(m, { size: "default", type: "success", onClick: a[1] || (a[1] = (N) => r.addRow()) }, { default: t(() => a[3] || (a[3] = [k("提交审核")])), _: 1, __: [3] })]), b((c(), x(w, { ref_key: "tableRef", ref: i, data: n(s).data, "empty-text": n(s).emptyText, "max-height": n(_), "show-summary": "", "summary-method": h }, { default: t(() => [e(o, { label: "序号", type: "index", align: "center", width: "60", fixed: "left" }), e(o, { label: "构件类型", prop: "workshopName", key: "workshopName", align: "center" }), e(o, { label: "零件工序", prop: "workshopName", key: "workshopName", align: "center", width: "120px" }, { default: t(() => [e(o, { label: "翼腹板", prop: "workshopName", key: "workshopName", align: "center" }), e(o, { label: "零件板", prop: "workshopName", key: "workshopName", align: "center" })]), _: 1 }), e(o, { label: "部件工序", prop: "workshopName", key: "workshopName", align: "center", width: "120px" }, { default: t(() => [e(o, { label: "组立", prop: "workshopName", key: "workshopName", align: "center" }), e(o, { label: "埋弧", prop: "workshopName", key: "workshopName", align: "center" })]), _: 1 }), e(o, { label: "构件工序", prop: "workshopName", key: "workshopName", align: "center", width: "120px" }, { default: t(() => [e(o, { label: "装配", prop: "workshopName", key: "workshopName", align: "center" }), e(o, { label: "焊接", prop: "workshopName", key: "workshopName", align: "center" }), e(o, { label: "涂装", prop: "workshopName", key: "workshopName", align: "center" })]), _: 1 }), e(o, { label: "合计", prop: "workshopName", key: "workshopName", align: "center" })]), _: 1 }, 8, ["data", "empty-text", "max-height"])), [[g, n(s).loading]])]);
  };
} }, F = V(z, [["__scopeId", "data-v-a0ee5106"]]);
export {
  F as default
};
