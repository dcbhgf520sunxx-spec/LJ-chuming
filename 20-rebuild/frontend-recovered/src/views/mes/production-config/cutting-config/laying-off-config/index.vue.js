import { ref as _ } from "vue";
import { inject as O } from "vue";
import { resolveComponent as c } from "vue";
import { resolveDirective as R } from "vue";
import { openBlock as t } from "vue";
import { createBlock as o } from "vue";
import { withCtx as n } from "vue";
import { createElementVNode as f } from "vue";
import { toDisplayString as h } from "vue";
import { unref as e } from "vue";
import { withDirectives as g } from "vue";
import { createTextVNode as B } from "vue";
import { createVNode as i } from "vue";
import { createCommentVNode as m } from "vue";
import { ElTableColumn as P } from "element-plus";
import { ElCard as G } from "element-plus";
import { vLoading as L } from "element-plus";
import { aA as j, x as F, oO as d, aB as b, G as H, an as I } from "../../../../../shared/runtime.js";
import { c as M } from "../../../../../modules/unloading-config-b9decdaa.js";
import U from "./module/form.vue.js";
import $ from "./module/header.vue.js";
const q = { style: { "line-height": "28px" } }, Y = { __name: "index", emits: ["click-laying-off"], setup(z, { emit: y }) {
  const C = { batchAdd: false, add: false, edit: false, del: false, download: false }, u = _(), x = y, k = _([...j]), { crud: l, columns: w } = F({ title: "下料配置", hasPagination: true, formStore: true, formStoreKey: "MES_CUTTING_CONFIG", sort: [], permission: { ...d }, optShow: { ...C }, crudApi: { ...M }, dataPath: "" }, u), T = O("maxHeight");
  function v(s) {
    s && x("click-laying-off", s);
  }
  return (s, p) => {
    const S = c("common-button"), r = P, D = c("table-cell-tag"), N = c("common-table"), V = G, A = R("permission"), E = L;
    return t(), o(V, { class: "line-box box-card" }, { header: n(() => [f("span", q, h(e(l).title) + "列表", 1), g((t(), o(S, { style: { float: "right", padding: "6px 10px" }, size: "default", type: "primary", icon: "el-icon-plus", disabled: true, onClick: e(l).toAdd }, { default: n(() => p[0] || (p[0] = [B(" 新增 ")])), _: 1, __: [0] }, 8, ["onClick"])), [[A, e(d).add]])]), default: n(() => [i($), g((t(), o(N, { ref_key: "tableRef", ref: u, data: e(l).data, "highlight-current-row": "", "data-format": k.value, "show-empty-symbol": false, "max-height": e(T), style: { width: "100%" }, "row-key": "id", onCurrentChange: v }, { default: n(() => [i(r, { label: "序号", type: "index", align: "center", width: "60" }), e(w).visible("name") ? (t(), o(r, { "header-align": "center", align: "left", key: "name", prop: "name", label: "下料方式" }, { default: n(({ row: a }) => [a.materialType ? (t(), o(D, { key: 0, name: e(b).V[a.materialType].SL, color: e(b).V[a.materialType].COLOR, offset: 15 }, null, 8, ["name", "color"])) : m("", true), f("span", null, h(a.name), 1)]), _: 1 })) : m("", true), e(H)(e(d).del) ? (t(), o(r, { key: 1, label: "操作", width: "130px", align: "center" }, { default: n(({ row: a }) => [i(e(I), { disabledEdit: true, disabledDel: true, "show-edit": true, "show-del": true, data: a }, null, 8, ["data"])]), _: 1 })) : m("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[E, e(l).loading]]), i(U)]), _: 1 });
  };
} };
export {
  Y as default
};
