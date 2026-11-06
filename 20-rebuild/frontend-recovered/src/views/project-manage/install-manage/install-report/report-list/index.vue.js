import { ref as m } from "vue";
import { resolveComponent as v } from "vue";
import { openBlock as r } from "vue";
import { createElementBlock as n } from "vue";
import { unref as o } from "vue";
import { createVNode as e } from "vue";
import { withDirectives as x } from "vue";
import { createBlock as k } from "vue";
import { withCtx as d } from "vue";
import { createTextVNode as T } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElTag as I } from "element-plus";
import { vLoading as N } from "element-plus";
import { c as P } from "../../../../../modules/install-report-list-d430e189.js";
import { _ as A, m as L, mw as R, x as U, o as C, bN as u, P as E } from "../../../../../shared/runtime.js";
import { n as H } from "../../../../../modules/project-19a12d6b.js";
import q from "./module/header.vue.js";
import "../../../../../modules/report-list-f9da4d70.js";
import "../../../components/Panel/index.vue.js";
import "../../../../../modules/vue3-count-to.esm-8987f38d.js";
const B = { class: "app-container" }, M = { key: 0 }, O = { key: 1 }, S = { __name: "index", setup(V) {
  const { globalProjectId: s, globalProject: l } = L(["globalProjectId", "globalProject"]), f = { add: false, edit: false, del: false, download: false }, i = m(), _ = m([["areaType", ["parse-enum", R]]]), { crud: a, CRUD: g } = U({ title: "安装报表", sort: ["id.desc"], permission: { ...H }, requiredQuery: ["projectId", "productType"], optShow: { ...f }, crudApi: { ...P }, hasPagination: true }, i), { maxHeight: y } = C({ wrapperBox: ".install-report-list", paginate: true, extraHeight: 40 });
  return g.HOOK.beforeRefresh = () => (a.query.projectId = l.value.businessType === u.INSTALLATION.V ? s.value : void 0, !!a.query.projectId), (D, p) => {
    var c;
    const t = j, b = v("common-table"), w = I, h = N;
    return r(), n("div", B, [((c = o(l)) == null ? void 0 : c.businessType) === o(u).INSTALLATION.V ? (r(), n("div", M, [e(o(q), { projectId: o(s), globalProject: o(l) }, null, 8, ["projectId", "globalProject"]), x((r(), k(b, { ref_key: "tableRef", ref: i, data: o(a).data, "empty-text": o(a).emptyText, "max-height": o(y), stripe: false, "data-format": _.value, "row-key": "id", style: { width: "100%" } }, { default: d(() => [e(t, { type: "index", prop: "index", label: "序号", align: "center", width: "60" }), e(t, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "measureUnit", prop: "measureUnit", label: "计量单位", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "actualQuantity", prop: "actualQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "accountingUnit", prop: "accountingUnit", label: "核算单位", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "actualMete", prop: "actualMete", label: "安装量", align: "center", "show-overflow-tooltip": "" }), e(t, { key: "supplierName", prop: "supplierName", label: "劳务单位", align: "center", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "empty-text", "max-height", "data-format"])), [[h, o(a).loading]]), e(o(E))])) : (r(), n("div", O, [e(w, { type: "danger", size: "large", style: { "margin-bottom": "10px" } }, { default: d(() => p[0] || (p[0] = [T(" * 您好，请先选择业务类型为项目承包的项目，当前页面需要选择业务类型为项目承包方可查看 ")])), _: 1, __: [0] })]))]);
  };
} }, Y = A(S, [["__scopeId", "data-v-f222f234"]]);
export {
  Y as default
};
